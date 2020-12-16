package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.sale;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.manager.UI_CARDVIEW_DATA_MANAGER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_NO;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.manager.UI_CARDVIEW_DATA_MANAGER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_NO_1;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.manager.UI_CARDVIEW_DATA_MANAGER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_NO_2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.manager.UI_CARDVIEW_DATA_MANAGER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_NO_3;


public class CustomFragmentPageAdapterScollview_sale_for_checker_all2 extends FragmentPagerAdapter {

    private static final String TAG = CustomFragmentPageAdapterScollview_sale_for_checker_all2.class.getSimpleName();

    private static final int FRAGMENT_COUNT = 3;

    public CustomFragmentPageAdapterScollview_sale_for_checker_all2(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
                  //case 0:
                  // return new UI_CARDVIEW_DATA_MANAGER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_NO();
                    case 0:
                        return new UI_CARDVIEW_DATA_MANAGER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_NO_1();
                    case 1:
                          return new UI_CARDVIEW_DATA_MANAGER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_NO_2();

            case 2:
                return new UI_CARDVIEW_DATA_MANAGER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_NO_3();
            //case 3:
             //   return new UI_CARDVIEW_DATA_MANAGER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_NO_3();
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
           // case 0:
            //    return "การ์ดทั้งหมด";
            case 0:
                return "ค่างวด";

           case 1:
                return "ตรวจสอบ";
            case 2:
                return "สัญญา";
           // case 3:
           //     return "ปัญหาแจ้งซ่อม";

        }
        return null;
    }
}
