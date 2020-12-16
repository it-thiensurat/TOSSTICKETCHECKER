package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.UI_CARDVIEW_CHECK_PROBLEM_NEW2;


public class CustomFragmentPageAdapterScollview_cedit extends FragmentPagerAdapter {

    private static final String TAG = CustomFragmentPageAdapterScollview_cedit.class.getSimpleName();

    private static final int FRAGMENT_COUNT = 1;

    public CustomFragmentPageAdapterScollview_cedit(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new UI_CARDVIEW_CHECK_PROBLEM_NEW2();
          //  case 1:
              //  return new UI_CARDVIEW_DATA_CEDIT_SENT_RPOBLEM();
         //


           // case 2:

              //  return new MainFragment_map_contno_credit();


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
            //case 1:
           //     return "แยกเลขที่สัญญา";
           // case 2:
            //    return "ตำแหน่งเลขที่สัญญา";
        }
        return null;
    }
}
