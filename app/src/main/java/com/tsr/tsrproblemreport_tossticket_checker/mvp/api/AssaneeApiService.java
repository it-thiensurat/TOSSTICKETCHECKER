package com.tsr.tsrproblemreport_tossticket_checker.mvp.api;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import com.tsr.tsrproblemreport_tossticket_checker.mvp.Model.Customer;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.Model.manager.Manager;


import java.util.Objects;

import static com.tsr.tsrproblemreport_tossticket_checker.mvp.api.AssaneeURL.URL;
import static com.tsr.tsrproblemreport_tossticket_checker.mvp.api.AssaneeURL.URL_manager;
import static com.tsr.tsrproblemreport_tossticket_checker.other_all.EndPoints.GET_JSON_sent_nontification_to_credit;


/**
 * Created by TheKhaeng on 9/14/2016 AD.
 */

public interface AssaneeApiService{

    @GET( URL )
    Call<Customer> getLogin(@Query("SALECODE") String username);

    @GET( URL_manager )
    Call<Manager> getProblem_manager(@Query("user_code") String user_code);

    @POST(GET_JSON_sent_nontification_to_credit)
    Call<Objects> sent_nonti_credit(@Body Sent_nonti_all body);
}
