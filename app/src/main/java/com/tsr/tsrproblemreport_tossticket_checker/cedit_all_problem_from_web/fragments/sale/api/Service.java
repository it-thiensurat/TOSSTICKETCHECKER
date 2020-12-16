package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.sale.api;



import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_sale_edit_problem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by frank on 12/16/16.
 */

public interface Service {



    @GET("/assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_no_PAGE.php/")                                   // REAL
    Call<Object> getSale(@Query("user_code") String EmpID,@Query("page") int page);


    @GET("/assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all_for_ret/manager_problem1_json2_real_from_cedit_edit_problem2_copy_real_PAGE.php/")                                   // REAL
    Call<Object> getSale0(@Query("user_code") String EmpID,@Query("page") int page);




}


