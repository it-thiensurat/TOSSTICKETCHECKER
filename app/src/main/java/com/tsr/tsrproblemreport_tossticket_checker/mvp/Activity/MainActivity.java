package com.tsr.tsrproblemreport_tossticket_checker.mvp.Activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.Adapter.ContactAdapter;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.Model.Customer;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.Model.CustomerRes;

import com.tsr.tsrproblemreport_tossticket_checker.mvp.base.BaseMvpActivity;

public class MainActivity extends BaseMvpActivity<Maininterface.presenter> implements Maininterface.view {
    private ContactAdapter contactAdapter;

    //private LinearLayoutManager layoutManager;
    @Override
    public Maininterface.presenter createPresenter() {
        return MainPresenter.create();
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
    public void bindView() {
        ButterKnife.bind(this);
    }

    @Override
    public void setupView() {
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        relativeLayout.setVisibility(View.GONE);
    }

    @Override
    public void setupInstance() {

    }

    @Override
    public void initialize() {
        getPresenter().login("10103957");
    }

    @Override
    public void success(String username) {
        Toast.makeText(MainActivity.this, username, Toast.LENGTH_LONG).show();
    }


    @Override
    public void setCustomerToAdapter(final List<CustomerRes> customer) {
        contactAdapter = new ContactAdapter(this, customer);
        recycler.setAdapter(contactAdapter);
        //contactAdapter.notifyDataSetChanged();

        mShimmerViewContainer.stopShimmerAnimation();
        mShimmerViewContainer.setVisibility(View.GONE);

        swipe_refresh_layout.setRefreshing(false);
        int count=    contactAdapter.getItemCount();
        counter.setText(count+"");

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
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("customerlist", getPresenter().getCustomerList());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        getPresenter().setCustomerList((Customer) savedInstanceState.getParcelable("customerlist"));
    }

    @Override
    public void restoreView(Bundle savedInstanceState) {
        super.restoreView(savedInstanceState);
        getPresenter().restoreCustomerList(getPresenter().getCustomerList());
    }




}
