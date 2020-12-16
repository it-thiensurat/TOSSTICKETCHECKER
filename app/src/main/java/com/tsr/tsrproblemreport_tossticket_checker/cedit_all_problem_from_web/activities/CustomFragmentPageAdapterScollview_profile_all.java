package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.UI_CARDVIEW_DATA_CREDIT_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT2_in_profile;


public class CustomFragmentPageAdapterScollview_profile_all extends FragmentPagerAdapter {

    private static final String TAG = CustomFragmentPageAdapterScollview_profile_all.class.getSimpleName();

    private static final int FRAGMENT_COUNT =1;

    public CustomFragmentPageAdapterScollview_profile_all(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new UI_CARDVIEW_DATA_CREDIT_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT2_in_profile();
          //  case 1:
           //     return new CallsFragment();
           // return new MainFragment_manager();


          //  case 2:
               // return new MainFragment_map_contno();
           //     return new CallsFragment();


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
                return "ทั้งหมด";
           // case 1:
         //       return "แยกเลขที่สัญญา";
          //  case 2:
            //    return "ตำแหน่งเลขที่สัญญา";
            /*
            case 2:
                return "หน.ทีม";
            case 3:
                return "ซุปเปอร์ฯ";
            case 4:
                return "ผจก.สาย";
            case 5:
                return "ผจก.ฝ่าย";
                */
        }
        return null;
    }
}
