package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
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
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.ContactAdapter;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.RecyclerViewAdapter_sale;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_map;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_sale;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


public class UI_CARDVIEW_DATA_SALE extends Fragment implements    View.OnClickListener, RecyclerViewAdapter_sale.itemclick, RecyclerViewAdapter_sale.itemclick2 {


    private Context mContext;
    GetData_cedit_map getData_cedit_map;
    public UI_CARDVIEW_DATA_SALE(Context mContext) {
        this.mContext = mContext;
    }

    GetData_sale getData_cedit;
    List<GetData_sale> GetDataAdapter1;
    private RecyclerViewAdapter_sale contactAdapter;

    RecyclerView recyclerView;
    RelativeLayout relativeLayout,RelativeLayout_map_contno;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    public static Context context;


    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/sale_data.php";

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



    int setlist = 0;

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
    public UI_CARDVIEW_DATA_SALE() {

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
        fab2 = (android.support.design.widget.FloatingActionButton) layoutView.findViewById(R.id.fab2);

        mShimmerViewContainer = layoutView.findViewById(R.id.shimmer_view_container);


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






    public void JSON_DATA_WEB_CALL2() {

        String EmployeeName = MyApplication.getInstance().getPrefManager().getPreferrence("EmployeeName");
        try {
            Log.e("WEBSERVICE",GET_JSON_DATA_HTTP_URL + "?SaleEmployeeName=" + URLEncoder.encode(EmployeeName, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL + "?SaleEmployeeName=" + URLEncoder.encode(EmployeeName, "UTF-8"),


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
        swipeRefreshLayout.setRefreshing(false);
    }




    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            final GetData_sale GetDataAdapter2 = new GetData_sale();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);

                getData_cedit = new GetData_sale();

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







                //GetDataAdapter2.setDistant(json.getString(JSON_IssueName));
            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter2);
            //  pDialog.dismiss();
        }



                contactAdapter = new RecyclerViewAdapter_sale(GetDataAdapter1, getActivity());


                recyclerView.setAdapter(contactAdapter);


                contactAdapter.setitemclick(this);
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
        inflater.inflate(R.menu.music, menu);
        MenuItem menuItem = menu.findItem(R.id.testAction);
        MenuItem menuItem2 = menu.findItem(R.id.testAction2);
        MenuItem menuItem3 = menu.findItem(R.id.testAction3);
        MenuItem menuItem4 = menu.findItem(R.id.testAction4);
        MenuItem menuItem5 = menu.findItem(R.id.testAction5);

        MenuItem menuItemุ6 = menu.findItem(R.id.action_search);
        //     MenuItem menuItemุ7 = menu.findItem(R.id.map_contno);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItemุ6);
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
    public void click(View v, int position) {

    }

    @Override
    public void click2(View v, int position) {
        try {

            GetData_sale getData_cedit = GetDataAdapter1.get(position);
            position2 = position;


            Intent Intent = new Intent(getActivity(), Detali_data_cedit.class);


            Bundle bun = new Bundle();
            bun.putString("from","by_sale");
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
    public void onClick(View view) {
        if (view == fab) {
            MyApplication.getInstance().getPrefManager().setPreferrence("dat2", "0");
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
                    ContactAdapter.color = 0xff999999;


                    GetDataAdapter1.clear();
                    JSON_DATA_WEB_CALL2();
                } else {
                    fab.setImageResource(R.drawable.ic_save_white_24dp);
                    ContactAdapter.color = 0xff000000;


                    GetDataAdapter1.clear();
                    JSON_DATA_WEB_CALL2();
                }


            }
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
                GetDataAdapter1.clear();
                JSON_DATA_WEB_CALL2();





            } catch (Exception ex) {

            }
        }
        else if(requestCode==103){
            MyApplication.getInstance().getPrefManager().clear();

        }

        else {

        }
    }

}