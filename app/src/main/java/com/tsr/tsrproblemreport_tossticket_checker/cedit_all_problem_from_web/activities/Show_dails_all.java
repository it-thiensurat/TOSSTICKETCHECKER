package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_sale_edit_problem;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.CircleTransform;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by user on 25/1/2561.
 */

public class Show_dails_all extends AppCompatActivity{
    String contno="";
    JsonArrayRequest jsonArrayRequest ;
    RequestQueue requestQueue ;
    TextView txt_namesale0,txt_position0,txt_teamcode,txt_boss,
             txt_bossposition,txt_CustomerName,txt_ProductName,txt_ProductPrice,
            txt_Addressall,txt_Outstanding,txt_CustomerStatus,txt_AccountStatus,txt_PayLastPeriod,txt_namesale,txt_namesale2,txt_namesale3,txt_namesale4,
            txt_namesale5,txt_position,txt_position2,txt_position3,txt_position4,
            txt_position5,txt_status_name,txt_status_name2,txt_status_name3,txt_status_name4,
            txt_status_name5;

    ImageView handle0,handle,handle2,handle3,handle4,handle5;
    SweetAlertDialog pDialog2;
    GetData_cedit_sale_edit_problem GetDataAdapter2;
    String GET_JSON_DATA_HTTP_URL="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/detalis_all_from_contno.php";
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.custom_popup3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // image=(ImageView)findViewById(R.id.image);

        handle0= (ImageView)findViewById(R.id.handle0);
        txt_namesale0= (TextView)findViewById(R.id.txt_namesale0);
        txt_position0= (TextView)findViewById(R.id.txt_position0);
        txt_teamcode= (TextView)findViewById(R.id.txt_teamcode);
        txt_boss= (TextView)findViewById(R.id.txt_boss);
        txt_bossposition= (TextView)findViewById(R.id.txt_bossposition);
        txt_CustomerName= (TextView)findViewById(R.id.txt_CustomerName);
        txt_ProductName= (TextView)findViewById(R.id.txt_ProductName);
        txt_ProductPrice= (TextView)findViewById(R.id.txt_ProductPrice);
        txt_Addressall= (TextView)findViewById(R.id.txt_Addressall);

        txt_Outstanding= (TextView)findViewById(R.id.txt_Outstanding);
         txt_CustomerStatus= (TextView)findViewById(R.id.txt_CustomerStatus);
        txt_AccountStatus= (TextView)findViewById(R.id.txt_AccountStatus);
        txt_PayLastPeriod= (TextView)findViewById(R.id.txt_PayLastPeriod);



        handle= (ImageView)findViewById(R.id.handle);
          handle2= (ImageView)findViewById(R.id.handle2);
          handle3= (ImageView)findViewById(R.id.handle3);
          handle4= (ImageView)findViewById(R.id.handle4);
          handle5= (ImageView)findViewById(R.id.handle5);

          txt_namesale= (TextView)findViewById(R.id.txt_namesale);
          txt_namesale2= (TextView)findViewById(R.id.txt_namesale2);
          txt_namesale3= (TextView)findViewById(R.id.txt_namesale3);
          txt_namesale4= (TextView)findViewById(R.id.txt_namesale4);
          txt_namesale5= (TextView)findViewById(R.id.txt_namesale5);

          txt_position= (TextView)findViewById(R.id.txt_position);
          txt_position2= (TextView)findViewById(R.id.txt_position2);
          txt_position3= (TextView)findViewById(R.id.txt_position3);
          txt_position4= (TextView)findViewById(R.id.txt_position4);
          txt_position5= (TextView)findViewById(R.id.txt_position5);

          txt_status_name= (TextView)findViewById(R.id.txt_status_name);
          txt_status_name2= (TextView)findViewById(R.id.txt_status_name2);
          txt_status_name3= (TextView)findViewById(R.id.txt_status_name3);
          txt_status_name4= (TextView)findViewById(R.id.txt_status_name4);
          txt_status_name5= (TextView)findViewById(R.id.txt_status_name5);

        Bundle data=getIntent().getExtras();
        if(data!=null)
        {
            contno=data.getString("contno");

            pDialog2 = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
            pDialog2.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
            pDialog2.setTitleText("Loading");
            pDialog2.setCancelable(true);
            pDialog2.show();
            JSON_DATA_WEB_CALL();
        }



    }


    public void JSON_DATA_WEB_CALL() {

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL+"?contno="+contno ,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {



                        JSON_PARSE_DATA_AFTER_WEBCALL(response);
                        pDialog2.dismissWithAnimation();
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



    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array) {

        // if(array.length()==0){
        //    pDialog2.dismissWithAnimation();
        // }


        for (int i = 0; i < array.length(); i++) {

              GetDataAdapter2 = new GetData_cedit_sale_edit_problem();

            JSONObject json = null;

            try {

                json = array.getJSONObject(i);

                GetDataAdapter2.setEmployeeName_sale(json.getString("EmployeeName"));

                GetDataAdapter2.setPositionName_sale(json.getString("PositionName"));

                GetDataAdapter2.setSubTeamName(json.getString("SubTeamName"));
                GetDataAdapter2.setSubTeamHeadName(json.getString("SubTeamHeadName"));

                GetDataAdapter2.setTeamCode(json.getString("TeamCode"));
                GetDataAdapter2.setTeamName(json.getString("TeamName"));
                GetDataAdapter2.setTeamHeadName(json.getString("TeamHeadName"));
                GetDataAdapter2.setSupervisorName(json.getString("SupervisorName"));
                GetDataAdapter2.setSupervisorHeadName(json.getString("SupervisorHeadName"));
                GetDataAdapter2.setSubDepartmentName(json.getString("SubDepartmentName"));
                GetDataAdapter2.setSubDepartmentHeadName(json.getString("SubDepartmentHeadName"));
                GetDataAdapter2.setDepartmentName(json.getString("DepartmentName"));
                GetDataAdapter2.setDepartmentHeadName(json.getString("DepartmentHeadName"));
                GetDataAdapter2.setPicture_sale(json.getString("picture"));
                GetDataAdapter2.setProductName(json.getString("ProductName"));
                GetDataAdapter2.setProductPrice(json.getString("ProductPrice"));
                GetDataAdapter2.setCustomerName(json.getString("CustomerName"));

                GetDataAdapter2.setAddressall(json.getString("Addressall"));
                GetDataAdapter2.setLatitude(json.getString("Latitude"));
                GetDataAdapter2.setLongitude(json.getString("Longitude"));
                GetDataAdapter2.setTelHome(json.getString("TelHome"));
                GetDataAdapter2.setTelMobile(json.getString("TelMobile"));



                GetDataAdapter2.setSaleStatus(json.getString("SaleStatus"));
                GetDataAdapter2.setTeamSaleStatus(json.getString("TeamSaleStatus"));
                GetDataAdapter2.setSupSaleStatus(json.getString("SupSaleStatus"));
                GetDataAdapter2.setSecSaleStatus(json.getString("SecSaleStatus"));
                GetDataAdapter2.setMngSaleStatus(json.getString("MngSaleStatus"));

                GetDataAdapter2.setTeamSaleEmp_picture(json.getString("TeamSaleEmp_picture"));
                GetDataAdapter2.setSupSaleEmp_picture(json.getString("SupSaleEmp_picture"));
                GetDataAdapter2.setSecSaleEmp_picture(json.getString("SecSaleEmp_picture"));
                GetDataAdapter2.setMngSaleEmp_picture(json.getString("MngSaleEmp_picture"));
                GetDataAdapter2.setOutstanding(json.getString("Outstanding"));
                GetDataAdapter2.setCustomerStatus(json.getString("CustomerStatus"));
                GetDataAdapter2.setAccountStatus(json.getString("AccountStatus"));
                GetDataAdapter2.setPayLastPeriod(json.getString("PayLastPeriod"));


            } catch (JSONException e) {

                e.printStackTrace();
            }
        }















        try {
            Glide.with(this).load(GetDataAdapter2.getPicture_sale())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(this))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                    .placeholder(this.getResources().getDrawable(R.drawable.dasaa))
                    .into(handle0);
        }
        catch (Exception e) {

        }



        txt_namesale0.setText(GetDataAdapter2.getEmployeeName_sale());
        txt_position0.setText(GetDataAdapter2.getPositionName_sale());
        txt_teamcode.setText(GetDataAdapter2.getTeamCode());
        txt_boss.setText(GetDataAdapter2.getTeamHeadName());
        txt_bossposition.setText(GetDataAdapter2.getTeamName());
        txt_ProductName.setText(GetDataAdapter2.getProductName());
        txt_ProductPrice.setText(GetDataAdapter2.getProductPrice());
        txt_CustomerName.setText(GetDataAdapter2.getCustomerName());
        txt_Addressall.setText(GetDataAdapter2.getAddressall());





        txt_Outstanding.setText(GetDataAdapter2.getOutstanding());
        txt_CustomerStatus.setText(GetDataAdapter2.getCustomerStatus());
        txt_AccountStatus.setText(GetDataAdapter2.getAccountStatus());
        txt_PayLastPeriod.setText(GetDataAdapter2.getPayLastPeriod());








        try {
            Glide.with(this).load(GetDataAdapter2.getPicture_sale())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(this))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                    .placeholder(this.getResources().getDrawable(R.drawable.dasaa))
                    .into(handle);
        }
        catch (Exception e) {

        }



        try {
            Glide.with(this).load(GetDataAdapter2.getTeamSaleEmp_picture())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(this))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                    .placeholder(this.getResources().getDrawable(R.drawable.dasaa))
                    .into(handle2);
        }
        catch (Exception e) {

        }



        try {
            Glide.with(this).load(GetDataAdapter2.getSupSaleEmp_picture())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(this))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                    .placeholder(this.getResources().getDrawable(R.drawable.dasaa))
                    .into(handle3);
        }
        catch (Exception e) {

        }


        try {
            Glide.with(this).load(GetDataAdapter2.getSecSaleEmp_picture())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(this))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                    .placeholder(this.getResources().getDrawable(R.drawable.dasaa))
                    .into(handle4);
        }
        catch (Exception e) {

        }


        try {
            Glide.with(this).load(GetDataAdapter2.getMngSaleEmp_picture())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(this))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                    .placeholder(this.getResources().getDrawable(R.drawable.dasaa))
                    .into(handle5);
        }
        catch (Exception e) {

        }




        txt_namesale.setText(GetDataAdapter2.getEmployeeName_sale());
        txt_namesale2.setText(GetDataAdapter2.getSubTeamHeadName());
        txt_namesale3.setText(GetDataAdapter2.getSupervisorHeadName());
        txt_namesale4.setText(GetDataAdapter2.getSubDepartmentHeadName());
        txt_namesale5.setText(GetDataAdapter2.getDepartmentHeadName());

        txt_position.setText(GetDataAdapter2.getPositionName_sale());
        txt_position2.setText(GetDataAdapter2.getSubTeamName());
        txt_position3.setText(GetDataAdapter2.getSupervisorName());
        txt_position4.setText(GetDataAdapter2.getSubDepartmentName());
        txt_position5.setText(GetDataAdapter2.getDepartmentName());


        String CHECK_STATUS_SALE1=GetDataAdapter2.getSaleStatus()+"";
        String CHECK_STATUS_SALE2=GetDataAdapter2.getSupSaleStatus()+"";
        String CHECK_STATUS_SALE3=GetDataAdapter2.getSupSaleStatus()+"";
        String CHECK_STATUS_SALE4=GetDataAdapter2.getSecSaleStatus()+"";
        String CHECK_STATUS_SALE5=GetDataAdapter2.getMngSaleStatus()+"";

        if(CHECK_STATUS_SALE1.equals("null")){
            txt_status_name.setText("ยังทำงานอยู่");
            txt_status_name.setBackgroundResource(R.drawable.roun_rect_orange17);
            txt_status_name.setTextColor(0xffffffff);
        }
        else {
            if (CHECK_STATUS_SALE1.equals("N")) {
                txt_status_name.setText("ยังทำงานอยู่");
                txt_status_name.setBackgroundResource(R.drawable.roun_rect_orange17);
                txt_status_name.setTextColor(0xffffffff);

            } else if (CHECK_STATUS_SALE1.equals("P")) {
                txt_status_name.setText("ย้ายตำแหน่ง");
                txt_status_name.setBackgroundResource(R.drawable.roun_rect_orange22);
                txt_status_name.setTextColor(0xffffffff);


            } else {
                txt_status_name.setText("ลาออกแล้ว");
                txt_status_name.setBackgroundResource(R.drawable.roun_rect_orange21);
                txt_status_name.setTextColor(0xffffffff);

            }
        }





        if(CHECK_STATUS_SALE2.equals("null")){
            txt_status_name2.setText("ยังทำงานอยู่");
            txt_status_name2.setBackgroundResource(R.drawable.roun_rect_orange17);
            txt_status_name2.setTextColor(0xffffffff);
        }
        else {
            if (CHECK_STATUS_SALE2.equals("N")) {
                txt_status_name2.setText("ยังทำงานอยู่");
                txt_status_name2.setBackgroundResource(R.drawable.roun_rect_orange17);
                txt_status_name2.setTextColor(0xffffffff);
            } else if (CHECK_STATUS_SALE2.equals("P")) {
                txt_status_name2.setText("ย้ายตำแหน่ง");
                txt_status_name2.setBackgroundResource(R.drawable.roun_rect_orange22);
                txt_status_name2.setTextColor(0xffffffff);

            } else {
                txt_status_name2.setText("ลาออกแล้ว");
                txt_status_name2.setBackgroundResource(R.drawable.roun_rect_orange21);
                txt_status_name2.setTextColor(0xffffffff);

            }
        }





        if(CHECK_STATUS_SALE3.equals("null")){
            txt_status_name3.setText("ยังทำงานอยู่");
            txt_status_name3.setBackgroundResource(R.drawable.roun_rect_orange17);
            txt_status_name3.setTextColor(0xffffffff);
        }
        else {
            if (CHECK_STATUS_SALE3.equals("N")) {
                txt_status_name3.setText("ยังทำงานอยู่");
                txt_status_name3.setBackgroundResource(R.drawable.roun_rect_orange17);
                txt_status_name3.setTextColor(0xffffffff);
            } else if (CHECK_STATUS_SALE3.equals("P")) {
                txt_status_name3.setText("ย้ายตำแหน่ง");
                txt_status_name3.setBackgroundResource(R.drawable.roun_rect_orange22);
                txt_status_name3.setTextColor(0xffffffff);

            } else {
                txt_status_name3.setText("ลาออกแล้ว");
                txt_status_name3.setBackgroundResource(R.drawable.roun_rect_orange21);
                txt_status_name3.setTextColor(0xffffffff);

            }
        }











        if(CHECK_STATUS_SALE4.equals("null")){
            txt_status_name4.setText("ยังทำงานอยู่");
            txt_status_name4.setBackgroundResource(R.drawable.roun_rect_orange17);
            txt_status_name4.setTextColor(0xffffffff);
        }
        else {
            if (CHECK_STATUS_SALE4.equals("N")) {
                txt_status_name4.setText("ยังทำงานอยู่");
                txt_status_name4.setBackgroundResource(R.drawable.roun_rect_orange17);
                txt_status_name4.setTextColor(0xffffffff);
            } else if (CHECK_STATUS_SALE4.equals("P")) {
                txt_status_name4.setText("ย้ายตำแหน่ง");
                txt_status_name4.setBackgroundResource(R.drawable.roun_rect_orange22);
                txt_status_name4.setTextColor(0xffffffff);

            } else {
                txt_status_name4.setText("ลาออกแล้ว");
                txt_status_name4.setBackgroundResource(R.drawable.roun_rect_orange21);
                txt_status_name4.setTextColor(0xffffffff);

            }
        }














        if(CHECK_STATUS_SALE5.equals("null")){
            txt_status_name5.setText("ยังทำงานอยู่");
            txt_status_name5.setBackgroundResource(R.drawable.roun_rect_orange17);
            txt_status_name5.setTextColor(0xffffffff);
        }
        else {
            if (CHECK_STATUS_SALE5.equals("N")) {
                txt_status_name5.setText("ยังทำงานอยู่");
                txt_status_name5.setBackgroundResource(R.drawable.roun_rect_orange17);
                txt_status_name5.setTextColor(0xffffffff);
            } else if (CHECK_STATUS_SALE5.equals("P")) {
                txt_status_name5.setText("ย้ายตำแหน่ง");
                txt_status_name5.setBackgroundResource(R.drawable.roun_rect_orange22);
                txt_status_name5.setTextColor(0xffffffff);

            } else {
                txt_status_name5.setText("ลาออกแล้ว");
                txt_status_name5.setBackgroundResource(R.drawable.roun_rect_orange21);
                txt_status_name5.setTextColor(0xffffffff);

            }
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
