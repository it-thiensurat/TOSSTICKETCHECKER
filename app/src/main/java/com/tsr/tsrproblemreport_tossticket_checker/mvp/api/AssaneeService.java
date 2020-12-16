package com.tsr.tsrproblemreport_tossticket_checker.mvp.api;


import com.tsr.tsrproblemreport_tossticket_checker.mvp.api.base.BaseService;

/**
 * Created by TheKhaeng on 9/15/2016 AD.
 */

public class AssaneeService extends BaseService<AssaneeApiService> {

    public static AssaneeService newInstance( String baseUrl ){
        AssaneeService service = new AssaneeService();
        service.setBaseUrl( baseUrl );
        return service;
    }

    private AssaneeService(){
    }

    @Override
    protected Class<AssaneeApiService> getApiClassType(){
        return AssaneeApiService.class;
    }
}
