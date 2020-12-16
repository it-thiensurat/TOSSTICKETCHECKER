package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.RecyclerViewAdapter_cedit_sent_report_problem_error;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_map;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_sale_recive_problem;
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
import java.util.ArrayList;
import java.util.List;


public class UI_CARDVIEW_DATA_CEDIT_SENT_RPOBLEM extends Fragment implements RecyclerViewAdapter_cedit_sent_report_problem_error.itemclick2,RecyclerViewAdapter_cedit_sent_report_problem_error.itemclick_navigate  {

    private Context mContext;
    GetData_cedit_map getData_cedit_map;
    @SuppressLint("ValidFragment")
    public UI_CARDVIEW_DATA_CEDIT_SENT_RPOBLEM(Context mContext) {
        this.mContext = mContext;
    }

    GetData_cedit_sale_recive_problem getData_cedit;
    List<GetData_cedit_sale_recive_problem> GetDataAdapter1;
    private RecyclerViewAdapter_cedit_sent_report_problem_error contactAdapter;

    RecyclerView recyclerView;
    RelativeLayout relativeLayout,RelativeLayout_map_contno,no_data;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    public static Context context;


   // String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/sale_problem1_json2_real_from_cedit.php";
   // String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_list_nontification_problem_of_credit.php";
    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_list_nontification_problem_of_credit.php";
    String JSON_InformID = "InformID";
    String JSON_Contno = "Contno";
    String JSON_Informitem = "Informitem";
    //String JSON_WorkCode = "WorkCode";
    String JSON_ProductName="ProductName";
    String JSON_TotalPrice="TotalPrice";
    String JSON_CustomerName = "CustomerName";
    String JSON_count_problem = "count_problem";
    String JSON_date_createString = "date_create";
    String JSON_AddressDetail = "Addressall";

    String JSON_Latitude = "Latitude";
    String JSON_Longitude = "Longitude";
    String JSON_TelHome = "TelHome";
    String JSON_TelMobile = "TelMobile";

    String latlong="";

    int setlist = 0;
    double dist;
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



    private ShimmerFrameLayout mShimmerViewContainer;
    Thread thread;
    public UI_CARDVIEW_DATA_CEDIT_SENT_RPOBLEM() {

    }


    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        recyclerView.setHasFixedSize(true);

        recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(recyclerViewlayoutManager);


        relativeLayout.setVisibility(View.GONE);




        JSON_DATA_WEB_CALL2();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // GetDataAdapter1.clear();
                position2 = 0;
                //JSON_DATA_WEB_CALL();

                no_data.setVisibility(View.GONE);

                recyclerView.setHasFixedSize(true);

                recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

                recyclerView.setLayoutManager(recyclerViewlayoutManager);
                mShimmerViewContainer.stopShimmerAnimation();
                mShimmerViewContainer.setVisibility(View.VISIBLE);
                GetDataAdapter1.clear();
                JSON_DATA_WEB_CALL2();
                swipeRefreshLayout.setRefreshing(false);
            }
        });





    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View layoutView = inflater.inflate(R.layout.cardview_row_cedit, container, false);
        // toolbar = (Toolbar) layoutView.findViewById(R.id.toolbar);
        //  toolbar = (Toolbar) layoutView.findViewById(R.id.toolbar);
        setHasOptionsMenu(true);

        swipeRefreshLayout = (SwipeRefreshLayout) layoutView.findViewById(R.id.swipe_refresh_layout);
        //  swipeRefreshLayout.setOnRefreshListener(getActivity());
        counter = (TextView) layoutView.findViewById(R.id.counter);
        fab = (android.support.design.widget.FloatingActionButton) layoutView.findViewById(R.id.fab);

        GetDataAdapter1 = new ArrayList<>();

        recyclerView = (RecyclerView) layoutView.findViewById(R.id.recyclerview1);
        relativeLayout = (RelativeLayout) layoutView.findViewById(R.id.relativeLayout);
        RelativeLayout_map_contno= (RelativeLayout) layoutView.findViewById(R.id.RelativeLayout_map_contno);
        no_data= (RelativeLayout) layoutView.findViewById(R.id.no_data);
        fab2 = (android.support.design.widget.FloatingActionButton) layoutView.findViewById(R.id.fab2);

        mShimmerViewContainer = layoutView.findViewById(R.id.shimmer_view_container);





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






    public void JSON_DATA_WEB_CALL2() {

        String user_code = MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        String WorkCode="00";

            jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL + "?EmpID=" + user_code,


                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {

                            JSON_PARSE_DATA_AFTER_WEBCALL(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            error.printStackTrace();


                            /*

                            //Get response code here
                            if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                                Log.e("error","1");

                            } else if (error instanceof AuthFailureError) {
                                Log.e("error","2");
                                new SweetAlertDialog(getActivity(), SweetAlertDialog.ERROR_TYPE)
                                        .setTitleText("!Network Error")
                                        .setContentText("กรุณาตรวจสอบอินเตอร์เน็ต!")
                                        .show();
                            } else if (error instanceof ServerError) {
                                Log.e("error","3");

                            } else if (error instanceof NetworkError) {
                                Log.e("error","4");
                                new SweetAlertDialog(getActivity(), SweetAlertDialog.ERROR_TYPE)
                                        .setTitleText("!Network Error")
                                        .setContentText("กรุณาตรวจสอบอินเตอร์เน็ต!")
                                        .show();
                            } else if (error instanceof ParseError) {
                                Log.e("error","5");
                                new SweetAlertDialog(getActivity(), SweetAlertDialog.ERROR_TYPE)
                                        .setTitleText("!Parse Error")
                                        .setContentText("tag api เกิน หรือ ขาด!")
                                        .show();
                            }


                            */


                        }
                    });


        requestQueue = Volley.newRequestQueue(getActivity());

        requestQueue.add(jsonArrayRequest);
        swipeRefreshLayout.setRefreshing(false);
    }



int size;
    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array) {
        latlong = MyApplication.getInstance().getPrefManager().getPreferrence("latlong");
        size=array.length();
        if(size==0){

/*
            new SweetAlertDialog(getActivity(), SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("!OK")
                    .setContentText("ไม่มีปัญหา")
                    .show();*/


            no_data.setVisibility(View.VISIBLE);

        }
        else {
            no_data.setVisibility(View.GONE);
        }
        for (int i = 0; i < array.length(); i++) {

            final GetData_cedit_sale_recive_problem GetDataAdapter2 = new GetData_cedit_sale_recive_problem();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);

                getData_cedit = new GetData_cedit_sale_recive_problem();

                GetDataAdapter2.setInformID(json.getString(JSON_InformID));
                GetDataAdapter2.setContno(json.getString(JSON_Contno));
                GetDataAdapter2.setInformitem(json.getString(JSON_Informitem));

                //GetDataAdapter2.setWorkCode(json.getString(JSON_WorkCode));

                GetDataAdapter2.setProductName(json.getString(JSON_ProductName));
                GetDataAdapter2.setTotalPrice(json.getString(JSON_TotalPrice));
                GetDataAdapter2.setCustomerName(json.getString(JSON_CustomerName));
                GetDataAdapter2.setAddressDetail(json.getString(JSON_AddressDetail));
                GetDataAdapter2.setCount_problem(json.getString(JSON_count_problem));
                //GetDataAdapter2.setDate_createString(json.getString(JSON_date_createString));
                GetDataAdapter2.setDate_createString(json.getJSONObject("date_create").getString("date"));

                GetDataAdapter2.setLatitude(json.getString(JSON_Latitude));
                GetDataAdapter2.setLongitude(json.getString(JSON_Longitude));
                GetDataAdapter2.setTelHome(json.getString(JSON_TelHome));
                GetDataAdapter2.setTelMobile(json.getString(JSON_TelMobile));

               // distance(Double.parseDouble("13.897776"),Double.parseDouble("100.5123653"),Double.parseDouble(json.getString(JSON_Latitude)),Double.parseDouble(json.getString(JSON_Longitude)));

                //String.format("%.2f", dist);
//                Log.e("latlong",latlong);
                getDistanceInfo(latlong,json.getString(JSON_Latitude)+","+json.getString(JSON_Longitude));
                GetDataAdapter2.setDistant((String.format("%.2f", dist)));

                //GetDataAdapter2.setDistant(json.getString(JSON_IssueName));
            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter2);
            //  pDialog.dismiss();
        }



        contactAdapter = new RecyclerViewAdapter_cedit_sent_report_problem_error(GetDataAdapter1, getActivity());


        recyclerView.setAdapter(contactAdapter);

        contactAdapter.setitemclick2(this);
        contactAdapter.setitemclick_navigate(this);

        mShimmerViewContainer.stopShimmerAnimation();
        mShimmerViewContainer.setVisibility(View.GONE);


    }

    private double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
         dist = Math.sin(deg2rad(lat1))
                * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1))
                * Math.cos(deg2rad(lat2))
                * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        Log.e("dist", String.valueOf(dist));
        return (dist);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }



    private double getDistanceInfo(String city1, String city2) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        StringBuilder stringBuilder = new StringBuilder();

        Double da = 0.0;
        try {

           String url = "http://maps.googleapis.com/maps/api/directions/json?origin=" + city1 + "&destination=" + city2 + "&sensor=false";

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

            //durat= Double.parseDouble(duration.getString("value"));


            Log.e("durat", String.valueOf(dist));


        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dist;

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
        inflater.inflate(R.menu.music, menu);
        MenuItem menuItem = menu.findItem(R.id.testAction);
        MenuItem menuItem2 = menu.findItem(R.id.testAction2);
        MenuItem menuItem3 = menu.findItem(R.id.testAction3);
        MenuItem menuItem4 = menu.findItem(R.id.testAction4);
        MenuItem menuItem5 = menu.findItem(R.id.testAction5);

        MenuItem menuItem6 = menu.findItem(R.id.action_search);
        MenuItem menuItem7 = menu.findItem(R.id.action_setting);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem6);
        search(searchView);



        if (!searchView.isIconified()) {
            searchView.setQuery("", false);
            JSON_DATA_WEB_CALL2();
        }


        menuItem.setVisible(false);
        menuItem2.setVisible(false);
        menuItem3.setVisible(false);
        menuItem4.setVisible(false);
        menuItem5.setVisible(false);
        menuItem6.setVisible(false);
        menuItem7.setVisible(false);
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
                    JSON_DATA_WEB_CALL2();
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
    public void click2(View v, int position) {
        getData_cedit = GetDataAdapter1.get(position);
        Intent Intent = new Intent(getActivity(), UI_CARDVIEW_DATA_CEDIT_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_Activity.class);
        Bundle bun = new Bundle();
        bun.putString("Contno", getData_cedit.getContno());
        //bun.putString("Informitem", getData_cedit.getInformitem());
        bun.putString("InformID", getData_cedit.getInformID());
        Intent.putExtras(bun);
        startActivityForResult(Intent, 66);
    }

    @Override
    public void click_navigate(View v, int position) {
        getData_cedit = GetDataAdapter1.get(position);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?daddr=" + latlong+"&daddr="+getData_cedit.getLatitude()+","+getData_cedit.getLongitude()));
        startActivity(intent);
    }
}