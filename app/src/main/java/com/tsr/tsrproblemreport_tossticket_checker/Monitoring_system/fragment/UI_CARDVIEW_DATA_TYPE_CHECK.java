package com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
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
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.activity.Detali_check1;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.activity.Detali_check2;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.activity.Detali_check3;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.adapter.RecyclerViewAdapter_type_check;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.Get_data_type_check;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UI_CARDVIEW_DATA_TYPE_CHECK extends Fragment implements RecyclerViewAdapter_type_check.itemclick2   {
    // private DemoFragment currentFragment;






    List<Get_data_type_check> GetDataAdapter1,GetDataAdapter3;
    RelativeLayout relativeLayout;
    RecyclerView recyclerView;
    private Toolbar toolbar;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    Get_data_type_check getDataAdapter;
    RecyclerViewAdapter_type_check recyclerViewadapter;
    private RecyclerViewAdapter_type_check mAdapter;
    String DADADA;
    // private RecyclerViewAdapter3 adapter;
    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/checker_system/type_check.php";
    String JSON_data = "data";







    public static String  refno2,count_foller2;
    JsonArrayRequest jsonArrayRequest ;
    // private RVAdapter adapter;
    RequestQueue requestQueue ;
    private SwipeRefreshLayout swipeRefreshLayout;
    TextView counter;
    private ProgressDialog pDialog;
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        // setHasOptionsMenu(true);


        recyclerView.setHasFixedSize(true);

        recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(recyclerViewlayoutManager);




        if(checkConnection()==true){
            relativeLayout.setVisibility(View.GONE);
            JSON_DATA_WEB_CALL();


            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    recyclerView.setHasFixedSize(true);

                    recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

                    recyclerView.setLayoutManager(recyclerViewlayoutManager);
                    GetDataAdapter1.clear();
                    recyclerView.clearOnScrollListeners();
                    JSON_DATA_WEB_CALL();

                    swipeRefreshLayout.setRefreshing(false);
                }
            });

        }
        else {
            relativeLayout.setVisibility(View.VISIBLE);
            JSON_DATA_WEB_CALL();


            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    recyclerView.setHasFixedSize(true);

                    recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

                    recyclerView.setLayoutManager(recyclerViewlayoutManager);
                    GetDataAdapter1.clear();
                    recyclerView.clearOnScrollListeners();
                    JSON_DATA_WEB_CALL();

                    swipeRefreshLayout.setRefreshing(false);
                }
            });
        }





    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layoutView = inflater.inflate(R.layout.cardview_row22, container, false);



        //toolbar = (Toolbar) layoutView.findViewById(R.id.toolbar);

        //  getActivity().invalidateOptionsMenu();
        setHasOptionsMenu(true);


        swipeRefreshLayout = (SwipeRefreshLayout)layoutView.findViewById(R.id.swipe_refresh_layout);
        //  swipeRefreshLayout.setOnRefreshListener(getActivity());
        counter=(TextView) layoutView.findViewById(R.id.counter);
        GetDataAdapter1 = new ArrayList<>();



        recyclerView = (RecyclerView)layoutView. findViewById(R.id.recyclerview1);

        relativeLayout= (RelativeLayout) layoutView.findViewById(R.id.relativeLayout);




        return layoutView;

    }

    protected boolean checkConnection(){
        boolean re=false;
        try{
            ConnectivityManager conMan = (ConnectivityManager) this.getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

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
    public void JSON_DATA_WEB_CALL(){
        String salecode = MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL+"?salecode="+salecode,

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
        swipeRefreshLayout.setRefreshing(false);
    }




    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array){
        //  pDialog = new ProgressDialog(getActivity());
        // Showing progress dialog before making http request
        //  pDialog.setMessage("กำลังโหลดข้อมูล...");
        //  pDialog.show();
        for(int i = 0; i<array.length(); i++) {

            Get_data_type_check GetDataAdapter2 = new Get_data_type_check();
            // GetDataAdapter1.clear();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);
                //     Log.e(TAG,"หมู json array"+json.getJSONObject("InstallDate").getString("date"));



                GetDataAdapter2.setData(json.getString(JSON_data));




            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter2);

        }

       recyclerViewadapter = new RecyclerViewAdapter_type_check(GetDataAdapter1, getActivity());

        recyclerView.setAdapter(recyclerViewadapter);
        recyclerViewadapter.setitemclick2(this);

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

    Intent Intent;
    @Override
    public void click2(View v, int position) {

        if(position==0){
             Intent = new Intent(getActivity(), Detali_check1.class);
        }
        else if(position==1){
             Intent = new Intent(getActivity(), Detali_check2.class);
        }
        else if(position==2){
             Intent = new Intent(getActivity(), Detali_check3.class);
        }

        Bundle bun = new Bundle();
       // bun.putString("ID", getData_cedit_sale_edit_problem.getID());
        Intent.putExtras(bun);
        startActivityForResult(Intent, 23);

    }
}