package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.tsr.tsrproblemreport_tossticket_checker.R;

import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.data.constant.Constants;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.data.preference.AppPreference;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.data.preference.PrefKey;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.utility.AppUtils;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.Utils;

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

import cn.pedant.SweetAlert.SweetAlertDialog;

import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.LinearLayout_data2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.LinearLayout_data3;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.check_mylocation;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.currentLoc;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.fab;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.image_qrcode;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.latitude;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.longitude;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.t1;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.t10;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.t2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.t3;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.t4;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.t5;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.t6;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.t7;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.t8;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.t9;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.tv_distance_checker;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.tv_qr_checker;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.txt_address2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.txt_codeteam2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.txt_conno2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.txt_customer2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.txt_date2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.txt_idcard2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.txt_phone2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.txt_productname2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.txt_status2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.txtname_sale2;


public class ResultActivity extends AppCompatActivity {
    GetData_cedit getData_cedit;


    private Activity mActivity;
    private Context mContext;
    public static String SaleEmployeeName2,SaleTeamCode2,SaleHeaderName2,conno2,conno_qr_code,productname2,status2,customer2,idcard2,address2,Latitude2,Longitude2,phone2,phone_mobile2,phone_home2,date2,latitude2,longitude2,distance2;
    private TextView result, result2;
    private ImageView actionIcon;

    private LinearLayout buttonCopy, buttonSearch, buttonShare, buttonAction;
    private String conno,url2;
public static String data2="",data3="";
    JsonArrayRequest jsonArrayRequest;

    RequestQueue requestQueue;

    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/insert_check_customer.php";
    String GET_JSON_DATA_HTTP_URL2 = "http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/insert_check_customer_history.php";
    String GET_JSON_DATA_HTTP_URL3 = "http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/cedit_data_contno.php";
   public static String conno_qr,refno,LA,LO,address,address_now;

    String JSON_CONTNO = "CONTNO";
    String JSON_RefNo = "RefNo";
    String JSON_isremark = "isremark";

    String JSON_SaleEmployeeName = "SaleEmployeeName";
    String JSON_SaleTeamCode = "SaleTeamCode";
    String JSON_SaleHeaderName = "SaleHeaderName";

    String JSON_IDCARD= "IDCARD";
    String JSON_CustomerName = "CustomerName";
    String JSON_ADDRESSS = "ADDRESSS";
    String JSON_Latitude = "Latitude";
    String JSON_Longitude = "Longitude";


    String JSON_statusName= "statusName";
    String JSON_TelMobile = "TelMobile";
    String JSON_TelHome = "TelHome";
    String JSON_ProductName = "ProductName";


    Double DIS,lat_intro2,long_intro2,lat_end2,long_end2;
    public  static Double dist = 0.0;
    public static int view_scan=0;
    public  static int view_contno_success=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initVars();
        initViews();
        initFunctionality();

       // initListeners();
    }





    private void initVars() {
        mActivity = ResultActivity.this;
        mContext = mActivity.getApplicationContext();
    }

    private void initViews() {
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        result = (TextView) findViewById(R.id.result);
        result2= (TextView) findViewById(R.id.result2);

        Bundle data=getIntent().getExtras();
        if(data!=null) {

            conno = data.getString("conno");
        }

    }

    private void initFunctionality() {

        getSupportActionBar().setTitle(getString(R.string.result));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ArrayList<String> arrayList = AppPreference.getInstance(mContext).getStringArray(PrefKey.RESULT_LIST);
        String lastResult = arrayList.get(arrayList.size() - 1);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            data2=Html.fromHtml(lastResult, Html.FROM_HTML_MODE_LEGACY).toString();
            result.setText(Html.fromHtml(lastResult, Html.FROM_HTML_MODE_LEGACY));
        } else {
            result.setText(Html.fromHtml(lastResult));
            data2=Html.fromHtml(lastResult).toString();
        }
        result.setMovementMethod(LinkMovementMethod.getInstance());

        String chaeck_nember="8859112600026";
         conno_qr = MyApplication.getInstance().getPrefManager().getPreferrence("conno_qr");

        refno= MyApplication.getInstance().getPrefManager().getPreferrence("RefNo_all");
        LA= MyApplication.getInstance().getPrefManager().getPreferrence("Latitude");
        LO= MyApplication.getInstance().getPrefManager().getPreferrence("Longitude");
        address= MyApplication.getInstance().getPrefManager().getPreferrence("address");
        address_now= MyApplication.getInstance().getPrefManager().getPreferrence("address_now");
        conno_qr_code=data2;
        data3=data2;
        if(data2.equals(conno_qr)){
            //result2.setText("8850051015674");

            latitude2 = latitude;
            longitude2 = longitude;
            Log.e("latitude2latitude2",latitude2+longitude2);
            VIEW_DATA();

            INSENT_DATA_CHECK_QRCOD();


            INSENT_history_qr();



            view_contno_success=1;


            finish();
        }
        else {
            view_contno_success=0;
            result2.setText("ไม่มีข้อมูล");
            latitude2 = latitude;
            longitude2 = longitude;
            Log.e("latitude2latitude2",latitude2+longitude2);
            VIEW_DATA();
            INSENT_history_qr();

            fab.setVisibility(View.VISIBLE);
            if((LA.equals("0"))&(LO.equals("0"))) {
                getDistanceInfo2(address_now,address);

                distance2= String.valueOf(dist);
            }
            else {
                getDistanceInfo(latitude2+","+longitude2,Latitude2+","+Longitude2);

                distance2= String.valueOf(dist);
            }


            LinearLayout_data2.setVisibility(View.GONE);
            LinearLayout_data3.setVisibility(View.VISIBLE);
            fab.setVisibility(View.VISIBLE);
            tv_qr_checker.setBackgroundResource(R.drawable.roun_rect_orange9);
            tv_qr_checker.setText("ตรวจสอบแล้ว");
            tv_distance_checker.setBackgroundResource(R.drawable.roun_rect_orange10);
            tv_distance_checker.setText(distance2 + " km ");
            image_qrcode.setBackgroundResource(R.drawable.icon_error);
            if(dist >= 0.5) {
                check_mylocation.setBackgroundResource(R.drawable.icon_error);
            }
            else {
                check_mylocation.setBackgroundResource(R.drawable.icon_success);
            }

            t1.setVisibility(View.GONE);
            t2.setVisibility(View.GONE);
            t3.setVisibility(View.GONE);
            t4.setVisibility(View.GONE);
            t5.setVisibility(View.GONE);
            t6.setVisibility(View.GONE);
            t7.setVisibility(View.GONE);
            t8.setVisibility(View.GONE);
            t9.setVisibility(View.GONE);
            t10.setVisibility(View.GONE);


         //   loading();
          //  Thread xy = new Thread(myThread5);
           // xy.start();



            finish();
        }
        // TODO Sample fullscreen Ad implementation
        // fullscreen ad


        int type = AppUtils.getResourceType(lastResult);

    }
    @Override
    protected void onStart() {
        super.onStart();
        currentLoc.connectGoogleApi();
    }

    @Override
    protected void onStop() {
        super.onStop();
        currentLoc.disConnectGoogleApi();
    }
    private  void VIEW_DATA(){
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL3+"?CONTNO="+data2,


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

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

    }

    public void JSON_PARSE_DATA_AFTER_WEBCALL( JSONArray array) {

        for (int i = 0; i <= array.length()-1; i++) {

            final GetData_cedit GetDataAdapter2 = new GetData_cedit();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);




                getData_cedit =new GetData_cedit();


                getData_cedit.setCONTNO2(json.getString(JSON_CONTNO));
                getData_cedit.setRefNo2(json.getString(JSON_RefNo));
                getData_cedit.setSaleEmployeeName2(json.getString(JSON_SaleEmployeeName));
                getData_cedit.setSaleTeamCode2(json.getString(JSON_SaleTeamCode));
                getData_cedit.setSaleHeaderName2(json.getString(JSON_SaleHeaderName));
                getData_cedit.setIDCARD2(json.getString(JSON_IDCARD));
                getData_cedit.setCustomerName2(json.getString(JSON_CustomerName));
                getData_cedit.setAddressDetail2(json.getString(JSON_ADDRESSS));
                getData_cedit.setLatitude2(json.getString(JSON_Latitude));
                getData_cedit.setLongitude2(json.getString(JSON_Longitude));
                getData_cedit.setTelMobile2(json.getString(JSON_TelMobile));
                getData_cedit.setTelHome2(json.getString(JSON_TelHome));
                getData_cedit.setProductName2(json.getString(JSON_ProductName));
                getData_cedit.setstatusName2(json.getString(JSON_statusName));
                getData_cedit.setEFFDATE2(json.getJSONObject("EFFDATE").getString("date"));



                SaleEmployeeName2=getData_cedit.getSaleEmployeeName2();
                SaleTeamCode2=getData_cedit.getSaleTeamCode2();
                SaleHeaderName2=getData_cedit.getSaleHeaderName2()+"";

                Log.e("SaleHeaderName2",SaleHeaderName2);
                conno2=getData_cedit.getCONTNO2();
                idcard2=getData_cedit.getIDCARD2();
                productname2=getData_cedit.getProductName2();
                status2=getData_cedit.getstatusName2();
                customer2=getData_cedit.getCustomerName2();
                address2=getData_cedit.getAddressDetail2();
                Latitude2=getData_cedit.getLatitude2();
                Longitude2=getData_cedit.getLongitude2();

                date2=getData_cedit.getEFFDATE2();
                phone_mobile2=getData_cedit.getTelMobile2();
                phone_home2=getData_cedit.getTelHome2();





                try {
                    lat_intro2= Double.valueOf(latitude2);                    //callcurus
                    long_intro2= Double.valueOf(longitude2);
                    lat_end2= Double.valueOf(Latitude2);
                    long_end2= Double.valueOf(Longitude2);

                    if((LA.equals("0"))&(LO.equals("0"))) {
                        getDistanceInfo2(address_now,address);

                        distance2= String.valueOf(dist);
                    }
                    else {
                        getDistanceInfo(latitude2+","+longitude2,Latitude2+","+Longitude2);

                        distance2= String.valueOf(dist);
                    }



                }
                catch (Exception ex){

                }




                txtname_sale2.setText(SaleEmployeeName2);
                txt_codeteam2.setText(SaleTeamCode2);
                txt_conno2.setText(conno2);
                txt_productname2.setText(productname2);

                if((conno_qr_code.equals(data2))){

                    txt_status2.setText("เลขที่สัญญาถูกต้อง");
                    txt_status2.setTextColor(0xff26ae90);
                    //  LinearLayout_status.setBackgroundColor(0xffFFFFFF);
                }
                else {

                    txt_status2.setText("เลขที่สัญญาไม่ตรงกัน");
                    txt_status2.setTextColor(0xffF63D2B);

                }

                //txt_status2.setText(status2);
                txt_customer2.setText(customer2);
                txt_idcard2.setText(idcard2);
                txt_address2.setText(address2);
                txt_phone2.setText(phone_mobile2+" , "+phone_home2);
                txt_date2.setText(date2);


                if(data2.equals(conno_qr)) {
                    fab.setVisibility(View.VISIBLE);
                    LinearLayout_data3.setVisibility(View.GONE);
                    tv_qr_checker.setBackgroundResource(R.drawable.roun_rect_orange9);
                    tv_qr_checker.setText("ตรวจสอบแล้ว");

                    tv_distance_checker.setBackgroundResource(R.drawable.roun_rect_orange10);
                    tv_distance_checker.setText(distance2 + " km ");

                    image_qrcode.setBackgroundResource(R.drawable.icon_success);
                    if(dist >= 0.5) {
                        check_mylocation.setBackgroundResource(R.drawable.icon_error);
                    }
                    else {
                        check_mylocation.setBackgroundResource(R.drawable.icon_success);
                    }
                }
                else {


                    LinearLayout_data2.setVisibility(View.GONE);
                    LinearLayout_data3.setVisibility(View.VISIBLE);
                    tv_qr_checker.setBackgroundResource(R.drawable.roun_rect_orange9);
                    tv_qr_checker.setText("ตรวจสอบแล้ว");

                    tv_distance_checker.setBackgroundResource(R.drawable.roun_rect_orange10);
                    tv_distance_checker.setText(distance2 + " km ");
                    image_qrcode.setBackgroundResource(R.drawable.icon_error);
                    if(dist >= 0.5) {
                        check_mylocation.setBackgroundResource(R.drawable.icon_error);
                    }
                    else {
                        check_mylocation.setBackgroundResource(R.drawable.icon_success);
                    }






                }

            } catch (JSONException e) {

                e.printStackTrace();
            }

        }

      //  Thread xy = new Thread(myThread5);
      //  xy.start();

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


        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dist;

    }


    private double getDistanceInfo2(String city1,String city2) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        StringBuilder stringBuilder = new StringBuilder();

        Double da = 0.0;
        try {

            url2 = "http://maps.googleapis.com/maps/api/directions/json?origin=" + URLEncoder.encode(city1, "UTF-8")+"&destination=" + URLEncoder.encode(city2, "UTF-8") + "&sensor=false" ;



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



            dist = Double.parseDouble(distance.getString("value"));

            dist=dist/1000.0;


        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dist;

    }






    String txt3="";
    private Runnable myThread5 = new Runnable(){
        public void run() {
            try{
                String salecode = MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");

                String data="&salename="+SaleEmployeeName2+"&teamcode="+SaleTeamCode2+"&headname="+SaleHeaderName2+"&salecode="+salecode+"&conno="+conno_qr+"&conno_qr_code="+conno_qr_code+"&status_qrcode="+"1"+"&lat_long="+latitude2+","+longitude2+"&distance="+distance2+"&product_name="+productname2+"&status="+status2+"&name_customer="+customer2
                        +"&id_card="+idcard2+"&address="+address2+"&number_phone="+phone_mobile2+" , "+phone_home2+"&date="+date2;


                Log.e("datadatadata",data);
                String re=	Utils.sendPostData(data.getBytes("UTF-8"), Utils.DATA_CEDIT2);
                Utils.isshop=true;
                txt3=re;


            }
            catch(Exception e)
            {
                e.printStackTrace();

            }
            myHandle3.sendMessage(myHandle3.obtainMessage());
        }
    };

    Handler myHandle3 = new Handler(){
        @Override
        public void handleMessage(android.os.Message msg) {
            if (txt3.equals("success")){
                pDialog.dismiss();
                success(txt3);
            }
            else {
                pDialog.dismiss();
                error(txt3);
            }
        }
    };



    SweetAlertDialog pDialog;
    private void loading(){
        pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading");
        pDialog.setCancelable(false);
        pDialog.show();
    }
    private void success(String success){
        new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText(success)
                .setContentText("บันทึกสำเร็จ!")
                .setConfirmText("OK")
                .showCancelButton(true)

                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {


                        sDialog.cancel();
                    }
                })
                .show();

    }

    private void error(String error){
        new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText(error)
                .setContentText("ไม่สำเร็จ!")
                .setConfirmText("OK")
                .showCancelButton(true)

                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {


                        sDialog.cancel();
                    }
                })
                .show();

    }



    private  void INSENT_DATA_CHECK_QRCOD(){

    String salecode = MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");
    //String SALECODE = MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");
    //jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL3+"?pagestart="+"0"+"&pagsesize="+"10"+"&place="+"13.9012707,100.4514525",
    // Log.e("web_moo",GET_JSON_DATA_HTTP_URL3+"?pagestart="+"0"+"&pagsesize="+"10"+"&place="+"13.9012707,100.4514525");
    jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL+"?salecode="+salecode+"&conno="+conno_qr+"&status_qrcode="+"1",


            new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });

    requestQueue = Volley.newRequestQueue(this);

    requestQueue.add(jsonArrayRequest);

}





    private  void INSENT_history_qr(){

        String salecode = MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");
        String empid = MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        //jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL3+"?pagestart="+"0"+"&pagsesize="+"10"+"&place="+"13.9012707,100.4514525",
        // Log.e("web_moo",GET_JSON_DATA_HTTP_URL3+"?pagestart="+"0"+"&pagsesize="+"10"+"&place="+"13.9012707,100.4514525");
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL2+"?empid="+empid+"&salecode="+salecode+"&refno="+refno+"&conno="+conno_qr+"&titleTypeCode="+"SCAN"+"&partimage="+"success",


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (requestCode == Constants.PERMISSION_REQ) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", result.getText().toString(), null)));
            }
        } else {
            AppUtils.showToast(mContext, getString(R.string.permission_not_granted));
        }
    }

}

