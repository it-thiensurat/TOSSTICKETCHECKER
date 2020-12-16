package com.tsr.tsrproblemreport_tossticket_checker.mvp.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.hwangjr.rxbus.RxBus;

import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.Model.ConvertCustomerRes;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.Model.Customer;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.Model.CustomerRes;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.api.AssaneeServiceManager;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.base.BaseMvpPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainFragmentPresenter extends BaseMvpPresenter<MainFragmentInterface.view> implements MainFragmentInterface.presenter{

    private AssaneeServiceManager serviceManager;
    private static Customer customerGroup;
    private static List<CustomerRes> customerRes = new ArrayList<CustomerRes>();

    public MainFragmentPresenter(){
        serviceManager = AssaneeServiceManager.getInstance();
    }

    public void setManager( AssaneeServiceManager manager ){
        serviceManager = manager;
    }

    @Override
    public void onViewCreate(){
        RxBus.get().register( this );
    }

    @Override
    public void onViewDestroy(){
        RxBus.get().unregister( this );
    }




    private static Context context;
    public static MainFragmentInterface.presenter create(FragmentActivity fragmentManager){
    //public static MainFragmentInterface_manager.presenter create(){
       // context = fragmentManager;
        return new MainFragmentPresenter();
    }

    @Override
    public void login(String username) {
        getView().onload();
        serviceManager.Login(username, new AssaneeServiceManager.AssaneeManagerCallback<Customer>() {
            @Override
            public void onSuccess(Customer result) {
                Log.e("onSuccess",result.getData().size()+"");
                Customer customer = ConvertCustomerRes.createFromResult(result);
                customerGroup = customer;
                customerRes = ConvertCustomerRes.createListDataItemsFromResult(result.getData());
                getView().ondimiss();
                getView().setCustomerToAdapter(customerRes);
            }

            @Override
            public void onFailure(Throwable t) {
                getView().ondimiss();

            }
        });
    }



    @Override
    public void intent_deteil(int position) {
        Log.e("sss", String.valueOf(position));
        try {

            CustomerRes getData_cedit = customerRes.get(position);
            Intent intent = new Intent(context, Detali_data_cedit.class);


            Bundle bun = new Bundle();
            bun.putString("conno", getData_cedit.getCONTNO());
            bun.putString("customer", getData_cedit.getCustomerName());

            intent.putExtras(bun);
            context.startActivity(intent);

            //startActivityForResult(Intent, 100);


            Log.e("OK","OK");
        } catch (Exception e) {
            Log.e("ERROR",e.getMessage());
            e.printStackTrace();
        }
    }





    private void startActivityForResult(Intent intent, int i) {

    }

    @Override
    public void setCustomerList(Customer customer) {
        this.customerGroup = customer;
    }

    @Override
    public Customer getCustomerList() {
        return customerGroup;
    }

    @Override
    public void restoreCustomerList(Customer customer) {
        getView().setCustomerToAdapter(customer.getData());
    }
}
