package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.RecyclerViewAdapterCheckBox2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetDataAdapterCheckBox;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class UI_CARDVIEW_DATA_CEDIT_report_problem2 extends Fragment implements View.OnClickListener   {



    List<GetDataAdapterCheckBox> GetDataAdapter1;
    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/groud_problem_add.php";
    String GET_insent_report_problem="http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/insert_report_problem.php";

    RecyclerViewAdapterCheckBox2 recyclerViewadapter1;
    String JSON_ID = "id_add";
    String JSON_PROBLEM = "topic_problem_add";

    RecyclerView recyclerView;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    JsonArrayRequest jsonArrayRequest ;
    RequestQueue requestQueue ;
    RelativeLayout relativeLayout;
    SwipeRefreshLayout swipeRefreshLayout;

    FloatingActionButton floatingActionButton;

    StringBuilder stringBuilder,stringBuilder2,stringBuilder3,stringBuilder4;
    String DADA,DADA2,DADA3;
    StringBuilder kaka;

    String Description="";
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        recyclerView.setHasFixedSize(true);

        recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(recyclerViewlayoutManager);


        JSON_DATA_WEB_CALL();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                recyclerView.setHasFixedSize(true);

                recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

                recyclerView.setLayoutManager(recyclerViewlayoutManager);

                GetDataAdapter1.clear();
                JSON_DATA_WEB_CALL();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View layoutView = inflater.inflate(R.layout.cardview_row_cedit_cedit, container, false);

        setHasOptionsMenu(true);



        GetDataAdapter1 = new ArrayList<>();

        recyclerView = (RecyclerView) layoutView.findViewById(R.id.recyclerview1);
        relativeLayout= (RelativeLayout) layoutView.findViewById(R.id.relativeLayout);
        swipeRefreshLayout = (SwipeRefreshLayout) layoutView.findViewById(R.id.swipe_refresh_layout);
        floatingActionButton= (FloatingActionButton) layoutView.findViewById(R.id.fab);
        relativeLayout.setVisibility(View.GONE);
        floatingActionButton.setOnClickListener(this);
        return layoutView;

    }


    public void JSON_DATA_WEB_CALL() {

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL ,


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




    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            final GetDataAdapterCheckBox GetDataAdapter2 = new GetDataAdapterCheckBox();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);

                GetDataAdapter2.setid2(json.getString(JSON_ID));
                GetDataAdapter2.setproblem2(json.getString(JSON_PROBLEM));

            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter2);

        }


        recyclerViewadapter1 = new RecyclerViewAdapterCheckBox2(GetDataAdapter1, getActivity());
        recyclerView.setAdapter(recyclerViewadapter1);



    }




    @Override
    public void onClick(View view) {
        if(view==floatingActionButton){
            dialog();
        }
    }


    private void dialog(){


        new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE)
                .setTitleText("คุณแน่ใจไหม?")
                .setContentText("ที่ต้องการแจ้งการแก้ไขปัญหานี้แล้ว!")
                .setCancelText("ไม่!")
                .setConfirmText("ใช่!")
                .showCancelButton(true)
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        Log.e("3333","3333");
                        sDialog.cancel();
                    }
                })
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(final SweetAlertDialog sDialog) {
                        Log.e("rrrr", "rrrr");
                        sDialog.cancel();

                        stringBuilder = new StringBuilder();
                        stringBuilder2 = new StringBuilder();
                        stringBuilder3 = new StringBuilder();
                        stringBuilder4 = new StringBuilder();

                        for (GetDataAdapterCheckBox number : GetDataAdapter1) {
                            if (number.isSelected()) {

                                if (stringBuilder.length() > 0)
                                    stringBuilder.append(",");


                                stringBuilder.append(number.getproblem2());


                                if (stringBuilder2.length() > 0)
                                    stringBuilder2.append(",");
                                stringBuilder2.append(number.getid2());
                                kaka = stringBuilder;

                            }


                            if (number.isSelected()) {

                                if (stringBuilder3.length() > 0)
                                    stringBuilder3.append(",");


                                stringBuilder3.append(number.getproblem2());


                                if (stringBuilder4.length() > 0)
                                    stringBuilder4.append(",");
                                stringBuilder4.append(number.getid2());

                            }

                        }
                        DADA = stringBuilder2.toString();
                        DADA2 = stringBuilder.toString();
                        DADA3 = stringBuilder3.toString();

                        Log.e("a1", DADA);
                        Log.e("a2", kaka + "");
                        Log.e("a3", DADA2 + "");
                        Log.e("a4", Description + "");


                        try {



                            if (stringBuilder2.toString() == "") {
                                DADA = "NULL";
                                Log.e("ยังไม่เลือกปัญหา", "ยังไม่เลือกปัญหา");
                                final Dialog dialog = new Dialog(getActivity());
                                dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                                dialog.setContentView(R.layout.customdialog_check_press_checkbox);
                                dialog.setCancelable(true);

                                Button button1 = (Button) dialog.findViewById(R.id.button1);
                                button1.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View v) {
                                        Toast.makeText(getActivity()
                                                , "Close dialog", Toast.LENGTH_SHORT);
                                        dialog.cancel();

                                    }
                                });

                                dialog.show();



                            } else {

                                insent_report_problem();
                                //nontification_cedit_to_sale();
                                // dialog2.cancel();

                            }

                        }
                        catch (Exception ex){


                        }


                    }


                })
                .show();



    }

    public void insent_report_problem() {
        String contno= MyApplication.getInstance().getPrefManager().getPreferrence("conno_qr");//More
        String CreateBy=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        jsonArrayRequest = new JsonArrayRequest(GET_insent_report_problem+"?contno="+contno+"&problem="+DADA+"&type="+"More"+"&CreateBy="+CreateBy ,


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

        requestQueue = Volley.newRequestQueue(getActivity());

        requestQueue.add(jsonArrayRequest);

    }
    String GET_nontification_to_sale="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit/firebase_nontification_sale_from_cedit/index.php";
    public void nontification_cedit_to_sale() {
        String contno= MyApplication.getInstance().getPrefManager().getPreferrence("conno_qr");//More
        String image_cedit=MyApplication.getInstance().getPrefManager().getPreferrence("picture");//More
        jsonArrayRequest = new JsonArrayRequest(GET_nontification_to_sale+"?contno="+contno+"&problem="+DADA+"&image_cedit="+image_cedit,


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

        requestQueue = Volley.newRequestQueue(getActivity());

        requestQueue.add(jsonArrayRequest);

    }
}