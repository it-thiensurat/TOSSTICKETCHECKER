package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.fragment.GenerateFragment;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.fragment.HistoryFragment;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.fragment.ScanFragment_report_problem_sale;

import java.util.ArrayList;

/**
 * Created by Ashiq on 18/4/17.
 */
public class MainPagerAdapter_report_problem_sale extends FragmentStatePagerAdapter {

    private ArrayList<String> mFragmentItems;

    public MainPagerAdapter_report_problem_sale(FragmentManager fm, ArrayList<String> fragmentItems) {
        super(fm);
        this.mFragmentItems = fragmentItems;
    }

    @Override
    public Fragment getItem(int i) {

        Fragment fragment = null;

        if(i == 0) {
            fragment = new ScanFragment_report_problem_sale();
        } else if(i == 1){
            fragment = new GenerateFragment();
        } else if(i == 2){
            fragment = new HistoryFragment();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return mFragmentItems.size();
    }

}
