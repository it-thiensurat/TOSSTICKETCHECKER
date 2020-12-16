package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
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
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.ContactAdapter;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_map;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_sale_recive_problem;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import at.grabner.circleprogress.CircleProgressView;

public class MainFragment_map_contno_credit extends Fragment  implements OnMapReadyCallback,View.OnClickListener {


    private Context mContext;
    GetData_cedit_map getData_cedit_map;
    @SuppressLint("ValidFragment")
    public MainFragment_map_contno_credit(Context mContext) {
        this.mContext = mContext;
    }
    SupportMapFragment mapFragment;
    Marker melbourne;
    MusicActivity_Credit musicActivity_credit;

    String DADADA;
    GetData_cedit_sale_recive_problem getData_cedit;
    List<GetData_cedit_sale_recive_problem> GetDataAdapter1;
    private ContactAdapter contactAdapter;
    public static CircleProgressView mCircleView;
    GetData_cedit getDataAdapter;
    RecyclerView recyclerView;
    RelativeLayout relativeLayout,RelativeLayout_map_contno;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    public static Context context;
    JSONObject jsonObject;


    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/cedit_problem_contno_map.php";
    String GET_JSON_DATA_HTTP_URL2="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/cedit_problem_contno_map2.php";

   public static GoogleMap googleMap;
    String CC;
    ContactAdapter recycleview_data_cedit;
    String JSON_Contno = "Contno";
    String JSON_WorkCode = "WorkCode";
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

    String PositionCode="";
    String CONTNO,PRODUCT;
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




    public MainFragment_map_contno_credit() {

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

        String EMPID = MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL + "?EMPID=" + EMPID,


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

    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array) {


        for (i = 0; i < array.length(); i++) {

            final GetData_cedit_sale_recive_problem GetDataAdapter2 = new GetData_cedit_sale_recive_problem();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);

                getData_cedit = new GetData_cedit_sale_recive_problem();

                GetDataAdapter2.setContno(json.getString(JSON_Contno));
                GetDataAdapter2.setWorkCode(json.getString(JSON_WorkCode));

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




                iis++;

                String LA_A = GetDataAdapter2.getLatitude()+"";
                String LO_O = GetDataAdapter2.getLongitude()+"";
                 CONTNO = GetDataAdapter2.getContno()+"";
                 PRODUCT=GetDataAdapter2.getProductName()+"";
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
                            .title("เลขที่สัญญา : "+CONTNO+" : สินค้า : "+PRODUCT)
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
        if(PositionCode.equals("Credit")){
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








                if(PositionCode.equals("Credit")){
                    JSON_DATA_WEB_CALL();
                }

                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(13.9012801, 100.5039834), 12));





            }
        });




    }

    public void JSON_DATA_WEB_CALL2() {

        String EMPID = MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL2 + "?EMPID=" + EMPID+ "&contno=" + CON,


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








                Intent Intent = new Intent(getActivity(), UI_CARDVIEW_DATA_CEDIT_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_Activity_map.class);


                Bundle bun = new Bundle();

                bun.putString("Contno", json.getString(JSON_Contno));



                Intent.putExtras(bun);

                startActivityForResult(Intent, 100);


            } catch (JSONException e) {

                e.printStackTrace();
            }


        }


    }




}