package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.MusicActivity_Credit;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Show_dails_all;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.RecyclerViewAdapter_credit_recive_problem_before_edit2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.RecyclerViewAdapter_sale_recive_problem_before_edit;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.databases.SQLiteHelper;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.Details_contno;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_remove_image_select_id;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_sale_edit_problem;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_sale_information;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_uploade_Image;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.ImageAfter;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.ImageBefore;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.utils.ImageConfiguration;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
//import static com.tsr.tsrproblemreport.cedit_all_problem_from_web.adapters.RecyclerViewAdapter_sale_recive_problem_before_edit.linear_down;

public class UI_CARDVIEW_DATA_CREDIT_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT2_in_profile extends Fragment implements RecyclerViewAdapter_credit_recive_problem_before_edit2.itemclick2,RecyclerViewAdapter_credit_recive_problem_before_edit2.itemclick,RecyclerViewAdapter_credit_recive_problem_before_edit2.itemclick_list_item_status_sale  {

    List<GetData_cedit_sale_edit_problem> GetDataAdapter1;
    List<ImageBefore> imageBeforeList;
    List<ImageAfter> imageAfterList;
    List<Details_contno> details_contnos;


    GetData_cedit_sale_edit_problem getData_cedit_sale_edit_problem;
    // String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/sale_problem1_json2_real_from_cedit_edit_problem.php";
//    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/sale_problem1_json2_real_from_cedit_edit_problem2.php";
    //String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/sale_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check.php";
    //String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/sale_problem1_json2_real_from_cedit_edit_problem2_copy_real.php";
    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/cedit_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_in_profile.php";


    RecyclerViewAdapter_credit_recive_problem_before_edit2 recyclerViewadapter1;
    String JSON_InformID = "InformID";
    String JSON_Contno = "Contno";
    String JSON_EmployeeName = "EmployeeName";
    String JSON_PositionName = "PositionName";
    String JSON_picture = "picture";
    String JSON_Informitem = "Informitem";
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


    NestedScrollView nestedScrollview;
     MusicActivity_Credit showHideViewListener;
    private static final int HIDE_THRESHOLD = 90;
    private int scrolledDistance = 0;
    private boolean controlsVisible = true, wait;

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








        recyclerView.setNestedScrollingEnabled(false);
        nestedScrollview.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                Log.e("xa", String.valueOf(scrollX+scrollY+oldScrollX+oldScrollY));
                recyclerViewOnScrollListener.onScrolled(recyclerView, scrollX - oldScrollX, scrollY - oldScrollY);
            }
        });


       // JSON_DATA_WEB_CALL2();
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
        details_contnos = new ArrayList<>();


        recyclerView = (RecyclerView) layoutView.findViewById(R.id.recyclerview1);
        relativeLayout= (RelativeLayout) layoutView.findViewById(R.id.relativeLayout);
        swipeRefreshLayout = (SwipeRefreshLayout)layoutView.findViewById(R.id.swipe_refresh_layout);
        floatingActionButton= (FloatingActionButton) layoutView.findViewById(R.id.fab);

        //nestedScrollview= (NestedScrollView) layoutView.findViewById(R.id.nestedScrollview);



        floatingActionButton.setVisibility(View.GONE);
        relativeLayout.setVisibility(View.GONE);


        return  layoutView;
    }


    private RecyclerView.OnScrollListener recyclerViewOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            Log.e("sss","sss");









            /*

            if (scrolledDistance > HIDE_THRESHOLD && controlsVisible) {
                MusicActivity_Credit showHideViewListener =new MusicActivity_Credit();
                Log.e("4444","4444");
                //showHideViewListener.hideBottomBar();

                slide_down = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_down);
                slide_down.setFillAfter(true);
                slide_down.setDuration(200);
                slide_down.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        bottomBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                bottomBar.startAnimation(slide_down);



                wait = true;
                controlsVisible = false;
                scrolledDistance = 0;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        wait = false;
                    }
                }, 600);







            }
            else if (scrolledDistance < -HIDE_THRESHOLD && !controlsVisible) {
                Log.e("555","555");

               // showHideViewListener.showBottomBar();
                slide_up = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_up);
                slide_up.setFillAfter(true);
                slide_up.setDuration(200);
                bottomBar.setVisibility(View.VISIBLE);
                bottomBar.startAnimation(slide_up);



                wait = true;
                controlsVisible = true;
                scrolledDistance = 0;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        wait = false;
                    }
                }, 600);
            }

            if ((controlsVisible && dy > 0) || (!controlsVisible && dy < 0)) {
                Log.e("ggg","ggg");
                scrolledDistance += dy;
            }


            */













            /*


            if (showHideViewListener != null && !wait) {
                if (scrolledDistance > HIDE_THRESHOLD && controlsVisible) {

                    Log.e("sss","sss");
                    showHideViewListener.hideView();
                    wait = true;
                    controlsVisible = false;
                    scrolledDistance = 0;
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            wait = false;
                        }
                    }, 600);
                } else if (scrolledDistance < -HIDE_THRESHOLD && !controlsVisible) {
                    Log.e("xxx","xxx");

                    showHideViewListener.showView();
                    wait = true;
                    controlsVisible = true;
                    scrolledDistance = 0;
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            wait = false;
                        }
                    }, 600);
                }
                if ((controlsVisible && dy > 0) || (!controlsVisible && dy < 0)) {
                    Log.e("ggg","ggg");
                    scrolledDistance += dy;
                }
            }
            */


        }
    };


    public void SQLiteDataBaseBuild(){

        sqLiteDatabase = this.getActivity().openOrCreateDatabase(SQLiteHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    public void SQLiteTableBuild(){

        //sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper.TABLE_NAME+"("+ SQLiteHelper.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+SQLiteHelper.Table_Column_1_Subject_Name+" VARCHAR, "+SQLiteHelper.Table_Column_2_SubjectFullForm+" VARCHAR, "+SQLiteHelper.Table_Column_3_subteamcode+" VARCHAR, "+SQLiteHelper.Table_Column_5_contract_number+" VARCHAR, "+SQLiteHelper.Table_Column_6_contract_number2+" VARCHAR, "+SQLiteHelper.Table_Column_7_name_topic+" VARCHAR, "+SQLiteHelper.Table_Column_8_customer+" VARCHAR, "+SQLiteHelper.Table_Column_9_description+" VARCHAR, "+SQLiteHelper.Table_Column_16_status+" VARCHAR, "+SQLiteHelper.Table_Column_15_date_time+" VARCHAR, "+SQLiteHelper.Table_Column_23_date_time_update+" VARCHAR, "+SQLiteHelper.Table_Column_10_approveStatus+" VARCHAR, "+SQLiteHelper.Table_Column_11_approveBy+" VARCHAR, "+SQLiteHelper.Table_Column_12_approveDate+" VARCHAR, "+SQLiteHelper.Table_Column_17_isremark+" VARCHAR, "+SQLiteHelper.Table_Column_14_isremark1+" VARCHAR, "+SQLiteHelper.Table_Column_20_check_foller+" VARCHAR, "+SQLiteHelper.Table_Column_21_countfoller+" VARCHAR, "+SQLiteHelper.Table_Column_22_countcomment+" VARCHAR, "+SQLiteHelper.Table_Column_4_picture+" VARCHAR);");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper.TABLE_NAME+"("+ SQLiteHelper.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper.Table_contno+" VARCHAR, "+SQLiteHelper.Table_part_id+" VARCHAR, "+SQLiteHelper.Table_part_image+" VARCHAR, "+SQLiteHelper.Table_type_image+" VARCHAR, "+SQLiteHelper.Table_Problem_Type_ID+" VARCHAR, "+SQLiteHelper.Table_Problem_TypeDeteils_ID+" VARCHAR, "+SQLiteHelper.Table_Url+" VARCHAR, "+SQLiteHelper.Table_Image_Name+" VARCHAR, "+SQLiteHelper.Table_Image_Size+" VARCHAR, "+SQLiteHelper.Table_Image_Type+" VARCHAR);");


    }




    public void JSON_DATA_WEB_CALL() {

        String user_code= MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        //String user_code= MyApplication.getInstance().getPrefManager().getPreferrence("Mcode");
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
                GetDataAdapter2.setInformitem(json.getString(JSON_Informitem));
                GetDataAdapter2.setID(json.getString(JSON_ID));
                GetDataAdapter2.setTopic_problem(json.getString(JSON_topic_problem));
                GetDataAdapter2.setMain(json.getString(JSON_main));
                GetDataAdapter2.setGory(json.getString(JSON_gory));
                GetDataAdapter2.setProblemDetail(json.getString(JSON_ProblemDetail));
                GetDataAdapter2.setProblemDetail2(json.getString(JSON_ProblemDetail2));
                GetDataAdapter2.setImage_Name(json.getString(JSON_Image_Name));
                GetDataAdapter2.setWorkCode(json.getString(JSON_WorkCode));
                GetDataAdapter2.setWorkName(json.getString(JSON_WorkName));
                GetDataAdapter2.setDate_create(json.getJSONObject("date_create").getString("date"));
                GetDataAdapter2.setCountImage(json.getString(JSON_countImage));
                GetDataAdapter2.setImage_Name_R(json.getString(JSON_Image_Name_R));
                GetDataAdapter2.setCountImage_R(json.getString(JSON_countImage_R));
                GetDataAdapter2.setImageUrl(json.getString(JSON_ImageUrl));
                GetDataAdapter2.setImageUrl_R(json.getString(JSON_ImageUrl_R));
                GetDataAdapter2.setItems_R(json.getString(JSON_Items_R));
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






                JSONArray array4 = json.getJSONArray("details");
                JSONObject object4 = null;
                Details_contno details_contno;
                details_contnos = new ArrayList<Details_contno>();
Log.e("array4", String.valueOf(array4.length()));
                for (int i2 = 0; i2 < array4.length(); i2++) {
                    details_contno =new Details_contno() ;
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

               // GetDataAdapter2.setDetails_contnos(details_contnos);






            } catch (JSONException e) {

                e.printStackTrace();
            }






            GetDataAdapter1.add(GetDataAdapter2);

        }


        recyclerViewadapter1 = new RecyclerViewAdapter_credit_recive_problem_before_edit2(GetDataAdapter1,getActivity());
        recyclerView.setAdapter(recyclerViewadapter1);
        recyclerView.scrollToPosition(position_recycle_view);
        recyclerViewadapter1.setitemclick2(this);
        recyclerViewadapter1.setitemclick(this);
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


   public static boolean open_up_down=false;
    RecyclerViewAdapter_sale_recive_problem_before_edit recyclerViewAdapter_sale_recive_problem_before_edit;
    @Override
    public void click2(View v, int position) {

        Log.e("position", String.valueOf(position));

        // linear_down.setVisibility(View.GONE);

        getData_cedit_sale_edit_problem = GetDataAdapter1.get(position);

        String WorkCode=getData_cedit_sale_edit_problem.getWorkCode();
        String ResponStatus=getData_cedit_sale_edit_problem.getResponStatus();
        Log.e("position", String.valueOf(position));
        Log.e("ResponStatus",ResponStatus+WorkCode);




            LinearLayout linearLayout =(LinearLayout)v.findViewById(R.id.linear_down);
            ImageView image_status =(ImageView)v.findViewById(R.id.image_status);
        if (!open_up_down) {
            Log.e("00", "00");
            open_up_down = true;


            linearLayout.setVisibility(View.VISIBLE);
            image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);

        } else {
            Log.e("11", "11");
            open_up_down = false;
            linearLayout.setVisibility(View.GONE);
            image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);

        }//






    }

    @Override
    public void onStop() {
        super.onStop();
        recyclerView.removeOnScrollListener(recyclerViewOnScrollListener);

Log.e("onStop","onStop");


/*
        // hide buttom menu
        slide_down = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_down);
        slide_down.setFillAfter(true);
        slide_down.setDuration(200);
        slide_down.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) { }
            @Override
            public void onAnimationEnd(Animation animation) { bottomBar.setVisibility(View.GONE); }
            @Override
            public void onAnimationRepeat(Animation animation) { }
        });
        bottomBar.startAnimation(slide_down);
        wait = true;
        controlsVisible = false;
        scrolledDistance = 0;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                wait = false;
            }
        }, 600);

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
    @Override
    public void click_list_item_status_sale(View v, int position) {


        Intent Intent = new Intent(getActivity(), Show_dails_all.class);
        Bundle bun = new Bundle();
        bun.putString("contno", getData_cedit_sale_edit_problem.getContno());
        Intent.putExtras(bun);
        startActivityForResult(Intent, 55);

    }
    @Override
    public void click(View v, int position) {
        getData_cedit_sale_edit_problem = GetDataAdapter1.get(position);

        final CharSequence[] items = {"ข้อมูลเพิ่มเติ่ม", "บันทึกไว้", "แสดงความคิดเห็น", "ติดตาม", "ปิด"};

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
                else if(item==2){

                }
                else if(item==3){

                }
                else if(item==4){
                    dialog.cancel();
                }
                // Log.e("item", String.valueOf(item));

            }
        });
        builder.show();


        /*

         */
    }
}