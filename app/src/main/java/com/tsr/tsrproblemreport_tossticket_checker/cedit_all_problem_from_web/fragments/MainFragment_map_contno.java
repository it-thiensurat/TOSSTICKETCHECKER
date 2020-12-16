package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
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
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.MusicActivity_Credit;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.ContactAdapter;
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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import at.grabner.circleprogress.CircleProgressView;

public class MainFragment_map_contno extends Fragment  implements OnMapReadyCallback,View.OnClickListener {


    private Context mContext;
    GetData_cedit_map getData_cedit_map;
    public MainFragment_map_contno(Context mContext) {
        this.mContext = mContext;
    }
    SupportMapFragment mapFragment;
    Marker melbourne;
    MusicActivity_Credit musicActivity_credit;

    String DADADA;
    GetData_cedit getData_cedit;
    List<GetData_cedit> GetDataAdapter1;
    private ContactAdapter contactAdapter;
    public static CircleProgressView mCircleView;
    GetData_cedit getDataAdapter;
    RecyclerView recyclerView;
    RelativeLayout relativeLayout,RelativeLayout_map_contno;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    public static Context context;
    JSONObject jsonObject;


    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/cedit_data.php";
    String GET_JSON_DATA_HTTP_URL2="http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/cedit_data_contno2.php";

    String GET_JSON_DATA_HTTP_URL_SALE="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit/sale/problem_all/sale_problem1_json2_real_from_cedit.php";
    String GET_JSON_DATA_HTTP_URL_TEAMLEADER="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit/supervisor/problem_all/supervisor_problem1_json2_real_from_cedit.php";
    String GET_JSON_DATA_HTTP_URL_SUPERVISOR="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit/supervisor/problem_all/supervisor_problem1_json2_real_from_cedit.php";
    String GET_JSON_DATA_HTTP_URL_LINE="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit/supervisor/problem_all/supervisor_problem1_json2_real_from_cedit.php";
    String GET_JSON_DATA_HTTP_URL_MANAGER="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit/supervisor/problem_all/supervisor_problem1_json2_real_from_cedit.php";

    // http://app.thiensurat.co.th/assanee/test_rettofit8.php
   public static GoogleMap googleMap;
    String CC;
    ContactAdapter recycleview_data_cedit;
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
    String CONTNO;
    Double LA=0.0,LO=0.0;

    double persen = 0.00;
    int b;
    public static Dialog dialog2;

    Double    dist=0.0;
    public static int ia, i = 0, iis = 0;

    String CON;
    int setlist = 0;
    private int count;
    private Toolbar toolbar;
    JsonArrayRequest jsonArrayRequest;

    RequestQueue requestQueue;
    private SwipeRefreshLayout swipeRefreshLayout;
    TextView counter;
    FloatingActionButton fab, fab2;

    public static int position2;

    MarkerOptions markerOpt;
    ProgressDialog progressDialog;
    private int progressStatus = 0;
    private Handler handler = new Handler();
    private ProgressDialog pDialog;

    private ItemTouchHelper itemTouchHelper;


    private ShimmerFrameLayout mShimmerViewContainer;




    public MainFragment_map_contno() {

    }


    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);



        PositionCode=MyApplication.getInstance().getPrefManager().getPreferrence("PositionCode");



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View layoutView = inflater.inflate(R.layout.map_contno, container, false);

        setHasOptionsMenu(true);


        GetDataAdapter1 = new ArrayList<>();


       // mapFragment = (MapView) layoutView.findViewById(R.id.map);
       // mapFragment.getMapAsync(this);

        mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

         fab = (FloatingActionButton) layoutView.findViewById(R.id.fab);
        fab.setOnClickListener(this);






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

        String SALECODE = MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL + "?SALECODE=" + SALECODE,


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

        requestQueue = Volley.newRequestQueue(getActivity());

        requestQueue.add(jsonArrayRequest);

    }


    public void JSON_DATA_WEB_CALL_SALE() {

        String EmployeeName = MyApplication.getInstance().getPrefManager().getPreferrence("EmployeeName");

        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_SALE + "?SaleEmployeeName=" + URLEncoder.encode(EmployeeName, "UTF-8"),


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
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        requestQueue = Volley.newRequestQueue(getActivity());

        requestQueue.add(jsonArrayRequest);
        //swipeRefreshLayout.setRefreshing(false);
    }

    public void JSON_DATA_WEB_CALL_TEAMLEADER() {

        String empid = MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_TEAMLEADER + "?empid=" + URLEncoder.encode(empid, "UTF-8"),


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
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        requestQueue = Volley.newRequestQueue(getActivity());

        requestQueue.add(jsonArrayRequest);

    }


    public void JSON_DATA_WEB_CALL_SUPERVISOR() {

        String empid = MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_SUPERVISOR + "?empid=" + URLEncoder.encode(empid, "UTF-8"),


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
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        requestQueue = Volley.newRequestQueue(getActivity());

        requestQueue.add(jsonArrayRequest);

    }
    public void JSON_DATA_WEB_CALL_LINE() {

        String empid = MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_LINE + "?empid=" + URLEncoder.encode(empid, "UTF-8"),


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
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        requestQueue = Volley.newRequestQueue(getActivity());

        requestQueue.add(jsonArrayRequest);

    }


    public void JSON_DATA_WEB_CALL_MANAGER() {

        String empid = MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_MANAGER + "?empid=" + URLEncoder.encode(empid, "UTF-8"),


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
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        requestQueue = Volley.newRequestQueue(getActivity());

        requestQueue.add(jsonArrayRequest);

    }

    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array) {


        for (i = 0; i < array.length(); i++) {

            final GetData_cedit GetDataAdapter2 = new GetData_cedit();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);

                getData_cedit = new GetData_cedit();

                GetDataAdapter2.setCONTNO(json.getString(JSON_CONTNO));
                GetDataAdapter2.setRefNo(json.getString(JSON_RefNo));

                GetDataAdapter2.setSaleEmployeeName(json.getString(JSON_SaleEmployeeName));
                GetDataAdapter2.setSaleTeamCode(json.getString(JSON_SaleTeamCode));
                GetDataAdapter2.setSaleHeaderName(json.getString(JSON_SaleHeaderName));

                GetDataAdapter2.setIDCARD(json.getString(JSON_IDCARD));
                GetDataAdapter2.setCustomerName(json.getString(JSON_CustomerName));
                GetDataAdapter2.setAddressDetail(json.getString(JSON_ADDRESSS));
                GetDataAdapter2.setLatitude(json.getString(JSON_Latitude));
                GetDataAdapter2.setLongitude(json.getString(JSON_Longitude));

                GetDataAdapter2.setTelMobile(json.getString(JSON_TelMobile));
                GetDataAdapter2.setTelHome(json.getString(JSON_TelHome));
                GetDataAdapter2.setProductName(json.getString(JSON_ProductName));
                GetDataAdapter2.setdis(json.getString(JSON_dis));
                GetDataAdapter2.setstatusName(json.getString(JSON_statusName));


                GetDataAdapter2.setEFFDATE(json.getJSONObject("EFFDATE").getString("date"));


                GetDataAdapter2.setstatus_qrcode(json.getString(JSON_status_qrcode));
                GetDataAdapter2.setdistance(json.getString(JSON_distance));

                GetDataAdapter2.setsalename(json.getString(JSON_salename));
                GetDataAdapter2.setteamcode(json.getString(JSON_teamcode));
                GetDataAdapter2.setheadname(json.getString(JSON_headname));
                GetDataAdapter2.setlat_long(json.getString(JSON_lat_long));

                GetDataAdapter2.setconno(json.getString(JSON_conno));
                GetDataAdapter2.setconno_qr_code(json.getString(JSON_conno_qr_code));
                GetDataAdapter2.setproduct_name(json.getString(JSON_product_name));
                GetDataAdapter2.setstatus(json.getString(JSON_status));
                GetDataAdapter2.setname_customer(json.getString(JSON_name_customer));
                GetDataAdapter2.setid_card(json.getString(JSON_id_card));
                GetDataAdapter2.setaddress(json.getString(JSON_address));
                GetDataAdapter2.setnumber_phone(json.getString(JSON_number_phone));
                //GetDataAdapter2.setdate(json.getString(JSON_date));JSON_EFFDATE2
                GetDataAdapter2.setdate(json.getString(JSON_EFFDATE2));
                GetDataAdapter2.setIssueName(json.getString(JSON_IssueName));
                GetDataAdapter2.setstatus_view_lasttime(json.getString(JSON_status_view_lasttime));

Log.e("CCCC",GetDataAdapter2.getCONTNO());




                iis++;

                String LA_A = GetDataAdapter2.getLatitude()+"";
                String LO_O = GetDataAdapter2.getLongitude()+"";
                 CONTNO = GetDataAdapter2.getCONTNO()+"";
                String ADRR = GetDataAdapter2.getAddressDetail()+"";


                Log.e("masa",LA_A+","+LO_O);
                if(LA_A.equals("null")){
                    // Log.e("null",LA_A+","+LO_O);
                }
                else {






                    LA= Double.valueOf(LA_A);
                    LO= Double.valueOf(LO_O);

                   melbourne= googleMap.addMarker(new MarkerOptions()
                            .position(new LatLng(LA, LO))
                            .title("เลขที่สัญญา : "+CONTNO)
                            .snippet("ที่อยู่ : "+ADRR)


                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_pin_atm)));
                   // melbourne.showInfoWindow();


















                   String D= String.valueOf(melbourne.getPosition());

                    googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                        @Override
                        public void onInfoWindowClick(Marker marker) {

                            LatLng latLon = marker.getPosition();
                             CC=marker.getTitle();

                            if(CC.indexOf(CC) != -1) {
                                String arr2[] = CC.split(" : ");
                                CON=arr2[1];

                            }

                            Log.e("CC",CC);
                            JSON_DATA_WEB_CALL2();
                            //Cycle through places array
                          //  for(Place place : places){
                              //  if (latLon.equals(place.latlng)){
                                    //match found!  Do something....
                              //  }

                           // }
                        }
                    });


                }



            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter2);
            //  pDialog.dismiss();
        }
        ia = array.length();


        melbourne= googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(13.9012801, 100.5039834))
                .title("พนักงานตรวจสอบ")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_custom_search)));
        // .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        melbourne.showInfoWindow();

    }




    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap=googleMap;
        if(PositionCode.equals("Cedit")){
            JSON_DATA_WEB_CALL();
        }
        else   if(PositionCode.equals("Sale")){
            JSON_DATA_WEB_CALL_SALE();
        }
        else   if(PositionCode.equals("Teamleader")){
            JSON_DATA_WEB_CALL_TEAMLEADER();
        }
        else   if(PositionCode.equals("Supervisor")){
            JSON_DATA_WEB_CALL_SUPERVISOR();
        }
        else   if(PositionCode.equals("Line Manager")){
            JSON_DATA_WEB_CALL_LINE();
        }
        else   if(PositionCode.equals("Manager")){
            JSON_DATA_WEB_CALL_MANAGER();
        }
        else {
            JSON_DATA_WEB_CALL();
        }
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(13.9012801, 100.5039834), 12));

    }


    @Override
    public void onClick(View view) {
        this.googleMap=googleMap;
        mapFragment.getMapAsync(new OnMapReadyCallback() {

            @Override
            public void onMapReady(GoogleMap googleMap) {








                if(PositionCode.equals("Cedit")){
                    JSON_DATA_WEB_CALL();
                }
                else   if(PositionCode.equals("Sale")){
                    JSON_DATA_WEB_CALL_SALE();
                }
                else   if(PositionCode.equals("Teamleader")){
                    JSON_DATA_WEB_CALL_TEAMLEADER();
                }
                else   if(PositionCode.equals("Supervisor")){
                    JSON_DATA_WEB_CALL_SUPERVISOR();
                }
                else   if(PositionCode.equals("Line Manager")){
                    JSON_DATA_WEB_CALL_LINE();
                }
                else   if(PositionCode.equals("Manager")){
                    JSON_DATA_WEB_CALL_MANAGER();
                }
                else {
                    JSON_DATA_WEB_CALL();
                }
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(13.9012801, 100.5039834), 12));





            }
        });




    }




    private double getDistanceInfo(String city1, String city2) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        StringBuilder stringBuilder = new StringBuilder();

        Double da = 0.0;
        try {

         String   url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + city1 + "&destination=" + city2 + "&sensor=false";

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




            dist= Double.parseDouble(distance.getString("value"));

            dist=dist/1000.0;

          // Double durat= Double.parseDouble(duration.getString("value"));


            Log.e("durat", String.valueOf(dist));
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dist;

    }

    //@Override
    //public void onInfoWindowClick(Marker marker) {
       // getDistanceInfo("13.9012801,100.5039834",LA+","+LO);

        //Log.e("CONTNOs",CONTNO);
   // }



    public void JSON_DATA_WEB_CALL2() {

        String SALECODE = MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL2 + "?SALECODE=" + SALECODE+ "&contno=" + CON,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_WEBCALL2(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue = Volley.newRequestQueue(getActivity());

        requestQueue.add(jsonArrayRequest);

    }


    public void JSON_PARSE_DATA_AFTER_WEBCALL2(JSONArray array) {


        for (i = 0; i < array.length(); i++) {

            final GetData_cedit GetDataAdapter2 = new GetData_cedit();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);








                Intent Intent = new Intent(getActivity(), Detali_data_cedit.class);


                Bundle bun = new Bundle();
                bun.putString("conno", json.getString(JSON_CONTNO));
                bun.putString("RefNo", json.getString(JSON_RefNo));
                bun.putString("SaleEmployeeName",json.getString(JSON_SaleEmployeeName));

                bun.putString("SaleTeamCode", json.getString(JSON_SaleTeamCode));
                bun.putString("SaleHeaderName",json.getString(JSON_SaleHeaderName));

                bun.putString("productname", json.getString(JSON_ProductName));
                bun.putString("status",json.getString(JSON_status_qrcode));
                bun.putString("customer", json.getString(JSON_CustomerName));
                bun.putString("idcard", json.getString(JSON_IDCARD));
                bun.putString("address", json.getString(JSON_ADDRESSS));
                bun.putString("phone_home",json.getString(JSON_TelHome));
                bun.putString("phone_mobile", json.getString(JSON_TelMobile));
                bun.putString("date", json.getJSONObject("EFFDATE").getString("date"));

                bun.putString("Latitude", json.getString(JSON_Latitude));
                bun.putString("Longitude",json.getString(JSON_Longitude));


                bun.putString("status_qrcode",json.getString(JSON_status_qrcode));
                bun.putString("distance",json.getString(JSON_distance));

                bun.putString("salename", json.getString(JSON_salename));
                bun.putString("teamcode", json.getString(JSON_teamcode));
                bun.putString("headname", json.getString(JSON_headname));
                bun.putString("lat_long", json.getString(JSON_lat_long));

                bun.putString("conno2",json.getString(JSON_conno));
                bun.putString("conno_qr_code", json.getString(JSON_conno_qr_code));

                bun.putString("product_name", json.getString(JSON_product_name));
                bun.putString("status2", json.getString(JSON_status));
                bun.putString("name_customer", json.getString(JSON_name_customer));
                bun.putString("id_card",json.getString(JSON_id_card));
                bun.putString("address2", json.getString(JSON_address));
                bun.putString("number_phone", json.getString(JSON_number_phone));
                bun.putString("date2", json.getString(JSON_EFFDATE2));


                Intent.putExtras(bun);

                startActivityForResult(Intent, 100);


            } catch (JSONException e) {

                e.printStackTrace();
            }











        }


    }

}