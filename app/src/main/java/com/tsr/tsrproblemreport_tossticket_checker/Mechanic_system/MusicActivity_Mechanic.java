package com.tsr.tsrproblemreport_tossticket_checker.Mechanic_system;
  //      com.tsr.tsrproblemreport_tossticket_checker

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.firebase.messaging.FirebaseMessaging;
import com.tsr.tsrproblemreport_tossticket_checker.API_URL_ALL;
import com.tsr.tsrproblemreport_tossticket_checker.Mechanic_system.fragment.UI_CARDVIEW_DATA_CUSTOMER;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.MusicActivity_Checker;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.TOSSGeneral;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.BagdeDrawable;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.IconTextTabsActivity_history;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.databases.SQLiteHelper_image_buffer;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.databases.SQLiteHelper_image_buffer2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.databases.SQLiteHelper_problem_id_image;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.ProfileFragment;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.UI_CARDVIEW_CHECK_PROBLEM_NEW2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.UI_CARDVIEW_CHECK_PROBLEM_NEW2_2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.UI_CARDVIEW_DATA_CEDIT;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.UI_CARDVIEW_DATA_CEDIT_BEFORE_EDIT_PROBLEM_FRAGMENT_waiting_to_check;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.UI_CARDVIEW_DATA_CREDIT_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT2_Acti;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.UI_CARDVIEW_DATA_CREDIT_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT2_UAT;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.credit.UI_CARDVIEW_DATA_MANAGER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_CREDIT1;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.sale.IconTextTabsActivity_sale_for_checker_all;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.sale.IconTextTabsActivity_sale_for_checker_all0;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.sale.IconTextTabsActivity_sale_for_checker_all2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.sale.IconTextTabsActivity_sale_for_checker_all3;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.sale.UI_CARDVIEW_DATA_FOR_CHECKER;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.sale_report_problem.UI_CARDVIEW_DATA_MANAGER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_SALE_REPORT_PROBLEM;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.helper.GetCurrentLocation;
import com.tsr.tsrproblemreport_tossticket_checker.jsonlogin.GetData;
import com.tsr.tsrproblemreport_tossticket_checker.jsonlogin.INTRO_APP;
import com.tsr.tsrproblemreport_tossticket_checker.jsonlogin.LOGIN_MAIN;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.CircleTransform;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.Config;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.EndPoints;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyVolley;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.contextmenu.ContextMenuDialogFragment;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.contextmenu.MenuObject;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.contextmenu.MenuParams;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.contextmenu.interfaces.OnMenuItemClickListener;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.contextmenu.interfaces.OnMenuItemLongClickListener;
import com.tsr.tsrproblemreport_tossticket_checker.payment_system.MusicActivity_Payment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;
import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;

import static com.tsr.tsrproblemreport_tossticket_checker.API_URL_ALL.BASE_URL;
import static com.tsr.tsrproblemreport_tossticket_checker.R.id.profile_name;


public class MusicActivity_Mechanic extends AppCompatActivity implements OnMenuItemClickListener, OnMenuItemLongClickListener {

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

    public static TextView nav_sale1,nav_sale2,nav_sale3,nav_sale4;

    View header;
    TextView profileName,positionprofile;
    private ImageView imgNavHeaderBg, imgProfile;
    public static int count =0;
    String DA,DA2,DA3,DA4;
    int da3_1,da3_2,da3_3;

    int da_no4_1,da_no4_2,da_no4_3;


    int da_add_1,da_add_2,da_add_3;



    private Context context;
    String urlNavHeaderBg = "",urlProfileImg = "", Update_shutdown="",Update_shutdown_details="",latestVersionCode="",url="",releaseNotes="",select_update="";
    String backgroud="",teamleader="",name_teamleader="",username="",position="",
            keyfcm="",username2="";
    private MenuItem menuItemClicked;
    public static int dad_mac=0;
    GetData getData,getData2,getData3,getData4,getData5;
    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/login5.php";


    String JSON_EmployeeName = "EmployeeName";
    String JSON_PositionCode = "PositionCode";
    String JSON_PositionName = "PositionName";
    String JSON_picture = "picture";
    String JSON_backgound = "backgound";

    String JSON_TeamHeadCode = "TeamHeadCode";
    String JSON_TeamHeadName = "TeamHeadName";
    String JSON_TeamName = "TeamName";

    String JSON_SupervisorHeadCode = "SupervisorHeadCode";
    String JSON_SupervisorHeadName = "SupervisorHeadName";
    String JSON_SupervisorName = "SupervisorName";

    String JSON_SubDepartmentHeadCode = "SubDepartmentHeadCode";
    String JSON_SubDepartmentHeadName = "SubDepartmentHeadName";
    String JSON_SubDepartmentName = "SubDepartmentName";

    String JSON_DepartmentHeadCode = "DepartmentHeadCode";
    String JSON_DepartmentHeadName = "DepartmentHeadName";
    String JSON_DepartmentName = "DepartmentName";

    String JSON_SubTeamCode = "SubTeamCode";
    String JSON_TeamCode = "TeamCode";
    String JSON_UserName = "UserName";

    String JSON_themes_app = "themesapp";
    String JSON_themes_color1 = "themes_color1";



    String JSON_problemall = "count_problemall";
    String JSON_problemyes = "count_problemyes";
    String JSON_problemno = "count_problemno";
    String JSON_problemfollow = "count_problemfollow";

    JsonArrayRequest jsonArrayRequest ;

    RequestQueue requestQueue ;

    JsonArrayRequest jsonArrayRequest12 ;

    RequestQueue requestQueue12 ;

    String arr2[];
    String deviceId,regId,tokenA,tokenb,EmployeeName,
            UserName,PositionCode,PositionName,
            picture,backgound,TeamHeadCode,TeamHeadName,
            TeamName,SupervisorHeadCode,SupervisorHeadName,
            SupervisorName,SubDepartmentHeadCode,SubDepartmentHeadName,
            SubDepartmentName,DepartmentHeadCode,DepartmentHeadName,
            DepartmentName,SubTeamCode,TeamCode,themes_app,themes_color1,
            count_problemall,count_problemyes,count_problemno,count_problemfollow,PositionCode_REAL;
    private TextView txtRegId, txtMessage,textView3;
    String themes_color2;
    private int animationCounter = 1;
    private Handler imageSwitcherHandler;
    private BroadcastReceiver mRegistrationBroadcastReceiver;


String VersionOS="",nonti="";
String contno_non;
    String ga,ga2,ga3,ga4,ga5,ga6;
    int count_nontification1_int,count_nontification2_int,count_nontification3_int,
            count_nontification4_int,count_nontification5_int,count_nontification6_int,count_nontification_all;

    public static final int CONNECTION_TIMEOUT=10000;
    public static final int READ_TIMEOUT=15000;

    private MenuItem menuSearch;
    RelativeLayout main_container_wrapper;


    String title_web_to_cedit_checker ;
    String title_cedit_to_cedit_checker ;

    public  static int check_cick=0;
    public  static SimpleTooltip tooltip;
    TextView txt_version_code;
    String version="",EmpID="",GCMID="",version_code="";
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music4);
        this.context = this;
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        main_container_wrapper=(RelativeLayout) findViewById(R.id.main_container_wrapper);
        txt_version_code=(TextView) findViewById(R.id.txt_version_code);

        try {
            PackageInfo pInfo = this.getPackageManager().getPackageInfo(getPackageName(), 0);
             version = pInfo.versionName;
            version_code = String.valueOf(pInfo.versionCode);
            txt_version_code.setText("VersionName : "+version+" : "+ TOSSGeneral.SERVICE_MODE);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }




















      //  update_status_offline();
        select_status_Update_shutdown();
        check_permision();





        VersionOS= MyApplication.getInstance().getPrefManager().getPreferrence("VersionOS");
         EmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
         GCMID=MyApplication.getInstance().getPrefManager().getPreferrence("TOKEN");


        try {
            if(VersionOS.equals("6WW.0")){
                SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE);
                sweetAlertDialog.setTitleText("Error!");
                sweetAlertDialog.setContentText("*ยังไม่เปิดให้ใช้กับ android 6.0*");
                sweetAlertDialog.setCancelable(false);
                sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {



                        Log.e("dialog","ปิด dialog");
                        sDialog.dismissWithAnimation();

                        finish();
                    }
                });
                sweetAlertDialog .show();
            }
            else {

            }

        }
        catch (Exception ex){

        }

        Bundle data=getIntent().getExtras();
        if(data!=null) {
            //nonti = data.getString("nonti");

        }


        EmployeeName=MyApplication.getInstance().getPrefManager().getPreferrence("EmployeeName");
        PositionCode=MyApplication.getInstance().getPrefManager().getPreferrence("SourceSystem");
        PositionCode_REAL=MyApplication.getInstance().getPrefManager().getPreferrence("PositionCode");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, APP_PERMISSION_REQUEST);
        } else {

           // startService(new Intent(MusicActivity_Credit.this, FloatWidgetService.class));

        }


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragment = new UI_CARDVIEW_DATA_CEDIT();


        try {

                fragment  = new UI_CARDVIEW_DATA_CUSTOMER();
                setTitle("รายการติดตั้ง");
                //fragment = new IconTextTabsActivity_cedit_intro();

        }
        catch (Exception EX){

        }


       String AndroidDeviceID = Settings.Secure.getString(this.getContentResolver(),
                Settings.Secure.ANDROID_ID);


        Log.e("AndroidDeviceID",AndroidDeviceID);


        try {
            fragmentTransaction.replace(R.id.main_container_wrapper, fragment);
            fragmentTransaction.commit();
        }
        catch (Exception EX){

        }












        initMenuFragment();

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


        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                // checking for type intent filter
                if (intent.getAction().equals(Config.REGISTRATION_COMPLETE)) {
                    // gcm successfully registered
                    // now subscribe to `global` topic to receive app wide notifications
                    FirebaseMessaging.getInstance().subscribeToTopic(Config.TOPIC_GLOBAL);

                    //displayFirebaseRegId();

                } else if (intent.getAction().equals(Config.PUSH_NOTIFICATION)) {
                    // new push notification is received

                    String message = intent.getStringExtra("problem");
                    String contno = intent.getStringExtra("contno");
                    String check=intent.getStringExtra("check");
                    String CHECK_non_logout=intent.getStringExtra("non_logout");
                    //  Log.e("contno_nonti",contno);
                   // Toast.makeText(getApplicationContext(), "Push notification: " + message, Toast.LENGTH_LONG).show();
                     title_web_to_cedit_checker = intent.getStringExtra("title_web_to_cedit_checker");
                     title_cedit_to_cedit_checker = intent.getStringExtra("title_cedit_to_cedit_checker");





                   /* try {
                        if(!title_web_to_cedit_checker.isEmpty()){



                            Intent showFullQuoteIntent = new Intent(MusicActivity_Credit.this, MusicActivity_Payment.class);
                            startActivity(showFullQuoteIntent);
                            finish();

                        }
                    }
                    catch (Exception ex){

                    }



                    try {
                        if(!title_cedit_to_cedit_checker.isEmpty()) {


                            Intent showFullQuoteIntent = new Intent(MusicActivity_Credit.this, MusicActivity_Checker.class);
                            startActivity(showFullQuoteIntent);
                            finish();

                        }
                    }
                    catch (Exception ex){

                    }*/



                    //startService(new Intent(MusicActivity_Credit.this, FloatWidgetService.class));

                    // txtMessage.setText(message);
                    //Log.e("message555",message);
                    try {


                        if(!message.isEmpty()){
                      //      startService(new Intent(MusicActivity_Credit.this, FloatWidgetService.class));
                            count++;

                            try {
                                if(PositionCode.equals("Credit")){
                                    //fragment  = new UI_CARDVIEW_CHECK_PROBLEM_NEW();
                                   // setTitle("แจ้งปัญหา");
                                    //fragment = new IconTextTabsActivity_cedit_intro();
                                }
                                else {


                                   if(check.equals("check")){
                                       Intent showFullQuoteIntent = new Intent(MusicActivity_Mechanic.this, MusicActivity_Mechanic.class);
                                       startActivity(showFullQuoteIntent);
                                       finish();
                                   }



                                }
                            }
                            catch (Exception EX){

                            }

                        }


                        if(CHECK_non_logout.equals("logout")) {
                            try {


                                update_TOKEN();
                                update_status_offline();
                                INSENT_LOGout_LOOKHIN();



                                MyApplication.getInstance().getPrefManager().clear();
                                MyApplication.getInstance().getPrefManager().setPreferrence("statuslogin", "0");
                                MyApplication.getInstance().getPrefManager().setPreferrence("statuslogin_sale", "0");
                                MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_M", "null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_L", "null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_S", "null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_T", "null");

                                // Intent mIntent = new Intent( MusicActivity_Credit.this, LOGIN_MAIN.class);
                                Intent mIntent = new Intent( MusicActivity_Mechanic.this, INTRO_APP.class);

                                startActivity(mIntent);
                                finish();

                            }
                            catch (Exception ex){
                                MyApplication.getInstance().getPrefManager().clear();
                                MyApplication.getInstance().getPrefManager().setPreferrence("statuslogin", "0");
                                MyApplication.getInstance().getPrefManager().setPreferrence("statuslogin_sale", "0");
                                MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_M", "null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_L", "null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_S", "null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_T", "null");

                                // Intent mIntent = new Intent( MusicActivity_Credit.this, LOGIN_MAIN.class);
                                Intent mIntent = new Intent( MusicActivity_Mechanic.this, INTRO_APP.class);

                                startActivity(mIntent);
                                finish();
                            }
                        }




                    }
                    catch (Exception ex){
                        //count=1;
                        //count= 1;
                    }


                    invalidateOptionsMenu();
                }
            }
        };








try {
    String ff=  MyApplication.getInstance().getPrefManager().getPreferrence("themes_app");
    String  hex_value = "0x"+Integer.toHexString(Integer.parseInt(ff));
    Log.e("hex_value", hex_value);
    int dd= Integer.parseInt(ff);
    Log.e("dd", String.valueOf(dd));

    //   navigationView.setItemTextAppearance();
    navigationView.setBackgroundColor(dd);

}
catch (Exception ex){

}








        nav_sale1=(TextView) MenuItemCompat.getActionView(navigationView.getMenu().
                findItem(R.id.nav_report1));

        nav_sale2=(TextView) MenuItemCompat.getActionView(navigationView.getMenu().
                findItem(R.id.nav_report_contno_error));

        nav_sale3=(TextView) MenuItemCompat.getActionView(navigationView.getMenu().
                findItem(R.id.nav_edit));

        nav_sale4=(TextView) MenuItemCompat.getActionView(navigationView.getMenu().
                findItem(R.id.nav_report_sale_checker));


        try {
            if (PositionCode.equals("Credit")) {

            } else {
                initializeCountDrawer_sale();
                JSON_DATA_WEB_CALL_number_page3_2();
                JSON_DATA_WEB_CALL_number_page_no4();
                JSON_DATA_WEB_CALL_number_page_add();

                JSON_DATA_WEB_CALL_number_page();

                JSON_DATA_WEB_CALL_number_page2();
                JSON_DATA_WEB_CALL_number_page3();

                JSON_DATA_WEB_CALL_number_page4();

                //

            }
        }
        catch (Exception ex){

        }











        String design_app_on_off_all = MyApplication.getInstance().getPrefManager().getPreferrence("design");

        navigationView.getMenu().findItem(R.id.nav_home).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_user).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_report1).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_report2).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_report_foller).setVisible(false);

        navigationView.getMenu().findItem(R.id.nav_check_customer_yes).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_about_us).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_privacy_policy).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_profile).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_user_user).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_settings).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_report_bug).setVisible(false);




        try {
            if(PositionCode.equals("Credit")){
                navigationView.getMenu().findItem(R.id.nav_report_problem).setVisible(true);
                navigationView.getMenu().findItem(R.id.nav_report_contno).setVisible(true);
                navigationView.getMenu().findItem(R.id.nav_report_contno_error).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_report_contno_success).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_edit).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_check_customer_yes).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_history).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_check_customer).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_report1).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_history_sale).setVisible(false);

                //ระบบตรวจสอบ
                navigationView.getMenu().findItem(R.id.nav_check).setVisible(true);            //ระบบตรวจสอบ
                //ระบบตรวจสอบ

                navigationView.getMenu().findItem(R.id.nav_check3).setVisible(true);

                navigationView.getMenu().findItem(R.id.nav_report_sale_checker).setVisible(false);

                navigationView.getMenu().findItem(R.id.nav_report_problem_uat).setVisible(false);

            }
            else {
                navigationView.getMenu().findItem(R.id.nav_report_problem).setVisible(false);      // แจ้งปัญหาของเชล
                navigationView.getMenu().findItem(R.id.nav_report_contno).setVisible(false);       // แจ้งปัญหาของเชล
                navigationView.getMenu().findItem(R.id.nav_report_contno_error).setVisible(true);
                navigationView.getMenu().findItem(R.id.nav_report_contno_success).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_edit).setVisible(true);
                navigationView.getMenu().findItem(R.id.nav_check_customer_yes).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_history).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_check_customer).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_report1).setVisible(true);
                navigationView.getMenu().findItem(R.id.nav_history_sale).setVisible(false);
                //ระบบตรวจสอบ
                navigationView.getMenu().findItem(R.id.nav_check).setVisible(false);            //ระบบตรวจสอบ

                navigationView.getMenu().findItem(R.id.nav_check3).setVisible(false);

                //ระบบตรวจสอบ

                navigationView.getMenu().findItem(R.id.nav_report_sale_checker).setVisible(true);

                navigationView.getMenu().findItem(R.id.nav_report_problem_uat).setVisible(false);


            }
        }
        catch (Exception EX){

        }




        /*
        try {
            if(design_app_on_off_all.equals("0")){
                navigationView.getMenu().findItem(R.id.nav_about_us).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_privacy_policy).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_profile).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_user_user).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_settings).setVisible(false);
            }
            else {
                navigationView.getMenu().findItem(R.id.nav_about_us).setVisible(true);
                navigationView.getMenu().findItem(R.id.nav_privacy_policy).setVisible(true);
                navigationView.getMenu().findItem(R.id.nav_profile).setVisible(true);
                navigationView.getMenu().findItem(R.id.nav_user_user).setVisible(true);
                navigationView.getMenu().findItem(R.id.nav_settings).setVisible(true);
            }

        }
        catch (Exception ex){
            navigationView.getMenu().findItem(R.id.nav_about_us).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_privacy_policy).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_profile).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_user_user).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_settings).setVisible(true);
        }
*/




        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_home0) {
                    fragment  = new UI_CARDVIEW_DATA_CUSTOMER();
                    setTitle("รายการติดตั้ง");
                }
                else if (id == R.id.nav_home) {
                    fragment = new UI_CARDVIEW_DATA_CEDIT();

                } else if (id == R.id.nav_user) {
                    //  fragment = new IconTextTabsActivity10();

                } else if (id == R.id.nav_report1) {


                        fragment = new  IconTextTabsActivity_sale_for_checker_all0();
                    setTitle("รายการการ์ดปัญหาทั้งหมด");

                } else if (id == R.id.nav_report2) {
                    //fragment = new LibraryFragment9();


                }
                else if (id == R.id.nav_report_sale_checker) {
                    fragment = new IconTextTabsActivity_sale_for_checker_all();
                    setTitle("รายการตรวจสอบจากเครดิต");

                }

                else if (id == R.id.nav_report_foller) {
                    // fragment = new LibraryFragment14();


                }
                else if (id == R.id.nav_check_customer) {



                    fragment = new UI_CARDVIEW_DATA_CEDIT_BEFORE_EDIT_PROBLEM_FRAGMENT_waiting_to_check();


                    setTitle("รายการที่ต้องตรวจสอบ");


                }
                else if (id == R.id.nav_report_problem) {
                    if(PositionCode.equals("Credit")){
                        // fragment = new UI_CARDVIEW_DATA_CREDIT_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT2();
                        fragment = new UI_CARDVIEW_DATA_MANAGER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_CREDIT1();
                    }
                    // fragment = new IconTextTabsActivity_cedit_intro();


                    else if(PositionCode.equals("Sale")){
                        fragment = new UI_CARDVIEW_DATA_MANAGER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_SALE_REPORT_PROBLEM();
                    }

                    setTitle("รายการ การแจ้งปัญหา");

                }

                else if (id == R.id.nav_report_problem_uat) {
                    if(PositionCode.equals("Credit")){
                        fragment = new UI_CARDVIEW_DATA_CREDIT_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT2_UAT();
                    }

                    setTitle("รายการ การแจ้งปัญหา UAT");

                }


                else if (id == R.id.nav_report_contno_error) {

                    fragment = new IconTextTabsActivity_sale_for_checker_all2();

              /*      if(PositionCode_REAL.equals("Sale")){
                        fragment = new UI_CARDVIEW_DATA_SALE_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_NO();
                    }
                    else if(PositionCode_REAL.equals("SubTeamLeader")){
                        fragment = new UI_CARDVIEW_DATA_LEADER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_NO();
                    }
                    else if(PositionCode_REAL.equals("Supervisor")){
                        fragment = new UI_CARDVIEW_DATA_SUP_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_NO();
                    }
                    else if(PositionCode_REAL.equals("LineManager")){
                        fragment = new UI_CARDVIEW_DATA_LINE_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_NO();
                    }
                    else if(PositionCode_REAL.equals("Manager")){
                        fragment = new UI_CARDVIEW_DATA_MANAGER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_NO();

                    }
*/

                    setTitle("รายการที่ยังไม่แก้ไข");

                }
                else if (id == R.id.nav_edit) {
                    fragment = new IconTextTabsActivity_sale_for_checker_all3();


         /*           if(PositionCode_REAL.equals("Sale")){
                        fragment = new UI_CARDVIEW_DATA_SALE_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_YES();
                    }
                    else if(PositionCode_REAL.equals("SubTeamLeader")){
                        fragment = new UI_CARDVIEW_DATA_LEADER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_YES();
                    }
                    else if(PositionCode_REAL.equals("Supervisor")){
                        fragment = new UI_CARDVIEW_DATA_SUP_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_YES();
                    }
                    else if(PositionCode_REAL.equals("LineManager")){
                        fragment = new UI_CARDVIEW_DATA_LINE_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_YES();
                    }
                    else if(PositionCode_REAL.equals("Manager")){
                        fragment = new UI_CARDVIEW_DATA_MANAGER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_YES();
                        //fragment = new UI_CARDVIEW_DATA_MANAGER_BEFORE_EDIT_PROBLEM_FRAGMENT_waiting_to_check();
                    }*/

                    setTitle("รายการที่แก้ไขแล้ว");

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
                    // fragment  = new UI_CARDVIEW_CHECK_PROBLEM_NEW();
                    fragment  = new UI_CARDVIEW_CHECK_PROBLEM_NEW2_2();

                    setTitle("แจ้งปัญหา");

                }


                else if (id == R.id.nav_about_us) {
                    // startActivity(new Intent(MusicActivity5.this, WelcomeActivity.class));
                    //  startActivity(new Intent(MusicActivity_Credit.this, MainActivity_555.class));
                    // return true;
                }else if (id == R.id.nav_privacy_policy) {

                }

                else if (id == R.id.nav_check) {



                    startActivity(new Intent(MusicActivity_Mechanic.this, MusicActivity_Checker.class));
                    finish();
                    return true;
                    //      setTitle("ระบบตรวจสอบ");
                }
                else if (id == R.id.nav_check3) {



                    // startActivity(new Intent(MusicActivity_Credit.this, UI_CARDVIEW_DATA_CREDIT_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT2_Acti.class));
                    startActivity(new Intent(MusicActivity_Mechanic.this, MusicActivity_Payment.class));
                    finish();
                    return true;
                    //      setTitle("ระบบตรวจสอบ");
                }

              /*  else if (id == R.id.nav_orther1) {



                    startActivity(new Intent(MusicActivity_Credit.this, BadgeViewActivity.class));
                    finish();
                    return true;
                    //      setTitle("ระบบตรวจสอบ");
                }*/

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

                        update_TOKEN();
                        update_status_offline();
                        INSENT_LOGout_LOOKHIN();

                        //       MyApplication.getInstance().getPrefManager().clear();
                        MyApplication.getInstance().getPrefManager().setPreferrence("statuslogin", "0");
                        MyApplication.getInstance().getPrefManager().setPreferrence("statuslogin_sale", "0");
                        MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_M", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_L", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_S", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_T", "null");


                        // Intent mIntent = new Intent( MusicActivity_Credit.this, LOGIN_MAIN.class);
                        Intent mIntent = new Intent( MusicActivity_Mechanic.this, LOGIN_MAIN.class);

                        startActivity(mIntent);
                        finish();

                    }
                    catch (Exception ex){
                        //   MyApplication.getInstance().getPrefManager().clear();
                        MyApplication.getInstance().getPrefManager().setPreferrence("statuslogin", "0");
                        MyApplication.getInstance().getPrefManager().setPreferrence("statuslogin_sale", "0");
                        MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_M", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_L", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_S", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_T", "null");


                        // Intent mIntent = new Intent( MusicActivity_Credit.this, LOGIN_MAIN.class);
                        Intent mIntent = new Intent( MusicActivity_Mechanic.this, LOGIN_MAIN.class);

                        startActivity(mIntent);
                        finish();
                    }


                }





                FragmentTransaction transaction = fragmentManager.beginTransaction();
                try {
                    transaction.replace(R.id.main_container_wrapper, fragment);
                }
                catch (Exception ex){

                }


                transaction.commit();

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                assert drawer != null;
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });











        currentLoc = new GetCurrentLocation(this);


        loadNavHeader();



/*               new AppUpdater(context)

               .setUpdateFrom(UpdateFrom.JSON)
               .setUpdateJSON("http://app.thiensurat.co.th/assanee/check_update.php")
               .setDisplay(Display.DIALOG)
                .showAppUpdated(false)
               .start();*/






         SQLiteDataBaseBuild();
        SQLiteTableBuild();
         sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_image_buffer.TABLE_NAME+"");

        SQLiteDataBaseBuild2();
        SQLiteTableBuild2();
        sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_problem_id_image.TABLE_NAME+"");

        SQLiteDataBaseBuild3();
        SQLiteTableBuild3();
        sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_image_buffer2.TABLE_NAME+"");
        //checkCameraPermission();



       // addImageToGallery("/storage/sdcard0/Android/data/th.co.thiensurat.uat/files/pictures/582478F33CE149D6A6332ED54B86C1CA/IDCARD/088C082C78DF4457874ACFCDD6C49191.jpg",this);
        /**
         *
         * GIS
         *
         * Edit by Teerayut Klinsanga
         *
         * Date 2019-08-27
         *
         */

     /*   try {
            Intent i = getApplicationContext().getPackageManager().getLaunchIntentForPackage("com.gps_tracking");
            if (i != null) {
                MyApplication.getInstance().getPrefManager().setPreferrence("gis", "1");
                Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("gis://empid/" + EmpID));
                startActivity(in);
            }
        }
        catch (Exception ex){

        }
*/

        /**
         * END
         */
    }

    // handleSelectedMenu(MenuItem menuItem){



/*
    public static void addImageToGallery(final String filePath, final Context context) {

        ContentValues values = new ContentValues();

        values.put(MediaStore.Images.Media.DATE_TAKEN, System.currentTimeMillis());
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
        values.put(MediaStore.MediaColumns.DATA, filePath);

        context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
    }
*/





    public void SQLiteDataBaseBuild(){

        sqLiteDatabase = openOrCreateDatabase(SQLiteHelper_image_buffer.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    public void SQLiteTableBuild(){

        //sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper.TABLE_NAME+"("+ SQLiteHelper.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+SQLiteHelper.Table_Column_1_Subject_Name+" VARCHAR, "+SQLiteHelper.Table_Column_2_SubjectFullForm+" VARCHAR, "+SQLiteHelper.Table_Column_3_subteamcode+" VARCHAR, "+SQLiteHelper.Table_Column_5_contract_number+" VARCHAR, "+SQLiteHelper.Table_Column_6_contract_number2+" VARCHAR, "+SQLiteHelper.Table_Column_7_name_topic+" VARCHAR, "+SQLiteHelper.Table_Column_8_customer+" VARCHAR, "+SQLiteHelper.Table_Column_9_description+" VARCHAR, "+SQLiteHelper.Table_Column_16_status+" VARCHAR, "+SQLiteHelper.Table_Column_15_date_time+" VARCHAR, "+SQLiteHelper.Table_Column_23_date_time_update+" VARCHAR, "+SQLiteHelper.Table_Column_10_approveStatus+" VARCHAR, "+SQLiteHelper.Table_Column_11_approveBy+" VARCHAR, "+SQLiteHelper.Table_Column_12_approveDate+" VARCHAR, "+SQLiteHelper.Table_Column_17_isremark+" VARCHAR, "+SQLiteHelper.Table_Column_14_isremark1+" VARCHAR, "+SQLiteHelper.Table_Column_20_check_foller+" VARCHAR, "+SQLiteHelper.Table_Column_21_countfoller+" VARCHAR, "+SQLiteHelper.Table_Column_22_countcomment+" VARCHAR, "+SQLiteHelper.Table_Column_4_picture+" VARCHAR);");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_image_buffer.TABLE_NAME+"("+ SQLiteHelper_image_buffer.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_image_buffer.Table_part_id+" VARCHAR, "+SQLiteHelper_image_buffer.Table_name_image+" VARCHAR, "+SQLiteHelper_image_buffer.Table_url_image+" VARCHAR, "+SQLiteHelper_image_buffer.Table_Url+" VARCHAR, "+SQLiteHelper_image_buffer.Table_Image_Name+" VARCHAR, "+SQLiteHelper_image_buffer.Table_Image_Size+" VARCHAR, "+SQLiteHelper_image_buffer.Table_Image_Type+" VARCHAR, "+SQLiteHelper_image_buffer.Table_order_image+" VARCHAR);");


    }

    public void SQLiteDataBaseBuild2(){

        sqLiteDatabase = openOrCreateDatabase(SQLiteHelper_problem_id_image.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    public void SQLiteTableBuild2(){

        //sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper.TABLE_NAME+"("+ SQLiteHelper.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+SQLiteHelper.Table_Column_1_Subject_Name+" VARCHAR, "+SQLiteHelper.Table_Column_2_SubjectFullForm+" VARCHAR, "+SQLiteHelper.Table_Column_3_subteamcode+" VARCHAR, "+SQLiteHelper.Table_Column_5_contract_number+" VARCHAR, "+SQLiteHelper.Table_Column_6_contract_number2+" VARCHAR, "+SQLiteHelper.Table_Column_7_name_topic+" VARCHAR, "+SQLiteHelper.Table_Column_8_customer+" VARCHAR, "+SQLiteHelper.Table_Column_9_description+" VARCHAR, "+SQLiteHelper.Table_Column_16_status+" VARCHAR, "+SQLiteHelper.Table_Column_15_date_time+" VARCHAR, "+SQLiteHelper.Table_Column_23_date_time_update+" VARCHAR, "+SQLiteHelper.Table_Column_10_approveStatus+" VARCHAR, "+SQLiteHelper.Table_Column_11_approveBy+" VARCHAR, "+SQLiteHelper.Table_Column_12_approveDate+" VARCHAR, "+SQLiteHelper.Table_Column_17_isremark+" VARCHAR, "+SQLiteHelper.Table_Column_14_isremark1+" VARCHAR, "+SQLiteHelper.Table_Column_20_check_foller+" VARCHAR, "+SQLiteHelper.Table_Column_21_countfoller+" VARCHAR, "+SQLiteHelper.Table_Column_22_countcomment+" VARCHAR, "+SQLiteHelper.Table_Column_4_picture+" VARCHAR);");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_problem_id_image.TABLE_NAME+"("+ SQLiteHelper_problem_id_image.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_problem_id_image.Table_part_id+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_part_image+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_Category+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_Main_problems+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_Sub_problems+" VARCHAR,"+SQLiteHelper_problem_id_image.Table_topic+" VARCHAR,"+SQLiteHelper_problem_id_image.Table_ProblemDetail+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_datetime+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_Url+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_Image_Name+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_Image_Size+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_Image_Type+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_order_image+" VARCHAR);");


    }

    public void SQLiteDataBaseBuild3(){

        sqLiteDatabase = openOrCreateDatabase(SQLiteHelper_image_buffer2.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    public void SQLiteTableBuild3(){

        //sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper.TABLE_NAME+"("+ SQLiteHelper.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+SQLiteHelper.Table_Column_1_Subject_Name+" VARCHAR, "+SQLiteHelper.Table_Column_2_SubjectFullForm+" VARCHAR, "+SQLiteHelper.Table_Column_3_subteamcode+" VARCHAR, "+SQLiteHelper.Table_Column_5_contract_number+" VARCHAR, "+SQLiteHelper.Table_Column_6_contract_number2+" VARCHAR, "+SQLiteHelper.Table_Column_7_name_topic+" VARCHAR, "+SQLiteHelper.Table_Column_8_customer+" VARCHAR, "+SQLiteHelper.Table_Column_9_description+" VARCHAR, "+SQLiteHelper.Table_Column_16_status+" VARCHAR, "+SQLiteHelper.Table_Column_15_date_time+" VARCHAR, "+SQLiteHelper.Table_Column_23_date_time_update+" VARCHAR, "+SQLiteHelper.Table_Column_10_approveStatus+" VARCHAR, "+SQLiteHelper.Table_Column_11_approveBy+" VARCHAR, "+SQLiteHelper.Table_Column_12_approveDate+" VARCHAR, "+SQLiteHelper.Table_Column_17_isremark+" VARCHAR, "+SQLiteHelper.Table_Column_14_isremark1+" VARCHAR, "+SQLiteHelper.Table_Column_20_check_foller+" VARCHAR, "+SQLiteHelper.Table_Column_21_countfoller+" VARCHAR, "+SQLiteHelper.Table_Column_22_countcomment+" VARCHAR, "+SQLiteHelper.Table_Column_4_picture+" VARCHAR);");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_image_buffer2.TABLE_NAME+"("+ SQLiteHelper_image_buffer2.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_image_buffer2.Table_part_id+" VARCHAR, "+SQLiteHelper_image_buffer2.Table_name_image+" VARCHAR, "+SQLiteHelper_image_buffer2.Table_url_image+" VARCHAR, "+SQLiteHelper_image_buffer2.Table_Url+" VARCHAR, "+SQLiteHelper_image_buffer2.Table_Image_Name+" VARCHAR, "+SQLiteHelper_image_buffer2.Table_Image_Size+" VARCHAR, "+SQLiteHelper_image_buffer2.Table_Image_Type+" VARCHAR, "+SQLiteHelper_image_buffer2.Table_order_image+" VARCHAR);");


    }

    public static void setBadge(Context context, int count) {
        String launcherClassName = getLauncherClassName(context);
        if (launcherClassName == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count", count);
        intent.putExtra("badge_count_package_name", context.getPackageName());
        intent.putExtra("badge_count_class_name", launcherClassName);
        context.sendBroadcast(intent);
    }

    public static String getLauncherClassName(Context context) {

        PackageManager pm = context.getPackageManager();

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> resolveInfos = pm.queryIntentActivities(intent, 0);
        for (ResolveInfo resolveInfo : resolveInfos) {
            String pkgName = resolveInfo.activityInfo.applicationInfo.packageName;
            if (pkgName.equalsIgnoreCase(context.getPackageName())) {
                String className = resolveInfo.activityInfo.name;
                return className;
            }
        }
        return null;
    }

    @Override
    protected void onStart() {
        try {
            super.onStart();
        }
        catch (Exception ex){

        }

        currentLoc.connectGoogleApi();
    }

    @Override
    protected void onStop() {
        super.onStop();
        currentLoc.disConnectGoogleApi();
    }




    @Override
    protected void onResume() {
        super.onResume();



        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.REGISTRATION_COMPLETE));


        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.PUSH_NOTIFICATION));


        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.main_container_wrapper);




       // check_permision();

        /*
        if (currentFragment instanceof HomeFragment5) {

            JSON_DATA_WEB_CALL();
            loadNavHeader();
        }
        else if (currentFragment instanceof SettingsFragment) {
            JSON_DATA_WEB_CALL();
            Log.e("ddd","fff");
            loadNavHeader();
        }
        */

        //DETERMINE WHO STARTED THIS ACTIVITY
//        final String sender=this.getIntent().getExtras().getString("SENDER_KEY");

        //IF ITS THE FRAGMENT THEN RECEIVE DATA
       // if(sender != null)
        //{
            receiveData();
         //   Toast.makeText(this, "Received", Toast.LENGTH_SHORT).show();

       // }




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

    public void JSON_DATA_WEB_CALL(){

        // jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL+"?picture="+"http://app.thiensurat.co.th/assanee/upload/image8.png",
        //   jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL+"?deviceID="+deviceId,
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_WEBCALL(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);
        // swipeRefreshLayout.setRefreshing(false);
    }

    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            GetData GetDataAdapter2 = new GetData();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);
                // Log.e(TAG,"หมู json array"+json.getJSONObject("InstallDate").getString("date"));


                getData = new GetData();

                getData.setEmployeeName(json.getString(JSON_EmployeeName));
                getData.setPositionCode(json.getString(JSON_PositionCode));
                getData.setPositionName(json.getString(JSON_PositionName));
                getData.setpicture(json.getString(JSON_picture));
                getData.setbackgound(json.getString(JSON_backgound));

                getData.setTeamHeadCode(json.getString(JSON_TeamHeadCode));
                getData.setTeamHeadName(json.getString(JSON_TeamHeadName));
                getData.setTeamName(json.getString(JSON_TeamName));

                getData.setSupervisorHeadCode(json.getString(JSON_SupervisorHeadCode));
                getData.setSupervisorHeadName(json.getString(JSON_SupervisorHeadName));
                getData.setSupervisorName(json.getString(JSON_SupervisorName));

                getData.setSubDepartmentHeadCode(json.getString(JSON_SubDepartmentHeadCode));
                getData.setSubDepartmentHeadName(json.getString(JSON_SubDepartmentHeadName));
                getData.setSubDepartmentName(json.getString(JSON_SubDepartmentName));

                getData.setDepartmentHeadCode(json.getString(JSON_DepartmentHeadCode));
                getData.setDepartmentHeadName(json.getString(JSON_DepartmentHeadName));
                getData.setDepartmentName(json.getString(JSON_DepartmentName));

                getData.setSubTeamCode(json.getString(JSON_SubTeamCode));
                getData.setTeamCode(json.getString(JSON_TeamCode));
                getData.setUserName(json.getString(JSON_UserName));
                getData.setthemes_app(json.getString(JSON_themes_app));
                getData.setthemes_color1(json.getString(JSON_themes_color1));

                EmployeeName = getData.getEmployeeName();
                PositionCode = getData.getPositionCode();
                PositionName = getData.getPositionName();
                picture = getData.getpicture();
                backgound = getData.getbackgound();

                TeamHeadCode = getData.getTeamHeadCode();
                TeamHeadName = getData.getTeamHeadName();
                TeamName = getData.getTeamName();

                SupervisorHeadCode = getData.getSupervisorHeadCode();
                SupervisorHeadName = getData.getSupervisorHeadName();
                SupervisorName = getData.getSupervisorName();

                SubDepartmentHeadCode = getData.getSubDepartmentHeadCode();
                SubDepartmentHeadName = getData.getSubDepartmentHeadName();
                SubDepartmentName = getData.getSubDepartmentName();

                DepartmentHeadCode = getData.getDepartmentHeadCode();
                DepartmentHeadName = getData.getDepartmentHeadName();
                DepartmentName = getData.getDepartmentName();

                SubTeamCode = getData.getSubTeamCode();
                TeamCode = getData.getTeamCode();
                UserName = getData.getUserName();
                themes_app = getData.getthemes_app();
                themes_color1 = getData.getthemes_color1();


                if (themes_color1.equals(null)) {
                    themes_color2 = "-1";
                } else {
                    themes_color2 = getData.getthemes_color1();
                }


                MyApplication.getInstance().getPrefManager().setPreferrence("EmployeeName", EmployeeName);
                MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode", PositionCode);
                MyApplication.getInstance().getPrefManager().setPreferrence("PositionName", PositionName);
                MyApplication.getInstance().getPrefManager().setPreferrence("picture", picture);
                MyApplication.getInstance().getPrefManager().setPreferrence("backgound", backgound);
                MyApplication.getInstance().getPrefManager().setPreferrence("TeamHeadCode", TeamHeadCode);
                MyApplication.getInstance().getPrefManager().setPreferrence("TeamHeadName", TeamHeadName);
                MyApplication.getInstance().getPrefManager().setPreferrence("TeamName", TeamName);
                MyApplication.getInstance().getPrefManager().setPreferrence("SupervisorHeadCode", SupervisorHeadCode);
                MyApplication.getInstance().getPrefManager().setPreferrence("SupervisorHeadName", SupervisorHeadName);
                MyApplication.getInstance().getPrefManager().setPreferrence("SupervisorName", SupervisorName);
                MyApplication.getInstance().getPrefManager().setPreferrence("SubDepartmentHeadCode", SubDepartmentHeadCode);
                MyApplication.getInstance().getPrefManager().setPreferrence("SubDepartmentHeadName", SubDepartmentHeadName);
                MyApplication.getInstance().getPrefManager().setPreferrence("SubDepartmentName", SubDepartmentName);
                MyApplication.getInstance().getPrefManager().setPreferrence("DepartmentHeadCode", DepartmentHeadCode);
                MyApplication.getInstance().getPrefManager().setPreferrence("DepartmentHeadName", DepartmentHeadName);
                MyApplication.getInstance().getPrefManager().setPreferrence("DepartmentName", DepartmentName);
                MyApplication.getInstance().getPrefManager().setPreferrence("SubTeamCode", SubTeamCode);
                MyApplication.getInstance().getPrefManager().setPreferrence("TeamCode", TeamCode);
                MyApplication.getInstance().getPrefManager().setPreferrence("UserName", UserName);
                MyApplication.getInstance().getPrefManager().setPreferrence("themes_app", themes_app);
                MyApplication.getInstance().getPrefManager().setPreferrence("themes_color2", themes_color2);

            } catch (JSONException e) {


                e.printStackTrace();


            }
            //    GetDataAdapter1.add(GetDataAdapter2);
        }
    }

    private List<MenuObject> getMenuObjects() {


        List<MenuObject> menuObjects = new ArrayList<>();

        MenuObject close = new MenuObject();
        close.setResource(R.drawable.delete);





        MenuObject send = new MenuObject("ตั้งค่า");
        send.setResource(R.drawable.settingsss);

        MenuObject like = new MenuObject("โปรไฟท์");
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.contactsss);
        like.setBitmap(b);

        MenuObject like2 = new MenuObject("user");
        Bitmap b2 = BitmapFactory.decodeResource(getResources(), R.drawable.usergroup);
        like2.setBitmap(b2);




        MenuObject block = new MenuObject("อัพเดทตำแหน่งระยะทาง");
        block.setResource(R.drawable.lolo);


        MenuObject block2 = new MenuObject("รีเซ็ตค่าเริ่มต้น");
        block2.setResource(R.drawable.reset);







        menuObjects.add(close);

        menuObjects.add(send);
        menuObjects.add(like);
        menuObjects.add(like2);
        // menuObjects.add(addFr);
        //   menuObjects.add(addFav);
        menuObjects.add(block);
        menuObjects.add(block2);
        return menuObjects;
    }



    private void initializeCountDrawer_sale() {

        DA=  MyApplication.getInstance().getPrefManager().getPreferrence("DA_DA")+"";
        DA2=   MyApplication.getInstance().getPrefManager().getPreferrence("DA_DA2")+"";
        DA3=   MyApplication.getInstance().getPrefManager().getPreferrence("DA_DA3")+"";
        DA4=   MyApplication.getInstance().getPrefManager().getPreferrence("DA_DA4")+"";

        if((DA.equals("null"))|(DA.equals("0"))){
            nav_sale1.setText("");
            nav_sale1.setBackgroundResource(0);
        }
        else {
            nav_sale1.setGravity(Gravity.CENTER);
            nav_sale1.setTypeface(null, Typeface.BOLD);
            nav_sale1.setTextColor(getResources().getColor(R.color.black));
            nav_sale1.setText(DA);
            nav_sale1.setBackgroundResource(R.drawable.bg_circle4);
        }



        if((DA2.equals("null"))|(DA2.equals("0"))){
            nav_sale2.setText("");
            nav_sale2.setBackgroundResource(0);
        }
        else {
            nav_sale2.setGravity(Gravity.CENTER);
            nav_sale2.setTypeface(null, Typeface.BOLD);
            nav_sale2.setTextColor(getResources().getColor(R.color.blue));
            nav_sale2.setText(DA2);
            nav_sale2.setBackgroundResource(R.drawable.bg_circle4);
        }



        if((DA3.equals("null"))|(DA3.equals("0"))){
            nav_sale3.setText("");
            nav_sale3.setBackgroundResource(0);
        }
        else {
            nav_sale3.setGravity(Gravity.CENTER);
            nav_sale3.setTypeface(null,Typeface.BOLD);
            nav_sale3.setTextColor(getResources().getColor(R.color.colorPrimary));
            nav_sale3.setText(DA3);
            nav_sale3.setBackgroundResource(R.drawable.bg_circle4);

        }






        if((DA4.equals("null"))|(DA4.equals("0"))){
            nav_sale4.setText("");
            nav_sale4.setBackgroundResource(0);
        }
        else {
            nav_sale4.setGravity(Gravity.CENTER);
            nav_sale4.setTypeface(null,Typeface.BOLD);
            nav_sale4.setTextColor(getResources().getColor(R.color.Yellow));
            nav_sale4.setText(DA4);
            nav_sale4.setBackgroundResource(R.drawable.bg_circle4);

        }

        //nav_report_foller.setVisibility(View.INVISIBLE);




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





    /*
String cancal="";
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            update_status_offline();
           // status_run_work=true;
            cancal = MyApplication.getInstance().getPrefManager().getPreferrence("cancal")+"";
            if(ui_cardview_check_problem_new.size>0){

                if(cancal.equals("1")){
                    if (PositionCode.equals("Credit")) {
                        fragment = new LibraryFragment_problem();
                        setTitle("แจ้งปัญหา");
                        //fragment = new IconTextTabsActivity_cedit_intro();
                    } else {
                        fragment = new IconTextTabsActivity_cedit_intro_sale();
                    }

                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.main_container_wrapper, fragment);
                    transaction.commit();

                    return true;
                }
                else {
                    update_status_offline();
                    Log.e("offline","user");
                    Intent mIntent = new Intent( MusicActivity_Credit.this, LOGIN_MAIN.class);
                    startActivity(mIntent);
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }




            }
            else {
               // MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                update_status_offline();
                Log.e("offline","user");
                Intent mIntent = new Intent( MusicActivity_Credit.this, LOGIN_MAIN.class);
                startActivity(mIntent);
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }









        } else {

        }
        return false;
    }
    */





    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else if (mMenuDialogFragment != null && mMenuDialogFragment.isAdded()) {
            mMenuDialogFragment.dismiss();
        }


        else {

            try {
                if(check_cick==1){
                    tooltip.dismiss();
                    check_cick=0;
                }
                else {
                    super.onBackPressed();
                    update_status_offline();
                    finish();
                }
            }
            catch (Exception e){
/*                super.onBackPressed();
                update_status_offline();
                finish();*/
            }




        }
    }
    private void dialog_show_runing(){
        final Dialog dialog = new Dialog(MusicActivity_Mechanic.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog_on_running);
        dialog.setCancelable(true);
        dialog.show();
    }






    @SuppressLint("ResourceAsColor")
    @Override
    public boolean onMenuItemClick(View clickedView, int position) {
        //    Toast.makeText(this, "Clicked on position: " + position, Toast.LENGTH_SHORT).show();

        if(position==1){



            //   Log.e("ccc", String.valueOf(position));
        }


        else if(position==2){
          //  fragment = new HomeFragment5();
            //  Log.e("ccc", String.valueOf(position));
        }
        else if(position==3){
            //fragment = new IconTextTabsActivity20();
            //   Log.e("ccc", String.valueOf(position));
        }




        else if(position==4){

              // currentLoc = new GetCurrentLocation(this);
            latitude = currentLoc.latitude;
            longitude = currentLoc.longitude;

            Log.e("llll",latitude+","+longitude);
           // MyApplication.getInstance().getPrefManager().setPreferrence("status_update_distant","0");
            MyApplication.getInstance().getPrefManager().setPreferrence("latlong", latitude+","+longitude);
            dad_mac =1;
            fragment = new UI_CARDVIEW_DATA_FOR_CHECKER();










        }
        else if(position==5){
            MyApplication.getInstance().getPrefManager().setPreferrence("dat2", "1");
            MyApplication.getInstance().getPrefManager().setPreferrence("key_sort", null);
            MyApplication.getInstance().getPrefManager().setPreferrence("intro_save", "0");

            fragment = new UI_CARDVIEW_DATA_FOR_CHECKER();
        }
        else {
            dad_mac =0;
        }



        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_container_wrapper, fragment);
        transaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        assert drawer != null;
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onMenuItemLongClick(View clickedView, int position) {
        Toast.makeText(this, "Long clicked on position: " + position, Toast.LENGTH_SHORT).show();
    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main2, menu);

        //MenuItem menuItem = menu.findItem(R.id.ss);
       // menuItem.setIcon(buildCounterDrawable(count, R.drawable.ic_notifications_none_white_24dp));

        MenuItem itemCart = menu.findItem(R.id.action_cart);
        LayerDrawable icon = (LayerDrawable) itemCart.getIcon();
        setBadgeCount(this, icon, String.valueOf(count));

        itemCart.setVisible(false);

        return true;
    }


    private Drawable buildCounterDrawable(int count, int backgroundImageId) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.counter_menuitem_layout, null);
        view.setBackgroundResource(backgroundImageId);

        if (count == 0) {
            View counterTextPanel = view.findViewById(R.id.counterValuePanel);
            counterTextPanel.setVisibility(View.GONE);
        } else {
            TextView textView = (TextView) view.findViewById(R.id.count);
            textView.setText("" + count);
        }

        view.measure(
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());

        view.setDrawingCacheEnabled(true);
        view.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);

        return new BitmapDrawable(getResources(), bitmap);
    }

    private Drawable buildCounterDrawable2(int count, int backgroundImageId) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.searching_menuitem_layout, null);
        view.setBackgroundResource(backgroundImageId);

        if (count == 0) {
            View counterTextPanel = view.findViewById(R.id.counterValuePanel);
            counterTextPanel.setVisibility(View.GONE);
        } else {
            TextView textView = (TextView) view.findViewById(R.id.count);
            textView.setText("" + count);
        }

        view.measure(
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());

        view.setDrawingCacheEnabled(true);
        view.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);

        return new BitmapDrawable(getResources(), bitmap);
    }

    private void doIncrease() {
        count++;
        invalidateOptionsMenu();
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
Log.e("ssss","sssss");

            String latitude2 = currentLoc.latitude;
            String longitude2 = currentLoc.longitude;
            Log.e("latlong_M",latitude2+","+longitude2);

            MyApplication.getInstance().getPrefManager().setPreferrence("latlong", latitude2+","+longitude2);
            Toast.makeText(MusicActivity_Mechanic.this, "อัพเดทตำแหน่ง " +"เสร็จสิ้น", Toast.LENGTH_LONG).show();
        }

       else if(id == R.id.action_cart){
            count=0;

            Log.e("111",PositionCode);

            try {
                if(PositionCode.equals("Credit")){
                    Intent showFullQuoteIntent = new Intent(this, UI_CARDVIEW_DATA_CREDIT_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT2_Acti.class);
                    startActivity(showFullQuoteIntent);
                }
               else if(PositionCode.equals("Sale")){
                    Intent showFullQuoteIntent = new Intent(this, MusicActivity_Mechanic.class);
                    startActivity(showFullQuoteIntent);
                    finish();
                }
                else {

                    Intent showFullQuoteIntent = new Intent(this, MusicActivity_Mechanic.class);
                    startActivity(showFullQuoteIntent);
                    finish();
                }
            }
            catch (Exception EX){

            }


        }



        return super.onOptionsItemSelected(item);
    }





    protected boolean checkConnection(){
        boolean re=false;
        try{
            ConnectivityManager conMan = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = conMan.getActiveNetworkInfo();

            final boolean connected = networkInfo != null
                    && networkInfo.isAvailable()
                    && networkInfo.isConnected();

            if ( !connected) {
                re= false;
            }
            else
                re=true;
        }catch(Exception err){}
        return re;
    }



    private void update_status_offline() {

        username2=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        final String status_online = "0";
        final String email = username;
        final String shop = username;
        if (username2 == null) {

            return;
        }

        StringRequest stringRequest = new StringRequest(Request.Method.POST, EndPoints.URL_UPDATE_OFFLINE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //  progressDialog.dismiss();
                        try {

                            JSONObject obj = new JSONObject(response);
                            Log.e("message", obj.getString("success"));
                            Toast.makeText(MusicActivity_Mechanic.this, obj.getString("success"), Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //   progressDialog.dismiss();
//                        Log.e("error",error.getMessage());
                   //   Toast.makeText(MusicActivity_Credit.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                // params.put("status", status);
                params.put("username", username2);

                return params;
            }
        };


        try {
            MyVolley.getInstance(this).addToRequestQueue(stringRequest);
        }
        catch (Exception ex){

        }

    }




    String GET_JSON_DATA_HTTP_URL_UPDATE_TOKEN="http://app.thiensurat.co.th/assanee/updatelogout.php";
    public void update_TOKEN() {
        username2=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_UPDATE_TOKEN + "?username=" + username2,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {



                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        try {
            try {
                requestQueue = Volley.newRequestQueue(this);
                requestQueue.add(jsonArrayRequest);

                int MY_SOCKET_TIMEOUT_MS=100000;

                jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(
                        MY_SOCKET_TIMEOUT_MS,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            }
            catch (RuntimeException ex){

            }
        }
        catch (OutOfMemoryError EX){

        }

    }







    String GET_JSON_INSENT_LOGIN_LOOKHIN="https://tssm.thiensurat.co.th/addLogloginApp.php";
    public   void INSENT_LOGout_LOOKHIN(){

        // EmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        String TypeLogin="LOGOUT";
        // GCMID=MyApplication.getInstance().getPrefManager().getPreferrence("TOKEN");
        String AppVersion=version;
        String AndroidVersion=VersionOS;

        Log.e("test_logout",EmpID+TypeLogin+GCMID+AppVersion+AndroidVersion);


        StringRequest postRequest = new StringRequest(Request.Method.POST, GET_JSON_INSENT_LOGIN_LOOKHIN,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.e("Response_sucess", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
//                        Log.e("Response_error", error.getLocalizedMessage());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("EmpID", EmpID);
                params.put("TypeLogin",TypeLogin);
                try {
                    params.put("GCMID", URLDecoder.decode(GCMID, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                params.put("AppVersion",AppVersion);
                params.put("AndroidVersion",AndroidVersion);


                return params;
            }
        };
        // requestQueue.add(postRequest);

        try {
            try {
                requestQueue = Volley.newRequestQueue(this);
                requestQueue.add(postRequest);

                int MY_SOCKET_TIMEOUT_MS=10000;

                jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(
                        MY_SOCKET_TIMEOUT_MS,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            }
            catch (RuntimeException ex){

            }
        }
        catch (OutOfMemoryError EX){

        }


    }




    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
        super.onPause();
    }







    int data_all=0;
    int f=0;
    String GET_JSON_DATA_HTTP_URL_da="http://www.assaneecity.com/insent_update_mysql.php";
    public void Jsonupdate() {


                    jsonArrayRequest12 = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_da + "?word=" + arr2[ioo],


                            new Response.Listener<JSONArray>() {
                                @Override
                                public void onResponse(JSONArray response) {

                                    //Log.e("1111", "11111");


                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    //Log.e("2222", error.toString());

                                }
                            });


                requestQueue12 = Volley.newRequestQueue(this);

                requestQueue12.add(jsonArrayRequest12);






    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == APP_PERMISSION_REQUEST && resultCode == RESULT_OK) {
           // startService(new Intent(MusicActivity_Credit.this, FloatWidgetService.class));
        } else {
            //Toast.makeText(this, "Draw over other app permission not enable.", Toast.LENGTH_SHORT).show();
        }
    }


    private void receiveData()
    {
        //RECEIVE DATA VIA INTENT
        Intent i = getIntent();
        String name = i.getStringExtra("NAME_KEY");
        int year = i.getIntExtra("YEAR_KEY",0);

        try {
            Log.e("name",name);
        }
        catch (Exception e){

        }

        //SET DATA TO TEXTVIEWS

    }


    public static void setBadgeCount(Context context, LayerDrawable icon, String count) {

        BagdeDrawable badge;

        // Reuse drawable if possible
        Drawable reuse = icon.findDrawableByLayerId(R.id.ic_badge);
        if (reuse != null && reuse instanceof BagdeDrawable) {
            badge = (BagdeDrawable) reuse;
        } else {
            badge = new BagdeDrawable(context);
        }

        badge.setCount(count);
        icon.mutate();
        icon.setDrawableByLayerId(R.id.ic_badge, badge);
    }





String GET_JSON_DATA_HTTP_URL_Update_shutdown="http://app.thiensurat.co.th/assanee/Update_shutdown2.php";
    public void select_status_Update_shutdown() {

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_Update_shutdown,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.e("response", String.valueOf(response));
                        JSON_PARSE_DATA_AFTER_WEBCALL_Update_shutdown(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        try {
            try {
                requestQueue = Volley.newRequestQueue(this);
                requestQueue.add(jsonArrayRequest);

                int MY_SOCKET_TIMEOUT_MS=10000;

                jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(
                        MY_SOCKET_TIMEOUT_MS,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            }
            catch (RuntimeException ex){

            }
        }
        catch (OutOfMemoryError EX){

        }

    }

    public void JSON_PARSE_DATA_AFTER_WEBCALL_Update_shutdown(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                 Update_shutdown=json.getString("Update_shutdown");
                Update_shutdown_details=json.getString("Update_shutdown_details");

                latestVersionCode=json.getString("latestVersionCode");
                url=json.getString("url");
                releaseNotes=json.getString("releaseNotes");

                Log.e("Update_shutdown",Update_shutdown);

            } catch (JSONException e) {

                e.printStackTrace();
            }

        }


Log.e("latestVersionCode",latestVersionCode);




        try {
            if(Update_shutdown.equals("1")){
                SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE);
                sweetAlertDialog.setTitleText("ปิดปรับปรุงระบบ!");
                sweetAlertDialog.setContentText("ภายใน"+Update_shutdown_details+"* ขออภัย *");
                //sweetAlertDialog.setCancelText("ไม่! ออก");
                sweetAlertDialog.setConfirmText("OK! ปิดแอฟ");
                sweetAlertDialog.setCancelable(false);
                sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {


                        Log.e("dialog", "ปิด dialog");
                        sDialog.dismissWithAnimation();
                        finish();

                    }
                });
                sweetAlertDialog.show();

            }
            else if(!latestVersionCode.equals(version_code)){
/*                SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE);
                sweetAlertDialog.setTitleText("มีการอัพเดทไหม่!");
                sweetAlertDialog.setContentText(releaseNotes);
                sweetAlertDialog.setCancelText("ไม่! ออก");
                sweetAlertDialog.setConfirmText("OK! อัพเดท");
                sweetAlertDialog.setCancelable(false);
                sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {


                        Intent intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse(url));
                        // startActivity(intent);
                        startActivityForResult(intent, 10);

                    }
                });
                sweetAlertDialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        Log.e("dialog", "ปิด dialog");
                        sweetAlertDialog.dismissWithAnimation();
                        finish();
                    }
                });
                sweetAlertDialog.show();*/
            }


            else {

            }

        }
        catch (Exception ex){

        }



    }








    String row_all1="",row_all2="",row_all3="",row_all4="",page="",page2="",page3="";
    String GET_JSON_DATA_HTTP_URL_number_page1 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_number_page.php";

    String GET_JSON_DATA_HTTP_URL_number_page1_add = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_number_page_add.php";

    String GET_JSON_DATA_HTTP_URL_number_page2 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_number_page_no.php";
    String GET_JSON_DATA_HTTP_URL_number_page3 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_number_page_yes.php";
    String GET_JSON_DATA_HTTP_URL_number_page4 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_number_page_checker_for_credit.php";

    public void JSON_DATA_WEB_CALL_number_page() {

        String user_code= MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

        //  jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL+"?user_code="+user_code ,
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_number_page1+"?user_code="+user_code  ,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {



                        JSON_PARSE_DATA_AFTER_WEBCALL_number_page(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        JSON_DATA_WEB_CALL_number_page();
                    }
                });

        try {
            try {
                requestQueue = Volley.newRequestQueue(this);
                requestQueue.add(jsonArrayRequest);

                int MY_SOCKET_TIMEOUT_MS=100000;

                jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(
                        MY_SOCKET_TIMEOUT_MS,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            }
            catch (RuntimeException ex){

            }
        }
        catch (OutOfMemoryError EX){

        }

    }




    public void JSON_PARSE_DATA_AFTER_WEBCALL_number_page(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {


            JSONObject json = null;
            try {

                json = array.getJSONObject(i);
                row_all1=json.getString("row_all");
                page=json.getString("page");

            } catch (JSONException e) {

                e.printStackTrace();
            }


        }


        da_add_1= Integer.parseInt(row_all1);
        da_add_3=da_add_2+da_add_1;
         DA= String.valueOf(da_add_3);


        Log.e("DA",DA);

        try {



            MyApplication.getInstance().getPrefManager().setPreferrence("DA_DA", DA);
            MyApplication.getInstance().getPrefManager().setPreferrence("page1", page);

            if((DA.equals("null"))|(DA.equals("0"))){
                nav_sale1.setText("");
                nav_sale1.setBackgroundResource(0);
            }
            else {
                nav_sale1.setGravity(Gravity.CENTER);
                nav_sale1.setTypeface(null, Typeface.BOLD);
                nav_sale1.setTextColor(getResources().getColor(R.color.black));
                nav_sale1.setText(DA);
                nav_sale1.setBackgroundResource(R.drawable.bg_circle4);
            }
        }
        catch (Exception ex){

        }


    }









    public void JSON_DATA_WEB_CALL_number_page_add() {

        String user_code= MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

        //  jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL+"?user_code="+user_code ,

        //Log.e("page1_add",GET_JSON_DATA_HTTP_URL_number_page1_add+"?user_code="+user_code);
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_number_page1_add+"?user_code="+user_code  ,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {



                        JSON_PARSE_DATA_AFTER_WEBCALL_number_page_add(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        JSON_DATA_WEB_CALL_number_page_add();
                    }
                });

        try {
            try {
                requestQueue = Volley.newRequestQueue(this);
                requestQueue.add(jsonArrayRequest);

                int MY_SOCKET_TIMEOUT_MS=100000;

                jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(
                        MY_SOCKET_TIMEOUT_MS,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            }
            catch (RuntimeException ex){

            }
        }
        catch (OutOfMemoryError EX){

        }

    }



String row_all1_add="",page_add="";
    public void JSON_PARSE_DATA_AFTER_WEBCALL_number_page_add(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {


            JSONObject json = null;
            try {

                json = array.getJSONObject(i);
                row_all1_add=json.getString("row_all");
                page_add=json.getString("page");

            } catch (JSONException e) {

                e.printStackTrace();
            }


        }

       // row_all1_add=row_all1_add;
        da_add_2= Integer.parseInt(row_all1_add);
       Log.e("da_add_2", String.valueOf(da_add_2));

        da_add_3=da_add_2+da_add_1;
        DA= String.valueOf(da_add_3);


        try {



            MyApplication.getInstance().getPrefManager().setPreferrence("DA_DA", DA);
            MyApplication.getInstance().getPrefManager().setPreferrence("page1", page);

            if((DA.equals("null"))|(DA.equals("0"))){
                nav_sale1.setText("");
                nav_sale1.setBackgroundResource(0);
            }
            else {
                nav_sale1.setGravity(Gravity.CENTER);
                nav_sale1.setTypeface(null, Typeface.BOLD);
                nav_sale1.setTextColor(getResources().getColor(R.color.black));
                nav_sale1.setText(DA);
                nav_sale1.setBackgroundResource(R.drawable.bg_circle4);
            }
        }
        catch (Exception ex){

        }

    }








    public void JSON_DATA_WEB_CALL_number_page2() {

        String user_code= MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

        //  jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL+"?user_code="+user_code ,
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_number_page2+"?user_code="+user_code  ,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {



                        JSON_PARSE_DATA_AFTER_WEBCALL_number_page2(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        JSON_DATA_WEB_CALL_number_page2();
                    }
                });

        try {
            try {
                requestQueue = Volley.newRequestQueue(this);
                requestQueue.add(jsonArrayRequest);

                int MY_SOCKET_TIMEOUT_MS=100000;

                jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(
                        MY_SOCKET_TIMEOUT_MS,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            }
            catch (RuntimeException ex){

            }
        }
        catch (OutOfMemoryError EX){

        }

    }




    public void JSON_PARSE_DATA_AFTER_WEBCALL_number_page2(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {


            JSONObject json = null;
            try {

                json = array.getJSONObject(i);
                row_all2=json.getString("row_all");
                page2=json.getString("page");

            } catch (JSONException e) {

                e.printStackTrace();
            }


        }

        da_no4_1= Integer.parseInt(row_all2);
        da_no4_3=da_no4_2+da_no4_1;
        DA2= String.valueOf(da_no4_3);
        Log.e("DA2",DA2);

        try {
            MyApplication.getInstance().getPrefManager().setPreferrence("DA_DA2", DA2);
            MyApplication.getInstance().getPrefManager().setPreferrence("page2", page2);
            if((DA2.equals("null"))|(DA2.equals("0"))){
                nav_sale2.setText("");
                nav_sale2.setBackgroundResource(0);
            }
            else {
                nav_sale2.setGravity(Gravity.CENTER);
                nav_sale2.setTypeface(null, Typeface.BOLD);
                nav_sale2.setTextColor(getResources().getColor(R.color.blue));
                nav_sale2.setText(DA2);
                nav_sale2.setBackgroundResource(R.drawable.bg_circle4);
            }

        }
        catch (Exception ex){

        }


    }







    public void JSON_DATA_WEB_CALL_number_page3() {

        String user_code= MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

        //  jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL+"?user_code="+user_code ,
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_number_page3+"?user_code="+user_code  ,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {



                        JSON_PARSE_DATA_AFTER_WEBCALL_number_page3(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        JSON_DATA_WEB_CALL_number_page3();
                    }
                });

        try {
            try {
                requestQueue = Volley.newRequestQueue(this);
                requestQueue.add(jsonArrayRequest);

                int MY_SOCKET_TIMEOUT_MS=100000;

                jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(
                        MY_SOCKET_TIMEOUT_MS,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            }
            catch (RuntimeException ex){

            }
        }
        catch (OutOfMemoryError EX){

        }

    }




    public void JSON_PARSE_DATA_AFTER_WEBCALL_number_page3(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {


            JSONObject json = null;
            try {

                json = array.getJSONObject(i);
                row_all3=json.getString("row_all");
                page3=json.getString("page");

            } catch (JSONException e) {

                e.printStackTrace();
            }


        }

        //DA3=row_all3;
        Log.e("row_all3",row_all3);
        da3_1= Integer.parseInt(row_all3);


        da3_3=da3_2+da3_1;
        DA3= String.valueOf(da3_3);

        try {
            MyApplication.getInstance().getPrefManager().setPreferrence("DA_DA3", DA3);
            MyApplication.getInstance().getPrefManager().setPreferrence("page3", page3);
            if((DA3.equals("null"))|(DA3.equals("0"))){
                nav_sale3.setText("");
                nav_sale3.setBackgroundResource(0);
            }
            else {
                nav_sale3.setGravity(Gravity.CENTER);
                nav_sale3.setTypeface(null,Typeface.BOLD);
                nav_sale3.setTextColor(getResources().getColor(R.color.colorPrimary));
                nav_sale3.setText(DA3);
                nav_sale3.setBackgroundResource(R.drawable.bg_circle4);

            }
        }
        catch (Exception ex){

        }



    }






    public void JSON_DATA_WEB_CALL_number_page4() {

        String user_code= MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

        //  jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL+"?user_code="+user_code ,
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_number_page4+"?user_code="+user_code  ,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {



                        JSON_PARSE_DATA_AFTER_WEBCALL_number_page4(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        JSON_DATA_WEB_CALL_number_page4();
                    }
                });

        try {
            try {
                requestQueue = Volley.newRequestQueue(this);
                requestQueue.add(jsonArrayRequest);

                int MY_SOCKET_TIMEOUT_MS=100000;

                jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(
                        MY_SOCKET_TIMEOUT_MS,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            }
            catch (RuntimeException ex){

            }
        }
        catch (OutOfMemoryError EX){

        }

    }




    public void JSON_PARSE_DATA_AFTER_WEBCALL_number_page4(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {


            JSONObject json = null;
            try {

                json = array.getJSONObject(i);
                row_all4=json.getString("row_all");


            } catch (JSONException e) {

                e.printStackTrace();
            }


        }

        DA4=row_all4;

        Log.e("DA4",DA4);









            try {
                MyApplication.getInstance().getPrefManager().setPreferrence("DA_DA4", DA4);
                if((DA4.equals("null"))|(DA4.equals("0"))){
                    nav_sale4.setText("");
                    nav_sale4.setBackgroundResource(0);
                }
                else {
                    nav_sale4.setGravity(Gravity.CENTER);
                    nav_sale4.setTypeface(null,Typeface.BOLD);
                    nav_sale4.setTextColor(getResources().getColor(R.color.Yellow));
                    nav_sale4.setText(DA4);
                    nav_sale4.setBackgroundResource(R.drawable.bg_circle4);

                }
            }
            catch (Exception ex){

            }


    }


    public void JSON_DATA_WEB_CALL_number_page3_2() {

        String user_code= MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

        //  jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL+"?user_code="+user_code ,
        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_number_page_YES2+"?user_code="+user_code  ,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {



                        JSON_PARSE_DATA_AFTER_WEBCALL_number_page3_2(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        JSON_DATA_WEB_CALL_number_page3_2();
                    }
                });

        try {
            try {
                requestQueue = Volley.newRequestQueue(this);
                requestQueue.add(jsonArrayRequest);

                int MY_SOCKET_TIMEOUT_MS=100000;

                jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(
                        MY_SOCKET_TIMEOUT_MS,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            }
            catch (RuntimeException ex){

            }
        }
        catch (OutOfMemoryError EX){

        }

    }

    String row_all3_2="",page3_2="";
    public void JSON_PARSE_DATA_AFTER_WEBCALL_number_page3_2(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {


            JSONObject json = null;
            try {

                json = array.getJSONObject(i);
                row_all3_2=json.getString("row_all");
                page3_2=json.getString("page");

            } catch (JSONException e) {

                e.printStackTrace();
            }


        }

        Log.e("row_all3_2",row_all3_2);
        da3_2= Integer.parseInt(row_all3_2);

        //counter.setText(row_all);
        da3_3=da3_2+da3_1;
        DA3= String.valueOf(da3_3);

        try {
            MyApplication.getInstance().getPrefManager().setPreferrence("DA_DA3", DA3);
            MyApplication.getInstance().getPrefManager().setPreferrence("page3", page3);
            if((DA3.equals("null"))|(DA3.equals("0"))){
                nav_sale3.setText("");
                nav_sale3.setBackgroundResource(0);
            }
            else {
                nav_sale3.setGravity(Gravity.CENTER);
                nav_sale3.setTypeface(null,Typeface.BOLD);
                nav_sale3.setTextColor(getResources().getColor(R.color.colorPrimary));
                nav_sale3.setText(DA3);
                nav_sale3.setBackgroundResource(R.drawable.bg_circle4);

            }
        }
        catch (Exception ex){

        }

    }











    public void JSON_DATA_WEB_CALL_number_page_no4() {

        String user_code= MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

        //  jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL+"?user_code="+user_code ,
        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_number_page+"?user_code="+user_code  ,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {



                        JSON_PARSE_DATA_AFTER_WEBCALL_number_page_no4(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        JSON_DATA_WEB_CALL_number_page_no4();
                    }
                });

        try {
            try {
                requestQueue = Volley.newRequestQueue(this);
                requestQueue.add(jsonArrayRequest);

                int MY_SOCKET_TIMEOUT_MS=100000;

                jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(
                        MY_SOCKET_TIMEOUT_MS,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            }
            catch (RuntimeException ex){

            }
        }
        catch (OutOfMemoryError EX){

        }

    }
    String row_all_no4="",page_no4="";
    public void JSON_PARSE_DATA_AFTER_WEBCALL_number_page_no4(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {


            JSONObject json = null;
            try {

                json = array.getJSONObject(i);
                row_all_no4=json.getString("row_all");
                page_no4=json.getString("page");

            } catch (JSONException e) {

                e.printStackTrace();
            }


        }

        da_no4_2= Integer.parseInt(row_all_no4);

        Log.e("da_no4_2", String.valueOf(da_no4_2));
      //  counter.setText(row_all);



        da_no4_3=da_no4_2+da_no4_1;
        DA2= String.valueOf(da_no4_3);
        Log.e("DA2",DA2);

        try {
            MyApplication.getInstance().getPrefManager().setPreferrence("DA_DA2", DA2);
            MyApplication.getInstance().getPrefManager().setPreferrence("page2", page2);
            if((DA2.equals("null"))|(DA2.equals("0"))){
                nav_sale2.setText("");
                nav_sale2.setBackgroundResource(0);
            }
            else {
                nav_sale2.setGravity(Gravity.CENTER);
                nav_sale2.setTypeface(null, Typeface.BOLD);
                nav_sale2.setTextColor(getResources().getColor(R.color.blue));
                nav_sale2.setText(DA2);
                nav_sale2.setBackgroundResource(R.drawable.bg_circle4);
            }

        }
        catch (Exception ex){

        }

    }



    private final static int REQUEST_CODE_ASK_PERMISSIONS = 1;

    /**
     * Permissions that need to be explicitly requested from end user.
     */
    private static final String[] REQUIRED_SDK_PERMISSIONS = new String[] {
            Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};

    protected void check_permision() {
        final List<String> missingPermissions = new ArrayList<String>();
        // check all required dynamic permissions
        for (final String permission : REQUIRED_SDK_PERMISSIONS) {
            final int result = ContextCompat.checkSelfPermission(this, permission);
            if (result != PackageManager.PERMISSION_GRANTED) {
                missingPermissions.add(permission);
            }
        }
        if (!missingPermissions.isEmpty()) {
            // request all missing permissions
            final String[] permissions = missingPermissions
                    .toArray(new String[missingPermissions.size()]);
            ActivityCompat.requestPermissions(this, permissions, REQUEST_CODE_ASK_PERMISSIONS);

            //openAppSettings();
        } else {
            final int[] grantResults = new int[REQUIRED_SDK_PERMISSIONS.length];
            Arrays.fill(grantResults, PackageManager.PERMISSION_GRANTED);
            onRequestPermissionsResult(REQUEST_CODE_ASK_PERMISSIONS, REQUIRED_SDK_PERMISSIONS,
                    grantResults);
        }
    }



    String TOPIC_PER="";
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                for (int index = permissions.length - 1; index >= 0; --index) {
                    if (grantResults[index] != PackageManager.PERMISSION_GRANTED) {


                        if(permissions[permissions.length - 1].equals("android.permission.ACCESS_FINE_LOCATION")){
                            TOPIC_PER="กรุณาอนุญาตให้ TOSS TICKET CHECKER เข้าถึงตำแหน่งของอุปกรณ์ก่อนเข้าใช้งาน";
                        }
                        else if(permissions[permissions.length - 1].equals("android.permission.CAMERA")){
                            TOPIC_PER="กรุณาอนุญาตให้ TOSS TICKET CHECKER ถ่ายภาพและบันทึกวิดีโอก่อนเข้าใช้งาน";
                        }
                      else  if(permissions[permissions.length - 1].equals("android.permission.WRITE_EXTERNAL_STORAGE")){
                            TOPIC_PER="กรุณาอนุญาตให้ TOSS TICKET CHECKER เข้าถึงรูปภาพ สื่อ และไฟล์บนอุปกรณ์ก่อนเข้าใช้งาน";
                        }


                        showMessage(this,TOPIC_PER);

                        return;
                    }
                }






                break;
        }
    }
   public void openAppSettings() {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", this.getPackageName(), null);
        intent.setData(uri);
       startActivity(intent);


    }







    private void showMessage(Activity activity, String msg) {
        AlertDialog.Builder setupAlert;
        setupAlert = new AlertDialog.Builder(activity)
                .setTitle(activity.getString(R.string.permission_message_title))
                .setMessage(msg)
                .setCancelable(false)
                .setNegativeButton(activity.getString(R.string.permission_message_button), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        openAppSettings();
                    }
                });
        setupAlert.show();
    }





}
