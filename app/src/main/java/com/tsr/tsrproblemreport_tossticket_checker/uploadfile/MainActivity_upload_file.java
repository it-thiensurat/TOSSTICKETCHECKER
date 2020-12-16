package com.tsr.tsrproblemreport_tossticket_checker.uploadfile;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.tsr.tsrproblemreport_tossticket_checker.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import pub.devrel.easypermissions.EasyPermissions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity_upload_file extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {
    private static final String TAG = MainActivity_upload_file.class.getSimpleName();

    private static final int REQUEST_GALLERY_CODE = 200;
    private static final int READ_REQUEST_CODE = 300;
    private static final String SERVER_PATH = "http://app.thiensurat.co.th/assanee/";
    private Uri uri;
    private Service uploadService;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_upload_file);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        // Change base URL to your upload server URL.
        uploadService = new Retrofit.Builder()
                .baseUrl(SERVER_PATH)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Service.class);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Uploading...");
        uploadMultiFile();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, MainActivity_upload_file.this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_GALLERY_CODE && resultCode == Activity.RESULT_OK) {
            uri = data.getData();
            if (EasyPermissions.hasPermissions(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                progressDialog.show();
                String filePath = getRealPathFromURIPath(uri, MainActivity_upload_file.this);
                File file = new File(filePath);
               // Log.d(TAG, "filePath=" + filePath);
                //RequestBody mFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                RequestBody mFile = RequestBody.create(MediaType.parse("image/*"), file);
                MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", file.getName(), mFile);
                RequestBody filename = RequestBody.create(MediaType.parse("text/plain"), file.getName());

                Call<UploadObject> fileUpload = uploadService.uploadSingleFile(fileToUpload, filename);
                fileUpload.enqueue(new Callback<UploadObject>() {
                    @Override
                    public void onResponse(Call<UploadObject> call, Response<UploadObject> response) {
                        progressDialog.dismiss();
                      //  Toast.makeText(MainActivity_upload_file.this, "Response " + response.raw().message(), Toast.LENGTH_LONG).show();
                      //  Toast.makeText(MainActivity_upload_file.this, "Success " + response.body().getSuccess(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<UploadObject> call, Throwable t) {
                        progressDialog.dismiss();

                       // Log.d(TAG, "Error " + t.getMessage());
                    }

                });
            } else {
                EasyPermissions.requestPermissions(this, getString(R.string.read_file), READ_REQUEST_CODE, Manifest.permission.READ_EXTERNAL_STORAGE);
            }
        }

       // else if(resultCode==REQUEST_ALL_PERMISSION){
        //    Toast.makeText(MainActivity_Loadmore.this, "5555 " +"65555", Toast.LENGTH_LONG).show();
        //}
    }

    private String getRealPathFromURIPath(Uri contentURI, Activity activity) {
        Cursor cursor = activity.getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) {
            return contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            return cursor.getString(idx);
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

        if (uri != null) {
            progressDialog.show();
        }
        String filePath = getRealPathFromURIPath(uri, MainActivity_upload_file.this);
        File file = new File(filePath);
        RequestBody mFile = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", file.getName(), mFile);
        RequestBody filename = RequestBody.create(MediaType.parse("text/plain"), file.getName());

        Call<UploadObject> fileUpload = uploadService.uploadSingleFile(fileToUpload, filename);

        fileUpload.enqueue(new Callback<UploadObject>() {
            @Override
            public void onResponse(Call<UploadObject> call, Response<UploadObject> response) {
                progressDialog.dismiss();
           //     Toast.makeText(MainActivity_upload_file.this, "Success " + response.message(), Toast.LENGTH_LONG).show();
             //   Toast.makeText(MainActivity_upload_file.this, "Success " + response.body().toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<UploadObject> call, Throwable t) {
                progressDialog.dismiss();
              //  Log.d(TAG, "Error " + t.getMessage());
            }
        });

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
      //  Log.d(TAG, "Permission has been denied");
    }

    private void uploadMultiFile() {
        progressDialog.show();

        ArrayList<String> filePaths = new ArrayList<>();
      //  filePaths.add("/storage/sdcard0/Android/data/com.tsr.tsrproblemreport/files/Pictures/70102488/report_problem/IDALL/image_error/image_error_20180513114358.jpg");
      //  filePaths.add("/storage/sdcard0/Android/data/com.tsr.tsrproblemreport/files/Pictures/70102488/report_problem/IDALL/image_error/image_error_20180513120015.jpg");
       // filePaths.add("/storage/sdcard0/Android/data/com.tsr.tsrproblemreport/files/Pictures/70102488/report_problem/IDALL/image_error/image_error_20180513120033.jpg");

      //  filePaths.add("/storage/sdcard0/Android/data/com.tsr.tsrproblemreport/files/Pictures/70102488/report_problem/IDALL/image_error/image_error_20180513120412.jpg");
      //  filePaths.add("/sdcard/Android/data/com.tsr.tsrproblemreport/files/Pictures/70102488/report_problem/IDALL/image_error/image_error_20180513120412.jpg");
        filePaths.add("/sdcard/Android/data/com.tsr.tsrproblemreport/files/Pictures/70102488/report_problem/IDALL/image_edit/image_edit_20180513041513.jpg");
        //filePaths.add("/storage/sdcard0/Android/data/com.tsr.tsrproblemreport/files/Pictures/70102488/report_problem/IDALL/image_error/image_error_20180513120427.jpg");
        //filePaths.add("/storage/sdcard0/Android/data/com.tsr.tsrproblemreport/files/Pictures/70102488/report_problem/IDALL/image_error/image_error_20180513120438.jpg");


        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);

        builder.addFormDataPart("user_name", "Robert");
        builder.addFormDataPart("email", "mobile.apps.pro.vn@gmail.com");

        // Map is used to multipart the file using okhttp3.RequestBody
        // Multiple Images
     //   Toast.makeText(MainActivity_Loadmore.this, "size " + filePaths.size(), Toast.LENGTH_LONG).show();

       // MultipartBody.Part filePart2;
        for (int i = 0; i < filePaths.size(); i++) {
            File file = new File(filePaths.get(i));
           // Toast.makeText(MainActivity_Loadmore.this, "error " + "upload", Toast.LENGTH_LONG).show();


            builder.addFormDataPart("file[]", file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file));
        }

        File file = new File("");
        MultipartBody requestBody = builder.build();
        Call<ResponseBody> call = uploadService.uploadMultiFile(requestBody);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

               // Toast.makeText(MainActivity_upload_file.this, "Success " + response.message(), Toast.LENGTH_LONG).show();
               // Toast.makeText(MainActivity_upload_file.this, "Success " + response.body().toString(), Toast.LENGTH_LONG).show();

                progressDialog.dismiss();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                progressDialog.dismiss();
               // Log.d(TAG, "Error " + t.getMessage());
            }
        });


    }
/*
    private static final int REQUEST_ALL_PERMISSION = 1;
    @TargetApi(Build.VERSION_CODES.M)
    private void initPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA) ||
                    shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                Toast.makeText(this, "Need permission please", Toast.LENGTH_SHORT).show();
            }
            requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_ALL_PERMISSION);
        } else {
            // do your normal stuff
        }
    }
*/


}

