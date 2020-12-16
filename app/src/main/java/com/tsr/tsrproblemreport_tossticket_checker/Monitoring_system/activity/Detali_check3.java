package com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.activity;

/**
 * Created by user on 30/11/2560.
 */

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.github.gcacace.signaturepad.views.SignaturePad;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.tsr.tsrproblemreport_tossticket_checker.BuildConfig;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.MusicActivity_Checker;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.adapter.RecyclerViewDataAdapter_dialog_image_problem_from_id_checker1;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.adapter.RecyclerViewDataAdapter_dialog_image_problem_from_id_checker2;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.adapter.RecyclerViewDataAdapter_dialog_image_problem_from_id_checker3;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.adapter.RecyclerViewDataAdapter_dialog_image_problem_from_id_checker4;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.adapter.RecyclerViewDataAdapter_dialog_image_problem_from_id_checker5;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.adapter.RecyclerViewDataAdapter_dialog_image_problem_from_id_checker_map;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.adapter.RecyclerViewDataAdapter_image1;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.adapter.RecyclerViewDataAdapter_image2;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.adapter.RecyclerViewDataAdapter_image3;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.adapter.RecyclerViewDataAdapter_image4;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.adapter.RecyclerViewDataAdapter_image5;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.adapter.RecyclerViewDataAdapter_image_map;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.data_base.SQLiteHelper_data_checker_problem_for_report;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.data_base.SQLiteHelper_image_buffer_checker1;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.data_base.SQLiteHelper_image_buffer_checker1_2;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.data_base.SQLiteHelper_image_buffer_checker2;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.data_base.SQLiteHelper_image_buffer_checker2_2;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.data_base.SQLiteHelper_image_buffer_checker3;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.data_base.SQLiteHelper_image_buffer_checker3_2;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.data_base.SQLiteHelper_image_buffer_checker4;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.data_base.SQLiteHelper_image_buffer_checker4_2;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.data_base.SQLiteHelper_image_buffer_checker5;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.data_base.SQLiteHelper_image_buffer_checker5_2;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.data_base.SQLiteHelper_image_buffer_checker_map;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.data_base.SQLiteHelper_image_buffer_checker_map_2;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.data_base.SQLiteHelper_image_buffer_checker_pensing;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.data_base.SQLiteHelper_problem_id_image_checker1;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.data_base.SQLiteHelper_problem_id_image_checker2;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.data_base.SQLiteHelper_problem_id_image_checker3;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.data_base.SQLiteHelper_problem_id_image_checker4;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.data_base.SQLiteHelper_problem_id_image_checker5;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.data_base.SQLiteHelper_problem_id_image_checker_map;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.GetData_cedit_dialog_image_problem_from_id_checker1;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.GetData_cedit_dialog_image_problem_from_id_checker2;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.GetData_cedit_dialog_image_problem_from_id_checker3;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.GetData_cedit_dialog_image_problem_from_id_checker4;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.GetData_cedit_dialog_image_problem_from_id_checker5;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.GetData_cedit_dialog_image_problem_from_id_checker_map;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.GetData_select_checker_who;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.GetData_select_home_in;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.GetData_select_install;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.GetData_select_map_maker;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.SectionDataModel_checker1;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.SectionDataModel_checker2;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.SectionDataModel_checker3;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.SectionDataModel_checker4;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.SectionDataModel_checker5;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.SectionDataModel_checker_map;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.SingleItemModel_checker1;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.SingleItemModel_checker2;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.SingleItemModel_checker3;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.SingleItemModel_checker4;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.SingleItemModel_checker5;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.SingleItemModel_checker_map;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.pen_sing.ViewSignatureActivity;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.qrcode.MainActivity_barcode;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.MusicActivity_Credit;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.Service;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.map.MapsActivity;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_image_new;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_uploade_Image;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.utils.ImageConfiguration;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.utils.MarshMallowPermission;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import cn.pedant.SweetAlert.SweetAlertDialog;
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

import static com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.pen_sing.SignatureActivity.STORAGE_PERMISSION_CODE;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.map.MapsActivity.imageFile;

public class Detali_check3 extends AppCompatActivity implements View.OnClickListener,RecyclerViewDataAdapter_image1.itemclick_deleteAll_image1,RecyclerViewDataAdapter_image2.itemclick_deleteAll_image2,RecyclerViewDataAdapter_image3.itemclick_deleteAll_image3,RecyclerViewDataAdapter_image4.itemclick_deleteAll_image4,RecyclerViewDataAdapter_image5.itemclick_deleteAll_image5,RecyclerViewDataAdapter_image_map.itemclick_deleteAll_image_map,RecyclerViewDataAdapter_dialog_image_problem_from_id_checker1.itemclick_deleteAll_id_checker1,RecyclerViewDataAdapter_dialog_image_problem_from_id_checker2.itemclick_deleteAll_id_checker2,RecyclerViewDataAdapter_dialog_image_problem_from_id_checker3.itemclick_deleteAll_id_checker3,RecyclerViewDataAdapter_dialog_image_problem_from_id_checker4.itemclick_deleteAll_id_checker4,RecyclerViewDataAdapter_dialog_image_problem_from_id_checker5.itemclick_deleteAll_id_checker5,RecyclerViewDataAdapter_dialog_image_problem_from_id_checker_map.itemclick_deleteAll_id_checker_map {
    RelativeLayout relat_scan,open_camera,open_camera2,open_camera3,
            open_camera4,open_camera5,open_image,open_image2,open_image3
            ,open_image4,open_image5,location,r_save,r_save2,r_save_di,r_save_di2;
    LinearLayout linear_pen,li1,li2,li3,li4,li5,li6,li_qr1,li7,li_pay2,li_pay2_2;
    private SignaturePad objSignaturePad;
    private String signaturePath;
    String conno="",FnYear="",FnMonth="",customer="",PayLastPeriod="",Outstanding="",ProcessTypeID="";
    TextView txt_scan;
    ImageView image_tal2,image_tal3,image_clear,image_pen_sing;
    ImageButton bt_scan,switcher2;
    RecyclerView my_recycler_view1,my_recycler_view2,my_recycler_view3,my_recycler_view4,my_recycler_view5,my_recycler_view_map;
    Spinner spDemo,spDemo1,spDemo2,spDemo3,spDemo4;
    EditText new_message,new_message1,new_message2,new_message3,new_message4,new_message_home_in,new_message_scan,new_message_install,new_message_pay2;
    RadioButton RadioButton_0,RadioButton_1,RadioButton_2,RadioButton_4,RadioButton_5,RadioButton_6;
    CheckBox CheckBox0;
    int CheckBox_status=0;
    RadioGroup radioSexGroup,radioSexGroup1,radioSexGroup2;
    private RadioButton radioButton1,radioButton2,radioButton3;
    Intent Intent;
    String VersionOSM="",AnswerID_home_in="",AnswerID_gps="",AnswerID_install="",AnswerID_who="",TopicID_home_in="",TopicID_gps="",
            TopicID_install="",TopicID_who="";

    String checkedText_confirm="",checkedText_install="",checkedText_pay_one="";
    long noOfDaysBetween = 0;
    ImageConfiguration ic;
    Uri fileUri;
    Intent CamIntent,CropIntent;
    File file;
    String PATH;
    MarshMallowPermission marshMallowPermission = new MarshMallowPermission(this);
    Timer timer;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;

    ArrayList<SectionDataModel_checker1> allSampleData1;
    ArrayList<SectionDataModel_checker2> allSampleData2;
    ArrayList<SectionDataModel_checker3> allSampleData3;
    ArrayList<SectionDataModel_checker4> allSampleData4;
    ArrayList<SectionDataModel_checker5> allSampleData5;
    ArrayList<SectionDataModel_checker_map> allSampleData_map;

    ArrayList<SingleItemModel_checker1> singleItem1;
    ArrayList<SingleItemModel_checker2> singleItem2;
    ArrayList<SingleItemModel_checker3> singleItem3;
    ArrayList<SingleItemModel_checker4> singleItem4;
    ArrayList<SingleItemModel_checker5> singleItem5;
    ArrayList<SingleItemModel_checker_map> singleItem_map;


    RecyclerViewDataAdapter_dialog_image_problem_from_id_checker1 recyclerViewDataAdapter_dialog_image_problem_from_id_checker1;
    RecyclerViewDataAdapter_dialog_image_problem_from_id_checker2 recyclerViewDataAdapter_dialog_image_problem_from_id_checker2;
    RecyclerViewDataAdapter_dialog_image_problem_from_id_checker3 recyclerViewDataAdapter_dialog_image_problem_from_id_checker3;
    RecyclerViewDataAdapter_dialog_image_problem_from_id_checker4 recyclerViewDataAdapter_dialog_image_problem_from_id_checker4;
    RecyclerViewDataAdapter_dialog_image_problem_from_id_checker5 recyclerViewDataAdapter_dialog_image_problem_from_id_checker5;
    RecyclerViewDataAdapter_dialog_image_problem_from_id_checker_map recyclerViewDataAdapter_dialog_image_problem_from_id_checker_map;



    List<GetData_cedit_dialog_image_problem_from_id_checker1> getData_image_more_for_delates_checker1;
    GetData_cedit_dialog_image_problem_from_id_checker1 data_cedit_dialog_image_problem_from_id_checker1;

    List<GetData_cedit_dialog_image_problem_from_id_checker2> getData_image_more_for_delates_checker2;
    GetData_cedit_dialog_image_problem_from_id_checker2 data_cedit_dialog_image_problem_from_id_checker2;

    List<GetData_cedit_dialog_image_problem_from_id_checker3> getData_image_more_for_delates_checker3;
    GetData_cedit_dialog_image_problem_from_id_checker3 data_cedit_dialog_image_problem_from_id_checker3;

    List<GetData_cedit_dialog_image_problem_from_id_checker4> getData_image_more_for_delates_checker4;
    GetData_cedit_dialog_image_problem_from_id_checker4 data_cedit_dialog_image_problem_from_id_checker4;

    List<GetData_cedit_dialog_image_problem_from_id_checker5> getData_image_more_for_delates_checker5;
    GetData_cedit_dialog_image_problem_from_id_checker5 data_cedit_dialog_image_problem_from_id_checker5;

    List<GetData_cedit_dialog_image_problem_from_id_checker_map> getData_image_more_for_delates_checker_map;
    GetData_cedit_dialog_image_problem_from_id_checker_map data_cedit_dialog_image_problem_from_id_checker_map;

    List<GetData_image_new> getData_image_news;
    GetData_image_new getDataImageNew;

    List<GetData_select_home_in> getData_select_home_in;
    List<GetData_select_map_maker> getData_select_map_makers;
    List<GetData_select_checker_who> getData_select_checker_whos;
    List<GetData_select_install> getData_select_installs;


    List<GetData_uploade_Image> getData_uploade_images;

    JsonArrayRequest jsonArrayRequest;
    JsonObjectRequest jsonObjectRequest;
    RequestQueue requestQueue;
    String GET_JSON_DATA_HTTP_URL_gory_1= "http://app.thiensurat.co.th/assanee/checker_system/insert_CheckerCard_Details_home_in.php";
    String GET_JSON_DATA_HTTP_URL_gory_2= "http://app.thiensurat.co.th/assanee/checker_system/insert_CheckerCard_Details_gps_maker.php";
    String GET_JSON_DATA_HTTP_URL_gory_3= "http://app.thiensurat.co.th/assanee/checker_system/insert_CheckerCard_Details_install.php";
    String GET_JSON_DATA_HTTP_URL_gory_4= "http://app.thiensurat.co.th/assanee/checker_system/insert_CheckerCard_Details_checker_who.php";


    String item="",item1="",item2="",item3="",item4="";

    SweetAlertDialog pDialogg;
    private Service uploadService;
    private static final String SERVER_PATH = "http://app.thiensurat.co.th/assanee/";

    String date_s="",date2_s="",date3_s="",date22="";
    TextView date1,date2,txt_day_nad2,txt_Outstanding,txt_PayLastPeriod;



int status_report_problem_qr=0,status_report_problem_pay2=0;

    String date_new_format_thai,date_new_format_thai2;
    String dateThai_year,dateThai_month,dateThai_day,dateThai_month1;
    int converted_dateThai11;
    private Date oneWayTripDate;


    String date_new_format_thai3;
    String dateThai_year3,dateThai_month3,dateThai_day3;

    String s1,s2,s3,s4,s5,s6;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_check_for_1_3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        VersionOSM = MyApplication.getInstance().getPrefManager().getPreferrence("VersionOS");

        relat_scan= (RelativeLayout) findViewById(R.id.relat_scan);
        txt_scan= (TextView) findViewById(R.id.txt_scan);
        bt_scan= (ImageButton) findViewById(R.id.bt_scan);
        switcher2= (ImageButton) findViewById(R.id.switcher2);


        open_camera= (RelativeLayout) findViewById(R.id.open_camera);
        open_camera2= (RelativeLayout) findViewById(R.id.open_camera2);
        open_camera3= (RelativeLayout) findViewById(R.id.open_camera3);
        open_camera4= (RelativeLayout) findViewById(R.id.open_camera4);
        open_camera5= (RelativeLayout) findViewById(R.id.open_camera5);

        open_image= (RelativeLayout) findViewById(R.id.open_image);
        open_image2= (RelativeLayout) findViewById(R.id.open_image2);
        open_image3= (RelativeLayout) findViewById(R.id.open_image3);
        open_image4= (RelativeLayout) findViewById(R.id.open_image4);
        open_image5= (RelativeLayout) findViewById(R.id.open_image5);

        location= (RelativeLayout) findViewById(R.id.location);

        my_recycler_view1= (RecyclerView) findViewById(R.id.my_recycler_view);
        my_recycler_view2= (RecyclerView) findViewById(R.id.my_recycler_view2);
        my_recycler_view3= (RecyclerView) findViewById(R.id.my_recycler_view3);
        my_recycler_view4= (RecyclerView) findViewById(R.id.my_recycler_view4);
        my_recycler_view5= (RecyclerView) findViewById(R.id.my_recycler_view5);
        my_recycler_view_map= (RecyclerView) findViewById(R.id.my_recycler_view_map);
        linear_pen= (LinearLayout) findViewById(R.id.linear_pen);

        spDemo= (Spinner) findViewById(R.id.spDemo);
        spDemo1= (Spinner) findViewById(R.id.spDemo1);
        spDemo2= (Spinner) findViewById(R.id.spDemo2);
        spDemo3= (Spinner) findViewById(R.id.spDemo3);
        spDemo4= (Spinner) findViewById(R.id.spDemo4);

        RadioButton_0= (RadioButton) findViewById(R.id.RadioButton);
        RadioButton_1= (RadioButton) findViewById(R.id.RadioButton1);
        RadioButton_2= (RadioButton) findViewById(R.id.RadioButton2);
        RadioButton_2= (RadioButton) findViewById(R.id.RadioButton3);
        CheckBox0= (CheckBox) findViewById(R.id.CheckBox);
        RadioButton_5= (RadioButton) findViewById(R.id.RadioButton5);
        RadioButton_6= (RadioButton) findViewById(R.id.RadioButton6);

        radioSexGroup = (RadioGroup) findViewById(R.id.radioSex);
        radioSexGroup1 = (RadioGroup) findViewById(R.id.radioSex1);
        radioSexGroup2 = (RadioGroup) findViewById(R.id.radioSex2);


        new_message= (EditText) findViewById(R.id.new_message);
        new_message1= (EditText) findViewById(R.id.new_message1);
        new_message2= (EditText) findViewById(R.id.new_message2);
        new_message3= (EditText) findViewById(R.id.new_message3);

        new_message_home_in= (EditText) findViewById(R.id.new_message_home_in);
        new_message_scan= (EditText) findViewById(R.id.new_message_scan);
        new_message_install= (EditText) findViewById(R.id.new_message_install);

        new_message_pay2= (EditText) findViewById(R.id.new_message_pay2);
        //new_message4= (EditText) findViewById(R.id.new_message4);

        r_save= (RelativeLayout) findViewById(R.id.r_save);
        r_save2= (RelativeLayout) findViewById(R.id.r_save2);

        image_tal2= (ImageView) findViewById(R.id.image_tal2);
        image_tal3= (ImageView) findViewById(R.id.image_tal3);
        image_clear= (ImageView) findViewById(R.id.image_clear);
        image_pen_sing= (ImageView) findViewById(R.id.image_pen_sing);
        date1= (TextView) findViewById(R.id.date1);
        date2= (TextView) findViewById(R.id.date2);

        txt_day_nad2= (TextView) findViewById(R.id.txt_day_nad2);
        txt_Outstanding= (TextView) findViewById(R.id.Outstanding);
        txt_PayLastPeriod= (TextView) findViewById(R.id.PayLastPeriod);

        li1= (LinearLayout) findViewById(R.id.li1);
        li2= (LinearLayout) findViewById(R.id.li2);
        li3= (LinearLayout) findViewById(R.id.li3);
        li4= (LinearLayout) findViewById(R.id.li4);
        li5= (LinearLayout) findViewById(R.id.li5);
        li6= (LinearLayout) findViewById(R.id.li6);
        li7= (LinearLayout) findViewById(R.id.li7);
        li_qr1= (LinearLayout) findViewById(R.id.li_qr1);
        li_pay2= (LinearLayout) findViewById(R.id.li_pay2);
        li_pay2_2= (LinearLayout) findViewById(R.id.li_pay2_2);

        allSampleData1 = new ArrayList<SectionDataModel_checker1>();
        allSampleData2 = new ArrayList<SectionDataModel_checker2>();
        allSampleData3 = new ArrayList<SectionDataModel_checker3>();
        allSampleData4 = new ArrayList<SectionDataModel_checker4>();
        allSampleData5 = new ArrayList<SectionDataModel_checker5>();
        allSampleData_map = new ArrayList<SectionDataModel_checker_map>();

        singleItem1 = new ArrayList<SingleItemModel_checker1>();
        singleItem2 = new ArrayList<SingleItemModel_checker2>();
        singleItem3 = new ArrayList<SingleItemModel_checker3>();
        singleItem4 = new ArrayList<SingleItemModel_checker4>();
        singleItem5 = new ArrayList<SingleItemModel_checker5>();
        singleItem_map = new ArrayList<SingleItemModel_checker_map>();

        getData_uploade_images = new ArrayList<>();
        //getData_image_more_for_delates= new ArrayList<GetData_cedit_dialog_image_problem_from_id>();

        getData_image_more_for_delates_checker1= new ArrayList<GetData_cedit_dialog_image_problem_from_id_checker1>();
        getData_image_more_for_delates_checker2= new ArrayList<GetData_cedit_dialog_image_problem_from_id_checker2>();
        getData_image_more_for_delates_checker3= new ArrayList<GetData_cedit_dialog_image_problem_from_id_checker3>();
        getData_image_more_for_delates_checker4= new ArrayList<GetData_cedit_dialog_image_problem_from_id_checker4>();
        getData_image_more_for_delates_checker5= new ArrayList<GetData_cedit_dialog_image_problem_from_id_checker5>();
        getData_image_more_for_delates_checker_map= new ArrayList<GetData_cedit_dialog_image_problem_from_id_checker_map>();
        getData_image_news= new ArrayList<>();
        getData_select_home_in=new ArrayList<>();
        getData_select_map_makers=new ArrayList<>();
        getData_select_checker_whos=new ArrayList<>();
        getData_select_installs=new ArrayList<>();



        bt_scan.setOnClickListener(this);
        switcher2.setOnClickListener(this);
        open_camera.setOnClickListener(this);
        open_image.setOnClickListener(this);
        open_camera2.setOnClickListener(this);
        open_image2.setOnClickListener(this);
        open_camera3.setOnClickListener(this);
        open_image3.setOnClickListener(this);
        open_camera4.setOnClickListener(this);
        open_image4.setOnClickListener(this);
        open_camera5.setOnClickListener(this);
        open_image5.setOnClickListener(this);
        location.setOnClickListener(this);
        r_save.setOnClickListener(this);
        r_save2.setOnClickListener(this);
        linear_pen.setOnClickListener(this);
        image_tal2.setOnClickListener(this);
        image_tal3.setOnClickListener(this);
        image_clear.setOnClickListener(this);
        PackageManager m = this.getPackageManager();
        PATH = this.getPackageName();
        try {
            PackageInfo p = m.getPackageInfo(PATH, 0);
            PATH = p.applicationInfo.dataDir;
            Log.e("app path", PATH);
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("yourtag", "Error Package name not found ", e);
        }

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String date = df.format(Calendar.getInstance().getTime());
        date1.setText(date);
        date2.setText(date);
        date_s=date;
        date2_s=date;

        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
         date22 = df2.format(Calendar.getInstance().getTime());
        date3_s=date22;
        my_recycler_view1.setHasFixedSize(true);
        RecyclerViewDataAdapter_image1 adapter = new RecyclerViewDataAdapter_image1(this, allSampleData1);
        my_recycler_view1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        my_recycler_view1.setAdapter(adapter);

        my_recycler_view2.setHasFixedSize(true);
        RecyclerViewDataAdapter_image2 adapter2 = new RecyclerViewDataAdapter_image2(this, allSampleData2);
        my_recycler_view2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        my_recycler_view2.setAdapter(adapter2);

        my_recycler_view3.setHasFixedSize(true);
        RecyclerViewDataAdapter_image3 adapter3 = new RecyclerViewDataAdapter_image3(this, allSampleData3);
        my_recycler_view3.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        my_recycler_view3.setAdapter(adapter3);

        my_recycler_view4.setHasFixedSize(true);
        RecyclerViewDataAdapter_image4 adapter4 = new RecyclerViewDataAdapter_image4(this, allSampleData4);
        my_recycler_view4.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        my_recycler_view4.setAdapter(adapter4);

        my_recycler_view5.setHasFixedSize(true);
        RecyclerViewDataAdapter_image5 adapter5 = new RecyclerViewDataAdapter_image5(this, allSampleData5);
        my_recycler_view5.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        my_recycler_view5.setAdapter(adapter5);

        my_recycler_view_map.setHasFixedSize(true);
        RecyclerViewDataAdapter_image_map adapter_map = new RecyclerViewDataAdapter_image_map(this, allSampleData_map);
        my_recycler_view_map.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        my_recycler_view_map.setAdapter(adapter_map);

        SQLiteDataBaseBuild1();
        SQLiteTableBuild1_2();
        sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_image_buffer_checker1.TABLE_NAME+"");

        SQLiteDataBaseBuild2();
        SQLiteTableBuild2_2();
        sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_image_buffer_checker2.TABLE_NAME+"");

        SQLiteDataBaseBuild3();
        SQLiteTableBuild3_2();
        sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_image_buffer_checker3.TABLE_NAME+"");

        SQLiteDataBaseBuild4();
        SQLiteTableBuild4_2();
        sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_image_buffer_checker4.TABLE_NAME+"");

        SQLiteDataBaseBuild5();
        SQLiteTableBuild5_2();
        sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_image_buffer_checker5.TABLE_NAME+"");

        SQLiteDataBaseBuild_map();
        SQLiteTableBuild_map_2();
        sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_image_buffer_checker5.TABLE_NAME+"");


        SQLiteDataBaseBuild_pensing();
        SQLiteTableBuild_pensing();
        sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_image_buffer_checker_pensing.TABLE_NAME+"");

/*        SQLiteDataBaseBuild_data_checker_problem_for_report();
        SQLiteTableBuild_data_checker_problem_for_report();
        sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_data_checker_problem_for_report.TABLE_NAME+"");*/

        String new_message_S=new_message.getText().toString();
        String new_message1_S=new_message1.getText().toString();
        String new_message2_S=new_message2.getText().toString();
        String new_message3_S=new_message3.getText().toString();
//        String new_message4_S=new_message4.getText().toString();

/*        int selectedId = radioSexGroup.getCheckedRadioButtonId();
        radioButton1 = (RadioButton) findViewById(selectedId);

        int selectedId2 = radioSexGroup1.getCheckedRadioButtonId();
        radioButton2 = (RadioButton) findViewById(selectedId2);

        int selectedId3 = radioSexGroup2.getCheckedRadioButtonId();
        radioButton3 = (RadioButton) findViewById(selectedId3);*/

        Bundle data=getIntent().getExtras();
        if(data!=null)
        {
            conno=data.getString("conno");
            FnYear=data.getString("FnYear");
            FnMonth=data.getString("FnMonth");
            customer=data.getString("customer");

            Outstanding=data.getString("Outstanding");
            PayLastPeriod=data.getString("PayLastPeriod");

            ProcessTypeID=data.getString("ProcessTypeID");


            txt_Outstanding.setText(MyApplication.getInstance().getPrefManager().getPreferrence("Outstanding_cf"));
            txt_PayLastPeriod.setText(MyApplication.getInstance().getPrefManager().getPreferrence("PayLastPeriod_cf"));

            //Log.e("FnYear",FnYear);
            //Log.e("FnMonth",FnMonth);

        }
/*        String ff =radioButton1.getText().toString();
        String ff2 =radioButton2.getText().toString();*/
//        String ff3 =radioButton3.getText().toString();
        //Log.e("ff3",ff3);



        radioSexGroup.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                    {
                                                        public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                        {
                                                            RadioButton checkedRadio = ( RadioButton ) Detali_check3.this.findViewById ( checkedId );


                                                            checkedText_install  = checkedRadio.getText ( ).toString ( );



                                                        }
                                                    }
        );


        radioSexGroup1.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                    {
                                                        public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                        {
                                                            RadioButton checkedRadio = ( RadioButton ) Detali_check3.this.findViewById ( checkedId );

                                                         //   String checkedText = checkedRadio.getText ( ).toString ( );
                                                            checkedText_pay_one  = checkedRadio.getText ( ).toString ( );


                                                        }
                                                    }
        );



        radioSexGroup2.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                         {
                                             public void onCheckedChanged ( RadioGroup group, int checkedId )
                                             {
                                                 RadioButton checkedRadio = ( RadioButton ) Detali_check3.this.findViewById ( checkedId );

                                                // String checkedText = checkedRadio.getText ( ).toString ( );
                                                 checkedText_confirm  = checkedRadio.getText ( ).toString ( );
                                                 if(checkedText_confirm.equals("ไม่ถูกต้อง")){
                                                     linear_pen.setVisibility(View.GONE);
                                                 }
                                                 else {
                                                     linear_pen.setVisibility(View.VISIBLE);
                                                 }

                                             }
                                         }
        );








        CheckBox0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CheckBox0.isChecked()){
                    Log.e("CheckBox0","1");
                    txt_day_nad2.setVisibility(View.VISIBLE);
                    li_pay2.setVisibility(View.VISIBLE);
                    li_pay2_2.setVisibility(View.VISIBLE);
                    CheckBox_status=1;




                    try {

                        SimpleDateFormat input22 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        SimpleDateFormat output22 = new SimpleDateFormat("yyyy-MM-dd");
                        SimpleDateFormat output33 = new SimpleDateFormat("HH:mm:ss");
                        try {
                            oneWayTripDate = input22.parse(date);  // parse input

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }


                        date_new_format_thai=output22.format(oneWayTripDate);
                        date_new_format_thai2=output33.format(oneWayTripDate);

                        Log.e("date_new_format_thai",date_new_format_thai);


                        if(date_new_format_thai.indexOf(date_new_format_thai) != -1) {
                            String arr2[] = date_new_format_thai.split("-");
                            dateThai_year=arr2[0];
                            dateThai_month=arr2[1];
                            dateThai_day=arr2[2];

                        }
                    }
                    catch (Exception ex){

                    }

                    try {

                        SimpleDateFormat input22 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        SimpleDateFormat output22 = new SimpleDateFormat("yyyy-MM-dd");
                        SimpleDateFormat output33 = new SimpleDateFormat("HH:mm:ss");
                        try {
                            oneWayTripDate = input22.parse(date2_s);  // parse input

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }


                        date_new_format_thai3=output22.format(oneWayTripDate);



                        if(date_new_format_thai3.indexOf(date_new_format_thai3) != -1) {
                            String arr2[] = date_new_format_thai3.split("-");
                            dateThai_year3=arr2[0];
                            dateThai_month3=arr2[1];
                            dateThai_day3=arr2[2];

                        }
                    }
                    catch (Exception ex){

                    }

                  int d1,m1,y1,d2,m2,y2;




                    String dateBeforeString =date22;
                    String dateAfterString = date3_s;

                    Log.e("dateBeforeString",dateBeforeString+dateAfterString);

                    //Parsing the date
                    LocalDate dateBefore = null;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        dateBefore = LocalDate.parse(dateBeforeString);
                    }
                    LocalDate dateAfter = null;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        dateAfter = LocalDate.parse(dateAfterString);
                    }


                    //calculating number of days in between

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
                        Log.e("noOfDaysBetween", String.valueOf(noOfDaysBetween));
                    }

                    getCountOfDays(dateBeforeString,dateAfterString);






                }
                else {
                    Log.e("CheckBox0","0");
                    txt_day_nad2.setVisibility(View.GONE);
                    li_pay2.setVisibility(View.GONE);
                    li_pay2_2.setVisibility(View.GONE);
                    CheckBox_status=0;
                }
            }
        });


        SELECT_DATA_PROBLEM_GORY();
        SELECT_DATA_PROBLEM_GORY1();
        SELECT_DATA_PROBLEM_GORY2();
        SELECT_DATA_PROBLEM_GORY3();







    }

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


    /*Calendar todayCal = Calendar.getInstance();
    int todayYear = todayCal.get(Calendar.YEAR);
    int today = todayCal.get(Calendar.MONTH);
    int todayDay = todayCal.get(Calendar.DAY_OF_MONTH);
    */

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

        float dayCount = (float) diff / (24 * 60 * 60 * 1000);
        Log.e("dayCount", String.valueOf((int) dayCount));

        if((int) dayCount>45){
            txt_day_nad2.setText("เกิน 45 วัน");
            txt_day_nad2.setTextColor(0xffff0000);
            status_report_problem_pay2=1;

            SQLiteDataBaseBuild_data_checker_problem_for_report();
            SQLiteTableBuild_data_checker_problem_for_report();
            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + " (CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID) VALUES('" + conno + "','" + "ปัญหาการ์ดค่างวด" + "','" + "การชำระงวด 2" + "','" + "เกิน 45 วัน" + "','" + new_message_pay2.getText().toString() + "','" + "ตรวจสอบได้ เข้าบ้านลูกค้าได้" + "');";
            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);

        }
        else {
            txt_day_nad2.setText("อีก "+String.valueOf((int) dayCount)+" วัน");
            txt_day_nad2.setTextColor(0xff228b22);
            status_report_problem_pay2=0;
        }



        return ("" + (int) dayCount + " Days");
    }




    int order_image1=0,order_image1_2=0,order_image2=0,order_image2_2=0,order_image3=0,order_image3_2=0,order_image4=0,order_image4_2=0,order_image5=0,order_image5_2=0,order_image_map=0,order_image_map_2=0;
    int check_buttom_remove_image1=0,check_buttom_remove_image2=0,check_buttom_remove_image3=0,check_buttom_remove_image4=0,check_buttom_remove_image5=0,check_buttom_remove_image_map=0;
    public  int size1=0,size2=0,size3=0,size4=0,size5=0,size_map=0;
    String VersionOS="";
    String conno_intro="",conno_scan="",ID_SUB="1";
    int error=0;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 23 ) {
            conno_intro=MyApplication.getInstance().getPrefManager().getPreferrence("conno_intro");
            conno_scan=MyApplication.getInstance().getPrefManager().getPreferrence("conno_scan");

            try {
                if(conno_intro.equals(conno_scan)){
                    switcher2.setImageResource(R.drawable.check_box_report_problem);
                    switcher2.setVisibility(View.VISIBLE);
                    txt_scan.setText("หมายเลขตรงกัน "+conno_intro+":"+conno_scan);
                    txt_scan.setTextColor(0xff66cdaa);
                    error=1;

                    li3.setVisibility(View.GONE);
                    li_qr1.setVisibility(View.GONE);

                     status_report_problem_qr=0;
                    color_error();
                }
                else {
                    switcher2.setImageResource(R.drawable.errorerror);
                    switcher2.setVisibility(View.VISIBLE);
                    txt_scan.setText("หมายเลขไม่ตรงกัน "+conno_intro+":"+conno_scan);
                    txt_scan.setTextColor(0xfff40707);

                    error=0;

                    li3.setVisibility(View.VISIBLE);
                    li_qr1.setVisibility(View.VISIBLE);
                    status_report_problem_qr=1;


                    SQLiteDataBaseBuild_data_checker_problem_for_report();
                    SQLiteTableBuild_data_checker_problem_for_report();
                    String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + " (CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID) VALUES('" + conno + "','" + "ปัญหาการ์ดตรวจสอบ" + "','" + "หมายเลขเครื่องไม่ตรงกัน" + "','" + "ปัญหาการติดตั้ง" + "','" + new_message_scan.getText().toString() + "','" + "ตรวจสอบได้ เข้าบ้านลูกค้าได้" + "');";
                    sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
                    color_error();
                }
            }
            catch (Exception ex){

            }




        } else if (requestCode == 1 ) {
           // if(resultCode==RESULT_OK) {
                allSampleData1.clear();
                //CropImage();





                order_image1=order_image1+1;
                order_image1_2=order_image1_2+1;
                MyApplication.getInstance().getPrefManager().getPreferrence("part_image");
                String FILE="";
                try {
                    VersionOS = MyApplication.getInstance().getPrefManager().getPreferrence("VersionOS");

                    if((VersionOS.equals("6.0"))|(VersionOS.equals("6.0.0"))|(VersionOS.equals("6.0.1"))|(VersionOS.equals("6.1"))|(VersionOS.equals("6.1.0"))|(VersionOS.equals("7.0"))|(VersionOS.equals("7.0.0"))|(VersionOS.equals("7.0.1"))|(VersionOS.equals("7.1"))|(VersionOS.equals("7.1.0"))|(VersionOS.equals("7.1.1"))|(VersionOS.equals("7.1.2"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.0.0"))|(VersionOS.equals("8.1.0"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.1"))|(VersionOS.equals("8.1.1"))){
                        FILE=MyApplication.getInstance().getPrefManager().getPreferrence("part_image")+"/"+MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+".jpg";
                    }
                    else {
                        FILE=file.getAbsolutePath();
                    }
                }
                catch (Exception ex){
                    FILE=file.getAbsolutePath();
                }




                String image_name=MyApplication.getInstance().getPrefManager().getPreferrence("imageName");


                //  Log.e("image_name",image_name);

                String Url="http://app.thiensurat.co.th/assanee/uploads_image_checker/"+image_name+".jpg";
                // Log.e("Url_image_name",Url);

                File file2 = new File(FILE);
                long length = file2.length();
                length = length/1024;
                String number="";
                if(check_buttom_remove_image1==1){
                    number = String.valueOf(2);
                }
                else {
                    number= String.valueOf(1);
                }


                SQLiteDataBaseBuild1();
                SQLiteTableBuild1_2();

                String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker1.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "jpg" + "','" + order_image1 + "');";
                // String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (part_id,part_image,type_image) VALUES('" + id_image_success + "', '" + file.getAbsolutePath() + "', '" + "image_success" + "');";
                sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
















                for (int i = 1; i <=1; i++) {

                    SectionDataModel_checker1 dm = new SectionDataModel_checker1();

                    dm.setHeaderTitle("ล่าสุด ");

                    ArrayList<SingleItemModel_checker1> singleItem = new ArrayList<SingleItemModel_checker1>();





                    if(check_buttom_remove_image1==1){
                        cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper_image_buffer_checker1.TABLE_NAME+""  +" WHERE name_image ="+"'"+"2"+"'"   , null);
                        if (cursor.moveToFirst()) {
                            do {

                                String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_url_image));
                                String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_order_image));
                                Log.e("A", FA);

                                // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                                // String f= String.valueOf(order_image);
                                singleItem.add(new SingleItemModel_checker1("รูป " + f, FA));

                                size1 = singleItem.size();
                                MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                            } while (cursor.moveToNext());
                        }
                        cursor.close();
                    }
                    else {

                        cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker1.TABLE_NAME + "", null);

                        if (cursor.moveToFirst()) {
                            do {

                                String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_url_image));
                                String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_order_image));
                                Log.e("AAAAAAAA", FA);

                                // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                                // String f= String.valueOf(order_image);
                                singleItem.add(new SingleItemModel_checker1("รูป " + f, FA));

                                size1 = singleItem.size();
                                MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                            } while (cursor.moveToNext());
                        }
                        cursor.close();
                    }







                    dm.setAllItemsInSection(singleItem);

                    allSampleData1.add(dm);


                }


                RecyclerViewDataAdapter_image1 adapter = new RecyclerViewDataAdapter_image1(this, allSampleData1);
                my_recycler_view1.setAdapter(adapter);
                adapter.setitemclick_deleteAll3(this);
                if(size1==0){
                    my_recycler_view1.setVisibility(View.GONE);
                }
                else {
                    my_recycler_view1.setVisibility(View.VISIBLE);



                }

            //}

        }
        else if (requestCode == 2 ) {
            // if(resultCode==RESULT_OK) {
            allSampleData2.clear();
            //CropImage();





            order_image2=order_image2+1;
            order_image2_2=order_image2_2+1;
            MyApplication.getInstance().getPrefManager().getPreferrence("part_image");
            String FILE="";
            try {
                VersionOS = MyApplication.getInstance().getPrefManager().getPreferrence("VersionOS");

                if((VersionOS.equals("6.0"))|(VersionOS.equals("6.0.0"))|(VersionOS.equals("6.0.1"))|(VersionOS.equals("6.1"))|(VersionOS.equals("6.1.0"))|(VersionOS.equals("7.0"))|(VersionOS.equals("7.0.0"))|(VersionOS.equals("7.0.1"))|(VersionOS.equals("7.1"))|(VersionOS.equals("7.1.0"))|(VersionOS.equals("7.1.1"))|(VersionOS.equals("7.1.2"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.0.0"))|(VersionOS.equals("8.1.0"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.1"))|(VersionOS.equals("8.1.1"))){
                    FILE=MyApplication.getInstance().getPrefManager().getPreferrence("part_image")+"/"+MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+".jpg";
                }
                else {
                    FILE=file.getAbsolutePath();
                }
            }
            catch (Exception ex){
                FILE=file.getAbsolutePath();
            }




            String image_name=MyApplication.getInstance().getPrefManager().getPreferrence("imageName");


            //  Log.e("image_name",image_name);

            String Url="http://app.thiensurat.co.th/assanee/uploads_image_checker/"+image_name+".jpg";
            // Log.e("Url_image_name",Url);

            File file2 = new File(FILE);
            long length = file2.length();
            length = length/1024;
            String number="";
            if(check_buttom_remove_image2==1){
                number = String.valueOf(2);
            }
            else {
                number= String.valueOf(1);
            }


            SQLiteDataBaseBuild2();
            SQLiteTableBuild2_2();

            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker2.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "jpg" + "','" + order_image2 + "');";
            // String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (part_id,part_image,type_image) VALUES('" + id_image_success + "', '" + file.getAbsolutePath() + "', '" + "image_success" + "');";
            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
















            for (int i = 1; i <=1; i++) {

                SectionDataModel_checker2 dm = new SectionDataModel_checker2();

                dm.setHeaderTitle("ล่าสุด ");

                ArrayList<SingleItemModel_checker2> singleItem = new ArrayList<SingleItemModel_checker2>();





                if(check_buttom_remove_image2==1){
                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper_image_buffer_checker2.TABLE_NAME+""  +" WHERE name_image ="+"'"+"2"+"'"   , null);
                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_order_image));
                            Log.e("A", FA);

                            // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                            // String f= String.valueOf(order_image);
                            singleItem.add(new SingleItemModel_checker2("รูป " + f, FA));

                            size2 = singleItem.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }
                else {

                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker2.TABLE_NAME + "", null);

                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_order_image));
                            Log.e("AAAAAAAA", FA);

                            // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                            // String f= String.valueOf(order_image);
                            singleItem.add(new SingleItemModel_checker2("รูป " + f, FA));

                            size2 = singleItem.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }







                dm.setAllItemsInSection(singleItem);

                allSampleData2.add(dm);


            }


            RecyclerViewDataAdapter_image2 adapter = new RecyclerViewDataAdapter_image2(this, allSampleData2);
            my_recycler_view2.setAdapter(adapter);
            adapter.setitemclick_deleteAll3(this);
            if(size2==0){
                my_recycler_view2.setVisibility(View.GONE);
            }
            else {
                my_recycler_view2.setVisibility(View.VISIBLE);



            }

            //}

        }
        else if (requestCode == 3 ) {
            // if(resultCode==RESULT_OK) {
            allSampleData3.clear();
            //CropImage();





            order_image3=order_image3+1;
            order_image3_2=order_image3_2+1;
            MyApplication.getInstance().getPrefManager().getPreferrence("part_image");
            String FILE="";
            try {
                VersionOS = MyApplication.getInstance().getPrefManager().getPreferrence("VersionOS");

                if((VersionOS.equals("6.0"))|(VersionOS.equals("6.0.0"))|(VersionOS.equals("6.0.1"))|(VersionOS.equals("6.1"))|(VersionOS.equals("6.1.0"))|(VersionOS.equals("7.0"))|(VersionOS.equals("7.0.0"))|(VersionOS.equals("7.0.1"))|(VersionOS.equals("7.1"))|(VersionOS.equals("7.1.0"))|(VersionOS.equals("7.1.1"))|(VersionOS.equals("7.1.2"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.0.0"))|(VersionOS.equals("8.1.0"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.1"))|(VersionOS.equals("8.1.1"))){
                    FILE=MyApplication.getInstance().getPrefManager().getPreferrence("part_image")+"/"+MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+".jpg";
                }
                else {
                    FILE=file.getAbsolutePath();
                }
            }
            catch (Exception ex){
                FILE=file.getAbsolutePath();
            }




            String image_name=MyApplication.getInstance().getPrefManager().getPreferrence("imageName");


            //  Log.e("image_name",image_name);

            String Url="http://app.thiensurat.co.th/assanee/uploads_image_checker/"+image_name+".jpg";
            // Log.e("Url_image_name",Url);

            File file2 = new File(FILE);
            long length = file2.length();
            length = length/1024;
            String number="";
            if(check_buttom_remove_image3==1){
                number = String.valueOf(2);
            }
            else {
                number= String.valueOf(1);
            }


            SQLiteDataBaseBuild3();
            SQLiteTableBuild3_2();

            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker3.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "jpg" + "','" + order_image3 + "');";
            // String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (part_id,part_image,type_image) VALUES('" + id_image_success + "', '" + file.getAbsolutePath() + "', '" + "image_success" + "');";
            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
















            for (int i = 1; i <=1; i++) {

                SectionDataModel_checker3 dm = new SectionDataModel_checker3();

                dm.setHeaderTitle("ล่าสุด ");

                ArrayList<SingleItemModel_checker3> singleItem = new ArrayList<SingleItemModel_checker3>();





                if(check_buttom_remove_image3==1){
                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper_image_buffer_checker3.TABLE_NAME+""  +" WHERE name_image ="+"'"+"2"+"'"   , null);
                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_order_image));
                            Log.e("A", FA);

                            // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                            // String f= String.valueOf(order_image);
                            singleItem.add(new SingleItemModel_checker3("รูป " + f, FA));

                            size3 = singleItem.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }
                else {

                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker3.TABLE_NAME + "", null);

                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_order_image));
                            Log.e("AAAAAAAA", FA);

                            // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                            // String f= String.valueOf(order_image);
                            singleItem.add(new SingleItemModel_checker3("รูป " + f, FA));

                            size3 = singleItem.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }







                dm.setAllItemsInSection(singleItem);

                allSampleData3.add(dm);


            }


            RecyclerViewDataAdapter_image3 adapter = new RecyclerViewDataAdapter_image3(this, allSampleData3);
            my_recycler_view3.setAdapter(adapter);
            adapter.setitemclick_deleteAll3(this);
            if(size3==0){
                my_recycler_view3.setVisibility(View.GONE);
            }
            else {
                my_recycler_view3.setVisibility(View.VISIBLE);


            }

            //}

        }
        else if (requestCode == 4 ) {
            // if(resultCode==RESULT_OK) {
            allSampleData4.clear();
            //CropImage();





            order_image4=order_image4+1;
            order_image4_2=order_image4_2+1;
            MyApplication.getInstance().getPrefManager().getPreferrence("part_image");
            String FILE="";
            try {
                VersionOS = MyApplication.getInstance().getPrefManager().getPreferrence("VersionOS");

                if((VersionOS.equals("6.0"))|(VersionOS.equals("6.0.0"))|(VersionOS.equals("6.0.1"))|(VersionOS.equals("6.1"))|(VersionOS.equals("6.1.0"))|(VersionOS.equals("7.0"))|(VersionOS.equals("7.0.0"))|(VersionOS.equals("7.0.1"))|(VersionOS.equals("7.1"))|(VersionOS.equals("7.1.0"))|(VersionOS.equals("7.1.1"))|(VersionOS.equals("7.1.2"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.0.0"))|(VersionOS.equals("8.1.0"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.1"))|(VersionOS.equals("8.1.1"))){
                    FILE=MyApplication.getInstance().getPrefManager().getPreferrence("part_image")+"/"+MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+".jpg";
                }
                else {
                    FILE=file.getAbsolutePath();
                }
            }
            catch (Exception ex){
                FILE=file.getAbsolutePath();
            }




            String image_name=MyApplication.getInstance().getPrefManager().getPreferrence("imageName");


            //  Log.e("image_name",image_name);

            String Url="http://app.thiensurat.co.th/assanee/uploads_image_checker/"+image_name+".jpg";
            // Log.e("Url_image_name",Url);

            File file2 = new File(FILE);
            long length = file2.length();
            length = length/1024;
            String number="";
            if(check_buttom_remove_image4==1){
                number = String.valueOf(2);
            }
            else {
                number= String.valueOf(1);
            }


            SQLiteDataBaseBuild4();
            SQLiteTableBuild4_2();

            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker4.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "jpg" + "','" + order_image4 + "');";
            // String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (part_id,part_image,type_image) VALUES('" + id_image_success + "', '" + file.getAbsolutePath() + "', '" + "image_success" + "');";
            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
















            for (int i = 1; i <=1; i++) {

                SectionDataModel_checker4 dm = new SectionDataModel_checker4();

                dm.setHeaderTitle("ล่าสุด ");

                ArrayList<SingleItemModel_checker4> singleItem = new ArrayList<SingleItemModel_checker4>();





                if(check_buttom_remove_image4==1){
                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper_image_buffer_checker4.TABLE_NAME+""  +" WHERE name_image ="+"'"+"2"+"'"   , null);
                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_order_image));
                            Log.e("A", FA);

                            // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                            // String f= String.valueOf(order_image);
                            singleItem.add(new SingleItemModel_checker4("รูป " + f, FA));

                            size4 = singleItem.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }
                else {

                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker4.TABLE_NAME + "", null);

                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_order_image));
                            Log.e("AAAAAAAA", FA);

                            // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                            // String f= String.valueOf(order_image);
                            singleItem.add(new SingleItemModel_checker4("รูป " + f, FA));

                            size4 = singleItem.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }







                dm.setAllItemsInSection(singleItem);

                allSampleData4.add(dm);


            }


            RecyclerViewDataAdapter_image4 adapter = new RecyclerViewDataAdapter_image4(this, allSampleData4);
            my_recycler_view4.setAdapter(adapter);
            adapter.setitemclick_deleteAll3(this);
            if(size4==0){
                my_recycler_view4.setVisibility(View.GONE);
            }
            else {
                my_recycler_view4.setVisibility(View.VISIBLE);

                color_error();

            }

            //}

        }
        else if (requestCode == 5 ) {
            // if(resultCode==RESULT_OK) {
            allSampleData5.clear();
            //CropImage();





            order_image5=order_image5+1;
            order_image5_2=order_image5_2+1;
            MyApplication.getInstance().getPrefManager().getPreferrence("part_image");
            String FILE="";
            try {
                VersionOS = MyApplication.getInstance().getPrefManager().getPreferrence("VersionOS");

                if((VersionOS.equals("6.0"))|(VersionOS.equals("6.0.0"))|(VersionOS.equals("6.0.1"))|(VersionOS.equals("6.1"))|(VersionOS.equals("6.1.0"))|(VersionOS.equals("7.0"))|(VersionOS.equals("7.0.0"))|(VersionOS.equals("7.0.1"))|(VersionOS.equals("7.1"))|(VersionOS.equals("7.1.0"))|(VersionOS.equals("7.1.1"))|(VersionOS.equals("7.1.2"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.0.0"))|(VersionOS.equals("8.1.0"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.1"))|(VersionOS.equals("8.1.1"))){
                    FILE=MyApplication.getInstance().getPrefManager().getPreferrence("part_image")+"/"+MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+".jpg";
                }
                else {
                    FILE=file.getAbsolutePath();
                }
            }
            catch (Exception ex){
                FILE=file.getAbsolutePath();
            }




            String image_name=MyApplication.getInstance().getPrefManager().getPreferrence("imageName");


            //  Log.e("image_name",image_name);

            String Url="http://app.thiensurat.co.th/assanee/uploads_image_checker/"+image_name+".jpg";
            // Log.e("Url_image_name",Url);

            File file2 = new File(FILE);
            long length = file2.length();
            length = length/1024;
            String number="";
            if(check_buttom_remove_image5==1){
                number = String.valueOf(2);
            }
            else {
                number= String.valueOf(1);
            }


            SQLiteDataBaseBuild5();
            SQLiteTableBuild5_2();

            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker5.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "jpg" + "','" + order_image5 + "');";
            // String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (part_id,part_image,type_image) VALUES('" + id_image_success + "', '" + file.getAbsolutePath() + "', '" + "image_success" + "');";
            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
















            for (int i = 1; i <=1; i++) {

                SectionDataModel_checker5 dm = new SectionDataModel_checker5();

                dm.setHeaderTitle("ล่าสุด ");

                ArrayList<SingleItemModel_checker5> singleItem = new ArrayList<SingleItemModel_checker5>();





                if(check_buttom_remove_image5==1){
                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper_image_buffer_checker5.TABLE_NAME+""  +" WHERE name_image ="+"'"+"2"+"'"   , null);
                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_order_image));
                            Log.e("A", FA);

                            // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                            // String f= String.valueOf(order_image);
                            singleItem.add(new SingleItemModel_checker5("รูป " + f, FA));

                            size5 = singleItem.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }
                else {

                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker5.TABLE_NAME + "", null);

                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_order_image));
                            Log.e("AAAAAAAA", FA);

                            // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                            // String f= String.valueOf(order_image);
                            singleItem.add(new SingleItemModel_checker5("รูป " + f, FA));

                            size5 = singleItem.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }







                dm.setAllItemsInSection(singleItem);

                allSampleData5.add(dm);


            }


            RecyclerViewDataAdapter_image5 adapter = new RecyclerViewDataAdapter_image5(this, allSampleData5);
            my_recycler_view5.setAdapter(adapter);
            adapter.setitemclick_deleteAll3(this);
            if(size5==0){
                my_recycler_view5.setVisibility(View.GONE);
            }
            else {
                my_recycler_view5.setVisibility(View.VISIBLE);
                color_error();
            }

            //}

        }
        else if (requestCode == 6 ) {
            allSampleData1.clear();




            order_image1=order_image1+1;
            order_image1_2=order_image1_2+1;
            MyApplication.getInstance().getPrefManager().getPreferrence("part_image");
            String FILE="";
            try {
                VersionOS = MyApplication.getInstance().getPrefManager().getPreferrence("VersionOS");

                if((VersionOS.equals("6.0"))|(VersionOS.equals("6.0.0"))|(VersionOS.equals("6.0.1"))|(VersionOS.equals("6.1"))|(VersionOS.equals("6.1.0"))|(VersionOS.equals("7.0"))|(VersionOS.equals("7.0.0"))|(VersionOS.equals("7.0.1"))|(VersionOS.equals("7.1"))|(VersionOS.equals("7.1.0"))|(VersionOS.equals("7.1.1"))|(VersionOS.equals("7.1.2"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.0.0"))|(VersionOS.equals("8.1.0"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.1"))|(VersionOS.equals("8.1.1"))){
                    FILE=MyApplication.getInstance().getPrefManager().getPreferrence("part_image")+"/"+MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+".jpg";
                }
                else {
                    FILE=file.getAbsolutePath();
                }
            }
            catch (Exception ex){
                FILE=file.getAbsolutePath();
            }




            String image_name=MyApplication.getInstance().getPrefManager().getPreferrence("imageName");


            //  Log.e("image_name",image_name);

            String Url="http://app.thiensurat.co.th/assanee/uploads_image_checker/"+image_name+".jpg";
            // Log.e("Url_image_name",Url);

            File file2 = new File(FILE);
            long length = file2.length();
            length = length/1024;

            String number="";
            if(check_buttom_remove_image1==1){
                number= String.valueOf(2);
            }
            else {
                number= String.valueOf(1);
            }

            SQLiteDataBaseBuild1();
            SQLiteTableBuild1_2();

            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker1.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "jpg" + "','" + order_image1 + "');";
            // String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (part_id,part_image,type_image) VALUES('" + id_image_success + "', '" + file.getAbsolutePath() + "', '" + "image_success" + "');";
            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
















            for (int i = 1; i <=1; i++) {

                SectionDataModel_checker1 dm = new SectionDataModel_checker1();

                dm.setHeaderTitle("ล่าสุด ");

                ArrayList<SingleItemModel_checker1> singleItem = new ArrayList<SingleItemModel_checker1>();



                if(check_buttom_remove_image1==1){
                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper_image_buffer_checker1.TABLE_NAME+""  +" WHERE name_image ="+"'"+"2"+"'"   , null);
                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_order_image));
                            Log.e("A", FA);

                            // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                            // String f= String.valueOf(order_image);
                            singleItem.add(new SingleItemModel_checker1("รูป " + f, FA));

                            size1 = singleItem.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }
                else {


                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker1.TABLE_NAME + "", null);

                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_order_image));
                            Log.e("A", FA);

                            // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                            // String f= String.valueOf(order_image);
                            singleItem.add(new SingleItemModel_checker1("รูป " + f, FA));

                            size1 = singleItem.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }

                dm.setAllItemsInSection(singleItem);

                allSampleData1.add(dm);


            }


            RecyclerViewDataAdapter_image1 adapter = new RecyclerViewDataAdapter_image1(this, allSampleData1);
            my_recycler_view1.setAdapter(adapter);
            adapter.setitemclick_deleteAll3(this);
            if(size1==0){
                my_recycler_view1.setVisibility(View.GONE);
            }
            else {
                my_recycler_view1.setVisibility(View.VISIBLE);
            }

        }
        else if (requestCode == 7 ) {

            allSampleData2.clear();



            order_image2=order_image2+1;
            order_image2_2=order_image2_2+1;
            MyApplication.getInstance().getPrefManager().getPreferrence("part_image");
            String FILE="";
            try {
                VersionOS = MyApplication.getInstance().getPrefManager().getPreferrence("VersionOS");

                if((VersionOS.equals("6.0"))|(VersionOS.equals("6.0.0"))|(VersionOS.equals("6.0.1"))|(VersionOS.equals("6.1"))|(VersionOS.equals("6.1.0"))|(VersionOS.equals("7.0"))|(VersionOS.equals("7.0.0"))|(VersionOS.equals("7.0.1"))|(VersionOS.equals("7.1"))|(VersionOS.equals("7.1.0"))|(VersionOS.equals("7.1.1"))|(VersionOS.equals("7.1.2"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.0.0"))|(VersionOS.equals("8.1.0"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.1"))|(VersionOS.equals("8.1.1"))){
                    FILE=MyApplication.getInstance().getPrefManager().getPreferrence("part_image")+"/"+MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+".jpg";
                }
                else {
                    FILE=file.getAbsolutePath();
                }
            }
            catch (Exception ex){
                FILE=file.getAbsolutePath();
            }




            String image_name=MyApplication.getInstance().getPrefManager().getPreferrence("imageName");


            //  Log.e("image_name",image_name);

            String Url="http://app.thiensurat.co.th/assanee/uploads_image_checker/"+image_name+".jpg";
            // Log.e("Url_image_name",Url);

            File file2 = new File(FILE);
            long length = file2.length();
            length = length/1024;

            String number="";
            if(check_buttom_remove_image2==1){
                number= String.valueOf(2);
            }
            else {
                number= String.valueOf(1);
            }

            SQLiteDataBaseBuild2();
            SQLiteTableBuild2_2();

            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker2.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "jpg" + "','" + order_image2 + "');";
            // String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (part_id,part_image,type_image) VALUES('" + id_image_success + "', '" + file.getAbsolutePath() + "', '" + "image_success" + "');";
            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
















            for (int i = 1; i <=1; i++) {

                SectionDataModel_checker2 dm = new SectionDataModel_checker2();

                dm.setHeaderTitle("ล่าสุด ");

                ArrayList<SingleItemModel_checker2> singleItem = new ArrayList<SingleItemModel_checker2>();



                if(check_buttom_remove_image2==1){
                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper_image_buffer_checker2.TABLE_NAME+""  +" WHERE name_image ="+"'"+"2"+"'"   , null);
                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_order_image));
                            Log.e("A", FA);

                            // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                            // String f= String.valueOf(order_image);
                            singleItem.add(new SingleItemModel_checker2("รูป " + f, FA));

                            size2 = singleItem.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }
                else {


                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker2.TABLE_NAME + "", null);

                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_order_image));
                            Log.e("A", FA);

                            // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                            // String f= String.valueOf(order_image);
                            singleItem.add(new SingleItemModel_checker2("รูป " + f, FA));

                            size2 = singleItem.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }

                dm.setAllItemsInSection(singleItem);

                allSampleData2.add(dm);


            }


            RecyclerViewDataAdapter_image2 adapter = new RecyclerViewDataAdapter_image2(this, allSampleData2);
            my_recycler_view2.setAdapter(adapter);
            adapter.setitemclick_deleteAll3(this);
            if(size2==0){
                my_recycler_view2.setVisibility(View.GONE);
            }
            else {
                my_recycler_view2.setVisibility(View.VISIBLE);
            }

        }
        else if (requestCode == 8 ) {

            allSampleData3.clear();



            order_image3=order_image3+1;
            order_image3_2=order_image3_2+1;
            MyApplication.getInstance().getPrefManager().getPreferrence("part_image");
            String FILE="";
            try {
                VersionOS = MyApplication.getInstance().getPrefManager().getPreferrence("VersionOS");

                if((VersionOS.equals("6.0"))|(VersionOS.equals("6.0.0"))|(VersionOS.equals("6.0.1"))|(VersionOS.equals("6.1"))|(VersionOS.equals("6.1.0"))|(VersionOS.equals("7.0"))|(VersionOS.equals("7.0.0"))|(VersionOS.equals("7.0.1"))|(VersionOS.equals("7.1"))|(VersionOS.equals("7.1.0"))|(VersionOS.equals("7.1.1"))|(VersionOS.equals("7.1.2"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.0.0"))|(VersionOS.equals("8.1.0"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.1"))|(VersionOS.equals("8.1.1"))){
                    FILE=MyApplication.getInstance().getPrefManager().getPreferrence("part_image")+"/"+MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+".jpg";
                }
                else {
                    FILE=file.getAbsolutePath();
                }
            }
            catch (Exception ex){
                FILE=file.getAbsolutePath();
            }




            String image_name=MyApplication.getInstance().getPrefManager().getPreferrence("imageName");


            //  Log.e("image_name",image_name);

            String Url="http://app.thiensurat.co.th/assanee/uploads_image_checker/"+image_name+".jpg";
            // Log.e("Url_image_name",Url);

            File file2 = new File(FILE);
            long length = file2.length();
            length = length/1024;

            String number="";
            if(check_buttom_remove_image3==1){
                number= String.valueOf(2);
            }
            else {
                number= String.valueOf(1);
            }

            SQLiteDataBaseBuild3();
            SQLiteTableBuild3_2();

            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker3.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "jpg" + "','" + order_image3 + "');";
            // String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (part_id,part_image,type_image) VALUES('" + id_image_success + "', '" + file.getAbsolutePath() + "', '" + "image_success" + "');";
            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
















            for (int i = 1; i <=1; i++) {

                SectionDataModel_checker3 dm = new SectionDataModel_checker3();

                dm.setHeaderTitle("ล่าสุด ");

                ArrayList<SingleItemModel_checker3> singleItem = new ArrayList<SingleItemModel_checker3>();



                if(check_buttom_remove_image3==1){
                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper_image_buffer_checker3.TABLE_NAME+""  +" WHERE name_image ="+"'"+"2"+"'"   , null);
                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_order_image));
                            Log.e("A", FA);

                            // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                            // String f= String.valueOf(order_image);
                            singleItem.add(new SingleItemModel_checker3("รูป " + f, FA));

                            size3 = singleItem.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }
                else {


                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker3.TABLE_NAME + "", null);

                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_order_image));
                            Log.e("A", FA);

                            // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                            // String f= String.valueOf(order_image);
                            singleItem.add(new SingleItemModel_checker3("รูป " + f, FA));

                            size3 = singleItem.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }

                dm.setAllItemsInSection(singleItem);

                allSampleData3.add(dm);


            }


            RecyclerViewDataAdapter_image3 adapter = new RecyclerViewDataAdapter_image3(this, allSampleData3);
            my_recycler_view3.setAdapter(adapter);
            adapter.setitemclick_deleteAll3(this);
            if(size3==0){
                my_recycler_view3.setVisibility(View.GONE);
            }
            else {
                my_recycler_view3.setVisibility(View.VISIBLE);
            }

        }
        else if (requestCode == 9 ) {

            allSampleData4.clear();



            order_image4=order_image4+1;
            order_image4_2=order_image4_2+1;
            MyApplication.getInstance().getPrefManager().getPreferrence("part_image");
            String FILE="";
            try {
                VersionOS = MyApplication.getInstance().getPrefManager().getPreferrence("VersionOS");

                if((VersionOS.equals("6.0"))|(VersionOS.equals("6.0.0"))|(VersionOS.equals("6.0.1"))|(VersionOS.equals("6.1"))|(VersionOS.equals("6.1.0"))|(VersionOS.equals("7.0"))|(VersionOS.equals("7.0.0"))|(VersionOS.equals("7.0.1"))|(VersionOS.equals("7.1"))|(VersionOS.equals("7.1.0"))|(VersionOS.equals("7.1.1"))|(VersionOS.equals("7.1.2"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.0.0"))|(VersionOS.equals("8.1.0"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.1"))|(VersionOS.equals("8.1.1"))){
                    FILE=MyApplication.getInstance().getPrefManager().getPreferrence("part_image")+"/"+MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+".jpg";
                }
                else {
                    FILE=file.getAbsolutePath();
                }
            }
            catch (Exception ex){
                FILE=file.getAbsolutePath();
            }




            String image_name=MyApplication.getInstance().getPrefManager().getPreferrence("imageName");


            //  Log.e("image_name",image_name);

            String Url="http://app.thiensurat.co.th/assanee/uploads_image_checker/"+image_name+".jpg";
            // Log.e("Url_image_name",Url);

            File file2 = new File(FILE);
            long length = file2.length();
            length = length/1024;

            String number="";
            if(check_buttom_remove_image4==1){
                number= String.valueOf(2);
            }
            else {
                number= String.valueOf(1);
            }

            SQLiteDataBaseBuild4();
            SQLiteTableBuild4_2();

            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker4.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "jpg" + "','" + order_image4 + "');";
            // String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (part_id,part_image,type_image) VALUES('" + id_image_success + "', '" + file.getAbsolutePath() + "', '" + "image_success" + "');";
            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
















            for (int i = 1; i <=1; i++) {

                SectionDataModel_checker4 dm = new SectionDataModel_checker4();

                dm.setHeaderTitle("ล่าสุด ");

                ArrayList<SingleItemModel_checker4> singleItem = new ArrayList<SingleItemModel_checker4>();



                if(check_buttom_remove_image4==1){
                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper_image_buffer_checker4.TABLE_NAME+""  +" WHERE name_image ="+"'"+"2"+"'"   , null);
                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_order_image));
                            Log.e("A", FA);

                            // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                            // String f= String.valueOf(order_image);
                            singleItem.add(new SingleItemModel_checker4("รูป " + f, FA));

                            size4 = singleItem.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }
                else {


                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker4.TABLE_NAME + "", null);

                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_order_image));
                            Log.e("A", FA);

                            // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                            // String f= String.valueOf(order_image);
                            singleItem.add(new SingleItemModel_checker4("รูป " + f, FA));

                            size4 = singleItem.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }

                dm.setAllItemsInSection(singleItem);

                allSampleData4.add(dm);


            }


            RecyclerViewDataAdapter_image4 adapter = new RecyclerViewDataAdapter_image4(this, allSampleData4);
            my_recycler_view4.setAdapter(adapter);
            adapter.setitemclick_deleteAll3(this);
            if(size4==0){
                my_recycler_view4.setVisibility(View.GONE);
            }
            else {
                my_recycler_view4.setVisibility(View.VISIBLE);
            }

        }
        else if (requestCode == 10 ) {
            allSampleData5.clear();




            order_image5=order_image5+1;
            order_image5_2=order_image5_2+1;
            MyApplication.getInstance().getPrefManager().getPreferrence("part_image");
            String FILE="";
            try {
                VersionOS = MyApplication.getInstance().getPrefManager().getPreferrence("VersionOS");

                if((VersionOS.equals("6.0"))|(VersionOS.equals("6.0.0"))|(VersionOS.equals("6.0.1"))|(VersionOS.equals("6.1"))|(VersionOS.equals("6.1.0"))|(VersionOS.equals("7.0"))|(VersionOS.equals("7.0.0"))|(VersionOS.equals("7.0.1"))|(VersionOS.equals("7.1"))|(VersionOS.equals("7.1.0"))|(VersionOS.equals("7.1.1"))|(VersionOS.equals("7.1.2"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.0.0"))|(VersionOS.equals("8.1.0"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.1"))|(VersionOS.equals("8.1.1"))){
                    FILE=MyApplication.getInstance().getPrefManager().getPreferrence("part_image")+"/"+MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+".jpg";
                }
                else {
                    FILE=file.getAbsolutePath();
                }
            }
            catch (Exception ex){
                FILE=file.getAbsolutePath();
            }




            String image_name=MyApplication.getInstance().getPrefManager().getPreferrence("imageName");


            //  Log.e("image_name",image_name);

            String Url="http://app.thiensurat.co.th/assanee/uploads_image_checker/"+image_name+".jpg";
            // Log.e("Url_image_name",Url);

            File file2 = new File(FILE);
            long length = file2.length();
            length = length/1024;

            String number="";
            if(check_buttom_remove_image5==1){
                number= String.valueOf(2);
            }
            else {
                number= String.valueOf(1);
            }

            SQLiteDataBaseBuild5();
            SQLiteTableBuild5_2();

            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker5.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "jpg" + "','" + order_image5 + "');";
            // String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (part_id,part_image,type_image) VALUES('" + id_image_success + "', '" + file.getAbsolutePath() + "', '" + "image_success" + "');";
            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
















            for (int i = 1; i <=1; i++) {

                SectionDataModel_checker5 dm = new SectionDataModel_checker5();

                dm.setHeaderTitle("ล่าสุด ");

                ArrayList<SingleItemModel_checker5> singleItem = new ArrayList<SingleItemModel_checker5>();



                if(check_buttom_remove_image5==1){
                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper_image_buffer_checker5.TABLE_NAME+""  +" WHERE name_image ="+"'"+"2"+"'"   , null);
                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_order_image));
                            Log.e("A", FA);

                            // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                            // String f= String.valueOf(order_image);
                            singleItem.add(new SingleItemModel_checker5("รูป " + f, FA));

                            size5 = singleItem.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }
                else {


                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker5.TABLE_NAME + "", null);

                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_order_image));
                            Log.e("A", FA);

                            // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                            // String f= String.valueOf(order_image);
                            singleItem.add(new SingleItemModel_checker5("รูป " + f, FA));

                            size5 = singleItem.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }

                dm.setAllItemsInSection(singleItem);

                allSampleData5.add(dm);


            }


            RecyclerViewDataAdapter_image5 adapter = new RecyclerViewDataAdapter_image5(this, allSampleData5);
            my_recycler_view5.setAdapter(adapter);
            adapter.setitemclick_deleteAll3(this);
            if(size5==0){
                my_recycler_view5.setVisibility(View.GONE);
            }
            else {
                my_recycler_view5.setVisibility(View.VISIBLE);
            }

        }

        else if(requestCode == 11 ){
            // if(resultCode==RESULT_OK) {
            allSampleData_map.clear();
            //CropImage();





            order_image_map=order_image_map+1;
            order_image_map_2=order_image_map_2+1;







 MyApplication.getInstance().getPrefManager().getPreferrence("part_image");
            String FILE="";
            try {
                VersionOS = MyApplication.getInstance().getPrefManager().getPreferrence("VersionOS");

                if((VersionOS.equals("6.0"))|(VersionOS.equals("6.0.0"))|(VersionOS.equals("6.0.1"))|(VersionOS.equals("6.1"))|(VersionOS.equals("6.1.0"))|(VersionOS.equals("7.0"))|(VersionOS.equals("7.0.0"))|(VersionOS.equals("7.0.1"))|(VersionOS.equals("7.1"))|(VersionOS.equals("7.1.0"))|(VersionOS.equals("7.1.1"))|(VersionOS.equals("7.1.2"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.0.0"))|(VersionOS.equals("8.1.0"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.1"))|(VersionOS.equals("8.1.1"))){
                    FILE=MyApplication.getInstance().getPrefManager().getPreferrence("part_image")+"/"+MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+".jpg";
                }
                else {
                    FILE=imageFile.getAbsolutePath();
                }
            }
            catch (Exception ex){
                FILE=imageFile.getAbsolutePath();
            }




            String image_name=MyApplication.getInstance().getPrefManager().getPreferrence("imageName");
            String Url="http://app.thiensurat.co.th/assanee/uploads_image_checker/"+image_name+".jpg";
            File file2 = new File(FILE);
            long length = file2.length();
            length = length/1024;
            String number="";
            if(check_buttom_remove_image_map==1){
                number = String.valueOf(2);
            }
            else {
                number= String.valueOf(1);
            }


            SQLiteDataBaseBuild_map();
            SQLiteTableBuild_map_2();

            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker_map.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "jpg" + "','" + order_image_map + "');";
            // String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (part_id,part_image,type_image) VALUES('" + id_image_success + "', '" + file.getAbsolutePath() + "', '" + "image_success" + "');";
            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);









            for (int i = 1; i <=1; i++) {

                SectionDataModel_checker_map dm = new SectionDataModel_checker_map();

                dm.setHeaderTitle("ล่าสุด ");

                ArrayList<SingleItemModel_checker_map> singleItem = new ArrayList<>();





                if(check_buttom_remove_image5==1){
                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper_image_buffer_checker_map.TABLE_NAME+""  +" WHERE name_image ="+"'"+"2"+"'"   , null);
                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_order_image));
                            Log.e("A", FA);

                            // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                            // String f= String.valueOf(order_image);
                            singleItem.add(new SingleItemModel_checker_map("รูป " + f, FA));

                            size_map = singleItem.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }
                else {

                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker_map.TABLE_NAME + "", null);

                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_order_image));
                            Log.e("AAAAAAAA", FA);

                            // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                            // String f= String.valueOf(order_image);
                            singleItem.add(new SingleItemModel_checker_map("รูป " + f, FA));

                            size_map = singleItem.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }







                dm.setAllItemsInSection(singleItem);

                allSampleData_map.add(dm);


            }


            RecyclerViewDataAdapter_image_map adapter = new RecyclerViewDataAdapter_image_map(this, allSampleData_map);
            my_recycler_view_map.setAdapter(adapter);
            adapter.setitemclick_deleteAll_map_map(this);
            Log.e("size_map", String.valueOf(size_map));
            if(size_map==0){
                my_recycler_view_map.setVisibility(View.GONE);
            }
            else {
                my_recycler_view_map.setVisibility(View.VISIBLE);
                color_error();
            }

            //}

        }
       else if(requestCode == STORAGE_PERMISSION_CODE){

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
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {

                    }


                })
                .check();
    }


    @Override
    public void onClick(View v) {
           if(v==bt_scan){
               Intent = new Intent(Detali_check3.this, MainActivity_barcode.class);

               startActivityForResult(Intent, 23);
           }
           else if(v==switcher2){
               if(error==0){
                   new SweetAlertDialog(Detali_check3.this, SweetAlertDialog.ERROR_TYPE)

                           .setTitleText("สแกนแล้ว!")
                           .setContentText("หมายเลขไม่ตรงกัน!")
                           .show();
               }
               else {
                   new SweetAlertDialog(Detali_check3.this, SweetAlertDialog.SUCCESS_TYPE)
                           .setTitleText("สแกนแล้ว!")
                           .setContentText("หมายเลขตรงกัน!")
                           .show();
               }
           }
           else if(v==location){
               Intent Intent = new Intent( this, MapsActivity.class);
               startActivityForResult(Intent, 11);
           }
           else if(v==open_camera){
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
                           } else  if((VersionOSM.equals("6.0"))|(VersionOSM.equals("6.0.0"))|(VersionOSM.equals("6.0.1"))|(VersionOSM.equals("6.1"))|(VersionOSM.equals("6.1.0"))|(VersionOSM.equals("7.0"))|(VersionOSM.equals("7.0.0"))|(VersionOSM.equals("7.0.1"))|(VersionOSM.equals("7.1"))|(VersionOSM.equals("7.1.0"))|(VersionOSM.equals("7.1.1"))|(VersionOSM.equals("7.1.2"))|(VersionOSM.equals("8.0"))|(VersionOSM.equals("8.0.0"))|(VersionOSM.equals("8.1.0"))|(VersionOSM.equals("8.0"))|(VersionOSM.equals("8.1"))|(VersionOSM.equals("8.1.1"))) {

                               if (!marshMallowPermission.checkPermissionForCamera()) {
                                   marshMallowPermission.requestPermissionForCamera();


                               } else {
                                   if (!marshMallowPermission.checkPermissionForExternalStorage()) {
                                       marshMallowPermission.requestPermissionForExternalStorage();
                                   } else {

                                       CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                       //CamIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                                       ic = new ImageConfiguration(this, PATH);
                                       file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                                               "report_problem", "ALL");

                                       fileUri = FileProvider.getUriForFile(this,
                                               BuildConfig.APPLICATION_ID + ".provider",
                                               file);




                                       // fileUri = Uri.fromFile(file);
                                       CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                                       startActivityForResult(CamIntent, 1);


                                       //Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                                       // startActivity(intent);


                                   }
                               }
                           }


                           else {
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
                       } catch (Exception ex) {





                           try {
                               CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                               ic = new ImageConfiguration(this,PATH);
                               file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                                       "report_problem", "ALL");


                               fileUri = FileProvider.getUriForFile(this,
                                       BuildConfig.APPLICATION_ID + ".provider",
                                       file);


                               // fileUri = Uri.fromFile(file);
                               CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

                               try {
                                   startActivityForResult(CamIntent, 1);
                               } catch (Exception e) {

                               }
                           }
                           catch (Exception e){

                           }



                       }


           }
           else if(v==open_camera2){
               checkCameraPermission();



               try {
                   if ((VersionOSM.equals("5.0"))|(VersionOSM.equals("5.0.1"))|(VersionOSM.equals("5.0.2"))|(VersionOSM.equals("5.1.3"))|(VersionOSM.equals("5.1"))|(VersionOSM.equals("5.1.1"))|(VersionOSM.equals("5.1.0"))|(VersionOSM.equals("5.1.2"))) {
                       CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                       ic = new ImageConfiguration(this,PATH);
                       file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                               "report_problem", "ALL");


                       fileUri = Uri.fromFile(file);
                       CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                       startActivityForResult(CamIntent, 2);
                   } else  if((VersionOSM.equals("6.0"))|(VersionOSM.equals("6.0.0"))|(VersionOSM.equals("6.0.1"))|(VersionOSM.equals("6.1"))|(VersionOSM.equals("6.1.0"))|(VersionOSM.equals("7.0"))|(VersionOSM.equals("7.0.0"))|(VersionOSM.equals("7.0.1"))|(VersionOSM.equals("7.1"))|(VersionOSM.equals("7.1.0"))|(VersionOSM.equals("7.1.1"))|(VersionOSM.equals("7.1.2"))|(VersionOSM.equals("8.0"))|(VersionOSM.equals("8.0.0"))|(VersionOSM.equals("8.1.0"))|(VersionOSM.equals("8.0"))|(VersionOSM.equals("8.1"))|(VersionOSM.equals("8.1.1"))) {

                       if (!marshMallowPermission.checkPermissionForCamera()) {
                           marshMallowPermission.requestPermissionForCamera();


                       } else {
                           if (!marshMallowPermission.checkPermissionForExternalStorage()) {
                               marshMallowPermission.requestPermissionForExternalStorage();
                           } else {

                               CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               //CamIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                               ic = new ImageConfiguration(this, PATH);
                               file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                                       "report_problem", "ALL");

                               fileUri = FileProvider.getUriForFile(this,
                                       BuildConfig.APPLICATION_ID + ".provider",
                                       file);
                               // fileUri = Uri.fromFile(file);
                               CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                               startActivityForResult(CamIntent, 2);


                               //Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                               // startActivity(intent);


                           }
                       }
                   }


                   else {
                       CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                       ic = new ImageConfiguration(this,PATH);
                       file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                               "report_problem", "ALL");

                       fileUri = FileProvider.getUriForFile(this,
                               BuildConfig.APPLICATION_ID + ".provider",
                               file);
                       // fileUri = Uri.fromFile(file);
                       CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                       startActivityForResult(CamIntent, 2);
                   }
               } catch (Exception ex) {





                   try {
                       CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                       ic = new ImageConfiguration(this,PATH);
                       file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                               "report_problem", "ALL");


                       fileUri = FileProvider.getUriForFile(this,
                               BuildConfig.APPLICATION_ID + ".provider",
                               file);


                       // fileUri = Uri.fromFile(file);
                       CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

                       try {
                           startActivityForResult(CamIntent, 2);
                       } catch (Exception e) {

                       }
                   }
                   catch (Exception e){

                   }



               }


           }
           else if(v==open_camera3){
               checkCameraPermission();



               try {
                   if ((VersionOSM.equals("5.0"))|(VersionOSM.equals("5.0.1"))|(VersionOSM.equals("5.0.2"))|(VersionOSM.equals("5.1.3"))|(VersionOSM.equals("5.1"))|(VersionOSM.equals("5.1.1"))|(VersionOSM.equals("5.1.0"))|(VersionOSM.equals("5.1.2"))) {
                       CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                       ic = new ImageConfiguration(this,PATH);
                       file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                               "report_problem", "ALL");


                       fileUri = Uri.fromFile(file);
                       CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                       startActivityForResult(CamIntent, 3);
                   } else  if((VersionOSM.equals("6.0"))|(VersionOSM.equals("6.0.0"))|(VersionOSM.equals("6.0.1"))|(VersionOSM.equals("6.1"))|(VersionOSM.equals("6.1.0"))|(VersionOSM.equals("7.0"))|(VersionOSM.equals("7.0.0"))|(VersionOSM.equals("7.0.1"))|(VersionOSM.equals("7.1"))|(VersionOSM.equals("7.1.0"))|(VersionOSM.equals("7.1.1"))|(VersionOSM.equals("7.1.2"))|(VersionOSM.equals("8.0"))|(VersionOSM.equals("8.0.0"))|(VersionOSM.equals("8.1.0"))|(VersionOSM.equals("8.0"))|(VersionOSM.equals("8.1"))|(VersionOSM.equals("8.1.1"))) {

                       if (!marshMallowPermission.checkPermissionForCamera()) {
                           marshMallowPermission.requestPermissionForCamera();


                       } else {
                           if (!marshMallowPermission.checkPermissionForExternalStorage()) {
                               marshMallowPermission.requestPermissionForExternalStorage();
                           } else {

                               CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               //CamIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                               ic = new ImageConfiguration(this, PATH);
                               file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                                       "report_problem", "ALL");

                               fileUri = FileProvider.getUriForFile(this,
                                       BuildConfig.APPLICATION_ID + ".provider",
                                       file);
                               // fileUri = Uri.fromFile(file);
                               CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                               startActivityForResult(CamIntent, 3);


                               //Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                               // startActivity(intent);


                           }
                       }
                   }


                   else {
                       CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                       ic = new ImageConfiguration(this,PATH);
                       file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                               "report_problem", "ALL");

                       fileUri = FileProvider.getUriForFile(this,
                               BuildConfig.APPLICATION_ID + ".provider",
                               file);
                       // fileUri = Uri.fromFile(file);
                       CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                       startActivityForResult(CamIntent, 3);
                   }
               } catch (Exception ex) {





                   try {
                       CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                       ic = new ImageConfiguration(this,PATH);
                       file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                               "report_problem", "ALL");


                       fileUri = FileProvider.getUriForFile(this,
                               BuildConfig.APPLICATION_ID + ".provider",
                               file);


                       // fileUri = Uri.fromFile(file);
                       CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

                       try {
                           startActivityForResult(CamIntent, 3);
                       } catch (Exception e) {

                       }
                   }
                   catch (Exception e){

                   }



               }


           }
           else if(v==open_camera4){
               checkCameraPermission();



               try {
                   if ((VersionOSM.equals("5.0"))|(VersionOSM.equals("5.0.1"))|(VersionOSM.equals("5.0.2"))|(VersionOSM.equals("5.1.3"))|(VersionOSM.equals("5.1"))|(VersionOSM.equals("5.1.1"))|(VersionOSM.equals("5.1.0"))|(VersionOSM.equals("5.1.2"))) {
                       CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                       ic = new ImageConfiguration(this,PATH);
                       file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                               "report_problem", "ALL");


                       fileUri = Uri.fromFile(file);
                       CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                       startActivityForResult(CamIntent, 4);
                   } else  if((VersionOSM.equals("6.0"))|(VersionOSM.equals("6.0.0"))|(VersionOSM.equals("6.0.1"))|(VersionOSM.equals("6.1"))|(VersionOSM.equals("6.1.0"))|(VersionOSM.equals("7.0"))|(VersionOSM.equals("7.0.0"))|(VersionOSM.equals("7.0.1"))|(VersionOSM.equals("7.1"))|(VersionOSM.equals("7.1.0"))|(VersionOSM.equals("7.1.1"))|(VersionOSM.equals("7.1.2"))|(VersionOSM.equals("8.0"))|(VersionOSM.equals("8.0.0"))|(VersionOSM.equals("8.1.0"))|(VersionOSM.equals("8.0"))|(VersionOSM.equals("8.1"))|(VersionOSM.equals("8.1.1"))) {

                       if (!marshMallowPermission.checkPermissionForCamera()) {
                           marshMallowPermission.requestPermissionForCamera();


                       } else {
                           if (!marshMallowPermission.checkPermissionForExternalStorage()) {
                               marshMallowPermission.requestPermissionForExternalStorage();
                           } else {

                               CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               //CamIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                               ic = new ImageConfiguration(this, PATH);
                               file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                                       "report_problem", "ALL");

                               fileUri = FileProvider.getUriForFile(this,
                                       BuildConfig.APPLICATION_ID + ".provider",
                                       file);
                               // fileUri = Uri.fromFile(file);
                               CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                               startActivityForResult(CamIntent, 4);


                               //Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                               // startActivity(intent);


                           }
                       }
                   }


                   else {
                       CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                       ic = new ImageConfiguration(this,PATH);
                       file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                               "report_problem", "ALL");

                       fileUri = FileProvider.getUriForFile(this,
                               BuildConfig.APPLICATION_ID + ".provider",
                               file);
                       // fileUri = Uri.fromFile(file);
                       CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                       startActivityForResult(CamIntent, 4);
                   }
               } catch (Exception ex) {





                   try {
                       CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                       ic = new ImageConfiguration(this,PATH);
                       file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                               "report_problem", "ALL");


                       fileUri = FileProvider.getUriForFile(this,
                               BuildConfig.APPLICATION_ID + ".provider",
                               file);


                       // fileUri = Uri.fromFile(file);
                       CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

                       try {
                           startActivityForResult(CamIntent, 4);
                       } catch (Exception e) {

                       }
                   }
                   catch (Exception e){

                   }



               }


           }
           else if(v==open_camera5){
               checkCameraPermission();



               try {
                   if ((VersionOSM.equals("5.0"))|(VersionOSM.equals("5.0.1"))|(VersionOSM.equals("5.0.2"))|(VersionOSM.equals("5.1.3"))|(VersionOSM.equals("5.1"))|(VersionOSM.equals("5.1.1"))|(VersionOSM.equals("5.1.0"))|(VersionOSM.equals("5.1.2"))) {
                       CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                       ic = new ImageConfiguration(this,PATH);
                       file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                               "report_problem", "ALL");


                       fileUri = Uri.fromFile(file);
                       CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                       startActivityForResult(CamIntent, 5);
                   } else  if((VersionOSM.equals("6.0"))|(VersionOSM.equals("6.0.0"))|(VersionOSM.equals("6.0.1"))|(VersionOSM.equals("6.1"))|(VersionOSM.equals("6.1.0"))|(VersionOSM.equals("7.0"))|(VersionOSM.equals("7.0.0"))|(VersionOSM.equals("7.0.1"))|(VersionOSM.equals("7.1"))|(VersionOSM.equals("7.1.0"))|(VersionOSM.equals("7.1.1"))|(VersionOSM.equals("7.1.2"))|(VersionOSM.equals("8.0"))|(VersionOSM.equals("8.0.0"))|(VersionOSM.equals("8.1.0"))|(VersionOSM.equals("8.0"))|(VersionOSM.equals("8.1"))|(VersionOSM.equals("8.1.1"))) {

                       if (!marshMallowPermission.checkPermissionForCamera()) {
                           marshMallowPermission.requestPermissionForCamera();


                       } else {
                           if (!marshMallowPermission.checkPermissionForExternalStorage()) {
                               marshMallowPermission.requestPermissionForExternalStorage();
                           } else {

                               CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               //CamIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                               ic = new ImageConfiguration(this, PATH);
                               file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                                       "report_problem", "ALL");

                               fileUri = FileProvider.getUriForFile(this,
                                       BuildConfig.APPLICATION_ID + ".provider",
                                       file);
                               // fileUri = Uri.fromFile(file);
                               CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                               startActivityForResult(CamIntent, 5);


                               //Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                               // startActivity(intent);


                           }
                       }
                   }


                   else {
                       CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                       ic = new ImageConfiguration(this,PATH);
                       file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                               "report_problem", "ALL");

                       fileUri = FileProvider.getUriForFile(this,
                               BuildConfig.APPLICATION_ID + ".provider",
                               file);
                       // fileUri = Uri.fromFile(file);
                       CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                       startActivityForResult(CamIntent, 5);
                   }
               } catch (Exception ex) {





                   try {
                       CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                       ic = new ImageConfiguration(this,PATH);
                       file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                               "report_problem", "ALL");


                       fileUri = FileProvider.getUriForFile(this,
                               BuildConfig.APPLICATION_ID + ".provider",
                               file);


                       // fileUri = Uri.fromFile(file);
                       CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

                       try {
                           startActivityForResult(CamIntent, 5);
                       } catch (Exception e) {

                       }
                   }
                   catch (Exception e){

                   }



               }


           }
           else if(v==open_image){
               checkCameraPermission();
               Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
               startActivityForResult(intent, 6);
           }
           else if(v==open_image2){
               checkCameraPermission();
               Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
               startActivityForResult(intent, 7);
           }
           else if(v==open_image3){
               checkCameraPermission();
               Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
               startActivityForResult(intent, 8);
           }
           else if(v==open_image4){
               checkCameraPermission();
               Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
               startActivityForResult(intent, 9);
           }
           else if(v==open_image5){
               checkCameraPermission();
               Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
               startActivityForResult(intent, 10);
           }
           else if(v==r_save){
               String QR_S=txt_scan.getText().toString();

               li1.setBackgroundColor(0xffffffff);
               li2.setBackgroundColor(0xffffffff);
               li3.setBackgroundColor(0xffffffff);
               li4.setBackgroundColor(0xffffffff);
               li5.setBackgroundColor(0xffffffff);
               li6.setBackgroundColor(0xffffffff);
               li7.setBackgroundColor(0xffffffff);

               if((size4==0)&(size_map==0)){   // 1
                   li1.setBackgroundColor(0xffff0000);
                   li2.setBackgroundColor(0xffff0000);

                   sweet_dailog_waining_checker();
               }
               else if((size4==1)&(size_map==0)){
                   // li1.setBackgroundColor(0xffff0000);
                   li2.setBackgroundColor(0xffff0000);

                   sweet_dailog_waining_checker();
               }
               else if((size4==0)&(size_map==1)){
                   li1.setBackgroundColor(0xffff0000);
                   // li2.setBackgroundColor(0xffff0000);


                   sweet_dailog_waining_checker();
               }













               else {


                   SQLiteDataBaseBuild1();
                   SQLiteTableBuild1();


                   cursor = sqLiteDatabase.rawQuery("SELECT *  FROM " + SQLiteHelper_image_buffer_checker1.TABLE_NAME, null);

                   if (cursor.moveToFirst()) {
                       do {
                           GetData_uploade_Image getData_uploade_image = new GetData_uploade_Image();
                           String part_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_url_image));
                           String part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_part_id));

                           String url_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_url_image));
                           String Url = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_Url));
                           String Image_Name = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_Image_Name));
                           String Image_Size = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_Image_Size));
                           String Image_Type = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_Image_Type));
                           String order_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_order_image));
                           // Log.e("oooo", part_image);
                           if (!part_image.equals("null")) {
                               Log.e("part_id1", part_image);
                               getData_uploade_image.setImage(part_image);
                               getData_uploade_image.setPart_id(part_id);

                               getData_uploade_image.setUrl_image1(url_image);
                               getData_uploade_image.setUrl1(Url);
                               getData_uploade_image.setImage_Name1(Image_Name);
                               getData_uploade_image.setImage_Size1(Image_Size);
                               getData_uploade_image.setImage_Type1(Image_Type);
                               getData_uploade_image.setOrder_image1(order_image);

                               getData_uploade_images.add(getData_uploade_image);
                           }


                       } while (cursor.moveToNext());
                   }
                   cursor.close();


                   SQLiteDataBaseBuild2();
                   SQLiteTableBuild2();


                   cursor = sqLiteDatabase.rawQuery("SELECT *  FROM " + SQLiteHelper_image_buffer_checker2.TABLE_NAME, null);

                   if (cursor.moveToFirst()) {
                       do {
                           GetData_uploade_Image getData_uploade_image = new GetData_uploade_Image();
                           String part_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_url_image));
                           String part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_part_id));

                           String url_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_url_image));
                           String Url = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_Url));
                           String Image_Name = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_Image_Name));
                           String Image_Size = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_Image_Size));
                           String Image_Type = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_Image_Type));
                           String order_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_order_image));

                           if (!part_image.equals("null")) {
                               Log.e("part_id2", part_image);
                               getData_uploade_image.setImage(part_image);
                               getData_uploade_image.setPart_id(part_id);

                               getData_uploade_image.setUrl_image2(url_image);
                               getData_uploade_image.setUrl2(Url);
                               getData_uploade_image.setImage_Name2(Image_Name);
                               getData_uploade_image.setImage_Size2(Image_Size);
                               getData_uploade_image.setImage_Type2(Image_Type);
                               getData_uploade_image.setOrder_image2(order_image);

                               getData_uploade_images.add(getData_uploade_image);
                           }


                       } while (cursor.moveToNext());
                   }
                   cursor.close();


                   SQLiteDataBaseBuild3();
                   SQLiteTableBuild3();


                   cursor = sqLiteDatabase.rawQuery("SELECT *  FROM " + SQLiteHelper_image_buffer_checker3.TABLE_NAME, null);

                   if (cursor.moveToFirst()) {
                       do {
                           GetData_uploade_Image getData_uploade_image = new GetData_uploade_Image();
                           String part_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_url_image));
                           String part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_part_id));

                           String url_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_url_image));
                           String Url = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_Url));
                           String Image_Name = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_Image_Name));
                           String Image_Size = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_Image_Size));
                           String Image_Type = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_Image_Type));
                           String order_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_order_image));
                           // Log.e("oooo", part_image);
                           if (!part_image.equals("null")) {
                               Log.e("part_id3", part_image);
                               getData_uploade_image.setImage(part_image);
                               getData_uploade_image.setPart_id(part_id);

                               getData_uploade_image.setUrl_image3(url_image);
                               getData_uploade_image.setUrl3(Url);
                               getData_uploade_image.setImage_Name3(Image_Name);
                               getData_uploade_image.setImage_Size3(Image_Size);
                               getData_uploade_image.setImage_Type3(Image_Type);
                               getData_uploade_image.setOrder_image3(order_image);

                               getData_uploade_images.add(getData_uploade_image);
                           }


                       } while (cursor.moveToNext());
                   }
                   cursor.close();

                   SQLiteDataBaseBuild4();
                   SQLiteTableBuild4();


                   cursor = sqLiteDatabase.rawQuery("SELECT *  FROM " + SQLiteHelper_image_buffer_checker4.TABLE_NAME, null);

                   if (cursor.moveToFirst()) {
                       do {
                           GetData_uploade_Image getData_uploade_image = new GetData_uploade_Image();
                           String part_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_url_image));
                           String part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_part_id));

                           String url_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_url_image));
                           String Url = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_Url));
                           String Image_Name = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_Image_Name));
                           String Image_Size = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_Image_Size));
                           String Image_Type = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_Image_Type));
                           String order_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_order_image));
                           // Log.e("oooo", part_image);
                           if (!part_image.equals("null")) {
                               Log.e("part_id4", part_image);
                               getData_uploade_image.setImage(part_image);
                               getData_uploade_image.setPart_id(part_id);

                               getData_uploade_image.setUrl_image4(url_image);
                               getData_uploade_image.setUrl4(Url);
                               getData_uploade_image.setImage_Name4(Image_Name);
                               getData_uploade_image.setImage_Size4(Image_Size);
                               getData_uploade_image.setImage_Type4(Image_Type);
                               getData_uploade_image.setOrder_image4(order_image);

                               getData_uploade_images.add(getData_uploade_image);
                           }


                       } while (cursor.moveToNext());
                   }
                   cursor.close();

                   SQLiteDataBaseBuild5();
                   SQLiteTableBuild5();


                   cursor = sqLiteDatabase.rawQuery("SELECT *  FROM " + SQLiteHelper_image_buffer_checker5.TABLE_NAME, null);

                   if (cursor.moveToFirst()) {
                       do {
                           GetData_uploade_Image getData_uploade_image = new GetData_uploade_Image();
                           String part_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_url_image));
                           String part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_part_id));

                           String url_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_url_image));
                           String Url = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_Url));
                           String Image_Name = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_Image_Name));
                           String Image_Size = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_Image_Size));
                           String Image_Type = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_Image_Type));
                           String order_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_order_image));
                           // Log.e("oooo", part_image);
                           if (!part_image.equals("null")) {
                               Log.e("part_id5", part_image);
                               getData_uploade_image.setImage(part_image);
                               getData_uploade_image.setPart_id(part_id);

                               getData_uploade_image.setUrl_image5(url_image);
                               getData_uploade_image.setUrl5(Url);
                               getData_uploade_image.setImage_Name5(Image_Name);
                               getData_uploade_image.setImage_Size5(Image_Size);
                               getData_uploade_image.setImage_Type5(Image_Type);
                               getData_uploade_image.setOrder_image5(order_image);

                               getData_uploade_images.add(getData_uploade_image);
                           }


                       } while (cursor.moveToNext());
                   }
                   cursor.close();

                   SQLiteDataBaseBuild_map();
                   SQLiteTableBuild_map();
                   cursor = sqLiteDatabase.rawQuery("SELECT *  FROM " + SQLiteHelper_image_buffer_checker_map.TABLE_NAME, null);

                   if (cursor.moveToFirst()) {
                       do {
                           GetData_uploade_Image getData_uploade_image = new GetData_uploade_Image();
                           String part_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_url_image));
                           String part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_part_id));

                           String url_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_url_image));
                           String Url = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_Url));
                           String Image_Name = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_Image_Name));
                           String Image_Size = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_Image_Size));
                           String Image_Type = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_Image_Type));
                           String order_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_order_image));
                           // Log.e("oooo", part_image);
                           if (!part_image.equals("null")) {
                               Log.e("part_id_map", part_image);
                               getData_uploade_image.setImage(part_image);
                               getData_uploade_image.setPart_id(part_id);

                               getData_uploade_image.setUrl_image6(url_image);
                               getData_uploade_image.setUrl6(Url);
                               getData_uploade_image.setImage_Name6(Image_Name);
                               getData_uploade_image.setImage_Size6(Image_Size);
                               getData_uploade_image.setImage_Type6(Image_Type);
                               getData_uploade_image.setOrder_image6(order_image);

                               getData_uploade_images.add(getData_uploade_image);
                           }


                       } while (cursor.moveToNext());
                   }
                   cursor.close();


                   SQLiteDataBaseBuild_pensing();
                   SQLiteTableBuild_pensing();
                   cursor = sqLiteDatabase.rawQuery("SELECT *  FROM " + SQLiteHelper_image_buffer_checker_pensing.TABLE_NAME, null);

                   if (cursor.moveToFirst()) {
                       do {
                           GetData_uploade_Image getData_uploade_image = new GetData_uploade_Image();
                           String part_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_pensing.Table_url_image));
                           String part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_pensing.Table_part_id));

                           String url_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_pensing.Table_url_image));
                           String Url = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_pensing.Table_Url));
                           String Image_Name = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_pensing.Table_Image_Name));
                           String Image_Size = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_pensing.Table_Image_Size));
                           String Image_Type = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_pensing.Table_Image_Type));
                           String order_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_pensing.Table_order_image));
                           // Log.e("oooo", part_image);
                           if (!part_image.equals("null")) {
                               Log.e("part_id_map", part_image);
                               getData_uploade_image.setImage(part_image);
                               getData_uploade_image.setPart_id(part_id);

                               getData_uploade_image.setUrl_image7(url_image);
                               getData_uploade_image.setUrl7(Url);
                               getData_uploade_image.setImage_Name7(Image_Name);
                               getData_uploade_image.setImage_Size7(Image_Size);
                               getData_uploade_image.setImage_Type7(Image_Type);
                               getData_uploade_image.setOrder_image7(order_image);

                               getData_uploade_images.add(getData_uploade_image);
                           }


                       } while (cursor.moveToNext());
                   }
                   cursor.close();


                   insert_CheckerCard_Master();

                   insert_CheckerCard_Details_home_in();
                   insert_CheckerCard_Details_gps_maker();
                   //insert_CheckerCard_Details_qr_scan();
                  // insert_CheckerCard_Details_install();
                 //  insert_CheckerCard_Details_install_yes_no();
                  // insert_CheckerCard_Details_checker_who();
                  // insert_CheckerCard_Details_customer1();

                   if (CheckBox_status==1){
                    //   insert_CheckerCard_Details_customer2();
                   }


                  // insert_CheckerCard_Details_confrim();


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




                   try {
                       uploadMultiFile();
                   } catch (Exception ex) {

                   }

                   SQLiteDataBaseBuild_data_checker_problem_for_report();
                   SQLiteTableBuild_data_checker_problem_for_report();
                   String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + " (CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID,ProblemID) VALUES('" + conno + "','" + "ปัญหาการ์ดตรวจสอบ" + "','" + "ปัญหาอื่นๆ" + "','" + "ตรวจสอบไม่ได้" + "','" + new_message_scan.getText().toString() + "','" + "ตรวจสอบไม่ได้" + "','" + "62" + "');";
                   sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
               }












           }
           else if(v==r_save2){

           }
           else if(v==linear_pen){
               File dire= new File(Environment.getExternalStorageDirectory(), "/Android/data/com.tsr.tsrproblemreport_tossticket/files/Pictures/image_pen_sing");
               Log.e("dire", String.valueOf(dire));
               new DirectoryCleaner(dire).clean();
               dire.delete();

              final Dialog dialog = new Dialog(this);
               dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
               dialog.setContentView(R.layout.dialog_custom_pen);
               dialog.setCancelable(false);

                  objSignaturePad = (SignaturePad)dialog.findViewById(R.id.objSignaturePad);
               r_save_di= (RelativeLayout)dialog.findViewById(R.id.r_save_di);
               r_save_di2= (RelativeLayout)dialog.findViewById(R.id.r_save_di2);
               ImageView image_cancal= (ImageView)dialog.findViewById(R.id.image_cancal);
               if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                   requestStoragePermission();
               }

               enableDisableButtons(false);
               objSignaturePad.setOnSignedListener(new SignaturePad.OnSignedListener() {
                   @Override
                   public void onStartSigning() {
                       // code to handle the onStartSigning event
                   }

                   @Override
                   public void onSigned() {
                       // code to handle the onSigned event
                       enableDisableButtons(true);
                   }

                   @Override
                   public void onClear() {
                       // code to handle the onClear event
                       enableDisableButtons(false);

                   }
               });
               image_cancal.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       dialog.dismiss();
                   }
               });
               r_save_di.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       //write code for saving the signature as image
                       Bitmap bitmapSignature = objSignaturePad.getSignatureBitmap();
                       // Create image from bitmap and store it in memory
                       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                       bitmapSignature.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
                       Random rand = new Random();
                       int randomValue = rand.nextInt(9999);
                       File file = null;
                       ic = new ImageConfiguration(Detali_check3.this, PATH);
                       file = ic.createImageByType_pen_sing(MyApplication.getInstance().getPrefManager().getPreferrence("conno_cf"),
                               "report_problem", "ALL");


                        //file = new File(Environment.getExternalStorageDirectory().getAbsoluteFile() +
                         //      "/"+String.valueOf(randomValue) + "capturedsignature.jpg");

                    //   File file = new File(    "/sdcard/Android/data/"+getPackageName()+"/files/"+Environment.DIRECTORY_PICTURES + "/" + "image_pen_sing" +  "/"+String.valueOf(randomValue) + "capturedsignature.jpg");

                      // "/sdcard/Android/data/"+context.getPackageName()+"/files/"+Environment.DIRECTORY_PICTURES + "/" + imgdir + "/" + type + "/" + "ID" + ID + "/" + "image_pen_sing" + "/");
                     //  File file = ic.createImageByType_pen_sing("1234",
                         //      "report_problem", "ALL");

                       try {
                           if (file.createNewFile()) {
                               file.createNewFile();
                           }
                           FileOutputStream fileOutputStream = new FileOutputStream(file);
                           fileOutputStream.write(byteArrayOutputStream.toByteArray());
                           fileOutputStream.close();

                           signaturePath = file.getAbsolutePath();
                           Log.e("signaturePath",signaturePath);
                       //   Picasso.with(Detali_check1.this).load(signaturePath).into(image_pen_sing);
                           image_pen_sing.setImageURI(Uri.parse("file://"+signaturePath));
                           image_pen_sing.setVisibility(View.VISIBLE);






                           String image_name=MyApplication.getInstance().getPrefManager().getPreferrence("imageName");
                           String Url="http://app.thiensurat.co.th/assanee/uploads_image_checker/"+image_name+".jpg";

                           long length = file.length();
                           length = length/1024;
                           String number= String.valueOf(1);



                           SQLiteDataBaseBuild_pensing();
                           SQLiteTableBuild_pensing();


                           String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker_pensing.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + number + "','" + file + "','" + Url + "','" + image_name + "','" + length + "','" + "jpg" + "','" + "1" + "');";
                           sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);




                   /*        try {
                               Glide.with(Detali_check1.this).load(signaturePath)



                                         .crossFade()
                                           .thumbnail(0.5f)
                                       // .bitmapTransform(new CircleTransform(context))
                                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                                       // .placeholder(this.getResources().getDrawable(R.drawable.dasaa))
                                       .into(image_pen_sing);
                           }
                           catch (Exception e) {

                           }*/

                       } catch (Exception e) {
                           e.printStackTrace();
                       }
                       dialog.dismiss();
                   }
               });
               r_save_di2.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       objSignaturePad.clear();
                   }
               });
               dialog.show();

               //Intent showFullQuoteIntent = new Intent(Detali_check1.this, SignatureActivity.class);
               //startActivity(showFullQuoteIntent);
              // image_pen_sing.setb

   /*            try {
                   Glide.with(Detali_check1.this).load(signaturePath)



                           .crossFade()
                           .thumbnail(0.5f)
                           // .bitmapTransform(new CircleTransform(context))
                           .diskCacheStrategy(DiskCacheStrategy.ALL)
                           // .placeholder(this.getResources().getDrawable(R.drawable.dasaa))
                           .into(image_pen_sing);
               }
               catch (Exception e) {

               }*/

           }
           else if(v==image_tal2){



                       final Calendar calendar = Calendar.getInstance();
                       int yy = calendar.get(Calendar.YEAR);
                       int mm = calendar.get(Calendar.MONTH);
                       int dd = calendar.get(Calendar.DAY_OF_MONTH);
                       DatePickerDialog datePicker = new DatePickerDialog(Detali_check3.this, new DatePickerDialog.OnDateSetListener() {
                           @Override
                           public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                               date_s = "";
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
                               date_s= dayOfMonth_s+"-"+month_s+"-"+String.valueOf(year);




                               date1.setText(date_s);
                           }


                       }, yy, mm, dd);
                       datePicker.show();



               date1.setVisibility(View.VISIBLE);
               image_clear.setVisibility(View.VISIBLE);
           }
           else if(v==image_tal3){

                       final Calendar calendar = Calendar.getInstance();
                       int yy = calendar.get(Calendar.YEAR);
                       int mm = calendar.get(Calendar.MONTH);
                       int dd = calendar.get(Calendar.DAY_OF_MONTH);
                       DatePickerDialog datePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
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
                               date2.setText(date2_s);


                               String dateBeforeString =date22;
                               String dateAfterString = date3_s;

                               //Parsing the date
                               LocalDate dateBefore = null;
                               if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                   dateBefore = LocalDate.parse(dateBeforeString);
                               }
                               LocalDate dateAfter = null;
                               if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                   dateAfter = LocalDate.parse(dateAfterString);
                               }

                               //calculating number of days in between

                               if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                   noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
                               }
                               Log.e("noOfDaysBetween", String.valueOf(noOfDaysBetween));
                               getCountOfDays(dateBeforeString,dateAfterString);
            /*                   if(noOfDaysBetween>45){
                                   txt_day_nad2.setText("เกิน 45 วัน");
                                   txt_day_nad2.setTextColor(0xffff0000);
                               }
                               else {
                                   txt_day_nad2.setText("อีก "+noOfDaysBetween+" วัน");
                                   txt_day_nad2.setTextColor(0xff228b22);
                               }*/


                           }


                       }, yy, mm, dd);
                       datePicker.show();

           }
           else if(v==image_clear){
               date1.setVisibility(View.GONE);
               image_clear.setVisibility(View.GONE);
           }

    }

    private void sweet_dailog_waining_checker(){
        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("! ข้อมูลยังไม่ครบ")
                .setContentText("กรุณาตรวจสอบข้อมูลก่อน!")
                .setConfirmText("OK!")
                .show();
    }

    private void color_error(){
        String QR_S=txt_scan.getText().toString();
        li1.setBackgroundColor(0xffffffff);
        li2.setBackgroundColor(0xffffffff);
        li3.setBackgroundColor(0xffffffff);
        li4.setBackgroundColor(0xffffffff);
        li5.setBackgroundColor(0xffffffff);
        li6.setBackgroundColor(0xffffffff);
        li7.setBackgroundColor(0xffffffff);

        if((size4==0)&(size_map==0)){   // 1
            li1.setBackgroundColor(0xffff0000);
            li2.setBackgroundColor(0xffff0000);


        }
        else if((size4==1)&(size_map==0)){

            li2.setBackgroundColor(0xffff0000);


        }
        else if((size4==0)&(size_map==1)){
            li1.setBackgroundColor(0xffff0000);

        }
    }

    public void OnClearSignatureClick(View v) {

    }


    public void OnViewSignatureClick(View v) {
        Intent i=new Intent(this,ViewSignatureActivity.class);
        i.putExtra("SignaturePath", signaturePath);
        startActivity(i);
    }
    private void   enableDisableButtons(boolean enableButton)
    {
        r_save_di.setEnabled(enableButton);
        r_save_di2.setEnabled(enableButton);
    }
    //Requesting permission
    private void requestStoragePermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)){
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }

        //And finally ask for the permission
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},STORAGE_PERMISSION_CODE);
    }


    public void SQLiteDataBaseBuild1(){
        sqLiteDatabase = openOrCreateDatabase(SQLiteHelper_image_buffer_checker1.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
    public void SQLiteTableBuild1(){
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_image_buffer_checker1.TABLE_NAME+"("+ SQLiteHelper_image_buffer_checker1.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_image_buffer_checker1.Table_part_id+" VARCHAR, "+SQLiteHelper_image_buffer_checker1.Table_name_image+" VARCHAR, "+SQLiteHelper_image_buffer_checker1.Table_url_image+" VARCHAR, "+SQLiteHelper_image_buffer_checker1.Table_Url+" VARCHAR, "+SQLiteHelper_image_buffer_checker1.Table_Image_Name+" VARCHAR, "+SQLiteHelper_image_buffer_checker1.Table_Image_Size+" VARCHAR, "+SQLiteHelper_image_buffer_checker1.Table_Image_Type+" VARCHAR, "+SQLiteHelper_image_buffer_checker1.Table_order_image+" VARCHAR);");
    }
    public void SQLiteDataBaseBuild1_2(){
        sqLiteDatabase = openOrCreateDatabase(SQLiteHelper_image_buffer_checker1_2.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
    public void SQLiteTableBuild1_2(){
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_image_buffer_checker1_2.TABLE_NAME+"("+ SQLiteHelper_image_buffer_checker1_2.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_image_buffer_checker1_2.Table_part_id+" VARCHAR, "+SQLiteHelper_image_buffer_checker1_2.Table_name_image+" VARCHAR, "+SQLiteHelper_image_buffer_checker1_2.Table_url_image+" VARCHAR, "+SQLiteHelper_image_buffer_checker1_2.Table_Url+" VARCHAR, "+SQLiteHelper_image_buffer_checker1_2.Table_Image_Name+" VARCHAR, "+SQLiteHelper_image_buffer_checker1_2.Table_Image_Size+" VARCHAR, "+SQLiteHelper_image_buffer_checker1_2.Table_Image_Type+" VARCHAR, "+SQLiteHelper_image_buffer_checker1_2.Table_order_image+" VARCHAR);");
    }

    public void SQLiteDataBaseBuild2(){
        sqLiteDatabase = openOrCreateDatabase(SQLiteHelper_image_buffer_checker2.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
    public void SQLiteTableBuild2(){
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_image_buffer_checker2.TABLE_NAME+"("+ SQLiteHelper_image_buffer_checker2.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_image_buffer_checker2.Table_part_id+" VARCHAR, "+SQLiteHelper_image_buffer_checker2.Table_name_image+" VARCHAR, "+SQLiteHelper_image_buffer_checker2.Table_url_image+" VARCHAR, "+SQLiteHelper_image_buffer_checker2.Table_Url+" VARCHAR, "+SQLiteHelper_image_buffer_checker2.Table_Image_Name+" VARCHAR, "+SQLiteHelper_image_buffer_checker2.Table_Image_Size+" VARCHAR, "+SQLiteHelper_image_buffer_checker2.Table_Image_Type+" VARCHAR, "+SQLiteHelper_image_buffer_checker2.Table_order_image+" VARCHAR);");
    }
    public void SQLiteDataBaseBuild2_2(){
        sqLiteDatabase = openOrCreateDatabase(SQLiteHelper_image_buffer_checker2_2.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
    public void SQLiteTableBuild2_2(){
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_image_buffer_checker2_2.TABLE_NAME+"("+ SQLiteHelper_image_buffer_checker2_2.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_image_buffer_checker2_2.Table_part_id+" VARCHAR, "+SQLiteHelper_image_buffer_checker2_2.Table_name_image+" VARCHAR, "+SQLiteHelper_image_buffer_checker2_2.Table_url_image+" VARCHAR, "+SQLiteHelper_image_buffer_checker2_2.Table_Url+" VARCHAR, "+SQLiteHelper_image_buffer_checker2_2.Table_Image_Name+" VARCHAR, "+SQLiteHelper_image_buffer_checker2_2.Table_Image_Size+" VARCHAR, "+SQLiteHelper_image_buffer_checker2_2.Table_Image_Type+" VARCHAR, "+SQLiteHelper_image_buffer_checker2_2.Table_order_image+" VARCHAR);");
    }

    public void SQLiteDataBaseBuild3(){
        sqLiteDatabase = openOrCreateDatabase(SQLiteHelper_image_buffer_checker3.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
    public void SQLiteTableBuild3(){
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_image_buffer_checker3.TABLE_NAME+"("+ SQLiteHelper_image_buffer_checker3.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_image_buffer_checker3.Table_part_id+" VARCHAR, "+SQLiteHelper_image_buffer_checker3.Table_name_image+" VARCHAR, "+SQLiteHelper_image_buffer_checker3.Table_url_image+" VARCHAR, "+SQLiteHelper_image_buffer_checker3.Table_Url+" VARCHAR, "+SQLiteHelper_image_buffer_checker3.Table_Image_Name+" VARCHAR, "+SQLiteHelper_image_buffer_checker3.Table_Image_Size+" VARCHAR, "+SQLiteHelper_image_buffer_checker3.Table_Image_Type+" VARCHAR, "+SQLiteHelper_image_buffer_checker3.Table_order_image+" VARCHAR);");
    }
    public void SQLiteDataBaseBuild3_2(){
        sqLiteDatabase = openOrCreateDatabase(SQLiteHelper_image_buffer_checker3_2.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
    public void SQLiteTableBuild3_2(){
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_image_buffer_checker3_2.TABLE_NAME+"("+ SQLiteHelper_image_buffer_checker3_2.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_image_buffer_checker3_2.Table_part_id+" VARCHAR, "+SQLiteHelper_image_buffer_checker3_2.Table_name_image+" VARCHAR, "+SQLiteHelper_image_buffer_checker3_2.Table_url_image+" VARCHAR, "+SQLiteHelper_image_buffer_checker3_2.Table_Url+" VARCHAR, "+SQLiteHelper_image_buffer_checker3_2.Table_Image_Name+" VARCHAR, "+SQLiteHelper_image_buffer_checker3_2.Table_Image_Size+" VARCHAR, "+SQLiteHelper_image_buffer_checker3_2.Table_Image_Type+" VARCHAR, "+SQLiteHelper_image_buffer_checker3_2.Table_order_image+" VARCHAR);");
    }


    public void SQLiteDataBaseBuild4(){
        sqLiteDatabase = openOrCreateDatabase(SQLiteHelper_image_buffer_checker4.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
    public void SQLiteTableBuild4(){
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_image_buffer_checker4.TABLE_NAME+"("+ SQLiteHelper_image_buffer_checker4.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_image_buffer_checker4.Table_part_id+" VARCHAR, "+SQLiteHelper_image_buffer_checker4.Table_name_image+" VARCHAR, "+SQLiteHelper_image_buffer_checker4.Table_url_image+" VARCHAR, "+SQLiteHelper_image_buffer_checker4.Table_Url+" VARCHAR, "+SQLiteHelper_image_buffer_checker4.Table_Image_Name+" VARCHAR, "+SQLiteHelper_image_buffer_checker4.Table_Image_Size+" VARCHAR, "+SQLiteHelper_image_buffer_checker4.Table_Image_Type+" VARCHAR, "+SQLiteHelper_image_buffer_checker4.Table_order_image+" VARCHAR);");
    }
    public void SQLiteDataBaseBuild4_2(){
        sqLiteDatabase = openOrCreateDatabase(SQLiteHelper_image_buffer_checker4_2.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
    public void SQLiteTableBuild4_2(){
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_image_buffer_checker4_2.TABLE_NAME+"("+ SQLiteHelper_image_buffer_checker4_2.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_image_buffer_checker4_2.Table_part_id+" VARCHAR, "+SQLiteHelper_image_buffer_checker4_2.Table_name_image+" VARCHAR, "+SQLiteHelper_image_buffer_checker4_2.Table_url_image+" VARCHAR, "+SQLiteHelper_image_buffer_checker4_2.Table_Url+" VARCHAR, "+SQLiteHelper_image_buffer_checker4_2.Table_Image_Name+" VARCHAR, "+SQLiteHelper_image_buffer_checker4_2.Table_Image_Size+" VARCHAR, "+SQLiteHelper_image_buffer_checker4_2.Table_Image_Type+" VARCHAR, "+SQLiteHelper_image_buffer_checker4_2.Table_order_image+" VARCHAR);");
    }


    public void SQLiteDataBaseBuild5(){
        sqLiteDatabase = openOrCreateDatabase(SQLiteHelper_image_buffer_checker5.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
    public void SQLiteTableBuild5(){
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_image_buffer_checker5.TABLE_NAME+"("+ SQLiteHelper_image_buffer_checker5.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_image_buffer_checker5.Table_part_id+" VARCHAR, "+SQLiteHelper_image_buffer_checker5.Table_name_image+" VARCHAR, "+SQLiteHelper_image_buffer_checker5.Table_url_image+" VARCHAR, "+SQLiteHelper_image_buffer_checker5.Table_Url+" VARCHAR, "+SQLiteHelper_image_buffer_checker5.Table_Image_Name+" VARCHAR, "+SQLiteHelper_image_buffer_checker5.Table_Image_Size+" VARCHAR, "+SQLiteHelper_image_buffer_checker5.Table_Image_Type+" VARCHAR, "+SQLiteHelper_image_buffer_checker5.Table_order_image+" VARCHAR);");
    }
    public void SQLiteDataBaseBuild5_2(){
        sqLiteDatabase = openOrCreateDatabase(SQLiteHelper_image_buffer_checker5_2.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
    public void SQLiteTableBuild5_2(){
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_image_buffer_checker5_2.TABLE_NAME+"("+ SQLiteHelper_image_buffer_checker5_2.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_image_buffer_checker5_2.Table_part_id+" VARCHAR, "+SQLiteHelper_image_buffer_checker5_2.Table_name_image+" VARCHAR, "+SQLiteHelper_image_buffer_checker5_2.Table_url_image+" VARCHAR, "+SQLiteHelper_image_buffer_checker5_2.Table_Url+" VARCHAR, "+SQLiteHelper_image_buffer_checker5_2.Table_Image_Name+" VARCHAR, "+SQLiteHelper_image_buffer_checker5_2.Table_Image_Size+" VARCHAR, "+SQLiteHelper_image_buffer_checker5_2.Table_Image_Type+" VARCHAR, "+SQLiteHelper_image_buffer_checker5_2.Table_order_image+" VARCHAR);");
    }






    public void SQLiteDataBaseBuild_map(){
        sqLiteDatabase = openOrCreateDatabase(SQLiteHelper_image_buffer_checker_map.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
    public void SQLiteTableBuild_map(){
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_image_buffer_checker_map.TABLE_NAME+"("+ SQLiteHelper_image_buffer_checker_map.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_image_buffer_checker_map.Table_part_id+" VARCHAR, "+SQLiteHelper_image_buffer_checker_map.Table_name_image+" VARCHAR, "+SQLiteHelper_image_buffer_checker_map.Table_url_image+" VARCHAR, "+SQLiteHelper_image_buffer_checker_map.Table_Url+" VARCHAR, "+SQLiteHelper_image_buffer_checker_map.Table_Image_Name+" VARCHAR, "+SQLiteHelper_image_buffer_checker_map.Table_Image_Size+" VARCHAR, "+SQLiteHelper_image_buffer_checker_map.Table_Image_Type+" VARCHAR, "+SQLiteHelper_image_buffer_checker_map.Table_order_image+" VARCHAR);");
    }
    public void SQLiteDataBaseBuild_map_2(){
        sqLiteDatabase = openOrCreateDatabase(SQLiteHelper_image_buffer_checker_map_2.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
    public void SQLiteTableBuild_map_2(){
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_image_buffer_checker_map_2.TABLE_NAME+"("+ SQLiteHelper_image_buffer_checker_map_2.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_image_buffer_checker_map_2.Table_part_id+" VARCHAR, "+SQLiteHelper_image_buffer_checker_map_2.Table_name_image+" VARCHAR, "+SQLiteHelper_image_buffer_checker_map_2.Table_url_image+" VARCHAR, "+SQLiteHelper_image_buffer_checker_map_2.Table_Url+" VARCHAR, "+SQLiteHelper_image_buffer_checker_map_2.Table_Image_Name+" VARCHAR, "+SQLiteHelper_image_buffer_checker_map_2.Table_Image_Size+" VARCHAR, "+SQLiteHelper_image_buffer_checker_map_2.Table_Image_Type+" VARCHAR, "+SQLiteHelper_image_buffer_checker_map_2.Table_order_image+" VARCHAR);");
    }





    public void SQLiteDataBaseBuild_pensing(){
        sqLiteDatabase = openOrCreateDatabase(SQLiteHelper_image_buffer_checker_pensing.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
    public void SQLiteTableBuild_pensing(){
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_image_buffer_checker_pensing.TABLE_NAME+"("+ SQLiteHelper_image_buffer_checker_pensing.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_image_buffer_checker_pensing.Table_part_id+" VARCHAR, "+SQLiteHelper_image_buffer_checker_pensing.Table_name_image+" VARCHAR, "+SQLiteHelper_image_buffer_checker_pensing.Table_url_image+" VARCHAR, "+SQLiteHelper_image_buffer_checker_pensing.Table_Url+" VARCHAR, "+SQLiteHelper_image_buffer_checker_pensing.Table_Image_Name+" VARCHAR, "+SQLiteHelper_image_buffer_checker_pensing.Table_Image_Size+" VARCHAR, "+SQLiteHelper_image_buffer_checker_pensing.Table_Image_Type+" VARCHAR, "+SQLiteHelper_image_buffer_checker_pensing.Table_order_image+" VARCHAR);");
    }



    public void SQLiteDataBaseBuild_id_image_checker1(){
        sqLiteDatabase =openOrCreateDatabase(SQLiteHelper_problem_id_image_checker1.DATABASE_NAME, Context.MODE_PRIVATE, null);
        }
        public void SQLiteTableBuild_id_image_checker1(){
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_problem_id_image_checker1.TABLE_NAME+"("+ SQLiteHelper_problem_id_image_checker1.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_problem_id_image_checker1.Table_part_id+" VARCHAR, "+SQLiteHelper_problem_id_image_checker1.Table_part_image+" VARCHAR, "+SQLiteHelper_problem_id_image_checker1.Table_Category+" VARCHAR, "+SQLiteHelper_problem_id_image_checker1.Table_Main_problems+" VARCHAR, "+SQLiteHelper_problem_id_image_checker1.Table_Sub_problems+" VARCHAR,"+SQLiteHelper_problem_id_image_checker1.Table_topic+" VARCHAR,"+SQLiteHelper_problem_id_image_checker1.Table_ProblemDetail+" VARCHAR, "+SQLiteHelper_problem_id_image_checker1.Table_datetime+" VARCHAR, "+SQLiteHelper_problem_id_image_checker1.Table_Url+" VARCHAR, "+SQLiteHelper_problem_id_image_checker1.Table_Image_Name+" VARCHAR, "+SQLiteHelper_problem_id_image_checker1.Table_Image_Size+" VARCHAR, "+SQLiteHelper_problem_id_image_checker1.Table_Image_Type+" VARCHAR, "+SQLiteHelper_problem_id_image_checker1.Table_order_image+" VARCHAR);");
        }


    public void SQLiteDataBaseBuild_id_image_checker2(){
        sqLiteDatabase =openOrCreateDatabase(SQLiteHelper_problem_id_image_checker2.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
    public void SQLiteTableBuild_id_image_checker2(){
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_problem_id_image_checker2.TABLE_NAME+"("+ SQLiteHelper_problem_id_image_checker2.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_problem_id_image_checker2.Table_part_id+" VARCHAR, "+SQLiteHelper_problem_id_image_checker2.Table_part_image+" VARCHAR, "+SQLiteHelper_problem_id_image_checker2.Table_Category+" VARCHAR, "+SQLiteHelper_problem_id_image_checker2.Table_Main_problems+" VARCHAR, "+SQLiteHelper_problem_id_image_checker2.Table_Sub_problems+" VARCHAR,"+SQLiteHelper_problem_id_image_checker2.Table_topic+" VARCHAR,"+SQLiteHelper_problem_id_image_checker2.Table_ProblemDetail+" VARCHAR, "+SQLiteHelper_problem_id_image_checker2.Table_datetime+" VARCHAR, "+SQLiteHelper_problem_id_image_checker2.Table_Url+" VARCHAR, "+SQLiteHelper_problem_id_image_checker2.Table_Image_Name+" VARCHAR, "+SQLiteHelper_problem_id_image_checker2.Table_Image_Size+" VARCHAR, "+SQLiteHelper_problem_id_image_checker2.Table_Image_Type+" VARCHAR, "+SQLiteHelper_problem_id_image_checker2.Table_order_image+" VARCHAR);");
    }



    public void SQLiteDataBaseBuild_id_image_checker3(){
        sqLiteDatabase =openOrCreateDatabase(SQLiteHelper_problem_id_image_checker3.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
    public void SQLiteTableBuild_id_image_checker3(){
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_problem_id_image_checker3.TABLE_NAME+"("+ SQLiteHelper_problem_id_image_checker3.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_problem_id_image_checker3.Table_part_id+" VARCHAR, "+SQLiteHelper_problem_id_image_checker3.Table_part_image+" VARCHAR, "+SQLiteHelper_problem_id_image_checker3.Table_Category+" VARCHAR, "+SQLiteHelper_problem_id_image_checker3.Table_Main_problems+" VARCHAR, "+SQLiteHelper_problem_id_image_checker3.Table_Sub_problems+" VARCHAR,"+SQLiteHelper_problem_id_image_checker3.Table_topic+" VARCHAR,"+SQLiteHelper_problem_id_image_checker3.Table_ProblemDetail+" VARCHAR, "+SQLiteHelper_problem_id_image_checker3.Table_datetime+" VARCHAR, "+SQLiteHelper_problem_id_image_checker3.Table_Url+" VARCHAR, "+SQLiteHelper_problem_id_image_checker3.Table_Image_Name+" VARCHAR, "+SQLiteHelper_problem_id_image_checker3.Table_Image_Size+" VARCHAR, "+SQLiteHelper_problem_id_image_checker3.Table_Image_Type+" VARCHAR, "+SQLiteHelper_problem_id_image_checker3.Table_order_image+" VARCHAR);");
    }


    public void SQLiteDataBaseBuild_id_image_checker4(){
        sqLiteDatabase =openOrCreateDatabase(SQLiteHelper_problem_id_image_checker4.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
    public void SQLiteTableBuild_id_image_checker4(){
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_problem_id_image_checker4.TABLE_NAME+"("+ SQLiteHelper_problem_id_image_checker4.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_problem_id_image_checker4.Table_part_id+" VARCHAR, "+SQLiteHelper_problem_id_image_checker4.Table_part_image+" VARCHAR, "+SQLiteHelper_problem_id_image_checker4.Table_Category+" VARCHAR, "+SQLiteHelper_problem_id_image_checker4.Table_Main_problems+" VARCHAR, "+SQLiteHelper_problem_id_image_checker4.Table_Sub_problems+" VARCHAR,"+SQLiteHelper_problem_id_image_checker4.Table_topic+" VARCHAR,"+SQLiteHelper_problem_id_image_checker4.Table_ProblemDetail+" VARCHAR, "+SQLiteHelper_problem_id_image_checker4.Table_datetime+" VARCHAR, "+SQLiteHelper_problem_id_image_checker4.Table_Url+" VARCHAR, "+SQLiteHelper_problem_id_image_checker4.Table_Image_Name+" VARCHAR, "+SQLiteHelper_problem_id_image_checker4.Table_Image_Size+" VARCHAR, "+SQLiteHelper_problem_id_image_checker4.Table_Image_Type+" VARCHAR, "+SQLiteHelper_problem_id_image_checker4.Table_order_image+" VARCHAR);");
    }


    public void SQLiteDataBaseBuild_id_image_checker5(){
        sqLiteDatabase =openOrCreateDatabase(SQLiteHelper_problem_id_image_checker5.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
    public void SQLiteTableBuild_id_image_checker5(){
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_problem_id_image_checker5.TABLE_NAME+"("+ SQLiteHelper_problem_id_image_checker5.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_problem_id_image_checker5.Table_part_id+" VARCHAR, "+SQLiteHelper_problem_id_image_checker5.Table_part_image+" VARCHAR, "+SQLiteHelper_problem_id_image_checker5.Table_Category+" VARCHAR, "+SQLiteHelper_problem_id_image_checker5.Table_Main_problems+" VARCHAR, "+SQLiteHelper_problem_id_image_checker5.Table_Sub_problems+" VARCHAR,"+SQLiteHelper_problem_id_image_checker5.Table_topic+" VARCHAR,"+SQLiteHelper_problem_id_image_checker5.Table_ProblemDetail+" VARCHAR, "+SQLiteHelper_problem_id_image_checker5.Table_datetime+" VARCHAR, "+SQLiteHelper_problem_id_image_checker5.Table_Url+" VARCHAR, "+SQLiteHelper_problem_id_image_checker5.Table_Image_Name+" VARCHAR, "+SQLiteHelper_problem_id_image_checker5.Table_Image_Size+" VARCHAR, "+SQLiteHelper_problem_id_image_checker5.Table_Image_Type+" VARCHAR, "+SQLiteHelper_problem_id_image_checker5.Table_order_image+" VARCHAR);");
    }



    public void SQLiteDataBaseBuild_id_image_checker_map(){
        sqLiteDatabase =openOrCreateDatabase(SQLiteHelper_problem_id_image_checker_map.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
    public void SQLiteTableBuild_id_image_checker_map(){
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_problem_id_image_checker_map.TABLE_NAME+"("+ SQLiteHelper_problem_id_image_checker_map.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_problem_id_image_checker_map.Table_part_id+" VARCHAR, "+SQLiteHelper_problem_id_image_checker_map.Table_part_image+" VARCHAR, "+SQLiteHelper_problem_id_image_checker_map.Table_Category+" VARCHAR, "+SQLiteHelper_problem_id_image_checker_map.Table_Main_problems+" VARCHAR, "+SQLiteHelper_problem_id_image_checker_map.Table_Sub_problems+" VARCHAR,"+SQLiteHelper_problem_id_image_checker_map.Table_topic+" VARCHAR,"+SQLiteHelper_problem_id_image_checker_map.Table_ProblemDetail+" VARCHAR, "+SQLiteHelper_problem_id_image_checker_map.Table_datetime+" VARCHAR, "+SQLiteHelper_problem_id_image_checker_map.Table_Url+" VARCHAR, "+SQLiteHelper_problem_id_image_checker_map.Table_Image_Name+" VARCHAR, "+SQLiteHelper_problem_id_image_checker_map.Table_Image_Size+" VARCHAR, "+SQLiteHelper_problem_id_image_checker_map.Table_Image_Type+" VARCHAR, "+SQLiteHelper_problem_id_image_checker_map.Table_order_image+" VARCHAR);");
    }







    public void SQLiteDataBaseBuild_data_checker_problem_for_report(){
        sqLiteDatabase =openOrCreateDatabase(SQLiteHelper_data_checker_problem_for_report.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
    public void SQLiteTableBuild_data_checker_problem_for_report(){
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_data_checker_problem_for_report.TABLE_NAME+"("+ SQLiteHelper_data_checker_problem_for_report.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_data_checker_problem_for_report.Table_CONTNO+" VARCHAR, "+SQLiteHelper_data_checker_problem_for_report.Table_GORY+" VARCHAR, "+SQLiteHelper_data_checker_problem_for_report.Table_MAIN+" VARCHAR, "+SQLiteHelper_data_checker_problem_for_report.Table_SUB+" VARCHAR, "+SQLiteHelper_data_checker_problem_for_report.Table_DETAILS+" VARCHAR,"+SQLiteHelper_data_checker_problem_for_report.Table_ProcessTypeID+" VARCHAR);");
    }





    Dialog dialog_image,dialog_image2,dialog_image3,dialog_image4,dialog_image5,dialog_image_map;
    int chek_image_ckik=0;
    @Override
    public void click_deleteAll_image1(View v, int position) {
        Log.e("C1","C1");
        chek_image_ckik=1;
        if(size1>0) {
            getData_image_more_for_delates_checker1.clear();


            dialog_image = new Dialog(this);
            dialog_image.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog_image.setContentView(R.layout.mp3_online_list_single_recycleview_dialog_custom_image_problem);
            dialog_image.setCancelable(true);
            final TextView counter = (TextView) dialog_image.findViewById(R.id.counter);
            final RelativeLayout close = (RelativeLayout) dialog_image.findViewById(R.id.close);


            final RecyclerView recycler_view = (RecyclerView) dialog_image.findViewById(R.id.recycler_view);

            recycler_view.setHasFixedSize(true);
            recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

            SQLiteDataBaseBuild1();
            SQLiteTableBuild1_2();
            if (check_buttom_remove_image1 == 1) {

                cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker1.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                if (cursor.moveToFirst()) {
                    do {
                        GetData_cedit_dialog_image_problem_from_id_checker1 dataCeditDialogImageProblemFromId = new GetData_cedit_dialog_image_problem_from_id_checker1();

                        String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_url_image));
                        String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_order_image));

                        dataCeditDialogImageProblemFromId.setImage_id_all(FA);
                        getData_image_more_for_delates_checker1.add(dataCeditDialogImageProblemFromId);
                        // getData_cedit_dialog_image_problem_from_ids.add(dataCeditDialogImageProblemFromId);
                    } while (cursor.moveToNext());
                }
                cursor.close();

                //  }

            } else {
                cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker1.TABLE_NAME + "", null);
                if (cursor.moveToFirst()) {
                    do {
                        GetData_cedit_dialog_image_problem_from_id_checker1 dataCeditDialogImageProblemFromId = new GetData_cedit_dialog_image_problem_from_id_checker1();

                        String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_url_image));
                        String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_order_image));

                        Log.e("FAFA",FA);
                        dataCeditDialogImageProblemFromId.setImage_id_all(FA);
                        getData_image_more_for_delates_checker1.add(dataCeditDialogImageProblemFromId);
                        // getData_cedit_dialog_image_problem_from_ids.add(dataCeditDialogImageProblemFromId);
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }


            counter.setText(getData_image_more_for_delates_checker1.size() + "");

            recyclerViewDataAdapter_dialog_image_problem_from_id_checker1 = new RecyclerViewDataAdapter_dialog_image_problem_from_id_checker1(this, getData_image_more_for_delates_checker1);
            recycler_view.setAdapter(recyclerViewDataAdapter_dialog_image_problem_from_id_checker1);
            recyclerViewDataAdapter_dialog_image_problem_from_id_checker1.setitemclick_deleteAll2(this);

            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog_image.dismiss();
                }
            });


            dialog_image.show();

        }
        else {
            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("! ไม่มีรูป")
                    .setContentText("กรุณาตรวจสอบข้อมูลก่อน!")
                    .setConfirmText("ออก!")
                    .show();
        }




    }

    @Override
    public void click_deleteAll_image2(View v, int position) {
        Log.e("C2","C2");
        chek_image_ckik=2;
        if(size2>0) {
            getData_image_more_for_delates_checker2.clear();


            dialog_image2 = new Dialog(this);
            dialog_image2.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog_image2.setContentView(R.layout.mp3_online_list_single_recycleview_dialog_custom_image_problem);
            dialog_image2.setCancelable(true);
            final TextView counter = (TextView) dialog_image2.findViewById(R.id.counter);
            final RelativeLayout close = (RelativeLayout) dialog_image2.findViewById(R.id.close);


            final RecyclerView recycler_view = (RecyclerView) dialog_image2.findViewById(R.id.recycler_view);

            recycler_view.setHasFixedSize(true);
            recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

            SQLiteDataBaseBuild2();
            SQLiteTableBuild2_2();
            if (check_buttom_remove_image2 == 1) {

                cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker2.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                if (cursor.moveToFirst()) {
                    do {
                        GetData_cedit_dialog_image_problem_from_id_checker2 dataCeditDialogImageProblemFromId = new GetData_cedit_dialog_image_problem_from_id_checker2();

                        String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_url_image));
                        String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_order_image));

                        dataCeditDialogImageProblemFromId.setImage_id_all(FA);
                        getData_image_more_for_delates_checker2.add(dataCeditDialogImageProblemFromId);
                        // getData_cedit_dialog_image_problem_from_ids.add(dataCeditDialogImageProblemFromId);
                    } while (cursor.moveToNext());
                }
                cursor.close();

                //  }

            } else {
                cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker2.TABLE_NAME + "", null);
                if (cursor.moveToFirst()) {
                    do {
                        GetData_cedit_dialog_image_problem_from_id_checker2 dataCeditDialogImageProblemFromId = new GetData_cedit_dialog_image_problem_from_id_checker2();

                        String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_url_image));
                        String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_order_image));
                        Log.e("FAFA2",FA);
                        dataCeditDialogImageProblemFromId.setImage_id_all(FA);
                        getData_image_more_for_delates_checker2.add(dataCeditDialogImageProblemFromId);
                        // getData_cedit_dialog_image_problem_from_ids.add(dataCeditDialogImageProblemFromId);
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }


            counter.setText(getData_image_more_for_delates_checker2.size() + "");

            recyclerViewDataAdapter_dialog_image_problem_from_id_checker2 = new RecyclerViewDataAdapter_dialog_image_problem_from_id_checker2(this, getData_image_more_for_delates_checker2);
            recycler_view.setAdapter(recyclerViewDataAdapter_dialog_image_problem_from_id_checker2);
            recyclerViewDataAdapter_dialog_image_problem_from_id_checker2.setitemclick_deleteAll2(this);

            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog_image2.dismiss();
                }
            });


            dialog_image2.show();

        }
        else {
            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("! ไม่มีรูป")
                    .setContentText("กรุณาตรวจสอบข้อมูลก่อน!")
                    .setConfirmText("ออก!")
                    .show();
        }




    }

    @Override
    public void click_deleteAll_image3(View v, int position) {
        chek_image_ckik=3;
        if(size3>0) {
            getData_image_more_for_delates_checker3.clear();


            dialog_image3 = new Dialog(this);
            dialog_image3.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog_image3.setContentView(R.layout.mp3_online_list_single_recycleview_dialog_custom_image_problem);
            dialog_image3.setCancelable(true);
            final TextView counter = (TextView) dialog_image3.findViewById(R.id.counter);
            final RelativeLayout close = (RelativeLayout) dialog_image3.findViewById(R.id.close);


            final RecyclerView recycler_view = (RecyclerView) dialog_image3.findViewById(R.id.recycler_view);

            recycler_view.setHasFixedSize(true);
            recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

            SQLiteDataBaseBuild3();
            SQLiteTableBuild3_2();
            if (check_buttom_remove_image3 == 1) {

                cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker3.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                if (cursor.moveToFirst()) {
                    do {
                        GetData_cedit_dialog_image_problem_from_id_checker3 dataCeditDialogImageProblemFromId = new GetData_cedit_dialog_image_problem_from_id_checker3();

                        String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_url_image));
                        String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_order_image));

                        dataCeditDialogImageProblemFromId.setImage_id_all(FA);
                        getData_image_more_for_delates_checker3.add(dataCeditDialogImageProblemFromId);
                        // getData_cedit_dialog_image_problem_from_ids.add(dataCeditDialogImageProblemFromId);
                    } while (cursor.moveToNext());
                }
                cursor.close();

                //  }

            } else {
                cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker3.TABLE_NAME + "", null);
                if (cursor.moveToFirst()) {
                    do {
                        GetData_cedit_dialog_image_problem_from_id_checker3 dataCeditDialogImageProblemFromId = new GetData_cedit_dialog_image_problem_from_id_checker3();

                        String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_url_image));
                        String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_order_image));

                        dataCeditDialogImageProblemFromId.setImage_id_all(FA);
                        getData_image_more_for_delates_checker3.add(dataCeditDialogImageProblemFromId);
                        // getData_cedit_dialog_image_problem_from_ids.add(dataCeditDialogImageProblemFromId);
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }


            counter.setText(getData_image_more_for_delates_checker3.size() + "");

            recyclerViewDataAdapter_dialog_image_problem_from_id_checker3 = new RecyclerViewDataAdapter_dialog_image_problem_from_id_checker3(this, getData_image_more_for_delates_checker3);
            recycler_view.setAdapter(recyclerViewDataAdapter_dialog_image_problem_from_id_checker3);
            recyclerViewDataAdapter_dialog_image_problem_from_id_checker3.setitemclick_deleteAll2(this);

            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog_image3.dismiss();
                }
            });


            dialog_image3.show();

        }
        else {
            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("! ไม่มีรูป")
                    .setContentText("กรุณาตรวจสอบข้อมูลก่อน!")
                    .setConfirmText("ออก!")
                    .show();
        }




    }

    @Override
    public void click_deleteAll_image4(View v, int position) {
        chek_image_ckik=4;
        if(size4>0) {
            getData_image_more_for_delates_checker4.clear();


            dialog_image4 = new Dialog(this);
            dialog_image4.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog_image4.setContentView(R.layout.mp3_online_list_single_recycleview_dialog_custom_image_problem);
            dialog_image4.setCancelable(true);
            final TextView counter = (TextView) dialog_image4.findViewById(R.id.counter);
            final RelativeLayout close = (RelativeLayout) dialog_image4.findViewById(R.id.close);


            final RecyclerView recycler_view = (RecyclerView) dialog_image4.findViewById(R.id.recycler_view);

            recycler_view.setHasFixedSize(true);
            recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

            SQLiteDataBaseBuild4();
            SQLiteTableBuild4_2();
            if (check_buttom_remove_image4 == 1) {

                cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker4.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                if (cursor.moveToFirst()) {
                    do {
                        GetData_cedit_dialog_image_problem_from_id_checker4 dataCeditDialogImageProblemFromId = new GetData_cedit_dialog_image_problem_from_id_checker4();

                        String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_url_image));
                        String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_order_image));

                        dataCeditDialogImageProblemFromId.setImage_id_all(FA);
                        getData_image_more_for_delates_checker4.add(dataCeditDialogImageProblemFromId);
                        // getData_cedit_dialog_image_problem_from_ids.add(dataCeditDialogImageProblemFromId);
                    } while (cursor.moveToNext());
                }
                cursor.close();

                //  }

            } else {
                cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker4.TABLE_NAME + "", null);
                if (cursor.moveToFirst()) {
                    do {
                        GetData_cedit_dialog_image_problem_from_id_checker4 dataCeditDialogImageProblemFromId = new GetData_cedit_dialog_image_problem_from_id_checker4();

                        String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_url_image));
                        String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_order_image));

                        dataCeditDialogImageProblemFromId.setImage_id_all(FA);
                        getData_image_more_for_delates_checker4.add(dataCeditDialogImageProblemFromId);
                        // getData_cedit_dialog_image_problem_from_ids.add(dataCeditDialogImageProblemFromId);
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }


            counter.setText(getData_image_more_for_delates_checker4.size() + "");

            recyclerViewDataAdapter_dialog_image_problem_from_id_checker4 = new RecyclerViewDataAdapter_dialog_image_problem_from_id_checker4(this, getData_image_more_for_delates_checker4);
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
        else {
            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("! ไม่มีรูป")
                    .setContentText("กรุณาตรวจสอบข้อมูลก่อน!")
                    .setConfirmText("ออก!")
                    .show();
        }




    }

    @Override
    public void click_deleteAll_image5(View v, int position) {
        chek_image_ckik=5;
        if(size5>0) {
            getData_image_more_for_delates_checker5.clear();


            dialog_image5 = new Dialog(this);
            dialog_image5.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog_image5.setContentView(R.layout.mp3_online_list_single_recycleview_dialog_custom_image_problem);
            dialog_image5.setCancelable(true);
            final TextView counter = (TextView) dialog_image5.findViewById(R.id.counter);
            final RelativeLayout close = (RelativeLayout) dialog_image5.findViewById(R.id.close);


            final RecyclerView recycler_view = (RecyclerView) dialog_image5.findViewById(R.id.recycler_view);

            recycler_view.setHasFixedSize(true);
            recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

            SQLiteDataBaseBuild5();
            SQLiteTableBuild5_2();
            if (check_buttom_remove_image5 == 1) {

                cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker5.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                if (cursor.moveToFirst()) {
                    do {
                        GetData_cedit_dialog_image_problem_from_id_checker5 dataCeditDialogImageProblemFromId = new GetData_cedit_dialog_image_problem_from_id_checker5();

                        String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_url_image));
                        String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_order_image));

                        dataCeditDialogImageProblemFromId.setImage_id_all(FA);
                        getData_image_more_for_delates_checker5.add(dataCeditDialogImageProblemFromId);
                        // getData_cedit_dialog_image_problem_from_ids.add(dataCeditDialogImageProblemFromId);
                    } while (cursor.moveToNext());
                }
                cursor.close();

                //  }

            } else {
                cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker5.TABLE_NAME + "", null);
                if (cursor.moveToFirst()) {
                    do {
                        GetData_cedit_dialog_image_problem_from_id_checker5 dataCeditDialogImageProblemFromId = new GetData_cedit_dialog_image_problem_from_id_checker5();

                        String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_url_image));
                        String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_order_image));

                        dataCeditDialogImageProblemFromId.setImage_id_all(FA);
                        getData_image_more_for_delates_checker5.add(dataCeditDialogImageProblemFromId);
                        // getData_cedit_dialog_image_problem_from_ids.add(dataCeditDialogImageProblemFromId);
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }


            counter.setText(getData_image_more_for_delates_checker5.size() + "");

            recyclerViewDataAdapter_dialog_image_problem_from_id_checker5 = new RecyclerViewDataAdapter_dialog_image_problem_from_id_checker5(this, getData_image_more_for_delates_checker5);
            recycler_view.setAdapter(recyclerViewDataAdapter_dialog_image_problem_from_id_checker5);
            recyclerViewDataAdapter_dialog_image_problem_from_id_checker5.setitemclick_deleteAll2(this);

            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog_image5.dismiss();
                }
            });


            dialog_image5.show();

        }
        else {
            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("! ไม่มีรูป")
                    .setContentText("กรุณาตรวจสอบข้อมูลก่อน!")
                    .setConfirmText("ออก!")
                    .show();
        }




    }



    @Override
    public void click_deleteAll_image_map(View v, int position) {
        Log.e("mapmap","mapmap");
        Log.e("size_map2", String.valueOf(size_map));
        Log.e("check_buttom", String.valueOf(check_buttom_remove_image_map));
        //chek_image_ckik=5;

/*        cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker_map.TABLE_NAME + "", null);
        if (cursor.moveToFirst()) {
            do {
                GetData_cedit_dialog_image_problem_from_id_checker_map dataCeditDialogImageProblemFromId = new GetData_cedit_dialog_image_problem_from_id_checker_map();

                String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_url_image));
                String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_order_image));

                Log.e("FAFA",FA);

                dataCeditDialogImageProblemFromId.setImage_id_all(FA);
                getData_image_more_for_delates_checker_map.add(dataCeditDialogImageProblemFromId);
                // getData_cedit_dialog_image_problem_from_ids.add(dataCeditDialogImageProblemFromId);
            } while (cursor.moveToNext());
        }
        cursor.close();*/

        if(size_map>0) {
            getData_image_more_for_delates_checker_map.clear();
Log.e("map","1111");

              dialog_image_map = new Dialog(this);
            dialog_image_map.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog_image_map.setContentView(R.layout.mp3_online_list_single_recycleview_dialog_custom_image_problem);
            dialog_image_map.setCancelable(true);
            final TextView counter = (TextView) dialog_image_map.findViewById(R.id.counter);
            final RelativeLayout close = (RelativeLayout) dialog_image_map.findViewById(R.id.close);

            Log.e("map","2222");

            final RecyclerView recycler_view = (RecyclerView) dialog_image_map.findViewById(R.id.recycler_view);

            recycler_view.setHasFixedSize(true);
            recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

           SQLiteDataBaseBuild_map();
            SQLiteTableBuild_map_2();
            Log.e("map","3333");

            if (check_buttom_remove_image_map == 1) {

                cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker_map.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                if (cursor.moveToFirst()) {
                    do {
                        GetData_cedit_dialog_image_problem_from_id_checker_map dataCeditDialogImageProblemFromId = new GetData_cedit_dialog_image_problem_from_id_checker_map();

                        String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_url_image));
                        String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_order_image));

                        dataCeditDialogImageProblemFromId.setImage_id_all(FA);
                        getData_image_more_for_delates_checker_map.add(dataCeditDialogImageProblemFromId);
                        // getData_cedit_dialog_image_problem_from_ids.add(dataCeditDialogImageProblemFromId);
                    } while (cursor.moveToNext());
                }
                cursor.close();

                //  }
                Log.e("map","4444");


            } else {
                cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker_map.TABLE_NAME + "", null);
                if (cursor.moveToFirst()) {
                    do {
                        GetData_cedit_dialog_image_problem_from_id_checker_map dataCeditDialogImageProblemFromId = new GetData_cedit_dialog_image_problem_from_id_checker_map();

                        String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_url_image));
                        String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_order_image));

                        Log.e("FAFA",FA);

                        dataCeditDialogImageProblemFromId.setImage_id_all(FA);
                        getData_image_more_for_delates_checker_map.add(dataCeditDialogImageProblemFromId);
                        // getData_cedit_dialog_image_problem_from_ids.add(dataCeditDialogImageProblemFromId);
                    } while (cursor.moveToNext());
                }
                cursor.close();
                Log.e("map","5555");

            }

            Log.e("map","6666");

            counter.setText(getData_image_more_for_delates_checker_map.size() + "");

            recyclerViewDataAdapter_dialog_image_problem_from_id_checker_map = new RecyclerViewDataAdapter_dialog_image_problem_from_id_checker_map(this, getData_image_more_for_delates_checker_map);
            recycler_view.setAdapter(recyclerViewDataAdapter_dialog_image_problem_from_id_checker_map);
            recyclerViewDataAdapter_dialog_image_problem_from_id_checker_map.setitemclick_deleteAll2(this);

            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog_image_map.dismiss();
                }
            });

            Log.e("map","7777");

            dialog_image_map.show();

        }
        else {
            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("! ไม่มีรูป")
                    .setContentText("กรุณาตรวจสอบข้อมูลก่อน!")
                    .setConfirmText("ออก!")
                    .show();
        }




    }


    public class DirectoryCleaner {
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

    int update_order_image=0,update_order_image2=0,update_order_image3=0,update_order_image4=0,update_order_image5=0,update_order_image_map=0,size_im1,size_im2,size_im3,size_im4,size_im5,size_im_map;

    @Override
    public void click_deleteAll_id_checker1(View v, int position) {

        dialog_image.dismiss();

            order_image1 = 0;
            data_cedit_dialog_image_problem_from_id_checker1 = getData_image_more_for_delates_checker1.get(position);
            Log.e("remove + ", String.valueOf(position) + "," + data_cedit_dialog_image_problem_from_id_checker1.getImage_id_all());

            // Log.e("remove + ", String.valueOf(position));
            SQLiteDataBaseBuild1();
            SQLiteTableBuild1();
            SQLiteDataBaseBuild1_2();
            SQLiteTableBuild1_2();

            sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker1.TABLE_NAME + "" + " WHERE url_image =" + "'" + data_cedit_dialog_image_problem_from_id_checker1.getImage_id_all() + "'");


            getData_image_news.clear();


            cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker1.TABLE_NAME + "", null);
            if (cursor.moveToFirst()) {
                do {

                    String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_url_image));
                    String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_order_image));

                    String ID_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_part_id));
                    String number_BUF2 = String.valueOf(2);
                    String NAME_IMAGE_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_name_image));
                    String Url_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_Url));
                    String length_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_Image_Size));
                    String image_type_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_Image_Type));
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


            size_im1 = getData_image_news.size();
            //getData_image_news.clear();
            if (getData_image_news.size() == 0) {
                check_buttom_remove_image1 = 0;
                size_im1 = 0;
                order_image1 = 0;
                sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker1.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'");

                //File dire = new File(Environment.getExternalStorageDirectory(), "/Android/data/com.tsr.tsrproblemreport/files/Pictures");
                //new DirectoryCleaner(dire).clean();
                //dire.delete();

                SQLiteDataBaseBuild1();
                SQLiteTableBuild1();
                sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker1.TABLE_NAME + "");

                SQLiteDataBaseBuild1_2();
                SQLiteTableBuild1_2();
                sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker1_2.TABLE_NAME + "");

                SQLiteDataBaseBuild_id_image_checker1();
                SQLiteTableBuild_id_image_checker1();
                sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_problem_id_image_checker1.TABLE_NAME + "");

                my_recycler_view1.setVisibility(View.GONE);

            } else {
                //check_buttom_remove_image=1;
            }
            Log.e("CHECK_IMAGEwwww_S", String.valueOf(getData_image_news.size()));
            SQLiteDataBaseBuild1();
            SQLiteTableBuild1_2();
            sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker1.TABLE_NAME + "" + " WHERE name_image =" + "'" + "1" + "'");
            sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker1.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'");
            for (int i2 = 0; i2 < getData_image_news.size(); i2++) {


                order_image1 = order_image1 + 1;
                getDataImageNew = getData_image_news.get(i2);
                Log.e("CHECK_IMAGEwwww_2", String.valueOf(order_image1));
                String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker1.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + getDataImageNew.getPart_id() + "','" + getDataImageNew.getName_image() + "','" + getDataImageNew.getUrl_image() + "','" + getDataImageNew.getUrl() + "','" + getDataImageNew.getImage_Name() + "','" + getDataImageNew.getImage_Size() + "','" + getDataImageNew.getImage_Type() + "','" + String.valueOf(order_image1) + "');";
                sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
            }


            allSampleData1.clear();
            singleItem1.clear();


            for (int i = 1; i <= 1; i++) {

                SectionDataModel_checker1 dm = new SectionDataModel_checker1();

                dm.setHeaderTitle("ล่าสุด ");

                singleItem1 = new ArrayList<SingleItemModel_checker1>();


                if (size_im1 == 1) {
                    cursor = sqLiteDatabase.rawQuery("SELECT count(*)as dd,url_image,order_image,name_image FROM " + SQLiteHelper_image_buffer_checker1.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                    //cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" , null);
                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_order_image));
                            //String rr=cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
                            Log.e("FAภ", FA + "," + order_image1);


                            singleItem1.add(new SingleItemModel_checker1("รูป " + f, FA));

                            size1 = singleItem1.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                } else {


                    Cursor cursor222 = sqLiteDatabase.rawQuery("SELECT distinct name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image FROM " + SQLiteHelper_image_buffer_checker1.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                    //cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" , null);
                    if (cursor222.moveToFirst()) {
                        do {
                            //for(int i2=0;i2<=1;i2++) {
                            // count_id2 = cursor.getInt(0);
                            //Log.e("count_id2", String.valueOf(count_id2));
                            String FA = cursor222.getString(cursor222.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_url_image));
                            String FA2 = cursor222.getString(cursor222.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_url_image));
                            String f = cursor222.getString(cursor222.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_order_image));
                            //String rr=cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
                            int vv = Integer.parseInt(f);
                            if (FA2 != FA) {
                                Log.e("FAn", FA + "," + order_image1);
                            }


                            singleItem1.add(new SingleItemModel_checker1("รูป " + f, FA));

                            size1 = singleItem1.size();
                            //MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                            //  }

                        } while (cursor222.moveToNext());
                    }


                }


                //}


                dm.setAllItemsInSection(singleItem1);
                allSampleData1.add(dm);
            }

            RecyclerViewDataAdapter_image1 adapter = new RecyclerViewDataAdapter_image1(this, allSampleData1);
            my_recycler_view1.setAdapter(adapter);
            adapter.setitemclick_deleteAll3(this);
            adapter.notifyDataSetChanged();
            if (singleItem1.size() == 0) {
                my_recycler_view1.setVisibility(View.GONE);
            } else {
                my_recycler_view1.setVisibility(View.VISIBLE);
            }
            //select_image();
            check_buttom_remove_image1 = 1;


    }

    @Override
    public void click_deleteAll_id_checker2(View v, int position) {
        dialog_image2.dismiss();


            order_image2 = 0;
            data_cedit_dialog_image_problem_from_id_checker2 = getData_image_more_for_delates_checker2.get(position);
            Log.e("remove + ", String.valueOf(position) + "," + data_cedit_dialog_image_problem_from_id_checker2.getImage_id_all());

            // Log.e("remove + ", String.valueOf(position));
            SQLiteDataBaseBuild2();
            SQLiteTableBuild2();
            SQLiteDataBaseBuild2_2();
            SQLiteTableBuild2_2();

            sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker2.TABLE_NAME + "" + " WHERE url_image =" + "'" + data_cedit_dialog_image_problem_from_id_checker2.getImage_id_all() + "'");


            getData_image_news.clear();


            cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker2.TABLE_NAME + "", null);
            if (cursor.moveToFirst()) {
                do {

                    String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_url_image));
                    String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_order_image));

                    String ID_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_part_id));
                    String number_BUF2 = String.valueOf(2);
                    String NAME_IMAGE_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_name_image));
                    String Url_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_Url));
                    String length_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_Image_Size));
                    String image_type_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_Image_Type));
                    String order_image_BUF2 = String.valueOf(update_order_image2 + 1);




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


            size_im2 = getData_image_news.size();
            //getData_image_news.clear();
            if (getData_image_news.size() == 0) {
                check_buttom_remove_image2 = 0;
                size_im2 = 0;
                order_image2 = 0;
                sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker2.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'");

                //File dire = new File(Environment.getExternalStorageDirectory(), "/Android/data/com.tsr.tsrproblemreport/files/Pictures");
                //  new DirectoryCleaner(dire).clean();
                //dire.delete();

                SQLiteDataBaseBuild2();
                SQLiteTableBuild2();
                sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker2.TABLE_NAME + "");

                SQLiteDataBaseBuild2_2();
                SQLiteTableBuild2_2();
                sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker2_2.TABLE_NAME + "");

                SQLiteDataBaseBuild_id_image_checker2();
                SQLiteTableBuild_id_image_checker2();
                sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_problem_id_image_checker2.TABLE_NAME + "");

                my_recycler_view2.setVisibility(View.GONE);

            } else {
                //check_buttom_remove_image=1;
            }
            Log.e("CHECK_IMAGEwwww_S", String.valueOf(getData_image_news.size()));
            SQLiteDataBaseBuild2();
            SQLiteTableBuild2_2();
            sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker2.TABLE_NAME + "" + " WHERE name_image =" + "'" + "1" + "'");
            sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker2.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'");
            for (int i2 = 0; i2 < getData_image_news.size(); i2++) {


                order_image2 = order_image2 + 1;
                getDataImageNew = getData_image_news.get(i2);
                Log.e("CHECK_IMAGEwwww_2", String.valueOf(order_image2));
                String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker2.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + getDataImageNew.getPart_id() + "','" + getDataImageNew.getName_image() + "','" + getDataImageNew.getUrl_image() + "','" + getDataImageNew.getUrl() + "','" + getDataImageNew.getImage_Name() + "','" + getDataImageNew.getImage_Size() + "','" + getDataImageNew.getImage_Type() + "','" + String.valueOf(order_image2) + "');";
                sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
            }


            allSampleData2.clear();
            singleItem2.clear();


            for (int i = 1; i <= 1; i++) {

                SectionDataModel_checker2 dm = new SectionDataModel_checker2();

                dm.setHeaderTitle("ล่าสุด ");

                singleItem2 = new ArrayList<SingleItemModel_checker2>();


                if (size_im2 == 1) {
                    cursor = sqLiteDatabase.rawQuery("SELECT count(*)as dd,url_image,order_image,name_image FROM " + SQLiteHelper_image_buffer_checker2.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                    //cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" , null);
                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_order_image));
                            //String rr=cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
                            Log.e("FAภ", FA + "," + order_image2);


                            singleItem2.add(new SingleItemModel_checker2("รูป " + f, FA));

                            size2 = singleItem2.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                } else {


                    Cursor cursor222 = sqLiteDatabase.rawQuery("SELECT distinct name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image FROM " + SQLiteHelper_image_buffer_checker2.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                    //cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" , null);
                    if (cursor222.moveToFirst()) {
                        do {
                            //for(int i2=0;i2<=1;i2++) {
                            // count_id2 = cursor.getInt(0);
                            //Log.e("count_id2", String.valueOf(count_id2));
                            String FA = cursor222.getString(cursor222.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_url_image));
                            String FA2 = cursor222.getString(cursor222.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_url_image));
                            String f = cursor222.getString(cursor222.getColumnIndex(SQLiteHelper_image_buffer_checker2.Table_order_image));
                            //String rr=cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
                            int vv = Integer.parseInt(f);
                            if (FA2 != FA) {
                                Log.e("FAn", FA + "," + order_image2);
                            }


                            singleItem2.add(new SingleItemModel_checker2("รูป " + f, FA));

                            size2 = singleItem2.size();
                            //MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                            //  }

                        } while (cursor222.moveToNext());
                    }


                }


                //}


                dm.setAllItemsInSection(singleItem2);
                allSampleData2.add(dm);
            }

            RecyclerViewDataAdapter_image2 adapter = new RecyclerViewDataAdapter_image2(this, allSampleData2);
            my_recycler_view2.setAdapter(adapter);
            adapter.setitemclick_deleteAll3(this);
            adapter.notifyDataSetChanged();
            if (singleItem2.size() == 0) {
                my_recycler_view2.setVisibility(View.GONE);
            } else {
                my_recycler_view2.setVisibility(View.VISIBLE);
            }
            //select_image();
            check_buttom_remove_image2 = 1;


    }

    @Override
    public void click_deleteAll_id_checker3(View v, int position) {
        dialog_image3.dismiss();


        order_image3 = 0;
        data_cedit_dialog_image_problem_from_id_checker3 = getData_image_more_for_delates_checker3.get(position);
        Log.e("remove + ", String.valueOf(position) + "," + data_cedit_dialog_image_problem_from_id_checker3.getImage_id_all());

        // Log.e("remove + ", String.valueOf(position));
        SQLiteDataBaseBuild3();
        SQLiteTableBuild3();
        SQLiteDataBaseBuild3_2();
        SQLiteTableBuild3_2();

        sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker3.TABLE_NAME + "" + " WHERE url_image =" + "'" + data_cedit_dialog_image_problem_from_id_checker3.getImage_id_all() + "'");


        getData_image_news.clear();


        cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker3.TABLE_NAME + "", null);
        if (cursor.moveToFirst()) {
            do {

                String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_url_image));
                String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_order_image));

                String ID_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_part_id));
                String number_BUF2 = String.valueOf(2);
                String NAME_IMAGE_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_name_image));
                String Url_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_Url));
                String length_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_Image_Size));
                String image_type_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_Image_Type));
                String order_image_BUF2 = String.valueOf(update_order_image3 + 1);




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


        size_im3 = getData_image_news.size();
        //getData_image_news.clear();
        if (getData_image_news.size() == 0) {
            check_buttom_remove_image3 = 0;
            size_im3= 0;
            order_image3 = 0;
            sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker3.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'");

            //File dire = new File(Environment.getExternalStorageDirectory(), "/Android/data/com.tsr.tsrproblemreport/files/Pictures");
            //  new DirectoryCleaner(dire).clean();
            //dire.delete();

            SQLiteDataBaseBuild3();
            SQLiteTableBuild3();
            sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker3.TABLE_NAME + "");

            SQLiteDataBaseBuild3_2();
            SQLiteTableBuild3_2();
            sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker3_2.TABLE_NAME + "");

            SQLiteDataBaseBuild_id_image_checker3();
            SQLiteTableBuild_id_image_checker3();
            sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_problem_id_image_checker3.TABLE_NAME + "");

            my_recycler_view2.setVisibility(View.GONE);

        } else {
            //check_buttom_remove_image=1;
        }
        Log.e("CHECK_IMAGEwwww_S", String.valueOf(getData_image_news.size()));
        SQLiteDataBaseBuild3();
        SQLiteTableBuild3_2();
        sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker3.TABLE_NAME + "" + " WHERE name_image =" + "'" + "1" + "'");
        sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker3.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'");
        for (int i2 = 0; i2 < getData_image_news.size(); i2++) {


            order_image3 = order_image3 + 1;
            getDataImageNew = getData_image_news.get(i2);
            Log.e("CHECK_IMAGEwwww_2", String.valueOf(order_image2));
            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker3.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + getDataImageNew.getPart_id() + "','" + getDataImageNew.getName_image() + "','" + getDataImageNew.getUrl_image() + "','" + getDataImageNew.getUrl() + "','" + getDataImageNew.getImage_Name() + "','" + getDataImageNew.getImage_Size() + "','" + getDataImageNew.getImage_Type() + "','" + String.valueOf(order_image3) + "');";
            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
        }


        allSampleData3.clear();
        singleItem3.clear();


        for (int i = 1; i <= 1; i++) {

            SectionDataModel_checker3 dm = new SectionDataModel_checker3();

            dm.setHeaderTitle("ล่าสุด ");

            singleItem3 = new ArrayList<SingleItemModel_checker3>();


            if (size_im3 == 1) {
                cursor = sqLiteDatabase.rawQuery("SELECT count(*)as dd,url_image,order_image,name_image FROM " + SQLiteHelper_image_buffer_checker3.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                //cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" , null);
                if (cursor.moveToFirst()) {
                    do {

                        String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_url_image));
                        String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_order_image));
                        //String rr=cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
                        Log.e("FAภ", FA + "," + order_image3);


                        singleItem3.add(new SingleItemModel_checker3("รูป " + f, FA));

                        size3 = singleItem3.size();
                        MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                    } while (cursor.moveToNext());
                }
                cursor.close();
            } else {


                Cursor cursor222 = sqLiteDatabase.rawQuery("SELECT distinct name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image FROM " + SQLiteHelper_image_buffer_checker3.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                //cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" , null);
                if (cursor222.moveToFirst()) {
                    do {
                        //for(int i2=0;i2<=1;i2++) {
                        // count_id2 = cursor.getInt(0);
                        //Log.e("count_id2", String.valueOf(count_id2));
                        String FA = cursor222.getString(cursor222.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_url_image));
                        String FA2 = cursor222.getString(cursor222.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_url_image));
                        String f = cursor222.getString(cursor222.getColumnIndex(SQLiteHelper_image_buffer_checker3.Table_order_image));
                        //String rr=cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
                        int vv = Integer.parseInt(f);
                        if (FA2 != FA) {
                            Log.e("FAn", FA + "," + order_image3);
                        }


                        singleItem3.add(new SingleItemModel_checker3("รูป " + f, FA));

                        size3 = singleItem3.size();
                        //MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        //  }

                    } while (cursor222.moveToNext());
                }


            }


            //}


            dm.setAllItemsInSection(singleItem3);
            allSampleData3.add(dm);
        }

        RecyclerViewDataAdapter_image3 adapter = new RecyclerViewDataAdapter_image3(this, allSampleData3);
        my_recycler_view3.setAdapter(adapter);
        adapter.setitemclick_deleteAll3(this);
        adapter.notifyDataSetChanged();
        if (singleItem3.size() == 0) {
            my_recycler_view3.setVisibility(View.GONE);
        } else {
            my_recycler_view3.setVisibility(View.VISIBLE);
        }
        //select_image();
        check_buttom_remove_image3 = 1;


    }

    @Override
    public void click_deleteAll_id_checker4(View v, int position) {
        dialog_image4.dismiss();


        order_image4 = 0;
        data_cedit_dialog_image_problem_from_id_checker4 = getData_image_more_for_delates_checker4.get(position);
        Log.e("remove + ", String.valueOf(position) + "," + data_cedit_dialog_image_problem_from_id_checker4.getImage_id_all());

        // Log.e("remove + ", String.valueOf(position));
        SQLiteDataBaseBuild4();
        SQLiteTableBuild4();
        SQLiteDataBaseBuild4_2();
        SQLiteTableBuild4_2();

        sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker4.TABLE_NAME + "" + " WHERE url_image =" + "'" + data_cedit_dialog_image_problem_from_id_checker4.getImage_id_all() + "'");


        getData_image_news.clear();


        cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker4.TABLE_NAME + "", null);
        if (cursor.moveToFirst()) {
            do {

                String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_url_image));
                String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_order_image));

                String ID_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_part_id));
                String number_BUF2 = String.valueOf(2);
                String NAME_IMAGE_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_name_image));
                String Url_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_Url));
                String length_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_Image_Size));
                String image_type_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_Image_Type));
                String order_image_BUF2 = String.valueOf(update_order_image4 + 1);




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


        size_im4 = getData_image_news.size();
        //getData_image_news.clear();
        if (getData_image_news.size() == 0) {
            check_buttom_remove_image4 = 0;
            size_im4 = 0;
            order_image4 = 0;
            sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker4.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'");

            //File dire = new File(Environment.getExternalStorageDirectory(), "/Android/data/com.tsr.tsrproblemreport/files/Pictures");
            //  new DirectoryCleaner(dire).clean();
            //dire.delete();

            SQLiteDataBaseBuild4();
            SQLiteTableBuild4();
            sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker4.TABLE_NAME + "");

            SQLiteDataBaseBuild4_2();
            SQLiteTableBuild4_2();
            sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker4_2.TABLE_NAME + "");

            SQLiteDataBaseBuild_id_image_checker4();
            SQLiteTableBuild_id_image_checker4();
            sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_problem_id_image_checker4.TABLE_NAME + "");

            my_recycler_view4.setVisibility(View.GONE);

        } else {
            //check_buttom_remove_image=1;
        }
        Log.e("CHECK_IMAGEwwww_S", String.valueOf(getData_image_news.size()));
        SQLiteDataBaseBuild4();
        SQLiteTableBuild4_2();
        sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker4.TABLE_NAME + "" + " WHERE name_image =" + "'" + "1" + "'");
        sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker4.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'");
        for (int i2 = 0; i2 < getData_image_news.size(); i2++) {


            order_image4 = order_image4 + 1;
            getDataImageNew = getData_image_news.get(i2);
            Log.e("CHECK_IMAGEwwww_2", String.valueOf(order_image4));
            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker4.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + getDataImageNew.getPart_id() + "','" + getDataImageNew.getName_image() + "','" + getDataImageNew.getUrl_image() + "','" + getDataImageNew.getUrl() + "','" + getDataImageNew.getImage_Name() + "','" + getDataImageNew.getImage_Size() + "','" + getDataImageNew.getImage_Type() + "','" + String.valueOf(order_image4) + "');";
            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
        }


        allSampleData4.clear();
        singleItem4.clear();


        for (int i = 1; i <= 1; i++) {

            SectionDataModel_checker4 dm = new SectionDataModel_checker4();

            dm.setHeaderTitle("ล่าสุด ");

            singleItem4 = new ArrayList<SingleItemModel_checker4>();


            if (size_im4 == 1) {
                cursor = sqLiteDatabase.rawQuery("SELECT count(*)as dd,url_image,order_image,name_image FROM " + SQLiteHelper_image_buffer_checker4.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                //cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" , null);
                if (cursor.moveToFirst()) {
                    do {

                        String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_url_image));
                        String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_order_image));
                        //String rr=cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
                        Log.e("FAภ", FA + "," + order_image4);


                        singleItem4.add(new SingleItemModel_checker4("รูป " + f, FA));

                        size4 = singleItem4.size();
                        MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                    } while (cursor.moveToNext());
                }
                cursor.close();
            } else {


                Cursor cursor222 = sqLiteDatabase.rawQuery("SELECT distinct name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image FROM " + SQLiteHelper_image_buffer_checker4.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                //cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" , null);
                if (cursor222.moveToFirst()) {
                    do {
                        //for(int i2=0;i2<=1;i2++) {
                        // count_id2 = cursor.getInt(0);
                        //Log.e("count_id2", String.valueOf(count_id2));
                        String FA = cursor222.getString(cursor222.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_url_image));
                        String FA2 = cursor222.getString(cursor222.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_url_image));
                        String f = cursor222.getString(cursor222.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_order_image));
                        //String rr=cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
                        int vv = Integer.parseInt(f);
                        if (FA2 != FA) {
                            Log.e("FAn", FA + "," + order_image4);
                        }


                        singleItem4.add(new SingleItemModel_checker4("รูป " + f, FA));

                        size4 = singleItem4.size();
                        //MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        //  }

                    } while (cursor222.moveToNext());
                }


            }


            //}


            dm.setAllItemsInSection(singleItem4);
            allSampleData4.add(dm);
        }

        RecyclerViewDataAdapter_image4 adapter = new RecyclerViewDataAdapter_image4(this, allSampleData4);
        my_recycler_view4.setAdapter(adapter);
        adapter.setitemclick_deleteAll3(this);
        adapter.notifyDataSetChanged();
        if (singleItem4.size() == 0) {
            my_recycler_view4.setVisibility(View.GONE);
        } else {
            my_recycler_view4.setVisibility(View.VISIBLE);
        }
        //select_image();
        check_buttom_remove_image4 = 1;


    }

    @Override
    public void click_deleteAll_id_checker5(View v, int position) {
        dialog_image5.dismiss();


        order_image5 = 0;
        data_cedit_dialog_image_problem_from_id_checker5 = getData_image_more_for_delates_checker5.get(position);
        Log.e("remove + ", String.valueOf(position) + "," + data_cedit_dialog_image_problem_from_id_checker5.getImage_id_all());

        // Log.e("remove + ", String.valueOf(position));
        SQLiteDataBaseBuild5();
        SQLiteTableBuild5();
        SQLiteDataBaseBuild5_2();
        SQLiteTableBuild5_2();

        sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker5.TABLE_NAME + "" + " WHERE url_image =" + "'" + data_cedit_dialog_image_problem_from_id_checker5.getImage_id_all() + "'");


        getData_image_news.clear();


        cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker5.TABLE_NAME + "", null);
        if (cursor.moveToFirst()) {
            do {

                String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_url_image));
                String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_order_image));

                String ID_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_part_id));
                String number_BUF2 = String.valueOf(2);
                String NAME_IMAGE_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_name_image));
                String Url_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_Url));
                String length_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_Image_Size));
                String image_type_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_Image_Type));
                String order_image_BUF2 = String.valueOf(update_order_image5 + 1);




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


        size_im5 = getData_image_news.size();
        //getData_image_news.clear();
        if (getData_image_news.size() == 0) {
            check_buttom_remove_image5 = 0;
            size_im5 = 0;
            order_image5 = 0;
            sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker5.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'");

            //File dire = new File(Environment.getExternalStorageDirectory(), "/Android/data/com.tsr.tsrproblemreport/files/Pictures");
            //  new DirectoryCleaner(dire).clean();
            //dire.delete();

            SQLiteDataBaseBuild5();
            SQLiteTableBuild5();
            sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker5.TABLE_NAME + "");

            SQLiteDataBaseBuild5_2();
            SQLiteTableBuild5_2();
            sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker5_2.TABLE_NAME + "");

            SQLiteDataBaseBuild_id_image_checker5();
            SQLiteTableBuild_id_image_checker5();
            sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_problem_id_image_checker5.TABLE_NAME + "");

            my_recycler_view5.setVisibility(View.GONE);

        } else {
            //check_buttom_remove_image=1;
        }
        Log.e("CHECK_IMAGEwwww_S", String.valueOf(getData_image_news.size()));
        SQLiteDataBaseBuild5();
        SQLiteTableBuild5_2();
        sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker5.TABLE_NAME + "" + " WHERE name_image =" + "'" + "1" + "'");
        sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker5.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'");
        for (int i2 = 0; i2 < getData_image_news.size(); i2++) {


            order_image5 = order_image5 + 1;
            getDataImageNew = getData_image_news.get(i2);
            Log.e("CHECK_IMAGEwwww_2", String.valueOf(order_image5));
            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker5.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + getDataImageNew.getPart_id() + "','" + getDataImageNew.getName_image() + "','" + getDataImageNew.getUrl_image() + "','" + getDataImageNew.getUrl() + "','" + getDataImageNew.getImage_Name() + "','" + getDataImageNew.getImage_Size() + "','" + getDataImageNew.getImage_Type() + "','" + String.valueOf(order_image5) + "');";
            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
        }


        allSampleData5.clear();
        singleItem5.clear();


        for (int i = 1; i <= 1; i++) {

            SectionDataModel_checker5 dm = new SectionDataModel_checker5();

            dm.setHeaderTitle("ล่าสุด ");

            singleItem5 = new ArrayList<SingleItemModel_checker5>();


            if (size_im5 == 1) {
                cursor = sqLiteDatabase.rawQuery("SELECT count(*)as dd,url_image,order_image,name_image FROM " + SQLiteHelper_image_buffer_checker5.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                //cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" , null);
                if (cursor.moveToFirst()) {
                    do {

                        String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_url_image));
                        String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_order_image));
                        //String rr=cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
                        Log.e("FAภ", FA + "," + order_image5);


                        singleItem5.add(new SingleItemModel_checker5("รูป " + f, FA));

                        size5 = singleItem5.size();
                        MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                    } while (cursor.moveToNext());
                }
                cursor.close();
            } else {


                Cursor cursor222 = sqLiteDatabase.rawQuery("SELECT distinct name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image FROM " + SQLiteHelper_image_buffer_checker5.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                //cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" , null);
                if (cursor222.moveToFirst()) {
                    do {
                        //for(int i2=0;i2<=1;i2++) {
                        // count_id2 = cursor.getInt(0);
                        //Log.e("count_id2", String.valueOf(count_id2));
                        String FA = cursor222.getString(cursor222.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_url_image));
                        String FA2 = cursor222.getString(cursor222.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_url_image));
                        String f = cursor222.getString(cursor222.getColumnIndex(SQLiteHelper_image_buffer_checker5.Table_order_image));
                        //String rr=cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
                        int vv = Integer.parseInt(f);
                        if (FA2 != FA) {
                            Log.e("FAn", FA + "," + order_image5);
                        }


                        singleItem5.add(new SingleItemModel_checker5("รูป " + f, FA));

                        size5 = singleItem5.size();
                        //MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        //  }

                    } while (cursor222.moveToNext());
                }


            }


            //}


            dm.setAllItemsInSection(singleItem5);
            allSampleData5.add(dm);
        }

        RecyclerViewDataAdapter_image5 adapter = new RecyclerViewDataAdapter_image5(this, allSampleData5);
        my_recycler_view5.setAdapter(adapter);
        adapter.setitemclick_deleteAll3(this);
        adapter.notifyDataSetChanged();
        if (singleItem5.size() == 0) {
            my_recycler_view5.setVisibility(View.GONE);
        } else {
            my_recycler_view5.setVisibility(View.VISIBLE);
        }
        //select_image();
        check_buttom_remove_image5 = 1;


    }

    @Override
    public void click_deleteAll_id_checker_map(View v, int position) {
        Log.e("bvbv","bvbv");

        dialog_image_map.dismiss();


        order_image_map = 0;
        data_cedit_dialog_image_problem_from_id_checker_map = getData_image_more_for_delates_checker_map.get(position);
        Log.e("remove + ", String.valueOf(position) + "," + data_cedit_dialog_image_problem_from_id_checker_map.getImage_id_all());

        // Log.e("remove + ", String.valueOf(position));
        SQLiteDataBaseBuild_map();
        SQLiteTableBuild_map();
        SQLiteDataBaseBuild_map_2();
        SQLiteTableBuild_map_2();

        sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker_map.TABLE_NAME + "" + " WHERE url_image =" + "'" + data_cedit_dialog_image_problem_from_id_checker_map.getImage_id_all() + "'");


        getData_image_news.clear();


        cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker_map.TABLE_NAME + "", null);
        if (cursor.moveToFirst()) {
            do {

                String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_url_image));
                String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_order_image));

                String ID_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_part_id));
                String number_BUF2 = String.valueOf(2);
                String NAME_IMAGE_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_name_image));
                String Url_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_Url));
                String length_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_Image_Size));
                String image_type_BUF2 = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_Image_Type));
                String order_image_BUF2 = String.valueOf(update_order_image_map + 1);




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


        size_im_map = getData_image_news.size();
        //getData_image_news.clear();
        if (getData_image_news.size() == 0) {
            check_buttom_remove_image_map = 0;
            size_im_map = 0;
            order_image_map = 0;
            sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker_map.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'");

            //File dire = new File(Environment.getExternalStorageDirectory(), "/Android/data/com.tsr.tsrproblemreport/files/Pictures");
            //  new DirectoryCleaner(dire).clean();
            //dire.delete();

            SQLiteDataBaseBuild_map();
            SQLiteTableBuild_map();
            sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker_map.TABLE_NAME + "");

            SQLiteDataBaseBuild_map_2();
            SQLiteTableBuild_map_2();
            sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker_map_2.TABLE_NAME + "");

            SQLiteDataBaseBuild_id_image_checker_map();
            SQLiteTableBuild_id_image_checker_map();
            sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_problem_id_image_checker_map.TABLE_NAME + "");

            my_recycler_view_map.setVisibility(View.GONE);

        } else {
            //check_buttom_remove_image=1;
        }
        Log.e("CHECK_IMAGEwwww_S", String.valueOf(getData_image_news.size()));
        SQLiteDataBaseBuild_map();
        SQLiteTableBuild_map_2();
        sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker_map.TABLE_NAME + "" + " WHERE name_image =" + "'" + "1" + "'");
        sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker_map.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'");
        for (int i2 = 0; i2 < getData_image_news.size(); i2++) {


            order_image_map = order_image_map + 1;
            getDataImageNew = getData_image_news.get(i2);
            Log.e("CHECK_IMAGEwwww_2", String.valueOf(order_image_map));
            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker_map.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + getDataImageNew.getPart_id() + "','" + getDataImageNew.getName_image() + "','" + getDataImageNew.getUrl_image() + "','" + getDataImageNew.getUrl() + "','" + getDataImageNew.getImage_Name() + "','" + getDataImageNew.getImage_Size() + "','" + getDataImageNew.getImage_Type() + "','" + String.valueOf(order_image_map) + "');";
            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
        }


        allSampleData_map.clear();
        singleItem_map.clear();


        for (int i = 1; i <= 1; i++) {

            SectionDataModel_checker_map dm = new SectionDataModel_checker_map();

            dm.setHeaderTitle("ล่าสุด ");

            singleItem_map = new ArrayList<SingleItemModel_checker_map>();


            if (size_im_map == 1) {
                cursor = sqLiteDatabase.rawQuery("SELECT count(*)as dd,url_image,order_image,name_image FROM " + SQLiteHelper_image_buffer_checker_map.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                //cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" , null);
                if (cursor.moveToFirst()) {
                    do {

                        String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_url_image));
                        String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_order_image));
                        //String rr=cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
                        Log.e("FAภ", FA + "," + order_image_map);


                        singleItem_map.add(new SingleItemModel_checker_map("รูป " + f, FA));

                        size_map = singleItem_map.size();
                        MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                    } while (cursor.moveToNext());
                }
                cursor.close();
            } else {


                Cursor cursor222 = sqLiteDatabase.rawQuery("SELECT distinct name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image FROM " + SQLiteHelper_image_buffer_checker_map.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                //cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" , null);
                if (cursor222.moveToFirst()) {
                    do {
                        //for(int i2=0;i2<=1;i2++) {
                        // count_id2 = cursor.getInt(0);
                        //Log.e("count_id2", String.valueOf(count_id2));
                        String FA = cursor222.getString(cursor222.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_url_image));
                        String FA2 = cursor222.getString(cursor222.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_url_image));
                        String f = cursor222.getString(cursor222.getColumnIndex(SQLiteHelper_image_buffer_checker_map.Table_order_image));
                        //String rr=cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
                        int vv = Integer.parseInt(f);
                        if (FA2 != FA) {
                            Log.e("FAn", FA + "," + order_image_map);
                        }


                        singleItem_map.add(new SingleItemModel_checker_map("รูป " + f, FA));

                        size_map = singleItem_map.size();
                        //MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        //  }

                    } while (cursor222.moveToNext());
                }


            }


            //}


            dm.setAllItemsInSection(singleItem_map);
            allSampleData_map.add(dm);
        }

        RecyclerViewDataAdapter_image_map adapter = new RecyclerViewDataAdapter_image_map(this, allSampleData_map);
        my_recycler_view_map.setAdapter(adapter);
        adapter.setitemclick_deleteAll_map_map(this);
        adapter.notifyDataSetChanged();
        if (singleItem_map.size() == 0) {
            my_recycler_view_map.setVisibility(View.GONE);
        } else {
            my_recycler_view_map.setVisibility(View.VISIBLE);
        }
        //select_image();
        check_buttom_remove_image_map = 1;


    }





    public void SELECT_DATA_PROBLEM_GORY() {

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_gory_1 ,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_SELECT_DATA_PROBLEM_GORY(response);

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

    // String ID_GORY2="";
    public void JSON_PARSE_DATA_AFTER_SELECT_DATA_PROBLEM_GORY(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            final GetData_select_home_in GetDataAdapter2 = new GetData_select_home_in();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                GetDataAdapter2.setAnswerID(json.getString("AnswerID"));
                GetDataAdapter2.setTopicID(json.getString("TopicID"));
                GetDataAdapter2.setData(json.getString("data"));
               // GetDataAdapter2.setProblemName(json.getString("ProblemName"));



            } catch (JSONException e) {

                e.printStackTrace();
            }
            getData_select_home_in.add(GetDataAdapter2);
            // value=GetDataAdapter2.getProblemName();
        }
        String[] array2 = new String[getData_select_home_in.size()];
        String[] array3 = new String[getData_select_home_in.size()];
        int i;
        ArrayAdapter<String> adapter = null ;

        for ( i = 0; i < getData_select_home_in.size(); i++) {
            final GetData_select_home_in contact = getData_select_home_in.get(i);
            array2[i]= contact.getData();

//            Log.e("SSSS",array2[i]);

            //array2=getData_select_topic_problem_gories.;
            try {
                adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, array2);
                //adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, android.R.id.text1, array2);
            }
            catch (Exception ex){

            }

        }



        spDemo.setAdapter(adapter);

        spDemo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item = parent.getItemAtPosition(position).toString();
              Log.e("spDemo",item);

                //Toast.makeText(parent.getContext(), "Selected Item: " + item, Toast.LENGTH_LONG).show();


                final GetData_select_home_in contact = getData_select_home_in.get(position);
                AnswerID_home_in= contact.getAnswerID();
                TopicID_home_in= contact.getTopicID();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }





    public void SELECT_DATA_PROBLEM_GORY1() {

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_gory_2 ,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_SELECT_DATA_PROBLEM_GORY1(response);

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

    // String ID_GORY2="";
    public void JSON_PARSE_DATA_AFTER_SELECT_DATA_PROBLEM_GORY1(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            final GetData_select_map_maker GetDataAdapter2 = new GetData_select_map_maker();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                GetDataAdapter2.setAnswerID(json.getString("AnswerID"));
                GetDataAdapter2.setTopicID(json.getString("TopicID"));
                GetDataAdapter2.setData(json.getString("data"));




            } catch (JSONException e) {

                e.printStackTrace();
            }
            getData_select_map_makers.add(GetDataAdapter2);
            // value=GetDataAdapter2.getProblemName();
        }
        String[] array2 = new String[ getData_select_map_makers.size()];
        String[] array3 = new String[ getData_select_map_makers.size()];
        int i;
        ArrayAdapter<String> adapter = null ;

        for ( i = 0; i <  getData_select_map_makers.size(); i++) {
            final GetData_select_map_maker contact =  getData_select_map_makers.get(i);
            array2[i]= contact.getData();

            Log.e("SSSS",array2[i]);

            //array2=getData_select_topic_problem_gories.;
            try {
                adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, array2);
                //adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, android.R.id.text1, array2);
            }
            catch (Exception ex){

            }

        }



        spDemo1.setAdapter(adapter);

        spDemo1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item1 = parent.getItemAtPosition(position).toString();
                Log.e("spDemo1",item1);

                final GetData_select_map_maker contact = getData_select_map_makers.get(position);
                AnswerID_gps= contact.getAnswerID();
                TopicID_gps= contact.getTopicID();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    public void SELECT_DATA_PROBLEM_GORY2() {

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_gory_3 ,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_SELECT_DATA_PROBLEM_GORY2(response);

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

    // String ID_GORY2="";
    public void JSON_PARSE_DATA_AFTER_SELECT_DATA_PROBLEM_GORY2(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            final GetData_select_install GetDataAdapter2 = new GetData_select_install();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                GetDataAdapter2.setAnswerID(json.getString("AnswerID"));
                GetDataAdapter2.setTopicID(json.getString("TopicID"));
                GetDataAdapter2.setData(json.getString("data"));




            } catch (JSONException e) {

                e.printStackTrace();
            }
            getData_select_installs.add(GetDataAdapter2);
            // value=GetDataAdapter2.getProblemName();
        }
        String[] array2 = new String[getData_select_installs.size()];
        String[] array3 = new String[getData_select_installs.size()];
        int i;
        ArrayAdapter<String> adapter = null ;

        for ( i = 0; i < getData_select_installs.size(); i++) {
            final GetData_select_install contact = getData_select_installs.get(i);
            array2[i]= contact.getData();

            Log.e("SSSS",array2[i]);

            //array2=getData_select_topic_problem_gories.;
            try {
                adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, array2);
                //adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, android.R.id.text1, array2);
            }
            catch (Exception ex){

            }

        }



        spDemo2.setAdapter(adapter);

        spDemo2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item2 = parent.getItemAtPosition(position).toString();
                Log.e("spDemo2",item2);

                final GetData_select_install contact = getData_select_installs.get(position);
                AnswerID_install= contact.getAnswerID();
                TopicID_install= contact.getTopicID();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }




    public void SELECT_DATA_PROBLEM_GORY3() {

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_gory_4 ,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_SELECT_DATA_PROBLEM_GORY3(response);

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

    // String ID_GORY2="";
    public void JSON_PARSE_DATA_AFTER_SELECT_DATA_PROBLEM_GORY3(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            final GetData_select_checker_who GetDataAdapter2 = new GetData_select_checker_who();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                GetDataAdapter2.setAnswerID(json.getString("AnswerID"));
                GetDataAdapter2.setTopicID(json.getString("TopicID"));
                GetDataAdapter2.setData(json.getString("data"));




            } catch (JSONException e) {

                e.printStackTrace();
            }
            getData_select_checker_whos.add(GetDataAdapter2);
            // value=GetDataAdapter2.getProblemName();
        }
        String[] array2 = new String[        getData_select_checker_whos.size()];
        String[] array3 = new String[        getData_select_checker_whos.size()];
        int i;
        ArrayAdapter<String> adapter = null ;

        for ( i = 0; i <         getData_select_checker_whos.size(); i++) {
            final GetData_select_checker_who contact =         getData_select_checker_whos.get(i);
            array2[i]= contact.getData();

            Log.e("SSSS",array2[i]);

            //array2=getData_select_topic_problem_gories.;
            try {
                adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, array2);
                //adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, android.R.id.text1, array2);
            }
            catch (Exception ex){

            }

        }



        spDemo3.setAdapter(adapter);

        spDemo3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item2 = parent.getItemAtPosition(position).toString();
                Log.e("spDemo3",item3);

                final GetData_select_checker_who contact = getData_select_checker_whos.get(position);
                AnswerID_who= contact.getAnswerID();
                TopicID_who= contact.getTopicID();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }



    String part_image="";

    private void uploadMultiFile() {

        //progressDialog.show();
        pDialogg.show();

        ArrayList<String> filePaths = new ArrayList<>();

        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);

        int gg=   getData_uploade_images.size();
        Log.e("gg", String.valueOf(gg));
        for (int i = 0; i < getData_uploade_images.size(); i++) {
            // getData_uploade_images.get(i);
            GetData_uploade_Image contact = getData_uploade_images.get(i);
            String data_image_to_qry = contact.getImage();








            String url_image1 = contact.getUrl_image1()+"";
            String Url1= contact.getUrl1()+"";
            String Image_Name1= contact.getImage_Name1()+"";
            String Image_Size1= contact.getImage_Size1()+"";
            String Image_Type1= contact.getImage_Type1()+"";
            String order_image1= contact.getOrder_image1()+"";

            String url_image2 = contact.getUrl_image2()+"";
            String Url2= contact.getUrl2()+"";
            String Image_Name2= contact.getImage_Name2()+"";
            String Image_Size2= contact.getImage_Size2()+"";
            String Image_Type2= contact.getImage_Type2()+"";
            String order_image2= contact.getOrder_image2()+"";


            String url_image3 = contact.getUrl_image3()+"";
            String Url3= contact.getUrl3()+"";
            String Image_Name3= contact.getImage_Name3()+"";
            String Image_Size3= contact.getImage_Size3()+"";
            String Image_Type3= contact.getImage_Type3()+"";
            String order_image3= contact.getOrder_image3()+"";


            String url_image4 = contact.getUrl_image4()+"";
            String Url4= contact.getUrl4()+"";
            String Image_Name4= contact.getImage_Name4()+"";
            String Image_Size4= contact.getImage_Size4()+"";
            String Image_Type4= contact.getImage_Type4()+"";
            String order_image4= contact.getOrder_image4()+"";

            String url_image5 = contact.getUrl_image5()+"";
            String Url5= contact.getUrl5()+"";
            String Image_Name5= contact.getImage_Name5()+"";
            String Image_Size5= contact.getImage_Size5()+"";
            String Image_Type5= contact.getImage_Type5()+"";
            String order_image5= contact.getOrder_image5()+"";

            String url_image6 = contact.getUrl_image6()+"";
            String Url6= contact.getUrl6()+"";
            String Image_Name6= contact.getImage_Name6()+"";
            String Image_Size6= contact.getImage_Size6()+"";
            String Image_Type6= contact.getImage_Type6()+"";
            String order_image6= contact.getOrder_image6()+"";

            String url_image7 = contact.getUrl_image7()+"";
            String Url7= contact.getUrl7()+"";
            String Image_Name7= contact.getImage_Name7()+"";
            String Image_Size7= contact.getImage_Size7()+"";
            String Image_Type7= contact.getImage_Type7()+"";
            String order_image7= contact.getOrder_image7()+"";

            if(!url_image1.equals("null")){
                insert_CheckerCard_Images_qr_scan(order_image1,Url1,Image_Name1,Image_Type1,Image_Size1);
            }
            if(!url_image2.equals("null")){
                insert_CheckerCard_Images_install(order_image2,Url2,Image_Name2,Image_Type2,Image_Size2);
            }
            if(!url_image3.equals("null")){
                //insert_CheckerCard_Images_install_yes_no(order_image3,Url3,Image_Name3,Image_Type3,Image_Size3);
            }
            if(!url_image4.equals("null")){



                insert_CheckerCard_Images_home_in(order_image4,Url4,Image_Name4,Image_Type4,Image_Size4);
            }
            if(!url_image5.equals("null")){
                insert_CheckerCard_Images_confrim(order_image5,Url5,Image_Name5,Image_Type5,Image_Size5);
            }
            if(!url_image6.equals("null")){

                insert_CheckerCard_Images_gps_maker(order_image6,Url6,Image_Name6,Image_Type6,Image_Size6);
            }

            if(!url_image7.equals("null")){

                insert_CheckerCard_Images_pensing(order_image7,Url7,Image_Name7,Image_Type7,Image_Size7);
            }










/*
            SQLiteDataBaseBuild1();
            SQLiteTableBuild1();


            cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper_image_buffer_checker1.TABLE_NAME+"" +" WHERE url_image ="+"'"+data_image_to_qry+"'"  , null);

            if (cursor.moveToFirst()) {
                do {

                    part_image=cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_url_image));
*/
/*                    datetime=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image_checker1.Table_ProblemDetail));
                    Url=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image_checker1.Table_Url));
                    Image_Name=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image_checker1.Table_Image_Name));
                    Image_Size=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image_checker1.Table_Image_Size));
                    Image_Type=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image_checker1.Table_Image_Type));
                    Image_id_item=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image_checker1.Table_order_image));*//*


                    //INSENT_Problem_Inform_Details_Images();

                    Log.e("part_image_final",part_image);
                } while (cursor.moveToNext());
            }
            cursor.close();
*/





/*
            SQLiteDataBaseBuild1();
            SQLiteTableBuild1();


            cursor = sqLiteDatabase.rawQuery("SELECT *  FROM " + SQLiteHelper_image_buffer_checker1.TABLE_NAME, null);

            if (cursor.moveToFirst()) {
                do {

                    String part_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_url_image));
                    String part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_part_id));
                    // Log.e("oooo", part_image);
                    if (!part_image.equals("null")) {
                        Log.e("part_image_final",part_image);

                    }


                } while (cursor.moveToNext());
            }
            cursor.close();*/



            File file = new File(String.valueOf(contact.getImage()));
            builder.addFormDataPart("file[]", file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file));
        }






        File file = new File("");
        MultipartBody requestBody = builder.build();



        try {

            Thread thread = null;
            Thread finalThread = thread;
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Call<ResponseBody> call=null;
                    /*Call<ResponseBody>*/ call = uploadService.uploadMultiFile2(requestBody);

                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                            try {
                                pDialogg.dismiss();

                            }
                            catch (Exception ex){

                            }

                            select_check_sucess_all();


                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            try {
                                pDialogg.dismiss();
                            }
                            catch (Exception ex){

                            }
                            File dire= new File(Environment.getExternalStorageDirectory(), "/Android/data/com.tsr.tsrproblemreport_tossticket/files/Pictures");
                            Log.e("dire", String.valueOf(dire));
                            new DirectoryCleaner(dire).clean();
                            dire.delete();
                            getData_uploade_images.clear();

                        }
                    });
                }
            });

            thread.start();
        }
        catch (Exception ex){
            pDialogg.dismiss();
            // pDialogg.cancel();

        }




    }


    String GET_JSON_insert_CheckerCard_Master="http://app.thiensurat.co.th/assanee/checker_system/Master/insert_CheckerCard_Master_home_in.php";
    String GET_JSON_insert_CheckerCard_Dedails="http://app.thiensurat.co.th/assanee/checker_system/Details/insert_CheckerCard_Details.php";
    String GET_JSON_insert_CheckerCard_Images="http://app.thiensurat.co.th/assanee/checker_system/Images/insert_CheckerCard_Image.php";

    private void insert_CheckerCard_Master(){

        String Contno=conno;






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





        try {
            Log.e("URL_Details_Images",GET_JSON_insert_CheckerCard_Master+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&CheckerEmpID="+InformEmpID+"&CustomerChecked="+URLEncoder.encode(customer, "UTF-8")+"&ProcessTypeID="+ProcessTypeID+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

//MyApplication.getInstance().getPrefManager().getPreferrence("InformID")

        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_insert_CheckerCard_Master+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&CheckerEmpID="+InformEmpID+"&CustomerChecked="+URLEncoder.encode(customer, "UTF-8")+"&ProcessTypeID="+ProcessTypeID+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID,


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









    private void insert_CheckerCard_Details_home_in(){

        String Contno=conno;


        String ipaddress2=MyApplication.getInstance().getPrefManager().getPreferrence("IPaddress")+"";
        String computername2=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";

        String ipaddress3="";
        String computername3="";


        if(ipaddress2.equals("null")){
            ipaddress3="-";
        }
        else {
            ipaddress3="-";

        }





        if(computername2.equals("null")){
            computername3="-";
        }
        else {

            computername3=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";
        }

        String ipaddress = ipaddress3;
        String computername = computername3;
        String InformEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");


        String TopicID=TopicID_home_in;
        String AnswerID=AnswerID_home_in;

        String new_message_home_in_S=new_message_home_in.getText().toString();
        String AnswerNote="";
        if(new_message_home_in_S.isEmpty()){
             AnswerNote="-";
        }
        else {
             AnswerNote=new_message_home_in.getText().toString();
        }





        try {
            Log.e("URL_Details_Images",GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID,


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




    private void insert_CheckerCard_Details_gps_maker(){

        String Contno=conno;


        String ipaddress2=MyApplication.getInstance().getPrefManager().getPreferrence("IPaddress")+"";
        String computername2=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";

        String ipaddress3="";
        String computername3="";


        if(ipaddress2.equals("null")){
            ipaddress3="-";
        }
        else {
            ipaddress3="-";

        }





        if(computername2.equals("null")){
            computername3="-";
        }
        else {

            computername3=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";
        }

        String ipaddress = ipaddress3;
        String computername = computername3;
        String InformEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");


    //    String TopicID="2";
    //    String AnswerID="02";
    //    String AnswerNote="ทดสอบ2";


        String TopicID=TopicID_gps;
        String AnswerID=AnswerID_gps;
        String AnswerNote="ปักหมุดต่ำแหน่ง gps";



        try {
            Log.e("URL_Details_Images",GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID,


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
    private void insert_CheckerCard_Details_qr_scan(){

        String Contno=conno;


        String ipaddress2=MyApplication.getInstance().getPrefManager().getPreferrence("IPaddress")+"";
        String computername2=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";

        String ipaddress3="";
        String computername3="";


        if(ipaddress2.equals("null")){
            ipaddress3="-";
        }
        else {
            ipaddress3="-";

        }





        if(computername2.equals("null")){
            computername3="-";
        }
        else {

            computername3=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";
        }

        String ipaddress = ipaddress3;
        String computername = computername3;
        String InformEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");


        conno_intro=MyApplication.getInstance().getPrefManager().getPreferrence("conno_intro");
        conno_scan=MyApplication.getInstance().getPrefManager().getPreferrence("conno_scan");
        String TopicID="1";
        String AnswerID="";
        try {
            if (conno_intro.equals(conno_scan)) {
                 AnswerID="19";
            } else {
                 AnswerID="20";
            }
        }
        catch (Exception erx){

        }
String new_message_scan_S=new_message_scan.getText().toString();
        String AnswerNote="";

        if(new_message_scan_S.isEmpty()){
            AnswerNote="สแกนบาร์โคดที่เครื่อง";
        }
        else {
            AnswerNote=new_message_scan.getText().toString();
        }



        try {
            Log.e("URL_Details_Images",GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID,


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
    private void insert_CheckerCard_Details_install(){

        String Contno=conno;


        String ipaddress2=MyApplication.getInstance().getPrefManager().getPreferrence("IPaddress")+"";
        String computername2=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";

        String ipaddress3="";
        String computername3="";


        if(ipaddress2.equals("null")){
            ipaddress3="-";
        }
        else {
            ipaddress3="-";

        }





        if(computername2.equals("null")){
            computername3="-";
        }
        else {

            computername3=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";
        }

        String ipaddress = ipaddress3;
        String computername = computername3;
        String InformEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");


        String TopicID="5";
        String AnswerID="";
        if(checkedText_install.equals("ติดตั้งเรียบร้อย")){
            AnswerID="9";
        }
        else {
            AnswerID="10";
        }




        String new_message_install_S=new_message_install.getText().toString();
        String AnswerNote="";

        if(new_message_install_S.isEmpty()){
            AnswerNote="-";
        }
        else {
            AnswerNote=new_message_install.getText().toString();
        }



        try {
            Log.e("URL_Details_Images",GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID,


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
    private void insert_CheckerCard_Details_install_yes_no(){

        String Contno=conno;


        String ipaddress2=MyApplication.getInstance().getPrefManager().getPreferrence("IPaddress")+"";
        String computername2=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";

        String ipaddress3="";
        String computername3="";


        if(ipaddress2.equals("null")){
            ipaddress3="-";
        }
        else {
            ipaddress3="-";

        }





        if(computername2.equals("null")){
            computername3="-";
        }
        else {

            computername3=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";
        }

        String ipaddress = ipaddress3;
        String computername = computername3;
        String InformEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");


        String TopicID="5";
        String AnswerID="05";
        String AnswerNote="ทดสอบ5";

        try {
            Log.e("URL_Details_Images",GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID,


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
    private void insert_CheckerCard_Details_checker_who(){

        String Contno=conno;


        String ipaddress2=MyApplication.getInstance().getPrefManager().getPreferrence("IPaddress")+"";
        String computername2=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";

        String ipaddress3="";
        String computername3="";


        if(ipaddress2.equals("null")){
            ipaddress3="-";
        }
        else {
            ipaddress3="-";

        }





        if(computername2.equals("null")){
            computername3="-";
        }
        else {

            computername3=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";
        }

        String ipaddress = ipaddress3;
        String computername = computername3;
        String InformEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");


        String TopicID=TopicID_who;
        String AnswerID=AnswerID_who;




        String new_message_install_S=new_message.getText().toString();
        String AnswerNote="";

        if(new_message_install_S.isEmpty()){
            AnswerNote="-";
        }
        else {
            AnswerNote=new_message.getText().toString();
        }

        try {
            Log.e("URL_Details_Images",GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID,


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
    private void insert_CheckerCard_Details_customer1(){

        String Contno=conno;


        String ipaddress2=MyApplication.getInstance().getPrefManager().getPreferrence("IPaddress")+"";
        String computername2=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";

        String ipaddress3="";
        String computername3="";


        if(ipaddress2.equals("null")){
            ipaddress3="-";
        }
        else {
            ipaddress3="-";

        }





        if(computername2.equals("null")){
            computername3="-";
        }
        else {

            computername3=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";
        }

        String ipaddress = ipaddress3;
        String computername = computername3;
        String InformEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");


        String TopicID="4";
        String AnswerID="";
        if(checkedText_pay_one.equals("ชำระแล้ว")){
            AnswerID="15";
        }
        else {
            AnswerID="16";
        }



        String new_message_install_S=new_message2.getText().toString();
        String AnswerNote="";

        if(new_message_install_S.isEmpty()){
            AnswerNote="-";
        }
        else {
            AnswerNote=new_message2.getText().toString();
        }

        try {
            Log.e("URL_Details_Images",GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID,


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
    private void insert_CheckerCard_Details_customer2(){

        String Contno=conno;


        String ipaddress2=MyApplication.getInstance().getPrefManager().getPreferrence("IPaddress")+"";
        String computername2=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";

        String ipaddress3="";
        String computername3="";


        if(ipaddress2.equals("null")){
            ipaddress3="-";
        }
        else {
            ipaddress3="-";

        }





        if(computername2.equals("null")){
            computername3="-";
        }
        else {

            computername3=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";
        }

        String ipaddress = ipaddress3;
        String computername = computername3;
        String InformEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");




        String TopicID="9";
        String AnswerID="21";
        //String AnswerNote="นัดเก็บเงินงวด 2 ";

        String new_message_install_S=new_message_pay2.getText().toString();
        String AnswerNote="";

        if(new_message_install_S.isEmpty()){
            AnswerNote="นัดเก็บเงินงวด 2";
        }
        else {
            AnswerNote=new_message_pay2.getText().toString();
        }


        try {
            Log.e("URL_Details_Images",GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID,


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
    private void insert_CheckerCard_Details_confrim(){

        String Contno=conno;


        String ipaddress2=MyApplication.getInstance().getPrefManager().getPreferrence("IPaddress")+"";
        String computername2=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";

        String ipaddress3="";
        String computername3="";


        if(ipaddress2.equals("null")){
            ipaddress3="-";
        }
        else {
            ipaddress3="-";

        }





        if(computername2.equals("null")){
            computername3="-";
        }
        else {

            computername3=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";
        }

        String ipaddress = ipaddress3;
        String computername = computername3;
        String InformEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");


        String TopicID="27";
        String AnswerID="";
        if(checkedText_pay_one.equals("ถูกต้อง")){
            AnswerID="22";
        }
        else {
            AnswerID="23";
        }



        String new_message_install_S=new_message2.getText().toString();
        String AnswerNote="";

        if(new_message_install_S.isEmpty()){
            AnswerNote="-";
        }
        else {
            AnswerNote=new_message2.getText().toString();
        }

        try {
            Log.e("URL_Details_Images",GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID,


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
    private void insert_CheckerCard_Details_Other(){

    }
    private void insert_CheckerCard_Details_additional(){

    }









    private void insert_CheckerCard_Images_home_in(String Items1,String URL1,String ImageName1,String ImageType1,String ImageSize1){



        String Contno=conno;


        String ipaddress2=MyApplication.getInstance().getPrefManager().getPreferrence("IPaddress")+"";
        String computername2=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";

        String ipaddress3="";
        String computername3="";


        if(ipaddress2.equals("null")){
            ipaddress3="-";
        }
        else {
            ipaddress3="-";

        }





        if(computername2.equals("null")){
            computername3="-";
        }
        else {

            computername3=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";
        }

        String ipaddress = ipaddress3;
        String computername = computername3;
        String InformEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");


        String TopicID="2";
        String AnswerID="09";
        String AnswerNote="ทดสอบ9";

        String Items=Items1;
        String URL=URL1;
        String ImageName=ImageName1;
        String ImageType=ImageType1;
        String ImageSize=ImageSize1;


        try {
            Log.e("URL_Details_Images",GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }



        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID,


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
    private void insert_CheckerCard_Images_gps_maker(String Items1,String URL1,String ImageName1,String ImageType1,String ImageSize1){



        String Contno=conno;


        String ipaddress2=MyApplication.getInstance().getPrefManager().getPreferrence("IPaddress")+"";
        String computername2=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";

        String ipaddress3="";
        String computername3="";


        if(ipaddress2.equals("null")){
            ipaddress3="-";
        }
        else {
            ipaddress3="-";

        }





        if(computername2.equals("null")){
            computername3="-";
        }
        else {

            computername3=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";
        }

        String ipaddress = ipaddress3;
        String computername = computername3;
        String InformEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");


        String TopicID="6";
        String AnswerID="09";
        String AnswerNote="ทดสอบ9";

        String Items=Items1;
        String URL=URL1;
        String ImageName=ImageName1;
        String ImageType=ImageType1;
        String ImageSize=ImageSize1;


        try {
            Log.e("URL_Details_Images",GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }



        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID,


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
    private void insert_CheckerCard_Images_qr_scan(String Items1,String URL1,String ImageName1,String ImageType1,String ImageSize1){



        String Contno=conno;


        String ipaddress2=MyApplication.getInstance().getPrefManager().getPreferrence("IPaddress")+"";
        String computername2=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";

        String ipaddress3="";
        String computername3="";


        if(ipaddress2.equals("null")){
            ipaddress3="-";
        }
        else {
            ipaddress3="-";

        }





        if(computername2.equals("null")){
            computername3="-";
        }
        else {

            computername3=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";
        }

        String ipaddress = ipaddress3;
        String computername = computername3;
        String InformEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");


        String TopicID="1";
        String AnswerID="09";
        String AnswerNote="ทดสอบ9";

        String Items=Items1;
        String URL=URL1;
        String ImageName=ImageName1;
        String ImageType=ImageType1;
        String ImageSize=ImageSize1;


        try {
            Log.e("URL_Details_Images",GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }



        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID,


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
    private void insert_CheckerCard_Images_install(String Items1,String URL1,String ImageName1,String ImageType1,String ImageSize1){



        String Contno=conno;


        String ipaddress2=MyApplication.getInstance().getPrefManager().getPreferrence("IPaddress")+"";
        String computername2=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";

        String ipaddress3="";
        String computername3="";


        if(ipaddress2.equals("null")){
            ipaddress3="-";
        }
        else {
            ipaddress3="-";

        }





        if(computername2.equals("null")){
            computername3="-";
        }
        else {

            computername3=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";
        }

        String ipaddress = ipaddress3;
        String computername = computername3;
        String InformEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");


        String TopicID="5";
        String AnswerID="09";
        String AnswerNote="ทดสอบ9";

        String Items=Items1;
        String URL=URL1;
        String ImageName=ImageName1;
        String ImageType=ImageType1;
        String ImageSize=ImageSize1;


        try {
            Log.e("URL_Details_Images",GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }



        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID,


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
/*    private void insert_CheckerCard_Images_install_yes_no(String Items1,String URL1,String ImageName1,String ImageType1,String ImageSize1){



        String Contno=conno;


        String ipaddress2=MyApplication.getInstance().getPrefManager().getPreferrence("IPaddress")+"";
        String computername2=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";

        String ipaddress3="";
        String computername3="";


        if(ipaddress2.equals("null")){
            ipaddress3="-";
        }
        else {
            ipaddress3="-";

        }





        if(computername2.equals("null")){
            computername3="-";
        }
        else {

            computername3=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";
        }

        String ipaddress = ipaddress3;
        String computername = computername3;
        String InformEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");


        String TopicID="5";
        String AnswerID="09";
        String AnswerNote="ทดสอบ9";

        String Items=Items1;
        String URL=URL1;
        String ImageName=ImageName1;
        String ImageType=ImageType1;
        String ImageSize=ImageSize1;


        try {
            Log.e("URL_Details_Images",GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }



        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID,


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


    }*/
    private void insert_CheckerCard_Images_confrim(String Items1,String URL1,String ImageName1,String ImageType1,String ImageSize1){



        String Contno=conno;


        String ipaddress2=MyApplication.getInstance().getPrefManager().getPreferrence("IPaddress")+"";
        String computername2=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";

        String ipaddress3="";
        String computername3="";


        if(ipaddress2.equals("null")){
            ipaddress3="-";
        }
        else {
            ipaddress3="-";

        }





        if(computername2.equals("null")){
            computername3="-";
        }
        else {

            computername3=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";
        }

        String ipaddress = ipaddress3;
        String computername = computername3;
        String InformEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");


        String TopicID="27";
        String AnswerID="18";
        String AnswerNote="ยืนยันการผ่อนชำระ";

        String Items=Items1;
        String URL=URL1;
        String ImageName=ImageName1;
        String ImageType=ImageType1;
        String ImageSize=ImageSize1;


        try {
            Log.e("URL_Details_Images",GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }



        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID,


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



    private void insert_CheckerCard_Images_pensing(String Items1,String URL1,String ImageName1,String ImageType1,String ImageSize1){



        String Contno=conno;


        String ipaddress2=MyApplication.getInstance().getPrefManager().getPreferrence("IPaddress")+"";
        String computername2=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";

        String ipaddress3="";
        String computername3="";


        if(ipaddress2.equals("null")){
            ipaddress3="-";
        }
        else {
            ipaddress3="-";

        }





        if(computername2.equals("null")){
            computername3="-";
        }
        else {

            computername3=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";
        }

        String ipaddress = ipaddress3;
        String computername = computername3;
        String InformEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");


        String TopicID="27";
        String AnswerID="17";
        String AnswerNote="เซ็นชื่อ";

        String Items=Items1;
        String URL=URL1;
        String ImageName=ImageName1;
        String ImageType=ImageType1;
        String ImageSize=ImageSize1;


        try {
            Log.e("URL_Details_Images",GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }



        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID,


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

    String GET_JSON_select_check_sucess_all="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_check_sucess_all2.php";
    String InformID_REAL="";
    public void select_check_sucess_all(){
         InformID_REAL= MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");



        jsonArrayRequest = new JsonArrayRequest(GET_JSON_select_check_sucess_all+"?InformID="+InformID_REAL+"&Contno="+conno,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSON_PARSE_DATA_AFTER_select_id_from_Problem_Inform_select_check_sucess_all(response);

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


        requestQueue.add(jsonArrayRequest);
    }
    public static String InformID_M="",InformID_D="",InformID_I="";
    public void JSON_PARSE_DATA_AFTER_select_id_from_Problem_Inform_select_check_sucess_all(JSONArray array) {
        for (int i = 0; i < array.length(); i++) {

            //final GetData_select_topic_problem_sub GetDataAdapter2 = new GetData_select_topic_problem_sub();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                // GetDataAdapter2.setProblemID(json.getString("InformID"));
                InformID_M= json.getString("InformID_M");
                InformID_D= json.getString("InformID_D");
                InformID_I= json.getString("InformID_I");
            }
            catch (JSONException e) {

                e.printStackTrace();
            }
        }












        InformID_REAL= MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        Log.e("InformID_ALL_FULL",InformID_M+","+InformID_D+","+InformID_I+","+InformID_REAL);
        if((InformID_M.equals(InformID_REAL))&(InformID_I.equals(InformID_REAL))){



            SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE);
            sweetAlertDialog.setTitleText("เสร็จสิ้น!");
            sweetAlertDialog.setContentText("*การตรวจสอบ*");
            sweetAlertDialog.setCancelable(false);
            sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sDialog) {


                    String count="";
                    if((status_report_problem_qr==1)|status_report_problem_pay2==1){
                        if(status_report_problem_qr==1&status_report_problem_pay2==1){
                            count="2";
                        }
                    if(status_report_problem_qr==1&status_report_problem_pay2==0){
                        count="1";
                        }
                    if(status_report_problem_qr==0&status_report_problem_pay2==1){
                        count="1";
                        }

                        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(Detali_check3.this, SweetAlertDialog.SUCCESS_TYPE);
                        sweetAlertDialog.setTitleText("มีปัญหา "+count+" !");
                        sweetAlertDialog.setContentText("*รายการที่ต้องแจ้ง*");
                        sweetAlertDialog.setConfirmText("OK,แจ้งปัญหา!");
                        sweetAlertDialog.setCancelText("ไม่,ออก!");
                        sweetAlertDialog.setCancelable(false);
                        sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {



                                Intent = new Intent(Detali_check3.this, MusicActivity_Credit.class);
                                startActivity(Intent);
                                finish();

                            }
                        });
                        sweetAlertDialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.cancel();
                                sweetAlertDialog.dismiss();
                                Intent = new Intent(Detali_check3.this, MusicActivity_Checker.class);
                                startActivity(Intent);
                                finish();
                            }
                        });

                    }

                    else {
                        Intent = new Intent(Detali_check3.this, MusicActivity_Checker.class);
                        startActivity(Intent);
                        finish();
                    }









                }
            });
        }
        else {








            pDialogg.dismiss();
            pDialogg.cancel();
            //  Log.d(TAG, "Error " + t.getMessage());
            //finalThread.stop();



            SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE);
            sweetAlertDialog.setTitleText("เสร็จสิ้น!");
            sweetAlertDialog.setContentText("*การตรวจสอบ*");
            sweetAlertDialog.setCancelable(false);

/*            SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE);
            sweetAlertDialog.setTitleText("ผิดพลาด!");
            sweetAlertDialog.setContentText("*อัพโหลดข้อมูลไม่สำเร็จ กรุณาลองอีกครั้ง*");
            sweetAlertDialog.setCancelable(false);*/
            sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sDialog) {

                    sweetAlertDialog.dismiss();
                    String count="";
                    if((status_report_problem_qr==1)|status_report_problem_pay2==1){
                        if(status_report_problem_qr==1&status_report_problem_pay2==1){
                            count="2";
                        }
                        if(status_report_problem_qr==1&status_report_problem_pay2==0){
                            count="1";
                        }
                        if(status_report_problem_qr==0&status_report_problem_pay2==1){
                            count="1";
                        }

                        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(Detali_check3.this, SweetAlertDialog.SUCCESS_TYPE);
                        sweetAlertDialog.setTitleText("มีปัญหา "+count+" !");
                        sweetAlertDialog.setContentText("*รายการที่ต้องแจ้ง*");
                        sweetAlertDialog.setConfirmText("OK,แจ้งปัญหา!");
                        sweetAlertDialog.setCancelText("ไม่,ออก!");
                        sweetAlertDialog.setCancelable(false);
                        sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {



                                Intent = new Intent(Detali_check3.this, MusicActivity_Credit.class);
                                startActivity(Intent);
                                finish();

                            }
                        });
                        sweetAlertDialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.cancel();
                                sweetAlertDialog.dismiss();
                                Intent = new Intent(Detali_check3.this, MusicActivity_Checker.class);
                                startActivity(Intent);
                                finish();
                            }
                        });

                    }

                    else {
                        Intent = new Intent(Detali_check3.this, MusicActivity_Checker.class);
                        startActivity(Intent);
                        finish();
                    }
                }
            });
            sweetAlertDialog .show();
        }



    }




}



