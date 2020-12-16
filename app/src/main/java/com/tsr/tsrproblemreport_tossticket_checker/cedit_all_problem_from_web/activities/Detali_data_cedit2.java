package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities;

/**
 * Created by user on 30/11/2560.
 */

import android.annotation.SuppressLint;

import android.content.Intent;

import android.os.Build;
import android.os.Bundle;

import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

import android.util.Log;

import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;
import com.tsr.tsrproblemreport_tossticket_checker.R;

import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.UI_CARDVIEW_DATA_CEDIT;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.helper.GetCurrentLocation;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.contextmenu.ContextMenuDialogFragment;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.contextmenu.MenuObject;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.contextmenu.MenuParams;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.contextmenu.interfaces.OnMenuItemClickListener;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.contextmenu.interfaces.OnMenuItemLongClickListener;

import java.util.ArrayList;
import java.util.List;


public class Detali_data_cedit2 extends AppCompatActivity implements OnMenuItemClickListener,OnMenuItemLongClickListener {

    public static AHBottomNavigation bottomNavigation;
    private boolean useMenuResource = true;
    private int[] tabColors;
    private AHBottomNavigationAdapter navigationAdapter;
    private FloatingActionButton floatingActionButton;
    private Handler handler = new Handler();
    private ArrayList<AHBottomNavigationItem> bottomNavigationItems = new ArrayList<>();

    private FragmentManager fragmentManager;
    private Fragment fragment = null;
    private ContextMenuDialogFragment mMenuDialogFragment;
    GetCurrentLocation currentLoc;
    String latitude,longitude;
    public static int dad=0;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.check_customer_new2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        try {

                fragment  = new UI_CARDVIEW_DATA_CEDIT();
                setTitle("ระบบตรวจสอบ");

        }
        catch (Exception EX){

        }



        try {
            fragmentTransaction.replace(R.id.fragment_container555, fragment);
            fragmentTransaction.commit();
        }
        catch (Exception EX){

        }


        initUI();
        initMenuFragment();
        currentLoc = new GetCurrentLocation(this);
    }




String PositionCode="";
    @SuppressLint("ResourceAsColor")
    private void initUI() {
        PositionCode=MyApplication.getInstance().getPrefManager().getPreferrence("PositionCode");

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        }

        bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);
        //viewPager = (AHBottomNavigationViewPager) findViewById(R.id.view_pager);
        //	floatingActionButton = (FloatingActionButton) findViewById(R.id.floating_action_button);

        if (useMenuResource) {

            if(PositionCode.equals("Cedit")) {
                tabColors = getApplicationContext().getResources().getIntArray(R.array.tab_colors);
                navigationAdapter = new AHBottomNavigationAdapter(this, R.menu.bottom_navigation_menu_3);
                navigationAdapter.setupWithBottomNavigation(bottomNavigation, tabColors);
                bottomNavigation.setBackgroundResource(R.color.colorPrimary);
                //   bottomNavigation.getItem(R.id.check).setTitle("5555");
                AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.tab_3, R.drawable.ic_maps_local_restaurant, R.color.color_tab_3);
            }
            else    if(PositionCode.equals("Sale")){
                tabColors = getApplicationContext().getResources().getIntArray(R.array.tab_colors);
                navigationAdapter = new AHBottomNavigationAdapter(this, R.menu.bottom_navigation_menu_3_2);
                navigationAdapter.setupWithBottomNavigation(bottomNavigation, tabColors);
                bottomNavigation.setBackgroundResource(R.color.colorPrimary);
                //   bottomNavigation.getItem(R.id.check).setTitle("5555");
                AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.tab_3, R.drawable.ic_maps_local_restaurant, R.color.color_tab_3);
            }
            else {
                tabColors = getApplicationContext().getResources().getIntArray(R.array.tab_colors);
                navigationAdapter = new AHBottomNavigationAdapter(this, R.menu.bottom_navigation_menu_3);
                navigationAdapter.setupWithBottomNavigation(bottomNavigation, tabColors);
                bottomNavigation.setBackgroundResource(R.color.colorPrimary);
                //   bottomNavigation.getItem(R.id.check).setTitle("5555");
                AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.tab_3, R.drawable.ic_maps_local_restaurant, R.color.color_tab_3);
            }



        } else {




        }


        bottomNavigation.manageFloatingActionButtonBehavior(floatingActionButton);
        bottomNavigation.setTranslucentNavigationEnabled(true);

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                //positionASA=position;


                if (position == 0) {

                   // changeFragment(0);
                }
                else if (position == 1) {

                }

                else {

                }


                return true;
            }
        });



        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Setting custom colors for notification




                /*
                AHNotification notification = new AHNotification.Builder()
                        .setText("100")
                        .setBackgroundColor(ContextCompat.getColor(Detali_data_cedit.this, R.color.color_notification_back))
                        .setTextColor(ContextCompat.getColor(Detali_data_cedit.this, R.color.color_notification_text))
                        .build();
                bottomNavigation.setNotification(notification, 1);
                //Snackbar.make(bottomNavigation, "Snackbar with bottom navigation",
                //	Snackbar.LENGTH_SHORT).show();

*/



                AHNotification notification2 = new AHNotification.Builder()
                        .setText("100")
                        .setBackgroundColor(ContextCompat.getColor(Detali_data_cedit2.this, R.color.color_notification_back))
                        .setTextColor(ContextCompat.getColor(Detali_data_cedit2.this, R.color.color_notification_text))
                        .build();
                bottomNavigation.setNotification(notification2, 2);
                if(PositionCode.equals("Cedit")){
                    bottomNavigation.setNotification(notification2, 2);
                }
                else if(PositionCode.equals("Sale")){
                    bottomNavigation.setNotification(notification2, 1);
                }


            //    bottomNavigation.enableItemAtPosition(0);
             //   bottomNavigation.disableItemAtPosition(1);
               // bottomNavigation.setItemDisableColor(Color.parseColor("#3A000000"));

              //  bottomNavigation.hideBottomNavigation(1);

                //Snackbar.make(bottomNavigation, "Snackbar with bottom navigation",
                //	Snackbar.LENGTH_SHORT).show();

            }
        }, 3000);

        //bottomNavigation.setDefaultBackgroundResource(R.drawable.bottom_navigation_background);
    }




    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void updateBottomNavigationColor(boolean isColored) {
        bottomNavigation.setColored(isColored);
    }


    public boolean isBottomNavigationColored() {
        return bottomNavigation.isColored();
    }

    public void updateBottomNavigationItems(boolean addItems) {

        if (useMenuResource) {
            if (addItems) {
                navigationAdapter = new AHBottomNavigationAdapter(this, R.menu.bottom_navigation_menu_5);
                navigationAdapter.setupWithBottomNavigation(bottomNavigation, tabColors);
                bottomNavigation.setNotification("1", 3);
            } else {
                navigationAdapter = new AHBottomNavigationAdapter(this, R.menu.bottom_navigation_menu_3);
                navigationAdapter.setupWithBottomNavigation(bottomNavigation, tabColors);
            }

        } else {
            if (addItems) {
                AHBottomNavigationItem item4 = new AHBottomNavigationItem(getString(R.string.tab_4),
                        ContextCompat.getDrawable(this, R.drawable.ic_maps_local_bar),
                        ContextCompat.getColor(this, R.color.color_tab_4));
                AHBottomNavigationItem item5 = new AHBottomNavigationItem(getString(R.string.tab_5),
                        ContextCompat.getDrawable(this, R.drawable.ic_maps_place),
                        ContextCompat.getColor(this, R.color.color_tab_5));

                bottomNavigation.addItem(item4);
                bottomNavigation.addItem(item5);
                bottomNavigation.setNotification("1", 3);
            } else {
                bottomNavigation.removeAllItems();
                bottomNavigation.addItems(bottomNavigationItems);
            }
        }
    }



    public void showOrHideBottomNavigation(boolean show) {
        if (show) {
            bottomNavigation.restoreBottomNavigation(true);
        } else {
            bottomNavigation.hideBottomNavigation(true);
        }
    }


    public void updateSelectedBackgroundVisibility(boolean isVisible) {
        bottomNavigation.setSelectedBackgroundVisible(isVisible);
    }


    public void setForceTitleHide(boolean forceTitleHide) {
        AHBottomNavigation.TitleState state = forceTitleHide ? AHBottomNavigation.TitleState.ALWAYS_HIDE : AHBottomNavigation.TitleState.ALWAYS_SHOW;
        bottomNavigation.setTitleState(state);
    }


    public void reload() {
        startActivity(new Intent(this, DemoActivity.class));
        finish();
    }


    public int getBottomNavigationNbItems() {
        return bottomNavigation.getItemsCount();
    }



    private void initMenuFragment() {
        MenuParams menuParams = new MenuParams();
        menuParams.setActionBarSize((int) getResources().getDimension(R.dimen.tool_bar_height));
        menuParams.setMenuObjects(getMenuObjects());
        menuParams.setClosableOutside(false);
        mMenuDialogFragment = ContextMenuDialogFragment.newInstance(menuParams);
        mMenuDialogFragment.setItemClickListener(this);
        mMenuDialogFragment.setItemLongClickListener(this);
    }

    private List<MenuObject> getMenuObjects() {


        List<MenuObject> menuObjects = new ArrayList<>();

        MenuObject close = new MenuObject();
        close.setResource(R.drawable.delete);





        MenuObject send = new MenuObject("ตั้งค่า");
        send.setResource(R.drawable.settingsss);
/*
        MenuObject like = new MenuObject("โปรไฟท์");
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.contactsss);
        like.setBitmap(b);

        MenuObject like2 = new MenuObject("user");
        Bitmap b2 = BitmapFactory.decodeResource(getResources(), R.drawable.usergroup);
        like2.setBitmap(b2);*/




        MenuObject block = new MenuObject("อัพเดทตำแหน่งระยะทาง");
        block.setResource(R.drawable.lolo);


        MenuObject block2 = new MenuObject("รีเซ็ตค่าเริ่มต้น");
        block2.setResource(R.drawable.reset);







        menuObjects.add(close);

        menuObjects.add(send);
       // menuObjects.add(like);
     //   menuObjects.add(like2);
        // menuObjects.add(addFr);
        //   menuObjects.add(addFav);
        menuObjects.add(block);
        menuObjects.add(block2);
        return menuObjects;
    }





    @SuppressLint("ResourceAsColor")
    @Override
    public boolean onMenuItemClick(View clickedView, int position) {
        //    Toast.makeText(this, "Clicked on position: " + position, Toast.LENGTH_SHORT).show();

        if(position==1){



            //   Log.e("ccc", String.valueOf(position));
        }


        else if(position==2){
             currentLoc = new GetCurrentLocation(this);
            latitude = currentLoc.latitude;
            longitude = currentLoc.longitude;

            Log.e("llll",latitude+","+longitude);
            // MyApplication.getInstance().getPrefManager().setPreferrence("status_update_distant","0");
            MyApplication.getInstance().getPrefManager().setPreferrence("latlong", latitude+","+longitude);
            MyApplication.getInstance().getPrefManager().setPreferrence("dat2", "1");
            MyApplication.getInstance().getPrefManager().setPreferrence("key_sort", null);
            dad =1;
            //fragment = new IconTextTabsActivity_cedit_intro();

                fragment  = new UI_CARDVIEW_DATA_CEDIT();


        }
        else if(position==3) {
            MyApplication.getInstance().getPrefManager().setPreferrence("dat2", "0");
            MyApplication.getInstance().getPrefManager().setPreferrence("key_sort", null);
            dad = 2;

            fragment = new UI_CARDVIEW_DATA_CEDIT();


        }


    /*    else if(position==4){

            // currentLoc = new GetCurrentLocation(this);
 *//*           latitude = currentLoc.latitude;
            longitude = currentLoc.longitude;

            Log.e("llll",latitude+","+longitude);
            // MyApplication.getInstance().getPrefManager().setPreferrence("status_update_distant","0");
            MyApplication.getInstance().getPrefManager().setPreferrence("latlong", latitude+","+longitude);
            dad =1;
            fragment = new IconTextTabsActivity_cedit_intro();

*//*



        }
        else if(position==5){
            MyApplication.getInstance().getPrefManager().setPreferrence("dat2", "1");
            MyApplication.getInstance().getPrefManager().setPreferrence("key_sort", null);
            fragment = new IconTextTabsActivity_cedit_intro();
            //ui_get_json_login.JSON_DATA_WEB_CALL_MAP();
            //fragment = new LibraryFragment14();
            //   Log.e("ccc", String.valueOf(position));
        }*/
        else {
            dad =0;
        }



     FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container555, fragment);
        transaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        assert drawer != null;
//        drawer.closeDrawer(GravityCompat.START);




        return true;
    }

    @Override
    public void onMenuItemLongClick(View clickedView, int position) {
        Toast.makeText(this, "Long clicked on position: " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if(id == R.id.action_setting){
            if (fragmentManager.findFragmentByTag(ContextMenuDialogFragment.TAG) == null) {
                mMenuDialogFragment.show(fragmentManager, ContextMenuDialogFragment.TAG);
            }
        }
        else if(id == R.id.update_location){

        }

        else if(id == R.id.action_cart){



        }



        return super.onOptionsItemSelected(item);
    }
}
