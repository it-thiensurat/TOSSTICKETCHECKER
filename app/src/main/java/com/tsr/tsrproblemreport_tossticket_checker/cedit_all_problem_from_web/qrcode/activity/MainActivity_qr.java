package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.adapter.MainPagerAdapter;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.data.constant.Constants;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.utility.AppUtils;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;


import java.util.ArrayList;

//import com.google.android.gms.ads.AdView;

public class MainActivity_qr extends AppCompatActivity {

    private Activity mActivity;
    private Context mContext;

    private ViewPager mViewPager;
    private ArrayList<String> mFragmentItems;

    private BottomNavigationView bottomNavigationView;
private String conno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initVars();
        initViews();
        initFunctionality();
        initListeners();

    }

    private void initVars() {
        mActivity = MainActivity_qr.this;
        mContext = mActivity.getApplicationContext();
        mFragmentItems = new ArrayList<>();
    }

    private void initViews() {
        setContentView(R.layout.activity_main_qccode);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);


        Bundle data=getIntent().getExtras();
        if(data!=null) {

            conno = data.getString("conno");

            MyApplication.getInstance().getPrefManager().setPreferrence("conno_qr", conno);
        }

    }

    private void initFunctionality() {
        if ((ContextCompat.checkSelfPermission( mActivity, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
                || (ContextCompat.checkSelfPermission( mActivity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)) {
            ActivityCompat.requestPermissions(
                    mActivity, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, Constants.PERMISSION_REQ);
        } else {
            setUpViewPager();
        }

        // TODO Sample banner Ad implementation
        //  AdManager.getInstance(mContext).showBannerAd((AdView) findViewById(R.id.adView));

    }

    private void initListeners() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_scan:
                        mViewPager.setCurrentItem(0, true);
                        break;
                    case R.id.nav_generate:
                        mViewPager.setCurrentItem(1, true);
                        break;
                    case R.id.nav_history:
                        mViewPager.setCurrentItem(2, true);
                        break;
                }
                return true;
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0) {
                    bottomNavigationView.setSelectedItemId(R.id.nav_scan);
                } else if(position == 1) {
                    bottomNavigationView.setSelectedItemId(R.id.nav_generate);
                } else if(position == 2) {
                    bottomNavigationView.setSelectedItemId(R.id.nav_history);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setUpViewPager() {

        mFragmentItems.add(getString(R.string.menu_scan));
        mFragmentItems.add(getString(R.string.menu_generate));
        mFragmentItems.add(getString(R.string.menu_history));

        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), mFragmentItems);
        mViewPager.setAdapter(mainPagerAdapter);
        mainPagerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == Constants.PERMISSION_REQ) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setUpViewPager();
            } else {
                AppUtils.showToast(mContext, getString(R.string.permission_not_granted));
            }

        }
    }



    @Override
    public void onBackPressed() {
        AppUtils.tapToExit(mActivity);
    }
}
