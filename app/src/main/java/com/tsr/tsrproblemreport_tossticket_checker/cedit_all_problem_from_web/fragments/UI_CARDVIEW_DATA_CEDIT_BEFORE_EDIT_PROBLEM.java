package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments;


import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Activity_check_problem_by_cedit;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Activity_details_problem_by_all;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.RecyclerViewAdapter_cedit_sent_problem_before_edit;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.databases.SQLiteHelper;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_remove_image_select_id;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_sale_edit_problem;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_sale_information;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_uploade_Image;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.ImageBefore;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.utils.ImageConfiguration;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class UI_CARDVIEW_DATA_CEDIT_BEFORE_EDIT_PROBLEM extends AppCompatActivity implements RecyclerViewAdapter_cedit_sent_problem_before_edit.itemclick2  {



    List<GetData_cedit_sale_edit_problem> GetDataAdapter1;
    List<ImageBefore> imageBeforeList;
    GetData_cedit_sale_edit_problem getData_cedit_sale_edit_problem;
    // String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/sale_problem1_json2_real_from_cedit_edit_problem.php";
    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_problem_id.php";

    RecyclerViewAdapter_cedit_sent_problem_before_edit recyclerViewadapter1;
    String JSON_InformID = "InformID";
    String JSON_Contno = "Contno";
    String JSON_ID = "ID";
    String JSON_topic_problem = "topic_problem";
    String JSON_main = "main";
    String JSON_gory = "gory";
    String JSON_ProblemDetail = "ProblemDetail";
    String JSON_Image_Name = "Image_Name";
    String JSON_WorkCode = "WorkCode";
    String JSON_WorkName = "WorkName";
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
        imageBeforeList = new ArrayList<>();
        getData_uploade_images = new ArrayList<>();
        remove_image_select_id= new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);
        relativeLayout= (RelativeLayout) findViewById(R.id.relativeLayout);
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_refresh_layout);
        floatingActionButton= (FloatingActionButton) findViewById(R.id.fab);



        relativeLayout.setVisibility(View.GONE);
        // floatingActionButton.setOnClickListener(this);


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
                recyclerView.setHasFixedSize(true);

                recyclerViewlayoutManager = new LinearLayoutManager(UI_CARDVIEW_DATA_CEDIT_BEFORE_EDIT_PROBLEM.this);

                recyclerView.setLayoutManager(recyclerViewlayoutManager);

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
        String user_code= MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

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
                GetDataAdapter2.setInformID(json.getString(JSON_InformID));
                GetDataAdapter2.setContno(json.getString(JSON_Contno));
                GetDataAdapter2.setID(json.getString(JSON_ID));
                GetDataAdapter2.setTopic_problem(json.getString(JSON_topic_problem));
                GetDataAdapter2.setMain(json.getString(JSON_main));
                GetDataAdapter2.setGory(json.getString(JSON_gory));
                GetDataAdapter2.setProblemDetail(json.getString(JSON_ProblemDetail));
                GetDataAdapter2.setImage_Name(json.getString(JSON_Image_Name));

                GetDataAdapter2.setWorkCode(json.getString(JSON_WorkCode));
                GetDataAdapter2.setWorkName(json.getString(JSON_WorkName));

                GetDataAdapter2.setCountImage(json.getString(JSON_countImage));


            } catch (JSONException e) {

                e.printStackTrace();
            }






            GetDataAdapter1.add(GetDataAdapter2);

        }


        recyclerViewadapter1 = new RecyclerViewAdapter_cedit_sent_problem_before_edit(GetDataAdapter1,this);
        recyclerView.setAdapter(recyclerViewadapter1);
        recyclerView.scrollToPosition(position_recycle_view);
        recyclerViewadapter1.setitemclick2(this);

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


    @Override
    public void click2(View v, int position) {

        getData_cedit_sale_edit_problem = GetDataAdapter1.get(position);
        String WorkCode=getData_cedit_sale_edit_problem.getWorkCode();
        if(WorkCode.equals("22")){
            Intent Intent = new Intent(UI_CARDVIEW_DATA_CEDIT_BEFORE_EDIT_PROBLEM.this, Activity_check_problem_by_cedit.class);
            Bundle bun = new Bundle();
            bun.putString("ID", getData_cedit_sale_edit_problem.getID());
            bun.putString("Gory", getData_cedit_sale_edit_problem.getGory());
            bun.putString("Main", getData_cedit_sale_edit_problem.getMain());
            bun.putString("Sub", getData_cedit_sale_edit_problem.getTopic_problem());
            bun.putString("Detail", getData_cedit_sale_edit_problem.getProblemDetail());
            bun.putString("conno", conno);



            Intent.putExtras(bun);
            startActivityForResult(Intent, 23);
        }
        else if(WorkCode.equals("21")){
            Intent Intent = new Intent(UI_CARDVIEW_DATA_CEDIT_BEFORE_EDIT_PROBLEM.this, Activity_details_problem_by_all.class);
            Bundle bun = new Bundle();
            bun.putString("ID", getData_cedit_sale_edit_problem.getID());
            bun.putString("Gory", getData_cedit_sale_edit_problem.getGory());
            bun.putString("Main", getData_cedit_sale_edit_problem.getMain());
            bun.putString("Sub", getData_cedit_sale_edit_problem.getTopic_problem());
            bun.putString("Detail", getData_cedit_sale_edit_problem.getProblemDetail());
            bun.putString("conno", conno);



            Intent.putExtras(bun);
            startActivityForResult(Intent, 23);
        }
        else {

            /*
            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("!ปัญหายังไม่ได้อนุมัติ")
                    .setContentText("รอการอนุมัติก่อน!")

                    .show();
                    */

            Intent Intent = new Intent(UI_CARDVIEW_DATA_CEDIT_BEFORE_EDIT_PROBLEM.this, Activity_details_problem_by_all.class);
            Bundle bun = new Bundle();
            bun.putString("ID", getData_cedit_sale_edit_problem.getID());
            bun.putString("Gory", getData_cedit_sale_edit_problem.getGory());
            bun.putString("Main", getData_cedit_sale_edit_problem.getMain());
            bun.putString("Sub", getData_cedit_sale_edit_problem.getTopic_problem());
            bun.putString("Detail", getData_cedit_sale_edit_problem.getProblemDetail());
            bun.putString("conno", conno);



            Intent.putExtras(bun);
            startActivityForResult(Intent, 23);
        }
    }
}