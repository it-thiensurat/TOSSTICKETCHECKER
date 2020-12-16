package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.sale;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.CustomFragmentPageAdapterScollview_cedit;

public class IconTextTabsActivity_sale_for_checker_all extends Fragment {
    private int count = 0;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {

            R.drawable.baseline_list_white_24,
            R.drawable.baseline_list_black_24,
            R.drawable.baseline_list_black_24,


    };


    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layoutView = inflater.inflate(R.layout.fragment_icon_text_tabs, container, false);
        toolbar = (Toolbar) layoutView.findViewById(R.id.toolbar);






        viewPager = (ViewPager) layoutView.findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomFragmentPageAdapterScollview_sale_for_checker_all(getChildFragmentManager()));

        tabLayout = (TabLayout) layoutView.findViewById(R.id.tabs);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);    // เเบ่ง ให้ เท่ากัน
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabIndex = tab.getPosition();



                if(tabIndex==0){
                    tabLayout.getTabAt(0).setIcon(tabIcons[0]).setIcon(R.drawable.baseline_list_white_24);
                    tabLayout.getTabAt(1).setIcon(tabIcons[1]).setIcon(R.drawable.baseline_list_black_24);
                    tabLayout.getTabAt(2).setIcon(tabIcons[2]).setIcon(R.drawable.baseline_list_black_24);

                }
                else if(tabIndex==1){
                    tabLayout.getTabAt(0).setIcon(tabIcons[0]).setIcon(R.drawable.baseline_list_black_24);
                    tabLayout.getTabAt(1).setIcon(tabIcons[1]).setIcon(R.drawable.baseline_list_white_24);
                    tabLayout.getTabAt(2).setIcon(tabIcons[2]).setIcon(R.drawable.baseline_list_black_24);
                }
                else if(tabIndex==2){
                    tabLayout.getTabAt(0).setIcon(tabIcons[0]).setIcon(R.drawable.baseline_list_black_24);
                    tabLayout.getTabAt(1).setIcon(tabIcons[1]).setIcon(R.drawable.baseline_list_black_24);
                    tabLayout.getTabAt(2).setIcon(tabIcons[2]).setIcon(R.drawable.baseline_list_white_24);
                }

                // invalidateOptionsMenu();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        setupTabIcons();

        setHasOptionsMenu(true);


        return layoutView;

    }

    int tabIndex = 0;

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }





















    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_search) {
            // doIncrease();





        }

        return super.onOptionsItemSelected(item);
    }













}


