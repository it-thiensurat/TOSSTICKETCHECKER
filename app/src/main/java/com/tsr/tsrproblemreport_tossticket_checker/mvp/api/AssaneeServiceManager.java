package com.tsr.tsrproblemreport_tossticket_checker.mvp.api;


import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.Model.Customer;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.Model.manager.Manager;

import static com.tsr.tsrproblemreport_tossticket_checker.mvp.api.AssaneeURL.BASE_URL;

public class AssaneeServiceManager{

    private static AssaneeServiceManager instance;
    private static AssaneeApiService api;


    public interface AssaneeManagerCallback<T>{
        void onSuccess(T result);

        void onFailure(Throwable t);
    }

    public static AssaneeServiceManager getInstance(){
        if( instance == null ){
            instance = new AssaneeServiceManager();
        }
        return instance;
    }

    private AssaneeServiceManager(){
    }

    public static void setApi( AssaneeApiService mockApi ){
        api = mockApi;
    }

    public Call<Customer> requestLogin(String username){
        return AssaneeService.newInstance( BASE_URL )
                .getApi( api )
                .getLogin( username);

    }
    public void Login(String username, final AssaneeManagerCallback<Customer> callback){
        requestLogin(username).enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {
                Log.e("username",response+"");
                if( callback != null ){
                    callback.onSuccess( response.body() );
                }
            }

            @Override
            public void onFailure(Call<Customer> call, Throwable t) {
                Log.e("onFailure",t.getMessage());
            }
        });
    }




    public void Login2(String username, final AssaneeManagerCallback<Manager> callback){
        requestLogin(username).enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {

            }

            @Override
            public void onFailure(Call<Customer> call, Throwable t) {

            }
        });

    }

/*
    public void requestBeer( int page, final NongBeerManagerCallback<BeerProductResultGroup> callback ){
        requestBeerCall( page ).enqueue( new Callback<BeerProductResultGroup>(){
            @Override
            public void onResponse( Call<BeerProductResultGroup> call, Response<BeerProductResultGroup> response ){
                if( callback != null ){
                    if( beerChecker( response ) ){
                        callback.onSuccess( response.body() );
                    }else{
                        callback.onFailure( new Throwable( "Response invalid." ) );
                    }
                }
            }

            @Override
            public void onFailure( Call<BeerProductResultGroup> call, Throwable t ){
                if( !call.isCanceled() ){
                    if( callback != null ){
                        callback.onFailure( t );
                    }
                }
            }
        } );
    }


    */


/*
    public void addNewOrder( double latitude,
                             double longitude,
                             List<BeerProductItem> items,
                             final NongBeerManagerCallback<AddNewOrderResult> callback ){
        List<AddNewOrderBody.BeersBody> beers = new ArrayList<>();
        for( BeerProductItem item : items ){
            beers.add( new AddNewOrderBody.BeersBody()
                    .setId( item.getId() )
                    .setAmount( item.getAmount() ) );
        }

        AddNewOrderBody body = new AddNewOrderBody()
                .setLocation( latitude, longitude )
                .setBeers( beers );

        callAddNewOrder = requestAddNewOrder( body );
        callAddNewOrder.enqueue( new Callback<AddNewOrderResult>(){
            @Override
            public void onResponse( Call<AddNewOrderResult> call, Response<AddNewOrderResult> response ){
                if( callback != null ){
                    if( addNewOrderResultChecker( response ) ){
                        callback.onSuccess( response.body() );
                    }else{
                        callback.onFailure( new Throwable( "response invalid." ) );
                    }
                }
                callAddNewOrder = null;
            }

            @Override
            public void onFailure( Call<AddNewOrderResult> call, Throwable t ){
                if( callback != null ){
                    callback.onFailure( t );
                }
                callAddNewOrder = null;
            }
        } );
    }


    public Call<AddNewOrderResult> requestAddNewOrder( AddNewOrderBody body ){
        return NongBeerService.newInstance( BASE_URL )
                .getApi( api )
                .addNewOrder( body );
    }

    private boolean addNewOrderResultChecker( Response<AddNewOrderResult> response ){
        if( response.isSuccessful() ){
            AddNewOrderResult result = response.body();
            return SUCCESS.equals( result.getStatus() );
        }
        return false;
    }


    public void cancelAddNewOrder(){
        if( callAddNewOrder != null ){
            callAddNewOrder.cancel();
        }
    }


    public Call<BeerProductResultGroup> requestBeerCall( int page ){
        return NongBeerService.newInstance( BASE_URL )
                .getApi( api )
                .getBeer( page );
    }

    public void requestHistory( int page, final NongBeerManagerCallback<HistoryResultGroup> callback ){
        requestHistoryCall( page ).enqueue( new Callback<HistoryResultGroup>(){
            @Override
            public void onResponse( Call<HistoryResultGroup> call, Response<HistoryResultGroup> response ){
                if( callback != null ){
                    if( historyChecker( response ) ){
                        callback.onSuccess( response.body() );
                    }else{
                        callback.onFailure( new Throwable("Response invalid.") );
                    }
                }
            }

            @Override
            public void onFailure( Call<HistoryResultGroup> call, Throwable t ){
                if( callback != null ){
                    callback.onFailure( t );
                }
            }
        } );
    }

    public Call<HistoryResultGroup> requestHistoryCall( int page ){
        return NongBeerService.newInstance( BASE_URL )
                .getApi( api )
                .getHistory( page );
    }

    private boolean historyChecker( Response<HistoryResultGroup> response ){
        if( response.isSuccessful() ){
            HistoryResultGroup result = response.body();
            return SUCCESS.equals( result.getStatus() ) && result.getOrders() != null;
        }
        return false;
    }

    private boolean beerChecker( Response<BeerProductResultGroup> response ){
        if( response.isSuccessful() ){
            BeerProductResultGroup result = response.body();
            return SUCCESS.equals( result.getStatus() ) && result.getBeers() != null;
        }
        return false;
    }
*/

}
