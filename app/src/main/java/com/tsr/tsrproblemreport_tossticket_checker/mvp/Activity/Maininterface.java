package com.tsr.tsrproblemreport_tossticket_checker.mvp.Activity;

import java.util.List;

import com.tsr.tsrproblemreport_tossticket_checker.mvp.Model.Customer;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.Model.CustomerRes;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.base.BaseMvpInterface;

/**
 * Created by user on 30/10/2560.
 */

public class Maininterface {

    public interface view extends BaseMvpInterface.View{
        void success(String username);
        void setCustomerToAdapter(List<CustomerRes> customer);
    }

    public interface  presenter extends  BaseMvpInterface.Presenter<view>{
        void login(String username);
        void setCustomerList(Customer customer);
        Customer getCustomerList();
        void restoreCustomerList(Customer customer);
    }


}
