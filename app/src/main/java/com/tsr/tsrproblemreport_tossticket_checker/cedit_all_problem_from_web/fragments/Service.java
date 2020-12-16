package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments;

import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.uploads_image.UploadObject;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;

/**
 * Created by Robert
 */

public interface Service {
    /*@Multipart
    @POST("/upload_multi_files/MultiUpload.php")
    Call<ResponseBody> uploadFile(@Part MultipartBody.Part file, @Part("name") RequestBody name);*/
    @Multipart
    @POST("/upload_multi_files/fileUpload.php")
    Call<UploadObject> uploadSingleFile(@Part MultipartBody.Part file, @Part("name") RequestBody name);

    @Multipart
    //@POST("/upload_multi_files/MultiUpload.php")
    @POST("MultiPartUpload.php")
    Call<UploadObject> uploadMultiFile(@Part MultipartBody.Part file1, @Part MultipartBody.Part file2, @Part MultipartBody.Part file3);



    @Multipart
    //@POST("/upload_multi_files/MultiUpload.php")
    @POST("MultiPartUpload2.php")
    Call<UploadObject> uploadMultiFile2(@Part MultipartBody.Part file1, @Part MultipartBody.Part file2, @Part MultipartBody.Part file3);






 //   @POST("MultiPartUpload.php")
 //   Call<ResponseBody> uploadMultiFile(@Body RequestBody file);


    @POST("MultiPartUpload.php")
    Call<ResponseBody> uploadMultiFile(@Body RequestBody file);


    @POST("MultiPartUpload2.php")
    Call<ResponseBody> uploadMultiFile2(@Body RequestBody file);

    @FormUrlEncoded
    @PUT("/api/register")
    Call<ResponseBody> getStatus(
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password,
            @Field("fbID") String fbID,
            @Field("gmailID") String gmailID,
            @Field("twitID") String twitID,
            @Field("gender") String gender,
            @Field("birthDate") String birthDate,
            @Field("location") String location,
            @Field("longitude") String longitude,
            @Field("latitude") String latitude,
            @Field("profileImage") String profileImage);
    //@Field parameters can only be used with form encoding. (parameter #2)
}
