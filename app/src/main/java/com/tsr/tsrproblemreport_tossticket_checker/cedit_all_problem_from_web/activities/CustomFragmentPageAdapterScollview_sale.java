package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.leader.UI_CARDVIEW_DATA_LEADER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.line.UI_CARDVIEW_DATA_LINE_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.manager.UI_CARDVIEW_DATA_MANAGER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.sale.UI_CARDVIEW_DATA_SALE_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.sup.UI_CARDVIEW_DATA_SUP_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;


public class CustomFragmentPageAdapterScollview_sale extends FragmentPagerAdapter {

    private static final String TAG = CustomFragmentPageAdapterScollview_cedit.class.getSimpleName();

    private static final int FRAGMENT_COUNT = 1;

    public CustomFragmentPageAdapterScollview_sale(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                try {
                    String PositionCode=MyApplication.getInstance().getPrefManager().getPreferrence("PositionCode");
                    if(PositionCode.equals("Sale")){
                        return new UI_CARDVIEW_DATA_SALE_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT();
                    }
                    else if(PositionCode.equals("SubTeamLeader")){
                        return new UI_CARDVIEW_DATA_LEADER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT();
                    }
                    else if(PositionCode.equals("Supervisor")){
                        return new UI_CARDVIEW_DATA_SUP_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT();
                    }
                    else if(PositionCode.equals("LineManager")){

                       return new UI_CARDVIEW_DATA_LINE_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT();
                        //return new MainActivity_555();
                    }
                    else if(PositionCode.equals("Manager")){
                        return new UI_CARDVIEW_DATA_MANAGER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT();

                    }
                }
                catch (Exception EX){

                }


            /*case 1:
                return new UI_CARDVIEW_DATA_SALE_RECIVE_RPOBLEM();

            case 2:

            return new MainFragment_map_contno_sale_sale();*/

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
            /*case 1:
                return "แยกเลขที่สัญญา";
            case 2:
                return "ตำแหน่งเลขที่สัญญา";*/

        }
        return null;
    }
}
