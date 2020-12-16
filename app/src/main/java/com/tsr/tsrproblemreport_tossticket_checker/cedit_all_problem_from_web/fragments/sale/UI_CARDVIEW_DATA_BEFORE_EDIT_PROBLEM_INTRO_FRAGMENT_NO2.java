package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.sale;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Activity_edit_problem_from_sale;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Activity_edit_problem_from_sale_edit_new;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Show_dails_all;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.UI_CARDVIEW_DATA_SALE_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_ACTIVITY;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.CircleTransform;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;
import com.tsr.tsrproblemreport_tossticket_checker.test.adapters.RecyclerViewDataAdapter;
import com.tsr.tsrproblemreport_tossticket_checker.test.models.Details_contno;
import com.tsr.tsrproblemreport_tossticket_checker.test.models.GetData_cedit_sale_edit_problem;
import com.tsr.tsrproblemreport_tossticket_checker.test.models.ImageAfter;
import com.tsr.tsrproblemreport_tossticket_checker.test.models.ImageBefore;
import com.tsr.tsrproblemreport_tossticket_checker.test.models.SectionDataModel;
import com.tsr.tsrproblemreport_tossticket_checker.test.models.SectionDataModel2;
import com.tsr.tsrproblemreport_tossticket_checker.test.models.SingleItemModel;
import com.tsr.tsrproblemreport_tossticket_checker.test.models.SingleItemModel2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;
import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltipUtils;

import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.MusicActivity_Credit.check_cick;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.MusicActivity_Credit.tooltip;

public class UI_CARDVIEW_DATA_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_NO2 extends Fragment implements RecyclerViewDataAdapter.itemclick,RecyclerViewDataAdapter.itemclick2,RecyclerViewDataAdapter.itemclick_list_item_status_sale,RecyclerViewDataAdapter.itemclick_list_item_history  {

    private Toolbar toolbar;


    ArrayList<SectionDataModel> allSampleData;
    ArrayList<SectionDataModel2> allSampleData2;
    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/line/problem_all/line_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_no_2.php";
    String GET_JSON_DATA_HTTP_URL_date1_to_date2 = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/line/problem_all/line_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_no_date1_to_date2.php";

    JsonArrayRequest jsonArrayRequest ;
    RequestQueue requestQueue ;

    List<GetData_cedit_sale_edit_problem> GetDataAdapter1;
    List<ImageBefore> imageBeforeList;
    List<ImageAfter> imageAfterList;
    List<Details_contno> details_contnos;
    GetData_cedit_sale_edit_problem getData_cedit_sale_edit_problem;
    RecyclerViewDataAdapter recyclerViewDataAdapter;

    String JSON_InformID = "InformID";
    String JSON_ResponStatus= "ResponStatus";

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
    RecyclerView my_recycler_view,my_recycler_view2;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    SwipeRefreshLayout swipeRefreshLayout;
    FloatingActionButton floatingActionButton;
    RelativeLayout relativeLayout;
    public static int item=0;
    SweetAlertDialog pDialog2;
    List<GetData_cedit_sale_edit_problem> getDataAdapter;


    String date_s="",date2_s="";
    TextView date1,date2,counter;
    ImageView search;

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View layoutView = inflater.inflate(R.layout.activity_main_test, container, false);
        setHasOptionsMenu(true);







        my_recycler_view = (RecyclerView) layoutView.findViewById(R.id.my_recycler_view);
        swipeRefreshLayout = (SwipeRefreshLayout)layoutView.findViewById(R.id.swipe_refresh_layout);
        relativeLayout= (RelativeLayout)layoutView.findViewById(R.id.relativeLayout);
        floatingActionButton= (FloatingActionButton) layoutView.findViewById(R.id.fab);
        counter= (TextView) layoutView.findViewById(R.id.counter);
        //nestedScrollview= (NestedScrollView) layoutView.findViewById(R.id.nestedScrollview);

        date1= (TextView) layoutView.findViewById(R.id.date1);
        date2= (TextView) layoutView.findViewById(R.id.date2);
        search= (ImageView) layoutView.findViewById(R.id.search);

        floatingActionButton.setVisibility(View.GONE);
        // relativeLayout.setVisibility(View.GONE);


        allSampleData = new ArrayList<SectionDataModel>();
        allSampleData2 = new ArrayList<SectionDataModel2>();
        GetDataAdapter1 = new ArrayList<>();
        imageBeforeList = new ArrayList<>();
        imageAfterList = new ArrayList<>();
        details_contnos = new ArrayList<>();


        if (toolbar != null) {
//            setSupportActionBar(toolbar);
            //toolbar.setTitle("G PlayStore");

        }







        my_recycler_view.setHasFixedSize(true);
        recyclerViewlayoutManager = new LinearLayoutManager(getActivity());
        my_recycler_view.setLayoutManager(recyclerViewlayoutManager);





        // my_recycler_view.setHasFixedSize(true);
        //RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(GetDataAdapter1,getActivity(), allSampleData,allSampleData2);
        // my_recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        // my_recycler_view.setAdapter(adapter);









        pDialog2 = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
        pDialog2.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog2.setTitleText("Loading");
        pDialog2.setCancelable(true);
        pDialog2.show();

        JSON_DATA_WEB_CALL();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                my_recycler_view.setHasFixedSize(true);
                recyclerViewlayoutManager = new LinearLayoutManager(getActivity());
                my_recycler_view.setLayoutManager(recyclerViewlayoutManager);
                GetDataAdapter1.clear();
                allSampleData.clear();
                allSampleData2.clear();

                pDialog2 = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
                pDialog2.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                pDialog2.setTitleText("Loading");
                pDialog2.setCancelable(true);
                pDialog2.show();


                JSON_DATA_WEB_CALL();
                swipeRefreshLayout.setRefreshing(false);
            }
        });




        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String date = df.format(Calendar.getInstance().getTime());
        date1.setText(date);
        date2.setText(date);
        date_s=date;
        date2_s=date;
        date1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar calendar = Calendar.getInstance();
                int yy = calendar.get(Calendar.YEAR);
                int mm = calendar.get(Calendar.MONTH);
                int dd = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date_s = "";
                        String month_s ="";
                        String dayOfMonth_s ="";
                        if(dayOfMonth<9){
                            dayOfMonth_s="0"+String.valueOf(dayOfMonth);
                        }
                        else {
                            dayOfMonth_s=String.valueOf(dayOfMonth);
                        }
                        if(month<9){
                            month_s="0"+String.valueOf(month+1);
                        }
                        else {
                            month_s=String.valueOf(month+1);
                        }
                        date_s= dayOfMonth_s+"-"+month_s+"-"+String.valueOf(year);




                        date1.setText(date_s);
                    }


                }, yy, mm, dd);
                datePicker.show();



            }
        });

        date2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int yy = calendar.get(Calendar.YEAR);
                int mm = calendar.get(Calendar.MONTH);
                int dd = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date2_s = "";
                        String month_s ="";
                        String dayOfMonth_s ="";
                        if(dayOfMonth<9){
                            dayOfMonth_s="0"+String.valueOf(dayOfMonth);
                        }
                        else {
                            dayOfMonth_s=String.valueOf(dayOfMonth);
                        }
                        if(month<9){
                            month_s="0"+String.valueOf(month+1);
                        }
                        else {
                            month_s=String.valueOf(month+1);
                        }
                        date2_s= dayOfMonth_s+"-"+month_s+"-"+String.valueOf(year);
                        date2.setText(date2_s);
                    }


                }, yy, mm, dd);
                datePicker.show();
            }
        });



        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetDataAdapter1.clear();
                JSON_DATA_WEB_CALL_date_to_date();
            }
        });





        if(checkConnection() == true){
            relativeLayout.setVisibility(View.GONE);
        }
        else {
            relativeLayout.setVisibility(View.VISIBLE);

        }

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.ACTION_SETTINGS);
                startActivityForResult(intent, 11);
            }
        });










        return  layoutView;
    }





    protected boolean checkConnection(){
        boolean re=false;
        try{
            ConnectivityManager conMan = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = conMan.getActiveNetworkInfo();

            final boolean connected = networkInfo != null
                    && networkInfo.isAvailable()
                    && networkInfo.isConnected();

            if ( !connected) {
                re= false;
            }
            else
                re=true;
        }catch(Exception err){}
        return re;
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
                        pDialog2.dismissWithAnimation();
                    }
                });

        try {
            try {
                requestQueue = Volley.newRequestQueue(getActivity());
                requestQueue.add(jsonArrayRequest);

                int MY_SOCKET_TIMEOUT_MS=100000;

                jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(
                        MY_SOCKET_TIMEOUT_MS,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            }
            catch (RuntimeException ex){

            }
        }
        catch (OutOfMemoryError EX){

        }

    }
    public void JSON_DATA_WEB_CALL_date_to_date() {

        String user_code= MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

        // Log.e("user_code",GET_JSON_DATA_HTTP_URL_date1_to_date2+"?user_code="+user_code+"&date1="+date1+"&date2="+date2);
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_date1_to_date2+"?user_code="+user_code+"&date1="+date_s+"&date2="+date2_s ,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {



                        JSON_PARSE_DATA_AFTER_WEBCALL(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pDialog2.dismissWithAnimation();
                        pDialog2 = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
                        pDialog2.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                        pDialog2.setTitleText("Loading");
                        pDialog2.setCancelable(true);
                        pDialog2.show();
                        JSON_DATA_WEB_CALL_date_to_date();
                    }
                });

        try {
            try {
                requestQueue = Volley.newRequestQueue(getActivity());
                requestQueue.add(jsonArrayRequest);

                int MY_SOCKET_TIMEOUT_MS=100000;

                jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(
                        MY_SOCKET_TIMEOUT_MS,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            }
            catch (RuntimeException ex){

            }
        }
        catch (OutOfMemoryError EX){

        }
        swipeRefreshLayout.setRefreshing(false);
    }

    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array) {

        allSampleData.clear();
        allSampleData2.clear();
        for (int i = 0; i < array.length(); i++) {

            SectionDataModel dm = new SectionDataModel();
            dm.setHeaderTitle(" ล่าสุด ");

            SectionDataModel2 dm2 = new SectionDataModel2();
            dm2.setHeaderTitle(" ล่าสุด ");


            final GetData_cedit_sale_edit_problem GetDataAdapter2 = new GetData_cedit_sale_edit_problem();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);
                GetDataAdapter2.setInformID(json.getString(JSON_InformID));
                GetDataAdapter2.setResponStatus(json.getString(JSON_ResponStatus));

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
                GetDataAdapter2.setProblemDetail3(json.getString("ProblemDetail3"));
                GetDataAdapter2.setProblemDetail4(json.getString("ProblemDetail4"));
                GetDataAdapter2.setImage_Name(json.getString(JSON_Image_Name));
                GetDataAdapter2.setWorkCode(json.getString(JSON_WorkCode));
                GetDataAdapter2.setWorkName(json.getString(JSON_WorkName));
                GetDataAdapter2.setDate_create(json.getJSONObject("date_modify").getString("date"));
                GetDataAdapter2.setCountImage(json.getString(JSON_countImage));
                GetDataAdapter2.setImage_Name_R(json.getString(JSON_Image_Name_R));
                GetDataAdapter2.setCountImage_R(json.getString(JSON_countImage_R));
                GetDataAdapter2.setImageUrl(json.getString(JSON_ImageUrl));
                GetDataAdapter2.setImageUrl_R(json.getString(JSON_ImageUrl_R));
                GetDataAdapter2.setItems_R(json.getString(JSON_Items_R));
                GetDataAdapter2.setUser_code(json.getString(JSON_user_code));
                GetDataAdapter2.setProblemDetail_sub(json.getString("ProblemDetail_sub"));
                GetDataAdapter2.setInformitem(json.getString("Informitem"));

                GetDataAdapter2.setCustomer(json.getString("customer"));
                GetDataAdapter2.setTel(json.getString("tel"));
                GetDataAdapter2.setTel2(json.getString("tel2"));
                GetDataAdapter2.setAddress(json.getString("address"));
                GetDataAdapter2.setEffDate(json.getString("EffDate"));

                JSONArray array2 = json.getJSONArray("ImageBefore");
                JSONObject object = null;

                ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
                for (int i2 = 0; i2 < array2.length(); i2++) {

                    object = array2.getJSONObject(i2);
                    String IMAGE = object.getString(String.valueOf((i2+1)));

                    //final SingleItemModel singleItemModel = new SingleItemModel();
                   // singleItemModel.setUrl(IMAGE);
                    singleItem.add(new SingleItemModel("Item " + i2, IMAGE));

                }



                JSONArray array3 = json.getJSONArray("ImageAfter");
                JSONObject object3 = null;
                ArrayList<SingleItemModel2> singleItem2 = new ArrayList<SingleItemModel2>();
                for (int i2 = 0; i2 < array3.length(); i2++) {

                    object3 = array3.getJSONObject(i2);
                    String IMAGE= object3.getString(String.valueOf((i2+1)));
                    //final SingleItemModel singleItemModel = new SingleItemModel();
                   // singleItemModel.setUrl2(IMAGE);
                    singleItem2.add(new SingleItemModel2("Item " + i2,IMAGE));
                }




           /*




                for (int j = 0; j <= 5; j++) {
                    final SingleItemModel singleItemModel = new SingleItemModel();
                    singleItemModel.setUrl("http://app.thiensurat.co.th/assanee/upload/iconprofile/picture1.png");
                    singleItem.add(new SingleItemModel("Item " + j, singleItemModel.getUrl()));
                }*/

                dm.setAllItemsInSection(singleItem);
                allSampleData.add(dm);

                dm2.setAllItemsInSection(singleItem2);
                allSampleData2.add(dm2);





            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter2);












        }



        pDialog2.dismissWithAnimation();
        counter.setText(GetDataAdapter1.size()+"");

        try {
            RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(GetDataAdapter1,getActivity(), allSampleData,allSampleData2);
            my_recycler_view.setAdapter(adapter);

            adapter.setitemclick(this);
            adapter.setitemclick2(this);
            adapter.setitemclick_list_item_status_sale(this);
            adapter.setitemclick_list_item_history(this);
        }
        catch (RuntimeException r){

        }

    }







    public void createDummyData() {
            int ff=item;
        Log.e("ff", String.valueOf(ff));
        for (int i = 1; i <= 5; i++) {

            SectionDataModel dm = new SectionDataModel();

            dm.setHeaderTitle(" ล่าสุด ");

            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
            for (int j = 0; j <= 5; j++) {
                singleItem.add(new SingleItemModel("Item " + j, "http://app.thiensurat.co.th/assanee/upload/iconprofile/picture1.png"));
            }

            dm.setAllItemsInSection(singleItem);

            allSampleData.add(dm);

        }
    }


































    String GET_JSON_DATA_HTTP_URL43="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/avc4.php";
    public void SELECT_SALE_ALL(String Contno) {
        Log.e("url",GET_JSON_DATA_HTTP_URL43+"?contno="+Contno);

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL43+"?contno="+Contno ,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {



                        JSON_PARSE_DATA_AFTER_WEBCALL2(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        SELECT_SALE_ALL(Contno);
                    }
                });

        try {
            try {
                requestQueue = Volley.newRequestQueue(getActivity());
                requestQueue.add(jsonArrayRequest);

                int MY_SOCKET_TIMEOUT_MS=10000;

                jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(
                        MY_SOCKET_TIMEOUT_MS,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            }
            catch (RuntimeException ex){

            }
        }
        catch (OutOfMemoryError EX){

        }

    }



    public void JSON_PARSE_DATA_AFTER_WEBCALL2(JSONArray array) {


        Log.e("dddd","dddd");
        for (int i = 0; i < array.length(); i++) {

            final GetData_cedit_sale_edit_problem GetDataAdapter2 = new GetData_cedit_sale_edit_problem();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);

                Log.e("getEmployeeName_sale",json.getString("EmployeeName"));


            } catch (JSONException e) {

                e.printStackTrace();
            }



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
            getActivity().onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }







    public static boolean open_up_down=false;

    @Override
    public void click2(View v, int position) {

        Log.e("position", String.valueOf(position));

        // linear_down.setVisibility(View.GONE);

        getData_cedit_sale_edit_problem = GetDataAdapter1.get(position);

        String WorkCode=getData_cedit_sale_edit_problem.getWorkCode();
        String ResponStatus=getData_cedit_sale_edit_problem.getResponStatus();
        Log.e("position", String.valueOf(position));
        Log.e("ResponStatus",ResponStatus+WorkCode);

        if(WorkCode.equals("22")){


            if(ResponStatus.equals("1")){
                Intent Intent = new Intent(getActivity(), Activity_edit_problem_from_sale.class);
                Bundle bun = new Bundle();
                bun.putString("ID", getData_cedit_sale_edit_problem.getID());
                bun.putString("Gory", getData_cedit_sale_edit_problem.getGory());
                bun.putString("Main", getData_cedit_sale_edit_problem.getMain());
                bun.putString("Sub", getData_cedit_sale_edit_problem.getTopic_problem());
                bun.putString("Detail", getData_cedit_sale_edit_problem.getProblemDetail());
                bun.putString("conno", getData_cedit_sale_edit_problem.getContno());
                bun.putString("InformID", getData_cedit_sale_edit_problem.getInformID());
                bun.putString("Contno", getData_cedit_sale_edit_problem.getContno());
                bun.putString("WorkCode", getData_cedit_sale_edit_problem.getWorkCode());
                bun.putString("WorkName", getData_cedit_sale_edit_problem.getWorkName());
                bun.putString("date_time", getData_cedit_sale_edit_problem.getDate_create());
                bun.putString("Items_R", getData_cedit_sale_edit_problem.getItems_R());
                bun.putString("user_code", getData_cedit_sale_edit_problem.getUser_code());

                bun.putString("getPicture", getData_cedit_sale_edit_problem.getPicture());
                bun.putString("getEmployeeName", getData_cedit_sale_edit_problem.getEmployeeName());
                bun.putString("getPositionName", getData_cedit_sale_edit_problem.getPositionName());


                bun.putString("getCountImage", getData_cedit_sale_edit_problem.getCountImage());
                bun.putString("getCountImage_R", getData_cedit_sale_edit_problem.getCountImage_R());
                bun.putString("getImageUrl", getData_cedit_sale_edit_problem.getImageUrl());
                bun.putString("getImageUrl_R", getData_cedit_sale_edit_problem.getImageUrl_R());
                bun.putString("new_message_main_S", getData_cedit_sale_edit_problem.getProblemDetail_sub());
                bun.putString("ProblemDetail3", getData_cedit_sale_edit_problem.getProblemDetail3());
                bun.putString("ProblemDetail4", getData_cedit_sale_edit_problem.getProblemDetail4());
                bun.putString("customer", getData_cedit_sale_edit_problem.getCustomer());
                bun.putString("tel", getData_cedit_sale_edit_problem.getTel());
                bun.putString("tel2", getData_cedit_sale_edit_problem.getTel2());
                bun.putString("address", getData_cedit_sale_edit_problem.getAddress());
                bun.putString("EffDate", getData_cedit_sale_edit_problem.getEffDate());
                Intent.putExtras(bun);
                startActivityForResult(Intent, 23);

            }
            else {
                Intent Intent = new Intent(getActivity(), Activity_edit_problem_from_sale_edit_new.class);
                Bundle bun = new Bundle();
                bun.putString("ID", getData_cedit_sale_edit_problem.getID());
                bun.putString("Gory", getData_cedit_sale_edit_problem.getGory());
                bun.putString("Main", getData_cedit_sale_edit_problem.getMain());
                bun.putString("Sub", getData_cedit_sale_edit_problem.getTopic_problem());
                bun.putString("Detail", getData_cedit_sale_edit_problem.getProblemDetail());
                bun.putString("conno", getData_cedit_sale_edit_problem.getContno());
                bun.putString("InformID", getData_cedit_sale_edit_problem.getInformID());
                bun.putString("Contno", getData_cedit_sale_edit_problem.getContno());
                bun.putString("WorkCode", getData_cedit_sale_edit_problem.getWorkCode());
                bun.putString("WorkName", getData_cedit_sale_edit_problem.getWorkName());
                bun.putString("date_time", getData_cedit_sale_edit_problem.getDate_create());
                bun.putString("Items_R", getData_cedit_sale_edit_problem.getItems_R());
                bun.putString("user_code", getData_cedit_sale_edit_problem.getUser_code());
                bun.putString("getPicture", getData_cedit_sale_edit_problem.getPicture());
                bun.putString("getEmployeeName", getData_cedit_sale_edit_problem.getEmployeeName());
                bun.putString("getPositionName", getData_cedit_sale_edit_problem.getPositionName());
                bun.putString("getCountImage", getData_cedit_sale_edit_problem.getCountImage());
                bun.putString("getCountImage_R", getData_cedit_sale_edit_problem.getCountImage_R());
                bun.putString("getImageUrl", getData_cedit_sale_edit_problem.getImageUrl());
                bun.putString("getImageUrl_R", getData_cedit_sale_edit_problem.getImageUrl_R());
                bun.putString("new_message_main_S", getData_cedit_sale_edit_problem.getProblemDetail_sub());
                bun.putString("ProblemDetail3", getData_cedit_sale_edit_problem.getProblemDetail3());
                bun.putString("ProblemDetail4", getData_cedit_sale_edit_problem.getProblemDetail4());
                bun.putString("customer", getData_cedit_sale_edit_problem.getCustomer());
                bun.putString("tel", getData_cedit_sale_edit_problem.getTel());
                bun.putString("tel2", getData_cedit_sale_edit_problem.getTel2());
                bun.putString("address", getData_cedit_sale_edit_problem.getAddress());
                bun.putString("EffDate", getData_cedit_sale_edit_problem.getEffDate());
                Intent.putExtras(bun);
                startActivityForResult(Intent, 23);
            }















        }
        else if(WorkCode.equals("900")){

            Intent Intent = new Intent(getActivity(), Activity_edit_problem_from_sale_edit_new.class);
            Bundle bun = new Bundle();
            bun.putString("ID", getData_cedit_sale_edit_problem.getID());
            bun.putString("Gory", getData_cedit_sale_edit_problem.getGory());
            bun.putString("Main", getData_cedit_sale_edit_problem.getMain());
            bun.putString("Sub", getData_cedit_sale_edit_problem.getTopic_problem());
            bun.putString("Detail", getData_cedit_sale_edit_problem.getProblemDetail());
            bun.putString("conno", getData_cedit_sale_edit_problem.getContno());
            bun.putString("InformID", getData_cedit_sale_edit_problem.getInformID());
            bun.putString("Contno", getData_cedit_sale_edit_problem.getContno());
            bun.putString("WorkCode", getData_cedit_sale_edit_problem.getWorkCode());
            bun.putString("WorkName", getData_cedit_sale_edit_problem.getWorkName());
            bun.putString("date_time", getData_cedit_sale_edit_problem.getDate_create());
            bun.putString("Items_R", getData_cedit_sale_edit_problem.getItems_R());
            bun.putString("user_code", getData_cedit_sale_edit_problem.getUser_code());
            bun.putString("getPicture", getData_cedit_sale_edit_problem.getPicture());
            bun.putString("getEmployeeName", getData_cedit_sale_edit_problem.getEmployeeName());
            bun.putString("getPositionName", getData_cedit_sale_edit_problem.getPositionName());
            bun.putString("getCountImage", getData_cedit_sale_edit_problem.getCountImage());
            bun.putString("getCountImage_R", getData_cedit_sale_edit_problem.getCountImage_R());
            bun.putString("getImageUrl", getData_cedit_sale_edit_problem.getImageUrl());
            bun.putString("getImageUrl_R", getData_cedit_sale_edit_problem.getImageUrl_R());
            bun.putString("new_message_main_S", getData_cedit_sale_edit_problem.getProblemDetail_sub());
            bun.putString("ProblemDetail3", getData_cedit_sale_edit_problem.getProblemDetail3());
            bun.putString("ProblemDetail4", getData_cedit_sale_edit_problem.getProblemDetail4());
            bun.putString("customer", getData_cedit_sale_edit_problem.getCustomer());
            bun.putString("tel", getData_cedit_sale_edit_problem.getTel());
            bun.putString("tel2", getData_cedit_sale_edit_problem.getTel2());
            bun.putString("address", getData_cedit_sale_edit_problem.getAddress());
            bun.putString("EffDate", getData_cedit_sale_edit_problem.getEffDate());
            Intent.putExtras(bun);
            startActivityForResult(Intent, 23);






        }


        else {





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




    }

    @Override
    public void onStop() {
        super.onStop();

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == 23) {
            try {
                my_recycler_view.setHasFixedSize(true);
                recyclerViewlayoutManager = new LinearLayoutManager(getActivity());
                my_recycler_view.setLayoutManager(recyclerViewlayoutManager);

                GetDataAdapter1.clear();
                allSampleData.clear();
                allSampleData2.clear();
                JSON_DATA_WEB_CALL();
            }
            catch (RuntimeException E){

            }

        }  else if(requestCode==11){

            if(checkConnection() == true){
                relativeLayout.setVisibility(View.GONE);
            }
            else {
                relativeLayout.setVisibility(View.VISIBLE);

            }
        }
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

        SELECT_DATA_CONFIRM2(conno_aa);

        pDialog = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading");
        pDialog.setCancelable(true);
        pDialog.show();
        JSON_DATA_WEB_CALL2();
        check_cick=1;
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

        final CharSequence[] items = {"ข้อมูลเพิ่มเติ่ม", "แก้ไขปัญหา", "บันทึกไว้", "แสดงความคิดเห็น", "ติดตาม", "ปิด"};

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
                    String ResponStatus=getData_cedit_sale_edit_problem.getResponStatus();

                    if(ResponStatus.equals("1")){
                        Intent Intent = new Intent(getActivity(), Activity_edit_problem_from_sale.class);
                        Bundle bun = new Bundle();
                        bun.putString("ID", getData_cedit_sale_edit_problem.getID());
                        bun.putString("Gory", getData_cedit_sale_edit_problem.getGory());
                        bun.putString("Main", getData_cedit_sale_edit_problem.getMain());
                        bun.putString("Sub", getData_cedit_sale_edit_problem.getTopic_problem());
                        bun.putString("Detail", getData_cedit_sale_edit_problem.getProblemDetail());
                        bun.putString("conno", getData_cedit_sale_edit_problem.getContno());
                        bun.putString("InformID", getData_cedit_sale_edit_problem.getInformID());
                        bun.putString("Contno", getData_cedit_sale_edit_problem.getContno());
                        bun.putString("WorkCode", getData_cedit_sale_edit_problem.getWorkCode());
                        bun.putString("WorkName", getData_cedit_sale_edit_problem.getWorkName());
                        bun.putString("date_time", getData_cedit_sale_edit_problem.getDate_create());
                        bun.putString("Items_R", getData_cedit_sale_edit_problem.getItems_R());
                        bun.putString("user_code", getData_cedit_sale_edit_problem.getUser_code());
                        bun.putString("getPicture", getData_cedit_sale_edit_problem.getPicture());
                        bun.putString("getEmployeeName", getData_cedit_sale_edit_problem.getEmployeeName());
                        bun.putString("getPositionName", getData_cedit_sale_edit_problem.getPositionName());
                        bun.putString("getCountImage", getData_cedit_sale_edit_problem.getCountImage());
                        bun.putString("getCountImage_R", getData_cedit_sale_edit_problem.getCountImage_R());
                        bun.putString("getImageUrl", getData_cedit_sale_edit_problem.getImageUrl());
                        bun.putString("getImageUrl_R", getData_cedit_sale_edit_problem.getImageUrl_R());
                        bun.putString("new_message_main_S", getData_cedit_sale_edit_problem.getProblemDetail_sub());
                        bun.putString("ProblemDetail3", getData_cedit_sale_edit_problem.getProblemDetail3());
                        bun.putString("ProblemDetail4", getData_cedit_sale_edit_problem.getProblemDetail4());
                        bun.putString("customer", getData_cedit_sale_edit_problem.getCustomer());
                        bun.putString("tel", getData_cedit_sale_edit_problem.getTel());
                        bun.putString("tel2", getData_cedit_sale_edit_problem.getTel2());
                        bun.putString("address", getData_cedit_sale_edit_problem.getAddress());
                        bun.putString("EffDate", getData_cedit_sale_edit_problem.getEffDate());
                        Intent.putExtras(bun);
                        startActivityForResult(Intent, 23);

                    }
                    else {
                        Intent Intent = new Intent(getActivity(), Activity_edit_problem_from_sale_edit_new.class);
                        Bundle bun = new Bundle();
                        bun.putString("ID", getData_cedit_sale_edit_problem.getID());
                        bun.putString("Gory", getData_cedit_sale_edit_problem.getGory());
                        bun.putString("Main", getData_cedit_sale_edit_problem.getMain());
                        bun.putString("Sub", getData_cedit_sale_edit_problem.getTopic_problem());
                        bun.putString("Detail", getData_cedit_sale_edit_problem.getProblemDetail());
                        bun.putString("conno", getData_cedit_sale_edit_problem.getContno());
                        bun.putString("InformID", getData_cedit_sale_edit_problem.getInformID());
                        bun.putString("Contno", getData_cedit_sale_edit_problem.getContno());
                        bun.putString("WorkCode", getData_cedit_sale_edit_problem.getWorkCode());
                        bun.putString("WorkName", getData_cedit_sale_edit_problem.getWorkName());
                        bun.putString("date_time", getData_cedit_sale_edit_problem.getDate_create());
                        bun.putString("Items_R", getData_cedit_sale_edit_problem.getItems_R());
                        bun.putString("user_code", getData_cedit_sale_edit_problem.getUser_code());
                        bun.putString("getPicture", getData_cedit_sale_edit_problem.getPicture());
                        bun.putString("getEmployeeName", getData_cedit_sale_edit_problem.getEmployeeName());
                        bun.putString("getPositionName", getData_cedit_sale_edit_problem.getPositionName());
                        bun.putString("getCountImage", getData_cedit_sale_edit_problem.getCountImage());
                        bun.putString("getCountImage_R", getData_cedit_sale_edit_problem.getCountImage_R());
                        bun.putString("getImageUrl", getData_cedit_sale_edit_problem.getImageUrl());
                        bun.putString("getImageUrl_R", getData_cedit_sale_edit_problem.getImageUrl_R());
                        bun.putString("new_message_main_S", getData_cedit_sale_edit_problem.getProblemDetail_sub());
                        bun.putString("ProblemDetail3", getData_cedit_sale_edit_problem.getProblemDetail3());
                        bun.putString("ProblemDetail4", getData_cedit_sale_edit_problem.getProblemDetail4());
                        bun.putString("customer", getData_cedit_sale_edit_problem.getCustomer());
                        bun.putString("tel", getData_cedit_sale_edit_problem.getTel());
                        bun.putString("tel2", getData_cedit_sale_edit_problem.getTel2());
                        bun.putString("address", getData_cedit_sale_edit_problem.getAddress());
                        bun.putString("EffDate", getData_cedit_sale_edit_problem.getEffDate());
                        Intent.putExtras(bun);
                        startActivityForResult(Intent, 23);
                    }

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

    }


    public void JSON_DATA_WEB_CALL2() {

        Log.e("gggg",GET_JSON_DATA_HTTP_URL2+"?contno="+conno_aa);
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL2+"?contno="+conno_aa ,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {



                        JSON_PARSE_DATA_AFTER_WEBCALL3(response);
                        //   pDialog2.dismissWithAnimation();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        JSON_DATA_WEB_CALL2();
                    }
                });

        try {
            requestQueue = Volley.newRequestQueue(getActivity());
            requestQueue.add(jsonArrayRequest);
        }
        catch (OutOfMemoryError EX){

        }

    }


    com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_sale_edit_problem GetDataAdapter3;
    public void JSON_PARSE_DATA_AFTER_WEBCALL3(JSONArray array) {

        // if(array.length()==0){
        //    pDialog2.dismissWithAnimation();
        // }


        for (int i = 0; i < array.length(); i++) {

            GetDataAdapter3 = new com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_sale_edit_problem();

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
                GetDataAdapter3.setProductSerial(json.getString("ProductSerial"));
            } catch (JSONException e) {

                e.printStackTrace();
            }
        }


        pDialog.dismissWithAnimation();






        tooltip = new SimpleTooltip.Builder(getActivity())
                .anchorView(e)
                .text("ddddddddd")
                .gravity(Gravity.BOTTOM)
                .dismissOnOutsideTouch(false)
                .dismissOnInsideTouch(false)
                .modal(true)
                .animated(true)
                .animationDuration(2000)
                .animationPadding(SimpleTooltipUtils.pxFromDp(0))
                //.padding(SimpleTooltipUtils.pxFromDp(50))

                .contentView(R.layout.custom_popup3, R.id.txt_namesale)
                //.focusable(true)
                // .maxWidth(SimpleTooltipUtils.pxFromDp(10))

                .build();
        //pDialog.dismissWithAnimation();

        final LinearLayout close= (LinearLayout)tooltip.findViewById(R.id.close);
        final ImageView handle0= (ImageView)tooltip.findViewById(R.id.handle0);
        final TextView txt_namesale0= (TextView)tooltip.findViewById(R.id.txt_namesale0);
        final TextView txt_position0= (TextView)tooltip.findViewById(R.id.txt_position0);




        final TextView txt_teamcode= (TextView) tooltip.findViewById(R.id.txt_teamcode);
        final TextView txt_boss= (TextView) tooltip.findViewById(R.id.txt_boss);
        final TextView  txt_bossposition= (TextView) tooltip.findViewById(R.id.txt_bossposition);
        final TextView txt_product_serial= (TextView) tooltip.findViewById(R.id.txt_product_serial);
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

        final TextView  txt_pay= (TextView) tooltip.findViewById(R.id.txt_pay);
        final TextView   txt_baba= (TextView) tooltip.findViewById(R.id.txt_baba);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tooltip.dismiss();
                check_cick=0;
            }
        });


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
        txt_product_serial.setText(GetDataAdapter3.getProductSerial());
        txt_ProductName.setText(GetDataAdapter3.getProductName());
        txt_ProductPrice.setText(GetDataAdapter3.getProductPrice());
        txt_CustomerName.setText(GetDataAdapter3.getCustomerName());
        txt_Addressall.setText(GetDataAdapter3.getAddressall());

        txt_Outstanding.setText(GetDataAdapter3.getOutstanding());
        txt_CustomerStatus.setText(GetDataAdapter3.getCustomerStatus());
        txt_AccountStatus.setText(GetDataAdapter3.getAccountStatus());
        txt_PayLastPeriod.setText(GetDataAdapter3.getPayLastPeriod());





        try {
            Glide.with(this).load(GetDataAdapter3.getPicture_sale())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(getActivity()))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                    .placeholder(this.getResources().getDrawable(R.drawable.dasaa))
                    .into(handle);
        }
        catch (Exception e) {

        }



        try {
            Glide.with(this).load(GetDataAdapter3.getTeamSaleEmp_picture())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(getActivity()))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                    .placeholder(this.getResources().getDrawable(R.drawable.dasaa))
                    .into(handle2);
        }
        catch (Exception e) {

        }



        try {
            Glide.with(this).load(GetDataAdapter3.getSupSaleEmp_picture())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(getActivity()))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                    .placeholder(this.getResources().getDrawable(R.drawable.dasaa))
                    .into(handle3);
        }
        catch (Exception e) {

        }


        try {
            Glide.with(this).load(GetDataAdapter3.getSecSaleEmp_picture())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(getActivity()))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                    .placeholder(this.getResources().getDrawable(R.drawable.dasaa))
                    .into(handle4);
        }
        catch (Exception e) {

        }


        try {
            Glide.with(this).load(GetDataAdapter3.getMngSaleEmp_picture())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(getActivity()))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                    .placeholder(this.getResources().getDrawable(R.drawable.dasaa))
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
        String CHECK_STATUS_SALE2=GetDataAdapter3.getTeamSaleStatus()+"";
        String CHECK_STATUS_SALE3=GetDataAdapter3.getSupSaleStatus()+"";
        String CHECK_STATUS_SALE4=GetDataAdapter3.getSecSaleStatus()+"";
        String CHECK_STATUS_SALE5=GetDataAdapter3.getMngSaleStatus()+"";


        if(CHECK_STATUS_SALE1.equals("null")){
            txt_status_name.setText("ไม่มี");
            txt_status_name.setBackgroundResource(R.drawable.roun_rect_orange23);
            txt_status_name.setTextColor(0xffffffff);
        }
        else {

            if (CHECK_STATUS_SALE1.equals("D")) {
                txt_status_name.setText("รักษาการ");
                txt_status_name.setBackgroundResource(R.drawable.roun_rect_orange23);
                txt_status_name.setTextColor(0xffffffff);

            }
            else if (CHECK_STATUS_SALE1.equals("G")) {
                txt_status_name.setText("ย้ายออก");
                txt_status_name.setBackgroundResource(R.drawable.roun_rect_orange24);
                txt_status_name.setTextColor(0xffffffff);

            }

            else if (CHECK_STATUS_SALE1.equals("N")) {
                txt_status_name.setText("ปกติ");
                txt_status_name.setBackgroundResource(R.drawable.roun_rect_orange17);
                txt_status_name.setTextColor(0xffffffff);

            } else if (CHECK_STATUS_SALE1.equals("P")) {
                txt_status_name.setText("ย้าย");
                txt_status_name.setBackgroundResource(R.drawable.roun_rect_orange22);
                txt_status_name.setTextColor(0xffffffff);


            } else {
                txt_status_name.setText("ออก");
                txt_status_name.setBackgroundResource(R.drawable.roun_rect_orange21);
                txt_status_name.setTextColor(0xffffffff);

            }
        }





        if(CHECK_STATUS_SALE2.equals("null")){
            txt_status_name2.setText("ไม่มี");
            txt_status_name2.setBackgroundResource(R.drawable.roun_rect_orange23);
            txt_status_name2.setTextColor(0xffffffff);
        }
        else {

            if (CHECK_STATUS_SALE2.equals("D")) {
                txt_status_name2.setText("รักษาการ");
                txt_status_name2.setBackgroundResource(R.drawable.roun_rect_orange23);
                txt_status_name2.setTextColor(0xffffffff);

            }
            else if (CHECK_STATUS_SALE2.equals("G")) {
                txt_status_name2.setText("ย้ายออก");
                txt_status_name2.setBackgroundResource(R.drawable.roun_rect_orange24);
                txt_status_name2.setTextColor(0xffffffff);

            }

            else if (CHECK_STATUS_SALE2.equals("N")) {
                txt_status_name2.setText("ปกติ");
                txt_status_name2.setBackgroundResource(R.drawable.roun_rect_orange17);
                txt_status_name2.setTextColor(0xffffffff);

            } else if (CHECK_STATUS_SALE2.equals("P")) {
                txt_status_name2.setText("ย้าย");
                txt_status_name2.setBackgroundResource(R.drawable.roun_rect_orange22);
                txt_status_name2.setTextColor(0xffffffff);


            } else  {
                txt_status_name2.setText("ออก");
                txt_status_name2.setBackgroundResource(R.drawable.roun_rect_orange21);
                txt_status_name2.setTextColor(0xffffffff);

            }
        }





        if(CHECK_STATUS_SALE3.equals("null")){
            txt_status_name3.setText("ไม่มี");
            txt_status_name3.setBackgroundResource(R.drawable.roun_rect_orange23);
            txt_status_name3.setTextColor(0xffffffff);
        }
        else {

            if (CHECK_STATUS_SALE3.equals("D")) {
                txt_status_name3.setText("รักษาการ");
                txt_status_name3.setBackgroundResource(R.drawable.roun_rect_orange23);
                txt_status_name3.setTextColor(0xffffffff);

            }
            else if (CHECK_STATUS_SALE3.equals("G")) {
                txt_status_name3.setText("ย้ายออก");
                txt_status_name3.setBackgroundResource(R.drawable.roun_rect_orange24);
                txt_status_name3.setTextColor(0xffffffff);

            }

            else if (CHECK_STATUS_SALE3.equals("N")) {
                txt_status_name3.setText("ปกติ");
                txt_status_name3.setBackgroundResource(R.drawable.roun_rect_orange17);
                txt_status_name3.setTextColor(0xffffffff);

            } else if (CHECK_STATUS_SALE3.equals("P")) {
                txt_status_name3.setText("ย้าย");
                txt_status_name3.setBackgroundResource(R.drawable.roun_rect_orange22);
                txt_status_name3.setTextColor(0xffffffff);


            } else {
                txt_status_name3.setText("ออก");
                txt_status_name3.setBackgroundResource(R.drawable.roun_rect_orange21);
                txt_status_name3.setTextColor(0xffffffff);

            }
        }











        if(CHECK_STATUS_SALE4.equals("null")){
            txt_status_name4.setText("ไม่มี");
            txt_status_name4.setBackgroundResource(R.drawable.roun_rect_orange23);
            txt_status_name4.setTextColor(0xffffffff);
        }
        else {

            if (CHECK_STATUS_SALE4.equals("D")) {
                txt_status_name4.setText("รักษาการ");
                txt_status_name4.setBackgroundResource(R.drawable.roun_rect_orange23);
                txt_status_name4.setTextColor(0xffffffff);

            }
            else if (CHECK_STATUS_SALE4.equals("G")) {
                txt_status_name4.setText("ย้ายออก");
                txt_status_name4.setBackgroundResource(R.drawable.roun_rect_orange24);
                txt_status_name4.setTextColor(0xffffffff);

            }

            else if (CHECK_STATUS_SALE4.equals("N")) {
                txt_status_name4.setText("ปกติ");
                txt_status_name4.setBackgroundResource(R.drawable.roun_rect_orange17);
                txt_status_name4.setTextColor(0xffffffff);

            } else if (CHECK_STATUS_SALE4.equals("P")) {
                txt_status_name4.setText("ย้าย");
                txt_status_name4.setBackgroundResource(R.drawable.roun_rect_orange22);
                txt_status_name4.setTextColor(0xffffffff);


            } else {
                txt_status_name4.setText("ออก");
                txt_status_name4.setBackgroundResource(R.drawable.roun_rect_orange21);
                txt_status_name4.setTextColor(0xffffffff);

            }
        }














        if(CHECK_STATUS_SALE5.equals("null")){
            txt_status_name5.setText("ไม่มี");
            txt_status_name5.setBackgroundResource(R.drawable.roun_rect_orange23);
            txt_status_name5.setTextColor(0xffffffff);
        }
        else {

            if (CHECK_STATUS_SALE5.equals("D")) {
                txt_status_name5.setText("รักษาการ");
                txt_status_name5.setBackgroundResource(R.drawable.roun_rect_orange23);
                txt_status_name5.setTextColor(0xffffffff);

            }
            else if (CHECK_STATUS_SALE5.equals("G")) {
                txt_status_name5.setText("ย้ายออก");
                txt_status_name5.setBackgroundResource(R.drawable.roun_rect_orange24);
                txt_status_name5.setTextColor(0xffffffff);

            }

            else if (CHECK_STATUS_SALE5.equals("N")) {
                txt_status_name5.setText("ปกติ");
                txt_status_name5.setBackgroundResource(R.drawable.roun_rect_orange17);
                txt_status_name5.setTextColor(0xffffffff);

            } else if (CHECK_STATUS_SALE5.equals("P")) {
                txt_status_name5.setText("ย้าย");
                txt_status_name5.setBackgroundResource(R.drawable.roun_rect_orange22);
                txt_status_name5.setTextColor(0xffffffff);


            } else {
                txt_status_name5.setText("ออก");
                txt_status_name5.setBackgroundResource(R.drawable.roun_rect_orange21);
                txt_status_name5.setTextColor(0xffffffff);

            }
        }
        txt_Outstanding.setText(NetAmount);
        txt_pay.setText(PaymentPeriodNumber+" งวด");
        txt_baba.setText(Balance);
        tooltip.show();

    }




    @Override
    public void onCreateOptionsMenu(
            Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.music, menu);

        MenuItem menuItem = menu.findItem(R.id.testAction);
        MenuItem menuItem2 = menu.findItem(R.id.testAction2);
        MenuItem menuItem3 = menu.findItem(R.id.testAction3);
        MenuItem menuItem4 = menu.findItem(R.id.testAction4);
        MenuItem menuItem5 = menu.findItem(R.id.testAction5);

        MenuItem menuItemุ6 = menu.findItem(R.id.action_search);
        MenuItem menuItemุ7 = menu.findItem(R.id.action_setting);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItemุ6);
        search(searchView);

        if(!searchView.isIconified()){
            searchView.setQuery("",false);
            JSON_DATA_WEB_CALL();
        }

        menuItem.setVisible(false);
        menuItem2.setVisible(false);
        menuItem3.setVisible(false);
        menuItem4.setVisible(false);
        menuItem5.setVisible(false);
        menuItemุ7.setVisible(false);


    }


    private void search(final SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {




                if (recyclerViewDataAdapter != null)
                    recyclerViewDataAdapter.getFilter().filter(newText);

                if(newText.equals("")){
                    GetDataAdapter1.clear();
                    allSampleData.clear();
                    allSampleData2.clear();
                    recyclerViewDataAdapter.getFilter().filter("");
                    my_recycler_view.setHasFixedSize(true);
                    recyclerViewlayoutManager = new LinearLayoutManager(getActivity());
                    my_recycler_view.setLayoutManager(recyclerViewlayoutManager);
                    JSON_DATA_WEB_CALL();
                    Log.e("4444","3333");
                }

                return true;






            }
        });
    }


    @Override
    public void click_list_item_history(View v, int position) {
        getData_cedit_sale_edit_problem = GetDataAdapter1.get(position);
        Intent Intent = new Intent(getActivity(), UI_CARDVIEW_DATA_SALE_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_ACTIVITY.class);
        Bundle bun = new Bundle();
        bun.putString("InformID", getData_cedit_sale_edit_problem.getInformID());
        Intent.putExtras(bun);
        startActivityForResult(Intent, 77);
    }




    String GET_JSON_DATA_HTTP_URL_gory_6= "http://app.thiensurat.co.th/assanee/checker_system/data_confirm3.php";
    public void SELECT_DATA_CONFIRM2(String CONO) {
        Log.e("conno_aa",GET_JSON_DATA_HTTP_URL_gory_6+"?CONTNO="+CONO);

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_gory_6+"?CONTNO="+CONO ,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_SELECT_DATA_CONFIRM2(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        SELECT_DATA_CONFIRM2(CONO);
                    }
                });

        try {
            try {
                requestQueue = Volley.newRequestQueue(getActivity());
                requestQueue.add(jsonArrayRequest);

                int MY_SOCKET_TIMEOUT_MS=10000;

                jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(
                        MY_SOCKET_TIMEOUT_MS,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            }
            catch (RuntimeException ex){

            }
        }
        catch (OutOfMemoryError EX){

        }

    }

    String TotalPrice="",Balance="",PaymentPeriodNumber="",NetAmount="";
    public void JSON_PARSE_DATA_AFTER_SELECT_DATA_CONFIRM2(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {


            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                TotalPrice=json.getString("TotalPrice");
                Balance=json.getString("Balance");
                PaymentPeriodNumber=json.getString("PaymentPeriodNumber");
                // NetAmount=json.getString("NetAmount");


                JSONArray array2 = json.getJSONArray("NetAmount");
                JSONObject object = null;

                for (int i2 = 0; i2 < array2.length(); i2++) {

                    object = array2.getJSONObject(i2);
                    String IMAGE= object.getString(String.valueOf((i2+1)));
                    NetAmount=IMAGE;

                }


            } catch (JSONException e) {

                e.printStackTrace();
            }


            ;
        }



    }

}
