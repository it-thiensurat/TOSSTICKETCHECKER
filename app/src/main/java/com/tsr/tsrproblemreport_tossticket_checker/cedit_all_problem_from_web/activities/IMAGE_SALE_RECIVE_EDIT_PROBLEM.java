package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.IMAGE_report_problem_all_id_Adapter;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetDataAdapter_image_report_problem_error;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class IMAGE_SALE_RECIVE_EDIT_PROBLEM extends AppCompatActivity implements IMAGE_report_problem_all_id_Adapter.MessageAdapterListener {
    List<GetDataAdapter_image_report_problem_error> GetDataAdapter1;
    GetDataAdapter_image_report_problem_error getDataAdapter_image_report_problem_error;
    IMAGE_report_problem_all_id_Adapter image_report_problem_all_id_adapter;
    RecyclerView recyclerview;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    GridLayoutManager layoutManager;
    Uri fileUri;
    File file;    JsonArrayRequest jsonArrayRequest;

    RequestQueue requestQueue;
    String ID="",image="";
    int i=0;


    String GET_JSON_DATA_HTTP_URL_image_all="sale_problem1_json2_real_image_all_report_problemt.php";
     String  JSON_Image_Name="image";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_report_problem_all_id);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        GetDataAdapter1 = new ArrayList<>();
        recyclerview= (RecyclerView) findViewById(R.id.recyclerview1);

        recyclerview.setHasFixedSize(true);

        recyclerViewlayoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(recyclerViewlayoutManager);
        layoutManager = new GridLayoutManager(this, 3);
        recyclerview.setLayoutManager(layoutManager);
        Bundle data=getIntent().getExtras();
        if(data!=null) {
            // from=data.getString("from");
            ID = data.getString("ID");

        }



        JSON_SELECT_IMAGE_ALL();








    }


    public void JSON_SELECT_IMAGE_ALL() {

String user_code="A07407";

        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_image_all + "?ID=" +ID+ "&user_code=" +user_code,


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
        } catch (Exception e) {
            e.printStackTrace();
        }

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

    }





    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array){

        for(int i = 0; i<array.length(); i++) {

            GetDataAdapter_image_report_problem_error GetDataAdapter2 = new GetDataAdapter_image_report_problem_error();
            // GetDataAdapter1.clear();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);

                GetDataAdapter2.setImage_error(json.getString(JSON_Image_Name));


            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter2);

        }

        image_report_problem_all_id_adapter= new IMAGE_report_problem_all_id_Adapter(GetDataAdapter1, this,this);
        recyclerview.setAdapter(image_report_problem_all_id_adapter);



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


    @Override
    public void onRowClicked(int position) {

    }

    @Override
    public void onRowLongClicked(int position) {

    }
}
