package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities;

/**
 * Created by user on 30/11/2560.
 */

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.squareup.picasso.Picasso;

import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.Activity_Call;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.fragment.UI_CARDVIEW_DATA_TYPE_CHECK;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.check_for_credit.Check_Fragment1_2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.check_for_credit.Check_Fragment1_3;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Detali_data_cedit3_3 extends AppCompatActivity  {

    public static AHBottomNavigation bottomNavigation;
    private boolean useMenuResource = true;
    private int[] tabColors;
    private AHBottomNavigationAdapter navigationAdapter;
    private FloatingActionButton floatingActionButton;
    private Handler handler = new Handler();
    private ArrayList<AHBottomNavigationItem> bottomNavigationItems = new ArrayList<>();

    private FragmentManager fragmentManager;
    private Fragment fragment = null;
    JsonArrayRequest jsonArrayRequest ;
    // private RVAdapter adapter;
    RequestQueue requestQueue ;
    public static String TransDate,PayPeriod,AllPeriods,Trans_No,BankName,BankRef,BillerNo,SerialNumber,Ref2,QRId,PayerName,PayerBank,Amount,ResultCode,ResultDesc,
            CheckerStatus,from,ProductSerial,PayLastPeriod,Outstanding,FnYear,FnMonth,conno,productname,status,customer,idcard,address,
            phone_home,phone_mobile,date,Latitude,Longitude,RefNo,isremark,SaleEmployeeName="",SaleTeamCode,SaleHeaderName;

    public static StringBuilder recDataString = new StringBuilder();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.check_customer_new3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





        Bundle data=getIntent().getExtras();
        if(data!=null) {


            TransDate = data.getString("TransDate");
            PayPeriod = data.getString("PayPeriod");
            AllPeriods = data.getString("AllPeriods");


            Trans_No = data.getString("Trans_No");
            BankName = data.getString("BankName");
            BankRef = data.getString("BankRef");
            BillerNo = data.getString("BillerNo");
            SerialNumber = data.getString("SerialNumber");
            Ref2 = data.getString("Ref2");
            QRId = data.getString("QRId");
            PayerName = data.getString("PayerName");
            PayerBank = data.getString("PayerBank");
            Amount = data.getString("Amount");
            ResultCode = data.getString("ResultCode");
            ResultDesc = data.getString("ResultDesc");



            CheckerStatus = data.getString("CheckerStatus");

            ProductSerial = data.getString("ProductSerial");
            Outstanding = data.getString("Outstanding");
            PayLastPeriod = data.getString("PayLastPeriod");

            FnYear = data.getString("FnYear");
            FnMonth = data.getString("FnMonth");

            conno = data.getString("conno");
            RefNo = data.getString("RefNo");
            isremark = data.getString("isremark");

            SaleEmployeeName = data.getString("SaleEmployeeName");
            SaleTeamCode = data.getString("SaleTeamCode");
            SaleHeaderName = data.getString("SaleHeaderName");

            productname = data.getString("productname");
            status = data.getString("status");
            customer = data.getString("customer");
            idcard = data.getString("idcard");

            phone_home = data.getString("phone_home");
            phone_mobile = data.getString("phone_mobile");
            date = data.getString("date");

            Latitude = data.getString("Latitude");
            Longitude = data.getString("Longitude");
            address = data.getString("address");



            Trans_No = data.getString("Trans_No");
            BankName = data.getString("BankName");
            BankRef = data.getString("BankRef");
            BillerNo = data.getString("BillerNo");
            SerialNumber = data.getString("SerialNumber");
            Ref2 = data.getString("Ref2");
            QRId = data.getString("QRId");
            PayerName = data.getString("PayerName");
            PayerBank = data.getString("PayerBank");
            Amount = data.getString("Amount");
            ResultCode = data.getString("ResultCode");
            ResultDesc = data.getString("ResultDesc");


            MyApplication.getInstance().getPrefManager().setPreferrence("TransDate_cf", TransDate);
            MyApplication.getInstance().getPrefManager().setPreferrence("PayPeriod_cf", PayPeriod);
            MyApplication.getInstance().getPrefManager().setPreferrence("AllPeriods_cf", AllPeriods);


            MyApplication.getInstance().getPrefManager().setPreferrence("Trans_No_cf", Trans_No);
            MyApplication.getInstance().getPrefManager().setPreferrence("BankName_cf", BankName);
            MyApplication.getInstance().getPrefManager().setPreferrence("BankRef_cf", BankRef);
            MyApplication.getInstance().getPrefManager().setPreferrence("BillerNo_cf", BillerNo);
            MyApplication.getInstance().getPrefManager().setPreferrence("SerialNumber_cf", SerialNumber);
            MyApplication.getInstance().getPrefManager().setPreferrence("Ref2_cf", Ref2);
            MyApplication.getInstance().getPrefManager().setPreferrence("QRId_cf", QRId);
            MyApplication.getInstance().getPrefManager().setPreferrence("PayerName_cf", PayerName);
            MyApplication.getInstance().getPrefManager().setPreferrence("PayerBank_cf", PayerBank);
            MyApplication.getInstance().getPrefManager().setPreferrence("Amount_cf", Amount);
            MyApplication.getInstance().getPrefManager().setPreferrence("ResultCode_cf", ResultCode);
            MyApplication.getInstance().getPrefManager().setPreferrence("ResultDesc_cf", ResultDesc);



            MyApplication.getInstance().getPrefManager().setPreferrence("CheckerStatus", CheckerStatus);

            MyApplication.getInstance().getPrefManager().setPreferrence("ProductSerial_cf", ProductSerial);

            MyApplication.getInstance().getPrefManager().setPreferrence("Outstanding_cf", Outstanding);
            MyApplication.getInstance().getPrefManager().setPreferrence("PayLastPeriod_cf", PayLastPeriod);

            MyApplication.getInstance().getPrefManager().setPreferrence("FnYear_cf", FnYear);
            MyApplication.getInstance().getPrefManager().setPreferrence("FnMonth_cf", FnMonth);

            MyApplication.getInstance().getPrefManager().setPreferrence("conno_cf", conno);
            MyApplication.getInstance().getPrefManager().setPreferrence("RefNo_cf", RefNo);
            MyApplication.getInstance().getPrefManager().setPreferrence("isremark_cf", isremark);
            MyApplication.getInstance().getPrefManager().setPreferrence("SaleEmployeeName_cf", SaleEmployeeName);

            MyApplication.getInstance().getPrefManager().setPreferrence("phone_home_cf", phone_home);
            MyApplication.getInstance().getPrefManager().setPreferrence("phone_mobile_cf", phone_mobile);

            MyApplication.getInstance().getPrefManager().setPreferrence("Latitude_cf", Latitude);
            MyApplication.getInstance().getPrefManager().setPreferrence("Longitude_cf", Longitude);
            MyApplication.getInstance().getPrefManager().setPreferrence("address_cf", address);

            MyApplication.getInstance().getPrefManager().setPreferrence("SaleTeamCode_cf", SaleTeamCode);
            MyApplication.getInstance().getPrefManager().setPreferrence("SaleHeaderName_cf", SaleHeaderName);
            MyApplication.getInstance().getPrefManager().setPreferrence("productname_cf", productname);


            MyApplication.getInstance().getPrefManager().setPreferrence("status_cf", status);
            MyApplication.getInstance().getPrefManager().setPreferrence("customer_cf", customer);
            MyApplication.getInstance().getPrefManager().setPreferrence("idcard_cf", idcard);
            MyApplication.getInstance().getPrefManager().setPreferrence("date_cf", date);





           // JSON_DATA_WEB_CALL2();
        }


        fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        try {

            fragment  = new Check_Fragment1_3();
            setTitle("ข้อมูลลูกค้า");

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
                navigationAdapter = new AHBottomNavigationAdapter(this, R.menu.bottom_navigation_menu_3_2);
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
                navigationAdapter = new AHBottomNavigationAdapter(this, R.menu.bottom_navigation_menu_3_2);
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
                    fragment  = new Check_Fragment1_3();
                    setTitle("ข้อมูลลูกค้า");

                    // changeFragment(0);
                }
                else if (position == 1) {
                    fragment  = new UI_CARDVIEW_DATA_TYPE_CHECK();
                    setTitle("ตรวจสอบ");
                }

                else {

                }

                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container555, fragment);
                transaction.commit();



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



        /*        AHNotification notification2 = new AHNotification.Builder()
                        .setText("100")
                        .setBackgroundColor(ContextCompat.getColor(Detali_data_cedit3.this, R.color.color_notification_back))
                        .setTextColor(ContextCompat.getColor(Detali_data_cedit3.this, R.color.color_notification_text))
                        .build();
                bottomNavigation.setNotification(notification2, 1);*/

  /*              AHNotification notification3 = new AHNotification.Builder()
                        .setText("50")
                        .setBackgroundColor(ContextCompat.getColor(Detali_data_cedit3.this, R.color.color_notification_back))
                        .setTextColor(ContextCompat.getColor(Detali_data_cedit3.this, R.color.color_notification_text))
                        .build();
                bottomNavigation.setNotification(notification3, 2);

*/

/*                if(PositionCode.equals("Cedit")){
                    bottomNavigation.setNotification(notification2, 2);
                }
                else if(PositionCode.equals("Sale")){
                    bottomNavigation.setNotification(notification2, 1);
                }*/


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




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_map, menu);
        //menuItem1 = menu.findItem(R.id.map);
        // menuItem2 = menu.findItem(R.id.map2);
        //help = menu.findItem(R.id.help);
        return true;
    }
    @SuppressLint("MissingPermission")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.call){



            //Intent showFullQuoteIntent = new Intent(this, Activity_Call.class);
          //  startActivity(showFullQuoteIntent);

            Intent Intent = new Intent(this, Activity_Call.class);
            Bundle bun = new Bundle();
            bun.putString("number", phone_home+","+phone_mobile);
            Intent.putExtras(bun);
            startActivity(Intent);

/*if((phone_mobile.equals("null"))|phone_mobile.isEmpty()){
    phone_mobile="00-0000-0000";
    recDataString.delete(0, recDataString.length());
    recDataString.append(phone_home);
    String NUM1 = recDataString.substring(0, 12);
    String uri = "tel:" + NUM1.replaceAll("[^0-9|\\+]", "");
    //  posted_by.replaceAll("[^0-9|\\+]", ""
    Intent intent = new Intent(Intent.ACTION_CALL);
    // intent.setData(Uri.parse("tel:"+phone_home+","+phone_mobile));
    // intent.setData(Uri.parse("tel:"+NUM1));
    intent.setData(Uri.parse(uri));
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


    startActivity(intent);
}
else {
    recDataString.delete(0, recDataString.length());
    recDataString.append(phone_home);
    String NUM1 = recDataString.substring(0, 12);
    String uri = "tel:" + NUM1.replaceAll("[^0-9|\\+]", "");
    //  posted_by.replaceAll("[^0-9|\\+]", ""
    Intent intent = new Intent(Intent.ACTION_CALL);
    // intent.setData(Uri.parse("tel:"+phone_home+","+phone_mobile));
    // intent.setData(Uri.parse("tel:"+NUM1));
    intent.setData(Uri.parse(uri));
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


    startActivity(intent);*/


//}



        }
        else if(id == R.id.map){



            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?daddr=" + "13.897776" + "," + "100.5123653"+"&daddr="+Latitude+","+Longitude));
            startActivity(intent);

        }
        else if (id == android.R.id.home) {
            // finish the activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }






}

