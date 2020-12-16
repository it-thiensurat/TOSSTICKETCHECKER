package com.tsr.tsrproblemreport_tossticket_checker.mvp.Model.manager;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 7/2/2561.
 */

public class ConvertManagerRes {

    public static Manager createFromResult(Manager result ){
        Manager group = new Manager();
        group.setStatus( result.getStatus() );
        group.setMessage( result.getMessage() );
        group.setData( ConvertManagerRes.createListDataItemsFromResult( result.getData() ) );
        return group;
    }

    public static List<ManagerRes> createListDataItemsFromResult(List<ManagerRes> result){
        List<ManagerRes> items = new ArrayList<>();
        for( ManagerRes dataItemResult : result ){
            ManagerRes item = new ManagerRes();
            item.setCONTNO(dataItemResult.getCONTNO());
            item.setCustomerName(dataItemResult.getCustomerName());
            items.add( item );
        }
        return items;
    }
}
