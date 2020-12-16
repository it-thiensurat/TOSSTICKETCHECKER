package com.tsr.tsrproblemreport_tossticket_checker.mvp.Activity;

import android.util.Log;

import com.hwangjr.rxbus.RxBus;

import java.util.ArrayList;
import java.util.List;

import com.tsr.tsrproblemreport_tossticket_checker.mvp.Model.ConvertCustomerRes;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.Model.Customer;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.Model.CustomerRes;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.api.AssaneeServiceManager;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.base.BaseMvpPresenter;

/**
 * Created by user on 30/10/2560.
 */

public class MainPresenter extends BaseMvpPresenter<Maininterface.view> implements Maininterface.presenter {

    private AssaneeServiceManager serviceManager;
    private static Customer customerGroup;
    private static List<CustomerRes> customerRes = new ArrayList<CustomerRes>();

    public MainPresenter(){
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








    public  static Maininterface.presenter create(){
      return new MainPresenter();
    }
    @Override
    public void login(String username ) {
        serviceManager.Login(username, new AssaneeServiceManager.AssaneeManagerCallback<Customer>() {
            @Override
            public void onSuccess(Customer result) {
                Log.e("onSuccess",result.getData().size()+"");
                Customer customer = ConvertCustomerRes.createFromResult(result);
                customerGroup = customer;
                customerRes = ConvertCustomerRes.createListDataItemsFromResult(result.getData());
                getView().setCustomerToAdapter(customerRes);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
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
