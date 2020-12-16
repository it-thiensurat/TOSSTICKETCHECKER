package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments;


import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;

import android.net.Uri;

import android.os.Build;
import android.os.Bundle;

import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import android.widget.RelativeLayout;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.IMAGE_SALE_RECIVE_EDIT_PROBLEM;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.RecyclerViewAdapter_sale_recive_report_problem_edit;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.databases.SQLiteHelper;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_remove_image_select_id;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_sale_edit_problem;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_sale_information;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_uploade_Image;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.utils.ImageConfiguration;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class UI_CARDVIEW_DATA_SALE_EDIT_PROBLEM extends AppCompatActivity implements  View.OnClickListener,RecyclerViewAdapter_sale_recive_report_problem_edit.itemclick2, RecyclerViewAdapter_sale_recive_report_problem_edit.itemclick_image_sucess, RecyclerViewAdapter_sale_recive_report_problem_edit.itemclick_image_ic_dete1, RecyclerViewAdapter_sale_recive_report_problem_edit.itemclick_image_ic_dete2, RecyclerViewAdapter_sale_recive_report_problem_edit.itemclick_photograph_image_error, RecyclerViewAdapter_sale_recive_report_problem_edit.itemclick_photograph_image_success,RecyclerViewAdapter_sale_recive_report_problem_edit.MessageAdapterListener {



    List<GetData_cedit_sale_edit_problem> GetDataAdapter1;
    GetData_cedit_sale_edit_problem getData_cedit_sale_edit_problem;
   // String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/sale_problem1_json2_real_from_cedit_edit_problem.php";
   // String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/sale_problem1_json2_real_from_cedit_edit_problem2.php";
    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/sale_problem1_json2_real_from_cedit_edit_problem2_real.php";

    RecyclerViewAdapter_sale_recive_report_problem_edit recyclerViewadapter1;
    String JSON_ID = "ID";
    String JSON_topic_problem = "topic_problem";
    String JSON_main = "main";
    String JSON_gory = "gory";
    String JSON_ProblemDetail = "ProblemDetail";
    String JSON_Image_Name = "Image_Name";
    String JSON_countImage = "countImage";

    String id_problem="";
    StringBuilder stringBuilder,stringBuilder2,stringBuilder3,stringBuilder4;
    String DADA,DADA2,DADA3;
    StringBuilder kaka;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    JsonArrayRequest jsonArrayRequest ;
    RequestQueue requestQueue ;
    RelativeLayout relativeLayout;
    SwipeRefreshLayout swipeRefreshLayout;
    FloatingActionButton floatingActionButton;
    Intent intent;
    List<GetData_sale_information> GetDataAdapter2;
    String contno="";
    int position_recycle_view=0;
    private static final String TAG = MainActivity.class.getSimpleName();
    List<GetData_uploade_Image> getData_uploade_images;
    List<GetData_cedit_remove_image_select_id> remove_image_select_id;
    String PATH;
    String conno="";
    Uri fileUri;
    ImageConfiguration ic;
    Intent CamIntent,CropIntent;
    File file;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardview_row_sale_edit_problem);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        GetDataAdapter1 = new ArrayList<>();
        getData_uploade_images = new ArrayList<>();
        remove_image_select_id= new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);
        relativeLayout= (RelativeLayout) findViewById(R.id.relativeLayout);
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_refresh_layout);
        floatingActionButton= (FloatingActionButton) findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(this);

        relativeLayout.setVisibility(View.GONE);
       // floatingActionButton.setOnClickListener(this);

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
        if(data!=null) {
            // from=data.getString("from");
            conno = data.getString("Contno");

        }



        recyclerView.setHasFixedSize(true);

        recyclerViewlayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(recyclerViewlayoutManager);

        JSON_DATA_WEB_CALL();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                GetDataAdapter1.clear();
                JSON_DATA_WEB_CALL();
                swipeRefreshLayout.setRefreshing(false);
            }
        });


    }



    public void SQLiteDataBaseBuild(){

        sqLiteDatabase = this.openOrCreateDatabase(SQLiteHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    public void SQLiteTableBuild(){

        //sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper.TABLE_NAME+"("+ SQLiteHelper.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+SQLiteHelper.Table_Column_1_Subject_Name+" VARCHAR, "+SQLiteHelper.Table_Column_2_SubjectFullForm+" VARCHAR, "+SQLiteHelper.Table_Column_3_subteamcode+" VARCHAR, "+SQLiteHelper.Table_Column_5_contract_number+" VARCHAR, "+SQLiteHelper.Table_Column_6_contract_number2+" VARCHAR, "+SQLiteHelper.Table_Column_7_name_topic+" VARCHAR, "+SQLiteHelper.Table_Column_8_customer+" VARCHAR, "+SQLiteHelper.Table_Column_9_description+" VARCHAR, "+SQLiteHelper.Table_Column_16_status+" VARCHAR, "+SQLiteHelper.Table_Column_15_date_time+" VARCHAR, "+SQLiteHelper.Table_Column_23_date_time_update+" VARCHAR, "+SQLiteHelper.Table_Column_10_approveStatus+" VARCHAR, "+SQLiteHelper.Table_Column_11_approveBy+" VARCHAR, "+SQLiteHelper.Table_Column_12_approveDate+" VARCHAR, "+SQLiteHelper.Table_Column_17_isremark+" VARCHAR, "+SQLiteHelper.Table_Column_14_isremark1+" VARCHAR, "+SQLiteHelper.Table_Column_20_check_foller+" VARCHAR, "+SQLiteHelper.Table_Column_21_countfoller+" VARCHAR, "+SQLiteHelper.Table_Column_22_countcomment+" VARCHAR, "+SQLiteHelper.Table_Column_4_picture+" VARCHAR);");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper.TABLE_NAME+"("+ SQLiteHelper.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper.Table_contno+" VARCHAR, "+SQLiteHelper.Table_part_id+" VARCHAR, "+SQLiteHelper.Table_part_image+" VARCHAR, "+SQLiteHelper.Table_type_image+" VARCHAR, "+SQLiteHelper.Table_Problem_Type_ID+" VARCHAR, "+SQLiteHelper.Table_Problem_TypeDeteils_ID+" VARCHAR, "+SQLiteHelper.Table_Url+" VARCHAR, "+SQLiteHelper.Table_Image_Name+" VARCHAR, "+SQLiteHelper.Table_Image_Size+" VARCHAR, "+SQLiteHelper.Table_Image_Type+" VARCHAR);");


    }




    public void JSON_DATA_WEB_CALL() {

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL ,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_WEBCALL(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);
        swipeRefreshLayout.setRefreshing(false);
    }



    int idid=0;
    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array) {






        for (int i = 0; i < array.length(); i++) {

            final GetData_cedit_sale_edit_problem GetDataAdapter2 = new GetData_cedit_sale_edit_problem();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);

                GetDataAdapter2.setID(json.getString(JSON_ID));
                GetDataAdapter2.setTopic_problem(json.getString(JSON_topic_problem));
                GetDataAdapter2.setMain(json.getString(JSON_main));
                GetDataAdapter2.setGory(json.getString(JSON_gory));
                GetDataAdapter2.setProblemDetail(json.getString(JSON_ProblemDetail));
                GetDataAdapter2.setImage_Name(json.getString(JSON_Image_Name));
                GetDataAdapter2.setCountImage(json.getString(JSON_countImage));


            } catch (JSONException e) {

                e.printStackTrace();
            }






            GetDataAdapter1.add(GetDataAdapter2);

        }


        recyclerViewadapter1 = new RecyclerViewAdapter_sale_recive_report_problem_edit(GetDataAdapter1,this,this,this);
        recyclerView.setAdapter(recyclerViewadapter1);
        recyclerView.scrollToPosition(position_recycle_view);


      //  recyclerViewadapter1.setitemclick2(this);


    }


    @Override
    public void onClick(View view) {
        if(view==floatingActionButton){
            dialog();
        }
    }

    @Override
    public void click2(View v, int position) {
        getData_cedit_sale_edit_problem = GetDataAdapter1.get(position);
        Intent Intent = new Intent(UI_CARDVIEW_DATA_SALE_EDIT_PROBLEM.this, IMAGE_SALE_RECIVE_EDIT_PROBLEM.class);
        Bundle bun = new Bundle();
        bun.putString("ID", getData_cedit_sale_edit_problem.getID());
        Intent.putExtras(bun);
        startActivityForResult(Intent, 67);
    }

    @Override
    public void click_image_sucess(View v, int position) {

    }

    @Override
    public void click_image_ic_dete1(View v, int position) {

    }

    @Override
    public void click_image_ic_dete2(View v, int position) {

    }

    @Override
    public void click_photograph_image_error(View v, int position) {

    }

    int id_image_success=0;
    @Override
    public void click_photograph_image_success(View v, int position) {
        getData_cedit_sale_edit_problem=GetDataAdapter1.get(position);
        id_image_success= Integer.parseInt(getData_cedit_sale_edit_problem.getID());

        CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        ic=new ImageConfiguration(this,PATH);
        file=ic.createImageByType_sucess(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                "report_problem",getData_cedit_sale_edit_problem.getID());
        fileUri=Uri.fromFile(file);
        CamIntent.putExtra(MediaStore.EXTRA_OUTPUT,fileUri);
        startActivityForResult(CamIntent,1);
    }

    @Override
    public void onRowLongClicked(int position) {

    }

    @Override
    public void onRowLongClicked2(int position) {

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
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {

            if(resultCode==RESULT_OK) {

                CropImage();
            }
        }
        else if(requestCode == 2){

            File storageDir =  null ;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
                storageDir = this.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("contno_save") + "/"+"report_problem"+ "/"+"ID"+getData_cedit_sale_edit_problem.getID()+ "/"+"image_error"+"/");

            }

            File image[]= storageDir.listFiles();
            int fgf= image.length;
            for(int i=0;i<fgf;i++) {
                String DF = String.valueOf(image[i]);
            }

            try {
                if(fgf>1){
                    recyclerViewadapter1.count_image(fgf,id_image_success);
                    recyclerViewadapter1.notifyDataSetChanged();
                }
                else {

                }

            }
            catch (Exception ex){

            }

            String Problem_Type_ID="01";
            String Problem_TypeDeteils_ID= String.valueOf(id_image_success);
            String Url="http://app.thiensurat.co.th/assanee/uploads_image_report_problem/";
            String image_name=MyApplication.getInstance().getPrefManager().getPreferrence("imageName");
            String FILE=file.getAbsolutePath();
            File file2 = new File(FILE);
            long length = file2.length();
            length = length/1024;



            SQLiteDataBaseBuild();
            SQLiteTableBuild();

            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (contno,part_id,part_image,type_image,Problem_Type_ID,Problem_TypeDeteils_ID,Url,Image_Name,Image_Size,Image_Type) VALUES('" + MyApplication.getInstance().getPrefManager().getPreferrence("getCONTNO") + "','" + id_image_success + "', '" + file.getAbsolutePath() + "', '" + "image_error" + "', '" + Problem_Type_ID + "', '" + Problem_TypeDeteils_ID + "', '" + Url + "', '" + image_name + "', '" + length + "', '" + "jpg" + "');";
            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);



            position_recycle_view=id_image_success;
            GetDataAdapter1.clear();
            JSON_DATA_WEB_CALL();

        }







    }



    private void dialog(){


        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("คุณแน่ใจไหม?")
                .setContentText("ที่ต้องการแจ้งการแก้ไขปัญหานี้แล้ว!")
                .setCancelText("ไม่!")
                .setConfirmText("ใช่!")
                .showCancelButton(true)
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        Log.e("3333","3333");
                        sDialog.cancel();
                    }
                })
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(final SweetAlertDialog sDialog) {
                        Log.e("rrrr", "rrrr");
                        sDialog.cancel();






                        stringBuilder = new StringBuilder();
                        stringBuilder2 = new StringBuilder();
                        stringBuilder3 = new StringBuilder();
                        stringBuilder4 = new StringBuilder();

                        for (GetData_cedit_sale_edit_problem number : GetDataAdapter1) {
                            if (number.isSelected()) {

                                if (stringBuilder.length() > 0)
                                    stringBuilder.append(",");


                                stringBuilder.append(number.getTopic_problem());


                                if (stringBuilder2.length() > 0)
                                    stringBuilder2.append(",");
                                stringBuilder2.append(number.getID());
                                kaka = stringBuilder;

                            }


                            if (number.isSelected()) {

                                if (stringBuilder3.length() > 0)
                                    stringBuilder3.append(",");


                                stringBuilder3.append(number.getTopic_problem());


                                if (stringBuilder4.length() > 0)
                                    stringBuilder4.append(",");
                                stringBuilder4.append(number.getID());

                            }

                        }
                        DADA = stringBuilder2.toString();
                        DADA2 = stringBuilder.toString();
                        DADA3 = stringBuilder3.toString();

                        Log.e("a1", DADA);



                        try {



                                String arr3[];
                                /*
                                SweetAlertDialog pDialogg2 = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
                                pDialogg2.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                                pDialogg2.setTitleText("กำลังอัปโหลด...");
                                pDialogg2.setCancelable(false);
                                pDialogg2.show();

                                   Log.e("55555555555555555","555555");
                                */


                                     arr3= DADA.split(",");
                                    int count=arr3.length;
                                    Log.e("count", String.valueOf(count));
                                    for(int c=0;c<arr3.length;c++) {
                                        id_problem=arr3[c];
                                        Log.e("arr2", arr3[c]);
                                        INSENT_EDIT_PROBLEM();
                                      //  pDialogg2.cancel();
                                    }




                        }
                        catch (Exception ex){


                        }


                    }


                })
                .show();



    }


    String GET_JSON_INSENT_edit_problem="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/sale_problem1_json2_insert_edit_problem.php";
    public   void INSENT_EDIT_PROBLEM(){

        String user_code="A07407";
        String Problem_TypeDeteils_ID=id_problem;
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_INSENT_edit_problem+"?Contno="+conno+"&Problem_TypeDeteils_ID="+Problem_TypeDeteils_ID+"&user_code="+user_code,


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

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);
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


}