package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.sale;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.UI_CARDVIEW_CHECK_PROBLEM_NEW2;


public class CustomFragmentPageAdapterScollview_sale_for_checker_all extends FragmentPagerAdapter {

    private static final String TAG = CustomFragmentPageAdapterScollview_sale_for_checker_all.class.getSimpleName();

    private static final int FRAGMENT_COUNT = 3;

    public CustomFragmentPageAdapterScollview_sale_for_checker_all(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
                    case 0:
                        return new UI_CARDVIEW_DATA_FOR_CHECKER_RECHECK();
                   case 1:
                          return new UI_CARDVIEW_DATA_FOR_CHECKER_NO();
                   case 2:

                          return new UI_CARDVIEW_DATA_FOR_CHECKER();

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
                return "รอตรวจสอบ";

           case 1:
               return "รออนุมัติ";
           case 2:

                return "ตรวจสอบแล้ว";
        }
        return null;
    }
}
