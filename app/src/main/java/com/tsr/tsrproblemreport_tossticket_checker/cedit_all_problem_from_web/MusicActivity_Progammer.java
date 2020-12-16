package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
/*import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.enums.Display;
import com.github.javiersantos.appupdater.enums.UpdateFrom;*/
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.IconTextTabsActivity_cedit_intro;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.IconTextTabsActivity_cedit_intro_sale;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.IconTextTabsActivity_history;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.ProfileFragment;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.UI_CARDVIEW_CHECK_PROBLEM_NEW2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.UI_CARDVIEW_DATA_CEDIT;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.UI_CARDVIEW_DATA_CEDIT_BEFORE_EDIT_PROBLEM_FRAGMENT_waiting_to_check;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.helper.GetCurrentLocation;
import com.tsr.tsrproblemreport_tossticket_checker.jsonlogin.LOGIN_MAIN;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.CircleTransform;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.contextmenu.ContextMenuDialogFragment;

import static com.tsr.tsrproblemreport_tossticket_checker.R.id.profile_name;

public class MusicActivity_Progammer extends AppCompatActivity   {

    SQLiteDatabase sqLiteDatabase;
    private Toolbar toolbar;
    private FragmentManager fragmentManager;
    private Fragment fragment = null;
    int ioo=0;
    private static final int APP_PERMISSION_REQUEST = 102;
    GetCurrentLocation currentLoc;
    public static String latitude, longitude;
    private ContextMenuDialogFragment mMenuDialogFragment;
public static int dad=0,dad2=0;
    UI_CARDVIEW_CHECK_PROBLEM_NEW2 ui_cardview_check_problem_new;
    public static NavigationView navigationView;
    public static TextView nav_home,nav_report1,nav_report2,nav_report_foller;
    View header;
    TextView profileName,positionprofile;
    private ImageView imgNavHeaderBg, imgProfile;
    public static int count =0;
    String DA,DA2,DA3,DA4;
    private Context context;
    String urlNavHeaderBg = "",urlProfileImg = "";






    String EmployeeName,PositionCode,PositionName,
            picture,backgound,PositionCode_REAL;

    String ga,ga2,ga3,ga4,ga5,ga6;
    int count_nontification1_int,count_nontification2_int,count_nontification3_int,
            count_nontification4_int,count_nontification5_int,count_nontification6_int,count_nontification_all;

    public static final int CONNECTION_TIMEOUT=10000;
    public static final int READ_TIMEOUT=15000;

    private MenuItem menuSearch;
    RelativeLayout main_container_wrapper;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        this.context = this;
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        main_container_wrapper=(RelativeLayout) findViewById(R.id.main_container_wrapper);


        EmployeeName=MyApplication.getInstance().getPrefManager().getPreferrence("EmployeeName");
        PositionCode=MyApplication.getInstance().getPrefManager().getPreferrence("SourceSystem");
        PositionCode_REAL=MyApplication.getInstance().getPrefManager().getPreferrence("PositionCode");



        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragment = new UI_CARDVIEW_DATA_CEDIT();



                //fragment = new  IconTextTabsActivity_cedit_intro();
                //setTitle("ข้อมูลทั้งหมด");


       String AndroidDeviceID = Settings.Secure.getString(this.getContentResolver(),
                Settings.Secure.ANDROID_ID);


        Log.e("AndroidDeviceID",AndroidDeviceID);


        try {
            fragmentTransaction.replace(R.id.main_container_wrapper, fragment);
            fragmentTransaction.commit();
        }
        catch (Exception EX){

        }




        navigationView = (NavigationView) findViewById(R.id.nav_view);
        header= navigationView.inflateHeaderView(R.layout.nav_header_music);
        profileName= (TextView) header.findViewById(profile_name);
        positionprofile = (TextView) header.findViewById(R.id.position);

        imgNavHeaderBg = (ImageView) header.findViewById(R.id.settime_logout);
        imgProfile = (ImageView) header.findViewById(R.id.img_profile);


        try {

            if(ga.equals("null")){count_nontification1_int= 0;}
            else {count_nontification1_int= Integer.parseInt(ga);}
            if(ga2.equals("null")){count_nontification2_int= 0;}
            else {count_nontification2_int= Integer.parseInt(ga2);}
            if(ga3.equals("null")){count_nontification3_int= 0;}
            else {count_nontification3_int= Integer.parseInt(ga3);}
            if(ga4.equals("null")){count_nontification4_int= 0;}
            else {count_nontification4_int= Integer.parseInt(ga4);}
            if(ga5.equals("null")){count_nontification5_int= 0;}
            else {count_nontification5_int= Integer.parseInt(ga5);}
            if(ga6.equals("null")){count_nontification6_int= 0;}
            else {count_nontification6_int= Integer.parseInt(ga6);}


            //count= count_nontification1_int+count_nontification2_int+count_nontification3_int+count_nontification4_int+count_nontification5_int+count_nontification6_int;
            //Log.e("count", String.valueOf(count));
        }
        catch (Exception ex){

        }







        nav_home=(TextView) MenuItemCompat.getActionView(navigationView.getMenu().
                findItem(R.id.nav_home));

        nav_report1=(TextView) MenuItemCompat.getActionView(navigationView.getMenu().
                findItem(R.id.nav_report1));

        nav_report2=(TextView) MenuItemCompat.getActionView(navigationView.getMenu().
                findItem(R.id.nav_report2));

        nav_report_foller=(TextView) MenuItemCompat.getActionView(navigationView.getMenu().
                findItem(R.id.nav_report_foller));



        String design_app_on_off_all = MyApplication.getInstance().getPrefManager().getPreferrence("design");

        navigationView.getMenu().findItem(R.id.nav_home).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_user).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_report2).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_report_foller).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_about_us).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_privacy_policy).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_profile).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_user_user).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_settings).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_report_bug).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_report_contno_error).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_edit).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_check_customer_yes).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_history).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_check_customer).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_report1).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_report_problem).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_report_contno).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_report_contno_success).setVisible(false);

        // navigationView.getMenu().findItem(R.id.nav_profile).setVisible(true);



        //ระบบตรวจสอบ
        navigationView.getMenu().findItem(R.id.nav_check).setVisible(true);            //ระบบตรวจสอบ
        //ระบบตรวจสอบ










        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_home) {
                    fragment = new UI_CARDVIEW_DATA_CEDIT();

                } else if (id == R.id.nav_user) {
                  //  fragment = new IconTextTabsActivity10();

                } else if (id == R.id.nav_report1) {
                    fragment = new IconTextTabsActivity_cedit_intro_sale();
                    setTitle("รายการปัญหาทั้งหมด");

                } else if (id == R.id.nav_report2) {
                    //fragment = new LibraryFragment9();


                }

                else if (id == R.id.nav_report_foller) {
                   // fragment = new LibraryFragment14();


                }
                else if (id == R.id.nav_check_customer) {



                        fragment = new UI_CARDVIEW_DATA_CEDIT_BEFORE_EDIT_PROBLEM_FRAGMENT_waiting_to_check();


                    setTitle("รายการที่ต้องตรวจสอบ");


                }
                else if (id == R.id.nav_report_problem) {
                    fragment = new IconTextTabsActivity_cedit_intro();
                   // fragment = new UI_CARDVIEW_DATA_CEDIT_SENT_RPOBLEM();
                    setTitle("รายการ การแจ้งปัญหา");

                }

               else if (id == R.id.nav_report_contno_error) {

                }
                else if (id == R.id.nav_edit) {

                }


                else if (id == R.id.nav_check_customer_yes) {
                   // fragment = new UI_CARDVIEW_DATA_CEDIT_yes();
                  //  fragment = new MainFragment_map_contno();
                 //   setTitle("รายการที่ตรวจสอบแล้ว");

                }
                else if (id == R.id.nav_history) {
                    //fragment = new UI_CARDVIEW_DATA_CEDIT_HISTORY();
                    fragment = new IconTextTabsActivity_history();
                    setTitle("ประวัติทำรายการ");

                }

                else if (id == R.id.nav_report_contno) {
                    //fragment = new UI_CARDVIEW_DATA_CEDIT_HISTORY();
                   // fragment  = new LibraryFragment_problem();
                    fragment  = new UI_CARDVIEW_CHECK_PROBLEM_NEW2();
                    setTitle("แจ้งปัญหา");

                }


                else if (id == R.id.nav_about_us) {
                    // startActivity(new Intent(MusicActivity5.this, WelcomeActivity.class));
                  //  startActivity(new Intent(MusicActivity_Credit.this, MainActivity_Loadmore.class));
                   // return true;
                }else if (id == R.id.nav_privacy_policy) {

                }else if (id == R.id.nav_check) {
                    fragment  = new UI_CARDVIEW_DATA_CEDIT();
                    setTitle("ระบบตรวจสอบ");
                }


                    else if (id == R.id.nav_profile) {
                    fragment = new ProfileFragment();
                    setTitle("โปรไฟล์");
                }
                else if (id == R.id.nav_user_user) {

                  //  fragment = new IconTextTabsActivity20();
                    setTitle("ผู้ใช้งาน");
                }
                else if (id == R.id.nav_settings) {
                  //  fragment = new SettingsFragment();
                    setTitle("ตั้งค่า");
                }


                else if (id == R.id.logout) {

                    try {

                        MyApplication.getInstance().getPrefManager().clear();
                        MyApplication.getInstance().getPrefManager().setPreferrence("statuslogin", "0");
                        MyApplication.getInstance().getPrefManager().setPreferrence("statuslogin_sale", "0");
                        MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_M", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_L", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_S", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_T", "null");

                           // Intent mIntent = new Intent( MusicActivity_Credit.this, LOGIN_MAIN.class);
                        Intent mIntent = new Intent( MusicActivity_Progammer.this, LOGIN_MAIN.class);

                            startActivity(mIntent);
                            finish();

                    }
                    catch (Exception ex){

                    }


                }





                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_container_wrapper, fragment);
                transaction.commit();

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                assert drawer != null;
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });











        currentLoc = new GetCurrentLocation(this);


        loadNavHeader();


    }






    private void loadNavHeader() {
        backgound =MyApplication.getInstance().getPrefManager().getPreferrence("backgound");
        picture=MyApplication.getInstance().getPrefManager().getPreferrence("picture");
        urlNavHeaderBg= backgound;
        urlProfileImg= picture;
        profileName.setText(EmployeeName+"     :     "+MyApplication.getInstance().getPrefManager().getPreferrence("EMPID"));
        positionprofile.setText(MyApplication.getInstance().getPrefManager().getPreferrence("PositionName"));

       // Log.e("PositionCode_REAL",PositionCode_REAL);
        // String strurl=Utils.UPLOAD_URL+pictureurl;
        // loading header background image
        Glide.with(this).load(urlNavHeaderBg)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgNavHeaderBg);

        // Loading profile image
        Glide.with(this).load(urlProfileImg)
                .crossFade()
                .thumbnail(0.5f)
                .bitmapTransform(new CircleTransform(this))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                .into(imgProfile);

        // showing dot next to notifications label
        navigationView.getMenu().getItem(1).setActionView(R.layout.menu_dot);
    }


}
