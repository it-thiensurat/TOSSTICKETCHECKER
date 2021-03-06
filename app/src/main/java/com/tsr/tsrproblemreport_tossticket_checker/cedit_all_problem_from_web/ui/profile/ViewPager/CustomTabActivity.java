package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.ui.profile.ViewPager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.sale.UI_CARDVIEW_DATA_SALE_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.ui.profile.Fragment.CallsFragment;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.ui.profile.Fragment.ContactsFragment;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.ui.profile.ViewPagerAdapter;


public class CustomTabActivity extends Fragment {

    //This is our tablayout
    private TabLayout tabLayout;

    //This is our viewPager
    private ViewPager viewPager;

    //Fragments

    UI_CARDVIEW_DATA_SALE_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT chatFragment;
    CallsFragment callsFragment;
    ContactsFragment contactsFragment;

    String[] tabTitle={"CALLS","CHAT","CONTACTS"};
    int[] unreadCount={0,5,0};
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);





    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.activity_tab_without_icon, container, false);


        viewPager = (ViewPager) inflate.findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(3);
        setupViewPager(viewPager);

        //Initializing the tablayout
        tabLayout = (TabLayout) inflate.findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

        try
        {
            setupTabIcons();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewPager.setCurrentItem(position,false);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

return inflate;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {


            /*
            case R.id.action_status:
                Toast.makeText(this, "Home Status Click", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_settings:
                Toast.makeText(this, "Home Settings Click", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_with_icon:
                Intent withicon=new Intent(this,TabWithIconActivity.class);
                startActivity(withicon);
                finish();
                return true;
            case R.id.action_without_icon:
                Intent withouticon=new Intent(this,TabWOIconActivity.class);
                startActivity(withouticon);
                finish();
                return true;

                */

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        callsFragment=new CallsFragment();
        chatFragment=new UI_CARDVIEW_DATA_SALE_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT();
        contactsFragment=new ContactsFragment();
        adapter.addFragment(callsFragment,"CALLS");
        adapter.addFragment(chatFragment,"CHAT");
        adapter.addFragment(contactsFragment,"CONTACTS");
        viewPager.setAdapter(adapter);
    }

    private View prepareTabView(int pos) {
        View view = getLayoutInflater().inflate(R.layout.custom_tab,null);
        TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
        TextView tv_count = (TextView) view.findViewById(R.id.tv_count);
        tv_title.setText(tabTitle[pos]);
        if(unreadCount[pos]>0)
        {
            tv_count.setVisibility(View.VISIBLE);
            tv_count.setText(""+unreadCount[pos]);
           // tv_count.setText("11");
        }
        else
            tv_count.setVisibility(View.GONE);
       // tv_count.setText("11");


        return view;
    }

    private void setupTabIcons()
    {

        for(int i=0;i<tabTitle.length;i++)
        {
            /*TabLayout.Tab tabitem = tabLayout.newTab();
            tabitem.setCustomView(prepareTabView(i));
            tabLayout.addTab(tabitem);*/

            tabLayout.getTabAt(i).setCustomView(prepareTabView(i));
        }


    }
}
