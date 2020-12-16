package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.tsr.tsrproblemreport_tossticket_checker.API_URL_ALL;
import com.tsr.tsrproblemreport_tossticket_checker.BuildConfig;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.RecyclerViewDataAdapter5;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.RecyclerViewDataAdapter6;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.RecyclerViewDataAdapter_dialog_image_problem_from_id2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.databases.SQLiteHelper_image_buffer;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.databases.SQLiteHelper_problem_id_image;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.DATA_mp3;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_delete_image_respon;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_dialog_image_problem_from_id;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_sale_edit_problem;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_check_problem;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_image_more_for_delate;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_image_new;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_uploade_Image;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.SectionDataModel;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.SectionDataModel2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.SingleItemModel;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.SingleItemModel2;
//import com.tsr.tsrproblemreport.cedit_all_problem_from_web.uploads_image.Service;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.utils.ImageConfiguration;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.utils.MarshMallowPermission;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.CircleTransform;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.EndPoints;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import cn.pedant.SweetAlert.SweetAlertDialog;
import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;
import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltipUtils;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tech.gusavila92.websocketclient.WebSocketClient;

/**
 * Created by user on 25/1/2561.
 */

public class Activity_edit_problem_from_sale extends AppCompatActivity implements View.OnClickListener ,RecyclerViewDataAdapter6.itemclick_deleteAll,RecyclerViewDataAdapter_dialog_image_problem_from_id2.itemclick_deleteAll2,RecyclerViewDataAdapter5.itemclick_deleteAll3{
    ArrayList<SectionDataModel> allSampleData;
    ArrayList<SingleItemModel> singleItem;

    ArrayList<SectionDataModel2> allSampleData2;
    ArrayList<SingleItemModel2> singleItem2;

    List<GetData_cedit_sale_edit_problem> GetDataAdapter1;
    GetData_cedit_sale_edit_problem getData_cedit_sale_edit_problem;

    List<GetData_cedit_dialog_image_problem_from_id> getData_cedit_dialog_image_problem_from_ids;
    List<GetData_check_problem> getData_check_problems;

    List<GetData_cedit_dialog_image_problem_from_id> getData_image_more_for_delates;
    List<GetData_image_more_for_delate> getDataImageMoreForDelates;

    GetData_image_more_for_delate getData_image_more_for_delate;
    GetData_cedit_dialog_image_problem_from_id data_cedit_dialog_image_problem_from_id;
    RecyclerViewDataAdapter_dialog_image_problem_from_id2 recyclerViewDataAdapter_dialog_image_problem_from_id;
    RecyclerViewDataAdapter_dialog_image_problem_from_id2 recyclerViewDataAdapter_dialog_image_problem_from_id2;
    List<GetData_image_new> getData_image_news;
    GetData_image_new getDataImageNew;

    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;

    String ID = "", Gory = "", Main = "", Sub = "", Detail = "",
            conno = "", InformID_S = "", Contno_S = "", WorkCode_S = "",
            WorkName_S = "", date_time_S = "",Items_R="",user_code="",
            getPicture="",getEmployeeName="",getPositionName="",
            new_message_main_S="",ProblemDetail3="",ProblemDetail4="",
            customer_S="",tel_S="",tel2_S="",address_S="",eff_date_S="";



    String date_new_format_thai, date_new_format_thai2;
    String dateThai_year, dateThai_month, dateThai_day, dateThai_month1;
    int converted_dateThai11;
    private Date oneWayTripDate;
    String s1, s2, s3;

    ImageView image;
    RecyclerView my_recycler_view2, my_recycler_view;
    TextView txt_InformID, txt_contno, txt_status,
            txt_category, txt_main_problem, txt_sub_problem,
            txt_topic, txt_new_message, txt_status_closing, txt_datetime;
    RelativeLayout open_camera, r_save, r_delete,open_image;
    EditText new_message2;
    LinearLayout linear_coler, linear_status_closing;
    public static int size = 0;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    JsonArrayRequest jsonArrayRequest;
    RequestQueue requestQueue;


    public static final int CONNECTION_TIMEOUT=10000;
    public static final int READ_TIMEOUT=15000;






//UAT


/*
    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/UAT/select_image_problem_from_id_copy_real_UAT.php";
    String GET_JSON_DATA_HTTP_URL4 = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/UAT/select_image_problem_from_id_copy_of_details_real_UAT.php";
    String GET_JSON_insent_Problem_Respon_Details_Images = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/UAT/insent_Problem_Respon_Details_Images_copy_real_UAT.php";
    String GET_JSON_delete_Problem_Respon_Details_Images = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/UAT/delete_Problem_Respon_Details_Images_copy_real_UAT.php";
    String GET_JSON_select_id_from_Problem_Respon_Master = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/UAT/select_id_from_Problem_Respon_Master_copy_real_UAT.php";
    String GET_JSON_select_id_from_Problem_Respon_Details = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/UAT/select_id_from_Problem_Respon_Details_copy_real_UAT.php";
    String GET_JSON_UPDATE_from_Problem_Respon_Master = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/UAT/update_Problem_Respon_Master_copy_real_UAT.php";
    String GET_JSON_UPDATE_from_Problem_Respon_Details = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/UAT/update_Problem_Respon_Details_copy_real_UAT.php";
    String GET_JSON_select_empid_sent_problem_in_come = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/UAT/select_emp_sent_problem_in_come_UAT.php";

    String GET_JSON_sent_nontification_to_credit = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/firebase_nontification_sale_to_credit_by_edit_problem_UATDDDD/index.php";
    String GET_JSON_DATA_HTTP_URL_sent_nontification_to_web=" http://app.thiensurat.co.th/api/RealTimeDatabase_UATหหห/";
    String GET_JSON_sent_nontification_to_sale_all="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/firebase_nontification_sale_from_cedit_to_sale_all_UAT/index.php";
    String URL_non_to_web="ws://uat.thiensurat.co.th:3002หห";
*/






    private Service uploadService;
    SweetAlertDialog pDialogg;
   // private static final String SERVER_PATH = "http://app.thiensurat.co.th/assanee/";
    private static final String SERVER_PATH = "http://thiensurat.com/fileshare02/assanee/";
    List<GetData_uploade_Image> getData_uploade_images;
    RecyclerViewDataAdapter6 adapter2;

    List<GetData_cedit_delete_image_respon> getData_cedit_delete_image_respons;

    String InformID_DELETE_IMAGE_RESPON="",
            ProblemID_DELETE_IMAGE_RESPON="",
            DepartID_DELETE_IMAGE_RESPON="",
            Items_DELETE_IMAGE_RESPON="",
            ImageUrl_DELETE_IMAGE_RESPON="";
    String VersionOSM="";
    String PATH;


    public ImageView list_item_home_dislike;
    public ImageView list_item_home_menu;
    public ImageView list_item_home_foxy_img;
    public  TextView list_item_home_posted_name;
    public  TextView list_item_home_posted_txt;
    public  TextView txt_comment,new_message_main;

    public ImageView list_item_status_sale,list_item_history;
    public TextView new_message3,new_message4;
    public LinearLayout linear_sale3,linear_sale4,li_tel;

    int check_nonti_web=0;
    String details_problem_nonti_to_web="";

    protected  TextView txt_customer;
    protected  TextView txt_tel,txt_tel2;
    protected  TextView txt_address,txt_effdate;
    int check_buttom_remove_image=0;
    int size_image=0;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardview_row_cedit_cedit3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        VersionOSM = android.os.Build.VERSION.RELEASE;

        my_recycler_view2 = (RecyclerView) findViewById(R.id.my_recycler_view2);
        my_recycler_view = (RecyclerView) findViewById(R.id.my_recycler_view);

        txt_InformID = (TextView) findViewById(R.id.InformID);
        txt_contno = (TextView) findViewById(R.id.contno);
        txt_status = (TextView) findViewById(R.id.txt_status);

        txt_category = (TextView) findViewById(R.id.txt_category);
        txt_main_problem = (TextView) findViewById(R.id.txt_main_problem);
        txt_sub_problem = (TextView) findViewById(R.id.txt_sub_problem);
        txt_topic = (TextView) findViewById(R.id.txt_topic);
        txt_new_message = (TextView) findViewById(R.id.txt_new_message);
        txt_status_closing = (TextView) findViewById(R.id.txt_status_closing);
        txt_datetime = (TextView) findViewById(R.id.txt_datetime);
        open_camera = (RelativeLayout) findViewById(R.id.open_camera);
        open_image= (RelativeLayout) findViewById(R.id.open_image);
        r_save = (RelativeLayout) findViewById(R.id.r_save);
        r_delete = (RelativeLayout) findViewById(R.id.r_delete);
        new_message2 = (EditText) findViewById(R.id.new_message2);

        linear_coler = (LinearLayout) findViewById(R.id.linear_coler);
        linear_status_closing = (LinearLayout) findViewById(R.id.linear_status_closing);
        li_tel=findViewById(R.id.li_tel) ;


        list_item_home_foxy_img= (ImageView)findViewById(R.id.list_item_home_foxy_img);
        list_item_home_dislike= (ImageView)findViewById(R.id.list_item_home_dislike);
        list_item_home_menu= (ImageView)findViewById(R.id.list_item_home_menu);
        list_item_home_posted_name= (TextView)findViewById(R.id.list_item_home_posted_name) ;
        list_item_home_posted_txt= (TextView)findViewById(R.id.list_item_home_posted_txt) ;
        txt_comment= (TextView)findViewById(R.id.txt_comment) ;
        list_item_status_sale= (ImageView)findViewById(R.id.list_item_status_sale);
        new_message_main= (TextView)findViewById(R.id.new_message_main) ;

        new_message3= (TextView)findViewById(R.id.new_message3) ;
        new_message4= (TextView)findViewById(R.id.new_message4) ;
        linear_sale3= (LinearLayout)findViewById(R.id.linear_sale3) ;
        linear_sale4= (LinearLayout)findViewById(R.id.linear_sale4) ;
        list_item_history= (ImageView)findViewById(R.id.list_item_history);

        txt_customer = (TextView)findViewById(R.id.txt_customer) ;
        txt_tel = (TextView)findViewById(R.id.txt_tel) ;
        txt_tel2 = (TextView)findViewById(R.id.txt_tel2) ;
        txt_address = (TextView)findViewById(R.id.txt_address) ;
        txt_effdate= (TextView)findViewById(R.id.txt_effdate) ;

        allSampleData = new ArrayList<SectionDataModel>();
        singleItem = new ArrayList<SingleItemModel>();

        allSampleData2 = new ArrayList<SectionDataModel2>();
        singleItem2 = new ArrayList<SingleItemModel2>();
        getData_uploade_images = new ArrayList<>();
        getData_cedit_delete_image_respons= new ArrayList<>();

        getData_cedit_dialog_image_problem_from_ids=new ArrayList<>();
        getData_check_problems=new ArrayList<>();


        GetDataAdapter1= new ArrayList<>();
        getData_image_more_for_delates= new ArrayList<GetData_cedit_dialog_image_problem_from_id>();
        getDataImageMoreForDelates= new ArrayList<>();
        getData_image_news= new ArrayList<>();


        open_camera.setOnClickListener(this);
        open_image.setOnClickListener(this);
        r_save.setOnClickListener(this);
        r_delete.setOnClickListener(this);
        list_item_status_sale.setOnClickListener(this);
        list_item_history.setOnClickListener(this);
        my_recycler_view2.setHasFixedSize(true);
        RecyclerViewDataAdapter5 adapter = new RecyclerViewDataAdapter5(this, allSampleData);
        my_recycler_view2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        my_recycler_view2.setAdapter(adapter);


        my_recycler_view.setHasFixedSize(true);
        adapter2 = new RecyclerViewDataAdapter6(this, allSampleData2);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        my_recycler_view.setAdapter(adapter2);

       //adapter2.setitemclick_deleteAll(this);
        new_message2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(new_message2.getWindowToken(), 0);
                    new_message2.clearFocus();
                    return true;
                }
                return false;
            }
        });


        PackageManager m = getPackageManager();
        PATH = getPackageName();
        try {
            PackageInfo p = m.getPackageInfo(PATH, 0);
            PATH = p.applicationInfo.dataDir;
            Log.e("app path", PATH);
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("yourtag", "Error Package name not found ", e);
        }



        Bundle data = getIntent().getExtras();
        if (data != null) {
            ID = data.getString("ID");
            Gory = data.getString("Gory");
            Main = data.getString("Main");
            Sub = data.getString("Sub");
            Detail = data.getString("Detail");
            conno = data.getString("conno");

            InformID_S = data.getString("InformID");
            Contno_S = data.getString("Contno");
            WorkCode_S = data.getString("WorkCode");
            WorkName_S = data.getString("WorkName");
            date_time_S = data.getString("date_time");
            Items_R = data.getString("Items_R");
            user_code = data.getString("user_code");
            new_message_main_S= data.getString("new_message_main_S");
            getPicture = data.getString("getPicture");
            getEmployeeName = data.getString("getEmployeeName");
            getPositionName = data.getString("getPositionName");

            ProblemDetail3 = data.getString("ProblemDetail3");
            ProblemDetail4 = data.getString("ProblemDetail4");

            customer_S = data.getString("customer");
            tel_S = data.getString("tel");
            tel2_S = data.getString("tel2");
            address_S = data.getString("address");
            eff_date_S = data.getString("EffDate");

            details_problem_nonti_to_web=Sub;
            MyApplication.getInstance().getPrefManager().setPreferrence("contno_save", Contno_S);



            try {
                Glide.with(this).load(getPicture)
                        .crossFade()
                        .thumbnail(0.5f)
                        .bitmapTransform(new CircleTransform(this))
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(this.getResources().getDrawable(R.drawable.dasaa))
                        .into(list_item_home_foxy_img);
            }
            catch (Exception e) {

            }
           list_item_home_posted_name.setText(getEmployeeName);
           list_item_home_posted_txt.setText(getPositionName);

            txt_customer.setText(customer_S);
            txt_address.setText(address_S);

            try {
                txt_effdate.setText(eff_date_S);


            }
            catch (Exception e){

            }


            try {
                if(new_message_main_S.isEmpty()){
                    new_message_main.setText("-");
                }
                else {
                    new_message_main.setText(new_message_main_S);
                }
            }
            catch (Exception ex){

            }
            new_message3.setText(ProblemDetail3);
            new_message4.setText(ProblemDetail4);
            try {

                if ((ProblemDetail3.equals("null"))|(ProblemDetail3.isEmpty())){
                    linear_sale3.setVisibility(View.GONE);
                }
                else {
                    linear_sale3.setVisibility(View.VISIBLE);
                }

                if ((ProblemDetail4.equals("null"))|(ProblemDetail4.isEmpty())){
                    linear_sale4.setVisibility(View.GONE);
                }
                else {
                    linear_sale4.setVisibility(View.VISIBLE);
                }
            }
            catch (Exception EX){

            }

            txt_category.setText(Gory);
            txt_main_problem.setText(Main);
            txt_sub_problem.setText(Sub);
            txt_topic.setText(Detail);
            txt_new_message.setText(Detail);

            txt_status_closing.setText("รอดำเนินการ");
            txt_status_closing.setTextColor(0xffA9A9A9);
            linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);

            txt_InformID.setText(InformID_S);
            txt_contno.setText(Contno_S);

            if (WorkName_S.equals("null")) {
                txt_status.setText("ยังไม่ได้รับการอนุมัติ");

            } else {
                txt_status.setText(WorkName_S);

            }


            if (WorkCode_S.equals("00")) {
                linear_coler.setBackgroundResource(R.color.graysafe);

            } else if (WorkCode_S.equals("10")) {
                linear_coler.setBackgroundResource(R.color.colorPrimary);

            } else if (WorkCode_S.equals("21")) {
                linear_coler.setBackgroundResource(R.color.MediumTurquoise);

            } else if (WorkCode_S.equals("22")) {
                linear_coler.setBackgroundResource(R.color.Red);

            } else if (WorkCode_S.equals("23")) {
                linear_coler.setBackgroundResource(R.color.RoyalBlue);

            } else if (WorkCode_S.equals("24")) {
                linear_coler.setBackgroundResource(R.color.Blue);

            } else if (WorkCode_S.equals("25")) {
                linear_coler.setBackgroundResource(R.color.DarkBlue);

            } else if (WorkCode_S.equals("90")) {
                linear_coler.setBackgroundResource(R.color.Red);
                r_delete.setVisibility(View.VISIBLE);
            } else {


                linear_coler.setBackgroundResource(R.color.Yellow);
            }


            try {

                SimpleDateFormat input22 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat output22 = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat output33 = new SimpleDateFormat("HH:mm:ss");
                try {
                    oneWayTripDate = input22.parse(date_time_S);  // parse input

                } catch (ParseException e) {
                    e.printStackTrace();
                }


                date_new_format_thai = output22.format(oneWayTripDate);
                date_new_format_thai2 = output33.format(oneWayTripDate);

              //  Log.e("date_new_format_thai", date_new_format_thai);


                if (date_new_format_thai.indexOf(date_new_format_thai) != -1) {
                    String arr2[] = date_new_format_thai.split("-");
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


                    String fff = Utils.getSystemDateTextMonth();


                    if (fff.indexOf(fff) != -1) {
                        String arr[] = fff.split("-");
                        s1 = arr[0];
                        s2 = arr[1];
                        s3 = arr[2];
                    }

                    Log.e("s123", s1 + s2 + s3);
                    if ((dateThai_day.equals(s1)) & (dateThai_month.equals(s2)) & (dateThai_year.equals(s3))) {
                        txt_datetime.setText(date_new_format_thai2);
                        //Viewholder.icon_time.setBackgroundResource(R.drawable.ic_access_time_black_24dp);
                        //Log.e("TIME",date_new_format_thai2);
                    } else {
                        txt_datetime.setText(dateThai_day + " " + dateThai_month1 + converted_dateThai11);
                        //  Viewholder.icon_time.setBackgroundResource(0);
                        // Log.e("dateThai",dateThai_day+""+dateThai_month1+""+converted_dateThai11+"");
                    }


                }
            } catch (Exception ex) {

            }


        }


        select_empid_sent_problem_in_come();
        JSON_DATA_WEB_CALL2();
        //JSON_DATA_WEB_CALL3();

        select_id_from_Problem_Respon_Master();
        //select_id_from_Problem_Respon_Details();















        try {
            DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
            String date_now = df2.format(Calendar.getInstance().getTime());

            String arr2[] = eff_date_S.split("/");
            String date_day=arr2[0];
            String date_month=arr2[1];
            String date_year=arr2[2];

            String date_install=date_year+"-"+date_month+"-"+date_day;

            getCountOfDays(date_now,date_install);

            if((int) dayCount>30){
                //li_tel.setVisibility(View.GONE);
                txt_tel.setText("เกิน 30 วัน");
                txt_tel2.setText("เกิน 30 วัน");

            }
            else {
               //li_tel.setVisibility(View.VISIBLE);
                try {
                    if((tel_S.equals("null"))|tel_S.isEmpty()){
                        txt_tel.setText("-");
                    }
                    else {
                        txt_tel.setText(tel_S);
                    }


                    if((tel2_S.equals("null"))|tel2_S.isEmpty()){
                        txt_tel2.setText("-");
                    }
                    else {
                        txt_tel2.setText(tel2_S);
                    }
                }
                catch (Exception ex){

                }



            }

        }
        catch (Exception ex){

        }




    }


    float dayCount;
    public String getCountOfDays(String createdDateString, String expireDateString) {



        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

        Date createdConvertedDate = null, expireCovertedDate = null, todayWithZeroTime = null;
        try {
            createdConvertedDate = dateFormat.parse(createdDateString);
            expireCovertedDate = dateFormat.parse(expireDateString);

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




        return ("" + (int) dayCount + " Days");
    }





    public void select_empid_sent_problem_in_come() {
        String user_code = MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        Log.e("hhhhhhhh", API_URL_ALL.GET_JSON_select_empid_sent_problem_in_come_Activity_edit_problem_from_sale + "?user_code=" + user_code + "&ProblemID=" + ID + "&Contno=" + Contno_S);
        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_select_empid_sent_problem_in_come_Activity_edit_problem_from_sale + "?user_code=" + user_code + "&ProblemID=" + ID + "&Contno=" + Contno_S,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSON_PARSE_DATA_AFTER_select_empid_sent_problem_in_come(response);

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

    String InformEmpID = "", fcm_key = "",CashTeamCode="";

    public void JSON_PARSE_DATA_AFTER_select_empid_sent_problem_in_come(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            //final GetData_select_topic_problem_sub GetDataAdapter2 = new GetData_select_topic_problem_sub();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                // GetDataAdapter2.setProblemID(json.getString("InformID"));
                InformEmpID = json.getString("InformEmpID");
                fcm_key = json.getString("fcm_key");
                CashTeamCode = json.getString("CashTeamCode");

                Log.e("CashTeamCode",CashTeamCode);
            } catch (JSONException e) {

                e.printStackTrace();
            }

        }


       // Log.e("InformEmpID", InformEmpID);
       // Log.e("fcm_key", fcm_key);
    }

    String ffss="";
    public void JSON_DATA_WEB_CALL2() {
        //String user_code = MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        try {
            ffss=   URLEncoder.encode(API_URL_ALL.GET_JSON_DATA_HTTP_URL_Activity_edit_problem_from_sale + "?user_code=" + user_code+"&ProblemID=" + ID +"&Contno=" + Contno_S, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String ff=API_URL_ALL.GET_JSON_DATA_HTTP_URL_Activity_edit_problem_from_sale + "?user_code=" + user_code.replace(" ","")+"&ProblemID=" + ID +"&Contno=" + Contno_S;

        try {
            String asubstring = user_code.substring(0, 6);


            Log.e("url_select_image", ff);
            Log.e("url_select_image", asubstring);
        }
        catch (Exception ex){

        }

      //  try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_Activity_edit_problem_from_sale + "?user_code=" + user_code.replace(" ","")+"&ProblemID=" + ID +"&Contno=" + Contno_S,
                    //  jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL ,

                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {

                            createDummyData(response);

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

    public void createDummyData(JSONArray array) {

        for (int i = 1; i <= 1; i++) {

            SectionDataModel dm = new SectionDataModel();

            dm.setHeaderTitle("ล่าสุด ");

            singleItem = new ArrayList<SingleItemModel>();


            for (int j = 0; j < array.length(); j++) {

                final DATA_mp3 GetDataAdapter2 = new DATA_mp3();
                JSONObject json = null;
                try {

                    json = array.getJSONObject(j);

                    GetDataAdapter2.setMp3_thumbnail_s2(json.getString("ImageUrl"));

                    String f = String.valueOf(j + 1);
                    singleItem.add(new SingleItemModel("รูป " + f, GetDataAdapter2.getMp3_thumbnail_s2()));

                   // Log.e("CC", GetDataAdapter2.getMp3_thumbnail_s2());

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            // for (int j = 0; j <= 5; j++) {
            // singleItem.add(new SingleItemModel("Item " + j, "http://app.thiensurat.co.th/assanee/upload/iconprofile/picture1.png"));
            //  }

            dm.setAllItemsInSection(singleItem);

            allSampleData.add(dm);


        }


        RecyclerViewDataAdapter5 adapter = new RecyclerViewDataAdapter5(this, allSampleData);
        my_recycler_view2.setAdapter(adapter);
        adapter.setitemclick_deleteAll3(this);

        if (singleItem.size() == 0) {
            my_recycler_view2.setVisibility(View.GONE);
        } else {
            my_recycler_view2.setVisibility(View.VISIBLE);
        }
    }


    public void JSON_DATA_WEB_CALL3() {
        singleItem2.clear();
     //   String user_code = MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
       // Log.e("dddd", GET_JSON_DATA_HTTP_URL4 + "?user_code=" + user_code + "&ProblemID=" + ID + "&Contno=" + Contno_S+ "&Items=" + Items_R);
        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL4_Activity_edit_problem_from_sale + "?user_code=" + user_code.replace(" ","") + "&ProblemID=" + ID + "&Contno=" + Contno_S+ "&Items=" + Items_R,
                //  jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL ,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        createDummyData2(response);

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

    RecyclerViewDataAdapter6 adapter;

    public void createDummyData2(JSONArray array) {

        for (int i = 1; i <= 1; i++) {

            SectionDataModel2 dm = new SectionDataModel2();

            dm.setHeaderTitle("ล่าสุด ");

            singleItem2 = new ArrayList<SingleItemModel2>();


            for (int j = 0; j < array.length(); j++) {

                final DATA_mp3 GetDataAdapter2 = new DATA_mp3();
                final GetData_cedit_delete_image_respon getData_cedit_delete_image_respon=new GetData_cedit_delete_image_respon();
                JSONObject json = null;
                try {

                    json = array.getJSONObject(j);

                    GetDataAdapter2.setMp3_thumbnail_s2(json.getString("ImageUrl"));

                    getData_cedit_delete_image_respon.setImageUrl(json.getString("ImageUrl"));
                    getData_cedit_delete_image_respon.setInformID(json.getString("InformID"));
                    getData_cedit_delete_image_respon.setProblemID(json.getString("ProblemID"));
                    getData_cedit_delete_image_respon.setItems(json.getString("Items"));
                    getData_cedit_delete_image_respon.setDepartID(json.getString("DepartID"));

                    String f = String.valueOf(j + 1);
                    singleItem2.add(new SingleItemModel2("รูป " + f, GetDataAdapter2.getMp3_thumbnail_s2()));
                    getData_cedit_delete_image_respons.add(getData_cedit_delete_image_respon);
/*
                    if(WorkCode_S.equals("90")){
                        SQLiteDataBaseBuild();
                        SQLiteTableBuild();
                        String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer.TABLE_NAME + " (part_id,Url) VALUES('" + ID + "','" + Url + "','" + image_name + "','" + length + "','" + "jpg" + "','" + order_image + "');";
                        sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);

                    }*/

                    //Log.e("CC", GetDataAdapter2.getMp3_thumbnail_s2());

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            // for (int j = 0; j <= 5; j++) {
            // singleItem.add(new SingleItemModel("Item " + j, "http://app.thiensurat.co.th/assanee/upload/iconprofile/picture1.png"));
            //  }

            dm.setAllItemsInSection(singleItem2);

            allSampleData2.add(dm);


        }


        adapter = new RecyclerViewDataAdapter6(this, allSampleData2);
        my_recycler_view.setAdapter(adapter);
        adapter.setitemclick_deleteAll(this);

        if (singleItem2.size() == 0) {
            my_recycler_view.setVisibility(View.GONE);
        } else {
            my_recycler_view.setVisibility(View.VISIBLE);
        }
    }


    public void select_image() {
        allSampleData2.clear();
        SQLiteDataBaseBuild();
        SQLiteTableBuild();
        for (int i = 1; i <= 1; i++) {

            SectionDataModel2 dm = new SectionDataModel2();

            dm.setHeaderTitle("ล่าสุด ");

            //   ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();



            if(check_buttom_remove_image==1) {
                cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);

                if (cursor.moveToFirst()) {
                    do {

                        String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                        Log.e("A", FA);

                        // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                        String f = String.valueOf(1);
                        singleItem2.add(new SingleItemModel2("รูป " + f, FA));


                    } while (cursor.moveToNext());
                }
                cursor.close();

            }
            else {
                cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "", null);

                if (cursor.moveToFirst()) {
                    do {

                        String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                        Log.e("A", FA);

                        // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                        String f = String.valueOf(1);
                        singleItem2.add(new SingleItemModel2("รูป " + f, FA));


                    } while (cursor.moveToNext());
                }
                cursor.close();

            }



            size = singleItem2.size();
            Log.e("size", String.valueOf(size));
            dm.setAllItemsInSection(singleItem2);

            allSampleData2.add(dm);


        }


        adapter = new RecyclerViewDataAdapter6(this, allSampleData2);
        my_recycler_view.setAdapter(adapter);


        if (size == 0) {
            my_recycler_view.setVisibility(View.GONE);
        } else {
            my_recycler_view.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            // finish the activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    ImageConfiguration ic;
    Uri fileUri;
    Intent CamIntent, CropIntent;
    File file;
    String Url = "", url_image = "", order_ITEM = "";
    MarshMallowPermission marshMallowPermission = new MarshMallowPermission(this);





    String conno_aa="";
    SweetAlertDialog pDialog;
    View e;


    @Override
    public void onClick(View view) {
        if (view == open_camera) {

            checkCameraPermission();
            try {
                if ((VersionOSM.equals("5.0"))|(VersionOSM.equals("5.0.1"))|(VersionOSM.equals("5.0.2"))|(VersionOSM.equals("5.1.3"))|(VersionOSM.equals("5.1"))|(VersionOSM.equals("5.1.1"))|(VersionOSM.equals("5.1.0"))|(VersionOSM.equals("5.1.2"))) {
                    CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                    ic = new ImageConfiguration(this,PATH);
                    file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                            "report_problem", "ALL");


                    fileUri = Uri.fromFile(file);
                    CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                    startActivityForResult(CamIntent, 1);
                }
                else {


                    if (!marshMallowPermission.checkPermissionForCamera()) {
                        marshMallowPermission.requestPermissionForCamera();
                    } else {
                        if (!marshMallowPermission.checkPermissionForExternalStorage()) {
                            marshMallowPermission.requestPermissionForExternalStorage();
                        } else {

                            CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                            ic = new ImageConfiguration(this,PATH);
                            file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                                    "report_problem", "ALL");

                            fileUri = FileProvider.getUriForFile(this,
                                    BuildConfig.APPLICATION_ID + ".provider",
                                    file);
                            // fileUri = Uri.fromFile(file);
                            CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                            startActivityForResult(CamIntent, 1);
                        }
                    }


                }
            }
            catch (Exception ex){
                CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                ic = new ImageConfiguration(this,PATH);
                file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                        "report_problem", "ALL");

                fileUri = FileProvider.getUriForFile(this,
                        BuildConfig.APPLICATION_ID + ".provider",
                        file);
                // fileUri = Uri.fromFile(file);
                CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                startActivityForResult(CamIntent, 1);
            }






        }
        else if (view == open_image) {

                checkCameraPermission();
/*                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 88);*/

            Intent intent  = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            //CamIntent = new Intent("android.media.action.IMAGE_CAPTURE");
            ic = new ImageConfiguration(this, PATH);
            file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                    "report_problem", "ALL");

            fileUri = FileProvider.getUriForFile(this,
                    BuildConfig.APPLICATION_ID + ".provider",
                    file);
            // fileUri = Uri.fromFile(file);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
            startActivityForResult(intent, 88);
        }


        else if (view == r_save) {
            String strUserName = new_message2.getText().toString();

            if (TextUtils.isEmpty(strUserName)) {
                new_message2.setError("!กรุณาพิมพ์รายละเอียดการแก้ไขปัญหาด้วย");
                Vibrator v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    v.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    v.vibrate(200);
                }

                return;
            } else {



                if (size_id_master != 0) {
                    // INSENT_Problem_Respon_Details();
                }

               UPDATE_Problem_Respon_Master();
               UPDATE_Problem_Respon_Details();


                try {

                    if(check_buttom_remove_image==1) {
                        cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);

                        if (cursor.moveToFirst()) {
                            do {

                                GetData_uploade_Image getData_uploade_image = new GetData_uploade_Image();
                                // Url = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Url));
                                url_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                                String part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_id));
                                Log.e("url_image", url_image);
                                getData_uploade_image.setImage(url_image);
                                getData_uploade_image.setPart_id(part_id);
                                getData_uploade_images.add(getData_uploade_image);

                            } while (cursor.moveToNext());
                        }
                        cursor.close();
                    }
                    else {


                        cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "", null);

                        if (cursor.moveToFirst()) {
                            do {

                                GetData_uploade_Image getData_uploade_image = new GetData_uploade_Image();
                                // Url = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Url));
                                url_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                                String part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_id));
                                Log.e("url_image", url_image);
                                getData_uploade_image.setImage(url_image);
                                getData_uploade_image.setPart_id(part_id);
                                getData_uploade_images.add(getData_uploade_image);

                            } while (cursor.moveToNext());
                        }
                        cursor.close();
                    }



                } catch (Exception EX) {

                }


                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient client = new OkHttpClient.Builder()
                        .addInterceptor(interceptor)
                        .connectTimeout(60, TimeUnit.SECONDS)
                        .writeTimeout(60, TimeUnit.SECONDS)
                        .readTimeout(60, TimeUnit.SECONDS)
                        .build();

                // Change base URL to your upload server URL.
                uploadService = new Retrofit.Builder()
                        .baseUrl(SERVER_PATH)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(Service.class);


                pDialogg = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
                pDialogg.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                pDialogg.setTitleText("กำลังอัปโหลด...");
                pDialogg.setCancelable(false);
                uploadMultiFile();



            }





        } else if (view == r_delete) {

            singleItem2.clear();
            adapter.notifyDataSetChanged();


            for(int i=0;i<getData_cedit_delete_image_respons.size();i++){
                GetData_cedit_delete_image_respon getData_cedit_delete_image_respon = getData_cedit_delete_image_respons.get(i);

                        InformID_DELETE_IMAGE_RESPON=getData_cedit_delete_image_respon.getInformID();
                        ProblemID_DELETE_IMAGE_RESPON=getData_cedit_delete_image_respon.getProblemID();
                        DepartID_DELETE_IMAGE_RESPON=getData_cedit_delete_image_respon.getDepartID();
                        Items_DELETE_IMAGE_RESPON=getData_cedit_delete_image_respon.getItems();
                        ImageUrl_DELETE_IMAGE_RESPON=getData_cedit_delete_image_respon.getImageUrl();

                        DELETE_Problem_Respon_image();
            }



            dialog_success_delete();
        }
        else if(view==list_item_status_sale){
            SELECT_DATA_CONFIRM2(conno);
                e=view;
                pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
                pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                pDialog.setTitleText("Loading");
                pDialog.setCancelable(true);
                pDialog.show();
                JSON_DATA_WEB_CALL38();

        }
        else if(view==list_item_history){
            Intent Intent = new Intent(this, UI_CARDVIEW_DATA_SALE_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_ACTIVITY.class);
            Bundle bun = new Bundle();
            bun.putString("InformID", InformID_S);
            Intent.putExtras(bun);
            startActivityForResult(Intent, 77);
        }
    }


    public void sent_nontification_to_web(){
        String EmpIDForm=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        String EmpIDTo=InformEmpID;
        String WorkCode="24";
       // String CashTeamCode_REAL=CashTeamCode;
        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_sent_nontification_to_web_Activity_edit_problem_from_sale+"?EmpIDForm="+EmpIDForm+"&EmpIDTo="+EmpIDTo+"&WorkCode="+WorkCode,


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

    private void dialog_success_delete() {


    final SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE);
        sweetAlertDialog.setTitleText("เสร็จสิ้น!");
        sweetAlertDialog.setContentText("*การลบรูป*");
        sweetAlertDialog.setCancelable(true);
        sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener()

    {
        @Override
        public void onClick (SweetAlertDialog sDialog){
            sweetAlertDialog.cancel();

       // finish();
    }
    });
        sweetAlertDialog.show();

}

    String Image_Name="";
    String Image_Size="";
    String Image_Type="";
    String part_id="";
    String Image_id_item="";
    private void uploadMultiFile() {
        //progressDialog.show();
        pDialogg.show();

        ArrayList<String> filePaths = new ArrayList<>();
        int gg=   getData_uploade_images.size();
        Log.e("gg", String.valueOf(gg));
        filePaths.add("/storage/sdcard0/Android/data/com.tsr.tsrproblemreport/files/Pictures/70102489/report_problem/ID1/image_error/image_error_20180406070126-1473976226.jpg");
        //    filePaths.add("/storage/sdcard0/Android/data/com.tsr.tsrproblemreport/files/Pictures/70102489/report_problem/ID1/image_error/image_error_201804060738541936595331.jpg");
        //  filePaths.add("/storage/sdcard0/Android/data/com.tsr.tsrproblemreport/files/Pictures/70102489/report_problem/ID1/image_error/image_error_20180406070126-1473976226.jpg");

        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);

        builder.addFormDataPart("user_name", "Robert");
        builder.addFormDataPart("email", "mobile.apps.pro.vn@gmail.com");


        for (int i = 0; i < getData_uploade_images.size(); i++) {
            // getData_uploade_images.get(i);
            GetData_uploade_Image contact = getData_uploade_images.get(i);
            String data_image_to_qry=contact.getImage();


            if(check_buttom_remove_image==1) {
                cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);

                if (cursor.moveToFirst()) {
                    do {

                        part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_id));
                        Url = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Url));
                        order_ITEM = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_order_image));
                        Image_Name = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Image_Name));
                        Image_Size = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Image_Size));
                        Image_Type = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Image_Type));
                        Image_id_item = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_order_image));
                        Log.e("Url_rrr", Url);

                        INSENT_Problem_Inform_Details_Images();

                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            else {

                cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "", null);

                if (cursor.moveToFirst()) {
                    do {

                        part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_id));
                        Url = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Url));
                        order_ITEM = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_order_image));
                        Image_Name = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Image_Name));
                        Image_Size = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Image_Size));
                        Image_Type = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Image_Type));
                        Image_id_item = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_order_image));
                        Log.e("Url_rrr", Url);

                        INSENT_Problem_Inform_Details_Images();

                    } while (cursor.moveToNext());
                }
                cursor.close();
            }




            File file = new File(String.valueOf(contact.getImage()));
            builder.addFormDataPart("file[]", file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file));
        }

        File file = new File("");
        MultipartBody requestBody = builder.build();
        Call<ResponseBody> call = uploadService.uploadMultiFile(requestBody);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {



                           dialog_success();

                pDialogg.cancel();

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                dialog_error();

                pDialogg.cancel();
            }
        });


    }


    private void dialog_success(){

        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE);
        sweetAlertDialog.setTitleText("เสร็จสิ้น!");
        sweetAlertDialog.setContentText("*การแก้ไขปัญหา*");
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sDialog) {


                MyApplication.getInstance().getPrefManager().setPreferrence("EDIT_SALE_SUCCESS", "1");

                SQLiteDataBaseBuild();
                SQLiteTableBuild();
                sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_image_buffer.TABLE_NAME+"");


                File dire= new File(Environment.getExternalStorageDirectory(), "/Android/data/com.tsr.tsrproblemreport/files/Pictures");
                Log.e("dire", String.valueOf(dire));
                new DirectoryCleaner(dire).clean();
                dire.delete();


                Log.e("dialog","ปิด dialog");
                sDialog.dismissWithAnimation();


                String image=MyApplication.getInstance().getPrefManager().getPreferrence("picture");

                Log.e("gggg",Contno_S+","+Sub+","+fcm_key+","+InformEmpID+","+ID+","+image+","+CashTeamCode);
                    new Async_sent_nontification_to_credit().execute(Contno_S,Sub,fcm_key,InformEmpID,ID,image,CashTeamCode);
                    sent_nontification_to_sale_all();


                if(check_nonti_web==0){
                    connectSocket();
                    check_nonti_web=1;
                }
                else {
                    webSocketClient.close();
                }

                //sent_non();
              //  Thread non_credit = new Thread(sent_non_to_credit);
             //   non_credit.start();
              // ddd();
               // sent_nontification_to_credit();
              //  sent_nontification_to_sale_all();
               // requestQueue.stop();

                finish();
            }
        });
        sweetAlertDialog .show();
    }

    private void dialog_error(){
        SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE);
        sweetAlertDialog.setTitleText("ไม่สำเร็จ!");
        sweetAlertDialog.setContentText("*การแก้ไขปัญหา*");
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sDialog) {

                 SQLiteDataBaseBuild();
                 SQLiteTableBuild();
                sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_image_buffer.TABLE_NAME+"");


                File dire= new File(Environment.getExternalStorageDirectory(), "/Android/data/com.tsr.tsrproblemreport/files/Pictures");
                Log.e("dire", String.valueOf(dire));
                new DirectoryCleaner(dire).clean();
                dire.delete();


                Log.e("dialog","ปิด dialog");
                sDialog.dismissWithAnimation();

                finish();
            }
        });
        sweetAlertDialog .show();
    }


  public void  sent_nontification_to_credit(){
        Log.e("yyy","yyy");
        String image=MyApplication.getInstance().getPrefManager().getPreferrence("picture");
      try {
          Log.e("URL_FCM",API_URL_ALL.GET_JSON_sent_nontification_to_credit_Activity_edit_problem_from_sale+"?contno="+Contno_S+"&problem="+URLEncoder.encode(Sub, "UTF-8")+"&fcm_key="+fcm_key+"&user_code="+InformEmpID+"&ID="+ID+"&image="+image+"&CashTeamCode="+CashTeamCode);
      } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
      }
      try {
          jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_sent_nontification_to_credit_Activity_edit_problem_from_sale+"?contno="+Contno_S+"&problem="+URLEncoder.encode(Sub, "UTF-8")+"&fcm_key="+fcm_key+"&user_code="+InformEmpID+"&ID="+ID+"&image="+image+"&CashTeamCode="+CashTeamCode,


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


      requestQueue = Volley.newRequestQueue(this);

      requestQueue.add(jsonArrayRequest);
    }

    public void  sent_nontification_to_sale_all(){
        String image=MyApplication.getInstance().getPrefManager().getPreferrence("picture");
        try {
            Log.e("URL_FCM_ALL",API_URL_ALL.GET_JSON_sent_nontification_to_sale_all_Activity_edit_problem_from_sale+"?contno="+Contno_S+"&problem="+URLEncoder.encode(Sub, "UTF-8")+"&image_cedit="+image);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_sent_nontification_to_sale_all_Activity_edit_problem_from_sale+"?contno="+Contno_S+"&problem="+URLEncoder.encode(Sub, "UTF-8")+"&image_cedit="+image,


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


        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);
    }




    public void select_id_from_Problem_Respon_Master(){
        Log.e("url_id_Master",API_URL_ALL.GET_JSON_select_id_from_Problem_Respon_Master_Activity_edit_problem_from_sale+"?Contno="+conno+"&ProblemID="+ID);

        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_select_id_from_Problem_Respon_Master_Activity_edit_problem_from_sale+"?Contno="+conno+"&ProblemID="+ID,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSON_PARSE_DATA_AFTER_select_id_from_Problem_Respon_Master(response);

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


    String InformID="";
    String ProblemID="";
    String WorkCode="";
    int size_id_master;
    public void JSON_PARSE_DATA_AFTER_select_id_from_Problem_Respon_Master(JSONArray array) {

         size_id_master=array.length();
        Log.e("size_id_master", String.valueOf(size_id_master));
        for (int i = 0; i < array.length(); i++) {

            //final GetData_select_topic_problem_sub GetDataAdapter2 = new GetData_select_topic_problem_sub();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                // GetDataAdapter2.setProblemID(json.getString("InformID"));
                InformID=json.getString("InformID");
                ProblemID=json.getString("ProblemID");
                WorkCode=json.getString("WorkCode");

                MyApplication.getInstance().getPrefManager().setPreferrence("InformID", InformID);
                MyApplication.getInstance().getPrefManager().setPreferrence("ProblemID", ProblemID);
                MyApplication.getInstance().getPrefManager().setPreferrence("WorkCode", WorkCode);
                Log.e("InformID",InformID);
                Log.e("ProblemID",ProblemID);
                Log.e("WorkCode",WorkCode);


            } catch (JSONException e) {

                e.printStackTrace();
            }

        }
        select_id_from_Problem_Respon_Details();
    }

    public void select_id_from_Problem_Respon_Details(){

     //   String DepartID=MyApplication.getInstance().getPrefManager().getPreferrence("DepartId");
        String DepartID="AE";
        Log.e("url_select_details",API_URL_ALL.GET_JSON_select_id_from_Problem_Respon_Details_Activity_edit_problem_from_sale+"?InformID="+InformID+"&ProblemID="+ProblemID+"&DepartID="+DepartID);
        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_select_id_from_Problem_Respon_Details_Activity_edit_problem_from_sale+"?InformID="+InformID+"&ProblemID="+ProblemID+"&DepartID="+DepartID,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSON_PARSE_DATA_AFTER_select_id_from_Problem_Respon_Details(response);

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



    String Items="";
    int int_item;
    public void JSON_PARSE_DATA_AFTER_select_id_from_Problem_Respon_Details(JSONArray array) {
        int_item=array.length();
        if(int_item==0){
            Items="1";
            Log.e("Items",Items);
        }
        for (int i = 0; i < array.length(); i++) {

            //final GetData_select_topic_problem_sub GetDataAdapter2 = new GetData_select_topic_problem_sub();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                // GetDataAdapter2.setProblemID(json.getString("InformID"));
                Items=json.getString("Items");


                MyApplication.getInstance().getPrefManager().setPreferrence("Items", Items);

                Log.e("Items",Items);



            } catch (JSONException e) {

                e.printStackTrace();
            }

        }

    }






    private  void INSENT_Problem_Inform_Details_Images(){


        String ProblemID=part_id;
        String ImageItem=Image_id_item ;
        String ImageUrl=Url;
        String ImageName=Image_Name;
        String ImageSize=Image_Size;
        String ImageType =Image_Type;
        //String DepartID=MyApplication.getInstance().getPrefManager().getPreferrence("DepartId");
        String  DepartID="AE";
        //String Items_from_details=Items;
        Log.e("URL_IMAGE",API_URL_ALL.GET_JSON_insent_Problem_Respon_Details_Images_Activity_edit_problem_from_sale+"?InformID="+InformID+"&ProblemID="+ProblemID+"&DepartID="+DepartID+"&ImageItem="+ImageItem+"&ImageUrl="+ImageUrl+"&ImageName="+ImageName+"&ImageSize="+ImageSize+"&ImageType="+ImageType+"&Items="+Items);
        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insent_Problem_Respon_Details_Images_Activity_edit_problem_from_sale+"?InformID="+InformID+"&ProblemID="+ProblemID+"&DepartID="+DepartID+"&ImageItem="+ImageItem+"&ImageUrl="+ImageUrl+"&ImageName="+ImageName+"&ImageSize="+ImageSize+"&ImageType="+ImageType+"&Items="+Items,
       // jsonArrayRequest = new JsonArrayRequest(GET_JSON_insent_Problem_Respon_Details_Images+"?InformID="+MyApplication.getInstance().getPrefManager().getPreferrence("InformID")+"&ProblemID="+ProblemID+"&ImageItem="+ImageItem+"&ImageUrl="+ImageUrl,


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


    public void  DELETE_Problem_Respon_image(){

        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_delete_Problem_Respon_Details_Images_Activity_edit_problem_from_sale+"?InformID="+InformID_DELETE_IMAGE_RESPON+"&ProblemID="+ProblemID_DELETE_IMAGE_RESPON+"&DepartID="+DepartID_DELETE_IMAGE_RESPON+"&Items="+Items_DELETE_IMAGE_RESPON+"&ImageUrl="+ImageUrl_DELETE_IMAGE_RESPON,
                // jsonArrayRequest = new JsonArrayRequest(GET_JSON_insent_Problem_Respon_Details_Images+"?InformID="+MyApplication.getInstance().getPrefManager().getPreferrence("InformID")+"&ProblemID="+ProblemID+"&ImageItem="+ImageItem+"&ImageUrl="+ImageUrl,


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

    private  void UPDATE_Problem_Respon_Master(){

//String DepartID=MyApplication.getInstance().getPrefManager().getPreferrence("DepartId");
        String DepartID="AE";
Log.e("UPDATE_Master",API_URL_ALL.GET_JSON_UPDATE_from_Problem_Respon_Master_Activity_edit_problem_from_sale+"?InformID="+InformID_S+"&ProblemID="+ID+"&DepartID="+DepartID);
        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_UPDATE_from_Problem_Respon_Master_Activity_edit_problem_from_sale+"?InformID="+InformID_S+"&ProblemID="+ID+"&DepartID="+DepartID,
                // jsonArrayRequest = new JsonArrayRequest(GET_JSON_insent_Problem_Respon_Details_Images+"?InformID="+MyApplication.getInstance().getPrefManager().getPreferrence("InformID")+"&ProblemID="+ProblemID+"&ImageItem="+ImageItem+"&ImageUrl="+ImageUrl,


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
    private  void UPDATE_Problem_Respon_Details(){



        //String DepartID=MyApplication.getInstance().getPrefManager().getPreferrence("DepartId");
        String DepartID="AE";
        String EmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        String ResponNote=new_message2.getText().toString();
        try {
            Log.e("UPDATE_Details",API_URL_ALL.GET_JSON_UPDATE_from_Problem_Respon_Details_Activity_edit_problem_from_sale+"?InformID="+InformID_S+"&ProblemID="+ID+"&DepartID="+DepartID+"&EmpID="+EmpID+"&ResponNote="+URLEncoder.encode(ResponNote, "UTF-8")+"&Items="+"2");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }



        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_UPDATE_from_Problem_Respon_Details_Activity_edit_problem_from_sale+"?InformID="+InformID_S+"&ProblemID="+ID+"&DepartID="+DepartID+"&EmpID="+EmpID+"&ResponNote="+URLEncoder.encode(ResponNote, "UTF-8")+"&Items="+"2",
                    // jsonArrayRequest = new JsonArrayRequest(GET_JSON_insent_Problem_Respon_Details_Images+"?InformID="+MyApplication.getInstance().getPrefManager().getPreferrence("InformID")+"&ProblemID="+ProblemID+"&ImageItem="+ImageItem+"&ImageUrl="+ImageUrl,


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

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);




    }
     Dialog dialog_image;
    @Override
    public void click_deleteAll(View v, int position) {


        getData_image_more_for_delates.clear();


        dialog_image = new Dialog(this);
        dialog_image.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog_image.setContentView(R.layout.mp3_online_list_single_recycleview_dialog_custom_image_problem);
        dialog_image.setCancelable(true);
        final TextView counter = (TextView) dialog_image.findViewById(R.id.counter);
        final RelativeLayout close = (RelativeLayout) dialog_image.findViewById(R.id.close);


        final RecyclerView recycler_view = (RecyclerView) dialog_image.findViewById(R.id.recycler_view);

        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        if(check_buttom_remove_image==1){

            cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
            if (cursor.moveToFirst()) {
                do {
                    GetData_cedit_dialog_image_problem_from_id dataCeditDialogImageProblemFromId = new GetData_cedit_dialog_image_problem_from_id();

                    String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                    String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));

                    dataCeditDialogImageProblemFromId.setImage_id_all(FA);
                    getData_image_more_for_delates.add(dataCeditDialogImageProblemFromId);
                    // getData_cedit_dialog_image_problem_from_ids.add(dataCeditDialogImageProblemFromId);
                } while (cursor.moveToNext());
            }
            cursor.close();

            //  }

        }
        else {
            cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper_image_buffer.TABLE_NAME+""   , null);
            if (cursor.moveToFirst()) {
                do {
                    GetData_cedit_dialog_image_problem_from_id dataCeditDialogImageProblemFromId =new GetData_cedit_dialog_image_problem_from_id();

                    String FA=cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                    String f=cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));

                    dataCeditDialogImageProblemFromId.setImage_id_all(FA);
                    getData_image_more_for_delates.add(dataCeditDialogImageProblemFromId);
                    // getData_cedit_dialog_image_problem_from_ids.add(dataCeditDialogImageProblemFromId);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }





        counter.setText(getData_image_more_for_delates.size()+"");

        recyclerViewDataAdapter_dialog_image_problem_from_id2 = new RecyclerViewDataAdapter_dialog_image_problem_from_id2(this, getData_image_more_for_delates );
        recycler_view.setAdapter(recyclerViewDataAdapter_dialog_image_problem_from_id2);
        recyclerViewDataAdapter_dialog_image_problem_from_id2.setitemclick_deleteAll2(this);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_image.dismiss();
            }
        });



        dialog_image.show();






    }
    int update_order_image=0,size3;
    @Override
    public void click_deleteAll2(View v, int position) {
        dialog_image.dismiss();

        order_image=0;
        data_cedit_dialog_image_problem_from_id =getData_image_more_for_delates.get(position);
        Log.e("remove + ", String.valueOf(position)+","+data_cedit_dialog_image_problem_from_id.getImage_id_all());

        // Log.e("remove + ", String.valueOf(position));
        SQLiteDataBaseBuild();
        SQLiteTableBuild();


        sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" + " WHERE url_image =" + "'" + data_cedit_dialog_image_problem_from_id.getImage_id_all() + "'");


        getData_image_news.clear();


        cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "", null);
        if (cursor.moveToFirst()) {
            do {

                String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));

                String ID_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_part_id));
                String number_BUF2 = String.valueOf(2);
                String NAME_IMAGE_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_name_image));
                String Url_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Url));
                String length_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Size));
                String image_type_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Type));
                String order_image_BUF2 = String.valueOf(update_order_image + 1);



                getDataImageNew = new GetData_image_new();
                getDataImageNew.setPart_id(ID_BUF2);
                getDataImageNew.setName_image(number_BUF2);
                getDataImageNew.setUrl_image(FA);
                getDataImageNew.setUrl(Url_BUF2);
                getDataImageNew.setImage_Name(NAME_IMAGE_BUF2);
                getDataImageNew.setImage_Size(length_BUF2);
                getDataImageNew.setImage_Type(image_type_BUF2);
                getDataImageNew.setOrder_image(order_image_BUF2);
                getData_image_news.add(getDataImageNew);
            } while (cursor.moveToNext());
        }
        cursor.close();







        size_image=getData_image_news.size();
        //getData_image_news.clear();
        if(getData_image_news.size()==0){
            check_buttom_remove_image=0;
            size_image=0;
            order_image=0;
            sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'");

            File dire= new File(Environment.getExternalStorageDirectory(), "/Android/data/com.tsr.tsrproblemreport/files/Pictures");
            Log.e("dire", String.valueOf(dire));
            new DirectoryCleaner(dire).clean();
            dire.delete();

            SQLiteDataBaseBuild();
            SQLiteTableBuild();
            sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_image_buffer.TABLE_NAME+"");



        }
        else {
            //check_buttom_remove_image=1;
        }
        Log.e("CHECK_IMAGEwwww_S", String.valueOf(getData_image_news.size()));
        SQLiteDataBaseBuild();
        SQLiteTableBuild();
        sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" + " WHERE name_image =" + "'" + "1" + "'");
        sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'");
        for (int i2 = 0; i2 < getData_image_news.size(); i2++) {


            order_image=order_image+1;
            getDataImageNew=getData_image_news.get(i2);
            Log.e("CHECK_IMAGEwwww_2", String.valueOf(order_image));
            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + getDataImageNew.getPart_id() + "','" + getDataImageNew.getName_image() + "','" + getDataImageNew.getUrl_image() + "','" + getDataImageNew.getUrl() + "','" + getDataImageNew.getImage_Name() + "','" + getDataImageNew.getImage_Size() + "','" + getDataImageNew.getImage_Type() + "','" + String.valueOf(order_image) + "');";
            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
        }




        allSampleData2.clear();
        singleItem2.clear();


        for (int i = 1; i <=1; i++) {

            SectionDataModel2 dm = new SectionDataModel2();

            dm.setHeaderTitle("ล่าสุด ");

            singleItem2 = new ArrayList<SingleItemModel2>();


            if(size_image==1){
                cursor = sqLiteDatabase.rawQuery("SELECT count(*)as dd,url_image,order_image,name_image FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                //cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" , null);
                if (cursor.moveToFirst()) {
                    do {

                        String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                        String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
                        //String rr=cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
                        Log.e("FAภ",FA+","+order_image);


                        singleItem2.add(new SingleItemModel2("รูป " + f, FA));

                        size = singleItem2.size();
                        MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }

            else {



                Cursor   cursor222 = sqLiteDatabase.rawQuery("SELECT distinct name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                //cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" , null);
                if (cursor222.moveToFirst()) {
                    do {
                        //for(int i2=0;i2<=1;i2++) {
                        // count_id2 = cursor.getInt(0);
                        //Log.e("count_id2", String.valueOf(count_id2));
                        String FA = cursor222.getString(cursor222.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                        String FA2 = cursor222.getString(cursor222.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                        String f = cursor222.getString(cursor222.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
                        //String rr=cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
                        int vv = Integer.parseInt(f);
                        if (FA2!=FA) {
                            Log.e("FAn", FA + "," + order_image);
                        }



                        singleItem2.add(new SingleItemModel2("รูป " + f, FA));

                        //size = singleItem.size();
                        //MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        //  }

                    } while (cursor222.moveToNext());
                }


            }






            //}


            dm.setAllItemsInSection(singleItem2);
            allSampleData2.add(dm);
        }

        RecyclerViewDataAdapter6 adapter = new RecyclerViewDataAdapter6(this, allSampleData2);
        my_recycler_view.setAdapter(adapter);
        adapter.setitemclick_deleteAll(this);
        adapter.notifyDataSetChanged();
        if(singleItem2.size()==0){
            my_recycler_view.setVisibility(View.GONE);
        }
        else {
            my_recycler_view.setVisibility(View.VISIBLE);
        }
        //select_image();
        check_buttom_remove_image=1;

    }

    @Override
    public void click_deleteAll3(View v, int position) {
        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                            .setTitleText("!ไม่สามารถทำรายการได้")
                .setContentText("รูปจากแจ้งปัญหา!")
                .setConfirmText("ออก!")
                .show();
    }


    public static class DirectoryCleaner {
        private final File mFile;

        public DirectoryCleaner(File file) {
            mFile = file;
        }

        public void clean() {
            if (null == mFile || !mFile.exists() || !mFile.isDirectory()) return;
            for (File file : mFile.listFiles()) {
                delete(file);
            }
        }

        private void delete(File file) {
            if (file.isDirectory()) {
                for (File child : file.listFiles()) {
                    delete(child);
                }
            }
            file.delete();

        }
    }

    private void CropImage() {

        try {
            CropIntent = new Intent("com.android.camera.action.CROP");
            CropIntent.setDataAndType(fileUri, "image/*");
            CropIntent.putExtra("crop", "true");
            CropIntent.putExtra("outputX", 1024);
            CropIntent.putExtra("outputY", 1024);
            CropIntent.putExtra("aspectX", 1);
            CropIntent.putExtra("aspectY", 1);
            CropIntent.putExtra("scaleUpIfNeeded", true);
            CropIntent.putExtra("return-data", true);
            //CropIntent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
            startActivityForResult(CropIntent, 2);
        } catch (ActivityNotFoundException ex) {

        }
    }
    int order_image=0;
    String VersionOS="";
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {

        }

        else if(requestCode == 1){
            if(resultCode==RESULT_OK) {
                allSampleData2.clear();
                //CropImage();


                //  allSampleData2.clear();
                order_image=order_image+1;

                MyApplication.getInstance().getPrefManager().getPreferrence("part_image");
                String FILE2= "";
                String FILE= "";
                try {
               /*     VersionOS = android.os.Build.VERSION.RELEASE;

                    if((VersionOS.equals("6.0"))|(VersionOS.equals("6.0.0"))|(VersionOS.equals("6.0.1"))|(VersionOS.equals("6.1"))|(VersionOS.equals("6.1.0"))|(VersionOS.equals("7.0"))|(VersionOS.equals("7.0.0"))|(VersionOS.equals("7.0.1"))|(VersionOS.equals("7.1"))|(VersionOS.equals("7.1.0"))|(VersionOS.equals("7.1.1"))|(VersionOS.equals("7.1.2"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.0.0"))|(VersionOS.equals("8.1.0"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.1"))|(VersionOS.equals("9"))|(VersionOS.equals("9.0"))|(VersionOS.equals("9.0.0"))|(VersionOS.equals("9.1"))|(VersionOS.equals("9.1.0"))){
                        FILE=MyApplication.getInstance().getPrefManager().getPreferrence("part_image")+"/"+MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+".jpg";
                    }
                    else {
                        FILE=file.getAbsolutePath();
                    }

                    */

                    FILE2 = MyApplication.getInstance().getPrefManager().getPreferrence("part_image") + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("imageName") + ".jpg";

                    File file21 = new File(FILE2);

                    //File mSaveBit; // Your image file
                    String filePath = file21.getPath();
                    Bitmap bitmap = BitmapFactory.decodeFile(filePath);


                    ic.getResizedBiBitmaptmap(bitmap,"camera");

                    FILE = MyApplication.getInstance().getPrefManager().getPreferrence("part_image") + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+"new" + ".png";





                }
                catch (Exception ex){
                    FILE=file.getAbsolutePath();
                }

                //String FILE=file.getAbsolutePath();


                String image_name = MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+"new";
               // String image_name=MyApplication.getInstance().getPrefManager().getPreferrence("imageName");
               // String Url="http://app.thiensurat.co.th/assanee/uploads_image_report_problem/"+image_name+".jpg";
              //  String Url=SERVER_PATH+"uploads_image_report_problem/"+image_name+".jpg";
                String Url=SERVER_PATH+"uploads_image_report_problem/"+image_name+".png";

                File file2 = new File(FILE);
                long length = file2.length();
                length = length/1024;

                String number="";
                if(check_buttom_remove_image==1){
                    number= String.valueOf(2);
                }
                else {
                    number= String.valueOf(1);
                }

                SQLiteDataBaseBuild();
                SQLiteTableBuild();
                String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "jpg" + "','" + order_image + "');";
                sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);

                for (int i = 1; i <=1; i++) {

                    SectionDataModel2 dm = new SectionDataModel2();

                    dm.setHeaderTitle("ล่าสุด ");

                    singleItem2 = new ArrayList<SingleItemModel2>();



                    if(check_buttom_remove_image==1) {
                        cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                        if (cursor.moveToFirst()) {
                            do {

                                String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                                String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
                                singleItem2.add(new SingleItemModel2("รูป " + f, FA));

                                size = singleItem2.size();
                                MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                            } while (cursor.moveToNext());
                        }
                        cursor.close();
                    }
                    else {
                        cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "", null);

                        if (cursor.moveToFirst()) {
                            do {

                                String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                                String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
                                singleItem2.add(new SingleItemModel2("รูป " + f, FA));

                                size = singleItem2.size();
                                MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                            } while (cursor.moveToNext());
                        }
                        cursor.close();
                    }



                    dm.setAllItemsInSection(singleItem2);
                    allSampleData2.add(dm);
                }

                adapter = new RecyclerViewDataAdapter6(this, allSampleData2);
                my_recycler_view.setAdapter(adapter);
                adapter.setitemclick_deleteAll(this);
                // adapter.notifyDataSetChanged();
                if(singleItem2.size()==0){
                    my_recycler_view.setVisibility(View.GONE);
                }
                else {
                    my_recycler_view.setVisibility(View.VISIBLE);
                }
                //select_image();
            }

        }

        else if (requestCode == 2){
          //  allSampleData2.clear();
            order_image=order_image+1;

            MyApplication.getInstance().getPrefManager().getPreferrence("part_image");
            String FILE="";
            try {
                VersionOS = android.os.Build.VERSION.RELEASE;

                if((VersionOS.equals("6.0"))|(VersionOS.equals("6.0.0"))|(VersionOS.equals("6.0.1"))|(VersionOS.equals("6.1"))|(VersionOS.equals("6.1.0"))|(VersionOS.equals("7.0"))|(VersionOS.equals("7.0.0"))|(VersionOS.equals("7.0.1"))|(VersionOS.equals("7.1"))|(VersionOS.equals("7.1.0"))|(VersionOS.equals("7.1.1"))|(VersionOS.equals("7.1.2"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.0.0"))|(VersionOS.equals("8.1.0"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.1"))|(VersionOS.equals("9"))|(VersionOS.equals("9.0"))|(VersionOS.equals("9.0.0"))|(VersionOS.equals("9.1"))|(VersionOS.equals("9.1.0"))){
                    FILE=MyApplication.getInstance().getPrefManager().getPreferrence("part_image")+"/"+MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+".jpg";
                }
                else {
                    FILE=file.getAbsolutePath();
                }
            }
            catch (Exception ex){
                FILE=file.getAbsolutePath();
            }

            //String FILE=file.getAbsolutePath();


            String image_name=MyApplication.getInstance().getPrefManager().getPreferrence("imageName");
           // String Url="http://app.thiensurat.co.th/assanee/uploads_image_report_problem/"+image_name+".jpg";
            String Url=SERVER_PATH+"uploads_image_report_problem/"+image_name+".jpg";
            File file2 = new File(FILE);
            long length = file2.length();
            length = length/1024;

            String number="";
            if(check_buttom_remove_image==1){
                number= String.valueOf(2);
            }
            else {
                number= String.valueOf(1);
            }

            SQLiteDataBaseBuild();
            SQLiteTableBuild();
            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "jpg" + "','" + order_image + "');";
            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);

            for (int i = 1; i <=1; i++) {

                SectionDataModel2 dm = new SectionDataModel2();

                dm.setHeaderTitle("ล่าสุด ");

               singleItem2 = new ArrayList<SingleItemModel2>();




                if(check_buttom_remove_image==1) {
                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
                            singleItem2.add(new SingleItemModel2("รูป " + f, FA));

                            size = singleItem2.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }
                else {

                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "", null);

                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
                            singleItem2.add(new SingleItemModel2("รูป " + f, FA));

                            size = singleItem2.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }



                dm.setAllItemsInSection(singleItem2);
                allSampleData2.add(dm);
                }

                  adapter = new RecyclerViewDataAdapter6(this, allSampleData2);
                  my_recycler_view.setAdapter(adapter);
            adapter.setitemclick_deleteAll(this);
               // adapter.notifyDataSetChanged();
            if(singleItem2.size()==0){
                my_recycler_view.setVisibility(View.GONE);
            }
            else {
                my_recycler_view.setVisibility(View.VISIBLE);
            }
            //select_image();

        }

        else if (requestCode == 88 && resultCode == RESULT_OK) {
            allSampleData2.clear();
            order_image=order_image+1;
            String FILE="";
            String DD="";
            String image_name="";
            String image_type="png";
            int size_arr;
            Uri uri = data.getData();
            String[] projection = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(projection[0]);
            String filepath = cursor.getString(columnIndex);

/*            FILE =filepath;
            File file=new File(filepath);
            image_name=file.getName().substring(0,file.getName().indexOf("."));
            image_type=file.getName().substring(file.getName().lastIndexOf(".")+1);

            cursor.close();*/


            String FILE2= "";

            try {

                File file21 = new File(filepath);
                String filePath = file21.getPath();
                Bitmap bitmap = BitmapFactory.decodeFile(filePath);
                ic.getResizedBiBitmaptmap(bitmap,"open");
                FILE2 = MyApplication.getInstance().getPrefManager().getPreferrence("part_image") + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+"new" + ".png";

            }
            catch (Exception ex){

            }

            FILE =FILE2;

            image_name = MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+"new";
            cursor.close();

            // test_image.setImage(FILE);








            //String Url="http://app.thiensurat.co.th/assanee/uploads_image_report_problem/"+image_name+"."+image_type;
            String Url=SERVER_PATH+"uploads_image_report_problem/"+image_name+"."+image_type;
          //  String Url=SERVER_PATH+"uploads_image_report_problem/"+image_name+".jpg";
            // Log.e("Url_image_name",Url);

            File file2 = new File(FILE);
            long length = file2.length();
            length = length/1024;


            String number="";
            if(check_buttom_remove_image==1){
                number= String.valueOf(2);
            }
            else {
                number= String.valueOf(1);
            }


            SQLiteDataBaseBuild();
            SQLiteTableBuild();

            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + image_type + "','" + order_image + "');";
            // String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (part_id,part_image,type_image) VALUES('" + id_image_success + "', '" + file.getAbsolutePath() + "', '" + "image_success" + "');";
            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);

            for (int i = 1; i <=1; i++) {

                SectionDataModel2 dm = new SectionDataModel2();

                dm.setHeaderTitle("ล่าสุด ");

                singleItem2 = new ArrayList<SingleItemModel2>();






                if(check_buttom_remove_image==1) {
                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
                            Log.e("A", FA);

                            // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                            // String f= String.valueOf(order_image);
                            singleItem2.add(new SingleItemModel2("รูป " + f, FA));

                            size = singleItem2.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }

                else {

                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "", null);

                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
                            Log.e("A", FA);

                            // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                            // String f= String.valueOf(order_image);
                            singleItem2.add(new SingleItemModel2("รูป " + f, FA));

                            size = singleItem2.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }






                dm.setAllItemsInSection(singleItem2);

                allSampleData2.add(dm);


            }


            RecyclerViewDataAdapter6 adapter = new RecyclerViewDataAdapter6(this, allSampleData2);
            my_recycler_view.setAdapter(adapter);
            adapter.setitemclick_deleteAll(this);

            if(singleItem2.size()==0){
                my_recycler_view.setVisibility(View.GONE);
            }
            else {
                my_recycler_view.setVisibility(View.VISIBLE);
            }
        }

    }




    public void SQLiteDataBaseBuild(){

        sqLiteDatabase = this.openOrCreateDatabase(SQLiteHelper_image_buffer.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    public void SQLiteTableBuild(){

        //sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper.TABLE_NAME+"("+ SQLiteHelper.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+SQLiteHelper.Table_Column_1_Subject_Name+" VARCHAR, "+SQLiteHelper.Table_Column_2_SubjectFullForm+" VARCHAR, "+SQLiteHelper.Table_Column_3_subteamcode+" VARCHAR, "+SQLiteHelper.Table_Column_5_contract_number+" VARCHAR, "+SQLiteHelper.Table_Column_6_contract_number2+" VARCHAR, "+SQLiteHelper.Table_Column_7_name_topic+" VARCHAR, "+SQLiteHelper.Table_Column_8_customer+" VARCHAR, "+SQLiteHelper.Table_Column_9_description+" VARCHAR, "+SQLiteHelper.Table_Column_16_status+" VARCHAR, "+SQLiteHelper.Table_Column_15_date_time+" VARCHAR, "+SQLiteHelper.Table_Column_23_date_time_update+" VARCHAR, "+SQLiteHelper.Table_Column_10_approveStatus+" VARCHAR, "+SQLiteHelper.Table_Column_11_approveBy+" VARCHAR, "+SQLiteHelper.Table_Column_12_approveDate+" VARCHAR, "+SQLiteHelper.Table_Column_17_isremark+" VARCHAR, "+SQLiteHelper.Table_Column_14_isremark1+" VARCHAR, "+SQLiteHelper.Table_Column_20_check_foller+" VARCHAR, "+SQLiteHelper.Table_Column_21_countfoller+" VARCHAR, "+SQLiteHelper.Table_Column_22_countcomment+" VARCHAR, "+SQLiteHelper.Table_Column_4_picture+" VARCHAR);");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_image_buffer.TABLE_NAME+"("+ SQLiteHelper_image_buffer.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_image_buffer.Table_part_id+" VARCHAR, "+SQLiteHelper_image_buffer.Table_name_image+" VARCHAR, "+SQLiteHelper_image_buffer.Table_url_image+" VARCHAR, "+SQLiteHelper_image_buffer.Table_Url+" VARCHAR, "+SQLiteHelper_image_buffer.Table_Image_Name+" VARCHAR, "+SQLiteHelper_image_buffer.Table_Image_Size+" VARCHAR, "+SQLiteHelper_image_buffer.Table_Image_Type+" VARCHAR, "+SQLiteHelper_image_buffer.Table_order_image+" VARCHAR);");


    }





    public class ObjNonti{
        public String InformID,WorkCode,MessageHeader,MessageDetails,ipaddress;
    }
    private WebSocketClient webSocketClient;
    public void connectSocket(){

        //sent_nontification_to_credit();
       // sent_nontification_to_sale_all();

        Log.e("","");
        URI uri;
        try {
            uri = new URI(API_URL_ALL.URL_non_to_web_Activity_edit_problem_from_sale);
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }
        webSocketClient = new WebSocketClient(uri) {
            @Override
            public void onOpen() {
                System.out.println("onOpen");
                ObjNonti ob = new ObjNonti();
                ob.InformID = InformID_S+"_"+ID+"_"+"AE";
                ob.WorkCode = "24";
                ob.ipaddress=MyApplication.getInstance().getPrefManager().getPreferrence("IPaddress");
                ob.MessageHeader = "แก้ไขปัญหาจาก : "+MyApplication.getInstance().getPrefManager().getPreferrence("EMPID")+" : "+MyApplication.getInstance().getPrefManager().getPreferrence("EmployeeName");
                ob.MessageDetails = details_problem_nonti_to_web+" : "+new_message2.getText().toString();
                Gson gson = new Gson();
                String json = gson.toJson(ob);
                Log.e("strJson" , json);
                webSocketClient.send(json);
            }

            @Override
            public void onTextReceived(String message) {
                System.out.println("onTextReceived");
                webSocketClient.close();
            }

            @Override
            public void onBinaryReceived(byte[] data) {
                System.out.println("onBinaryReceived");
            }

            @Override
            public void onPingReceived(byte[] data) {
                System.out.println("onPingReceived");
            }

            @Override
            public void onPongReceived(byte[] data) {
                System.out.println("onPongReceived");
            }

            @Override
            public void onException(Exception e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onCloseReceived() {
                System.out.println("onCloseReceived");
            }
        };



        webSocketClient.setConnectTimeout(10000);
        webSocketClient.setReadTimeout(60000);
        //webSocketClient.addHeader("Origin", "http://developer.example.com");
        //webSocketClient.enableAutomaticReconnection(5000);
        webSocketClient.connect();
        check_nonti_web=1;
    }









    public void JSON_DATA_WEB_CALL38() {

        Log.e("gggg",API_URL_ALL.GET_JSON_DATA_HTTP_URL2_Activity_edit_problem_from_sale+"?contno="+Contno_S);
        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL2_Activity_edit_problem_from_sale+"?contno="+Contno_S ,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {



                        JSON_PARSE_DATA_AFTER_WEBCALL3(response);
                        //   pDialog2.dismissWithAnimation();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //JSON_DATA_WEB_CALL3();
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


    GetData_cedit_sale_edit_problem  GetDataAdapter3;
    public void JSON_PARSE_DATA_AFTER_WEBCALL3(JSONArray array) {

        // if(array.length()==0){
        //    pDialog2.dismissWithAnimation();
        // }


        for (int i = 0; i < array.length(); i++) {

            GetDataAdapter3 = new GetData_cedit_sale_edit_problem();

            JSONObject json = null;

            try {

                json = array.getJSONObject(i);

                GetDataAdapter3.setEmployeeName_sale(json.getString("EmployeeName"));
                GetDataAdapter3.setPositionName_sale(json.getString("PositionName"));

                GetDataAdapter3.setSubTeamName(json.getString("SubTeamName"));
                GetDataAdapter3.setSubTeamHeadName(json.getString("SubTeamHeadName"));
                GetDataAdapter3.setTeamCode(json.getString("TeamCode"));
                GetDataAdapter3.setTeamName(json.getString("TeamName"));
                GetDataAdapter3.setTeamHeadName(json.getString("TeamHeadName"));


                GetDataAdapter3.setSupervisorName(json.getString("SupervisorName"));
                GetDataAdapter3.setSupervisorHeadName(json.getString("SupervisorHeadName"));

                GetDataAdapter3.setSubDepartmentName(json.getString("SubDepartmentName"));
                GetDataAdapter3.setSubDepartmentHeadName(json.getString("SubDepartmentHeadName"));

                GetDataAdapter3.setDepartmentName(json.getString("DepartmentName"));
                GetDataAdapter3.setDepartmentHeadName(json.getString("DepartmentHeadName"));

                GetDataAdapter3.setPicture_sale(json.getString("picture"));
                GetDataAdapter3.setProductName(json.getString("ProductName"));
                GetDataAdapter3.setProductPrice(json.getString("ProductPrice"));
                GetDataAdapter3.setCustomerName(json.getString("CustomerName"));

                GetDataAdapter3.setAddressall(json.getString("Addressall"));
                GetDataAdapter3.setLatitude(json.getString("Latitude"));
                GetDataAdapter3.setLongitude(json.getString("Longitude"));
                GetDataAdapter3.setTelHome(json.getString("TelHome"));
                GetDataAdapter3.setTelMobile(json.getString("TelMobile"));



                GetDataAdapter3.setSaleStatus(json.getString("SaleStatus"));
                GetDataAdapter3.setTeamSaleStatus(json.getString("TeamSaleStatus"));
                GetDataAdapter3.setSupSaleStatus(json.getString("SupSaleStatus"));
                GetDataAdapter3.setSecSaleStatus(json.getString("SecSaleStatus"));
                GetDataAdapter3.setMngSaleStatus(json.getString("MngSaleStatus"));

                GetDataAdapter3.setTeamSaleEmp_picture(json.getString("TeamSaleEmp_picture"));
                GetDataAdapter3.setSupSaleEmp_picture(json.getString("SupSaleEmp_picture"));
                GetDataAdapter3.setSecSaleEmp_picture(json.getString("SecSaleEmp_picture"));
                GetDataAdapter3.setMngSaleEmp_picture(json.getString("MngSaleEmp_picture"));

                GetDataAdapter3.setOutstanding(json.getString("Outstanding"));
                GetDataAdapter3.setCustomerStatus(json.getString("CustomerStatus"));
                GetDataAdapter3.setAccountStatus(json.getString("AccountStatus"));
                GetDataAdapter3.setPayLastPeriod(json.getString("PayLastPeriod"));
            } catch (JSONException e) {

                e.printStackTrace();
            }
        }


        pDialog.dismissWithAnimation();






        final SimpleTooltip tooltip = new SimpleTooltip.Builder(this)
                .anchorView(e)
                .text("ddddddddd")
                .gravity(Gravity.BOTTOM)
                //.dismissOnOutsideTouch(true)
                //.dismissOnInsideTouch(true)
                .modal(true)
                .animated(true)
                .animationDuration(2000)
                .animationPadding(SimpleTooltipUtils.pxFromDp(0))
                //.padding(SimpleTooltipUtils.pxFromDp(50))

                .contentView(R.layout.custom_popup3, R.id.txt_namesale)
                //.focusable(true)
                // .maxWidth(SimpleTooltipUtils.pxFromDp(10))
                .build();
        //pDialog.dismissWithAnimation();

        final ImageView handle0= (ImageView)tooltip.findViewById(R.id.handle0);
        final TextView txt_namesale0= (TextView)tooltip.findViewById(R.id.txt_namesale0);
        final TextView txt_position0= (TextView)tooltip.findViewById(R.id.txt_position0);




        final TextView txt_teamcode= (TextView) tooltip.findViewById(R.id.txt_teamcode);
        final TextView txt_boss= (TextView) tooltip.findViewById(R.id.txt_boss);
        final TextView  txt_bossposition= (TextView) tooltip.findViewById(R.id.txt_bossposition);
        final TextView txt_ProductName= (TextView) tooltip.findViewById(R.id.txt_ProductName);
        final TextView txt_ProductPrice= (TextView) tooltip.findViewById(R.id.txt_ProductPrice);
        final TextView  txt_CustomerName= (TextView) tooltip.findViewById(R.id.txt_CustomerName);
        final TextView txt_Addressall= (TextView) tooltip.findViewById(R.id.txt_Addressall);

        final TextView txt_Outstanding= (TextView) tooltip.findViewById(R.id.txt_Outstanding);
        final TextView txt_CustomerStatus= (TextView) tooltip.findViewById(R.id.txt_CustomerStatus);
        final TextView txt_AccountStatus= (TextView) tooltip.findViewById(R.id.txt_AccountStatus);
        final TextView txt_PayLastPeriod= (TextView) tooltip.findViewById(R.id.txt_PayLastPeriod);




        final ImageView handle= (ImageView) tooltip.findViewById(R.id.handle);
        final ImageView handle2= (ImageView) tooltip.findViewById(R.id.handle2);
        final ImageView handle3= (ImageView) tooltip.findViewById(R.id.handle3);
        final ImageView handle4= (ImageView) tooltip.findViewById(R.id.handle4);
        final ImageView handle5= (ImageView) tooltip.findViewById(R.id.handle5);

        final TextView txt_namesale= (TextView) tooltip.findViewById(R.id.txt_namesale);
        final TextView txt_namesale2= (TextView) tooltip.findViewById(R.id.txt_namesale2);
        final TextView txt_namesale3= (TextView) tooltip.findViewById(R.id.txt_namesale3);
        final TextView txt_namesale4= (TextView) tooltip.findViewById(R.id.txt_namesale4);
        final TextView txt_namesale5= (TextView) tooltip.findViewById(R.id.txt_namesale5);

        final TextView txt_position= (TextView) tooltip.findViewById(R.id.txt_position);
        final TextView txt_position2= (TextView) tooltip.findViewById(R.id.txt_position2);
        final TextView txt_position3= (TextView) tooltip.findViewById(R.id.txt_position3);
        final TextView txt_position4= (TextView) tooltip.findViewById(R.id.txt_position4);
        final TextView txt_position5= (TextView) tooltip.findViewById(R.id.txt_position5);

        final TextView txt_status_name= (TextView) tooltip.findViewById(R.id.txt_status_name);
        final TextView txt_status_name2= (TextView) tooltip.findViewById(R.id.txt_status_name2);
        final TextView txt_status_name3= (TextView) tooltip.findViewById(R.id.txt_status_name3);
        final TextView txt_status_name4= (TextView) tooltip.findViewById(R.id.txt_status_name4);
        final TextView txt_status_name5= (TextView) tooltip.findViewById(R.id.txt_status_name5);

        final TextView  txt_pay= (TextView) tooltip.findViewById(R.id.txt_pay);
        final TextView   txt_baba= (TextView) tooltip.findViewById(R.id.txt_baba);

        try {
            Glide.with(this).load(GetDataAdapter3.getPicture_sale())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(this))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                    .placeholder(this.getResources().getDrawable(R.drawable.dasaa))
                    .into(handle0);
        }
        catch (Exception e) {

        }



        txt_namesale0.setText(GetDataAdapter3.getEmployeeName_sale());
        txt_position0.setText(GetDataAdapter3.getPositionName_sale());

        //txt_namesale.setText(GetDataAdapter3.getEmployeeName_sale());
        //txt_position.setText(GetDataAdapter3.getPositionName_sale());
        txt_teamcode.setText(GetDataAdapter3.getTeamCode());
        txt_boss.setText(GetDataAdapter3.getTeamHeadName());
        txt_bossposition.setText(GetDataAdapter3.getTeamName());
        txt_ProductName.setText(GetDataAdapter3.getProductName());
        txt_ProductPrice.setText(GetDataAdapter3.getProductPrice());
        txt_CustomerName.setText(GetDataAdapter3.getCustomerName());
        txt_Addressall.setText(GetDataAdapter3.getAddressall());

        txt_Outstanding.setText(GetDataAdapter3.getOutstanding());
        txt_CustomerStatus.setText(GetDataAdapter3.getCustomerStatus());
        txt_AccountStatus.setText(GetDataAdapter3.getAccountStatus());
        txt_PayLastPeriod.setText(GetDataAdapter3.getPayLastPeriod());





        try {
            Glide.with(this).load(GetDataAdapter3.getPicture_sale())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(this))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                    .placeholder(this.getResources().getDrawable(R.drawable.dasaa))
                    .into(handle);
        }
        catch (Exception e) {

        }



        try {
            Glide.with(this).load(GetDataAdapter3.getTeamSaleEmp_picture())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(this))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                    .placeholder(this.getResources().getDrawable(R.drawable.dasaa))
                    .into(handle2);
        }
        catch (Exception e) {

        }



        try {
            Glide.with(this).load(GetDataAdapter3.getSupSaleEmp_picture())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(this))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                    .placeholder(this.getResources().getDrawable(R.drawable.dasaa))
                    .into(handle3);
        }
        catch (Exception e) {

        }


        try {
            Glide.with(this).load(GetDataAdapter3.getSecSaleEmp_picture())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(this))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                    .placeholder(this.getResources().getDrawable(R.drawable.dasaa))
                    .into(handle4);
        }
        catch (Exception e) {

        }


        try {
            Glide.with(this).load(GetDataAdapter3.getMngSaleEmp_picture())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(this))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                    .placeholder(this.getResources().getDrawable(R.drawable.dasaa))
                    .into(handle5);
        }
        catch (Exception e) {

        }




        txt_namesale.setText(GetDataAdapter3.getEmployeeName_sale());

        txt_namesale2.setText(GetDataAdapter3.getTeamHeadName());

        txt_namesale3.setText(GetDataAdapter3.getSupervisorHeadName());
        txt_namesale4.setText(GetDataAdapter3.getSubDepartmentHeadName());
        txt_namesale5.setText(GetDataAdapter3.getDepartmentHeadName());

        txt_position.setText(GetDataAdapter3.getPositionName_sale());

        txt_position2.setText(GetDataAdapter3.getTeamName());

        txt_position3.setText(GetDataAdapter3.getSupervisorName());
        txt_position4.setText(GetDataAdapter3.getSubDepartmentName());
        txt_position5.setText(GetDataAdapter3.getDepartmentName());


        String CHECK_STATUS_SALE1=GetDataAdapter3.getSaleStatus()+"";
        String CHECK_STATUS_SALE2=GetDataAdapter3.getSupSaleStatus()+"";
        String CHECK_STATUS_SALE3=GetDataAdapter3.getSupSaleStatus()+"";
        String CHECK_STATUS_SALE4=GetDataAdapter3.getSecSaleStatus()+"";
        String CHECK_STATUS_SALE5=GetDataAdapter3.getMngSaleStatus()+"";


        if(CHECK_STATUS_SALE1.equals("null")){
            txt_status_name.setText("ไม่มี");
            txt_status_name.setBackgroundResource(R.drawable.roun_rect_orange23);
            txt_status_name.setTextColor(0xffffffff);
        }
        else {

            if (CHECK_STATUS_SALE1.equals("D")) {
                txt_status_name.setText("รักษาการ");
                txt_status_name.setBackgroundResource(R.drawable.roun_rect_orange23);
                txt_status_name.setTextColor(0xffffffff);

            }
            else if (CHECK_STATUS_SALE1.equals("G")) {
                txt_status_name.setText("ย้ายออก");
                txt_status_name.setBackgroundResource(R.drawable.roun_rect_orange24);
                txt_status_name.setTextColor(0xffffffff);

            }

            else if (CHECK_STATUS_SALE1.equals("N")) {
                txt_status_name.setText("ปกติ");
                txt_status_name.setBackgroundResource(R.drawable.roun_rect_orange17);
                txt_status_name.setTextColor(0xffffffff);

            } else if (CHECK_STATUS_SALE1.equals("P")) {
                txt_status_name.setText("ย้าย");
                txt_status_name.setBackgroundResource(R.drawable.roun_rect_orange22);
                txt_status_name.setTextColor(0xffffffff);


            } else {
                txt_status_name.setText("ออก");
                txt_status_name.setBackgroundResource(R.drawable.roun_rect_orange21);
                txt_status_name.setTextColor(0xffffffff);

            }
        }





        if(CHECK_STATUS_SALE2.equals("null")){
            txt_status_name2.setText("ไม่มี");
            txt_status_name2.setBackgroundResource(R.drawable.roun_rect_orange23);
            txt_status_name2.setTextColor(0xffffffff);
        }
        else {

            if (CHECK_STATUS_SALE2.equals("D")) {
                txt_status_name2.setText("รักษาการ");
                txt_status_name2.setBackgroundResource(R.drawable.roun_rect_orange23);
                txt_status_name2.setTextColor(0xffffffff);

            }
            else if (CHECK_STATUS_SALE2.equals("G")) {
                txt_status_name2.setText("ย้ายออก");
                txt_status_name2.setBackgroundResource(R.drawable.roun_rect_orange24);
                txt_status_name2.setTextColor(0xffffffff);

            }

            else if (CHECK_STATUS_SALE2.equals("N")) {
                txt_status_name2.setText("ปกติ");
                txt_status_name2.setBackgroundResource(R.drawable.roun_rect_orange17);
                txt_status_name2.setTextColor(0xffffffff);

            } else if (CHECK_STATUS_SALE2.equals("P")) {
                txt_status_name2.setText("ย้าย");
                txt_status_name2.setBackgroundResource(R.drawable.roun_rect_orange22);
                txt_status_name2.setTextColor(0xffffffff);


            } else  {
                txt_status_name2.setText("ออก");
                txt_status_name2.setBackgroundResource(R.drawable.roun_rect_orange21);
                txt_status_name2.setTextColor(0xffffffff);

            }
        }





        if(CHECK_STATUS_SALE3.equals("null")){
            txt_status_name3.setText("ไม่มี");
            txt_status_name3.setBackgroundResource(R.drawable.roun_rect_orange23);
            txt_status_name3.setTextColor(0xffffffff);
        }
        else {

            if (CHECK_STATUS_SALE3.equals("D")) {
                txt_status_name3.setText("รักษาการ");
                txt_status_name3.setBackgroundResource(R.drawable.roun_rect_orange23);
                txt_status_name3.setTextColor(0xffffffff);

            }
            else if (CHECK_STATUS_SALE3.equals("G")) {
                txt_status_name3.setText("ย้ายออก");
                txt_status_name3.setBackgroundResource(R.drawable.roun_rect_orange24);
                txt_status_name3.setTextColor(0xffffffff);

            }

            else if (CHECK_STATUS_SALE3.equals("N")) {
                txt_status_name3.setText("ปกติ");
                txt_status_name3.setBackgroundResource(R.drawable.roun_rect_orange17);
                txt_status_name3.setTextColor(0xffffffff);

            } else if (CHECK_STATUS_SALE3.equals("P")) {
                txt_status_name3.setText("ย้าย");
                txt_status_name3.setBackgroundResource(R.drawable.roun_rect_orange22);
                txt_status_name3.setTextColor(0xffffffff);


            } else {
                txt_status_name3.setText("ออก");
                txt_status_name3.setBackgroundResource(R.drawable.roun_rect_orange21);
                txt_status_name3.setTextColor(0xffffffff);

            }
        }











        if(CHECK_STATUS_SALE4.equals("null")){
            txt_status_name4.setText("ไม่มี");
            txt_status_name4.setBackgroundResource(R.drawable.roun_rect_orange23);
            txt_status_name4.setTextColor(0xffffffff);
        }
        else {

            if (CHECK_STATUS_SALE4.equals("D")) {
                txt_status_name4.setText("รักษาการ");
                txt_status_name4.setBackgroundResource(R.drawable.roun_rect_orange23);
                txt_status_name4.setTextColor(0xffffffff);

            }
            else if (CHECK_STATUS_SALE4.equals("G")) {
                txt_status_name4.setText("ย้ายออก");
                txt_status_name4.setBackgroundResource(R.drawable.roun_rect_orange24);
                txt_status_name4.setTextColor(0xffffffff);

            }

            else if (CHECK_STATUS_SALE4.equals("N")) {
                txt_status_name4.setText("ปกติ");
                txt_status_name4.setBackgroundResource(R.drawable.roun_rect_orange17);
                txt_status_name4.setTextColor(0xffffffff);

            } else if (CHECK_STATUS_SALE4.equals("P")) {
                txt_status_name4.setText("ย้าย");
                txt_status_name4.setBackgroundResource(R.drawable.roun_rect_orange22);
                txt_status_name4.setTextColor(0xffffffff);


            } else {
                txt_status_name4.setText("ออก");
                txt_status_name4.setBackgroundResource(R.drawable.roun_rect_orange21);
                txt_status_name4.setTextColor(0xffffffff);

            }
        }














        if(CHECK_STATUS_SALE5.equals("null")){
            txt_status_name5.setText("ไม่มี");
            txt_status_name5.setBackgroundResource(R.drawable.roun_rect_orange23);
            txt_status_name5.setTextColor(0xffffffff);
        }
        else {

            if (CHECK_STATUS_SALE5.equals("D")) {
                txt_status_name5.setText("รักษาการ");
                txt_status_name5.setBackgroundResource(R.drawable.roun_rect_orange23);
                txt_status_name5.setTextColor(0xffffffff);

            }
            else if (CHECK_STATUS_SALE5.equals("G")) {
                txt_status_name5.setText("ย้ายออก");
                txt_status_name5.setBackgroundResource(R.drawable.roun_rect_orange24);
                txt_status_name5.setTextColor(0xffffffff);

            }

            else if (CHECK_STATUS_SALE5.equals("N")) {
                txt_status_name5.setText("ปกติ");
                txt_status_name5.setBackgroundResource(R.drawable.roun_rect_orange17);
                txt_status_name5.setTextColor(0xffffffff);

            } else if (CHECK_STATUS_SALE5.equals("P")) {
                txt_status_name5.setText("ย้าย");
                txt_status_name5.setBackgroundResource(R.drawable.roun_rect_orange22);
                txt_status_name5.setTextColor(0xffffffff);


            } else {
                txt_status_name5.setText("ออก");
                txt_status_name5.setBackgroundResource(R.drawable.roun_rect_orange21);
                txt_status_name5.setTextColor(0xffffffff);

            }
        }

        txt_Outstanding.setText(NetAmount);
        txt_pay.setText(PaymentPeriodNumber+" งวด");
        txt_baba.setText(Balance);
        tooltip.show();

    }

    public void SELECT_DATA_CONFIRM2(String CONO) {
        Log.e("conno_aa",API_URL_ALL.GET_JSON_DATA_HTTP_URL_gory_6_Activity_edit_problem_from_sale+"?CONTNO="+CONO);

        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_gory_6_Activity_edit_problem_from_sale+"?CONTNO="+CONO ,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_SELECT_DATA_CONFIRM2(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        SELECT_DATA_CONFIRM2(CONO);
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

    String TotalPrice="",Balance="",PaymentPeriodNumber="",NetAmount="";
    public void JSON_PARSE_DATA_AFTER_SELECT_DATA_CONFIRM2(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {


            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                TotalPrice=json.getString("TotalPrice");
                Balance=json.getString("Balance");
                PaymentPeriodNumber=json.getString("PaymentPeriodNumber");
                // NetAmount=json.getString("NetAmount");


                JSONArray array2 = json.getJSONArray("NetAmount");
                JSONObject object = null;

                for (int i2 = 0; i2 < array2.length(); i2++) {

                    object = array2.getJSONObject(i2);
                    String IMAGE= object.getString(String.valueOf((i2+1)));
                    NetAmount=IMAGE;

                }


            } catch (JSONException e) {

                e.printStackTrace();
            }


            ;
        }



    }
    private void checkCameraPermission() {
        Dexter.withActivity(this)
                .withPermissions(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (report.areAllPermissionsGranted()) {
                            // Do something
                        } else {
                            //Toast.makeText(MainActivity_Loadmore.this, R.string.camera_and_write_external_storage_denied, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<com.karumi.dexter.listener.PermissionRequest> permissions, PermissionToken token) {

                    }


                })
                .check();
    }



    private class Async_sent_nontification_to_credit extends AsyncTask<String, String, String>
    {
        ProgressDialog pdLoading = new ProgressDialog(Activity_edit_problem_from_sale.this);
        HttpURLConnection conn;
        URL url = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //this method will be running on UI thread

            /*
            pdLoading.setMessage("\tLoading...");
            pdLoading.setCancelable(false);
            pdLoading.show();*/

        }
        @Override
        protected String doInBackground(String... params) {
            try {

                // Enter URL address where your php file resides
                url = new URL(EndPoints.URL_UPDATE_OFFLINE2);

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return "exception";
            }
            try {
                // Setup HttpURLConnection class to send and receive data from php and mysql
                conn = (HttpURLConnection)url.openConnection();
                conn.setReadTimeout(READ_TIMEOUT);
                conn.setConnectTimeout(CONNECTION_TIMEOUT);
                conn.setRequestMethod("POST");

                // setDoInput and setDoOutput method depict handling of both send and receive
                conn.setDoInput(true);
                conn.setDoOutput(true);


                // Append parameters to URL
                Uri.Builder builder = new Uri.Builder()
                        //  .appendQueryParameter("username", params[0])
                        //.appendQueryParameter("password", params[1]);


                        .appendQueryParameter("contno", params[0])
                        .appendQueryParameter("problem", params[1])
                        .appendQueryParameter("fcm_key", params[2])
                        .appendQueryParameter("user_code", params[3])
                        .appendQueryParameter("ID", params[4])
                        .appendQueryParameter("image", params[5])
                        .appendQueryParameter("CashTeamCode", params[6]);


                //  params.put("contno", "U0301411");
                // params.put("problem", "1,2");
                //    params.put("fcm_key", "d_aGtUtkpeE:APA91bFwK2MAlmOQzgzQEBjr6akEFQgtR8dO8RTY72V6rEbK2yjxDNNyFsqq5KLVVcbnm0hr7je3kwMyr5IBjH-PlrRZHe5fV4EbjNyA606Z9RGaDU7jJ6ckPRusHQK1Ef2NVxIzndS-");
                //  params.put("user_code", "A29971");
                //params.put("ID", "7");
                //  params.put("image", "http://app.thiensurat.co.th/assanee/upload/iconprofile/picture1.png");
                // params.put("CashTeamCode", "059");

                String query = builder.build().getEncodedQuery();

                // Open connection for sending data
                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();
                conn.connect();

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                return "exception";
            }

            try {

                int response_code = conn.getResponseCode();

                // Check if successful connection made
                if (response_code == HttpURLConnection.HTTP_OK) {

                    // Read data sent from server
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }

                    // Pass data to onPostExecute method
                    return(result.toString());

                }else{

                    return("unsuccessful");
                }

            } catch (IOException e) {
                e.printStackTrace();
                return "exception";
            } finally {
                conn.disconnect();
            }


        }

        @Override
        protected void onPostExecute(String result) {

            //this method will be running on UI thread

           // pdLoading.dismiss();
            conn.disconnect();
            if(result.equalsIgnoreCase("true"))
            {
                /* Here launching another activity when login successful. If you persist login state
                use sharedPreferences of Android. and logout button to clear sharedPreferences.
                 */

                //  Intent intent = new Intent(MusicActivity_Credit.this,SuccessActivity.class);
                // startActivity(intent);
                //  MusicActivity_Credit.this.finish();

            }else if (result.equalsIgnoreCase("false")){

                // If username and password does not match display a error message
                //Toast.makeText(MusicActivity_Credit.this, "Invalid email or password", Toast.LENGTH_LONG).Show();

            } else if (result.equalsIgnoreCase("exception") || result.equalsIgnoreCase("unsuccessful")) {

                //  Toast.makeText(MusicActivity_Credit.this, "OOPs! Something went wrong. Connection Problem.", Toast.LENGTH_LONG).Show();

            }
        }

    }

}
