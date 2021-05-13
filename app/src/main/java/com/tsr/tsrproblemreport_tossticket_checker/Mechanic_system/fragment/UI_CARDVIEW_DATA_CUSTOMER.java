package com.tsr.tsrproblemreport_tossticket_checker.Mechanic_system.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;
import com.tsr.tsrproblemreport_tossticket_checker.Mechanic_system.activity.Activity_tel_custo;
import com.tsr.tsrproblemreport_tossticket_checker.Mechanic_system.adapter.RecyclerViewAdapter_custo;
import com.tsr.tsrproblemreport_tossticket_checker.Mechanic_system.api.Service;
import com.tsr.tsrproblemreport_tossticket_checker.Mechanic_system.model.Get_data_customer;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.tsr.tsrproblemreport_tossticket_checker.Mechanic_system.api.client.BASE_URL;

public class UI_CARDVIEW_DATA_CUSTOMER extends Fragment implements RecyclerViewAdapter_custo.itemclick2   {
    // private DemoFragment currentFragment;






    List<Get_data_customer> GetDataAdapter1;
    RelativeLayout relativeLayout;
    RecyclerView recyclerView;
    private Toolbar toolbar;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    Get_data_customer getDataAdapter;
    RecyclerViewAdapter_custo recyclerViewadapter;
    private RecyclerViewAdapter_custo mAdapter;
    String DADADA;
    // private RecyclerViewAdapter3 adapter;
    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/checker_system/type_check.php";
    String JSON_data = "data";





    SweetAlertDialog pDialog2;

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

        String EMPID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

        recyclerView.setHasFixedSize(true);

        recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(recyclerViewlayoutManager);




        if(checkConnection()==true){
            relativeLayout.setVisibility(View.GONE);

            pDialog2 = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
            pDialog2.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
            pDialog2.setTitleText("Loading");
            pDialog2.setCancelable(true);
            pDialog2.show();


            JSON_DATA_WEB_CALL(EMPID);


            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    recyclerView.setHasFixedSize(true);

                    recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

                    recyclerView.setLayoutManager(recyclerViewlayoutManager);
                    GetDataAdapter1.clear();
                    recyclerView.clearOnScrollListeners();

                    pDialog2 = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
                    pDialog2.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                    pDialog2.setTitleText("Loading");
                    pDialog2.setCancelable(true);
                    pDialog2.show();

                    JSON_DATA_WEB_CALL(EMPID);

                    swipeRefreshLayout.setRefreshing(false);
                }
            });

        }
/*        else {
            relativeLayout.setVisibility(View.VISIBLE);
            JSON_DATA_WEB_CALL(EMPID);


            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    recyclerView.setHasFixedSize(true);

                    recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

                    recyclerView.setLayoutManager(recyclerViewlayoutManager);
                    GetDataAdapter1.clear();
                    recyclerView.clearOnScrollListeners();
                    JSON_DATA_WEB_CALL(EMPID);

                    swipeRefreshLayout.setRefreshing(false);
                }
            });
        }*/





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


        counter.setText("รายการลูกค้า");
        counter.setVisibility(View.GONE);
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



    private void JSON_DATA_WEB_CALL(String empid) {
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            Service request = retrofit.create(Service.class);
            Call call = request.customer(empid);
            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, retrofit2.Response response) {
                    Gson gson = new Gson();
                    try {
                        JSONObject jsonObject = new JSONObject(gson.toJson(response.body()));

                        JSON_PARSE_DATA_AFTER_WEBCALL(jsonObject.getJSONArray("data"));


                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.e("data", "22");
                    }
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    Log.e("data", "2");
                }
            });

        } catch (Exception e) {
            Log.e("data", "3");
        }
    }
    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array){

        if(array.length()==0){
            try {
                pDialog2.cancel();
                pDialog2.dismiss();
            }
            catch (Exception ex){

            }
        }
        else {
            for (int i = 0; i < array.length(); i++) {

                Get_data_customer GetDataAdapter2 = new Get_data_customer();
                // GetDataAdapter1.clear();

                JSONObject json = null;
                try {

                    json = array.getJSONObject(i);
                    //     Log.e(TAG,"หมู json array"+json.getJSONObject("InstallDate").getString("date"));


                    GetDataAdapter2.setCustomername(json.getString("customername"));
                    GetDataAdapter2.setContno(json.getString("contno"));

                    GetDataAdapter2.setTelno(json.getString("telno"));
                    GetDataAdapter2.setAddress(json.getString("address"));
                    GetDataAdapter2.setProductname(json.getString("productname"));
                    GetDataAdapter2.setInstalldate(json.getJSONObject("installdate").getString("date"));


                } catch (JSONException e) {

                    e.printStackTrace();
                }
                GetDataAdapter1.add(GetDataAdapter2);

            }

            try {
                pDialog2.cancel();
                pDialog2.dismiss();
            } catch (Exception ex) {

            }

            recyclerViewadapter = new RecyclerViewAdapter_custo(GetDataAdapter1, getActivity());

            recyclerView.setAdapter(recyclerViewadapter);
            recyclerViewadapter.setitemclick2(this);
        }
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
        getDataAdapter=GetDataAdapter1.get(position);

        Intent = new Intent(getActivity(), Activity_tel_custo.class);
        Bundle bun = new Bundle();
        bun.putString("Contno", getDataAdapter.getContno());
        bun.putString("NAME", getDataAdapter.getCustomername());

        bun.putString("address", getDataAdapter.getAddress());
        bun.putString("productname", getDataAdapter.getProductname());
        bun.putString("installdate", getDataAdapter.getInstalldate());

        Intent.putExtras(bun);
        startActivityForResult(Intent, 23);

    }
}