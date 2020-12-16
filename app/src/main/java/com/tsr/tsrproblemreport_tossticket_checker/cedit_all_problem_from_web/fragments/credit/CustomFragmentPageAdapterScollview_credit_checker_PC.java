package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.credit;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.UI_CARDVIEW_DATA_CEDIT2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.UI_CARDVIEW_DATA_CEDIT2_2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.UI_CARDVIEW_DATA_CEDIT2_2_PC;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.UI_CARDVIEW_DATA_CEDIT2_PC;


public class CustomFragmentPageAdapterScollview_credit_checker_PC extends FragmentPagerAdapter {

    private static final String TAG = CustomFragmentPageAdapterScollview_credit_checker_PC.class.getSimpleName();

    private static final int FRAGMENT_COUNT = 2;

    public CustomFragmentPageAdapterScollview_credit_checker_PC(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
                    case 0:
                        return new UI_CARDVIEW_DATA_CEDIT2_PC();
                   case 1:
                          return new UI_CARDVIEW_DATA_CEDIT2_2_PC();


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
                return "ตรวจสอบแล้ว ทั้งหมด";

           case 1:
               return "ตรวจสอบแล้ว พบปัญหา";

        }
        return null;
    }
}
