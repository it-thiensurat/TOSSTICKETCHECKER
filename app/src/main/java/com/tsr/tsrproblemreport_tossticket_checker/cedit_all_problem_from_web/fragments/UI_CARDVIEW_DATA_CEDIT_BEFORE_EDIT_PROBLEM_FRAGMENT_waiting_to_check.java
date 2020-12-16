package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Activity_check_problem_by_cedit;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Show_dails_all;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.RecyclerViewAdapter_cedit_recive_problem_before_edit_fragment_waiting_to_check;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.databases.SQLiteHelper;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_remove_image_select_id;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_sale_edit_problem;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_sale_information;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_uploade_Image;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.ImageAfter;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.ImageBefore;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.utils.ImageConfiguration;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.CircleTransform;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;
import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltipUtils;


public class UI_CARDVIEW_DATA_CEDIT_BEFORE_EDIT_PROBLEM_FRAGMENT_waiting_to_check extends Fragment implements RecyclerViewAdapter_cedit_recive_problem_before_edit_fragment_waiting_to_check.itemclick2,RecyclerViewAdapter_cedit_recive_problem_before_edit_fragment_waiting_to_check.itemclick,RecyclerViewAdapter_cedit_recive_problem_before_edit_fragment_waiting_to_check.itemclick_list_item_status_sale  {



    List<GetData_cedit_sale_edit_problem> GetDataAdapter1;
    List<ImageBefore> imageBeforeList;
    List<ImageAfter> imageAfterList;
    GetData_cedit_sale_edit_problem getData_cedit_sale_edit_problem;
    // String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/sale_problem1_json2_real_from_cedit_edit_problem.php";
//    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/sale_problem1_json2_real_from_cedit_edit_problem2.php";
   // String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/cedit_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_check.php";
    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/cedit_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_check_real.php";
    RecyclerViewAdapter_cedit_recive_problem_before_edit_fragment_waiting_to_check recyclerViewadapter1;
    String JSON_InformID = "InformID";
    String JSON_Contno = "Contno";
    String JSON_EmployeeName = "EmployeeName";
    String JSON_PositionName = "PositionName";
    String JSON_picture = "picture";
    String JSON_ID = "ID";
    String JSON_topic_problem = "topic_problem";
    String JSON_main = "main";
    String JSON_gory = "gory";
    String JSON_ProblemDetail = "ProblemDetail";
    String JSON_ProblemDetail2 = "ProblemDetail2";
    String JSON_Image_Name = "Image_Name";
    String JSON_WorkCode = "WorkCode";
    String JSON_WorkName = "WorkName";
    String JSON_countImage = "countImage";
    String JSON_Image_Name_R = "Image_Name_R";
    String JSON_countImage_R = "countImage_R";
    String JSON_ImageUrl = "ImageUrl";
    String JSON_ImageUrl_R = "ImageUrl_R";
    String JSON_Items_R = "Items_R";
    String JSON_user_code="user_code";

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

    String conno="";
    Uri fileUri;
    ImageConfiguration ic;
    Intent CamIntent,CropIntent;
    File file;
    SQLiteDatabase sqLiteDatabase;

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        Bundle data=getActivity().getIntent().getExtras();
        if(data!=null) {
            // from=data.getString("from");
            conno = data.getString("Contno");

        }



        recyclerView.setHasFixedSize(true);

        recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(recyclerViewlayoutManager);



        JSON_DATA_WEB_CALL();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                recyclerView.setHasFixedSize(true);

                recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

                recyclerView.setLayoutManager(recyclerViewlayoutManager);

                GetDataAdapter1.clear();
                JSON_DATA_WEB_CALL();
                swipeRefreshLayout.setRefreshing(false);
            }
        });



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View layoutView = inflater.inflate(R.layout.cardview_row_sale_edit_problem, container, false);


        GetDataAdapter1 = new ArrayList<>();
        getData_uploade_images = new ArrayList<>();
        remove_image_select_id= new ArrayList<>();
        imageBeforeList = new ArrayList<>();
        imageAfterList = new ArrayList<>();



        recyclerView = (RecyclerView) layoutView.findViewById(R.id.recyclerview1);
        relativeLayout= (RelativeLayout) layoutView.findViewById(R.id.relativeLayout);
        swipeRefreshLayout = (SwipeRefreshLayout)layoutView.findViewById(R.id.swipe_refresh_layout);
        floatingActionButton= (FloatingActionButton) layoutView.findViewById(R.id.fab);
        floatingActionButton.setVisibility(View.GONE);
        relativeLayout.setVisibility(View.GONE);

        return  layoutView;
    }





    public void SQLiteDataBaseBuild(){

        sqLiteDatabase = this.getActivity().openOrCreateDatabase(SQLiteHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    public void SQLiteTableBuild(){

        //sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper.TABLE_NAME+"("+ SQLiteHelper.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+SQLiteHelper.Table_Column_1_Subject_Name+" VARCHAR, "+SQLiteHelper.Table_Column_2_SubjectFullForm+" VARCHAR, "+SQLiteHelper.Table_Column_3_subteamcode+" VARCHAR, "+SQLiteHelper.Table_Column_5_contract_number+" VARCHAR, "+SQLiteHelper.Table_Column_6_contract_number2+" VARCHAR, "+SQLiteHelper.Table_Column_7_name_topic+" VARCHAR, "+SQLiteHelper.Table_Column_8_customer+" VARCHAR, "+SQLiteHelper.Table_Column_9_description+" VARCHAR, "+SQLiteHelper.Table_Column_16_status+" VARCHAR, "+SQLiteHelper.Table_Column_15_date_time+" VARCHAR, "+SQLiteHelper.Table_Column_23_date_time_update+" VARCHAR, "+SQLiteHelper.Table_Column_10_approveStatus+" VARCHAR, "+SQLiteHelper.Table_Column_11_approveBy+" VARCHAR, "+SQLiteHelper.Table_Column_12_approveDate+" VARCHAR, "+SQLiteHelper.Table_Column_17_isremark+" VARCHAR, "+SQLiteHelper.Table_Column_14_isremark1+" VARCHAR, "+SQLiteHelper.Table_Column_20_check_foller+" VARCHAR, "+SQLiteHelper.Table_Column_21_countfoller+" VARCHAR, "+SQLiteHelper.Table_Column_22_countcomment+" VARCHAR, "+SQLiteHelper.Table_Column_4_picture+" VARCHAR);");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper.TABLE_NAME+"("+ SQLiteHelper.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper.Table_contno+" VARCHAR, "+SQLiteHelper.Table_part_id+" VARCHAR, "+SQLiteHelper.Table_part_image+" VARCHAR, "+SQLiteHelper.Table_type_image+" VARCHAR, "+SQLiteHelper.Table_Problem_Type_ID+" VARCHAR, "+SQLiteHelper.Table_Problem_TypeDeteils_ID+" VARCHAR, "+SQLiteHelper.Table_Url+" VARCHAR, "+SQLiteHelper.Table_Image_Name+" VARCHAR, "+SQLiteHelper.Table_Image_Size+" VARCHAR, "+SQLiteHelper.Table_Image_Type+" VARCHAR);");


    }




    public void JSON_DATA_WEB_CALL() {

       String user_code= MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
       // String user_code= MyApplication.getInstance().getPrefManager().getPreferrence("Mcode");
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL+"?user_code="+user_code ,

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


        try {
            requestQueue = Volley.newRequestQueue(getActivity());
            requestQueue.add(jsonArrayRequest);
        }
        catch (OutOfMemoryError EX){

        }

        swipeRefreshLayout.setRefreshing(false);
    }



    int idid=0;
    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array) {






        for (int i = 0; i < array.length(); i++) {

            final GetData_cedit_sale_edit_problem GetDataAdapter2 = new GetData_cedit_sale_edit_problem();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);
                GetDataAdapter2.setInformID(json.getString(JSON_InformID));
                GetDataAdapter2.setContno(json.getString(JSON_Contno));
                GetDataAdapter2.setEmployeeName(json.getString(JSON_EmployeeName));
                GetDataAdapter2.setPositionName(json.getString(JSON_PositionName));
                GetDataAdapter2.setPicture(json.getString(JSON_picture));
                GetDataAdapter2.setID(json.getString(JSON_ID));
                GetDataAdapter2.setTopic_problem(json.getString(JSON_topic_problem));
                GetDataAdapter2.setMain(json.getString(JSON_main));
                GetDataAdapter2.setGory(json.getString(JSON_gory));
                GetDataAdapter2.setProblemDetail(json.getString(JSON_ProblemDetail));
                GetDataAdapter2.setProblemDetail2(json.getString(JSON_ProblemDetail2));
                GetDataAdapter2.setImage_Name(json.getString(JSON_Image_Name));
                GetDataAdapter2.setWorkCode(json.getString(JSON_WorkCode));
                GetDataAdapter2.setWorkName(json.getString(JSON_WorkName));

                GetDataAdapter2.setCountImage(json.getString(JSON_countImage));
                GetDataAdapter2.setImage_Name_R(json.getString(JSON_Image_Name_R));
                GetDataAdapter2.setCountImage_R(json.getString(JSON_countImage_R));
                GetDataAdapter2.setImageUrl(json.getString(JSON_ImageUrl));
                GetDataAdapter2.setImageUrl_R(json.getString(JSON_ImageUrl_R));
                GetDataAdapter2.setItems_R(json.getString(JSON_Items_R));
                GetDataAdapter2.setUser_code(json.getString(JSON_user_code));
                GetDataAdapter2.setProblemDetail_sub(json.getString("ProblemDetail_sub"));
                JSONArray array2 = json.getJSONArray("ImageBefore");
                JSONObject object = null;
                ImageBefore imageBefore;
                imageBeforeList = new ArrayList<ImageBefore>();
                //Log.e("array2length", String.valueOf(array2.length()));
                for (int i2 = 0; i2 < array2.length(); i2++) {
                    imageBefore =new ImageBefore() ;
                    object = array2.getJSONObject(i2);
                    String IMAGE= object.getString(String.valueOf((i2+1)));
                    //Log.e("IMAGE",IMAGE);
                    imageBefore.setImageUrl(IMAGE);
                    imageBeforeList.add(imageBefore);
                }

                GetDataAdapter2.setImageBefore(imageBeforeList);





                JSONArray array3 = json.getJSONArray("ImageAfter");
                JSONObject object3 = null;
                ImageAfter imageAfter;
                imageAfterList = new ArrayList<ImageAfter>();

                for (int i2 = 0; i2 < array3.length(); i2++) {
                    imageAfter =new ImageAfter() ;
                    object3 = array3.getJSONObject(i2);
                    String IMAGE= object3.getString(String.valueOf((i2+1)));
                    Log.e("IMAGE",IMAGE);
                    imageAfter.setImageUrl(IMAGE);
                    imageAfterList.add(imageAfter);
                }

                GetDataAdapter2.setImageAfter(imageAfterList);





                /*
                JSONArray array4 = json.getJSONArray("details");
                JSONObject object4 = null;
                // Details_contno details_contno;
                //details_contnos = new ArrayList<Details_contno>();
                Log.e("array4", String.valueOf(array4.length()));
                for (int i2 = 0; i2 < array4.length(); i2++) {
                    // details_contno =new Details_contno() ;
                    object4 = array4.getJSONObject(i2);


                    GetDataAdapter2.setEmployeeName_sale(object4.getString("EmployeeName"));

                    GetDataAdapter2.setPositionName_sale(object4.getString("PositionName"));
                    GetDataAdapter2.setSubTeamName(object4.getString("SubTeamName"));
                    GetDataAdapter2.setSubTeamHeadName(object4.getString("SubTeamHeadName"));
                    GetDataAdapter2.setTeamCode(object4.getString("TeamCode"));
                    GetDataAdapter2.setTeamName(object4.getString("TeamName"));
                    GetDataAdapter2.setTeamHeadName(object4.getString("TeamHeadName"));
                    GetDataAdapter2.setSupervisorName(object4.getString("SupervisorName"));
                    GetDataAdapter2.setSupervisorHeadName(object4.getString("SupervisorHeadName"));
                    GetDataAdapter2.setSubDepartmentName(object4.getString("SubDepartmentName"));
                    GetDataAdapter2.setSubDepartmentHeadName(object4.getString("SubDepartmentHeadName"));
                    GetDataAdapter2.setDepartmentName(object4.getString("DepartmentName"));
                    GetDataAdapter2.setDepartmentHeadName(object4.getString("DepartmentHeadName"));
                    GetDataAdapter2.setPicture_sale(object4.getString("picture"));
                    GetDataAdapter2.setProductName(object4.getString("ProductName"));
                    GetDataAdapter2.setProductPrice(object4.getString("ProductPrice"));
                    GetDataAdapter2.setCustomerName(object4.getString("CustomerName"));

                    GetDataAdapter2.setAddressall(object4.getString("Addressall"));
                    GetDataAdapter2.setLatitude(object4.getString("Latitude"));
                    GetDataAdapter2.setLongitude(object4.getString("Longitude"));
                    GetDataAdapter2.setTelHome(object4.getString("TelHome"));
                    GetDataAdapter2.setTelMobile(object4.getString("TelMobile"));

                    Log.e("EmployeeName",object4.getString("EmployeeName"));
                    Log.e("CustomerName",object4.getString("CustomerName"));


                    //  details_contnos.add(details_contno);
                }

                */




            } catch (JSONException e) {

                e.printStackTrace();
            }






            GetDataAdapter1.add(GetDataAdapter2);

        }


        recyclerViewadapter1 = new RecyclerViewAdapter_cedit_recive_problem_before_edit_fragment_waiting_to_check(GetDataAdapter1,getActivity());
        recyclerView.setAdapter(recyclerViewadapter1);
        recyclerView.scrollToPosition(position_recycle_view);
        recyclerViewadapter1.setitemclick(this);
        recyclerViewadapter1.setitemclick2(this);
        recyclerViewadapter1.setitemclick_list_item_status_sale(this);
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
            getActivity().onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void click2(View v, int position) {

        getData_cedit_sale_edit_problem = GetDataAdapter1.get(position);


        Intent Intent = new Intent(getActivity(), Activity_check_problem_by_cedit.class);
        Bundle bun = new Bundle();
        bun.putString("ID", getData_cedit_sale_edit_problem.getID());
        bun.putString("Gory", getData_cedit_sale_edit_problem.getGory());
        bun.putString("Main", getData_cedit_sale_edit_problem.getMain());
        bun.putString("Sub", getData_cedit_sale_edit_problem.getTopic_problem());
        bun.putString("Detail", getData_cedit_sale_edit_problem.getProblemDetail());
        bun.putString("Detail2", getData_cedit_sale_edit_problem.getProblemDetail2());
        bun.putString("conno", conno);
        bun.putString("InformID", getData_cedit_sale_edit_problem.getInformID());
        bun.putString("Contno", getData_cedit_sale_edit_problem.getContno());
        bun.putString("WorkCode", getData_cedit_sale_edit_problem.getWorkCode());
        bun.putString("WorkName", getData_cedit_sale_edit_problem.getWorkName());
        bun.putString("Items_R", getData_cedit_sale_edit_problem.getItems_R());

        bun.putString("user_code", getData_cedit_sale_edit_problem.getUser_code());
        bun.putString("getPicture", getData_cedit_sale_edit_problem.getPicture());
        bun.putString("getEmployeeName", getData_cedit_sale_edit_problem.getEmployeeName());
        bun.putString("getPositionName", getData_cedit_sale_edit_problem.getPositionName());
        bun.putString("getCountImage", getData_cedit_sale_edit_problem.getCountImage());
        bun.putString("getCountImage_R", getData_cedit_sale_edit_problem.getCountImage_R());
        bun.putString("getImageUrl", getData_cedit_sale_edit_problem.getImageUrl());
        bun.putString("getImageUrl_R", getData_cedit_sale_edit_problem.getImageUrl_R());

        Intent.putExtras(bun);
        startActivityForResult(Intent, 23);


    }


    String GET_JSON_DATA_HTTP_URL2="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/detalis_all_from_contno.php";
    String conno_aa="";
    SweetAlertDialog pDialog;
    View e;
    @Override
    public void click_list_item_status_sale(View v, int position) {

        e=v;
        getData_cedit_sale_edit_problem = GetDataAdapter1.get(position);
        conno_aa=getData_cedit_sale_edit_problem.getContno();
        Log.e("conno_aa",conno_aa);



        pDialog = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading");
        pDialog.setCancelable(true);
        pDialog.show();
        JSON_DATA_WEB_CALL2();


        /*
        Intent Intent = new Intent(getActivity(), Show_dails_all.class);
        Bundle bun = new Bundle();
        bun.putString("contno", getData_cedit_sale_edit_problem.getContno());
        Intent.putExtras(bun);
        startActivityForResult(Intent, 55);*/

    }

    @Override
    public void click(View v, int position) {
        getData_cedit_sale_edit_problem = GetDataAdapter1.get(position);

        final CharSequence[] items = {"ข้อมูลเพิ่มเติ่ม", "ตรวจสอบปัญหา", "บันทึกไว้", "แสดงความคิดเห็น", "ติดตาม", "ปิด"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);
        builder.setTitle("เลขที่การแจ้ง : "+getData_cedit_sale_edit_problem.getInformID()+", เลขที่สัญญา : "+getData_cedit_sale_edit_problem.getContno());
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {

                if(item==0){
                    Intent Intent = new Intent(getActivity(), Show_dails_all.class);
                    Bundle bun = new Bundle();
                    bun.putString("contno", getData_cedit_sale_edit_problem.getContno());
                    Intent.putExtras(bun);
                    startActivityForResult(Intent, 55);
                }
                else if(item==1){

                    Intent Intent = new Intent(getActivity(), Activity_check_problem_by_cedit.class);
                    Bundle bun = new Bundle();
                    bun.putString("ID", getData_cedit_sale_edit_problem.getID());
                    bun.putString("Gory", getData_cedit_sale_edit_problem.getGory());
                    bun.putString("Main", getData_cedit_sale_edit_problem.getMain());
                    bun.putString("Sub", getData_cedit_sale_edit_problem.getTopic_problem());
                    bun.putString("Detail", getData_cedit_sale_edit_problem.getProblemDetail());
                    bun.putString("Detail2", getData_cedit_sale_edit_problem.getProblemDetail2());
                    bun.putString("conno", conno);
                    bun.putString("InformID", getData_cedit_sale_edit_problem.getInformID());
                    bun.putString("Contno", getData_cedit_sale_edit_problem.getContno());
                    bun.putString("WorkCode", getData_cedit_sale_edit_problem.getWorkCode());
                    bun.putString("WorkName", getData_cedit_sale_edit_problem.getWorkName());
                    bun.putString("Items_R", getData_cedit_sale_edit_problem.getItems_R());

                    bun.putString("user_code", getData_cedit_sale_edit_problem.getUser_code());
                    bun.putString("getPicture", getData_cedit_sale_edit_problem.getPicture());
                    bun.putString("getEmployeeName", getData_cedit_sale_edit_problem.getEmployeeName());
                    bun.putString("getPositionName", getData_cedit_sale_edit_problem.getPositionName());
                    bun.putString("getCountImage", getData_cedit_sale_edit_problem.getCountImage());
                    bun.putString("getCountImage_R", getData_cedit_sale_edit_problem.getCountImage_R());
                    bun.putString("getImageUrl", getData_cedit_sale_edit_problem.getImageUrl());
                    bun.putString("getImageUrl_R", getData_cedit_sale_edit_problem.getImageUrl_R());

                    Intent.putExtras(bun);
                    startActivityForResult(Intent, 23);

                }

                else if(item==3){

                }
                else if(item==4){

                }
                else if(item==5){
                    dialog.cancel();
                }
                // Log.e("item", String.valueOf(item));

            }
        });
        builder.show();


        /*

         */
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == 23) {

            //if (resultCode == RESULT_OK) {
                GetDataAdapter1.clear();
                JSON_DATA_WEB_CALL();
          //  }
        }
    }





    public void JSON_DATA_WEB_CALL2() {

        Log.e("gggg",GET_JSON_DATA_HTTP_URL2+"?contno="+conno_aa);
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL2+"?contno="+conno_aa ,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {



                        JSON_PARSE_DATA_AFTER_WEBCALL2(response);
                        //   pDialog2.dismissWithAnimation();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        JSON_DATA_WEB_CALL2();
                    }
                });

        requestQueue = Volley.newRequestQueue(getActivity());

        requestQueue.add(jsonArrayRequest);

    }


    GetData_cedit_sale_edit_problem  GetDataAdapter3;
    public void JSON_PARSE_DATA_AFTER_WEBCALL2(JSONArray array) {

        // if(array.length()==0){
        //    pDialog2.dismissWithAnimation();
        // }


        for (int i = 0; i < array.length(); i++) {

            GetDataAdapter3 = new GetData_cedit_sale_edit_problem();

            JSONObject json = null;

            try {

                json = array.getJSONObject(i);

                GetDataAdapter3.setEmployeeName_sale(json.getString("EmployeeName"));
                GetDataAdapter3.setPositionName_sale(json.getString("PositionName"));

                GetDataAdapter3.setSubTeamName(json.getString("SubTeamName"));
                GetDataAdapter3.setSubTeamHeadName(json.getString("SubTeamHeadName"));
                GetDataAdapter3.setTeamCode(json.getString("TeamCode"));
                GetDataAdapter3.setTeamName(json.getString("TeamName"));
                GetDataAdapter3.setTeamHeadName(json.getString("TeamHeadName"));


                GetDataAdapter3.setSupervisorName(json.getString("SupervisorName"));
                GetDataAdapter3.setSupervisorHeadName(json.getString("SupervisorHeadName"));

                GetDataAdapter3.setSubDepartmentName(json.getString("SubDepartmentName"));
                GetDataAdapter3.setSubDepartmentHeadName(json.getString("SubDepartmentHeadName"));

                GetDataAdapter3.setDepartmentName(json.getString("DepartmentName"));
                GetDataAdapter3.setDepartmentHeadName(json.getString("DepartmentHeadName"));

                GetDataAdapter3.setPicture_sale(json.getString("picture"));
                GetDataAdapter3.setProductName(json.getString("ProductName"));
                GetDataAdapter3.setProductPrice(json.getString("ProductPrice"));
                GetDataAdapter3.setCustomerName(json.getString("CustomerName"));

                GetDataAdapter3.setAddressall(json.getString("Addressall"));
                GetDataAdapter3.setLatitude(json.getString("Latitude"));
                GetDataAdapter3.setLongitude(json.getString("Longitude"));
                GetDataAdapter3.setTelHome(json.getString("TelHome"));
                GetDataAdapter3.setTelMobile(json.getString("TelMobile"));



                GetDataAdapter3.setSaleStatus(json.getString("SaleStatus"));
                GetDataAdapter3.setTeamSaleStatus(json.getString("TeamSaleStatus"));
                GetDataAdapter3.setSupSaleStatus(json.getString("SupSaleStatus"));
                GetDataAdapter3.setSecSaleStatus(json.getString("SecSaleStatus"));
                GetDataAdapter3.setMngSaleStatus(json.getString("MngSaleStatus"));

                GetDataAdapter3.setTeamSaleEmp_picture(json.getString("TeamSaleEmp_picture"));
                GetDataAdapter3.setSupSaleEmp_picture(json.getString("SupSaleEmp_picture"));
                GetDataAdapter3.setSecSaleEmp_picture(json.getString("SecSaleEmp_picture"));
                GetDataAdapter3.setMngSaleEmp_picture(json.getString("MngSaleEmp_picture"));

                GetDataAdapter3.setOutstanding(json.getString("Outstanding"));
                GetDataAdapter3.setCustomerStatus(json.getString("CustomerStatus"));
                GetDataAdapter3.setAccountStatus(json.getString("AccountStatus"));
                GetDataAdapter3.setPayLastPeriod(json.getString("PayLastPeriod"));
            } catch (JSONException e) {

                e.printStackTrace();
            }
        }


        pDialog.dismissWithAnimation();






        final SimpleTooltip tooltip = new SimpleTooltip.Builder(getActivity())
                .anchorView(e)
                .text("ddddddddd")
                .gravity(Gravity.BOTTOM)
                //.dismissOnOutsideTouch(true)
                //.dismissOnInsideTouch(true)
                .modal(true)
                .animated(true)
                .animationDuration(2000)
                .animationPadding(SimpleTooltipUtils.pxFromDp(20))
                //.padding(SimpleTooltipUtils.pxFromDp(50))

                .contentView(R.layout.custom_popup3, R.id.txt_namesale)
                //.focusable(true)
                // .maxWidth(SimpleTooltipUtils.pxFromDp(10))
                .build();
        //pDialog.dismissWithAnimation();

        final ImageView handle0= (ImageView)tooltip.findViewById(R.id.handle0);
        final TextView txt_namesale0= (TextView)tooltip.findViewById(R.id.txt_namesale0);
        final TextView txt_position0= (TextView)tooltip.findViewById(R.id.txt_position0);




        final TextView txt_teamcode= (TextView) tooltip.findViewById(R.id.txt_teamcode);
        final TextView txt_boss= (TextView) tooltip.findViewById(R.id.txt_boss);
        final TextView  txt_bossposition= (TextView) tooltip.findViewById(R.id.txt_bossposition);
        final TextView txt_ProductName= (TextView) tooltip.findViewById(R.id.txt_ProductName);
        final TextView txt_ProductPrice= (TextView) tooltip.findViewById(R.id.txt_ProductPrice);
        final TextView  txt_CustomerName= (TextView) tooltip.findViewById(R.id.txt_CustomerName);
        final TextView txt_Addressall= (TextView) tooltip.findViewById(R.id.txt_Addressall);

        final TextView txt_Outstanding= (TextView) tooltip.findViewById(R.id.txt_Outstanding);
        final TextView txt_CustomerStatus= (TextView) tooltip.findViewById(R.id.txt_CustomerStatus);
        final TextView txt_AccountStatus= (TextView) tooltip.findViewById(R.id.txt_AccountStatus);
        final TextView txt_PayLastPeriod= (TextView) tooltip.findViewById(R.id.txt_PayLastPeriod);




        final ImageView handle= (ImageView) tooltip.findViewById(R.id.handle);
        final ImageView handle2= (ImageView) tooltip.findViewById(R.id.handle2);
        final ImageView handle3= (ImageView) tooltip.findViewById(R.id.handle3);
        final ImageView handle4= (ImageView) tooltip.findViewById(R.id.handle4);
        final ImageView handle5= (ImageView) tooltip.findViewById(R.id.handle5);

        final TextView txt_namesale= (TextView) tooltip.findViewById(R.id.txt_namesale);
        final TextView txt_namesale2= (TextView) tooltip.findViewById(R.id.txt_namesale2);
        final TextView txt_namesale3= (TextView) tooltip.findViewById(R.id.txt_namesale3);
        final TextView txt_namesale4= (TextView) tooltip.findViewById(R.id.txt_namesale4);
        final TextView txt_namesale5= (TextView) tooltip.findViewById(R.id.txt_namesale5);

        final TextView txt_position= (TextView) tooltip.findViewById(R.id.txt_position);
        final TextView txt_position2= (TextView) tooltip.findViewById(R.id.txt_position2);
        final TextView txt_position3= (TextView) tooltip.findViewById(R.id.txt_position3);
        final TextView txt_position4= (TextView) tooltip.findViewById(R.id.txt_position4);
        final TextView txt_position5= (TextView) tooltip.findViewById(R.id.txt_position5);

        final TextView txt_status_name= (TextView) tooltip.findViewById(R.id.txt_status_name);
        final TextView txt_status_name2= (TextView) tooltip.findViewById(R.id.txt_status_name2);
        final TextView txt_status_name3= (TextView) tooltip.findViewById(R.id.txt_status_name3);
        final TextView txt_status_name4= (TextView) tooltip.findViewById(R.id.txt_status_name4);
        final TextView txt_status_name5= (TextView) tooltip.findViewById(R.id.txt_status_name5);



        try {
            Glide.with(this).load(GetDataAdapter3.getPicture_sale())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(getActivity()))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                    .placeholder(this.getResources().getDrawable(R.drawable.dasaa))
                    .into(handle0);
        }
        catch (Exception e) {

        }



        txt_namesale0.setText(GetDataAdapter3.getEmployeeName_sale());
        txt_position0.setText(GetDataAdapter3.getPositionName_sale());

        //txt_namesale.setText(GetDataAdapter3.getEmployeeName_sale());
        //txt_position.setText(GetDataAdapter3.getPositionName_sale());
        txt_teamcode.setText(GetDataAdapter3.getTeamCode());
        txt_boss.setText(GetDataAdapter3.getTeamHeadName());
        txt_bossposition.setText(GetDataAdapter3.getTeamName());
        txt_ProductName.setText(GetDataAdapter3.getProductName());
        txt_ProductPrice.setText(GetDataAdapter3.getProductPrice());
        txt_CustomerName.setText(GetDataAdapter3.getCustomerName());
        txt_Addressall.setText(GetDataAdapter3.getAddressall());

        txt_Outstanding.setText(GetDataAdapter3.getOutstanding());
        txt_CustomerStatus.setText(GetDataAdapter3.getCustomerStatus());
        txt_AccountStatus.setText(GetDataAdapter3.getAccountStatus());
        txt_PayLastPeriod.setText(GetDataAdapter3.getPayLastPeriod());





        try {
            Glide.with(getActivity()).load(GetDataAdapter3.getPicture_sale())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(getActivity()))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                    .placeholder(getActivity().getResources().getDrawable(R.drawable.dasaa))
                    .into(handle);
        }
        catch (Exception e) {

        }



        try {
            Glide.with(getActivity()).load(GetDataAdapter3.getTeamSaleEmp_picture())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(getActivity()))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                    .placeholder(getActivity().getResources().getDrawable(R.drawable.dasaa))
                    .into(handle2);
        }
        catch (Exception e) {

        }



        try {
            Glide.with(getActivity()).load(GetDataAdapter3.getSupSaleEmp_picture())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(getActivity()))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                    .placeholder(getActivity().getResources().getDrawable(R.drawable.dasaa))
                    .into(handle3);
        }
        catch (Exception e) {

        }


        try {
            Glide.with(getActivity()).load(GetDataAdapter3.getSecSaleEmp_picture())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(getActivity()))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                    .placeholder(getActivity().getResources().getDrawable(R.drawable.dasaa))
                    .into(handle4);
        }
        catch (Exception e) {

        }


        try {
            Glide.with(getActivity()).load(GetDataAdapter3.getMngSaleEmp_picture())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(getActivity()))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                    .placeholder(getActivity().getResources().getDrawable(R.drawable.dasaa))
                    .into(handle5);
        }
        catch (Exception e) {

        }




        txt_namesale.setText(GetDataAdapter3.getEmployeeName_sale());

        txt_namesale2.setText(GetDataAdapter3.getTeamHeadName());

        txt_namesale3.setText(GetDataAdapter3.getSupervisorHeadName());
        txt_namesale4.setText(GetDataAdapter3.getSubDepartmentHeadName());
        txt_namesale5.setText(GetDataAdapter3.getDepartmentHeadName());

        txt_position.setText(GetDataAdapter3.getPositionName_sale());

        txt_position2.setText(GetDataAdapter3.getTeamName());

        txt_position3.setText(GetDataAdapter3.getSupervisorName());
        txt_position4.setText(GetDataAdapter3.getSubDepartmentName());
        txt_position5.setText(GetDataAdapter3.getDepartmentName());


        String CHECK_STATUS_SALE1=GetDataAdapter3.getSaleStatus()+"";
        String CHECK_STATUS_SALE2=GetDataAdapter3.getSupSaleStatus()+"";
        String CHECK_STATUS_SALE3=GetDataAdapter3.getSupSaleStatus()+"";
        String CHECK_STATUS_SALE4=GetDataAdapter3.getSecSaleStatus()+"";
        String CHECK_STATUS_SALE5=GetDataAdapter3.getMngSaleStatus()+"";


        if(CHECK_STATUS_SALE1.equals("null")){
            txt_status_name.setText("ยังทำงานอยู่");
            txt_status_name.setBackgroundResource(R.drawable.roun_rect_orange17);
            txt_status_name.setTextColor(0xffffffff);
        }
        else {
            if (CHECK_STATUS_SALE1.equals("N")) {
                txt_status_name.setText("ยังทำงานอยู่");
                txt_status_name.setBackgroundResource(R.drawable.roun_rect_orange17);
                txt_status_name.setTextColor(0xffffffff);

            } else if (CHECK_STATUS_SALE1.equals("P")) {
                txt_status_name.setText("ย้ายตำแหน่ง");
                txt_status_name.setBackgroundResource(R.drawable.roun_rect_orange22);
                txt_status_name.setTextColor(0xffffffff);


            } else {
                txt_status_name.setText("ลาออกแล้ว");
                txt_status_name.setBackgroundResource(R.drawable.roun_rect_orange21);
                txt_status_name.setTextColor(0xffffffff);

            }
        }





        if(CHECK_STATUS_SALE2.equals("null")){
            txt_status_name2.setText("ยังทำงานอยู่");
            txt_status_name2.setBackgroundResource(R.drawable.roun_rect_orange17);
            txt_status_name2.setTextColor(0xffffffff);
        }
        else {
            if (CHECK_STATUS_SALE2.equals("N")) {
                txt_status_name2.setText("ยังทำงานอยู่");
                txt_status_name2.setBackgroundResource(R.drawable.roun_rect_orange17);
                txt_status_name2.setTextColor(0xffffffff);
            } else if (CHECK_STATUS_SALE2.equals("P")) {
                txt_status_name2.setText("ย้ายตำแหน่ง");
                txt_status_name2.setBackgroundResource(R.drawable.roun_rect_orange22);
                txt_status_name2.setTextColor(0xffffffff);

            } else {
                txt_status_name2.setText("ลาออกแล้ว");
                txt_status_name2.setBackgroundResource(R.drawable.roun_rect_orange21);
                txt_status_name2.setTextColor(0xffffffff);

            }
        }





        if(CHECK_STATUS_SALE3.equals("null")){
            txt_status_name3.setText("ยังทำงานอยู่");
            txt_status_name3.setBackgroundResource(R.drawable.roun_rect_orange17);
            txt_status_name3.setTextColor(0xffffffff);
        }
        else {
            if (CHECK_STATUS_SALE3.equals("N")) {
                txt_status_name3.setText("ยังทำงานอยู่");
                txt_status_name3.setBackgroundResource(R.drawable.roun_rect_orange17);
                txt_status_name3.setTextColor(0xffffffff);
            } else if (CHECK_STATUS_SALE3.equals("P")) {
                txt_status_name3.setText("ย้ายตำแหน่ง");
                txt_status_name3.setBackgroundResource(R.drawable.roun_rect_orange22);
                txt_status_name3.setTextColor(0xffffffff);

            } else {
                txt_status_name3.setText("ลาออกแล้ว");
                txt_status_name3.setBackgroundResource(R.drawable.roun_rect_orange21);
                txt_status_name3.setTextColor(0xffffffff);

            }
        }











        if(CHECK_STATUS_SALE4.equals("null")){
            txt_status_name4.setText("ยังทำงานอยู่");
            txt_status_name4.setBackgroundResource(R.drawable.roun_rect_orange17);
            txt_status_name4.setTextColor(0xffffffff);
        }
        else {
            if (CHECK_STATUS_SALE4.equals("N")) {
                txt_status_name4.setText("ยังทำงานอยู่");
                txt_status_name4.setBackgroundResource(R.drawable.roun_rect_orange17);
                txt_status_name4.setTextColor(0xffffffff);
            } else if (CHECK_STATUS_SALE4.equals("P")) {
                txt_status_name4.setText("ย้ายตำแหน่ง");
                txt_status_name4.setBackgroundResource(R.drawable.roun_rect_orange22);
                txt_status_name4.setTextColor(0xffffffff);

            } else {
                txt_status_name4.setText("ลาออกแล้ว");
                txt_status_name4.setBackgroundResource(R.drawable.roun_rect_orange21);
                txt_status_name4.setTextColor(0xffffffff);

            }
        }














        if(CHECK_STATUS_SALE5.equals("null")){
            txt_status_name5.setText("ยังทำงานอยู่");
            txt_status_name5.setBackgroundResource(R.drawable.roun_rect_orange17);
            txt_status_name5.setTextColor(0xffffffff);
        }
        else {
            if (CHECK_STATUS_SALE5.equals("N")) {
                txt_status_name5.setText("ยังทำงานอยู่");
                txt_status_name5.setBackgroundResource(R.drawable.roun_rect_orange17);
                txt_status_name5.setTextColor(0xffffffff);
            } else if (CHECK_STATUS_SALE5.equals("P")) {
                txt_status_name5.setText("ย้ายตำแหน่ง");
                txt_status_name5.setBackgroundResource(R.drawable.roun_rect_orange22);
                txt_status_name5.setTextColor(0xffffffff);

            } else {
                txt_status_name5.setText("ลาออกแล้ว");
                txt_status_name5.setBackgroundResource(R.drawable.roun_rect_orange21);
                txt_status_name5.setTextColor(0xffffffff);

            }
        }


        tooltip.show();


    }


}