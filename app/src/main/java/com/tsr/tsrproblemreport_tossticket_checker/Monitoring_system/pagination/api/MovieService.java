package com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.pagination.api;




import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.pagination.models.TopRatedMovies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Pagination
 * Created by Suleiman19 on 10/27/16.
 * Copyright (c) 2016. Suleiman Ali Shakir. All rights reserved.
 */

public interface MovieService {

/*    @GET("movie/top_rated")
    Call<TopRatedMovies> getTopRatedMovies(
            @Query("api_key") String apiKey,
            @Query("language") String language,
                @Query("page") int pageIndex
    );*/




    @GET("assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_problem1_json2_real_from_cedit_edit_problem2_copy_real_PAGE.php")
    Call<TopRatedMovies> getTopRatedMovies(
           /* @Query("api_key") String apiKey,
            @Query("language") String language,*/
            @Query("page") int pageIndex
    );


}
