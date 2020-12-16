package com.tsr.tsrproblemreport_tossticket_checker.Mechanic_system.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;
import com.tsr.tsrproblemreport_tossticket_checker.Mechanic_system.adapter.RecyclerViewAdapter_tel;
import com.tsr.tsrproblemreport_tossticket_checker.Mechanic_system.api.Service;
import com.tsr.tsrproblemreport_tossticket_checker.Mechanic_system.model.Get_data_tel;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.jsonlogin.LOGIN_MAIN;

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


public class Activity_tel_custo extends AppCompatActivity implements RecyclerViewAdapter_tel.itemclick2,RecyclerViewAdapter_tel.itemclick3   {

    SweetAlertDialog pDialog2;
    List<Get_data_tel> GetDataAdapter1;
    RelativeLayout relativeLayout;
    RecyclerView recyclerView;
    private Toolbar toolbar;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    Get_data_tel getDataAdapter;
    RecyclerViewAdapter_tel recyclerViewadapter;
    private RecyclerViewAdapter_tel mAdapter;

    public static String  refno2,count_foller2;
    JsonArrayRequest jsonArrayRequest ;
    // private RVAdapter adapter;
    RequestQueue requestQueue ;
    private SwipeRefreshLayout swipeRefreshLayout;
    TextView counter;
    private ProgressDialog pDialog;
    String Contno="",NAME="",address="",productname="",installdate="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custo_tel);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_refresh_layout);
        //  swipeRefreshLayout.setOnRefreshListener(getActivity());
        counter=(TextView) findViewById(R.id.counter);
        GetDataAdapter1 = new ArrayList<>();



        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);

        relativeLayout= (RelativeLayout) findViewById(R.id.relativeLayout);


        Bundle data=getIntent().getExtras();
        if(data!=null)
        {
            Contno=data.getString("Contno");
            NAME=data.getString("NAME");

            address=data.getString("address");
            productname=data.getString("productname");
            installdate=data.getString("installdate");


            counter.setText("เบอร์ลูกค้า > "+NAME);

            setTitle(Contno);
        }




        if(checkConnection()==true){
            relativeLayout.setVisibility(View.GONE);

            pDialog2 = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
            pDialog2.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
            pDialog2.setTitleText("Loading");
            pDialog2.setCancelable(true);
            pDialog2.show();

            recyclerView.setHasFixedSize(true);

            recyclerViewlayoutManager = new LinearLayoutManager(Activity_tel_custo.this);

            recyclerView.setLayoutManager(recyclerViewlayoutManager);
            GetDataAdapter1.clear();
            recyclerView.clearOnScrollListeners();


            JSON_DATA_WEB_CALL(Contno);


            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    recyclerView.setHasFixedSize(true);

                    recyclerViewlayoutManager = new LinearLayoutManager(Activity_tel_custo.this);

                    recyclerView.setLayoutManager(recyclerViewlayoutManager);
                    GetDataAdapter1.clear();
                    recyclerView.clearOnScrollListeners();

                    pDialog2 = new SweetAlertDialog(Activity_tel_custo.this, SweetAlertDialog.PROGRESS_TYPE);
                    pDialog2.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                    pDialog2.setTitleText("Loading");
                    pDialog2.setCancelable(true);
                    pDialog2.show();

                    JSON_DATA_WEB_CALL(Contno);

                    swipeRefreshLayout.setRefreshing(false);
                }
            });

        }

    }

    protected boolean checkConnection(){
        boolean re=false;
        try{
            ConnectivityManager conMan = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

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

    private void JSON_DATA_WEB_CALL(String contno) {
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            Service request = retrofit.create(Service.class);
            Call call = request.tel(contno);
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
        Log.e("xxxx", String.valueOf(array.length()));

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

                Get_data_tel GetDataAdapter2 = new Get_data_tel();
                // GetDataAdapter1.clear();

                JSONObject json = null;
                try {

                    json = array.getJSONObject(i);
                    //     Log.e(TAG,"หมู json array"+json.getJSONObject("InstallDate").getString("date"));


                    GetDataAdapter2.setTel(json.getString("telno"));
                    GetDataAdapter2.setContno(json.getString("contno"));

                    GetDataAdapter2.setNAME(NAME);
                    GetDataAdapter2.setAddress(address);

                    GetDataAdapter2.setProductname(productname);
                    GetDataAdapter2.setInstalldate(installdate);



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

            recyclerViewadapter = new RecyclerViewAdapter_tel(GetDataAdapter1, this);

            recyclerView.setAdapter(recyclerViewadapter);
            recyclerViewadapter.setitemclick2(this);
        }
    }

    @Override
    public void click3(View v, int position) {

        getDataAdapter = GetDataAdapter1.get(position);

        if (getDataAdapter.getTel().equals("กรุณากรอกเบอร์โทร")) {


        AlertDialog.Builder alertbox = new AlertDialog.Builder(this);

        LinearLayout ll_alert_layout = new LinearLayout(this);
        ll_alert_layout.setOrientation(LinearLayout.VERTICAL);
        final EditText ed_input = new EditText(this);
        ll_alert_layout.addView(ed_input);

        alertbox.setTitle("ยืนยันเบอร์โทร");
        alertbox.setMessage("สำหรับส่ง sms");

        //setting linear layout to alert dialog

        alertbox.setView(ll_alert_layout);

        alertbox.setNegativeButton("ออก",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {

                        // will automatically dismiss the dialog and will do nothing

                    }
                });


        alertbox.setPositiveButton("ส่ง SMS",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {

                        String input_text = ed_input.getText().toString();

                        // do your action with input string
                        sent_sms(input_text, getDataAdapter.getContno());

                    }
                });
        alertbox.show();
    }

    }

    @Override
    public void click2(View v, int position) {
        getDataAdapter=GetDataAdapter1.get(position);

            if(getDataAdapter.getTel().equals("กรุณากรอกเบอร์โทร")){




                    AlertDialog.Builder alertbox = new AlertDialog.Builder(this);

                    LinearLayout ll_alert_layout = new LinearLayout(this);
                    ll_alert_layout.setOrientation(LinearLayout.VERTICAL);
                    final EditText ed_input = new EditText(this);
                    ll_alert_layout.addView(ed_input);

                    alertbox.setTitle("ยืนยันเบอร์โทร");
                    alertbox.setMessage("สำหรับส่ง sms");

                    //setting linear layout to alert dialog

                    alertbox.setView(ll_alert_layout);

                    alertbox.setNegativeButton("ออก",
                            new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface arg0, int arg1) {

                                    // will automatically dismiss the dialog and will do nothing

                                }
                            });


                    alertbox.setPositiveButton("ส่ง SMS",
                            new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface arg0, int arg1) {

                                    String input_text = ed_input.getText().toString();

                                    // do your action with input string
                                    sent_sms(input_text,getDataAdapter.getContno());

                                }
                            });
                    alertbox.show();




            }
            else {

                new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("คุณแนใจ ?")
                        .setContentText("ที่ต้องการส่ง sms ให้ลูกค้า! \nเบอร์ : "+getDataAdapter.getTel())
                        .setCancelText("ไม่,ออก!")
                        .setConfirmText("ไช่,ส่ง sms!")
                        .showCancelButton(true)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.cancel();
                                sent_sms(getDataAdapter.getTel(),getDataAdapter.getContno());
                            }
                        })
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.cancel();
                            }
                        })
                        .show();


            }




    }

    private void sent_sms(String tel,String contno) {
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            Service request = retrofit.create(Service.class);
            Call call = request.sentsms(tel,contno);



            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, retrofit2.Response response) {
                    Gson gson = new Gson();
                    try {


                        JSONObject jsonObject = new JSONObject(gson.toJson(response.body()));
                        //JSON_PARSE_DATA_AFTER_WEBCALL(jsonObject.getJSONArray("data"));

                        new SweetAlertDialog(Activity_tel_custo.this, SweetAlertDialog.SUCCESS_TYPE)
                                .setTitleText("sucess")
                                .setContentText("ส่ง sms เรียบร้อย!")
                                .show();


                    } catch (JSONException e) {
                        e.printStackTrace();




                        new SweetAlertDialog(Activity_tel_custo.this, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("error")
                                .setContentText("ส่ง sms ไม่สำเร็จ!")
                                .show();


                    }
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    Log.e("data", "2");
                }
            });



            new SweetAlertDialog(Activity_tel_custo.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("sucess")
                    .setContentText("ส่ง sms เรียบร้อย!")
                    .show();

        } catch (Exception e) {
            Log.e("data", "3");
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
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
