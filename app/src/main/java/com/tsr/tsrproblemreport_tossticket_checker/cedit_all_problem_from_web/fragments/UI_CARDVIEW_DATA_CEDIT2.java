package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Address;
import android.location.Geocoder;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.PlaceDetectionClient;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.data_base.SQLiteHelper_data_checker_all;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.MusicActivity_Credit;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit3_2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit3_4;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.ContactAdapter2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.helper.OnCustomerListChangedListener;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.helper.OnStartDragListener;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.helper.SimpleItemTouchHelperCallback;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_map;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import at.grabner.circleprogress.CircleProgressView;

import static com.tsr.tsrproblemreport_tossticket_checker.API_URL_ALL.BASE_URL;
import static com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.MusicActivity_Checker.dad;

public class UI_CARDVIEW_DATA_CEDIT2 extends Fragment implements OnStartDragListener, OnCustomerListChangedListener, View.OnClickListener, ContactAdapter2.itemclick, ContactAdapter2.itemclick2,OnMapReadyCallback {


    private Context mContext;
    GetData_cedit_map getData_cedit_map;
    @SuppressLint("ValidFragment")
    public UI_CARDVIEW_DATA_CEDIT2(Context mContext) {
        this.mContext = mContext;
    }
    SupportMapFragment mapFragment;
    Marker melbourne;
    Detali_data_cedit2 musicActivity_credit;

    String DADADA;
    GetData_cedit getData_cedit;
    List<GetData_cedit> GetDataAdapter1;
    private ContactAdapter2 contactAdapter;
    public static CircleProgressView mCircleView;

    RecyclerView recyclerView;
    RelativeLayout relativeLayout,RelativeLayout_map_contno;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    public static Context context;


    //String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/cedit_data.php";
    String GET_JSON_DATA_HTTP_URL = BASE_URL+"assanee/checker_system/data_check2_new.php";
    String GET_JSON_DATA_HTTP_URL_SE = BASE_URL+"assanee/checker_system/data_check2_new_SE.php";


    String GET_JSON_DATA_HTTP_URL_SALE="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit/sale/problem_all/sale_problem1_json2_real_from_cedit.php";
    String GET_JSON_DATA_HTTP_URL_TEAMLEADER="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit/supervisor/problem_all/supervisor_problem1_json2_real_from_cedit.php";
    String GET_JSON_DATA_HTTP_URL_SUPERVISOR="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit/supervisor/problem_all/supervisor_problem1_json2_real_from_cedit.php";
    String GET_JSON_DATA_HTTP_URL_LINE="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit/supervisor/problem_all/supervisor_problem1_json2_real_from_cedit.php";
    String GET_JSON_DATA_HTTP_URL_MANAGER="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit/supervisor/problem_all/supervisor_problem1_json2_real_from_cedit.php";

    String JSON_CONTNO = "CONTNO";
    String JSON_RefNo = "RefNo";
    String JSON_SaleEmployeeName = "SaleEmployeeName";
    String JSON_SaleTeamCode = "SaleTeamCode";
    String JSON_SaleHeaderName = "SaleHeaderName";
    String JSON_IDCARD = "IDCARD";
    String JSON_CustomerName = "CustomerName";
    String JSON_ADDRESSS = "ADDRESSS";
    String JSON_Latitude = "Latitude";
    String JSON_Longitude = "Longitude";
    String JSON_statusName = "statusName";
    String JSON_TelMobile = "TelMobile";
    String JSON_TelHome = "TelHome";
    String JSON_ProductName = "ProductName";
    String JSON_dis = "dis";
    String JSON_status_qrcode = "status_qrcode";
    String JSON_distance = "distance";
    String JSON_salename = "salename";
    String JSON_teamcode = "teamcode";
    String JSON_headname = "headname";
    String JSON_lat_long = "lat_long";
    String JSON_conno = "conno";
    String JSON_conno_qr_code = "conno_qr_code";
    String JSON_product_name = "product_name";
    String JSON_status = "status";
    String JSON_name_customer = "name_customer";
    String JSON_id_card = "id_card";
    String JSON_address = "address";
    String JSON_number_phone = "number_phone";
    String JSON_EFFDATE2 = "date2";
    String JSON_IssueName = "IssueName";
    String JSON_status_view_lasttime = "status_view_lasttime";

    String PositionCode="";
    SQLiteDatabase sqLiteDatabase;
    String address_now;
    Double dist = 0.0;
    Double durat=0.0;
    double persen = 0.00;
    int b;
    public static Dialog dialog2;


    public static int ia, i = 0, iis = 0;

    float latlat;
    float longlong;
    float latlat2;
    float longlong2;
    Cursor cursor;
    int setlist = 0;
    private int count;
    private Toolbar toolbar;
    JsonArrayRequest jsonArrayRequest;

    RequestQueue requestQueue;
    private SwipeRefreshLayout swipeRefreshLayout;
    TextView counter;
    android.support.design.widget.FloatingActionButton fab, fab2;

   public static int position2;


    public  static ProgressDialog progressDialog;
    private int progressStatus = 0;
    private Handler handler = new Handler();
    private ProgressDialog pDialog;

    private ItemTouchHelper itemTouchHelper;
    private GeoDataClient mGeoDataClient;
    private PlaceDetectionClient mPlaceDetectionClient;

    private ShimmerFrameLayout mShimmerViewContainer;
    Thread thread;
    public UI_CARDVIEW_DATA_CEDIT2() {

    }


    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        recyclerView.setHasFixedSize(true);

        recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(recyclerViewlayoutManager);


        relativeLayout.setVisibility(View.GONE);

       // SQLiteDataBaseBuild_data_checker_all();
      //  SQLiteTableBuild_data_checker_all();
       // sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_data_checker_all.TABLE_NAME+"");


        PositionCode=MyApplication.getInstance().getPrefManager().getPreferrence("PositionCode");
       // getDistanceInfo();
     //   getDistanceInfo("13.950481,100.668204","13.898026,100.514533");
/*        if (musicActivity_credit.dad == 1) {

            synchronized (getActivity()){
                progressDialog = new ProgressDialog(getActivity());
                progressDialog.setMessage("กำลังอัปเดทตำแหน่ง...");
                progressDialog.show();
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.setIndeterminate(true);

                GetDataAdapter1.clear();
            }
           // thread.start();




        }
        if (musicActivity_credit.dad == 2) {

            synchronized (getActivity()){
                progressDialog = new ProgressDialog(getActivity());
                progressDialog.setMessage("กำลังรีเซ็จค่าเริ่มต้น...");
                progressDialog.show();
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.setIndeterminate(true);

                GetDataAdapter1.clear();
            }
            // thread.start();




        }*/

        JSON_DATA_WEB_CALL();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // GetDataAdapter1.clear();
                position2 = 0;

                    recyclerView.setHasFixedSize(true);

                    recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

                    recyclerView.setLayoutManager(recyclerViewlayoutManager);
                    mShimmerViewContainer.stopShimmerAnimation();
                    mShimmerViewContainer.setVisibility(View.VISIBLE);
                    GetDataAdapter1.clear();


                    JSON_DATA_WEB_CALL();









                swipeRefreshLayout.setRefreshing(false);
            }
        });


/*           if(dad==1){

               SQLiteDataBaseBuild_data_checker_all();
               SQLiteTableBuild_data_checker_all();
               sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_data_checker_all.TABLE_NAME + "");

               GetDataAdapter1.clear();
               JSON_DATA_WEB_CALL3();

           }
           else {
               try {
                   if(MyApplication.getInstance().getPrefManager().getPreferrence("intro_save").equals("1")){
                    //   GetDataAdapter1.clear();
                     //  JSON_DATA_WEB_CALL2();
                       SQLiteDataBaseBuild_data_checker_all();
                       SQLiteTableBuild_data_checker_all();
                       data_old();
                   }
                   else {
                       GetDataAdapter1.clear();
                       JSON_DATA_WEB_CALL();
                   }
               }
               catch (Exception ex){
                   GetDataAdapter1.clear();
                   JSON_DATA_WEB_CALL();
               }


           }




        if (setlist == 1) {
            if(dad==1){

                SQLiteDataBaseBuild_data_checker_all();
                SQLiteTableBuild_data_checker_all();
                sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_data_checker_all.TABLE_NAME + "");

                GetDataAdapter1.clear();
                JSON_DATA_WEB_CALL3();

            }
            else {
                try {
                    if(MyApplication.getInstance().getPrefManager().getPreferrence("intro_save").equals("1")){
                        //   GetDataAdapter1.clear();
                        //  JSON_DATA_WEB_CALL2();
                        SQLiteDataBaseBuild_data_checker_all();
                        SQLiteTableBuild_data_checker_all();
                        data_old();
                    }
                    else {
                        GetDataAdapter1.clear();
                        JSON_DATA_WEB_CALL();
                    }
                }
                catch (Exception ex){
                    GetDataAdapter1.clear();
                    JSON_DATA_WEB_CALL();
                }


            }
        } else {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                   // GetDataAdapter1.clear();
                    position2 = 0;
                    //JSON_DATA_WEB_CALL();


                    try {
                        if(MyApplication.getInstance().getPrefManager().getPreferrence("intro_save").equals("1")){
                          //  GetDataAdapter1.clear();
                          //  JSON_DATA_WEB_CALL2();
                            SQLiteDataBaseBuild_data_checker_all();
                            SQLiteTableBuild_data_checker_all();
                            data_old();
                        }
                        else {


                            recyclerView.setHasFixedSize(true);

                            recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

                            recyclerView.setLayoutManager(recyclerViewlayoutManager);
                            mShimmerViewContainer.stopShimmerAnimation();
                            mShimmerViewContainer.setVisibility(View.VISIBLE);
                            GetDataAdapter1.clear();


                            JSON_DATA_WEB_CALL();
                        }
                    }
                    catch (Exception ex){
                        recyclerView.setHasFixedSize(true);

                        recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

                        recyclerView.setLayoutManager(recyclerViewlayoutManager);
                        mShimmerViewContainer.stopShimmerAnimation();
                        mShimmerViewContainer.setVisibility(View.VISIBLE);
                        GetDataAdapter1.clear();


                        JSON_DATA_WEB_CALL();
                    }








                    swipeRefreshLayout.setRefreshing(false);
                }
            });
        }*/


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View layoutView = inflater.inflate(R.layout.cardview_row_cedit, container, false);
        // toolbar = (Toolbar) layoutView.findViewById(R.id.toolbar);
        toolbar = (Toolbar) layoutView.findViewById(R.id.toolbar);
        setHasOptionsMenu(true);

        swipeRefreshLayout = (SwipeRefreshLayout) layoutView.findViewById(R.id.swipe_refresh_layout);
        //  swipeRefreshLayout.setOnRefreshListener(getActivity());
        counter = (TextView) layoutView.findViewById(R.id.counter);
        fab = (android.support.design.widget.FloatingActionButton) layoutView.findViewById(R.id.fab);

        GetDataAdapter1 = new ArrayList<>();

        recyclerView = (RecyclerView) layoutView.findViewById(R.id.recyclerview1);
        relativeLayout = (RelativeLayout) layoutView.findViewById(R.id.relativeLayout);
        RelativeLayout_map_contno= (RelativeLayout) layoutView.findViewById(R.id.RelativeLayout_map_contno);
         fab2 = (android.support.design.widget.FloatingActionButton) layoutView.findViewById(R.id.fab2);

        mShimmerViewContainer = layoutView.findViewById(R.id.shimmer_view_container);

        fab.setVisibility(View.GONE);
        fab.setOnClickListener(this);


        MyApplication.getInstance().getPrefManager().setPreferrence("dat2", "0");

        mGeoDataClient = Places.getGeoDataClient(getActivity(), null);

        // Construct a PlaceDetectionClient.
        mPlaceDetectionClient = Places.getPlaceDetectionClient(getActivity(), null);

        return layoutView;

    }





    protected boolean checkConnection() {
        boolean re = false;
        try {
            ConnectivityManager conMan = (ConnectivityManager) this.getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = conMan.getActiveNetworkInfo();

            final boolean connected = networkInfo != null
                    && networkInfo.isAvailable()
                    && networkInfo.isConnected();

            if (!connected) {
                re = false;
            } else
                re = true;
        } catch (Exception err) {
        }
        return re;
    }






    public void JSON_DATA_WEB_CALL() {
         // String SALECODE ="10103957";
        String CheckerEmpID = MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL + "?CheckerEmpID=" + CheckerEmpID,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_WEBCALL(response);
                        musicActivity_credit.dad=0;
                        //progressDialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        musicActivity_credit.dad=0;
                       // progressDialog.dismiss();
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



    public void JSON_DATA_WEB_CALL_SE(String data) {

        String user_code= MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

        //  jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL+"?user_code="+user_code ,
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_SE+"?CheckerEmpID="+user_code +"&data="+data ,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {



                        JSON_PARSE_DATA_AFTER_WEBCALL(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                       // pDialog2.dismissWithAnimation();
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


    public void JSON_DATA_WEB_CALL2() {
        String CheckerEmpID = MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL + "?CheckerEmpID=" + CheckerEmpID,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_WEBCALL2(response);
                        musicActivity_credit.dad=0;
                        //progressDialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        musicActivity_credit.dad=0;
                        // progressDialog.dismiss();
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

    public void JSON_DATA_WEB_CALL3() {
        String CheckerEmpID = MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL + "?CheckerEmpID=" + CheckerEmpID,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_WEBCALL3(response);
                        musicActivity_credit.dad=0;
                        //progressDialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        musicActivity_credit.dad=0;
                        // progressDialog.dismiss();
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

    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array) {
        GetDataAdapter1.clear();

      //  SQLiteDataBaseBuild_data_checker_all();
      //  SQLiteTableBuild_data_checker_all();

        for (i = 0; i < array.length(); i++) {

            final GetData_cedit GetDataAdapter2 = new GetData_cedit();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);

                getData_cedit = new GetData_cedit();

                GetDataAdapter2.setCheckerStatus(json.getString("CheckerStatus"));
                GetDataAdapter2.setCheckerStatusName(json.getString("CheckerStatusName"));
                GetDataAdapter2.setProductSerial(json.getString("ProductSerial"));
                GetDataAdapter2.setOutstanding(json.getString("Outstanding"));
                GetDataAdapter2.setPayLastPeriod(json.getString("PayLastPeriod"));

                GetDataAdapter2.setFnYear(json.getString("FnYear"));
                GetDataAdapter2.setFnMonth(json.getString("FnMonth"));
                GetDataAdapter2.setSaleEmployeeName(json.getString("SaleEmployeeName"));
                GetDataAdapter2.setSaleTeamCode(json.getString("SaleCode"));
                GetDataAdapter2.setCONTNO(json.getString("Contno"));
                GetDataAdapter2.setProductName(json.getString("ProductName"));
                GetDataAdapter2.setCustomerName(json.getString("CustomerName"));
                GetDataAdapter2.setIDCARD(json.getString("IDCard"));
                GetDataAdapter2.setAddressDetail(json.getString("Addressall"));
                GetDataAdapter2.setLatitude(json.getString("Latitude"));
                GetDataAdapter2.setLongitude(json.getString("Longitude"));
                GetDataAdapter2.setTelHome(json.getString("TelHome"));
                GetDataAdapter2.setTelMobile(json.getString("TelMobile"));
                GetDataAdapter2.setEFFDATE(json.getJSONObject("EffDate").getString("date"));

                GetDataAdapter2.setFortnight_no(json.getString("Fortnight_no"));
                GetDataAdapter2.setOpendate(json.getString("opendate"));
                GetDataAdapter2.setClosedate(json.getString("closedate"));

                //GetDataAdapter2.setRefNo(json.getString(JSON_RefNo));
             //   GetDataAdapter2.setSaleHeaderName(json.getString(JSON_SaleHeaderName));



                GetDataAdapter2.setdis("ยังไม่อัฟเดท");
                Log.e("FnYear",json.getString("FnYear"));
                Log.e("FnMonth",json.getString("FnMonth"));




                iis++;




                //GetDataAdapter2.setDistant(json.getString(JSON_IssueName));
            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter2);
            //  pDialog.dismiss();
        }








        contactAdapter = new ContactAdapter2(recyclerView, GetDataAdapter1, getActivity(), UI_CARDVIEW_DATA_CEDIT2.this, UI_CARDVIEW_DATA_CEDIT2.this);

        getData_cedit_map = new GetData_cedit_map();
        getData_cedit_map.setGetDataAdapter1(GetDataAdapter1);

        recyclerView.setAdapter(contactAdapter);

        contactAdapter.notifyDataSetChanged();


        counter.setText(GetDataAdapter1.size() + "");
        DADADA = GetDataAdapter1.size() + "";

        contactAdapter.setitemclick(this);
        contactAdapter.setitemclick2(this);

        mShimmerViewContainer.stopShimmerAnimation();
        mShimmerViewContainer.setVisibility(View.GONE);




        try {
            progressDialog.dismiss();
        }
        catch (Exception E){

        }


    }

    public void JSON_PARSE_DATA_AFTER_WEBCALL2(JSONArray array) {
        GetDataAdapter1.clear();

       SQLiteDataBaseBuild_data_checker_all();
        SQLiteTableBuild_data_checker_all();

        for (i = 0; i < array.length(); i++) {

            final GetData_cedit GetDataAdapter2 = new GetData_cedit();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);

                getData_cedit = new GetData_cedit();

                GetDataAdapter2.setOutstanding(json.getString("Outstanding"));
                GetDataAdapter2.setPayLastPeriod(json.getString("PayLastPeriod"));
                GetDataAdapter2.setFnYear(json.getString("FnYear"));
                GetDataAdapter2.setFnMonth(json.getString("FnMonth"));
                GetDataAdapter2.setSaleEmployeeName(json.getString("SaleEmployeeName"));
                GetDataAdapter2.setSaleTeamCode(json.getString("SaleCode"));
                GetDataAdapter2.setCONTNO(json.getString("Contno"));
                GetDataAdapter2.setProductName(json.getString("ProductName"));
                GetDataAdapter2.setCustomerName(json.getString("CustomerName"));
                GetDataAdapter2.setIDCARD(json.getString("IDCard"));
                GetDataAdapter2.setAddressDetail(json.getString("Addressall"));
                GetDataAdapter2.setLatitude(json.getString("Latitude"));
                GetDataAdapter2.setLongitude(json.getString("Longitude"));
                GetDataAdapter2.setTelHome(json.getString("TelHome"));
                GetDataAdapter2.setTelMobile(json.getString("TelMobile"));
                GetDataAdapter2.setEFFDATE(json.getJSONObject("EffDate").getString("date"));







                iis++;




                //GetDataAdapter2.setDistant(json.getString(JSON_IssueName));
            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter2);
            //  pDialog.dismiss();
        }
        // ia = array.length();

        //hidePDialog();
        // MyApplication.getInstance().getPrefManager().setPreferrence("status_update_distant","1");








        GetDataAdapter1.clear();
        cursor = sqLiteDatabase.rawQuery("SELECT CONTNO,RefNo,SaleEmployeeName,SaleTeamCode,SaleHeaderName,IDCARD,CustomerName,ADDRESSS,Tel,ProductName,EFFDATE,Dis,Latitude,Longitude,Outstanding,PayLastPeriod,FnYear,FnMonth FROM "+SQLiteHelper_data_checker_all.TABLE_NAME+""  +" order  by Dis ASC"   , null);
        if (cursor.moveToFirst()) {
            do {

                final GetData_cedit GetDataAdapter2 = new GetData_cedit();


                String Table_CONTNO = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_CONTNO));
                //String Table_RefNo = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_RefNo));
                String Table_SaleEmployeeName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleEmployeeName));
                String Table_SaleTeamCode = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleTeamCode));
                //String Table_SaleHeaderName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleHeaderName));
                String Table_IDCARD = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_IDCARD));
                String Table_CustomerName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_CustomerName));
                String Table_ADDRESSS = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_ADDRESSS));
                String Table_Tel = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Tel));
                //   String Table_Tel_MOBILE = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Tel_MOBILE));
                String Table_ProductName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_ProductName));
                String Table_EFFDATE = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_EFFDATE));
                String Table_Dis = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Dis));


                String Table_Latitude = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Latitude));
                String Table_Longitude = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Longitude));
                String Table_Outstanding = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Outstanding));
                String Table_PayLastPeriod = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_PayLastPeriod));
                String Table_FnYear = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_FnYear));
                String Table_FnMonth = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_FnMonth));


                Log.e("Table_Dis", Table_Dis);

                if(Double.parseDouble(Table_Dis)<=99){
                    GetDataAdapter2.setSaleEmployeeName(Table_SaleEmployeeName);
                    GetDataAdapter2.setSaleTeamCode(Table_SaleTeamCode);
                    GetDataAdapter2.setCONTNO(Table_CONTNO);
                    GetDataAdapter2.setProductName(Table_ProductName);
                    GetDataAdapter2.setCustomerName(Table_CustomerName);
                    GetDataAdapter2.setIDCARD(Table_IDCARD);
                    GetDataAdapter2.setAddressDetail(Table_ADDRESSS);
                    GetDataAdapter2.setTelHome(Table_Tel);
                    GetDataAdapter2.setEFFDATE(Table_EFFDATE);
                    GetDataAdapter2.setdis(Table_Dis);

                    GetDataAdapter2.setLatitude(Table_Latitude);
                    GetDataAdapter2.setLongitude(Table_Longitude);
                    GetDataAdapter2.setOutstanding(Table_Outstanding);
                    GetDataAdapter2.setPayLastPeriod(Table_PayLastPeriod);
                    GetDataAdapter2.setFnYear(Table_FnYear);
                    GetDataAdapter2.setFnMonth(Table_FnMonth);

                    GetDataAdapter1.add(GetDataAdapter2);
                }


            } while (cursor.moveToNext());
        }
        cursor.close();


        cursor = sqLiteDatabase.rawQuery("SELECT CONTNO,RefNo,SaleEmployeeName,SaleTeamCode,SaleHeaderName,IDCARD,CustomerName,ADDRESSS,Tel,ProductName,EFFDATE,Dis,Latitude,Longitude,Outstanding,PayLastPeriod,FnYear,FnMonth FROM "+SQLiteHelper_data_checker_all.TABLE_NAME+""  +" order  by Dis ASC"   , null);
        if (cursor.moveToFirst()) {
            do {

                final GetData_cedit GetDataAdapter2 = new GetData_cedit();


                String Table_CONTNO = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_CONTNO));
                //String Table_RefNo = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_RefNo));
                String Table_SaleEmployeeName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleEmployeeName));
                String Table_SaleTeamCode = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleTeamCode));
                //String Table_SaleHeaderName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleHeaderName));
                String Table_IDCARD = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_IDCARD));
                String Table_CustomerName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_CustomerName));
                String Table_ADDRESSS = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_ADDRESSS));
                String Table_Tel = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Tel));
                //   String Table_Tel_MOBILE = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Tel_MOBILE));
                String Table_ProductName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_ProductName));
                String Table_EFFDATE = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_EFFDATE));
                String Table_Dis = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Dis));

                String Table_Latitude = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Latitude));
                String Table_Longitude = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Longitude));
                String Table_Outstanding = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Outstanding));
                String Table_PayLastPeriod = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_PayLastPeriod));
                String Table_FnYear = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_FnYear));
                String Table_FnMonth = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_FnMonth));

                Log.e("Table_Dis", Table_Dis);

                if((Double.parseDouble(Table_Dis)>99)&(Double.parseDouble(Table_Dis)<=999)){
                    GetDataAdapter2.setSaleEmployeeName(Table_SaleEmployeeName);
                    GetDataAdapter2.setSaleTeamCode(Table_SaleTeamCode);
                    GetDataAdapter2.setCONTNO(Table_CONTNO);
                    GetDataAdapter2.setProductName(Table_ProductName);
                    GetDataAdapter2.setCustomerName(Table_CustomerName);
                    GetDataAdapter2.setIDCARD(Table_IDCARD);
                    GetDataAdapter2.setAddressDetail(Table_ADDRESSS);
                    GetDataAdapter2.setTelHome(Table_Tel);
                    GetDataAdapter2.setEFFDATE(Table_EFFDATE);
                    GetDataAdapter2.setdis(Table_Dis);

                    GetDataAdapter2.setLatitude(Table_Latitude);
                    GetDataAdapter2.setLongitude(Table_Longitude);
                    GetDataAdapter2.setOutstanding(Table_Outstanding);
                    GetDataAdapter2.setPayLastPeriod(Table_PayLastPeriod);
                    GetDataAdapter2.setFnYear(Table_FnYear);
                    GetDataAdapter2.setFnMonth(Table_FnMonth);
                    GetDataAdapter1.add(GetDataAdapter2);
                }


            } while (cursor.moveToNext());
        }
        cursor.close();


        cursor = sqLiteDatabase.rawQuery("SELECT CONTNO,RefNo,SaleEmployeeName,SaleTeamCode,SaleHeaderName,IDCARD,CustomerName,ADDRESSS,Tel,ProductName,EFFDATE,Dis,Latitude,Longitude,Outstanding,PayLastPeriod,FnYear,FnMonth FROM "+SQLiteHelper_data_checker_all.TABLE_NAME+""  +" order  by Dis ASC"   , null);
        if (cursor.moveToFirst()) {
            do {

                final GetData_cedit GetDataAdapter2 = new GetData_cedit();


                String Table_CONTNO = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_CONTNO));
                //String Table_RefNo = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_RefNo));
                String Table_SaleEmployeeName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleEmployeeName));
                String Table_SaleTeamCode = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleTeamCode));
                //String Table_SaleHeaderName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleHeaderName));
                String Table_IDCARD = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_IDCARD));
                String Table_CustomerName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_CustomerName));
                String Table_ADDRESSS = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_ADDRESSS));
                String Table_Tel = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Tel));
                //   String Table_Tel_MOBILE = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Tel_MOBILE));
                String Table_ProductName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_ProductName));
                String Table_EFFDATE = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_EFFDATE));
                String Table_Dis = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Dis));

                String Table_Latitude = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Latitude));
                String Table_Longitude = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Longitude));
                String Table_Outstanding = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Outstanding));
                String Table_PayLastPeriod = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_PayLastPeriod));
                String Table_FnYear = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_FnYear));
                String Table_FnMonth = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_FnMonth));

                Log.e("Table_Dis", Table_Dis);

                if(Double.parseDouble(Table_Dis)>=1000){
                    GetDataAdapter2.setSaleEmployeeName(Table_SaleEmployeeName);
                    GetDataAdapter2.setSaleTeamCode(Table_SaleTeamCode);
                    GetDataAdapter2.setCONTNO(Table_CONTNO);
                    GetDataAdapter2.setProductName(Table_ProductName);
                    GetDataAdapter2.setCustomerName(Table_CustomerName);
                    GetDataAdapter2.setIDCARD(Table_IDCARD);
                    GetDataAdapter2.setAddressDetail(Table_ADDRESSS);
                    GetDataAdapter2.setTelHome(Table_Tel);
                    GetDataAdapter2.setEFFDATE(Table_EFFDATE);
                    GetDataAdapter2.setdis(Table_Dis);

                    GetDataAdapter2.setLatitude(Table_Latitude);
                    GetDataAdapter2.setLongitude(Table_Longitude);
                    GetDataAdapter2.setOutstanding(Table_Outstanding);
                    GetDataAdapter2.setPayLastPeriod(Table_PayLastPeriod);
                    GetDataAdapter2.setFnYear(Table_FnYear);
                    GetDataAdapter2.setFnMonth(Table_FnMonth);
                    GetDataAdapter1.add(GetDataAdapter2);
                }


            } while (cursor.moveToNext());
        }
        cursor.close();






        try {

            String dat2 = MyApplication.getInstance().getPrefManager().getPreferrence("dat2");

            if ((dat2.equals("0")) | (dat2.equals("null"))) {

                contactAdapter = new ContactAdapter2(recyclerView, GetDataAdapter1, getActivity(), UI_CARDVIEW_DATA_CEDIT2.this, UI_CARDVIEW_DATA_CEDIT2.this);

                getData_cedit_map = new GetData_cedit_map();
                getData_cedit_map.setGetDataAdapter1(GetDataAdapter1);

                recyclerView.setAdapter(contactAdapter);

                contactAdapter.notifyDataSetChanged();


                counter.setText(GetDataAdapter1.size() + "");
                DADADA = GetDataAdapter1.size() + "";

                contactAdapter.setitemclick(this);
                contactAdapter.setitemclick2(this);


                recyclerView.setHasFixedSize(true);

                recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

                recyclerView.setLayoutManager(recyclerViewlayoutManager);

/*                if (musicActivity_credit.dad == 1) {
                    recyclerView.smoothScrollToPosition(i - 1);

                } else if (musicActivity_credit.dad == 2) {
                    recyclerView.smoothScrollToPosition(i - 1);

                } else {
                    try {
                        recyclerView.smoothScrollToPosition(0);
                        recyclerView.scrollToPosition(position2 - 1);
                    } catch (Exception ex) {

                    }

                }*/

                iis = i - 1;


                ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(contactAdapter);
                itemTouchHelper = new ItemTouchHelper(callback);
                itemTouchHelper.attachToRecyclerView(recyclerView);


                mShimmerViewContainer.stopShimmerAnimation();
                mShimmerViewContainer.setVisibility(View.GONE);


                if (iis == ContactAdapter2.position_adap) {

                    GetDataAdapter1.clear();
                    JSON_DATA_WEB_CALL();
                }


            } else {
                //this.GetDataAdapter1 = getOrderItem(GetDataAdapter1);
                this.GetDataAdapter1 = getOrderItem(GetDataAdapter1);
                contactAdapter = new ContactAdapter2(recyclerView, GetDataAdapter1, getActivity(), UI_CARDVIEW_DATA_CEDIT2.this, UI_CARDVIEW_DATA_CEDIT2.this);



                getData_cedit_map=new GetData_cedit_map();
                getData_cedit_map.setGetDataAdapter1(GetDataAdapter1);


                recyclerView.setAdapter(contactAdapter);







                contactAdapter.notifyDataSetChanged();
                counter.setText(GetDataAdapter1.size() + "");
                DADADA = GetDataAdapter1.size() + "";


                contactAdapter.setitemclick(this);
                contactAdapter.setitemclick2(this);


                recyclerView.setHasFixedSize(true);

                recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

                recyclerView.setLayoutManager(recyclerViewlayoutManager);

/*                if (musicActivity_credit.dad == 1) {
                    recyclerView.smoothScrollToPosition(i - 1);

                } else {
                    try {
                        recyclerView.smoothScrollToPosition(0);
                        recyclerView.scrollToPosition(position2 - 1);
                    } catch (Exception ex) {

                    }
                }*/
                iis = i - 1;


                ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(contactAdapter);
                itemTouchHelper = new ItemTouchHelper(callback);
                itemTouchHelper.attachToRecyclerView(recyclerView);


                mShimmerViewContainer.stopShimmerAnimation();
                mShimmerViewContainer.setVisibility(View.GONE);


                if (iis == ContactAdapter2.position_adap) {

                    GetDataAdapter1.clear();
                    JSON_DATA_WEB_CALL();
                }

            }


        } catch (RuntimeException ex) {

        }

        try {
            progressDialog.dismiss();
        }
        catch (Exception E){

        }


    }


    public void JSON_PARSE_DATA_AFTER_WEBCALL3(JSONArray array) {
        GetDataAdapter1.clear();

        SQLiteDataBaseBuild_data_checker_all();
        SQLiteTableBuild_data_checker_all();

        for (i = 0; i < array.length(); i++) {

            final GetData_cedit GetDataAdapter2 = new GetData_cedit();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);

                getData_cedit = new GetData_cedit();
                GetDataAdapter2.setOutstanding(json.getString("Outstanding"));
                GetDataAdapter2.setPayLastPeriod(json.getString("PayLastPeriod"));
                GetDataAdapter2.setFnYear(json.getString("FnYear"));
                GetDataAdapter2.setFnMonth(json.getString("FnMonth"));
                GetDataAdapter2.setSaleEmployeeName(json.getString("SaleEmployeeName"));
                GetDataAdapter2.setSaleTeamCode(json.getString("SaleCode"));
                GetDataAdapter2.setCONTNO(json.getString("Contno"));
                GetDataAdapter2.setProductName(json.getString("ProductName"));
                GetDataAdapter2.setCustomerName(json.getString("CustomerName"));
                GetDataAdapter2.setIDCARD(json.getString("IDCard"));
                GetDataAdapter2.setAddressDetail(json.getString("Addressall"));
                GetDataAdapter2.setLatitude(json.getString("Latitude"));
                GetDataAdapter2.setLongitude(json.getString("Longitude"));
                GetDataAdapter2.setTelHome(json.getString("TelHome"));
                GetDataAdapter2.setTelMobile(json.getString("TelMobile"));
                GetDataAdapter2.setEFFDATE(json.getJSONObject("EffDate").getString("date"));





                if(json.getString("Latitude").equals("0.0")){


                    GetDataAdapter2.setdis("10000");

                        String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_data_checker_all.TABLE_NAME + " (CONTNO,RefNo,SaleEmployeeName,SaleTeamCode,SaleHeaderName,IDCARD,CustomerName,ADDRESSS,Tel,Tel2,ProductName,EFFDATE,Dis,Latitude,Longitude,Outstanding,PayLastPeriod,FnYear,FnMonth) VALUES('" + json.getString("Contno") + "','" + "1234" + "','" + json.getString("SaleEmployeeName") + "','" + json.getString("SaleCode") + "','" + "assanee" + "','" + json.getString("IDCard") + "','" + json.getString("CustomerName") + "','" + json.getString("Addressall")+ "','" + json.getString("TelHome")+ "','" + json.getString("TelMobile")+ "','" + json.getString("ProductName")+ "','" + json.getJSONObject("EffDate").getString("date")+ "','" + 10000.00+ "','" + json.getString("Latitude")+ "','" + json.getString("Longitude")+ "','" + json.getString("Outstanding")+ "','" + json.getString("PayLastPeriod")+ "','" + json.getString("FnYear")+ "','" + json.getString("FnMonth")/*String.valueOf(String.format("%.2f", dist))*/ + "');";
                        sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);



                }
                else {
                    getDistanceInfo("13.950481,100.668204",json.getString("Latitude")+","+json.getString("Longitude"));
                    GetDataAdapter2.setdis(String.valueOf(String.format("%.2f", dist)));
                    // GetDataAdapter2.setdis(String.valueOf(String.format("%.2f", dist)));

                    String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_data_checker_all.TABLE_NAME + " (CONTNO,RefNo,SaleEmployeeName,SaleTeamCode,SaleHeaderName,IDCARD,CustomerName,ADDRESSS,Tel,Tel2,ProductName,EFFDATE,Dis,Latitude,Longitude,Outstanding,PayLastPeriod,FnYear,FnMonth) VALUES('" + json.getString("Contno") + "','" + "1234" + "','" + json.getString("SaleEmployeeName") + "','" + json.getString("SaleCode") + "','" + "assanee" + "','" + json.getString("IDCard") + "','" + json.getString("CustomerName") + "','" + json.getString("Addressall")+ "','" + json.getString("TelHome")+ "','" + json.getString("TelMobile")+ "','" + json.getString("ProductName")+ "','" + json.getJSONObject("EffDate").getString("date")+ "','" + dist+ "','" + json.getString("Latitude")+ "','" + json.getString("Longitude")+ "','" + json.getString("Outstanding")+ "','" + json.getString("PayLastPeriod")+ "','" + json.getString("FnYear")+ "','" + json.getString("FnMonth")/*String.valueOf(String.format("%.2f", dist))*/ + "');";
                    sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);

                }





                iis++;




                //GetDataAdapter2.setDistant(json.getString(JSON_IssueName));
            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter2);
            //  pDialog.dismiss();
        }
        // ia = array.length();

        //hidePDialog();
        // MyApplication.getInstance().getPrefManager().setPreferrence("status_update_distant","1");

/*
        mShimmerViewContainer.stopShimmerAnimation();
        mShimmerViewContainer.setVisibility(View.GONE);

        contactAdapter = new ContactAdapter(recyclerView, GetDataAdapter1, getActivity(), UI_CARDVIEW_DATA_CEDIT.this, UI_CARDVIEW_DATA_CEDIT.this);
        recyclerView.setAdapter(contactAdapter);

*/







        GetDataAdapter1.clear();
        cursor = sqLiteDatabase.rawQuery("SELECT CONTNO,RefNo,SaleEmployeeName,SaleTeamCode,SaleHeaderName,IDCARD,CustomerName,ADDRESSS,Tel,Tel2,ProductName,EFFDATE,Dis,Latitude,Longitude,Outstanding,PayLastPeriod,FnYear,FnMonth FROM "+SQLiteHelper_data_checker_all.TABLE_NAME+""  +" order  by Dis ASC"   , null);
        if (cursor.moveToFirst()) {
            do {

                final GetData_cedit GetDataAdapter2 = new GetData_cedit();


                String Table_CONTNO = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_CONTNO));
                //String Table_RefNo = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_RefNo));
                String Table_SaleEmployeeName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleEmployeeName));
                String Table_SaleTeamCode = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleTeamCode));
                //String Table_SaleHeaderName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleHeaderName));
                String Table_IDCARD = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_IDCARD));
                String Table_CustomerName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_CustomerName));
                String Table_ADDRESSS = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_ADDRESSS));
                String Table_Tel = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Tel));
                String Table_Tel_MOBILE = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Tel2));
                String Table_ProductName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_ProductName));
                String Table_EFFDATE = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_EFFDATE));
                String Table_Dis = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Dis));

                String Table_Latitude = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Latitude));
                String Table_Longitude = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Longitude));
                String Table_Outstanding = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Outstanding));
                String Table_PayLastPeriod = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_PayLastPeriod));
                String Table_FnYear = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_FnYear));
                String Table_FnMonth = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_FnMonth));

                Log.e("Table_Dis", Table_Dis);

                if(Double.parseDouble(Table_Dis)<=99){
                    GetDataAdapter2.setSaleEmployeeName(Table_SaleEmployeeName);
                    GetDataAdapter2.setSaleTeamCode(Table_SaleTeamCode);
                    GetDataAdapter2.setCONTNO(Table_CONTNO);
                    GetDataAdapter2.setProductName(Table_ProductName);
                    GetDataAdapter2.setCustomerName(Table_CustomerName);
                    GetDataAdapter2.setIDCARD(Table_IDCARD);
                    GetDataAdapter2.setAddressDetail(Table_ADDRESSS);
                    GetDataAdapter2.setTelHome(Table_Tel);
                    GetDataAdapter2.setTelMobile(Table_Tel_MOBILE);
                    GetDataAdapter2.setEFFDATE(Table_EFFDATE);
                    GetDataAdapter2.setdis(Table_Dis);

                    GetDataAdapter2.setLatitude(Table_Latitude);
                    GetDataAdapter2.setLongitude(Table_Longitude);
                    GetDataAdapter2.setOutstanding(Table_Outstanding);
                    GetDataAdapter2.setPayLastPeriod(Table_PayLastPeriod);
                    GetDataAdapter2.setFnYear(Table_FnYear);
                    GetDataAdapter2.setFnMonth(Table_FnMonth);

                    GetDataAdapter1.add(GetDataAdapter2);
                }


            } while (cursor.moveToNext());
        }
        cursor.close();


        cursor = sqLiteDatabase.rawQuery("SELECT CONTNO,RefNo,SaleEmployeeName,SaleTeamCode,SaleHeaderName,IDCARD,CustomerName,ADDRESSS,Tel,Tel2,ProductName,EFFDATE,Dis,Latitude,Longitude,Outstanding,PayLastPeriod,FnYear,FnMonth FROM "+SQLiteHelper_data_checker_all.TABLE_NAME+""  +" order  by Dis ASC"   , null);
        if (cursor.moveToFirst()) {
            do {

                final GetData_cedit GetDataAdapter2 = new GetData_cedit();


                String Table_CONTNO = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_CONTNO));
                //String Table_RefNo = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_RefNo));
                String Table_SaleEmployeeName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleEmployeeName));
                String Table_SaleTeamCode = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleTeamCode));
                //String Table_SaleHeaderName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleHeaderName));
                String Table_IDCARD = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_IDCARD));
                String Table_CustomerName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_CustomerName));
                String Table_ADDRESSS = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_ADDRESSS));
                String Table_Tel = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Tel));
                String Table_Tel_MOBILE = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Tel2));
                String Table_ProductName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_ProductName));
                String Table_EFFDATE = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_EFFDATE));
                String Table_Dis = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Dis));

                String Table_Latitude = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Latitude));
                String Table_Longitude = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Longitude));
                String Table_Outstanding = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Outstanding));
                String Table_PayLastPeriod = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_PayLastPeriod));
                String Table_FnYear = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_FnYear));
                String Table_FnMonth = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_FnMonth));

                Log.e("Table_Dis", Table_Dis);

                if((Double.parseDouble(Table_Dis)>99)&(Double.parseDouble(Table_Dis)<=999)){
                    GetDataAdapter2.setSaleEmployeeName(Table_SaleEmployeeName);
                    GetDataAdapter2.setSaleTeamCode(Table_SaleTeamCode);
                    GetDataAdapter2.setCONTNO(Table_CONTNO);
                    GetDataAdapter2.setProductName(Table_ProductName);
                    GetDataAdapter2.setCustomerName(Table_CustomerName);
                    GetDataAdapter2.setIDCARD(Table_IDCARD);
                    GetDataAdapter2.setAddressDetail(Table_ADDRESSS);
                    GetDataAdapter2.setTelHome(Table_Tel);
                    GetDataAdapter2.setTelMobile(Table_Tel_MOBILE);
                    GetDataAdapter2.setEFFDATE(Table_EFFDATE);
                    GetDataAdapter2.setdis(Table_Dis);

                    GetDataAdapter2.setLatitude(Table_Latitude);
                    GetDataAdapter2.setLongitude(Table_Longitude);
                    GetDataAdapter2.setOutstanding(Table_Outstanding);
                    GetDataAdapter2.setPayLastPeriod(Table_PayLastPeriod);
                    GetDataAdapter2.setFnYear(Table_FnYear);
                    GetDataAdapter2.setFnMonth(Table_FnMonth);
                    GetDataAdapter1.add(GetDataAdapter2);
                }


            } while (cursor.moveToNext());
        }
        cursor.close();


        cursor = sqLiteDatabase.rawQuery("SELECT CONTNO,RefNo,SaleEmployeeName,SaleTeamCode,SaleHeaderName,IDCARD,CustomerName,ADDRESSS,Tel,Tel2,ProductName,EFFDATE,Dis,Latitude,Longitude,Outstanding,PayLastPeriod,FnYear,FnMonth FROM "+SQLiteHelper_data_checker_all.TABLE_NAME+""  +" order  by Dis ASC"   , null);
        if (cursor.moveToFirst()) {
            do {

                final GetData_cedit GetDataAdapter2 = new GetData_cedit();


                String Table_CONTNO = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_CONTNO));
                //String Table_RefNo = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_RefNo));
                String Table_SaleEmployeeName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleEmployeeName));
                String Table_SaleTeamCode = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleTeamCode));
                //String Table_SaleHeaderName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleHeaderName));
                String Table_IDCARD = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_IDCARD));
                String Table_CustomerName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_CustomerName));
                String Table_ADDRESSS = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_ADDRESSS));
                String Table_Tel = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Tel));
                String Table_Tel_MOBILE = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Tel2));
                String Table_ProductName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_ProductName));
                String Table_EFFDATE = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_EFFDATE));
                String Table_Dis = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Dis));

                String Table_Latitude = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Latitude));
                String Table_Longitude = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Longitude));
                String Table_Outstanding = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Outstanding));
                String Table_PayLastPeriod = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_PayLastPeriod));
                String Table_FnYear = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_FnYear));
                String Table_FnMonth = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_FnMonth));

                Log.e("Table_Dis", Table_Dis);

                if((Double.parseDouble(Table_Dis)>=1000)&(Double.parseDouble(Table_Dis)<10000)){
                    GetDataAdapter2.setSaleEmployeeName(Table_SaleEmployeeName);
                    GetDataAdapter2.setSaleTeamCode(Table_SaleTeamCode);
                    GetDataAdapter2.setCONTNO(Table_CONTNO);
                    GetDataAdapter2.setProductName(Table_ProductName);
                    GetDataAdapter2.setCustomerName(Table_CustomerName);
                    GetDataAdapter2.setIDCARD(Table_IDCARD);
                    GetDataAdapter2.setAddressDetail(Table_ADDRESSS);
                    GetDataAdapter2.setTelHome(Table_Tel);
                    GetDataAdapter2.setTelMobile(Table_Tel_MOBILE);
                    GetDataAdapter2.setEFFDATE(Table_EFFDATE);
                    GetDataAdapter2.setdis(Table_Dis);

                    GetDataAdapter2.setLatitude(Table_Latitude);
                    GetDataAdapter2.setLongitude(Table_Longitude);
                    GetDataAdapter2.setOutstanding(Table_Outstanding);
                    GetDataAdapter2.setPayLastPeriod(Table_PayLastPeriod);
                    GetDataAdapter2.setFnYear(Table_FnYear);
                    GetDataAdapter2.setFnMonth(Table_FnMonth);
                    GetDataAdapter1.add(GetDataAdapter2);
                }


            } while (cursor.moveToNext());
        }
        cursor.close();

        cursor = sqLiteDatabase.rawQuery("SELECT CONTNO,RefNo,SaleEmployeeName,SaleTeamCode,SaleHeaderName,IDCARD,CustomerName,ADDRESSS,Tel,Tel2,ProductName,EFFDATE,Dis,Latitude,Longitude,Outstanding,PayLastPeriod,FnYear,FnMonth FROM "+SQLiteHelper_data_checker_all.TABLE_NAME+""  +" order  by Dis ASC"   , null);
        if (cursor.moveToFirst()) {
            do {

                final GetData_cedit GetDataAdapter2 = new GetData_cedit();


                String Table_CONTNO = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_CONTNO));
                //String Table_RefNo = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_RefNo));
                String Table_SaleEmployeeName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleEmployeeName));
                String Table_SaleTeamCode = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleTeamCode));
                //String Table_SaleHeaderName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleHeaderName));
                String Table_IDCARD = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_IDCARD));
                String Table_CustomerName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_CustomerName));
                String Table_ADDRESSS = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_ADDRESSS));
                String Table_Tel = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Tel));
                String Table_Tel_MOBILE = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Tel2));
                String Table_ProductName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_ProductName));
                String Table_EFFDATE = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_EFFDATE));
                String Table_Dis = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Dis));

                String Table_Latitude = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Latitude));
                String Table_Longitude = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Longitude));
                String Table_Outstanding = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Outstanding));
                String Table_PayLastPeriod = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_PayLastPeriod));
                String Table_FnYear = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_FnYear));
                String Table_FnMonth = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_FnMonth));

                Log.e("Table_Dis", Table_Dis);

                if(Double.parseDouble(Table_Dis)==10000){
                    GetDataAdapter2.setSaleEmployeeName(Table_SaleEmployeeName);
                    GetDataAdapter2.setSaleTeamCode(Table_SaleTeamCode);
                    GetDataAdapter2.setCONTNO(Table_CONTNO);
                    GetDataAdapter2.setProductName(Table_ProductName);
                    GetDataAdapter2.setCustomerName(Table_CustomerName);
                    GetDataAdapter2.setIDCARD(Table_IDCARD);
                    GetDataAdapter2.setAddressDetail(Table_ADDRESSS);
                    GetDataAdapter2.setTelHome(Table_Tel);
                    GetDataAdapter2.setTelMobile(Table_Tel_MOBILE);
                    GetDataAdapter2.setEFFDATE(Table_EFFDATE);
                    GetDataAdapter2.setdis("ไม่มีตำแหน่ง");

                    GetDataAdapter2.setLatitude(Table_Latitude);
                    GetDataAdapter2.setLongitude(Table_Longitude);
                    GetDataAdapter2.setOutstanding(Table_Outstanding);
                    GetDataAdapter2.setPayLastPeriod(Table_PayLastPeriod);
                    GetDataAdapter2.setFnYear(Table_FnYear);
                    GetDataAdapter2.setFnMonth(Table_FnMonth);
                    GetDataAdapter1.add(GetDataAdapter2);
                }


            } while (cursor.moveToNext());
        }
        cursor.close();

        MyApplication.getInstance().getPrefManager().setPreferrence("intro_save", "1");


        try {

            String dat2 = MyApplication.getInstance().getPrefManager().getPreferrence("dat2");

            if ((dat2.equals("0")) | (dat2.equals("null"))) {

                contactAdapter = new ContactAdapter2(recyclerView, GetDataAdapter1, getActivity(), UI_CARDVIEW_DATA_CEDIT2.this, UI_CARDVIEW_DATA_CEDIT2.this);

                getData_cedit_map = new GetData_cedit_map();
                getData_cedit_map.setGetDataAdapter1(GetDataAdapter1);

                recyclerView.setAdapter(contactAdapter);

                contactAdapter.notifyDataSetChanged();


                counter.setText(GetDataAdapter1.size() + "");
                DADADA = GetDataAdapter1.size() + "";

                contactAdapter.setitemclick(this);
                contactAdapter.setitemclick2(this);


                recyclerView.setHasFixedSize(true);

                recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

                recyclerView.setLayoutManager(recyclerViewlayoutManager);

   /*             if (musicActivity_credit.dad == 1) {
                    recyclerView.smoothScrollToPosition(i - 1);

                } else if (musicActivity_credit.dad == 2) {
                    recyclerView.smoothScrollToPosition(i - 1);

                } else {
                    try {
                        recyclerView.smoothScrollToPosition(0);
                        recyclerView.scrollToPosition(position2 - 1);
                    } catch (Exception ex) {

                    }

                }*/

                iis = i - 1;


                ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(contactAdapter);
                itemTouchHelper = new ItemTouchHelper(callback);
                itemTouchHelper.attachToRecyclerView(recyclerView);


                mShimmerViewContainer.stopShimmerAnimation();
                mShimmerViewContainer.setVisibility(View.GONE);


                if (iis == ContactAdapter2.position_adap) {

                    GetDataAdapter1.clear();
                    JSON_DATA_WEB_CALL();
                }


            } else {
                //this.GetDataAdapter1 = getOrderItem(GetDataAdapter1);
                this.GetDataAdapter1 = getOrderItem(GetDataAdapter1);
                contactAdapter = new ContactAdapter2(recyclerView, GetDataAdapter1, getActivity(), UI_CARDVIEW_DATA_CEDIT2.this, UI_CARDVIEW_DATA_CEDIT2.this);



                getData_cedit_map=new GetData_cedit_map();
                getData_cedit_map.setGetDataAdapter1(GetDataAdapter1);


                recyclerView.setAdapter(contactAdapter);







                contactAdapter.notifyDataSetChanged();
                counter.setText(GetDataAdapter1.size() + "");
                DADADA = GetDataAdapter1.size() + "";


                contactAdapter.setitemclick(this);
                contactAdapter.setitemclick2(this);


                recyclerView.setHasFixedSize(true);

                recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

                recyclerView.setLayoutManager(recyclerViewlayoutManager);

/*                if (musicActivity_credit.dad == 1) {
                    recyclerView.smoothScrollToPosition(i - 1);

                } else {
                    try {
                        recyclerView.smoothScrollToPosition(0);
                        recyclerView.scrollToPosition(position2 - 1);
                    } catch (Exception ex) {

                    }
                }*/
                iis = i - 1;


                ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(contactAdapter);
                itemTouchHelper = new ItemTouchHelper(callback);
                itemTouchHelper.attachToRecyclerView(recyclerView);


                mShimmerViewContainer.stopShimmerAnimation();
                mShimmerViewContainer.setVisibility(View.GONE);


                if (iis == ContactAdapter2.position_adap) {

                    GetDataAdapter1.clear();
                    JSON_DATA_WEB_CALL();
                }

            }


        } catch (RuntimeException ex) {

        }

        try {
            progressDialog.dismiss();
        }
        catch (Exception E){

        }

        dad =0;
    }
private void data_old(){
    GetDataAdapter1.clear();
    cursor = sqLiteDatabase.rawQuery("SELECT CONTNO,RefNo,SaleEmployeeName,SaleTeamCode,SaleHeaderName,IDCARD,CustomerName,ADDRESSS,Tel,Tel2,ProductName,EFFDATE,Dis,Latitude,Longitude,Outstanding,PayLastPeriod,FnYear,FnMonth FROM "+SQLiteHelper_data_checker_all.TABLE_NAME+""  +" order  by Dis ASC"   , null);
    if (cursor.moveToFirst()) {
        do {

            final GetData_cedit GetDataAdapter2 = new GetData_cedit();


            String Table_CONTNO = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_CONTNO));
            //String Table_RefNo = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_RefNo));
            String Table_SaleEmployeeName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleEmployeeName));
            String Table_SaleTeamCode = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleTeamCode));
            //String Table_SaleHeaderName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleHeaderName));
            String Table_IDCARD = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_IDCARD));
            String Table_CustomerName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_CustomerName));
            String Table_ADDRESSS = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_ADDRESSS));
            String Table_Tel = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Tel));
            String Table_Tel_MOBILE = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Tel2));
            String Table_ProductName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_ProductName));
            String Table_EFFDATE = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_EFFDATE));
            String Table_Dis = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Dis));

            String Table_Latitude = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Latitude));
            String Table_Longitude = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Longitude));
            String Table_Outstanding = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Outstanding));
            String Table_PayLastPeriod = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_PayLastPeriod));
            String Table_FnYear = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_FnYear));
            String Table_FnMonth = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_FnMonth));

            Log.e("Table_Dis", Table_Dis);

            if(Double.parseDouble(Table_Dis)<=99){
                GetDataAdapter2.setSaleEmployeeName(Table_SaleEmployeeName);
                GetDataAdapter2.setSaleTeamCode(Table_SaleTeamCode);
                GetDataAdapter2.setCONTNO(Table_CONTNO);
                GetDataAdapter2.setProductName(Table_ProductName);
                GetDataAdapter2.setCustomerName(Table_CustomerName);
                GetDataAdapter2.setIDCARD(Table_IDCARD);
                GetDataAdapter2.setAddressDetail(Table_ADDRESSS);
                GetDataAdapter2.setTelHome(Table_Tel);
                GetDataAdapter2.setTelMobile(Table_Tel_MOBILE);
                GetDataAdapter2.setEFFDATE(Table_EFFDATE);
                GetDataAdapter2.setdis(Table_Dis);

                GetDataAdapter2.setLatitude(Table_Latitude);
                GetDataAdapter2.setLongitude(Table_Longitude);
                GetDataAdapter2.setOutstanding(Table_Outstanding);
                GetDataAdapter2.setPayLastPeriod(Table_PayLastPeriod);
                GetDataAdapter2.setFnYear(Table_FnYear);
                GetDataAdapter2.setFnMonth(Table_FnMonth);
                GetDataAdapter1.add(GetDataAdapter2);
            }


        } while (cursor.moveToNext());
    }
    cursor.close();


    cursor = sqLiteDatabase.rawQuery("SELECT CONTNO,RefNo,SaleEmployeeName,SaleTeamCode,SaleHeaderName,IDCARD,CustomerName,ADDRESSS,Tel,Tel2,ProductName,EFFDATE,Dis,Latitude,Longitude,Outstanding,PayLastPeriod,FnYear,FnMonth FROM "+SQLiteHelper_data_checker_all.TABLE_NAME+""  +" order  by Dis ASC"   , null);
    if (cursor.moveToFirst()) {
        do {

            final GetData_cedit GetDataAdapter2 = new GetData_cedit();


            String Table_CONTNO = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_CONTNO));
            //String Table_RefNo = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_RefNo));
            String Table_SaleEmployeeName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleEmployeeName));
            String Table_SaleTeamCode = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleTeamCode));
            //String Table_SaleHeaderName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleHeaderName));
            String Table_IDCARD = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_IDCARD));
            String Table_CustomerName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_CustomerName));
            String Table_ADDRESSS = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_ADDRESSS));
            String Table_Tel = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Tel));
            String Table_Tel_MOBILE = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Tel2));
            String Table_ProductName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_ProductName));
            String Table_EFFDATE = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_EFFDATE));
            String Table_Dis = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Dis));

            String Table_Latitude = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Latitude));
            String Table_Longitude = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Longitude));
            String Table_Outstanding = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Outstanding));
            String Table_PayLastPeriod = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_PayLastPeriod));
            String Table_FnYear = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_FnYear));
            String Table_FnMonth = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_FnMonth));

            Log.e("Table_Dis", Table_Dis);

            if((Double.parseDouble(Table_Dis)>99)&(Double.parseDouble(Table_Dis)<=999)){
                GetDataAdapter2.setSaleEmployeeName(Table_SaleEmployeeName);
                GetDataAdapter2.setSaleTeamCode(Table_SaleTeamCode);
                GetDataAdapter2.setCONTNO(Table_CONTNO);
                GetDataAdapter2.setProductName(Table_ProductName);
                GetDataAdapter2.setCustomerName(Table_CustomerName);
                GetDataAdapter2.setIDCARD(Table_IDCARD);
                GetDataAdapter2.setAddressDetail(Table_ADDRESSS);
                GetDataAdapter2.setTelHome(Table_Tel);
                GetDataAdapter2.setTelMobile(Table_Tel_MOBILE);
                GetDataAdapter2.setEFFDATE(Table_EFFDATE);
                GetDataAdapter2.setdis(Table_Dis);

                GetDataAdapter2.setLatitude(Table_Latitude);
                GetDataAdapter2.setLongitude(Table_Longitude);
                GetDataAdapter2.setOutstanding(Table_Outstanding);
                GetDataAdapter2.setPayLastPeriod(Table_PayLastPeriod);
                GetDataAdapter2.setFnYear(Table_FnYear);
                GetDataAdapter2.setFnMonth(Table_FnMonth);
                GetDataAdapter1.add(GetDataAdapter2);
            }


        } while (cursor.moveToNext());
    }
    cursor.close();


    cursor = sqLiteDatabase.rawQuery("SELECT CONTNO,RefNo,SaleEmployeeName,SaleTeamCode,SaleHeaderName,IDCARD,CustomerName,ADDRESSS,Tel,Tel2,ProductName,EFFDATE,Dis,Latitude,Longitude,Outstanding,PayLastPeriod,FnYear,FnMonth FROM "+SQLiteHelper_data_checker_all.TABLE_NAME+""  +" order  by Dis ASC"   , null);
    if (cursor.moveToFirst()) {
        do {

            final GetData_cedit GetDataAdapter2 = new GetData_cedit();


            String Table_CONTNO = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_CONTNO));
            //String Table_RefNo = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_RefNo));
            String Table_SaleEmployeeName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleEmployeeName));
            String Table_SaleTeamCode = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleTeamCode));
            //String Table_SaleHeaderName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleHeaderName));
            String Table_IDCARD = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_IDCARD));
            String Table_CustomerName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_CustomerName));
            String Table_ADDRESSS = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_ADDRESSS));
            String Table_Tel = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Tel));
            String Table_Tel_MOBILE = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Tel2));
            String Table_ProductName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_ProductName));
            String Table_EFFDATE = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_EFFDATE));
            String Table_Dis = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Dis));

            String Table_Latitude = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Latitude));
            String Table_Longitude = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Longitude));
            String Table_Outstanding = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Outstanding));
            String Table_PayLastPeriod = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_PayLastPeriod));
            String Table_FnYear = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_FnYear));
            String Table_FnMonth = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_FnMonth));

            Log.e("Table_Dis", Table_Dis);

            if((Double.parseDouble(Table_Dis)>=1000)&(Double.parseDouble(Table_Dis)<10000)){
                GetDataAdapter2.setSaleEmployeeName(Table_SaleEmployeeName);
                GetDataAdapter2.setSaleTeamCode(Table_SaleTeamCode);
                GetDataAdapter2.setCONTNO(Table_CONTNO);
                GetDataAdapter2.setProductName(Table_ProductName);
                GetDataAdapter2.setCustomerName(Table_CustomerName);
                GetDataAdapter2.setIDCARD(Table_IDCARD);
                GetDataAdapter2.setAddressDetail(Table_ADDRESSS);
                GetDataAdapter2.setTelHome(Table_Tel);
                GetDataAdapter2.setTelMobile(Table_Tel_MOBILE);
                GetDataAdapter2.setEFFDATE(Table_EFFDATE);
                GetDataAdapter2.setdis(Table_Dis);

                GetDataAdapter2.setLatitude(Table_Latitude);
                GetDataAdapter2.setLongitude(Table_Longitude);
                GetDataAdapter2.setOutstanding(Table_Outstanding);
                GetDataAdapter2.setPayLastPeriod(Table_PayLastPeriod);
                GetDataAdapter2.setFnYear(Table_FnYear);
                GetDataAdapter2.setFnMonth(Table_FnMonth);
                GetDataAdapter1.add(GetDataAdapter2);
            }


        } while (cursor.moveToNext());
    }
    cursor.close();



    cursor = sqLiteDatabase.rawQuery("SELECT CONTNO,RefNo,SaleEmployeeName,SaleTeamCode,SaleHeaderName,IDCARD,CustomerName,ADDRESSS,Tel,Tel2,ProductName,EFFDATE,Dis,Latitude,Longitude,Outstanding,PayLastPeriod,FnYear,FnMonth FROM "+SQLiteHelper_data_checker_all.TABLE_NAME+""  +" order  by Dis ASC"   , null);
    if (cursor.moveToFirst()) {
        do {

            final GetData_cedit GetDataAdapter2 = new GetData_cedit();


            String Table_CONTNO = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_CONTNO));
            //String Table_RefNo = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_RefNo));
            String Table_SaleEmployeeName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleEmployeeName));
            String Table_SaleTeamCode = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleTeamCode));
            //String Table_SaleHeaderName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_SaleHeaderName));
            String Table_IDCARD = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_IDCARD));
            String Table_CustomerName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_CustomerName));
            String Table_ADDRESSS = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_ADDRESSS));
            String Table_Tel = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Tel));
            String Table_Tel_MOBILE = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Tel2));
            String Table_ProductName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_ProductName));
            String Table_EFFDATE = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_EFFDATE));
            String Table_Dis = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Dis));

            String Table_Latitude = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Latitude));
            String Table_Longitude = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Longitude));
            String Table_Outstanding = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_Outstanding));
            String Table_PayLastPeriod = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_PayLastPeriod));
            String Table_FnYear = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_FnYear));
            String Table_FnMonth = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_all.Table_FnMonth));

            Log.e("Table_Dis", Table_Dis);

            if(Double.parseDouble(Table_Dis)==10000){
                GetDataAdapter2.setSaleEmployeeName(Table_SaleEmployeeName);
                GetDataAdapter2.setSaleTeamCode(Table_SaleTeamCode);
                GetDataAdapter2.setCONTNO(Table_CONTNO);
                GetDataAdapter2.setProductName(Table_ProductName);
                GetDataAdapter2.setCustomerName(Table_CustomerName);
                GetDataAdapter2.setIDCARD(Table_IDCARD);
                GetDataAdapter2.setAddressDetail(Table_ADDRESSS);
                GetDataAdapter2.setTelHome(Table_Tel);
                GetDataAdapter2.setTelMobile(Table_Tel_MOBILE);
                GetDataAdapter2.setEFFDATE(Table_EFFDATE);
                GetDataAdapter2.setdis("ไม่มีตำแหน่ง");

                GetDataAdapter2.setLatitude(Table_Latitude);
                GetDataAdapter2.setLongitude(Table_Longitude);
                GetDataAdapter2.setOutstanding(Table_Outstanding);
                GetDataAdapter2.setPayLastPeriod(Table_PayLastPeriod);
                GetDataAdapter2.setFnYear(Table_FnYear);
                GetDataAdapter2.setFnMonth(Table_FnMonth);
                GetDataAdapter1.add(GetDataAdapter2);
            }


        } while (cursor.moveToNext());
    }
    cursor.close();


    try {

        String dat2 = MyApplication.getInstance().getPrefManager().getPreferrence("dat2");

        if ((dat2.equals("0")) | (dat2.equals("null"))) {

            contactAdapter = new ContactAdapter2(recyclerView, GetDataAdapter1, getActivity(), UI_CARDVIEW_DATA_CEDIT2.this, UI_CARDVIEW_DATA_CEDIT2.this);

            getData_cedit_map = new GetData_cedit_map();
            getData_cedit_map.setGetDataAdapter1(GetDataAdapter1);

            recyclerView.setAdapter(contactAdapter);

            contactAdapter.notifyDataSetChanged();


            counter.setText(GetDataAdapter1.size() + "");
            DADADA = GetDataAdapter1.size() + "";

            contactAdapter.setitemclick(this);
            contactAdapter.setitemclick2(this);


            recyclerView.setHasFixedSize(true);

            recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

            recyclerView.setLayoutManager(recyclerViewlayoutManager);

/*            if (musicActivity_credit.dad == 1) {
                recyclerView.smoothScrollToPosition(i - 1);

            } else if (musicActivity_credit.dad == 2) {
                recyclerView.smoothScrollToPosition(i - 1);

            } else {
                try {
                    recyclerView.smoothScrollToPosition(0);
                    recyclerView.scrollToPosition(position2 - 1);
                } catch (Exception ex) {

                }

            }*/

            iis = i - 1;


            ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(contactAdapter);
            itemTouchHelper = new ItemTouchHelper(callback);
            itemTouchHelper.attachToRecyclerView(recyclerView);


            mShimmerViewContainer.stopShimmerAnimation();
            mShimmerViewContainer.setVisibility(View.GONE);


            if (iis == ContactAdapter2.position_adap) {

                GetDataAdapter1.clear();
                JSON_DATA_WEB_CALL();
            }


        } else {
            //this.GetDataAdapter1 = getOrderItem(GetDataAdapter1);
            this.GetDataAdapter1 = getOrderItem(GetDataAdapter1);
            contactAdapter = new ContactAdapter2(recyclerView, GetDataAdapter1, getActivity(), UI_CARDVIEW_DATA_CEDIT2.this, UI_CARDVIEW_DATA_CEDIT2.this);



            getData_cedit_map=new GetData_cedit_map();
            getData_cedit_map.setGetDataAdapter1(GetDataAdapter1);


            recyclerView.setAdapter(contactAdapter);







            contactAdapter.notifyDataSetChanged();
            counter.setText(GetDataAdapter1.size() + "");
            DADADA = GetDataAdapter1.size() + "";


            contactAdapter.setitemclick(this);
            contactAdapter.setitemclick2(this);


            recyclerView.setHasFixedSize(true);

            recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

            recyclerView.setLayoutManager(recyclerViewlayoutManager);

/*            if (musicActivity_credit.dad == 1) {
                recyclerView.smoothScrollToPosition(i - 1);

            } else {
                try {
                    recyclerView.smoothScrollToPosition(0);
                    recyclerView.scrollToPosition(position2 - 1);
                } catch (Exception ex) {

                }
            }*/
            iis = i - 1;


            ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(contactAdapter);
            itemTouchHelper = new ItemTouchHelper(callback);
            itemTouchHelper.attachToRecyclerView(recyclerView);


            mShimmerViewContainer.stopShimmerAnimation();
            mShimmerViewContainer.setVisibility(View.GONE);


            if (iis == ContactAdapter2.position_adap) {

                GetDataAdapter1.clear();
                JSON_DATA_WEB_CALL();
            }

        }


    } catch (RuntimeException ex) {

    }

    try {
        progressDialog.dismiss();
    }
    catch (Exception E){

    }


}


    @Override
    public void onResume() {
        super.onResume();
        mShimmerViewContainer.startShimmerAnimation();
    }

    @Override
    public void onPause() {
        mShimmerViewContainer.stopShimmerAnimation();
        super.onPause();
    }


    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }


    @Override
    public void onCreateOptionsMenu(
            Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main3, menu);
       MenuItem menuItem = menu.findItem(R.id.testAction);
        MenuItem menuItem2 = menu.findItem(R.id.testAction2);
        MenuItem menuItem3 = menu.findItem(R.id.testAction3);
        MenuItem menuItem4 = menu.findItem(R.id.testAction4);
        MenuItem menuItem5 = menu.findItem(R.id.testAction5);

        MenuItem menuItemุ6 = menu.findItem(R.id.action_search);
       MenuItem menuItemุ7 = menu.findItem(R.id.update_location);
        MenuItem menuItemุ8 = menu.findItem(R.id.action_setting);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItemุ6);
        search(searchView);



        if (!searchView.isIconified()) {
            searchView.setQuery("", false);
            JSON_DATA_WEB_CALL();
        }


        menuItem.setVisible(false);
        menuItem2.setVisible(false);
        menuItem3.setVisible(false);
        menuItem4.setVisible(false);
        menuItemุ7.setVisible(false);
        menuItemุ8.setVisible(false);


    }


    private void search(final SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {


                position2 = 0;

                recyclerView.setHasFixedSize(true);

                recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

                recyclerView.setLayoutManager(recyclerViewlayoutManager);
                mShimmerViewContainer.stopShimmerAnimation();
                mShimmerViewContainer.setVisibility(View.VISIBLE);
                GetDataAdapter1.clear();


                JSON_DATA_WEB_CALL_SE(query);
                searchView.clearFocus();


                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

     /*           if (contactAdapter != null)
                    contactAdapter.getFilter().filter(newText);

                if (newText.equals("")) {
                    GetDataAdapter1.clear();
                    try {
                        contactAdapter.getFilter().filter("");
                    }
                    catch (Exception ex){

                    }


                    recyclerView.setHasFixedSize(true);

                    recyclerViewlayoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(recyclerViewlayoutManager);
                    JSON_DATA_WEB_CALL();
                }*/

                return true;


            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();




        return super.onOptionsItemSelected(item);
    }

    @Override
    public void click(View v, int position) {

    }

    @Override
    public void click2(View v, int position) {
        try {

            GetData_cedit getData_cedit = GetDataAdapter1.get(position);
            position2 = position;

            if(getData_cedit.getCheckerStatus().equals("99")) {

                Intent Intent = new Intent(getActivity(), Detali_data_cedit3_4.class);

                Bundle bun = new Bundle();
                //    bun.putString("from","by_cedit");
                bun.putString("CheckerStatus", getData_cedit.getCheckerStatus());
                bun.putString("CheckerStatusName", getData_cedit.getCheckerStatusName());
                bun.putString("ProductSerial", getData_cedit.getProductSerial());
                bun.putString("Outstanding", getData_cedit.getOutstanding());
                bun.putString("PayLastPeriod", getData_cedit.getPayLastPeriod());

                bun.putString("FnYear", getData_cedit.getFnYear());
                bun.putString("FnMonth", getData_cedit.getFnMonth());

                bun.putString("conno", getData_cedit.getCONTNO());
                bun.putString("RefNo", getData_cedit.getRefNo());
                bun.putString("isremark", getData_cedit.getisremark());

                bun.putString("SaleEmployeeName", getData_cedit.getSaleEmployeeName());
                bun.putString("SaleTeamCode", getData_cedit.getSaleTeamCode());
                bun.putString("SaleHeaderName", getData_cedit.getSaleHeaderName());

                bun.putString("productname", getData_cedit.getProductName());
                bun.putString("status", getData_cedit.getstatusName());
                bun.putString("customer", getData_cedit.getCustomerName());
                bun.putString("idcard", getData_cedit.getIDCARD());
                bun.putString("address", getData_cedit.getAddressDetail());
                bun.putString("phone_home", getData_cedit.getTelHome());
                bun.putString("phone_mobile", getData_cedit.getTelMobile());
                bun.putString("date", getData_cedit.getEFFDATE());

                bun.putString("Latitude", getData_cedit.getLatitude());
                bun.putString("Longitude", getData_cedit.getLongitude());


                bun.putString("status_qrcode", getData_cedit.getstatus_qrcode());
                bun.putString("distance", getData_cedit.getdistance());

                bun.putString("salename", getData_cedit.getsalename());
                bun.putString("teamcode", getData_cedit.getteamcode());
                bun.putString("headname", getData_cedit.getheadname());
                bun.putString("lat_long", getData_cedit.getlat_long());

                bun.putString("conno2", getData_cedit.getconno());
                bun.putString("conno_qr_code", getData_cedit.getconno_qr_code());

                bun.putString("product_name", getData_cedit.getproduct_name());
                bun.putString("status2", getData_cedit.getstatus());
                bun.putString("name_customer", getData_cedit.getname_customer());
                bun.putString("id_card", getData_cedit.getid_card());
                bun.putString("address2", getData_cedit.getaddress());
                bun.putString("number_phone", getData_cedit.getnumber_phone());
                bun.putString("date2", getData_cedit.getdate());
                bun.putString("status_app", getData_cedit.getstatus_app());
                bun.putString("Description", getData_cedit.getIssueName());
                Intent.putExtras(bun);

                startActivityForResult(Intent, 23);
            }
            else {

                Intent Intent = new Intent(getActivity(), Detali_data_cedit3_2.class);


                Bundle bun = new Bundle();
                //    bun.putString("from","by_cedit");
                bun.putString("CheckerStatus", getData_cedit.getCheckerStatus());
                bun.putString("CheckerStatusName", getData_cedit.getCheckerStatusName());
                bun.putString("ProductSerial", getData_cedit.getProductSerial());
                bun.putString("Outstanding", getData_cedit.getOutstanding());
                bun.putString("PayLastPeriod", getData_cedit.getPayLastPeriod());

                bun.putString("FnYear", getData_cedit.getFnYear());
                bun.putString("FnMonth", getData_cedit.getFnMonth());

                bun.putString("conno", getData_cedit.getCONTNO());
                bun.putString("RefNo", getData_cedit.getRefNo());
                bun.putString("isremark", getData_cedit.getisremark());

                bun.putString("SaleEmployeeName", getData_cedit.getSaleEmployeeName());
                bun.putString("SaleTeamCode", getData_cedit.getSaleTeamCode());
                bun.putString("SaleHeaderName", getData_cedit.getSaleHeaderName());

                bun.putString("productname", getData_cedit.getProductName());
                bun.putString("status", getData_cedit.getstatusName());
                bun.putString("customer", getData_cedit.getCustomerName());
                bun.putString("idcard", getData_cedit.getIDCARD());
                bun.putString("address", getData_cedit.getAddressDetail());
                bun.putString("phone_home", getData_cedit.getTelHome());
                bun.putString("phone_mobile", getData_cedit.getTelMobile());
                bun.putString("date", getData_cedit.getEFFDATE());

                bun.putString("Latitude", getData_cedit.getLatitude());
                bun.putString("Longitude", getData_cedit.getLongitude());


                bun.putString("status_qrcode", getData_cedit.getstatus_qrcode());
                bun.putString("distance", getData_cedit.getdistance());

                bun.putString("salename", getData_cedit.getsalename());
                bun.putString("teamcode", getData_cedit.getteamcode());
                bun.putString("headname", getData_cedit.getheadname());
                bun.putString("lat_long", getData_cedit.getlat_long());

                bun.putString("conno2", getData_cedit.getconno());
                bun.putString("conno_qr_code", getData_cedit.getconno_qr_code());

                bun.putString("product_name", getData_cedit.getproduct_name());
                bun.putString("status2", getData_cedit.getstatus());
                bun.putString("name_customer", getData_cedit.getname_customer());
                bun.putString("id_card", getData_cedit.getid_card());
                bun.putString("address2", getData_cedit.getaddress());
                bun.putString("number_phone", getData_cedit.getnumber_phone());
                bun.putString("date2", getData_cedit.getdate());
                bun.putString("status_app", getData_cedit.getstatus_app());
                bun.putString("Description", getData_cedit.getIssueName());
                Intent.putExtras(bun);

                startActivityForResult(Intent, 23);


            }










        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        try {
            itemTouchHelper.startDrag(viewHolder);
        }
        catch (Exception ex){

        }

    }

    @Override
    public void onNoteListChanged(List<GetData_cedit> jobItemList) {

        List<String> listOfSortedCustomerId = new ArrayList<String>();
        for (GetData_cedit jobItem : jobItemList) {
            listOfSortedCustomerId.add(jobItem.getCONTNO());
        }

        Gson gson = new Gson();
        String jsonListOfSortedCustomerIds = gson.toJson(listOfSortedCustomerId);

        MyApplication.getInstance().getPrefManager().setPreferrence("key_sort", jsonListOfSortedCustomerIds);

    }


    @Override
    public void onClick(View view) {
        if (view == fab) {
            MyApplication.getInstance().getPrefManager().setPreferrence("dat2", "1");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {


                //recyclerViewadapter = new RecyclerViewAdapter5(getActivity());
                //recyclerView.setAdapter(recyclerViewadapter);

                setlist++;
                Log.e("setlist", String.valueOf(setlist));
                if (setlist > 1) {
                    setlist = 0;
                }
                if (setlist == 0) {
                    fab.setImageResource(R.drawable.ic_list_black_24dp);
                    ContactAdapter2.color = 0xff999999;

                    if(dad==1){

                        SQLiteDataBaseBuild_data_checker_all();
                        SQLiteTableBuild_data_checker_all();
                        sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_data_checker_all.TABLE_NAME + "");

                        GetDataAdapter1.clear();
                        JSON_DATA_WEB_CALL3();

                    }
                    else {
                        try {
                            if(MyApplication.getInstance().getPrefManager().getPreferrence("intro_save").equals("1")){
                                //   GetDataAdapter1.clear();
                                //  JSON_DATA_WEB_CALL2();
                                SQLiteDataBaseBuild_data_checker_all();
                                SQLiteTableBuild_data_checker_all();
                                data_old();
                            }
                            else {
                                GetDataAdapter1.clear();
                                JSON_DATA_WEB_CALL();
                            }
                        }
                        catch (Exception ex){
                            GetDataAdapter1.clear();
                            JSON_DATA_WEB_CALL();
                        }


                    }
                } else {
                    fab.setImageResource(R.drawable.ic_save_white_24dp);
                    ContactAdapter2.color = 0xff000000;



                    if(dad==1){

                        SQLiteDataBaseBuild_data_checker_all();
                        SQLiteTableBuild_data_checker_all();
                        sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_data_checker_all.TABLE_NAME + "");

                        GetDataAdapter1.clear();
                        JSON_DATA_WEB_CALL3();

                    }
                    else {
                        try {
                            if(MyApplication.getInstance().getPrefManager().getPreferrence("intro_save").equals("1")){
                                //   GetDataAdapter1.clear();
                                //  JSON_DATA_WEB_CALL2();
                                SQLiteDataBaseBuild_data_checker_all();
                                SQLiteTableBuild_data_checker_all();
                                data_old();
                            }
                            else {
                                GetDataAdapter1.clear();
                                JSON_DATA_WEB_CALL();
                            }
                        }
                        catch (Exception ex){
                            GetDataAdapter1.clear();
                            JSON_DATA_WEB_CALL();
                        }


                    }

/*ffff
                    GetDataAdapter1.clear();
                    JSON_DATA_WEB_CALL();*/
                }


            }
        }
    }


    private List<GetData_cedit> getOrderItem(List<GetData_cedit> jobItemList) {

        List<GetData_cedit> jobItems = jobItemList;
        List<GetData_cedit> sortedJob = new ArrayList<GetData_cedit>();

        try {
            String jsonListOfSortedJobItem = MyApplication.getInstance().getPrefManager().getPreferrence("key_sort");

            if (!jsonListOfSortedJobItem.isEmpty()) {
                Gson gson = new Gson();
                List<String> listOfSortedJobID = gson.fromJson(jsonListOfSortedJobItem,
                        new TypeToken<List<String>>() {
                        }.getType());

                if (listOfSortedJobID != null && listOfSortedJobID.size() > 0) {
                    for (String id : listOfSortedJobID) {
                        for (GetData_cedit jobItem : jobItems) {
                            if (jobItem.getCONTNO().equals(id)) {
                                sortedJob.add(jobItem);
                                jobItems.remove(jobItem);

                                break;
                            }
                        }
                    }
                }
                if (jobItems.size() > 0) {
                    sortedJob.addAll(jobItems);


                }
                return sortedJob;
            } else {
                return jobItems;
            }
        } catch (Exception ex) {
            return jobItems;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            try {

                recyclerView.setHasFixedSize(true);

                recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

                recyclerView.setLayoutManager(recyclerViewlayoutManager);
                mShimmerViewContainer.stopShimmerAnimation();
                mShimmerViewContainer.setVisibility(View.VISIBLE);



                if(dad==1){

                    SQLiteDataBaseBuild_data_checker_all();
                    SQLiteTableBuild_data_checker_all();
                    sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_data_checker_all.TABLE_NAME + "");

                    GetDataAdapter1.clear();
                    JSON_DATA_WEB_CALL3();

                }
                else {
                    try {
                        if(MyApplication.getInstance().getPrefManager().getPreferrence("intro_save").equals("1")){
                            //   GetDataAdapter1.clear();
                            //  JSON_DATA_WEB_CALL2();
                            SQLiteDataBaseBuild_data_checker_all();
                            SQLiteTableBuild_data_checker_all();
                            data_old();
                        }
                        else {
                            GetDataAdapter1.clear();
                            JSON_DATA_WEB_CALL();
                        }
                    }
                    catch (Exception ex){
                        GetDataAdapter1.clear();
                        JSON_DATA_WEB_CALL();
                    }


                }


                 //GetDataAdapter1.clear();

                   // JSON_DATA_WEB_CALL();






            } catch (Exception ex) {

            }
        }
        else if(requestCode==103){
            MyApplication.getInstance().getPrefManager().clear();

        }

        else {

        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

    }

/*
    public float distance (float lat_a, float lng_a, float lat_b, float lng_b )
    {
        double earthRadius = 3958.75;
        double latDiff = Math.toRadians(lat_b-lat_a);
        double lngDiff = Math.toRadians(lng_b-lng_a);
        double a = Math.sin(latDiff /2) * Math.sin(latDiff /2) +
                Math.cos(Math.toRadians(lat_a)) * Math.cos(Math.toRadians(lat_b)) *
                        Math.sin(lngDiff /2) * Math.sin(lngDiff /2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        dist = earthRadius * c*2;

        int meterConversion = 1609;

        return new Float(dist *2* meterConversion).floatValue();
    }
*/


    public void SQLiteDataBaseBuild_data_checker_all(){
        sqLiteDatabase = getActivity().openOrCreateDatabase(SQLiteHelper_data_checker_all.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
    public void SQLiteTableBuild_data_checker_all(){
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_data_checker_all.TABLE_NAME+"("+ SQLiteHelper_data_checker_all.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_data_checker_all.Table_CONTNO+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_RefNo+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_SaleEmployeeName+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_SaleTeamCode+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_SaleHeaderName+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_IDCARD+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_CustomerName+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_ADDRESSS+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_Tel+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_Tel2+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_ProductName+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_EFFDATE+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_Dis+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_Latitude+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_Longitude+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_Outstanding+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_PayLastPeriod+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_FnYear+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_FnMonth+" VARCHAR);");
    }


    public Address getAddress(double latitude, double longitude)
    {
        Geocoder geocoder;



        List<Address> addresses;
        geocoder = new Geocoder(context, Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(latitude,longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
            return addresses.get(0);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public void getAddress()
    {

        try {
            Double latitude_d = Double.valueOf(MusicActivity_Credit.latitude);
            Double longitude_d = Double.valueOf(MusicActivity_Credit.longitude);
            Address locationAddress=getAddress(latitude_d,longitude_d);

            if(locationAddress!=null)
            {
                address_now = locationAddress.getAddressLine(0);
                Log.e("currentLocationWW",address_now);

            }

        }
        catch (Exception T){

        }



    }




    private double getDistanceInfo(String city1 ,String city2) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        StringBuilder stringBuilder = new StringBuilder();

        Double da = 0.0;
        try {

          //String  url = "http://maps.googleapis.com/maps/api/directions/json?origin=" + city1 + "&destination=" + city2 + "&sensor=false";
          //  String  url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=Seattle&destinations=San+Francisco&key=AIzaSyDau8gZ_HY0WVrGMWVLe7ciYIGeRWklE84";
            String  url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="+URLEncoder.encode(city1, "UTF-8")+"&destinations="+URLEncoder.encode(city2, "UTF-8")+"&key=AIzaSyDau8gZ_HY0WVrGMWVLe7ciYIGeRWklE84";
            //   String url = "http://maps.google.com/maps/api/directions/json?origin="
            //   + city1 + "&destination=" + city2
            //   + "&sensor=false&units=metric";

            HttpPost httppost = new HttpPost(url);

            HttpClient client = new DefaultHttpClient();
            HttpResponse response;
            stringBuilder = new StringBuilder();


            response = client.execute(httppost);
            HttpEntity entity = response.getEntity();
            InputStream stream = entity.getContent();
            int b;
            while ((b = stream.read()) != -1) {
                stringBuilder.append((char) b);
            }
        } catch (ClientProtocolException e) {
        } catch (IOException e) {
        }

        JSONObject jsonObject = new JSONObject();
        try {

/*
            jsonObject = new JSONObject(stringBuilder.toString());

            JSONArray array = jsonObject.getJSONArray("rows");

            JSONObject routes = array.getJSONObject(0);

            JSONArray legs = routes.getJSONArray("elements");

            JSONObject steps = legs.getJSONObject(0);

            JSONObject distance = steps.getJSONObject("distance");
            JSONObject duration = steps.getJSONObject("duration");
*/


            //  Log.e("Distance", distance.toString());

//httpResponse is the output of google api
            JSONObject jsonRespRouteDistance = new JSONObject(stringBuilder.toString())
                    .getJSONArray("rows")
                    .getJSONObject(0)
                    .getJSONArray ("elements")
                    .getJSONObject(0)
                    .getJSONObject("distance");

            JSONObject jsonRespRouteDistance2 = new JSONObject(stringBuilder.toString())
                    .getJSONArray("rows")
                    .getJSONObject(0)
                    .getJSONArray ("elements")
                    .getJSONObject(0)
                    .getJSONObject("duration");

            String distance2 = jsonRespRouteDistance.get("text").toString();
            String distance3 = jsonRespRouteDistance2.get("text").toString();
            String distance4 = jsonRespRouteDistance.get("value").toString();
            String distance5 = jsonRespRouteDistance2.get("value").toString();
            /*
             * For distance, below is only partial solution as the
             * output to string destination_addr will contain square brackets [] and double codes ""
             * Eg. [ "1600 Pennsylvania Avenue, Hagerstown, MD 21742, USA" ]
             *
             */

            /*String destination_addr = new JSONObject(stringBuilder.toString())
                    .get("destination_addresses")
                    .toString();*/


            Log.e("destination_addr", distance4+","+distance5);





         dist = Double.parseDouble(distance4);

            dist=dist/1000.0;


            //durat= Double.parseDouble(duration.getString("value"));

            //JSON_DATA_WEB_CALL_insent_map();
            //Log.e("durat", String.valueOf(dist));


        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dist;

    }



    private double getDistanceInfo2 (String city1, String city2) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        StringBuilder stringBuilder = new StringBuilder();

        Double da = 0.0;
        try {
            //url2 = "http://maps.googleapis.com/maps/api/directions/json?origin=" + city1 + "&destination=" + city2 + "&sensor=false";
         // String  url2 = "http://maps.googleapis.com/maps/api/directions/json?origin=" + URLEncoder.encode(city1, "UTF-8")+"&destination=" + URLEncoder.encode(city2, "UTF-8") + "&sensor=false" ;
            String  url2 = "https://maps.googleapis.com/maps/api/directions/json?origin=Toronto&destination=Montreal&key=AIzaSyD7npBz1WiWeSMSUN1NPtYpn0FQJ0iWS9E";
            Log.e("url2",url2);

            HttpPost httppost = new HttpPost(url2);

            HttpClient client = new DefaultHttpClient();
            HttpResponse response;
            stringBuilder = new StringBuilder();


            response = client.execute(httppost);
            HttpEntity entity = response.getEntity();
            InputStream stream = entity.getContent();
            int b;
            while ((b = stream.read()) != -1) {
                stringBuilder.append((char) b);
            }
        } catch (ClientProtocolException e) {
        } catch (IOException e) {
        }

        JSONObject jsonObject = new JSONObject();
        try {

            jsonObject = new JSONObject(stringBuilder.toString());

            JSONArray array = jsonObject.getJSONArray("routes");

            JSONObject routes = array.getJSONObject(0);

            JSONArray legs = routes.getJSONArray("legs");

            JSONObject steps = legs.getJSONObject(0);

            JSONObject distance = steps.getJSONObject("distance");
            JSONObject duration = steps.getJSONObject("duration");


            //  Log.e("Distance", distance.toString());




            dist = Double.parseDouble(distance.getString("value"));

            dist=dist/1000.0;

            durat= Double.parseDouble(duration.getString("value"));
           // JSON_DATA_WEB_CALL_insent_map();

            Log.e("durat", String.valueOf(dist));
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dist;

    }


}