package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.check_for_credit;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.tsr.tsrproblemreport_tossticket_checker.API_URL_ALL;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.activity.Detali_check1;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.activity.Detali_check2;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.activity.Detali_check3;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.adapter.RecyclerViewAdapter_type_check_susscess;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.adapter.RecyclerViewDataAdapter_dialog_image_problem_from_id_checker444;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.GetData_cedit_dialog_image_problem_from_id_checker4;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.Get_data_type_check;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.ViewPagerAdapter;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.ContactAdapter;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.helper.GetCurrentLocation;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;
import com.viewpagerindicator.CirclePageIndicator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import static com.tsr.tsrproblemreport_tossticket_checker.API_URL_ALL.BASE_URL;

public class Check_Fragment1_2 extends Fragment implements RecyclerViewAdapter_type_check_susscess.itemclick2, View.OnClickListener,RecyclerViewAdapter_type_check_susscess.itemclick_image_problem_incorrect, RecyclerViewDataAdapter_dialog_image_problem_from_id_checker444.itemclick_deleteAll_id_checker4,RecyclerViewAdapter_type_check_susscess.itemclick_edit {
    private ImageView userImage;
    private TextView userPostsCount, userFollowersCount, userFollowingCount,edit_text10,cc1,cc2;
    private TextView userName;
    private ProgressBar profileRefreshProgress;
    RelativeLayout profileFrame;
    private FragmentManager fragmentManager;
    private Fragment fragment = null;
    ImageView imageView;
    ImageView image_bg;
    ConstraintLayout vvv;
    TextView textView,textView2;
    RecyclerViewDataAdapter_dialog_image_problem_from_id_checker444 recyclerViewDataAdapter_dialog_image_problem_from_id_checker4;
    private FloatingActionButton fabSetting;
    EditText edit_text1,edit_text2,edit_text3,edit_text4,edit_text5,edit_text6,edit_text7,edit_text8,edit_text9;
    LinearLayout linear_text_new;
 //   String Latitude="",Longitude="",phone_home="",phone_mobile="";
    public static String from,ProductSerial,PayLastPeriod,Outstanding,FnYear,FnMonth,conno,productname,status,customer,idcard,address,
            phone_home,phone_mobile,date,Latitude,Longitude,RefNo,isremark,SaleEmployeeName="",SaleTeamCode,SaleHeaderName,CheckerStatus;

    TextView txtname_sale,txt_codeteam,txt_conno,txt_productname,txt_status,txt_customer,txt_idcard,txt_address,txt_phone,txt_phone2,txt_date,txt_mylocation,counter,counter2;
    String FnYear_N,FnMonth_N,Contno_N,CustomerName_N,IDCard_N,AddressDetail_N,Latitude_N,Longitude_N,TelHome_N,TelMobile_N;
    private final int CALL_REQUEST = 100;
    private final int CALL_REQUEST2 = 101;

    private Date oneWayTripDate;

    public static  FloatingActionButton fab,fab2;
    String date_new_format_thai;
    String dateThai_year,dateThai_month,dateThai_day, dateThai_month1;
    int converted_dateThai11;

    ViewPager viewPager;
    public static   LinearLayout sliderDotspanel,sliderDotspanel2,LinearLayout_check,LinearLayout_data2,LinearLayout_data3,LinearLayout_status,liner1,liner2;
    private int dotscount,dotscount2;
    private ImageView[] dots,dots2;
    View view,view2;
    String   latitude,longitude;
    GetCurrentLocation currentLoc;
    double d;
    List<GetData_cedit_dialog_image_problem_from_id_checker4> getData_image_more_for_delates_checker4;
    GetData_cedit_dialog_image_problem_from_id_checker4 data_cedit_dialog_image_problem_from_id_checker4;
    ViewPagerAdapter viewPagerAdapter;
    public static int runtime=0;

    JsonArrayRequest jsonArrayRequest ;
    // private RVAdapter adapter;
    RequestQueue requestQueue ;
    private SwipeRefreshLayout swipeRefreshLayout;

    private ProgressDialog pDialog;


    List<Get_data_type_check> GetDataAdapter1,GetDataAdapter3;
    RelativeLayout relativeLayout;
    RecyclerView recyclerView;
    private Toolbar toolbar;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    Get_data_type_check getDataAdapter;
    RecyclerViewAdapter_type_check_susscess recyclerViewadapter;
    private RecyclerViewAdapter_type_check_susscess mAdapter;
    String DADADA;
    // private RecyclerViewAdapter3 adapter;
    String GET_JSON_DATA_HTTP_URL = "";
    String JSON_data = "data";
String PositionCode;

    LinearLayout LinearLayout_data1,LinearLayout_data12,data_old,data_new,liner3,li_line7,li_line8;
ImageView edit1,edit2,edit3,edit4,edit5,edit6,edit7,edit8,image_tal1,image_tal2,edit9,edit10,image_mylocation,image_mylocation_claer;



    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;



    private String[] urls = new String[] {"https://demonuts.com/Demonuts/SampleImages/W-03.JPG", "https://demonuts.com/Demonuts/SampleImages/W-08.JPG", "https://demonuts.com/Demonuts/SampleImages/W-10.JPG",
            "https://demonuts.com/Demonuts/SampleImages/W-13.JPG", "https://demonuts.com/Demonuts/SampleImages/W-17.JPG", "https://demonuts.com/Demonuts/SampleImages/W-21.JPG"};
    private   String[]   sampleNetworkImageURLs = new String[]{
            API_URL_ALL.GET_JSON_DATA_HTTP_URL_IMAGE + image1,
            API_URL_ALL.GET_JSON_DATA_HTTP_URL_IMAGE + image2,
            API_URL_ALL.GET_JSON_DATA_HTTP_URL_IMAGE + image3,
            API_URL_ALL.GET_JSON_DATA_HTTP_URL_IMAGE + image4,
            API_URL_ALL.GET_JSON_DATA_HTTP_URL_IMAGE + image5,
            API_URL_ALL.GET_JSON_DATA_HTTP_URL_IMAGE + image6
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
        final View view = inflater.inflate(R.layout.fragment_check_for_credit2, container, false);


        setHasOptionsMenu(true);
        txtname_sale=(TextView)view.findViewById(R.id.txtname_sale);
        txt_codeteam=(TextView)view.findViewById(R.id.txt_codeteam);

        txt_conno=(TextView)view.findViewById(R.id.txt_conno);
        txt_productname=(TextView)view.findViewById(R.id.txt_productname);
        txt_status=(TextView)view.findViewById(R.id.txt_status);
        txt_customer=(TextView)view.findViewById(R.id.txt_customer);
        txt_idcard=(TextView)view.findViewById(R.id.txt_idcard);
        txt_address=(TextView)view.findViewById(R.id.txt_address);
        txt_phone=(TextView)view.findViewById(R.id.txt_phone);
        txt_phone2=(TextView)view.findViewById(R.id.txt_phone2);
        txt_date=(TextView)view.findViewById(R.id.txt_date);
        txt_mylocation=(TextView)view.findViewById(R.id.txt_mylocation);
        LinearLayout_data1= (LinearLayout) view.findViewById(R.id.LinearLayout_data1);
        //LinearLayout_data12= (LinearLayout) view.findViewById(R.id.LinearLayout_data12);
        fab= (FloatingActionButton) view.findViewById(R.id.fab);
        fab2= (FloatingActionButton) view.findViewById(R.id.fab2);
        fab.setOnClickListener(this);
        fab2.setOnClickListener(this);
       // swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipe_refresh_layout);
       // counter=(TextView) layoutView.findViewById(R.id.counter);
        GetDataAdapter1 = new ArrayList<>();
        recyclerView = (RecyclerView)view. findViewById(R.id.recyclerview1);

        relativeLayout= (RelativeLayout) view.findViewById(R.id.relativeLayout);
        liner3= (LinearLayout) view.findViewById(R.id.liner3);
        //recyclerView.setVisibility(View.GONE);
        edit1= (ImageView) view.findViewById(R.id.edit1);
        edit2= (ImageView) view.findViewById(R.id.edit2);
        edit3= (ImageView) view.findViewById(R.id.edit3);
        edit4= (ImageView) view.findViewById(R.id.edit4);
        edit5= (ImageView) view.findViewById(R.id.edit5);
        edit6= (ImageView) view.findViewById(R.id.edit6);
        edit7= (ImageView) view.findViewById(R.id.edit7);
        edit8= (ImageView) view.findViewById(R.id.edit8);
        edit9= (ImageView) view.findViewById(R.id.edit9);
        edit10= (ImageView) view.findViewById(R.id.edit10);

        image_tal1= (ImageView) view.findViewById(R.id.image_tal1);
        image_tal2= (ImageView) view.findViewById(R.id.image_tal2);
        image_mylocation= (ImageView) view.findViewById(R.id.image_mylocation);
        image_mylocation_claer= (ImageView) view.findViewById(R.id.image_mylocation_claer);
        edit_text1= (EditText) view.findViewById(R.id.edit_text1);
        edit_text2= (EditText) view.findViewById(R.id.edit_text2);
        edit_text3= (EditText) view.findViewById(R.id.edit_text3);
        edit_text4= (EditText) view.findViewById(R.id.edit_text4);
        edit_text5= (EditText) view.findViewById(R.id.edit_text5);
        edit_text6= (EditText) view.findViewById(R.id.edit_text6);
        edit_text7= (EditText) view.findViewById(R.id.edit_text7);
        edit_text8= (EditText) view.findViewById(R.id.edit_text8);
        edit_text9= (EditText) view.findViewById(R.id.edit_text9);
        edit_text10= (TextView) view.findViewById(R.id.edit_text10);
        linear_text_new= (LinearLayout) view.findViewById(R.id.linear_text_new);
        data_old= (LinearLayout) view.findViewById(R.id.data_old);
        data_new= (LinearLayout) view.findViewById(R.id.data_new);

        li_line7= (LinearLayout) view.findViewById(R.id.li_line7);
        li_line8= (LinearLayout) view.findViewById(R.id.li_line8);
        cc1= (TextView) view.findViewById(R.id.cc1);
        cc2= (TextView) view.findViewById(R.id.cc2);

        getData_image_more_for_delates_checker4= new ArrayList<GetData_cedit_dialog_image_problem_from_id_checker4>();
        GetDataAdapter1 = new ArrayList<>();

        counter=(TextView)view.findViewById(R.id.counter);
        counter.setText("ข้อมูลการตรวจสอบ");
        edit1.setOnClickListener(this);
        edit2.setOnClickListener(this);
        edit3.setOnClickListener(this);
        edit4.setOnClickListener(this);
        edit5.setOnClickListener(this);
        edit6.setOnClickListener(this);
        edit7.setOnClickListener(this);
        edit8.setOnClickListener(this);
        edit9.setOnClickListener(this);
        edit10.setOnClickListener(this);
        txt_phone.setOnClickListener(this);
        txt_phone2.setOnClickListener(this);
        image_tal1.setOnClickListener(this);
        image_tal2.setOnClickListener(this);
        image_mylocation.setOnClickListener(this);
        image_mylocation_claer.setOnClickListener(this);
        data_old.setOnClickListener(this);
        data_new.setOnClickListener(this);
        viewPager = (ViewPager)view.findViewById(R.id.viewPager);
        sliderDotspanel = (LinearLayout) view.findViewById(R.id.SliderDots);


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity());
        ProductSerial=MyApplication.getInstance().getPrefManager().getPreferrence("ProductSerial_cf");
        Outstanding=MyApplication.getInstance().getPrefManager().getPreferrence("Outstanding_cf");
        PayLastPeriod=MyApplication.getInstance().getPrefManager().getPreferrence("PayLastPeriod_cf");

        FnYear=MyApplication.getInstance().getPrefManager().getPreferrence("FnYear_cf");
        FnMonth=MyApplication.getInstance().getPrefManager().getPreferrence("FnMonth_cf");



        Latitude=MyApplication.getInstance().getPrefManager().getPreferrence("Latitude_cf");
        Longitude=MyApplication.getInstance().getPrefManager().getPreferrence("Longitude_cf");
        phone_home=MyApplication.getInstance().getPrefManager().getPreferrence("phone_home_cf");
        phone_mobile=MyApplication.getInstance().getPrefManager().getPreferrence("phone_mobile_cf");

        SaleEmployeeName=MyApplication.getInstance().getPrefManager().getPreferrence("SaleEmployeeName_cf");
        conno=MyApplication.getInstance().getPrefManager().getPreferrence("conno_cf");
        isremark=MyApplication.getInstance().getPrefManager().getPreferrence("isremark_cf");
        address=MyApplication.getInstance().getPrefManager().getPreferrence("address_cf");
        MyApplication.getInstance().getPrefManager().setPreferrence("contno_map", conno);

        SaleTeamCode=MyApplication.getInstance().getPrefManager().getPreferrence("SaleTeamCode_cf");
        SaleHeaderName=MyApplication.getInstance().getPrefManager().getPreferrence("SaleHeaderName_cf");
        productname=MyApplication.getInstance().getPrefManager().getPreferrence("productname_cf");
        status=MyApplication.getInstance().getPrefManager().getPreferrence("status_cf");

        customer=MyApplication.getInstance().getPrefManager().getPreferrence("customer_cf");
        idcard=MyApplication.getInstance().getPrefManager().getPreferrence("idcard_cf");
        date=MyApplication.getInstance().getPrefManager().getPreferrence("date_cf");
        CheckerStatus=MyApplication.getInstance().getPrefManager().getPreferrence("CheckerStatus");

        txtname_sale.setText(SaleEmployeeName);
        txt_codeteam.setText(SaleTeamCode);
        txt_conno.setText(conno);
        txt_productname.setText(productname);


        try {
            if(CheckerStatus.equals("01")){
                txt_status.setText("รอตรวจสอบ");
                li_line7.setVisibility(View.VISIBLE);
                li_line8.setVisibility(View.VISIBLE);
                txt_status.setTextColor(0xffFFA500);
            }
            else if(CheckerStatus.equals("11")){
                txt_status.setText("ตรวจสอบแล้ว");
                li_line7.setVisibility(View.VISIBLE);
                li_line8.setVisibility(View.VISIBLE);
                txt_status.setTextColor(0xff2E8B57);
            }
            else if(CheckerStatus.equals("10")){
                txt_status.setText("รออนุมัติการตรวจสอบ");
                li_line7.setVisibility(View.VISIBLE);
                li_line8.setVisibility(View.VISIBLE);
                txt_status.setTextColor(0xffFF4081);
            }
            else if(CheckerStatus.equals("99")){
                txt_status.setText("ตรวจสอบแล้ว พบปัญหา");
                li_line7.setVisibility(View.GONE);
                li_line8.setVisibility(View.GONE);
                txt_status.setTextColor(0xffff0000);
            }
        }
        catch (Exception ex){

        }
        fab.setVisibility(View.GONE);


        txt_customer.setText(customer);
        txt_idcard.setText(idcard);
        txt_address.setText(address);
        txt_phone.setText(phone_home);
        txt_phone2.setText(phone_mobile);
        try {
            if(Latitude.equals("0.0")){
                txt_mylocation.setText("ไม่มีตำแหน่ง");
            }
            else {
                txt_mylocation.setText(Latitude + "," + Longitude);
            }
        }
        catch (Exception ex){
            txt_mylocation.setText("ไม่มีตำแหน่ง");
        }


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
                //Log.e("dateThai",dateThai_day+""+dateThai_month1+""+converted_dateThai11+"");
            }
        }
        catch (Exception ex){

        }



            try {
                currentLoc = new GetCurrentLocation(getActivity());
            }
            catch (Exception ex){

            }


        select_new_data();


















        MyApplication.getInstance().getPrefManager().setPreferrence("image1", "null");
        MyApplication.getInstance().getPrefManager().setPreferrence("image2", "null");
        MyApplication.getInstance().getPrefManager().setPreferrence("image3", "null");
        MyApplication.getInstance().getPrefManager().setPreferrence("image4", "null");
        MyApplication.getInstance().getPrefManager().setPreferrence("image5", "null");
        MyApplication.getInstance().getPrefManager().setPreferrence("image6", "null");
        JSON_DATA_WEB_CALL2();









        PositionCode=MyApplication.getInstance().getPrefManager().getPreferrence("SourceSystem");
        try {
            if(PositionCode.equals("Credit")){

                GET_JSON_DATA_HTTP_URL = BASE_URL+"assanee/checker_system/data_check_susscess.php";
            }
            else {

                GET_JSON_DATA_HTTP_URL = BASE_URL+"assanee/checker_system/data_check_susscess_sale.php";

            }
        }
        catch (Exception EX){

        }



        if(checkConnection()==true){
            relativeLayout.setVisibility(View.GONE);
            JSON_DATA_WEB_CALL();


          //  swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
              //  @Override
              //  public void onRefresh() {
                    recyclerView.setHasFixedSize(true);

                    recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

                    recyclerView.setLayoutManager(recyclerViewlayoutManager);
                    GetDataAdapter1.clear();
                    recyclerView.clearOnScrollListeners();
                    JSON_DATA_WEB_CALL();

                //    swipeRefreshLayout.setRefreshing(false);
             //   }
           // });

        }
        else {
            relativeLayout.setVisibility(View.VISIBLE);
            JSON_DATA_WEB_CALL();


           // swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            //    @Override
             //   public void onRefresh() {
                    recyclerView.setHasFixedSize(true);

                    recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

                    recyclerView.setLayoutManager(recyclerViewlayoutManager);
                    GetDataAdapter1.clear();
                    recyclerView.clearOnScrollListeners();
                    JSON_DATA_WEB_CALL();

                   // swipeRefreshLayout.setRefreshing(false);
                //}
          //  });
        }




        select_color();




        return view;
    }





    public void JSON_DATA_WEB_CALL2() {


        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL2_Check_Fragment1+"?CONTNO="+conno,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        //JSON_PARSE_DATA_AFTER_WEBCALL(response);
                        JSON_PARSE_DATA_AFTER_WEBCALL2(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //JSON_DATA_WEB_CALL2();
                    }
                });

        try {
            try {
                requestQueue = Volley.newRequestQueue(getActivity());
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


    public static String image1="",image2="",image3="",image4="",image5="",image6="";
    public void JSON_PARSE_DATA_AFTER_WEBCALL2( JSONArray array) {





        for (int i = 0; i <= array.length()-1; i++) {


            JSONObject json = null;
            try {

                json = array.getJSONObject(i);






                image1 = json.getString("Image_PRODUCT")+"";
                image2 = json.getString("Image_IDCARD")+"";
                image3 = json.getString("Image_MAP")+"";


                image4 = json.getString("Image_ADDRESS")+"";
                image5 = json.getString("Image_PAYMENTCARD")+"";
                image6 = json.getString("Image_MAPPAYMENT")+"";






                Log.e("image1", image1);
                Log.e("image2", image2);
                Log.e("image3", image3);
                Log.e("image4", image4);
                Log.e("image5", image5);
                Log.e("image6", image6);


                sampleNetworkImageURLs = new String[]{
                        API_URL_ALL.GET_JSON_DATA_HTTP_URL_IMAGE + image1,
                        API_URL_ALL.GET_JSON_DATA_HTTP_URL_IMAGE + image2,
                        API_URL_ALL.GET_JSON_DATA_HTTP_URL_IMAGE + image3,
                        API_URL_ALL.GET_JSON_DATA_HTTP_URL_IMAGE + image4,
                        API_URL_ALL.GET_JSON_DATA_HTTP_URL_IMAGE + image5,
                        API_URL_ALL.GET_JSON_DATA_HTTP_URL_IMAGE + image6
                };





            } catch (JSONException e)
            {

                e.printStackTrace();
            }
        }


        init();


    }







    private void init() {


        try {
            mPager = (ViewPager) getActivity().findViewById(R.id.pager);
            mPager.setAdapter(new SlidingImage_Adapter(getActivity(),sampleNetworkImageURLs));

            CirclePageIndicator indicator = (CirclePageIndicator)
                    getActivity().findViewById(R.id.indicator);

            indicator.setViewPager(mPager);

            final float density = getResources().getDisplayMetrics().density;

//Set circle indicator radius
            indicator.setRadius(5 * density);

            NUM_PAGES = sampleNetworkImageURLs.length;

            // Auto start of viewpager
            final Handler handler = new Handler();
            final Runnable Update = new Runnable() {
                public void run() {
                    if (currentPage == NUM_PAGES) {
                        currentPage = 0;
                    }
                    mPager.setCurrentItem(currentPage++, true);
                }
            };
            Timer swipeTimer = new Timer();
            swipeTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    // handler.post(Update);
                }
            }, 5000, 5000);

            // Pager listener over indicator
            indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

                @Override
                public void onPageSelected(int position) {
                    currentPage = position;

                }

                @Override
                public void onPageScrolled(int pos, float arg1, int arg2) {

                }

                @Override
                public void onPageScrollStateChanged(int pos) {

                }
            });
        }
        catch (Exception ex){

        }


    }










    Intent Intent;
    @Override
    public void click2(View v, int position) {
        getDataAdapter=GetDataAdapter1.get(position);

     String DATA2=   getDataAdapter.getProblemDetail();

     Log.e("DATA2",DATA2);
            if(DATA2.equals("นัดเก็บเงินงวด2")){

            }

//        if(position==0){
//            Intent = new Intent(getActivity(), Detali_check1.class);
//            Bundle bun = new Bundle();
//             bun.putString("conno", conno);
//            bun.putString("FnYear", FnYear);
//            bun.putString("FnMonth", FnMonth);
//            bun.putString("customer", customer);
//
//            bun.putString("Outstanding", Outstanding);
//            bun.putString("PayLastPeriod", PayLastPeriod);
//            bun.putString("ProcessTypeID", getDataAdapter.getProcessTypeID());
//
//
//
//            Intent.putExtras(bun);
//            startActivityForResult(Intent, 23);
//        }
//        else if(position==1){
//            Intent = new Intent(getActivity(), Detali_check2.class);
//            Bundle bun = new Bundle();
//            bun.putString("conno", conno);
//            bun.putString("FnYear", FnYear);
//            bun.putString("FnMonth", FnMonth);
//            bun.putString("customer", customer);
//
//            bun.putString("Outstanding", Outstanding);
//            bun.putString("PayLastPeriod", PayLastPeriod);
//            bun.putString("ProcessTypeID", getDataAdapter.getProcessTypeID());
//            Intent.putExtras(bun);
//            startActivityForResult(Intent, 23);
//        }
//        else if(position==2){
//            Intent = new Intent(getActivity(), Detali_check3.class);
//            Bundle bun = new Bundle();
//            bun.putString("conno", conno);
//            bun.putString("FnYear", FnYear);
//            bun.putString("FnMonth", FnMonth);
//            bun.putString("customer", customer);
//
//            bun.putString("Outstanding", Outstanding);
//            bun.putString("PayLastPeriod", PayLastPeriod);
//            bun.putString("ProcessTypeID", getDataAdapter.getProcessTypeID());
//            Intent.putExtras(bun);
//            startActivityForResult(Intent, 23);
//        }



    }
    int setlist = 0;
    @Override
    public void onClick(View v) {
        if(v==fab){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {


                //recyclerViewadapter = new RecyclerViewAdapter5(getActivity());
                //recyclerView.setAdapter(recyclerViewadapter);

                setlist++;
                Log.e("setlist", String.valueOf(setlist));
                if (setlist > 1) {
                    setlist = 0;
                }
                if (setlist == 0) {
                    fab.setImageResource(R.drawable.ic_edit_white_24dp);
                    ContactAdapter.color = 0xff999999;

                edit1.setVisibility(View.GONE);
                    edit2.setVisibility(View.GONE);
                    edit3.setVisibility(View.GONE);
                    edit4.setVisibility(View.GONE);
                    edit5.setVisibility(View.GONE);
                    edit6.setVisibility(View.GONE);
                    edit7.setVisibility(View.GONE);
                    edit8.setVisibility(View.GONE);
                    edit9.setVisibility(View.GONE);
                    edit10.setVisibility(View.GONE);
                  //  LinearLayout_data1.setVisibility(View.VISIBLE);
                   // LinearLayout_data12.setVisibility(View.GONE);
                   // GetDataAdapter1.clear();
                  //  JSON_DATA_WEB_CALL();
                    txtname_sale.setVisibility(View.VISIBLE);
                    txt_codeteam.setVisibility(View.VISIBLE);
                    txt_conno.setVisibility(View.VISIBLE);
                    txt_productname.setVisibility(View.VISIBLE);
                    txt_status.setVisibility(View.VISIBLE);
                    txt_customer.setVisibility(View.VISIBLE);
                    txt_idcard.setVisibility(View.VISIBLE);
                    txt_address.setVisibility(View.VISIBLE);
                    txt_phone.setVisibility(View.VISIBLE);
                    txt_phone2.setVisibility(View.VISIBLE);
                    txt_date.setVisibility(View.VISIBLE);


                    edit_text1.setVisibility(View.GONE);
                    edit_text2.setVisibility(View.GONE);
                    edit_text3.setVisibility(View.GONE);
                    edit_text4.setVisibility(View.GONE);
                    edit_text5.setVisibility(View.GONE);
                    edit_text6.setVisibility(View.GONE);
                    edit_text7.setVisibility(View.GONE);
                    edit_text8.setVisibility(View.GONE);
                    edit_text9.setVisibility(View.GONE);
                    image_tal1.setVisibility(View.GONE);
                    image_tal2.setVisibility(View.GONE);
                    image_mylocation.setVisibility(View.GONE);
                    image_mylocation_claer.setVisibility(View.GONE);
                   // linear_text_new.setVisibility(View.VISIBLE);
                    fab2.setVisibility(View.GONE);
 /*                   INSENT_checker_edit_custommer_all();

                    Toast toast = Toast.makeText(getActivity(), "บันทึกรายการเสร็จสิ้น", Toast.LENGTH_SHORT);
                    TextView v2 = (TextView) toast.getView().findViewById(android.R.id.message);
                    v2.setTextColor(Color.GREEN);
                    toast.show();

                    select_new_data();*/

                } else {
                    fab.setImageResource(R.drawable.ic_close_black_24dp);
                    ContactAdapter.color = 0xff000000;
                    //LinearLayout_data1.setVisibility(View.GONE);
                  //  LinearLayout_data12.setVisibility(View.VISIBLE);
                    edit1.setVisibility(View.GONE);
                    edit2.setVisibility(View.GONE);
                    edit3.setVisibility(View.GONE);
                    edit4.setVisibility(View.GONE);
                    edit5.setVisibility(View.VISIBLE);
                    edit6.setVisibility(View.VISIBLE);
                    edit7.setVisibility(View.VISIBLE);
                    edit8.setVisibility(View.VISIBLE);
                    edit9.setVisibility(View.VISIBLE);
                    edit10.setVisibility(View.VISIBLE);
                    fab2.setVisibility(View.VISIBLE);
                  //  linear_text_new.setVisibility(View.VISIBLE);

                    image_tal1.setVisibility(View.VISIBLE);
                    image_tal2.setVisibility(View.VISIBLE);
                    image_mylocation.setVisibility(View.GONE);
                    image_mylocation_claer.setVisibility(View.GONE);
                    //GetDataAdapter1.clear();
                    //JSON_DATA_WEB_CALL();

                }


            }

        }


        if(v==fab2){
         //   if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            setlist++;
            Log.e("setlist", String.valueOf(setlist));
            if (setlist > 1) {
                setlist = 0;
            }
                //recyclerViewadapter = new RecyclerViewAdapter5(getActivity());
                //recyclerView.setAdapter(recyclerViewadapter);

/*                setlist++;
                Log.e("setlist", String.valueOf(setlist));
                if (setlist > 1) {
                    setlist = 0;
                }*/
           /*     if (setlist == 0) {*/
                    fab.setImageResource(R.drawable.ic_edit_white_24dp);
                    ContactAdapter.color = 0xff999999;

                    edit1.setVisibility(View.GONE);
                    edit2.setVisibility(View.GONE);
                    edit3.setVisibility(View.GONE);
                    edit4.setVisibility(View.GONE);
                    edit5.setVisibility(View.GONE);
                    edit6.setVisibility(View.GONE);
                    edit7.setVisibility(View.GONE);
                    edit8.setVisibility(View.GONE);
                    edit9.setVisibility(View.GONE);
                    edit10.setVisibility(View.GONE);
                    //  LinearLayout_data1.setVisibility(View.VISIBLE);
                    // LinearLayout_data12.setVisibility(View.GONE);
                    // GetDataAdapter1.clear();
                    //  JSON_DATA_WEB_CALL();
                    txtname_sale.setVisibility(View.VISIBLE);
                    txt_codeteam.setVisibility(View.VISIBLE);
                    txt_conno.setVisibility(View.VISIBLE);
                    txt_productname.setVisibility(View.VISIBLE);
                    txt_status.setVisibility(View.VISIBLE);
                    txt_customer.setVisibility(View.VISIBLE);
                    txt_idcard.setVisibility(View.VISIBLE);
                    txt_address.setVisibility(View.VISIBLE);
                    txt_phone.setVisibility(View.VISIBLE);
                    txt_phone2.setVisibility(View.VISIBLE);
                    txt_date.setVisibility(View.VISIBLE);


                    edit_text1.setVisibility(View.GONE);
                    edit_text2.setVisibility(View.GONE);
                    edit_text3.setVisibility(View.GONE);
                    edit_text4.setVisibility(View.GONE);
                    edit_text5.setVisibility(View.GONE);
                    edit_text6.setVisibility(View.GONE);
                    edit_text7.setVisibility(View.GONE);
                    edit_text8.setVisibility(View.GONE);
                    edit_text9.setVisibility(View.GONE);
                    image_tal1.setVisibility(View.GONE);
                    image_tal2.setVisibility(View.GONE);
                    image_mylocation.setVisibility(View.GONE);
                    image_mylocation_claer.setVisibility(View.GONE);
                    linear_text_new.setVisibility(View.VISIBLE);
                    INSENT_checker_edit_custommer_all();

                    Toast toast = Toast.makeText(getActivity(), "บันทึกรายการเสร็จสิ้น", Toast.LENGTH_SHORT);
                    TextView v2 = (TextView) toast.getView().findViewById(android.R.id.message);
                    v2.setTextColor(Color.GREEN);
                    toast.show();

                    select_new_data();

                    fab2.setVisibility(View.GONE);
       /*         } else {
                    fab.setImageResource(R.drawable.ic_save_white_24dp);
                    ContactAdapter.color = 0xff000000;
                    //LinearLayout_data1.setVisibility(View.GONE);
                    //  LinearLayout_data12.setVisibility(View.VISIBLE);
                    edit1.setVisibility(View.GONE);
                    edit2.setVisibility(View.GONE);
                    edit3.setVisibility(View.GONE);
                    edit4.setVisibility(View.GONE);
                    edit5.setVisibility(View.VISIBLE);
                    edit6.setVisibility(View.VISIBLE);
                    edit7.setVisibility(View.VISIBLE);
                    edit8.setVisibility(View.VISIBLE);
                    edit9.setVisibility(View.VISIBLE);
                    edit10.setVisibility(View.VISIBLE);
                    linear_text_new.setVisibility(View.VISIBLE);

                    image_tal1.setVisibility(View.VISIBLE);
                    image_tal2.setVisibility(View.VISIBLE);
                    image_mylocation.setVisibility(View.GONE);
                    image_mylocation_claer.setVisibility(View.GONE);
                    //GetDataAdapter1.clear();
                    //JSON_DATA_WEB_CALL();

                }*/


           // }

        }

        else if(v==edit1){
            edit_text1.setVisibility(View.VISIBLE);
            txtname_sale.setVisibility(View.GONE);

            //txtname_sale.setCursorVisible(false);
            edit_text1.requestFocus();
            edit_text1.setText(SaleEmployeeName);



        }
        else if(v==edit2){
            edit_text2.setVisibility(View.VISIBLE);
            txt_codeteam.setVisibility(View.GONE);
            edit_text2.requestFocus();


            edit_text2.setText(SaleTeamCode);

         //   edit_text2.setSelection(1);
        }
        else if(v==edit3){
            edit_text3.setVisibility(View.VISIBLE);
            txt_conno.setVisibility(View.GONE);
            edit_text3.requestFocus();
            edit_text3.setText(conno);

        }

        else if(v==edit4){
            edit_text4.setVisibility(View.VISIBLE);
            txt_productname.setVisibility(View.GONE);
            edit_text4.requestFocus();
            edit_text4.setText(productname);

        }
        else if(v==edit5){

            edit_text5.setVisibility(View.VISIBLE);
            txt_customer.setVisibility(View.GONE);
            edit_text5.requestFocus();
            edit_text5.setText(customer);

        }
        else if(v==edit6){
            edit_text6.setVisibility(View.VISIBLE);
            txt_idcard.setVisibility(View.GONE);
            edit_text6.requestFocus();
            edit_text6.setText(idcard);

        }
        else if(v==edit7){
            edit_text7.setVisibility(View.VISIBLE);
            txt_phone.setVisibility(View.GONE);
            edit_text7.requestFocus();
            edit_text7.setText(phone_home);
        }
        else if(v==edit8){
            edit_text8.setVisibility(View.VISIBLE);
            txt_address.setVisibility(View.GONE);
            edit_text8.requestFocus();
            edit_text8.setText(address);
        }
        else if(v==edit9){
            edit_text9.setVisibility(View.VISIBLE);
            txt_phone2.setVisibility(View.GONE);
            edit_text9.requestFocus();
            edit_text9.setText(phone_mobile);
        }
        else if(v==edit10){
            edit_text10.setVisibility(View.VISIBLE);
            txt_mylocation.setVisibility(View.GONE);

           // edit_text10.setSelection(edit_text10.getText().length());
          //  edit_text10.requestFocus();
          //  edit_text10.setText(Latitude+","+Longitude);
            image_mylocation.setVisibility(View.VISIBLE);
            image_mylocation_claer.setVisibility(View.VISIBLE);
            try {
                if(Latitude.equals("0.0")){
                    edit_text10.setText("ไม่มีตำแหน่ง");
                }
                else {
                    edit_text10.setText(Latitude+","+Longitude);
                }
            }
            catch (Exception ex){
                edit_text10.setText("ไม่มีตำแหน่ง");
            }




        }
        else if(v==txt_phone){
/*
            Intent Intent = new Intent(getActivity(), Activity_Call.class);
            Bundle bun = new Bundle();
            bun.putString("number", phone_home);
            Intent.putExtras(bun);
            startActivity(Intent);
*/


            try
            {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                {
                    if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling

                        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, CALL_REQUEST);

                        return;
                    }
                }

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + phone_home));
                startActivity(callIntent);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }

        }
        else if(v==txt_phone2){
/*            Intent Intent = new Intent(getActivity(), Activity_Call.class);
            Bundle bun = new Bundle();
            bun.putString("number", phone_mobile);
            Intent.putExtras(bun);
            startActivity(Intent);*/

            try
            {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                {
                    if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling

                        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, CALL_REQUEST2);

                        return;
                    }
                }

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + phone_mobile));
                startActivity(callIntent);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        else if(v==image_tal1){
   /*         Intent Intent = new Intent(getActivity(), Activity_Call.class);
            Bundle bun = new Bundle();
            bun.putString("number", phone_home);
            Intent.putExtras(bun);
            startActivity(Intent);*/

            try
            {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                {
                    if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling

                        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, CALL_REQUEST);

                        return;
                    }
                }

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + phone_home));
                startActivity(callIntent);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        else if(v==image_tal2){
         /*   Intent Intent = new Intent(getActivity(), Activity_Call.class);
            Bundle bun = new Bundle();
            bun.putString("number", phone_mobile);
            Intent.putExtras(bun);
            startActivity(Intent);*/


            try
            {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                {
                    if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling

                        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, CALL_REQUEST2);

                        return;
                    }
                }

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + phone_mobile));
                startActivity(callIntent);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }

     else if(v==image_mylocation){
             latitude = currentLoc.latitude;
            longitude = currentLoc.longitude;
            edit_text10.setText(latitude+","+longitude);

        }
        else if(v==image_mylocation_claer){
            try {
                if(Latitude.equals("0.0")){
                    edit_text10.setText("ไม่มีตำแหน่ง");
                }
                else {
                    edit_text10.setText(Latitude+","+Longitude);
                }
            }
            catch (Exception ex){
                edit_text10.setText("ไม่มีตำแหน่ง");
            }
        }


        else if(v==data_old){

            txtname_sale.setText(SaleEmployeeName);
            txt_codeteam.setText(SaleTeamCode);
            txt_conno.setText(conno);
            txt_productname.setText(productname);
            txt_status.setText("รอตรวจสอบ");
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
            txt_phone.setText(phone_home);
            txt_phone2.setText(phone_mobile);
            try {
                if(Latitude.equals("0.0")){
                    txt_mylocation.setText("ไม่มีตำแหน่ง");
                }
                else {
                    txt_mylocation.setText(Latitude + "," + Longitude);
                }
            }
            catch (Exception ex){
                txt_mylocation.setText("ไม่มีตำแหน่ง");
            }


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
                    //Log.e("dateThai",dateThai_day+""+dateThai_month1+""+converted_dateThai11+"");
                }
            }
            catch (Exception ex){

            }

        }

        else if(v==data_new){


            txtname_sale.setText(SaleEmployeeName);
            txt_codeteam.setText(SaleTeamCode);
            txt_conno.setText(Contno_N);
            txt_productname.setText(productname);
            txt_status.setText("รอตรวจสอบ");




            txt_customer.setText(CustomerName_N);
            txt_idcard.setText(IDCard_N);
            txt_address.setText(AddressDetail_N);
            txt_phone.setText(TelHome_N);
            txt_phone2.setText(TelMobile_N);
            txt_mylocation.setText(Latitude_N + "," + Longitude_N);



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
                    //Log.e("dateThai",dateThai_day+""+dateThai_month1+""+converted_dateThai11+"");
                }
            }
            catch (Exception ex){

            }

        }

    }

    String TopicID="";
    public void JSON_DATA_WEB_CALL22(){
        // = MyApplication.getInstance().getPrefManager().getPreferrence("TopicID");
        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.JSON_DATA_WEB_CALL22__Check_Fragment1_2+"?TopicID="+TopicID+"&Contno="+conno,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_WEBCALL22(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue = Volley.newRequestQueue(getActivity());

        requestQueue.add(jsonArrayRequest);
//        swipeRefreshLayout.setRefreshing(false);
    }




    public void JSON_PARSE_DATA_AFTER_WEBCALL22(JSONArray array){
        //  pDialog = new ProgressDialog(getActivity());
        // Showing progress dialog before making http request
        //  pDialog.setMessage("กำลังโหลดข้อมูล...");
        //  pDialog.show();
        getData_image_more_for_delates_checker4.clear();
        for(int i = 0; i<array.length(); i++) {

            GetData_cedit_dialog_image_problem_from_id_checker4 dataCeditDialogImageProblemFromId = new GetData_cedit_dialog_image_problem_from_id_checker4();
            // GetDataAdapter1.clear();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);
                //     Log.e(TAG,"หมู json array"+json.getJSONObject("InstallDate").getString("date"));
                dataCeditDialogImageProblemFromId.setImage_id_all(json.getString("URL"));
                getData_image_more_for_delates_checker4.add(dataCeditDialogImageProblemFromId);



            } catch (JSONException e) {

                e.printStackTrace();
            }
           // getData_image_more_for_delates_checker4.add(GetDataAdapter2);

        }

/*
        recyclerViewadapter = new RecyclerViewAdapter_type_check_susscess(GetDataAdapter1, getActivity());

        recyclerView.setAdapter(recyclerViewadapter);
        recyclerViewadapter.setitemclick2(this);
        recyclerViewadapter.setitemclick_image_problem_incorrect(this);

*/






      //  getData_image_more_for_delates_checker4.clear();


        dialog_image4 = new Dialog(getActivity());
        dialog_image4.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog_image4.setContentView(R.layout.mp3_online_list_single_recycleview_dialog_custom_image_problem);
        dialog_image4.setCancelable(true);
        final TextView counter = (TextView) dialog_image4.findViewById(R.id.counter);
        final RelativeLayout close = (RelativeLayout) dialog_image4.findViewById(R.id.close);


        final RecyclerView recycler_view = (RecyclerView) dialog_image4.findViewById(R.id.recycler_view);

        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));




        counter.setText(getData_image_more_for_delates_checker4.size() + "");

        recyclerViewDataAdapter_dialog_image_problem_from_id_checker4 = new RecyclerViewDataAdapter_dialog_image_problem_from_id_checker444(getActivity(), getData_image_more_for_delates_checker4);
        recycler_view.setAdapter(recyclerViewDataAdapter_dialog_image_problem_from_id_checker4);
        recyclerViewDataAdapter_dialog_image_problem_from_id_checker4.setitemclick_deleteAll2(this);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_image4.dismiss();
            }
        });


        dialog_image4.show();



    }
    Dialog dialog_image4;
    @Override
    public void click_image_problem_incorrect(View v, int position) {
        getDataAdapter = GetDataAdapter1.get(position);
        TopicID=getDataAdapter.getTopicID();
        Log.e("3333","4444");
        JSON_DATA_WEB_CALL22();
    }

    @Override
    public void click_deleteAll_id_checker4(View v, int position) {
      //  JSON_DATA_WEB_CALL22();
    }


    TextView date222,date2,txt_day_nad2;
    long noOfDaysBetween = 0;
    float dayCount;
    String  date_new_format_thai2="",date2_s="";
    String  date3_s="";
    String PayNextDate22="";
    @Override
    public void click_edit(View v, int position) {







        DateFormat df3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date3 = df3.format(Calendar.getInstance().getTime());

        PayNextDate22=date3;








        Dialog   dialog_edit = new Dialog(getActivity());
        dialog_edit.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog_edit.setContentView(R.layout.custom_dialog_edit_pay2);
        dialog_edit.setCancelable(true);



        final LinearLayout li_pay_two = (LinearLayout) dialog_edit.findViewById(R.id.li_pay_two);
        final LinearLayout li_pay_two2 = (LinearLayout) dialog_edit.findViewById(R.id.li_pay_two2);
        final LinearLayout li_pay2 = (LinearLayout) dialog_edit.findViewById(R.id.li_pay2);
        final LinearLayout li_saddve = (LinearLayout) dialog_edit.findViewById(R.id.li_saddve);

        date222 = (TextView) dialog_edit.findViewById(R.id.date222);
        date2 = (TextView) dialog_edit.findViewById(R.id.date2);
        txt_day_nad2 = (TextView) dialog_edit.findViewById(R.id.txt_day_nad2);
        final ImageView  image_tal3= (ImageView) dialog_edit.findViewById(R.id.image_tal3);






        try {



            SimpleDateFormat input22 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat output22 = new SimpleDateFormat("yyyy-MM-dd");
            try {
                oneWayTripDate = input22.parse(date);  // parse input

            } catch (ParseException e) {
                e.printStackTrace();
            }


            date_new_format_thai2=output22.format(oneWayTripDate);

            //  Log.e("date_new_format_thai", date_new_format_thai);


            if (date_new_format_thai2.indexOf(date_new_format_thai2) != -1) {
                String arr2[] = date_new_format_thai2.split("-");
                dateThai_year = arr2[0];
                dateThai_month = arr2[1];
                dateThai_day = arr2[2];


                converted_dateThai11 = Integer.parseInt(dateThai_year);
                converted_dateThai11 = converted_dateThai11 + 543;

                if (dateThai_month.equals("01")) {
                    dateThai_month1 = "ม.ค.";
                } else if (dateThai_month.equals("02")) {
                    dateThai_month1 = "ก.พ.";
                } else if (dateThai_month.equals("03")) {
                    dateThai_month1 = "มี.ค.";
                } else if (dateThai_month.equals("04")) {
                    dateThai_month1 = "เม.ย.";
                } else if (dateThai_month.equals("05")) {
                    dateThai_month1 = "พ.ค.";
                } else if (dateThai_month.equals("06")) {
                    dateThai_month1 = "มิ.ย.";
                } else if (dateThai_month.equals("07")) {
                    dateThai_month1 = "ก.ค.";
                } else if (dateThai_month.equals("08")) {
                    dateThai_month1 = "ส.ค.";
                } else if (dateThai_month.equals("09")) {
                    dateThai_month1 = "ก.ย.";
                } else if (dateThai_month.equals("10")) {
                    dateThai_month1 = "ต.ค.";
                } else if (dateThai_month.equals("11")) {
                    dateThai_month1 = "พ.ย.";
                } else if (dateThai_month.equals("12")) {
                    dateThai_month1 = "ธ.ค.";
                }



                date222.setText(dateThai_day + " " + dateThai_month1 + converted_dateThai11);
                //  Viewholder.icon_time.setBackgroundResource(0);
                // Log.e("dateThai",dateThai_day+""+dateThai_month1+""+converted_dateThai11+"");



            }
        } catch (Exception ex) {

        }
















        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(Calendar.getInstance().getTime());




        try {



            if (date.indexOf(date) != -1) {
                String arr2[] = date.split("-");
                dateThai_year = arr2[0];
                dateThai_month = arr2[1];
                dateThai_day = arr2[2];


                converted_dateThai11 = Integer.parseInt(dateThai_year);
                converted_dateThai11 = converted_dateThai11 + 543;

                if (dateThai_month.equals("01")) {
                    dateThai_month1 = "ม.ค.";
                } else if (dateThai_month.equals("02")) {
                    dateThai_month1 = "ก.พ.";
                } else if (dateThai_month.equals("03")) {
                    dateThai_month1 = "มี.ค.";
                } else if (dateThai_month.equals("04")) {
                    dateThai_month1 = "เม.ย.";
                } else if (dateThai_month.equals("05")) {
                    dateThai_month1 = "พ.ค.";
                } else if (dateThai_month.equals("06")) {
                    dateThai_month1 = "มิ.ย.";
                } else if (dateThai_month.equals("07")) {
                    dateThai_month1 = "ก.ค.";
                } else if (dateThai_month.equals("08")) {
                    dateThai_month1 = "ส.ค.";
                } else if (dateThai_month.equals("09")) {
                    dateThai_month1 = "ก.ย.";
                } else if (dateThai_month.equals("10")) {
                    dateThai_month1 = "ต.ค.";
                } else if (dateThai_month.equals("11")) {
                    dateThai_month1 = "พ.ย.";
                } else if (dateThai_month.equals("12")) {
                    dateThai_month1 = "ธ.ค.";
                }



                date2.setText(dateThai_day + " " + dateThai_month1 + converted_dateThai11);
                //  Viewholder.icon_time.setBackgroundResource(0);
                // Log.e("dateThai",dateThai_day+""+dateThai_month1+""+converted_dateThai11+"");



            }
        } catch (Exception ex) {

        }
















        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
        String  date22 = df2.format(Calendar.getInstance().getTime());
          date3_s=date22;









        String dateBeforeString =date3_s;
        String dateAfterString = date_new_format_thai2;

        Log.e("dateBeforeString",dateBeforeString+dateAfterString);

        //Parsing the date
        LocalDate dateBefore = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            dateBefore = LocalDate.parse(dateBeforeString);
        }
        LocalDate dateAfter = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            try {
                dateAfter = LocalDate.parse(dateAfterString);
            }
            catch (Exception EX){

            }

        }


        //calculating number of days in between

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            try {
                noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
                Log.e("noOfDaysBetween", String.valueOf(noOfDaysBetween));
            }
            catch (Exception ex){

            }

        }

        try {












           // getCountOfDays(dateBeforeString,dateAfterString);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

            Date createdConvertedDate = null, expireCovertedDate = null, todayWithZeroTime = null;
            try {
                createdConvertedDate = dateFormat.parse(dateBeforeString);
                expireCovertedDate = dateFormat.parse(dateAfterString);

                Date today = new Date();

                todayWithZeroTime = dateFormat.parse(dateFormat.format(today));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            int cYear = 0, cMonth = 0, cDay = 0;

            if (createdConvertedDate.after(todayWithZeroTime)) {
                Calendar cCal = Calendar.getInstance();
                cCal.setTime(createdConvertedDate);
                cYear = cCal.get(Calendar.YEAR);
                cMonth = cCal.get(Calendar.MONTH);
                cDay = cCal.get(Calendar.DAY_OF_MONTH);

            } else {
                Calendar cCal = Calendar.getInstance();
                cCal.setTime(todayWithZeroTime);
                cYear = cCal.get(Calendar.YEAR);
                cMonth = cCal.get(Calendar.MONTH);
                cDay = cCal.get(Calendar.DAY_OF_MONTH);
            }



            Calendar eCal = Calendar.getInstance();
            eCal.setTime(expireCovertedDate);

            int eYear = eCal.get(Calendar.YEAR);
            int eMonth = eCal.get(Calendar.MONTH);
            int eDay = eCal.get(Calendar.DAY_OF_MONTH);

            Calendar date1 = Calendar.getInstance();
            Calendar date2 = Calendar.getInstance();

            date1.clear();
            date1.set(cYear, cMonth, cDay);
            date2.clear();
            date2.set(eYear, eMonth, eDay);

            long diff = date2.getTimeInMillis() - date1.getTimeInMillis();

            dayCount = 0-((float) diff / (24 * 60 * 60 * 1000));
            Log.e("dayCount", String.valueOf((int) dayCount));


            if((int) dayCount>60){
                txt_day_nad2.setText(" "+String.valueOf((int) dayCount)+" วัน");
                txt_day_nad2.setTextColor(0xffff0000);


            }
            else {
                txt_day_nad2.setText(" "+String.valueOf((int) dayCount)+" วัน");
                txt_day_nad2.setTextColor(0xff228b22);
            }






















        }
        catch (Exception ex){

        }























        image_tal3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {








                final Calendar calendar = Calendar.getInstance();
                int yy = calendar.get(Calendar.YEAR);
                int mm = calendar.get(Calendar.MONTH);
                int dd = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date2_s = "";
                        String month_s ="";
                        String dayOfMonth_s ="";
                        if(dayOfMonth<9){
                            dayOfMonth_s="0"+String.valueOf(dayOfMonth);
                        }
                        else {
                            dayOfMonth_s=String.valueOf(dayOfMonth);
                        }
                        if(month<9){
                            month_s="0"+String.valueOf(month+1);
                        }
                        else {
                            month_s=String.valueOf(month+1);
                        }
                        date2_s= dayOfMonth_s+"-"+month_s+"-"+String.valueOf(year);
                        date3_s=String.valueOf(year)+"-"+month_s+"-"+dayOfMonth_s;





                        try {

                            String FF= String.valueOf(year)+"-"+month_s+"-"+dayOfMonth_s;



                            if (FF.indexOf(FF) != -1) {
                                String arr2[] = FF.split("-");
                                dateThai_year = arr2[0];
                                dateThai_month = arr2[1];
                                dateThai_day = arr2[2];


                                converted_dateThai11 = Integer.parseInt(dateThai_year);
                                converted_dateThai11 = converted_dateThai11 + 543;

                                if (dateThai_month.equals("01")) {
                                    dateThai_month1 = "ม.ค.";
                                } else if (dateThai_month.equals("02")) {
                                    dateThai_month1 = "ก.พ.";
                                } else if (dateThai_month.equals("03")) {
                                    dateThai_month1 = "มี.ค.";
                                } else if (dateThai_month.equals("04")) {
                                    dateThai_month1 = "เม.ย.";
                                } else if (dateThai_month.equals("05")) {
                                    dateThai_month1 = "พ.ค.";
                                } else if (dateThai_month.equals("06")) {
                                    dateThai_month1 = "มิ.ย.";
                                } else if (dateThai_month.equals("07")) {
                                    dateThai_month1 = "ก.ค.";
                                } else if (dateThai_month.equals("08")) {
                                    dateThai_month1 = "ส.ค.";
                                } else if (dateThai_month.equals("09")) {
                                    dateThai_month1 = "ก.ย.";
                                } else if (dateThai_month.equals("10")) {
                                    dateThai_month1 = "ต.ค.";
                                } else if (dateThai_month.equals("11")) {
                                    dateThai_month1 = "พ.ย.";
                                } else if (dateThai_month.equals("12")) {
                                    dateThai_month1 = "ธ.ค.";
                                }



                                date2.setText(dateThai_day + " " + dateThai_month1 + converted_dateThai11);


                            }
                        } catch (Exception ex) {

                        }


                        //PayNextDate22=date3_s+" 00:00:00.000";
//                        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
//                      String  date22 = df2.format(Calendar.getInstance().getTime());
//                     String   date3_s=date22;
//
//

                        PayNextDate22=date3_s+" 00:00:00.000";

                        String dateBeforeString =date3_s;
                        String dateAfterString = date_new_format_thai2;
                        //Parsing the date
                        LocalDate dateBefore = null;
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                            dateBefore = LocalDate.parse(dateBeforeString);
                        }
                        LocalDate dateAfter = null;
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                            dateAfter = LocalDate.parse(dateAfterString);
                        }



                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                            noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
                        }






                        Log.e("noOfDaysBetween", String.valueOf(noOfDaysBetween));





                       // getCountOfDays(dateBeforeString,dateAfterString);






                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

                        Date createdConvertedDate = null, expireCovertedDate = null, todayWithZeroTime = null;
                        try {
                            createdConvertedDate = dateFormat.parse(dateBeforeString);
                            expireCovertedDate = dateFormat.parse(dateAfterString);

                            Date today = new Date();

                            todayWithZeroTime = dateFormat.parse(dateFormat.format(today));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        int cYear = 0, cMonth = 0, cDay = 0;

                        if (createdConvertedDate.after(todayWithZeroTime)) {
                            Calendar cCal = Calendar.getInstance();
                            cCal.setTime(createdConvertedDate);
                            cYear = cCal.get(Calendar.YEAR);
                            cMonth = cCal.get(Calendar.MONTH);
                            cDay = cCal.get(Calendar.DAY_OF_MONTH);

                        } else {
                            Calendar cCal = Calendar.getInstance();
                            cCal.setTime(todayWithZeroTime);
                            cYear = cCal.get(Calendar.YEAR);
                            cMonth = cCal.get(Calendar.MONTH);
                            cDay = cCal.get(Calendar.DAY_OF_MONTH);
                        }



                        Calendar eCal = Calendar.getInstance();
                        eCal.setTime(expireCovertedDate);

                        int eYear = eCal.get(Calendar.YEAR);
                        int eMonth = eCal.get(Calendar.MONTH);
                        int eDay = eCal.get(Calendar.DAY_OF_MONTH);

                        Calendar date1 = Calendar.getInstance();
                        Calendar date2 = Calendar.getInstance();

                        date1.clear();
                        date1.set(cYear, cMonth, cDay);
                        date2.clear();
                        date2.set(eYear, eMonth, eDay);

                        long diff = date2.getTimeInMillis() - date1.getTimeInMillis();

                        dayCount = 0-((float) diff / (24 * 60 * 60 * 1000));
                        Log.e("dayCount", String.valueOf((int) dayCount));


                        if((int) dayCount>60){
                            txt_day_nad2.setText(" "+String.valueOf((int) dayCount)+" วัน");
                            txt_day_nad2.setTextColor(0xffff0000);


                        }
                        else {
                            txt_day_nad2.setText(" "+String.valueOf((int) dayCount)+" วัน");
                            txt_day_nad2.setTextColor(0xff228b22);
                        }





















                    }


                }, yy, mm, dd);
                datePicker.show();










            }
        });





        li_saddve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                       String day_details=String.valueOf((int) dayCount)+" วัน";
                       String AnswerID="";
                       Log.e("PayNextDate22",PayNextDate22);
                       Log.e("day_details",day_details);
                            if((int) dayCount>60){
                                AnswerID="30";
                            }
                            else {
                                AnswerID="21";
                            }

                       update_pay2(PayNextDate22,AnswerID,day_details);


                GetDataAdapter1.clear();
                JSON_DATA_WEB_CALL();



                dialog_edit.cancel();


            }
        });




        dialog_edit.show();



    }








 private void update_pay2(String PayNextDate22,String AnswerID,String AnswerNote){


     try {
         Log.e("url_update",API_URL_ALL.GET_JSON_UPDATE_MASTER_AND_DETAILS_CHECKER+"?Contno="+conno+"&PayNextDate="+URLEncoder.encode(PayNextDate22, "UTF-8")+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8"));
     } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
     }





     try {
         jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_UPDATE_MASTER_AND_DETAILS_CHECKER+"?Contno="+conno+"&PayNextDate="+URLEncoder.encode(PayNextDate22, "UTF-8")+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8"),


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
     } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
     }

     try {
         try {
             requestQueue = Volley.newRequestQueue(getActivity());
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




    protected boolean checkConnection(){
        boolean re=false;
        try{
            ConnectivityManager conMan = (ConnectivityManager) this.getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

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
    public void JSON_DATA_WEB_CALL(){
        String CheckerEmpID = MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL+"?CheckerEmpID="+CheckerEmpID+"&Contno="+conno,

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

        requestQueue = Volley.newRequestQueue(getActivity());

        requestQueue.add(jsonArrayRequest);
//        swipeRefreshLayout.setRefreshing(false);
    }




    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array){
        //  pDialog = new ProgressDialog(getActivity());
        // Showing progress dialog before making http request
        //  pDialog.setMessage("กำลังโหลดข้อมูล...");
        //  pDialog.show();
        GetDataAdapter1.clear();
        for(int i = 0; i<array.length(); i++) {

            Get_data_type_check GetDataAdapter2 = new Get_data_type_check();
            // GetDataAdapter1.clear();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);
                //     Log.e(TAG,"หมู json array"+json.getJSONObject("InstallDate").getString("date"));

                GetDataAdapter2.setTopicID(json.getString("TopicID"));
                GetDataAdapter2.setProcessTypeName(json.getString("ProcessTypeName"));
                GetDataAdapter2.setProcessTypeID(json.getString("TopicName"));
                GetDataAdapter2.setAnswerID(json.getString("AnswerID"));
                GetDataAdapter2.setData(json.getString("AnswerName"));
                GetDataAdapter2.setItems(json.getString("Items"));
                GetDataAdapter2.setImageUrl(json.getString("ImageUrl"));
                GetDataAdapter2.setImageType(json.getString("ImageType"));
                GetDataAdapter2.setURL(json.getString("URL"));
                GetDataAdapter2.setProblemDetail(json.getString("ProblemDetail"));
                GetDataAdapter2.setENTERDATE(json.getString("ENTERDATE"));

            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter2);

        }

        recyclerViewadapter = new RecyclerViewAdapter_type_check_susscess(GetDataAdapter1, getActivity());

        recyclerView.setAdapter(recyclerViewadapter);
        recyclerViewadapter.setitemclick2(this);
        recyclerViewadapter.setitemclick_image_problem_incorrect(this);
        recyclerViewadapter.setitemclick_edit(this);

    }




    private  void INSENT_checker_edit_custommer_all(){

        String Contno=conno;
        String CustomerName=edit_text5.getText().toString();
        if(CustomerName.isEmpty()){
            CustomerName=customer;
        }

        String IDCard=edit_text6.getText().toString();
        if(IDCard.isEmpty()){
            IDCard=idcard;
        }

        String TelHome=edit_text7.getText().toString();
        if(TelHome.isEmpty()){
            TelHome=phone_home;
        }

        String TelMobile=edit_text9.getText().toString();
        if(TelMobile.isEmpty()){
            TelMobile=phone_mobile;
        }
        String AddressDetail=edit_text8.getText().toString();
        if(AddressDetail.isEmpty()){
            AddressDetail=address;
        }






        String ipaddress2=MyApplication.getInstance().getPrefManager().getPreferrence("IPaddress")+"";
        String computername2=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";

        String ipaddress3="";
        String computername3="";
        //Toast.makeText(getActivity(), "IP :  " + ipaddress2, Toast.LENGTH_LONG).show();
        // int ff= Integer.parseInt(ipaddress2);

        if(ipaddress2.equals("null")){
            ipaddress3="-";
        }
        else {
            ipaddress3="-";
            //ipaddress=ipaddress2.substring(0, 15);
        }





        if(computername2.equals("null")){
            computername3="-";
        }
        else {
            //computername="android 6.0";
            computername3=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";
        }



        //jsonArrayRequest = new JsonArrayRequest(GET_JSON_insent_Problem_Inform_Details+"?InformID="+InformID_REAL+"&ProblemID="+part_id_details+"&ProblemTopic="+URLEncoder.encode(ProblemTopic, "UTF-8")+"&ProblemDetail="+URLEncoder.encode(ProblemDetail, "UTF-8")+"&CheckNote="+URLEncoder.encode(CheckNote, "UTF-8"),

        //url = "http://httpbin.org/post";
        String ipaddress = ipaddress3;
        String computername = computername3;
        String InformEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

        String latitude_ULOAD="";
        String longtitude_ULOAD="";

        try {
            if(latitude.equals("null")){
                latitude_ULOAD=Latitude;
                longtitude_ULOAD=Longitude;
            }
            else {
                latitude_ULOAD=latitude;
                longtitude_ULOAD=longitude;
            }
        }
        catch (Exception ex){
            latitude_ULOAD=Latitude;
            longtitude_ULOAD=Longitude;
        }



       try {
            Log.e("URL_Details_Images",API_URL_ALL.GET_JSON_INSENT_checker_edit_custommer_all+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&CustomerName="+URLEncoder.encode(CustomerName, "UTF-8")+"&IDCard="+IDCard+"&TelHome="+TelHome+"&TelMobile="+TelMobile+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&AddressDetail="+URLEncoder.encode(AddressDetail, "UTF-8")+"&Latitude="+latitude_ULOAD+"&Longitude="+longtitude_ULOAD);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

//MyApplication.getInstance().getPrefManager().getPreferrence("InformID")

        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_INSENT_checker_edit_custommer_all+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&CustomerName="+URLEncoder.encode(CustomerName, "UTF-8")+"&IDCard="+IDCard+"&TelHome="+TelHome+"&TelMobile="+TelMobile+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&AddressDetail="+URLEncoder.encode(AddressDetail, "UTF-8")+"&Latitude="+latitude_ULOAD+"&Longitude="+longtitude_ULOAD,


                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            //check_sucess_insert_image=1;

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                           // check_sucess_insert_image=0;
                        }
                    });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            try {
                requestQueue = Volley.newRequestQueue(getActivity());
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


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults)
    {
        if(requestCode == CALL_REQUEST)
        {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                try
                {
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                    {
                        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling

                            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, CALL_REQUEST);

                            return;
                        }
                    }

                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + phone_home));
                    startActivity(callIntent);
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
            else
            {
                Toast.makeText(getActivity(), getResources().getString(R.string.call_permission_denied_message), Toast.LENGTH_SHORT).show();
            }
        }

        else if(requestCode == CALL_REQUEST2){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                try
                {
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                    {
                        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling

                            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, CALL_REQUEST2);

                            return;
                        }
                    }

                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + phone_mobile));
                    startActivity(callIntent);
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
            else
            {
                Toast.makeText(getActivity(), getResources().getString(R.string.call_permission_denied_message), Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        currentLoc.connectGoogleApi();
    }

    @Override
    public void onStop() {
        super.onStop();
        currentLoc.disConnectGoogleApi();
    }


    private void select_new_data(){
        Log.e("yrl",API_URL_ALL.GET_JSON_DATA_HTTP_URL_select_new_data+"?Contno="+conno);
        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_select_new_data+"?Contno="+conno,

                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            JSON_PARSE_DATA_AFTER_WEBCALL_select_new_data(response);
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            select_new_data();
                        }
                    });

        try {
            try {
                requestQueue = Volley.newRequestQueue(getActivity());
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


    public void JSON_PARSE_DATA_AFTER_WEBCALL_select_new_data(JSONArray array){
            int count_data_new=array.length();
            if(count_data_new>0){
                linear_text_new.setVisibility(View.VISIBLE);
            }
            else {
                linear_text_new.setVisibility(View.GONE);
            }
        Log.e("count_data_new", String.valueOf(count_data_new));
        for(int i = 0; i<array.length(); i++) {

            Get_data_type_check GetDataAdapter2 = new Get_data_type_check();
            // GetDataAdapter1.clear();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);

                 FnYear_N=json.getString("FnYear");
                 FnMonth_N =json.getString("FnMonth");
                 Contno_N=json.getString("Contno");
                 CustomerName_N=json.getString("CustomerName");
                 IDCard_N=json.getString("IDCard");
                 AddressDetail_N=json.getString("AddressDetail");
                 Latitude_N=json.getString("Latitude");
                 Longitude_N=json.getString("Longitude");
                 TelHome_N=json.getString("TelHome");
                 TelMobile_N=json.getString("TelMobile");



            } catch (JSONException e) {

                e.printStackTrace();
            }


        }



    }








    String ScoreColorID="",Description="";
    private void select_color(){
        Log.e("yrl",API_URL_ALL.GET_JSON_DATA_HTTP_URL_select_color+"?Contno="+conno);
        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_select_color+"?Contno="+conno,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSON_PARSE_DATA_AFTER_WEBCALL_select_color(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        try {
                            select_color();
                        }
                        catch (Exception ex){

                        }

                    }
                });

        try {
            try {
                requestQueue = Volley.newRequestQueue(getActivity());
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
//        swipeRefreshLayout.setRefreshing(false);
    }


    public void JSON_PARSE_DATA_AFTER_WEBCALL_select_color(JSONArray array){
        int count_data_new=array.length();
        if(count_data_new>0){


            if(CheckerStatus.equals("99")){
                //txt_status.setText("ตรวจสอบแล้วไม่ผ่าน");
                li_line7.setVisibility(View.VISIBLE);
                li_line8.setVisibility(View.VISIBLE);
            }
            else {
                li_line7.setVisibility(View.VISIBLE);
                li_line8.setVisibility(View.VISIBLE);
            }

        }
        else {
            li_line7.setVisibility(View.GONE);
            li_line8.setVisibility(View.GONE);
        }
        Log.e("count_data_new", String.valueOf(count_data_new));
        for(int i = 0; i<array.length(); i++) {

            Get_data_type_check GetDataAdapter2 = new Get_data_type_check();
            // GetDataAdapter1.clear();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);

                ScoreColorID=json.getString("ScoreColorID");
                Description =json.getString("Description");




            } catch (JSONException e) {

                e.printStackTrace();
            }


        }
        cc2.setText(Description);

        if(ScoreColorID.equals("01")){
            cc1.setBackgroundResource(R.drawable.bg_circle);
            //count1.setText("✔");
        }
       else if(ScoreColorID.equals("02")){
            cc1.setBackgroundResource(R.drawable.bg_circle30);
        }
       else if(ScoreColorID.equals("03")){
            cc1.setBackgroundResource(R.drawable.bg_circle01);
        }



    }






    }
