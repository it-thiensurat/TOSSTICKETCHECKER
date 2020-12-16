package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.comment.RecyclerViewAdapter_comment;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.Comment;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Activity_comment extends AppCompatActivity {
    List<Comment> comments;
    Comment comment;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    JsonArrayRequest jsonArrayRequest ;
    RequestQueue requestQueue ;
    String GET_JSON_DATA_HTTP_URL="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/sale_problem1_json2_real_from_cedit_edit_problem2_copy_real_comment.php";
    RecyclerViewAdapter_comment recyclerViewAdapter_comment;
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chats);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerViewlayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewlayoutManager);
        comments = new ArrayList<>();

        JSON_DATA_WEB_CALL();


    }


    public void JSON_DATA_WEB_CALL() {

        String user_code= MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

        Log.e("user_code",user_code);
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL/*+"?user_code="+user_code */,

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
      //  swipeRefreshLayout.setRefreshing(false);
    }






    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            final Comment GetDataAdapter2 = new Comment();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);
                GetDataAdapter2.setInformID(json.getString("InformID"));
                GetDataAdapter2.setImageUrl(json.getString("ImageUrl"));
                GetDataAdapter2.setWorkCode(json.getString("WorkCode"));
                GetDataAdapter2.setProblemDetail(json.getString("ProblemDetail"));
                GetDataAdapter2.setDate_create(json.getJSONObject("date_create").getString("date"));
                GetDataAdapter2.setName_topic(json.getString("name_topic"));
                GetDataAdapter2.setPicture_topic(json.getString("picture_topic"));

            } catch (JSONException e) {

                e.printStackTrace();
            }


            comments.add(GetDataAdapter2);

        }


         recyclerViewAdapter_comment = new RecyclerViewAdapter_comment(comments,this);
         recyclerView.setAdapter(recyclerViewAdapter_comment);


    }



}
