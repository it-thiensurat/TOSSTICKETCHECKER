package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.CustomFragmentPageAdapterScollview_profile_all;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.CircleTransform;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;

public class ProfileFragment extends Fragment {
    private ImageView userImage;
    private TextView userPostsCount, userFollowersCount, userFollowingCount;
    private TextView userName;
    private ProgressBar profileRefreshProgress;
    RelativeLayout profileFrame;
    private FragmentManager fragmentManager;
    private Fragment fragment = null;
    ImageView imageView;
    ImageView image_bg;
    ConstraintLayout vvv;
    TextView textView,textView2;
    private FloatingActionButton fabSetting;
    //String[] tabTitle={"พนักงาน","ปัญหา","ไทม์ไล"};
    //ImageView[] tabTitle={R.drawable.icon_contno,R.drawable.icon_contno,R.drawable.icon_contno};
    int[] unreadCount={0,5,0};
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private int[] tabIcons = {

            R.drawable.icon_history1,
           // R.drawable.icon_contno,
          //  R.drawable.icon_location,


    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_user_profile, container, false);
        userImage = view.findViewById(R.id.userImage);
        userName = view.findViewById(R.id.fullName);
        userPostsCount = view.findViewById(R.id.userPostsCount);
        userFollowersCount = view.findViewById(R.id.userFollowersCount);
        userFollowingCount = view.findViewById(R.id.userFollowingCount);
        profileRefreshProgress = view.findViewById(R.id.profileRefreshProgress);

        imageView= view.findViewById(R.id.imageView);
        image_bg= view.findViewById(R.id.image_bg);
        vvv= view.findViewById(R.id.vvv);
        textView= view.findViewById(R.id.textView);
        textView2= view.findViewById(R.id.textView2);
        loadNavHeader();
      //  profileFrame = view.findViewById(R.id.profileFrame);
//        profileFrame.setVisibility(View.VISIBLE);



/*
        fragmentManager = getActivity().getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragment  = new CustomTabActivity();
        fragmentTransaction.replace(R.id.profileFrame, fragment);
        fragmentTransaction.commit();*/


        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomFragmentPageAdapterScollview_profile_all(getChildFragmentManager()));

        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);    // เเบ่ง ให้ เท่ากัน
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabIndex = tab.getPosition();
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
        return view;
    }


    private View prepareTabView(int pos) {
        View view = getLayoutInflater().inflate(R.layout.custom_tab,null);
      //  TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
        ImageView tv_title = (ImageView) view.findViewById(R.id.tv_title);

        TextView tv_count = (TextView) view.findViewById(R.id.tv_count);
        //tv_title.setText(tabTitle[pos]);
        tv_title.setBackgroundResource(tabIcons[pos]);
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


    int tabIndex = 0;

    private void setupTabIcons() {
        for(int i=0;i<tabIcons.length;i++)
        {


            tabLayout.getTabAt(i).setCustomView(prepareTabView(i));
        }

       // tabLayout.getTabAt(0).setIcon(tabIcons[0]);
       // tabLayout.getTabAt(1).setIcon(tabIcons[1]);
       // tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        //tabLayout.getTabAt(0).setCustomView(prepareTabView(0));
    }

    @Override
    public void onResume() {
        super.onResume();



    }




    private void loadNavHeader() {

        textView.setText(MyApplication.getInstance().getPrefManager().getPreferrence("EmployeeName"));
        textView2.setText(MyApplication.getInstance().getPrefManager().getPreferrence("PositionName"));
        Glide.with(this).load(MyApplication.getInstance().getPrefManager().getPreferrence("backgound"))
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(image_bg);

        // Loading profile image
        Glide.with(this).load(MyApplication.getInstance().getPrefManager().getPreferrence("picture"))
                .crossFade()
                .thumbnail(0.5f)
                .bitmapTransform(new CircleTransform(getActivity()))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(getActivity().getResources().getDrawable(R.drawable.dasaa))
                .into(imageView);

    }

}
