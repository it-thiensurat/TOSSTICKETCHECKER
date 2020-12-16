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
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
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
import android.widget.ScrollView;
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
import com.google.gson.Gson;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.tsr.tsrproblemreport_tossticket_checker.API_URL_ALL;
import com.tsr.tsrproblemreport_tossticket_checker.BuildConfig;
import com.tsr.tsrproblemreport_tossticket_checker.INSERT_GPS_GIS;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.MusicActivity_Checker;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.adapter.RecyclerViewAdapter_confirm;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.adapter.RecyclerViewAdapter_type_check;
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
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.data_base.SQLiteHelper_data_type;
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
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.GetData_select_product_name;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.GetData_select_tain;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.GetData_select_tain2;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.Get_data_confirm;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.Get_data_type_check;
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
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.BagdeDrawable;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.Service;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.map.MapsActivity;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_image_new;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_uploade_Image;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.utils.ImageConfiguration;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.utils.MarshMallowPermission;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.contextmenu.ContextMenuDialogFragment;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.contextmenu.MenuObject;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.contextmenu.MenuParams;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.contextmenu.interfaces.OnMenuItemClickListener;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.contextmenu.interfaces.OnMenuItemLongClickListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
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
import tech.gusavila92.websocketclient.WebSocketClient;

import static com.tsr.tsrproblemreport_tossticket_checker.API_URL_ALL.BASE_URL;
import static com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.pen_sing.SignatureActivity.STORAGE_PERMISSION_CODE;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.map.MapsActivity.imageFile;

public class Detali_check1 extends AppCompatActivity implements View.OnClickListener,RecyclerViewDataAdapter_image1.itemclick_deleteAll_image1,RecyclerViewDataAdapter_image2.itemclick_deleteAll_image2,RecyclerViewDataAdapter_image3.itemclick_deleteAll_image3,RecyclerViewDataAdapter_image4.itemclick_deleteAll_image4,RecyclerViewDataAdapter_image5.itemclick_deleteAll_image5,RecyclerViewDataAdapter_image_map.itemclick_deleteAll_image_map,RecyclerViewDataAdapter_dialog_image_problem_from_id_checker1.itemclick_deleteAll_id_checker1,RecyclerViewDataAdapter_dialog_image_problem_from_id_checker2.itemclick_deleteAll_id_checker2,RecyclerViewDataAdapter_dialog_image_problem_from_id_checker3.itemclick_deleteAll_id_checker3,RecyclerViewDataAdapter_dialog_image_problem_from_id_checker4.itemclick_deleteAll_id_checker4,RecyclerViewDataAdapter_dialog_image_problem_from_id_checker5.itemclick_deleteAll_id_checker5,RecyclerViewDataAdapter_dialog_image_problem_from_id_checker_map.itemclick_deleteAll_id_checker_map,RecyclerViewAdapter_type_check.itemclick2, OnMenuItemClickListener, OnMenuItemLongClickListener {
    INSERT_GPS_GIS insert_gps_gis;


    RelativeLayout relat_scan,open_camera,open_camera2,open_camera3,relativeLayout_new,
            open_camera4,open_camera5,open_image,open_image2,open_image3
            ,open_image4,open_image5,location,r_save,r_save2,r_save_di,r_save_di2;
    LinearLayout li_gps,linearlayout_date_to_date,li_install_re_tain,li_retain,linearlayout_show_problem_tain,li_install_tain,li_pen,linear_pen,li1,li2,li3,li4,li5,li6,li_qr1,li7,li_pay2,li_pay2_2,li_pay1_2,li_pay1,li_who,li_install2,li_install3,li_line1234,
            li_save,li_install1,linearlayout_show_problem_sub,li_pay_one,
            li_pay_two,li_pay_two2,li_confirm,li_confirm2,li_line1,li_line2,
            li_line3,li_line4,li_line5,li_line6,li_line0,li_line7,li_line8,
            li_line9,li_remarket,li_pay2_2_2,li_line10,li_line11,li_line12,li_pay2_2_3;
    private SignaturePad objSignaturePad;
    private String signaturePath;
    String NoID="",conno="",FnYear="",FnMonth="",customer="",PayLastPeriod="",Outstanding="",ProcessTypeID="",ProductSerial="",date_install="";
    TextView txt_scan,txt_scan_assa;
    ImageView image_tal2,image_tal3,image_clear,image_pen_sing;
    ImageButton bt_scan,switcher2;
    RecyclerView my_recycler_view1,my_recycler_view2,my_recycler_view3,my_recycler_view4,my_recycler_view5,my_recycler_view_map,my_recycler_view2_2,recyclerview1;
    Spinner spDemo,spDemo1,spDemo2,spDemo3,spDemo4,spDemo5,spDemo6;
    EditText new_message_tain,new_message,new_message1,new_message2,new_message3,new_message4,new_message_home_in,new_message_scan,new_message_install,new_message_pay2,new_message_select4;
    RadioButton RadioButton_0,RadioButton_1,RadioButton_2,RadioButton_4,RadioButton_5,RadioButton_6;
    CheckBox CheckBox0,cb_pay_two;
    int CheckBox_status=0;
    RadioGroup radioSexGroup,radioSexGroup1,radioSexGroup2,radioSex_re,radioSex_retain,radioSex_con;
    private RadioButton radioButton1,radioButton2,radioButton3;
    Intent Intent;
    String VersionOSM="",AnswerID_home_in="",AnswerID_gps="",AnswerID_install="",AnswerID_who="",AnswerID_tain="",AnswerID_tain2="",TopicID_home_in="",TopicID_gps="",
            TopicID_install="",TopicID_who="",TopicID_tain="",TopicID_tain2="";

    String checkedText_confirm="",checkedText_install="",checkedText_pay_one="",radioSex_re_S="",radioSex_retain_S="",checkedText_radioSex_con="";
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
    RecyclerViewAdapter_confirm recyclerViewAdapter_confirm;
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

    List<Get_data_confirm> get_data_confirms;
    Get_data_confirm get_data_confirm;

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
    List<GetData_select_tain> getData_select_tains;
    List<GetData_select_tain2> getData_select_tains2;
    List<GetData_select_product_name> getData_select_product_names;

    List<GetData_uploade_Image> getData_uploade_images;

    JsonArrayRequest jsonArrayRequest;
    JsonObjectRequest jsonObjectRequest;
    RequestQueue requestQueue;




    Get_data_type_check getDataAdapter;
    RecyclerViewAdapter_type_check recyclerViewadapter;
    List<Get_data_type_check> get_data_type_checks;

    RecyclerView.LayoutManager recyclerViewlayoutManager;

    String item="",item1="",item2="",item3="",item4="",item5="",item6="";

    SweetAlertDialog pDialogg;
    private Service uploadService;
   // private static final String SERVER_PATH = "http://app.thiensurat.co.th/assanee/";
    private static final String SERVER_PATH = "http://thiensurat.com/fileshare02/assanee/";

    String date_s="",date2_s="",date3_s="",date22="";
    TextView date1,date2,txt_day_nad2,txt_Outstanding,txt_PayLastPeriod,date222,txt_balance;

    String data_redio1="",data_redio2="",data_redio3="",data_radioSex_con="";

    int check_nonti_web=0;
int status_report_problem_qr=0,status_report_problem_pay2=0,status_qr=0,status_pen=0;

    String date_new_format_thai,date_new_format_thai2;
    String dateThai_year,dateThai_month,dateThai_day,dateThai_month1;
    int converted_dateThai11;
    private Date oneWayTripDate,oneWayTripDate2;


    String date_new_format_thai3;
    String dateThai_year3,dateThai_month3,dateThai_day3;

    String s1,s2,s3,s4,s5,s6;
    String PayNextDate22="";

    String CHECK_PROBLEM="";

    int check_save_checker=0,select_color=0;
    TextView count1,count2,count3;
    String select_color_S="";
    int check_maker_gps=0;
    String GET_date2="";
    int check_open_dialog=0;






    int order_image1=0,order_image1_2=0,order_image2=0,order_image2_2=0,order_image3=0,order_image3_2=0,order_image4=0,order_image4_2=0,order_image5=0,order_image5_2=0,order_image_map=0,order_image_map_2=0;
    int check_buttom_remove_image1=0,check_buttom_remove_image2=0,check_buttom_remove_image3=0,check_buttom_remove_image4=0,check_buttom_remove_image5=0,check_buttom_remove_image_map=0;
    public  int size1=0,size2=0,size3=0,size4=0,size5=0,size_map=0;
    String VersionOS="";
    String conno_intro="",conno_scan="",ID_SUB="1";
    int error=0;




    private ContextMenuDialogFragment mMenuDialogFragment;
    private FragmentManager fragmentManager;
    private Fragment fragment = null;



    int[] location_LI;

    int[] location_li_gps;
    int[] location_li_scan; //li7

    int[] location_li_scan_image; //li3

    int[] location_li_install; //li_install2
    int[] location_li_install_image;//li4
    int[] location_li_remarket; //li_remarket
    int[] location_li_device_tain; //linearlayout_show_problem_tain
    int[] location_li_pay_one; //li_pay_one
    int[] location_li_pay_two;//li_pay_two
    int[] location_li_confirm; //li_confirm
    int[] location_li_pen;//li_pen

    ScrollView scrollView;

    LinearLayout lili_1,lili_2,lili_3,lili_line1,lili_line2,lili_text_select4,li_line13,li_conveniently;
    int check_cb_pay_two=0;
 TextView txt_concon;

 int problem1=0,problem2=0,problem3=0,problem4=0,problem5=0,problem6=0,problem7=0,problem8=0,problem9=0,problem10=0;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_check_for_1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        //VersionOSM = MyApplication.getInstance().getPrefManager().getPreferrence("VersionOS");

        VersionOSM = android.os.Build.VERSION.RELEASE;

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
        li_install_tain= (LinearLayout) findViewById(R.id.li_install_tain);

        linearlayout_show_problem_tain= (LinearLayout) findViewById(R.id.linearlayout_show_problem_tain);

        my_recycler_view2_2= (RecyclerView) findViewById(R.id.my_recycler_view2_2);
        recyclerview1= (RecyclerView) findViewById(R.id.recyclerview1);



        spDemo= (Spinner) findViewById(R.id.spDemo);
        spDemo1= (Spinner) findViewById(R.id.spDemo1);
        spDemo2= (Spinner) findViewById(R.id.spDemo2);
        spDemo3= (Spinner) findViewById(R.id.spDemo3);
        spDemo4= (Spinner) findViewById(R.id.spDemo4);

        spDemo5= (Spinner) findViewById(R.id.spDemo5);
        spDemo6= (Spinner) findViewById(R.id.spDemo6);

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

        radioSex_re = (RadioGroup) findViewById(R.id.radioSex_re);
        radioSex_retain= (RadioGroup) findViewById(R.id.radioSex_retain);

        radioSex_con= (RadioGroup) findViewById(R.id.radioSex_con);

        new_message= (EditText) findViewById(R.id.new_message);
        new_message1= (EditText) findViewById(R.id.new_message1);
        new_message2= (EditText) findViewById(R.id.new_message2);
        new_message3= (EditText) findViewById(R.id.new_message3);

        new_message_home_in= (EditText) findViewById(R.id.new_message_home_in);
        new_message_scan= (EditText) findViewById(R.id.new_message_scan);
        new_message_install= (EditText) findViewById(R.id.new_message_install);

        new_message_pay2= (EditText) findViewById(R.id.new_message_pay2);
        new_message_tain= (EditText) findViewById(R.id.new_message_tain);

        new_message_select4= (EditText) findViewById(R.id.new_message_select4);
        //new_message4= (EditText) findViewById(R.id.new_message4);

        r_save= (RelativeLayout) findViewById(R.id.r_save);
        r_save2= (RelativeLayout) findViewById(R.id.r_save2);

        image_tal2= (ImageView) findViewById(R.id.image_tal2);
        image_tal3= (ImageView) findViewById(R.id.image_tal3);
        image_clear= (ImageView) findViewById(R.id.image_clear);
        image_pen_sing= (ImageView) findViewById(R.id.image_pen_sing);
        date1= (TextView) findViewById(R.id.date1);
        date2= (TextView) findViewById(R.id.date2);


         GET_date2 = date2.getText().toString();

       // size2=1;

        txt_day_nad2= (TextView) findViewById(R.id.txt_day_nad2);
        txt_Outstanding= (TextView) findViewById(R.id.txt_Outstanding);
        txt_PayLastPeriod= (TextView) findViewById(R.id.PayLastPeriod);
        date222= (TextView) findViewById(R.id.date222);
        txt_balance= (TextView) findViewById(R.id.txt_balance);

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

        li_pay1= (LinearLayout) findViewById(R.id.li_pay1);
        li_pay1_2= (LinearLayout) findViewById(R.id.li_pay1_2);
        li_who= (LinearLayout) findViewById(R.id.li_who);

        li_install2= (LinearLayout) findViewById(R.id.li_install2);
        li_install3= (LinearLayout) findViewById(R.id.li_install3);



        li_pay2_2_2= (LinearLayout) findViewById(R.id.li_pay2_2_2);
        li_line10= (LinearLayout) findViewById(R.id.li_line10);
        li_line11= (LinearLayout) findViewById(R.id.li_line11);
        li_line12= (LinearLayout) findViewById(R.id.li_line12);
        li_pay2_2_3= (LinearLayout) findViewById(R.id.li_pay2_2_3);




        li_install1= (LinearLayout) findViewById(R.id.li_install1);
        linearlayout_show_problem_sub= (LinearLayout) findViewById(R.id.linearlayout_show_problem_sub);
        li_pay_one= (LinearLayout) findViewById(R.id.li_pay_one);
        li_pay_two= (LinearLayout) findViewById(R.id.li_pay_two);
        li_pay_two2= (LinearLayout) findViewById(R.id.li_pay_two2);
        li_confirm= (LinearLayout) findViewById(R.id.li_confirm);
        li_confirm2= (LinearLayout) findViewById(R.id.li_confirm2);

        li_line0= (LinearLayout) findViewById(R.id.li_line0);
        li_line1= (LinearLayout) findViewById(R.id.li_line1);
        li_line2= (LinearLayout) findViewById(R.id.li_line2);
        li_line3= (LinearLayout) findViewById(R.id.li_line3);
        li_line4= (LinearLayout) findViewById(R.id.li_line4);
        li_line5= (LinearLayout) findViewById(R.id.li_line5);
        li_line6= (LinearLayout) findViewById(R.id.li_line6);
        li_save= (LinearLayout) findViewById(R.id.li_save);
        li_line1234= (LinearLayout) findViewById(R.id.li_line1234);
        li_pen= (LinearLayout) findViewById(R.id.li_pen);

        txt_scan_assa= (TextView) findViewById(R.id.txt_scan_assa);
        li_line7= (LinearLayout) findViewById(R.id.li_line7);
        li_line8= (LinearLayout) findViewById(R.id.li_line8);
        li_line9= (LinearLayout) findViewById(R.id.li_line9);
        li_remarket= (LinearLayout) findViewById(R.id.li_remarket);
        li_retain= (LinearLayout) findViewById(R.id.li_retain);
        li_install_re_tain= (LinearLayout) findViewById(R.id.li_install_re_tain);
        relativeLayout_new= (RelativeLayout) findViewById(R.id.relativeLayout_new);
        linearlayout_date_to_date= (LinearLayout) findViewById(R.id.linearlayout_date_to_date);
        li_gps= (LinearLayout) findViewById(R.id.li_gps);

          count1=(TextView)findViewById(R.id.count1);
          count2=(TextView)findViewById(R.id.count2);
          count3=(TextView)findViewById(R.id.count3);


        lili_1= (LinearLayout) findViewById(R.id.lili_1);
        lili_2= (LinearLayout) findViewById(R.id.lili_2);
        lili_3= (LinearLayout) findViewById(R.id.lili_3);
        lili_line1= (LinearLayout) findViewById(R.id.lili_line1);
        lili_line2= (LinearLayout) findViewById(R.id.lili_line2);
        lili_text_select4= (LinearLayout) findViewById(R.id.lili_text_select4);

        li_conveniently= (LinearLayout) findViewById(R.id.li_conveniently);
        li_line13= (LinearLayout) findViewById(R.id.li_line13);

        txt_concon=(TextView)findViewById(R.id.txt_concon);

      cb_pay_two= (CheckBox) findViewById(R.id.cb_pay_two);
        MyApplication.getInstance().getPrefManager().setPreferrence("check_cb_pay_two", "0");
        cb_pay_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 cb_pay_two = (CheckBox)v;
                if(cb_pay_two.isChecked()){
                    check_cb_pay_two=1;
                    MyApplication.getInstance().getPrefManager().setPreferrence("check_cb_pay_two", "1");
                 //Log.e("checkbox","1");
                 //  txt_day_nad2.setVisibility(View.GONE);
                    txt_day_nad2.setText("");
                    GET_date2="ok";
                    txt_day_nad2.setVisibility(View.GONE);
                    li_pay2.setBackgroundColor(0xffffffff);
                    date2.setText("-");
                }
                else {
                    check_cb_pay_two=0;
                    MyApplication.getInstance().getPrefManager().setPreferrence("check_cb_pay_two", "0");
                    Log.e("checkbox","2");
                    txt_day_nad2.setVisibility(View.GONE);
                    GET_date2="-";

                }
            }
        });



 /*       try {
            String ddd=   MyApplication.getInstance().getPrefManager().getPreferrence("check_cb_pay_two")+"";
            if(!ddd.equals("null")){
                cb_pay_two.setChecked(!cb_pay_two.isChecked());
            }

        }
        catch (Exception ex){

        }*/



try {
    String S_new_message_home_in=   MyApplication.getInstance().getPrefManager().getPreferrence("new_message_home_in")+"";
    if(!S_new_message_home_in.equals("null")){
        new_message_home_in.setText(S_new_message_home_in);
    }

}
catch (Exception ex){

}





        try {
            String S_new_message_scan=   MyApplication.getInstance().getPrefManager().getPreferrence("new_message_scan")+"";
            if(!S_new_message_scan.equals("null")){
                new_message_scan.setText(S_new_message_scan);
            }

        }
        catch (Exception ex){

        }



        try {
            String S_new_message_install=   MyApplication.getInstance().getPrefManager().getPreferrence("new_message_install")+"";
            if(!S_new_message_install.equals("null")){
                new_message_install.setText(S_new_message_install);
            }

        }
        catch (Exception ex){

        }



        try {
            String S_new_message_tain=   MyApplication.getInstance().getPrefManager().getPreferrence("new_message_tain")+"";
            if(!S_new_message_tain.equals("null")){
                new_message_tain.setText(S_new_message_tain);
            }

        }
        catch (Exception ex){

        }




        try {
            String S_new_message1=   MyApplication.getInstance().getPrefManager().getPreferrence("new_message1")+"";
            if(!S_new_message1.equals("null")){
                new_message1.setText(S_new_message1);
            }

        }
        catch (Exception ex){

        }




        try {
            String S_new_message=   MyApplication.getInstance().getPrefManager().getPreferrence("new_message")+"";
            if(!S_new_message.equals("null")){
                new_message.setText(S_new_message);
            }

        }
        catch (Exception ex){

        }













        count1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                count1.setText("✔");count2.setText("");count3.setText("");
                //color=0xfff40707;
                select_color=1;
                select_color_S="03";
                if(select_color!=0){
                    li_line8.setBackgroundColor(0xffffffff);
                }
            }
        });
        count2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                count1.setText("");count2.setText("✔");count3.setText("");
                //color=0xfffcc7c7;
                select_color=2;
                select_color_S="02";
                if(select_color!=0){
                    li_line8.setBackgroundColor(0xffffffff);
                }
            }
        });
        count3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                count1.setText("");count2.setText("");count3.setText("✔");
                //color=0xff808080;
                select_color=3;
                select_color_S="01";
                if(select_color!=0){
                    li_line8.setBackgroundColor(0xffffffff);
                }
            }
        });






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
        getData_select_tains=new ArrayList<>();
        getData_select_tains2=new ArrayList<>();
        get_data_confirms=new ArrayList<>();
        get_data_type_checks=new ArrayList<>();
        getData_select_product_names=new ArrayList<>();

        bt_scan.setOnClickListener(this);
        txt_scan.setOnClickListener(this);

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

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(Calendar.getInstance().getTime());

        DateFormat df3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date3 = df3.format(Calendar.getInstance().getTime());


        try {
          String fgd = MyApplication.getInstance().getPrefManager().getPreferrence("checkedText_pay_two_nad_install")+"";
          if(!fgd.equals("null")){
              PayNextDate22=fgd;
          }
        }
        catch (Exception ex){

        }

        Log.e("PayNextDate", PayNextDate22);

        date1.setText(date);









































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




                try {

                    String DD=MyApplication.getInstance().getPrefManager().getPreferrence("checkedText_pay_two");
                    if(!DD.equals("null")){
                         date2.setText(DD);   // ปิด defulr ค่าเริ่มต้นไว้

                    }



                }
                catch (Exception ex){

                }



            }
        } catch (Exception ex) {

        }









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




        my_recycler_view2_2.setHasFixedSize(true);
        RecyclerViewAdapter_confirm adapter_confirm = new RecyclerViewAdapter_confirm( get_data_confirms,this);
        my_recycler_view2_2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        my_recycler_view2_2.setAdapter(adapter_confirm);



       // view_data_size();


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

            NoID=data.getString("NoID");
            conno=data.getString("conno");
            FnYear=data.getString("FnYear");
            FnMonth=data.getString("FnMonth");
            customer=data.getString("customer");

            Outstanding=data.getString("Outstanding");
            PayLastPeriod=data.getString("PayLastPeriod");

           // ProcessTypeID=data.getString("ProcessTypeID");
            ProductSerial=data.getString("ProductSerial");
            date_install=data.getString("date");
            //txt_Outstanding.setText(MyApplication.getInstance().getPrefManager().getPreferrence("Outstanding_cf"));
            txt_PayLastPeriod.setText(MyApplication.getInstance().getPrefManager().getPreferrence("PayLastPeriod_cf"));

            //Log.e("FnYear",FnYear);
            Log.e("NoID",NoID);

        }

      check_box3();
      check_box1();
      check_box4();
      check_box2();
      check_box5();
      check_box_new1();




















        txt_day_nad2.setVisibility(View.VISIBLE);

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








            SimpleDateFormat input44= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat output44 = new SimpleDateFormat("yyyy-MM-dd");

            try {
                oneWayTripDate2 = input44.parse(date_install);  // parse input

            } catch (ParseException e) {
                e.printStackTrace();
            }

try {
    date_install=output44.format(oneWayTripDate2);
}
catch (Exception ex){

}


   //     date_install


      //  String dateBeforeString =date_install;
       // String dateAfterString = date3_s;









        try {


            //  Log.e("date_new_format_thai", date_new_format_thai);


            if (date_install.indexOf(date_install) != -1) {
                String arr2[] = date_install.split("-");
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













        String dateBeforeString =date3_s;
        String dateAfterString = date_install;


        try {




            String DDCSa= MyApplication.getInstance().getPrefManager().getPreferrence("checkedText_pay_two_nad_install")+"";

            if(!DDCSa.equals("null")){

                dateBeforeString=DDCSa;


          /*      SimpleDateFormat input333= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat output333 = new SimpleDateFormat("yyyy-MM-dd");

                try {
                    oneWayTripDate2 = input333.parse(DDCSa);  // parse input

                } catch (ParseException e) {
                    e.printStackTrace();
                }

                try {
                    dateBeforeString=output44.format(oneWayTripDate2);
                   // dateBeforeString=DDCSa;
                }
                catch (Exception ex){

                }*/








            }
            Log.e("date_install_55",DDCSa);
        }
        catch (Exception ex){

        }




        Log.e("dateBeforeString",dateBeforeString+dateAfterString);

        //Parsing the date
        LocalDate dateBefore = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            try {
                dateBefore = LocalDate.parse(dateBeforeString);
            }
            catch (Exception ex){

            }

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
            getCountOfDays(dateBeforeString,dateAfterString);
        }
        catch (Exception ex){

        }

        //getCountOfDays(dateAfterString,dateBeforeString);













        try {
           // String checkedText_install_ONBACK = MyApplication.getInstance().getPrefManager().getPreferrence("checkedText_install") + "";
            String item_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("item")+"";
            if ((!item_ONBACK.equals("null"))&(!item_ONBACK.equals("คอนโดมิเนียม"))) {
                SELECT_DATA_PROBLEM_GORY_save_back(item_ONBACK);
            }
            else {
                SELECT_DATA_PROBLEM_GORY();
            }

        }
        catch (Exception ex){
            SELECT_DATA_PROBLEM_GORY();
        }









        try {
            // String checkedText_install_ONBACK = MyApplication.getInstance().getPrefManager().getPreferrence("checkedText_install") + "";
            String item1_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("item1")+"";
            if ((!item1_ONBACK.equals("null"))&(!item1_ONBACK.equals("ปักหมุด"))) {
                SELECT_DATA_PROBLEM_GORY1_save_back(item1_ONBACK);
            }
            else {
                SELECT_DATA_PROBLEM_GORY1();
            }

        }
        catch (Exception ex){
            SELECT_DATA_PROBLEM_GORY1();
        }








        try {
            // String checkedText_install_ONBACK = MyApplication.getInstance().getPrefManager().getPreferrence("checkedText_install") + "";
            String item3_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("item3")+"";
            if ((!item3_ONBACK.equals("null"))&(!item3_ONBACK.equals("ผู้ซื้อ"))) {
                SELECT_DATA_PROBLEM_GORY3_save_back(item3_ONBACK);
            }
            else {
                SELECT_DATA_PROBLEM_GORY3();
            }

        }
        catch (Exception ex){
            SELECT_DATA_PROBLEM_GORY3();
        }






        SELECT_DATA_PROBLEM_GORY2();








        try {
            // String checkedText_install_ONBACK = MyApplication.getInstance().getPrefManager().getPreferrence("checkedText_install") + "";
            String item5_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("item5")+"";
            if ((!item5_ONBACK.equals("null"))&(!item5_ONBACK.equals("P5"))) {
                SELECT_DATA_PROBLEM_TAIN_save_back(item5_ONBACK);
            }
            else {
                SELECT_DATA_PROBLEM_TAIN();
            }

        }
        catch (Exception ex){
            SELECT_DATA_PROBLEM_TAIN();
    }







        try {
            // String checkedText_install_ONBACK = MyApplication.getInstance().getPrefManager().getPreferrence("checkedText_install") + "";
            String item6_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("item6")+"";
            if ((!item6_ONBACK.equals("null"))&(!item6_ONBACK.equals("ช่วงเช้า"))) {
                SELECT_DATA_PROBLEM_TAIN2_save_back(item6_ONBACK);
            }
            else {
                SELECT_DATA_PROBLEM_TAIN2();
            }

        }
        catch (Exception ex){
            SELECT_DATA_PROBLEM_TAIN2();
        }






        SELECT_DATA_CONFIRM();
        SELECT_DATA_CONFIRM2();
















        view_data_size();

        try {
            String S_image_pen_sing=   MyApplication.getInstance().getPrefManager().getPreferrence("image_pen_sing")+"";
            String S_signaturePath=   MyApplication.getInstance().getPrefManager().getPreferrence("signaturePath")+"";
            if(!S_image_pen_sing.equals("null")){

                image_pen_sing.setVisibility(View.VISIBLE);
                image_pen_sing.setImageURI(Uri.parse("file://"+S_signaturePath));
                status_pen=1;
            }

        }
        catch (Exception ex){

        }



        try {
            String S_scan_barcode=   MyApplication.getInstance().getPrefManager().getPreferrence("scan_barcode")+"";
            String S_status_qr=   MyApplication.getInstance().getPrefManager().getPreferrence("status_qr")+"";

            if(!S_scan_barcode.equals("null")){

                if(!S_status_qr.equals("null")){

                    if(S_status_qr.equals("1")){
                        switcher2.setImageResource(R.drawable.errorerror);
                        switcher2.setVisibility(View.VISIBLE);
                        txt_scan.setText("หมายเลขไม่ตรงกัน "+ProductSerial+":"+conno_scan);
                        txt_scan.setTextColor(0xfff40707);

                        error=0;

                        li3.setVisibility(View.VISIBLE);
                        li_qr1.setVisibility(View.VISIBLE);
                        status_report_problem_qr=1;


                        status_qr=0;
                        Log.e("size1", String.valueOf(size1));
                        if(size1==0){

                            li3.setBackgroundColor(0xffff0000);
                        }
                        else {
                            li3.setBackgroundColor(0xffffffff);
                        }


                        //color_error();
                    }
                    else {
                        switcher2.setImageResource(R.drawable.check_box_report_problem);
                        switcher2.setVisibility(View.VISIBLE);
                        txt_scan.setText("หมายเลขตรงกัน "+ProductSerial+":"+conno_scan);
                        txt_scan.setTextColor(0xff66cdaa);
                        error=1;

                        li3.setVisibility(View.GONE);
                        li_qr1.setVisibility(View.GONE);

                        status_report_problem_qr=0;
                        // color_error();
                        status_qr=0;
                        li3.setBackgroundColor(0xffffffff);
                    }


                }
            }

        }
        catch (Exception ex){

        }




















        try {


            String S_NAD_DATE=   MyApplication.getInstance().getPrefManager().getPreferrence("checkedText_pay_two_nad")+"";
            Log.e("S_NAD_DATE",S_NAD_DATE);
            String FDD=date2.getText().toString();
            Log.e("FDDFDD",FDD);
            if(!FDD.equals("-")){
                int dayday= Integer.parseInt(S_NAD_DATE);

                GET_date2=S_NAD_DATE;

                if(dayday>60){



                    txt_day_nad2.setVisibility(View.VISIBLE);
                    li_pay2.setBackgroundColor(0xffffffff);


                    txt_day_nad2.setText(" "+String.valueOf(dayday)+" วัน");

                    txt_day_nad2.setTextColor(0xffff0000);
                    status_report_problem_pay2=1;

                }



                else {



                    txt_day_nad2.setVisibility(View.VISIBLE);
                    li_pay2.setBackgroundColor(0xffffffff);




                    txt_day_nad2.setText(" "+String.valueOf(dayday)+" วัน");
                    txt_day_nad2.setTextColor(0xff228b22);
                    status_report_problem_pay2=0;


                }
                //  txt_day_nad2.setVisibility(View.GONE);
            }





            else {
                txt_day_nad2.setVisibility(View.GONE);
            }

        }
        catch (Exception ex){

        }


















        fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //initMenuFragment();


         scrollView= (ScrollView) findViewById(R.id.ScrollView);





     /*   scrollView.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),"Current Y is : "+scrollView.getScrollY(), Toast.LENGTH_SHORT).show();
            }
        });

        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                int scrollX = scrollView.getScrollX();
                Log.d(TAG, "scrollX: " + scrollX);
            }
        });
*/

        scrollView.post(new Runnable(){

            @Override
            public void run() {
                ViewTreeObserver observer = scrollView.getViewTreeObserver();
                observer.addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener(){

                    @Override
                    public void onScrollChanged() {
                        int scrollX = scrollView.getScrollX();
                        int scrollY = scrollView.getScrollY();

                        Log.e("location_LI", String.valueOf(scrollX+","+scrollY));
                       // Log.e("location_li_pen", String.valueOf(location_li_pen[0]+location_li_pen[1]));

                    }});
            }});


    }




    private void check_box3(){





        try {

            // String radioSex_re_S_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("radioSex_re_S")+"";
            //String checkedText_pay_one_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("checkedText_pay_one")+"";






            String checkedText_install_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("radioSex_retain_S")+"";


           // MyApplication.getInstance().getPrefManager().setPreferrence("radioSex_retain_S", checkedText_install_ONBACK);

            Log.e("install_ONBACK3",checkedText_install_ONBACK);

            if(!checkedText_install_ONBACK.equals("null")){
                if(checkedText_install_ONBACK.equals("มี")){
                    Log.e("install_ONBACK","0000");

                    ((RadioButton)radioSex_retain.getChildAt(1)).setChecked(true);
                    ((RadioButton)radioSex_retain.getChildAt(0)).setChecked(false);

                    radioSex_retain_S  = checkedText_install_ONBACK;
                    //data_redio1=checkedText_pay_one;

                    if (!radioSex_retain_S.isEmpty()){
                        li_retain.setBackgroundColor(0xffffffff);
                    }


                    if (radioSex_retain_S.equals("มี")) {

                        li_install_re_tain.setVisibility(View.VISIBLE);
                        // li_install_tain.setVisibility(View.VISIBLE);
                    } else {
                        li_install_re_tain.setVisibility(View.GONE);
                        // li_install_tain.setVisibility(View.GONE);

                    }



















                    radioSex_retain.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                                 {
                                                                     public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                                     {
                                                                         RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );


                                                                         //  checkedText_install  = checkedRadio.getText ( ).toString ( );
                                                                         radioSex_retain_S  = checkedRadio.getText ( ).toString ( );
                                                                         //data_redio1=checkedText_pay_one;

                                                                         if (!radioSex_retain_S.isEmpty()){
                                                                             li_retain.setBackgroundColor(0xffffffff);
                                                                         }


                                                                         if (radioSex_retain_S.equals("มี")) {

                                                                             li_install_re_tain.setVisibility(View.VISIBLE);
                                                                             // li_install_tain.setVisibility(View.VISIBLE);


                                                                             SELECT_DATA_PROBLEM_TAIN();
                                                                         } else {
                                                                             li_install_re_tain.setVisibility(View.GONE);
                                                                             // li_install_tain.setVisibility(View.GONE);

                                                                         }

                                                                     }
                                                                 }
                    );












                }
                else if(checkedText_install_ONBACK.equals("ไม่มี")){
                    Log.e("install_ONBACK","1111");

                    ((RadioButton)radioSex_retain.getChildAt(0)).setChecked(true);
                    ((RadioButton)radioSex_retain.getChildAt(1)).setChecked(false);

                    radioSex_retain_S  = checkedText_install_ONBACK;
                    //data_redio1=checkedText_pay_one;

                    if (!radioSex_retain_S.isEmpty()){
                        li_retain.setBackgroundColor(0xffffffff);
                    }


                    if (radioSex_retain_S.equals("มี")) {

                        li_install_re_tain.setVisibility(View.VISIBLE);
                        // li_install_tain.setVisibility(View.VISIBLE);
                    } else {
                        li_install_re_tain.setVisibility(View.GONE);
                        // li_install_tain.setVisibility(View.GONE);

                    }

































                    radioSex_retain.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                                 {
                                                                     public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                                     {
                                                                         RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );


                                                                         //  checkedText_install  = checkedRadio.getText ( ).toString ( );
                                                                         radioSex_retain_S  = checkedRadio.getText ( ).toString ( );
                                                                         //data_redio1=checkedText_pay_one;

                                                                         if (!radioSex_retain_S.isEmpty()){
                                                                             li_retain.setBackgroundColor(0xffffffff);
                                                                         }


                                                                         if (radioSex_retain_S.equals("มี")) {

                                                                             li_install_re_tain.setVisibility(View.VISIBLE);
                                                                             // li_install_tain.setVisibility(View.VISIBLE);

                                                                             SELECT_DATA_PROBLEM_TAIN();
                                                                         } else {
                                                                             li_install_re_tain.setVisibility(View.GONE);
                                                                             // li_install_tain.setVisibility(View.GONE);

                                                                         }

                                                                     }
                                                                 }
                    );














                }

                else {

                    Log.e("install_ONBACK","2222");

                    ((RadioButton)radioSex_retain.getChildAt(1)).setChecked(false);
                    ((RadioButton)radioSex_retain.getChildAt(0)).setChecked(false);







                    radioSex_retain_S  = checkedText_install_ONBACK;
                    //data_redio1=checkedText_pay_one;

                    if (!radioSex_retain_S.isEmpty()){
                        li_retain.setBackgroundColor(0xffffffff);
                    }


                    if (radioSex_retain_S.equals("มี")) {

                        li_install_re_tain.setVisibility(View.VISIBLE);
                        // li_install_tain.setVisibility(View.VISIBLE);
                    } else {
                        li_install_re_tain.setVisibility(View.GONE);
                        // li_install_tain.setVisibility(View.GONE);

                    }












                    radioSex_retain.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                                 {
                                                                     public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                                     {
                                                                         RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );


                                                                         //  checkedText_install  = checkedRadio.getText ( ).toString ( );
                                                                         radioSex_retain_S  = checkedRadio.getText ( ).toString ( );
                                                                         //data_redio1=checkedText_pay_one;

                                                                         if (!radioSex_retain_S.isEmpty()){
                                                                             li_retain.setBackgroundColor(0xffffffff);
                                                                         }


                                                                         if (radioSex_retain_S.equals("มี")) {

                                                                             li_install_re_tain.setVisibility(View.VISIBLE);
                                                                             // li_install_tain.setVisibility(View.VISIBLE);

                                                                             SELECT_DATA_PROBLEM_TAIN();
                                                                         } else {


                                                                             li_install_re_tain.setVisibility(View.GONE);
                                                                             // li_install_tain.setVisibility(View.GONE);

                                                                         }

                                                                     }
                                                                 }
                    );











                }

            }
            else {





                Log.e("install_ONBACK","4444");







                radioSex_retain.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                             {
                                                                 public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                                 {
                                                                     RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );


                                                                     //  checkedText_install  = checkedRadio.getText ( ).toString ( );
                                                                     radioSex_retain_S  = checkedRadio.getText ( ).toString ( );
                                                                     //data_redio1=checkedText_pay_one;

                                                                     if (!radioSex_retain_S.isEmpty()){
                                                                         li_retain.setBackgroundColor(0xffffffff);
                                                                     }


                                                                     if (radioSex_retain_S.equals("มี")) {

                                                                         li_install_re_tain.setVisibility(View.VISIBLE);
                                                                         // li_install_tain.setVisibility(View.VISIBLE);
                                                                         SELECT_DATA_PROBLEM_TAIN();
                                                                     } else {
                                                                         li_install_re_tain.setVisibility(View.GONE);
                                                                         // li_install_tain.setVisibility(View.GONE);

                                                                     }

                                                                 }
                                                             }
                );










            }
        }
        catch (Exception ex){



            radioSex_retain.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                         {
                                                             public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                             {
                                                                 RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );


                                                                 //  checkedText_install  = checkedRadio.getText ( ).toString ( );
                                                                 radioSex_retain_S  = checkedRadio.getText ( ).toString ( );
                                                                 //data_redio1=checkedText_pay_one;

                                                                 if (!radioSex_retain_S.isEmpty()){
                                                                     li_retain.setBackgroundColor(0xffffffff);
                                                                 }


                                                                 if (radioSex_retain_S.equals("มี")) {

                                                                     li_install_re_tain.setVisibility(View.VISIBLE);
                                                                     // li_install_tain.setVisibility(View.VISIBLE);
                                                                     SELECT_DATA_PROBLEM_TAIN();
                                                                 } else {
                                                                     li_install_re_tain.setVisibility(View.GONE);
                                                                     // li_install_tain.setVisibility(View.GONE);

                                                                 }

                                                             }
                                                         }
            );


        }
    }










    private void check_box4(){





        try {

            // String radioSex_re_S_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("radioSex_re_S")+"";
            //String checkedText_pay_one_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("checkedText_pay_one")+"";






            String checkedText_install_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("checkedText_pay_one")+"";


            //MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_one", checkedText_install_ONBACK);

            Log.e("install_ONBACK4",checkedText_install_ONBACK);

            if(!checkedText_install_ONBACK.equals("null")){
                if(checkedText_install_ONBACK.equals("ยังไม่ชำระ")){
                    ((RadioButton)radioSexGroup.getChildAt(1)).setChecked(true);
                    ((RadioButton)radioSexGroup.getChildAt(0)).setChecked(false);


                    checkedText_pay_one  = checkedText_install_ONBACK;

                    data_redio2=checkedText_pay_one;

                    if (!data_redio2.isEmpty()){

                        li_pay_one.setBackgroundColor(0xffffffff);
                    }



















                    radioSexGroup.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                               {
                                                                   public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                                   {
                                                                       RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );


                                                                       //  checkedText_install  = checkedRadio.getText ( ).toString ( );
                                                                       checkedText_pay_one  = checkedRadio.getText ( ).toString ( );

                                                                       data_redio2=checkedText_pay_one;

                                                                       if (!data_redio2.isEmpty()){

                                                                           li_pay_one.setBackgroundColor(0xffffffff);
                                                                       }








                                                                   }
                                                               }
                    );












                }
                else if(checkedText_install_ONBACK.equals("ชำระแล้ว")){
                    ((RadioButton)radioSexGroup.getChildAt(0)).setChecked(true);
                    ((RadioButton)radioSexGroup.getChildAt(1)).setChecked(false);

                    checkedText_pay_one  = checkedText_install_ONBACK;

                    data_redio2=checkedText_pay_one;

                    if (!data_redio2.isEmpty()){

                        li_pay_one.setBackgroundColor(0xffffffff);
                    }

































                    radioSexGroup.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                               {
                                                                   public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                                   {
                                                                       RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );


                                                                       //  checkedText_install  = checkedRadio.getText ( ).toString ( );
                                                                       checkedText_pay_one  = checkedRadio.getText ( ).toString ( );

                                                                       data_redio2=checkedText_pay_one;

                                                                       if (!data_redio2.isEmpty()){

                                                                           li_pay_one.setBackgroundColor(0xffffffff);
                                                                       }








                                                                   }
                                                               }
                    );














                }
                else {
                    ((RadioButton)radioSexGroup.getChildAt(1)).setChecked(false);
                    ((RadioButton)radioSexGroup.getChildAt(0)).setChecked(false);







                    checkedText_pay_one  = checkedText_install_ONBACK;

                    data_redio2=checkedText_pay_one;

                    if (!data_redio2.isEmpty()){

                        li_pay_one.setBackgroundColor(0xffffffff);
                    }











                    radioSexGroup.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                               {
                                                                   public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                                   {
                                                                       RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );


                                                                       //  checkedText_install  = checkedRadio.getText ( ).toString ( );
                                                                       checkedText_pay_one  = checkedRadio.getText ( ).toString ( );

                                                                       data_redio2=checkedText_pay_one;

                                                                       if (!data_redio2.isEmpty()){

                                                                           li_pay_one.setBackgroundColor(0xffffffff);
                                                                       }








                                                                   }
                                                               }
                    );











                }

            }
            else {













                radioSexGroup.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                           {
                                                               public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                               {
                                                                   RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );


                                                                   //  checkedText_install  = checkedRadio.getText ( ).toString ( );
                                                                   checkedText_pay_one  = checkedRadio.getText ( ).toString ( );

                                                                   data_redio2=checkedText_pay_one;

                                                                   if (!data_redio2.isEmpty()){

                                                                       li_pay_one.setBackgroundColor(0xffffffff);
                                                                   }








                                                               }
                                                           }
                );










            }
        }
        catch (Exception ex){



            radioSexGroup.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                       {
                                                           public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                           {
                                                               RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );


                                                               //  checkedText_install  = checkedRadio.getText ( ).toString ( );
                                                               checkedText_pay_one  = checkedRadio.getText ( ).toString ( );

                                                               data_redio2=checkedText_pay_one;

                                                               if (!data_redio2.isEmpty()){

                                                                   li_pay_one.setBackgroundColor(0xffffffff);
                                                               }








                                                           }
                                                       }
            );


        }
    }















    private void check_box5(){





        try {

            // String radioSex_re_S_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("radioSex_re_S")+"";
            //String checkedText_pay_one_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("checkedText_pay_one")+"";






            String checkedText_install_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("checkedText_confirm")+"";


          //  MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_confirm", checkedText_install_ONBACK);

            Log.e("install_ONBACK5",checkedText_install_ONBACK);

            if(!checkedText_install_ONBACK.equals("null")){
                if(checkedText_install_ONBACK.equals("ไม่ถูกต้อง")){
                    ((RadioButton)radioSexGroup2.getChildAt(1)).setChecked(true);
                    ((RadioButton)radioSexGroup2.getChildAt(0)).setChecked(false);




                    checkedText_confirm  = checkedText_install_ONBACK;
                    data_redio3=checkedText_confirm;
                    if (!data_redio3.isEmpty()){
                        li_confirm.setBackgroundColor(0xffffffff);
                    }


                    if(checkedText_confirm.equals("ไม่ถูกต้อง")){
                        li6.setVisibility(View.VISIBLE);
                        linear_pen.setVisibility(View.VISIBLE);

                        SQLiteDataBaseBuild_data_checker_problem_for_report();
                        SQLiteTableBuild_data_checker_problem_for_report();
                        String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + " (CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID) VALUES('" + conno + "','" + "ปัญหาการ์ดตรวจสอบ" + "','" + "ระยะเวลาการผ่อน" + "','" + "ไม่ถูกต้อง" + "','" + new_message_scan.getText().toString() + "','" + "ตรวจสอบได้ เข้าบ้านลูกค้าได้" + "');";
                        //    String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + " (CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID,ProblemID) VALUES('" + conno + "','" + "ปัญหาการ์ดตรวจสอบ" + "','" + "ลูกค้านัดเกินกำหนด" + "','" + "เกิน 45 วัน" + "','" + NNN + "','" + "ตรวจสอบได้ เข้าบ้านลูกค้าได้" + "','" + "14" + "');";
                        try {
                            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
                        }
                        catch (Exception ex){

                        }

                    }
                    else {
                        linear_pen.setVisibility(View.VISIBLE);
                        li6.setVisibility(View.GONE);


                        SQLiteDataBaseBuild_data_checker_problem_for_report();
                        SQLiteTableBuild_data_checker_problem_for_report();
                        sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + "" + " WHERE MAIN =" + "'" + "ระยะเวลาการผ่อน" + "'");



                    }

















                    radioSexGroup2.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                                {
                                                                    public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                                    {
                                                                        RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );

                                                                        // String checkedText = checkedRadio.getText ( ).toString ( );
                                                                        checkedText_confirm  = checkedRadio.getText ( ).toString ( );
                                                                        data_redio3=checkedText_confirm;
                                                                        if (!data_redio3.isEmpty()){
                                                                            li_confirm.setBackgroundColor(0xffffffff);
                                                                        }


                                                                        if(checkedText_confirm.equals("ไม่ถูกต้อง")){
                                                                            li6.setVisibility(View.VISIBLE);
                                                                            linear_pen.setVisibility(View.VISIBLE);

                                                                            SQLiteDataBaseBuild_data_checker_problem_for_report();
                                                                            SQLiteTableBuild_data_checker_problem_for_report();
                                                                            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + " (CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID) VALUES('" + conno + "','" + "ปัญหาการ์ดตรวจสอบ" + "','" + "ระยะเวลาการผ่อน" + "','" + "ไม่ถูกต้อง" + "','" + new_message_scan.getText().toString() + "','" + "ตรวจสอบได้ เข้าบ้านลูกค้าได้" + "');";
                                                                            //    String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + " (CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID,ProblemID) VALUES('" + conno + "','" + "ปัญหาการ์ดตรวจสอบ" + "','" + "ลูกค้านัดเกินกำหนด" + "','" + "เกิน 45 วัน" + "','" + NNN + "','" + "ตรวจสอบได้ เข้าบ้านลูกค้าได้" + "','" + "14" + "');";
                                                                            try {
                                                                                sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
                                                                            }
                                                                            catch (Exception ex){

                                                                            }

                                                                        }
                                                                        else {
                                                                            linear_pen.setVisibility(View.VISIBLE);
                                                                            li6.setVisibility(View.GONE);


                                                                            SQLiteDataBaseBuild_data_checker_problem_for_report();
                                                                            SQLiteTableBuild_data_checker_problem_for_report();
                                                                            sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + "" + " WHERE MAIN =" + "'" + "ระยะเวลาการผ่อน" + "'");



                                                                        }

                                                                    }
                                                                }
                    );












                }
                else if(checkedText_install_ONBACK.equals("ถูกต้อง")){
                    ((RadioButton)radioSexGroup2.getChildAt(0)).setChecked(true);
                    ((RadioButton)radioSexGroup2.getChildAt(1)).setChecked(false);

                    checkedText_confirm  = checkedText_install_ONBACK;
                    data_redio3=checkedText_confirm;
                    if (!data_redio3.isEmpty()){
                        li_confirm.setBackgroundColor(0xffffffff);
                    }


                    if(checkedText_confirm.equals("ไม่ถูกต้อง")){
                        li6.setVisibility(View.VISIBLE);
                        linear_pen.setVisibility(View.VISIBLE);

                        SQLiteDataBaseBuild_data_checker_problem_for_report();
                        SQLiteTableBuild_data_checker_problem_for_report();
                        String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + " (CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID) VALUES('" + conno + "','" + "ปัญหาการ์ดตรวจสอบ" + "','" + "ระยะเวลาการผ่อน" + "','" + "ไม่ถูกต้อง" + "','" + new_message_scan.getText().toString() + "','" + "ตรวจสอบได้ เข้าบ้านลูกค้าได้" + "');";
                        //    String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + " (CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID,ProblemID) VALUES('" + conno + "','" + "ปัญหาการ์ดตรวจสอบ" + "','" + "ลูกค้านัดเกินกำหนด" + "','" + "เกิน 45 วัน" + "','" + NNN + "','" + "ตรวจสอบได้ เข้าบ้านลูกค้าได้" + "','" + "14" + "');";
                        try {
                            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
                        }
                        catch (Exception ex){

                        }

                    }
                    else {
                        linear_pen.setVisibility(View.VISIBLE);
                        li6.setVisibility(View.GONE);


                        SQLiteDataBaseBuild_data_checker_problem_for_report();
                        SQLiteTableBuild_data_checker_problem_for_report();
                        sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + "" + " WHERE MAIN =" + "'" + "ระยะเวลาการผ่อน" + "'");



                    }
































                    radioSexGroup2.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                                {
                                                                    public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                                    {
                                                                        RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );

                                                                        // String checkedText = checkedRadio.getText ( ).toString ( );
                                                                        checkedText_confirm  = checkedRadio.getText ( ).toString ( );
                                                                        data_redio3=checkedText_confirm;
                                                                        if (!data_redio3.isEmpty()){
                                                                            li_confirm.setBackgroundColor(0xffffffff);
                                                                        }


                                                                        if(checkedText_confirm.equals("ไม่ถูกต้อง")){
                                                                            li6.setVisibility(View.VISIBLE);
                                                                            linear_pen.setVisibility(View.VISIBLE);

                                                                            SQLiteDataBaseBuild_data_checker_problem_for_report();
                                                                            SQLiteTableBuild_data_checker_problem_for_report();
                                                                            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + " (CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID) VALUES('" + conno + "','" + "ปัญหาการ์ดตรวจสอบ" + "','" + "ระยะเวลาการผ่อน" + "','" + "ไม่ถูกต้อง" + "','" + new_message_scan.getText().toString() + "','" + "ตรวจสอบได้ เข้าบ้านลูกค้าได้" + "');";
                                                                            //    String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + " (CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID,ProblemID) VALUES('" + conno + "','" + "ปัญหาการ์ดตรวจสอบ" + "','" + "ลูกค้านัดเกินกำหนด" + "','" + "เกิน 45 วัน" + "','" + NNN + "','" + "ตรวจสอบได้ เข้าบ้านลูกค้าได้" + "','" + "14" + "');";
                                                                            try {
                                                                                sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
                                                                            }
                                                                            catch (Exception ex){

                                                                            }

                                                                        }
                                                                        else {
                                                                            linear_pen.setVisibility(View.VISIBLE);
                                                                            li6.setVisibility(View.GONE);


                                                                            SQLiteDataBaseBuild_data_checker_problem_for_report();
                                                                            SQLiteTableBuild_data_checker_problem_for_report();
                                                                            sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + "" + " WHERE MAIN =" + "'" + "ระยะเวลาการผ่อน" + "'");



                                                                        }

                                                                    }
                                                                }
                    );














                }
                else {
                    ((RadioButton)radioSexGroup2.getChildAt(1)).setChecked(false);
                    ((RadioButton)radioSexGroup2.getChildAt(0)).setChecked(false);







                    checkedText_confirm  = checkedText_install_ONBACK;
                    data_redio3=checkedText_confirm;
                    if (!data_redio3.isEmpty()){
                        li_confirm.setBackgroundColor(0xffffffff);
                    }


                    if(checkedText_confirm.equals("ไม่ถูกต้อง")){
                        li6.setVisibility(View.VISIBLE);
                        linear_pen.setVisibility(View.VISIBLE);

                        SQLiteDataBaseBuild_data_checker_problem_for_report();
                        SQLiteTableBuild_data_checker_problem_for_report();
                        String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + " (CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID) VALUES('" + conno + "','" + "ปัญหาการ์ดตรวจสอบ" + "','" + "ระยะเวลาการผ่อน" + "','" + "ไม่ถูกต้อง" + "','" + new_message_scan.getText().toString() + "','" + "ตรวจสอบได้ เข้าบ้านลูกค้าได้" + "');";
                        //    String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + " (CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID,ProblemID) VALUES('" + conno + "','" + "ปัญหาการ์ดตรวจสอบ" + "','" + "ลูกค้านัดเกินกำหนด" + "','" + "เกิน 45 วัน" + "','" + NNN + "','" + "ตรวจสอบได้ เข้าบ้านลูกค้าได้" + "','" + "14" + "');";
                        try {
                            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
                        }
                        catch (Exception ex){

                        }

                    }
                    else {
                        linear_pen.setVisibility(View.VISIBLE);
                        li6.setVisibility(View.GONE);


                        SQLiteDataBaseBuild_data_checker_problem_for_report();
                        SQLiteTableBuild_data_checker_problem_for_report();
                        sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + "" + " WHERE MAIN =" + "'" + "ระยะเวลาการผ่อน" + "'");



                    }











                    radioSexGroup2.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                                {
                                                                    public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                                    {
                                                                        RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );

                                                                        // String checkedText = checkedRadio.getText ( ).toString ( );
                                                                        checkedText_confirm  = checkedRadio.getText ( ).toString ( );
                                                                        data_redio3=checkedText_confirm;
                                                                        if (!data_redio3.isEmpty()){
                                                                            li_confirm.setBackgroundColor(0xffffffff);
                                                                        }


                                                                        if(checkedText_confirm.equals("ไม่ถูกต้อง")){
                                                                            li6.setVisibility(View.VISIBLE);
                                                                            linear_pen.setVisibility(View.VISIBLE);

                                                                            SQLiteDataBaseBuild_data_checker_problem_for_report();
                                                                            SQLiteTableBuild_data_checker_problem_for_report();
                                                                            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + " (CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID) VALUES('" + conno + "','" + "ปัญหาการ์ดตรวจสอบ" + "','" + "ระยะเวลาการผ่อน" + "','" + "ไม่ถูกต้อง" + "','" + new_message_scan.getText().toString() + "','" + "ตรวจสอบได้ เข้าบ้านลูกค้าได้" + "');";
                                                                            //    String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + " (CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID,ProblemID) VALUES('" + conno + "','" + "ปัญหาการ์ดตรวจสอบ" + "','" + "ลูกค้านัดเกินกำหนด" + "','" + "เกิน 45 วัน" + "','" + NNN + "','" + "ตรวจสอบได้ เข้าบ้านลูกค้าได้" + "','" + "14" + "');";
                                                                            try {
                                                                                sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
                                                                            }
                                                                            catch (Exception ex){

                                                                            }

                                                                        }
                                                                        else {
                                                                            linear_pen.setVisibility(View.VISIBLE);
                                                                            li6.setVisibility(View.GONE);


                                                                            SQLiteDataBaseBuild_data_checker_problem_for_report();
                                                                            SQLiteTableBuild_data_checker_problem_for_report();
                                                                            sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + "" + " WHERE MAIN =" + "'" + "ระยะเวลาการผ่อน" + "'");



                                                                        }

                                                                    }
                                                                }
                    );











                }

            }
            else {













                radioSexGroup2.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                            {
                                                                public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                                {
                                                                    RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );

                                                                    // String checkedText = checkedRadio.getText ( ).toString ( );
                                                                    checkedText_confirm  = checkedRadio.getText ( ).toString ( );
                                                                    data_redio3=checkedText_confirm;
                                                                    if (!data_redio3.isEmpty()){
                                                                        li_confirm.setBackgroundColor(0xffffffff);
                                                                    }


                                                                    if(checkedText_confirm.equals("ไม่ถูกต้อง")){
                                                                        li6.setVisibility(View.VISIBLE);
                                                                        linear_pen.setVisibility(View.VISIBLE);

                                                                        SQLiteDataBaseBuild_data_checker_problem_for_report();
                                                                        SQLiteTableBuild_data_checker_problem_for_report();
                                                                        String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + " (CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID) VALUES('" + conno + "','" + "ปัญหาการ์ดตรวจสอบ" + "','" + "ระยะเวลาการผ่อน" + "','" + "ไม่ถูกต้อง" + "','" + new_message_scan.getText().toString() + "','" + "ตรวจสอบได้ เข้าบ้านลูกค้าได้" + "');";
                                                                        //    String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + " (CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID,ProblemID) VALUES('" + conno + "','" + "ปัญหาการ์ดตรวจสอบ" + "','" + "ลูกค้านัดเกินกำหนด" + "','" + "เกิน 45 วัน" + "','" + NNN + "','" + "ตรวจสอบได้ เข้าบ้านลูกค้าได้" + "','" + "14" + "');";
                                                                        try {
                                                                            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
                                                                        }
                                                                        catch (Exception ex){

                                                                        }

                                                                    }
                                                                    else {
                                                                        linear_pen.setVisibility(View.VISIBLE);
                                                                        li6.setVisibility(View.GONE);


                                                                        SQLiteDataBaseBuild_data_checker_problem_for_report();
                                                                        SQLiteTableBuild_data_checker_problem_for_report();
                                                                        sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + "" + " WHERE MAIN =" + "'" + "ระยะเวลาการผ่อน" + "'");



                                                                    }

                                                                }
                                                            }
                );










            }
        }
        catch (Exception ex){



            radioSexGroup2.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                        {
                                                            public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                            {
                                                                RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );

                                                                // String checkedText = checkedRadio.getText ( ).toString ( );
                                                                checkedText_confirm  = checkedRadio.getText ( ).toString ( );
                                                                data_redio3=checkedText_confirm;
                                                                if (!data_redio3.isEmpty()){
                                                                    li_confirm.setBackgroundColor(0xffffffff);
                                                                }


                                                                if(checkedText_confirm.equals("ไม่ถูกต้อง")){
                                                                    li6.setVisibility(View.VISIBLE);
                                                                    linear_pen.setVisibility(View.VISIBLE);

                                                                    SQLiteDataBaseBuild_data_checker_problem_for_report();
                                                                    SQLiteTableBuild_data_checker_problem_for_report();
                                                                    String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + " (CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID) VALUES('" + conno + "','" + "ปัญหาการ์ดตรวจสอบ" + "','" + "ระยะเวลาการผ่อน" + "','" + "ไม่ถูกต้อง" + "','" + new_message_scan.getText().toString() + "','" + "ตรวจสอบได้ เข้าบ้านลูกค้าได้" + "');";
                                                                    //    String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + " (CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID,ProblemID) VALUES('" + conno + "','" + "ปัญหาการ์ดตรวจสอบ" + "','" + "ลูกค้านัดเกินกำหนด" + "','" + "เกิน 45 วัน" + "','" + NNN + "','" + "ตรวจสอบได้ เข้าบ้านลูกค้าได้" + "','" + "14" + "');";
                                                                    try {
                                                                        sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
                                                                    }
                                                                    catch (Exception ex){

                                                                    }

                                                                }
                                                                else {
                                                                    linear_pen.setVisibility(View.VISIBLE);
                                                                    li6.setVisibility(View.GONE);


                                                                    SQLiteDataBaseBuild_data_checker_problem_for_report();
                                                                    SQLiteTableBuild_data_checker_problem_for_report();
                                                                    sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + "" + " WHERE MAIN =" + "'" + "ระยะเวลาการผ่อน" + "'");



                                                                }

                                                            }
                                                        }
            );


        }
    }



















    private void check_box1(){





        try {

           // String radioSex_re_S_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("radioSex_re_S")+"";
            //String checkedText_pay_one_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("checkedText_pay_one")+"";






            String checkedText_install_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("radioSex_re_S")+"";


            //MyApplication.getInstance().getPrefManager().setPreferrence("radioSex_re_S", checkedText_install_ONBACK);

            Log.e("install_ONBACK1",checkedText_install_ONBACK);

            if(!checkedText_install_ONBACK.equals("null")){
                if(checkedText_install_ONBACK.equals("ไม่เคย")){
                    ((RadioButton)radioSex_re.getChildAt(1)).setChecked(true);
                    ((RadioButton)radioSex_re.getChildAt(0)).setChecked(false);

                    radioSex_re_S  = checkedText_install_ONBACK;
                    //data_redio1=checkedText_pay_one;

                    if (!radioSex_re_S.isEmpty()){
                        li_remarket.setBackgroundColor(0xffffffff);
                    }




















                    radioSex_re.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                             {
                                                                 public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                                 {
                                                                     RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );


                                                                     //  checkedText_install  = checkedRadio.getText ( ).toString ( );
                                                                     radioSex_re_S  = checkedRadio.getText ( ).toString ( );
                                                                     //data_redio1=checkedText_pay_one;

                                                                     if (!radioSex_re_S.isEmpty()){
                                                                         li_remarket.setBackgroundColor(0xffffffff);
                                                                     }




                                                                 }
                                                             }
                    );












                }
                else if(checkedText_install_ONBACK.equals("เคย")){
                    ((RadioButton)radioSex_re.getChildAt(0)).setChecked(true);
                    ((RadioButton)radioSex_re.getChildAt(1)).setChecked(false);

                    radioSex_re_S  = checkedText_install_ONBACK;
                    //data_redio1=checkedText_pay_one;

                    if (!radioSex_re_S.isEmpty()){
                        li_remarket.setBackgroundColor(0xffffffff);
                    }



































                    radioSex_re.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                             {
                                                                 public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                                 {
                                                                     RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );


                                                                     //  checkedText_install  = checkedRadio.getText ( ).toString ( );
                                                                     radioSex_re_S  = checkedRadio.getText ( ).toString ( );
                                                                     //data_redio1=checkedText_pay_one;

                                                                     if (!radioSex_re_S.isEmpty()){
                                                                         li_remarket.setBackgroundColor(0xffffffff);
                                                                     }




                                                                 }
                                                             }
                    );














                }
                else {
                    ((RadioButton)radioSex_re.getChildAt(1)).setChecked(false);
                    ((RadioButton)radioSex_re.getChildAt(0)).setChecked(false);






                    radioSex_re_S  = checkedText_install_ONBACK;
                    //data_redio1=checkedText_pay_one;

                    if (!radioSex_re_S.isEmpty()){
                        li_remarket.setBackgroundColor(0xffffffff);
                    }















                    radioSex_re.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                             {
                                                                 public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                                 {
                                                                     RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );


                                                                     //  checkedText_install  = checkedRadio.getText ( ).toString ( );
                                                                     radioSex_re_S  = checkedRadio.getText ( ).toString ( );
                                                                     //data_redio1=checkedText_pay_one;

                                                                     if (!radioSex_re_S.isEmpty()){
                                                                         li_remarket.setBackgroundColor(0xffffffff);
                                                                     }




                                                                 }
                                                             }
                    );











                }

            }
            else {













                radioSex_re.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                         {
                                                             public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                             {
                                                                 RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );


                                                                 //  checkedText_install  = checkedRadio.getText ( ).toString ( );
                                                                 radioSex_re_S  = checkedRadio.getText ( ).toString ( );
                                                                 //data_redio1=checkedText_pay_one;

                                                                 if (!radioSex_re_S.isEmpty()){
                                                                     li_remarket.setBackgroundColor(0xffffffff);
                                                                 }




                                                             }
                                                         }
                );










            }
        }
        catch (Exception ex){



            radioSex_re.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                     {
                                                         public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                         {
                                                             RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );


                                                             //  checkedText_install  = checkedRadio.getText ( ).toString ( );
                                                             radioSex_re_S  = checkedRadio.getText ( ).toString ( );
                                                             //data_redio1=checkedText_pay_one;

                                                             if (!radioSex_re_S.isEmpty()){
                                                                 li_remarket.setBackgroundColor(0xffffffff);
                                                             }




                                                         }
                                                     }
            );


        }
    }


    private void check_box2(){
        try {
            String checkedText_install_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("checkedText_install")+"";


            //MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_install", checkedText_install_ONBACK);

            Log.e("install_ONBACK2",checkedText_install_ONBACK);

            if(!checkedText_install_ONBACK.equals("null")){
                if(checkedText_install_ONBACK.equals("ติดดั้งไม่เรียบร้อย")){
                    ((RadioButton)radioSexGroup1.getChildAt(1)).setChecked(true);
                    ((RadioButton)radioSexGroup1.getChildAt(0)).setChecked(false);

                    checkedText_install  = checkedText_install_ONBACK;
                    data_redio1=checkedText_install;
                    if (!data_redio1.isEmpty()){

                        li_install2.setBackgroundColor(0xffffffff);

                    }

                    if(checkedText_install.isEmpty()){
                        // Log.e("no_data","no_data");
                    }
                    else {

                        if (checkedText_install.equals("ยังไม่ชำระ")) {
                            li_pay1.setVisibility(View.GONE);
                            li_pay1_2.setVisibility(View.VISIBLE);
                        } else {
                            li_pay1.setVisibility(View.GONE);
                            li_pay1_2.setVisibility(View.GONE);
                        }
                    }








                    radioSexGroup1.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                                {
                                                                    public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                                    {

                                                                        RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );








                                                                        //   String checkedText = checkedRadio.getText ( ).toString ( );

                                                                        checkedText_install  = checkedRadio.getText ( ).toString ( );


                                                                        data_redio1=checkedText_install;

                                                                        if (!data_redio1.isEmpty()){

                                                                            li_install2.setBackgroundColor(0xffffffff);

                                                                        }



                                                                        if(checkedText_install.isEmpty()){
                                                                            // Log.e("no_data","no_data");
                                                                        }
                                                                        else {



                                                                            if (checkedText_install.equals("ยังไม่ชำระ")) {
                                                                                li_pay1.setVisibility(View.GONE);
                                                                                li_pay1_2.setVisibility(View.VISIBLE);
                                                                            } else {
                                                                                li_pay1.setVisibility(View.GONE);
                                                                                li_pay1_2.setVisibility(View.GONE);
                                                                            }
                                                                        }





                                                                    }
                                                                }
                    );



                }
                else if(checkedText_install_ONBACK.equals("ติดตั้งเรียบร้อย")){
                    ((RadioButton)radioSexGroup1.getChildAt(0)).setChecked(true);
                    ((RadioButton)radioSexGroup1.getChildAt(1)).setChecked(false);

                    checkedText_install  = checkedText_install_ONBACK;
                    data_redio1=checkedText_install;
                    if (!data_redio1.isEmpty()){

                        li_install2.setBackgroundColor(0xffffffff);

                    }

                    if(checkedText_install.isEmpty()){
                        // Log.e("no_data","no_data");
                    }
                    else {

                        if (checkedText_install.equals("ยังไม่ชำระ")) {
                            li_pay1.setVisibility(View.GONE);
                            li_pay1_2.setVisibility(View.VISIBLE);
                        } else {
                            li_pay1.setVisibility(View.GONE);
                            li_pay1_2.setVisibility(View.GONE);
                        }
                    }












                    radioSexGroup1.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                                {
                                                                    public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                                    {

                                                                        RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );








                                                                        //   String checkedText = checkedRadio.getText ( ).toString ( );

                                                                        checkedText_install  = checkedRadio.getText ( ).toString ( );


                                                                        data_redio1=checkedText_install;

                                                                        if (!data_redio1.isEmpty()){

                                                                            li_install2.setBackgroundColor(0xffffffff);

                                                                        }



                                                                        if(checkedText_install.isEmpty()){
                                                                            // Log.e("no_data","no_data");
                                                                        }
                                                                        else {



                                                                            if (checkedText_install.equals("ยังไม่ชำระ")) {
                                                                                li_pay1.setVisibility(View.GONE);
                                                                                li_pay1_2.setVisibility(View.VISIBLE);
                                                                            } else {
                                                                                li_pay1.setVisibility(View.GONE);
                                                                                li_pay1_2.setVisibility(View.GONE);
                                                                            }
                                                                        }





                                                                    }
                                                                }
                    );












                }
                else {
                    ((RadioButton)radioSexGroup1.getChildAt(1)).setChecked(false);
                    ((RadioButton)radioSexGroup1.getChildAt(0)).setChecked(false);






                    checkedText_install  = checkedText_install_ONBACK;
                    data_redio1=checkedText_install;
                    if (!data_redio1.isEmpty()){

                        li_install2.setBackgroundColor(0xffffffff);

                    }

                    if(checkedText_install.isEmpty()){
                        // Log.e("no_data","no_data");
                    }
                    else {

                        if (checkedText_install.equals("ยังไม่ชำระ")) {
                            li_pay1.setVisibility(View.GONE);
                            li_pay1_2.setVisibility(View.VISIBLE);
                        } else {
                            li_pay1.setVisibility(View.GONE);
                            li_pay1_2.setVisibility(View.GONE);
                        }
                    }








                    radioSexGroup1.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                                {
                                                                    public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                                    {

                                                                        RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );








                                                                        //   String checkedText = checkedRadio.getText ( ).toString ( );

                                                                        checkedText_install  = checkedRadio.getText ( ).toString ( );


                                                                        data_redio1=checkedText_install;

                                                                        if (!data_redio1.isEmpty()){

                                                                            li_install2.setBackgroundColor(0xffffffff);

                                                                        }



                                                                        if(checkedText_install.isEmpty()){
                                                                            // Log.e("no_data","no_data");
                                                                        }
                                                                        else {



                                                                            if (checkedText_install.equals("ยังไม่ชำระ")) {
                                                                                li_pay1.setVisibility(View.GONE);
                                                                                li_pay1_2.setVisibility(View.VISIBLE);
                                                                            } else {
                                                                                li_pay1.setVisibility(View.GONE);
                                                                                li_pay1_2.setVisibility(View.GONE);
                                                                            }
                                                                        }





                                                                    }
                                                                }
                    );




                }

            }
            else {




                radioSexGroup1.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                            {
                                                                public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                                {

                                                                    RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );








                                                                    //   String checkedText = checkedRadio.getText ( ).toString ( );

                                                                    checkedText_install  = checkedRadio.getText ( ).toString ( );


                                                                    data_redio1=checkedText_install;

                                                                    if (!data_redio1.isEmpty()){

                                                                        li_install2.setBackgroundColor(0xffffffff);

                                                                    }



                                                                    if(checkedText_install.isEmpty()){
                                                                        // Log.e("no_data","no_data");
                                                                    }
                                                                    else {



                                                                        if (checkedText_install.equals("ยังไม่ชำระ")) {
                                                                            li_pay1.setVisibility(View.GONE);
                                                                            li_pay1_2.setVisibility(View.VISIBLE);
                                                                        } else {
                                                                            li_pay1.setVisibility(View.GONE);
                                                                            li_pay1_2.setVisibility(View.GONE);
                                                                        }
                                                                    }





                                                                }
                                                            }
                );

            }
        }
        catch (Exception ex){



            radioSexGroup1.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                        {
                                                            public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                            {

                                                                RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );








                                                                //   String checkedText = checkedRadio.getText ( ).toString ( );

                                                                checkedText_install  = checkedRadio.getText ( ).toString ( );


                                                                data_redio1=checkedText_install;

                                                                if (!data_redio1.isEmpty()){

                                                                    li_install2.setBackgroundColor(0xffffffff);

                                                                }



                                                                if(checkedText_install.isEmpty()){
                                                                    // Log.e("no_data","no_data");
                                                                }
                                                                else {



                                                                    if (checkedText_install.equals("ยังไม่ชำระ")) {
                                                                        li_pay1.setVisibility(View.GONE);
                                                                        li_pay1_2.setVisibility(View.VISIBLE);
                                                                    } else {
                                                                        li_pay1.setVisibility(View.GONE);
                                                                        li_pay1_2.setVisibility(View.GONE);
                                                                    }
                                                                }





                                                            }
                                                        }
            );

        }
    }





















    private void check_box_new1(){
        try {
            String checkedText_radioSex_con_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("checkedText_radioSex_con_ONBACK")+"";


            //MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_install", checkedText_install_ONBACK);

            Log.e("install_ONBACK2",checkedText_radioSex_con_ONBACK);

            if(!checkedText_radioSex_con_ONBACK.equals("null")){




                try {
                    String S_ProcessTypeID=MyApplication.getInstance().getPrefManager().getPreferrence("ProcessTypeID");

                    if((S_ProcessTypeID.equals("01"))|(S_ProcessTypeID.equals("02"))){
                        li_conveniently.setVisibility(View.VISIBLE);
                    }
                    else {
                        li_conveniently.setVisibility(View.GONE);
                    }
                }
                catch (Exception ex){

                }






                if(checkedText_radioSex_con_ONBACK.equals("ไม่สะดวก")){
                    ((RadioButton)radioSex_con.getChildAt(1)).setChecked(true);
                    ((RadioButton)radioSex_con.getChildAt(0)).setChecked(false);

                    checkedText_radioSex_con  = checkedText_radioSex_con_ONBACK;
                    data_radioSex_con=checkedText_radioSex_con;
                    if (!data_radioSex_con.isEmpty()){

                        li_conveniently.setBackgroundColor(0xffffffff);

                    }










                    radioSex_con.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                                {
                                                                    public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                                    {

                                                                        RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );








                                                                        //   String checkedText = checkedRadio.getText ( ).toString ( );

                                                                        checkedText_radioSex_con  = checkedRadio.getText ( ).toString ( );


                                                                        data_radioSex_con=checkedText_radioSex_con;

                                                                        if (!data_radioSex_con.isEmpty()){

                                                                            li_conveniently.setBackgroundColor(0xffffffff);

                                                                        }









                                                                    }
                                                                }
                    );



                }
                else if(checkedText_radioSex_con_ONBACK.equals("ใช่สะดวก")){
                    ((RadioButton)radioSex_con.getChildAt(0)).setChecked(true);
                    ((RadioButton)radioSex_con.getChildAt(1)).setChecked(false);

                    checkedText_radioSex_con  = checkedText_radioSex_con_ONBACK;
                    data_radioSex_con=checkedText_radioSex_con;
                    if (!data_radioSex_con.isEmpty()){

                        li_install2.setBackgroundColor(0xffffffff);

                    }














                    radioSex_con.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                                {
                                                                    public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                                    {

                                                                        RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );








                                                                        //   String checkedText = checkedRadio.getText ( ).toString ( );

                                                                        checkedText_radioSex_con  = checkedRadio.getText ( ).toString ( );


                                                                        data_radioSex_con=checkedText_radioSex_con;

                                                                        if (!data_radioSex_con.isEmpty()){

                                                                            li_conveniently.setBackgroundColor(0xffffffff);

                                                                        }








                                                                    }
                                                                }
                    );












                }
                else {
                    ((RadioButton)radioSex_con.getChildAt(1)).setChecked(false);
                    ((RadioButton)radioSex_con.getChildAt(0)).setChecked(false);






                    checkedText_radioSex_con  = checkedText_radioSex_con_ONBACK;
                    data_radioSex_con=checkedText_radioSex_con;
                    if (!data_radioSex_con.isEmpty()){

                        li_install2.setBackgroundColor(0xffffffff);

                    }










                    radioSex_con.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                                {
                                                                    public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                                    {

                                                                        RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );








                                                                        //   String checkedText = checkedRadio.getText ( ).toString ( );

                                                                        checkedText_radioSex_con  = checkedRadio.getText ( ).toString ( );


                                                                        data_radioSex_con=checkedText_radioSex_con;

                                                                        if (!data_radioSex_con.isEmpty()){

                                                                            li_conveniently.setBackgroundColor(0xffffffff);

                                                                        }









                                                                    }
                                                                }
                    );




                }

            }
            else {




                radioSex_con.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                            {
                                                                public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                                {

                                                                    RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );








                                                                    //   String checkedText = checkedRadio.getText ( ).toString ( );

                                                                    checkedText_radioSex_con  = checkedRadio.getText ( ).toString ( );


                                                                    data_radioSex_con=checkedText_radioSex_con;

                                                                    if (!data_radioSex_con.isEmpty()){

                                                                        li_conveniently.setBackgroundColor(0xffffffff);

                                                                    }








                                                                }
                                                            }
                );

            }
        }
        catch (Exception ex){



            radioSex_con.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( )
                                                        {
                                                            public void onCheckedChanged ( RadioGroup group, int checkedId )
                                                            {

                                                                RadioButton checkedRadio = ( RadioButton ) Detali_check1.this.findViewById ( checkedId );








                                                                //   String checkedText = checkedRadio.getText ( ).toString ( );

                                                                checkedText_radioSex_con  = checkedRadio.getText ( ).toString ( );


                                                                data_radioSex_con=checkedText_radioSex_con;

                                                                if (!data_radioSex_con.isEmpty()){

                                                                    li_conveniently.setBackgroundColor(0xffffffff);

                                                                }








                                                            }
                                                        }
            );

        }
    }
    private void view_data_size(){
        allSampleData1.clear();
        allSampleData2.clear();
        allSampleData3.clear();
        allSampleData4.clear();
        allSampleData5.clear();
        get_data_type_checks.clear();

        SQLiteDataBaseBuild1();
        SQLiteTableBuild1_2();




        try {
            String S_ProcessTypeID=MyApplication.getInstance().getPrefManager().getPreferrence("ProcessTypeID");

            if((S_ProcessTypeID.equals("01"))|(S_ProcessTypeID.equals("02"))){
                li_conveniently.setVisibility(View.VISIBLE);
            }
            else {
                li_conveniently.setVisibility(View.GONE);
            }
        }
        catch (Exception ex){
            li_conveniently.setVisibility(View.GONE);
        }




            for (int i = 1; i <=1; i++) {

                SectionDataModel_checker1 dm = new SectionDataModel_checker1();

                dm.setHeaderTitle("ล่าสุด ");

                ArrayList<SingleItemModel_checker1> singleItem = new ArrayList<SingleItemModel_checker1>();


                    try {
                        cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker1.TABLE_NAME + "", null);

                        if (cursor.moveToFirst()) {
                            do {

                                String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_url_image));
                                String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_order_image));


                                // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                                // String f= String.valueOf(order_image);
                                singleItem.add(new SingleItemModel_checker1("รูป " + f, FA));

                                size1 = singleItem.size();
                                MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                            } while (cursor.moveToNext());
                        }
                        cursor.close();
                    }
                    catch (Exception ex){

                    }









                dm.setAllItemsInSection(singleItem);

                allSampleData1.add(dm);


            }

        Log.e("size1", String.valueOf(size1));
            RecyclerViewDataAdapter_image1 adapter = new RecyclerViewDataAdapter_image1(this, allSampleData1);
            my_recycler_view1.setAdapter(adapter);
            adapter.setitemclick_deleteAll3(this);
            if(size1==0){
                my_recycler_view1.setVisibility(View.GONE);

            }
            else {
                my_recycler_view1.setVisibility(View.VISIBLE);

            }
















        SQLiteDataBaseBuild2();
        SQLiteTableBuild2_2();











        for (int i = 1; i <=1; i++) {

            SectionDataModel_checker2 dm = new SectionDataModel_checker2();

            dm.setHeaderTitle("ล่าสุด ");

            ArrayList<SingleItemModel_checker2> singleItem = new ArrayList<SingleItemModel_checker2>();







                try {
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
                catch (Exception ex){

                }









            dm.setAllItemsInSection(singleItem);

            allSampleData2.add(dm);


        }

        Log.e("size2", String.valueOf(size2));
        RecyclerViewDataAdapter_image2 adapter2 = new RecyclerViewDataAdapter_image2(this, allSampleData2);
        my_recycler_view2.setAdapter(adapter2);
        adapter2.setitemclick_deleteAll3(this);
        if(size2==0){
            my_recycler_view2.setVisibility(View.GONE);
        }
        else {
            my_recycler_view2.setVisibility(View.VISIBLE);

        }
























        SQLiteDataBaseBuild3();
        SQLiteTableBuild3_2();







        for (int i = 1; i <= 1; i++) {

            SectionDataModel_checker3 dm = new SectionDataModel_checker3();

            dm.setHeaderTitle("ล่าสุด ");

            ArrayList<SingleItemModel_checker3> singleItem = new ArrayList<SingleItemModel_checker3>();





                try {
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
                catch (Exception ex){

                }




            dm.setAllItemsInSection(singleItem);

            allSampleData3.add(dm);


        }

        Log.e("size3", String.valueOf(size3));
        RecyclerViewDataAdapter_image3 adapter3 = new RecyclerViewDataAdapter_image3(this, allSampleData3);
        my_recycler_view3.setAdapter(adapter3);
        adapter3.setitemclick_deleteAll3(this);
        if (size3 == 0) {
            my_recycler_view3.setVisibility(View.GONE);
        } else {
            my_recycler_view3.setVisibility(View.VISIBLE);


        }


























        SQLiteDataBaseBuild4();
        SQLiteTableBuild4_2();



        for (int i = 1; i <= 1; i++) {

            SectionDataModel_checker4 dm = new SectionDataModel_checker4();

            dm.setHeaderTitle("ล่าสุด ");

            ArrayList<SingleItemModel_checker4> singleItem = new ArrayList<SingleItemModel_checker4>();




                try {
                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker4.TABLE_NAME + "", null);
                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_order_image));
                            // Log.e("AAAAAAAA", FA);

                            // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                            // String f= String.valueOf(order_image);
                            singleItem.add(new SingleItemModel_checker4("รูป " + f, FA));

                            size4 = singleItem.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }
                catch (Exception dd){

                }





            dm.setAllItemsInSection(singleItem);

            allSampleData4.add(dm);


        }

        Log.e("size4", String.valueOf(size4));
        RecyclerViewDataAdapter_image4 adapter4 = new RecyclerViewDataAdapter_image4(this, allSampleData4);
        my_recycler_view4.setAdapter(adapter4);
        adapter4.setitemclick_deleteAll3(this);


        if (size4 == 0) {
            my_recycler_view4.setVisibility(View.GONE);
        } else {
            my_recycler_view4.setVisibility(View.VISIBLE);

        }



















        SQLiteDataBaseBuild5();
        SQLiteTableBuild5_2();





        for (int i = 1; i <=1; i++) {

            SectionDataModel_checker5 dm = new SectionDataModel_checker5();

            dm.setHeaderTitle("ล่าสุด ");

            ArrayList<SingleItemModel_checker5> singleItem = new ArrayList<SingleItemModel_checker5>();










                try {
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
                catch (Exception ex){

                }













            dm.setAllItemsInSection(singleItem);

            allSampleData5.add(dm);


        }

        Log.e("size5", String.valueOf(size5));
        RecyclerViewDataAdapter_image5 adapter5 = new RecyclerViewDataAdapter_image5(this, allSampleData5);
        my_recycler_view5.setAdapter(adapter5);
        adapter5.setitemclick_deleteAll3(this);


        if(size5==0){
            my_recycler_view5.setVisibility(View.GONE);
        }
        else {
            my_recycler_view5.setVisibility(View.VISIBLE);

        }












        SQLiteDataBaseBuild_map();
        SQLiteTableBuild_map_2();


        for (int i = 1; i <=1; i++) {

            SectionDataModel_checker_map dm = new SectionDataModel_checker_map();

            dm.setHeaderTitle("ล่าสุด ");

            ArrayList<SingleItemModel_checker_map> singleItem = new ArrayList<>();








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








            dm.setAllItemsInSection(singleItem);

            allSampleData_map.add(dm);


        }


        RecyclerViewDataAdapter_image_map adapter6 = new RecyclerViewDataAdapter_image_map(this, allSampleData_map);
        my_recycler_view_map.setAdapter(adapter6);
        adapter6.setitemclick_deleteAll_map_map(this);
        Log.e("size_map", String.valueOf(size_map));
        if(size_map==0){
            my_recycler_view_map.setVisibility(View.GONE);
         //   li2.setBackgroundColor(0xffff0000);
        }
        else {
            my_recycler_view_map.setVisibility(View.VISIBLE);
          //  li2.setBackgroundColor(0xffffffff);

        }





































                try {
                    String ProcessTypeID= MyApplication.getInstance().getPrefManager().getPreferrence("ProcessTypeID");

                    Log.e("sdaac",ProcessTypeID);
                    if((ProcessTypeID.equals("01"))|(ProcessTypeID.equals("02"))|(ProcessTypeID.equals("03"))|(ProcessTypeID.equals("04"))|(ProcessTypeID.equals("05"))){
                        get_data_type_checks.clear();

                        SQLiteDataBaseBuild_data_type();
                        SQLiteTableBuild_data_type();

                        if(ProcessTypeID.equals("01")) {




                            recyclerview1.setHasFixedSize(true);
                            recyclerViewlayoutManager = new LinearLayoutManager(this);
                            recyclerview1.setLayoutManager(recyclerViewlayoutManager);
                            get_data_type_checks.clear();
                            // recyclerview1.clearOnScrollListeners();
                            JSON_DATA_WEB_CALL();





                            relativeLayout_new.setVisibility(View.GONE);






                            ProcessTypeID="01";

                            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='true' WHERE part_id =" + "'" + "01" + "'");
                            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "02" + "'");
                            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "03" + "'");
                            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "04" + "'");
                            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "05" + "'");

                            recyclerview1.setHasFixedSize(true);
                            recyclerViewlayoutManager = new LinearLayoutManager(this);
                            recyclerview1.setLayoutManager(recyclerViewlayoutManager);
                            get_data_type_checks.clear();



                                cursor = sqLiteDatabase.rawQuery("SELECT  distinct part_id,ProcessTypeName,Processclick  FROM " + SQLiteHelper_data_type.TABLE_NAME, null);

                                if (cursor.moveToFirst()) {
                                    do {


                                        Get_data_type_check getDataTypeCheck = new Get_data_type_check();
                                        String Table_part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_part_id));
                                        String Table_ProcessTypeName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_ProcessTypeName));
                                        String Table_Processclick = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_Processclick));


                                        getDataTypeCheck.setProcessTypeID(Table_part_id);
                                        getDataTypeCheck.setData(Table_ProcessTypeName);
                                        getDataTypeCheck.setProcessclick(Table_Processclick);
                                        Log.e("Table_Processclick", Table_Processclick);
                                        get_data_type_checks.add(getDataTypeCheck);

                                        //recyclerViewadapter.notifyDataSetChanged();
                                    } while (cursor.moveToNext());
                                }
                                cursor.close();


                            recyclerViewadapter = new RecyclerViewAdapter_type_check(get_data_type_checks, this);

                            recyclerview1.setAdapter(recyclerViewadapter);
                            recyclerViewadapter.setitemclick2(this);




                            li_pay2.setVisibility(View.VISIBLE);
                            li_pay2_2.setVisibility(View.GONE);
                            li_install2.setVisibility(View.VISIBLE);
                            li_install3.setVisibility(View.VISIBLE);
                            li4.setVisibility(View.VISIBLE);
                            li7.setVisibility(View.VISIBLE);
                            txt_scan_assa.setVisibility(View.VISIBLE);
                            li_install1.setVisibility(View.VISIBLE);
                            linearlayout_show_problem_sub.setVisibility(View.VISIBLE);
                            li_pay_one.setVisibility(View.VISIBLE);
                            li_pay_two.setVisibility(View.VISIBLE);
                            li_pay_two2.setVisibility(View.VISIBLE);
                            li_pay2.setVisibility(View.VISIBLE);
                            li_confirm.setVisibility(View.VISIBLE);
                            li_confirm2.setVisibility(View.VISIBLE);
                            linear_pen.setVisibility(View.VISIBLE);
                            li_line1.setVisibility(View.VISIBLE);
                            li_line2.setVisibility(View.VISIBLE);
                            li_line3.setVisibility(View.VISIBLE);
                            li_line4.setVisibility(View.VISIBLE);
                            li_line5.setVisibility(View.VISIBLE);
                            li_line6.setVisibility(View.VISIBLE);
                            li_save.setVisibility(View.VISIBLE);
                            li_line1234.setVisibility(View.VISIBLE);

                            li_line7.setVisibility(View.GONE);
                            li_line8.setVisibility(View.GONE);
                            li_line9.setVisibility(View.GONE);
                            li_remarket.setVisibility(View.VISIBLE);

                            linearlayout_show_problem_tain.setVisibility(View.VISIBLE);



                            //  li_install_re_tain.setVisibility(View.VISIBLE);
                            linearlayout_date_to_date.setVisibility(View.VISIBLE);


                            li_pay2_2_2.setVisibility(View.VISIBLE);
                            li_line10.setVisibility(View.VISIBLE);
                            li_line11.setVisibility(View.VISIBLE);
                            li_line12.setVisibility(View.VISIBLE);
                            li_pay2_2_3.setVisibility(View.VISIBLE);

                            Log.e("assanee","6");



                            lili_1.setVisibility(View.VISIBLE);
                            lili_2.setVisibility(View.VISIBLE);
                            lili_3.setVisibility(View.VISIBLE);
                            lili_line1.setVisibility(View.VISIBLE);
                            lili_line2.setVisibility(View.VISIBLE);
                            li1.setVisibility(View.VISIBLE);
                            li2.setVisibility(View.VISIBLE);
                            lili_text_select4.setVisibility(View.GONE);


                            item_click=0;
                        }

                        else  if(ProcessTypeID.equals("02")) {




                            recyclerview1.setHasFixedSize(true);
                            recyclerViewlayoutManager = new LinearLayoutManager(this);
                            recyclerview1.setLayoutManager(recyclerViewlayoutManager);
                            get_data_type_checks.clear();
                            // recyclerview1.clearOnScrollListeners();
                            JSON_DATA_WEB_CALL();





                            relativeLayout_new.setVisibility(View.GONE);





                            ProcessTypeID="02";

                            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "01" + "'");
                            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='true' WHERE part_id =" + "'" + "02" + "'");
                            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "03" + "'");
                            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "04" + "'");
                            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "05" + "'");

                            get_data_type_checks.clear();
                            cursor = sqLiteDatabase.rawQuery("SELECT distinct part_id,ProcessTypeName,Processclick  FROM " + SQLiteHelper_data_type.TABLE_NAME, null);

                            if (cursor.moveToFirst()) {
                                do {

                                    Get_data_type_check    getDataTypeCheck= new Get_data_type_check();
                                    String Table_part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_part_id));
                                    String Table_ProcessTypeName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_ProcessTypeName));
                                    String Table_Processclick = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_Processclick));

                                    getDataTypeCheck.setProcessTypeID(Table_part_id);
                                    getDataTypeCheck.setData(Table_ProcessTypeName);
                                    getDataTypeCheck.setProcessclick(Table_Processclick);
                                    Log.e("Table_Processclick",Table_Processclick);
                                    get_data_type_checks.add(getDataTypeCheck);
                                } while (cursor.moveToNext());
                            }
                            cursor.close();


                            recyclerViewadapter = new RecyclerViewAdapter_type_check(get_data_type_checks, this);

                            recyclerview1.setAdapter(recyclerViewadapter);
                            recyclerViewadapter.setitemclick2(this);








                            li_pay2.setVisibility(View.VISIBLE);
                            li_pay2_2.setVisibility(View.GONE);
                            li_install2.setVisibility(View.GONE);
                            li_install3.setVisibility(View.GONE);
                            li4.setVisibility(View.GONE);
                            li7.setVisibility(View.GONE);
                            txt_scan_assa.setVisibility(View.GONE);
                            li_install1.setVisibility(View.GONE);
                            linearlayout_show_problem_sub.setVisibility(View.VISIBLE);
                            li_pay_one.setVisibility(View.VISIBLE);
                            li_pay_two.setVisibility(View.VISIBLE);
                            li_pay_two2.setVisibility(View.VISIBLE);
                            li_pay2.setVisibility(View.VISIBLE);
                            li_confirm.setVisibility(View.VISIBLE);
                            li_confirm2.setVisibility(View.VISIBLE);
                            linear_pen.setVisibility(View.VISIBLE);
                            li_line0.setVisibility(View.GONE);
                            li_line1.setVisibility(View.VISIBLE);
                            li_line2.setVisibility(View.GONE);
                            li_line3.setVisibility(View.VISIBLE);
                            li_line4.setVisibility(View.VISIBLE);
                            li_line5.setVisibility(View.VISIBLE);
                            li_line6.setVisibility(View.VISIBLE);
                            li_save.setVisibility(View.VISIBLE);
                            li_line1234.setVisibility(View.VISIBLE);

                            li_line7.setVisibility(View.GONE);
                            li_line8.setVisibility(View.GONE);
                            li_line9.setVisibility(View.GONE);
                            li_remarket.setVisibility(View.VISIBLE);

                            linearlayout_show_problem_tain.setVisibility(View.VISIBLE);


                            // li_install_re_tain.setVisibility(View.VISIBLE);
                            linearlayout_date_to_date.setVisibility(View.VISIBLE);

                            li_pay2_2_2.setVisibility(View.VISIBLE);
                            li_line10.setVisibility(View.VISIBLE);
                            li_line11.setVisibility(View.VISIBLE);
                            li_line12.setVisibility(View.VISIBLE);
                            li_pay2_2_3.setVisibility(View.VISIBLE);





                            lili_1.setVisibility(View.VISIBLE);
                            lili_2.setVisibility(View.VISIBLE);
                            lili_3.setVisibility(View.VISIBLE);
                            lili_line1.setVisibility(View.VISIBLE);
                            lili_line2.setVisibility(View.VISIBLE);
                            li1.setVisibility(View.VISIBLE);
                            li2.setVisibility(View.VISIBLE);
                            lili_text_select4.setVisibility(View.GONE);

                            Log.e("assanee","5");
                            item_click=1;
                        }

                        else  if(ProcessTypeID.equals("03")) {


                            recyclerview1.setHasFixedSize(true);
                            recyclerViewlayoutManager = new LinearLayoutManager(this);
                            recyclerview1.setLayoutManager(recyclerViewlayoutManager);
                            get_data_type_checks.clear();
                            // recyclerview1.clearOnScrollListeners();
                            JSON_DATA_WEB_CALL();





                            relativeLayout_new.setVisibility(View.GONE);
                            ProcessTypeID="03";

                            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "01" + "'");
                            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "02" + "'");
                            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='true' WHERE part_id =" + "'" + "03" + "'");
                            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "04" + "'");
                            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "05" + "'");
                            get_data_type_checks.clear();
                            cursor = sqLiteDatabase.rawQuery("SELECT distinct part_id,ProcessTypeName,Processclick  FROM " + SQLiteHelper_data_type.TABLE_NAME, null);

                            if (cursor.moveToFirst()) {
                                do {

                                    Get_data_type_check    getDataTypeCheck= new Get_data_type_check();
                                    String Table_part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_part_id));
                                    String Table_ProcessTypeName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_ProcessTypeName));
                                    String Table_Processclick = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_Processclick));

                                    getDataTypeCheck.setProcessTypeID(Table_part_id);
                                    getDataTypeCheck.setData(Table_ProcessTypeName);
                                    getDataTypeCheck.setProcessclick(Table_Processclick);
                                    Log.e("Table_Processclick",Table_Processclick);
                                    get_data_type_checks.add(getDataTypeCheck);
                                } while (cursor.moveToNext());
                            }
                            cursor.close();


                            recyclerViewadapter = new RecyclerViewAdapter_type_check(get_data_type_checks, this);

                            recyclerview1.setAdapter(recyclerViewadapter);

                            recyclerViewadapter.setitemclick2(this);






                            li_pay2.setVisibility(View.GONE);
                            li_pay2_2.setVisibility(View.GONE);
                            li_install2.setVisibility(View.GONE);
                            li_install3.setVisibility(View.GONE);
                            li4.setVisibility(View.GONE);
                            li7.setVisibility(View.GONE);
                            txt_scan_assa.setVisibility(View.GONE);
                            li_install1.setVisibility(View.GONE);
                            linearlayout_show_problem_sub.setVisibility(View.GONE);
                            li_pay_one.setVisibility(View.GONE);
                            li_pay_two.setVisibility(View.GONE);
                            li_pay_two2.setVisibility(View.GONE);
                            li_pay2.setVisibility(View.GONE);
                            li_confirm.setVisibility(View.GONE);
                            li_confirm2.setVisibility(View.GONE);
                            linear_pen.setVisibility(View.GONE);

                            li_line0.setVisibility(View.GONE);
                            li_line1.setVisibility(View.GONE);
                            li_line2.setVisibility(View.GONE);
                            li_line3.setVisibility(View.GONE);
                            li_line4.setVisibility(View.GONE);
                            li_line5.setVisibility(View.GONE);
                            li_line6.setVisibility(View.VISIBLE);
                            li_save.setVisibility(View.VISIBLE);
                            li_line1234.setVisibility(View.GONE);

                            li_line7.setVisibility(View.GONE);
                            li_line8.setVisibility(View.GONE);
                            li_line9.setVisibility(View.GONE);
                            li_remarket.setVisibility(View.GONE);
                            linearlayout_show_problem_tain.setVisibility(View.GONE);
                            li_install_tain.setVisibility(View.GONE);
                            li_install_re_tain.setVisibility(View.GONE);
                            linearlayout_date_to_date.setVisibility(View.GONE);

                            li_pay2_2_2.setVisibility(View.GONE);
                            li_line10.setVisibility(View.GONE);
                            li_line11.setVisibility(View.GONE);
                            li_line12.setVisibility(View.GONE);
                            li_pay2_2_3.setVisibility(View.GONE);
                            Log.e("assanee","4");


                            lili_1.setVisibility(View.VISIBLE);
                            lili_2.setVisibility(View.VISIBLE);
                            lili_3.setVisibility(View.VISIBLE);
                            lili_line1.setVisibility(View.VISIBLE);
                            lili_line2.setVisibility(View.VISIBLE);
                            li1.setVisibility(View.VISIBLE);
                            li2.setVisibility(View.VISIBLE);
                            lili_text_select4.setVisibility(View.GONE);
                            item_click=2;
                        }

                        else  if(ProcessTypeID.equals("04")) {


                            recyclerview1.setHasFixedSize(true);
                            recyclerViewlayoutManager = new LinearLayoutManager(this);
                            recyclerview1.setLayoutManager(recyclerViewlayoutManager);
                            get_data_type_checks.clear();
                            // recyclerview1.clearOnScrollListeners();
                            JSON_DATA_WEB_CALL();





                            relativeLayout_new.setVisibility(View.GONE);
                            ProcessTypeID="04";

                            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "01" + "'");
                            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "02" + "'");
                            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "03" + "'");
                            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='true' WHERE part_id =" + "'" + "04" + "'");
                            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "05" + "'");
                            get_data_type_checks.clear();
                            cursor = sqLiteDatabase.rawQuery("SELECT distinct part_id,ProcessTypeName,Processclick  FROM " + SQLiteHelper_data_type.TABLE_NAME, null);

                            if (cursor.moveToFirst()) {
                                do {

                                    Get_data_type_check    getDataTypeCheck= new Get_data_type_check();
                                    String Table_part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_part_id));
                                    String Table_ProcessTypeName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_ProcessTypeName));
                                    String Table_Processclick = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_Processclick));

                                    getDataTypeCheck.setProcessTypeID(Table_part_id);
                                    getDataTypeCheck.setData(Table_ProcessTypeName);
                                    getDataTypeCheck.setProcessclick(Table_Processclick);
                                    Log.e("Table_Processclick",Table_Processclick);
                                    get_data_type_checks.add(getDataTypeCheck);
                                } while (cursor.moveToNext());
                            }
                            cursor.close();


                            recyclerViewadapter = new RecyclerViewAdapter_type_check(get_data_type_checks, this);

                            recyclerview1.setAdapter(recyclerViewadapter);

                            recyclerViewadapter.setitemclick2(this);






                            li_pay2.setVisibility(View.GONE);
                            li_pay2_2.setVisibility(View.GONE);
                            li_install2.setVisibility(View.GONE);
                            li_install3.setVisibility(View.GONE);
                            li4.setVisibility(View.GONE);
                            li7.setVisibility(View.GONE);
                            txt_scan_assa.setVisibility(View.GONE);
                            li_install1.setVisibility(View.GONE);
                            linearlayout_show_problem_sub.setVisibility(View.GONE);
                            li_pay_one.setVisibility(View.GONE);
                            li_pay_two.setVisibility(View.GONE);
                            li_pay_two2.setVisibility(View.GONE);
                            li_pay2.setVisibility(View.GONE);
                            li_confirm.setVisibility(View.GONE);
                            li_confirm2.setVisibility(View.GONE);
                            linear_pen.setVisibility(View.GONE);

                            li_line0.setVisibility(View.GONE);
                            li_line1.setVisibility(View.GONE);
                            li_line2.setVisibility(View.GONE);
                            li_line3.setVisibility(View.GONE);
                            li_line4.setVisibility(View.GONE);
                            li_line5.setVisibility(View.GONE);
                            li_line6.setVisibility(View.VISIBLE);
                            li_save.setVisibility(View.VISIBLE);
                            li_line1234.setVisibility(View.GONE);

                            li_line7.setVisibility(View.GONE);
                            li_line8.setVisibility(View.GONE);
                            li_line9.setVisibility(View.GONE);
                            li_remarket.setVisibility(View.GONE);
                            linearlayout_show_problem_tain.setVisibility(View.GONE);
                            li_install_tain.setVisibility(View.GONE);
                            li_install_re_tain.setVisibility(View.GONE);
                            linearlayout_date_to_date.setVisibility(View.GONE);

                            li_pay2_2_2.setVisibility(View.GONE);
                            li_line10.setVisibility(View.GONE);
                            li_line11.setVisibility(View.GONE);
                            li_line12.setVisibility(View.GONE);
                            li_pay2_2_3.setVisibility(View.GONE);
                            Log.e("assanee","4");


                            lili_1.setVisibility(View.GONE);
                            lili_2.setVisibility(View.GONE);
                            lili_3.setVisibility(View.GONE);
                            lili_line1.setVisibility(View.GONE);
                            lili_line2.setVisibility(View.GONE);
                            li1.setVisibility(View.GONE);
                            li2.setVisibility(View.GONE);
                            lili_text_select4.setVisibility(View.VISIBLE);
                            item_click=3;
                        }

                        else  if(ProcessTypeID.equals("05")) {


                            recyclerview1.setHasFixedSize(true);
                            recyclerViewlayoutManager = new LinearLayoutManager(this);
                            recyclerview1.setLayoutManager(recyclerViewlayoutManager);
                            get_data_type_checks.clear();
                            // recyclerview1.clearOnScrollListeners();
                            JSON_DATA_WEB_CALL();





                            relativeLayout_new.setVisibility(View.GONE);
                            ProcessTypeID="05";

                            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "01" + "'");
                            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "02" + "'");
                            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "03" + "'");
                            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "04" + "'");
                            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='true' WHERE part_id =" + "'" + "05" + "'");
                            get_data_type_checks.clear();
                            cursor = sqLiteDatabase.rawQuery("SELECT distinct part_id,ProcessTypeName,Processclick  FROM " + SQLiteHelper_data_type.TABLE_NAME, null);

                            if (cursor.moveToFirst()) {
                                do {

                                    Get_data_type_check    getDataTypeCheck= new Get_data_type_check();
                                    String Table_part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_part_id));
                                    String Table_ProcessTypeName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_ProcessTypeName));
                                    String Table_Processclick = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_Processclick));

                                    getDataTypeCheck.setProcessTypeID(Table_part_id);
                                    getDataTypeCheck.setData(Table_ProcessTypeName);
                                    getDataTypeCheck.setProcessclick(Table_Processclick);
                                    Log.e("Table_Processclick",Table_Processclick);
                                    get_data_type_checks.add(getDataTypeCheck);
                                } while (cursor.moveToNext());
                            }
                            cursor.close();


                            recyclerViewadapter = new RecyclerViewAdapter_type_check(get_data_type_checks, this);

                            recyclerview1.setAdapter(recyclerViewadapter);

                            recyclerViewadapter.setitemclick2(this);






                            li_pay2.setVisibility(View.GONE);
                            li_pay2_2.setVisibility(View.GONE);
                            li_install2.setVisibility(View.GONE);
                            li_install3.setVisibility(View.GONE);
                            li4.setVisibility(View.GONE);
                            li7.setVisibility(View.GONE);
                            txt_scan_assa.setVisibility(View.GONE);
                            li_install1.setVisibility(View.GONE);
                            linearlayout_show_problem_sub.setVisibility(View.GONE);
                            li_pay_one.setVisibility(View.GONE);
                            li_pay_two.setVisibility(View.GONE);
                            li_pay_two2.setVisibility(View.GONE);
                            li_pay2.setVisibility(View.GONE);
                            li_confirm.setVisibility(View.GONE);
                            li_confirm2.setVisibility(View.GONE);
                            linear_pen.setVisibility(View.GONE);

                            li_line0.setVisibility(View.GONE);
                            li_line1.setVisibility(View.GONE);
                            li_line2.setVisibility(View.GONE);
                            li_line3.setVisibility(View.GONE);
                            li_line4.setVisibility(View.GONE);
                            li_line5.setVisibility(View.GONE);
                            li_line6.setVisibility(View.VISIBLE);
                            li_save.setVisibility(View.VISIBLE);
                            li_line1234.setVisibility(View.GONE);

                            li_line7.setVisibility(View.GONE);
                            li_line8.setVisibility(View.GONE);
                            li_line9.setVisibility(View.GONE);
                            li_remarket.setVisibility(View.GONE);
                            linearlayout_show_problem_tain.setVisibility(View.GONE);
                            li_install_tain.setVisibility(View.GONE);
                            li_install_re_tain.setVisibility(View.GONE);
                            linearlayout_date_to_date.setVisibility(View.GONE);

                            li_pay2_2_2.setVisibility(View.GONE);
                            li_line10.setVisibility(View.GONE);
                            li_line11.setVisibility(View.GONE);
                            li_line12.setVisibility(View.GONE);
                            li_pay2_2_3.setVisibility(View.GONE);
                            Log.e("assanee","5");


                            lili_1.setVisibility(View.GONE);
                            lili_2.setVisibility(View.GONE);
                            lili_3.setVisibility(View.GONE);
                            lili_line1.setVisibility(View.GONE);
                            lili_line2.setVisibility(View.GONE);
                            li1.setVisibility(View.GONE);
                            li2.setVisibility(View.GONE);
                            lili_text_select4.setVisibility(View.VISIBLE);
                            item_click=4;
                        }
                        else {
                            recyclerview1.setHasFixedSize(true);
                            recyclerViewlayoutManager = new LinearLayoutManager(this);
                            recyclerview1.setLayoutManager(recyclerViewlayoutManager);
                            get_data_type_checks.clear();
                            // recyclerview1.clearOnScrollListeners();
                            JSON_DATA_WEB_CALL();





                            relativeLayout_new.setVisibility(View.GONE);







                            li_pay2.setVisibility(View.GONE);
                            li_pay2_2.setVisibility(View.GONE);
                            li_install2.setVisibility(View.GONE);
                            li_install3.setVisibility(View.GONE);
                            li4.setVisibility(View.GONE);
                            li7.setVisibility(View.GONE);
                            txt_scan_assa.setVisibility(View.GONE);
                            li_install1.setVisibility(View.GONE);
                            linearlayout_show_problem_sub.setVisibility(View.GONE);
                            li_pay_one.setVisibility(View.GONE);
                            li_pay_two.setVisibility(View.GONE);
                            li_pay_two2.setVisibility(View.GONE);
                            li_pay2.setVisibility(View.GONE);
                            li_confirm.setVisibility(View.GONE);
                            li_confirm2.setVisibility(View.GONE);
                            linear_pen.setVisibility(View.GONE);
                            li_line1.setVisibility(View.GONE);
                            li_line2.setVisibility(View.GONE);
                            li_line3.setVisibility(View.GONE);
                            li_line4.setVisibility(View.GONE);
                            li_line5.setVisibility(View.GONE);
                            li_line6.setVisibility(View.GONE);
                            li_save.setVisibility(View.GONE);
                            li_line1234.setVisibility(View.GONE);
                            li_line7.setVisibility(View.GONE);
                            li_line8.setVisibility(View.GONE);
                            li_line9.setVisibility(View.GONE);
                            li_remarket.setVisibility(View.GONE);
                            linearlayout_show_problem_tain.setVisibility(View.GONE);
                            li_install_tain.setVisibility(View.GONE);

                            li_install_re_tain.setVisibility(View.GONE);
                            linearlayout_date_to_date.setVisibility(View.GONE);

                            li_pay2_2_2.setVisibility(View.GONE);
                            li_line10.setVisibility(View.GONE);
                            li_line11.setVisibility(View.GONE);
                            li_line12.setVisibility(View.GONE);
                            li_pay2_2_3.setVisibility(View.GONE);
                            Log.e("assanee","3");
                        }

                    }
                    else {
                        // JSON_DATA_WEB_CALL();
                        recyclerview1.setHasFixedSize(true);
                        recyclerViewlayoutManager = new LinearLayoutManager(this);
                        recyclerview1.setLayoutManager(recyclerViewlayoutManager);
                        get_data_type_checks.clear();
                       // recyclerview1.clearOnScrollListeners();
                        JSON_DATA_WEB_CALL();



                        relativeLayout_new.setVisibility(View.GONE);







                       li_pay2.setVisibility(View.GONE);
                        li_pay2_2.setVisibility(View.GONE);
                        li_install2.setVisibility(View.GONE);
                        li_install3.setVisibility(View.GONE);
                        li4.setVisibility(View.GONE);
                        li7.setVisibility(View.GONE);
                        txt_scan_assa.setVisibility(View.GONE);
                        li_install1.setVisibility(View.GONE);
                        linearlayout_show_problem_sub.setVisibility(View.GONE);
                        li_pay_one.setVisibility(View.GONE);
                        li_pay_two.setVisibility(View.GONE);
                        li_pay_two2.setVisibility(View.GONE);
                        li_pay2.setVisibility(View.GONE);
                        li_confirm.setVisibility(View.GONE);
                        li_confirm2.setVisibility(View.GONE);
                        linear_pen.setVisibility(View.GONE);
                        li_line1.setVisibility(View.GONE);
                        li_line2.setVisibility(View.GONE);
                        li_line3.setVisibility(View.GONE);
                        li_line4.setVisibility(View.GONE);
                        li_line5.setVisibility(View.GONE);
                        li_line6.setVisibility(View.GONE);
                        li_save.setVisibility(View.GONE);
                        li_line1234.setVisibility(View.GONE);
                        li_line7.setVisibility(View.GONE);
                        li_line8.setVisibility(View.GONE);
                        li_line9.setVisibility(View.GONE);
                        li_remarket.setVisibility(View.GONE);
                        linearlayout_show_problem_tain.setVisibility(View.GONE);
                        li_install_tain.setVisibility(View.GONE);

                        li_install_re_tain.setVisibility(View.GONE);
                        linearlayout_date_to_date.setVisibility(View.GONE);

                        li_pay2_2_2.setVisibility(View.GONE);
                        li_line10.setVisibility(View.GONE);
                        li_line11.setVisibility(View.GONE);
                        li_line12.setVisibility(View.GONE);
                        li_pay2_2_3.setVisibility(View.GONE);
                        Log.e("assanee","2");

                    }
                }
                catch (Exception ex){
                    // JSON_DATA_WEB_CALL();
                    recyclerview1.setHasFixedSize(true);
                    recyclerViewlayoutManager = new LinearLayoutManager(this);
                    recyclerview1.setLayoutManager(recyclerViewlayoutManager);
                    get_data_type_checks.clear();
                   // recyclerview1.clearOnScrollListeners();
                    JSON_DATA_WEB_CALL();


                    relativeLayout_new.setVisibility(View.GONE);







                    li_pay2.setVisibility(View.GONE);
                    li_pay2_2.setVisibility(View.GONE);
                    li_install2.setVisibility(View.GONE);
                    li_install3.setVisibility(View.GONE);
                    li4.setVisibility(View.GONE);
                    li7.setVisibility(View.GONE);
                    txt_scan_assa.setVisibility(View.GONE);
                    li_install1.setVisibility(View.GONE);
                    linearlayout_show_problem_sub.setVisibility(View.GONE);
                    li_pay_one.setVisibility(View.GONE);
                    li_pay_two.setVisibility(View.GONE);
                    li_pay_two2.setVisibility(View.GONE);
                    li_pay2.setVisibility(View.GONE);
                    li_confirm.setVisibility(View.GONE);
                    li_confirm2.setVisibility(View.GONE);
                    linear_pen.setVisibility(View.GONE);
                    li_line1.setVisibility(View.GONE);
                    li_line2.setVisibility(View.GONE);
                    li_line3.setVisibility(View.GONE);
                    li_line4.setVisibility(View.GONE);
                    li_line5.setVisibility(View.GONE);
                    li_line6.setVisibility(View.GONE);
                    li_save.setVisibility(View.GONE);
                    li_line1234.setVisibility(View.GONE);
                    li_line7.setVisibility(View.GONE);
                    li_line8.setVisibility(View.GONE);
                    li_line9.setVisibility(View.GONE);
                    li_remarket.setVisibility(View.GONE);
                    linearlayout_show_problem_tain.setVisibility(View.GONE);
                    li_install_tain.setVisibility(View.GONE);

                    li_install_re_tain.setVisibility(View.GONE);
                    linearlayout_date_to_date.setVisibility(View.GONE);

                    li_pay2_2_2.setVisibility(View.GONE);
                    li_line10.setVisibility(View.GONE);
                    li_line11.setVisibility(View.GONE);
                    li_line12.setVisibility(View.GONE);
                    li_pay2_2_3.setVisibility(View.GONE);

                    Log.e("assanee","1");
                }









        String item_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("item")+"";
        String item1_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("item1")+"";

        String item2_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("item2")+"";
        String item3_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("item3")+"";
        String item5_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("item5")+"";
        String item6_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("item6")+"";
        String radioSex_retain_S_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("radioSex_retain_S")+"";
        String radioSex_re_S_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("radioSex_re_S")+"";
        String checkedText_pay_one_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("checkedText_pay_one")+"";
        String checkedText_install_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("checkedText_install")+"";
        String checkedText_confirm_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("checkedText_confirm")+"";

        Log.e("test_ONback",item_ONBACK+" , "+item1_ONBACK+" , "+item2_ONBACK+" , "+item3_ONBACK+" , "+item5_ONBACK+" , "+item6_ONBACK+" , "+radioSex_retain_S_ONBACK+" , "+radioSex_re_S_ONBACK+" , "+checkedText_pay_one_ONBACK+" , "+checkedText_install_ONBACK+" , "+checkedText_confirm_ONBACK);






    }

    float dayCount;
    public String getCountOfDays(String createdDateString, String expireDateString) {

       // Log.e("createdDateString",createdDateString+","+expireDateString);

        SQLiteDataBaseBuild_data_checker_problem_for_report();
        SQLiteTableBuild_data_checker_problem_for_report();

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

         dayCount = 0-((float) diff / (24 * 60 * 60 * 1000));
        Log.e("dayCount", String.valueOf((int) dayCount));
        String NNN="";
        if(new_message_pay2.getText().toString().isEmpty()){
            NNN="-";
        }
        else {
            NNN=new_message_pay2.getText().toString();
        }




        MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_two_nad", String.valueOf((int) dayCount));


       if((int) dayCount>60){


           if(GET_date2.equals("-")){
               txt_day_nad2.setVisibility(View.GONE);
           }
           else {



                   txt_day_nad2.setVisibility(View.VISIBLE);
                   li_pay2.setBackgroundColor(0xffffffff);
               if(check_cb_pay_two==1){
                   cb_pay_two.setChecked(!cb_pay_two.isChecked());
                   check_cb_pay_two=0;
                   MyApplication.getInstance().getPrefManager().setPreferrence("check_cb_pay_two", "0");
               }




           }

            txt_day_nad2.setText(" "+String.valueOf((int) dayCount)+" วัน");

            txt_day_nad2.setTextColor(0xffff0000);
            status_report_problem_pay2=1;



        }



        else {

           if(GET_date2.equals("-")){
               txt_day_nad2.setVisibility(View.GONE);
           }
           else {





                   txt_day_nad2.setVisibility(View.VISIBLE);
                   li_pay2.setBackgroundColor(0xffffffff);

               if(check_cb_pay_two==1){
                   cb_pay_two.setChecked(!cb_pay_two.isChecked());
                   check_cb_pay_two=0;
                   MyApplication.getInstance().getPrefManager().setPreferrence("check_cb_pay_two", "0");
               }

           }



            txt_day_nad2.setText(" "+String.valueOf((int) dayCount)+" วัน");
            txt_day_nad2.setTextColor(0xff228b22);
            status_report_problem_pay2=0;





        }



        return ("" + (int) dayCount + " Days");
    }





    @SuppressLint("ResourceAsColor")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 23 ) {
            conno_intro=MyApplication.getInstance().getPrefManager().getPreferrence("conno_intro");
            conno_scan=MyApplication.getInstance().getPrefManager().getPreferrence("conno_scan");

            try {
                if(ProductSerial.equals(conno_scan)){
                    switcher2.setImageResource(R.drawable.check_box_report_problem);
                    switcher2.setVisibility(View.VISIBLE);
                    txt_scan.setText("หมายเลขตรงกัน "+ProductSerial+":"+conno_scan);
                    txt_scan.setTextColor(0xff66cdaa);
                    error=1;

                    li3.setVisibility(View.GONE);
                    li_qr1.setVisibility(View.GONE);

                     status_report_problem_qr=0;
                    color_error();
                    status_qr=0;
                    li3.setBackgroundColor(0xffffffff);




                    MyApplication.getInstance().getPrefManager().setPreferrence("scan_barcode","หมายเลขตรงกัน "+ProductSerial+":"+conno_scan);
                    MyApplication.getInstance().getPrefManager().setPreferrence("status_qr","0");

              /*      SQLiteDataBaseBuild_data_checker_problem_for_report();
                    SQLiteTableBuild_data_checker_problem_for_report();
                    sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + "" + " WHERE MAIN =" + "'" + "หมายเลขเครื่องไม่ตรงกัน" + "'");

*/







/*                    final ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
                    animator.setRepeatCount(ValueAnimator.INFINITE);
                    animator.setInterpolator(new LinearInterpolator());
                    animator.setDuration(9000L);
                    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            final float progress = (float) animation.getAnimatedValue();
                            final float width = txt_scan.getWidth();
                            final float translationX = width * progress;
                            txt_scan.setTranslationX(translationX);
                           // second.setTranslationX(translationX - width);
                        }
                    });
                    animator.start();*/







                }
                else {
                    switcher2.setImageResource(R.drawable.errorerror);
                    switcher2.setVisibility(View.VISIBLE);
                    txt_scan.setText("หมายเลขไม่ตรงกัน "+ProductSerial+":"+conno_scan);
                    txt_scan.setTextColor(0xfff40707);

                    error=0;

                    li3.setVisibility(View.VISIBLE);
                    li_qr1.setVisibility(View.VISIBLE);
                    status_report_problem_qr=1;





                    MyApplication.getInstance().getPrefManager().setPreferrence("scan_barcode","หมายเลขไม่ตรงกัน "+ProductSerial+":"+conno_scan);
                    MyApplication.getInstance().getPrefManager().setPreferrence("status_qr","1");
















                    status_qr=1;
Log.e("size1", String.valueOf(size1));
                   if(size1==0){

                       li3.setBackgroundColor(0xffff0000);
                   }
                   else {
                       li3.setBackgroundColor(0xffffffff);
                   }


                /*    SQLiteDataBaseBuild_data_checker_problem_for_report();
                    SQLiteTableBuild_data_checker_problem_for_report();
                    String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + " (CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID) VALUES('" + conno + "','" + "ปัญหาการ์ดตรวจสอบ" + "','" + "ปัญหาอื่นๆ" + "','" + "หมายเลขเครื่องไม่ตรงกัน" + "','" + new_message_scan.getText().toString() + "','" + "ตรวจสอบได้ เข้าบ้านลูกค้าได้" + "');";
                    sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
                  */

                    color_error();







/*
                    final ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
                    animator.setRepeatCount(ValueAnimator.INFINITE);
                    animator.setInterpolator(new LinearInterpolator());
                    animator.setDuration(9000L);
                    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            final float progress = (float) animation.getAnimatedValue();
                            final float width = txt_scan.getWidth();
                            final float translationX = width * progress;
                            //txt_scan.setTranslationX(translationX);
                            txt_scan.setTranslationX(translationX - width);
                        }
                    });
                    animator.start();
*/





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
            String FILE2= "";
            String FILE= "";
                try {
                    //VersionOS = android.os.Build.VERSION.RELEASE;

                  //  if((VersionOS.equals("6.0"))|(VersionOS.equals("6.0.0"))|(VersionOS.equals("6.0.1"))|(VersionOS.equals("6.1"))|(VersionOS.equals("6.1.0"))|(VersionOS.equals("7.0"))|(VersionOS.equals("7.0.0"))|(VersionOS.equals("7.0.1"))|(VersionOS.equals("7.1"))|(VersionOS.equals("7.1.0"))|(VersionOS.equals("7.1.1"))|(VersionOS.equals("7.1.2"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.0.0"))|(VersionOS.equals("8.1.0"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.1"))|(VersionOS.equals("8.1.1"))|(VersionOS.equals("9"))|(VersionOS.equals("9.0"))|(VersionOS.equals("9.0.0"))|(VersionOS.equals("9.1"))|(VersionOS.equals("9.1.0"))){
                        FILE2 = MyApplication.getInstance().getPrefManager().getPreferrence("part_image") + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("imageName") + ".jpg";

                        File file21 = new File(FILE2);

                        //File mSaveBit; // Your image file
                        String filePath = file21.getPath();
                        Bitmap bitmap = BitmapFactory.decodeFile(filePath);


                        ic.getResizedBiBitmaptmap(bitmap,"camera");

                        FILE = MyApplication.getInstance().getPrefManager().getPreferrence("part_image") + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+"new" + ".png";
                 //   }
                  //  else {
                    //    FILE=file.getAbsolutePath();
                  // }
                }
                catch (Exception ex){
                //    FILE=file.getAbsolutePath();
                }




            String image_name = MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+"new";



              //  String Url="http://app.thiensurat.co.th/assanee/uploads_image_checker/"+image_name+".png";
            String Url=SERVER_PATH+"uploads_image_checker/"+image_name+".png";



                File file2 = new File(FILE);
                long length = file2.length();
                length = length/1024;

            if (length != 0) {
            Log.e("length_moo1", String.valueOf(length));


                String number="";
                if(check_buttom_remove_image1==1){
                    number = String.valueOf(2);
                }
                else {
                    number= String.valueOf(1);
                }


                SQLiteDataBaseBuild1();
                SQLiteTableBuild1_2();

                String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker1.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "png" + "','" + order_image1 + "');";
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
                    status_qr=1;

                }
                else {
                    my_recycler_view1.setVisibility(View.VISIBLE);
                    status_qr=0;
                    li3.setBackgroundColor(0xffffffff);
                    color_error();

                }

            }
           else {
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

                        try {
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
                        catch (Exception ex){

                        }

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

        }
        else if (requestCode == 2 ) {
            // if(resultCode==RESULT_OK) {
            allSampleData2.clear();
            //CropImage();





            order_image2=order_image2+1;
            order_image2_2=order_image2_2+1;
            MyApplication.getInstance().getPrefManager().getPreferrence("part_image");
            String FILE2= "";
            String FILE= "";
            try {
               // VersionOS = android.os.Build.VERSION.RELEASE;

               // if((VersionOS.equals("6.0"))|(VersionOS.equals("6.0.0"))|(VersionOS.equals("6.0.1"))|(VersionOS.equals("6.1"))|(VersionOS.equals("6.1.0"))|(VersionOS.equals("7.0"))|(VersionOS.equals("7.0.0"))|(VersionOS.equals("7.0.1"))|(VersionOS.equals("7.1"))|(VersionOS.equals("7.1.0"))|(VersionOS.equals("7.1.1"))|(VersionOS.equals("7.1.2"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.0.0"))|(VersionOS.equals("8.1.0"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.1"))|(VersionOS.equals("8.1.1"))|(VersionOS.equals("9"))|(VersionOS.equals("9.0"))|(VersionOS.equals("9.0.0"))|(VersionOS.equals("9.1"))|(VersionOS.equals("9.1.0"))){


                    FILE2 = MyApplication.getInstance().getPrefManager().getPreferrence("part_image") + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("imageName") + ".jpg";

                    File file21 = new File(FILE2);

                    //File mSaveBit; // Your image file
                    String filePath = file21.getPath();
                    Bitmap bitmap = BitmapFactory.decodeFile(filePath);


                    ic.getResizedBiBitmaptmap(bitmap,"camera");

                    FILE = MyApplication.getInstance().getPrefManager().getPreferrence("part_image") + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+"new" + ".png";




                //}
               // else {
               //     FILE=file.getAbsolutePath();
               // }
            }
            catch (Exception ex){
           //     FILE=file.getAbsolutePath();
            }




            String image_name = MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+"new";


            //  Log.e("image_name",image_name);

            //String Url="http://app.thiensurat.co.th/assanee/uploads_image_checker/"+image_name+".png";

            String Url=SERVER_PATH+"uploads_image_checker/"+image_name+".png";
            // Log.e("Url_image_name",Url);

            File file2 = new File(FILE);
            long length = file2.length();
            length = length/1024;

            if (length != 0) {
            Log.e("length_moo2", String.valueOf(length));

            String number="";
            if(check_buttom_remove_image2==1){
                number = String.valueOf(2);
            }
            else {
                number= String.valueOf(1);
            }


            SQLiteDataBaseBuild2();
            SQLiteTableBuild2_2();

            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker2.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "png" + "','" + order_image2 + "');";
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
                color_error();

            }

            }
          else {
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
                        try {
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
                        catch (Exception ex){

                        }

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

        }
        else if (requestCode == 3 ) {
            // if(resultCode==RESULT_OK) {
            allSampleData3.clear();
            //CropImage();





            order_image3=order_image3+1;
            order_image3_2=order_image3_2+1;
            MyApplication.getInstance().getPrefManager().getPreferrence("part_image");


            String FILE2= "";
            String FILE= "";
            try {
               // VersionOS = android.os.Build.VERSION.RELEASE;

             //   if((VersionOS.equals("6.0"))|(VersionOS.equals("6.0.0"))|(VersionOS.equals("6.0.1"))|(VersionOS.equals("6.1"))|(VersionOS.equals("6.1.0"))|(VersionOS.equals("7.0"))|(VersionOS.equals("7.0.0"))|(VersionOS.equals("7.0.1"))|(VersionOS.equals("7.1"))|(VersionOS.equals("7.1.0"))|(VersionOS.equals("7.1.1"))|(VersionOS.equals("7.1.2"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.0.0"))|(VersionOS.equals("8.1.0"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.1"))|(VersionOS.equals("8.1.1"))|(VersionOS.equals("9"))|(VersionOS.equals("9.0"))|(VersionOS.equals("9.0.0"))|(VersionOS.equals("9.1"))|(VersionOS.equals("9.1.0"))){

                    FILE2 = MyApplication.getInstance().getPrefManager().getPreferrence("part_image") + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("imageName") + ".jpg";

                    File file21 = new File(FILE2);

                    //File mSaveBit; // Your image file
                    String filePath = file21.getPath();
                    Bitmap bitmap = BitmapFactory.decodeFile(filePath);


                    ic.getResizedBiBitmaptmap(bitmap,"camera");

                    FILE = MyApplication.getInstance().getPrefManager().getPreferrence("part_image") + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+"new" + ".png";
              //  }
               // else {
               //     FILE=file.getAbsolutePath();
               // }
            }
            catch (Exception ex){
              //  FILE=file.getAbsolutePath();
            }





            String image_name = MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+"new";


            //  Log.e("image_name",image_name);

          //  String Url="http://app.thiensurat.co.th/assanee/uploads_image_checker/"+image_name+".png";
            String Url=SERVER_PATH+"uploads_image_checker/"+image_name+".png";
            // Log.e("Url_image_name",Url);

            File file2 = new File(FILE);
            long length = file2.length();
            length = length/1024;

            if (length != 0) {
                Log.e("length_moo3", String.valueOf(length));


                String number = "";
                if (check_buttom_remove_image3 == 1) {
                    number = String.valueOf(2);
                } else {
                    number = String.valueOf(1);
                }


                SQLiteDataBaseBuild3();
                SQLiteTableBuild3_2();

                String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker3.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "png" + "','" + order_image3 + "');";
                // String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (part_id,part_image,type_image) VALUES('" + id_image_success + "', '" + file.getAbsolutePath() + "', '" + "image_success" + "');";
                sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);


                for (int i = 1; i <= 1; i++) {

                    SectionDataModel_checker3 dm = new SectionDataModel_checker3();

                    dm.setHeaderTitle("ล่าสุด ");

                    ArrayList<SingleItemModel_checker3> singleItem = new ArrayList<SingleItemModel_checker3>();


                    if (check_buttom_remove_image3 == 1) {
                        cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker3.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
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
                    } else {

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
                if (size3 == 0) {
                    my_recycler_view3.setVisibility(View.GONE);
                } else {
                    my_recycler_view3.setVisibility(View.VISIBLE);
                    color_error();

                }

            }
            else {

                for (int i = 1; i <= 1; i++) {

                    SectionDataModel_checker3 dm = new SectionDataModel_checker3();

                    dm.setHeaderTitle("ล่าสุด ");

                    ArrayList<SingleItemModel_checker3> singleItem = new ArrayList<SingleItemModel_checker3>();


                    if (check_buttom_remove_image3 == 1) {
                        cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker3.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
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
                    } else {


                        try {
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
                        catch (Exception ex){

                        }

                    }


                    dm.setAllItemsInSection(singleItem);

                    allSampleData3.add(dm);


                }


                RecyclerViewDataAdapter_image3 adapter = new RecyclerViewDataAdapter_image3(this, allSampleData3);
                my_recycler_view3.setAdapter(adapter);
                adapter.setitemclick_deleteAll3(this);
                if (size3 == 0) {
                    my_recycler_view3.setVisibility(View.GONE);
                } else {
                    my_recycler_view3.setVisibility(View.VISIBLE);


                }
            }

        }
        else if (requestCode == 4 ) {
            // if(resultCode==RESULT_OK) {





            allSampleData4.clear();



            //CropImage();



            order_image4 = order_image4 + 1;
            order_image4_2 = order_image4_2 + 1;
            MyApplication.getInstance().getPrefManager().getPreferrence("part_image");
            String FILE2= "";
            String FILE= "";

            try {
             //   VersionOS = android.os.Build.VERSION.RELEASE;

               // if ((VersionOS.equals("6.0")) | (VersionOS.equals("6.0.0")) | (VersionOS.equals("6.0.1")) | (VersionOS.equals("6.1")) | (VersionOS.equals("6.1.0")) | (VersionOS.equals("7.0")) | (VersionOS.equals("7.0.0")) | (VersionOS.equals("7.0.1")) | (VersionOS.equals("7.1")) | (VersionOS.equals("7.1.0")) | (VersionOS.equals("7.1.1")) | (VersionOS.equals("7.1.2")) | (VersionOS.equals("8.0")) | (VersionOS.equals("8.0.0")) | (VersionOS.equals("8.1.0")) | (VersionOS.equals("8.0")) | (VersionOS.equals("8.1")) | (VersionOS.equals("8.1.1"))|(VersionOS.equals("9")) | (VersionOS.equals("9.0")) | (VersionOS.equals("9.0.0")) | (VersionOS.equals("9.1")) | (VersionOS.equals("9.1.0"))) {




                    FILE2 = MyApplication.getInstance().getPrefManager().getPreferrence("part_image") + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("imageName") + ".jpg";

                    File file21 = new File(FILE2);

                    //File mSaveBit; // Your image file
                    String filePath = file21.getPath();
                    Bitmap bitmap = BitmapFactory.decodeFile(filePath);


                    ic.getResizedBiBitmaptmap(bitmap,"camera");

                    FILE = MyApplication.getInstance().getPrefManager().getPreferrence("part_image") + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+"new" + ".png";

               // }


                //else {
                //    FILE = file.getAbsolutePath();

                  //  Log.e("FILE",FILE);


             //   }






            } catch (Exception ex) {
            //    FILE = file.getAbsolutePath();
            }

            //compressedImageFile = new Compressor(this).compressToFile(actualImageFile);


            String image_name = MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+"new";


            //  Log.e("image_name",image_name);

          //  String Url = "http://app.thiensurat.co.th/assanee/uploads_image_checker/" + image_name + ".png";
            String Url=SERVER_PATH+"uploads_image_checker/"+image_name+".png";
            // Log.e("Url_image_name",Url);

            File file2 = new File(FILE);
            long length = file2.length();
            length = length / 1024;




            if (length != 0) {






            String number = "";
            if (check_buttom_remove_image4 == 1) {
                number = String.valueOf(2);
            } else {
                number = String.valueOf(1);
            }


            SQLiteDataBaseBuild4();
            SQLiteTableBuild4_2();

            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker4.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "png" + "','" + order_image4 + "');";
            // String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (part_id,part_image,type_image) VALUES('" + id_image_success + "', '" + file.getAbsolutePath() + "', '" + "image_success" + "');";
            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);


            for (int i = 1; i <= 1; i++) {

                SectionDataModel_checker4 dm = new SectionDataModel_checker4();

                dm.setHeaderTitle("ล่าสุด ");

                ArrayList<SingleItemModel_checker4> singleItem = new ArrayList<SingleItemModel_checker4>();


                if (check_buttom_remove_image4 == 1) {
                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker4.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_order_image));
                           // Log.e("A", FA);

                            // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                            // String f= String.valueOf(order_image);
                            singleItem.add(new SingleItemModel_checker4("รูป " + f, FA));

                            size4 = singleItem.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                } else {

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

            Log.e("size4size4", String.valueOf(size4));
            if (size4 == 0) {
                my_recycler_view4.setVisibility(View.GONE);
            } else {
                my_recycler_view4.setVisibility(View.VISIBLE);


                color_error();
                //MyApplication.getInstance().getPrefManager().setPreferrence("part_image", "null");
            }

        }
        else {



                for (int i = 1; i <= 1; i++) {

                    SectionDataModel_checker4 dm = new SectionDataModel_checker4();

                    dm.setHeaderTitle("ล่าสุด ");

                    ArrayList<SingleItemModel_checker4> singleItem = new ArrayList<SingleItemModel_checker4>();


                    if (check_buttom_remove_image4 == 1) {
                        cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker4.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                        if (cursor.moveToFirst()) {
                            do {

                                String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_url_image));
                                String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_order_image));

                                singleItem.add(new SingleItemModel_checker4("รูป " + f, FA));

                                size4 = singleItem.size();
                                MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                            } while (cursor.moveToNext());
                        }
                        cursor.close();
                    } else {

                        try {
                            cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker4.TABLE_NAME + "", null);
                            if (cursor.moveToFirst()) {
                                do {

                                    String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_url_image));
                                    String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker4.Table_order_image));
                                    // Log.e("AAAAAAAA", FA);

                                    // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                                    // String f= String.valueOf(order_image);
                                    singleItem.add(new SingleItemModel_checker4("รูป " + f, FA));

                                    size4 = singleItem.size();
                                    MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                                } while (cursor.moveToNext());
                            }
                            cursor.close();
                        }
                        catch (Exception dd){

                        }


                    }


                    dm.setAllItemsInSection(singleItem);

                    allSampleData4.add(dm);


                }


                RecyclerViewDataAdapter_image4 adapter = new RecyclerViewDataAdapter_image4(this, allSampleData4);
                my_recycler_view4.setAdapter(adapter);
                adapter.setitemclick_deleteAll3(this);

                Log.e("size4size4", String.valueOf(size4));
                if (size4 == 0) {
                    my_recycler_view4.setVisibility(View.GONE);
                } else {
                    my_recycler_view4.setVisibility(View.VISIBLE);

                }


            }



        }
        else if (requestCode == 5 ) {
            // if(resultCode==RESULT_OK) {
            allSampleData5.clear();
            //CropImage();





            order_image5=order_image5+1;
            order_image5_2=order_image5_2+1;
            MyApplication.getInstance().getPrefManager().getPreferrence("part_image");


            String FILE2= "";
            String FILE= "";
            try {

                    FILE2 = MyApplication.getInstance().getPrefManager().getPreferrence("part_image") + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("imageName") + ".jpg";
                    File file21 = new File(FILE2);
                    String filePath = file21.getPath();
                    Bitmap bitmap = BitmapFactory.decodeFile(filePath);
                    ic.getResizedBiBitmaptmap(bitmap,"camera");
                    FILE = MyApplication.getInstance().getPrefManager().getPreferrence("part_image") + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+"new" + ".png";

            }
            catch (Exception ex){
            }




            String image_name = MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+"new";

         //   String Url = "http://app.thiensurat.co.th/assanee/uploads_image_checker/" + image_name + ".png";
            String Url=SERVER_PATH+"uploads_image_checker/"+image_name+".png";
            // Log.e("Url_image_name",Url);

            File file2 = new File(FILE);
            long length = file2.length();
            length = length/1024;

            if (length != 0) {
            Log.e("length_moo5", String.valueOf(length));




            String number="";
            if(check_buttom_remove_image5==1){
                number = String.valueOf(2);
            }
            else {
                number= String.valueOf(1);
            }


            SQLiteDataBaseBuild5();
            SQLiteTableBuild5_2();

            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker5.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "png" + "','" + order_image5 + "');";
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

            }
           else {
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



                        try {
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
                        catch (Exception ex){

                        }





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

        }
        else if (requestCode == 6 ) {
            allSampleData1.clear();


            String FILE="";
            String DD="";
            String image_name="";
            String image_type="";
            int size_arr;


                    try {
                        Uri uri = data.getData();
                        String[] projection = {MediaStore.Images.Media.DATA};

                        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
                        cursor.moveToFirst();

                        int columnIndex = cursor.getColumnIndex(projection[0]);
                        String filepath = cursor.getString(columnIndex);


/*                        Log.e("filepath",filepath);
                        FILE =filepath;
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



                        order_image1=order_image1+1;
                        order_image1_2=order_image1_2+1;



                        String Url=SERVER_PATH+"uploads_image_checker/"+image_name+".png";

                        // Log.e("Url_image_name",Url);

                        File file2 = new File(FILE);
                        long length = file2.length();
                        length = length/1024;

                        if (length != 0) {
                            String number = "";
                            if (check_buttom_remove_image1 == 1) {
                                number = String.valueOf(2);
                            } else {
                                number = String.valueOf(1);
                            }

                            SQLiteDataBaseBuild1();
                            SQLiteTableBuild1_2();

                            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker1.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "png" + "','" + order_image1 + "');";
                            // String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (part_id,part_image,type_image) VALUES('" + id_image_success + "', '" + file.getAbsolutePath() + "', '" + "image_success" + "');";
                            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);


                            for (int i = 1; i <= 1; i++) {

                                SectionDataModel_checker1 dm = new SectionDataModel_checker1();

                                dm.setHeaderTitle("ล่าสุด ");

                                ArrayList<SingleItemModel_checker1> singleItem = new ArrayList<SingleItemModel_checker1>();


                                if (check_buttom_remove_image1 == 1) {
                                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker1.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
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
                                } else {


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
                            if (size1 == 0) {
                                my_recycler_view1.setVisibility(View.GONE);
                                status_qr = 1;
                            } else {
                                my_recycler_view1.setVisibility(View.VISIBLE);
                                status_qr = 0;
                                li3.setBackgroundColor(0xffffffff);
                                color_error();
                            }

                        }
                        else {
                            size1=0;
                            my_recycler_view1.setVisibility(View.GONE);
                        }
                    }
                    catch (Exception ex){

                    }



        }
        else if (requestCode == 7 ) {

            allSampleData2.clear();




            String FILE="";
            String DD="";
            String image_name="";
            String image_type="";
            int size_arr;


                    try {
                        Uri uri = data.getData();
                        String[] projection = {MediaStore.Images.Media.DATA};

                        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
                        cursor.moveToFirst();

                        int columnIndex = cursor.getColumnIndex(projection[0]);
                        String filepath = cursor.getString(columnIndex);


/*                        Log.e("filepath",filepath);
                        FILE =filepath;
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

                        order_image2=order_image2+1;
                        order_image2_2=order_image2_2+1;











                        //  Log.e("image_name",image_name);

                    //    String Url="http://app.thiensurat.co.th/assanee/uploads_image_checker/"+image_name+".jpg";
                        String Url=SERVER_PATH+"uploads_image_checker/"+image_name+".png";
                        // Log.e("Url_image_name",Url);

                        File file2 = new File(FILE);
                        long length = file2.length();
                        length = length/1024;

                        if (length != 0) {
                            String number = "";
                            if (check_buttom_remove_image2 == 1) {
                                number = String.valueOf(2);
                            } else {
                                number = String.valueOf(1);
                            }

                            SQLiteDataBaseBuild2();
                            SQLiteTableBuild2_2();

                            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker2.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "png" + "','" + order_image2 + "');";
                            // String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (part_id,part_image,type_image) VALUES('" + id_image_success + "', '" + file.getAbsolutePath() + "', '" + "image_success" + "');";
                            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);


                            for (int i = 1; i <= 1; i++) {

                                SectionDataModel_checker2 dm = new SectionDataModel_checker2();

                                dm.setHeaderTitle("ล่าสุด ");

                                ArrayList<SingleItemModel_checker2> singleItem = new ArrayList<SingleItemModel_checker2>();


                                if (check_buttom_remove_image2 == 1) {
                                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker2.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
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
                                } else {


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
                            if (size2 == 0) {
                                my_recycler_view2.setVisibility(View.GONE);
                            } else {
                                my_recycler_view2.setVisibility(View.VISIBLE);
                                color_error();
                            }
                        }
                        else {
                            size2=0;
                            my_recycler_view2.setVisibility(View.GONE);
                        }
                    }
                    catch (Exception ex){

                    }


        }
        else if (requestCode == 8 ) {

            allSampleData3.clear();





            String FILE="";
            String DD="";
            String image_name="";
            String image_type="";
            int size_arr;



                    try {
                        Uri uri = data.getData();
                        String[] projection = {MediaStore.Images.Media.DATA};

                        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
                        cursor.moveToFirst();

                        int columnIndex = cursor.getColumnIndex(projection[0]);
                        String filepath = cursor.getString(columnIndex);


/*                        Log.e("filepath",filepath);
                        FILE =filepath;
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


                        order_image3=order_image3+1;
                        order_image3_2=order_image3_2+1;





                       // String Url="http://app.thiensurat.co.th/assanee/uploads_image_checker/"+image_name+".jpg";
                        String Url=SERVER_PATH+"uploads_image_checker/"+image_name+".jpg";
                        // Log.e("Url_image_name",Url);

                        File file2 = new File(FILE);
                        long length = file2.length();
                        length = length/1024;

                        if (length != 0) {
                            String number = "";
                            if (check_buttom_remove_image3 == 1) {
                                number = String.valueOf(2);
                            } else {
                                number = String.valueOf(1);
                            }

                            SQLiteDataBaseBuild3();
                            SQLiteTableBuild3_2();

                            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker3.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "png" + "','" + order_image3 + "');";
                            // String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (part_id,part_image,type_image) VALUES('" + id_image_success + "', '" + file.getAbsolutePath() + "', '" + "image_success" + "');";
                            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);


                            for (int i = 1; i <= 1; i++) {

                                SectionDataModel_checker3 dm = new SectionDataModel_checker3();

                                dm.setHeaderTitle("ล่าสุด ");

                                ArrayList<SingleItemModel_checker3> singleItem = new ArrayList<SingleItemModel_checker3>();


                                if (check_buttom_remove_image3 == 1) {
                                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker3.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
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
                                } else {


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
                            if (size3 == 0) {
                                my_recycler_view3.setVisibility(View.GONE);
                            } else {
                                my_recycler_view3.setVisibility(View.VISIBLE);
                                color_error();
                            }
                        }
                        else {
                            size3=0;
                            my_recycler_view3.setVisibility(View.GONE);
                        }
                    }
                    catch (Exception ex){

                    }

        }
        else if (requestCode == 9 ) {

            allSampleData4.clear();


            String FILE="";
            String DD="";
            String image_name="";
            String image_type="";
            int size_arr;



            try {
                Uri uri = data.getData();
                String[] projection = {MediaStore.Images.Media.DATA};

                Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(projection[0]);
                String filepath = cursor.getString(columnIndex);


/*                Log.e("filepath",filepath);
                FILE =filepath;
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





                order_image4=order_image4+1;
                order_image4_2=order_image4_2+1;
     /*       MyApplication.getInstance().getPrefManager().getPreferrence("part_image");
            String FILE="";
            try {
                VersionOS = MyApplication.getInstance().getPrefManager().getPreferrence("VersionOS");

                if((VersionOS.equals("6.0"))|(VersionOS.equals("6.0.0"))|(VersionOS.equals("6.0.1"))|(VersionOS.equals("6.1"))|(VersionOS.equals("6.1.0"))|(VersionOS.equals("7.0"))|(VersionOS.equals("7.0.0"))|(VersionOS.equals("7.0.1"))|(VersionOS.equals("7.1"))|(VersionOS.equals("7.1.0"))|(VersionOS.equals("7.1.1"))|(VersionOS.equals("7.1.2"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.0.0"))|(VersionOS.equals("8.1.0"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.1"))|(VersionOS.equals("8.1.1"))|(VersionOS.equals("9.0"))|(VersionOS.equals("9.0.0"))|(VersionOS.equals("9.1"))|(VersionOS.equals("9.1.0"))){
                    FILE=MyApplication.getInstance().getPrefManager().getPreferrence("part_image")+"/"+MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+".jpg";
                }
                else {
                    FILE=file.getAbsolutePath();
                }
            }
            catch (Exception ex){
                try {
                    FILE=file.getAbsolutePath();
                }
                catch (Exception e){

                }

            }*/






                //  String image_name=MyApplication.getInstance().getPrefManager().getPreferrence("imageName");


                //  Log.e("image_name",image_name);

                //String Url="http://app.thiensurat.co.th/assanee/uploads_image_checker/"+image_name+".jpg";
                String Url=SERVER_PATH+"uploads_image_checker/"+image_name+".png";
                // Log.e("Url_image_name",Url);

                File file2 = new File(FILE);

                Log.e("FILE_9", String.valueOf(file2));
                long length = file2.length();
                length = length/1024;

                if (length != 0) {

                    Log.e("length4_1", String.valueOf(length));

                    String number = "";
                    if (check_buttom_remove_image4 == 1) {
                        number = String.valueOf(2);
                    } else {
                        number = String.valueOf(1);
                    }

                    SQLiteDataBaseBuild4();
                    SQLiteTableBuild4_2();

                    String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker4.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "png" + "','" + order_image4 + "');";
                    // String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (part_id,part_image,type_image) VALUES('" + id_image_success + "', '" + file.getAbsolutePath() + "', '" + "image_success" + "');";
                    sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);


                    for (int i = 1; i <= 1; i++) {

                        SectionDataModel_checker4 dm = new SectionDataModel_checker4();

                        dm.setHeaderTitle("ล่าสุด ");

                        ArrayList<SingleItemModel_checker4> singleItem = new ArrayList<SingleItemModel_checker4>();


                        if (check_buttom_remove_image4 == 1) {
                            cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker4.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
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
                        } else {


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
                    if (size4 == 0) {
                        my_recycler_view4.setVisibility(View.GONE);
                    } else {
                        my_recycler_view4.setVisibility(View.VISIBLE);
                        color_error();
                    }
                }
                else {
                    Log.e("length4_2", String.valueOf(length));
                    size4=0;
                    my_recycler_view4.setVisibility(View.GONE);

                }
            }
            catch (Exception ex){

            }

        }
        else if (requestCode == 10 ) {
            allSampleData5.clear();




            String FILE="";
            String DD="";
            String image_name="";
            String image_type="";
            int size_arr;


                try {
                    Uri uri = data.getData();
                    String[] projection = {MediaStore.Images.Media.DATA};

                    Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(projection[0]);
                    String filepath = cursor.getString(columnIndex);


/*                    Log.e("filepath",filepath);
                    FILE =filepath;
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

                    order_image5=order_image5+1;
                    order_image5_2=order_image5_2+1;



                  /*          MyApplication.getInstance().getPrefManager().getPreferrence("part_image");
                            String FILE="";
                            try {
                                VersionOS = MyApplication.getInstance().getPrefManager().getPreferrence("VersionOS");

                                if((VersionOS.equals("6.0"))|(VersionOS.equals("6.0.0"))|(VersionOS.equals("6.0.1"))|(VersionOS.equals("6.1"))|(VersionOS.equals("6.1.0"))|(VersionOS.equals("7.0"))|(VersionOS.equals("7.0.0"))|(VersionOS.equals("7.0.1"))|(VersionOS.equals("7.1"))|(VersionOS.equals("7.1.0"))|(VersionOS.equals("7.1.1"))|(VersionOS.equals("7.1.2"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.0.0"))|(VersionOS.equals("8.1.0"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.1"))|(VersionOS.equals("8.1.1"))|(VersionOS.equals("9.0"))|(VersionOS.equals("9.0.0"))|(VersionOS.equals("9.1"))|(VersionOS.equals("9.1.0"))){
                                    FILE=MyApplication.getInstance().getPrefManager().getPreferrence("part_image")+"/"+MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+".jpg";
                                }
                                else {
                                    FILE=file.getAbsolutePath();
                                }
                            }
                            catch (Exception ex){
                                try {
                                    FILE=file.getAbsolutePath();
                                }
                                catch (Exception e){

                                }

                            }




                            String image_name=MyApplication.getInstance().getPrefManager().getPreferrence("imageName");*/





                    //  Log.e("image_name",image_name);

                //    String Url="http://app.thiensurat.co.th/assanee/uploads_image_checker/"+image_name+".jpg";
                    String Url=SERVER_PATH+"uploads_image_checker/"+image_name+".png";
                    // Log.e("Url_image_name",Url);

                    File file2 = new File(FILE);
                    long length = file2.length();
                    length = length/1024;

                    if (length != 0) {
                        String number = "";
                        if (check_buttom_remove_image5 == 1) {
                            number = String.valueOf(2);
                        } else {
                            number = String.valueOf(1);
                        }

                        SQLiteDataBaseBuild5();
                        SQLiteTableBuild5_2();

                        String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker5.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "png" + "','" + order_image5 + "');";
                        // String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (part_id,part_image,type_image) VALUES('" + id_image_success + "', '" + file.getAbsolutePath() + "', '" + "image_success" + "');";
                        sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);


                        for (int i = 1; i <= 1; i++) {

                            SectionDataModel_checker5 dm = new SectionDataModel_checker5();

                            dm.setHeaderTitle("ล่าสุด ");

                            ArrayList<SingleItemModel_checker5> singleItem = new ArrayList<SingleItemModel_checker5>();


                            if (check_buttom_remove_image5 == 1) {
                                cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker5.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
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
                            } else {


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
                        if (size5 == 0) {
                            my_recycler_view5.setVisibility(View.GONE);
                        } else {
                            my_recycler_view5.setVisibility(View.VISIBLE);
                            color_error();
                        }
                    }
                    else {
                        size5=0;
                        my_recycler_view5.setVisibility(View.GONE);

                    }
                }
                catch (Exception ex){

                }



        }

        else if(requestCode == 11 ){


            String CHECK_SAVE_MAP= MyApplication.getInstance().getPrefManager().getPreferrence("check_status_map_save");
            if(CHECK_SAVE_MAP.equals("1")){
                // if(resultCode==RESULT_OK) {
                allSampleData_map.clear();
                //CropImage();





                order_image_map=order_image_map+1;
                order_image_map_2=order_image_map_2+1;







                MyApplication.getInstance().getPrefManager().getPreferrence("part_image");
                String FILE="";
                try {
                    VersionOS = android.os.Build.VERSION.RELEASE;

                    if((VersionOS.equals("6.0"))|(VersionOS.equals("6.0.0"))|(VersionOS.equals("6.0.1"))|(VersionOS.equals("6.1"))|(VersionOS.equals("6.1.0"))|(VersionOS.equals("7.0"))|(VersionOS.equals("7.0.0"))|(VersionOS.equals("7.0.1"))|(VersionOS.equals("7.1"))|(VersionOS.equals("7.1.0"))|(VersionOS.equals("7.1.1"))|(VersionOS.equals("7.1.2"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.0.0"))|(VersionOS.equals("8.1.0"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.1"))|(VersionOS.equals("8.1.1"))|(VersionOS.equals("9"))|(VersionOS.equals("9.0"))|(VersionOS.equals("9.0.0"))|(VersionOS.equals("9.1"))|(VersionOS.equals("9.1.0"))){
                        FILE=MyApplication.getInstance().getPrefManager().getPreferrence("part_image")+"/"+MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+".jpg";
                    }
                    else {
                        FILE=imageFile.getAbsolutePath();
                    }
                }
                catch (Exception ex){
                    try {
                        FILE=imageFile.getAbsolutePath();
                    }
                    catch (Exception dd){

                    }

                }




                String image_name=MyApplication.getInstance().getPrefManager().getPreferrence("imageName");
                //String Url="http://app.thiensurat.co.th/assanee/uploads_image_checker/"+image_name+".jpg";
                String Url=SERVER_PATH+"uploads_image_checker/"+image_name+".jpg";
                File file2 = new File(FILE);
                long length = file2.length();
                length = length/1024;

                if (length != 0) {
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

                }
                else {
                    size_map=0;
                    my_recycler_view_map.setVisibility(View.GONE);
                }
            }
            else {
                // if(resultCode==RESULT_OK) {
                allSampleData_map.clear();
                //CropImage();





               // order_image_map=order_image_map+1;
               // order_image_map_2=order_image_map_2+1;







                MyApplication.getInstance().getPrefManager().getPreferrence("part_image");
                String FILE="";
                try {
                    VersionOS = android.os.Build.VERSION.RELEASE;

                    if((VersionOS.equals("6.0"))|(VersionOS.equals("6.0.0"))|(VersionOS.equals("6.0.1"))|(VersionOS.equals("6.1"))|(VersionOS.equals("6.1.0"))|(VersionOS.equals("7.0"))|(VersionOS.equals("7.0.0"))|(VersionOS.equals("7.0.1"))|(VersionOS.equals("7.1"))|(VersionOS.equals("7.1.0"))|(VersionOS.equals("7.1.1"))|(VersionOS.equals("7.1.2"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.0.0"))|(VersionOS.equals("8.1.0"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.1"))|(VersionOS.equals("8.1.1"))|(VersionOS.equals("9"))|(VersionOS.equals("9.0"))|(VersionOS.equals("9.0.0"))|(VersionOS.equals("9.1"))|(VersionOS.equals("9.1.0"))){
                        FILE=MyApplication.getInstance().getPrefManager().getPreferrence("part_image")+"/"+MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+".jpg";
                    }
                    else {
                        FILE=imageFile.getAbsolutePath();
                    }
                }
                catch (Exception ex){
                    try {
                        FILE=imageFile.getAbsolutePath();
                    }
                    catch (Exception dd){

                    }

                }




                String image_name=MyApplication.getInstance().getPrefManager().getPreferrence("imageName");
                //String Url="http://app.thiensurat.co.th/assanee/uploads_image_checker/"+image_name+".jpg";
                String Url=SERVER_PATH+"uploads_image_checker/"+image_name+".jpg";
                File file2 = new File(FILE);
                long length = file2.length();
                length = length/1024;

                if (length != 0) {
                    String number="";
                    if(check_buttom_remove_image_map==1){
                        number = String.valueOf(2);
                    }
                    else {
                        number= String.valueOf(1);
                    }


                    SQLiteDataBaseBuild_map();
                    SQLiteTableBuild_map_2();

                 //   String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer_checker_map.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "jpg" + "','" + order_image_map + "');";
                    // String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (part_id,part_image,type_image) VALUES('" + id_image_success + "', '" + file.getAbsolutePath() + "', '" + "image_success" + "');";
                 //   sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);









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

                }
                else {
                    size_map=0;
                    my_recycler_view_map.setVisibility(View.GONE);
                }
            }



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
               Intent = new Intent(Detali_check1.this, MainActivity_barcode.class);

               startActivityForResult(Intent, 23);
           }
           else if(v==txt_scan){
               Intent = new Intent(Detali_check1.this, MainActivity_barcode.class);

               startActivityForResult(Intent, 23);
           }
           else if(v==switcher2){
               if(error==0){
                   new SweetAlertDialog(Detali_check1.this, SweetAlertDialog.ERROR_TYPE)

                           .setTitleText("สแกนแล้ว!")
                           .setContentText("หมายเลขไม่ตรงกัน!")
                           .show();
               }
               else {
                   new SweetAlertDialog(Detali_check1.this, SweetAlertDialog.SUCCESS_TYPE)
                           .setTitleText("สแกนแล้ว!")
                           .setContentText("หมายเลขตรงกัน!")
                           .show();
               }
           }
           else if(v==location){
               MyApplication.getInstance().getPrefManager().setPreferrence("check_status_map_save", "0");

               Intent Intent = new Intent( this, MapsActivity.class);
               startActivityForResult(Intent, 11);
           }
           else if(v==open_camera){
               checkCameraPermission();



                       try {
                           if ((VersionOSM.equals("5.0"))|(VersionOSM.equals("5.0.1"))|(VersionOSM.equals("5.0.2"))|(VersionOSM.equals("5.1.3"))|(VersionOSM.equals("5.1"))|(VersionOSM.equals("5.1.1"))|(VersionOSM.equals("5.1.0"))|(VersionOSM.equals("5.1.2"))) {
                               CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                               ic = new ImageConfiguration(this,PATH);
                               file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                                       "report_problem", "ALL");


                               fileUri = Uri.fromFile(file);
                               CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                               startActivityForResult(CamIntent, 1);
                           } /*else  if((VersionOSM.equals("6.0"))|(VersionOSM.equals("6.0.0"))|(VersionOSM.equals("6.0.1"))|(VersionOSM.equals("6.1"))|(VersionOSM.equals("6.1.0"))|(VersionOSM.equals("7.0"))|(VersionOSM.equals("7.0.0"))|(VersionOSM.equals("7.0.1"))|(VersionOSM.equals("7.1"))|(VersionOSM.equals("7.1.0"))|(VersionOSM.equals("7.1.1"))|(VersionOSM.equals("7.1.2"))|(VersionOSM.equals("8.0"))|(VersionOSM.equals("8.0.0"))|(VersionOSM.equals("8.1.0"))|(VersionOSM.equals("8.0"))|(VersionOSM.equals("8.1"))|(VersionOSM.equals("8.1.1"))|(VersionOSM.equals("9"))|(VersionOSM.equals("9.0"))|(VersionOSM.equals("9.0.0"))|(VersionOSM.equals("9.1"))|(VersionOSM.equals("9.1.0"))) {

                               if (!marshMallowPermission.checkPermissionForCamera()) {
                                   marshMallowPermission.requestPermissionForCamera();


                               } else {
                                   if (!marshMallowPermission.checkPermissionForExternalStorage()) {
                                       marshMallowPermission.requestPermissionForExternalStorage();
                                   } else {

                                       CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                       //CamIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                                       ic = new ImageConfiguration(this, PATH);
                                       file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
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
                           }*/


                           else {
  /*                             CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                               ic = new ImageConfiguration(this,PATH);
                               file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                                       "report_problem", "ALL");

                               fileUri = FileProvider.getUriForFile(this,
                                       BuildConfig.APPLICATION_ID + ".provider",
                                       file);
                               // fileUri = Uri.fromFile(file);
                               CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                               startActivityForResult(CamIntent, 1);*/



                               if (!marshMallowPermission.checkPermissionForCamera()) {
                                   marshMallowPermission.requestPermissionForCamera();


                               } else {
                                   if (!marshMallowPermission.checkPermissionForExternalStorage()) {
                                       marshMallowPermission.requestPermissionForExternalStorage();
                                   } else {

                                       CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                       //CamIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                                       ic = new ImageConfiguration(this, PATH);
                                       file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
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
                       } catch (Exception ex) {





                           try {
                               CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                               ic = new ImageConfiguration(this,PATH);
                               file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
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
                       file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                               "report_problem", "ALL");


                       fileUri = Uri.fromFile(file);
                       CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                       startActivityForResult(CamIntent, 2);
                   } /*else  if((VersionOSM.equals("6.0"))|(VersionOSM.equals("6.0.0"))|(VersionOSM.equals("6.0.1"))|(VersionOSM.equals("6.1"))|(VersionOSM.equals("6.1.0"))|(VersionOSM.equals("7.0"))|(VersionOSM.equals("7.0.0"))|(VersionOSM.equals("7.0.1"))|(VersionOSM.equals("7.1"))|(VersionOSM.equals("7.1.0"))|(VersionOSM.equals("7.1.1"))|(VersionOSM.equals("7.1.2"))|(VersionOSM.equals("8.0"))|(VersionOSM.equals("8.0.0"))|(VersionOSM.equals("8.1.0"))|(VersionOSM.equals("8.0"))|(VersionOSM.equals("8.1"))|(VersionOSM.equals("8.1.1"))|(VersionOSM.equals("9"))|(VersionOSM.equals("9.0"))|(VersionOSM.equals("9.0.0"))|(VersionOSM.equals("9.1"))|(VersionOSM.equals("9.1.0"))) {

                       if (!marshMallowPermission.checkPermissionForCamera()) {
                           marshMallowPermission.requestPermissionForCamera();


                       } else {
                           if (!marshMallowPermission.checkPermissionForExternalStorage()) {
                               marshMallowPermission.requestPermissionForExternalStorage();
                           } else {

                               CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               //CamIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                               ic = new ImageConfiguration(this, PATH);
                               file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
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
                   }*/


                   else {
/*                       CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                       ic = new ImageConfiguration(this,PATH);
                       file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                               "report_problem", "ALL");

                       fileUri = FileProvider.getUriForFile(this,
                               BuildConfig.APPLICATION_ID + ".provider",
                               file);
                       // fileUri = Uri.fromFile(file);
                       CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                       startActivityForResult(CamIntent, 2);*/



                       if (!marshMallowPermission.checkPermissionForCamera()) {
                           marshMallowPermission.requestPermissionForCamera();


                       } else {
                           if (!marshMallowPermission.checkPermissionForExternalStorage()) {
                               marshMallowPermission.requestPermissionForExternalStorage();
                           } else {

                               CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               //CamIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                               ic = new ImageConfiguration(this, PATH);
                               file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
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
               } catch (Exception ex) {





                   try {
                       CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                       ic = new ImageConfiguration(this,PATH);
                       file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
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
                       file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                               "report_problem", "ALL");


                       fileUri = Uri.fromFile(file);
                       CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                       startActivityForResult(CamIntent, 3);
                   } /*else  if((VersionOSM.equals("6.0"))|(VersionOSM.equals("6.0.0"))|(VersionOSM.equals("6.0.1"))|(VersionOSM.equals("6.1"))|(VersionOSM.equals("6.1.0"))|(VersionOSM.equals("7.0"))|(VersionOSM.equals("7.0.0"))|(VersionOSM.equals("7.0.1"))|(VersionOSM.equals("7.1"))|(VersionOSM.equals("7.1.0"))|(VersionOSM.equals("7.1.1"))|(VersionOSM.equals("7.1.2"))|(VersionOSM.equals("8.0"))|(VersionOSM.equals("8.0.0"))|(VersionOSM.equals("8.1.0"))|(VersionOSM.equals("8.0"))|(VersionOSM.equals("8.1"))|(VersionOSM.equals("8.1.1"))|(VersionOSM.equals("9"))|(VersionOSM.equals("9.0"))|(VersionOSM.equals("9.0.0"))|(VersionOSM.equals("9.1"))|(VersionOSM.equals("9.1.0"))) {

                       if (!marshMallowPermission.checkPermissionForCamera()) {
                           marshMallowPermission.requestPermissionForCamera();


                       } else {
                           if (!marshMallowPermission.checkPermissionForExternalStorage()) {
                               marshMallowPermission.requestPermissionForExternalStorage();
                           } else {

                               CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               //CamIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                               ic = new ImageConfiguration(this, PATH);
                               file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
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
                   }*/


                   else {
/*                       CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                       ic = new ImageConfiguration(this,PATH);
                       file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                               "report_problem", "ALL");

                       fileUri = FileProvider.getUriForFile(this,
                               BuildConfig.APPLICATION_ID + ".provider",
                               file);
                       // fileUri = Uri.fromFile(file);
                       CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                       startActivityForResult(CamIntent, 3);*/




                       if (!marshMallowPermission.checkPermissionForCamera()) {
                           marshMallowPermission.requestPermissionForCamera();


                       } else {
                           if (!marshMallowPermission.checkPermissionForExternalStorage()) {
                               marshMallowPermission.requestPermissionForExternalStorage();
                           } else {

                               CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               //CamIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                               ic = new ImageConfiguration(this, PATH);
                               file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
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
               } catch (Exception ex) {





                   try {
                       CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                       ic = new ImageConfiguration(this,PATH);
                       file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
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
                       file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                               "report_problem", "ALL");


                       fileUri = Uri.fromFile(file);
                       CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                       startActivityForResult(CamIntent, 4);
                   } /*else  if((VersionOSM.equals("6.0"))|(VersionOSM.equals("6.0.0"))|(VersionOSM.equals("6.0.1"))|(VersionOSM.equals("6.1"))|(VersionOSM.equals("6.1.0"))|(VersionOSM.equals("7.0"))|(VersionOSM.equals("7.0.0"))|(VersionOSM.equals("7.0.1"))|(VersionOSM.equals("7.1"))|(VersionOSM.equals("7.1.0"))|(VersionOSM.equals("7.1.1"))|(VersionOSM.equals("7.1.2"))|(VersionOSM.equals("8.0"))|(VersionOSM.equals("8.0.0"))|(VersionOSM.equals("8.1.0"))|(VersionOSM.equals("8.0"))|(VersionOSM.equals("8.1"))|(VersionOSM.equals("8.1.1"))|(VersionOSM.equals("9"))|(VersionOSM.equals("9.0"))|(VersionOSM.equals("9.0.0"))|(VersionOSM.equals("9.1"))|(VersionOSM.equals("9.1.0"))) {

                       if (!marshMallowPermission.checkPermissionForCamera()) {
                           marshMallowPermission.requestPermissionForCamera();


                       } else {
                           if (!marshMallowPermission.checkPermissionForExternalStorage()) {
                               marshMallowPermission.requestPermissionForExternalStorage();
                           } else {

                               CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               //CamIntent = new Intent("android.media.action.IMAGE_CAPTURE");







                               ic = new ImageConfiguration(this, PATH);
                               file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                                       "report_problem", "ALL");





                              // file = new Compressor(this).compressToFile(file);
                              // ic.resizeAndCompressImageBeforeSend(this,PATH,"aaaa");




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
                   }*/


                   else {
/*                       CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                       ic = new ImageConfiguration(this,PATH);
                       file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                               "report_problem", "ALL");

                       fileUri = FileProvider.getUriForFile(this,
                               BuildConfig.APPLICATION_ID + ".provider",
                               file);
                       // fileUri = Uri.fromFile(file);
                       CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                       startActivityForResult(CamIntent, 4);*/



                       if (!marshMallowPermission.checkPermissionForCamera()) {
                           marshMallowPermission.requestPermissionForCamera();


                       } else {
                           if (!marshMallowPermission.checkPermissionForExternalStorage()) {
                               marshMallowPermission.requestPermissionForExternalStorage();
                           } else {

                               CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               //CamIntent = new Intent("android.media.action.IMAGE_CAPTURE");







                               ic = new ImageConfiguration(this, PATH);
                               file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                                       "report_problem", "ALL");





                               // file = new Compressor(this).compressToFile(file);
                               // ic.resizeAndCompressImageBeforeSend(this,PATH,"aaaa");




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
               } catch (Exception ex) {





                   try {
                       CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                       ic = new ImageConfiguration(this,PATH);
                       file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
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
                       file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                               "report_problem", "ALL");


                       fileUri = Uri.fromFile(file);
                       CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                       startActivityForResult(CamIntent, 5);
                   } /*else  if((VersionOSM.equals("6.0"))|(VersionOSM.equals("6.0.0"))|(VersionOSM.equals("6.0.1"))|(VersionOSM.equals("6.1"))|(VersionOSM.equals("6.1.0"))|(VersionOSM.equals("7.0"))|(VersionOSM.equals("7.0.0"))|(VersionOSM.equals("7.0.1"))|(VersionOSM.equals("7.1"))|(VersionOSM.equals("7.1.0"))|(VersionOSM.equals("7.1.1"))|(VersionOSM.equals("7.1.2"))|(VersionOSM.equals("8.0"))|(VersionOSM.equals("8.0.0"))|(VersionOSM.equals("8.1.0"))|(VersionOSM.equals("8.0"))|(VersionOSM.equals("8.1"))|(VersionOSM.equals("8.1.1"))|(VersionOSM.equals("9"))|(VersionOSM.equals("9.0"))|(VersionOSM.equals("9.0.0"))|(VersionOSM.equals("9.1"))|(VersionOSM.equals("9.1.0"))) {

                       if (!marshMallowPermission.checkPermissionForCamera()) {
                           marshMallowPermission.requestPermissionForCamera();


                       } else {
                           if (!marshMallowPermission.checkPermissionForExternalStorage()) {
                               marshMallowPermission.requestPermissionForExternalStorage();
                           } else {

                               CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               //CamIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                               ic = new ImageConfiguration(this, PATH);
                               file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
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
                   }*/


                   else {
         /*              CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                       ic = new ImageConfiguration(this,PATH);
                       file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                               "report_problem", "ALL");

                       fileUri = FileProvider.getUriForFile(this,
                               BuildConfig.APPLICATION_ID + ".provider",
                               file);
                       // fileUri = Uri.fromFile(file);
                       CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                       startActivityForResult(CamIntent, 5);*/






                       if (!marshMallowPermission.checkPermissionForCamera()) {
                           marshMallowPermission.requestPermissionForCamera();


                       } else {
                           if (!marshMallowPermission.checkPermissionForExternalStorage()) {
                               marshMallowPermission.requestPermissionForExternalStorage();
                           } else {

                               CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               //CamIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                               ic = new ImageConfiguration(this, PATH);
                               file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
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
               } catch (Exception ex) {





                   try {
                       CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                       ic = new ImageConfiguration(this,PATH);
                       file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
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
   /*            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
               startActivityForResult(intent, 6);*/







               Intent intent  = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
               //CamIntent = new Intent("android.media.action.IMAGE_CAPTURE");
               ic = new ImageConfiguration(this, PATH);
               file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                       "report_problem", "ALL");

               fileUri = FileProvider.getUriForFile(this,
                       BuildConfig.APPLICATION_ID + ".provider",
                       file);
               // fileUri = Uri.fromFile(file);
               intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
               startActivityForResult(intent, 6);

           }
           else if(v==open_image2){
               checkCameraPermission();
/*               Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
               startActivityForResult(intent, 7);*/
               Intent intent  = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
               //CamIntent = new Intent("android.media.action.IMAGE_CAPTURE");
               ic = new ImageConfiguration(this, PATH);
               file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                       "report_problem", "ALL");

               fileUri = FileProvider.getUriForFile(this,
                       BuildConfig.APPLICATION_ID + ".provider",
                       file);
               // fileUri = Uri.fromFile(file);
               intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
               startActivityForResult(intent, 7);
           }
           else if(v==open_image3){
               checkCameraPermission();
/*               Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
               startActivityForResult(intent, 8);*/
               Intent intent  = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
               //CamIntent = new Intent("android.media.action.IMAGE_CAPTURE");
               ic = new ImageConfiguration(this, PATH);
               file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                       "report_problem", "ALL");

               fileUri = FileProvider.getUriForFile(this,
                       BuildConfig.APPLICATION_ID + ".provider",
                       file);
               // fileUri = Uri.fromFile(file);
               intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
               startActivityForResult(intent, 8);
           }
           else if(v==open_image4){
               checkCameraPermission();
/*               Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
               startActivityForResult(intent, 9);*/
               Intent intent  = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
               //CamIntent = new Intent("android.media.action.IMAGE_CAPTURE");
               ic = new ImageConfiguration(this, PATH);
               file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                       "report_problem", "ALL");

               fileUri = FileProvider.getUriForFile(this,
                       BuildConfig.APPLICATION_ID + ".provider",
                       file);
               // fileUri = Uri.fromFile(file);
               intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
               startActivityForResult(intent, 9);
           }
           else if(v==open_image5){
               checkCameraPermission();
/*               Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
               startActivityForResult(intent, 10);*/
               Intent intent  = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
               //CamIntent = new Intent("android.media.action.IMAGE_CAPTURE");
               ic = new ImageConfiguration(this, PATH);
               file = ic.createImageByType_error_checker(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                       "report_problem", "ALL");

               fileUri = FileProvider.getUriForFile(this,
                       BuildConfig.APPLICATION_ID + ".provider",
                       file);
               // fileUri = Uri.fromFile(file);
               intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
               startActivityForResult(intent, 10);
           }
           else if(v==r_save){
               save_data();
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
                       bitmapSignature.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
                       Random rand = new Random();
                       int randomValue = rand.nextInt(9999);
                       File file = null;
                       ic = new ImageConfiguration(Detali_check1.this, PATH);
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




                           status_pen=1;

                           MyApplication.getInstance().getPrefManager().setPreferrence("image_pen_sing", "VISIBLE");
                           MyApplication.getInstance().getPrefManager().setPreferrence("signaturePath",signaturePath);

                           if(status_pen==1){
                               li_pen.setBackgroundColor(0xffffffff);
                           }




                           String image_name=MyApplication.getInstance().getPrefManager().getPreferrence("imageName");
                           //String Url="http://app.thiensurat.co.th/assanee/uploads_image_checker/"+image_name+".jpg";
                           String Url=SERVER_PATH+"uploads_image_checker/"+image_name+".jpg";

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
                       status_pen=0;
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
                       DatePickerDialog datePicker = new DatePickerDialog(Detali_check1.this, new DatePickerDialog.OnDateSetListener() {
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


                                       MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_two", dateThai_day + " " + dateThai_month1 + converted_dateThai11);
                                       date2.setText(dateThai_day + " " + dateThai_month1 + converted_dateThai11);
                                       //  Viewholder.icon_time.setBackgroundResource(0);
                                       // Log.e("dateThai",dateThai_day+""+dateThai_month1+""+converted_dateThai11+"");

                                       GET_date2 = date2.getText().toString();

                                   }
                               } catch (Exception ex) {

                               }



                                //date2.setText(date2_s);




                               PayNextDate22=date3_s+" 00:00:00.000";
                              // Log.e("PayNextDate", PayNextDate22);



                               //String dateBeforeString =date_install;
                               //String dateAfterString = date3_s;
                               String dateBeforeString =date3_s;
                               String dateAfterString = date_install;

                               MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_two_nad_install", PayNextDate22);



                               //Parsing the date
                               LocalDate dateBefore = null;
                               if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                   try {
                                       dateBefore = LocalDate.parse(dateBeforeString);
                                   }
                                   catch (Exception ex){

                                   }

                               }
                               LocalDate dateAfter = null;
                               if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                   try {
                                       dateAfter = LocalDate.parse(dateAfterString);
                                   }
                                   catch (Exception ex){

                                   }

                               }

                               //calculating number of days in between

                               try {
                                   if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                       noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
                                   }
                                   // Log.e("noOfDaysBetween", String.valueOf(noOfDaysBetween));
                                   getCountOfDays(dateBeforeString,dateAfterString);
                               }
                               catch (Exception rr){

                               }



                           }


                       }, yy, mm, dd);
                       datePicker.show();

















           }
           else if(v==image_clear){
               date1.setVisibility(View.GONE);
               image_clear.setVisibility(View.GONE);
           }

    }




    private  void save_data(){


            view_sratus_problem();

            String QR_S=txt_scan.getText().toString();

            li1.setBackgroundColor(0xffffffff);
            li2.setBackgroundColor(0xffffffff);
            li3.setBackgroundColor(0xffffffff);
            li4.setBackgroundColor(0xffffffff);
            li5.setBackgroundColor(0xffffffff);
            li6.setBackgroundColor(0xffffffff);
            li7.setBackgroundColor(0xffffffff);


            try {
                String MAP =MyApplication.getInstance().getPrefManager().getPreferrence("size_map")+"";
                if(!MAP.equals("null")){
                    //  size_map= Integer.parseInt(MAP);




                    SQLiteDataBaseBuild_map();
                    SQLiteTableBuild_map_2();


                    for (int i = 1; i <=1; i++) {

                        SectionDataModel_checker_map dm = new SectionDataModel_checker_map();

                        dm.setHeaderTitle("ล่าสุด ");

                        ArrayList<SingleItemModel_checker_map> singleItem = new ArrayList<>();








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




                    Log.e("size_map3", String.valueOf(size_map));



































                    SQLiteDataBaseBuild1();
                    SQLiteTableBuild1_2();








                    for (int i = 1; i <=1; i++) {

                        SectionDataModel_checker1 dm = new SectionDataModel_checker1();

                        dm.setHeaderTitle("ล่าสุด ");

                        ArrayList<SingleItemModel_checker1> singleItem = new ArrayList<SingleItemModel_checker1>();


                        try {
                            cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer_checker1.TABLE_NAME + "", null);

                            if (cursor.moveToFirst()) {
                                do {

                                    String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_url_image));
                                    String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer_checker1.Table_order_image));


                                    // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                                    // String f= String.valueOf(order_image);
                                    singleItem.add(new SingleItemModel_checker1("รูป " + f, FA));

                                    size1 = singleItem.size();
                                    MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                                } while (cursor.moveToNext());
                            }
                            cursor.close();
                        }
                        catch (Exception ex){

                        }









                        dm.setAllItemsInSection(singleItem);

                        allSampleData1.add(dm);


                    }













                }
            }
            catch (Exception ex){

            }

            Log.e("size_map2", String.valueOf(size_map));
            Log.e("size1_1", String.valueOf(size1));
            Log.e("size1_4", String.valueOf(size4));
            Log.e("size1_5", String.valueOf(size5));













            if(item_click==0){



                if((size4==0)&(size_map==0)&(size5==0)&QR_S.equals("สแกน QR/BAR CODE")){
                    Log.e("test_error", "1");

                    // 1
                    li1.setBackgroundColor(0xffff0000);
                    li2.setBackgroundColor(0xffff0000);
                    li4.setBackgroundColor(0xffff0000);
                    li7.setBackgroundColor(0xffff0000);

                    if (data_redio1.isEmpty()) {
                        //Log.e("no_data","no_data");

                        li_install2.setBackgroundColor(0xffff0000);

                    }

                    if (data_redio2.isEmpty()) {
                        // Log.e("no_data","no_data");

                        li_pay_one.setBackgroundColor(0xffff0000);

                    }
                    if (data_redio3.isEmpty()) {
                        //Log.e("no_data","no_data");

                        li_confirm.setBackgroundColor(0xffff0000);

                    }

                    if (status_qr == 1) {
                        if(size1==0){

                            li3.setBackgroundColor(0xffff0000);
                        }
                        else {
                            li3.setBackgroundColor(0xffffffff);
                        }
                    }
                    if (status_pen == 0) {
                        li_pen.setBackgroundColor(0xffff0000);
                    }
                    if(GET_date2.equals("-")){
                        li_pay2.setBackgroundColor(0xffff0000);

                    }
                    if(radioSex_re_S.isEmpty()){
                        li_remarket.setBackgroundColor(0xffff0000);

                    }
                    if(radioSex_retain_S.isEmpty()){
                        li_retain.setBackgroundColor(0xffff0000);

                    }
                    if(data_radioSex_con.isEmpty()){
                        li_conveniently.setBackgroundColor(0xffff0000);

                    }
                    sweet_dailog_waining_checker("ยังไม่ถ่ายรูปหน้าบ้าน","1");

                }
                else if((size4==1)&(size_map==0)&(size5==0)&QR_S.equals("สแกน QR/BAR CODE")){

                    Log.e("test_error", "2");
                    //
                    //li1.setBackgroundColor(0xffff0000);
                    li2.setBackgroundColor(0xffff0000);
                    li4.setBackgroundColor(0xffff0000);
                    li7.setBackgroundColor(0xffff0000);
                    if (data_redio1.isEmpty()) {
                        //Log.e("no_data","no_data");

                        li_install2.setBackgroundColor(0xffff0000);

                    }

                    if (data_redio2.isEmpty()) {
                        // Log.e("no_data","no_data");

                        li_pay_one.setBackgroundColor(0xffff0000);

                    }
                    if (data_redio3.isEmpty()) {
                        //Log.e("no_data","no_data");

                        li_confirm.setBackgroundColor(0xffff0000);

                    }


                    if (status_qr == 1) {
                        if(size1==0){

                            li3.setBackgroundColor(0xffff0000);
                        }
                        else {
                            li3.setBackgroundColor(0xffffffff);
                        }
                    }
                    if (status_pen == 0) {
                        li_pen.setBackgroundColor(0xffff0000);
                    }
                    if(GET_date2.equals("-")){
                        li_pay2.setBackgroundColor(0xffff0000);

                    }

                    if(radioSex_re_S.isEmpty()){
                        li_remarket.setBackgroundColor(0xffff0000);

                    }
                    if(radioSex_retain_S.isEmpty()){
                        li_retain.setBackgroundColor(0xffff0000);

                    }
                    if(data_radioSex_con.isEmpty()){
                        li_conveniently.setBackgroundColor(0xffff0000);

                    }
                    sweet_dailog_waining_checker("ยังไม่ปักหมุด","2");



                }
                else if((size4==1)&(size_map==1)&(size5==0)&QR_S.equals("สแกน QR/BAR CODE")){

                    Log.e("test_error", "3");


                    li4.setBackgroundColor(0xffff0000);
                    li7.setBackgroundColor(0xffff0000);
                    if(data_redio1.isEmpty()){
                        //Log.e("no_data","no_data");

                        li_install2.setBackgroundColor(0xffff0000);

                    }

                    if(data_redio2.isEmpty()){
                        // Log.e("no_data","no_data");

                        li_pay_one.setBackgroundColor(0xffff0000);

                    }
                    if(data_redio3.isEmpty()){
                        //Log.e("no_data","no_data");

                        li_confirm.setBackgroundColor(0xffff0000);

                    }

                    if(status_qr==1){
                        if(size1==0){

                            li3.setBackgroundColor(0xffff0000);
                        }
                        else {
                            li3.setBackgroundColor(0xffffffff);
                        }
                    }
                    if(status_pen==0){
                        li_pen.setBackgroundColor(0xffff0000);
                    }
                    if(GET_date2.equals("-")){
                        li_pay2.setBackgroundColor(0xffff0000);

                    }

                    if(radioSex_re_S.isEmpty()){
                        li_remarket.setBackgroundColor(0xffff0000);

                    }
                    if(radioSex_retain_S.isEmpty()){
                        li_retain.setBackgroundColor(0xffff0000);

                    }

                    if(data_radioSex_con.isEmpty()){
                        li_conveniently.setBackgroundColor(0xffff0000);

                    }
                    sweet_dailog_waining_checker("ยังไม่สแกน QR/BAR CODE","3");
                }

                else if(status_qr==1){
                    Log.e("test_error", "18");

                    if(size1==0){

                        li3.setBackgroundColor(0xffff0000);
                    }
                    else {
                        li3.setBackgroundColor(0xffffffff);
                    }
                    if(data_radioSex_con.isEmpty()){
                        li_conveniently.setBackgroundColor(0xffff0000);

                    }
                    sweet_dailog_waining_checker("ยังไม่ถ่ายรูป Barcode","4");
                }








                else if(data_redio1.isEmpty()){

                    Log.e("test_error", "15");

                    //Log.e("no_data","no_data");

                    li_install2.setBackgroundColor(0xffff0000);


                    if(data_redio1.isEmpty()){
                        //Log.e("no_data","no_data");

                        li_install2.setBackgroundColor(0xffff0000);

                    }

                    if(data_redio2.isEmpty()){
                        // Log.e("no_data","no_data");

                        li_pay_one.setBackgroundColor(0xffff0000);

                    }
                    if(data_redio3.isEmpty()){
                        //Log.e("no_data","no_data");

                        li_confirm.setBackgroundColor(0xffff0000);
                        //
                    }
                    if(status_qr==1){
                        if(size1==0){

                            li3.setBackgroundColor(0xffff0000);
                        }
                        else {
                            li3.setBackgroundColor(0xffffffff);
                        }
                    }
                    if(status_pen==0){
                        li_pen.setBackgroundColor(0xffff0000);
                    }

                    if(GET_date2.equals("-")){
                        li_pay2.setBackgroundColor(0xffff0000);

                    }

                    if(radioSex_re_S.isEmpty()){
                        li_remarket.setBackgroundColor(0xffff0000);

                    }
                    if(radioSex_retain_S.isEmpty()){
                        li_retain.setBackgroundColor(0xffff0000);

                    }
                    if(data_radioSex_con.isEmpty()){
                        li_conveniently.setBackgroundColor(0xffff0000);

                    }

                    sweet_dailog_waining_checker("ยังไม่เลือก การติดตั้ง?","5");
                }


                else if((size4==1)&(size_map==1)&(size5==0)&!QR_S.equals("สแกน QR/BAR CODE")){
                    Log.e("test_error", "10");



                    //li1.setBackgroundColor(0xffff0000);
                    // li2.setBackgroundColor(0xffff0000);
                    li4.setBackgroundColor(0xffff0000);
                    //  li7.setBackgroundColor(0xffff0000);
                    if(data_redio1.isEmpty()){
                        //Log.e("no_data","no_data");

                        li_install2.setBackgroundColor(0xffff0000);

                    }

                    if(data_redio2.isEmpty()){
                        // Log.e("no_data","no_data");

                        li_pay_one.setBackgroundColor(0xffff0000);

                    }
                    if(data_redio3.isEmpty()){
                        //Log.e("no_data","no_data");

                        li_confirm.setBackgroundColor(0xffff0000);

                    }
                    if(status_qr==1){
                        if(size1==0){

                            li3.setBackgroundColor(0xffff0000);
                        }
                        else {
                            li3.setBackgroundColor(0xffffffff);
                        }
                    }
                    if(status_pen==0){
                        li_pen.setBackgroundColor(0xffff0000);
                    }

                    if(GET_date2.equals("-")){
                        li_pay2.setBackgroundColor(0xffff0000);

                    }
                    if(radioSex_re_S.isEmpty()){
                        li_remarket.setBackgroundColor(0xffff0000);

                    }
                    if(radioSex_retain_S.isEmpty()){
                        li_retain.setBackgroundColor(0xffff0000);

                    }
                    if(data_radioSex_con.isEmpty()){
                        li_conveniently.setBackgroundColor(0xffff0000);

                    }
                    sweet_dailog_waining_checker("ยังไม่ถ่ายรูปเครื่องติดตั้ง","6");
                }









                else if(radioSex_re_S.isEmpty()){
                    Log.e("test_error", "20");

                    li_remarket.setBackgroundColor(0xffff0000);

                    sweet_dailog_waining_checker("ยังไม่เลือก เคยซื้อสินค้าบริษัท?","7");
                }
                else if(radioSex_retain_S.isEmpty()){
                    Log.e("test_error", "21");

                    li_retain.setBackgroundColor(0xffff0000);

                    sweet_dailog_waining_checker("ยังไม่เลือก มีเครื่องเทร์น?","8");
                }













                else  if(data_redio2.isEmpty()){
                    Log.e("test_error", "16");
                    // Log.e("no_data","no_data");

                    li_pay_one.setBackgroundColor(0xffff0000);

                    if(data_redio1.isEmpty()){
                        //Log.e("no_data","no_data");

                        li_install2.setBackgroundColor(0xffff0000);
                        //
                    }

                    if(data_redio2.isEmpty()){
                        // Log.e("no_data","no_data");

                        li_pay_one.setBackgroundColor(0xffff0000);
                        //
                    }
                    if(data_redio3.isEmpty()){
                        //Log.e("no_data","no_data");

                        li_confirm.setBackgroundColor(0xffff0000);
                        //
                    }
                    if(status_qr==1){
                        if(size1==0){

                            li3.setBackgroundColor(0xffff0000);
                        }
                        else {
                            li3.setBackgroundColor(0xffffffff);
                        }
                    }
                    if(status_pen==0){
                        li_pen.setBackgroundColor(0xffff0000);
                    }
                    if(GET_date2.equals("-")){
                        li_pay2.setBackgroundColor(0xffff0000);

                    }

                    if(radioSex_re_S.isEmpty()){
                        li_remarket.setBackgroundColor(0xffff0000);

                    }
                    if(radioSex_retain_S.isEmpty()){
                        li_retain.setBackgroundColor(0xffff0000);

                    }
                    if(data_radioSex_con.isEmpty()){
                        li_conveniently.setBackgroundColor(0xffff0000);

                    }
                    //
                    sweet_dailog_waining_checker("ยังไม่เลือก การชำระงวดแรก?","9");
                }
                else if(GET_date2.equals("-")){
                    Log.e("test_error", "22");

                    li_pay2.setBackgroundColor(0xffff0000);
                    sweet_dailog_waining_checker("ยังไม่เลือก การชำระงวด 2?","10");
                }

                else if(data_redio3.isEmpty()){
                    Log.e("test_error", "17");
                    //Log.e("no_data","no_data");

                    li_confirm.setBackgroundColor(0xffff0000);
                    //

                    if(data_redio1.isEmpty()){
                        //Log.e("no_data","no_data");

                        li_install2.setBackgroundColor(0xffff0000);
                        //
                    }

                    if(data_redio2.isEmpty()){
                        // Log.e("no_data","no_data");

                        li_pay_one.setBackgroundColor(0xffff0000);
                        //
                    }
                    if(data_redio3.isEmpty()){
                        //Log.e("no_data","no_data");

                        li_confirm.setBackgroundColor(0xffff0000);
                        //
                    }
                    if(status_qr==1){
                        if(size1==0){

                            li3.setBackgroundColor(0xffff0000);
                        }
                        else {
                            li3.setBackgroundColor(0xffffffff);
                        }
                    }
                    if(status_pen==0){
                        li_pen.setBackgroundColor(0xffff0000);
                    }

                    if(GET_date2.equals("-")){
                        li_pay2.setBackgroundColor(0xffff0000);

                    }


                    if(radioSex_re_S.isEmpty()){
                        li_remarket.setBackgroundColor(0xffff0000);

                    }
                    if(radioSex_retain_S.isEmpty()){
                        li_retain.setBackgroundColor(0xffff0000);

                    }

                    if(data_radioSex_con.isEmpty()){
                        li_conveniently.setBackgroundColor(0xffff0000);

                    }
                    sweet_dailog_waining_checker("ยังไม่เลือก การผ่อนชำระ?","11");
                }




                else if(status_pen==0){
                    Log.e("test_error", "19");

                    li_pen.setBackgroundColor(0xffff0000);

                    if(GET_date2.equals("-")){
                        li_pay2.setBackgroundColor(0xffff0000);

                    }
                    if(data_radioSex_con.isEmpty()){
                        li_conveniently.setBackgroundColor(0xffff0000);

                    }
                    sweet_dailog_waining_checker("ยังไม่ เซ็นชื่อ","12");
                }




                else if((size4==1)&(size_map==1)&(size5==1)&QR_S.equals("สแกน QR/BAR CODE")){
                    Log.e("test_error", "4");



                    li7.setBackgroundColor(0xffff0000);
                    if(data_redio1.isEmpty()){
                        //Log.e("no_data","no_data");

                        li_install2.setBackgroundColor(0xffff0000);

                    }

                    if(data_redio2.isEmpty()){
                        // Log.e("no_data","no_data");

                        li_pay_one.setBackgroundColor(0xffff0000);

                    }
                    if(data_redio3.isEmpty()){
                        //Log.e("no_data","no_data");

                        li_confirm.setBackgroundColor(0xffff0000);

                    }
                    if(status_qr==1){
                        if(size1==0){

                            li3.setBackgroundColor(0xffff0000);
                        }
                        else {
                            li3.setBackgroundColor(0xffffffff);
                        }
                    }
                    if(status_pen==0){
                        li_pen.setBackgroundColor(0xffff0000);
                    }
                    if(GET_date2.equals("-")){
                        li_pay2.setBackgroundColor(0xffff0000);

                    }
                    if(radioSex_re_S.isEmpty()){
                        li_remarket.setBackgroundColor(0xffff0000);

                    }
                    if(radioSex_retain_S.isEmpty()){
                        li_retain.setBackgroundColor(0xffff0000);

                    }
                    if(data_radioSex_con.isEmpty()){
                        li_conveniently.setBackgroundColor(0xffff0000);

                    }
                    sweet_dailog_waining_checker("ยังไม่สแกน QR/BAR CODE","3");
                    //   sweet_dailog_waining_checker("8453","13");
                }

                else if((size4==0)&(size_map==1)&(size5==0)&QR_S.equals("สแกน QR/BAR CODE")){

                    Log.e("test_error", "5");



                    li1.setBackgroundColor(0xffff0000);
                    //li2.setBackgroundColor(0xffff0000);
                    li4.setBackgroundColor(0xffff0000);
                    li7.setBackgroundColor(0xffff0000);
                    if(data_redio1.isEmpty()){
                        //Log.e("no_data","no_data");

                        li_install2.setBackgroundColor(0xffff0000);

                    }

                    if(data_redio2.isEmpty()){
                        // Log.e("no_data","no_data");

                        li_pay_one.setBackgroundColor(0xffff0000);

                    }
                    if(data_redio3.isEmpty()){
                        //Log.e("no_data","no_data");

                        li_confirm.setBackgroundColor(0xffff0000);

                    }
                    if(status_qr==1){
                        if(size1==0){

                            li3.setBackgroundColor(0xffff0000);
                        }
                        else {
                            li3.setBackgroundColor(0xffffffff);
                        }
                    }
                    if(status_pen==0){
                        li_pen.setBackgroundColor(0xffff0000);
                    }

                    if(GET_date2.equals("-")){
                        li_pay2.setBackgroundColor(0xffff0000);

                    }

                    if(radioSex_re_S.isEmpty()){
                        li_remarket.setBackgroundColor(0xffff0000);

                    }
                    if(radioSex_retain_S.isEmpty()){
                        li_retain.setBackgroundColor(0xffff0000);

                    }
                    if(data_radioSex_con.isEmpty()){
                        li_conveniently.setBackgroundColor(0xffff0000);

                    }
                    sweet_dailog_waining_checker("ยังไม่ถ่ายรูปเครื่องติดตั้ง","6");
                }
                else if((size4==0)&(size_map==0)&(size5==1)&QR_S.equals("สแกน QR/BAR CODE")){
                    Log.e("test_error", "6");

                    li1.setBackgroundColor(0xffff0000);
                    li2.setBackgroundColor(0xffff0000);
                    // li4.setBackgroundColor(0xffff0000);
                    li7.setBackgroundColor(0xffff0000);
                    if (data_redio1.isEmpty()) {
                        //Log.e("no_data","no_data");

                        li_install2.setBackgroundColor(0xffff0000);

                    }

                    if (data_redio2.isEmpty()) {
                        // Log.e("no_data","no_data");

                        li_pay_one.setBackgroundColor(0xffff0000);

                    }
                    if (data_redio3.isEmpty()) {
                        //Log.e("no_data","no_data");

                        li_confirm.setBackgroundColor(0xffff0000);

                    }
                    if (status_qr == 1) {
                        if(size1==0){

                            li3.setBackgroundColor(0xffff0000);
                        }
                        else {
                            li3.setBackgroundColor(0xffffffff);
                        }
                    }
                    if (status_pen == 0) {
                        li_pen.setBackgroundColor(0xffff0000);
                    }

                    if(GET_date2.equals("-")){
                        li_pay2.setBackgroundColor(0xffff0000);

                    }

                    if(radioSex_re_S.isEmpty()){
                        li_remarket.setBackgroundColor(0xffff0000);

                    }
                    if(radioSex_retain_S.isEmpty()){
                        li_retain.setBackgroundColor(0xffff0000);

                    }

                    if(data_radioSex_con.isEmpty()){
                        li_conveniently.setBackgroundColor(0xffff0000);

                    }

                    sweet_dailog_waining_checker("ยังไม่ถ่ายรูปหน้าบ้าน","1");

                }
                else if((size4==0)&(size_map==1)&(size5==1)&QR_S.equals("สแกน QR/BAR CODE")){

                    Log.e("test_error", "7");


                    li1.setBackgroundColor(0xffff0000);
                    // li2.setBackgroundColor(0xffff0000);
                    // li4.setBackgroundColor(0xffff0000);
                    li7.setBackgroundColor(0xffff0000);
                    if(data_redio1.isEmpty()){
                        //Log.e("no_data","no_data");

                        li_install2.setBackgroundColor(0xffff0000);
                        //  sweet_dailog_waining_checker();
                    }

                    if(data_redio2.isEmpty()){
                        // Log.e("no_data","no_data");

                        li_pay_one.setBackgroundColor(0xffff0000);

                    }
                    if(data_redio3.isEmpty()){
                        //Log.e("no_data","no_data");

                        li_confirm.setBackgroundColor(0xffff0000);

                    }
                    if(status_qr==1){
                        if(size1==0){

                            li3.setBackgroundColor(0xffff0000);
                        }
                        else {
                            li3.setBackgroundColor(0xffffffff);
                        }
                    }
                    if(status_pen==0){
                        li_pen.setBackgroundColor(0xffff0000);
                    }

                    if(GET_date2.equals("-")){
                        li_pay2.setBackgroundColor(0xffff0000);

                    }

                    if(radioSex_re_S.isEmpty()){
                        li_remarket.setBackgroundColor(0xffff0000);

                    }
                    if(radioSex_retain_S.isEmpty()){
                        li_retain.setBackgroundColor(0xffff0000);

                    }
                    if(data_radioSex_con.isEmpty()){
                        li_conveniently.setBackgroundColor(0xffff0000);

                    }
                    sweet_dailog_waining_checker("ยังไม่ถ่ายรูปหน้าบ้าน","1");
                    //sweet_dailog_waining_checker("8627","16");
                }




                else if((size4==0)&(size_map==0)&(size5==0)&!QR_S.equals("สแกน QR/BAR CODE")){   // 1
                    Log.e("test_error", "8");

                    li1.setBackgroundColor(0xffff0000);
                    li2.setBackgroundColor(0xffff0000);
                    li4.setBackgroundColor(0xffff0000);
                    //  li7.setBackgroundColor(0xffff0000);
                    if (data_redio1.isEmpty()) {
                        //Log.e("no_data","no_data");

                        li_install2.setBackgroundColor(0xffff0000);

                    }

                    if (data_redio2.isEmpty()) {
                        // Log.e("no_data","no_data");

                        li_pay_one.setBackgroundColor(0xffff0000);

                    }
                    if (data_redio3.isEmpty()) {
                        //Log.e("no_data","no_data");

                        li_confirm.setBackgroundColor(0xffff0000);

                    }
                    if (status_qr == 1) {
                        if(size1==0){

                            li3.setBackgroundColor(0xffff0000);
                        }
                        else {
                            li3.setBackgroundColor(0xffffffff);
                        }
                    }
                    if (status_pen == 0) {
                        li_pen.setBackgroundColor(0xffff0000);
                    }

                    if(GET_date2.equals("-")){
                        li_pay2.setBackgroundColor(0xffff0000);

                    }
                    if(radioSex_re_S.isEmpty()){
                        li_remarket.setBackgroundColor(0xffff0000);

                    }
                    if(radioSex_retain_S.isEmpty()){
                        li_retain.setBackgroundColor(0xffff0000);

                    }
                    if(data_radioSex_con.isEmpty()){
                        li_conveniently.setBackgroundColor(0xffff0000);

                    }

                    sweet_dailog_waining_checker("ยังไม่ถ่ายรูปหน้าบ้าน","1");

                }
                else if((size4==1)&(size_map==0)&(size5==0)&!QR_S.equals("สแกน QR/BAR CODE")){
                    Log.e("test_error", "9");

                    //  li1.setBackgroundColor(0xffff0000);
                    li2.setBackgroundColor(0xffff0000);
                    li4.setBackgroundColor(0xffff0000);
                    //  li7.setBackgroundColor(0xffff0000);
                    if (data_redio1.isEmpty()) {
                        //Log.e("no_data","no_data");

                        li_install2.setBackgroundColor(0xffff0000);

                    }

                    if (data_redio2.isEmpty()) {
                        // Log.e("no_data","no_data");

                        li_pay_one.setBackgroundColor(0xffff0000);

                    }
                    if (data_redio3.isEmpty()) {
                        //Log.e("no_data","no_data");

                        li_confirm.setBackgroundColor(0xffff0000);

                    }
                    if (status_qr == 1) {
                        if(size1==0){

                            li3.setBackgroundColor(0xffff0000);
                        }
                        else {
                            li3.setBackgroundColor(0xffffffff);
                        }
                    }
                    if (status_pen == 0) {
                        li_pen.setBackgroundColor(0xffff0000);
                    }
                    if(GET_date2.equals("-")){
                        li_pay2.setBackgroundColor(0xffff0000);

                    }
                    if(radioSex_re_S.isEmpty()){
                        li_remarket.setBackgroundColor(0xffff0000);

                    }
                    if(radioSex_retain_S.isEmpty()){
                        li_retain.setBackgroundColor(0xffff0000);

                    }
                    if(data_radioSex_con.isEmpty()){
                        li_conveniently.setBackgroundColor(0xffff0000);

                    }
                    sweet_dailog_waining_checker("ยังไม่ปักหมุด","2");
                    //  sweet_dailog_waining_checker("8739","18");

                }



                else if((size4==0)&(size_map==1)&(size5==0)&!QR_S.equals("สแกน QR/BAR CODE")){
                    Log.e("test_error", "11");

                    li1.setBackgroundColor(0xffff0000);
                    // li2.setBackgroundColor(0xffff0000);
                    li4.setBackgroundColor(0xffff0000);
                    //  li7.setBackgroundColor(0xffff0000);
                    if(data_redio1.isEmpty()){
                        //Log.e("no_data","no_data");

                        li_install2.setBackgroundColor(0xffff0000);

                    }

                    if(data_redio2.isEmpty()){
                        // Log.e("no_data","no_data");

                        li_pay_one.setBackgroundColor(0xffff0000);

                    }
                    if(data_redio3.isEmpty()){
                        //Log.e("no_data","no_data");

                        li_confirm.setBackgroundColor(0xffff0000);

                    }
                    if(status_qr==1){
                        if(size1==0){

                            li3.setBackgroundColor(0xffff0000);
                        }
                        else {
                            li3.setBackgroundColor(0xffffffff);
                        }
                    }
                    if(status_pen==0){
                        li_pen.setBackgroundColor(0xffff0000);
                    }


                    if(GET_date2.equals("-")){
                        li_pay2.setBackgroundColor(0xffff0000);

                    }

                    if(radioSex_re_S.isEmpty()){
                        li_remarket.setBackgroundColor(0xffff0000);

                    }
                    if(radioSex_retain_S.isEmpty()){
                        li_retain.setBackgroundColor(0xffff0000);

                    }
                    if(data_radioSex_con.isEmpty()){
                        li_conveniently.setBackgroundColor(0xffff0000);

                    }

                    sweet_dailog_waining_checker("ยังไม่ถ่ายรูปหน้าบ้าน","1");

                }



                else if((size4==0)&(size_map==0)&(size5==1)&!QR_S.equals("สแกน QR/BAR CODE")){
                    Log.e("test_error", "12");

                    li1.setBackgroundColor(0xffff0000);
                    li2.setBackgroundColor(0xffff0000);
                    // li4.setBackgroundColor(0xffff0000);
                    //  li7.setBackgroundColor(0xffff0000);
                    if (data_redio1.isEmpty()) {
                        //Log.e("no_data","no_data");

                        li_install2.setBackgroundColor(0xffff0000);

                    }

                    if (data_redio2.isEmpty()) {
                        // Log.e("no_data","no_data");

                        li_pay_one.setBackgroundColor(0xffff0000);

                    }
                    if (data_redio3.isEmpty()) {
                        //Log.e("no_data","no_data");

                        li_confirm.setBackgroundColor(0xffff0000);

                    }
                    if (status_qr == 1) {
                        if(size1==0){

                            li3.setBackgroundColor(0xffff0000);
                        }
                        else {
                            li3.setBackgroundColor(0xffffffff);
                        }
                    }
                    if (status_pen == 0) {
                        li_pen.setBackgroundColor(0xffff0000);
                    }

                    if(GET_date2.equals("-")){
                        li_pay2.setBackgroundColor(0xffff0000);

                    }

                    if(radioSex_re_S.isEmpty()){
                        li_remarket.setBackgroundColor(0xffff0000);

                    }
                    if(radioSex_retain_S.isEmpty()){
                        li_retain.setBackgroundColor(0xffff0000);

                    }
                    if(data_radioSex_con.isEmpty()){
                        li_conveniently.setBackgroundColor(0xffff0000);

                    }
                    sweet_dailog_waining_checker("ยังไม่ถ่ายรูปหน้าบ้าน","1");

                }

                else if((size4==0)&(size_map==1)&(size5==1)&!QR_S.equals("สแกน QR/BAR CODE")){
                    Log.e("test_error", "13");

                    li1.setBackgroundColor(0xffff0000);
                    //   li2.setBackgroundColor(0xffff0000);
                    //  li4.setBackgroundColor(0xffff0000);
                    //  li7.setBackgroundColor(0xffff0000);
                    if(data_redio1.isEmpty()){
                        //Log.e("no_data","no_data");

                        li_install2.setBackgroundColor(0xffff0000);

                    }

                    if(data_redio2.isEmpty()){
                        // Log.e("no_data","no_data");

                        li_pay_one.setBackgroundColor(0xffff0000);

                    }
                    if(data_redio3.isEmpty()){
                        //Log.e("no_data","no_data");

                        li_confirm.setBackgroundColor(0xffff0000);

                    }
                    if(status_qr==1){
                        if(size1==0){

                            li3.setBackgroundColor(0xffff0000);
                        }
                        else {
                            li3.setBackgroundColor(0xffffffff);
                        }
                    }
                    if(status_pen==0){
                        li_pen.setBackgroundColor(0xffff0000);
                    }

                    if(GET_date2.equals("-")){
                        li_pay2.setBackgroundColor(0xffff0000);

                    }

                    if(radioSex_re_S.isEmpty()){
                        li_remarket.setBackgroundColor(0xffff0000);

                    }
                    if(radioSex_retain_S.isEmpty()){
                        li_retain.setBackgroundColor(0xffff0000);

                    }
                    if(data_radioSex_con.isEmpty()){
                        li_conveniently.setBackgroundColor(0xffff0000);

                    }
                    sweet_dailog_waining_checker("ยังไม่ถ่ายรูปหน้าบ้าน","1");
                    //sweet_dailog_waining_checker("8966","21");
                }
                else if((size4==1)&(size_map==0)&(size5==1)&QR_S.equals("สแกน QR/BAR CODE")){
                    Log.e("test_error", "14");


                    // li1.setBackgroundColor(0xffff0000);
                    li2.setBackgroundColor(0xffff0000);
                    //  li4.setBackgroundColor(0xffff0000);
                    li7.setBackgroundColor(0xffff0000);
                    if (data_redio1.isEmpty()) {
                        //Log.e("no_data","no_data");

                        li_install2.setBackgroundColor(0xffff0000);

                    }

                    if (data_redio2.isEmpty()) {
                        // Log.e("no_data","no_data");

                        li_pay_one.setBackgroundColor(0xffff0000);

                    }
                    if (data_redio3.isEmpty()) {
                        //Log.e("no_data","no_data");

                        li_confirm.setBackgroundColor(0xffff0000);

                    }
                    if (status_qr == 1) {
                        if(size1==0){

                            li3.setBackgroundColor(0xffff0000);
                        }
                        else {
                            li3.setBackgroundColor(0xffffffff);
                        }
                    }
                    if (status_pen == 0) {
                        li_pen.setBackgroundColor(0xffff0000);
                    }


                    if(GET_date2.equals("-")){
                        li_pay2.setBackgroundColor(0xffff0000);

                    }

                    if(radioSex_re_S.isEmpty()){
                        li_remarket.setBackgroundColor(0xffff0000);

                    }
                    if(radioSex_retain_S.isEmpty()){
                        li_retain.setBackgroundColor(0xffff0000);

                    }
                    if(data_radioSex_con.isEmpty()){
                        li_conveniently.setBackgroundColor(0xffff0000);

                    }

                    sweet_dailog_waining_checker("ยังไม่ปักหมุด","2");







                }
                else if(data_radioSex_con.isEmpty()){
                    li_conveniently.setBackgroundColor(0xffff0000);

                }

                else if(select_color==0){
                    Log.e("test_error", "23");

                    if (check_nonti_web == 0) {
                        connectSocket("ตรวจสอบได้ เข้าบ้านลูกค้าได้");
                        check_nonti_web = 1;
                    } else {
                        try {
                            webSocketClient.close();
                        } catch (Exception e) {

                        }

                    }



                    //li_line8.setBackgroundColor(0xffff0000);

                    final Dialog dialog = new Dialog(this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.custom_dialog_select_color_status);
                    dialog.setCancelable(false);




                    TextView   count1=(TextView)dialog.findViewById(R.id.count1);
                    TextView  count2=(TextView)dialog.findViewById(R.id.count2);
                    TextView count3=(TextView)dialog.findViewById(R.id.count3);
                    RelativeLayout r_sddddave=(RelativeLayout)dialog.findViewById(R.id.r_sddddave);
                    LinearLayout li_text=(LinearLayout)dialog.findViewById(R.id.li_text);
                    RelativeLayout exit=(RelativeLayout)dialog.findViewById(R.id.exit);





                    count1.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            count1.setText("✔");count2.setText("");count3.setText("");
                            //color=0xfff40707;
                            select_color=1;
                            select_color_S="03";
                            if(select_color!=0){
                                li_line8.setBackgroundColor(0xffffffff);
                            }
                            li_text.setVisibility(View.GONE);
                        }
                    });
                    count2.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            count1.setText("");count2.setText("✔");count3.setText("");
                            //color=0xfffcc7c7;
                            select_color=2;
                            select_color_S="02";
                            if(select_color!=0){
                                li_line8.setBackgroundColor(0xffffffff);
                            }
                            li_text.setVisibility(View.GONE);
                        }
                    });
                    count3.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            count1.setText("");count2.setText("");count3.setText("✔");
                            //color=0xff808080;
                            select_color=3;
                            select_color_S="01";
                            if(select_color!=0){
                                li_line8.setBackgroundColor(0xffffffff);
                            }
                            li_text.setVisibility(View.GONE);
                        }
                    });

                    exit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            select_color=0;
                            dialog.cancel();
                            check_open_dialog=0;
                        }
                    });


                    r_sddddave.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            if(select_color!=0){
                                dialog.cancel();
                                li_text.setVisibility(View.GONE);










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




                                if(item_click==0){

                                    insert_CheckerCard_Master();

                                    insert_CheckerCard_Details_home_in();
                                    insert_CheckerCard_Details_gps_maker();
                                    insert_CheckerCard_Details_qr_scan();
                                    insert_CheckerCard_Details_install();
                                    insert_CheckerCard_Details_checker_who();
                                    insert_CheckerCard_Details_customer1();
                                    insert_CheckerCard_Details_tain();
                                    insert_CheckerCard_Details_date_to_date();
                                    insert_remarket();

                                    if (CheckBox_status==1){
                                        insert_CheckerCard_Details_customer2();
                                    }


                                    insert_CheckerCard_Details_confrim();

                                    insert_CheckerCard_Details_conveniently();

                                    update_CheckerCard_Master();

                                }
                                else  if(item_click==1){
                                    insert_CheckerCard_Master();
                                    insert_CheckerCard_Details_home_in();
                                    insert_CheckerCard_Details_gps_maker();
                                    insert_CheckerCard_Details_checker_who();
                                    insert_CheckerCard_Details_customer1();
                                    insert_CheckerCard_Details_tain();
                                    insert_CheckerCard_Details_date_to_date();
                                    insert_remarket();

                                    if (CheckBox_status==1){
                                        insert_CheckerCard_Details_customer2();
                                    }


                                    insert_CheckerCard_Details_confrim();
                                    insert_CheckerCard_Details_conveniently();
                                    update_CheckerCard_Master();
                                }
                                else if(item_click==2){
                                    insert_CheckerCard_Master();
                                    insert_CheckerCard_Details_home_in();
                                    insert_CheckerCard_Details_gps_maker();
                                }
                                else {

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


                                pDialogg = new SweetAlertDialog(Detali_check1.this, SweetAlertDialog.PROGRESS_TYPE);
                                pDialogg.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                                pDialogg.setTitleText("กำลังอัปโหลด...");
                                pDialogg.setCancelable(false);









                                SQLiteDataBaseBuild_data_checker_problem_for_report();
                                SQLiteTableBuild_data_checker_problem_for_report();

                                cursor = sqLiteDatabase.rawQuery("SELECT /*count(SUB)as dd,*/CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID  FROM " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME, null);

                                try {
                                    if (cursor.moveToFirst()) {
                                        do {


                                        } while (cursor.moveToNext());
                                    }
                                }
                                catch (Exception ex){

                                }

                                cursor.close();











                                try {
                                    uploadMultiFile();
                                } catch (Exception ex) {

                                }

                                select_color=0;



                            }
                            else {
                                li_text.setVisibility(View.VISIBLE);
                            }

                        }
                    });




                    if(check_open_dialog==0){
                        dialog.show();
                        check_open_dialog=1;
                    }


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




                    if(item_click==0){

                        insert_CheckerCard_Master();

                        insert_CheckerCard_Details_home_in();
                        insert_CheckerCard_Details_gps_maker();
                        insert_CheckerCard_Details_qr_scan();
                        insert_CheckerCard_Details_install();
                        insert_CheckerCard_Details_checker_who();
                        insert_CheckerCard_Details_customer1();
                        insert_CheckerCard_Details_tain();
                        insert_CheckerCard_Details_date_to_date();
                        insert_remarket();

                        if (CheckBox_status==1){
                            insert_CheckerCard_Details_customer2();
                        }


                        insert_CheckerCard_Details_confrim();

                    }
                    else  if(item_click==1){
                        insert_CheckerCard_Master();
                        insert_CheckerCard_Details_home_in();
                        insert_CheckerCard_Details_gps_maker();
                        insert_CheckerCard_Details_checker_who();
                        insert_CheckerCard_Details_customer1();
                        insert_CheckerCard_Details_tain();
                        insert_CheckerCard_Details_date_to_date();
                        insert_remarket();

                        if (CheckBox_status==1){
                            insert_CheckerCard_Details_customer2();
                        }


                        insert_CheckerCard_Details_confrim();

                    }
                    else if(item_click==2){
                        insert_CheckerCard_Master();
                        insert_CheckerCard_Details_home_in();
                        insert_CheckerCard_Details_gps_maker();
                    }
                    else {

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









                    SQLiteDataBaseBuild_data_checker_problem_for_report();
                    SQLiteTableBuild_data_checker_problem_for_report();

                    cursor = sqLiteDatabase.rawQuery("SELECT /*count(SUB)as dd,*/CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID  FROM " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME, null);

                    try {
                        if (cursor.moveToFirst()) {
                            do {


                            } while (cursor.moveToNext());
                        }
                    }
                    catch (Exception ex){

                    }

                    cursor.close();











                    try {
                        uploadMultiFile();
                    } catch (Exception ex) {

                    }

                    select_color=0;
                }
            }
            else if(item_click==1){
                view_sratus_problem();

                if((size4==0)&(size_map==0)){   // 1


                    li1.setBackgroundColor(0xffff0000);
                    li2.setBackgroundColor(0xffff0000);


                    if (data_redio1.isEmpty()) {
                        //Log.e("no_data","no_data");

                        li_install2.setBackgroundColor(0xffff0000);
                        //
                    }

                    if (data_redio2.isEmpty()) {
                        // Log.e("no_data","no_data");

                        li_pay_one.setBackgroundColor(0xffff0000);
                        //
                    }
                    if (data_redio3.isEmpty()) {
                        //Log.e("no_data","no_data");

                        li_confirm.setBackgroundColor(0xffff0000);
                        //
                    }
                    if (status_pen == 0) {
                        li_pen.setBackgroundColor(0xffff0000);
                    }


                    if(GET_date2.equals("-")){
                        li_pay2.setBackgroundColor(0xffff0000);

                    }

                    if(radioSex_re_S.isEmpty()){
                        li_remarket.setBackgroundColor(0xffff0000);

                    }
                    if(radioSex_retain_S.isEmpty()){
                        li_retain.setBackgroundColor(0xffff0000);

                    }
                    if(data_radioSex_con.isEmpty()){
                        li_conveniently.setBackgroundColor(0xffff0000);

                    }
                    sweet_dailog_waining_checker("ยังไม่ถ่ายรูปหน้าบ้าน","1");

                }
                else if((size4==1)&(size_map==0)){


                    // li1.setBackgroundColor(0xffff0000);
                    li2.setBackgroundColor(0xffff0000);

                    if (data_redio1.isEmpty()) {
                        //Log.e("no_data","no_data");

                        li_install2.setBackgroundColor(0xffff0000);
                        //
                    }

                    if (data_redio2.isEmpty()) {
                        // Log.e("no_data","no_data");

                        li_pay_one.setBackgroundColor(0xffff0000);
                        //
                    }
                    if (data_redio3.isEmpty()) {
                        //Log.e("no_data","no_data");

                        li_confirm.setBackgroundColor(0xffff0000);
                        //
                    }
                    if (status_pen == 0) {
                        li_pen.setBackgroundColor(0xffff0000);
                    }

                    if(GET_date2.equals("-")){
                        li_pay2.setBackgroundColor(0xffff0000);

                    }
                    if(radioSex_re_S.isEmpty()){
                        li_remarket.setBackgroundColor(0xffff0000);

                    }
                    if(radioSex_retain_S.isEmpty()){
                        li_retain.setBackgroundColor(0xffff0000);

                    }
                    if(data_radioSex_con.isEmpty()){
                        li_conveniently.setBackgroundColor(0xffff0000);

                    }

                    sweet_dailog_waining_checker("ยังไม่ปักหมุด","2");

                }

                else if((size4==0)&(size_map==1)){
                    li1.setBackgroundColor(0xffff0000);
                    // li2.setBackgroundColor(0xffff0000);


                    sweet_dailog_waining_checker("ยังไม่ถ่ายรูปหน้าบ้าน","1");
                }










                else if(radioSex_re_S.isEmpty()){
                    Log.e("test_error", "20");

                    li_remarket.setBackgroundColor(0xffff0000);

                    sweet_dailog_waining_checker("ยังไม่เลือก เคยซื้อสินค้าบริษัท?","7");
                }
                else if(radioSex_retain_S.isEmpty()){
                    Log.e("test_error", "21");

                    li_retain.setBackgroundColor(0xffff0000);

                    sweet_dailog_waining_checker("ยังไม่เลือก มีเครื่องเทร์น?","8");
                }













                else  if(data_redio2.isEmpty()){
                    Log.e("test_error", "16");
                    // Log.e("no_data","no_data");

                    li_pay_one.setBackgroundColor(0xffff0000);

                    if(data_redio1.isEmpty()){
                        //Log.e("no_data","no_data");

                        li_install2.setBackgroundColor(0xffff0000);
                        //
                    }

                    if(data_redio2.isEmpty()){
                        // Log.e("no_data","no_data");

                        li_pay_one.setBackgroundColor(0xffff0000);
                        //
                    }
                    if(data_redio3.isEmpty()){
                        //Log.e("no_data","no_data");

                        li_confirm.setBackgroundColor(0xffff0000);
                        //
                    }
                    if(status_qr==1){
                        if(size1==0){

                            li3.setBackgroundColor(0xffff0000);
                        }
                        else {
                            li3.setBackgroundColor(0xffffffff);
                        }
                    }
                    if(status_pen==0){
                        li_pen.setBackgroundColor(0xffff0000);
                    }
                    if(GET_date2.equals("-")){
                        li_pay2.setBackgroundColor(0xffff0000);

                    }

                    if(radioSex_re_S.isEmpty()){
                        li_remarket.setBackgroundColor(0xffff0000);

                    }
                    if(radioSex_retain_S.isEmpty()){
                        li_retain.setBackgroundColor(0xffff0000);

                    }
                    if(data_radioSex_con.isEmpty()){
                        li_conveniently.setBackgroundColor(0xffff0000);

                    }
                    //
                    sweet_dailog_waining_checker("ยังไม่เลือก การชำระงวดแรก?","9");
                }
                else if(GET_date2.equals("-")){
                    Log.e("test_error", "22");

                    li_pay2.setBackgroundColor(0xffff0000);
                    sweet_dailog_waining_checker("ยังไม่เลือก การชำระงวด 2?","10");
                }

                else if(data_redio3.isEmpty()){
                    Log.e("test_error", "17");
                    //Log.e("no_data","no_data");

                    li_confirm.setBackgroundColor(0xffff0000);
                    //

                    if(data_redio1.isEmpty()){
                        //Log.e("no_data","no_data");

                        li_install2.setBackgroundColor(0xffff0000);
                        //
                    }

                    if(data_redio2.isEmpty()){
                        // Log.e("no_data","no_data");

                        li_pay_one.setBackgroundColor(0xffff0000);
                        //
                    }
                    if(data_redio3.isEmpty()){
                        //Log.e("no_data","no_data");

                        li_confirm.setBackgroundColor(0xffff0000);
                        //
                    }
                    if(status_qr==1){
                        if(size1==0){

                            li3.setBackgroundColor(0xffff0000);
                        }
                        else {
                            li3.setBackgroundColor(0xffffffff);
                        }
                    }
                    if(status_pen==0){
                        li_pen.setBackgroundColor(0xffff0000);
                    }

                    if(GET_date2.equals("-")){
                        li_pay2.setBackgroundColor(0xffff0000);

                    }


                    if(radioSex_re_S.isEmpty()){
                        li_remarket.setBackgroundColor(0xffff0000);

                    }
                    if(radioSex_retain_S.isEmpty()){
                        li_retain.setBackgroundColor(0xffff0000);

                    }
                    if(data_radioSex_con.isEmpty()){
                        li_conveniently.setBackgroundColor(0xffff0000);

                    }

                    sweet_dailog_waining_checker("ยังไม่เลือก การผ่อนชำระ?","11");
                }




                else if(status_pen==0){
                    Log.e("test_error", "19");

                    li_pen.setBackgroundColor(0xffff0000);

                    if(GET_date2.equals("-")){
                        li_pay2.setBackgroundColor(0xffff0000);

                    }
                    if(data_radioSex_con.isEmpty()){
                        li_conveniently.setBackgroundColor(0xffff0000);

                    }
                    sweet_dailog_waining_checker("ยังไม่ เซ็นชื่อ","12");
                }

                else if(data_radioSex_con.isEmpty()){
                    li_conveniently.setBackgroundColor(0xffff0000);

                }

                else if(select_color==0){

                    if (check_nonti_web == 0) {
                        connectSocket("ตรวจสอบได้ เข้าบ้านลูกค้าไม่ได้");
                        check_nonti_web = 1;
                    } else {
                        try {
                            webSocketClient.close();
                        } catch (Exception e) {

                        }

                    }

                    //li_line8.setBackgroundColor(0xffff0000);

                    final Dialog dialog = new Dialog(this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.custom_dialog_select_color_status);
                    dialog.setCancelable(false);




                    TextView   count1=(TextView)dialog.findViewById(R.id.count1);
                    TextView  count2=(TextView)dialog.findViewById(R.id.count2);
                    TextView count3=(TextView)dialog.findViewById(R.id.count3);
                    RelativeLayout r_sddddave=(RelativeLayout)dialog.findViewById(R.id.r_sddddave);
                    LinearLayout li_text=(LinearLayout)dialog.findViewById(R.id.li_text);
                    RelativeLayout exit=(RelativeLayout)dialog.findViewById(R.id.exit);




                    count1.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            count1.setText("✔");count2.setText("");count3.setText("");
                            //color=0xfff40707;
                            select_color=1;
                            select_color_S="03";
                            if(select_color!=0){
                                li_line8.setBackgroundColor(0xffffffff);
                            }
                            li_text.setVisibility(View.GONE);
                        }
                    });
                    count2.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            count1.setText("");count2.setText("✔");count3.setText("");
                            //color=0xfffcc7c7;
                            select_color=2;
                            select_color_S="02";
                            if(select_color!=0){
                                li_line8.setBackgroundColor(0xffffffff);
                            }
                            li_text.setVisibility(View.GONE);
                        }
                    });
                    count3.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            count1.setText("");count2.setText("");count3.setText("✔");
                            //color=0xff808080;
                            select_color=3;
                            select_color_S="01";
                            if(select_color!=0){
                                li_line8.setBackgroundColor(0xffffffff);
                            }
                            li_text.setVisibility(View.GONE);
                        }
                    });

                    exit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            select_color=0;
                            dialog.cancel();
                            check_open_dialog=0;

                        }
                    });
                    r_sddddave.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            if(select_color!=0){
                                dialog.cancel();
                                li_text.setVisibility(View.GONE);



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




                                if(item_click==0){

                                 /*          insert_CheckerCard_Master();

                                           insert_CheckerCard_Details_home_in();
                                           insert_CheckerCard_Details_gps_maker();
                                           insert_CheckerCard_Details_qr_scan();
                                           insert_CheckerCard_Details_install();
                                           insert_CheckerCard_Details_checker_who();
                                           insert_CheckerCard_Details_customer1();
                                           insert_CheckerCard_Details_tain();
                                           insert_CheckerCard_Details_date_to_date();
                                           insert_remarket();
                                           if (CheckBox_status==1){
                                               insert_CheckerCard_Details_customer2();
                                           }


                                           insert_CheckerCard_Details_confrim();*/

                                }
                                else  if(item_click==1){
                                    insert_CheckerCard_Master();
                                    insert_CheckerCard_Details_home_in();
                                    insert_CheckerCard_Details_gps_maker();
                                    insert_CheckerCard_Details_checker_who();
                                    insert_CheckerCard_Details_customer1();
                                    insert_CheckerCard_Details_tain();
                                    insert_CheckerCard_Details_date_to_date();
                                    insert_remarket();
                                    if (CheckBox_status==1){
                                        insert_CheckerCard_Details_customer2();
                                    }


                                    insert_CheckerCard_Details_confrim();

                                    insert_CheckerCard_Details_conveniently();

                                    update_CheckerCard_Master();

                                }
                                else if(item_click==2){
                                /*           insert_CheckerCard_Master();
                                           insert_CheckerCard_Details_home_in();
                                           insert_CheckerCard_Details_gps_maker();*/
                                }
                                else {

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


                                pDialogg = new SweetAlertDialog(Detali_check1.this, SweetAlertDialog.PROGRESS_TYPE);
                                pDialogg.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                                pDialogg.setTitleText("กำลังอัปโหลด...");
                                pDialogg.setCancelable(false);









                                SQLiteDataBaseBuild_data_checker_problem_for_report();
                                SQLiteTableBuild_data_checker_problem_for_report();

                                cursor = sqLiteDatabase.rawQuery("SELECT /*count(SUB)as dd,*/CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID  FROM " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME, null);

                                if (cursor.moveToFirst()) {
                                    do {


                                    } while (cursor.moveToNext());
                                }
                                cursor.close();











                                try {
                                    uploadMultiFile();
                                } catch (Exception ex) {

                                }

                                select_color=0;

                            }
                            else {
                                li_text.setVisibility(View.VISIBLE);
                            }

                        }
                    });

                    if(check_open_dialog==0){
                        dialog.show();
                        check_open_dialog=1;
                    }

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




                    if(item_click==0){

                        insert_CheckerCard_Master();

                        insert_CheckerCard_Details_home_in();
                        insert_CheckerCard_Details_gps_maker();
                        insert_CheckerCard_Details_qr_scan();
                        insert_CheckerCard_Details_install();
                        insert_CheckerCard_Details_checker_who();
                        insert_CheckerCard_Details_customer1();
                        insert_CheckerCard_Details_tain();
                        insert_CheckerCard_Details_date_to_date();
                        insert_remarket();
                        if (CheckBox_status==1){
                            insert_CheckerCard_Details_customer2();
                        }


                        insert_CheckerCard_Details_confrim();

                    }
                    else  if(item_click==1){
                        insert_CheckerCard_Master();
                        insert_CheckerCard_Details_home_in();
                        insert_CheckerCard_Details_gps_maker();
                        insert_CheckerCard_Details_checker_who();
                        insert_CheckerCard_Details_customer1();
                        insert_CheckerCard_Details_tain();
                        insert_CheckerCard_Details_date_to_date();
                        insert_remarket();
                        if (CheckBox_status==1){
                            insert_CheckerCard_Details_customer2();
                        }


                        insert_CheckerCard_Details_confrim();

                    }
                    else if(item_click==2){
                        insert_CheckerCard_Master();
                        insert_CheckerCard_Details_home_in();
                        insert_CheckerCard_Details_gps_maker();
                    }
                    else {

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









                    SQLiteDataBaseBuild_data_checker_problem_for_report();
                    SQLiteTableBuild_data_checker_problem_for_report();

                    cursor = sqLiteDatabase.rawQuery("SELECT /*count(SUB)as dd,*/CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID  FROM " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME, null);

                    if (cursor.moveToFirst()) {
                        do {


                        } while (cursor.moveToNext());
                    }
                    cursor.close();











                    try {
                        uploadMultiFile();
                    } catch (Exception ex) {

                    }

                    select_color=0;
                }
            }
            else if(item_click==2){
                CHECK_PROBLEM="99";
                if((size4==0)&(size_map==0)){   // 1
//                       if(check_maker_gps==1){
//                           size_map=1;
//                           li1.setBackgroundColor(0xffff0000);
//
//                       }
                    //  else {
                    li1.setBackgroundColor(0xffff0000);
                    li2.setBackgroundColor(0xffff0000);

                    sweet_dailog_waining_checker("ยังไม่ถ่ายรูปหน้าบ้าน","1");
                    //  }
                }
                else if((size4==1)&(size_map==0)){
//                       if(check_maker_gps==1){
//                           size_map=1;
//                       }
//                       else {
                    // li1.setBackgroundColor(0xffff0000);
                    li2.setBackgroundColor(0xffff0000);

                    sweet_dailog_waining_checker("ยังไม่ปักหมุด","2");
                    //   }
                }
                else if((size4==0)&(size_map==1)){
                    li1.setBackgroundColor(0xffff0000);
                    // li2.setBackgroundColor(0xffff0000);


                    sweet_dailog_waining_checker("ยังไม่ถ่ายรูปหน้าบ้าน","1");
                }

                else if(select_color==0){

                    if (check_nonti_web == 0) {
                        connectSocket("ตรวจสอบไม่ได้");
                        check_nonti_web = 1;
                    } else {
                        try {
                            webSocketClient.close();
                        } catch (Exception e) {

                        }

                    }

                    //li_line8.setBackgroundColor(0xffff0000);

                    final Dialog dialog = new Dialog(this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.custom_dialog_select_color_status);
                    dialog.setCancelable(false);




                    TextView   count1=(TextView)dialog.findViewById(R.id.count1);
                    TextView  count2=(TextView)dialog.findViewById(R.id.count2);
                    TextView count3=(TextView)dialog.findViewById(R.id.count3);
                    RelativeLayout r_sddddave=(RelativeLayout)dialog.findViewById(R.id.r_sddddave);
                    LinearLayout li_text=(LinearLayout)dialog.findViewById(R.id.li_text);
                    RelativeLayout exit=(RelativeLayout)dialog.findViewById(R.id.exit);




                    count1.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            count1.setText("✔");count2.setText("");count3.setText("");
                            //color=0xfff40707;
                            select_color=1;
                            select_color_S="03";
                            if(select_color!=0){
                                li_line8.setBackgroundColor(0xffffffff);
                            }
                            li_text.setVisibility(View.GONE);
                        }
                    });
                    count2.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            count1.setText("");count2.setText("✔");count3.setText("");
                            //color=0xfffcc7c7;
                            select_color=2;
                            select_color_S="02";
                            if(select_color!=0){
                                li_line8.setBackgroundColor(0xffffffff);
                            }
                            li_text.setVisibility(View.GONE);
                        }
                    });
                    count3.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            count1.setText("");count2.setText("");count3.setText("✔");
                            //color=0xff808080;
                            select_color=3;
                            select_color_S="01";
                            if(select_color!=0){
                                li_line8.setBackgroundColor(0xffffffff);
                            }
                            li_text.setVisibility(View.GONE);
                        }
                    });

                    exit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            select_color=0;
                            dialog.cancel();
                            check_open_dialog=0;
                        }
                    });

                    r_sddddave.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            if(select_color!=0){
                                dialog.cancel();
                                li_text.setVisibility(View.GONE);




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




                                if(item_click==0){



                                    insert_CheckerCard_Master();

                                    insert_CheckerCard_Details_home_in();
                                    insert_CheckerCard_Details_gps_maker();
                                    insert_CheckerCard_Details_qr_scan();
                                    insert_CheckerCard_Details_install();
                                    insert_CheckerCard_Details_checker_who();
                                    insert_CheckerCard_Details_customer1();
                                    insert_CheckerCard_Details_tain();
                                    insert_CheckerCard_Details_date_to_date();
                                    insert_remarket();
                                    if (CheckBox_status==1){
                                        insert_CheckerCard_Details_customer2();
                                    }


                                    insert_CheckerCard_Details_confrim();

                                }
                                else  if(item_click==1){
                                    insert_CheckerCard_Master();
                                    insert_CheckerCard_Details_home_in();
                                    insert_CheckerCard_Details_gps_maker();
                                    insert_CheckerCard_Details_checker_who();
                                    insert_CheckerCard_Details_customer1();
                                    insert_CheckerCard_Details_tain();
                                    insert_CheckerCard_Details_date_to_date();
                                    insert_remarket();
                                    if (CheckBox_status==1){
                                        insert_CheckerCard_Details_customer2();
                                    }


                                    insert_CheckerCard_Details_confrim();

                                }
                                else if(item_click==2){
                                    insert_CheckerCard_Master();
                                    insert_CheckerCard_Details_home_in();
                                    insert_CheckerCard_Details_gps_maker();
                                }
                                else {

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


                                pDialogg = new SweetAlertDialog(Detali_check1.this, SweetAlertDialog.PROGRESS_TYPE);
                                pDialogg.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                                pDialogg.setTitleText("กำลังอัปโหลด...");
                                pDialogg.setCancelable(false);









                                SQLiteDataBaseBuild_data_checker_problem_for_report();
                                SQLiteTableBuild_data_checker_problem_for_report();

                                cursor = sqLiteDatabase.rawQuery("SELECT /*count(SUB)as dd,*/CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID  FROM " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME, null);

                                if (cursor.moveToFirst()) {
                                    do {


                                    } while (cursor.moveToNext());
                                }
                                cursor.close();











                                try {
                                    uploadMultiFile();
                                } catch (Exception ex) {

                                }

                          /*             SQLiteDataBaseBuild_data_checker_problem_for_report();
                                       SQLiteTableBuild_data_checker_problem_for_report();
                                       String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + " (CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID) VALUES('" + conno + "','" + "ปัญหาการ์ดตรวจสอบ" + "','" + "ปัญหาอื่นๆ" + "','" + "ตรวจสอบไม่ได้" + "','" + new_message_scan.getText().toString()  + "','" + "ตรวจสอบไม่ได้" + "');";
                                       sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
*/



                                if (check_nonti_web == 0) {
                                    connectSocket("ตรวจสอบไม่ได้");
                                    check_nonti_web = 1;
                                } else {
                                    try {
                                        webSocketClient.close();
                                    } catch (Exception e) {

                                    }

                                }





                            }
                            else {
                                li_text.setVisibility(View.VISIBLE);
                            }

                        }
                    });

                    if(check_open_dialog==0){
                        dialog.show();
                        check_open_dialog=1;
                    }

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




                    if(item_click==0){



                        insert_CheckerCard_Master();

                        insert_CheckerCard_Details_home_in();
                        insert_CheckerCard_Details_gps_maker();
                        insert_CheckerCard_Details_qr_scan();
                        insert_CheckerCard_Details_install();
                        insert_CheckerCard_Details_checker_who();
                        insert_CheckerCard_Details_customer1();
                        insert_CheckerCard_Details_tain();
                        insert_CheckerCard_Details_date_to_date();
                        insert_remarket();
                        if (CheckBox_status==1){
                            insert_CheckerCard_Details_customer2();
                        }


                        insert_CheckerCard_Details_confrim();

                    }
                    else  if(item_click==1){
                        insert_CheckerCard_Master();
                        insert_CheckerCard_Details_home_in();
                        insert_CheckerCard_Details_gps_maker();
                        insert_CheckerCard_Details_checker_who();
                        insert_CheckerCard_Details_customer1();
                        insert_CheckerCard_Details_tain();
                        insert_CheckerCard_Details_date_to_date();
                        insert_remarket();
                        if (CheckBox_status==1){
                            insert_CheckerCard_Details_customer2();
                        }


                        insert_CheckerCard_Details_confrim();

                    }
                    else if(item_click==2){
                        insert_CheckerCard_Master();
                        insert_CheckerCard_Details_home_in();
                        insert_CheckerCard_Details_gps_maker();
                    }
                    else {

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









                    SQLiteDataBaseBuild_data_checker_problem_for_report();
                    SQLiteTableBuild_data_checker_problem_for_report();

                    cursor = sqLiteDatabase.rawQuery("SELECT /*count(SUB)as dd,*/CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID  FROM " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME, null);

                    if (cursor.moveToFirst()) {
                        do {


                        } while (cursor.moveToNext());
                    }
                    cursor.close();











                    try {
                        uploadMultiFile();
                    } catch (Exception ex) {

                    }

/*
                       SQLiteDataBaseBuild_data_checker_problem_for_report();
                       SQLiteTableBuild_data_checker_problem_for_report();
                       String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + " (CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID) VALUES('" + conno + "','" + "ปัญหาการ์ดตรวจสอบ" + "','" + "ปัญหาอื่นๆ" + "','" + "ตรวจสอบไม่ได้" + "','" + new_message_scan.getText().toString()  + "','" + "ตรวจสอบไม่ได้" + "');";
                       sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
*/




                    if (check_nonti_web == 0) {
                        connectSocket("ตรวจสอบไม่ได้");
                        check_nonti_web = 1;
                    } else {
                        try {
                            webSocketClient.close();
                        } catch (Exception e) {

                        }

                    }

                     /*  SQLiteDataBaseBuild_data_checker_problem_for_report();
                       SQLiteTableBuild_data_checker_problem_for_report();
                       String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + " (CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID) VALUES('" + conno + "','" + "ปัญหาการ์ดตรวจสอบ" + "','" + "ปัญหาอื่นๆ" + "','" + "หมายเลขเครื่องไม่ตรงกัน" + "','" + new_message_scan.getText().toString() + "','" + "ตรวจสอบได้ เข้าบ้านลูกค้าได้" + "');";
                       sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
                       */
                     /*  try {
                           sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
                       }
                       catch (Exception ex){

                       }*/

                }

            }
            else if(item_click==3){






                CHECK_PROBLEM="99";













                if(select_color==0){

                    if (check_nonti_web == 0) {
                        connectSocket("นอกเขตการขาย");
                        check_nonti_web = 1;
                    } else {
                        try {
                            webSocketClient.close();
                        } catch (Exception e) {

                        }

                    }

                    //li_line8.setBackgroundColor(0xffff0000);

                    final Dialog dialog = new Dialog(this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.custom_dialog_select_color_status);
                    dialog.setCancelable(false);




                    TextView   count1=(TextView)dialog.findViewById(R.id.count1);
                    TextView  count2=(TextView)dialog.findViewById(R.id.count2);
                    TextView count3=(TextView)dialog.findViewById(R.id.count3);
                    RelativeLayout r_sddddave=(RelativeLayout)dialog.findViewById(R.id.r_sddddave);
                    LinearLayout li_text=(LinearLayout)dialog.findViewById(R.id.li_text);
                    RelativeLayout exit=(RelativeLayout)dialog.findViewById(R.id.exit);




                    count1.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            count1.setText("✔");count2.setText("");count3.setText("");
                            //color=0xfff40707;
                            select_color=1;
                            select_color_S="03";
                            if(select_color!=0){
                                li_line8.setBackgroundColor(0xffffffff);
                            }
                            li_text.setVisibility(View.GONE);
                        }
                    });
                    count2.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            count1.setText("");count2.setText("✔");count3.setText("");
                            //color=0xfffcc7c7;
                            select_color=2;
                            select_color_S="02";
                            if(select_color!=0){
                                li_line8.setBackgroundColor(0xffffffff);
                            }
                            li_text.setVisibility(View.GONE);
                        }
                    });
                    count3.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            count1.setText("");count2.setText("");count3.setText("✔");
                            //color=0xff808080;
                            select_color=3;
                            select_color_S="01";
                            if(select_color!=0){
                                li_line8.setBackgroundColor(0xffffffff);
                            }
                            li_text.setVisibility(View.GONE);
                        }
                    });

                    exit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            select_color=0;
                            dialog.cancel();
                            check_open_dialog=0;
                        }
                    });

                    r_sddddave.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            if(select_color!=0){
                                dialog.cancel();
                                li_text.setVisibility(View.GONE);




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




                                if(item_click==0){


                                }
                                else  if(item_click==1){


                                }
                                else if(item_click==2){

                                }

                                else if(item_click==3){
                                    insert_CheckerCard_Master();
                                    //insert_CheckerCard_Details_home_in();
                                    insert_CheckerCard_Details_select4();
                                }

                                else {

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


                                pDialogg = new SweetAlertDialog(Detali_check1.this, SweetAlertDialog.PROGRESS_TYPE);
                                pDialogg.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                                pDialogg.setTitleText("กำลังอัปโหลด...");
                                pDialogg.setCancelable(false);









                                SQLiteDataBaseBuild_data_checker_problem_for_report();
                                SQLiteTableBuild_data_checker_problem_for_report();

                                cursor = sqLiteDatabase.rawQuery("SELECT /*count(SUB)as dd,*/CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID  FROM " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME, null);

                                if (cursor.moveToFirst()) {
                                    do {


                                    } while (cursor.moveToNext());
                                }
                                cursor.close();











                                try {
                                    uploadMultiFile();
                                } catch (Exception ex) {
                                    select_check_sucess_all();
                                }




                                if (check_nonti_web == 0) {
                                    connectSocket("นอกเขตการขาย");
                                    check_nonti_web = 1;
                                } else {
                                    try {
                                        webSocketClient.close();
                                    } catch (Exception e) {

                                    }

                                }





                            }
                            else {
                                li_text.setVisibility(View.VISIBLE);
                            }

                        }
                    });

                    if(check_open_dialog==0){
                        dialog.show();
                        check_open_dialog=1;
                    }

                }


            }

            else if(item_click==4){

                select_CheckerCard_AgainPending();

                new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("คุณแน่ใจไหม?")
                        .setContentText("ที่ต้องการบันทึกข้อมูล การรอตรวจไหม่!")
                        .setCancelText("ไม่,ออก!")
                        .setConfirmText("ใช่,บันทึก!")
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
                                Log.e("55555","รอตรวจไหม่");

                                insert_CheckerCard_AgainPending();

                                sDialog.cancel();

                                SweetAlertDialog sweetAlertDialog =  new SweetAlertDialog(Detali_check1.this);
                                sweetAlertDialog.setTitleText("บันทึกเสร็จสิ้น!");

                                sweetAlertDialog.setCancelable(false);
                                sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sweetAlertDialog) {


                                        SQLiteDataBaseBuild_data_type();
                                        SQLiteTableBuild_data_type();
                                        sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_data_type.TABLE_NAME+"");

                                        sweetAlertDialog.cancel();
                                        sweetAlertDialog.dismiss();
                                        Intent = new Intent(Detali_check1.this, MusicActivity_Checker.class);
                                        startActivity(Intent);
                                        finish();

                                                /*   Intent = new Intent(Detali_check1.this, MusicActivity_Checker.class);
                                                   startActivity(Intent);
                                                   finish();*/

                                    }
                                });
                                sweetAlertDialog.show();
                            }
                        })
                        .show();
            }











            MyApplication.getInstance().getPrefManager().setPreferrence("dat2", "1");
            //MyApplication.getInstance().getPrefManager().setPreferrence("key_sort", null);
            MyApplication.getInstance().getPrefManager().setPreferrence("intro_save", "0");

































    }
    private void sweet_dailog_waining_checker(String error_code,String line){

        try {
          String debug_run_error_checker1=  MyApplication.getInstance().getPrefManager().getPreferrence("debug_run_error_checker1");

            if(debug_run_error_checker1.equals("1")){
                SweetAlertDialog sweetAlertDialog=     new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE);
                sweetAlertDialog.setTitleText("! ข้อมูลยังไม่ครบ");
                sweetAlertDialog .setContentText("กรุณาตรวจสอบข้อมูลก่อน!");
                sweetAlertDialog.setConfirmText(error_code);
                sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismissWithAnimation();








try {

   String android_name=MyApplication.getInstance().getPrefManager().getPreferrence("android_name");
   if(android_name.equals("HUAWEI DUB-LX2 8.1.0 O")){
       if(line.equals("1")){
           //  scrollView.scrollTo(0,0);
           scrollView.smoothScrollTo(0,0);
           //scrollView.smoothScrollBy(0,0);
       }
       else if(line.equals("2")){
           // scrollView.scrollTo(0, 250);
           scrollView.smoothScrollTo(0,250);
           // scrollView.smoothScrollBy(0,250);
       }

       else if(line.equals("3")){
           //scrollView.scrollTo(0,1800);
           scrollView.smoothScrollTo(0,1800);
           //scrollView.smoothScrollBy(0,1800);
       }

       else if(line.equals("4")){
           // scrollView.scrollTo(0,1900);
           scrollView.smoothScrollTo(0,2000);
           //scrollView.smoothScrollBy(0,1900);
       }

       else if(line.equals("5")){
           //scrollView.scrollTo(0,2000);
           scrollView.smoothScrollTo(0,2200);
           // scrollView.smoothScrollBy(0,2000);
       }


       else if(line.equals("6")){
           // scrollView.scrollTo(0,2200);
           scrollView.smoothScrollTo(0,2500);
           // scrollView.smoothScrollBy(0,2200);
       }



       else if(line.equals("7")){
           //scrollView.scrollTo(0,2500);

           if(item_click==0){

               scrollView.smoothScrollTo(0,3300);
           }
           else {
               scrollView.smoothScrollTo(0,2100);
           }


           // scrollView.smoothScrollBy(0,2500);
       }


       else if(line.equals("8")){
           //   scrollView.scrollTo(0,2800);

           if(item_click==0){

               scrollView.smoothScrollTo(0,3500);
           }
           else {
               scrollView.smoothScrollTo(0,2300);
           }
           //scrollView.smoothScrollBy(0,2800);
       }

       else if(line.equals("9")){
           //scrollView.scrollTo(0,3100);

           if(item_click==0){

               scrollView.smoothScrollTo(0,3700);
           }
           else {
               scrollView.smoothScrollTo(0,2500);
           }
           //scrollView.smoothScrollBy(0,3100);
       }


       else if(line.equals("10")){
           // scrollView.scrollTo(0,3500);

           if(item_click==0){

               scrollView.smoothScrollTo(0,4000);
           }
           else {
               scrollView.smoothScrollTo(0,2800);
           }
           //  scrollView.smoothScrollBy(0,3500);
       }


       else if(line.equals("11")){
           // scrollView.scrollTo(0,4000);

           if(item_click==0){

               scrollView.smoothScrollTo(0,4500);
           }
           else {
               scrollView.smoothScrollTo(0,3300);
           }
           // scrollView.smoothScrollBy(0,4000);
       }


       else if(line.equals("12")){
           //   scrollView.scrollTo(0,5000);

           if(item_click==0){

               scrollView.smoothScrollTo(0,5000);
           }
           else {
               scrollView.smoothScrollTo(0,3800);
           }
           //  scrollView.smoothScrollBy(0,5000);
       }
       }

}
catch (Exception ex){

}




                    }
                });

                sweetAlertDialog .show();
            }
            else {
                new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("! ข้อมูลยังไม่ครบ")
                        .setContentText("กรุณาตรวจสอบข้อมูลก่อน!")
                        .setConfirmText("OK!")
                        .show();
            }

        }
        catch (Exception ex){
            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("! ข้อมูลยังไม่ครบ")
                    .setContentText("กรุณาตรวจสอบข้อมูลก่อน!")
                    .setConfirmText("OK!")
                    .show();
        }

    }

    private void color_error(){
        String QR_S=txt_scan.getText().toString();
        li1.setBackgroundColor(0xffffffff);
        li2.setBackgroundColor(0xffffffff);

        if(size1==0){

            li3.setBackgroundColor(0xffff0000);
        }
        else {
            li3.setBackgroundColor(0xffffffff);
        }



        li4.setBackgroundColor(0xffffffff);
        li5.setBackgroundColor(0xffffffff);
        li6.setBackgroundColor(0xffffffff);
        li7.setBackgroundColor(0xffffffff);

        Log.e("size", String.valueOf(size4+","+size_map+","+size5));
        if((size4==0)&(size_map==0)&(size5==0)&QR_S.equals("สแกน QR/BAR CODE")){   // 1
            li1.setBackgroundColor(0xffff0000);
            li2.setBackgroundColor(0xffff0000);
            li4.setBackgroundColor(0xffff0000);
            li7.setBackgroundColor(0xffff0000);
            //
        }
        else if((size4==1)&(size_map==0)&(size5==0)&QR_S.equals("สแกน QR/BAR CODE")){
            // li1.setBackgroundColor(0xffff0000);
            li2.setBackgroundColor(0xffff0000);
            li4.setBackgroundColor(0xffff0000);
            li7.setBackgroundColor(0xffff0000);
           //
        }
        else if((size4==1)&(size_map==1)&(size5==0)&QR_S.equals("สแกน QR/BAR CODE")){
            // li1.setBackgroundColor(0xffff0000);
            //  li2.setBackgroundColor(0xffff0000);
            li4.setBackgroundColor(0xffff0000);
            li7.setBackgroundColor(0xffff0000);

           //
        }
        else if((size4==1)&(size_map==1)&(size5==1)&QR_S.equals("สแกน QR/BAR CODE")){
            //  li1.setBackgroundColor(0xffff0000);
            // li2.setBackgroundColor(0xffff0000);
            //  li4.setBackgroundColor(0xffff0000);
            li7.setBackgroundColor(0xffff0000);

            //
        }

        else if((size4==0)&(size_map==1)&(size5==0)&QR_S.equals("สแกน QR/BAR CODE")){
            li1.setBackgroundColor(0xffff0000);
            //li2.setBackgroundColor(0xffff0000);
            li4.setBackgroundColor(0xffff0000);
            li7.setBackgroundColor(0xffff0000);

            //
        }
        else if((size4==0)&(size_map==0)&(size5==1)&QR_S.equals("สแกน QR/BAR CODE")){
            li1.setBackgroundColor(0xffff0000);
            li2.setBackgroundColor(0xffff0000);
            // li4.setBackgroundColor(0xffff0000);
            li7.setBackgroundColor(0xffff0000);

            //
        }
        else if((size4==0)&(size_map==1)&(size5==1)&QR_S.equals("สแกน QR/BAR CODE")){
            li1.setBackgroundColor(0xffff0000);
            // li2.setBackgroundColor(0xffff0000);
            // li4.setBackgroundColor(0xffff0000);
            li7.setBackgroundColor(0xffff0000);
           //
        }




        else if((size4==0)&(size_map==0)&(size5==0)&!QR_S.equals("สแกน QR/BAR CODE")){   // 1
            li1.setBackgroundColor(0xffff0000);
            li2.setBackgroundColor(0xffff0000);
            li4.setBackgroundColor(0xffff0000);
            //  li7.setBackgroundColor(0xffff0000);
           //
        }
        else if((size4==1)&(size_map==0)&(size5==0)&!QR_S.equals("สแกน QR/BAR CODE")){
            //  li1.setBackgroundColor(0xffff0000);
            li2.setBackgroundColor(0xffff0000);
            li4.setBackgroundColor(0xffff0000);
            //  li7.setBackgroundColor(0xffff0000);
          //
        }
        else if((size4==1)&(size_map==1)&(size5==0)&!QR_S.equals("สแกน QR/BAR CODE")){
            //li1.setBackgroundColor(0xffff0000);
            // li2.setBackgroundColor(0xffff0000);
            li4.setBackgroundColor(0xffff0000);
            //  li7.setBackgroundColor(0xffff0000);
          //
        }


        else if((size4==0)&(size_map==1)&(size5==0)&!QR_S.equals("สแกน QR/BAR CODE")){
            li1.setBackgroundColor(0xffff0000);
            // li2.setBackgroundColor(0xffff0000);
            li4.setBackgroundColor(0xffff0000);
            //  li7.setBackgroundColor(0xffff0000);
           //
        }
        else if((size4==0)&(size_map==0)&(size5==1)&!QR_S.equals("สแกน QR/BAR CODE")){
            li1.setBackgroundColor(0xffff0000);
            li2.setBackgroundColor(0xffff0000);
            // li4.setBackgroundColor(0xffff0000);
            //  li7.setBackgroundColor(0xffff0000);

           //
        }
        else if((size4==0)&(size_map==1)&(size5==1)&!QR_S.equals("สแกน QR/BAR CODE")){
            li1.setBackgroundColor(0xffff0000);
            //   li2.setBackgroundColor(0xffff0000);
            //  li4.setBackgroundColor(0xffff0000);
            //  li7.setBackgroundColor(0xffff0000);

         //
        }
        else if((size4==1)&(size_map==0)&(size5==1)&QR_S.equals("สแกน QR/BAR CODE")){
            // li1.setBackgroundColor(0xffff0000);
            li2.setBackgroundColor(0xffff0000);
            //  li4.setBackgroundColor(0xffff0000);
            li7.setBackgroundColor(0xffff0000);

          //
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









    public void SQLiteDataBaseBuild_data_type(){
        sqLiteDatabase =openOrCreateDatabase(SQLiteHelper_data_type.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
    public void SQLiteTableBuild_data_type(){
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_data_type.TABLE_NAME+"("+ SQLiteHelper_data_type.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_data_type.Table_part_id+" VARCHAR, "+SQLiteHelper_data_type.Table_ProcessTypeName+" VARCHAR, "+SQLiteHelper_data_type.Table_Processclick+" VARCHAR);");
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
                status_qr=1;
                size1=0;
            } else {
                my_recycler_view1.setVisibility(View.VISIBLE);
                status_qr=0;
                li3.setBackgroundColor(0xffffffff);
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
                size2=0;
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
            size3=0;
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
            size4=0;
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
            size5=0;
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
            size_map=0;
        } else {
            my_recycler_view_map.setVisibility(View.VISIBLE);
        }
        //select_image();
        check_buttom_remove_image_map = 1;


    }





    public void SELECT_DATA_PROBLEM_GORY() {

        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_gory_1 ,


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


    public void SELECT_DATA_PROBLEM_GORY_save_back(String AnswerName) {

        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_gory_1_save_back+"?AnswerName="+AnswerName ,


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

                MyApplication.getInstance().getPrefManager().setPreferrence("item", item);

               //Log.e("position_item", String.valueOf(position));
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

        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_gory_2_checker ,


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







    public void SELECT_DATA_PROBLEM_GORY1_save_back(String AnswerName) {

        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_gory_2_save_back+"?AnswerName="+AnswerName ,


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
                MyApplication.getInstance().getPrefManager().setPreferrence("item1", item1);
                if(item1.equals("ปักหมุดไม่ได้/ไม่มีสัญญาณ")){
                    check_maker_gps=1;
                    li_gps.setVisibility(View.GONE);
                    size_map=1;
                }
                else {
                    size_map=0;
                    check_maker_gps=0;
                    li_gps.setVisibility(View.VISIBLE);
                }

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

        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_gory_3 ,


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






    public void SELECT_DATA_PROBLEM_GORY2_save_back(String AnswerName) {

        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_gory_3_save_back+"?AnswerName="+AnswerName ,


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

        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_gory_4 ,


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





    public void SELECT_DATA_PROBLEM_GORY3_save_back(String AnswerName) {

        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_gory_4_save_back +"?AnswerName="+AnswerName,


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
                item3 = parent.getItemAtPosition(position).toString();
                Log.e("spDemo3",item3);

                MyApplication.getInstance().getPrefManager().setPreferrence("item3", item3);

                final GetData_select_checker_who contact = getData_select_checker_whos.get(position);
                AnswerID_who= contact.getAnswerID();
                TopicID_who= contact.getTopicID();
                if(item3.equals("ญาติ/เพื่อน")){
                    li_who.setVisibility(View.VISIBLE);
                }
                else {
                    li_who.setVisibility(View.GONE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
















    public void SELECT_DATA_PROBLEM_TAIN() {

        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_product_name ,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_SELECT_DATA_PROBLEM_TAIN(response);

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




    public void SELECT_DATA_PROBLEM_TAIN_save_back(String AnswerName) {

        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_product_name_save_back+"?ProductName="+AnswerName ,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_SELECT_DATA_PROBLEM_TAIN(response);

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
    public void JSON_PARSE_DATA_AFTER_SELECT_DATA_PROBLEM_TAIN(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            final GetData_select_product_name GetDataAdapter2 = new GetData_select_product_name();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                GetDataAdapter2.setProduct(json.getString("ProductName"));
                //GetDataAdapter2.setTopicID(json.getString("TopicID"));
                //GetDataAdapter2.setData(json.getString("data"));




            } catch (JSONException e) {

                e.printStackTrace();
            }
            getData_select_product_names.add(GetDataAdapter2);
            // value=GetDataAdapter2.getProblemName();
        }
        String[] array2 = new String[        getData_select_product_names.size()];
        String[] array3 = new String[        getData_select_product_names.size()];
        int i;
        ArrayAdapter<String> adapter = null ;

        for ( i = 0; i <         getData_select_product_names.size(); i++) {
            final GetData_select_product_name contact =         getData_select_product_names.get(i);
            array2[i]= contact.getProduct();

            Log.e("SSSS",array2[i]);

            //array2=getData_select_topic_problem_gories.;
            try {
                adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, array2);
                //adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, android.R.id.text1, array2);
            }
            catch (Exception ex){

            }

        }



        spDemo5.setAdapter(adapter);

        spDemo5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item5 = parent.getItemAtPosition(position).toString();
                Log.e("spDemo5",item5);
                MyApplication.getInstance().getPrefManager().setPreferrence("item5", item5);
                if (item5.equals("ยี่ห้อ อื่นๆ")) {

                    li_install_tain.setVisibility(View.VISIBLE);
                }
                else {
                    li_install_tain.setVisibility(View.GONE);
                }

                final GetData_select_product_name contact = getData_select_product_names.get(position);
               // AnswerID_tain= contact.getAnswerID();
                //TopicID_tain= contact.getTopicID();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


























    public void SELECT_DATA_PROBLEM_TAIN2() {

        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL__date_to_date ,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_SELECT_DATA_PROBLEM_TAIN2(response);

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




    public void SELECT_DATA_PROBLEM_TAIN2_save_back(String AnswerName) {

        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL__date_to_date_save_back+"?AnswerName="+AnswerName ,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_SELECT_DATA_PROBLEM_TAIN2(response);

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
    public void JSON_PARSE_DATA_AFTER_SELECT_DATA_PROBLEM_TAIN2(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            final GetData_select_tain2 GetDataAdapter2 = new GetData_select_tain2();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                GetDataAdapter2.setAnswerID(json.getString("AnswerID"));
                GetDataAdapter2.setTopicID(json.getString("TopicID"));
                GetDataAdapter2.setData(json.getString("data"));




            } catch (JSONException e) {

                e.printStackTrace();
            }
            getData_select_tains2.add(GetDataAdapter2);
            // value=GetDataAdapter2.getProblemName();
        }
        String[] array2 = new String[        getData_select_tains2.size()];
        String[] array3 = new String[        getData_select_tains2.size()];
        int i;
        ArrayAdapter<String> adapter = null ;

        for ( i = 0; i <         getData_select_tains2.size(); i++) {
            final GetData_select_tain2 contact =         getData_select_tains2.get(i);
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



        spDemo6.setAdapter(adapter);

        spDemo6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item6 = parent.getItemAtPosition(position).toString();
                Log.e("spDemo6",item6);
                MyApplication.getInstance().getPrefManager().setPreferrence("item6", item6);
                final GetData_select_tain2 contact = getData_select_tains2.get(position);
                AnswerID_tain2= contact.getAnswerID();
                TopicID_tain2= contact.getTopicID();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
























    public void SELECT_DATA_CONFIRM() {

        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_gory_5+"?CONTNO="+conno ,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_SELECT_DATA_CONFIRM(response);

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
    public void JSON_PARSE_DATA_AFTER_SELECT_DATA_CONFIRM(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            final Get_data_confirm GetDataAdapter2 = new Get_data_confirm();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                GetDataAdapter2.setPaymentPeriodNumber(json.getString("PaymentPeriodNumber"));
                GetDataAdapter2.setPaymentAmount(json.getString("PaymentAmount"));
                GetDataAdapter2.setDiscount(json.getString("Discount"));
                GetDataAdapter2.setNetAmount(json.getString("NetAmount"));
                GetDataAdapter2.setPaymentComplete(json.getString("PaymentComplete"));



            } catch (JSONException e) {

                e.printStackTrace();
            }
            get_data_confirms.add(GetDataAdapter2);
            // value=GetDataAdapter2.getProblemName();
        }



        recyclerViewAdapter_confirm = new RecyclerViewAdapter_confirm(get_data_confirms, this);

        my_recycler_view2_2.setAdapter(recyclerViewAdapter_confirm);
       // recyclerViewAdapter_confirm.setitemclick2(this);
        int dd=get_data_confirms.size()-1;

        txt_concon.setText("ราคาเงินผ่อน "+dd+" งวด");

    }






    public void SELECT_DATA_CONFIRM2() {

        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_gory_6+"?CONTNO="+conno ,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_SELECT_DATA_CONFIRM2(response);

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

    String TotalPrice="",Balance="";
    public void JSON_PARSE_DATA_AFTER_SELECT_DATA_CONFIRM2(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {


            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                TotalPrice=json.getString("TotalPrice");
                Balance=json.getString("Balance");




            } catch (JSONException e) {

                e.printStackTrace();
            }

            txt_Outstanding.setText(TotalPrice+" บาท");
            txt_balance.setText(Balance+" บาท");
           ;
        }



        recyclerViewAdapter_confirm = new RecyclerViewAdapter_confirm(get_data_confirms, this);

        my_recycler_view2_2.setAdapter(recyclerViewAdapter_confirm);
        // recyclerViewAdapter_confirm.setitemclick2(this);



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
               // insert_CheckerCard_Images_install(order_image2,Url2,Image_Name2,Image_Type2,Image_Size2);
                //insert_CheckerCard_Images_confrim(order_image2,Url2,Image_Name2,Image_Type2,Image_Size2);
            }
            if(!url_image3.equals("null")){
                insert_CheckerCard_Images_confrim(order_image3,Url3,Image_Name3,Image_Type3,Image_Size3);
            }
            if(!url_image4.equals("null")){



                insert_CheckerCard_Images_home_in(order_image4,Url4,Image_Name4,Image_Type4,Image_Size4);
            }
            if(!url_image5.equals("null")){

                insert_CheckerCard_Images_install(order_image5,Url5,Image_Name5,Image_Type5,Image_Size5);
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


/*
    String GET_JSON_insert_CheckerCard_Master="http://app.thiensurat.co.th/assanee/checker_system/Master/insert_CheckerCard_Master_home_in.php";
    String GET_JSON_insert_CheckerCard_Dedails="http://app.thiensurat.co.th/assanee/checker_system/Details/insert_CheckerCard_Details.php";
    String GET_JSON_insert_CheckerCard_Dedails_GPS="http://app.thiensurat.co.th/assanee/checker_system/Details/insert_CheckerCard_Details_GPS.php";
    String GET_JSON_insert_CheckerCard_Images="http://app.thiensurat.co.th/assanee/checker_system/Images/insert_CheckerCard_Image.php";
*/

    private void insert_CheckerCard_Master(){

        String Contno=conno;


try {
String S_ProcessTypeID=MyApplication.getInstance().getPrefManager().getPreferrence("ProcessTypeID");

        if(!S_ProcessTypeID.equals("null")){
            ProcessTypeID=S_ProcessTypeID;

            if((ProcessTypeID.equals("03"))|(ProcessTypeID.equals("04"))){
                problem1=1;
            }
            else {
                problem1=0;
            }
        }
}
catch (Exception ex){

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

        String PayNextDate="";
        String CHECK_PROBLEM_NEW="";




        try {
            String ddd=   MyApplication.getInstance().getPrefManager().getPreferrence("check_cb_pay_two")+"";
            if(ddd.equals("1")){
                PayNextDate="NULL";
                CHECK_PROBLEM_NEW="99";

                problem1=1;
            }
            else {
                PayNextDate=PayNextDate22;
                CHECK_PROBLEM_NEW=CHECK_PROBLEM;
                problem1=0;
            }

        }
        catch (Exception ex){
            PayNextDate=PayNextDate22;
            CHECK_PROBLEM_NEW=CHECK_PROBLEM;
            problem1=0;
        }


        try {
            Log.e("CheckerCard_Master", API_URL_ALL.GET_JSON_insert_CheckerCard_Master+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&CheckerEmpID="+InformEmpID+"&CustomerChecked="+URLEncoder.encode(customer, "UTF-8")+"&ProcessTypeID="+ProcessTypeID+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&PayNextDate="+URLEncoder.encode(PayNextDate, "UTF-8")+"&CHECK_PROBLEM="+CHECK_PROBLEM_NEW+"&ScoreColorID="+select_color_S+"&NoID="+NoID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

//MyApplication.getInstance().getPrefManager().getPreferrence("InformID")

        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insert_CheckerCard_Master+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&CheckerEmpID="+InformEmpID+"&CustomerChecked="+URLEncoder.encode(customer, "UTF-8")+"&ProcessTypeID="+ProcessTypeID+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&PayNextDate="+URLEncoder.encode(PayNextDate, "UTF-8")+"&CHECK_PROBLEM="+CHECK_PROBLEM_NEW+"&ScoreColorID="+select_color_S+"&NoID="+NoID,


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


  private void  update_CheckerCard_Master(){




      String EmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

      Log.e("urlll",API_URL_ALL.GET_JSON_check_and_update_CheckerCard_Master+"?Contno="+conno+"&EmpID="+EmpID);



          jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_check_and_update_CheckerCard_Master+"?Contno="+conno_intro+"&EmpID="+EmpID,


                  new Response.Listener<JSONArray>() {
                      @Override
                      public void onResponse(JSONArray response) {
                          update_CheckerCard_Master();
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



    private void insert_CheckerCard_Details_select4(){

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


        String TopicID="37";
        String AnswerID="-";

        String new_message_home_in_S=new_message_select4.getText().toString();
        String AnswerNote="";
        if(new_message_home_in_S.isEmpty()){
            AnswerNote="-";
        }
        else {
            AnswerNote=new_message_select4.getText().toString();
        }





        try {
            Log.e("URL_Details_Images",API_URL_ALL.GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID,


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
            Log.e("URL_Details_Images",API_URL_ALL.GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID,


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

        String lat=MyApplication.getInstance().getPrefManager().getPreferrence("lat")+"";
        String lon=MyApplication.getInstance().getPrefManager().getPreferrence("lon")+"";

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
        String AnswerNote="";

        if(item1.equals("ปักหมุดไม่ได้/ไม่มีสัญญาณ")){
            AnswerNote="ปักหมุดไม่ได้/ไม่มีสัญญาณ";
        }
        else {
            AnswerNote="ปักหมุดต่ำแหน่ง gps";
        }

        try {
            Log.e("URL_GPS",API_URL_ALL.GET_JSON_insert_CheckerCard_Dedails_GPS+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID+"&Latitude="+lat+"&Longtitude="+lon);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {
           jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insert_CheckerCard_Dedails_GPS+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID+"&Latitude="+lat+"&Longtitude="+lon,
                  //  jsonArrayRequest = new JsonArrayRequest(GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID,

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
        String AnswerNote="";
        try {
            if (ProductSerial.equals(conno_scan)) {
                 AnswerID="19";
                AnswerNote="หมายเลขเครื่องตรงกัน"+ProductSerial +" : "+conno_scan;
                problem2=0;
            } else {
                 AnswerID="20";
                AnswerNote="หมายเลขเครื่องไม่ตรงกัน "+ProductSerial +" : "+conno_scan;
                problem2=1;
            }
        }
        catch (Exception erx){

        }
String new_message_scan_S=new_message_scan.getText().toString();


      //  if(new_message_scan_S.isEmpty()){

        //}
       // else {
           // AnswerNote=new_message_scan.getText().toString();
      //  }



        try {
            Log.e("URL_Details_Images",API_URL_ALL.GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID,


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
            problem3=0;
        }
        else {
            AnswerID="10";
            problem3=1;
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
            Log.e("URL_Details_Images",API_URL_ALL.GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID,


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

    private void select_CheckerCard_AgainPending(){
        String Contno=conno;

            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_select_CheckerCard_AgainPending+"?Contno="+Contno,


                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {

                            JSON_PARSE_DATA_AFTER_WEBCALL3(response);

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

    String ITEM_PAD="";
  int item_padd=0;
    public void JSON_PARSE_DATA_AFTER_WEBCALL3(JSONArray array){
        if(array.length()==0){
            //ITEM_PAD="1";
            item_padd=1;
        }
        else {

            for (int i = 0; i < array.length(); i++) {

                Get_data_type_check GetDataAdapter2 = new Get_data_type_check();
                // GetDataAdapter1.clear();

                JSONObject json = null;
                try {

                    json = array.getJSONObject(i);
                    //     Log.e(TAG,"หมู json array"+json.getJSONObject("InstallDate").getString("date"));


                    ITEM_PAD=json.getString("Items");
                    item_padd= Integer.parseInt(ITEM_PAD)+1;


                } catch (JSONException e) {

                    e.printStackTrace();
                }


            }

        }


    }
    private void insert_CheckerCard_AgainPending(){

        String Contno=conno;
        String Refno="1111";
        String Items= String.valueOf(item_padd);


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






        String new_message_install_S=new_message_select4.getText().toString();
        String CheckerNote="";

        if(new_message_install_S.isEmpty()){
            CheckerNote="-";
        }
        else {
            CheckerNote=new_message_select4.getText().toString();
        }


        try {
            Log.e("cccc_url",API_URL_ALL.GET_JSON_insert_CheckerCard_AgainPending+"?Contno="+Contno+"&Refno="+Refno+"&Items="+Items+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&CheckerNote="+URLEncoder.encode(CheckerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insert_CheckerCard_AgainPending+"?Contno="+Contno+"&Refno="+Refno+"&Items="+Items+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&CheckerNote="+URLEncoder.encode(CheckerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID,


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
            Log.e("URL_Details_Images",API_URL_ALL.GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID,


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
            Log.e("URL_Details_Images",API_URL_ALL.GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID,


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

            problem4=0;
        }
        else {
            AnswerID="16";
            problem4=1;
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
            Log.e("URL_Details_Images",API_URL_ALL.GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID,


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






        String TopicID="";
        String AnswerID="";

        if(ProcessTypeID.equals("01")){
             TopicID="9";

            if((int) dayCount>60){
                AnswerID="30";
                problem6=1;
            }
            else {
                AnswerID="21";
                problem6=0;
            }
        }
      else  if(ProcessTypeID.equals("02")){
            TopicID="19";
            if((int) dayCount>60){
                AnswerID="47";
                problem6=1;
            }
            else {
                AnswerID="46";
                problem6=0;
            }
        }

















        //String AnswerNote="นัดเก็บเงินงวด 2 ";

        String new_message_install_S=new_message_pay2.getText().toString();
        String AnswerNote="";




        if(new_message_install_S.isEmpty()){

            AnswerNote=String.valueOf((int) dayCount)+" วัน";

        }
        else {
            AnswerNote=String.valueOf((int) dayCount)+" วัน";
          //  AnswerNote=new_message_pay2.getText().toString();
        }


        try {
            Log.e("URL_Details_Images",API_URL_ALL.GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID,


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
        if(checkedText_confirm.equals("ถูกต้อง")){
            AnswerID="22";
            problem7=0;
        }
        else {
            AnswerID="23";
            problem7=1;
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
            Log.e("URL_Details_Images",API_URL_ALL.GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID,


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






    private void insert_CheckerCard_Details_tain(){

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


        String TopicID="30";
        String AnswerID="";




      //  String new_message_install_S=new_message_tain.getText().toString();

        String AnswerNote="";
        if (radioSex_retain_S.equals("มี")) {

            if (item5.equals("ยี่ห้อ อื่นๆ")) {

                AnswerNote=new_message_tain.getText().toString();
            }
            else {
                AnswerNote=item5;
            }



            AnswerID="28";
            problem5=1;
        } else {

            AnswerNote="-";
            AnswerID="29";
            problem5=0;
        }









        try {
            Log.e("URL_Details_Images",API_URL_ALL.GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID,


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








    private void insert_CheckerCard_Details_date_to_date(){

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


        String TopicID=TopicID_tain2;
        String AnswerID=AnswerID_tain2;




        //String new_message_install_S=new_message_tain.getText().toString();
        String AnswerNote="-";

     /*   if(new_message_install_S.isEmpty()){
            AnswerNote="-";
        }
        else {
            AnswerNote=new_message_tain.getText().toString();
        }*/

        try {
            Log.e("URL_Details_Images",API_URL_ALL.GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID,


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








    private void insert_remarket(){

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


        String TopicID="";
        String AnswerID="";



        if(ProcessTypeID.equals("01")){
            TopicID="28";
            if(radioSex_re_S.equals("เคย")){
                AnswerID="24";
            }
            else {
                AnswerID="25";
            }
        }
        else if(ProcessTypeID.equals("02")) {
            TopicID="29";
            if(radioSex_re_S.equals("เคย")){
                AnswerID="26";
            }
            else {
                AnswerID="27";
            }
        }






        String new_message_install_S=new_message2.getText().toString();
        String AnswerNote="";

        if(new_message_install_S.isEmpty()){
            AnswerNote="-";
        }
        else {
            AnswerNote="-";
        }

        try {
            Log.e("URL_Details_Images",API_URL_ALL.GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID,


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










    private void insert_CheckerCard_Details_conveniently(){

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


        String TopicID="";
        String AnswerNote="-";
        String AnswerID="";






        try {
            String S_ProcessTypeID=MyApplication.getInstance().getPrefManager().getPreferrence("ProcessTypeID");

            if(!S_ProcessTypeID.equals("null")){
                ProcessTypeID=S_ProcessTypeID;






                if(ProcessTypeID.equals("01")){
                    TopicID="38";
                }
                else{
                    TopicID="39";
                }






                if(ProcessTypeID.equals("01")){
                    if(checkedText_confirm.equals("ใช่สะดวก")){
                        AnswerID="42";
                    }
                    else {
                        AnswerID="43";
                    }
                }
                else{
                    if(checkedText_confirm.equals("ถูกต้อง")){
                        AnswerID="44";
                    }
                    else {
                        AnswerID="45";
                    }
                }


            }
        }
        catch (Exception ex){

        }










        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insert_CheckerCard_Dedails+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&AnswerID="+AnswerID+"&AnswerNote="+URLEncoder.encode(AnswerNote, "UTF-8")+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID+"&NoID="+NoID,


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
            Log.e("URL_Details_Images",API_URL_ALL.GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID+"&NoID="+NoID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }



        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID+"&NoID="+NoID,


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
            Log.e("URL_Details_Images",API_URL_ALL.GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID+"&NoID="+NoID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }



        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID+"&NoID="+NoID,


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
            Log.e("URL_Details_Images",API_URL_ALL.GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID+"&NoID="+NoID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }



        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID+"&NoID="+NoID,


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
            Log.e("Images_install",API_URL_ALL.GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID+"&NoID="+NoID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }



        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID+"&NoID="+NoID,


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
   private void insert_CheckerCard_Images_install_yes_no(String Items1,String URL1,String ImageName1,String ImageType1,String ImageSize1){



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
            Log.e("Images_install",API_URL_ALL.GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }



        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID,


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
            Log.e("URL_Details_Images",API_URL_ALL.GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID+"&NoID="+NoID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }



        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID+"&NoID="+NoID,


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
            Log.e("URL_Details_Images",API_URL_ALL.GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID+"&NoID="+NoID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }



        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insert_CheckerCard_Images+"?Contno="+Contno+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&TopicID="+TopicID+"&Items="+Items+"&URL="+URL+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageType="+ImageType+"&ImageSize="+ImageSize+"&user_code="+InformEmpID+"&NoID="+NoID,


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

    String InformID_REAL="";
    public void select_check_sucess_all(){
         InformID_REAL= MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");



        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_select_check_sucess_all_checker+"?InformID="+InformID_REAL+"&Contno="+conno,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSON_PARSE_DATA_AFTER_select_id_from_Problem_Inform_select_check_sucess_all(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        select_check_sucess_all();
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

        if (array.length()==0) {


            SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE);
            sweetAlertDialog.setTitleText("ผิดพลาด!");
            sweetAlertDialog.setContentText("*อัพโหลดข้อมูลไม่สำเร็จ กรุณาลองอีกครั้ง*");
            sweetAlertDialog.setCancelable(false);


            sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sDialog) {

                    sweetAlertDialog.dismiss();

                    delate_data();

                    save_data();


                }
            });
            sweetAlertDialog.show();


        } else {


        for (int i = 0; i < array.length(); i++) {

            //final GetData_select_topic_problem_sub GetDataAdapter2 = new GetData_select_topic_problem_sub();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                // GetDataAdapter2.setProblemID(json.getString("InformID"));
                InformID_M = json.getString("InformID_M");
                InformID_D = json.getString("InformID_D");
                InformID_I = json.getString("InformID_I");
            } catch (JSONException e) {

                e.printStackTrace();
            }
        }


        check_save_checker = 1;


        InformID_REAL = MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        Log.e("InformID_ALL_FULL", InformID_M + "," + InformID_D + "," + InformID_I + "," + InformID_REAL);
        if ((InformID_M.equals(InformID_REAL)) & (InformID_D.equals(InformID_REAL))) {


            SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE);
            sweetAlertDialog.setTitleText("เสร็จสิ้น!");
            sweetAlertDialog.setContentText("*การตรวจสอบ*");
            sweetAlertDialog.setCancelable(false);
            sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sDialog) {


                    MyApplication.getInstance().getPrefManager().setPreferrence("ProcessTypeID", "00");
                    MyApplication.getInstance().getPrefManager().setPreferrence("item", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("item1", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("item2", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("item3", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("item5", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("item6", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("radioSex_retain_S", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("radioSex_re_S", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_one", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_install", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_confirm", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_two", "null");

                    MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_two_nad", "null");

                    MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_two_nad_install", "null");


                    MyApplication.getInstance().getPrefManager().setPreferrence("new_message_home_in", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("new_message_scan", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("new_message_install", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("new_message_tain", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("new_message1", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("new_message", "null");

                    MyApplication.getInstance().getPrefManager().setPreferrence("image_pen_sing", "null");

                    MyApplication.getInstance().getPrefManager().setPreferrence("GET_date2", "-");


                    MyApplication.getInstance().getPrefManager().setPreferrence("size_map", "null");

                    MyApplication.getInstance().getPrefManager().setPreferrence("scan_barcode", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("status_qr", "null");


                    SQLiteDataBaseBuild1();
                    SQLiteTableBuild1_2();
                    sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker1.TABLE_NAME + "");

                    SQLiteDataBaseBuild2();
                    SQLiteTableBuild2_2();
                    sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker2.TABLE_NAME + "");

                    SQLiteDataBaseBuild3();
                    SQLiteTableBuild3_2();
                    sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker3.TABLE_NAME + "");

                    SQLiteDataBaseBuild4();
                    SQLiteTableBuild4_2();
                    sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker4.TABLE_NAME + "");

                    SQLiteDataBaseBuild5();
                    SQLiteTableBuild5_2();
                    sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker5.TABLE_NAME + "");

                    SQLiteDataBaseBuild_map();
                    SQLiteTableBuild_map_2();
                    sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker5.TABLE_NAME + "");


                    SQLiteDataBaseBuild_pensing();
                    SQLiteTableBuild_pensing();
                    sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_image_buffer_checker_pensing.TABLE_NAME + "");

                    SQLiteDataBaseBuild_data_checker_problem_for_report();
                    SQLiteTableBuild_data_checker_problem_for_report();
                    sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + "");


                    SQLiteDataBaseBuild_data_type();
                    SQLiteTableBuild_data_type();
                    sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_data_type.TABLE_NAME + "");


                    try {
                        File root = new File(MyApplication.getInstance().getPrefManager().getPreferrence("part_image"));

                        File[] Files = root.listFiles();
                        if (Files != null) {
                            int j;
                            for (j = 0; j < Files.length; j++) {
                                System.out.println(Files[j].getAbsolutePath());
                                System.out.println(Files[j].delete());
                            }
                        }


                        File dir = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES) + "/report_problem/IDALL/image_error");
                        if (dir.isDirectory()) {
                            String[] children = dir.list();
                            for (int i = 0; i < children.length; i++) {
                                new File(dir, children[i]).delete();
                            }
                        }

                        File dir2 = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES) + "/" + conno_intro + "/report_problem/IDALL/image_map");
                        if (dir2.isDirectory()) {
                            String[] children = dir2.list();
                            for (int i = 0; i < children.length; i++) {
                                new File(dir2, children[i]).delete();
                            }
                        }

                        File dir3 = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES) + "/" + conno_intro + "/report_problem/IDALL/image_pen_sing");
                        if (dir3.isDirectory()) {
                            String[] children = dir3.list();
                            for (int i = 0; i < children.length; i++) {
                                new File(dir3, children[i]).delete();
                            }
                        }


                        File dir4 = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES) + "/" + conno_intro + "/report_problem/IDALL/image_map");
                        if (dir4.isDirectory()) {
                            String[] children = dir4.list();
                            for (int i = 0; i < children.length; i++) {
                                new File(dir4, children[i]).delete();
                            }
                        }

                    } catch (Exception ex) {

                    }


                    try {


                        insert_gps_gis = new INSERT_GPS_GIS(Detali_check1.this);
                        insert_gps_gis.gg();


                    } catch (Exception ex) {
                        //  Log.e("check_error",ex.getLocalizedMessage()+"");
                    }


                    sweetAlertDialog.dismiss();


                    try {


                        insert_gps_gis = new INSERT_GPS_GIS(Detali_check1.this);
                        insert_gps_gis.gg();


                    } catch (Exception ex) {
                        //  Log.e("check_error",ex.getLocalizedMessage()+"");
                    }

                    // ftsgrs
                    //    fsdgfs


                    try {
                        File dire = new File(Environment.getExternalStorageDirectory(), "/Android/data/" + BuildConfig.APPLICATION_ID + "/files/Pictures");
                        Log.e("dire", String.valueOf(dire));
                        new Detali_check1.DirectoryCleaner(dire).clean();
                        dire.delete();

                    } catch (Exception ex) {

                    }

                    Intent = new Intent(Detali_check1.this, MusicActivity_Checker.class);
                    startActivity(Intent);
                    finish();


                }
            });

            sweetAlertDialog.show();
        }
        else {
            SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE);
            sweetAlertDialog.setTitleText("ผิดพลาด!");
            sweetAlertDialog.setContentText("*อัพโหลดข้อมูลไม่สำเร็จ กรุณาลองอีกครั้ง*");
            sweetAlertDialog.setCancelable(false);


            sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sDialog) {

                    sweetAlertDialog.dismiss();

                    delate_data();

                    save_data();


                }
            });
            sweetAlertDialog.show();
        }
       /* else {








            pDialogg.dismiss();
            pDialogg.cancel();
            //  Log.d(TAG, "Error " + t.getMessage());
            //finalThread.stop();


            SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE);
            sweetAlertDialog.setTitleText("ผิดพลาด!");
            sweetAlertDialog.setContentText("*อัพโหลดข้อมูลไม่สำเร็จ กรุณาลองอีกครั้ง*");
            sweetAlertDialog.setCancelable(false);

*//*            SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE);
            sweetAlertDialog.setTitleText("ผิดพลาด!");
            sweetAlertDialog.setContentText("*อัพโหลดข้อมูลไม่สำเร็จ กรุณาลองอีกครั้ง*");
            sweetAlertDialog.setCancelable(false);*//*
            sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sDialog) {

                    sweetAlertDialog.dismiss();



                    try {


                        insert_gps_gis= new INSERT_GPS_GIS(Detali_check1.this);
                        insert_gps_gis.gg();


                    }
                    catch (Exception ex){
                        //  Log.e("check_error",ex.getLocalizedMessage()+"");
                    }

                   // ftsgrs
                        //    fsdgfs




                    try {
                        File dire= new File(Environment.getExternalStorageDirectory(), "/Android/data/"+BuildConfig.APPLICATION_ID+"/files/Pictures");
                        Log.e("dire", String.valueOf(dire));
                        new Detali_check1.DirectoryCleaner(dire).clean();
                        dire.delete();

                    }
                    catch (Exception ex){

                    }

      Intent = new Intent(Detali_check1.this, MusicActivity_Checker.class);
                                startActivity(Intent);
                                finish();







                 int problem_all = problem1+problem2+problem3+problem4+problem5+problem6+problem7;

                    if(problem_all>0){

                        MyApplication.getInstance().getPrefManager().setPreferrence("contno_by_checker",conno_intro);

                        Intent = new Intent(Detali_check1.this, MusicActivity_Credit.class);


                        startActivity(Intent);
                        finish();

                    }
                    else {


                        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(Detali_check1.this, SweetAlertDialog.SUCCESS_TYPE);
                        sweetAlertDialog.setTitleText("คุณต้องการแจ้งปัญหา!");
                        sweetAlertDialog.setContentText("*การตรวจสอบหรือไม่*");
                        sweetAlertDialog.setConfirmText("แจ้งปัญหา!");
                        sweetAlertDialog.setCancelText("ไม่แจ้งปัญหา");
                        sweetAlertDialog.setCancelable(false);
                        sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {


                                Intent = new Intent(Detali_check1.this, MusicActivity_Credit.class);
                                startActivity(Intent);
                                finish();

                            }
                        });
                        sweetAlertDialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.cancel();
                                sweetAlertDialog.dismiss();
                                Intent = new Intent(Detali_check1.this, MusicActivity_Checker.class);
                                startActivity(Intent);
                                finish();
                            }
                        });

                        sweetAlertDialog.show();


                    }



                }
            });
            sweetAlertDialog .show();








        }*/

    }



    }

    private void delate_data(){

        InformID_REAL= MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");



   //     String salecode = MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");
        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_delate_data_checker+"?Contno="+conno+"&Empid="+InformID_REAL+"&NoID="+NoID,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                      //  JSON_PARSE_DATA_AFTER_WEBCALL(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);
//        swipeRefreshLayout.setRefreshing(false);
    }





    public void JSON_DATA_WEB_CALL(){
        String salecode = MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");
        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_checker+"?salecode="+salecode,

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
//        swipeRefreshLayout.setRefreshing(false);
    }




    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array){

        Log.e("LEGGGGGGGGGG",array.length()+"");

        SQLiteDataBaseBuild_data_type();
        SQLiteTableBuild_data_type();
        get_data_type_checks.clear();
        for(int i = 0; i<array.length(); i++) {

            Get_data_type_check GetDataAdapter2 = new Get_data_type_check();
            // GetDataAdapter1.clear();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);
                //     Log.e(TAG,"หมู json array"+json.getJSONObject("InstallDate").getString("date"));


                GetDataAdapter2.setProcessTypeID(json.getString("ProcessTypeID"));
                GetDataAdapter2.setData(json.getString("ProcessTypeName"));
                GetDataAdapter2.setProcessclick(json.getString("Processclick"));


        String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_data_type.TABLE_NAME + " (part_id,ProcessTypeName,Processclick) VALUES('" + json.getString("ProcessTypeID") + "','" + json.getString("ProcessTypeName") + "','" + json.getString("Processclick") /*String.valueOf(String.format("%.2f", dist))*/ + "');";
                sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);



            } catch (JSONException e) {

                e.printStackTrace();
            }
            get_data_type_checks.add(GetDataAdapter2);

        }




    get_data_type_checks.clear();
        cursor = sqLiteDatabase.rawQuery("SELECT  distinct part_id,ProcessTypeName,Processclick  FROM " + SQLiteHelper_data_type.TABLE_NAME ,null);

        if (cursor.moveToFirst()) {
            do {
                Get_data_type_check    getDataTypeCheck= new Get_data_type_check();

                String Table_part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_part_id));
                String Table_ProcessTypeName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_ProcessTypeName));
                String Table_Processclick = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_Processclick));

                getDataTypeCheck.setProcessTypeID(Table_part_id);
                getDataTypeCheck.setData(Table_ProcessTypeName);
                getDataTypeCheck.setProcessclick(Table_Processclick);
                Log.e("Table_Processclick",Table_Processclick);
                get_data_type_checks.add(getDataTypeCheck);
                //recyclerViewadapter.notifyDataSetChanged();
            } while (cursor.moveToNext());
        }
        cursor.close();





        recyclerViewadapter = new RecyclerViewAdapter_type_check(get_data_type_checks, this);

        recyclerview1.setAdapter(recyclerViewadapter);
        recyclerViewadapter.setitemclick2(this);

    }
    boolean checker_chik=false;
    int item_click;
    @Override
    public void click2(View v, int position) {
        //get_data_type_checks.clear();
        //JSON_DATA_WEB_CALL();
        //RecyclerViewAdapter_type_check.imageView4.setBackgroundResource(R.drawable.check_box_report_problem_no);
//        ImageView  imageView4= (ImageView) v.findViewById(R.id.imageView4) ;
//
//        imageView4.setBackgroundResource(R.drawable.check_box_report_problem_no);

   /*     Get_data_type_check get_data_type_check = get_data_type_checks.get(position);
        if (get_data_type_check.getProcessclick().equals("false")) {
            get_data_type_check.setProcessclick("true");
        } else  {
            get_data_type_check.setProcessclick("false");
        }




        get_data_type_checks.set(position, get_data_type_check);
        Log.e("get_data_type_checks", get_data_type_check.getProcessclick());
       recyclerViewadapter.notifyDataSetChanged();*/

        item_click=position;

        SQLiteDataBaseBuild_data_type();
        SQLiteTableBuild_data_type();

        if(position==0) {
            ProcessTypeID="01";
            MyApplication.getInstance().getPrefManager().setPreferrence("ProcessTypeID",ProcessTypeID);

            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='true' WHERE part_id =" + "'" + "01" + "'");
            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "02" + "'");
            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "03" + "'");
            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "04" + "'");
            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "05" + "'");
            get_data_type_checks.clear();
            cursor = sqLiteDatabase.rawQuery("SELECT  distinct part_id,ProcessTypeName,Processclick  FROM " + SQLiteHelper_data_type.TABLE_NAME ,null);

            if (cursor.moveToFirst()) {
                do {
                    Get_data_type_check    getDataTypeCheck= new Get_data_type_check();
                    String Table_part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_part_id));
                    String Table_ProcessTypeName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_ProcessTypeName));
                    String Table_Processclick = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_Processclick));

                    getDataTypeCheck.setProcessTypeID(Table_part_id);
                    getDataTypeCheck.setData(Table_ProcessTypeName);
                    getDataTypeCheck.setProcessclick(Table_Processclick);
                    Log.e("Table_Processclick",Table_Processclick);
                    get_data_type_checks.add(getDataTypeCheck);
                    //recyclerViewadapter.notifyDataSetChanged();
                } while (cursor.moveToNext());
            }
            cursor.close();

            recyclerViewadapter = new RecyclerViewAdapter_type_check(get_data_type_checks, this);

            recyclerview1.setAdapter(recyclerViewadapter);
            recyclerViewadapter.setitemclick2(this);









            li_pay2.setVisibility(View.VISIBLE);
            li_pay2_2.setVisibility(View.GONE);
            li_install2.setVisibility(View.VISIBLE);
            li_install3.setVisibility(View.VISIBLE);
            li4.setVisibility(View.VISIBLE);
            li7.setVisibility(View.VISIBLE);
            txt_scan_assa.setVisibility(View.VISIBLE);
            li_install1.setVisibility(View.VISIBLE);
            linearlayout_show_problem_sub.setVisibility(View.VISIBLE);
            li_pay_one.setVisibility(View.VISIBLE);
            li_pay_two.setVisibility(View.VISIBLE);
            li_pay_two2.setVisibility(View.VISIBLE);
            li_pay2.setVisibility(View.VISIBLE);
            li_confirm.setVisibility(View.VISIBLE);
            li_confirm2.setVisibility(View.VISIBLE);
            linear_pen.setVisibility(View.VISIBLE);
            li_line1.setVisibility(View.VISIBLE);
            li_line2.setVisibility(View.VISIBLE);
            li_line3.setVisibility(View.VISIBLE);
            li_line4.setVisibility(View.VISIBLE);
            li_line5.setVisibility(View.VISIBLE);
            li_line6.setVisibility(View.VISIBLE);
            li_save.setVisibility(View.VISIBLE);
            li_line1234.setVisibility(View.VISIBLE);

            li_line7.setVisibility(View.GONE);
            li_line8.setVisibility(View.GONE);
            li_line9.setVisibility(View.GONE);
            li_remarket.setVisibility(View.VISIBLE);

            linearlayout_show_problem_tain.setVisibility(View.VISIBLE);



          //  li_install_re_tain.setVisibility(View.VISIBLE);
            linearlayout_date_to_date.setVisibility(View.VISIBLE);


            li_pay2_2_2.setVisibility(View.VISIBLE);
            li_line10.setVisibility(View.VISIBLE);
            li_line11.setVisibility(View.VISIBLE);
            li_line12.setVisibility(View.VISIBLE);
            li_pay2_2_3.setVisibility(View.VISIBLE);

            li3.setVisibility(View.VISIBLE);
            my_recycler_view5.setVisibility(View.VISIBLE);
            my_recycler_view1.setVisibility(View.VISIBLE);


            if(error==0){
                li_qr1.setVisibility(View.VISIBLE);
            }


            try {
                String S_image_pen_sing=   MyApplication.getInstance().getPrefManager().getPreferrence("image_pen_sing")+"";
                String S_signaturePath=   MyApplication.getInstance().getPrefManager().getPreferrence("signaturePath")+"";
                if(!S_image_pen_sing.equals("null")){

                    image_pen_sing.setVisibility(View.VISIBLE);
                    image_pen_sing.setImageURI(Uri.parse("file://"+S_signaturePath));
                    status_pen=1;
                }

            }
            catch (Exception ex){

            }

            lili_1.setVisibility(View.VISIBLE);
            lili_2.setVisibility(View.VISIBLE);
            lili_3.setVisibility(View.VISIBLE);
            lili_line1.setVisibility(View.VISIBLE);
            lili_line2.setVisibility(View.VISIBLE);
            li1.setVisibility(View.VISIBLE);
            li2.setVisibility(View.VISIBLE);
            lili_text_select4.setVisibility(View.GONE);


            li_line13.setVisibility(View.VISIBLE);
            li_conveniently.setVisibility(View.VISIBLE);

        }

       else if(position==1) {
            ProcessTypeID="02";
            MyApplication.getInstance().getPrefManager().setPreferrence("ProcessTypeID",ProcessTypeID);

            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "01" + "'");
            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='true' WHERE part_id =" + "'" + "02" + "'");
            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "03" + "'");
            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "04" + "'");
            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "05" + "'");
            get_data_type_checks.clear();
            cursor = sqLiteDatabase.rawQuery("SELECT distinct part_id,ProcessTypeName,Processclick  FROM " + SQLiteHelper_data_type.TABLE_NAME, null);

            if (cursor.moveToFirst()) {
                do {

                    Get_data_type_check    getDataTypeCheck= new Get_data_type_check();
                    String Table_part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_part_id));
                    String Table_ProcessTypeName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_ProcessTypeName));
                    String Table_Processclick = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_Processclick));

                    getDataTypeCheck.setProcessTypeID(Table_part_id);
                    getDataTypeCheck.setData(Table_ProcessTypeName);
                    getDataTypeCheck.setProcessclick(Table_Processclick);
                    Log.e("Table_Processclick",Table_Processclick);
                    get_data_type_checks.add(getDataTypeCheck);
                } while (cursor.moveToNext());
            }
            cursor.close();


            recyclerViewadapter = new RecyclerViewAdapter_type_check(get_data_type_checks, this);

           recyclerview1.setAdapter(recyclerViewadapter);
            recyclerViewadapter.setitemclick2(this);








            li_pay2.setVisibility(View.VISIBLE);
            li_pay2_2.setVisibility(View.GONE);
            li_install2.setVisibility(View.GONE);
            li_install3.setVisibility(View.GONE);
            li4.setVisibility(View.GONE);
            li7.setVisibility(View.GONE);
            txt_scan_assa.setVisibility(View.GONE);
            li_install1.setVisibility(View.GONE);
            linearlayout_show_problem_sub.setVisibility(View.VISIBLE);
            li_pay_one.setVisibility(View.VISIBLE);
            li_pay_two.setVisibility(View.VISIBLE);
            li_pay_two2.setVisibility(View.VISIBLE);
            li_pay2.setVisibility(View.VISIBLE);
            li_confirm.setVisibility(View.VISIBLE);
            li_confirm2.setVisibility(View.VISIBLE);
            linear_pen.setVisibility(View.VISIBLE);
            li_line0.setVisibility(View.GONE);
            li_line1.setVisibility(View.VISIBLE);
            li_line2.setVisibility(View.GONE);
            li_line3.setVisibility(View.VISIBLE);
            li_line4.setVisibility(View.VISIBLE);
            li_line5.setVisibility(View.VISIBLE);
            li_line6.setVisibility(View.VISIBLE);
            li_save.setVisibility(View.VISIBLE);
            li_line1234.setVisibility(View.VISIBLE);

            li_line7.setVisibility(View.GONE);
            li_line8.setVisibility(View.GONE);
            li_line9.setVisibility(View.GONE);
            li_remarket.setVisibility(View.VISIBLE);

            linearlayout_show_problem_tain.setVisibility(View.VISIBLE);


           // li_install_re_tain.setVisibility(View.VISIBLE);
            linearlayout_date_to_date.setVisibility(View.VISIBLE);

            li_pay2_2_2.setVisibility(View.VISIBLE);
            li_line10.setVisibility(View.VISIBLE);
            li_line11.setVisibility(View.VISIBLE);
            li_line12.setVisibility(View.VISIBLE);
            li_pay2_2_3.setVisibility(View.VISIBLE);

            li3.setVisibility(View.GONE);
            my_recycler_view5.setVisibility(View.GONE);
            my_recycler_view1.setVisibility(View.GONE);

            li_qr1.setVisibility(View.GONE);


            try {
                String S_image_pen_sing=   MyApplication.getInstance().getPrefManager().getPreferrence("image_pen_sing")+"";
                String S_signaturePath=   MyApplication.getInstance().getPrefManager().getPreferrence("signaturePath")+"";
                if(!S_image_pen_sing.equals("null")){

                    image_pen_sing.setVisibility(View.VISIBLE);
                    image_pen_sing.setImageURI(Uri.parse("file://"+S_signaturePath));
                    status_pen=1;
                }

            }
            catch (Exception ex){

            }

            lili_1.setVisibility(View.VISIBLE);
            lili_2.setVisibility(View.VISIBLE);
            lili_3.setVisibility(View.VISIBLE);
            lili_line1.setVisibility(View.VISIBLE);
            lili_line2.setVisibility(View.VISIBLE);
            li1.setVisibility(View.VISIBLE);
            li2.setVisibility(View.VISIBLE);
            lili_text_select4.setVisibility(View.GONE);

            li_line13.setVisibility(View.VISIBLE);
            li_conveniently.setVisibility(View.VISIBLE);

        }

       else if(position==2) {
            ProcessTypeID="03";
            MyApplication.getInstance().getPrefManager().setPreferrence("ProcessTypeID",ProcessTypeID);

            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "01" + "'");
            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "02" + "'");
            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='true' WHERE part_id =" + "'" + "03" + "'");
            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "04" + "'");
            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "05" + "'");
            get_data_type_checks.clear();
            cursor = sqLiteDatabase.rawQuery("SELECT distinct part_id,ProcessTypeName,Processclick  FROM " + SQLiteHelper_data_type.TABLE_NAME, null);

            if (cursor.moveToFirst()) {
                do {

                    Get_data_type_check    getDataTypeCheck= new Get_data_type_check();
                    String Table_part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_part_id));
                    String Table_ProcessTypeName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_ProcessTypeName));
                    String Table_Processclick = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_Processclick));

                    getDataTypeCheck.setProcessTypeID(Table_part_id);
                    getDataTypeCheck.setData(Table_ProcessTypeName);
                    getDataTypeCheck.setProcessclick(Table_Processclick);
                    Log.e("Table_Processclick",Table_Processclick);
                    get_data_type_checks.add(getDataTypeCheck);
                } while (cursor.moveToNext());
            }
            cursor.close();


           recyclerViewadapter = new RecyclerViewAdapter_type_check(get_data_type_checks, this);

            recyclerview1.setAdapter(recyclerViewadapter);

            recyclerViewadapter.setitemclick2(this);






            li_pay2.setVisibility(View.GONE);
            li_pay2_2.setVisibility(View.GONE);
            li_install2.setVisibility(View.GONE);
            li_install3.setVisibility(View.GONE);
            li4.setVisibility(View.GONE);
            li7.setVisibility(View.GONE);
            txt_scan_assa.setVisibility(View.GONE);
            li_install1.setVisibility(View.GONE);
            linearlayout_show_problem_sub.setVisibility(View.GONE);
            li_pay_one.setVisibility(View.GONE);
            li_pay_two.setVisibility(View.GONE);
            li_pay_two2.setVisibility(View.GONE);
            li_pay2.setVisibility(View.GONE);
            li_confirm.setVisibility(View.GONE);
            li_confirm2.setVisibility(View.GONE);
            linear_pen.setVisibility(View.GONE);

            li_line0.setVisibility(View.GONE);
            li_line1.setVisibility(View.GONE);
            li_line2.setVisibility(View.GONE);
            li_line3.setVisibility(View.GONE);
            li_line4.setVisibility(View.GONE);
            li_line5.setVisibility(View.GONE);
            li_line6.setVisibility(View.VISIBLE);
            li_save.setVisibility(View.VISIBLE);
            li_line1234.setVisibility(View.GONE);

            li_line7.setVisibility(View.GONE);
            li_line8.setVisibility(View.GONE);
            li_line9.setVisibility(View.GONE);
            li_remarket.setVisibility(View.GONE);
            linearlayout_show_problem_tain.setVisibility(View.GONE);
            li_install_tain.setVisibility(View.GONE);
            li_install_re_tain.setVisibility(View.GONE);
            linearlayout_date_to_date.setVisibility(View.GONE);

            li_pay2_2_2.setVisibility(View.GONE);
            li_line10.setVisibility(View.GONE);
            li_line11.setVisibility(View.GONE);
            li_line12.setVisibility(View.GONE);
            li_pay2_2_3.setVisibility(View.GONE);

            li3.setVisibility(View.GONE);
            my_recycler_view5.setVisibility(View.GONE);
            my_recycler_view1.setVisibility(View.GONE);

            image_pen_sing.setVisibility(View.GONE);
            li_qr1.setVisibility(View.GONE);





            lili_1.setVisibility(View.VISIBLE);
            lili_2.setVisibility(View.VISIBLE);
            lili_3.setVisibility(View.VISIBLE);
            lili_line1.setVisibility(View.VISIBLE);
            lili_line2.setVisibility(View.VISIBLE);
            li1.setVisibility(View.VISIBLE);
            li2.setVisibility(View.VISIBLE);
            lili_text_select4.setVisibility(View.GONE);

            li_line13.setVisibility(View.GONE);
            li_conveniently.setVisibility(View.GONE);
        }



        else if(position==3) {
            ProcessTypeID="04";
            MyApplication.getInstance().getPrefManager().setPreferrence("ProcessTypeID",ProcessTypeID);

            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "01" + "'");
            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "02" + "'");
            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "03" + "'");
            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='true' WHERE part_id =" + "'" + "04" + "'");
            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "05" + "'");
            get_data_type_checks.clear();
            cursor = sqLiteDatabase.rawQuery("SELECT distinct part_id,ProcessTypeName,Processclick  FROM " + SQLiteHelper_data_type.TABLE_NAME, null);

            if (cursor.moveToFirst()) {
                do {

                    Get_data_type_check    getDataTypeCheck= new Get_data_type_check();
                    String Table_part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_part_id));
                    String Table_ProcessTypeName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_ProcessTypeName));
                    String Table_Processclick = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_Processclick));

                    getDataTypeCheck.setProcessTypeID(Table_part_id);
                    getDataTypeCheck.setData(Table_ProcessTypeName);
                    getDataTypeCheck.setProcessclick(Table_Processclick);
                    Log.e("Table_Processclick",Table_Processclick);
                    get_data_type_checks.add(getDataTypeCheck);
                } while (cursor.moveToNext());
            }
            cursor.close();


            recyclerViewadapter = new RecyclerViewAdapter_type_check(get_data_type_checks, this);

            recyclerview1.setAdapter(recyclerViewadapter);

            recyclerViewadapter.setitemclick2(this);






            li_pay2.setVisibility(View.GONE);
            li_pay2_2.setVisibility(View.GONE);
            li_install2.setVisibility(View.GONE);
            li_install3.setVisibility(View.GONE);
            li4.setVisibility(View.GONE);
            li7.setVisibility(View.GONE);
            txt_scan_assa.setVisibility(View.GONE);
            li_install1.setVisibility(View.GONE);
            linearlayout_show_problem_sub.setVisibility(View.GONE);
            li_pay_one.setVisibility(View.GONE);
            li_pay_two.setVisibility(View.GONE);
            li_pay_two2.setVisibility(View.GONE);
            li_pay2.setVisibility(View.GONE);
            li_confirm.setVisibility(View.GONE);
            li_confirm2.setVisibility(View.GONE);
            linear_pen.setVisibility(View.GONE);

            li_line0.setVisibility(View.GONE);
            li_line1.setVisibility(View.GONE);
            li_line2.setVisibility(View.GONE);
            li_line3.setVisibility(View.GONE);
            li_line4.setVisibility(View.GONE);
            li_line5.setVisibility(View.GONE);
            li_line6.setVisibility(View.VISIBLE);
            li_save.setVisibility(View.VISIBLE);
            li_line1234.setVisibility(View.GONE);

            li_line7.setVisibility(View.GONE);
            li_line8.setVisibility(View.GONE);
            li_line9.setVisibility(View.GONE);
            li_remarket.setVisibility(View.GONE);
            linearlayout_show_problem_tain.setVisibility(View.GONE);
            li_install_tain.setVisibility(View.GONE);
            li_install_re_tain.setVisibility(View.GONE);
            linearlayout_date_to_date.setVisibility(View.GONE);

            li_pay2_2_2.setVisibility(View.GONE);
            li_line10.setVisibility(View.GONE);
            li_line11.setVisibility(View.GONE);
            li_line12.setVisibility(View.GONE);
            li_pay2_2_3.setVisibility(View.GONE);

            li3.setVisibility(View.GONE);
            my_recycler_view5.setVisibility(View.GONE);
            my_recycler_view1.setVisibility(View.GONE);

            image_pen_sing.setVisibility(View.GONE);
            li_qr1.setVisibility(View.GONE);







            lili_1.setVisibility(View.GONE);
            lili_2.setVisibility(View.GONE);
            lili_3.setVisibility(View.GONE);
            lili_line1.setVisibility(View.GONE);
            lili_line2.setVisibility(View.GONE);
            li1.setVisibility(View.GONE);
            li2.setVisibility(View.GONE);
            lili_text_select4.setVisibility(View.VISIBLE);


            li_line13.setVisibility(View.GONE);
            li_conveniently.setVisibility(View.GONE);



        }

        else if(position==4) {
            ProcessTypeID="05";
            MyApplication.getInstance().getPrefManager().setPreferrence("ProcessTypeID",ProcessTypeID);

            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "01" + "'");
            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "02" + "'");
            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "03" + "'");
            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='false' WHERE part_id =" + "'" + "04" + "'");
            sqLiteDatabase.execSQL("UPDATE   " + SQLiteHelper_data_type.TABLE_NAME + "" + " SET Processclick='true' WHERE part_id =" + "'" + "05" + "'");
            get_data_type_checks.clear();
            cursor = sqLiteDatabase.rawQuery("SELECT distinct part_id,ProcessTypeName,Processclick  FROM " + SQLiteHelper_data_type.TABLE_NAME, null);

            if (cursor.moveToFirst()) {
                do {

                    Get_data_type_check    getDataTypeCheck= new Get_data_type_check();
                    String Table_part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_part_id));
                    String Table_ProcessTypeName = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_ProcessTypeName));
                    String Table_Processclick = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_type.Table_Processclick));

                    getDataTypeCheck.setProcessTypeID(Table_part_id);
                    getDataTypeCheck.setData(Table_ProcessTypeName);
                    getDataTypeCheck.setProcessclick(Table_Processclick);
                    Log.e("Table_Processclick",Table_Processclick);
                    get_data_type_checks.add(getDataTypeCheck);
                } while (cursor.moveToNext());
            }
            cursor.close();


            recyclerViewadapter = new RecyclerViewAdapter_type_check(get_data_type_checks, this);

            recyclerview1.setAdapter(recyclerViewadapter);

            recyclerViewadapter.setitemclick2(this);






            li_pay2.setVisibility(View.GONE);
            li_pay2_2.setVisibility(View.GONE);
            li_install2.setVisibility(View.GONE);
            li_install3.setVisibility(View.GONE);
            li4.setVisibility(View.GONE);
            li7.setVisibility(View.GONE);
            txt_scan_assa.setVisibility(View.GONE);
            li_install1.setVisibility(View.GONE);
            linearlayout_show_problem_sub.setVisibility(View.GONE);
            li_pay_one.setVisibility(View.GONE);
            li_pay_two.setVisibility(View.GONE);
            li_pay_two2.setVisibility(View.GONE);
            li_pay2.setVisibility(View.GONE);
            li_confirm.setVisibility(View.GONE);
            li_confirm2.setVisibility(View.GONE);
            linear_pen.setVisibility(View.GONE);

            li_line0.setVisibility(View.GONE);
            li_line1.setVisibility(View.GONE);
            li_line2.setVisibility(View.GONE);
            li_line3.setVisibility(View.GONE);
            li_line4.setVisibility(View.GONE);
            li_line5.setVisibility(View.GONE);
            li_line6.setVisibility(View.VISIBLE);
            li_save.setVisibility(View.VISIBLE);
            li_line1234.setVisibility(View.GONE);

            li_line7.setVisibility(View.GONE);
            li_line8.setVisibility(View.GONE);
            li_line9.setVisibility(View.GONE);
            li_remarket.setVisibility(View.GONE);
            linearlayout_show_problem_tain.setVisibility(View.GONE);
            li_install_tain.setVisibility(View.GONE);
            li_install_re_tain.setVisibility(View.GONE);
            linearlayout_date_to_date.setVisibility(View.GONE);

            li_pay2_2_2.setVisibility(View.GONE);
            li_line10.setVisibility(View.GONE);
            li_line11.setVisibility(View.GONE);
            li_line12.setVisibility(View.GONE);
            li_pay2_2_3.setVisibility(View.GONE);

            li3.setVisibility(View.GONE);
            my_recycler_view5.setVisibility(View.GONE);
            my_recycler_view1.setVisibility(View.GONE);

            image_pen_sing.setVisibility(View.GONE);
            li_qr1.setVisibility(View.GONE);







            lili_1.setVisibility(View.GONE);
            lili_2.setVisibility(View.GONE);
            lili_3.setVisibility(View.GONE);
            lili_line1.setVisibility(View.GONE);
            lili_line2.setVisibility(View.GONE);
            li1.setVisibility(View.GONE);
            li2.setVisibility(View.GONE);
            lili_text_select4.setVisibility(View.VISIBLE);


            li_line13.setVisibility(View.GONE);
            li_conveniently.setVisibility(View.GONE);



        }
    }




    String Table_CONTNO,Table_GORY,Table_MAIN,Table_SUB,Table_DETAILS,Table_ProcessTypeID,Table_ProblemID="";
    StringBuilder sb = new StringBuilder();
    @Override
    public void onBackPressed() {






        //super.onBackPressed();


try {
    String ProcessTypeID= MyApplication.getInstance().getPrefManager().getPreferrence("ProcessTypeID");


    Log.e("5555","5555");

    if((size1>0)|(size2>0)|(size3>0)|(size4>0)|(size5>0)|(size_map>0)|ProcessTypeID.equals("01")|ProcessTypeID.equals("02")|ProcessTypeID.equals("03")|ProcessTypeID.equals("04")|ProcessTypeID.equals("05")){
        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("ต้องการออกจากหน้านี้หรือไม่ ?")
                .setContentText("ข้อมูลอาจไม่ได้ถูกบันทึก!")
                .setCancelText("ยกเลิก")
                .setConfirmText("ตกลง")
                .setNeutralText("ฉบับร่าง")
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

                        MyApplication.getInstance().getPrefManager().setPreferrence("ProcessTypeID", "00");
                        MyApplication.getInstance().getPrefManager().setPreferrence("item", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("item1", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("item2", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("item3", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("item5", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("item6", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("radioSex_retain_S", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("radioSex_re_S", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_one", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_install", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_radioSex_con_ONBACK", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_confirm", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_two", "null");

                        MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_two_nad", "null");

                        MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_two_nad_install", "null");


                        MyApplication.getInstance().getPrefManager().setPreferrence("new_message_home_in", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("new_message_scan", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("new_message_install", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("new_message_tain", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("new_message1", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("new_message", "null");

                        MyApplication.getInstance().getPrefManager().setPreferrence("image_pen_sing", "null");

                        MyApplication.getInstance().getPrefManager().setPreferrence("GET_date2", "-");


                        MyApplication.getInstance().getPrefManager().setPreferrence("size_map", "null");

                        MyApplication.getInstance().getPrefManager().setPreferrence("scan_barcode","null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("status_qr","null");

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

                        SQLiteDataBaseBuild_data_checker_problem_for_report();
                        SQLiteTableBuild_data_checker_problem_for_report();
                        sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_data_checker_problem_for_report.TABLE_NAME+"");


                        SQLiteDataBaseBuild_data_type();
                        SQLiteTableBuild_data_type();
                        sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_data_type.TABLE_NAME+"");










                        try {
                            File root = new File(MyApplication.getInstance().getPrefManager().getPreferrence("part_image"));

                            File[] Files = root.listFiles();
                            if(Files != null) {
                                int j;
                                for(j = 0; j < Files.length; j++) {
                                    System.out.println(Files[j].getAbsolutePath());
                                    System.out.println(Files[j].delete());
                                }
                            }





                            File dir = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES)+ "/report_problem/IDALL/image_error");
                            if (dir.isDirectory())
                            {
                                String[] children = dir.list();
                                for (int i = 0; i < children.length; i++)
                                {
                                    new File(dir, children[i]).delete();
                                }
                            }

                            File dir2 = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES)+ "/"+conno_intro+"/report_problem/IDALL/image_map");
                            if (dir2.isDirectory())
                            {
                                String[] children = dir2.list();
                                for (int i = 0; i < children.length; i++)
                                {
                                    new File(dir2, children[i]).delete();
                                }
                            }

                            File dir3 = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES)+ "/"+conno_intro+"/report_problem/IDALL/image_pen_sing");
                            if (dir3.isDirectory())
                            {
                                String[] children = dir3.list();
                                for (int i = 0; i < children.length; i++)
                                {
                                    new File(dir3, children[i]).delete();
                                }
                            }




                            File dir4 = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES)+ "/"+conno_intro+"/report_problem/IDALL/image_map");
                            if (dir4.isDirectory())
                            {
                                String[] children = dir4.list();
                                for (int i = 0; i < children.length; i++)
                                {
                                    new File(dir4, children[i]).delete();
                                }
                            }

                        }
                        catch (Exception ex){

                        }












                        sDialog.cancel();
                        SQLiteDataBaseBuild_data_checker_problem_for_report();
                        SQLiteTableBuild_data_checker_problem_for_report();
                        // sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + "" + " WHERE MAIN =" + "'" + "ระยะเวลาการผ่อน" + "'");
                        sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_data_checker_problem_for_report.TABLE_NAME+"");
                        finish();
                    }
                })



                .setNeutralClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {

                        sDialog.cancel();
                        finish();

                        MyApplication.getInstance().getPrefManager().setPreferrence("ProcessTypeID",ProcessTypeID);
                        MyApplication.getInstance().getPrefManager().setPreferrence("item", item);
                        MyApplication.getInstance().getPrefManager().setPreferrence("item1", item1);
                        MyApplication.getInstance().getPrefManager().setPreferrence("item2", item2);
                        MyApplication.getInstance().getPrefManager().setPreferrence("item3", item3);
                        MyApplication.getInstance().getPrefManager().setPreferrence("item5", item5);
                        MyApplication.getInstance().getPrefManager().setPreferrence("item6", item6);
                        MyApplication.getInstance().getPrefManager().setPreferrence("radioSex_retain_S", radioSex_retain_S);
                        MyApplication.getInstance().getPrefManager().setPreferrence("radioSex_re_S", radioSex_re_S);
                        MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_one", checkedText_pay_one);
                        MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_install", checkedText_install);
                        MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_confirm", checkedText_confirm);
                        MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_radioSex_con_ONBACK", checkedText_radioSex_con);

                        MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_two_nad", String.valueOf((int) dayCount));
                        MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_two_nad_install", PayNextDate22);


                        MyApplication.getInstance().getPrefManager().setPreferrence("new_message_home_in", new_message_home_in.getText().toString());
                        MyApplication.getInstance().getPrefManager().setPreferrence("new_message_scan", new_message_scan.getText().toString());
                        MyApplication.getInstance().getPrefManager().setPreferrence("new_message_install", new_message_install.getText().toString());
                        MyApplication.getInstance().getPrefManager().setPreferrence("new_message_tain", new_message_tain.getText().toString());
                        MyApplication.getInstance().getPrefManager().setPreferrence("new_message1", new_message1.getText().toString());
                        MyApplication.getInstance().getPrefManager().setPreferrence("new_message",new_message.getText().toString());

                        MyApplication.getInstance().getPrefManager().setPreferrence("GET_date2", "1");
                        MyApplication.getInstance().getPrefManager().setPreferrence("size_map", String.valueOf(size_map));
                    }
                })



                .show();

    }
    else {
        if(check_save_checker==0){


            String item_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("item")+"";
            String item1_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("item1")+"";
            String item3_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("item3")+"";

            String S_new_message_home_in=   new_message_home_in.getText().toString();

            if((!item_ONBACK.equals("คอนโดมิเนียม")&!item_ONBACK.equals("null"))|(!item1_ONBACK.equals("ปักหมุด")&!item1_ONBACK.equals("null"))|(!item3_ONBACK.equals("ผู้ซื้อ")&!item3_ONBACK.equals("null"))|(!S_new_message_home_in.isEmpty())){

                Log.e("4444","4444");



                new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("ต้องการออกจากหน้านี้หรือไม่ ?")
                        .setContentText("ข้อมูลอาจไม่ได้ถูกบันทึก!")
                        .setCancelText("ยกเลิก")
                        .setConfirmText("ตกลง")
                        .setNeutralText("ฉบับร่าง")
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

                                MyApplication.getInstance().getPrefManager().setPreferrence("ProcessTypeID", "00");
                                MyApplication.getInstance().getPrefManager().setPreferrence("item", "null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("item1", "null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("item2", "null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("item3", "null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("item5", "null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("item6", "null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("radioSex_retain_S", "null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("radioSex_re_S", "null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_one", "null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_install", "null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_confirm", "null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_radioSex_con_ONBACK", "null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_two", "null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_two_nad", "null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_two_nad_install", "null");

                                MyApplication.getInstance().getPrefManager().setPreferrence("new_message_home_in", "null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("new_message_scan", "null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("new_message_install", "null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("new_message_tain", "null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("new_message1", "null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("new_message","null");

                                MyApplication.getInstance().getPrefManager().setPreferrence("image_pen_sing", "null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("GET_date2", "-");
                                MyApplication.getInstance().getPrefManager().setPreferrence("size_map", "null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("scan_barcode","null");
                                MyApplication.getInstance().getPrefManager().setPreferrence("status_qr","null");
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

                                SQLiteDataBaseBuild_data_checker_problem_for_report();
                                SQLiteTableBuild_data_checker_problem_for_report();
                                sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_data_checker_problem_for_report.TABLE_NAME+"");


                                SQLiteDataBaseBuild_data_type();
                                SQLiteTableBuild_data_type();
                                sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_data_type.TABLE_NAME+"");






                                try {
                                    File root = new File(MyApplication.getInstance().getPrefManager().getPreferrence("part_image"));

                                    File[] Files = root.listFiles();
                                    if(Files != null) {
                                        int j;
                                        for(j = 0; j < Files.length; j++) {
                                            System.out.println(Files[j].getAbsolutePath());
                                            System.out.println(Files[j].delete());
                                        }
                                    }



                                    File dir = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES)+ "/report_problem/IDALL/image_error");
                                    if (dir.isDirectory())
                                    {
                                        String[] children = dir.list();
                                        for (int i = 0; i < children.length; i++)
                                        {
                                            new File(dir, children[i]).delete();
                                        }
                                    }

                                    File dir2 = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES)+ "/"+conno_intro+"/report_problem/IDALL/image_map");
                                    if (dir2.isDirectory())
                                    {
                                        String[] children = dir2.list();
                                        for (int i = 0; i < children.length; i++)
                                        {
                                            new File(dir2, children[i]).delete();
                                        }
                                    }

                                    File dir3 = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES)+ "/"+conno_intro+"/report_problem/IDALL/image_pen_sing");
                                    if (dir3.isDirectory())
                                    {
                                        String[] children = dir3.list();
                                        for (int i = 0; i < children.length; i++)
                                        {
                                            new File(dir3, children[i]).delete();
                                        }
                                    }
                                }
                                catch (Exception ex){

                                }








                                sDialog.cancel();
                                SQLiteDataBaseBuild_data_checker_problem_for_report();
                                SQLiteTableBuild_data_checker_problem_for_report();
                                // sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + "" + " WHERE MAIN =" + "'" + "ระยะเวลาการผ่อน" + "'");
                                sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_data_checker_problem_for_report.TABLE_NAME+"");
                                finish();
                            }
                        })



                        .setNeutralClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {

                                sDialog.cancel();
                                finish();

                                MyApplication.getInstance().getPrefManager().setPreferrence("ProcessTypeID",ProcessTypeID);
                                MyApplication.getInstance().getPrefManager().setPreferrence("item", item);
                                MyApplication.getInstance().getPrefManager().setPreferrence("item1", item1);
                                MyApplication.getInstance().getPrefManager().setPreferrence("item2", item2);
                                MyApplication.getInstance().getPrefManager().setPreferrence("item3", item3);
                                MyApplication.getInstance().getPrefManager().setPreferrence("item5", item5);
                                MyApplication.getInstance().getPrefManager().setPreferrence("item6", item6);
                                MyApplication.getInstance().getPrefManager().setPreferrence("radioSex_retain_S", radioSex_retain_S);
                                MyApplication.getInstance().getPrefManager().setPreferrence("radioSex_re_S", radioSex_re_S);
                                MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_one", checkedText_pay_one);
                                MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_install", checkedText_install);
                                MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_confirm", checkedText_confirm);
                                MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_radioSex_con_ONBACK", checkedText_radioSex_con);

                                MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_two_nad", String.valueOf((int) dayCount));
                                MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_two_nad_install", PayNextDate22);

                                MyApplication.getInstance().getPrefManager().setPreferrence("new_message_home_in", new_message_home_in.getText().toString());
                                MyApplication.getInstance().getPrefManager().setPreferrence("new_message_scan", new_message_scan.getText().toString());
                                MyApplication.getInstance().getPrefManager().setPreferrence("new_message_install", new_message_install.getText().toString());
                                MyApplication.getInstance().getPrefManager().setPreferrence("new_message_tain", new_message_tain.getText().toString());
                                MyApplication.getInstance().getPrefManager().setPreferrence("new_message1", new_message1.getText().toString());
                                MyApplication.getInstance().getPrefManager().setPreferrence("new_message",new_message.getText().toString());
                                MyApplication.getInstance().getPrefManager().setPreferrence("GET_date2", "1");
                                MyApplication.getInstance().getPrefManager().setPreferrence("size_map", String.valueOf(size_map));

                            }
                        })



                        .show();

            }


            else {
                SQLiteDataBaseBuild_data_checker_problem_for_report();
                SQLiteTableBuild_data_checker_problem_for_report();
                // sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + "" + " WHERE MAIN =" + "'" + "ระยะเวลาการผ่อน" + "'");
                sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_data_checker_problem_for_report.TABLE_NAME+"");
                finish();
            }



        }
    }
}
catch (Exception ex){
    if(check_save_checker==0){

        Log.e("3333","3333");

        String item_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("item")+"";
        String item1_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("item1")+"";
        String item3_ONBACK= MyApplication.getInstance().getPrefManager().getPreferrence("item3")+"";
        String S_new_message_home_in=   new_message_home_in.getText().toString();
        if((!item_ONBACK.equals("คอนโดมิเนียม")&!item_ONBACK.equals("null"))|(!item1_ONBACK.equals("ปักหมุด")&!item1_ONBACK.equals("null"))|(!item3_ONBACK.equals("ผู้ซื้อ")&!item3_ONBACK.equals("null"))|(!S_new_message_home_in.isEmpty())){

            Log.e("4444","4444");



            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("ต้องการออกจากหน้านี้หรือไม่ ?")
                    .setContentText("ข้อมูลอาจไม่ได้ถูกบันทึก!")
                    .setCancelText("ยกเลิก")
                    .setConfirmText("ตกลง")
                    .setNeutralText("ฉบับร่าง")
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

                            MyApplication.getInstance().getPrefManager().setPreferrence("ProcessTypeID", "00");
                            MyApplication.getInstance().getPrefManager().setPreferrence("item", "null");
                            MyApplication.getInstance().getPrefManager().setPreferrence("item1", "null");
                            MyApplication.getInstance().getPrefManager().setPreferrence("item2", "null");
                            MyApplication.getInstance().getPrefManager().setPreferrence("item3", "null");
                            MyApplication.getInstance().getPrefManager().setPreferrence("item5", "null");
                            MyApplication.getInstance().getPrefManager().setPreferrence("item6", "null");
                            MyApplication.getInstance().getPrefManager().setPreferrence("radioSex_retain_S", "null");
                            MyApplication.getInstance().getPrefManager().setPreferrence("radioSex_re_S", "null");
                            MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_one", "null");
                            MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_install", "null");
                            MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_confirm", "null");
                            MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_radioSex_con_ONBACK", "null");
                            MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_two_nad", "null");
                            MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_two_nad_install", "null");


                            MyApplication.getInstance().getPrefManager().setPreferrence("new_message_home_in", "null");
                            MyApplication.getInstance().getPrefManager().setPreferrence("new_message_scan", "null");
                            MyApplication.getInstance().getPrefManager().setPreferrence("new_message_install", "null");
                            MyApplication.getInstance().getPrefManager().setPreferrence("new_message_tain", "null");
                            MyApplication.getInstance().getPrefManager().setPreferrence("new_message1", "null");
                            MyApplication.getInstance().getPrefManager().setPreferrence("new_message","null");
                            MyApplication.getInstance().getPrefManager().setPreferrence("image_pen_sing", "null");
                            MyApplication.getInstance().getPrefManager().setPreferrence("GET_date2", "-");
                            MyApplication.getInstance().getPrefManager().setPreferrence("size_map", "null");
                            MyApplication.getInstance().getPrefManager().setPreferrence("scan_barcode","null");
                            MyApplication.getInstance().getPrefManager().setPreferrence("status_qr","null");
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

                            SQLiteDataBaseBuild_data_checker_problem_for_report();
                            SQLiteTableBuild_data_checker_problem_for_report();
                            sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_data_checker_problem_for_report.TABLE_NAME+"");


                            SQLiteDataBaseBuild_data_type();
                            SQLiteTableBuild_data_type();
                            sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_data_type.TABLE_NAME+"");






                            try {
                                File root = new File(MyApplication.getInstance().getPrefManager().getPreferrence("part_image"));

                                File[] Files = root.listFiles();
                                if(Files != null) {
                                    int j;
                                    for(j = 0; j < Files.length; j++) {
                                        System.out.println(Files[j].getAbsolutePath());
                                        System.out.println(Files[j].delete());
                                    }
                                }



                                File dir = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES)+ "/report_problem/IDALL/image_error");
                                if (dir.isDirectory())
                                {
                                    String[] children = dir.list();
                                    for (int i = 0; i < children.length; i++)
                                    {
                                        new File(dir, children[i]).delete();
                                    }
                                }

                                File dir2 = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES)+ "/"+conno_intro+"/report_problem/IDALL/image_map");
                                if (dir2.isDirectory())
                                {
                                    String[] children = dir2.list();
                                    for (int i = 0; i < children.length; i++)
                                    {
                                        new File(dir2, children[i]).delete();
                                    }
                                }

                                File dir3 = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES)+ "/"+conno_intro+"/report_problem/IDALL/image_pen_sing");
                                if (dir3.isDirectory())
                                {
                                    String[] children = dir3.list();
                                    for (int i = 0; i < children.length; i++)
                                    {
                                        new File(dir3, children[i]).delete();
                                    }
                                }
                            }
                            catch (Exception ex){

                            }











                            sDialog.cancel();
                            SQLiteDataBaseBuild_data_checker_problem_for_report();
                            SQLiteTableBuild_data_checker_problem_for_report();
                            // sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + "" + " WHERE MAIN =" + "'" + "ระยะเวลาการผ่อน" + "'");
                            sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_data_checker_problem_for_report.TABLE_NAME+"");
                            finish();
                        }
                    })



                    .setNeutralClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {

                            sDialog.cancel();
                            finish();

                            MyApplication.getInstance().getPrefManager().setPreferrence("ProcessTypeID",ProcessTypeID);
                            MyApplication.getInstance().getPrefManager().setPreferrence("item", item);
                            MyApplication.getInstance().getPrefManager().setPreferrence("item1", item1);
                            MyApplication.getInstance().getPrefManager().setPreferrence("item2", item2);
                            MyApplication.getInstance().getPrefManager().setPreferrence("item3", item3);
                            MyApplication.getInstance().getPrefManager().setPreferrence("item5", item5);
                            MyApplication.getInstance().getPrefManager().setPreferrence("item6", item6);
                            MyApplication.getInstance().getPrefManager().setPreferrence("radioSex_retain_S", radioSex_retain_S);
                            MyApplication.getInstance().getPrefManager().setPreferrence("radioSex_re_S", radioSex_re_S);
                            MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_one", checkedText_pay_one);
                            MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_install", checkedText_install);
                            MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_confirm", checkedText_confirm);

                            MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_radioSex_con_ONBACK", checkedText_radioSex_con);

                            MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_two_nad", String.valueOf((int) dayCount));

                            MyApplication.getInstance().getPrefManager().setPreferrence("checkedText_pay_two_nad_install", PayNextDate22);

                            MyApplication.getInstance().getPrefManager().setPreferrence("new_message_home_in", new_message_home_in.getText().toString());
                            MyApplication.getInstance().getPrefManager().setPreferrence("new_message_scan", new_message_scan.getText().toString());
                            MyApplication.getInstance().getPrefManager().setPreferrence("new_message_install", new_message_install.getText().toString());
                            MyApplication.getInstance().getPrefManager().setPreferrence("new_message_tain", new_message_tain.getText().toString());
                            MyApplication.getInstance().getPrefManager().setPreferrence("new_message1", new_message1.getText().toString());
                            MyApplication.getInstance().getPrefManager().setPreferrence("new_message", new_message.getText().toString());
                            MyApplication.getInstance().getPrefManager().setPreferrence("GET_date2", "1");
                            MyApplication.getInstance().getPrefManager().setPreferrence("size_map", String.valueOf(size_map));

                        }
                    })



                    .show();

        }


        else {

            Log.e("1111","1111");



            SQLiteDataBaseBuild_data_checker_problem_for_report();
            SQLiteTableBuild_data_checker_problem_for_report();
            // sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME + "" + " WHERE MAIN =" + "'" + "ระยะเวลาการผ่อน" + "'");
            sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_data_checker_problem_for_report.TABLE_NAME+"");
            finish();
        }




    }
}
















    }


    private void view_sratus_problem(){
        SQLiteDataBaseBuild_data_checker_problem_for_report();
        SQLiteTableBuild_data_checker_problem_for_report();


        Log.e("ปัญหา","ไม่มี");
        CHECK_PROBLEM="00";
        cursor = sqLiteDatabase.rawQuery("SELECT distinct/*count(SUB)as dd,*/CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID  FROM " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {

               // GetData_check_problem2 getDataCheckProblem2 = new GetData_check_problem2();
                // count_probelem=cursor.dd;
                Table_CONTNO = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_problem_for_report.Table_CONTNO));
                Table_GORY = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_problem_for_report.Table_GORY));
                Table_MAIN = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_problem_for_report.Table_MAIN));
                Table_SUB = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_problem_for_report.Table_SUB));
                Table_DETAILS = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_problem_for_report.Table_DETAILS));
                Table_ProcessTypeID = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_problem_for_report.Table_ProcessTypeID));
                //Table_ProblemID = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_problem_for_report.Table_ProblemID));








                Log.e("ปัญหา","มี");



                Log.e("Table_SUB555",Table_CONTNO+"");
                try {
                    if(!Table_CONTNO.equals("null")){
                        CHECK_PROBLEM="99";
                        Log.e("ปัญหา","มี");
                    }
                }
                catch (Exception ex){

                }




            } while (cursor.moveToNext());
        }
        cursor.close();
    }















    public class ObjNonti{
        public String InformID,WorkCode,MessageHeader,MessageDetails,ipaddress,type,project,Contno;
    }
    private WebSocketClient webSocketClient;
    public void connectSocket(String details_problem_nonti_to_web){
        Log.e("","");
        URI uri;
        try {
            uri = new URI("ws://toss.thiensurat.co.th:3002");
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
                ob.InformID = InformID_REAL;
                ob.WorkCode = "00";
                ob.type = "checker";
                ob.project = "CHECKER";
                ob.Contno = conno;
                ob.ipaddress=MyApplication.getInstance().getPrefManager().getPreferrence("IPaddress");
                ob.MessageHeader =InformID_REAL+ "ตรวจสอบจาก : "+MyApplication.getInstance().getPrefManager().getPreferrence("EMPID")+" : "+MyApplication.getInstance().getPrefManager().getPreferrence("EmployeeName");
                ob.MessageDetails = details_problem_nonti_to_web;
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
        //details_problem_nonti_to_web="";
    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main4, menu);

        //MenuItem menuItem = menu.findItem(R.id.ss);
        // menuItem.setIcon(buildCounterDrawable(count, R.drawable.ic_notifications_none_white_24dp));

       // MenuItem itemCart = menu.findItem(R.id.action_cart);
//        LayerDrawable icon = (LayerDrawable) itemCart.getIcon();
      //  setBadgeCount(this, icon, String.valueOf("1"));
//


   /*     itemCart.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if (fragmentManager.findFragmentByTag(ContextMenuDialogFragment.TAG) == null) {
                    mMenuDialogFragment.show(fragmentManager, ContextMenuDialogFragment.TAG);
                }
                return false;
            }
        });*/




        return true;
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


    @Override
    public void onMenuItemLongClick(View clickedView, int position) {

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

        else {

        }

        return true;
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









        MenuObject block = new MenuObject("รายงานปัญหาระบบ");
        block.setResource(R.drawable.baseline_report_problem_black_24dp);


        MenuObject block2 = new MenuObject("รายงานปัญหาระบบอัตโนมัติ");
        block2.setResource(R.drawable.baseline_report_problem_black_24dp);







        menuObjects.add(close);


        // menuObjects.add(addFr);
        //   menuObjects.add(addFav);
        menuObjects.add(block);
        menuObjects.add(block2);






        return menuObjects;
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
        else if(id == R.id.action_setting){

                //mMenuDialogFragment.show(fragmentManager, ContextMenuDialogFragment.TAG);

        }


        return super.onOptionsItemSelected(item);
    }



}


