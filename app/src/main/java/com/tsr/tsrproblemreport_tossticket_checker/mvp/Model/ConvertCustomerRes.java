package com.tsr.tsrproblemreport_tossticket_checker.mvp.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 7/2/2561.
 */

public class ConvertCustomerRes {

    public static Customer createFromResult(Customer result ){
        Customer group = new Customer();
        group.setStatus( result.getStatus() );
        group.setMessage( result.getMessage() );
        group.setData( ConvertCustomerRes.createListDataItemsFromResult( result.getData() ) );
        return group;
    }

    public static List<CustomerRes> createListDataItemsFromResult(List<CustomerRes> result){
        List<CustomerRes> items = new ArrayList<>();
        for( CustomerRes dataItemResult : result ){
            CustomerRes item = new CustomerRes();
            item.setCONTNO(dataItemResult.getCONTNO());
            item.setCustomerName(dataItemResult.getCustomerName());
            items.add( item );
        }
        return items;
    }
}
