package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.tsr.tsrproblemreport_tossticket_checker.R;

import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.data.constant.Constants;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.data.preference.AppPreference;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.data.preference.PrefKey;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.utility.AppUtils;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit.currentLoc;


public class ResultActivity_report_problem extends AppCompatActivity {
    GetData_cedit getData_cedit;

    String GET_JSON_DATA_HTTP_URL_INSENT_DATA_SALE="http://app.thiensurat.co.th/assanee/api_report_problem_from_contno/ProductSerial_to_contno_of_qrcode.php";
    private Activity mActivity;
    private Context mContext;
    public static String SaleEmployeeName2,SaleTeamCode2,SaleHeaderName2,conno2,conno_qr_code,productname2,status2,customer2,idcard2,address2,Latitude2,Longitude2,phone2,phone_mobile2,phone_home2,date2,latitude2,longitude2,distance2;
    private TextView result, result2;

    public static String data2="";

    JsonArrayRequest jsonArrayRequest;
    JsonObjectRequest jsonObjectRequest;
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initVars();
        initViews();
        initFunctionality();

        // initListeners();
    }





    private void initVars() {
        mActivity = ResultActivity_report_problem.this;
        mContext = mActivity.getApplicationContext();
    }

    private void initViews() {
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        result = (TextView) findViewById(R.id.result);
        result2= (TextView) findViewById(R.id.result2);



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


        if(!data2.equals("")){

            INSENT_DATA_SALE();
        }
        else {
            result2.setVisibility(View.VISIBLE);

        }

        int type = AppUtils.getResourceType(lastResult);

    }



    public void INSENT_DATA_SALE() {

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_INSENT_DATA_SALE+"?ProductSerial="+data2,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.e("response", String.valueOf(response));
                        JSON_PARSE_DATA_AFTER_WEBCALL_INSENT_DATA_SALE(response);

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
String CONTNO="";
    public void JSON_PARSE_DATA_AFTER_WEBCALL_INSENT_DATA_SALE(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {


            JSONObject json = null;
            try {

                json = array.getJSONObject(i);

                 CONTNO = json.getString("CONTNO");

            } catch (JSONException e) {

                e.printStackTrace();
            }
        }


        MyApplication.getInstance().getPrefManager().setPreferrence("qr_code_report_promlem_sale", CONTNO);
        Bundle bun = new Bundle();
        bun.putString("qr_code", CONTNO);
        // Intent.putExtras(bun);
        finish();



    }




    @Override
    protected void onStart() {
        super.onStart();
        try {
            currentLoc.connectGoogleApi();
        }
        catch (Exception ex){

        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        try {
            currentLoc.disConnectGoogleApi();
        }
        catch (Exception ex){

        }
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

