package com.tsr.tsrproblemreport_tossticket_checker.retrofit.api;



import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_sale_edit_problem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by frank on 12/16/16.
 */

public interface Service {



    @GET("assanee/login5_3.php/")                                   // REAL
    Call<Object> getSale(@Query("EmpID") String EmpID);

    @GET("assanee/login_device3.php/")
    Call<Object> getSale2(@Query("AndroidDeviceID") String AndroidDeviceID);

    @GET("assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_problem1_json2_real_from_cedit_edit_problem2_copy_real.php/")
    Call<Object> getDataManager(@Query("user_code") String user_code);

    @GET("assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_problem1_json2_real_from_cedit_edit_problem2_copy_real.php/")
    Call<List<GetData_cedit_sale_edit_problem>> getDataManager1(@Query("user_code") String user_code);

    @GET("assanee/api_sale_all_problem_from_cedit_by_db_kiw/line/problem_all/line_problem1_json2_real_from_cedit_edit_problem2_copy_real.php/")
    Call<Object> getSale3(@Query("user_code") String user_code);

    @GET("assanee/CHECK_ACODE.php/")                                   // REAL
    Call<Object> getSale4(@Query("SaleEmp") String EmpID);







/*
    @GET("/assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_problem1_json2_real_from_cedit_edit_problem2_copy_real_PAGE.php")
    Call<Object> getTopRatedMovies(
           *//* @Query("api_key") String apiKey,
            @Query("language") String language,*//*
            @Query("page") int pageIndex
    );*/
/*
    @GET("/assanee/login5_3_UAT.php/")                                  // UAT
    Call<Object> getSale(@Query("EmpID") String EmpID);

    @GET("/assanee/login_device.php/")
    Call<Object> getSale2(@Query("AndroidDeviceID") String AndroidDeviceID);
    */

}


