package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities;

/**
 * Created by user on 30/11/2560.
 */

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tsr.tsrproblemreport_tossticket_checker.R;


import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.helper.GetCurrentLocation;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.map.MapsActivity;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_sale_information;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.activity.MainActivity_qr;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.activity.ResultActivity;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.Utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import cn.pedant.SweetAlert.SweetAlertDialog;

import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.ViewPagerAdapter.GET_JSON_DATA_HTTP_URL_IMAGE;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.ViewPagerAdapter.check_image_device1;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.ViewPagerAdapter.check_image_device2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.ViewPagerAdapter.check_image_device3;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.ViewPagerAdapter.image1;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.ViewPagerAdapter.image11;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.ViewPagerAdapter.image2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.ViewPagerAdapter.image22;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.ViewPagerAdapter.image3;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.ViewPagerAdapter.image33;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.ViewPagerAdapter.j;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.activity.ResultActivity.SaleEmployeeName2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.activity.ResultActivity.SaleHeaderName2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.activity.ResultActivity.SaleTeamCode2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.activity.ResultActivity.address2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.activity.ResultActivity.conno_qr;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.activity.ResultActivity.customer2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.activity.ResultActivity.data2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.activity.ResultActivity.data3;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.activity.ResultActivity.date2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.activity.ResultActivity.distance2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.activity.ResultActivity.idcard2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.activity.ResultActivity.latitude2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.activity.ResultActivity.longitude2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.activity.ResultActivity.phone_home2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.activity.ResultActivity.phone_mobile2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.activity.ResultActivity.productname2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.activity.ResultActivity.status2;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.activity.ResultActivity.view_contno_success;


public class Detali_data_cedit extends AppCompatActivity implements OnClickListener {

        public static   ImageView scan,location,camera,camera2,image_device,image_device2,image_location,image_qrcode,my_location,check_mylocation;
        GetData_cedit getData_cedit;
        JsonArrayRequest jsonArrayRequest;
        Intent CamIntent,GalIntent,CropIntent,CropIntent2;
        RequestQueue requestQueue;
        File file;
        Uri uri;
        Bitmap bitmap;
        String filePath = null;
        Bitmap bmplogo=null;
 int positionASA;
    View bottomSheetView;

    String filePath2 = null;
    String encImage;
    String name="",type="",phone="",email="",intro="",logo="",hour="",logo2="";
    JsonArrayRequest jsonArrayRequest2;

    RequestQueue requestQueue2;

    TextView txtname_sale,txt_codeteam,txt_conno,txt_productname,txt_status,txt_customer,txt_idcard,txt_address,txt_phone,txt_date,counter,counter2;

    public  static TextView txtname_sale2,txt_codeteam2,txt_conno2,txt_productname2,txt_status2,txt_customer2,txt_idcard2,txt_address2,txt_phone2,txt_date2,tv_qr_checker,tv_distance_checker,tv_image1_checker,tv_image2_checker,tv_image3_checker;

  public static String from,conno,productname,status,customer,idcard,address,
           phone_home,phone_mobile,date,Latitude,Longitude,RefNo,isremark,SaleEmployeeName="",SaleTeamCode,SaleHeaderName, address_now;

    private Date oneWayTripDate;
    ViewPagerAdapter viewPagerAdapter;
    public static  FloatingActionButton fab;
    String date_new_format_thai;
    String  url2;

    String dateThai_year,dateThai_month,dateThai_day, dateThai_month1;

    ViewPager viewPager,viewPager3;
  public static   LinearLayout sliderDotspanel,sliderDotspanel2,LinearLayout_check,LinearLayout_data1,LinearLayout_data2,LinearLayout_data3,LinearLayout_status,liner1,liner2;
    private int dotscount,dotscount2;
    private ImageView[] dots,dots2;
    View view,view2;
    int converted_dateThai1,converted_dateThai11;
    ScrollView ScrollView1;
Button button5,button5_2,button5_22;
    double d;

    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/cedit_data_qrcode_stratus.php";
    String GET_JSON_DATA_HTTP_URL2 = "http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/insert_check_customer_data2.php";
    String GET_JSON_DATA_HTTP_URL3 = "http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/insert_check_customer_image_camera.php";
    String GET_JSON_DATA_HTTP_URL3_2 = "http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/insert_check_customer_image_camera2.php";
    String GET_JSON_DATA_HTTP_URL5 = "http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/insert_lasttime_view_checkcustomer.php";

    String GET_JSON_DATA_HTTP_URL6 = "http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/uploadphoto_check2.php";
    String GET_JSON_DATA_HTTP_URL7= "http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/insert_check_customer_device_image_by_peebang.php";
    String GET_JSON_DATA_HTTP_URL9= "http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/insert_check_customer_history.php";

    String GET_JSON_DATA_HTTP_URL_DELETE_PRODUCT= "http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/delete_image_device_from_sever.php";
    String GET_JSON_DATA_HTTP_URL_DELETE_IDCARD= "http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/delete_image_idcard_from_sever.php";

    String GET_JSON_DATA_HTTP_URL_UPDATE_LOCATION="http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/insert_check_customer_data2_update_location.php";



    String GET_PROBLEM_OF_SALE="http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/cedit_data_problem_of_sale.php";


    public static String status_qrcode,status_image,status_image2,status_location,distance,salename,teamcode,headname,lat_long;
    Double distance_d;
    String conno3,conno_qr_code,product_name,status3,name_customer2,id_card2,address3,number_phone2,date3,status_app2;

String ImageTypeCode,pathurl,CreateBy;




    public static GetCurrentLocation currentLoc;
    public static String latitude, longitude;



    RecyclerView recyclerView2,recyclerview2_2;
Button button4;
    RecyclerView.LayoutManager recyclerViewlayoutManager2,recyclerViewlayoutManager2_2;


    String GET_JSON_DATA_HTTP_URL4 = "";
    String GET_JSON_DATA_HTTP_URL8="";

    String JSON_ID = "id_ge";
    String JSON_PROBLEM = "topic_problem_ge";

    String JSON_ID2 = "id_add";
    String JSON_PROBLEM2 = "topic_problem_add";

    String JSON_EFFDATE2="date2";



    /********** get data sale of problem ******/
    List<GetData_sale_information> GetDataAdapter1;

    String JSON_EmployeeName="EmployeeName";
    String JSON_PositionCode="PositionCode";
    String JSON_PositionName="PositionName";
    String JSON_TeamHeadCode="TeamHeadCode";
    String JSON_TeamHeadName="TeamHeadName";
    String JSON_TeamName="TeamName";
    String JSON_SupervisorHeadCode="SupervisorHeadCode";
    String JSON_SupervisorHeadName="SupervisorHeadName";
    String JSON_SupervisorName="SupervisorName";
    String JSON_SubDepartmentHeadCode="SubDepartmentHeadCode";
    String JSON_SubDepartmentHeadName="SubDepartmentHeadName";
    String JSON_SubDepartmentName="SubDepartmentName";
    String JSON_DepartmentHeadCode="DepartmentHeadCode";
    String JSON_DepartmentHeadName="DepartmentHeadName";
    String JSON_DepartmentName="DepartmentName";
    String JSON_SubTeamCode="SubTeamCode";
    String JSON_TeamCode="TeamCode";
    String JSON_picture="picture";
    /********** get data sale of problem ******/




    StringBuilder stringBuilder,stringBuilder2,stringBuilder3,stringBuilder4;
    String DADA,DADA2,DADA3;
    StringBuilder kaka;

    String Description="";
    // String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/gethead_problem.php";
    //  String JSON_ID = "id";
    //  String JSON_PROBLEM = "problem";


    SwipeRefreshLayout swipeRefreshLayout;


    JsonArrayRequest jsonArrayRequest3 ;

    RequestQueue requestQueue3 ;
    JsonArrayRequest jsonArrayRequest5 ;
    RequestQueue requestQueue5 ;


    Context context;
    private RelativeLayout relayouttop,relativeLayout,layoutcontent,bn_save,main_container_wrapper;


     Dialog dialog2;

    private FragmentManager fragmentManager;
    private Fragment fragment = null;

/*********/

    private AHBottomNavigationAdapter navigationAdapter;
    private ArrayList<AHBottomNavigationItem> bottomNavigationItems = new ArrayList<>();
    private boolean useMenuResource = true;
    private int[] tabColors;
    private Handler handler = new Handler();

    // UI
    private AHBottomNavigationViewPager viewPager2;
    public static AHBottomNavigation bottomNavigation;
    private FloatingActionButton floatingActionButton;
    /*********/

    CoordinatorLayout coordinatorLayout;
    MenuItem menuItem2,menuItem1,help;

    Double dist = 0.0;
    public static TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boolean enabledTranslucentNavigation = getSharedPreferences("shared", Context.MODE_PRIVATE)
                .getBoolean("translucentNavigation", false);

        setTheme(enabledTranslucentNavigation ? R.style.AppTheme_TranslucentNavigation : R.style.AppTheme);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }



        setContentView(R.layout.check_customer_new);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            scan=(ImageView)findViewById(R.id.scan);
            location=(ImageView)findViewById(R.id.location);
            camera=(ImageView)findViewById(R.id.camera);
        camera2=(ImageView)findViewById(R.id.camera2);
        my_location=(ImageView)findViewById(R.id.my_location);
        check_mylocation=(ImageView)findViewById(R.id.check_mylocation);

        txtname_sale=(TextView)findViewById(R.id.txtname_sale);
        txt_codeteam=(TextView)findViewById(R.id.txt_codeteam);

        txt_conno=(TextView)findViewById(R.id.txt_conno);
        txt_productname=(TextView)findViewById(R.id.txt_productname);
        txt_status=(TextView)findViewById(R.id.txt_status);
        txt_customer=(TextView)findViewById(R.id.txt_customer);
        txt_idcard=(TextView)findViewById(R.id.txt_idcard);
        txt_address=(TextView)findViewById(R.id.txt_address);
        txt_phone=(TextView)findViewById(R.id.txt_phone);
        txt_date=(TextView)findViewById(R.id.txt_date);

        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);
        t4=(TextView)findViewById(R.id.t4);
        t5=(TextView)findViewById(R.id.t5);
        t6=(TextView)findViewById(R.id.t6);
        t7=(TextView)findViewById(R.id.t7);
        t8=(TextView)findViewById(R.id.t8);
        t9=(TextView)findViewById(R.id.t9);
        t10=(TextView)findViewById(R.id.t10);

        counter=(TextView)findViewById(R.id.counter);
        counter2=(TextView)findViewById(R.id.counter2);

        button5=(Button)findViewById(R.id.button5);
        fab=(FloatingActionButton)findViewById(R.id.fab);
        txtname_sale2=(TextView)findViewById(R.id.txtname_sale2);
        txt_codeteam2=(TextView)findViewById(R.id.txt_codeteam2);

        txt_conno2=(TextView)findViewById(R.id.txt_conno2);
        txt_productname2=(TextView)findViewById(R.id.txt_productname2);
        txt_status2=(TextView)findViewById(R.id.txt_status2);
        txt_customer2=(TextView)findViewById(R.id.txt_customer2);
        txt_idcard2=(TextView)findViewById(R.id.txt_idcard2);
        txt_address2=(TextView)findViewById(R.id.txt_address2);
        txt_phone2=(TextView)findViewById(R.id.txt_phone2);
        txt_date2=(TextView)findViewById(R.id.txt_date2);
        button5_2=(Button)findViewById(R.id.button5_2);
        button5_22=(Button)findViewById(R.id.button5_22);

        button5_22.setVisibility(View.GONE);

        LinearLayout_check=(LinearLayout)findViewById(R.id.LinearLayout_check);
        LinearLayout_data1=(LinearLayout)findViewById(R.id.LinearLayout_data1);
        LinearLayout_data2=(LinearLayout)findViewById(R.id.LinearLayout_data2);
        LinearLayout_data3=(LinearLayout)findViewById(R.id.LinearLayout_data3);

        liner1=(LinearLayout)findViewById(R.id.liner1);
        liner2=(LinearLayout)findViewById(R.id.liner2);
        layoutcontent=(RelativeLayout)findViewById(R.id.layoutcontent);
        bn_save=(RelativeLayout)findViewById(R.id.bn_save);

        main_container_wrapper=(RelativeLayout)findViewById(R.id.main_container_wrapper);
        coordinatorLayout=(CoordinatorLayout)findViewById(R.id.CoordinatorLayout);
        //view=(View)findViewById(R.id.view);
        view2=(View)findViewById(R.id.view2);
        ScrollView1=(ScrollView)findViewById(R.id.ScrollView);


        image_device=(ImageView)findViewById(R.id.image_device);
        image_device2=(ImageView)findViewById(R.id.image_device2);
        image_location=(ImageView)findViewById(R.id.image_location);
        image_qrcode=(ImageView)findViewById(R.id.image_qrcode);

        tv_qr_checker=(TextView)findViewById(R.id.tv_qr_checker);
        tv_distance_checker=(TextView)findViewById(R.id.tv_distance_checker);

        tv_image1_checker=(TextView)findViewById(R.id.tv_image1_checker);
        tv_image2_checker=(TextView)findViewById(R.id.tv_image2_checker);
        tv_image3_checker=(TextView)findViewById(R.id.tv_image3_checker);


        LinearLayout_status=(LinearLayout)findViewById(R.id.LinearLayout_status);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerview1);
        recyclerview2_2= (RecyclerView) findViewById(R.id.recyclerview2);
        //swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        relativeLayout= (RelativeLayout) findViewById(R.id.relativeLayout);
        recyclerView2.setHasFixedSize(true);
        recyclerview2_2.setHasFixedSize(true);

        recyclerViewlayoutManager2 = new LinearLayoutManager(context);
        recyclerViewlayoutManager2_2 = new LinearLayoutManager(context);

        recyclerView2.setLayoutManager(recyclerViewlayoutManager2);
        recyclerview2_2.setLayoutManager(recyclerViewlayoutManager2_2);
        //GET_JSON_DATA_HTTP_URL8 = "http://app.thiensurat.co.th/assanee/getsp.php";
        //GET_JSON_DATA_HTTP_URL4 = "http://app.thiensurat.co.th/assanee/group_problem.php";
        GET_JSON_DATA_HTTP_URL4 = "http://app.thiensurat.co.th/assanee/groud_problem_genaral.php";
        GET_JSON_DATA_HTTP_URL8 = "http://app.thiensurat.co.th/assanee/groud_problem_add.php";
        Description="001 ไม่ส่งสัญญา,002 ไม่ส่งใบเสร็จ,003 ไม่ส่งเครื่องเทิร์น,004 ไม่มีสำเนาบัตร,005 สำเนาบัตรไม่ชัด,006 สำเนาบัตรหมดอายุ ไม่เกิน 2 ปี,007 สำเนาบัตรหมดอายุ เกิน 2 ปี,008 สัญญามีการแก้ไข,009 เปลี่ยนราคา,010 ลายเซ็นลูกค้าไม่ต้องกับสำเนาบัตร,011 สัญญาไม่มีลายเซ็นลูกค้า,012 สัญญาไม่มีลายเซ็นพยาน,013 สัญญาไม่มีแผนที่,014 การ์ดไม่มีแผนที่,015 ไม่มีภาพถ่าย,016 ภาพถ่ายไม่ชัด,017 ภาพถ่ายไม่มีลายเซ็นซุปฯ,018 รายละเอียดเพิ่มเติม ประเภทที่อยู่อาศัย,019 รายละเอียดเพิ่มเติม อาชีพ,020 รายละเอียดเพิ่มเติม งานอดิเรก,021 มีประวัติถอดเครื่อง,022 มีประวัติหนี้สูญ,023 มีประวัติผ่อนสินค้า,024 แผนที่ Google Map ไม่ชัด,025 ไม่มีข้อมูลลูกค้าเพิ่มเติม";
        relativeLayout.setVisibility(View.GONE);






        //fragmentManager = getSupportFragmentManager();
      //  final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
     //   fragment = new UI_CARDVIEW_DATA_CEDIT();
        // fragment = new MainActivity2();

        // fragment = new GenerateFragment();

     //   setTitle("ตรวจสอบลูกค้า");

//        fragmentTransaction.replace(R.id.main_container_wrapper, fragment);
//        fragmentTransaction.commit();








        ScrollView1.setOnClickListener(this);



        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager3 = (ViewPager) findViewById(R.id.viewPager2);
        sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);

        sliderDotspanel2 = (LinearLayout) findViewById(R.id.SliderDots2);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        ViewPagerAdapter_check_new viewPagerAdapter_check_new = new ViewPagerAdapter_check_new(this);
           scan.setOnClickListener(this);
           location.setOnClickListener(this);
            camera.setOnClickListener(this);
        camera2.setOnClickListener(this);
            button5.setOnClickListener(this);
            button5_2.setOnClickListener(this);
            fab.setOnClickListener(this);
        image_device.setOnClickListener(this);
        image_device2.setOnClickListener(this);
        image_location.setOnClickListener(this);
        image_qrcode.setOnClickListener(this);

        my_location.setOnClickListener(this);
        check_mylocation.setOnClickListener(this);


        currentLoc = new GetCurrentLocation(this);

        Bundle data=getIntent().getExtras();
        if(data!=null)
        {
           // from=data.getString("from");
            conno=data.getString("conno");
            RefNo=data.getString("RefNo");
            isremark=data.getString("isremark");

            SaleEmployeeName=data.getString("SaleEmployeeName");
            SaleTeamCode=data.getString("SaleTeamCode");
            SaleHeaderName=data.getString("SaleHeaderName");

            productname=data.getString("productname");
            status=data.getString("status");
            customer=data.getString("customer");
            idcard=data.getString("idcard");
            address=data.getString("address");
            phone_home=data.getString("phone_home");
            phone_mobile=data.getString("phone_mobile");
            date=data.getString("date");

            Latitude=data.getString("Latitude");
            Longitude=data.getString("Longitude");


            status_qrcode=data.getString("status_qrcode");

            distance=data.getString("distance");

            salename=data.getString("salename");
            teamcode=data.getString("teamcode");
            headname=data.getString("headname");
            lat_long=data.getString("lat_long");


            conno3=data.getString("conno2");
            conno_qr_code=data.getString("conno_qr_code");
            product_name=data.getString("product_name");
            status3=data.getString("status2");
            name_customer2=data.getString("name_customer");
            id_card2=data.getString("id_card");
            address3=data.getString("address2");
            number_phone2=data.getString("number_phone");
            date3=data.getString("date2");
            status_app2=data.getString("status_app");
try {
    Log.e("from",from);
}
catch (Exception ex){

}


            MyApplication.getInstance().getPrefManager().setPreferrence("conno_qr", conno);
            MyApplication.getInstance().getPrefManager().setPreferrence("RefNo_all", RefNo);
            MyApplication.getInstance().getPrefManager().setPreferrence("Latitude", Latitude);
            MyApplication.getInstance().getPrefManager().setPreferrence("Longitude", Longitude);
            MyApplication.getInstance().getPrefManager().setPreferrence("address", address);

            txtname_sale.setText(SaleEmployeeName);
            txt_codeteam.setText(SaleTeamCode);
            txt_conno.setText(conno);
            txt_productname.setText(productname);
            try {
                if(status.equals("อนุมัติ Assign ")){
                    txt_status.setText("รอตรวจสอบ");
                }
            }
            catch (Exception ex){

            }



            txt_customer.setText(customer);
            txt_idcard.setText(idcard);
            txt_address.setText(address);
            txt_phone.setText(phone_mobile+" , "+phone_home);





                try {
                    if(status_qrcode.equals("1")) {
                        tv_qr_checker.setBackgroundResource(R.drawable.roun_rect_orange9);
                        tv_qr_checker.setText("ตรวจสอบแล้ว");
                    }
                    else {
                        tv_qr_checker.setBackgroundResource(R.drawable.roun_rect_orange11);
                        tv_qr_checker.setText("not done");
                    }

                    if(!distance.equals("null")) {
                        tv_distance_checker.setBackgroundResource(R.drawable.roun_rect_orange10);
                        tv_distance_checker.setText(distance+" km ");
                    }
                    else {
                        tv_distance_checker.setBackgroundResource(R.drawable.roun_rect_orange11);
                        tv_distance_checker.setText("not done");
                    }
                }
                catch (Exception ex){

                }

Log.e("testco",conno+","+conno_qr_code);

                             if(SaleEmployeeName.equals("null")){
                                    if(positionASA==1){
                                        LinearLayout_data3.setVisibility(View.GONE);
                                        LinearLayout_data2.setVisibility(View.VISIBLE);
                                    }
                                    else {
                                        LinearLayout_data3.setVisibility(View.GONE);
                                        LinearLayout_data2.setVisibility(View.GONE);
                                    }

                                 }

                             else {

                                 if (conno.equals(conno_qr_code)) {


                                     LinearLayout_data3.setVisibility(View.GONE);
                                     LinearLayout_data2.setVisibility(View.VISIBLE);
                                 } else {
                                     if (positionASA == 1) {
                                         LinearLayout_data3.setVisibility(View.VISIBLE);
                                         LinearLayout_data2.setVisibility(View.GONE);
                                     } else {
                                         LinearLayout_data3.setVisibility(View.GONE);
                                         LinearLayout_data2.setVisibility(View.GONE);
                                     }

                                 }

                             }





















                button5_2.setVisibility(View.GONE);




            try {
                SimpleDateFormat input22 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat output22 = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    oneWayTripDate = input22.parse(date);  // parse input

                } catch (ParseException e) {
                    e.printStackTrace();
                }


                date_new_format_thai=output22.format(oneWayTripDate);

                Log.e("date_new_format_thai",date_new_format_thai);


                if(date_new_format_thai.indexOf(date_new_format_thai) != -1) {
                    String arr2[] = date_new_format_thai.split("-");
                    dateThai_year=arr2[0];
                    dateThai_month=arr2[1];
                    dateThai_day=arr2[2];


                    converted_dateThai11=Integer.parseInt(dateThai_year);
                    converted_dateThai11=converted_dateThai11+543;

                    if(dateThai_month.equals("01")){dateThai_month1="ม.ค.";}
                    else if(dateThai_month.equals("02")){dateThai_month1="ก.พ.";}
                    else if(dateThai_month.equals("03")){dateThai_month1="มี.ค.";}
                    else if(dateThai_month.equals("04")){dateThai_month1="เม.ย.";}
                    else if(dateThai_month.equals("05")){dateThai_month1="พ.ค.";}
                    else if(dateThai_month.equals("06")){dateThai_month1="มิ.ย.";}
                    else if(dateThai_month.equals("07")){dateThai_month1="ก.ค.";}
                    else if(dateThai_month.equals("08")){dateThai_month1="ส.ค.";}
                    else if(dateThai_month.equals("09")){dateThai_month1="ก.ย.";}
                    else if(dateThai_month.equals("10")){dateThai_month1="ต.ค.";}
                    else if(dateThai_month.equals("11")){dateThai_month1="พ.ย.";}
                    else if(dateThai_month.equals("12")){dateThai_month1="ธ.ค.";}



                    txt_date.setText(dateThai_day+" "+dateThai_month1+converted_dateThai11);
                    Log.e("dateThai",dateThai_day+""+dateThai_month1+""+converted_dateThai11+"");
                }
            }
            catch (Exception ex){

            }






            try {
                d=Double.valueOf(distance);
            }
            catch (Exception ex){
                d= ResultActivity.dist;
            }


            try {
                if((Latitude.equals("0"))&(Longitude.equals("0"))) {
                    check_mylocation.setBackgroundResource(R.drawable.icon_error);
                }
                else {

                    if (d < 0.5) {
                        check_mylocation.setBackgroundResource(R.drawable.icon_error);
                    }  else {
                        check_mylocation.setBackgroundResource(R.drawable.icon_success);
                    }
                }
            }
            catch (Exception ex){

            }












            JSON_DATA_WEB_CALL_update_lasttime();



            main_container_wrapper.setVisibility(View.GONE);

            fragmentManager = getSupportFragmentManager();
            final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            //fragment = new UI_CARDVIEW_DATA_CEDIT();
            fragment = new LibraryFragment_problem();
            // fragment = new MainActivity2();

            // fragment = new GenerateFragment();

            setTitle("ตรวจสอบลูกค้า");

            fragmentTransaction.replace(R.id.main_container_wrapper, fragment);
            fragmentTransaction.commit();

        }










        viewPager.setAdapter(viewPagerAdapter);

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });






        viewPager3.setAdapter(viewPagerAdapter_check_new);

        dotscount2 = viewPagerAdapter_check_new.getCount();
        dots2 = new ImageView[dotscount2];

        for(int i = 0; i < dotscount2; i++){

            dots2[i] = new ImageView(this);
            dots2[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot2));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel2.addView(dots2[i], params);

        }

        dots2[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot2));

        viewPager3.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotscount2; i++){
                    dots2[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot2));
                }

                dots2[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot2));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });




        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);

        Timer timer2 = new Timer();
        timer2.scheduleAtFixedRate(new MyTimerTask2(), 2000, 4000);

        initUI();

        /**** load data sale  ****/
        INSENT_select_data_sale();
        /**** load data sale  ****/

    }

    BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {
        @Override
        public void onStateChanged(@NonNull View bottomSheet, int newState) {

        }

        @Override
        public void onSlide(@NonNull View bottomSheet, float slideOffset) {

        }
    };
    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            Detali_data_cedit.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(viewPager.getCurrentItem() == 0){
                        viewPager.setCurrentItem(1);
                    } else if(viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);
                    }
                  //  else if(viewPager.getCurrentItem() == 2){
                   //     viewPager.setCurrentItem(3);
                  //  }
                    else {
                        viewPager.setCurrentItem(0);
                    }

                }
            });

        }
    }

    public class MyTimerTask2 extends TimerTask {

        @Override
        public void run() {

            Detali_data_cedit.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(viewPager3.getCurrentItem() == 0){
                        viewPager3.setCurrentItem(1);
                    } else if(viewPager3.getCurrentItem() == 1){
                        viewPager3.setCurrentItem(2);
                    }
                    //  else if(viewPager.getCurrentItem() == 2){
                    //     viewPager.setCurrentItem(3);
                    //  }
                    else {
                        viewPager3.setCurrentItem(0);
                    }

                }
            });

        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    LinearLayout_check.setVisibility(View.GONE);
                    viewPager.setVisibility(View.VISIBLE);
                    sliderDotspanel.setVisibility(View.VISIBLE);
                    view2.setVisibility(View.GONE);
                    button5.setVisibility(View.GONE);
                    LinearLayout_data1.setVisibility(View.VISIBLE);
                    LinearLayout_data2.setVisibility(View.GONE);

                    return true;
                case R.id.navigation_dashboard:
                    //mTextMessage.setText(R.string.title_dashboard);
                    LinearLayout_check.setVisibility(View.VISIBLE);
                    viewPager.setVisibility(View.GONE);
                    sliderDotspanel.setVisibility(View.GONE);

                    view2.setVisibility(View.VISIBLE);
                    button5.setVisibility(View.VISIBLE);
                    LinearLayout_data1.setVisibility(View.GONE);
                    LinearLayout_data2.setVisibility(View.VISIBLE);
                    return true;

                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_notifications);



                    return true;
            }
            return false;
        }
    };




    @Override
    protected void onStart() {
        super.onStart();
        currentLoc.connectGoogleApi();
    }

    @Override
    protected void onStop() {
        super.onStop();
        currentLoc.disConnectGoogleApi();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }

    private void changeFragment(int position) {

        Fragment newFragment = null;

        if (position == 0) {
           // fragment = new UI_CARDVIEW_DATA_CEDIT();

        } else if (position % 2 != 0) {
           // fragment = new UI_CARDVIEW_DATA_CEDIT();
        } else {
            fragment = new SimpleTabsActivity();

        }
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_container_wrapper, fragment);
        transaction.commit();



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

/*
            if(PositionCode.equals("Cedit")){
                tabColors = getApplicationContext().getResources().getIntArray(R.array.tab_colors);
                navigationAdapter = new AHBottomNavigationAdapter(this, R.menu.bottom_navigation_menu_3);
                navigationAdapter.setupWithBottomNavigation(bottomNavigation, tabColors);
                bottomNavigation.setBackgroundResource(R.color.colorPrimary);
            }

           else if(PositionCode.equals("Sale")){
                tabColors = getApplicationContext().getResources().getIntArray(R.array.tab_colors);
                navigationAdapter = new AHBottomNavigationAdapter(this, R.menu.bottom_navigation_menu_3);
                navigationAdapter.setupWithBottomNavigation(bottomNavigation, tabColors);
                bottomNavigation.setBackgroundResource(R.color.colorPrimary);

            }
            */


        } else {




        }


        bottomNavigation.manageFloatingActionButtonBehavior(floatingActionButton);
        bottomNavigation.setTranslucentNavigationEnabled(true);

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                positionASA=position;


                if (position == 0) {
                    main_container_wrapper.setVisibility(View.GONE);
                    coordinatorLayout.setVisibility(View.GONE);
                    Log.e("1111","1111");
                    LinearLayout_check.setVisibility(View.GONE);
                    viewPager.setVisibility(View.VISIBLE);
                    sliderDotspanel.setVisibility(View.VISIBLE);
                    view2.setVisibility(View.GONE);
                    button5_2.setVisibility(View.GONE);
                    LinearLayout_data1.setVisibility(View.VISIBLE);
                    LinearLayout_data2.setVisibility(View.GONE);
                    LinearLayout_data3.setVisibility(View.GONE);
                    liner1.setVisibility(View.VISIBLE);
                    liner2.setVisibility(View.VISIBLE);
                    bn_save.setVisibility(View.GONE);
                    menuItem2.setVisible(false);
                    menuItem1.setVisible(true);

                    layoutcontent.setVisibility(View.VISIBLE);
                    viewPager3.setVisibility(View.GONE);
                    sliderDotspanel2.setVisibility(View.GONE);
                    recyclerView2.setVisibility(View.GONE);
                    recyclerview2_2.setVisibility(View.GONE);
                    counter.setVisibility(View.GONE);
                    counter2.setVisibility(View.GONE);

                   // changeFragment(0);
                }
                else if (position == 1) {
                    main_container_wrapper.setVisibility(View.GONE);
                    coordinatorLayout.setVisibility(View.GONE);
                    Log.e("2222", "2222");

                    LinearLayout_check.setVisibility(View.VISIBLE);
                    viewPager.setVisibility(View.GONE);
                    sliderDotspanel.setVisibility(View.GONE);

                    view2.setVisibility(View.VISIBLE);
                    button5_2.setVisibility(View.GONE);
                    LinearLayout_data1.setVisibility(View.GONE);
                    LinearLayout_data2.setVisibility(View.VISIBLE);
                   // LinearLayout_data3.setVisibility(View.VISIBLE);





                    if(view_contno_success==0){
                        LinearLayout_data3.setVisibility(View.VISIBLE);
                        LinearLayout_data2.setVisibility(View.GONE);
                    }
                    else {


                        if (conno_qr_code.equals("null")) {
                            if (positionASA == 1) {
                                LinearLayout_data3.setVisibility(View.GONE);
                                LinearLayout_data2.setVisibility(View.VISIBLE);


                            } else {
                                LinearLayout_data3.setVisibility(View.GONE);
                                LinearLayout_data2.setVisibility(View.GONE);
                            }


                            txtname_sale2.setText("");
                            txt_codeteam2.setText("");

                            txt_conno2.setText("");
                            txt_productname2.setText("");
                            txt_status2.setText("");
                            txt_customer2.setText("");
                            txt_idcard2.setText("");
                            txt_address2.setText("");
                            txt_phone2.setText("");
                            txt_date2.setText("");
                            fab.setVisibility(View.GONE);


                        } else {

                            if (conno.equals(conno_qr_code)) {


                                LinearLayout_data3.setVisibility(View.GONE);
                                LinearLayout_data2.setVisibility(View.VISIBLE);
                            } else {
                                if (positionASA == 1) {
                                    LinearLayout_data3.setVisibility(View.VISIBLE);
                                    LinearLayout_data2.setVisibility(View.GONE);
                                } else {
                                    LinearLayout_data3.setVisibility(View.GONE);
                                    LinearLayout_data2.setVisibility(View.GONE);
                                }

                            }


                            txtname_sale2.setText(salename);
                            txt_codeteam2.setText(teamcode);

                            txt_conno2.setText(conno_qr_code);
                            txt_productname2.setText(product_name);
                            txt_status2.setText(status3);
                            txt_customer2.setText(name_customer2);
                            txt_idcard2.setText(id_card2);
                            txt_address2.setText(address3);
                            txt_phone2.setText(number_phone2);
                            txt_date2.setText(date3);
                            fab.setVisibility(View.VISIBLE);


                            if ((status_qrcode.equals("1")) & (conno_qr_code.equals(conno))) {
                                image_qrcode.setBackgroundResource(R.drawable.icon_success);
                                txt_status2.setText("เลขที่สัญญาถูกต้อง");
                                txt_status2.setTextColor(0xff26ae90);
                                //  LinearLayout_status.setBackgroundColor(0xffFFFFFF);
                            } else {
                                image_qrcode.setBackgroundResource(R.drawable.icon_error);
                                txt_status2.setText("เลขที่สัญญาไม่ตรงกัน");
                                txt_status2.setTextColor(0xffF63D2B);
                                // LinearLayout_status.setBackgroundColor(0xffF63D2B);
                            }

                        }
                    }






                    //LinearLayout_data2.setVisibility(View.VISIBLE);

                   // LinearLayout_data3.setVisibility(View.VISIBLE);

                    liner1.setVisibility(View.VISIBLE);
                    liner2.setVisibility(View.VISIBLE);
                    bn_save.setVisibility(View.VISIBLE);

                    menuItem2.setVisible(true);
                    menuItem1.setVisible(true);
                    layoutcontent.setVisibility(View.VISIBLE);
                    recyclerView2.setVisibility(View.GONE);
                    recyclerview2_2.setVisibility(View.GONE);
                    counter.setVisibility(View.GONE);
                    counter2.setVisibility(View.GONE);

                    try {
                        String see_image = MyApplication.getInstance().getPrefManager().getPreferrence("image_slider");
                        if(see_image.equals("1")){
                            viewPager3.setVisibility(View.VISIBLE);
                            sliderDotspanel2.setVisibility(View.VISIBLE);
                            LinearLayout_check.setVisibility(View.GONE);
                            menuItem2.setIcon(R.drawable.icon_check);
                        }else {
                            viewPager3.setVisibility(View.GONE);
                            sliderDotspanel2.setVisibility(View.GONE);
                            LinearLayout_check.setVisibility(View.VISIBLE);
                            menuItem2.setIcon(R.drawable.image_slider);
                        }
                    }
                    catch (Exception ex){

                    }



                    LinearLayout_data1.setVisibility(View.GONE);
                    //changeFragment(1);
                }

                else {
                    /*
                    LinearLayout_check.setVisibility(View.GONE);
                    viewPager.setVisibility(View.GONE);
                    sliderDotspanel.setVisibility(View.GONE);
                    LinearLayout_data1.setVisibility(View.GONE);
                    LinearLayout_data2.setVisibility(View.GONE);
                    LinearLayout_data3.setVisibility(View.GONE);
                    layoutcontent.setVisibility(View.GONE);
                    liner1.setVisibility(View.GONE);
                    liner2.setVisibility(View.GONE);
                    bn_save.setVisibility(View.GONE);

                    recyclerView2.setVisibility(View.VISIBLE);
                    recyclerview2_2.setVisibility(View.VISIBLE);
                    counter.setVisibility(View.VISIBLE);
                    counter2.setVisibility(View.VISIBLE);
                    JSON_DATA_WEB_CALL2();
                    JSON_DATA_WEB_CALL3();
                    */
                    LinearLayout_check.setVisibility(View.GONE);
                    viewPager.setVisibility(View.GONE);
                    sliderDotspanel.setVisibility(View.GONE);
                    LinearLayout_data1.setVisibility(View.GONE);
                    LinearLayout_data2.setVisibility(View.GONE);
                    LinearLayout_data3.setVisibility(View.GONE);
                    layoutcontent.setVisibility(View.GONE);
                    liner1.setVisibility(View.GONE);
                    liner2.setVisibility(View.GONE);
                    bn_save.setVisibility(View.GONE);
                    recyclerView2.setVisibility(View.GONE);
                    recyclerview2_2.setVisibility(View.GONE);
                    counter.setVisibility(View.GONE);
                    counter2.setVisibility(View.GONE);

                    coordinatorLayout.setVisibility(View.VISIBLE);
                    main_container_wrapper.setVisibility(View.VISIBLE);

                    //changeFragment(2);

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
                        .setBackgroundColor(ContextCompat.getColor(Detali_data_cedit.this, R.color.color_notification_back))
                        .setTextColor(ContextCompat.getColor(Detali_data_cedit.this, R.color.color_notification_text))
                        .build();

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








        @Override
        public void onClick(View view) {



                          if(view==scan){



                              latitude = currentLoc.latitude;
                              longitude = currentLoc.longitude;
                              getAddress();

                              String adrress = currentLoc.longitude;
                              Log.e("QWQ",latitude+","+longitude);
                              /*
                              if(status_qrcode.equals("1")) {
                                  new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                                          .setTitleText("OK!")
                                          .setContentText("*สแกน QR/BAR แล้ว*")


                                          .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                              @Override
                                              public void onClick(SweetAlertDialog sDialog) {
                                                  sDialog.cancel();
                                                  // finish();
                                              }
                                          })
                                          .show();

                              }
                              else {
                                  Intent Intent = new Intent(this, MainActivity_qr.class);


                                  Bundle bun = new Bundle();
                                  bun.putString("conno", conno);


                                  Intent.putExtras(bun);

                                  startActivityForResult(Intent, 10);
                              }
*/

                              Intent Intent = new Intent(this, MainActivity_qr.class);


                              Bundle bun = new Bundle();
                              bun.putString("conno", conno);


                              Intent.putExtras(bun);

                              startActivityForResult(Intent, 10);


                }





                else if(view==my_location){
                              latitude = currentLoc.latitude;
                              longitude = currentLoc.longitude;

                              getAddress();
                              MyApplication.getInstance().getPrefManager().setPreferrence("address_now", address_now);
                              if(((status_qrcode.equals("1"))&(conno_qr_code.equals(conno)))|(data2.equals(conno_qr))){





                                  try {
                                      d=Double.valueOf(distance);
                                  }
                                  catch (Exception ex){
                                      d= ResultActivity.dist;
                                  }



                                  if (d >= 0.5) {

                                      new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                                              .setTitleText("ตำแหน่งไม่ถูกต้อง")
                                              .setContentText("อัปเดทตำแหน่ง ใช่/ไม่ ?")
                                              .setCancelText("ไม่,ออก!")
                                              .setConfirmText("ไช่,อัปเดท!")
                                              .showCancelButton(true)
                                              .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                  @Override
                                                  public void onClick(SweetAlertDialog sDialog) {
                                                      sDialog.cancel();
                                                  }
                                              })
                                              .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                  @Override
                                                  public void onClick(SweetAlertDialog sDialog) {


                                                      if ((Latitude.equals("0")) & (Longitude.equals("0"))) {
                                                          getDistanceInfo2(address_now, address);
                                                          //JSON_UPDATE_LOCATION();
                                                      } else {
                                                          getDistanceInfo(latitude + "," + longitude, Latitude + "," + Longitude);
                                                          //JSON_UPDATE_LOCATION();
                                                      }

                                                      tv_distance_checker.setBackgroundResource(R.drawable.roun_rect_orange10);
                                                      tv_distance_checker.setText(dist + " km ");
                                                      JSON_UPDATE_LOCATION();

                                                      sDialog.cancel();
                                                  }
                                              })
                                              .show();

                                  }
                                  else {
                                      new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                                              .setTitleText("ตำแหน่งถูกแล้ว")
                                              .setContentText("อัปเดทตำแหน่ง ใช่/ไม่ ?")
                                              .setCancelText("ไม่,ออก!")
                                              .setConfirmText("ไช่,อัปเดท!")
                                              .showCancelButton(true)
                                              .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                  @Override
                                                  public void onClick(SweetAlertDialog sDialog) {
                                                      sDialog.cancel();
                                                  }
                                              })
                                              .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                  @Override
                                                  public void onClick(SweetAlertDialog sDialog) {


                                                      if ((Latitude.equals("0")) & (Longitude.equals("0"))) {
                                                          getDistanceInfo2(address_now, address);
                                                          //JSON_UPDATE_LOCATION();
                                                      } else {
                                                          getDistanceInfo(latitude + "," + longitude, Latitude + "," + Longitude);
                                                          //JSON_UPDATE_LOCATION();
                                                      }

                                                      tv_distance_checker.setBackgroundResource(R.drawable.roun_rect_orange10);
                                                      tv_distance_checker.setText(dist + " km ");
                                                      JSON_UPDATE_LOCATION();

                                                      sDialog.cancel();
                                                  }
                                              })
                                              .show();
                                  }


                              }
                              else if((status_qrcode.equals("1"))&(!conno_qr_code.equals(conno))){
                                  new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                                          .setTitleText("เลขที่สัญญาไม่ถูกต้อง!")
                                          .setContentText("กรุณาลองตรวจสอบอีกครั้ง/แจ้งปัญหา")


                                          .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                              @Override
                                              public void onClick(SweetAlertDialog sDialog) {
                                                  sDialog.cancel();
                                                  // finish();
                                              }
                                          })
                                          .show();

                              }
                              else if(!status_qrcode.equals("1")){

                                  new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                                          .setTitleText("ยังไม่ตรวจสอบ QR CODE /BAE CODE !")
                                          .setContentText("กรุณาสแกน QR CODE /BAE CODE")


                                          .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                              @Override
                                              public void onClick(SweetAlertDialog sDialog) {
                                                  sDialog.cancel();
                                                  // finish();
                                              }
                                          })
                                          .show();







                              }

                          }

                else  if(view==location){
                              if(check_image_device1==3){

/*

                                  new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                                          .setTitleText("รูปภาพยืนยันถูกต้องแล้ว")
                                          .setContentText("คุณต้องการเปลี่ยนรูป ใช่/ไม่!")
                                          .setCancelText("ไม่,ออก!")
                                          .setConfirmText("ไช่,เปลี่ยน!")
                                          .showCancelButton(true)
                                          .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                              @Override
                                              public void onClick(SweetAlertDialog sDialog) {
                                                  sDialog.cancel();
                                              }
                                          })
                                          .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                              @Override
                                              public void onClick(SweetAlertDialog sDialog) {
                                                  Pin_location();

                                                  sDialog.cancel();
                                              }
                                          })
                                          .show();
*/


                                  final Dialog dialog = new Dialog(Detali_data_cedit.this);
                                  dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                                  dialog.setContentView(R.layout.custom_dialog_image_cedit2);
                                  dialog.setCancelable(true);
                                  final ImageView image_map=(ImageView)dialog.findViewById(R.id.image_map);
                                  final ImageView rotage2=(ImageView)dialog.findViewById(R.id.rotage2);
                                  final Button button4=(Button)dialog.findViewById(R.id.button4);
                                  final Button button5=(Button)dialog.findViewById(R.id.button5);

                                  try {
                                      Glide.with(this).load(GET_JSON_DATA_HTTP_URL_IMAGE+image3)



                                              .crossFade()
                                              .thumbnail(0.5f)
                                              // .bitmapTransform(new CircleTransform(context))
                                              .diskCacheStrategy(DiskCacheStrategy.ALL)
                                              .placeholder(this.getResources().getDrawable(R.drawable.no_image_map))
                                              .into(image_map);
                                  }
                                  catch (Exception e) {

                                  }

                                  rotage2.setOnClickListener(new OnClickListener() {

                                      @Override
                                      public void onClick(View view) {
                                          j=j+90;
                                          image_map.setRotation ((float) j);

                                      }
                                  });

                                  button4.setOnClickListener(new OnClickListener() {

                                      @Override
                                      public void onClick(View view) {
                                          dialog.cancel();

                                      }
                                  });



                                  button5.setOnClickListener(new OnClickListener() {

                                      @Override
                                      public void onClick(View view) {
                                          aweet_dialog_image_location();

                                      }
                                  });


                                  dialog.show();








                              }
                              else if(check_image_device1==2){

                                  Log.e("fdad",GET_JSON_DATA_HTTP_URL_IMAGE+image3);
                                  /*
                                  new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                                          .setTitleText("รูปภาพยังไม่ยืนยัน ว่าถูกต้อง!")
                                          .setContentText("คุณต้องการเปลี่ยนรูป ใช่/ไม่!")
                                          .setCancelText("ไม่,ออก!")
                                          .setConfirmText("ไช่,เปลี่ยน!")
                                          .showCancelButton(true)
                                          .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                              @Override
                                              public void onClick(SweetAlertDialog sDialog) {
                                                  sDialog.cancel();
                                              }
                                          })
                                          .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                              @Override
                                              public void onClick(SweetAlertDialog sDialog) {
                                                  Pin_location();

                                                  sDialog.cancel();
                                              }
                                          })
                                          .show();
                                  */
                                  final Dialog dialog = new Dialog(Detali_data_cedit.this);
                                  dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                                  dialog.setContentView(R.layout.custom_dialog_image_cedit2);
                                  dialog.setCancelable(true);
                                  final ImageView image_map=(ImageView)dialog.findViewById(R.id.image_map);
                                  final ImageView rotage2=(ImageView)dialog.findViewById(R.id.rotage2);
                                  final Button button4=(Button)dialog.findViewById(R.id.button4);
                                  final Button button5=(Button)dialog.findViewById(R.id.button5);

                                  try {
                                      Glide.with(this).load(GET_JSON_DATA_HTTP_URL_IMAGE+image3)



                                              .crossFade()
                                              .thumbnail(0.5f)
                                              // .bitmapTransform(new CircleTransform(context))
                                              .diskCacheStrategy(DiskCacheStrategy.ALL)
                                              .placeholder(this.getResources().getDrawable(R.drawable.no_image_map))
                                              .into(image_map);
                                  }
                                  catch (Exception e) {

                                  }

                                  rotage2.setOnClickListener(new OnClickListener() {

                                      @Override
                                      public void onClick(View view) {
                                          j=j+90;
                                          image_map.setRotation ((float) j);

                                      }
                                  });

                                  button4.setOnClickListener(new OnClickListener() {

                                      @Override
                                      public void onClick(View view) {
                                          dialog.cancel();

                                      }
                                  });



                                  button5.setOnClickListener(new OnClickListener() {

                                      @Override
                                      public void onClick(View view) {
                                          aweet_dialog_image_location();

                                      }
                                  });

                                  dialog.show();



                              }
                              else {
                                 Intent Intent = new Intent( this, MapsActivity.class);
                                  startActivityForResult(Intent, 11);
                              }


                }
                else  if(view==camera){
                              if(check_image_device2==3){

                                  /*
                                  new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                                          .setTitleText("รูปภาพยืนยันถูกต้องแล้ว")
                                          .setContentText("คุณต้องการเปลี่ยนรูป ใช่/ไม่!")
                                          .setCancelText("ไม่,ออก!")
                                          .setConfirmText("ไช่,เปลี่ยน!")
                                          .showCancelButton(true)
                                          .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                              @Override
                                              public void onClick(SweetAlertDialog sDialog) {
                                                  sDialog.cancel();
                                              }
                                          })
                                          .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                              @Override
                                              public void onClick(SweetAlertDialog sDialog) {
                                                  CameraOpen();

                                                  sDialog.cancel();
                                              }
                                          })
                                          .show();
                                  */

                                  final Dialog dialog = new Dialog(Detali_data_cedit.this);
                                  dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                                  dialog.setContentView(R.layout.custom_dialog_image_cedit2);
                                  dialog.setCancelable(true);
                                  final ImageView image_map=(ImageView)dialog.findViewById(R.id.image_map);
                                  final ImageView rotage2=(ImageView)dialog.findViewById(R.id.rotage2);
                                  final Button button4=(Button)dialog.findViewById(R.id.button4);
                                  final Button button5=(Button)dialog.findViewById(R.id.button5);

                                  try {
                                      Glide.with(this).load(GET_JSON_DATA_HTTP_URL_IMAGE+image1)



                                              .crossFade()
                                              .thumbnail(0.5f)
                                              // .bitmapTransform(new CircleTransform(context))
                                              .diskCacheStrategy(DiskCacheStrategy.ALL)
                                              .placeholder(this.getResources().getDrawable(R.drawable.no_image_product))
                                              .into(image_map);
                                  }
                                  catch (Exception e) {

                                  }

                                  rotage2.setOnClickListener(new OnClickListener() {

                                      @Override
                                      public void onClick(View view) {
                                          j=j+90;
                                          image_map.setRotation ((float) j);

                                      }
                                  });

                                  button4.setOnClickListener(new OnClickListener() {

                                      @Override
                                      public void onClick(View view) {
                                          dialog.cancel();

                                      }
                                  });



                                  button5.setOnClickListener(new OnClickListener() {

                                      @Override
                                      public void onClick(View view) {
                                          aweet_dialog_image_product();

                                      }
                                  });


                                  dialog.show();


                              }
                              else if(check_image_device2==2){
                                  /*
                                  new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                                          .setTitleText("รูปภาพยังไม่ยืนยัน ว่าถูกต้อง!")
                                          .setContentText("คุณต้องการเปลี่ยนรูป ใช่/ไม่!")
                                          .setCancelText("ไม่,ออก!")
                                          .setConfirmText("ไช่,เปลี่ยน!")
                                          .showCancelButton(true)
                                          .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                              @Override
                                              public void onClick(SweetAlertDialog sDialog) {
                                                  sDialog.cancel();
                                              }
                                          })
                                          .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                              @Override
                                              public void onClick(SweetAlertDialog sDialog) {
                                                  Pin_location();

                                                  sDialog.cancel();
                                              }
                                          })
                                          .show();
                                  */


                                  final Dialog dialog = new Dialog(Detali_data_cedit.this);
                                  dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                                  dialog.setContentView(R.layout.custom_dialog_image_cedit2);
                                  dialog.setCancelable(true);
                                  final ImageView image_map=(ImageView)dialog.findViewById(R.id.image_map);
                                  final ImageView rotage2=(ImageView)dialog.findViewById(R.id.rotage2);
                                  final Button button4=(Button)dialog.findViewById(R.id.button4);
                                  final Button button5=(Button)dialog.findViewById(R.id.button5);

                                  try {
                                      Glide.with(this).load(GET_JSON_DATA_HTTP_URL_IMAGE+image1)



                                              .crossFade()
                                              .thumbnail(0.5f)
                                              // .bitmapTransform(new CircleTransform(context))
                                              .diskCacheStrategy(DiskCacheStrategy.ALL)
                                              .placeholder(this.getResources().getDrawable(R.drawable.no_image_product))
                                              .into(image_map);
                                  }
                                  catch (Exception e) {

                                  }

                                  rotage2.setOnClickListener(new OnClickListener() {

                                      @Override
                                      public void onClick(View view) {
                                          j=j+90;
                                          image_map.setRotation ((float) j);

                                      }
                                  });

                                  button4.setOnClickListener(new OnClickListener() {

                                      @Override
                                      public void onClick(View view) {
                                          dialog.cancel();

                                      }
                                  });



                                  button5.setOnClickListener(new OnClickListener() {

                                      @Override
                                      public void onClick(View view) {
                                          aweet_dialog_image_product();

                                      }
                                  });


                                  dialog.show();






                              }
                              else {
                                  CameraOpen();
                              }
                          }

                          else  if(view==camera2){
                              if(check_image_device3==3){




                                  final Dialog dialog = new Dialog(Detali_data_cedit.this);
                                  dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                                  dialog.setContentView(R.layout.custom_dialog_image_cedit2);
                                  dialog.setCancelable(true);
                                  final ImageView image_map=(ImageView)dialog.findViewById(R.id.image_map);
                                  final ImageView rotage2=(ImageView)dialog.findViewById(R.id.rotage2);
                                  final Button button4=(Button)dialog.findViewById(R.id.button4);
                                  final Button button5=(Button)dialog.findViewById(R.id.button5);

                                  try {
                                      Glide.with(this).load(GET_JSON_DATA_HTTP_URL_IMAGE+image2)



                                              .crossFade()
                                              .thumbnail(0.5f)
                                              // .bitmapTransform(new CircleTransform(context))
                                              .diskCacheStrategy(DiskCacheStrategy.ALL)
                                              .placeholder(this.getResources().getDrawable(R.drawable.no_image_idcard))
                                              .into(image_map);
                                  }
                                  catch (Exception e) {

                                  }

                                  rotage2.setOnClickListener(new OnClickListener() {

                                      @Override
                                      public void onClick(View view) {
                                          j=j+90;
                                          image_map.setRotation ((float) j);

                                      }
                                  });

                                  button4.setOnClickListener(new OnClickListener() {

                                      @Override
                                      public void onClick(View view) {
                                          dialog.cancel();

                                      }
                                  });



                                  button5.setOnClickListener(new OnClickListener() {

                                      @Override
                                      public void onClick(View view) {
                                          aweet_dialog_image_idcard();

                                      }
                                  });


                                  dialog.show();

                              }
                              else if(check_image_device3==2){
                                  /*
                                  new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                                          .setTitleText("รูปภาพยังไม่ยืนยัน ว่าถูกต้อง!")
                                          .setContentText("คุณต้องการเปลี่ยนรูป ใช่/ไม่!")
                                          .setCancelText("ไม่,ออก!")
                                          .setConfirmText("ไช่,เปลี่ยน!")
                                          .showCancelButton(true)
                                          .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                              @Override
                                              public void onClick(SweetAlertDialog sDialog) {
                                                  sDialog.cancel();
                                              }
                                          })
                                          .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                              @Override
                                              public void onClick(SweetAlertDialog sDialog) {
                                                  Pin_location();

                                                  sDialog.cancel();
                                              }
                                          })
                                          .show();
                                          */



                                  final Dialog dialog = new Dialog(Detali_data_cedit.this);
                                  dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                                  dialog.setContentView(R.layout.custom_dialog_image_cedit2);
                                  dialog.setCancelable(true);
                                  final ImageView image_map=(ImageView)dialog.findViewById(R.id.image_map);
                                  final ImageView rotage2=(ImageView)dialog.findViewById(R.id.rotage2);
                                  final Button button4=(Button)dialog.findViewById(R.id.button4);
                                  final Button button5=(Button)dialog.findViewById(R.id.button5);

                                  try {
                                      Glide.with(this).load(GET_JSON_DATA_HTTP_URL_IMAGE+image2)



                                              .crossFade()
                                              .thumbnail(0.5f)
                                              // .bitmapTransform(new CircleTransform(context))
                                              .diskCacheStrategy(DiskCacheStrategy.ALL)
                                              .placeholder(this.getResources().getDrawable(R.drawable.no_image_idcard))
                                              .into(image_map);
                                  }
                                  catch (Exception e) {

                                  }

                                  rotage2.setOnClickListener(new OnClickListener() {

                                      @Override
                                      public void onClick(View view) {
                                          j=j+90;
                                          image_map.setRotation ((float) j);

                                      }
                                  });

                                  button4.setOnClickListener(new OnClickListener() {

                                      @Override
                                      public void onClick(View view) {
                                          dialog.cancel();

                                      }
                                  });



                                  button5.setOnClickListener(new OnClickListener() {

                                      @Override
                                      public void onClick(View view) {
                                          aweet_dialog_image_idcard();

                                      }
                                  });


                                  dialog.show();

                              }
                              else {
                                  CameraOpen2();
                              }


                          }
                else if(view==button5)
                          {
                             // Intent Intent = new Intent( Detali_data_cedit.this, UI_CARDVIEW_CHECKBOX_cedit.class);
                             // startActivity(Intent);

                          }

                else  if(view==ScrollView1)
                         {
               // Intent Intent = new Intent( Detali_data_cedit.this, UI_CARDVIEW_CHECKBOX_cedit.class);
                //startActivity(Intent);
                     Log.e("ss","ddd");
                     }



                          else  if(view==check_mylocation)
                          {





                              if(((status_qrcode.equals("1"))&(conno_qr_code.equals(conno)))|(data2.equals(conno_qr))){





                                  try {
                                      d=Double.valueOf(distance);
                                  }
                                  catch (Exception ex){
                                      d= ResultActivity.dist;
                                  }



                                      if (d >= 0.5) {
                                          new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                                                  .setTitleText("ตำแหน่งไม่ถูกต้อง!")
                                                  .setContentText("รัศมีเกิน 500 เมตร")


                                                  .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                      @Override
                                                      public void onClick(SweetAlertDialog sDialog) {
                                                          sDialog.cancel();
                                                          // finish();
                                                      }
                                                  })
                                                  .show();

                                      }
                                      else {
                                          new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                                                  .setTitleText("OK!")
                                                  .setContentText("ตำแหน่งถูกต้องแล้ว")


                                                  .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                      @Override
                                                      public void onClick(SweetAlertDialog sDialog) {
                                                          sDialog.cancel();
                                                          // finish();
                                                      }
                                                  })
                                                  .show();
                                      }


                              }
                              else if((status_qrcode.equals("1"))&(!conno_qr_code.equals(conno))){
                                  new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                                          .setTitleText("เลขที่สัญญาไม่ถูกต้อง!")
                                          .setContentText("กรุณาลองตรวจสอบอีกครั้ง/แจ้งปัญหา")


                                          .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                              @Override
                                              public void onClick(SweetAlertDialog sDialog) {
                                                  sDialog.cancel();
                                                  // finish();
                                              }
                                          })
                                          .show();

                              }
                              else if(!status_qrcode.equals("1")){

                                  new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                                          .setTitleText("ยังไม่ตรวจสอบ QR CODE /BAE CODE !")
                                          .setContentText("กรุณาสแกน QR CODE /BAE CODE")


                                          .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                              @Override
                                              public void onClick(SweetAlertDialog sDialog) {
                                                  sDialog.cancel();
                                                  // finish();
                                              }
                                          })
                                          .show();







                              }










                          }
                          else  if(view==image_qrcode)
                          {


                                  if(((status_qrcode.equals("1"))&(conno_qr_code.equals(conno)))|(data2.equals(conno_qr))){
                                      new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                                              .setTitleText("OK!")
                                              .setContentText("เลขที่สัญญาถูกต้อง")


                                              .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                  @Override
                                                  public void onClick(SweetAlertDialog sDialog) {
                                                      sDialog.cancel();
                                                      //finish();
                                                  }
                                              })
                                              .show();

                                  }
                                 else if((status_qrcode.equals("1"))&(!conno_qr_code.equals(conno))){
                                      new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                                              .setTitleText("เลขที่สัญญาไม่ถูกต้อง!")
                                              .setContentText("กรุณาลองตรวจสอบอีกครั้ง/แจ้งปัญหา")


                                              .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                  @Override
                                                  public void onClick(SweetAlertDialog sDialog) {
                                                      sDialog.cancel();
                                                      // finish();
                                                  }
                                              })
                                              .show();

                                  }
                                  else if(!status_qrcode.equals("1")){

                                      new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                                              .setTitleText("ยังไม่ตรวจสอบ QR CODE /BAE CODE !")
                                              .setContentText("กรุณาสแกน QR CODE /BAE CODE")


                                              .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                  @Override
                                                  public void onClick(SweetAlertDialog sDialog) {
                                                      sDialog.cancel();
                                                      // finish();
                                                  }
                                              })
                                              .show();







                                  }


                          }
                          else if(view==image_location){

                              if (check_image_device1==1){
                                  new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                                          .setTitleText("ERROR!")
                                          .setContentText("ยังไม่มีรูปภาพ !")


                                          .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                              @Override
                                              public void onClick(SweetAlertDialog sDialog) {
                                                  sDialog.cancel();
                                                  //finish();
                                              }
                                          })
                                          .show();

                              }

                              else if  (check_image_device1==2){
                                  new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                                          .setTitleText("คุณแน่ใจไหม ?")
                                          .setContentText("ที่ต้องการยืนยันรูปภาพ ถูกต้อง !")
                                          .setCancelText("ไม่,ออก!")
                                          .setConfirmText("ไช่,ยืนยัน!")
                                          .showCancelButton(true)
                                          .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                              @Override
                                              public void onClick(SweetAlertDialog sDialog) {
                                                  sDialog.cancel();
                                              }
                                          })
                                          .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                              @Override
                                              public void onClick(SweetAlertDialog sDialog) {
                                                  INSENT_history_confirm_image1();
                                                  image_location.setBackgroundResource(R.drawable.icon_success);
                                                  tv_image1_checker.setBackgroundResource(R.drawable.roun_rect_orange12);
                                                  tv_image1_checker.setText("ตรวจสอบแล้ว");

                                                  sDialog.cancel();
                                              }
                                          })
                                          .show();
                              }

                              else if (check_image_device1==3){
                                  new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                                          .setTitleText("OK!")
                                          .setContentText("ยืนยันรูปภาพถูกต้องแล้ว")


                                          .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                              @Override
                                              public void onClick(SweetAlertDialog sDialog) {
                                                  sDialog.cancel();
                                                  //finish();
                                              }
                                          })
                                          .show();
                              }






                          }
                          else if(view==image_device){

                              if  (check_image_device2==1){
                                  new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)

                                          .setTitleText("ERROR!")
                                          .setContentText("ยังไม่มีรูปภาพ !")


                                          .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                              @Override
                                              public void onClick(SweetAlertDialog sDialog) {
                                                  sDialog.cancel();
                                                  //finish();
                                              }
                                          })
                                          .show();

                              }

                              else if (check_image_device2==2){

                                  new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                                          .setTitleText("คุณแน่ใจไหม ?")
                                          .setContentText("ที่ต้องการยืนยันรูปภาพ ถูกต้อง !")
                                          .setCancelText("ไม่,ออก!")
                                          .setConfirmText("ไช่,ยืนยัน!")
                                          .showCancelButton(true)
                                          .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                              @Override
                                              public void onClick(SweetAlertDialog sDialog) {
                                                  sDialog.cancel();
                                              }
                                          })
                                          .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                              @Override
                                              public void onClick(SweetAlertDialog sDialog) {
                                                  INSENT_history_confirm_image2();
                                                  image_device.setBackgroundResource(R.drawable.icon_success);
                                                  tv_image2_checker.setBackgroundResource(R.drawable.roun_rect_orange12);
                                                  tv_image2_checker.setText("ตรวจสอบแล้ว");
                                                  sDialog.cancel();
                                              }
                                          })
                                          .show();
                              }

                              else if (check_image_device2==3){
                                  new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                                          .setTitleText("OK!")
                                          .setContentText("ยืนยันรูปภาพถูกต้องแล้ว")


                                          .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                              @Override
                                              public void onClick(SweetAlertDialog sDialog) {
                                                  sDialog.cancel();
                                                  //finish();
                                              }
                                          })
                                          .show();
                              }



                          }
                          else if(view==image_device2){
                              if (check_image_device3==1){
                                  new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                                          .setTitleText("ERROR!")
                                          .setContentText("ยังไม่มีรูปภาพ !")


                                          .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                              @Override
                                              public void onClick(SweetAlertDialog sDialog) {
                                                  sDialog.cancel();
                                                  //finish();
                                              }
                                          })
                                          .show();
                              }

                              else if (check_image_device3==2){
                                  new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                                          .setTitleText("คุณแน่ใจไหม ?")
                                          .setContentText("ที่ต้องการยืนยันรูปภาพ ถูกต้อง !")
                                          .setCancelText("ไม่,ออก!")
                                          .setConfirmText("ไช่,ยืนยัน!")
                                          .showCancelButton(true)
                                          .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                              @Override
                                              public void onClick(SweetAlertDialog sDialog) {
                                                  sDialog.cancel();
                                              }
                                          })
                                          .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                              @Override
                                              public void onClick(SweetAlertDialog sDialog) {
                                                  INSENT_history_confirm_image3();
                                                  image_device2.setBackgroundResource(R.drawable.icon_success);
                                                  tv_image3_checker.setBackgroundResource(R.drawable.roun_rect_orange12);
                                                  tv_image3_checker.setText("ตรวจสอบแล้ว");
                                                  sDialog.cancel();
                                              }
                                          })
                                          .show();
                              }

                              else if (check_image_device3==3){
                                  new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                                          .setTitleText("OK!")
                                          .setContentText("ยืนยันรูปภาพถูกต้องแล้ว")


                                          .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                              @Override
                                              public void onClick(SweetAlertDialog sDialog) {
                                                  sDialog.cancel();
                                                  //finish();
                                              }
                                          })
                                          .show();
                              }

                          }
                          else if(view==button5_2) {


                             // dialog();
                          }

                          else if(view==fab) {
                                loading();
                              Thread xy = new Thread(myThread5);
                              xy.start();
                          }


        }

    String txt3="";
    private Runnable myThread5 = new Runnable(){
        public void run() {
            try{
                String salecode = MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");

                String data="&salename="+SaleEmployeeName2+"&teamcode="+SaleTeamCode2+"&headname="+SaleHeaderName2+"&salecode="+salecode+"&conno="+conno_qr+"&conno_qr_code="+data3+"&status_qrcode="+"1"+"&lat_long="+latitude2+","+longitude2+"&distance="+distance2+"&product_name="+productname2+"&status="+status2+"&name_customer="+customer2
                        +"&id_card="+idcard2+"&address="+address2+"&number_phone="+phone_mobile2+" , "+phone_home2+"&date="+date2;


                Log.e("datadatadata",data);
                String re=	Utils.sendPostData(data.getBytes("UTF-8"), Utils.DATA_CEDIT2);
                Utils.isshop=true;
                txt3=re;

                Log.e("txt3",txt3);





            }
            catch(Exception e)
            {
                e.printStackTrace();

            }
            myHandle3.sendMessage(myHandle3.obtainMessage());
        }
    };

    Handler myHandle3 = new Handler(){
        @Override
        public void handleMessage(android.os.Message msg) {
Log.e("msg", String.valueOf(msg));
            if (txt3.equals("success")){
                pDialog.dismiss();
                success(txt3);
            }
            else {
                pDialog.dismiss();
                error(txt3);
            }
        }
    };

    SweetAlertDialog pDialog;
private void loading(){
    pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
    pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
    pDialog.setTitleText("Loading");
    pDialog.setCancelable(false);
    pDialog.show();
}
private void success(String success){
    new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
            .setTitleText(success)
            .setContentText("บันทึกสำเร็จ!")
            .setConfirmText("OK")
            .showCancelButton(true)

            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sDialog) {


                    sDialog.cancel();
                }
            })
            .show();

}

    private void error(String error){
        new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText(error)
                .setContentText("ไม่สำเร็จ!")
                .setConfirmText("OK")
                .showCancelButton(true)

                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {


                        sDialog.cancel();
                    }
                })
                .show();

    }

    private void aweet_dialog_image_location(){
            if(check_image_device1==3) {
                new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("รูปภาพยืนยันถูกต้องแล้ว")
                        .setContentText("คุณต้องการเปลี่ยนรูป ใช่/ไม่!")
                        .setCancelText("ไม่,ออก!")
                        .setConfirmText("ไช่,เปลี่ยน!")
                        .showCancelButton(true)
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.cancel();
                            }
                        })
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                Pin_location();

                                sDialog.cancel();
                            }
                        })
                        .show();


            }
            else {

                new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("รูปภาพยังไม่ยืนยัน ว่าถูกต้อง!")
                        .setContentText("คุณต้องการเปลี่ยนรูป ใช่/ไม่!")
                        .setCancelText("ไม่,ออก!")
                        .setConfirmText("ไช่,เปลี่ยน!")
                        .showCancelButton(true)
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.cancel();
                            }
                        })
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                Pin_location();

                                sDialog.cancel();
                            }
                        })
                        .show();
            }







        }

    private void aweet_dialog_image_product(){
        if(check_image_device2==3) {
            new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("รูปภาพยืนยันถูกต้องแล้ว")
                    .setContentText("คุณต้องการเปลี่ยนรูป ใช่/ไม่!")
                    .setCancelText("ไม่,ออก!")
                    .setConfirmText("ไช่,เปลี่ยน!")
                    .showCancelButton(true)
                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.cancel();
                        }
                    })
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            CameraOpen();

                            sDialog.cancel();
                        }
                    })
                    .show();


        }
        else {
            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("รูปภาพยังไม่ยืนยัน ว่าถูกต้อง!")
                    .setContentText("คุณต้องการเปลี่ยนรูป ใช่/ไม่!")
                    .setCancelText("ไม่,ออก!")
                    .setConfirmText("ไช่,เปลี่ยน!")
                    .showCancelButton(true)
                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.cancel();
                        }
                    })
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            Pin_location();

                            sDialog.cancel();
                        }
                    })
                    .show();
        }







    }


    private void aweet_dialog_image_idcard(){
        if(check_image_device3==3) {
            new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("รูปภาพยืนยันถูกต้องแล้ว")
                    .setContentText("คุณต้องการเปลี่ยนรูป ใช่/ไม่!")
                    .setCancelText("ไม่,ออก!")
                    .setConfirmText("ไช่,เปลี่ยน!")
                    .showCancelButton(true)
                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.cancel();
                        }
                    })
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            CameraOpen2();

                            sDialog.cancel();
                        }
                    })
                    .show();


        }
        else {
            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("รูปภาพยังไม่ยืนยัน ว่าถูกต้อง!")
                    .setContentText("คุณต้องการเปลี่ยนรูป ใช่/ไม่!")
                    .setCancelText("ไม่,ออก!")
                    .setConfirmText("ไช่,เปลี่ยน!")
                    .showCancelButton(true)
                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.cancel();
                        }
                    })
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            Pin_location();

                            sDialog.cancel();
                        }
                    })
                    .show();
        }







    }

        private  void Pin_location(){
            Intent Intent = new Intent( this, MapsActivity.class);
            startActivityForResult(Intent, 11);
        }



    public Address getAddress(double latitude,double longitude)
    {
        Geocoder geocoder;



        List<Address> addresses;
        geocoder = new Geocoder(this, Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(latitude,longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
            return addresses.get(0);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }
    public void getAddress()
    {


       Double latitude_d = Double.valueOf(latitude);
        Double longitude_d = Double.valueOf(longitude);
        Address locationAddress=getAddress(latitude_d,longitude_d);

        if(locationAddress!=null)
        {
             address_now = locationAddress.getAddressLine(0);
            Log.e("currentLocation",address_now);
            /*
            String address1 = locationAddress.getAddressLine(1);
            String city = locationAddress.getLocality();
            String state = locationAddress.getAdminArea();
            String country = locationAddress.getCountryName();
            String postalCode = locationAddress.getPostalCode();

            String currentLocation;

            if(!TextUtils.isEmpty(address))
            {
                currentLocation=address;

                if (!TextUtils.isEmpty(address1))
                    currentLocation+="\n"+address1;

                if (!TextUtils.isEmpty(city))
                {
                    currentLocation+="\n"+city;

                    if (!TextUtils.isEmpty(postalCode))
                        currentLocation+=" - "+postalCode;
                }
                else
                {
                    if (!TextUtils.isEmpty(postalCode))
                        currentLocation+="\n"+postalCode;
                }

                if (!TextUtils.isEmpty(state))
                    currentLocation+="\n"+state;

                if (!TextUtils.isEmpty(country))
                    currentLocation+="\n"+country;
*/



               // tvEmpty.setVisibility(View.GONE);
              //  tvAddress.setText(currentLocation);
               // tvAddress.setVisibility(View.VISIBLE);

               // if(!btnProceed.isEnabled())
               //     btnProceed.setEnabled(true);


            //}

        }

    }




    String txt="";
    private Runnable myThread = new Runnable(){
        public void run() {
            try{

            }
            catch(Exception e)
            {
                e.printStackTrace();

            }
            myHandle.sendMessage(myHandle.obtainMessage());
        }
    };

    Handler myHandle = new Handler(){
        @Override
        public void handleMessage(android.os.Message msg) {

        }
    };

    String txt2="";
    private Runnable myThread2 = new Runnable(){
        public void run() {
            try{



                final String CreateBy=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
                final String GroupID = DADA;
                final String ref =RefNo;

                String data="&refno="+ref+"&GroupID="+GroupID+"&CreateBy="+CreateBy;
                String re=	Utils.sendPostData(data.getBytes("UTF-8"), Utils.UPDATE_PROBLEM_PBANG2);
                Utils.isshop=true;
                txt2=re;






            }
            catch(Exception e)
            {
                e.printStackTrace();

            }
            myHandle2.sendMessage(myHandle2.obtainMessage());
        }
    };

    Handler myHandle2 = new Handler(){
        @Override
        public void handleMessage(android.os.Message msg) {


            //dialog();



        }
    };




    private double getDistanceInfo(String city1, String city2) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        StringBuilder stringBuilder = new StringBuilder();

        Double da = 0.0;
        try {

            String url = "http://maps.googleapis.com/maps/api/directions/json?origin=" + city1 + "&destination=" + city2 + "&sensor=false";

            HttpPost httppost = new HttpPost(url);

            HttpClient client = new DefaultHttpClient();
            HttpResponse response;
            stringBuilder = new StringBuilder();


            response = client.execute(httppost);
            HttpEntity entity = response.getEntity();
            InputStream stream = entity.getContent();
            int b;
            while ((b = stream.read()) != -1) {
                stringBuilder.append((char) b);
            }
        } catch (ClientProtocolException e) {
        } catch (IOException e) {
        }

        JSONObject jsonObject = new JSONObject();
        try {

            jsonObject = new JSONObject(stringBuilder.toString());

            JSONArray array = jsonObject.getJSONArray("routes");

            JSONObject routes = array.getJSONObject(0);

            JSONArray legs = routes.getJSONArray("legs");

            JSONObject steps = legs.getJSONObject(0);

            JSONObject distance = steps.getJSONObject("distance");
            JSONObject duration = steps.getJSONObject("duration");

            dist = Double.parseDouble(distance.getString("value"));

            dist=dist/1000.0;

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dist;

    }


    private double getDistanceInfo2(String city1,String city2) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        StringBuilder stringBuilder = new StringBuilder();

        Double da = 0.0;
        try {

             url2 = "http://maps.googleapis.com/maps/api/directions/json?origin=" + URLEncoder.encode(city1, "UTF-8")+"&destination=" + URLEncoder.encode(city2, "UTF-8") + "&sensor=false" ;

Log.e("url2",url2);

            HttpPost httppost = new HttpPost(url2);

            HttpClient client = new DefaultHttpClient();
            HttpResponse response;
            stringBuilder = new StringBuilder();


            response = client.execute(httppost);
            HttpEntity entity = response.getEntity();
            InputStream stream = entity.getContent();
            int b;
            while ((b = stream.read()) != -1) {
                stringBuilder.append((char) b);
            }
        } catch (ClientProtocolException e) {
        } catch (IOException e) {
        }

        JSONObject jsonObject = new JSONObject();
        try {

            jsonObject = new JSONObject(stringBuilder.toString());

            JSONArray array = jsonObject.getJSONArray("routes");

            JSONObject routes = array.getJSONObject(0);

            JSONArray legs = routes.getJSONArray("legs");

            JSONObject steps = legs.getJSONObject(0);

            JSONObject distance = steps.getJSONObject("distance");
            JSONObject duration = steps.getJSONObject("duration");

            dist = Double.parseDouble(distance.getString("value"));

            dist=dist/1000.0;

            //durat= Double.parseDouble(duration.getString("value"));



        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dist;

    }
    public void JSON_UPDATE_LOCATION(){
        String salecode = MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");


        jsonArrayRequest3 = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_UPDATE_LOCATION+"?salecode="+salecode+"&conno="+conno+"&conno_qr_code="+conno_qr_code+"&lat_long="+latitude+","+longitude+"&distance="+dist,


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

        requestQueue3 = Volley.newRequestQueue(this);

        requestQueue3.add(jsonArrayRequest3);

    }
















    private void CameraOpen() {
                CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


                file = new File(Environment.getExternalStorageDirectory(),
                        "file"+String.valueOf(System.currentTimeMillis())+".jpg");
                uri = Uri.fromFile(file);
                CamIntent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
                CamIntent.putExtra("return-data",true);
                startActivityForResult(CamIntent,0);
        }



        private void CropImage() {

                try{
                        CropIntent = new Intent("com.android.camera.action.CROP");
                        CropIntent.setDataAndType(uri,"image/*");
                        CropIntent.putExtra("crop","true");
                        CropIntent.putExtra("outputX",1024);
                        CropIntent.putExtra("outputY",1024);
                        CropIntent.putExtra("aspectX",1);
                        CropIntent.putExtra("aspectY",1);
                        CropIntent.putExtra("scaleUpIfNeeded",true);
                        CropIntent.putExtra("return-data",true);

                        startActivityForResult(CropIntent,1);
                }
                catch (ActivityNotFoundException ex)
                {

                }



        }
    private void CameraOpen2() {
        CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


        file = new File(Environment.getExternalStorageDirectory(),
                "file"+String.valueOf(System.currentTimeMillis())+".jpg");
        uri = Uri.fromFile(file);
        CamIntent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
        CamIntent.putExtra("return-data",true);
        startActivityForResult(CamIntent,2);
    }



    private void CropImage2() {

        try{
            CropIntent = new Intent("com.android.camera.action.CROP");
            CropIntent.setDataAndType(uri,"image/*");
            CropIntent.putExtra("crop","true");
            CropIntent.putExtra("outputX",1024);
            CropIntent.putExtra("outputY",1024);
            CropIntent.putExtra("aspectX",1);
            CropIntent.putExtra("aspectY",1);
            CropIntent.putExtra("scaleUpIfNeeded",true);
            CropIntent.putExtra("return-data",true);

            startActivityForResult(CropIntent,3);
        }
        catch (ActivityNotFoundException ex)
        {

        }



    }

        private void creatJPG(Bitmap bitmap ) {
                Date now = new Date();
                DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
                String imageName = df.format(now);
                try {
                        String imagePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();

                        File imageFile = new File(imagePath + "/" + imageName + ".jpg");
                        FileOutputStream outputStream = new FileOutputStream(imageFile);
                        int quality = 100;
                        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
                        outputStream.flush();
                        outputStream.close();

                        String uu = Uri.fromFile(imageFile).toString();
                        String rr =Uri.fromFile(imageFile).toString();

                        if (uu != null) {
                                filePath = uu;
                        } else if (rr != null) {
                                filePath = rr;
                        } else {

                                Toast.makeText(this, "Unknown path",
                                        Toast.LENGTH_LONG).show();
                                Log.e("Bitmap", "Unknown path");
                        }


                        System.out.println("filePath="+filePath);
                        bmplogo= Utils.decodeFile(new File(filePath),1024);


                    if(filePath!=null)logo=filePath;
                    Thread C=new Thread(myThread4);
                    C.start();




                } catch (IOException e) {
                        e.printStackTrace();
                }
        }





    private void creatJPG2(Bitmap bitmap ) {
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
        String imageName = df.format(now);
        try {
            String imagePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();

            File imageFile = new File(imagePath + "/" + imageName + ".jpg");
            FileOutputStream outputStream = new FileOutputStream(imageFile);
            int quality = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
            outputStream.flush();
            outputStream.close();

            String uu = Uri.fromFile(imageFile).toString();
            String rr =Uri.fromFile(imageFile).toString();


            if (uu != null) {
                filePath = uu;
            } else if (rr != null) {
                filePath = rr;
            } else {

                Toast.makeText(this, "Unknown path",
                        Toast.LENGTH_LONG).show();
                Log.e("Bitmap", "Unknown path");
            }


            System.out.println("filePath="+filePath);
            bmplogo= Utils.decodeFile(new File(filePath),1024);


            if(filePath!=null)logo=filePath;
            Thread C=new Thread(myThread6);
            C.start();







        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Runnable myThread4 = new Runnable(){
        public void run() {
            try{


                if(filePath!=null)
                {

                    byte[] bfile2= Utils.BitmapToByteArray_image_device(bitmap);
                    logo=Utils.getFileDate_image_device();
                    Utils.doFileUpload_image_device(bfile2, logo);

                    DELETE_IMAGE_DEVICE();
                    JSON_DATA_WEB_CALL_IMAGE_CAMERA();
                    INSENT_DATA_CHECK_DEVICE_PEEBANG();
                    INSENT_history_image_product();

                }

            }
            catch(Exception e)
            {
                e.printStackTrace();

            }
            myHandle.sendMessage(myHandle.obtainMessage());
        }
    };


    private Runnable myThread6 = new Runnable(){
        public void run() {
            try{


                if(filePath!=null)
                {

                    byte[] bfile2=Utils.BitmapToByteArray_image_idcard(bitmap);
                    logo=Utils.getFileDate_image_idcard();
                    Utils.doFileUpload_image_idcard(bfile2, logo);

                    JSON_DATA_WEB_CALL_IMAGE_CAMERA2();
                    DELETE_IMAGE_IDCARD();
                    INSENT_DATA_CHECK_IDCARD_PEEBANG();
                    INSENT_history_image_idcard();
                }

            }
            catch(Exception e)
            {
                e.printStackTrace();

            }
            myHandle.sendMessage(myHandle.obtainMessage());
        }
    };


        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
                super.onActivityResult(requestCode, resultCode, data);
                if(requestCode == 0) {
                       if(resultCode==RESULT_OK) {
                             CropImage();

                       }

                }


                else if (requestCode == 1)
                {

                        if(data != null)
                        {

                                try {

                                        Bundle bundle = data.getExtras();

                                        bitmap = bundle.getParcelable("data");

                                        Log.e("OKKKKKKKKKK","OKKKKKKKKKK");
                                        //  imageView2.setImageBitmap(bitmap);

                                        creatJPG(bitmap);

                                   // JSON_DATA_WEB_CALL();

                                }
                                catch (Exception e) {

                                }

                        }
                }

            else if(requestCode == 2) {
                if(resultCode==RESULT_OK) {
                    CropImage2();

                }

            }
                else if (requestCode == 3)
                {

                    if(data != null)
                    {

                        try {
                            Bundle bundle = data.getExtras();
                            bitmap = bundle.getParcelable("data");

                            Log.e("OKKKKKKKKKK","OKKKKKKKKKK");

                            creatJPG2(bitmap);
                            //JSON_DATA_WEB_CALL();
                        }
                        catch (Exception e) {

                        }

                    }
                }

                else if (requestCode == 10)
                {
                   // JSON_DATA_WEB_CALL();
                   // JSON_DATA_WEB_CALL2();
                }
                else if (requestCode == 11)
                {
                   // JSON_DATA_WEB_CALL();
                    // JSON_DATA_WEB_CALL2();
                }
        }







    public void JSON_DATA_WEB_CALL_IMAGE_CAMERA() {

        String salecode = MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL3+"?salecode="+salecode+"&conno="+conno+"&status_image="+"1",

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

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

    }

    public void JSON_DATA_WEB_CALL_IMAGE_CAMERA2() {

        String salecode = MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL3_2+"?salecode="+salecode+"&conno="+conno+"&status_image2="+"1",

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

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

    }


    private  void DELETE_IMAGE_DEVICE(){

        ImageTypeCode="PRODUCT";

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_DELETE_PRODUCT+"?refno="+RefNo+"&ImageTypeCode="+ImageTypeCode,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("2222",error.toString());

                    }
                });

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

    }



    private  void DELETE_IMAGE_IDCARD(){

        ImageTypeCode="IDCARD";

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_DELETE_IDCARD+"?refno="+RefNo+"&ImageTypeCode="+ImageTypeCode,


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

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

    }



    private  void INSENT_DATA_CHECK_DEVICE_PEEBANG(){

        ImageTypeCode="PRODUCT";
        logo2=Utils.getFileDate_image_device();
        pathurl=logo2;
        CreateBy= MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");




        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL7+"?refno="+RefNo+"&ImageTypeCode="+ImageTypeCode+"&pathurl="+pathurl+"&CreateBy="+CreateBy,


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

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

    }


    private  void INSENT_DATA_CHECK_IDCARD_PEEBANG(){

        ImageTypeCode="IDCARD";
        logo2=Utils.getFileDate_image_idcard();
        pathurl=logo2;
        CreateBy= MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");




        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL7+"?refno="+RefNo+"&ImageTypeCode="+ImageTypeCode+"&pathurl="+pathurl+"&CreateBy="+CreateBy,


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

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

    }
String SS="";
    public void JSON_DATA_WEB_CALL_update_lasttime() {


        String salecode = MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");
        if(salecode.equals("null")){
            SS=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        }
        else {
            SS=MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");
        }
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL5+"?salecode="+SS+"&conno="+conno,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("2222",error.toString());
                        //ShowSQLiteDBdata();
                    }
                });

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

    }




    private  void INSENT_history_image_product(){

        String salecode = MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");
        String empid = MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL9+"?empid="+empid+"&salecode="+salecode+"&refno="+RefNo+"&conno="+conno+"&titleTypeCode="+"PRODUCT"+"&server="+"assanee_mobile"+"&partimage="+logo+"&status_confirm_image_old="+"null"+"&status_confirm="+"1",


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("2222",error.toString());
                        //ShowSQLiteDBdata();
                    }
                });

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

    }



    private  void INSENT_history_image_idcard(){
        String salecode = MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");
        String empid = MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL9+"?empid="+empid+"&salecode="+salecode+"&refno="+RefNo+"&conno="+conno+"&titleTypeCode="+"IDCARD"+"&server="+"assanee_mobile"+"&partimage="+logo+"&status_confirm_image_old="+"null"+"&status_confirm="+"1",


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

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

    }


    private  void INSENT_history_confirm_image1(){

        String salecode = MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");
        String empid = MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL9+"?empid="+empid+"&salecode="+salecode+"&refno="+RefNo+"&conno="+conno+"&titleTypeCode="+"MAP"+"&server="+"Bighead_Mobile"+"&partimage="+image33+"&status_confirm_image_old="+"1"+"&status_confirm="+"null",


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //getDistanceInfo("13.9012707,100.4514525","13.988191,100.6137946");
                        //distance(13.9012707,100.4514525,13.9012707,100.4514525);
                        Log.e("1111","11111");
                        //  JSON_PARSE_DATA_AFTER_WEBCALL(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("2222",error.toString());
                        //ShowSQLiteDBdata();
                    }
                });

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

    }


    private  void INSENT_history_confirm_image2(){

        String salecode = MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");

        RefNo = MyApplication.getInstance().getPrefManager().getPreferrence("RefNo_all");
        String  conno = MyApplication.getInstance().getPrefManager().getPreferrence("conno_qr");
        CreateBy= MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        //logo_url= MyApplication.getInstance().getPrefManager().getPreferrence("logo_url");

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL9+"?empid="+CreateBy+"&salecode="+salecode+"&refno="+RefNo+"&conno="+conno+"&titleTypeCode="+"PRODUCT"+"&server="+"Bighead_Mobile"+"&partimage="+image11+"&status_confirm_image_old="+"1"+"&status_confirm="+"null",


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //getDistanceInfo("13.9012707,100.4514525","13.988191,100.6137946");
                        //distance(13.9012707,100.4514525,13.9012707,100.4514525);
                        Log.e("1111","11111");
                        //  JSON_PARSE_DATA_AFTER_WEBCALL(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("2222",error.toString());
                        //ShowSQLiteDBdata();
                    }
                });

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

    }



    private  void INSENT_history_confirm_image3(){

        String salecode = MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");

        RefNo = MyApplication.getInstance().getPrefManager().getPreferrence("RefNo_all");
        String  conno = MyApplication.getInstance().getPrefManager().getPreferrence("conno_qr");
        CreateBy= MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        //logo_url= MyApplication.getInstance().getPrefManager().getPreferrence("logo_url");

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL9+"?empid="+CreateBy+"&salecode="+salecode+"&refno="+RefNo+"&conno="+conno+"&titleTypeCode="+"IDCARD"+"&server="+"Bighead_Mobile"+"&partimage="+image22+"&status_confirm_image_old="+"1"+"&status_confirm="+"null",


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //getDistanceInfo("13.9012707,100.4514525","13.988191,100.6137946");
                        //distance(13.9012707,100.4514525,13.9012707,100.4514525);
                        Log.e("1111","11111");
                        //  JSON_PARSE_DATA_AFTER_WEBCALL(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("2222",error.toString());
                        //ShowSQLiteDBdata();
                    }
                });

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

    }


    private  void INSENT_select_data_sale(){


        try {
            jsonArrayRequest = new JsonArrayRequest(GET_PROBLEM_OF_SALE+"?SaleEmployeeName="+URLEncoder.encode(SaleEmployeeName, "UTF-8"),


                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {

                              JSON_PARSE_DATA_AFTER_WEBCALL_select_data_sale(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

    }





            public void JSON_PARSE_DATA_AFTER_WEBCALL_select_data_sale(JSONArray array) {

                for (int i = 0; i < array.length(); i++) {

                    final GetData_sale_information GetDataAdapter2 = new GetData_sale_information();

                    JSONObject json = null;
                    try {

                        json = array.getJSONObject(i);

                        getData_cedit = new GetData_cedit();



                        GetDataAdapter2.setEmployeeName(json.getString(JSON_EmployeeName));
                        GetDataAdapter2.setPositionCode(json.getString(JSON_PositionCode));
                        GetDataAdapter2.setPositionName(json.getString(JSON_PositionName));
                        GetDataAdapter2.setTeamHeadCode(json.getString(JSON_TeamHeadCode));
                        GetDataAdapter2.setTeamHeadName(json.getString(JSON_TeamHeadName));
                        GetDataAdapter2.setTeamName(json.getString(JSON_TeamName));
                        GetDataAdapter2.setSupervisorHeadCode(json.getString(JSON_SupervisorHeadCode));
                        GetDataAdapter2.setSupervisorHeadName(json.getString(JSON_SupervisorHeadName));
                        GetDataAdapter2.setSupervisorName(json.getString(JSON_SupervisorName));
                        GetDataAdapter2.setSubDepartmentHeadCode(json.getString(JSON_SubDepartmentHeadCode));
                        GetDataAdapter2.setSubDepartmentHeadName(json.getString(JSON_SubDepartmentHeadName));
                        GetDataAdapter2.setSubDepartmentName(json.getString(JSON_SubDepartmentName));
                        GetDataAdapter2.setDepartmentHeadCode(json.getString(JSON_DepartmentHeadCode));
                        GetDataAdapter2.setDepartmentHeadName(json.getString(JSON_DepartmentHeadName));
                        GetDataAdapter2.setDepartmentName(json.getString(JSON_DepartmentName));
                        GetDataAdapter2.setSubTeamCode(json.getString(JSON_SubTeamCode));
                        GetDataAdapter2.setTeamCode(json.getString(JSON_TeamCode));
                        GetDataAdapter2.setPicture(json.getString(JSON_picture));




                        MyApplication.getInstance().getPrefManager().setPreferrence("getEmployeeName", GetDataAdapter2.getEmployeeName());
                        MyApplication.getInstance().getPrefManager().setPreferrence("getPositionCode", GetDataAdapter2.getPositionCode());
                        MyApplication.getInstance().getPrefManager().setPreferrence("getPositionName", GetDataAdapter2.getPositionName());
                        MyApplication.getInstance().getPrefManager().setPreferrence("getTeamHeadCode", GetDataAdapter2.getTeamHeadCode());
                        MyApplication.getInstance().getPrefManager().setPreferrence("getTeamHeadName", GetDataAdapter2.getTeamHeadName());
                        MyApplication.getInstance().getPrefManager().setPreferrence("getTeamName", GetDataAdapter2.getTeamName());
                        MyApplication.getInstance().getPrefManager().setPreferrence("getSupervisorHeadCode", GetDataAdapter2.getSupervisorHeadCode());
                        MyApplication.getInstance().getPrefManager().setPreferrence("getSupervisorHeadName", GetDataAdapter2.getSupervisorHeadName());
                        MyApplication.getInstance().getPrefManager().setPreferrence("getSupervisorName", GetDataAdapter2.getSupervisorName());
                        MyApplication.getInstance().getPrefManager().setPreferrence("getSubDepartmentHeadCode", GetDataAdapter2.getSubDepartmentHeadCode());
                        MyApplication.getInstance().getPrefManager().setPreferrence("getSubDepartmentHeadName", GetDataAdapter2.getSubDepartmentHeadName());
                        MyApplication.getInstance().getPrefManager().setPreferrence("getSubDepartmentName", GetDataAdapter2.getSubDepartmentName());
                        MyApplication.getInstance().getPrefManager().setPreferrence("getDepartmentHeadCode", GetDataAdapter2.getDepartmentHeadCode());
                        MyApplication.getInstance().getPrefManager().setPreferrence("getDepartmentHeadName", GetDataAdapter2.getDepartmentHeadName());
                        MyApplication.getInstance().getPrefManager().setPreferrence("getDepartmentName", GetDataAdapter2.getDepartmentName());
                        MyApplication.getInstance().getPrefManager().setPreferrence("getSubTeamCode", GetDataAdapter2.getSubTeamCode());
                        MyApplication.getInstance().getPrefManager().setPreferrence("getTeamCode", GetDataAdapter2.getTeamCode());
                        MyApplication.getInstance().getPrefManager().setPreferrence("getPicture", GetDataAdapter2.getPicture());






                    } catch (JSONException e) {

                        e.printStackTrace();
                    }
//                    GetDataAdapter1.add(GetDataAdapter2);

                }



            }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_map, menu);
         menuItem1 = menu.findItem(R.id.map);
         menuItem2 = menu.findItem(R.id.map2);
       help = menu.findItem(R.id.help);
        return true;
    }


int i=0;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.help){


            Intent mIntent = new Intent( Detali_data_cedit.this, MainActivity_web_help.class);
            startActivity(mIntent);
        }
       else if(id == R.id.map){



            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?daddr=" + "13.897776" + "," + "100.5123653"+"&daddr="+Latitude+","+Longitude));
            startActivity(intent);

        }
        else if(id == R.id.map2){
            //invalidateOptionsMenu();
            try {
                String see_image = MyApplication.getInstance().getPrefManager().getPreferrence("image_slider");
                if(see_image.equals("1")){
                    i=1;
                }
                else {
                    i=0;
                }
            }
            catch (Exception ex){

            }

            i++;
            if(i>1){
                i=0;
            }
            if(i==0){
                viewPager3.setVisibility(View.GONE);
                sliderDotspanel2.setVisibility(View.GONE);
                LinearLayout_check.setVisibility(View.VISIBLE);
                MyApplication.getInstance().getPrefManager().setPreferrence("image_slider", "0");
                menuItem2.setIcon(R.drawable.image_slider);
            }
            else {
                viewPager3.setVisibility(View.VISIBLE);
                sliderDotspanel2.setVisibility(View.VISIBLE);
                LinearLayout_check.setVisibility(View.GONE);
                MyApplication.getInstance().getPrefManager().setPreferrence("image_slider", "1");
                menuItem2.setIcon(R.drawable.icon_check);
            }




        }
        else if (id == android.R.id.home) {
            // finish the activity

            onBackPressed();
            return true;
        }



        return super.onOptionsItemSelected(item);
    }




}
