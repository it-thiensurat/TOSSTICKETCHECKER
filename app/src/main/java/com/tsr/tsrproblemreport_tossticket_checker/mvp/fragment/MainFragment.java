package com.tsr.tsrproblemreport_tossticket_checker.mvp.fragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.tsr.tsrproblemreport_tossticket_checker.R;

import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.Adapter.ContactAdapter;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.Adapter.manager.ContactAdapter_manager;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.Model.Customer;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.Model.CustomerRes;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.Model.manager.ManagerRes;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.base.BaseMvpFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by TheKhaeng on 12/17/2016.
 */

public class MainFragment extends BaseMvpFragment<MainFragmentInterface.presenter>implements MainFragmentInterface.view, ContactAdapter.itemclick, ContactAdapter.itemclick2 {

    private ContactAdapter contactAdapter;
    private ContactAdapter_manager contactAdapter_manager;
     List<CustomerRes> customerRes ;
    List<ManagerRes> managerRes ;
    @Override
    public MainFragmentInterface.presenter createPresenter() {
        return MainFragmentPresenter.create(getActivity());
       // return MainFragmentPresenter_manager.create();
    }

    @Override
    public int getLayoutView() {
        return R.layout.cardview_row_cedit;
    }


    @BindView(R.id.recyclerview1)
    RecyclerView recycler;

    @BindView(R.id.shimmer_view_container)
    ShimmerFrameLayout mShimmerViewContainer;

    @BindView(R.id.relativeLayout)
    RelativeLayout relativeLayout;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipe_refresh_layout;

    @BindView(R.id.counter)
    TextView counter;


    @Override
    public void bindView(View view) {
        ButterKnife.bind(this,view);
    }

    @Override
    public void setupInstance() {

    }

    @Override
    public void setupView() {
      recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        relativeLayout.setVisibility(View.GONE);

       // customerRes= new ArrayList<>();
    }

    @Override
    public void initialize() {
        getPresenter().login("10103957");
    }

    @Override
    public void success(String username) {

    }



    @Override
    public void setCustomerToAdapter(final List<CustomerRes> customer) {
        this.customerRes = customer;     // สำคัญต้องประกาศเอาไว้รับค่า
        contactAdapter = new ContactAdapter(getActivity(), customer);
        recycler.setAdapter(contactAdapter);
        //contactAdapter.notifyDataSetChanged();

        mShimmerViewContainer.stopShimmerAnimation();
        mShimmerViewContainer.setVisibility(View.GONE);

        swipe_refresh_layout.setRefreshing(false);
        int count=    contactAdapter.getItemCount();
        counter.setText(count+"");

        contactAdapter.setitemclick(this);
        contactAdapter.setitemclick2(this);

        swipe_refresh_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                getPresenter().login("10103957");


            }
        });


    }

    @Override
    public void setCustomerToAdapter_manager(List<ManagerRes> manager) {
        this.managerRes = manager;     // สำคัญต้องประกาศเอาไว้รับค่า
        contactAdapter_manager = new ContactAdapter_manager(getActivity(), manager);
        recycler.setAdapter(contactAdapter_manager);
        //contactAdapter.notifyDataSetChanged();

        mShimmerViewContainer.stopShimmerAnimation();
        mShimmerViewContainer.setVisibility(View.GONE);

        swipe_refresh_layout.setRefreshing(false);
        int count=    contactAdapter_manager.getItemCount();
        counter.setText(count+"");

        //contactAdapter_manager.setitemclick(this);
      //  contactAdapter_manager.setitemclick2(this);

        swipe_refresh_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                getPresenter().login("10103957");


            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        mShimmerViewContainer.startShimmerAnimation();
    }

    @Override
    public void onPause() {
        mShimmerViewContainer.stopShimmerAnimation();
        super.onPause();
    }






    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("customerlist", getPresenter().getCustomerList());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        getPresenter().setCustomerList((Customer) savedInstanceState.getParcelable("customerlist"));
    }

    @Override
    public void restoreView(Bundle savedInstanceState) {
        super.restoreView(savedInstanceState);
        getPresenter().restoreCustomerList(getPresenter().getCustomerList());
    }


    @Override
    public void click(View v, int position) {
       // getPresenter().onclicknext();
    }

    @Override
    public void click2(View v, int position) {


        Log.e("sss","sss");
        try {

            CustomerRes getData_cedit = customerRes.get(position);
            Intent intent = new Intent(getActivity(), Detali_data_cedit.class);


            Bundle bun = new Bundle();
            bun.putString("conno", getData_cedit.getCONTNO());
            bun.putString("customer", getData_cedit.getCustomerName());

            intent.putExtras(bun);

            startActivityForResult(intent, 100);


            Log.e("OK","OK");
        } catch (Exception e) {

            e.printStackTrace();
            Log.e("ERROR",e.getMessage());
        }


        //getPresenter().intent_deteil(position);
    }

    private ProgressDialog progressDialog;
    @Override
    public void onload() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.show();
    }

    @Override
    public void ondimiss() {
        progressDialog.dismiss();
    }

    /*
    @Override
    public void onnext() {
        new Intent();
    }
    */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            try {



            } catch (Exception ex) {

            }
        }
        else if(requestCode==103){
            //MyApplication.getInstance().getPrefManager().clear();

        }

        else {

        }
    }

}

