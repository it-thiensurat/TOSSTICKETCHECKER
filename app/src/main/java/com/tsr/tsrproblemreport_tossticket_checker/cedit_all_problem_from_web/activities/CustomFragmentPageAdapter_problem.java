package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.UI_CARDVIEW_CHECK_PROBLEM_NEW2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.UI_CARDVIEW_DATA_CEDIT_modify_problem1;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;


public class CustomFragmentPageAdapter_problem extends FragmentPagerAdapter {

    private static final String TAG = CustomFragmentPageAdapter_problem.class.getSimpleName();

    private static final int FRAGMENT_COUNT =1;
private String SourceSystem="";
    public CustomFragmentPageAdapter_problem(FragmentManager fm) {
        super(fm);
        SourceSystem= MyApplication.getInstance().getPrefManager().getPreferrence("SourceSystem");
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                // return new UI_CARDVIEW_SALE_YES();
                if(SourceSystem.equals("Credit")){
                   // return new UI_CARDVIEW_DATA_CEDIT_report_problem1();
                    return new UI_CARDVIEW_CHECK_PROBLEM_NEW2();
                }
                else   {
                    return new UI_CARDVIEW_DATA_CEDIT_modify_problem1();
                }


         //   case 1:
           //     return new UI_CARDVIEW_DATA_CREDIT_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT2();
//


            //   if(SourceSystem.equals("Credit")){
              //      return new UI_CARDVIEW_DATA_CEDIT_report_problem2();
              //  }
              //  else   {
               //     return new UI_CARDVIEW_DATA_CEDIT_modify_problem2();
              //  }

            /*case 1:
                return new PlaylistFragment();
            case 2:
                return new AlbumFragment();
            case 3:
                return new ArtistFragment();*/
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
           //case 1:
             //  return "ปัญหาเพิ่มเติม";
        }
        return null;
    }
}
