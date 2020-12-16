package com.tsr.tsrproblemreport_tossticket_checker.Mechanic_system.api;




import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by frank on 12/16/16.
 */

public interface Service {





    @GET("/api/api-survaycontractelectricianlist-uat.php")
    Call<Object> customer(@Query("empid") String data);



    @GET("/api/api-survaytelnoelectricianlist-uat.php")
    Call<Object> tel(@Query("contno") String data);



    @GET("/api/api-survaysendsmselectricianlist-uat.php")
    Call<Object> sentsms(@Query("telno") String data,@Query("contno") String data2);




}


