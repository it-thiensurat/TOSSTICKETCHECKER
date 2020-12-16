package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments;


import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
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
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.RecyclerViewAdapter_cedit_sent_problem_before_edit;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.databases.SQLiteHelper;
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

import static android.app.Activity.RESULT_OK;

public class UI_CARDVIEW_DATA_CEDIT_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT extends Fragment implements RecyclerViewAdapter_cedit_sent_problem_before_edit.itemclick2,RecyclerViewAdapter_cedit_sent_problem_before_edit.itemclick_relat_remove  {



    List<GetData_cedit_sale_edit_problem> GetDataAdapter1;
    List<ImageBefore> imageBeforeList;
    List<ImageAfter> imageAfterList;

    GetData_cedit_sale_edit_problem getData_cedit_sale_edit_problem;
    // String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/sale_problem1_json2_real_from_cedit_edit_problem.php";
//    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/sale_problem1_json2_real_from_cedit_edit_problem2.php";
    //String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/cedit_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check.php";
    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/cedit_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real.php";
    RecyclerViewAdapter_cedit_sent_problem_before_edit recyclerViewadapter1;
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
        imageBeforeList = new ArrayList<>();
        imageAfterList = new ArrayList<>();

        getData_uploade_images = new ArrayList<>();
        remove_image_select_id= new ArrayList<>();

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

       // String user_code= MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        String user_code= MyApplication.getInstance().getPrefManager().getPreferrence("Mcode");
        String PositionName= MyApplication.getInstance().getPrefManager().getPreferrence("PositionName");
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL+"?user_code="+user_code+"&PositionName="+PositionName ,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_WEBCALL(response);
                       // Gson gson = new Gson();
                       // Log.e("imageBeforeList", gson.toJson(response));

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue = Volley.newRequestQueue(getActivity());

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

                /*
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

*/



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


        recyclerViewadapter1 = new RecyclerViewAdapter_cedit_sent_problem_before_edit(GetDataAdapter1,getActivity());
        recyclerView.setAdapter(recyclerViewadapter1);
        recyclerView.scrollToPosition(position_recycle_view);
        recyclerViewadapter1.setitemclick2(this);
        recyclerViewadapter1.setitemclick_relat_remove(this);

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




    RecyclerViewAdapter_cedit_sent_problem_before_edit recyclerViewAdapter_cedit_sent_problem_before_edit;
    public static boolean open_up_down=false;
    @Override
    public void click2(View v, int position) {
        Log.e("position", String.valueOf(position));
        getData_cedit_sale_edit_problem = GetDataAdapter1.get(position);

        String WorkCode=getData_cedit_sale_edit_problem.getWorkCode();



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
        }

/*
        if(!open_up_down){
            Log.e("00","00");
            open_up_down=true;
            recyclerViewAdapter_cedit_sent_problem_before_edit.linear_down_sent_from_cedit.setVisibility(View.VISIBLE);
            recyclerViewAdapter_cedit_sent_problem_before_edit.image_status_sent_from_cedit.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
        }
        else {
            Log.e("11","11");
            open_up_down=false;
            recyclerViewAdapter_cedit_sent_problem_before_edit.linear_down_sent_from_cedit.setVisibility(View.GONE);
            recyclerViewAdapter_cedit_sent_problem_before_edit.image_status_sent_from_cedit.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
        }*/
       /*
            Intent Intent = new Intent(getActivity(), Activity_edit_problem_from_sale.class);
            Bundle bun = new Bundle();
            bun.putString("ID", getData_cedit_sale_edit_problem.getID());
            bun.putString("Gory", getData_cedit_sale_edit_problem.getGory());
            bun.putString("Main", getData_cedit_sale_edit_problem.getMain());
            bun.putString("Sub", getData_cedit_sale_edit_problem.getTopic_problem());
            bun.putString("Detail", getData_cedit_sale_edit_problem.getProblemDetail());
            bun.putString("conno", conno);
            bun.putString("InformID", getData_cedit_sale_edit_problem.getInformID());
            bun.putString("Contno", getData_cedit_sale_edit_problem.getContno());
            bun.putString("WorkCode", getData_cedit_sale_edit_problem.getWorkCode());
            bun.putString("WorkName", getData_cedit_sale_edit_problem.getWorkName());
            Intent.putExtras(bun);
            startActivityForResult(Intent, 23);*/


/*

        */




    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == 23) {

            if (resultCode == RESULT_OK) {
                GetDataAdapter1.clear();
                JSON_DATA_WEB_CALL();
            }
        }
    }


    @Override
    public void click_relat_remove(View v, int position) {
        Log.e("position", String.valueOf(position));

    }
}