package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
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
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.RecyclerViewAdapter_history_problem;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UI_CARDVIEW_DATA_CEDIT_HISTORY_problem extends Fragment  implements RecyclerViewAdapter_history_problem.itemclick2 {
    // private DemoFragment currentFragment;






    List<GetData_cedit> GetDataAdapter1,GetDataAdapter3;
    RelativeLayout relativeLayout;
    RecyclerView recyclerView;
    private Toolbar toolbar;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    GetData_cedit getDataAdapter;
    RecyclerViewAdapter_history_problem recyclerViewadapter;
    private RecyclerViewAdapter_history_problem mAdapter;
    String DADADA;
    // private RecyclerViewAdapter3 adapter;
    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/cedit_data_history_problem.php";
    String JSON_refno2 = "refno";
    String JSON_CONTNO = "CONTNO";
    String JSON_GroupID = "GroupID";
    String JSON_IssueGroupName = "IssueGroupName";





    Dialog dialog2;

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
        View layoutView = inflater.inflate(R.layout.cardview_row, container, false);



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
        String CreateBy = MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL+"?CreateBy="+CreateBy,

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

            GetData_cedit GetDataAdapter2 = new GetData_cedit();
            // GetDataAdapter1.clear();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);
                //     Log.e(TAG,"หมู json array"+json.getJSONObject("InstallDate").getString("date"));



                GetDataAdapter2.setrefno2(json.getString(JSON_refno2));
                GetDataAdapter2.setconno2(json.getString(JSON_CONTNO));
                GetDataAdapter2.setGroupID(json.getString(JSON_GroupID));
                GetDataAdapter2.setIssueGroupName(json.getString(JSON_IssueGroupName));
                GetDataAdapter2.setCreatedate(json.getJSONObject("CreateDate").getString("date"));



            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter2);

        }

        recyclerViewadapter = new RecyclerViewAdapter_history_problem(GetDataAdapter1, getActivity());

        recyclerView.setAdapter(recyclerViewadapter);
        //swipeRefreshLayout.setRefreshing(false);
        counter.setText(GetDataAdapter1.size()+"");
        DADADA=GetDataAdapter1.size()+"";
        // ManageSharedPreferences.SavePreferences2(UI_CARDVIEW_DEPART1_json2_real.this,"w","pref", "s");

        // recyclerViewadapter.setitemclick(this);
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
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItemุ6);
        search(searchView);

        if(!searchView.isIconified()){
            searchView.setQuery("",false);
            JSON_DATA_WEB_CALL();
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
                // Log.e("filter",newText);
                if (recyclerViewadapter != null)
                    recyclerViewadapter.getFilter().filter(newText);

                if(newText.equals("")){
                    GetDataAdapter1.clear();
                    recyclerViewadapter.getFilter().filter("");
                    recyclerView.setHasFixedSize(true);
                    recyclerViewlayoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(recyclerViewlayoutManager);
                    JSON_DATA_WEB_CALL();
                }

                // recyclerViewadapter.(newText.toString());
                return true;






            }
        });
    }




    @Override
    public void click2(View v, final int position) {
        try {
            GetData_cedit getDataAdapter = GetDataAdapter1.get(position);













        }
        catch (Exception e) {

            e.printStackTrace();
        }



    }


}