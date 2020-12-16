package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.UI_CARDVIEW_CHECK_PROBLEM_NEW2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.UI_CARDVIEW_DATA_CEDIT_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT;


public class CustomFragmentPageAdapterScollview_cedit_problem extends FragmentPagerAdapter {

    private static final String TAG = CustomFragmentPageAdapterScollview_cedit.class.getSimpleName();

    private static final int FRAGMENT_COUNT = 2;

    public CustomFragmentPageAdapterScollview_cedit_problem(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
            //    return new UI_CARDVIEW_DATA_CEDIT_report_problem1();
            return new UI_CARDVIEW_CHECK_PROBLEM_NEW2();

            case 1:
                return new UI_CARDVIEW_DATA_CEDIT_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT();
//

        }
        return null;
    }

    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "ปัญหาทั่วไป";
            case 1:
                return "ปัญหาเพิ่มเติม";

        }
        return null;
    }
}
