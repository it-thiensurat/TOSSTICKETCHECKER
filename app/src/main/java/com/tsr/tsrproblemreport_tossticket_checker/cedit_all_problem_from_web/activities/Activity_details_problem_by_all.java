package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.RecyclerViewDataAdapter;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.RecyclerViewDataAdapter2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.databases.SQLiteHelper_image_buffer;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.databases.SQLiteHelper_problem_id_image;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.DATA_mp3;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_uploade_Image;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.ImageBefore;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.SectionDataModel;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.SectionDataModel2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.SingleItemModel;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.SingleItemModel2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.uploads_image.Service;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.utils.ImageConfiguration;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 25/1/2561.
 */

public class Activity_details_problem_by_all extends AppCompatActivity implements View.OnClickListener{
    ArrayList<SectionDataModel> allSampleData;
    ArrayList<SingleItemModel> singleItem;

    ArrayList<SectionDataModel2> allSampleData2;
    ArrayList<SingleItemModel2> singleItem2;

    private List<ImageBefore> imageBeforeList = new ArrayList<>();
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;

    String ID="",Gory="",Main="",Sub="",Detail="",conno="";
    ImageView image;
    RecyclerView my_recycler_view2,my_recycler_view;
    TextView txt_category,txt_main_problem,txt_sub_problem,txt_topic,txt_new_message;
    RelativeLayout open_camera,r_save;
    EditText new_message2;
    public static int size=0;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    JsonArrayRequest jsonArrayRequest;
    RequestQueue requestQueue;
    String GET_JSON_DATA_HTTP_URL="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/select_image_problem_from_id.php";
    String PATH;
    private Service uploadService;
    SweetAlertDialog pDialogg;
    private static final String SERVER_PATH = "http://app.thiensurat.co.th/assanee/";
    List<GetData_uploade_Image> getData_uploade_images;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardview_row_cedit_cedit5);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        my_recycler_view2 = (RecyclerView) findViewById(R.id.my_recycler_view2);
        my_recycler_view = (RecyclerView) findViewById(R.id.my_recycler_view);
        txt_category= (TextView) findViewById(R.id.txt_category);
        txt_main_problem= (TextView) findViewById(R.id.txt_main_problem);
        txt_sub_problem= (TextView) findViewById(R.id.txt_sub_problem);
        txt_topic= (TextView) findViewById(R.id.txt_topic);
        txt_new_message= (TextView) findViewById(R.id.txt_new_message);
        open_camera= (RelativeLayout) findViewById(R.id.open_camera);
        r_save= (RelativeLayout) findViewById(R.id.r_save);
        new_message2= (EditText) findViewById(R.id.new_message2);

        allSampleData = new ArrayList<SectionDataModel>();
        singleItem = new ArrayList<SingleItemModel>();

        allSampleData2 = new ArrayList<SectionDataModel2>();
        singleItem2 = new ArrayList<SingleItemModel2>();
        getData_uploade_images = new ArrayList<>();

        open_camera.setOnClickListener(this);
        r_save.setOnClickListener(this);

        my_recycler_view2.setHasFixedSize(true);
        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(this, allSampleData,imageBeforeList);
        my_recycler_view2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        my_recycler_view2.setAdapter(adapter);


        my_recycler_view.setHasFixedSize(true);
        RecyclerViewDataAdapter2 adapter2 = new RecyclerViewDataAdapter2(this, allSampleData2);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        my_recycler_view.setAdapter(adapter2);


        PackageManager m = getPackageManager();
        PATH = getPackageName();
        try {
            PackageInfo p = m.getPackageInfo(PATH, 0);
            PATH = p.applicationInfo.dataDir;
            Log.e("app path", PATH);
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("yourtag", "Error Package name not found ", e);
        }
        Bundle data=getIntent().getExtras();
        if(data!=null)
        {
            ID=data.getString("ID");
            Gory=data.getString("Gory");
            Main=data.getString("Main");
            Sub=data.getString("Sub");
            Detail=data.getString("Detail");
            conno=data.getString("conno");

            txt_category.setText(Gory);
            txt_main_problem.setText(Main);
            txt_sub_problem.setText(Sub);
            txt_topic.setText(Detail);
            txt_new_message.setText(Detail);

        }

        JSON_DATA_WEB_CALL2();
        select_image();
        select_id_from_Problem_Respon_Master();
        select_id_from_Problem_Respon_Details();
    }



    public void JSON_DATA_WEB_CALL2() {
      String user_code= MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
Log.e("dddd",GET_JSON_DATA_HTTP_URL + "?user_code=" + user_code+ "&ProblemID=" + ID);
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL + "?user_code=" + user_code+ "&ProblemID=" + ID,
                  //  jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL ,

                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {

                            createDummyData(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });


        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

    }
    public void createDummyData(JSONArray array) {

        for (int i = 1; i <=1; i++) {

            SectionDataModel dm = new SectionDataModel();

            dm.setHeaderTitle("ล่าสุด ");

           singleItem = new ArrayList<SingleItemModel>();



            for (int j = 0; j < array.length(); j++) {

                final DATA_mp3 GetDataAdapter2 = new DATA_mp3();
                JSONObject json = null;
                try {

                    json = array.getJSONObject(j);

                    GetDataAdapter2.setMp3_thumbnail_s2(json.getString("ImageUrl"));

                     String f= String.valueOf(j+1);
                     singleItem.add(new SingleItemModel("รูป "+f,GetDataAdapter2.getMp3_thumbnail_s2()));

                    Log.e("CC",GetDataAdapter2.getMp3_thumbnail_s2());

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            // for (int j = 0; j <= 5; j++) {
            // singleItem.add(new SingleItemModel("Item " + j, "http://app.thiensurat.co.th/assanee/upload/iconprofile/picture1.png"));
            //  }

            dm.setAllItemsInSection(singleItem);

            allSampleData.add(dm);


        }


        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(this, allSampleData,imageBeforeList);
        my_recycler_view2.setAdapter(adapter);


        if(singleItem.size()==0){
            my_recycler_view2.setVisibility(View.GONE);
        }
        else {
            my_recycler_view2.setVisibility(View.VISIBLE);
        }
    }






    RecyclerViewDataAdapter2 adapter;
    public  void select_image(){
        allSampleData2.clear();
        SQLiteDataBaseBuild();
        SQLiteTableBuild();
        for (int i = 1; i <=1; i++) {

            SectionDataModel2 dm = new SectionDataModel2();

            dm.setHeaderTitle("ล่าสุด ");

            //   ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();







            cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper_image_buffer.TABLE_NAME+""   , null);

            if (cursor.moveToFirst()) {
                do {

                    String FA=cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                    Log.e("A", FA);

                    // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                    String f= String.valueOf(1);
                    singleItem2.add(new SingleItemModel2("รูป "+f,FA));


                } while (cursor.moveToNext());
            }
            cursor.close();

            size = singleItem2.size();
            Log.e("size", String.valueOf(size));
            dm.setAllItemsInSection(singleItem2);

            allSampleData2.add(dm);


        }


         adapter = new RecyclerViewDataAdapter2(this, allSampleData2);
        my_recycler_view.setAdapter(adapter);


      if(size==0){
          my_recycler_view.setVisibility(View.GONE);
      }
      else {
          my_recycler_view.setVisibility(View.VISIBLE);
      }
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            // finish the activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    ImageConfiguration ic;
    Uri fileUri;
    Intent CamIntent,CropIntent;
    File file;
    String Url="",url_image="",order_ITEM="";

    @Override
    public void onClick(View view) {
        if(view==open_camera){
            CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            ic = new ImageConfiguration(this,PATH);
            file = ic.createImageByType_edit(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                    "report_problem", "ALL");
            fileUri = Uri.fromFile(file);
            CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
            startActivityForResult(CamIntent, 1);
        }
        else if(view==r_save){
            String strUserName = new_message2.getText().toString();

            if(TextUtils.isEmpty(strUserName)) {
                new_message2.setError("!กรุณาพิมพ์รายละเอียดการแก้ไขปัญหาด้วย");
                Vibrator v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    v.vibrate(VibrationEffect.createOneShot(200,VibrationEffect.DEFAULT_AMPLITUDE));
                }else{ v.vibrate(200);
                }

                return;
            }
            else {
                if(size_id_master!=0) {
                   // INSENT_Problem_Respon_Details();
                }



                cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "", null);

                if (cursor.moveToFirst()) {
                    do {

                        GetData_uploade_Image getData_uploade_image = new GetData_uploade_Image();
                       // Url = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Url));
                        url_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                        String part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_id));
                        Log.e("url_image",url_image);
                        getData_uploade_image.setImage(url_image);
                        getData_uploade_image.setPart_id(part_id);
                        getData_uploade_images.add(getData_uploade_image);

                    } while (cursor.moveToNext());
                }
                cursor.close();




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


                pDialogg = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
                pDialogg.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                pDialogg.setTitleText("กำลังอัปโหลด...");
                pDialogg.setCancelable(false);
                uploadMultiFile();

              /*
                allSampleData2.clear();
                adapter.notifyDataSetChanged();
                SQLiteDataBaseBuild();
                SQLiteTableBuild();
                sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "");

                File dire = new File(Environment.getExternalStorageDirectory(), "/Android/data/com.tsr.tsrproblemreport/files/Pictures");
                Log.e("dire", String.valueOf(dire));
                new DirectoryCleaner(dire).clean();
                dire.delete();*/

            }

        }
    }


    String Image_Name="";
    String Image_Size="";
    String Image_Type="";
    String part_id="";
    String Image_id_item="";
    private void uploadMultiFile() {
        //progressDialog.show();
        pDialogg.show();

        ArrayList<String> filePaths = new ArrayList<>();
        int gg=   getData_uploade_images.size();
        Log.e("gg", String.valueOf(gg));
        filePaths.add("/storage/sdcard0/Android/data/com.tsr.tsrproblemreport/files/Pictures/70102489/report_problem/ID1/image_error/image_error_20180406070126-1473976226.jpg");
        //    filePaths.add("/storage/sdcard0/Android/data/com.tsr.tsrproblemreport/files/Pictures/70102489/report_problem/ID1/image_error/image_error_201804060738541936595331.jpg");
        //  filePaths.add("/storage/sdcard0/Android/data/com.tsr.tsrproblemreport/files/Pictures/70102489/report_problem/ID1/image_error/image_error_20180406070126-1473976226.jpg");

        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);

        builder.addFormDataPart("user_name", "Robert");
        builder.addFormDataPart("email", "mobile.apps.pro.vn@gmail.com");


        for (int i = 0; i < getData_uploade_images.size(); i++) {
            // getData_uploade_images.get(i);
            GetData_uploade_Image contact = getData_uploade_images.get(i);
            String data_image_to_qry=contact.getImage();

            cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "", null);

            if (cursor.moveToFirst()) {
                do {

                    part_id=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_id));
                    Url=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Url));
                    order_ITEM=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_order_image));
                    Image_Name=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Image_Name));
                    Image_Size=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Image_Size));
                    Image_Type=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Image_Type));
                    Image_id_item=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_order_image));
                    Log.e("Url_rrr",Url);

                   INSENT_Problem_Inform_Details_Images();

                } while (cursor.moveToNext());
            }
            cursor.close();


            File file = new File(String.valueOf(contact.getImage()));
            builder.addFormDataPart("file[]", file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file));
        }

        File file = new File("");
        MultipartBody requestBody = builder.build();
        Call<ResponseBody> call = uploadService.uploadMultiFile(requestBody);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {



                           dialog_success();

                pDialogg.cancel();

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                dialog_error();

                pDialogg.cancel();
            }
        });


    }


    private void dialog_success(){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE);
        sweetAlertDialog.setTitleText("ไม่สำเร็จ!");
        sweetAlertDialog.setContentText("*การเเจ้งปัญหา*");
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sDialog) {

                //SQLiteDataBaseBuild2();
                //SQLiteTableBuild2();
                // sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_problem_id_image.TABLE_NAME+"");


                File dire= new File(Environment.getExternalStorageDirectory(), "/Android/data/com.tsr.tsrproblemreport/files/Pictures");
                Log.e("dire", String.valueOf(dire));
                new DirectoryCleaner(dire).clean();
                dire.delete();


                Log.e("dialog","ปิด dialog");
                sDialog.dismissWithAnimation();

                finish();
            }
        });
        sweetAlertDialog .show();
    }

    private void dialog_error(){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE);
        sweetAlertDialog.setTitleText("เสร็จสิ้น!");
        sweetAlertDialog.setContentText("*การเเจ้งปัญหา*");
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sDialog) {

                //SQLiteDataBaseBuild2();
                //SQLiteTableBuild2();
                // sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_problem_id_image.TABLE_NAME+"");


                File dire= new File(Environment.getExternalStorageDirectory(), "/Android/data/com.tsr.tsrproblemreport/files/Pictures");
                Log.e("dire", String.valueOf(dire));
                new DirectoryCleaner(dire).clean();
                dire.delete();


                Log.e("dialog","ปิด dialog");
                sDialog.dismissWithAnimation();

                finish();
            }
        });
        sweetAlertDialog .show();
    }

    String GET_JSON_insent_Problem_Respon_Master="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Respon_Master.php";
    String GET_JSON_insent_Problem_Respon_Details="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Respon_Details.php";
    String GET_JSON_insent_Problem_Respon_Details_Images="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Respon_Details_Images.php";
    String GET_JSON_select_id_from_Problem_Respon_Master="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_id_from_Problem_Respon_Master.php";
    String GET_JSON_select_id_from_Problem_Respon_Details="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_id_from_Problem_Respon_Details.php";



    public void select_id_from_Problem_Respon_Master(){
        Log.e("url_id_Master",GET_JSON_select_id_from_Problem_Respon_Master+"?Contno="+conno+"&ProblemID="+ID);

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_select_id_from_Problem_Respon_Master+"?Contno="+conno+"&ProblemID="+ID,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSON_PARSE_DATA_AFTER_select_id_from_Problem_Respon_Master(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });


        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);
    }


    String InformID="";
    String ProblemID="";
    String WorkCode="";
    int size_id_master;
    public void JSON_PARSE_DATA_AFTER_select_id_from_Problem_Respon_Master(JSONArray array) {

         size_id_master=array.length();
        Log.e("size_id_master", String.valueOf(size_id_master));
        for (int i = 0; i < array.length(); i++) {

            //final GetData_select_topic_problem_sub GetDataAdapter2 = new GetData_select_topic_problem_sub();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                // GetDataAdapter2.setProblemID(json.getString("InformID"));
                InformID=json.getString("InformID");
                ProblemID=json.getString("ProblemID");
                WorkCode=json.getString("WorkCode");

                MyApplication.getInstance().getPrefManager().setPreferrence("InformID", InformID);
                MyApplication.getInstance().getPrefManager().setPreferrence("ProblemID", ProblemID);
                MyApplication.getInstance().getPrefManager().setPreferrence("WorkCode", WorkCode);
                Log.e("InformID",InformID);
                Log.e("ProblemID",ProblemID);
                Log.e("WorkCode",WorkCode);


            } catch (JSONException e) {

                e.printStackTrace();
            }

        }

    }

    public void select_id_from_Problem_Respon_Details(){

        String DepartID=MyApplication.getInstance().getPrefManager().getPreferrence("DepartId");
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_select_id_from_Problem_Respon_Details+"?InformID="+InformID+"&ProblemID="+ProblemID+"&DepartID="+DepartID,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSON_PARSE_DATA_AFTER_select_id_from_Problem_Respon_Details(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });


        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);
    }



    String Items="";
    int int_item;
    public void JSON_PARSE_DATA_AFTER_select_id_from_Problem_Respon_Details(JSONArray array) {
        int_item=array.length();
        if(int_item==0){
            Items="1";
        }
        for (int i = 0; i < array.length(); i++) {

            //final GetData_select_topic_problem_sub GetDataAdapter2 = new GetData_select_topic_problem_sub();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                // GetDataAdapter2.setProblemID(json.getString("InformID"));
                Items=json.getString("Items");


                MyApplication.getInstance().getPrefManager().setPreferrence("Items", Items);

                Log.e("Items",Items);



            } catch (JSONException e) {

                e.printStackTrace();
            }

        }

    }

    public   void INSENT_Problem_Respon_Details(){




        String EmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        String DepartID=MyApplication.getInstance().getPrefManager().getPreferrence("DepartId");
      //  String Items2=Items;
        String ResponTypeID="02";
        String user_code=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        String ipaddress=MyApplication.getInstance().getPrefManager().getPreferrence("IPaddress");
        String computername=MyApplication.getInstance().getPrefManager().getPreferrence("android_name");
        String NoteData="NULL";
        String ResponStatus="1";
        String ResponNote=new_message2.getText().toString();

        try {
            Log.e("url_respon_details",GET_JSON_insent_Problem_Respon_Details+"?InformID="+InformID+"&ProblemID="+ProblemID+"&DepartID="+DepartID+"&Items="+Items+"&ResponTypeID="+ResponTypeID+"&EmpID="+EmpID+"&ResponNote="+URLEncoder.encode(ResponNote, "UTF-8")+"&user_code="+user_code+"&ipaddress="+ ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&NoteData="+NoteData+"&ResponStatus="+ResponStatus);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_insent_Problem_Respon_Details+"?InformID="+InformID+"&ProblemID="+ProblemID+"&DepartID="+DepartID+"&Items="+Items+"&ResponTypeID="+ResponTypeID+"&EmpID="+EmpID+"&ResponNote="+URLEncoder.encode(ResponNote, "UTF-8")+"&user_code="+user_code+"&ipaddress="+ ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&NoteData="+NoteData+"&ResponStatus="+ResponStatus,


                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            //INSENT_Problem_details();

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);
    }





    private  void INSENT_Problem_Inform_Details_Images(){


        String ProblemID=part_id;
        String ImageItem=Image_id_item ;
        String ImageUrl=Url;
        String ImageName=Image_Name;
        String ImageSize=Image_Size;
        String ImageType =Image_Type;
        String DepartID=MyApplication.getInstance().getPrefManager().getPreferrence("DepartId");
        Log.e("URL_IMAGE",GET_JSON_insent_Problem_Respon_Details_Images+"?InformID="+MyApplication.getInstance().getPrefManager().getPreferrence("InformID")+"&ProblemID="+ProblemID+"&DepartID="+DepartID+"&ImageItem="+ImageItem+"&ImageUrl="+ImageUrl+"&ImageName="+ImageName+"&ImageSize="+ImageSize+"&ImageType="+ImageType);
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_insent_Problem_Respon_Details_Images+"?InformID="+MyApplication.getInstance().getPrefManager().getPreferrence("InformID")+"&ProblemID="+ProblemID+"&DepartID="+DepartID+"&ImageItem="+ImageItem+"&ImageUrl="+ImageUrl+"&ImageName="+ImageName+"&ImageSize="+ImageSize+"&ImageType="+ImageType,
       // jsonArrayRequest = new JsonArrayRequest(GET_JSON_insent_Problem_Respon_Details_Images+"?InformID="+MyApplication.getInstance().getPrefManager().getPreferrence("InformID")+"&ProblemID="+ProblemID+"&ImageItem="+ImageItem+"&ImageUrl="+ImageUrl,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

    }

    private  void UPDATE_Problem_Respon_Master(){


        String ProblemID=part_id;
        String ImageItem=Image_id_item ;
        String ImageUrl=Url;
        String ImageName=Image_Name;
        String ImageSize=Image_Size;
        String ImageType =Image_Type;
        String DepartID=MyApplication.getInstance().getPrefManager().getPreferrence("DepartId");
        Log.e("URL_IMAGE",GET_JSON_insent_Problem_Respon_Details_Images+"?InformID="+MyApplication.getInstance().getPrefManager().getPreferrence("InformID")+"&ProblemID="+ProblemID+"&DepartID="+DepartID+"&ImageItem="+ImageItem+"&ImageUrl="+ImageUrl+"&ImageName="+ImageName+"&ImageSize="+ImageSize+"&ImageType="+ImageType);
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_insent_Problem_Respon_Details_Images+"?InformID="+MyApplication.getInstance().getPrefManager().getPreferrence("InformID")+"&ProblemID="+ProblemID+"&DepartID="+DepartID+"&ImageItem="+ImageItem+"&ImageUrl="+ImageUrl+"&ImageName="+ImageName+"&ImageSize="+ImageSize+"&ImageType="+ImageType,
                // jsonArrayRequest = new JsonArrayRequest(GET_JSON_insent_Problem_Respon_Details_Images+"?InformID="+MyApplication.getInstance().getPrefManager().getPreferrence("InformID")+"&ProblemID="+ProblemID+"&ImageItem="+ImageItem+"&ImageUrl="+ImageUrl,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

    }
    private  void UPDATE_Problem_Respon_Details(){


        String ProblemID=part_id;
        String ImageItem=Image_id_item ;
        String ImageUrl=Url;
        String ImageName=Image_Name;
        String ImageSize=Image_Size;
        String ImageType =Image_Type;
        String DepartID=MyApplication.getInstance().getPrefManager().getPreferrence("DepartId");
        Log.e("URL_IMAGE",GET_JSON_insent_Problem_Respon_Details_Images+"?InformID="+MyApplication.getInstance().getPrefManager().getPreferrence("InformID")+"&ProblemID="+ProblemID+"&DepartID="+DepartID+"&ImageItem="+ImageItem+"&ImageUrl="+ImageUrl+"&ImageName="+ImageName+"&ImageSize="+ImageSize+"&ImageType="+ImageType);
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_insent_Problem_Respon_Details_Images+"?InformID="+MyApplication.getInstance().getPrefManager().getPreferrence("InformID")+"&ProblemID="+ProblemID+"&DepartID="+DepartID+"&ImageItem="+ImageItem+"&ImageUrl="+ImageUrl+"&ImageName="+ImageName+"&ImageSize="+ImageSize+"&ImageType="+ImageType,
                // jsonArrayRequest = new JsonArrayRequest(GET_JSON_insent_Problem_Respon_Details_Images+"?InformID="+MyApplication.getInstance().getPrefManager().getPreferrence("InformID")+"&ProblemID="+ProblemID+"&ImageItem="+ImageItem+"&ImageUrl="+ImageUrl,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

    }
    public class DirectoryCleaner {
        private final File mFile;

        public DirectoryCleaner(File file) {
            mFile = file;
        }

        public void clean() {
            if (null == mFile || !mFile.exists() || !mFile.isDirectory()) return;
            for (File file : mFile.listFiles()) {
                delete(file);
            }
        }

        private void delete(File file) {
            if (file.isDirectory()) {
                for (File child : file.listFiles()) {
                    delete(child);
                }
            }
            file.delete();

        }
    }

    private void CropImage() {

        try {
            CropIntent = new Intent("com.android.camera.action.CROP");
            CropIntent.setDataAndType(fileUri, "image/*");
            CropIntent.putExtra("crop", "true");
            CropIntent.putExtra("outputX", 1024);
            CropIntent.putExtra("outputY", 1024);
            CropIntent.putExtra("aspectX", 1);
            CropIntent.putExtra("aspectY", 1);
            CropIntent.putExtra("scaleUpIfNeeded", true);
            CropIntent.putExtra("return-data", true);
            //CropIntent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
            startActivityForResult(CropIntent, 2);
        } catch (ActivityNotFoundException ex) {

        }
    }
    int order_image=0;
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {

        }

        else if(requestCode == 1){
            if(resultCode==RESULT_OK) {
                allSampleData2.clear();
                CropImage();
            }

        }

        else if (requestCode == 2){
          //  allSampleData2.clear();
            order_image=order_image+1;
            String FILE=file.getAbsolutePath();
            String image_name=MyApplication.getInstance().getPrefManager().getPreferrence("imageName");
            String Url="http://app.thiensurat.co.th/assanee/uploads_image_report_problem/"+image_name+".jpg";
            File file2 = new File(FILE);
            long length = file2.length();
            length = length/1024;
            String number= String.valueOf(1);
            SQLiteDataBaseBuild();
            SQLiteTableBuild();
            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "jpg" + "','" + order_image + "');";
            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);

            for (int i = 1; i <=1; i++) {

                SectionDataModel2 dm = new SectionDataModel2();

                dm.setHeaderTitle("ล่าสุด ");

               singleItem2 = new ArrayList<SingleItemModel2>();

                cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper_image_buffer.TABLE_NAME+""   , null);

                if (cursor.moveToFirst()) {
                    do {

                        String FA=cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                        String f=cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
                        singleItem2.add(new SingleItemModel2("รูป "+f,FA));

                        size=singleItem2.size();
                        MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                    } while (cursor.moveToNext());
                }
                cursor.close();
                dm.setAllItemsInSection(singleItem2);
                allSampleData2.add(dm);
                }

                  adapter = new RecyclerViewDataAdapter2(this, allSampleData2);
                  my_recycler_view.setAdapter(adapter);
               // adapter.notifyDataSetChanged();
            if(singleItem2.size()==0){
                my_recycler_view.setVisibility(View.GONE);
            }
            else {
                my_recycler_view.setVisibility(View.VISIBLE);
            }
            //select_image();

        }



    }




    public void SQLiteDataBaseBuild(){

        sqLiteDatabase = this.openOrCreateDatabase(SQLiteHelper_image_buffer.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    public void SQLiteTableBuild(){

        //sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper.TABLE_NAME+"("+ SQLiteHelper.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+SQLiteHelper.Table_Column_1_Subject_Name+" VARCHAR, "+SQLiteHelper.Table_Column_2_SubjectFullForm+" VARCHAR, "+SQLiteHelper.Table_Column_3_subteamcode+" VARCHAR, "+SQLiteHelper.Table_Column_5_contract_number+" VARCHAR, "+SQLiteHelper.Table_Column_6_contract_number2+" VARCHAR, "+SQLiteHelper.Table_Column_7_name_topic+" VARCHAR, "+SQLiteHelper.Table_Column_8_customer+" VARCHAR, "+SQLiteHelper.Table_Column_9_description+" VARCHAR, "+SQLiteHelper.Table_Column_16_status+" VARCHAR, "+SQLiteHelper.Table_Column_15_date_time+" VARCHAR, "+SQLiteHelper.Table_Column_23_date_time_update+" VARCHAR, "+SQLiteHelper.Table_Column_10_approveStatus+" VARCHAR, "+SQLiteHelper.Table_Column_11_approveBy+" VARCHAR, "+SQLiteHelper.Table_Column_12_approveDate+" VARCHAR, "+SQLiteHelper.Table_Column_17_isremark+" VARCHAR, "+SQLiteHelper.Table_Column_14_isremark1+" VARCHAR, "+SQLiteHelper.Table_Column_20_check_foller+" VARCHAR, "+SQLiteHelper.Table_Column_21_countfoller+" VARCHAR, "+SQLiteHelper.Table_Column_22_countcomment+" VARCHAR, "+SQLiteHelper.Table_Column_4_picture+" VARCHAR);");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_image_buffer.TABLE_NAME+"("+ SQLiteHelper_image_buffer.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_image_buffer.Table_part_id+" VARCHAR, "+SQLiteHelper_image_buffer.Table_name_image+" VARCHAR, "+SQLiteHelper_image_buffer.Table_url_image+" VARCHAR, "+SQLiteHelper_image_buffer.Table_Url+" VARCHAR, "+SQLiteHelper_image_buffer.Table_Image_Name+" VARCHAR, "+SQLiteHelper_image_buffer.Table_Image_Size+" VARCHAR, "+SQLiteHelper_image_buffer.Table_Image_Type+" VARCHAR, "+SQLiteHelper_image_buffer.Table_order_image+" VARCHAR);");


    }

}
