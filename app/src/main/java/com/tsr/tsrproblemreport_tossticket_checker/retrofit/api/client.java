package com.tsr.tsrproblemreport_tossticket_checker.retrofit.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.tsr.tsrproblemreport_tossticket_checker.API_URL_ALL.BASE_URL;

/**
 * Created by frank on 12/16/16.
 */

public class client  {

    // Trailing slash is needed
   // public static final String BASE_URL = "https://tssm.thiensurat.co.th";
    //public static  String BASE_URL ="http://app.thiensurat.co.th";






/*

    public static Retrofit createRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    //GitHubService service = retrofit.create(GitHubService.class);

 */
}
