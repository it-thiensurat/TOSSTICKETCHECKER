package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.sale;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.manager.UI_CARDVIEW_DATA_MANAGER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.manager.UI_CARDVIEW_DATA_MANAGER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_PAGE4_ALL;


public class CustomFragmentPageAdapterScollview_sale_for_checker_all0 extends FragmentPagerAdapter {

    private static final String TAG = CustomFragmentPageAdapterScollview_sale_for_checker_all0.class.getSimpleName();

    private static final int FRAGMENT_COUNT = 2;

    public CustomFragmentPageAdapterScollview_sale_for_checker_all0(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
                    case 0:
                        return new UI_CARDVIEW_DATA_MANAGER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT();
                   case 1:
                          return new UI_CARDVIEW_DATA_MANAGER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_PAGE4_ALL();


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
                return "ตรวจสอบ และ ค่างวด";

           case 1:
               return "สัญญา";

        }
        return null;
    }
}
