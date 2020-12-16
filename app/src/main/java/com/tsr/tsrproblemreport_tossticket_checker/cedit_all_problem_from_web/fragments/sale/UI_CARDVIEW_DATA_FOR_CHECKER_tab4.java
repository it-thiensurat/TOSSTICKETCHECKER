package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.sale;


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
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import android.widget.ProgressBar;
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
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.ContactAdapter_sale;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.helper.OnCustomerListChangedListener;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.helper.OnStartDragListener;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_map;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import at.grabner.circleprogress.CircleProgressView;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class UI_CARDVIEW_DATA_FOR_CHECKER_tab4 extends Fragment implements OnStartDragListener, OnCustomerListChangedListener, View.OnClickListener, ContactAdapter_sale.itemclick, ContactAdapter_sale.itemclick2,OnMapReadyCallback {


    private Context mContext;
    GetData_cedit_map getData_cedit_map;
    @SuppressLint("ValidFragment")
    public UI_CARDVIEW_DATA_FOR_CHECKER_tab4(Context mContext) {
        this.mContext = mContext;
    }
    SupportMapFragment mapFragment;
    Marker melbourne;
    Detali_data_cedit2 musicActivity_credit;

    String DADADA;
    GetData_cedit getData_cedit;
    List<GetData_cedit> GetDataAdapter1;
    private ContactAdapter_sale contactAdapter;
    public static CircleProgressView mCircleView;

    RecyclerView recyclerView;
    RelativeLayout relativeLayout,RelativeLayout_map_contno;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    public static Context context;


    //String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/cedit_data.php";
   // String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/checker_system/sale/data_check_sale2.php";

    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/checker_system/sale/data_check_sale1_2.php";
    String GET_JSON_DATA_HTTP_URL_number_page = "http://app.thiensurat.co.th/assanee/checker_system/sale/data_check_sale1_2_number_page.php";


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

    SweetAlertDialog pDialog2;
    public  static ProgressDialog progressDialog;
    private int progressStatus = 0;
    private Handler handler = new Handler();
    private ProgressDialog pDialog;

    private ItemTouchHelper itemTouchHelper;
    private GeoDataClient mGeoDataClient;
    private PlaceDetectionClient mPlaceDetectionClient;

    private ShimmerFrameLayout mShimmerViewContainer;
    Thread thread;

    ProgressBar progress_bar;

    private static final int PAGE_START = 1;
    private int number_page = PAGE_START;

    private int total_page;
    int select_date=0;
    int check_progress=0;

    public UI_CARDVIEW_DATA_FOR_CHECKER_tab4() {

    }


    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        recyclerView.setHasFixedSize(true);

        recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(recyclerViewlayoutManager);


        relativeLayout.setVisibility(View.GONE);

        PositionCode=MyApplication.getInstance().getPrefManager().getPreferrence("PositionCode");
        JSON_DATA_WEB_CALL_number_page();
        JSON_DATA_WEB_CALL();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {


                        recyclerView.setHasFixedSize(true);

                        recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

                        recyclerView.setLayoutManager(recyclerViewlayoutManager);
                        recyclerView.scrollToPosition(0);
                        number_page=1;
                check_progress=0;
                        mShimmerViewContainer.stopShimmerAnimation();
                        mShimmerViewContainer.setVisibility(View.VISIBLE);
                        GetDataAdapter1.clear();
                JSON_DATA_WEB_CALL_number_page();
                        JSON_DATA_WEB_CALL();

                swipeRefreshLayout.setRefreshing(false);
            }
        });

        initScrollListener();


    }



    boolean isLoading = false;
    private void initScrollListener() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                if (!isLoading) {
                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == GetDataAdapter1.size() - 1) {
                        //bottom of list!
                        //    number_page=number_page+1;
                        progress_bar.setVisibility(View.VISIBLE);

                        total_page= Integer.parseInt(page);
                        if(number_page<=total_page){
                            if(check_progress==0){
                                number_page += 1;
                                Log.e("page", String.valueOf(number_page));
                                loadMore();
                                isLoading = true;
                            }
                        }

                    }
                }
            }
        });


    }

    private void loadMore() {
        //GetDataAdapter1.add(null);
        // recyclerViewDataAdapter.notifyItemInserted(GetDataAdapter1.size() - 1);
        GetDataAdapter1.add(null);
//        recyclerViewDataAdapter.notifyItemInserted(GetDataAdapter1.size() - 1);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    GetDataAdapter1.remove(GetDataAdapter1.size() - 1);
                }
                catch (Exception ex){

                }


                    JSON_DATA_WEB_CALL3();






                isLoading = false;

            }
        }, 2000);


    }


    public void JSON_DATA_WEB_CALL_number_page() {

        String user_code= MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

        //  jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL+"?user_code="+user_code ,
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_number_page+"?CheckerEmpID="+user_code  ,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {



                        JSON_PARSE_DATA_AFTER_WEBCALL_number_page(response);

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


    String row_all="",page="";
    public void JSON_PARSE_DATA_AFTER_WEBCALL_number_page(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {


            JSONObject json = null;
            try {

                json = array.getJSONObject(i);
                row_all=json.getString("row_all");
                page=json.getString("page");

            } catch (JSONException e) {

                e.printStackTrace();
            }


        }


        counter.setText(row_all);

    }




    public void JSON_DATA_WEB_CALL3() {

        String user_code= MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

        //  jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL+"?user_code="+user_code ,
        //jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL+ "?CheckerEmpID=" + user_code+"&page="+number_page ,
                jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL+ "?CheckerEmpID=" + user_code+"&page="+number_page ,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {



                        JSON_PARSE_DATA_AFTER_WEBCALL4(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        pDialog2.dismissWithAnimation();
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
    public void JSON_PARSE_DATA_AFTER_WEBCALL4(JSONArray array) {

        if(array.length()==0){
            check_progress=1;
        }
        else {
            check_progress=0;
        }


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


        progress_bar.setVisibility(View.GONE);
        //contactAdapter = new ContactAdapter_sale(recyclerView, GetDataAdapter1, getActivity(), UI_CARDVIEW_DATA_FOR_CHECKER_RECHECK.this, UI_CARDVIEW_DATA_FOR_CHECKER_RECHECK.this);
       // recyclerView.setAdapter(contactAdapter);

        recyclerView.scrollToPosition(GetDataAdapter1.size()-11);
        contactAdapter.notifyDataSetChanged();

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
        fab.setVisibility(View.GONE);
        GetDataAdapter1 = new ArrayList<>();

        recyclerView = (RecyclerView) layoutView.findViewById(R.id.recyclerview1);
        relativeLayout = (RelativeLayout) layoutView.findViewById(R.id.relativeLayout);
        RelativeLayout_map_contno= (RelativeLayout) layoutView.findViewById(R.id.RelativeLayout_map_contno);
         fab2 = (android.support.design.widget.FloatingActionButton) layoutView.findViewById(R.id.fab2);

        mShimmerViewContainer = layoutView.findViewById(R.id.shimmer_view_container);
        progress_bar= (ProgressBar) layoutView.findViewById(R.id.progress_bar);

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

        Log.e("urlllll",GET_JSON_DATA_HTTP_URL + "?CheckerEmpID=" + CheckerEmpID+"&page="+number_page);
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL + "?CheckerEmpID=" + CheckerEmpID+"&page="+number_page,
                //jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL + "?CheckerEmpID=" + CheckerEmpID,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_WEBCALL(response);
                       // musicActivity_credit.dad=0;
                        //progressDialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //musicActivity_credit.dad=0;
//                        pDialog2.dismissWithAnimation();
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

        progress_bar.setVisibility(View.GONE);





        contactAdapter = new ContactAdapter_sale(recyclerView, GetDataAdapter1, getActivity(), UI_CARDVIEW_DATA_FOR_CHECKER_tab4.this, UI_CARDVIEW_DATA_FOR_CHECKER_tab4.this);
        recyclerView.setAdapter(contactAdapter);

        contactAdapter.setitemclick2(this);
        mShimmerViewContainer.stopShimmerAnimation();
        mShimmerViewContainer.setVisibility(View.GONE);





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
   //     MenuItem menuItemุ7 = menu.findItem(R.id.map_contno);

//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItemุ6);
     //   search(searchView);



      //  if (!searchView.isIconified()) {
       //     searchView.setQuery("", false);
       //     JSON_DATA_WEB_CALL();
       // }


//        menuItem.setVisible(false);
     //   menuItem2.setVisible(false);
     //   menuItem3.setVisible(false);
       // menuItem4.setVisible(false);
       // menuItem5.setVisible(false);


    }


    private void search(final SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                if (contactAdapter != null)
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
                }

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

            startActivityForResult(Intent, 100);














        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        itemTouchHelper.startDrag(viewHolder);
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


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

    }



    public void SQLiteDataBaseBuild_data_checker_all(){
        sqLiteDatabase = getActivity().openOrCreateDatabase(SQLiteHelper_data_checker_all.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
    public void SQLiteTableBuild_data_checker_all(){
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_data_checker_all.TABLE_NAME+"("+ SQLiteHelper_data_checker_all.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_data_checker_all.Table_CONTNO+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_RefNo+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_SaleEmployeeName+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_SaleTeamCode+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_SaleHeaderName+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_IDCARD+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_CustomerName+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_ADDRESSS+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_Tel+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_Tel2+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_ProductName+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_EFFDATE+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_Dis+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_Latitude+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_Longitude+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_Outstanding+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_PayLastPeriod+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_FnYear+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_FnMonth+" VARCHAR, "+SQLiteHelper_data_checker_all.Table_ProductSerial+" VARCHAR);");
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




}