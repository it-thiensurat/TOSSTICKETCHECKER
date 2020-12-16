package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.UI_CARDVIEW_DATA_CEDIT_HISTORY;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.UI_CARDVIEW_DATA_CEDIT_HISTORY_problem;


public class CustomFragmentPageAdapterScollview_slider_history extends FragmentPagerAdapter {

    private static final String TAG = CustomFragmentPageAdapterScollview_slider_history.class.getSimpleName();

    private static final int FRAGMENT_COUNT = 2;

    public CustomFragmentPageAdapterScollview_slider_history(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new UI_CARDVIEW_DATA_CEDIT_HISTORY();
            case 1:
                return new UI_CARDVIEW_DATA_CEDIT_HISTORY_problem();

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
                return "ตรวจสอบ";
            case 1:
                return "เเจ้งปัญหา";


        }
        return null;
    }
}
