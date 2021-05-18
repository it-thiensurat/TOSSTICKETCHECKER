package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
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
import com.tsr.tsrproblemreport_tossticket_checker.INSERT_GPS_GIS;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.adapter.RecyclerViewAdapter_type_check_susscess;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.adapter.RecyclerViewAdapter_type_check_susscess2;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.adapter.RecyclerViewDataAdapter_dialog_image_problem_from_id_checker444;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.data_base.SQLiteHelper_data_checker_problem_for_report;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.GetData_cedit_dialog_image_problem_from_id_checker4;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.Get_data_type_check;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.ContactAdapter3;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.RecyclerViewAdapter_check_problem_new;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.RecyclerViewAdapter_check_problem_new2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.RecyclerViewDataAdapter5;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.RecyclerViewDataAdapter_dialog_image_problem_from_id;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.RecyclerViewDataAdapter_dialog_image_problem_from_id2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.databases.SQLiteHelper_image_buffer;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.databases.SQLiteHelper_image_buffer2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.databases.SQLiteHelper_problem_id_image;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.DATA_mp3;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_dialog_image_problem_from_id;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_image_buf2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_check_problem;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_check_problem2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_image_more_for_delate;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_image_new;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_sale_information;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_select_topic_problem_gory;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_select_topic_problem_gory2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_select_topic_problem_main;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_select_topic_problem_sub;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_select_topic_problem_sub_all;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_uploade_Image;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.SectionDataModel;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.SingleItemModel;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.SingleItemModel3;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.activity.MainActivity_qr_report_problem;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.utils.ImageConfiguration;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.utils.MarshMallowPermission;
import com.tsr.tsrproblemreport_tossticket_checker.jsonlogin.LOGIN_MAIN;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.CircleTransform;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.Utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.pedant.SweetAlert.SweetAlertDialog;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import pub.devrel.easypermissions.EasyPermissions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tech.gusavila92.websocketclient.WebSocketClient;

import static android.app.Activity.RESULT_OK;
import static com.tsr.tsrproblemreport_tossticket_checker.API_URL_ALL.BASE_URL;


//import com.tsr.tsrproblemreport.Manifest;
//import com.tsr.tsrproblemreport.cedit_all_problem_from_web.uploads_image.Service;

public class UI_CARDVIEW_CHECK_PROBLEM_NEW2_2 extends Fragment implements View.OnClickListener,RecyclerViewAdapter_check_problem_new.itemclick_deleteAll,RecyclerViewAdapter_check_problem_new.itemclick_image_problem_incorrect, AdapterView.OnItemClickListener,RecyclerViewDataAdapter5.itemclick_deleteAll3,RecyclerViewDataAdapter_dialog_image_problem_from_id2.itemclick_deleteAll2,ContactAdapter3.itemclick2,RecyclerViewAdapter_type_check_susscess2.itemclick_image_problem_incorrect22,ContactAdapter3.itemclick_linear_se{


    INSERT_GPS_GIS insert_gps_gis;


    public static UI_CARDVIEW_CHECK_PROBLEM_NEW2_2 getInstance(){
        return new UI_CARDVIEW_CHECK_PROBLEM_NEW2_2();
    }
    int count_checker_problem=0;

       String contno="";

    Spinner spDemo,spDemo2,spDemo3,spDemo4,spDemo_2;
    String[] value= {
            "ทดสอบ 1", "เมา 1", "Eclair", "Froyo", "Gingerbread",
            "Honeycomb", "ICS", "Jelly Bean", "KitKat", "Lollipop",
            "Marshmallow"};

    JsonArrayRequest jsonArrayRequest;
    JsonObjectRequest jsonObjectRequest;
    RequestQueue requestQueue;
    ArrayList<SectionDataModel> allSampleData;
    ArrayList<SingleItemModel> singleItem;
    ArrayList<SingleItemModel3> singleItem3;

    RecyclerView my_recycler_view,recyclerview1,recyclerview2;
    RecyclerViewAdapter_check_problem_new recyclerViewAdapter_check_problem_new;
    RecyclerViewAdapter_check_problem_new adapter2;

    RecyclerViewAdapter_check_problem_new2 recyclerViewAdapter_check_problem_new2;

    RelativeLayout r_save,open_camera,savee,open_image,relativeLayout_check_net,re_up_down;
    List<GetData_check_problem> getData_check_problems;
    GetData_check_problem getDataCheckProblem2;

    List<GetData_check_problem2> getData_check_problems2;

    List<GetData_select_topic_problem_gory> getData_select_topic_problem_gories;
    List<GetData_select_topic_problem_gory2> getData_select_topic_problem_gories2;
    List<GetData_select_topic_problem_main> getData_select_topic_problem_mains;
    List<GetData_select_topic_problem_sub> getData_select_topic_problem_subs;
    List<GetData_select_topic_problem_sub_all> getData_select_topic_problem_sub_alls;

    List<GetData_cedit_dialog_image_problem_from_id> getData_image_more_for_delates;
    List<GetData_image_more_for_delate> getDataImageMoreForDelates;

    GetData_image_more_for_delate getData_image_more_for_delate;
    GetData_cedit_dialog_image_problem_from_id data_cedit_dialog_image_problem_from_id;
    RecyclerViewDataAdapter_dialog_image_problem_from_id2 recyclerViewDataAdapter_dialog_image_problem_from_id2;

    List<GetData_cedit_image_buf2> getData_cedit_image_buf2s;
    GetData_cedit_image_buf2 dataCeditImageBuf2;
    RecyclerViewDataAdapter5 recyclerViewDataAdapter5;

    List<GetData_image_new> getData_image_news;
    GetData_image_new getDataImageNew;

    EditText new_message,inputText,edittext_se,new_message_topic_other;
    ScrollView sv;
    TextView count_problem,tesss;
    ImageButton switcher,switcher2,ib_se,delete_problem_name;
    Button btn_report;
    CheckBox checkBox;
   LinearLayout linear_sale1,linear_sale2,linear_sale3,
           linearlayout_show_problem_sub,
           linearlayout_show_problem_main,
           linear_status,linear_coler,
           linear_problem,linear_gory,linear_topic_other,
           lenear_custommer_other,linear_gory2,li_checker,li_checker2;

    TextView txt_namesale,txt_product_serial,txt_problem_form_checker,txt_position,txt_teamcode,txt_boss,txt_bossposition,txt_status,problem_name,new_message_db,txt_ProductName,txt_ProductPrice,txt_CustomerName,txt_Addressall,txt_Outstanding,txt_CustomerStatus,txt_AccountStatus,txt_PayLastPeriod;
    ImageView handle,image_status,test_image,arrow;
    String getRefNo="",getCONTNO="",getProduct_serial="",getProductName="",getProductPrice="",getCustomerName="",getAddressall="",getEmpID="",getEmployeeName="",getPositionCode="",getPositionName="",getTeamHeadCode="",
            getTeamHeadName="",getTeamName="",getSupervisorHeadCode="",getSupervisorHeadName="",
            getSupervisorName="",getSubDepartmentHeadCode="",getSubDepartmentHeadName="",
            getSubDepartmentName="",getDepartmentHeadCode="",getDepartmentHeadName="",
            getDepartmentName="",getSubTeamCode="",getTeamCode="",getPicture="",contno_save="",check_sale_contno="",
            getOutstanding="",getCustomerStatus="",getAccountStatus="",getPayLastPeriod="",getCashTeamCCode="",getCashTeamACode="";

    //

    /********** get data sale of problem ******/
    List<GetData_sale_information> GetDataAdapter2;

    String JSON_CONTNO="CONTNO";

    String JSON_ProductName="ProductName";
    String JSON_ProductPrice="ProductPrice";
    String JSON_CustomerName="CustomerName";
    String JSON_Addressall="Addressall";
    String JSON_TelHome="TelHome";
    String JSON_TelMobile="TelMobile";

    String JSON_EmpID="EmpID";
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
    String JSON_InformID="ProblemID";
    String JSON_Contno_nontification_problem="Contno_nontification_problem";
    String JSON_InformEmpID="InformEmpID";
    String JSON_InformDepartID="InformDepartID";

    String ProblemID_checker="";
    String Details_checker="";
    String Topic_checker="";
    String contno_checker="";
String ProcessTypeID_checker="";

    String DATE_credit_problem="";                                        // date_time_now
    String s1,s2,s3,s4,s5,s6;                                             // date_time_now
    int converted1,converted2,converted3,converted4,converted5,converted6;// date_time_now
    Date oneWayTripDate;                                                   // date_time_now
    int data_date,date_real=0;                                                         // date_time_now


    public  static boolean menuOpen = false;
    //public  static boolean menuOpen_C = false;
    int check=0;
    int error=0;
    public static int size=0;
    public static boolean status_run_work= false;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    //  select topic problem


    //

    //
    RecyclerViewDataAdapter_dialog_image_problem_from_id recyclerViewDataAdapter_dialog_image_problem_from_id;
    List<GetData_cedit_dialog_image_problem_from_id> getData_cedit_dialog_image_problem_from_ids;

    List<GetData_uploade_Image> getData_uploade_images;
    private Service uploadService;
    //private Service uploadService2;
    ProgressDialog progressDialog;
    SweetAlertDialog pDialogg,pDialogg2;
    String status_Shortcut="0";
   // private static final String SERVER_PATH = "http://app.thiensurat.co.th/assanee/";
    private static final String SERVER_PATH = "http://thiensurat.com/fileshare02/assanee/";


    String dateThai_year,dateThai_month;
    int converted_dateThai;

    private static final int CAM_REQUEST=1313;


    private static final int PERMISSION_CALLBACK_CONSTANT = 101;
    private static final int REQUEST_PERMISSION_SETTING = 102;
    private View view;
    private TextView txtPermissions,txt_checker222,txt_note,status_check_contno;
    private Button btnCheckPermissions;

    int check_nonti_web=0,gory_intro=0;
    String details_problem_nonti_to_web="",INFROMID="";

    private SharedPreferences permissionStatus;
    private boolean sentToSettings = false;
    String VersionOSM="",PositionCode_REAL="";
    String PATH;

    int check_sucess_insert_master=0;
    int check_sucess_insert_details=0;
    int check_sucess_insert_image=0;
    int check_buttom_remove_image=0;
    int size_image=0;
    boolean chilk_up_down=true;



    GetData_cedit getData_cedit;
    List<GetData_cedit> GetDataAdapter1;

    RecyclerViewAdapter_type_check_susscess recyclerViewadapter;
    List<Get_data_type_check> GetDataAdapter3;
    private ContactAdapter3 contactAdapter;
    List<GetData_cedit_dialog_image_problem_from_id_checker4> getData_image_more_for_delates_checker4;
    RecyclerViewDataAdapter_dialog_image_problem_from_id_checker444 recyclerViewDataAdapter_dialog_image_problem_from_id_checker4;




    public UI_CARDVIEW_CHECK_PROBLEM_NEW2_2() {
    }
    //
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
       // sent_nontification_to_web();

        VersionOSM = Build.VERSION.RELEASE;
        PositionCode_REAL=MyApplication.getInstance().getPrefManager().getPreferrence("SourceSystem");
        if(PositionCode_REAL.equals("Sale")){
            API_URL_ALL.GET_JSON_DATA_HTTP_URL_gory=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_gory_problem_sale.php";
        }
        else {
            API_URL_ALL.GET_JSON_DATA_HTTP_URL_gory=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_gory_problem.php";
        }
        PackageManager m = getActivity().getPackageManager();
        PATH = getActivity().getPackageName();
        try {
            PackageInfo p = m.getPackageInfo(PATH, 0);
            PATH = p.applicationInfo.dataDir;
            Log.e("app path", PATH);
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("yourtag", "Error Package name not found ", e);
        }


        //hitUrl("http://app.thiensurat.co.th/api/RealTimeDatabase/?EmpIDForm=A36023&EmpIDTo=A40767&WorkCode=00");

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yy-MM-dd");
        String currentDate = df.format(c.getTime());

        String arr2[] = currentDate.split("-");
        dateThai_year=arr2[0];
        dateThai_month=arr2[1];


        converted_dateThai=Integer.parseInt(dateThai_year);
        converted_dateThai=converted_dateThai+43;

            try {
                String   status_hide_ro_reveal = MyApplication.getInstance().getPrefManager().getPreferrence("status_hide_ro_reveal");
                if(status_hide_ro_reveal.equals("1")){
                    revealMenu();
                    lenear_custommer_other.setVisibility(View.VISIBLE);
                }
                else {
                    hideMenu();
                    lenear_custommer_other.setVisibility(View.GONE);
                }
            }
            catch (Exception ex){

            }

      SELECT_DATA_PROBLEM_SUB_ALL();
            SELECT_DATA_PROBLEM_GORY();

        //select_image();
      //  SELECT_DATA_PROBLEM_SQLITE_intro();





        my_recycler_view.setHasFixedSize(true);

        RecyclerViewDataAdapter5 adapter = new RecyclerViewDataAdapter5(getActivity(), allSampleData);

        my_recycler_view.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        // layoutManager = new GridLayoutManager(getActivity(), 2);
        // my_recycler_view.setLayoutManager(layoutManager);
        my_recycler_view.setAdapter(adapter);




        recyclerview1.setHasFixedSize(true);
        recyclerview1.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        recyclerview2.setHasFixedSize(true);
        recyclerview2.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));




        inputText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(inputText.getWindowToken(), 0);
                    //initListener();
                    contno=inputText.getText().toString();

                     pDialogg2 = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
                    pDialogg2.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                    pDialogg2.setTitleText("กำลังค้นหาเลขที่สัญญา...");
                    pDialogg2.setCancelable(true);
                    pDialogg2.show();

                   // getData_select_topic_problem_gories.clear();
                    //getData_select_topic_problem_mains.clear();
                    //getData_select_topic_problem_subs.clear();


                    if(gory_intro==1){

                        INSENT_DATA_SALE();
                        INSENT_DATA_CHECK_CONTNO();
                    }
                    else {

                    }

                    savee.setVisibility(View.VISIBLE);
                    return true;
                }
                return false;
            }
        });



        new_message.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(new_message.getWindowToken(), 0);
                    new_message.clearFocus();
                    savee.setVisibility(View.VISIBLE);
                    return true;
                }
                return false;
            }
        });
        edittext_se.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext_se.getWindowToken(), 0);
                    pDialogg2 = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
                    pDialogg2.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                    pDialogg2.setTitleText("กำลังค้นหาเลขที่สัญญา...");
                    pDialogg2.setCancelable(true);
                    pDialogg2.show();


                    lenear_custommer_other.setVisibility(View.GONE);
                    hideMenu();
                    hideMenu2();
                    linear_status.setVisibility(View.GONE);


                    status_Shortcut="1";
                    SELECT_PROBLEM_FROM_NUMBER();

                    return true;
                }
                return false;
            }
        });


        ib_se.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pDialogg2 = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
                pDialogg2.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                pDialogg2.setTitleText("กำลังค้นหาเลขที่สัญญา...");
                pDialogg2.setCancelable(true);
                pDialogg2.show();

                status_Shortcut="1";
                SELECT_PROBLEM_FROM_NUMBER();
            }
        });




/*
        sv.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                int scrollY = sv.getScrollY(); // For ScrollView
                int scrollX = sv.getScrollX(); // For HorizontalScrollView

                Log.e("scrollY", String.valueOf(scrollY));
                Log.e("scrollX", String.valueOf(scrollX));

                if(scrollY>0)
                {

                   // hideMenu();
                    //hideMenu2();
                   // linear_sale1.setVisibility(View.GONE);
                }
                else {
                    //revealMenu();
                    //revealMenu2();
                }
            }
        });
        */

        inputText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lenear_custommer_other.setVisibility(View.GONE);
                hideMenu();
                hideMenu2();
                linear_status.setVisibility(View.GONE);
            }

        });


        inputText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                savee.setVisibility(View.GONE);


                return false;
            }


        });

        edittext_se.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                savee.setVisibility(View.GONE);


                return false;
            }


        });
        new_message.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                savee.setVisibility(View.GONE);


                return false;
            }


        });

        new_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //new_message.getText().clear();
            }

        });



        String save="",cancal="";
        save = MyApplication.getInstance().getPrefManager().getPreferrence("save")+"";
        cancal = MyApplication.getInstance().getPrefManager().getPreferrence("cancal")+"";
                     if(size>0){
                            if(cancal.equals("0")) {

                            }
                            else {
                                //dialog_show_runing();
                            }
                    }
                    else {

                    }







        // **********************************************DATA USER*********************************************


        getCONTNO = MyApplication.getInstance().getPrefManager().getPreferrence("getCONTNO");
        getProduct_serial= MyApplication.getInstance().getPrefManager().getPreferrence("getProduct_serial");
        getProductName = MyApplication.getInstance().getPrefManager().getPreferrence("getProductName");
        getProductPrice = MyApplication.getInstance().getPrefManager().getPreferrence("getProductPrice");
        getCustomerName = MyApplication.getInstance().getPrefManager().getPreferrence("getCustomerName");
        getAddressall = MyApplication.getInstance().getPrefManager().getPreferrence("getAddressall");

        getEmpID = MyApplication.getInstance().getPrefManager().getPreferrence("getEmpID");
        getEmployeeName = MyApplication.getInstance().getPrefManager().getPreferrence("getEmployeeName");
        getPositionCode = MyApplication.getInstance().getPrefManager().getPreferrence("getPositionCode");
        getPositionName = MyApplication.getInstance().getPrefManager().getPreferrence("getPositionName");
        getTeamHeadCode = MyApplication.getInstance().getPrefManager().getPreferrence("getTeamHeadCode");
        getTeamHeadName = MyApplication.getInstance().getPrefManager().getPreferrence("getTeamHeadName");
        getTeamName = MyApplication.getInstance().getPrefManager().getPreferrence("getTeamName");
        getSupervisorHeadCode = MyApplication.getInstance().getPrefManager().getPreferrence("getSupervisorHeadCode");
        getSupervisorHeadName = MyApplication.getInstance().getPrefManager().getPreferrence("getSupervisorHeadName");
        getSupervisorName = MyApplication.getInstance().getPrefManager().getPreferrence("getSupervisorName");
        getSubDepartmentHeadCode = MyApplication.getInstance().getPrefManager().getPreferrence("getSubDepartmentHeadCode");
        getSubDepartmentHeadName = MyApplication.getInstance().getPrefManager().getPreferrence("getSubDepartmentHeadName");
        getSubDepartmentName = MyApplication.getInstance().getPrefManager().getPreferrence("getSubDepartmentName");
        getDepartmentHeadCode = MyApplication.getInstance().getPrefManager().getPreferrence("getDepartmentHeadCode");
        getDepartmentHeadName = MyApplication.getInstance().getPrefManager().getPreferrence("getDepartmentHeadName");
        getDepartmentName = MyApplication.getInstance().getPrefManager().getPreferrence("getDepartmentName");
        getSubTeamCode = MyApplication.getInstance().getPrefManager().getPreferrence("getSubTeamCode");
        getTeamCode = MyApplication.getInstance().getPrefManager().getPreferrence("getTeamCode");
        getPicture = MyApplication.getInstance().getPrefManager().getPreferrence("getPicture");

        contno_save = MyApplication.getInstance().getPrefManager().getPreferrence("contno_save")+"";
        check_sale_contno = MyApplication.getInstance().getPrefManager().getPreferrence("check");

        getOutstanding= MyApplication.getInstance().getPrefManager().getPreferrence("getOutstanding");
        getCustomerStatus= MyApplication.getInstance().getPrefManager().getPreferrence("getCustomerStatus");
        getAccountStatus= MyApplication.getInstance().getPrefManager().getPreferrence("getAccountStatus");
        getPayLastPeriod= MyApplication.getInstance().getPrefManager().getPreferrence("getPayLastPeriod");

        getCashTeamCCode= MyApplication.getInstance().getPrefManager().getPreferrence("getCashTeamCCode");
        getCashTeamACode= MyApplication.getInstance().getPrefManager().getPreferrence("getCashTeamACode");


        try {
            if((check_sale_contno.equals("0"))|(check_sale_contno.equals("null"))){
                switcher2.setVisibility(View.GONE);
                inputText.clearAnimation();
            }
            else {
                switcher2.setVisibility(View.VISIBLE);
                inputText.setText(contno_save);
            }
        }
        catch (Exception e){

        }






        try {
            if(getEmployeeName.equals("null")){

                linear_sale1.setVisibility(View.GONE);
            }
            else {
                linear_sale1.setVisibility(View.VISIBLE);
            }

        }
        catch (Exception ex){
            linear_sale1.setVisibility(View.GONE);
        }






        try {
            Glide.with(getActivity()).load(getPicture)



                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(getActivity()))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(getActivity().getResources().getDrawable(R.drawable.dasaa))
                    .into(handle);
        }
        catch (Exception e) {

        }

        txt_namesale.setText(getEmployeeName);
        txt_position.setText(getPositionCode);
        txt_teamcode.setText(getTeamCode);
        txt_product_serial.setText(getProduct_serial);
        txt_ProductName.setText(getProductName);
        txt_ProductPrice.setText(getProductPrice+" บาท");
        txt_CustomerName.setText(getCustomerName);
        txt_Addressall.setText(getAddressall);

        txt_Outstanding.setText(getOutstanding);
        txt_CustomerStatus.setText(getCustomerStatus);
        txt_AccountStatus.setText(getAccountStatus);
        txt_PayLastPeriod.setText(getPayLastPeriod);


        try {
            if(getPositionCode.equals("Sale")){
                txt_boss.setText(getTeamHeadName+":");
                txt_bossposition.setText(getTeamName);
            }
            else if(getPositionCode.equals("SubTeamLeader")){
                txt_boss.setText(getSupervisorHeadName+":");
                txt_bossposition.setText(getSupervisorName);
            }
            else if(getPositionCode.equals("Supervisor")){
                txt_boss.setText(getSubDepartmentHeadName+":");
                txt_bossposition.setText(getSubDepartmentName);
            }
            else if(getPositionCode.equals("Line Manager")){
                txt_boss.setText(getDepartmentHeadName+":");
                txt_bossposition.setText(getDepartmentName);
            }
        }
        catch (Exception ex){

        }



































/*try {
    String  contno_by_checker=MyApplication.getInstance().getPrefManager().getPreferrence("contno_by_checker")+"";
    if(!contno_by_checker.equals("null")){
        pDialogg2 = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
        pDialogg2.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialogg2.setTitleText("กำลังค้นหาเลขที่สัญญา...");
        pDialogg2.setCancelable(true);
        pDialogg2.show();


        INSENT_DATA_SALE_auto(contno_by_checker);
        INSENT_DATA_CHECK_CONTNO_auto(contno_by_checker);
    }

}
catch (Exception EX){

}*/





















    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.e("555","555");
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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View layoutView = inflater.inflate(R.layout.cardview_row_cedit_cedit2_4, container, false);
        // toolbar = (Toolbar) layoutView.findViewById(R.id.toolbar);

        setHasOptionsMenu(true);


        // sv = (ScrollView)layoutView.findViewById(R.id.scrl);
        spDemo= (Spinner)layoutView. findViewById(R.id.spDemo);
        spDemo_2= (Spinner)layoutView. findViewById(R.id.spDemo_2);
        spDemo2= (Spinner)layoutView. findViewById(R.id.spDemo2);
        spDemo3= (Spinner)layoutView. findViewById(R.id.spDemo3);
        spDemo4= (Spinner)layoutView. findViewById(R.id.spDemo4);
        count_problem= (TextView)layoutView. findViewById(R.id.count_problem);
        new_message= (EditText)layoutView. findViewById(R.id.new_message);
        my_recycler_view = (RecyclerView) layoutView.findViewById(R.id.my_recycler_view);
        recyclerview1= (RecyclerView) layoutView.findViewById(R.id.recyclerview1);
        recyclerview2= (RecyclerView) layoutView.findViewById(R.id.my_recycler_view2);
        r_save= (RelativeLayout) layoutView.findViewById(R.id.r_save);
        open_camera= (RelativeLayout) layoutView.findViewById(R.id.open_camera);
        open_image= (RelativeLayout) layoutView.findViewById(R.id.open_image);
        linear_sale1= (LinearLayout) layoutView.findViewById(R.id.linear_sale1);
        linear_sale2= (LinearLayout) layoutView.findViewById(R.id.linear_sale2);
        linear_sale3= (LinearLayout) layoutView.findViewById(R.id.linear_sale3);
        inputText = (EditText) layoutView.findViewById(R.id.inputText);
        switcher= (ImageButton) layoutView.findViewById(R.id.switcher);
        switcher2= (ImageButton) layoutView.findViewById(R.id.switcher2);


        handle= (ImageView) layoutView.findViewById(R.id.handle);
        txt_product_serial= (TextView) layoutView.findViewById(R.id.txt_product_serial);
        txt_namesale= (TextView) layoutView.findViewById(R.id.txt_namesale);
        txt_position= (TextView) layoutView.findViewById(R.id.txt_position);
        txt_teamcode= (TextView) layoutView.findViewById(R.id.txt_teamcode);
        txt_boss= (TextView) layoutView.findViewById(R.id.txt_boss);
        txt_bossposition= (TextView) layoutView.findViewById(R.id.txt_bossposition);
        txt_ProductName= (TextView) layoutView.findViewById(R.id.txt_ProductName);
        txt_ProductPrice= (TextView) layoutView.findViewById(R.id.txt_ProductPrice);
        txt_CustomerName= (TextView) layoutView.findViewById(R.id.txt_CustomerName);
        txt_Addressall= (TextView) layoutView.findViewById(R.id.txt_Addressall);

        txt_Outstanding= (TextView) layoutView.findViewById(R.id.txt_Outstanding);
        txt_CustomerStatus= (TextView) layoutView.findViewById(R.id.txt_CustomerStatus);
        txt_AccountStatus= (TextView) layoutView.findViewById(R.id.txt_AccountStatus);
        txt_PayLastPeriod= (TextView) layoutView.findViewById(R.id.txt_PayLastPeriod);
        txt_problem_form_checker= (TextView) layoutView.findViewById(R.id.txt_problem_form_checker);

        btn_report= (Button) layoutView.findViewById(R.id.btn_report);
        txt_checker222= (TextView) layoutView.findViewById(R.id.txt_checker222);

        linearlayout_show_problem_main= (LinearLayout) layoutView.findViewById(R.id.linearlayout_show_problem_main);
        linearlayout_show_problem_sub= (LinearLayout) layoutView.findViewById(R.id.linearlayout_show_problem_sub);
        linear_status= (LinearLayout) layoutView.findViewById(R.id.linear_status);
        image_status= (ImageView) layoutView.findViewById(R.id.image_status);
        txt_status= (TextView) layoutView.findViewById(R.id.txt_status);
        linear_coler= (LinearLayout) layoutView.findViewById(R.id.linear_coler);
        checkBox= (CheckBox) layoutView.findViewById(R.id.checkBox);
        edittext_se = (EditText) layoutView.findViewById(R.id.edittext_se);
        ib_se= (ImageButton) layoutView.findViewById(R.id.ib_se);
        linear_problem= (LinearLayout) layoutView.findViewById(R.id.linear_problem);
        linear_gory= (LinearLayout) layoutView.findViewById(R.id.linear_gory);
        problem_name= (TextView) layoutView.findViewById(R.id.problem_name);
        delete_problem_name= (ImageButton) layoutView.findViewById(R.id.delete_problem_name);
        savee= (RelativeLayout) layoutView.findViewById(R.id.savee);
        linear_topic_other= (LinearLayout) layoutView.findViewById(R.id.linear_topic_other);
        lenear_custommer_other= (LinearLayout) layoutView.findViewById(R.id.lenear_custommer_other);
        new_message_topic_other= (EditText) layoutView.findViewById(R.id.new_message_topic_other);

        test_image= (ImageView) layoutView.findViewById(R.id.test_image);
        new_message_db= (TextView) layoutView.findViewById(R.id.new_message_db);
        relativeLayout_check_net=(RelativeLayout)layoutView.findViewById(R.id.relativeLayout);
        linear_gory2= (LinearLayout) layoutView.findViewById(R.id.linear_gory2);

        li_checker= (LinearLayout) layoutView.findViewById(R.id.li_checker);
        li_checker2= (LinearLayout) layoutView.findViewById(R.id.li_checker2);
        re_up_down=(RelativeLayout)layoutView.findViewById(R.id.re_up_down);

        txt_note= (TextView) layoutView.findViewById(R.id.txt_note);
        status_check_contno= (TextView) layoutView.findViewById(R.id.status_check_contno);
        arrow= (ImageView) layoutView.findViewById(R.id.arrow);

        tesss= (TextView) layoutView.findViewById(R.id.tesss);

        tesss.setOnClickListener(this);

        r_save.setOnClickListener(this);
        open_camera.setOnClickListener(this);
        open_image.setOnClickListener(this);
        switcher.setOnClickListener(this);
        switcher2.setOnClickListener(this);
        btn_report.setOnClickListener(this);
        delete_problem_name.setOnClickListener(this);
        relativeLayout_check_net.setOnClickListener(this);
       // spDemo.setOnItemClickListener (this);
        //spDemo2.setOnClickListener(this);
        //spDemo3.setOnClickListener(this);

        GetDataAdapter1 = new ArrayList<>();
        GetDataAdapter3= new ArrayList<>();
        getData_image_more_for_delates_checker4= new ArrayList<>();





        new_message.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if(!s.equals("") ) {
                    Log.e("ssss0",s.toString());
                  //  isNumeric(s.toString());
                }

            }



            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

             //   Log.e("ssss2",s.toString());


            }

            public void afterTextChanged(Editable s) {
/*
                    String regex = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

                    Pattern pattern= Pattern.compile(regex);


                    Matcher matcher= pattern.matcher(s);

                    if(matcher.matches()){
                       // new_message.setText(replace(oldChar, newChar));

                        new_message.setText(s);
                      //  new_message.setSelection(new_message.length());
                        Log.e("edit_status","เจออักษรพิเศษ");

                    }
                    else {
                        new_message.setText(s);

                        Log.e("edit_status","ok");

                    }*/

              //  isNumeric(s.toString());

                String regex = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

                Pattern pattern=Pattern.compile(regex);

                String subStr=s.toString();
                Matcher matcher= pattern.matcher(subStr);

/*              if(matcher.matches()){
                    new_message.setText(subStr.replaceFirst(regex,""));
                   new_message.setSelection(new_message.length());
                   // Log.e("edtistatus","1111");
                }

               // [-\\\\[\\\\]^/,'*:.!><~@#$%+=?|\\\"\\\\\\\\()]+

                else*/ if((subStr.contains(":"))|(subStr.contains("["))|(subStr.contains("\\\\"))  |(subStr.contains("\\"))|
                        (subStr.contains("[\\"))|(subStr.contains("[\\\\]"))|(subStr.contains("\\]"))|(subStr.contains("\\\\]"))  |(subStr.contains("^"))|
                        (subStr.contains("_"))|(subStr.contains("'"))|(subStr.contains("*"))|(subStr.contains("."))  |(subStr.contains("!"))|
                        (subStr.contains(">"))|(subStr.contains("<"))|(subStr.contains("~"))|(subStr.contains("@"))  |(subStr.contains("#"))|
                        (subStr.contains("$"))|(subStr.contains("%"))|(subStr.contains("+"))|(subStr.contains("="))  |(subStr.contains("?"))|
                        (subStr.contains("|"))|(subStr.contains("\\"))|(subStr.contains("\\\""))|(subStr.contains("\\\\\\\\\\\\\\\\"))  |(subStr.contains("\\\"\\"))|
                        (subStr.contains("()"))|(subStr.contains("]"))|(subStr.contains("+"))){
                    new_message.setText(subStr.replaceFirst("[-\\\\\\\\[\\\\\\\\]^_'' ,'*:.!><~@#$%+=?|\\\\\\\"\\\\\\\\\\\\\\\\()]+",""));
                    new_message.setSelection(new_message.length());
                    Log.e("edtistatus","2222");

                    new_message.setError("!ไม่สามารถใช้อักขระนี้ได้ ");
                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.showSoftInput(new_message, InputMethodManager.SHOW_IMPLICIT);


                    Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        v.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                    } else {
                        v.vibrate(200);
                    }

                }




            }
        });







        re_up_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("000","000");
                if(!chilk_up_down){
                    arrow.setBackgroundResource(R.drawable.arrow_down);
                    chilk_up_down=true;
                    Log.e("111","111");
                    recyclerview2.setVisibility(View.GONE);
                }
                else {
                    Log.e("222","222");
                    arrow.setBackgroundResource(R.drawable.arrow_up);
                    chilk_up_down=false;
                    recyclerview2.setVisibility(View.VISIBLE);

                }
            }
        });


     //   sv.scrollTo(0,0);
        //sv.scrollTo(0, 0);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    status_Shortcut="2";
                    SELECT_DATA_PROBLEM_SUB_ALL();

                   // if(!menuOpen_C) {
                        //menuOpen_C=true;
                        edittext_se.setVisibility(View.GONE);
                        ib_se.setVisibility(View.GONE);
                        spDemo4.setVisibility(View.VISIBLE);

                    //}
                    linear_problem.setVisibility(View.GONE);
                    linear_gory.setVisibility(View.GONE);
                    linearlayout_show_problem_main.setVisibility(View.GONE);
                    linearlayout_show_problem_sub.setVisibility(View.GONE);

                }
                else {
                    status_Shortcut="0";
                    //menuOpen_C=false;
                    edittext_se.setVisibility(View.VISIBLE);
                    ib_se.setVisibility(View.VISIBLE);
                    spDemo4.setVisibility(View.GONE);

                    linear_problem.setVisibility(View.GONE);
                    linear_gory.setVisibility(View.VISIBLE);
                    linearlayout_show_problem_main.setVisibility(View.VISIBLE);
                    linearlayout_show_problem_sub.setVisibility(View.VISIBLE);
                }
            }
        });


        allSampleData = new ArrayList<SectionDataModel>();
        singleItem = new ArrayList<SingleItemModel>();
        singleItem3= new ArrayList<SingleItemModel3>();
        getData_check_problems=new ArrayList<>();
        getData_check_problems2=new ArrayList<>();
        getData_select_topic_problem_gories=new ArrayList<>();
        getData_select_topic_problem_gories2=new ArrayList<>();
        getData_select_topic_problem_mains=new ArrayList<>();
        getData_select_topic_problem_subs=new ArrayList<>();
        getData_select_topic_problem_sub_alls=new ArrayList<>();
        getData_cedit_dialog_image_problem_from_ids=new ArrayList<>();
        getData_uploade_images = new ArrayList<>();

        getData_image_more_for_delates= new ArrayList<GetData_cedit_dialog_image_problem_from_id>();
        getDataImageMoreForDelates= new ArrayList<>();
        getData_cedit_image_buf2s= new ArrayList<>();
        getData_image_news= new ArrayList<>();



        JSON_DATA_CHECKER();
        //data_checker_problem_for_report();
/*
        spDemo2.setAdapter(adapter);
        spDemo2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected Item: " + item, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






        spDemo3.setAdapter(adapter);
        spDemo3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected Item: " + item, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

*/

        //checkCameraPermission();


        if(checkConnection() == true){
            relativeLayout_check_net.setVisibility(View.GONE);
        }
        else {
            relativeLayout_check_net.setVisibility(View.VISIBLE);

        }


        //select_id_from_Problem_Inform_Master_for_checker();


        return layoutView;
    }



    public static boolean isNumeric(String stringVal) {
        if (stringVal.matches("[-\\\\[\\\\]^,'*:.!><~@#$%+=?|\\\"\\\\\\\\()]+")) {

            Log.e("edit_status","เจออักษรพิเศษ");
            return true;
        }
        else {
            Log.e("edit_status","ok");

            return false;
        }


    }



String GET_JSON_DATA_HTTP_URL_CHECKER=BASE_URL+"assanee/checker_system/data_check3.php";
    public void JSON_DATA_CHECKER() {
        // String SALECODE ="10103957";
        String CheckerEmpID = MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_CHECKER + "?CheckerEmpID=" + CheckerEmpID,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_WEBCALL_DATA_CHECKER(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

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

    public void JSON_PARSE_DATA_AFTER_WEBCALL_DATA_CHECKER(JSONArray array) {

        if(array.length()==0){
            li_checker2.setVisibility(View.GONE);
        }
        else {
            li_checker2.setVisibility(View.VISIBLE);
        }
        GetDataAdapter1.clear();

        //  SQLiteDataBaseBuild_data_checker_all();
        //  SQLiteTableBuild_data_checker_all();

        for (int i = 0; i < array.length(); i++) {

            final GetData_cedit GetDataAdapter2 = new GetData_cedit();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);

                getData_cedit = new GetData_cedit();

             //   String FF=json.getJSONObject("date_create").getString("date");

              //  Log.e("FF",FF);

                GetDataAdapter2.setCheckerStatus(json.getString("CheckerStatus"));
                GetDataAdapter2.setCheckerStatusName(json.getString("CheckerStatusName"));
                GetDataAdapter2.setProductSerial(json.getString("ProductSerial"));
                GetDataAdapter2.setOutstanding(json.getString("Outstanding"));
                GetDataAdapter2.setPayLastPeriod(json.getString("PayLastPeriod"));

                GetDataAdapter2.setFnYear(json.getString("FnYear"));
                GetDataAdapter2.setFnMonth(json.getString("FnMonth"));
                GetDataAdapter2.setSaleEmployeeName(json.getString("SaleEmployeeName"));
                GetDataAdapter2.setSaleTeamCode(json.getString("SaleCode"));
                GetDataAdapter2.setCONTNO(json.getString("Contno"));
                GetDataAdapter2.setProductName(json.getString("ProductName"));
                GetDataAdapter2.setCustomerName(json.getString("CustomerName"));
                GetDataAdapter2.setIDCARD(json.getString("IDCard"));
                GetDataAdapter2.setAddressDetail(json.getString("Addressall"));
                GetDataAdapter2.setLatitude(json.getString("Latitude"));
                GetDataAdapter2.setLongitude(json.getString("Longitude"));
                GetDataAdapter2.setTelHome(json.getString("TelHome"));
                GetDataAdapter2.setTelMobile(json.getString("TelMobile"));
                GetDataAdapter2.setEFFDATE(json.getJSONObject("EffDate").getString("date"));

                //GetDataAdapter2.setRefNo(json.getString(JSON_RefNo));
                //   GetDataAdapter2.setSaleHeaderName(json.getString(JSON_SaleHeaderName));



                GetDataAdapter2.setdis("ยังไม่อัฟเดท");
                Log.e("FnYear",json.getString("FnYear"));
                Log.e("FnMonth",json.getString("FnMonth"));




                //iis++;




                //GetDataAdapter2.setDistant(json.getString(JSON_IssueName));
            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter2);
            //  pDialog.dismiss();
        }








        contactAdapter = new ContactAdapter3(recyclerview2, GetDataAdapter1, getActivity());
        recyclerview2.setAdapter(contactAdapter);

        //        contactAdapter.setitemclick(this);
        contactAdapter.setitemclick2(this);
        contactAdapter.setitemclick_linear_se(this);
        txt_checker222.setText(GetDataAdapter1.size()+" รายการ");

//        getData_cedit_map = new GetData_cedit_map();
//        getData_cedit_map.setGetDataAdapter1(GetDataAdapter1);



//        contactAdapter.notifyDataSetChanged();
//
//
//        counter.setText(GetDataAdapter1.size() + "");
//        DADADA = GetDataAdapter1.size() + "";
//
//        contactAdapter.setitemclick(this);
//        contactAdapter.setitemclick2(this);
//
//        mShimmerViewContainer.stopShimmerAnimation();
//        mShimmerViewContainer.setVisibility(View.GONE);




       /* try {
            progressDialog.dismiss();
        }
        catch (Exception E){

        }*/


    }

    @Override
    public void click_linear_se(View v, int position) {

        GetData_cedit  get=GetDataAdapter1.get(position);

       // Log.e("5555",get.getCONTNO());
        txt_note.setText("");
        linear_sale2.setVisibility(View.GONE);
        inputText.setText(get.getCONTNO());

        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(inputText.getWindowToken(), 0);
        //initListener();
        contno=inputText.getText().toString();

        pDialogg2 = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
        pDialogg2.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialogg2.setTitleText("กำลังค้นหาเลขที่สัญญา...");
        pDialogg2.setCancelable(true);
        pDialogg2.show();

        // getData_select_topic_problem_gories.clear();
        //getData_select_topic_problem_mains.clear();
        //getData_select_topic_problem_subs.clear();


        if(gory_intro==1){

            INSENT_DATA_SALE();
            INSENT_DATA_CHECK_CONTNO();
        }
        else {

        }

        savee.setVisibility(View.VISIBLE);










    }

    Dialog dialog;
    RecyclerView getMy_recycler_view;
    LinearLayout li_line7,li_line8;
    TextView cc1,cc2;
    String contno_CC="";
    public void click2(View v, int position) {
        GetData_cedit  getData_cedit=GetDataAdapter1.get(position);
        contno_CC=  getData_cedit.getCONTNO();



        dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_recycleview);

        getMy_recycler_view= (RecyclerView)dialog. findViewById(R.id.recyclerview1);

        li_line7= (LinearLayout) dialog.findViewById(R.id.li_line7);
        li_line8= (LinearLayout) dialog.findViewById(R.id.li_line8);
        cc1= (TextView) dialog.findViewById(R.id.cc1);
        cc2= (TextView) dialog.findViewById(R.id.cc2);



        getMy_recycler_view.setHasFixedSize(true);
        getMy_recycler_view.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));




        dialog.setCancelable(true);






        JSON_DATA_CHECKER_DIALOG(contno_CC);
        select_color(contno_CC);






    }

String GET_JSON_DATA_HTTP_URL_DATA_CHECKER=BASE_URL+"assanee/checker_system/data_check_susscess.php";
    public void JSON_DATA_CHECKER_DIALOG(String contno){
        String CheckerEmpID = MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

        Log.e("uuurr",GET_JSON_DATA_HTTP_URL_DATA_CHECKER+"?CheckerEmpID="+CheckerEmpID+"&Contno="+contno);
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_DATA_CHECKER+"?CheckerEmpID="+CheckerEmpID+"&Contno="+contno,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_WEBCALL_DATA_CHECKER_DIALOG(response);
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




    public void JSON_PARSE_DATA_AFTER_WEBCALL_DATA_CHECKER_DIALOG(JSONArray array){

        Log.e("array.length()", String.valueOf(array.length()));
        GetDataAdapter3.clear();
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


            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter3.add(GetDataAdapter2);

        }





        RecyclerViewAdapter_type_check_susscess2    recyclerViewadapter = new RecyclerViewAdapter_type_check_susscess2(GetDataAdapter3, getActivity());
        getMy_recycler_view.setAdapter(recyclerViewadapter);


        //recyclerViewadapter.setitemclick2(this);
        recyclerViewadapter.setitemclick_image_problem_incorrect(this);
        //recyclerViewadapter.setitemclick_edit(this);


        dialog.show();




    }






    String GET_JSON_DATA_HTTP_URL_select_color=BASE_URL+"assanee/checker_system/data_select_color.php";
    String ScoreColorID="",Description="";
    private void select_color(String conno){
        Log.e("yrl",GET_JSON_DATA_HTTP_URL_select_color+"?Contno="+conno);
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_select_color+"?Contno="+conno,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSON_PARSE_DATA_AFTER_WEBCALL_select_color(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        select_color(conno);
                    }
                });

        requestQueue = Volley.newRequestQueue(getActivity());

        requestQueue.add(jsonArrayRequest);
//        swipeRefreshLayout.setRefreshing(false);
    }


    public void JSON_PARSE_DATA_AFTER_WEBCALL_select_color(JSONArray array){
        int count_data_new=array.length();
        if(count_data_new>0){

                li_line7.setVisibility(View.VISIBLE);
                li_line8.setVisibility(View.VISIBLE);

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




    Dialog dialog_image4;
    @Override
    public void click_image_problem_incorrect22(View v, int position) {
        Get_data_type_check getData_cedit = GetDataAdapter3.get(position);
        TopicID=getData_cedit.getTopicID();

        Log.e("3333","4444");
        JSON_DATA_WEB_CALL22();
    }
    String TopicID="";
    public void JSON_DATA_WEB_CALL22(){
        // = MyApplication.getInstance().getPrefManager().getPreferrence("TopicID");
        jsonArrayRequest = new JsonArrayRequest(BASE_URL+"assanee/checker_system/data_check_image.php"+"?TopicID="+TopicID+"&Contno="+contno_CC,

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
        // recyclerViewDataAdapter_dialog_image_problem_from_id_checker4.setitemclick_deleteAll2(this);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_image4.dismiss();
            }
        });


        dialog_image4.show();



    }

























    String Table_CONTNO,Table_GORY,Table_MAIN,Table_SUB,Table_DETAILS,Table_ProcessTypeID,Table_ProblemID="";
    StringBuilder sb = new StringBuilder();

    int count_probelem=0;




private void data_checker_problem_for_report(){
    getData_check_problems2.clear();
    SQLiteDataBaseBuild_data_checker_problem_for_report();
    SQLiteTableBuild_data_checker_problem_for_report();




    cursor = sqLiteDatabase.rawQuery("SELECT distinct/*count(SUB)as dd,*/CONTNO,GORY,MAIN,SUB,DETAILS,ProcessTypeID  FROM " + SQLiteHelper_data_checker_problem_for_report.TABLE_NAME, null);

    if (cursor.moveToFirst()) {
        do {

            GetData_check_problem2 getDataCheckProblem2 = new GetData_check_problem2();
           // count_probelem=cursor.dd;
             Table_CONTNO = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_problem_for_report.Table_CONTNO));
             Table_GORY = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_problem_for_report.Table_GORY));
             Table_MAIN = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_problem_for_report.Table_MAIN));
             Table_SUB = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_problem_for_report.Table_SUB));
             Table_DETAILS = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_problem_for_report.Table_DETAILS));
             Table_ProcessTypeID = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_problem_for_report.Table_ProcessTypeID));
            //Table_ProblemID = cursor.getString(cursor.getColumnIndex(SQLiteHelper_data_checker_problem_for_report.Table_ProblemID));












            Log.e("Table_SUB",Table_SUB+"");
            try {
                if(!Table_CONTNO.equals("null")){

                    // Log.e("ProblemDetail", ProblemDetail + "");
                    getDataCheckProblem2.setPart_id(String.valueOf(part_id));
                    getDataCheckProblem2.setCount_image(String.valueOf("0"));
                    getDataCheckProblem2.setCONTNO(Table_CONTNO);
                    getDataCheckProblem2.setCategory(Table_GORY);
                    getDataCheckProblem2.setMain_problems(Table_MAIN);
                    getDataCheckProblem2.setSub_problems(Table_SUB);
                    getDataCheckProblem2.setSubject(Table_ProcessTypeID);
                    getDataCheckProblem2.setProblemDetail(Table_DETAILS);
                    getDataCheckProblem2.setDatetime(datetime);
                    getDataCheckProblem2.setImage(part_image);

                    if(Table_ProcessTypeID.equals("ตรวจสอบได้ เข้าบ้านลูกค้าได้")){
                        getDataCheckProblem2.setProcessTypeID("01");

                    }
                    else if(Table_ProcessTypeID.equals("ตรวจสอบได้ เข้าบ้านลูกค้าไม่ได้")){
                        getDataCheckProblem2.setProcessTypeID("02");
                    }
                    else if(Table_ProcessTypeID.equals("ตรวจสอบไม่ได้")){
                        getDataCheckProblem2.setProcessTypeID("03");
                    }





                    if(Table_SUB.equals("เกิน 45 วัน")){
                        getDataCheckProblem2.setProblemID("14");
                    }
                   else if(Table_SUB.equals("เกิน 60 วัน")){
                        getDataCheckProblem2.setProblemID("15");
                    }
                    else if(Table_SUB.equals("เกิน 75 วัน")){
                        getDataCheckProblem2.setProblemID("16");
                    }
                    else if(Table_SUB.equals("เกิน 90 วัน")){
                        getDataCheckProblem2.setProblemID("17");
                    }
                    else if(Table_SUB.equals("เกิน 120 วัน")){
                        getDataCheckProblem2.setProblemID("18");
                    }
                    else if(Table_SUB.equals("ตรวจสอบไม่ได้")){
                        getDataCheckProblem2.setProblemID("69");
                    }

                    else {
                        getDataCheckProblem2.setProblemID("62");
                    }

                    getData_check_problems2.add(getDataCheckProblem2);


                    sb.append("*"+Table_ProcessTypeID+" > "+" เลขที่สัญญา : "+Table_CONTNO+"\n"+" "+" -"+Table_GORY+" : "+Table_MAIN+" : "+Table_SUB+" : "+Table_DETAILS+"\n");
                    sb.append(",");
                    li_checker.setVisibility(View.GONE);
                    li_checker2.setVisibility(View.VISIBLE);

                }
            }
            catch (Exception ex){

            }




        } while (cursor.moveToNext());
    }
    cursor.close();
    String sel_cat = String.valueOf(sb);

    txt_problem_form_checker.setText(sel_cat);

    Log.e("data_probem",sel_cat+"");





    recyclerViewAdapter_check_problem_new2 = new RecyclerViewAdapter_check_problem_new2(getData_check_problems2,getActivity());
    recyclerview2.setAdapter(recyclerViewAdapter_check_problem_new2);
    txt_checker222.setText(getData_check_problems2.size()+" รายการ");


     count_checker_problem=getData_check_problems2.size();



    if(count_checker_problem>0){

        for (int i = 0; i < getData_check_problems2.size(); i++) {
            // getData_uploade_images.get(i);
            GetData_check_problem2 contact = getData_check_problems2.get(i);
            ProblemID_checker = contact.getProblemID();
            Details_checker=contact.getMain_problems()+","+contact.getProblemDetail();
            Topic_checker=contact.getSubject();

            contno_checker=contact.getCONTNO();
            ProcessTypeID_checker=contact.getProcessTypeID();

            Log.e("ProblemID_checker",ProblemID_checker);
           // INSENT_DATA_SALE_FOR_CHECKER();

            // select_id_from_Problem_Inform_Master_for_checker();
            // sent_nontification_to_web();
            try {
                pDialogg.dismiss();
                pDialogg.cancel();
            }
            catch (Exception    EX){

            }

        }



    }
}


    private void checkCameraPermission() {
        Dexter.withActivity(getActivity())
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
    protected boolean checkConnection(){
        boolean re=false;
        try{
            ConnectivityManager conMan = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

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

    private void initListener() {
        inputText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length() != 0) {
                    Log.e("ssss", String.valueOf(s));
                    contno=String.valueOf(s);
                    INSENT_DATA_SALE();
                    INSENT_DATA_CHECK_CONTNO();

                }

              else  if(s.length() == 0) {
                    lenear_custommer_other.setVisibility(View.GONE);
                    hideMenu();
                    hideMenu2();
                    linear_status.setVisibility(View.GONE);

                }
                else {

                }
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, getActivity());
    }



    private String getRealPathFromURIPath(Uri contentURI, Activity activity) {
        Cursor cursor = activity.getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) {
            return contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            return cursor.getString(idx);
        }
    }




    public static HttpResponse hitUrl(String url) {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(new HttpGet(url));
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void INSENT_DATA_SALE_FOR_CHECKER() {
        String user_code2=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        String user_code=MyApplication.getInstance().getPrefManager().getPreferrence("CashTeamCode");
/*        if(item.equals("อื่นๆ")){
            ID_SUB="0";
        }
        else {
          GGGGG

    }*/

        Log.e("url",API_URL_ALL.GET_JSON_DATA_HTTP_URL_INSENT_DATA_SALE555+"?contno="+contno_checker+"&ProblemID="+ProblemID_checker+"&user_code="+user_code+"&user_code2="+user_code2  );
        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_INSENT_DATA_SALE555+"?contno="+contno_checker+"&ProblemID="+ProblemID_checker+"&user_code="+user_code+"&user_code2="+user_code2  ,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.e("response", String.valueOf(response));
                        JSON_PARSE_DATA_AFTER_WEBCALL_INSENT_DATA_SALE_FOR_CHECKER(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        try {
            try {
                requestQueue = Volley.newRequestQueue(getActivity());
                requestQueue.add(jsonArrayRequest);

                int MY_SOCKET_TIMEOUT_MS=60000;

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





    public void INSENT_DATA_CHECK_CONTNO() {



        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_INSENT_DATA_CHECK_CONTNO+"?contno="+contno,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.e("response", String.valueOf(response));
                        JSON_PARSE_DATA_AFTER_WEBCALL_INSENT_CHECK_CONTNO(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        try {
            try {
                requestQueue = Volley.newRequestQueue(getActivity());
                requestQueue.add(jsonArrayRequest);

                int MY_SOCKET_TIMEOUT_MS=60000;

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

    public void INSENT_DATA_CHECK_CONTNO_auto(String CONTNO) {



        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_INSENT_DATA_CHECK_CONTNO+"?contno="+CONTNO,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.e("response", String.valueOf(response));
                        JSON_PARSE_DATA_AFTER_WEBCALL_INSENT_CHECK_CONTNO(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        try {
            try {
                requestQueue = Volley.newRequestQueue(getActivity());
                requestQueue.add(jsonArrayRequest);

                int MY_SOCKET_TIMEOUT_MS=60000;

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


    public void INSENT_DATA_SALE() {
        String user_code2=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        String user_code=MyApplication.getInstance().getPrefManager().getPreferrence("CashTeamCode");
        if(item.equals("อื่นๆ")){
            ID_SUB="0";
        }
        else {
            if (status_Shortcut.equals("1")) {
                ID_SUB = ID_PROMLEM_NUMBER;
            } else if (status_Shortcut.equals("2")) {
                ID_SUB = MyApplication.getInstance().getPrefManager().getPreferrence("ID_SUB_ALL");
            } else {
                ID_SUB = MyApplication.getInstance().getPrefManager().getPreferrence("ID_SUB");
            }
        }

        Log.e("url",API_URL_ALL.GET_JSON_DATA_HTTP_URL_INSENT_DATA_SALE+"?contno="+contno+"&ProblemID="+ID_SUB+"&user_code="+user_code+"&user_code2="+user_code2  );
        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_INSENT_DATA_SALE+"?contno="+contno+"&ProblemID="+ID_SUB+"&user_code="+user_code+"&user_code2="+user_code2  ,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.e("response", String.valueOf(response));
                        JSON_PARSE_DATA_AFTER_WEBCALL_INSENT_DATA_SALE(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        try {
            try {
                requestQueue = Volley.newRequestQueue(getActivity());
                requestQueue.add(jsonArrayRequest);

                int MY_SOCKET_TIMEOUT_MS=60000;

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




    public void INSENT_DATA_SALE_auto(String CONTNO) {
        String user_code2=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        String user_code=MyApplication.getInstance().getPrefManager().getPreferrence("CashTeamCode");
        if(item.equals("อื่นๆ")){
            ID_SUB="0";
        }
        else {
            if (status_Shortcut.equals("1")) {
                ID_SUB = ID_PROMLEM_NUMBER;
            } else if (status_Shortcut.equals("2")) {
                ID_SUB = MyApplication.getInstance().getPrefManager().getPreferrence("ID_SUB_ALL");
            } else {
                ID_SUB = MyApplication.getInstance().getPrefManager().getPreferrence("ID_SUB");
            }
        }

        Log.e("url",API_URL_ALL.GET_JSON_DATA_HTTP_URL_INSENT_DATA_SALE+"?contno="+CONTNO+"&ProblemID="+ID_SUB+"&user_code="+user_code+"&user_code2="+user_code2  );
        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_INSENT_DATA_SALE+"?contno="+CONTNO+"&ProblemID="+ID_SUB+"&user_code="+user_code+"&user_code2="+user_code2  ,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.e("response", String.valueOf(response));
                        JSON_PARSE_DATA_AFTER_WEBCALL_INSENT_DATA_SALE(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        try {
            try {
                requestQueue = Volley.newRequestQueue(getActivity());
                requestQueue.add(jsonArrayRequest);

                int MY_SOCKET_TIMEOUT_MS=60000;

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
    //check_sale_contno = MyApplication.getInstance().getPrefManager().getPreferrence("check");


    String NoID="",FnYear="",FnMonth="";
    public void JSON_PARSE_DATA_AFTER_WEBCALL_INSENT_DATA_SALE(JSONArray array) {
        check=array.length();
        MyApplication.getInstance().getPrefManager().setPreferrence("check", String.valueOf(check));
        if(check==0){
           // switcher2.setVisibility(View.GONE);
            switcher2.setVisibility(View.VISIBLE);
            switcher2.setImageResource(R.drawable.errorerror);
            error=1;



            revealMenu2();
            hideMenu();
            lenear_custommer_other.setVisibility(View.GONE);
        }
        else {

            switcher2.setVisibility(View.VISIBLE);
            switcher2.setImageResource(R.drawable.check_box_report_problem);
            error=0;
            revealMenu();
            lenear_custommer_other.setVisibility(View.VISIBLE);
        }
        for (int i = 0; i < array.length(); i++) {

            final GetData_sale_information GetDataAdapter2 = new GetData_sale_information();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);

                GetDataAdapter2.setCONTNO(json.getString(JSON_CONTNO));
                GetDataAdapter2.setProductSerial(json.getString("ProductSerial"));
                GetDataAdapter2.setProductName(json.getString(JSON_ProductName));
                GetDataAdapter2.setProductPrice(json.getString(JSON_ProductPrice));
                GetDataAdapter2.setCustomerName(json.getString(JSON_CustomerName));
                GetDataAdapter2.setAddressall(json.getString(JSON_Addressall));
                GetDataAdapter2.setTelHome(json.getString(JSON_TelHome));
                GetDataAdapter2.setTelMobile(json.getString(JSON_TelMobile));
                GetDataAdapter2.setEmpID(json.getString(JSON_EmpID));
                GetDataAdapter2.setEmployeeName(json.getString(JSON_EmployeeName));
                GetDataAdapter2.setPositionCode(json.getString(JSON_PositionCode));
                GetDataAdapter2.setPositionName(json.getString(JSON_PositionName));
                GetDataAdapter2.setSaleCode(json.getString("SaleCode"));

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
                GetDataAdapter2.setInformID(json.getString(JSON_InformID));

                GetDataAdapter2.setOutstanding(json.getString("Outstanding"));
                GetDataAdapter2.setCustomerStatus(json.getString("CustomerStatus"));
                GetDataAdapter2.setAccountStatus(json.getString("AccountStatus"));
                GetDataAdapter2.setPayLastPeriod(json.getString("PayLastPeriod"));

                GetDataAdapter2.setCashTeamCCode(json.getString("CashTeamCCode"));
                GetDataAdapter2.setCashTeamACode(json.getString("CashTeamACode"));




                 NoID=json.getString("NoID");
                 FnYear=json.getString("FnYear");
                 FnMonth=json.getString("FnMonth");




                //GetDataAdapter2.setContno_nontification_problem(json.getString(JSON_Contno_nontification_problem));
                //GetDataAdapter2.setInformEmpID(json.getString(JSON_InformEmpID));
               //GetDataAdapter2.setInformDepartID(json.getString(JSON_InformDepartID));



Log.e("getEmpID",GetDataAdapter2.getEmpID());





                try {
                    Glide.with(getActivity()).load(json.getString(JSON_picture))



                            .crossFade()
                            .thumbnail(0.5f)
                            .bitmapTransform(new CircleTransform(getActivity()))
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .placeholder(getActivity().getResources().getDrawable(R.drawable.dasaa))
                            .into(handle);
                }
                catch (Exception e) {

                }

                txt_namesale.setText(json.getString(JSON_EmployeeName));
                txt_position.setText(json.getString(JSON_PositionCode));
                txt_teamcode.setText(json.getString(JSON_TeamCode));
                txt_product_serial.setText(GetDataAdapter2.getProductSerial());
                txt_ProductName.setText(GetDataAdapter2.getProductName());
                txt_ProductPrice.setText(GetDataAdapter2.getProductPrice()+" บาท");
                txt_CustomerName.setText(GetDataAdapter2.getCustomerName());
                txt_Addressall.setText(GetDataAdapter2.getAddressall());

                txt_Outstanding.setText(GetDataAdapter2.getOutstanding());
                txt_CustomerStatus.setText(GetDataAdapter2.getCustomerStatus());
                txt_AccountStatus.setText(GetDataAdapter2.getAccountStatus());
                txt_PayLastPeriod.setText(GetDataAdapter2.getPayLastPeriod());

                if(GetDataAdapter2.getPositionCode().equals("Sale")){
                    txt_boss.setText(GetDataAdapter2.getTeamHeadName()+":");
                    txt_bossposition.setText(GetDataAdapter2.getTeamName());
                }
                else if(GetDataAdapter2.getPositionCode().equals("SubTeamLeader")){
                    txt_boss.setText(GetDataAdapter2.getSupervisorHeadName()+":");
                    txt_bossposition.setText(GetDataAdapter2.getSupervisorName());
                }
                else if(GetDataAdapter2.getPositionCode().equals("Supervisor")){
                    txt_boss.setText(GetDataAdapter2.getSubDepartmentHeadName()+":");
                    txt_bossposition.setText(GetDataAdapter2.getSubDepartmentName());
                }
                else if(GetDataAdapter2.getPositionCode().equals("Line Manager")){
                    txt_boss.setText(GetDataAdapter2.getDepartmentHeadName()+":");
                    txt_bossposition.setText(GetDataAdapter2.getDepartmentName());
                }



                if((GetDataAdapter2.getInformID().isEmpty())|GetDataAdapter2.getInformID().equals("null")){
                    linear_status.setVisibility(View.VISIBLE);
                 //   image_status.setBackgroundResource(R.drawable.ic_error_outline_white_24dp);
                   // txt_status.setText("ยังไม่เคยเเจ้งป้ญหา");
                   // linear_coler.setBackgroundResource(R.color.Plum);

                }
                else {
                    linear_status.setVisibility(View.VISIBLE);
                  //  image_status.setBackgroundResource(R.drawable.ic_check_circle_white_24dp);
                   // txt_status.setText("เคยแจ้งปัญหาแล้ว");
                   // linear_coler.setBackgroundResource(R.color.base_gray_green);
                }










                MyApplication.getInstance().getPrefManager().setPreferrence("getCONTNO", GetDataAdapter2.getCONTNO());

                MyApplication.getInstance().getPrefManager().setPreferrence("getProductName", GetDataAdapter2.getProductName());
                MyApplication.getInstance().getPrefManager().setPreferrence("getProductPrice", GetDataAdapter2.getProductPrice());
                MyApplication.getInstance().getPrefManager().setPreferrence("getCustomerName", GetDataAdapter2.getCustomerName());
                MyApplication.getInstance().getPrefManager().setPreferrence("getAddressall", GetDataAdapter2.getAddressall());


                MyApplication.getInstance().getPrefManager().setPreferrence("getEmpID", GetDataAdapter2.getEmpID());
                MyApplication.getInstance().getPrefManager().setPreferrence("getEmployeeName", GetDataAdapter2.getEmployeeName());
                MyApplication.getInstance().getPrefManager().setPreferrence("getPositionCode", GetDataAdapter2.getPositionCode());
                MyApplication.getInstance().getPrefManager().setPreferrence("getPositionName", GetDataAdapter2.getPositionName());
                MyApplication.getInstance().getPrefManager().setPreferrence("getSaleCode", GetDataAdapter2.getSaleCode());
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

                MyApplication.getInstance().getPrefManager().setPreferrence("getInformID", GetDataAdapter2.getInformID());
                MyApplication.getInstance().getPrefManager().setPreferrence("getContno_nontification_problem", GetDataAdapter2.getContno_nontification_problem());
                MyApplication.getInstance().getPrefManager().setPreferrence("getInformEmpID", GetDataAdapter2.getInformEmpID());
                MyApplication.getInstance().getPrefManager().setPreferrence("getInformDepartID", GetDataAdapter2.getInformDepartID());

                MyApplication.getInstance().getPrefManager().setPreferrence("getOutstanding", GetDataAdapter2.getOutstanding());
                MyApplication.getInstance().getPrefManager().setPreferrence("getCustomerStatus", GetDataAdapter2.getCustomerStatus());
                MyApplication.getInstance().getPrefManager().setPreferrence("getAccountStatus", GetDataAdapter2.getAccountStatus());
                MyApplication.getInstance().getPrefManager().setPreferrence("getPayLastPeriod", GetDataAdapter2.getPayLastPeriod());
                MyApplication.getInstance().getPrefManager().setPreferrence("getCashTeamCCode", GetDataAdapter2.getCashTeamCCode());
                MyApplication.getInstance().getPrefManager().setPreferrence("getCashTeamACode", GetDataAdapter2.getCashTeamACode());
                MyApplication.getInstance().getPrefManager().setPreferrence("contno_save", contno);



            } catch (JSONException e) {

                e.printStackTrace();
            }
            //  GetDataAdapter1.add(GetDataAdapter2);

        }
                try {
                    pDialogg2.cancel();
                }
                catch (Exception ex){

}

        select_status_non();
       // GetDataAdapter1.clear();
       // JSON_DATA_WEB_CALL();


    }
    public void JSON_PARSE_DATA_AFTER_WEBCALL_INSENT_DATA_SALE_FOR_CHECKER(JSONArray array) {
        check=array.length();
        MyApplication.getInstance().getPrefManager().setPreferrence("check", String.valueOf(check));


        switcher2.setVisibility(View.GONE);
        hideMenu();
        lenear_custommer_other.setVisibility(View.GONE);
        switcher2.setVisibility(View.GONE);
        lenear_custommer_other.setVisibility(View.GONE);


        for (int i = 0; i < array.length(); i++) {

            final GetData_sale_information GetDataAdapter2 = new GetData_sale_information();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);

                GetDataAdapter2.setCONTNO(json.getString(JSON_CONTNO));
                GetDataAdapter2.setProductSerial(json.getString("ProductSerial"));
                GetDataAdapter2.setProductName(json.getString(JSON_ProductName));
                GetDataAdapter2.setProductPrice(json.getString(JSON_ProductPrice));
                GetDataAdapter2.setCustomerName(json.getString(JSON_CustomerName));
                GetDataAdapter2.setAddressall(json.getString(JSON_Addressall));
                GetDataAdapter2.setTelHome(json.getString(JSON_TelHome));
                GetDataAdapter2.setTelMobile(json.getString(JSON_TelMobile));
                GetDataAdapter2.setEmpID(json.getString(JSON_EmpID));
                GetDataAdapter2.setEmployeeName(json.getString(JSON_EmployeeName));
                GetDataAdapter2.setPositionCode(json.getString(JSON_PositionCode));
                GetDataAdapter2.setPositionName(json.getString(JSON_PositionName));
                GetDataAdapter2.setSaleCode(json.getString("SaleCode"));

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
                GetDataAdapter2.setInformID(json.getString(JSON_InformID));

                GetDataAdapter2.setOutstanding(json.getString("Outstanding"));
                GetDataAdapter2.setCustomerStatus(json.getString("CustomerStatus"));
                GetDataAdapter2.setAccountStatus(json.getString("AccountStatus"));
                GetDataAdapter2.setPayLastPeriod(json.getString("PayLastPeriod"));

                GetDataAdapter2.setCashTeamCCode(json.getString("CashTeamCCode"));
                GetDataAdapter2.setCashTeamACode(json.getString("CashTeamACode"));
                //GetDataAdapter2.setContno_nontification_problem(json.getString(JSON_Contno_nontification_problem));
                //GetDataAdapter2.setInformEmpID(json.getString(JSON_InformEmpID));
                //GetDataAdapter2.setInformDepartID(json.getString(JSON_InformDepartID));



                Log.e("getEmpID",GetDataAdapter2.getEmpID());





                try {
                    Glide.with(getActivity()).load(json.getString(JSON_picture))



                            .crossFade()
                            .thumbnail(0.5f)
                            .bitmapTransform(new CircleTransform(getActivity()))
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .placeholder(getActivity().getResources().getDrawable(R.drawable.dasaa))
                            .into(handle);
                }
                catch (Exception e) {

                }

                txt_namesale.setText(json.getString(JSON_EmployeeName));
                txt_position.setText(json.getString(JSON_PositionCode));
                txt_teamcode.setText(json.getString(JSON_TeamCode));
                txt_product_serial.setText(GetDataAdapter2.getProductSerial());
                txt_ProductName.setText(GetDataAdapter2.getProductName());
                txt_ProductPrice.setText(GetDataAdapter2.getProductPrice()+" บาท");
                txt_CustomerName.setText(GetDataAdapter2.getCustomerName());
                txt_Addressall.setText(GetDataAdapter2.getAddressall());

                txt_Outstanding.setText(GetDataAdapter2.getOutstanding());
                txt_CustomerStatus.setText(GetDataAdapter2.getCustomerStatus());
                txt_AccountStatus.setText(GetDataAdapter2.getAccountStatus());
                txt_PayLastPeriod.setText(GetDataAdapter2.getPayLastPeriod());

                if(GetDataAdapter2.getPositionCode().equals("Sale")){
                    txt_boss.setText(GetDataAdapter2.getTeamHeadName()+":");
                    txt_bossposition.setText(GetDataAdapter2.getTeamName());
                }
                else if(GetDataAdapter2.getPositionCode().equals("SubTeamLeader")){
                    txt_boss.setText(GetDataAdapter2.getSupervisorHeadName()+":");
                    txt_bossposition.setText(GetDataAdapter2.getSupervisorName());
                }
                else if(GetDataAdapter2.getPositionCode().equals("Supervisor")){
                    txt_boss.setText(GetDataAdapter2.getSubDepartmentHeadName()+":");
                    txt_bossposition.setText(GetDataAdapter2.getSubDepartmentName());
                }
                else if(GetDataAdapter2.getPositionCode().equals("Line Manager")){
                    txt_boss.setText(GetDataAdapter2.getDepartmentHeadName()+":");
                    txt_bossposition.setText(GetDataAdapter2.getDepartmentName());
                }



                if((GetDataAdapter2.getInformID().isEmpty())|GetDataAdapter2.getInformID().equals("null")){
                    linear_status.setVisibility(View.VISIBLE);
                    //   image_status.setBackgroundResource(R.drawable.ic_error_outline_white_24dp);
                    // txt_status.setText("ยังไม่เคยเเจ้งป้ญหา");
                    // linear_coler.setBackgroundResource(R.color.Plum);

                }
                else {
                    linear_status.setVisibility(View.VISIBLE);
                    //  image_status.setBackgroundResource(R.drawable.ic_check_circle_white_24dp);
                    // txt_status.setText("เคยแจ้งปัญหาแล้ว");
                    // linear_coler.setBackgroundResource(R.color.base_gray_green);
                }










                MyApplication.getInstance().getPrefManager().setPreferrence("getCONTNO", GetDataAdapter2.getCONTNO());

                MyApplication.getInstance().getPrefManager().setPreferrence("getProductName", GetDataAdapter2.getProductName());
                MyApplication.getInstance().getPrefManager().setPreferrence("getProductPrice", GetDataAdapter2.getProductPrice());
                MyApplication.getInstance().getPrefManager().setPreferrence("getCustomerName", GetDataAdapter2.getCustomerName());
                MyApplication.getInstance().getPrefManager().setPreferrence("getAddressall", GetDataAdapter2.getAddressall());


                MyApplication.getInstance().getPrefManager().setPreferrence("getEmpID", GetDataAdapter2.getEmpID());
                MyApplication.getInstance().getPrefManager().setPreferrence("getEmployeeName", GetDataAdapter2.getEmployeeName());
                MyApplication.getInstance().getPrefManager().setPreferrence("getPositionCode", GetDataAdapter2.getPositionCode());
                MyApplication.getInstance().getPrefManager().setPreferrence("getPositionName", GetDataAdapter2.getPositionName());
                MyApplication.getInstance().getPrefManager().setPreferrence("getSaleCode", GetDataAdapter2.getSaleCode());
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

                MyApplication.getInstance().getPrefManager().setPreferrence("getInformID", GetDataAdapter2.getInformID());
                MyApplication.getInstance().getPrefManager().setPreferrence("getContno_nontification_problem", GetDataAdapter2.getContno_nontification_problem());
                MyApplication.getInstance().getPrefManager().setPreferrence("getInformEmpID", GetDataAdapter2.getInformEmpID());
                MyApplication.getInstance().getPrefManager().setPreferrence("getInformDepartID", GetDataAdapter2.getInformDepartID());

                MyApplication.getInstance().getPrefManager().setPreferrence("getOutstanding", GetDataAdapter2.getOutstanding());
                MyApplication.getInstance().getPrefManager().setPreferrence("getCustomerStatus", GetDataAdapter2.getCustomerStatus());
                MyApplication.getInstance().getPrefManager().setPreferrence("getAccountStatus", GetDataAdapter2.getAccountStatus());
                MyApplication.getInstance().getPrefManager().setPreferrence("getPayLastPeriod", GetDataAdapter2.getPayLastPeriod());
                MyApplication.getInstance().getPrefManager().setPreferrence("getCashTeamCCode", GetDataAdapter2.getCashTeamCCode());
                MyApplication.getInstance().getPrefManager().setPreferrence("getCashTeamACode", GetDataAdapter2.getCashTeamACode());
                MyApplication.getInstance().getPrefManager().setPreferrence("contno_save", contno);



            } catch (JSONException e) {

                e.printStackTrace();
            }
            //  GetDataAdapter1.add(GetDataAdapter2);

        }
        try {
            pDialogg2.cancel();
        }
        catch (Exception ex){

        }

        select_id_from_Problem_Inform_Master_for_checker();

    }








String CONTNO_CHECK_CONTNO="",CashName_CHECK_CONTNO="",CashTeamCode_CHECK_CONTNO="",CashEmpID_CHECK_CONTNO="",CashEmpName_CHECK_CONTNO="",customerstatus_CHECK_CONTNO="",CheckerStatus_CHECK_CONTNO="";
    public void JSON_PARSE_DATA_AFTER_WEBCALL_INSENT_CHECK_CONTNO(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {


            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                CONTNO_CHECK_CONTNO=json.getString("CONTNO");
                CashName_CHECK_CONTNO=json.getString("CashName");
                CashTeamCode_CHECK_CONTNO=json.getString("CashTeamCode");
                CashEmpID_CHECK_CONTNO=json.getString("CashEmpID");
                CashEmpName_CHECK_CONTNO=json.getString("CashEmpName");
                customerstatus_CHECK_CONTNO=json.getString("customerstatus");
                CheckerStatus_CHECK_CONTNO=json.getString("CheckerStatus");




            } catch (JSONException e) {

                e.printStackTrace();
            }

        }


        pDialogg2.cancel();
        if(array.length()==0){
            txt_note.setText("(หมายเหตุ : เลขที่สัญญานี้ไม่มีในระบบ)");

        }
        else {




           //if((CashEmpID_CHECK_CONTNO.equals(user_code2))&(CashTeamCode_CHECK_CONTNO.equals(user_code))){

             //   txt_note.setText("(หมายเหตุ : ต้องเลือก หมวดหมู่ เป็น ปัญหาการ์ดค่างวด แล้วทำการค้นหาใหม่)");

          //  }
          //  else {

                if((customerstatus_CHECK_CONTNO.equals("F"))&(!CashName_CHECK_CONTNO.equals("Credit"))){
                    txt_note.setText("(หมายเหตุ : เลขที่สัญญา "+CONTNO_CHECK_CONTNO+" จ่ายครบแล้ว ");

                }
                else if((customerstatus_CHECK_CONTNO.equals("T"))&(!CashName_CHECK_CONTNO.equals("Credit"))){
                    txt_note.setText("(หมายเหตุ : เลขที่สัญญา "+CONTNO_CHECK_CONTNO+" ถอดเครื่องแล้ว ");
                }
                else {



                    if(item.equals("ปัญหาการ์ดค่างวด")){
                        if((CashEmpID_CHECK_CONTNO.equals("NULL"))|(CashEmpID_CHECK_CONTNO.equals("null"))|(CashEmpID_CHECK_CONTNO.isEmpty())){
                            txt_note.setText("(หมายเหตุ : เลขที่สัญญา "+CONTNO_CHECK_CONTNO+" ตอนนี้เป็นของ "+CashName_CHECK_CONTNO+" อยู่ใน "+" : "+CashEmpName_CHECK_CONTNO+" )");

                        }
                        else {
                            txt_note.setText("(หมายเหตุ : เลขที่สัญญา "+CONTNO_CHECK_CONTNO+" ตอนนี้เป็นของ "+CashName_CHECK_CONTNO+" รหัส "+CashEmpID_CHECK_CONTNO+" : "+CashEmpName_CHECK_CONTNO+" )");

                        }


                    }
                    else {
                        String user_code2=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
                        String user_code=MyApplication.getInstance().getPrefManager().getPreferrence("CashTeamCode");



                            if(CheckerStatus_CHECK_CONTNO.equals("01")){
                                if((CashEmpID_CHECK_CONTNO.equals(user_code2))&(CashTeamCode_CHECK_CONTNO.equals(user_code))){
                                    txt_note.setText("(หมายเหตุ : เลขที่สัญญา "+CONTNO_CHECK_CONTNO+" ยังไม่ได้ทำการตรวจสอบ ในระบบ ตรวจสอบ !กรุณาตรวจสอบก่อนการแจ้งปัญหา" );

                                }
                                else {
                                    txt_note.setText("(หมายเหตุ : ใช้ได้เฉพาะ หมวดหมู่  ปัญหาอื่นๆ  : เนื่องจาก เลขที่สัญญา "+CONTNO_CHECK_CONTNO+" ตอนนี้เป็นของ "+CashName_CHECK_CONTNO+" รหัส "+CashEmpID_CHECK_CONTNO+" : "+CashEmpName_CHECK_CONTNO+" )");

                                }

                            }
                            else {

                                if((!customerstatus_CHECK_CONTNO.equals("F"))&(!CashName_CHECK_CONTNO.equals("Credit"))){
                                    if(customerstatus_CHECK_CONTNO.equals("T")){
                                        txt_note.setText("(หมายเหตุ : ใช้ได้เฉพาะ หมวดหมู่  ปัญหาการ์ดตรวจสอบ  : เนื่องจาก เลขที่สัญญา "+CONTNO_CHECK_CONTNO+" ตอนนี้เป็นของ "+CashName_CHECK_CONTNO+" รหัส "+CashEmpID_CHECK_CONTNO+" : "+CashEmpName_CHECK_CONTNO+" )" +
                                                " : สถานะ เครื่องถอด");

                                    }
                                    else {
                                        txt_note.setText("(หมายเหตุ : ใช้ได้เฉพาะ หมวดหมู่  ปัญหาการ์ดตรวจสอบ  : เนื่องจาก เลขที่สัญญา "+CONTNO_CHECK_CONTNO+" ตอนนี้เป็นของ "+CashName_CHECK_CONTNO+" รหัส "+CashEmpID_CHECK_CONTNO+" : "+CashEmpName_CHECK_CONTNO+" )");

                                    }

                                }
                                else if((!customerstatus_CHECK_CONTNO.equals("T"))&(!CashName_CHECK_CONTNO.equals("Credit"))){

                                      if(customerstatus_CHECK_CONTNO.equals("F")){
                                          txt_note.setText("(หมายเหตุ : ใช้ได้เฉพาะ หมวดหมู่  ปัญหาอื่นๆ  : เนื่องจาก เลขที่สัญญา  "+CONTNO_CHECK_CONTNO+" ตอนนี้เป็นของ "+CashName_CHECK_CONTNO+" รหัส "+CashEmpID_CHECK_CONTNO+" : "+CashEmpName_CHECK_CONTNO+" )" +
                                                  " : สถานะ จ่ายครบแล้ว");

                                    }
                                     else {
                                        txt_note.setText("(หมายเหตุ : ใช้ได้เฉพาะ หมวดหมู่  ปัญหาอื่นๆ  : เนื่องจาก เลขที่สัญญา  "+CONTNO_CHECK_CONTNO+" ตอนนี้เป็นของ "+CashName_CHECK_CONTNO+" รหัส "+CashEmpID_CHECK_CONTNO+" : "+CashEmpName_CHECK_CONTNO+" )" +
                                                "");
                                    }


                                }


                               else if((!customerstatus_CHECK_CONTNO.equals("F"))&(CashName_CHECK_CONTNO.equals("Credit"))){
                                    if(customerstatus_CHECK_CONTNO.equals("T")){
                                        txt_note.setText("(หมายเหตุ : ใช้ได้เฉพาะ หมวดหมู่  ปัญหาการ์ดตรวจสอบ  : เนื่องจาก เลขที่สัญญา "+CONTNO_CHECK_CONTNO+" ตอนนี้เป็นของ "+CashName_CHECK_CONTNO+" รหัส "+CashEmpID_CHECK_CONTNO+" : "+CashEmpName_CHECK_CONTNO+" )" +
                                                " : สถานะ เครื่องถอด");

                                    }
                                    else {
                                        txt_note.setText("(หมายเหตุ : ใช้ได้เฉพาะ หมวดหมู่  ปัญหาการ์ดตรวจสอบ  : เนื่องจาก เลขที่สัญญา "+CONTNO_CHECK_CONTNO+" ตอนนี้เป็นของ "+CashName_CHECK_CONTNO+" รหัส "+CashEmpID_CHECK_CONTNO+" : "+CashEmpName_CHECK_CONTNO+" )");

                                    }

                                }
                                else if((!customerstatus_CHECK_CONTNO.equals("T"))&(CashName_CHECK_CONTNO.equals("Credit"))){

                                    if((customerstatus_CHECK_CONTNO.equals("F"))&(CashEmpID_CHECK_CONTNO.equals(user_code2))&(CashTeamCode_CHECK_CONTNO.equals(user_code))){

                                        txt_note.setText("(หมายเหตุ : ใช้ได้เฉพาะ หมวดหมู่  ปัญหาอื่นๆ,ปัญหาการ์ดค่างวด หรือ อื่นๆ  : เนื่องจาก เลขที่สัญญา  "+CONTNO_CHECK_CONTNO+" ตอนนี้เป็นของ "+CashName_CHECK_CONTNO+" รหัส "+CashEmpID_CHECK_CONTNO+" : "+CashEmpName_CHECK_CONTNO+" )" +
                                                " : สถานะ จ่ายครบแล้ว");

                                    }
                                    if((customerstatus_CHECK_CONTNO.equals("F"))&(!CashEmpID_CHECK_CONTNO.equals(user_code2))&(!CashTeamCode_CHECK_CONTNO.equals(user_code))){

                                        txt_note.setText("(หมายเหตุ : ใช้ได้เฉพาะ หมวดหมู่  ปัญหาอื่นๆ  : เนื่องจาก เลขที่สัญญา  "+CONTNO_CHECK_CONTNO+" ตอนนี้เป็นของ "+CashName_CHECK_CONTNO+" รหัส "+CashEmpID_CHECK_CONTNO+" : "+CashEmpName_CHECK_CONTNO+" )" +
                                                " : สถานะ จ่ายครบแล้ว");
                                    }
                                    else {
                                        txt_note.setText("(หมายเหตุ : ใช้ได้เฉพาะ หมวดหมู่  ปัญหาอื่นๆ  : เนื่องจาก เลขที่สัญญา  "+CONTNO_CHECK_CONTNO+" ตอนนี้เป็นของ "+CashName_CHECK_CONTNO+" รหัส "+CashEmpID_CHECK_CONTNO+" : "+CashEmpName_CHECK_CONTNO+" )" +
                                                "");
                                    }


                                }

                            }















                    }










                }

           // }

        }

    }






















    public void SELECT_PROBLEM_FROM_NUMBER() {
        String id_code=edittext_se.getText().toString();
        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_SELECT_PROBLEM_FROM_NUMBER+"?id_code="+id_code ,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.e("response", String.valueOf(response));
                        JSON_PARSE_DATA_AFTER_WEBCALL_SELECT_PROBLEM_FROM_NUMBER(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

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

    String ID_PROMLEM_NUMBER="",name_sub="",main="",gory="",name_main="",name_gory="";
    public void JSON_PARSE_DATA_AFTER_WEBCALL_SELECT_PROBLEM_FROM_NUMBER(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {


            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                ID_PROMLEM_NUMBER=json.getString("ProblemID");
                name_sub=json.getString("ProblemName");
                main=json.getString("main");
                name_main=json.getString("name_main");
                gory=json.getString("gory");
                name_gory=json.getString("name_gory");
                Log.e("ID_PROMLEM_NUMBER",ID_PROMLEM_NUMBER);


            } catch (JSONException e) {

                e.printStackTrace();
            }

        }
        pDialogg2.cancel();

            if(array.length()==0){
                linear_problem.setVisibility(View.VISIBLE);
                linear_gory.setVisibility(View.GONE);
                linearlayout_show_problem_main.setVisibility(View.GONE);
                linearlayout_show_problem_sub.setVisibility(View.GONE);
                problem_name.setText("ไม่มีเลขปัญหา/ชื่อปัญหานี้");
                problem_name.setTextColor(0xffFF4081);
            }
            else {
                linear_problem.setVisibility(View.VISIBLE);
                linear_gory.setVisibility(View.GONE);
                linearlayout_show_problem_main.setVisibility(View.GONE);
                linearlayout_show_problem_sub.setVisibility(View.GONE);
                problem_name.setText(name_gory+" : "+name_main+" : "+name_sub);
                problem_name.setTextColor(0xff26ae90);
            }

        SELECT_DATA_PROBLEM_DETAILS();
        select_status_non();
    }










    String item="";
    public void SELECT_DATA_PROBLEM_GORY() {

        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_gory ,


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

    String ID_GORY="";
    public void JSON_PARSE_DATA_AFTER_SELECT_DATA_PROBLEM_GORY(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            final GetData_select_topic_problem_gory GetDataAdapter2 = new GetData_select_topic_problem_gory();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                GetDataAdapter2.setProblemID(json.getString("ProblemID"));
                GetDataAdapter2.setProblemName(json.getString("ProblemName"));



            } catch (JSONException e) {

                e.printStackTrace();
            }
            getData_select_topic_problem_gories.add(GetDataAdapter2);
           // value=GetDataAdapter2.getProblemName();
        }
        String[] array2 = new String[getData_select_topic_problem_gories.size()];
        String[] array3 = new String[getData_select_topic_problem_gories.size()];
        int i;
        ArrayAdapter<String> adapter = null ;

        for ( i = 0; i < getData_select_topic_problem_gories.size(); i++) {
            final GetData_select_topic_problem_gory contact = getData_select_topic_problem_gories.get(i);
            array2[i]= contact.getProblemName();

            Log.e("SSSS",array2[i]);

            //array2=getData_select_topic_problem_gories.;
            try {
                adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, android.R.id.text1, array2);
                //adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, android.R.id.text1, array2);
            }
            catch (Exception ex){

            }

        }




       // ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1, android.R.id.text1,getData_select_topic_problem_gories);



        spDemo.setAdapter(adapter);

        spDemo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 item = parent.getItemAtPosition(position).toString();
                if(item.equals("อื่นๆ")){
                    spDemo2.setVisibility(View.GONE);
                    spDemo3.setVisibility(View.GONE);
                    linearlayout_show_problem_main.setVisibility(View.GONE);
                    linearlayout_show_problem_sub.setVisibility(View.GONE);
                    linear_topic_other.setVisibility(View.VISIBLE);
                    select_status_non();
                }
                else {
                    spDemo2.setVisibility(View.VISIBLE);
                    spDemo3.setVisibility(View.VISIBLE);
                    linearlayout_show_problem_main.setVisibility(View.VISIBLE);
                    linearlayout_show_problem_sub.setVisibility(View.VISIBLE);
                    linear_topic_other.setVisibility(View.GONE);
                }


                try {
                    if((item.equals(""))|item.isEmpty()){
                        gory_intro=0;
                    }
                    else {
                        gory_intro=1;
                        if(item.equals("ปัญหาการ์ดตรวจสอบ")){
                            API_URL_ALL.GET_JSON_DATA_HTTP_URL_INSENT_DATA_SALE=BASE_URL+"assanee/api_report_problem_from_contno/report_promlem_contno2.php";
                            API_URL_ALL.GET_JSON_DATA_HTTP_URL_main=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_main_problem.php";
                            API_URL_ALL.GET_JSON_DATA_HTTP_URL_sub=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_sub_problem.php";
                            API_URL_ALL.GET_JSON_insent_Problem_Inform_Master=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Master_Copy_real2.php";
                            API_URL_ALL.GET_JSON_insent_Problem_Inform_Master_new=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Master_Copy_real_new.php";

                            Log.e("itemitem",item);
                            MyApplication.getInstance().getPrefManager().setPreferrence("item_DATA", item);
                            MyApplication.getInstance().getPrefManager().setPreferrence("chaeck_save_data", "0");


                            linear_gory2.setVisibility(View.GONE);
                            //SELECT_DATA_PROBLEM_MAIN();
                        }
                        else if(item.equals("ปัญหาการ์ดค่างวด")){
                            API_URL_ALL.GET_JSON_DATA_HTTP_URL_INSENT_DATA_SALE=BASE_URL+"assanee/api_report_problem_from_contno/report_promlem_contno.php";
                            API_URL_ALL.GET_JSON_DATA_HTTP_URL_main=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_main_problem.php";
                            API_URL_ALL.GET_JSON_DATA_HTTP_URL_sub=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_sub_problem.php";
                            API_URL_ALL.GET_JSON_insent_Problem_Inform_Master=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Master_Copy_real2.php";
                            API_URL_ALL.GET_JSON_insent_Problem_Inform_Master_new=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Master_Copy_real_new.php";

                            Log.e("itemitem",item);
                            MyApplication.getInstance().getPrefManager().setPreferrence("item_DATA", item);
                            MyApplication.getInstance().getPrefManager().setPreferrence("chaeck_save_data", "0");

                            linear_gory2.setVisibility(View.GONE);
                            //SELECT_DATA_PROBLEM_MAIN();
                        }
                        else if(item.equals("ปัญหาอื่นๆ")){
                            API_URL_ALL.GET_JSON_DATA_HTTP_URL_INSENT_DATA_SALE=BASE_URL+"assanee/api_report_problem_from_contno/report_promlem_contno3.php";
                            API_URL_ALL.GET_JSON_DATA_HTTP_URL_main=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_main_problem2.php";
                            API_URL_ALL.GET_JSON_DATA_HTTP_URL_sub=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_sub_problem2.php";
                            API_URL_ALL.GET_JSON_insent_Problem_Inform_Master=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Master_Copy_real2_2.php";
                            API_URL_ALL.GET_JSON_insent_Problem_Inform_Master_new=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Master_Copy_real_new_2.php";

                            Log.e("itemitem",item);
                            MyApplication.getInstance().getPrefManager().setPreferrence("item_DATA", item);
                            MyApplication.getInstance().getPrefManager().setPreferrence("chaeck_save_data", "0");

                            linear_gory2.setVisibility(View.VISIBLE);
                            SELECT_DATA_PROBLEM_GORY2();


                        }
                        else {
                            API_URL_ALL.GET_JSON_DATA_HTTP_URL_INSENT_DATA_SALE=BASE_URL+"assanee/api_report_problem_from_contno/report_promlem_contno3.php";
                            API_URL_ALL.GET_JSON_DATA_HTTP_URL_main=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_main_problem2.php";
                            API_URL_ALL.GET_JSON_DATA_HTTP_URL_sub=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_sub_problem2.php";

                            API_URL_ALL.GET_JSON_insent_Problem_Inform_Master=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Master_Copy_real2_2.php";
                            API_URL_ALL.GET_JSON_insent_Problem_Inform_Master_new=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Master_Copy_real_new_2.php";

                            Log.e("itemitem",item);
                            MyApplication.getInstance().getPrefManager().setPreferrence("item_DATA", item);
                            MyApplication.getInstance().getPrefManager().setPreferrence("chaeck_save_data", "0");

                            linear_gory2.setVisibility(View.VISIBLE);
                            SELECT_DATA_PROBLEM_GORY2();


                        }
                    }

                }
                catch (Exception r){

                }



                //tatus_Shortcut="0";
                //edittext_se.setText("");

                Log.e("gory",item);
                final GetData_select_topic_problem_gory contact = getData_select_topic_problem_gories.get(position);
                 ID_GORY= contact.getProblemID();
                getData_select_topic_problem_mains.clear();

                SELECT_DATA_PROBLEM_MAIN();



                //Toast.makeText(parent.getContext(), "Selected Item: " + item, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });









    }


    String item2="";
    public void SELECT_DATA_PROBLEM_GORY2() {

        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_gory_2 ,


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

   // String ID_GORY2="";
    public void JSON_PARSE_DATA_AFTER_SELECT_DATA_PROBLEM_GORY2(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            final GetData_select_topic_problem_gory2 GetDataAdapter2 = new GetData_select_topic_problem_gory2();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                GetDataAdapter2.setProblemID(json.getString("ProblemID"));
                GetDataAdapter2.setProblemName(json.getString("ProblemName"));



            } catch (JSONException e) {

                e.printStackTrace();
            }
            getData_select_topic_problem_gories2.add(GetDataAdapter2);
            // value=GetDataAdapter2.getProblemName();
        }
        String[] array2 = new String[getData_select_topic_problem_gories2.size()];
        String[] array3 = new String[getData_select_topic_problem_gories2.size()];
        int i;
        ArrayAdapter<String> adapter = null ;

        for ( i = 0; i < getData_select_topic_problem_gories2.size(); i++) {
            final GetData_select_topic_problem_gory2 contact = getData_select_topic_problem_gories2.get(i);
            array2[i]= contact.getProblemName();

            Log.e("SSSS",array2[i]);

            //array2=getData_select_topic_problem_gories.;
            try {
                adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, android.R.id.text1, array2);
                //adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, android.R.id.text1, array2);
            }
            catch (Exception ex){

            }

        }




        // ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1, android.R.id.text1,getData_select_topic_problem_gories);



        spDemo_2.setAdapter(adapter);

        spDemo_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item2 = parent.getItemAtPosition(position).toString();
                if(item2.equals("อื่นๆ")){
                    spDemo2.setVisibility(View.GONE);
                    spDemo3.setVisibility(View.GONE);
                    linearlayout_show_problem_main.setVisibility(View.GONE);
                    linearlayout_show_problem_sub.setVisibility(View.GONE);
                    linear_topic_other.setVisibility(View.VISIBLE);
                    select_status_non();
                }
                else {
                    spDemo2.setVisibility(View.VISIBLE);
                    spDemo3.setVisibility(View.VISIBLE);
                    linearlayout_show_problem_main.setVisibility(View.VISIBLE);
                    linearlayout_show_problem_sub.setVisibility(View.VISIBLE);
                    linear_topic_other.setVisibility(View.GONE);
                }





                //tatus_Shortcut="0";
                //edittext_se.setText("");

                Log.e("gory2",item2);
                final GetData_select_topic_problem_gory2 contact = getData_select_topic_problem_gories2.get(position);
                ID_GORY= contact.getProblemID();
                getData_select_topic_problem_mains.clear();
                SELECT_DATA_PROBLEM_MAIN();



                //Toast.makeText(parent.getContext(), "Selected Item: " + item, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }



    public void SELECT_DATA_PROBLEM_MAIN() {

        Log.e("subsub_0",API_URL_ALL.GET_JSON_DATA_HTTP_URL_main+"?ProblemID="+ID_GORY);
        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_main+"?ProblemID="+ID_GORY ,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_SELECT_DATA_PROBLEM_MAIN(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

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

    String ID_MAIN="";
    public void JSON_PARSE_DATA_AFTER_SELECT_DATA_PROBLEM_MAIN(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            final GetData_select_topic_problem_main GetDataAdapter2 = new GetData_select_topic_problem_main();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                GetDataAdapter2.setProblemID(json.getString("ProblemID"));
                GetDataAdapter2.setProblemName(json.getString("ProblemName"));



            } catch (JSONException e) {

                e.printStackTrace();
            }
            getData_select_topic_problem_mains.add(GetDataAdapter2);
            // value=GetDataAdapter2.getProblemName();
        }





        String[] array2 = new String[getData_select_topic_problem_mains.size()];

        //int i;
        ArrayAdapter<String> adapter = null ;

        for ( int i = 0; i < getData_select_topic_problem_mains.size(); i++) {
            final GetData_select_topic_problem_main contact = getData_select_topic_problem_mains.get(i);
            array2[i]= contact.getProblemName();

            try {
                adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, android.R.id.text1, array2);

            }
            catch (Exception ex){

            }

        }

        spDemo2.setAdapter(adapter);

        spDemo2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();

                try {
                    final GetData_select_topic_problem_main contact = getData_select_topic_problem_mains.get(position);
                    ID_MAIN= contact.getProblemID();

                }
                catch (Exception ex){

                }




                getData_select_topic_problem_subs.clear();

               // Log.e("idididmain",ID_MAIN);

                SELECT_DATA_PROBLEM_SUB();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }






    public void SELECT_DATA_PROBLEM_SUB() {

        Log.e("subsub",API_URL_ALL.GET_JSON_DATA_HTTP_URL_sub+"?ProblemID="+ID_MAIN);

        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_sub+"?ProblemID="+ID_MAIN ,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_SELECT_DATA_PROBLEM_SUB(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

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


String ID_SUB="";
    public void JSON_PARSE_DATA_AFTER_SELECT_DATA_PROBLEM_SUB(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            final GetData_select_topic_problem_sub GetDataAdapter2 = new GetData_select_topic_problem_sub();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                GetDataAdapter2.setProblemID(json.getString("ProblemID"));
                GetDataAdapter2.setProblemName(json.getString("ProblemName"));



            } catch (JSONException e) {

                e.printStackTrace();
            }
            getData_select_topic_problem_subs.add(GetDataAdapter2);
            // value=GetDataAdapter2.getProblemName();
        }





        String[] array2 = new String[getData_select_topic_problem_subs.size()];

        //int i;
        ArrayAdapter<String> adapter = null ;

        for ( int i = 0; i < getData_select_topic_problem_subs.size(); i++) {
            final GetData_select_topic_problem_sub contact = getData_select_topic_problem_subs.get(i);
            array2[i]= contact.getProblemName();
            try {
                adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, android.R.id.text1, array2);
            }
            catch (Exception ex){

            }


        }

        spDemo3.setAdapter(adapter);

        spDemo3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String problem_sub = parent.getItemAtPosition(position).toString();
                details_problem_nonti_to_web=problem_sub;
               final GetData_select_topic_problem_sub contact = getData_select_topic_problem_subs.get(position);

                if(item.equals("อื่นๆ")){
                    ID_SUB= "0";
                    MyApplication.getInstance().getPrefManager().setPreferrence("ID_SUB", ID_SUB);
                    status_Shortcut="0";
                    SELECT_DATA_PROBLEM_DETAILS();
                    select_status_non();
                }
                else {
                    ID_SUB= contact.getProblemID();
                    MyApplication.getInstance().getPrefManager().setPreferrence("ID_SUB", ID_SUB);

                    status_Shortcut="0";
                    SELECT_DATA_PROBLEM_DETAILS();
                    select_status_non();

                }


            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });










    }




    public void SELECT_DATA_PROBLEM_DETAILS() {
        if(item.equals("อื่นๆ")){
            ID_SUB= "0";

        }
        else {
            if (status_Shortcut.equals("1")) {
                ID_SUB = ID_PROMLEM_NUMBER;

            } else if (status_Shortcut.equals("2")) {
                ID_SUB = MyApplication.getInstance().getPrefManager().getPreferrence("ID_SUB_ALL");
                ;
            } else {
                ID_SUB = MyApplication.getInstance().getPrefManager().getPreferrence("ID_SUB");
            }
        }
        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_details+"?ProblemID="+ID_SUB ,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_SELECT_DATA_PROBLEM_DETAILS(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

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
    String DETAILS="";
    public void JSON_PARSE_DATA_AFTER_SELECT_DATA_PROBLEM_DETAILS(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            final GetData_select_topic_problem_sub GetDataAdapter2 = new GetData_select_topic_problem_sub();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                DETAILS=json.getString("ProblemDetail");

            } catch (JSONException e) {

                e.printStackTrace();
            }

        }


        new_message_db.setText(DETAILS);


    }













    public void select_status_non() {
        Log.e("item_select_status_non",item);
        if(item.equals("อื่นๆ")){
            ID_SUB= "0";

        }
        else {
            if (status_Shortcut.equals("1")) {
                ID_SUB = ID_PROMLEM_NUMBER;

            } else if (status_Shortcut.equals("2")) {
                ID_SUB = MyApplication.getInstance().getPrefManager().getPreferrence("ID_SUB_ALL");
                ;
            } else {
                ID_SUB = MyApplication.getInstance().getPrefManager().getPreferrence("ID_SUB");
            }
        }

        Log.e("url",API_URL_ALL.GET_JSON_DATA_HTTP_URL_select_status_non+"?contno="+inputText.getText().toString()+"&ProblemID="+ID_SUB);
        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_select_status_non+"?contno="+inputText.getText().toString()+"&ProblemID="+ID_SUB ,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.e("response", String.valueOf(response));
                        JSON_PARSE_DATA_AFTER_WEBCALL_select_status_non(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

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


    int s;
    String check_date_create_credit="";
    public void JSON_PARSE_DATA_AFTER_WEBCALL_select_status_non(JSONArray array) {
s=array.length();
Log.e("sasasasafa", String.valueOf(s));

                    if(item.equals("อื่นๆ")){
                        image_status.setBackgroundResource(R.drawable.ic_error_outline_white_24dp);
                        txt_status.setText("ยังไม่เคยเเจ้งป้ญหา");
                        linear_coler.setBackgroundResource(R.color.Plum);
                    }
                    else {
                        if (s == 0) {
                            image_status.setBackgroundResource(R.drawable.ic_error_outline_white_24dp);
                            txt_status.setText("ยังไม่เคยเเจ้งป้ญหา");
                            linear_coler.setBackgroundResource(R.color.Plum);

                        } else {

                            image_status.setBackgroundResource(R.drawable.ic_check_circle_white_24dp);
                            txt_status.setText("เคยแจ้งปัญหาแล้ว");
                            linear_coler.setBackgroundResource(R.color.base_gray_green);

                            select_id_from_Problem_Inform_Master2();
                        }
                    }
        for (int i = 0; i < array.length(); i++) {

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                String SS=json.getString("status_non");
                String ProblemTopic=json.getString("ProblemTopic");
                 check_date_create_credit=json.getJSONObject("date_create").getString("date");

                Log.e("create_credit",check_date_create_credit);
            } catch (JSONException e) {

                e.printStackTrace();
            }

        }











                try {
                    String date_now= Utils.getSystemDateTextMonth();
                    //Date oneWayTripDate;

                    SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    SimpleDateFormat output = new SimpleDateFormat("dd-MM-yyyy");
                    try {
                        oneWayTripDate = input.parse(check_date_create_credit);  // parse input
                        DATE_credit_problem=output.format(oneWayTripDate);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    Log.e("DATE_credit_problem",DATE_credit_problem);
                    Log.e("date_now",date_now);

                   if(DATE_credit_problem.indexOf(DATE_credit_problem) != -1) {
                        String arr2[] = DATE_credit_problem.split("-");
                        s4=arr2[0];
                        s5=arr2[1];
                        s6=arr2[2];
                        converted4=Integer.parseInt(s4);
                        converted6=Integer.parseInt(s6);
                    }

                    if(date_now.indexOf(date_now) != -1) {
                        String arr[] = date_now.split("-");
                        s1=arr[0];
                        s2=arr[1];
                        s3=arr[2];
                        converted1= Integer.parseInt(s1);
                        converted3= Integer.parseInt(s3);
                    }

                     data_date=   converted1-converted4;

                     Log.e("data", String.valueOf(data_date));
                    if((data_date+1<=7)&(s2.equals(s5))&(s3.equals(s6))){
                        date_real=1;
                        Log.e("okokok","okokok");
                    }
                    else{
                        date_real=0;
                        Log.e("errorerror","errorerror");
                    }

                }
                catch (Exception E){

                }








    }






















    public void SELECT_DATA_PROBLEM_SUB_ALL() {

        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_sub_all+"?ProblemID="+ID_MAIN ,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_SELECT_DATA_PROBLEM_SUB_ALL(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

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
    String ID_SUB_ALL="",SUB_ALL_name_sub="",SUB_ALL_name_main="",SUB_ALL_name_gory="";
    public void JSON_PARSE_DATA_AFTER_SELECT_DATA_PROBLEM_SUB_ALL(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            final GetData_select_topic_problem_sub_all GetDataAdapter2 = new GetData_select_topic_problem_sub_all();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                GetDataAdapter2.setProblemID(json.getString("ProblemID"));
                GetDataAdapter2.setProblemCode(json.getString("ProblemCode"));
                GetDataAdapter2.setProblemName(json.getString("ProblemName"));

                GetDataAdapter2.setName_main(json.getString("name_main"));
                GetDataAdapter2.setName_gory(json.getString("name_gory"));



            } catch (JSONException e) {

                e.printStackTrace();
            }
            getData_select_topic_problem_sub_alls.add(GetDataAdapter2);
            // value=GetDataAdapter2.getProblemName();
        }





        String[] array2 = new String[getData_select_topic_problem_sub_alls.size()];

        //int i;
        ArrayAdapter<String> adapter = null ;

        for ( int i = 0; i < getData_select_topic_problem_sub_alls.size(); i++) {
            final GetData_select_topic_problem_sub_all contact = getData_select_topic_problem_sub_alls.get(i);
            array2[i]= contact.getProblemName();
            try {
                adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, android.R.id.text1, array2);
            }
            catch (Exception ex){

            }


        }

        spDemo4.setAdapter(adapter);

        spDemo4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                   String item2 = parent.getItemAtPosition(position).toString();
                final GetData_select_topic_problem_sub_all contact = getData_select_topic_problem_sub_alls.get(position);
                status_Shortcut="2";
                ID_SUB_ALL=contact.getProblemID();
                SUB_ALL_name_sub=contact.getProblemName();
                SUB_ALL_name_main=contact.getName_main();
                SUB_ALL_name_gory=contact.getName_gory();

                MyApplication.getInstance().getPrefManager().setPreferrence("ID_SUB_ALL", ID_SUB_ALL);
                Log.e("item_ID_SUB",ID_SUB_ALL);
                item="";

                SELECT_DATA_PROBLEM_DETAILS();
                select_status_non();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }








    String ID_SUB_NEW="";
    public void select_id_from_Problem_Inform_Master2(){
String EMPID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

        if(status_Shortcut.equals("1")){
            ID_SUB_NEW=ID_PROMLEM_NUMBER;

        }
        else if(status_Shortcut.equals("2")){
            ID_SUB_NEW=MyApplication.getInstance().getPrefManager().getPreferrence("ID_SUB_ALL");;
        }
        else {
            ID_SUB_NEW=MyApplication.getInstance().getPrefManager().getPreferrence("ID_SUB");
        }



        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_select_id_from_Problem_Inform_Master_new+"?EMPID="+EMPID+"&contno="+MyApplication.getInstance().getPrefManager().getPreferrence("getCONTNO")+"&ProblemID="+ID_SUB_NEW,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSON_PARSE_DATA_AFTER_select_id_from_Problem_Inform_Master2(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });


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


        requestQueue.add(jsonArrayRequest);
    }
    String InformID_NEW="",InformIDRef="",Informitem="",Informitem_NEW;
    int Informitem_new=0;
    public void JSON_PARSE_DATA_AFTER_select_id_from_Problem_Inform_Master2(JSONArray array) {
        for (int i = 0; i < array.length(); i++) {

            //final GetData_select_topic_problem_sub GetDataAdapter2 = new GetData_select_topic_problem_sub();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                // GetDataAdapter2.setProblemID(json.getString("InformID"));
                InformID_NEW= json.getString("InformID");
                Informitem= json.getString("Informitem");
            }
            catch (JSONException e) {

                e.printStackTrace();
            }
        }
        InformIDRef=InformID_NEW;

        if(Informitem.equals("null")){
            Informitem_NEW="1";
        }
        else {

            try {
                Informitem_new= Integer.parseInt(Informitem)+1;
                Informitem_NEW= String.valueOf(Informitem_new);
            }
            catch (Exception ex){

            }

        }
//        Log.e("Informitem_NEW",Informitem_NEW);
    }

















public  void select_image(){
    allSampleData.clear();
    SQLiteDataBaseBuild();
    SQLiteTableBuild();
    for (int i = 1; i <=1; i++) {

        SectionDataModel dm = new SectionDataModel();

        dm.setHeaderTitle("ล่าสุด ");

     //   ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();




        if(check_buttom_remove_image==1){
            cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper_image_buffer.TABLE_NAME+""  +" WHERE name_image ="+"'"+"2"+"'"   , null);
            if (cursor.moveToFirst()) {
                do {

                    String FA=cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                    Log.e("A", FA);

                    // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                    String f= String.valueOf(1);
                    singleItem.add(new SingleItemModel("รูป "+f,FA));


                } while (cursor.moveToNext());
            }
            cursor.close();
        }

else {
            cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper_image_buffer.TABLE_NAME+""   , null);

            if (cursor.moveToFirst()) {
                do {

                    String FA=cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                    Log.e("A", FA);

                    // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                    String f= String.valueOf(1);
                    singleItem.add(new SingleItemModel("รูป "+f,FA));


                } while (cursor.moveToNext());
            }
            cursor.close();
        }


         size = singleItem.size();
        Log.e("size", String.valueOf(size));
        dm.setAllItemsInSection(singleItem);

        allSampleData.add(dm);


    }


    RecyclerViewDataAdapter5 adapter = new RecyclerViewDataAdapter5(getActivity(), allSampleData);
    my_recycler_view.setAdapter(adapter);


}


    public void createDummyData(JSONArray array) {





        for (int i = 1; i <=1; i++) {

            SectionDataModel dm = new SectionDataModel();

            dm.setHeaderTitle("ล่าสุด ");

            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();



            for (int j = 0; j < array.length(); j++) {

                final DATA_mp3 GetDataAdapter2 = new DATA_mp3();
                JSONObject json = null;
                try {

                    json = array.getJSONObject(j);

                    GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                  //  String f= String.valueOf(j+1);
                   // singleItem.add(new SingleItemModel("รูป "+f,GetDataAdapter2.getMp3_thumbnail_s2()));

                    Log.e("CC",GetDataAdapter2.getMp3_thumbnail_s2());

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


        RecyclerViewDataAdapter5 adapter = new RecyclerViewDataAdapter5(getActivity(), allSampleData);
        my_recycler_view.setAdapter(adapter);
    }
    ImageConfiguration ic;
    Uri fileUri;
    Intent CamIntent,CropIntent;
    File file;
    int count_id,count_id2;
    String FA_FA="";
    String CHECK_IMAGE="";

    String Url="";
    String Image_Name="";
    String Image_Size="";
    String Image_Type="";
    String Image_id_item="";
    String part_id_details="";
    String Topic="";
    String ProblemDetai="";
    String edittext_size="";
    String ID_SUB_REAL="";
    String CHECK_contno="";
    MarshMallowPermission marshMallowPermission = new MarshMallowPermission(getActivity());

    @Override
    public void onClick(View view) {
        CHECK_contno = MyApplication.getInstance().getPrefManager().getPreferrence("getCONTNO")+"";
        if(view==r_save) {

            if((check!=0)|(!CHECK_contno.equals("null"))) {




            check_nonti_web = 0;
            savee.setVisibility(View.VISIBLE);
            String enteredText = new_message.getText().toString();
            //split string to get every word using _ (space) and add all word to an array
            String[] words = enteredText.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() < 1) {
                   new_message.setText("-");
                    break;
                } else {

                }
            }


            ID_SUB_REAL = ID_SUB;
            if (status_Shortcut.equals("1")) {
                ID_SUB = ID_PROMLEM_NUMBER;


            } else if (status_Shortcut.equals("2")) {
                ID_SUB = MyApplication.getInstance().getPrefManager().getPreferrence("ID_SUB_ALL");
                ;
            } else {
                ID_SUB = MyApplication.getInstance().getPrefManager().getPreferrence("ID_SUB");
            }


            Log.e("ID_SUB", ID_SUB);

            contno_save = MyApplication.getInstance().getPrefManager().getPreferrence("contno_save") + "";

            String strinputText = inputText.getText().toString();

            if (TextUtils.isEmpty(strinputText)) {
                inputText.setError("!กรุณาพิมพ์เลขที่สัญญา");


                // if((contno_save.equals("null"))|(contno_save.isEmpty())){
                long[] pattern = {0, 200, 500};
                Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                // Vibrate for 500 milliseconds
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    v.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    //deprecated in API 26
                    v.vibrate(200);
                    //v.vibrate(pattern , 1);
                    //v.vibrate(new long[] { 500, 500, 500 });

                }


                SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(getActivity(), SweetAlertDialog.ERROR_TYPE);
                sweetAlertDialog.setTitleText("เลขที่สัญญาไม่ถูกต้อง!");
                sweetAlertDialog.setContentText("*กรุณาลองใหม่อีกครั้ง*");
                sweetAlertDialog.setCancelable(true);
                sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {


                        Log.e("dialog", "ปิด dialog");
                        sDialog.dismissWithAnimation();
                    }
                });
                sweetAlertDialog.show();


            } else {


                edittext_size = String.valueOf(new_message.getTextSize());


                if (item.equals("อื่นๆ")) {

                    String strUserName = new_message.getText().toString();

                    if (TextUtils.isEmpty(strUserName)) {
                        new_message.setError("!กรุณาพิมพ์รายละเอียดปัญหาด้วย");
                        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.showSoftInput(new_message, InputMethodManager.SHOW_IMPLICIT);


                        Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            v.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                        } else {
                            v.vibrate(200);
                        }


                        //  new_message.setHint("!กรุณาพิมพ์รายละเอียดปัญหาด้วย");
                        // new_message.setHintTextColor(0xffff0000);

                        return;
                    } else {
                        ID_SUB = "0";
                        Cursor cursor_id = sqLiteDatabase.rawQuery("SELECT COUNT (*)  FROM " + SQLiteHelper_problem_id_image.TABLE_NAME + "" + " WHERE part_id =" + "'" + ID_SUB + "'", null);

                        if (cursor_id.moveToFirst()) {
                            do {
                                count_id = cursor_id.getInt(0);
                                Log.e("count_id", String.valueOf(count_id));

                            } while (cursor_id.moveToNext());
                        }
                        cursor_id.close();

                        if (count_id > 0) {


                            Log.e("ERROR", "มีข้อมูลอยุ่แล้ว");
                            Toast toast = Toast.makeText(getActivity(), "ปัญหานี้มีข้อมูลรอการเเจ้งแล้ว", Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            v.setTextColor(Color.RED);
                            toast.show();

                            //  Toast.makeText(getActivity(), "ปัญหานี้มีข้อมูลรอการเเจ้งแล้ว", Toast.LENGTH_SHORT).show();
                            return;
                        } else {


                            String Category = spDemo.getSelectedItem().toString() + "";
                            String Main_problems = "NULL";
                            String Sub_problems = "NULL";
                            String topic = new_message_topic_other.getText().toString();
                            String ProblemDetail = new_message.getText().toString();


                            // if (topic.isEmpty()) {


                            // } else {
                            //topic = new_message.getText().toString();
                            //}
                            String datetime = "";
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                            datetime = sdf.format(new Date());


                            SQLiteDataBaseBuild();
                            SQLiteTableBuild();

                            SQLiteDataBaseBuild2();
                            SQLiteTableBuild2();

                            if(check_buttom_remove_image==1) {
                                Cursor cursor_id2 = sqLiteDatabase.rawQuery("SELECT COUNT (*),url_image,Url,Image_Name,Image_Size,Image_Type,order_image FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                                if (cursor_id2.moveToFirst()) {
                                    do {
                                        count_id2 = cursor_id2.getInt(0);
                                        Log.e("count_id2", String.valueOf(count_id2));
                                        CHECK_IMAGE = cursor_id2.getString(cursor_id2.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image)) + "";

                                        Url = cursor_id2.getString(cursor_id2.getColumnIndex(SQLiteHelper_image_buffer.Table_Url)) + "";
                                        Image_Name = cursor_id2.getString(cursor_id2.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Name)) + "";
                                        Image_Size = cursor_id2.getString(cursor_id2.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Size)) + "";
                                        Image_Type = cursor_id2.getString(cursor_id2.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Type)) + "";
                                        Image_id_item = cursor_id2.getString(cursor_id2.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image)) + "";
                                    } while (cursor_id2.moveToNext());
                                }
                                cursor_id2.close();
                            }
                            else {
                                Cursor cursor_id2 = sqLiteDatabase.rawQuery("SELECT COUNT (*),url_image,Url,Image_Name,Image_Size,Image_Type,order_image  FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" + " WHERE part_id =" + "'" + ID_SUB + "'", null);

                                if (cursor_id2.moveToFirst()) {
                                    do {
                                        count_id2 = cursor_id2.getInt(0);
                                        Log.e("count_id2", String.valueOf(count_id2));
                                        CHECK_IMAGE = cursor_id2.getString(cursor_id2.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image)) + "";

                                        Url = cursor_id2.getString(cursor_id2.getColumnIndex(SQLiteHelper_image_buffer.Table_Url)) + "";
                                        Image_Name = cursor_id2.getString(cursor_id2.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Name)) + "";
                                        Image_Size = cursor_id2.getString(cursor_id2.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Size)) + "";
                                        Image_Type = cursor_id2.getString(cursor_id2.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Type)) + "";
                                        Image_id_item = cursor_id2.getString(cursor_id2.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image)) + "";
                                    } while (cursor_id2.moveToNext());
                                }
                                cursor_id2.close();
                            }

                /*
                if(count_id2>0){

                    Log.e("FA_FA","44444");

                    Log.e("ERROR","มีข้อมูลอยุ่แล้ว");
                    Toast toast = Toast.makeText(getActivity(), "ปัญหานี้มีข้อมูลรอการเเจ้งแล้ว", Toast.LENGTH_SHORT);
                    TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                    v.setTextColor(Color.RED);
                    toast.show();

                    //  Toast.makeText(getActivity(), "ปัญหานี้มีข้อมูลรอการเเจ้งแล้ว", Toast.LENGTH_SHORT).show();
                    return;
                }*/


                            // else {
                            if (CHECK_IMAGE.equals("null")) {
                                Log.e("CHECK_IMAGE", "no_image");
                                // String ProblemDetail2=new_message.getText().toString();
                                FA_FA = "null";
                                String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_problem_id_image.TABLE_NAME + " (part_id,part_image,Category,Main_problems,Sub_problems,topic,ProblemDetail,datetime,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + FA_FA + "','" + Category + "','" + Main_problems + "','" + Sub_problems + "','" + topic + "','" + ProblemDetail + "','" + datetime + "','" + Url + "','" + Image_Name + "','" + Image_Size + "','" + Image_Type + "','" + Image_id_item + "');";
                                sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);

                            } else {
                                Log.e("CHECK_IMAGE", "have_image");


                                if(check_buttom_remove_image==1) {
                                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                                    if (cursor.moveToFirst()) {
                                        do {

                                            FA_FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                                            Url = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Url));
                                            Image_Name = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Name));
                                            Image_Size = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Size));
                                            Image_Type = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Type));
                                            Image_Type = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Type));
                                            Image_id_item = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));

                                            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_problem_id_image.TABLE_NAME + " (part_id,part_image,Category,Main_problems,Sub_problems,topic,ProblemDetail,datetime,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + FA_FA + "','" + Category + "','" + Main_problems + "','" + Sub_problems + "','" + topic + "','" + ProblemDetail + "','" + datetime + "','" + Url + "','" + Image_Name + "','" + Image_Size + "','" + Image_Type + "','" + Image_id_item + "');";
                                            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);


                                            Log.e("rrrr", FA_FA);


                                        } while (cursor.moveToNext());
                                    }
                                    cursor.close();
                                }

                                else {

                                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "", null);

                                    if (cursor.moveToFirst()) {
                                        do {

                                            FA_FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                                            Url = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Url));
                                            Image_Name = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Name));
                                            Image_Size = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Size));
                                            Image_Type = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Type));
                                            Image_Type = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Type));
                                            Image_id_item = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));

                                            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_problem_id_image.TABLE_NAME + " (part_id,part_image,Category,Main_problems,Sub_problems,topic,ProblemDetail,datetime,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + FA_FA + "','" + Category + "','" + Main_problems + "','" + Sub_problems + "','" + topic + "','" + ProblemDetail + "','" + datetime + "','" + Url + "','" + Image_Name + "','" + Image_Size + "','" + Image_Type + "','" + Image_id_item + "');";
                                            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);


                                            Log.e("rrrr", FA_FA);


                                        } while (cursor.moveToNext());
                                    }
                                    cursor.close();
                                }





                            }


                            SELECT_DATA_PROBLEM_SQLITE_intro();

                        }

                    }


                } else {


                    String strUserName = new_message.getText().toString();

                    if (TextUtils.isEmpty(strUserName)) {
                        new_message.setError("!กรุณาพิมพ์รายละเอียดปัญหาด้วย");
                        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.showSoftInput(new_message, InputMethodManager.SHOW_IMPLICIT);


                        Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            v.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                        } else {
                            v.vibrate(200);
                        }


                        //  new_message.setHint("!กรุณาพิมพ์รายละเอียดปัญหาด้วย");
                        // new_message.setHintTextColor(0xffff0000);

                        return;
                    } else {


                        try {
                            Cursor cursor_id = sqLiteDatabase.rawQuery("SELECT COUNT (*)  FROM " + SQLiteHelper_problem_id_image.TABLE_NAME + "" + " WHERE part_id =" + "'" + ID_SUB + "'", null);

                            if (cursor_id.moveToFirst()) {
                                do {
                                    count_id = cursor_id.getInt(0);
                                    Log.e("count_id", String.valueOf(count_id));

                                } while (cursor_id.moveToNext());
                            }
                            cursor_id.close();
                        } catch (Exception EX) {

                        }


                        if (count_id > 0) {

                            // SQLiteDataBaseBuild2();
                            // SQLiteTableBuild2();
                            // sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_problem_id_image.TABLE_NAME+"");

                            //String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_problem_id_image.TABLE_NAME + " (part_id,part_image,Category,Main_problems,Sub_problems,topic,datetime) VALUES('" + ID_SUB + "','" + FA + "','" + Category + "','" + Main_problems + "','" + Sub_problems + "','" + topic + "','" + datetime + "');";
                            //sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
                            Log.e("ERROR", "มีข้อมูลอยุ่แล้ว");
                            Toast toast = Toast.makeText(getActivity(), "ปัญหานี้มีข้อมูลรอการเเจ้งแล้ว", Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            v.setTextColor(Color.RED);
                            toast.show();

                            //  Toast.makeText(getActivity(), "ปัญหานี้มีข้อมูลรอการเเจ้งแล้ว", Toast.LENGTH_SHORT).show();
                            return;
                        } else {


                            String Category = "";
                            String Main_problems = "";
                            String Sub_problems = "";
                            String topic = "";
                            String ProblemDetail = "";


                            if (status_Shortcut.equals("1")) {
                                Category = name_gory;
                                Main_problems = name_main;
                                Sub_problems = name_sub;
                                topic = "NULL";

                                //ProblemDetail = new_message.getText().toString().replace("[-\\\\[\\\\]^/,'*:.!><~@#$%+=?|\\\"\\\\\\\\()]+", "");
                                ProblemDetail = new_message.getText().toString();



                                Log.e("ProblemDetail555",ProblemDetail);
                            } else if (status_Shortcut.equals("2")) {
                                Sub_problems = SUB_ALL_name_sub;
                                Main_problems = SUB_ALL_name_main;
                                Category = SUB_ALL_name_gory;
                                topic = "NULL";


                                //ProblemDetail = new_message.getText().toString().replace("[-\\\\[\\\\]^/,'*:.!><~@#$%+=?|\\\"\\\\\\\\()]+", "");

                                ProblemDetail = new_message.getText().toString();

                                Log.e("ProblemDetail666",ProblemDetail);
                            } else {
                                Category = spDemo.getSelectedItem().toString();
                                Main_problems = spDemo2.getSelectedItem().toString();
                                try {
                                    Sub_problems = spDemo3.getSelectedItem().toString();
                                }
                                catch (Exception ex){

                                }

                                topic = "NULL";
                               // ProblemDetail = new_message.getText().toString().replace("[-\\\\[\\\\]^/,'*:.!><~@#$%+=?|\\\"\\\\\\\\()]+", "");
                                ProblemDetail = new_message.getText().toString();
                                Log.e("ProblemDetail777",ProblemDetail);
                            }




/*
                        if (topic.isEmpty()) {
                            topic = "NULL";

                        } else {
                            topic = new_message.getText().toString();
                        }
                        */
                            String datetime = "";
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                            datetime = sdf.format(new Date());


                            SQLiteDataBaseBuild();
                            SQLiteTableBuild();

                            SQLiteDataBaseBuild2();
                            SQLiteTableBuild2();

                            Log.e("ID_SUBFFF", ID_SUB);

                            if(check_buttom_remove_image==1) {
                                cursor = sqLiteDatabase.rawQuery("SELECT url_image,Url,Image_Name,Image_Size,Image_Type,order_image FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
                                if (cursor.moveToFirst()) {
                                    do {
                                        count_id2 = cursor.getInt(0);
                                        Log.e("count_id2", String.valueOf(count_id2));
                                        CHECK_IMAGE = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image)) + "";

                                        Url = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Url)) + "";
                                        Image_Name = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Name)) + "";
                                        Image_Size = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Size)) + "";
                                        Image_Type = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Type)) + "";
                                        Image_id_item = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image)) + "";

                                        Log.e("CHECK_IMAGEwwww_1", CHECK_IMAGE);
                                    } while (cursor.moveToNext());
                                }
                                cursor.close();
                            }
                            else {

                                cursor = sqLiteDatabase.rawQuery("SELECT url_image,Url,Image_Name,Image_Size,Image_Type,order_image  FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" + " WHERE part_id =" + "'" + ID_SUB + "'", null);

                                if (cursor.moveToFirst()) {
                                    do {
                                        count_id2 = cursor.getInt(0);
                                        Log.e("count_id2", String.valueOf(count_id2));
                                        CHECK_IMAGE = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image)) + "";

                                        Url = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Url)) + "";
                                        Image_Name = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Name)) + "";
                                        Image_Size = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Size)) + "";
                                        Image_Type = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Type)) + "";
                                        Image_id_item = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image)) + "";

                                        Log.e("CHECK_IMAGEwwww", CHECK_IMAGE);
                                    } while (cursor.moveToNext());
                                }
                                cursor.close();
                            }



                            // else {
                            if (CHECK_IMAGE.isEmpty()) {
                                Log.e("CHECK_IMAGE", "no_image");

                                FA_FA = "null";
                                String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_problem_id_image.TABLE_NAME + " (part_id,part_image,Category,Main_problems,Sub_problems,topic,ProblemDetail,datetime,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + FA_FA + "','" + Category + "','" + Main_problems + "','" + Sub_problems + "','" + topic + "','" + ProblemDetail + "','" + datetime + "','" + Url + "','" + Image_Name + "','" + Image_Size + "','" + Image_Type + "','" + Image_id_item + "');";
                                sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);

                            } else {
                                Log.e("CHECK_IMAGE", "have_image");


                                if(check_buttom_remove_image==1){
                                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper_image_buffer.TABLE_NAME+""  +" WHERE name_image ="+"'"+"2"+"'"   , null);
                                    if (cursor.moveToFirst()) {
                                        do {

                                            FA_FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                                            Url = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Url));
                                            Image_Name = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Name));
                                            Image_Size = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Size));
                                            Image_Type = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Type));
                                            Image_Type = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Type));
                                            Image_id_item = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));

                                            SQLiteDataBaseBuild2();
                                            SQLiteTableBuild2();
                                            Log.e("data", ID_SUB + FA_FA + Category + Main_problems + Sub_problems + topic + ProblemDetail + datetime + Url + Image_Name + Image_Size + Image_Type + Image_id_item);
                                            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_problem_id_image.TABLE_NAME + " (part_id,part_image,Category,Main_problems,Sub_problems,topic,ProblemDetail,datetime,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + FA_FA + "','" + Category + "','" + Main_problems + "','" + Sub_problems + "','" + topic + "','" + ProblemDetail + "','" + datetime + "','" + Url + "','" + Image_Name + "','" + Image_Size + "','" + Image_Type + "','" + Image_id_item + "');";
                                            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);


                                            Log.e("rrrr", FA_FA);


                                        } while (cursor.moveToNext());
                                    }
                                    cursor.close();
                                }

                                else {
                                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "", null);

                                    if (cursor.moveToFirst()) {
                                        do {

                                            FA_FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                                            Url = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Url));
                                            Image_Name = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Name));
                                            Image_Size = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Size));
                                            Image_Type = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Type));
                                            Image_Type = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_Image_Type));
                                            Image_id_item = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));

                                            SQLiteDataBaseBuild2();
                                            SQLiteTableBuild2();
                                            Log.e("data", ID_SUB + FA_FA + Category + Main_problems + Sub_problems + topic + ProblemDetail + datetime + Url + Image_Name + Image_Size + Image_Type + Image_id_item);
                                            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_problem_id_image.TABLE_NAME + " (part_id,part_image,Category,Main_problems,Sub_problems,topic,ProblemDetail,datetime,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + FA_FA + "','" + Category + "','" + Main_problems + "','" + Sub_problems + "','" + topic + "','" + ProblemDetail + "','" + datetime + "','" + Url + "','" + Image_Name + "','" + Image_Size + "','" + Image_Type + "','" + Image_id_item + "');";
                                            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);


                                            Log.e("rrrr", FA_FA);


                                        } while (cursor.moveToNext());
                                    }
                                    cursor.close();
                                }





                            }



                            SELECT_DATA_PROBLEM_SQLITE_intro();

                            Toast toast = Toast.makeText(getActivity(), "บันทึกรายการเสร็จสิ้น", Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            v.setTextColor(Color.GREEN);
                            toast.show();

                        }
                    }
                }

            }


        }
        else {

                SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(getActivity(), SweetAlertDialog.ERROR_TYPE);
                sweetAlertDialog.setTitleText("เลขที่สัญญาไม่ถูกต้อง!");
                sweetAlertDialog.setContentText("*กรุณาลองใหม่อีกครั้ง*");
                sweetAlertDialog.setCancelable(true);
                sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {


                        Log.e("dialog", "ปิด dialog");
                        sDialog.dismissWithAnimation();
                    }
                });
                sweetAlertDialog.show();

        }











        }
        else if(view==open_camera){
            checkCameraPermission();

          // Log.e("VersionOSM",VersionOSM);

            if((check!=0)|(!CHECK_contno.equals("null"))) {
                //checkCameraPermission();
                contno_save = MyApplication.getInstance().getPrefManager().getPreferrence("contno_save") + "";
               // Log.e("contno_real",contno_save);
                String strinputText = inputText.getText().toString();

                if (TextUtils.isEmpty(strinputText)) {
                    inputText.setError("!กรุณาพิมพ์เลขที่สัญญา");
                    //if((contno_save.equals("null"))|(contno_save.isEmpty())){
                    long[] pattern = {0, 200, 500};
                    Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        v.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                    } else {

                        v.vibrate(200);
                    }


                    SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(getActivity(), SweetAlertDialog.ERROR_TYPE);
                    sweetAlertDialog.setTitleText("เลขที่สัญญาไม่ถูกต้อง!");
                    sweetAlertDialog.setContentText("*กรุณาลองใหม่อีกครั้ง*");
                    sweetAlertDialog.setCancelable(true);
                    sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {


                            Log.e("dialog", "ปิด dialog");
                            sDialog.dismissWithAnimation();
                        }
                    });
                    sweetAlertDialog.show();

                } else {

                    try {
                        if ((VersionOSM.equals("5.0"))|(VersionOSM.equals("5.0.1"))|(VersionOSM.equals("5.0.2"))|(VersionOSM.equals("5.1.3"))|(VersionOSM.equals("5.1"))|(VersionOSM.equals("5.1.1"))|(VersionOSM.equals("5.1.0"))|(VersionOSM.equals("5.1.2"))) {
                            CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                            ic = new ImageConfiguration(getActivity(),PATH);
                            file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                                    "report_problem", "ALL");


                            fileUri = Uri.fromFile(file);
                            CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                            startActivityForResult(CamIntent, 1);
                        }/* else  if((VersionOSM.equals("6.0"))|(VersionOSM.equals("6.0.0"))|(VersionOSM.equals("6.0.1"))|(VersionOSM.equals("6.1"))|(VersionOSM.equals("6.1.0"))|(VersionOSM.equals("7.0"))|(VersionOSM.equals("7.0.0"))|(VersionOSM.equals("7.0.1"))|(VersionOSM.equals("7.1"))|(VersionOSM.equals("7.1.0"))|(VersionOSM.equals("7.1.1"))|(VersionOSM.equals("7.1.2"))|(VersionOSM.equals("8.0"))|(VersionOSM.equals("8.0.0"))|(VersionOSM.equals("8.1.0"))|(VersionOSM.equals("8.0"))|(VersionOSM.equals("8.1"))|(VersionOSM.equals("8.1.1"))|(VersionOSM.equals("9"))|(VersionOSM.equals("9.0"))|(VersionOSM.equals("9.0.0"))|(VersionOSM.equals("9.1"))|(VersionOSM.equals("9.1.0"))) {

                            if (!marshMallowPermission.checkPermissionForCamera()) {
                                marshMallowPermission.requestPermissionForCamera();


                            } else {
                                if (!marshMallowPermission.checkPermissionForExternalStorage()) {
                                    marshMallowPermission.requestPermissionForExternalStorage();
                                } else {

                                    CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                    //CamIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                                    ic = new ImageConfiguration(getActivity(), PATH);
                                    file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                                            "report_problem", "ALL");

                                    fileUri = FileProvider.getUriForFile(getActivity(),
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
/*                            CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                            ic = new ImageConfiguration(getActivity(),PATH);
                            file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                                    "report_problem", "ALL");

                            fileUri = FileProvider.getUriForFile(getActivity(),
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
                                    ic = new ImageConfiguration(getActivity(), PATH);
                                    file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                                            "report_problem", "ALL");

                                    fileUri = FileProvider.getUriForFile(getActivity(),
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

                            ic = new ImageConfiguration(getActivity(),PATH);
                            file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                                    "report_problem", "ALL");


                            fileUri = FileProvider.getUriForFile(getActivity(),
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

            }
            else {

                SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(getActivity(), SweetAlertDialog.ERROR_TYPE);
                sweetAlertDialog.setTitleText("เลขที่สัญญาไม่ถูกต้อง!");
                sweetAlertDialog.setContentText("*กรุณาลองใหม่อีกครั้ง*");
                sweetAlertDialog.setCancelable(true);
                sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {


                        Log.e("dialog", "ปิด dialog");
                        sDialog.dismissWithAnimation();
                    }
                });
                sweetAlertDialog.show();


            }









        }


        else if(view==open_image){
//            if((check!=0)|(!CHECK_contno.equals("null"))) {
                checkCameraPermission();

               // Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
              //  startActivityForResult(intent, 77);



                Intent intent    = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                //CamIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                ic = new ImageConfiguration(getActivity(), PATH);
                file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                        "report_problem", "ALL");

                fileUri = FileProvider.getUriForFile(getActivity(),
                        BuildConfig.APPLICATION_ID + ".provider",
                        file);
                // fileUri = Uri.fromFile(file);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                startActivityForResult(intent, 77);


//            } else {
//                SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(getActivity(), SweetAlertDialog.ERROR_TYPE);
//                sweetAlertDialog.setTitleText("เลขที่สัญญาไม่ถูกต้อง!");
//                sweetAlertDialog.setContentText("*กรุณาลองใหม่อีกครั้ง*");
//                sweetAlertDialog.setCancelable(true);
//                sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                    @Override
//                    public void onClick(SweetAlertDialog sDialog) {
//
//
//                        Log.e("dialog", "ปิด dialog");
//                        sDialog.dismissWithAnimation();
//                    }
//                });
//                sweetAlertDialog.show();
//            }
        }
        else if(view==switcher){
            Intent intent = new Intent(getActivity(), MainActivity_qr_report_problem.class);
            startActivityForResult(intent,80);

        }
        else if(view==switcher2){

            check_sale_contno = MyApplication.getInstance().getPrefManager().getPreferrence("check");
            if (!menuOpen) {

                if(error==0){
                    revealMenu();

                }
                else {
                    revealMenu2();
                }




            } else {
                if(error==0){
                    hideMenu();

                }
                else {
                    hideMenu2();

                }





            }

            //linear_sale1.setVisibility(View.VISIBLE);

            /*
            final Dialog dialog = new Dialog(getActivity());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.custom_dialog_data_sale);
            dialog.setCancelable(false);
            dialog.show();*/
        }

        else if(view==btn_report){

            if(count_checker_problem>0){

                for (int i = 0; i < getData_check_problems2.size(); i++) {
                    // getData_uploade_images.get(i);
                    GetData_check_problem2 contact = getData_check_problems2.get(i);
                     ProblemID_checker = contact.getProblemID();
                     Details_checker=contact.getMain_problems()+","+contact.getProblemDetail();
                     Topic_checker=contact.getSubject();

                    contno_checker=contact.getCONTNO();
                    ProcessTypeID_checker=contact.getProcessTypeID();

                    //Log.e("ProblemID_checker",ProblemID_checker);
                    MyApplication.getInstance().getPrefManager().setPreferrence("ProblemID_checker", ProblemID_checker);
                    INSENT_DATA_SALE_FOR_CHECKER();

                    if (check_nonti_web == 0) {
                        connectSocket2(ProblemID_checker,Details_checker);
                        check_nonti_web = 1;
                    } else {
                        try {
                            webSocketClient.close();
                        } catch (Exception e) {

                        }

                    }
                   // select_id_from_Problem_Inform_Master_for_checker();
                   // sent_nontification_to_web();
                    try {
                        pDialogg.dismiss();
                        pDialogg.cancel();
                    }
                    catch (Exception    EX){

                    }


                }



            }



            else {


                if (s > 0) {
                    if (date_real == 0) {
                        Log.e("แก้ได้", "แก้ได้");
                        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE);
                        sweetAlertDialog.setTitleText("ปัญหานี้เคยเเจ้งแล้ว!");
                        sweetAlertDialog.setContentText("คุณต้องการแจ้งใหม่หรือไม่ ?");
                        sweetAlertDialog.setCancelText("ไม่! ออก");
                        sweetAlertDialog.setConfirmText("ใช่! แจ้งใหม่");
                        sweetAlertDialog.setCancelable(true);
                        sweetAlertDialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {


                                Log.e("dialog", "ปิด dialog");
                                sDialog.dismissWithAnimation();


                            }
                        });

                        sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {

                                sDialog.dismissWithAnimation();


                                contno_save = MyApplication.getInstance().getPrefManager().getPreferrence("contno_save") + "";
                                if (getData_check_problems.size() == 0) {
                                    SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE);
                                    sweetAlertDialog.setTitleText("ไม่มีรายการปัญหา!");
                                    sweetAlertDialog.setContentText("*กรุณาบันทึกรายการ*");
                                    sweetAlertDialog.setCancelable(true);
                                    sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sDialog) {


                                            Log.e("dialog", "ปิด dialog");
                                            sDialog.dismissWithAnimation();
                                        }
                                    });
                                    sweetAlertDialog.show();
                                } else {
                                    String strinputText = inputText.getText().toString();

                                    if (TextUtils.isEmpty(strinputText)) {
                                        inputText.setError("!กรุณาพิมพ์เลขที่สัญญา");
                                        // if((contno_save.equals("null"))|(contno_save.isEmpty())){
                                        long[] pattern = {0, 200, 500};
                                        Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                            v.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                                        } else {

                                            v.vibrate(200);
                                        }


                                        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(getActivity(), SweetAlertDialog.ERROR_TYPE);
                                        sweetAlertDialog.setTitleText("เลขที่สัญญาไม่ถูกต้อง!");
                                        sweetAlertDialog.setContentText("*กรุณาลองใหม่อีกครั้ง*");
                                        sweetAlertDialog.setCancelable(true);
                                        sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                            @Override
                                            public void onClick(SweetAlertDialog sDialog) {


                                                Log.e("dialog", "ปิด dialog");
                                                sDialog.dismissWithAnimation();
                                            }
                                        });
                                        sweetAlertDialog.show();

                                    } else {

                                        select_id_from_Problem_Inform_Master_new();


                                        sent_nontification_to_web();


                                        getData_select_topic_problem_gories.clear();
                                        getData_select_topic_problem_mains.clear();
                                        getData_select_topic_problem_subs.clear();
                                        if (status_Shortcut.equals("1")) {
                                            SELECT_PROBLEM_FROM_NUMBER();
                                        } else if (status_Shortcut.equals("2")) {
                                            SELECT_DATA_PROBLEM_SUB_ALL();
                                        } else {
                                          //  SELECT_DATA_PROBLEM_GORY();
                                        }


                                    }


                                }


                                //sDialog.dismissWithAnimation();
                            }
                        });


                        sweetAlertDialog.show();
                    } else {
                        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE);
                        sweetAlertDialog.setTitleText("ปัญหานี้เคยเเจ้งแล้ว!");
                        sweetAlertDialog.setContentText("*แจ้งใหม่ได้หลัง 7 วัน*");
                        sweetAlertDialog.setCancelText("ไม่! ออก");
                        //   sweetAlertDialog.setConfirmText("ใช่! แจ้งใหม่");
                        sweetAlertDialog.setCancelable(true);
                        sweetAlertDialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {


                                Log.e("dialog", "ปิด dialog");
                                sDialog.dismissWithAnimation();


                            }
                        });
                        sweetAlertDialog.show();

                    }


                } else {
                    contno_save = MyApplication.getInstance().getPrefManager().getPreferrence("contno_save") + "";
                    if (getData_check_problems.size() == 0) {
                        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE);
                        sweetAlertDialog.setTitleText("ไม่มีรายการปัญหา!");
                        sweetAlertDialog.setContentText("*กรุณาบันทึกรายการ*");
                        sweetAlertDialog.setCancelable(true);
                        sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {


                                Log.e("dialog", "ปิด dialog");
                                sDialog.dismissWithAnimation();
                            }
                        });
                        sweetAlertDialog.show();
                    } else {
                        String strinputText = inputText.getText().toString();

                        if (TextUtils.isEmpty(strinputText)) {
                            inputText.setError("!กรุณาพิมพ์เลขที่สัญญา");
                            // if((contno_save.equals("null"))|(contno_save.isEmpty())){
                            long[] pattern = {0, 200, 500};
                            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                v.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                            } else {

                                v.vibrate(200);
                            }


                            SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(getActivity(), SweetAlertDialog.ERROR_TYPE);
                            sweetAlertDialog.setTitleText("เลขที่สัญญาไม่ถูกต้อง!");
                            sweetAlertDialog.setContentText("*กรุณาลองใหม่อีกครั้ง*");
                            sweetAlertDialog.setCancelable(true);
                            sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {


                                    Log.e("dialog", "ปิด dialog");
                                    sDialog.dismissWithAnimation();
                                }
                            });
                            sweetAlertDialog.show();

                        } else {

                            select_id_from_Problem_Inform_Master();


                            sent_nontification_to_web();

                            getData_select_topic_problem_gories.clear();
                            getData_select_topic_problem_mains.clear();
                            getData_select_topic_problem_subs.clear();
                            if (status_Shortcut.equals("1")) {
                                SELECT_PROBLEM_FROM_NUMBER();
                            } else if (status_Shortcut.equals("2")) {
                                SELECT_DATA_PROBLEM_SUB_ALL();
                            } else {
                               // SELECT_DATA_PROBLEM_GORY();
                            }


                        }


                    }
                }


                if (check_nonti_web == 0) {
                    connectSocket();
                    check_nonti_web = 1;
                } else {
                    try {
                        webSocketClient.close();
                    } catch (Exception e) {

                    }

                }


            }





        }

        else if(view==delete_problem_name){
            linear_problem.setVisibility(View.GONE);
            linear_gory.setVisibility(View.VISIBLE);
            linearlayout_show_problem_main.setVisibility(View.VISIBLE);
            linearlayout_show_problem_sub.setVisibility(View.VISIBLE);
            status_Shortcut="0";
            edittext_se.setText("");

        }

        else if(view==relativeLayout_check_net){
            Log.e("fffd","ddss");
            Intent intent = new Intent(Settings.ACTION_SETTINGS);
            // intent.setClassName("com.android.settings", "com.android.settings.wifi.WifiSettings");
            startActivityForResult(intent, 11);
        }

        else if(view==tesss){
            final Dialog dialog = new Dialog(getActivity());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.custom_dialog_data_sale2);
            dialog.setCancelable(true);
            TextView   read_btn= (TextView) dialog.findViewById(R.id.read_btn);

            read_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });


            dialog.show();
        }


    }


    private void openActivity(Class<?> cls) {

    }




    public void sent_nontification_to_web(){
        String EmpIDForm=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        String EmpIDTo="A40767";
        String WorkCode="00";
        Log.e("URL_NON_WEB",API_URL_ALL.GET_JSON_DATA_HTTP_URL_sent_nontification_to_web+"?EmpIDForm="+EmpIDForm+"&EmpIDTo="+EmpIDTo+"&WorkCode="+WorkCode);
    jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_DATA_HTTP_URL_sent_nontification_to_web+"?EmpIDForm="+EmpIDForm+"&EmpIDTo="+EmpIDTo+"&WorkCode="+WorkCode,


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



    String part_id="";
    String part_image="";
    String Category="";
    String Main_problems="";
    String Sub_problems="";
    String topic="";
    String NodeDetail="";
    String datetime="";

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

Log.e("image_final",data_image_to_qry);

            cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper_problem_id_image.TABLE_NAME+"" +" WHERE part_image ="+"'"+data_image_to_qry+"'"  , null);

            if (cursor.moveToFirst()) {
                do {



                    part_id=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_id));
                    part_image=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_image));
                    Category=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Category));
                    Main_problems=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Main_problems));
                    Sub_problems=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Sub_problems));
                    topic=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_topic));
                    NodeDetail=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_topic));
                    datetime=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_ProblemDetail));

                    Url=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Url));
                    Image_Name=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Image_Name));
                    Image_Size=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Image_Size));
                    Image_Type=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Image_Type));
                    Image_id_item=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_order_image));



                /* if(item.equals("ปัญหาอื่นๆ")){
                        INSENT_Problem_Inform_Details_Images2();
                    }
                    else {
                        INSENT_Problem_Inform_Details_Images();
                    }*/
                  INSENT_Problem_Inform_Details_Images();


                } while (cursor.moveToNext());
            }
            cursor.close();




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
                    /*Call<ResponseBody>*/ call = uploadService.uploadMultiFile(requestBody);

                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                            try {
                                pDialogg.dismiss();
                                select_check_sucess_all();

                            }
                            catch (Exception ex){

                            }



                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            pDialogg.dismiss();
                            pDialogg.cancel();
                            //  Log.d(TAG, "Error " + t.getMessage());

                            try {
                                finalThread.stop();
                            }
                            catch (Exception ex){

                            }




                            SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE);
                            sweetAlertDialog.setTitleText("ผิดพลาด!");
                            sweetAlertDialog.setContentText("*อัพโหลดข้อมูลไม่สำเร็จ กรุณาลองอีกครั้ง*");
                            sweetAlertDialog.setCancelable(false);
                            sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {

                                    Delete_data_credit();
                                    SQLiteDataBaseBuild2();
                                    SQLiteTableBuild2();
                                    sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_problem_id_image.TABLE_NAME+"");


                                    File dire= new File(Environment.getExternalStorageDirectory(), "/Android/data/com.tsr.tsrproblemreport/files/Pictures");
                                    Log.e("dire", String.valueOf(dire));
                                    new DirectoryCleaner(dire).clean();
                                    dire.delete();

                                    Log.e("dialog","ปิด dialog");
                                    sDialog.dismissWithAnimation();









                                    MyApplication.getInstance().getPrefManager().setPreferrence("getCONTNO","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getProductName","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getProductPrice","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getCustomerName","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getAddressall","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getEmpID","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getEmployeeName","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getPositionCode","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getPositionName","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getTeamHeadCode","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getTeamHeadName","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getTeamName","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getSupervisorHeadCode","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getSupervisorHeadName","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getSupervisorName","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getSubDepartmentHeadCode","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getSubDepartmentHeadName","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getSubDepartmentName","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getDepartmentHeadCode","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getDepartmentHeadName","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getDepartmentName","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getSubTeamCode","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getTeamCode","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getPicture","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getInformID","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getContno_nontification_problem","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getInformEmpID","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getInformDepartID","null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getOutstanding", "null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getCustomerStatus", "null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getAccountStatus", "null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getPayLastPeriod", "null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getCashTeamCCode", "null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("getCashTeamACode", "null");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("contno_save", "");
                                    MyApplication.getInstance().getPrefManager().setPreferrence("check", "null");
                                    check_sucess_insert_master=0;
                                    check_sucess_insert_details=0;
                                    check_sucess_insert_image=0;
                                    check_buttom_remove_image=0;
                                    size_image=0;
                                    InformID_M="null";
                                    InformID_D="null";
                                    hideMenu();
                                    hideMenu2();
                                    switcher2.setVisibility(View.GONE);
                                    lenear_custommer_other.setVisibility(View.GONE);
                                    linear_status.setVisibility(View.GONE);
                                    inputText.setText("");
                                    inputText.clearAnimation();
                                    count_problem.setText("0" + " รายการ");
                                 //   is = String.valueOf(0);

                                    File file = new File("/storage/sdcard0/Android/data/com.tsr.tsrproblemreport/files/Pictures/70102489/report_problem/ID1/image_error/image_error_20180406070126-1473976226.jpg");
                                    double length = file.length();
                                    length = length / 1024;

                                    Log.e("imageName", file.getPath() + ", File size : " + length + " KB");
                                    getData_uploade_images.clear();
                                    pDialogg.dismiss();
                                    pDialogg.cancel();

                                    getData_check_problems.clear();  //เคลียร์ recycle problem real
                                    adapter2.notifyDataSetChanged();

                                    try {
                                        pDialogg.dismiss();
                                        pDialogg.cancel();
                                    }
                                    catch (Exception ex){

                                    }
                                }
                            });
                            sweetAlertDialog .show();




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





    //String GET_JSON_insent_Problem_Inform_Details_for_checker="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Details_Copy_real_for_checker.php";




    //
    //





    public void select_id_from_Problem_Inform_Master(){


            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_select_id_from_Problem_Inform_Master,


                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            JSON_PARSE_DATA_AFTER_select_id_from_Problem_Inform_Master(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });


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
    public void select_id_from_Problem_Inform_Master_for_checker(){


        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_select_id_from_Problem_Inform_Master,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSON_PARSE_DATA_AFTER_select_id_from_Problem_Inform_Master_for_checker(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });


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
    public void select_id_from_Problem_Inform_Master_for_checker2(){


        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_select_id_from_Problem_Inform_Master,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSON_PARSE_DATA_AFTER_select_id_from_Problem_Inform_Master_for_checker2(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });


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
    public void select_id_from_Problem_Inform_Master_new(){


        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_select_id_from_Problem_Inform_Master,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSON_PARSE_DATA_AFTER_select_id_from_Problem_Inform_Master_new(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });


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


    public void select_id_from_Problem_Inform_Master_new2(){


        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_select_id_from_Problem_Inform_Master,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSON_PARSE_DATA_AFTER_select_id_from_Problem_Inform_Master_new2(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });


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




    String InformID="";
    String InformID_REAL="";
    int count_id_inform=0;
    public void JSON_PARSE_DATA_AFTER_select_id_from_Problem_Inform_Master(JSONArray array) {
        count_id_inform=array.length();
        if(count_id_inform==0){
//Log.e("jjjjjjjjjj","00000");
            InformID=converted_dateThai+dateThai_month+"000001";

           // InformID=
        }
        //Log.e("gggggg","11111");
        for (int i = 0; i < array.length(); i++) {

            //final GetData_select_topic_problem_sub GetDataAdapter2 = new GetData_select_topic_problem_sub();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
               // GetDataAdapter2.setProblemID(json.getString("InformID"));
                 InformID=json.getString("InformID");
                // MyApplication.getInstance().getPrefManager().setPreferrence("InformID", InformID);

                Log.e("InformID_intro",InformID);

                //Log.e("jjjjjjjjjj","jjjjjjjjjj");

            } catch (JSONException e) {

                e.printStackTrace();
            }
            //getData_select_topic_problem_subs.add(GetDataAdapter2);
            // value=GetDataAdapter2.getProblemName();
        }



        InformID_REAL=InformID;


        Cursor cursor_id = sqLiteDatabase.rawQuery("SELECT DISTINCT part_id,topic,ProblemDetail  FROM " + SQLiteHelper_problem_id_image.TABLE_NAME, null);

        if (cursor_id.moveToFirst()) {
            do {
                part_id_details = cursor_id.getString(cursor_id.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_id));
                Topic= cursor_id.getString(cursor_id.getColumnIndex(SQLiteHelper_problem_id_image.Table_topic));
                ProblemDetai= cursor_id.getString(cursor_id.getColumnIndex(SQLiteHelper_problem_id_image.Table_ProblemDetail));
                //Log.e("ProblemDetai", ProblemDetai);


                INSENT_Problem_Master();
              //  select_id_from_Problem_Inform_Master();





                String item_DATA=MyApplication.getInstance().getPrefManager().getPreferrence("item_DATA");

                if(item_DATA.equals("ปัญหาอื่นๆ")){

                 //   if (item.equals("ปัญหาอื่นๆ")) {
                        INSENT_Problem_Details2();

                    } else {
                        INSENT_Problem_Details();
                    if(item_DATA.equals("ปัญหาการ์ดตรวจสอบ")){

                      //  if (item.equals("ปัญหาการ์ดตรวจสอบ")) {
                            insert_log_problem();
                        }


                    }




                Log.i("zzz","zzz");



            } while (cursor_id.moveToNext());
        }
        cursor_id.close();





        cursor = sqLiteDatabase.rawQuery("SELECT *  FROM " + SQLiteHelper_problem_id_image.TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                GetData_uploade_Image getData_uploade_image = new GetData_uploade_Image();
                String part_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_image));
                String part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_id));
               // Log.e("oooo", part_image);
                if (!part_image.equals("null")) {
                    getData_uploade_image.setImage(part_image);
                    getData_uploade_image.setPart_id(part_id);

                    getData_uploade_images.add(getData_uploade_image);
                }


            } while (cursor.moveToNext());
        }
        cursor.close();







        cursor = sqLiteDatabase.rawQuery("SELECT *  FROM " + SQLiteHelper_problem_id_image.TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                GetData_uploade_Image getData_uploade_image = new GetData_uploade_Image();
                String part_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_image));
                String part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_id));
                Log.e("oooo", part_image);
                if (!part_image.equals("null")) {
                    getData_uploade_image.setImage(part_image);
                    getData_uploade_image.setPart_id(part_id);

                    getData_uploade_images.add(getData_uploade_image);
                }


            } while (cursor.moveToNext());
        }
        cursor.close();








        VersionOS= Build.VERSION.RELEASE;


        try {
            if(VersionOS.equals("64.0")){

                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

                // Change base URL to your upload server URL.
                uploadService = new Retrofit.Builder()
                        .baseUrl(SERVER_PATH)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(Service.class);

                progressDialog = new ProgressDialog(getActivity());
                progressDialog.setMessage("กำลังอัปโหลด...");
                uploadMultiFile();
            }
            else {
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


                pDialogg = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
                pDialogg.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                pDialogg.setTitleText("กำลังอัปโหลด...");
                pDialogg.setCancelable(false);
                uploadMultiFile();
            }

        }
        catch (Exception ex){

        }












        //INSENT_Problem_Master();

    }




    public void JSON_PARSE_DATA_AFTER_select_id_from_Problem_Inform_Master_for_checker(JSONArray array) {
        count_id_inform=array.length();
        if(count_id_inform==0){
//Log.e("jjjjjjjjjj","00000");
            InformID=converted_dateThai+dateThai_month+"000001";

            // InformID=
        }
        //Log.e("gggggg","11111");
        for (int i = 0; i < array.length(); i++) {

            //final GetData_select_topic_problem_sub GetDataAdapter2 = new GetData_select_topic_problem_sub();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                // GetDataAdapter2.setProblemID(json.getString("InformID"));
                InformID=json.getString("InformID");
                // MyApplication.getInstance().getPrefManager().setPreferrence("InformID", InformID);

                //Log.e("InformID_intro",InformID);

                //Log.e("jjjjjjjjjj","jjjjjjjjjj");

            } catch (JSONException e) {

                e.printStackTrace();
            }
            //getData_select_topic_problem_subs.add(GetDataAdapter2);
            // value=GetDataAdapter2.getProblemName();
        }


        Log.e("InformID_checker",InformID);

        InformID_REAL=InformID;



       // for (int i = 0; i < 2; i++) {
            INSENT_Problem_Master_for_checker();
        INSENT_Problem_Details_for_checker();


       // }

    /*    for (int i = 0; i < getData_check_problems2.size(); i++) {
            // getData_uploade_images.get(i);
            GetData_check_problem2 contact = getData_check_problems2.get(i);
            ProblemID_checker = contact.getProblemID();
            Details_checker=contact.getMain_problems()+","+contact.getProblemDetail();
            Topic_checker=contact.getSubject();

            contno_checker=contact.getCONTNO();
            ProcessTypeID_checker=contact.getProcessTypeID();


            INSENT_Problem_Details_for_checker();


        }*/


















        VersionOS= Build.VERSION.RELEASE;


        try {
            if(VersionOS.equals("64.0")){

            }
            else {
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


                pDialogg = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
                pDialogg.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                pDialogg.setTitleText("กำลังอัปโหลด...");
                pDialogg.setCancelable(false);
                uploadMultiFile();


               // select_check_sucess_all();
                pDialogg.dismiss();
            }

        }
        catch (Exception ex){

        }



    }


    public void JSON_PARSE_DATA_AFTER_select_id_from_Problem_Inform_Master_for_checker2(JSONArray array) {
        count_id_inform=array.length();
        if(count_id_inform==0){
//Log.e("jjjjjjjjjj","00000");
            InformID=converted_dateThai+dateThai_month+"000001";

            // InformID=
        }
        //Log.e("gggggg","11111");
        for (int i = 0; i < array.length(); i++) {

            //final GetData_select_topic_problem_sub GetDataAdapter2 = new GetData_select_topic_problem_sub();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                // GetDataAdapter2.setProblemID(json.getString("InformID"));
                InformID=json.getString("InformID");
                // MyApplication.getInstance().getPrefManager().setPreferrence("InformID", InformID);

                //Log.e("InformID_intro",InformID);

                //Log.e("jjjjjjjjjj","jjjjjjjjjj");

            } catch (JSONException e) {

                e.printStackTrace();
            }
            //getData_select_topic_problem_subs.add(GetDataAdapter2);
            // value=GetDataAdapter2.getProblemName();
        }


        Log.e("InformID_checker",InformID);

        InformID_REAL=InformID;



        // for (int i = 0; i < 2; i++) {
        INSENT_Problem_Master_for_checker2();

        // }

        /*for (int i = 0; i < getData_check_problems2.size(); i++) {
            // getData_uploade_images.get(i);
            GetData_check_problem2 contact = getData_check_problems2.get(i);
            ProblemID_checker = contact.getProblemID();
            Details_checker=contact.getMain_problems()+","+contact.getProblemDetail();
            Topic_checker=contact.getSubject();

            contno_checker=contact.getCONTNO();
            ProcessTypeID_checker=contact.getProcessTypeID();





        }*/













/*




        VersionOS= MyApplication.getInstance().getPrefManager().getPreferrence("VersionOS");


        try {
            if(VersionOS.equals("64.0")){

            }
            else {
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


                pDialogg = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
                pDialogg.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                pDialogg.setTitleText("กำลังอัปโหลด...");
                pDialogg.setCancelable(false);
                uploadMultiFile();


                // select_check_sucess_all();
                pDialogg.dismiss();
            }

        }
        catch (Exception ex){

        }*/



    }

    public void JSON_PARSE_DATA_AFTER_select_id_from_Problem_Inform_Master_new(JSONArray array) {
        count_id_inform=array.length();
        if(count_id_inform==0){
            Log.e("jjjjjjjjjj","00000");
            InformID=converted_dateThai+dateThai_month+"000001";

            // InformID=
        }

        for (int i = 0; i < array.length(); i++) {

            //final GetData_select_topic_problem_sub GetDataAdapter2 = new GetData_select_topic_problem_sub();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                // GetDataAdapter2.setProblemID(json.getString("InformID"));
                InformID=json.getString("InformID");
                // MyApplication.getInstance().getPrefManager().setPreferrence("InformID", InformID);

                Log.e("InformID_intro",InformID);

                Log.e("jjjjjjjjjj","jjjjjjjjjj");

            } catch (JSONException e) {

                e.printStackTrace();
            }
            //getData_select_topic_problem_subs.add(GetDataAdapter2);
            // value=GetDataAdapter2.getProblemName();
        }



        InformID_REAL=InformID;


        Cursor cursor_id = sqLiteDatabase.rawQuery("SELECT DISTINCT part_id,topic,ProblemDetail  FROM " + SQLiteHelper_problem_id_image.TABLE_NAME, null);

        if (cursor_id.moveToFirst()) {
            do {
                part_id_details = cursor_id.getString(cursor_id.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_id));
                Topic= cursor_id.getString(cursor_id.getColumnIndex(SQLiteHelper_problem_id_image.Table_topic));
                ProblemDetai= cursor_id.getString(cursor_id.getColumnIndex(SQLiteHelper_problem_id_image.Table_ProblemDetail));
                Log.e("ProblemDetai", ProblemDetai);
                INSENT_Problem_Details();
                if (item.equals("ปัญหาการ์ดตรวจสอบ")) {
                    insert_log_problem();
                }
                INSENT_Problem_Master_new();


            } while (cursor_id.moveToNext());
        }
        cursor_id.close();

        cursor = sqLiteDatabase.rawQuery("SELECT *  FROM " + SQLiteHelper_problem_id_image.TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                GetData_uploade_Image getData_uploade_image = new GetData_uploade_Image();
                String part_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_image));
                String part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_id));
                Log.e("oooo", part_image);
                if (!part_image.equals("null")) {
                    getData_uploade_image.setImage(part_image);
                    getData_uploade_image.setPart_id(part_id);

                    getData_uploade_images.add(getData_uploade_image);
                }


            } while (cursor.moveToNext());
        }
        cursor.close();

        cursor = sqLiteDatabase.rawQuery("SELECT *  FROM " + SQLiteHelper_problem_id_image.TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                GetData_uploade_Image getData_uploade_image = new GetData_uploade_Image();
                String part_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_image));
                String part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_id));
                Log.e("oooo", part_image);
                if (!part_image.equals("null")) {
                    getData_uploade_image.setImage(part_image);
                    getData_uploade_image.setPart_id(part_id);

                    getData_uploade_images.add(getData_uploade_image);
                }


            } while (cursor.moveToNext());
        }
        cursor.close();








        VersionOS= Build.VERSION.RELEASE;


        try {
            if(VersionOS.equals("65.0")){

                /*
                SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(getActivity(), SweetAlertDialog.SUCCESS_TYPE);
                sweetAlertDialog.setTitleText("เสร็จสิ้น!");
                sweetAlertDialog.setContentText("*การเเจ้งปัญหา*");
                sweetAlertDialog.setCancelable(false);
                sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {

                        SQLiteDataBaseBuild2();
                        SQLiteTableBuild2();
                        sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_problem_id_image.TABLE_NAME+"");


                        File dire= new File(Environment.getExternalStorageDirectory(), "/Android/data/com.tsr.tsrproblemreport/files/Pictures");
                        Log.e("dire", String.valueOf(dire));
                        new DirectoryCleaner(dire).clean();
                        dire.delete();

                        Log.e("dialog","ปิด dialog");
                        sDialog.dismissWithAnimation();
                        getData_check_problems.clear();  //เคลียร์ recycle problem real
                        adapter2.notifyDataSetChanged();
                        if(check_nonti_web==0){
                            connectSocket();
                            check_nonti_web=1;
                        }
                        else {
                            webSocketClient.close();
                        }

                    }
                });
                sweetAlertDialog .show();
                */
              // Intent mIntent = new Intent( getActivity(), Upload_image.class);
              // startActivityForResult(mIntent,121);

                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

                // Change base URL to your upload server URL.
                uploadService = new Retrofit.Builder()
                        .baseUrl(SERVER_PATH)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(Service.class);

                progressDialog = new ProgressDialog(getActivity());
                progressDialog.setMessage("กำลังอัปโหลด...");
                uploadMultiFile();
            }
            else {
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

                // Change base URL to your upload server URL.
                uploadService = new Retrofit.Builder()
                        .baseUrl(SERVER_PATH)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(Service.class);


                pDialogg = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
                pDialogg.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                pDialogg.setTitleText("กำลังอัปโหลด...");
                pDialogg.setCancelable(false);
                uploadMultiFile();
            }

        }
        catch (Exception ex){

        }

    }


    public void JSON_PARSE_DATA_AFTER_select_id_from_Problem_Inform_Master_new2(JSONArray array) {
        count_id_inform=array.length();
        if(count_id_inform==0){
            Log.e("jjjjjjjjjj","00000");
            InformID=converted_dateThai+dateThai_month+"000001";

            // InformID=
        }

        for (int i = 0; i < array.length(); i++) {

            //final GetData_select_topic_problem_sub GetDataAdapter2 = new GetData_select_topic_problem_sub();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                // GetDataAdapter2.setProblemID(json.getString("InformID"));
                InformID=json.getString("InformID");
                // MyApplication.getInstance().getPrefManager().setPreferrence("InformID", InformID);

                Log.e("InformID_intro",InformID);

                Log.e("jjjjjjjjjj","jjjjjjjjjj");

            } catch (JSONException e) {

                e.printStackTrace();
            }
            //getData_select_topic_problem_subs.add(GetDataAdapter2);
            // value=GetDataAdapter2.getProblemName();
        }



        InformID_REAL=InformID;


        Cursor cursor_id = sqLiteDatabase.rawQuery("SELECT DISTINCT part_id,topic,ProblemDetail  FROM " + SQLiteHelper_problem_id_image.TABLE_NAME, null);

        if (cursor_id.moveToFirst()) {
            do {
                part_id_details = cursor_id.getString(cursor_id.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_id));
                Topic= cursor_id.getString(cursor_id.getColumnIndex(SQLiteHelper_problem_id_image.Table_topic));
                ProblemDetai= cursor_id.getString(cursor_id.getColumnIndex(SQLiteHelper_problem_id_image.Table_ProblemDetail));
                Log.e("ProblemDetai", ProblemDetai);
                INSENT_Problem_Details();
                if (item.equals("ปัญหาการ์ดตรวจสอบ")) {
                    insert_log_problem();
                }
                INSENT_Problem_Master_new();


            } while (cursor_id.moveToNext());
        }
        cursor_id.close();

        cursor = sqLiteDatabase.rawQuery("SELECT *  FROM " + SQLiteHelper_problem_id_image.TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                GetData_uploade_Image getData_uploade_image = new GetData_uploade_Image();
                String part_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_image));
                String part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_id));
                Log.e("oooo", part_image);
                if (!part_image.equals("null")) {
                    getData_uploade_image.setImage(part_image);
                    getData_uploade_image.setPart_id(part_id);

                    getData_uploade_images.add(getData_uploade_image);
                }


            } while (cursor.moveToNext());
        }
        cursor.close();

        cursor = sqLiteDatabase.rawQuery("SELECT *  FROM " + SQLiteHelper_problem_id_image.TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                GetData_uploade_Image getData_uploade_image = new GetData_uploade_Image();
                String part_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_image));
                String part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_id));
                Log.e("oooo", part_image);
                if (!part_image.equals("null")) {
                    getData_uploade_image.setImage(part_image);
                    getData_uploade_image.setPart_id(part_id);

                    getData_uploade_images.add(getData_uploade_image);
                }


            } while (cursor.moveToNext());
        }
        cursor.close();








        VersionOS= Build.VERSION.RELEASE;


        try {
            if(VersionOS.equals("65.0")){

                /*
                SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(getActivity(), SweetAlertDialog.SUCCESS_TYPE);
                sweetAlertDialog.setTitleText("เสร็จสิ้น!");
                sweetAlertDialog.setContentText("*การเเจ้งปัญหา*");
                sweetAlertDialog.setCancelable(false);
                sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {

                        SQLiteDataBaseBuild2();
                        SQLiteTableBuild2();
                        sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_problem_id_image.TABLE_NAME+"");


                        File dire= new File(Environment.getExternalStorageDirectory(), "/Android/data/com.tsr.tsrproblemreport/files/Pictures");
                        Log.e("dire", String.valueOf(dire));
                        new DirectoryCleaner(dire).clean();
                        dire.delete();

                        Log.e("dialog","ปิด dialog");
                        sDialog.dismissWithAnimation();
                        getData_check_problems.clear();  //เคลียร์ recycle problem real
                        adapter2.notifyDataSetChanged();
                        if(check_nonti_web==0){
                            connectSocket();
                            check_nonti_web=1;
                        }
                        else {
                            webSocketClient.close();
                        }

                    }
                });
                sweetAlertDialog .show();
                */
                // Intent mIntent = new Intent( getActivity(), Upload_image.class);
                // startActivityForResult(mIntent,121);

                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

                // Change base URL to your upload server URL.
                uploadService = new Retrofit.Builder()
                        .baseUrl(SERVER_PATH)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(Service.class);

                progressDialog = new ProgressDialog(getActivity());
                progressDialog.setMessage("กำลังอัปโหลด...");
                uploadMultiFile();
            }
            else {
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

                // Change base URL to your upload server URL.
                uploadService = new Retrofit.Builder()
                        .baseUrl(SERVER_PATH)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(Service.class);


                pDialogg = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
                pDialogg.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                pDialogg.setTitleText("กำลังอัปโหลด...");
                pDialogg.setCancelable(false);
                uploadMultiFile();
            }

        }
        catch (Exception ex){

        }

    }



    public   void INSENT_Problem_Details(){



        //String ProblemID=InformID;
        Log.e("InformID1",InformID);
        String ProblemTopic=Topic;
        String ProblemDetail=ProblemDetai;
        String CheckNote="NULL";
        String ProblemStatus="1";



        //jsonArrayRequest = new JsonArrayRequest(GET_JSON_insent_Problem_Inform_Details+"?InformID="+InformID_REAL+"&ProblemID="+part_id_details+"&ProblemTopic="+URLEncoder.encode(ProblemTopic, "UTF-8")+"&ProblemDetail="+URLEncoder.encode(ProblemDetail, "UTF-8")+"&CheckNote="+URLEncoder.encode(CheckNote, "UTF-8"),

        //url = "http://httpbin.org/post";
        StringRequest postRequest = new StringRequest(Request.Method.POST, API_URL_ALL.GET_JSON_insent_Problem_Inform_Details,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        check_sucess_insert_details=1;
                        // response
                        Log.e("Response", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        check_sucess_insert_details=0;
                        // error
                        //Log.d("Error.Response", response);
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("InformID", InformID_REAL);
                params.put("ProblemID",part_id_details);
                try {
                    params.put("ProblemTopic",URLDecoder.decode(ProblemTopic, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
              /*  try {
                    params.put("ProblemDetail",URLEncoder.encode(ProblemDetail, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }*/
                try {
                    params.put("ProblemDetail", URLDecoder.decode(ProblemDetail, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                try {
                    params.put("CheckNote", URLDecoder.decode(CheckNote, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                return params;
            }
        };
       // requestQueue.add(postRequest);

        try {
            try {
                requestQueue = Volley.newRequestQueue(getActivity());
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
    public   void INSENT_Problem_Details_for_checker(){










            ProblemID_checker=MyApplication.getInstance().getPrefManager().getPreferrence("ProblemID_checker");
            Log.e("IDD",ProblemID_checker);
            String ProblemTopic=Topic_checker;
            String ProblemDetail=Details_checker;
            String CheckNote="NULL";
            String ProblemStatus="1";



            //jsonArrayRequest = new JsonArrayRequest(GET_JSON_insent_Problem_Inform_Details+"?InformID="+InformID_REAL+"&ProblemID="+part_id_details+"&ProblemTopic="+URLEncoder.encode(ProblemTopic, "UTF-8")+"&ProblemDetail="+URLEncoder.encode(ProblemDetail, "UTF-8")+"&CheckNote="+URLEncoder.encode(CheckNote, "UTF-8"),

            //url = "http://httpbin.org/post";
            StringRequest postRequest = new StringRequest(Request.Method.POST, BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Details_Copy_real_uat.php",
                    new Response.Listener<String>()
                    {
                        @Override
                        public void onResponse(String response) {
                            check_sucess_insert_details=1;
                            // response
                            Log.e("Response", response);
                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            check_sucess_insert_details=0;
                            // error
                            //Log.d("Error.Response", response);
                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams()
                {
                    Map<String, String>  params = new HashMap<String, String>();
                    params.put("InformID", InformID_REAL);
                    params.put("ProblemID",ProblemID_checker);
                    try {
                        params.put("ProblemTopic",URLDecoder.decode(ProblemTopic, "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
              /*  try {
                    params.put("ProblemDetail",URLEncoder.encode(ProblemDetail, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }*/
                    try {
                        params.put("ProblemDetail", URLDecoder.decode(ProblemDetail, "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }

                    try {
                        params.put("CheckNote", URLDecoder.decode(CheckNote, "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }

                    return params;
                }
            };
            // requestQueue.add(postRequest);

            try {
                try {
                    requestQueue = Volley.newRequestQueue(getActivity());
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
    public   void INSENT_Problem_Details2(){   // have cs



        //String ProblemID=InformID;
        Log.e("InformID1",InformID);
        String ProblemTopic=Topic;
        String ProblemDetail=ProblemDetai;
        String CheckNote="NULL";
        String ProblemStatus="1";
        String InformEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");


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
        String finalIpaddress = ipaddress3;
        String finalComputername = computername3;
        StringRequest postRequest = new StringRequest(Request.Method.POST, API_URL_ALL.GET_JSON_insent_Problem_Inform_Details2,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        check_sucess_insert_details=1;
                        // response
                        Log.e("Response_details", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        check_sucess_insert_details=0;
                        // error
                        //Log.d("Error.Response", response);
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("InformID", InformID_REAL);
                params.put("ProblemID",part_id_details);

                params.put("EmpID",InformEmpID);
                params.put("ipaddress", finalIpaddress);
                params.put("computername", finalComputername);

                try {
                    params.put("ProblemTopic",URLDecoder.decode(ProblemTopic, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
              /*  try {
                    params.put("ProblemDetail",URLEncoder.encode(ProblemDetail, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }*/
                try {
                    params.put("ProblemDetail", URLDecoder.decode(ProblemDetail, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                try {
                    params.put("CheckNote", URLDecoder.decode(CheckNote, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }




                return params;
            }
        };
        // requestQueue.add(postRequest);

        try {
            try {
                requestQueue = Volley.newRequestQueue(getActivity());
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



    String Problem_Status="";
    public   void INSENT_Problem_Master(){

        String item_DATA=MyApplication.getInstance().getPrefManager().getPreferrence("item_DATA");

Log.e("item_DATA",item_DATA);
        if(item_DATA.equals("ปัญหาอื่นๆ")){

            API_URL_ALL.GET_JSON_insent_Problem_Inform_Master=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Master_Copy_real2_2.php";

        }

        else {

            API_URL_ALL.GET_JSON_insent_Problem_Inform_Master=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Master_Copy_real2.php";

        }









        String CashTeamCode="";





        String Contno=MyApplication.getInstance().getPrefManager().getPreferrence("contno_save");
        String InformEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        String InformDepartID=MyApplication.getInstance().getPrefManager().getPreferrence("DepartId");
        // String CashTeamCode=MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");



        if(PositionCode_REAL.equals("Sale")){
            CashTeamCode=MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");
        }
        else {
            CashTeamCode=MyApplication.getInstance().getPrefManager().getPreferrence("CashTeamCode");
        }

        String AdminEmpID="NULL";
        String AdminDepartID="NULL";

        String user_code=MyApplication.getInstance().getPrefManager().getPreferrence("getEmpID")+"";
        String SaleCode=MyApplication.getInstance().getPrefManager().getPreferrence("getSaleCode")+"";
        String SaleEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("getEmpID")+"";

        String ipaddress2=MyApplication.getInstance().getPrefManager().getPreferrence("IPaddress")+"";
        String computername2=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";

        String ipaddress="";
        String computername="";
        //Toast.makeText(getActivity(), "IP :  " + ipaddress2, Toast.LENGTH_LONG).show();
       // int ff= Integer.parseInt(ipaddress2);

        if(ipaddress2.equals("null")){
            ipaddress="-";
        }
        else {
            ipaddress="-";
            //ipaddress=ipaddress2.substring(0, 15);
        }





        if(computername2.equals("null")){
            computername="-";
        }
        else {
            //computername="android 6.0";
            computername=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";
        }


        String NoteData="NULL";
        String InformStatus="1";

        String Outstanding=MyApplication.getInstance().getPrefManager().getPreferrence("getOutstanding");
        String CustomerStatus=MyApplication.getInstance().getPrefManager().getPreferrence("getCustomerStatus");
        String AccountStatus=MyApplication.getInstance().getPrefManager().getPreferrence("getAccountStatus");
        String PayLastPeriod=MyApplication.getInstance().getPrefManager().getPreferrence("getPayLastPeriod");
        String CashTeamCCode=MyApplication.getInstance().getPrefManager().getPreferrence("getCashTeamCCode");
        String CashTeamACode=MyApplication.getInstance().getPrefManager().getPreferrence("getCashTeamACode");
        try {
            Log.e("URL_Master",API_URL_ALL.GET_JSON_insent_Problem_Inform_Master+"?InformID="+InformID_REAL+"&Contno="+Contno+"&SaleCode="+SaleCode+"&SaleEmpID="+SaleEmpID+"&CashTeamCode="+CashTeamCode+"&InformEmpID="+InformEmpID+"&InformDepartID="+InformDepartID+"&AdminEmpID="+AdminEmpID+"&AdminDepartID="+AdminDepartID+"&user_code="+user_code+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&NoteData="+NoteData+"&InformStatus="+InformStatus+"&Outstanding="+Outstanding+"&CustomerStatus="+CustomerStatus+"&AccountStatus="+AccountStatus+"&PayLastPeriod="+PayLastPeriod+"&CashTeamCCode="+CashTeamCCode+"&CashTeamACode="+CashTeamACode+"&ProblemID="+part_id_details);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {

            // jsonArrayRequest = new JsonArrayRequest(GET_JSON_insent_Problem_Inform_Master+"?Contno="+Contno+"&InformEmpID="+InformEmpID+"&InformDepartID="+InformDepartID+"&AdminEmpID="+AdminEmpID+"&AdminDepartID="+AdminDepartID+"&user_code="+user_code+"&ipaddress="+ipaddress+"&computername="+ URLEncoder.encode(computername, "UTF-8")+"&NoteData="+NoteData+"&InformStatus="+InformStatus,
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insent_Problem_Inform_Master+"?InformID="+InformID_REAL+"&Contno="+Contno+"&SaleCode="+SaleCode+"&SaleEmpID="+SaleEmpID+"&CashTeamCode="+CashTeamCode+"&InformEmpID="+InformEmpID+"&InformDepartID="+InformDepartID+"&AdminEmpID="+AdminEmpID+"&AdminDepartID="+AdminDepartID+"&user_code="+user_code+"&ipaddress="+ipaddress+"&computername="+ URLEncoder.encode(computername, "UTF-8")+"&NoteData="+NoteData+"&InformStatus="+InformStatus+"&Outstanding="+Outstanding+"&CustomerStatus="+CustomerStatus+"&AccountStatus="+AccountStatus+"&PayLastPeriod="+PayLastPeriod+"&CashTeamCCode="+CashTeamCCode+"&CashTeamACode="+CashTeamACode+"&ProblemID="+part_id_details,


                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            Log.e("ALL_response_M", String.valueOf(response));
                            check_sucess_insert_master=1;
                            //INSENT_Problem_details();

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("ERROR_response_M", error.getLocalizedMessage()+"");
                            check_sucess_insert_master=0;
                           // Log.d("zzz3","zzz3");
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





        //update_data_cannal_master_new(Contno); // อัพเดท data cannal
    }












    public   void INSENT_Problem_Master_for_checker(){
        String CashTeamCode="";





        String Contno=contno_checker;
        String ProcessTypeID=ProcessTypeID_checker;
        String InformEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        String InformDepartID=MyApplication.getInstance().getPrefManager().getPreferrence("DepartId");
        // String CashTeamCode=MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");



        if(PositionCode_REAL.equals("Sale")){
            CashTeamCode=MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");
        }
        else {
            CashTeamCode=MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");
        }

        String AdminEmpID="NULL";
        String AdminDepartID="NULL";

        String user_code=MyApplication.getInstance().getPrefManager().getPreferrence("getEmpID")+"";
        String SaleCode=MyApplication.getInstance().getPrefManager().getPreferrence("getSaleCode")+"";
        String SaleEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("getEmpID")+"";

        String ipaddress2=MyApplication.getInstance().getPrefManager().getPreferrence("IPaddress")+"";
        String computername2=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";

        String ipaddress="";
        String computername="";
        //Toast.makeText(getActivity(), "IP :  " + ipaddress2, Toast.LENGTH_LONG).show();
        // int ff= Integer.parseInt(ipaddress2);

        if(ipaddress2.equals("null")){
            ipaddress="-";
        }
        else {
            ipaddress="-";
            //ipaddress=ipaddress2.substring(0, 15);
        }





        if(computername2.equals("null")){
            computername="-";
        }
        else {
            //computername="android 6.0";
            computername=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";
        }


        String NoteData="NULL";
        String InformStatus="1";

        String Outstanding=MyApplication.getInstance().getPrefManager().getPreferrence("getOutstanding");
        String CustomerStatus=MyApplication.getInstance().getPrefManager().getPreferrence("getCustomerStatus");
        String AccountStatus=MyApplication.getInstance().getPrefManager().getPreferrence("getAccountStatus");
        String PayLastPeriod=MyApplication.getInstance().getPrefManager().getPreferrence("getPayLastPeriod");
        String CashTeamCCode=MyApplication.getInstance().getPrefManager().getPreferrence("getCashTeamCCode");
        String CashTeamACode=MyApplication.getInstance().getPrefManager().getPreferrence("Mcode");
        try {
            Log.e("URL_Master",BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Master_for_checker_uat.php"+"?InformID="+InformID_REAL+"&Contno="+Contno+"&SaleCode="+SaleCode+"&SaleEmpID="+SaleEmpID+"&CashTeamCode="+CashTeamCode+"&InformEmpID="+InformEmpID+"&InformDepartID="+InformDepartID+"&AdminEmpID="+AdminEmpID+"&AdminDepartID="+AdminDepartID+"&user_code="+user_code+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&NoteData="+NoteData+"&InformStatus="+InformStatus+"&Outstanding="+Outstanding+"&CustomerStatus="+CustomerStatus+"&AccountStatus="+AccountStatus+"&PayLastPeriod="+PayLastPeriod+"&CashTeamCCode="+CashTeamCCode+"&CashTeamACode="+CashTeamACode+"&ProblemID="+ProblemID_checker+"&ProcessTypeID="+ProcessTypeID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {

            // jsonArrayRequest = new JsonArrayRequest(GET_JSON_insent_Problem_Inform_Master+"?Contno="+Contno+"&InformEmpID="+InformEmpID+"&InformDepartID="+InformDepartID+"&AdminEmpID="+AdminEmpID+"&AdminDepartID="+AdminDepartID+"&user_code="+user_code+"&ipaddress="+ipaddress+"&computername="+ URLEncoder.encode(computername, "UTF-8")+"&NoteData="+NoteData+"&InformStatus="+InformStatus,
            jsonArrayRequest = new JsonArrayRequest(BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Master_for_checker_uat.php"+"?InformID="+InformID_REAL+"&Contno="+Contno+"&SaleCode="+SaleCode+"&SaleEmpID="+SaleEmpID+"&CashTeamCode="+CashTeamCode+"&InformEmpID="+InformEmpID+"&InformDepartID="+InformDepartID+"&AdminEmpID="+AdminEmpID+"&AdminDepartID="+AdminDepartID+"&user_code="+user_code+"&ipaddress="+ipaddress+"&computername="+ URLEncoder.encode(computername, "UTF-8")+"&NoteData="+NoteData+"&InformStatus="+InformStatus+"&Outstanding="+Outstanding+"&CustomerStatus="+CustomerStatus+"&AccountStatus="+AccountStatus+"&PayLastPeriod="+PayLastPeriod+"&CashTeamCCode="+CashTeamCCode+"&CashTeamACode="+CashTeamACode+"&ProblemID="+ProblemID_checker+"&ProcessTypeID="+ProcessTypeID,


                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            Log.e("ALL_response_M", String.valueOf(response));
                            check_sucess_insert_master=1;
                            //INSENT_Problem_details();

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("ERROR_response_M", error.getLocalizedMessage()+"");
                            check_sucess_insert_master=0;
                            // Log.d("zzz3","zzz3");
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




/*Log.e("rrr_size", String.valueOf(getData_check_problems2.size()));
        for (int i = 0; i < getData_check_problems2.size(); i++) {
            //  select_id_from_Problem_Inform_Master_for_checker2();
            // getData_uploade_images.get(i);
            GetData_check_problem2 contact = getData_check_problems2.get(i);
            ProblemID_checker = contact.getProblemID();
            Details_checker=contact.getMain_problems()+","+contact.getProblemDetail();
            Topic_checker=contact.getSubject();

            contno_checker=contact.getCONTNO();
            ProcessTypeID_checker=contact.getProcessTypeID();
              Log.e("ProblemID_checker_RRRR",ProblemID_checker);
          //  INSENT_Problem_Details_for_checker(ProcessTypeID_checker);

        }*/

/*      for (int i = 0; i < getData_check_problems2.size(); i++) {
           select_id_from_Problem_Inform_Master_for_checker2();
            // getData_uploade_images.get(i);
            GetData_check_problem2 contact = getData_check_problems2.get(i);
            ProblemID_checker = contact.getProblemID();
            Details_checker=contact.getMain_problems()+","+contact.getProblemDetail();
            Topic_checker=contact.getSubject();

            contno_checker=contact.getCONTNO();
            ProcessTypeID_checker=contact.getProcessTypeID();

            INSENT_Problem_Details_for_checker();

        }*/

    }

int ee=0;
    public   void INSENT_Problem_Master_for_checker2(){
        String CashTeamCode="";





        String Contno=contno_checker;
        String ProcessTypeID=ProcessTypeID_checker;
        String InformEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        String InformDepartID=MyApplication.getInstance().getPrefManager().getPreferrence("DepartId");
        // String CashTeamCode=MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");



        if(PositionCode_REAL.equals("Sale")){
            CashTeamCode=MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");
        }
        else {
            CashTeamCode=MyApplication.getInstance().getPrefManager().getPreferrence("CashTeamCode");
        }

        String AdminEmpID="NULL";
        String AdminDepartID="NULL";

        String user_code=MyApplication.getInstance().getPrefManager().getPreferrence("getEmpID")+"";
        String SaleCode=MyApplication.getInstance().getPrefManager().getPreferrence("getSaleCode")+"";
        String SaleEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("getEmpID")+"";

        String ipaddress2=MyApplication.getInstance().getPrefManager().getPreferrence("IPaddress")+"";
        String computername2=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";

        String ipaddress="";
        String computername="";
        //Toast.makeText(getActivity(), "IP :  " + ipaddress2, Toast.LENGTH_LONG).show();
        // int ff= Integer.parseInt(ipaddress2);

        if(ipaddress2.equals("null")){
            ipaddress="-";
        }
        else {
            ipaddress="-";
            //ipaddress=ipaddress2.substring(0, 15);
        }





        if(computername2.equals("null")){
            computername="-";
        }
        else {
            //computername="android 6.0";
            computername=MyApplication.getInstance().getPrefManager().getPreferrence("android_name")+"";
        }


        String NoteData="NULL";
        String InformStatus="1";

        String Outstanding=MyApplication.getInstance().getPrefManager().getPreferrence("getOutstanding");
        String CustomerStatus=MyApplication.getInstance().getPrefManager().getPreferrence("getCustomerStatus");
        String AccountStatus=MyApplication.getInstance().getPrefManager().getPreferrence("getAccountStatus");
        String PayLastPeriod=MyApplication.getInstance().getPrefManager().getPreferrence("getPayLastPeriod");
        String CashTeamCCode=MyApplication.getInstance().getPrefManager().getPreferrence("getCashTeamCCode");
        String CashTeamACode=MyApplication.getInstance().getPrefManager().getPreferrence("getCashTeamACode");
        try {
            Log.e("URL_Master",BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Master_for_checker_uat.php"+"?InformID="+InformID_REAL+"&Contno="+Contno+"&SaleCode="+SaleCode+"&SaleEmpID="+SaleEmpID+"&CashTeamCode="+CashTeamCode+"&InformEmpID="+InformEmpID+"&InformDepartID="+InformDepartID+"&AdminEmpID="+AdminEmpID+"&AdminDepartID="+AdminDepartID+"&user_code="+user_code+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&NoteData="+NoteData+"&InformStatus="+InformStatus+"&Outstanding="+Outstanding+"&CustomerStatus="+CustomerStatus+"&AccountStatus="+AccountStatus+"&PayLastPeriod="+PayLastPeriod+"&CashTeamCCode="+CashTeamCCode+"&CashTeamACode="+CashTeamACode+"&ProblemID="+ProblemID_checker+"&ProcessTypeID="+ProcessTypeID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        //INSENT_Problem_Details_for_checker();



        try {

            // jsonArrayRequest = new JsonArrayRequest(GET_JSON_insent_Problem_Inform_Master+"?Contno="+Contno+"&InformEmpID="+InformEmpID+"&InformDepartID="+InformDepartID+"&AdminEmpID="+AdminEmpID+"&AdminDepartID="+AdminDepartID+"&user_code="+user_code+"&ipaddress="+ipaddress+"&computername="+ URLEncoder.encode(computername, "UTF-8")+"&NoteData="+NoteData+"&InformStatus="+InformStatus,
            jsonArrayRequest = new JsonArrayRequest(BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Master_for_checker_uat.php"+"?InformID="+InformID_REAL+"&Contno="+Contno+"&SaleCode="+SaleCode+"&SaleEmpID="+SaleEmpID+"&CashTeamCode="+CashTeamCode+"&InformEmpID="+InformEmpID+"&InformDepartID="+InformDepartID+"&AdminEmpID="+AdminEmpID+"&AdminDepartID="+AdminDepartID+"&user_code="+user_code+"&ipaddress="+ipaddress+"&computername="+ URLEncoder.encode(computername, "UTF-8")+"&NoteData="+NoteData+"&InformStatus="+InformStatus+"&Outstanding="+Outstanding+"&CustomerStatus="+CustomerStatus+"&AccountStatus="+AccountStatus+"&PayLastPeriod="+PayLastPeriod+"&CashTeamCCode="+CashTeamCCode+"&CashTeamACode="+CashTeamACode+"&ProblemID="+ProblemID_checker+"&ProcessTypeID="+ProcessTypeID,


                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            Log.e("ALL_response_M", String.valueOf(response));
                            check_sucess_insert_master=1;
                            //INSENT_Problem_details();

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("ERROR_response_M", error.getLocalizedMessage()+"");
                            check_sucess_insert_master=0;
                            // Log.d("zzz3","zzz3");
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



        for (int i = 0; i < getData_check_problems2.size(); i++) {



            // getData_uploade_images.get(i);
            GetData_check_problem2 contact = getData_check_problems2.get(i);
            ProblemID_checker = contact.getProblemID();
            Details_checker=contact.getMain_problems()+","+contact.getProblemDetail();
            Topic_checker=contact.getSubject();

            contno_checker=contact.getCONTNO();
            ProcessTypeID_checker=contact.getProcessTypeID();


            if(ee==0){
                select_id_from_Problem_Inform_Master_for_checker2();
              //  INSENT_Problem_Details_for_checker();
            }
            ee=1;

        }



    }















    public void Delete_data_credit(){
        String Contno=MyApplication.getInstance().getPrefManager().getPreferrence("contno_save");
        String InformEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_Delete_data_credit+"?InformID="+InformID_REAL+"&ProblemID="+part_id_details+"&Contno="+Contno+"&InformEmpID="+InformEmpID,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                       // JSON_PARSE_DATA_AFTER_select_id_from_Problem_Inform_Master(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });


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
    public void Delete_data_credit2(){
        //String Contno=MyApplication.getInstance().getPrefManager().getPreferrence("contno_save");
        String InformEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_Delete_data_credit+"?InformID="+InformID_REAL+"&ProblemID="+ProblemID_checker+"&Contno="+contno_checker+"&InformEmpID="+InformEmpID,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // JSON_PARSE_DATA_AFTER_select_id_from_Problem_Inform_Master(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });


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

    public   void INSENT_Problem_Master_new(){

        String item_DATA=MyApplication.getInstance().getPrefManager().getPreferrence("item_DATA");


        if(item_DATA.equals("ปัญหาอื่นๆ")){

            API_URL_ALL.GET_JSON_insent_Problem_Inform_Master_new=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Master_Copy_real_new_2.php";
        }

        else {

            API_URL_ALL.GET_JSON_insent_Problem_Inform_Master_new=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Master_Copy_real_new.php";
        }



        String CashTeamCode="";


        String Contno=MyApplication.getInstance().getPrefManager().getPreferrence("contno_save");
        String InformEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        String InformDepartID=MyApplication.getInstance().getPrefManager().getPreferrence("DepartId");
        //String CashTeamCode=MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");


        if(PositionCode_REAL.equals("Sale")){
            CashTeamCode=MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");
        }
        else {
            CashTeamCode=MyApplication.getInstance().getPrefManager().getPreferrence("CashTeamCode");
        }

        String AdminEmpID="NULL";
        String AdminDepartID="NULL";
        //  String WorkCode="00";


        String user_code=MyApplication.getInstance().getPrefManager().getPreferrence("getEmpID");
        String ipaddress=MyApplication.getInstance().getPrefManager().getPreferrence("IPaddress");
        String computername=MyApplication.getInstance().getPrefManager().getPreferrence("android_name");
        String NoteData="NULL";
        String InformStatus="1";

        String Outstanding=MyApplication.getInstance().getPrefManager().getPreferrence("getOutstanding");
        String CustomerStatus=MyApplication.getInstance().getPrefManager().getPreferrence("getCustomerStatus");
        String AccountStatus=MyApplication.getInstance().getPrefManager().getPreferrence("getAccountStatus");
        String PayLastPeriod=MyApplication.getInstance().getPrefManager().getPreferrence("getPayLastPeriod");
        String CashTeamCCode=MyApplication.getInstance().getPrefManager().getPreferrence("getCashTeamCCode");
        String CashTeamACode=MyApplication.getInstance().getPrefManager().getPreferrence("getCashTeamACode");
        try {
            Log.e("URL_Master",API_URL_ALL.GET_JSON_insent_Problem_Inform_Master_new+"?InformID="+InformID_REAL+"&Contno="+Contno+"&CashTeamCode="+CashTeamCode+"&InformIDRef="+InformIDRef+"&Informitem="+Informitem_NEW+"&InformEmpID="+InformEmpID+"&InformDepartID="+InformDepartID+"&AdminEmpID="+AdminEmpID+"&AdminDepartID="+AdminDepartID+"&user_code="+user_code+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&NoteData="+NoteData+"&InformStatus="+InformStatus+"&Outstanding="+Outstanding+"&CustomerStatus="+CustomerStatus+"&AccountStatus="+AccountStatus+"&PayLastPeriod="+PayLastPeriod+"&CashTeamCCode="+CashTeamCCode+"&CashTeamACode="+CashTeamACode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {

            // jsonArrayRequest = new JsonArrayRequest(GET_JSON_insent_Problem_Inform_Master+"?Contno="+Contno+"&InformEmpID="+InformEmpID+"&InformDepartID="+InformDepartID+"&AdminEmpID="+AdminEmpID+"&AdminDepartID="+AdminDepartID+"&user_code="+user_code+"&ipaddress="+ipaddress+"&computername="+ URLEncoder.encode(computername, "UTF-8")+"&NoteData="+NoteData+"&InformStatus="+InformStatus,
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insent_Problem_Inform_Master_new+"?InformID="+InformID_REAL+"&Contno="+Contno+"&CashTeamCode="+CashTeamCode+"&InformIDRef="+InformIDRef+"&Informitem="+Informitem_NEW+"&InformEmpID="+InformEmpID+"&InformDepartID="+InformDepartID+"&AdminEmpID="+AdminEmpID+"&AdminDepartID="+AdminDepartID+"&user_code="+user_code+"&ipaddress="+ipaddress+"&computername="+ URLEncoder.encode(computername, "UTF-8")+"&NoteData="+NoteData+"&InformStatus="+InformStatus+"&Outstanding="+Outstanding+"&CustomerStatus="+CustomerStatus+"&AccountStatus="+AccountStatus+"&PayLastPeriod="+PayLastPeriod+"&CashTeamCCode="+CashTeamCCode+"&CashTeamACode="+CashTeamACode,


                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            check_sucess_insert_master=1;
                            //INSENT_Problem_details();

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            check_sucess_insert_master=0;

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

    String GET_JSON_select_check_sucess_all=BASE_URL+"assanee/checker_system/select_check_sucess_all_uat.php";

    public void select_check_sucess_all(){
        pDialogg.dismiss();
        pDialogg.cancel();


        jsonArrayRequest = new JsonArrayRequest(GET_JSON_select_check_sucess_all+"?InformID="+InformID_REAL,


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

     Log.e("InformID_ALL_FULL",InformID_M+","+InformID_D+","+InformID_I+","+InformID_REAL);












        if((InformID_M.equals(InformID_REAL))&(InformID_D.equals(InformID_REAL))){



            SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(getActivity(), SweetAlertDialog.SUCCESS_TYPE);
            sweetAlertDialog.setTitleText("เสร็จสิ้น!");
            sweetAlertDialog.setContentText("*การเเจ้งปัญหา*");
            sweetAlertDialog.setCancelable(false);
            sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sDialog) {




                    try {


                        insert_gps_gis= new INSERT_GPS_GIS(getActivity());
                        insert_gps_gis.gg();


                    }
                    catch (Exception ex){
                      //  Log.e("check_error",ex.getLocalizedMessage()+"");
                    }




                    try {
                        String contno_by_checker=MyApplication.getInstance().getPrefManager().getPreferrence("contno_by_checker")+"";
                        String contno_save=MyApplication.getInstance().getPrefManager().getPreferrence("contno_save")+"";
                        if(contno_by_checker.equals(contno_save)){


                            MyApplication.getInstance().getPrefManager().setPreferrence("contno_by_checker","null");

                        }

                    }
                    catch (Exception EX){

                    }





                    insert_data_to_cs();  // add data to cs

                    SQLiteDataBaseBuild2();
                    SQLiteTableBuild2();
                    sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper_problem_id_image.TABLE_NAME + "");


                    File dire = new File(Environment.getExternalStorageDirectory(), "/Android/data/com.tsr.tsrproblemreport/files/Pictures");
                    Log.e("dire", String.valueOf(dire));
                    new DirectoryCleaner(dire).clean();
                    dire.delete();











                    try {


                        contno_save = MyApplication.getInstance().getPrefManager().getPreferrence("contno_save")+"";



                        File dir2 = new File(getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES)+ "/"+contno_save+"/report_problem/IDALL/image_error");
                        if (dir2.isDirectory())
                        {
                            String[] children = dir2.list();
                            for (int i = 0; i < children.length; i++)
                            {
                                new File(dir2, children[i]).delete();
                            }
                        }


                    }
                    catch (Exception ex){

                    }












                    Log.e("dialog", "ปิด dialog");
                    sDialog.dismissWithAnimation();


                    MyApplication.getInstance().getPrefManager().setPreferrence("getCONTNO", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getProductName", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getProductPrice", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getCustomerName", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getAddressall", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getEmpID", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getEmployeeName", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getPositionCode", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getPositionName", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getTeamHeadCode", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getTeamHeadName", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getTeamName", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getSupervisorHeadCode", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getSupervisorHeadName", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getSupervisorName", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getSubDepartmentHeadCode", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getSubDepartmentHeadName", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getSubDepartmentName", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getDepartmentHeadCode", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getDepartmentHeadName", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getDepartmentName", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getSubTeamCode", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getTeamCode", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getPicture", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getInformID", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getContno_nontification_problem", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getInformEmpID", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getInformDepartID", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getOutstanding", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getCustomerStatus", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getAccountStatus", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getPayLastPeriod", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getCashTeamCCode", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getCashTeamACode", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("contno_save", "");
                    MyApplication.getInstance().getPrefManager().setPreferrence("check", "null");
                    check_buttom_remove_image=0;
                    check_sucess_insert_master=0;
                    check_sucess_insert_details=0;
                    check_sucess_insert_image=0;
                    size_image=0;
                    InformID_M="null";
                    InformID_D="null";

                    hideMenu();
                    hideMenu2();
                    switcher2.setVisibility(View.GONE);
                    lenear_custommer_other.setVisibility(View.GONE);
                    linear_status.setVisibility(View.GONE);
                    inputText.setText("");
                    inputText.clearAnimation();
                    count_problem.setText("0" + " รายการ");
                   // is = String.valueOf(0);
                    MyApplication.getInstance().getPrefManager().setPreferrence("report_problem", "0"); // มาจาก การตรวจสอบ


                    SQLiteDataBaseBuild_data_checker_problem_for_report();
                    SQLiteTableBuild_data_checker_problem_for_report();
                    sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_data_checker_problem_for_report.TABLE_NAME+"");
                    li_checker2.setVisibility(View.GONE);
                    //data_checker_problem_for_report();

                }
            });
            sweetAlertDialog.show();


            File file = new File("/storage/sdcard0/Android/data/com.tsr.tsrproblemreport/files/Pictures/70102489/report_problem/ID1/image_error/image_error_20180406070126-1473976226.jpg");
            double length = file.length();
            length = length / 1024;

            Log.e("imageName", file.getPath() + ", File size : " + length + " KB");
            getData_uploade_images.clear();
            pDialogg.dismiss();
            pDialogg.cancel();

            getData_check_problems.clear();  //เคลียร์ recycle problem real
            try {
                adapter2.notifyDataSetChanged();
            }
            catch (Exception ex){

            }

        }
        else {








            pDialogg.dismiss();
            pDialogg.cancel();
            //  Log.d(TAG, "Error " + t.getMessage());
            //finalThread.stop();



            SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE);
            sweetAlertDialog.setTitleText("ผิดพลาด!");
            sweetAlertDialog.setContentText("*อัพโหลดข้อมูลไม่สำเร็จ กรุณาลองอีกครั้ง*");
            sweetAlertDialog.setCancelable(false);
            sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sDialog) {

                    for (int i = 0; i < getData_check_problems2.size(); i++) {
                        // getData_uploade_images.get(i);
                        GetData_check_problem2 contact = getData_check_problems2.get(i);
                        ProblemID_checker = contact.getProblemID();
                        Details_checker=contact.getMain_problems()+","+contact.getProblemDetail();
                        Topic_checker=contact.getSubject();

                        contno_checker=contact.getCONTNO();

                        Delete_data_credit2();

                    }


                    try {
                        pDialogg.dismiss();
                    }
                    catch (Exception ex){

                    }



                    Delete_data_credit();
                    SQLiteDataBaseBuild2();
                    SQLiteTableBuild2();
                    sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_problem_id_image.TABLE_NAME+"");


                    File dire= new File(Environment.getExternalStorageDirectory(), "/Android/data/com.tsr.tsrproblemreport/files/Pictures");
                    Log.e("dire", String.valueOf(dire));
                    new DirectoryCleaner(dire).clean();
                    dire.delete();

                    Log.e("dialog","ปิด dialog");
                    sDialog.dismissWithAnimation();









                    MyApplication.getInstance().getPrefManager().setPreferrence("getCONTNO","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getProductName","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getProductPrice","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getCustomerName","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getAddressall","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getEmpID","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getEmployeeName","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getPositionCode","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getPositionName","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getTeamHeadCode","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getTeamHeadName","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getTeamName","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getSupervisorHeadCode","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getSupervisorHeadName","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getSupervisorName","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getSubDepartmentHeadCode","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getSubDepartmentHeadName","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getSubDepartmentName","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getDepartmentHeadCode","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getDepartmentHeadName","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getDepartmentName","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getSubTeamCode","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getTeamCode","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getPicture","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getInformID","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getContno_nontification_problem","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getInformEmpID","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getInformDepartID","null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getOutstanding", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getCustomerStatus", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getAccountStatus", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getPayLastPeriod", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getCashTeamCCode", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("getCashTeamACode", "null");
                    MyApplication.getInstance().getPrefManager().setPreferrence("contno_save", "");
                    MyApplication.getInstance().getPrefManager().setPreferrence("check", "null");
                    check_buttom_remove_image=0;
                    check_sucess_insert_master=0;
                    check_sucess_insert_details=0;
                    check_sucess_insert_image=0;
                    size_image=0;
                    InformID_M="null";
                    InformID_D="null";
                    hideMenu();
                    hideMenu2();
                    switcher2.setVisibility(View.GONE);
                    lenear_custommer_other.setVisibility(View.GONE);
                    linear_status.setVisibility(View.GONE);
                    inputText.setText("");
                    inputText.clearAnimation();
                    count_problem.setText("0" + " รายการ");
                    //is = String.valueOf(0);

                    File file = new File("/storage/sdcard0/Android/data/com.tsr.tsrproblemreport/files/Pictures/70102489/report_problem/ID1/image_error/image_error_20180406070126-1473976226.jpg");
                    double length = file.length();
                    length = length / 1024;

                    Log.e("imageName", file.getPath() + ", File size : " + length + " KB");
                    getData_uploade_images.clear();
                    pDialogg.dismiss();
                    pDialogg.cancel();

                    getData_check_problems.clear();  //เคลียร์ recycle problem real
                    try {
                        adapter2.notifyDataSetChanged();
                    }
                    catch (Exception ex){

                    }


                }
            });
            sweetAlertDialog .show();
        }


    }














    private  void INSENT_Problem_Inform_Details_Images(){


        String ProblemID=part_id;
        String ImageItem=Image_id_item ;




        String ImageUrl=Url;
        String ImageName=Image_Name;
        String ImageSize=Image_Size;
        String ImageType =Image_Type;
        Log.e("InformID1",InformID);
     //   Log.e("InformID2",MyApplication.getInstance().getPrefManager().getPreferrence("InformID"));
        try {
            Log.e("URL_Details_Images",API_URL_ALL.GET_JSON_insent_Problem_Inform_Details_Images+"?InformID="+InformID_REAL+"&ProblemID="+ProblemID+"&ImageItem="+ImageItem+"&ImageUrl="+URLEncoder.encode(ImageUrl, "UTF-8")+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageSize="+ImageSize+"&ImageType="+ImageType);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

//MyApplication.getInstance().getPrefManager().getPreferrence("InformID")

        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insent_Problem_Inform_Details_Images+"?InformID="+InformID_REAL+"&ProblemID="+ProblemID+"&ImageItem="+ImageItem+"&ImageUrl="+URLEncoder.encode(ImageUrl, "UTF-8")+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageSize="+ImageSize+"&ImageType="+ImageType,


                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            check_sucess_insert_image=1;

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            check_sucess_insert_image=0;
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




    private  void INSENT_Problem_Inform_Details_Images2(){


        String ProblemID=part_id;
        String ImageItem=Image_id_item ;




        String ImageUrl=Url;
        String ImageName=Image_Name;
        String ImageSize=Image_Size;
        String ImageType =Image_Type;
        Log.e("InformID1",InformID);
        //   Log.e("InformID2",MyApplication.getInstance().getPrefManager().getPreferrence("InformID"));
        try {
            Log.e("URL_Details_Images2",API_URL_ALL.GET_JSON_insent_Problem_Inform_Details_Images2+"?InformID="+InformID_REAL+"&ProblemID="+ProblemID+"&ImageItem="+ImageItem+"&ImageUrl="+URLEncoder.encode(ImageUrl, "UTF-8")+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageSize="+ImageSize+"&ImageType="+ImageType);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

//MyApplication.getInstance().getPrefManager().getPreferrence("InformID")

        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insent_Problem_Inform_Details_Images2+"?InformID="+InformID_REAL+"&ProblemID="+ProblemID+"&ImageItem="+ImageItem+"&ImageUrl="+URLEncoder.encode(ImageUrl, "UTF-8")+"&ImageName="+URLEncoder.encode(ImageName, "UTF-8")+"&ImageSize="+ImageSize+"&ImageType="+ImageType,


                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            check_sucess_insert_image=1;

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            check_sucess_insert_image=0;
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






    int idid2;
    String is ="";
    public  void  SELECT_DATA_PROBLEM_SQLITE_intro(){
        Log.e("runrun","runrun");
        order_image=0;
        new_message.setText("");
        CHECK_IMAGE="";
        allSampleData.clear();
        SQLiteDataBaseBuild();
        SQLiteTableBuild();
        sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_image_buffer.TABLE_NAME+"");


       // allSampleData.clear();
        getData_check_problems.clear();
        SQLiteDataBaseBuild2();
        SQLiteTableBuild2();

        if (item.equals("ปัญหาอื่นๆ")) {
            for (idid2 = 123; idid2 < 3500; idid2++) {

                    GetData_check_problem getDataCheckProblem = new GetData_check_problem();

                    cursor = sqLiteDatabase.rawQuery("SELECT count(*) as ddd,part_id,part_image,Category,Main_problems,Sub_problems,topic,ProblemDetail,datetime  FROM " + SQLiteHelper_problem_id_image.TABLE_NAME + "" + " WHERE part_id =" + "'" + idid2 + "'" + " ORDER BY datetime DESC LIMIT 1", null);

                    if (cursor.moveToFirst()) {
                        do {
                            int count = cursor.getInt(0);
                            if (count != 0) {
                                //String FA=cursor.getString(count(*));
                                Log.e("count999", String.valueOf(count));
                                String part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_id));
                                String part_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_image));
                                String Category = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Category));
                                String Main_problems = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Main_problems));
                                String Sub_problems = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Sub_problems));
                                String topic = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_topic));
                                String ProblemDetail = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_ProblemDetail));
                                String datetime = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_datetime));


                                Log.e("ProblemDetail", ProblemDetail + "");
                                getDataCheckProblem.setPart_id(String.valueOf(part_id));
                                getDataCheckProblem.setCount_image(String.valueOf(count));

                                getDataCheckProblem.setCategory(Category);
                                getDataCheckProblem.setMain_problems(Main_problems);
                                getDataCheckProblem.setSub_problems(Sub_problems);
                                getDataCheckProblem.setSubject(topic);
                                getDataCheckProblem.setProblemDetail(ProblemDetail);
                                getDataCheckProblem.setDatetime(datetime);
                                getDataCheckProblem.setImage(part_image);

                                getData_check_problems.add(getDataCheckProblem);
                            }

                        } while (cursor.moveToNext());
                    }
                    cursor.close();



            }

        }
        else {

            for (idid2 = 0; idid2 < 2000; idid2++) {
                if (idid2 > 122 && idid2 < 1071) {

                } else {
                    GetData_check_problem getDataCheckProblem = new GetData_check_problem();

                    cursor = sqLiteDatabase.rawQuery("SELECT count(*) as ddd,part_id,part_image,Category,Main_problems,Sub_problems,topic,ProblemDetail,datetime  FROM " + SQLiteHelper_problem_id_image.TABLE_NAME + "" + " WHERE part_id =" + "'" + idid2 + "'" + " ORDER BY datetime DESC LIMIT 1", null);

                    if (cursor.moveToFirst()) {
                        do {
                            int count = cursor.getInt(0);
                            if (count != 0) {
                                //String FA=cursor.getString(count(*));
                                Log.e("count999", String.valueOf(count));
                                String part_id = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_id));
                                String part_image = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_image));
                                String Category = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Category));
                                String Main_problems = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Main_problems));
                                String Sub_problems = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Sub_problems));
                                String topic = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_topic));
                                String ProblemDetail = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_ProblemDetail));
                                String datetime = cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_datetime));


                                Log.e("ProblemDetail", ProblemDetail + "");
                                getDataCheckProblem.setPart_id(String.valueOf(part_id));
                                getDataCheckProblem.setCount_image(String.valueOf(count));

                                getDataCheckProblem.setCategory(Category);
                                getDataCheckProblem.setMain_problems(Main_problems);
                                getDataCheckProblem.setSub_problems(Sub_problems);
                                getDataCheckProblem.setSubject(topic);
                                getDataCheckProblem.setProblemDetail(ProblemDetail);
                                getDataCheckProblem.setDatetime(datetime);
                                getDataCheckProblem.setImage(part_image);

                                getData_check_problems.add(getDataCheckProblem);
                            }

                        } while (cursor.moveToNext());
                    }
                    cursor.close();

                }


            }
        }

         adapter2 = new RecyclerViewAdapter_check_problem_new(getData_check_problems,getActivity());
        recyclerview1.setAdapter(adapter2);
        adapter2.setitemclick_deleteAll(this);
        adapter2.setitemclick_image_problem_incorrect(this);




        int ds=getData_check_problems.size();
         is = String.valueOf(ds);
        count_problem.setText(is+" รายการ");




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

    int order_image=0,order_image2=0;
    String VersionOS="";
    String part_image_in_device="";
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            try {
                String qr_code_report_promlem_sale = MyApplication.getInstance().getPrefManager().getPreferrence("qr_code_report_promlem_sale");
                Log.e("qr_code_repor",qr_code_report_promlem_sale);

                inputText.setText(qr_code_report_promlem_sale);
                inputText.setSelection(qr_code_report_promlem_sale.length());
                initListener();
            }
            catch (Exception x){

            }
        }
        else if(requestCode == 1){
            if(resultCode==RESULT_OK) {
                allSampleData.clear();
                //CropImage();

                if(item.equals("อื่นๆ")){
                    ID_SUB="0";
                }
                else {
                    if (status_Shortcut.equals("1")) {
                        ID_SUB = ID_PROMLEM_NUMBER;
                    } else if (status_Shortcut.equals("2")) {
                        ID_SUB = MyApplication.getInstance().getPrefManager().getPreferrence("ID_SUB_ALL");
                    } else {
                        ID_SUB = MyApplication.getInstance().getPrefManager().getPreferrence("ID_SUB");
                    }
                }



                order_image=order_image+1;
                order_image2=order_image+1;
                MyApplication.getInstance().getPrefManager().getPreferrence("part_image");
                String FILE2= "";
                String FILE= "";
                try {



                    FILE2 = MyApplication.getInstance().getPrefManager().getPreferrence("part_image") + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("imageName") + ".jpg";
                    File file21 = new File(FILE2);
                    String filePath = file21.getPath();
                    Bitmap bitmap = BitmapFactory.decodeFile(filePath);
                    ic.NewresizeBitmap(bitmap);
                    FILE = MyApplication.getInstance().getPrefManager().getPreferrence("part_image") + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+"new" + ".png";

                }
                catch (Exception ex){
                    FILE=file.getAbsolutePath();
                }



                String image_name = MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+"new";
               // String image_name=MyApplication.getInstance().getPrefManager().getPreferrence("imageName");


                //  Log.e("image_name",image_name);

                String Url=SERVER_PATH+"uploads_image_report_problem/"+image_name+".png";
             //   String Url="http://app.thiensurat.co.th/assanee/uploads_image_report_problem/"+image_name+".png";
                //String Url="http://app.thiensurat.co.th/assanee/uploads_image_report_problem/"+image_name+".jpg";
                // Log.e("Url_image_name",Url);





                File file2 = new File(FILE);
                long length = file2.length();
                length = length/1024;
                String number="";
                if(check_buttom_remove_image==1){
                    number = String.valueOf(2);
                }
                else {
                     number= String.valueOf(1);
                }


                SQLiteDataBaseBuild();
                SQLiteTableBuild();

                String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "jpg" + "','" + order_image + "');";
                // String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (part_id,part_image,type_image) VALUES('" + id_image_success + "', '" + file.getAbsolutePath() + "', '" + "image_success" + "');";
                sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
















                for (int i = 1; i <=1; i++) {

                    SectionDataModel dm = new SectionDataModel();

                    dm.setHeaderTitle("ล่าสุด ");

                    ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();




                    Log.e("sdd", String.valueOf(check_buttom_remove_image));
                    if(check_buttom_remove_image==1){
                        cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper_image_buffer.TABLE_NAME+""  +" WHERE name_image ="+"'"+"2"+"'"   , null);
                        if (cursor.moveToFirst()) {
                            do {

                                String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                                String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
                                Log.e("A", FA);

                                // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                                // String f= String.valueOf(order_image);
                                singleItem.add(new SingleItemModel("รูป " + f, FA));

                                size = singleItem.size();
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
                                Log.e("AAAAAAAA", FA);

                                // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                                // String f= String.valueOf(order_image);
                                singleItem.add(new SingleItemModel("รูป " + f, FA));

                                size = singleItem.size();
                                MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                            } while (cursor.moveToNext());
                        }
                        cursor.close();
                    }







                    dm.setAllItemsInSection(singleItem);

                    allSampleData.add(dm);


                }


                RecyclerViewDataAdapter5 adapter = new RecyclerViewDataAdapter5(getActivity(), allSampleData);
                my_recycler_view.setAdapter(adapter);
                adapter.setitemclick_deleteAll3(this);
                if(size==0){
                    my_recycler_view.setVisibility(View.GONE);
                }
                else {
                    my_recycler_view.setVisibility(View.VISIBLE);

                }

            }

        }

        else if (requestCode == 2){

            if(item.equals("อื่นๆ")){
                ID_SUB="0";
            }
            else {
                if (status_Shortcut.equals("1")) {
                    ID_SUB = ID_PROMLEM_NUMBER;
                } else if (status_Shortcut.equals("2")) {
                    ID_SUB = MyApplication.getInstance().getPrefManager().getPreferrence("ID_SUB_ALL");
                } else {
                    ID_SUB = MyApplication.getInstance().getPrefManager().getPreferrence("ID_SUB");
                }
            }



            order_image=order_image+1;
            order_image2=order_image+1;
            MyApplication.getInstance().getPrefManager().getPreferrence("part_image");
            String FILE="";
            try {
                VersionOS = Build.VERSION.RELEASE;

                if((VersionOS.equals("6.0"))|(VersionOS.equals("6.0.0"))|(VersionOS.equals("6.0.1"))|(VersionOS.equals("6.1"))|(VersionOS.equals("6.1.0"))|(VersionOS.equals("7.0"))|(VersionOS.equals("7.0.0"))|(VersionOS.equals("7.0.1"))|(VersionOS.equals("7.1"))|(VersionOS.equals("7.1.0"))|(VersionOS.equals("7.1.1"))|(VersionOS.equals("7.1.2"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.0.0"))|(VersionOS.equals("8.1.0"))|(VersionOS.equals("8.0"))|(VersionOS.equals("8.1"))|(VersionOS.equals("8.1.1"))|(VersionOS.equals("9"))|(VersionOS.equals("9.0"))|(VersionOS.equals("9.0.0"))|(VersionOS.equals("9.1"))|(VersionOS.equals("9.1.0"))){
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

           // String Url="http://app.thiensurat.co.th/assanee/uploads_image_report_problem/"+image_name+".jpg";
            String Url=SERVER_PATH+"uploads_image_report_problem/"+image_name+".jpg";
            //String Url=SERVER_PATH+"uploads_image_report_problem/"+image_name+".png";
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

            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "jpg" + "','" + order_image + "');";
            // String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (part_id,part_image,type_image) VALUES('" + id_image_success + "', '" + file.getAbsolutePath() + "', '" + "image_success" + "');";
            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
















            for (int i = 1; i <=1; i++) {

                SectionDataModel dm = new SectionDataModel();

                dm.setHeaderTitle("ล่าสุด ");

                ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();



                if(check_buttom_remove_image==1){
                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper_image_buffer.TABLE_NAME+""  +" WHERE name_image ="+"'"+"2"+"'"   , null);
                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
                            Log.e("A", FA);

                            // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                            // String f= String.valueOf(order_image);
                            singleItem.add(new SingleItemModel("รูป " + f, FA));

                            size = singleItem.size();
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
                            singleItem.add(new SingleItemModel("รูป " + f, FA));

                            size = singleItem.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }

                dm.setAllItemsInSection(singleItem);

                allSampleData.add(dm);


            }


            RecyclerViewDataAdapter5 adapter = new RecyclerViewDataAdapter5(getActivity(), allSampleData);
            my_recycler_view.setAdapter(adapter);
            adapter.setitemclick_deleteAll3(this);
            if(size==0){
                my_recycler_view.setVisibility(View.GONE);
            }
            else {
                my_recycler_view.setVisibility(View.VISIBLE);
            }

        }

   else if(requestCode==80){
            hideMenu();
            hideMenu2();
            String contno2=MyApplication.getInstance().getPrefManager().getPreferrence("qr_code_report_promlem_sale");


            inputText.setText(contno2);
            contno=contno2;
            pDialogg2 = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
            pDialogg2.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
            pDialogg2.setTitleText("กำลังค้นหาเลขที่สัญญา...");
            pDialogg2.setCancelable(true);
            pDialogg2.show();

            INSENT_DATA_SALE();
            INSENT_DATA_CHECK_CONTNO();

        }
        else if(requestCode == CAM_REQUEST){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        //    imgTakenPic.setImageBitmap(bitmap);
        }

        else if (requestCode == 77 && resultCode == RESULT_OK) {
            allSampleData.clear();

                     String FILE="";
                     String DD="";
                    String image_name="";
                    String image_type="png";
            int size_arr;
                Uri uri = data.getData();
                String[] projection = {MediaStore.Images.Media.DATA};

                Cursor cursor = getActivity().getContentResolver().query(uri, projection, null, null, null);
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(projection[0]);
                String filepath = cursor.getString(columnIndex);







            String FILE2= "";

            try {

                File file21 = new File(filepath);
                String filePath = file21.getPath();
//                Bitmap bitmap = BitmapFactory.decodeFile(filePath);
                /**
                 * Edit by Teerayut Klinsanga
                 */
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
                bitmap = ic.NewresizeBitmap(bitmap);
                Log.e("Bitmap size", bitmap.getWidth() + ", " + bitmap.getHeight());

//                ByteArrayOutputStream stream = new ByteArrayOutputStream();
//                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//                byte[] imageInByte = stream.toByteArray();
//                long lengthbmp = imageInByte.length;

                Log.e("Size of bmp", String.valueOf(bitmap.getByteCount()));
                /**
                 * End
                 */


                FILE2 = MyApplication.getInstance().getPrefManager().getPreferrence("part_image") + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+"new" + ".png";

            }
            catch (Exception ex){

            }






            FILE =FILE2;

             image_name = MyApplication.getInstance().getPrefManager().getPreferrence("imageName")+"new";
             cursor.close();


            if(item.equals("อื่นๆ")){
                ID_SUB="0";
            }
            else {
                if (status_Shortcut.equals("1")) {
                    ID_SUB = ID_PROMLEM_NUMBER;
                } else if (status_Shortcut.equals("2")) {
                    ID_SUB = MyApplication.getInstance().getPrefManager().getPreferrence("ID_SUB_ALL");
                } else {
                    ID_SUB = MyApplication.getInstance().getPrefManager().getPreferrence("ID_SUB");
                }
            }



            order_image=order_image+1;
            order_image2=order_image+1;



           // String Url="http://app.thiensuat.co.th/assanee/uploads_image_report_problem/"+image_name+"."+image_type;

            String Url=SERVER_PATH+"uploads_image_report_problem/"+image_name+"."+image_type;



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

            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + image_type + "','" + order_image + "');";
            // String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (part_id,part_image,type_image) VALUES('" + id_image_success + "', '" + file.getAbsolutePath() + "', '" + "image_success" + "');";
            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);

            for (int i = 1; i <=1; i++) {

                SectionDataModel dm = new SectionDataModel();

                dm.setHeaderTitle("ล่าสุด ");

                ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();




                if(check_buttom_remove_image==1){
                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper_image_buffer.TABLE_NAME+""  +" WHERE name_image ="+"'"+"2"+"'"   , null);
                    if (cursor.moveToFirst()) {
                        do {

                            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
                            Log.e("A", FA);

                            // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                            // String f= String.valueOf(order_image);
                            singleItem.add(new SingleItemModel("รูป " + f, FA));

                            size = singleItem.size();
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
                            singleItem.add(new SingleItemModel("รูป " + f, FA));

                            size = singleItem.size();
                            MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                }





                dm.setAllItemsInSection(singleItem);

                allSampleData.add(dm);


            }


            RecyclerViewDataAdapter5 adapter = new RecyclerViewDataAdapter5(getActivity(), allSampleData);
            my_recycler_view.setAdapter(adapter);
            adapter.setitemclick_deleteAll3(this);

            if(size==0){
                my_recycler_view.setVisibility(View.GONE);
            }
            else {
                my_recycler_view.setVisibility(View.VISIBLE);
            }
        }

   else if(requestCode==11){

            if(checkConnection() == true){
                relativeLayout_check_net.setVisibility(View.GONE);
            }
            else {
                relativeLayout_check_net.setVisibility(View.VISIBLE);

            }
        }

    }

    public void SQLiteDataBaseBuild(){

        sqLiteDatabase = getActivity().openOrCreateDatabase(SQLiteHelper_image_buffer.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    public void SQLiteTableBuild(){

        //sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper.TABLE_NAME+"("+ SQLiteHelper.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+SQLiteHelper.Table_Column_1_Subject_Name+" VARCHAR, "+SQLiteHelper.Table_Column_2_SubjectFullForm+" VARCHAR, "+SQLiteHelper.Table_Column_3_subteamcode+" VARCHAR, "+SQLiteHelper.Table_Column_5_contract_number+" VARCHAR, "+SQLiteHelper.Table_Column_6_contract_number2+" VARCHAR, "+SQLiteHelper.Table_Column_7_name_topic+" VARCHAR, "+SQLiteHelper.Table_Column_8_customer+" VARCHAR, "+SQLiteHelper.Table_Column_9_description+" VARCHAR, "+SQLiteHelper.Table_Column_16_status+" VARCHAR, "+SQLiteHelper.Table_Column_15_date_time+" VARCHAR, "+SQLiteHelper.Table_Column_23_date_time_update+" VARCHAR, "+SQLiteHelper.Table_Column_10_approveStatus+" VARCHAR, "+SQLiteHelper.Table_Column_11_approveBy+" VARCHAR, "+SQLiteHelper.Table_Column_12_approveDate+" VARCHAR, "+SQLiteHelper.Table_Column_17_isremark+" VARCHAR, "+SQLiteHelper.Table_Column_14_isremark1+" VARCHAR, "+SQLiteHelper.Table_Column_20_check_foller+" VARCHAR, "+SQLiteHelper.Table_Column_21_countfoller+" VARCHAR, "+SQLiteHelper.Table_Column_22_countcomment+" VARCHAR, "+SQLiteHelper.Table_Column_4_picture+" VARCHAR);");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_image_buffer.TABLE_NAME+"("+ SQLiteHelper_image_buffer.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_image_buffer.Table_part_id+" VARCHAR, "+SQLiteHelper_image_buffer.Table_name_image+" VARCHAR, "+SQLiteHelper_image_buffer.Table_url_image+" VARCHAR, "+SQLiteHelper_image_buffer.Table_Url+" VARCHAR, "+SQLiteHelper_image_buffer.Table_Image_Name+" VARCHAR, "+SQLiteHelper_image_buffer.Table_Image_Size+" VARCHAR, "+SQLiteHelper_image_buffer.Table_Image_Type+" VARCHAR, "+SQLiteHelper_image_buffer.Table_order_image+" VARCHAR);");


    }

    public void SQLiteDataBaseBuild2(){

        sqLiteDatabase = getActivity().openOrCreateDatabase(SQLiteHelper_problem_id_image.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    public void SQLiteTableBuild2(){

        //sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper.TABLE_NAME+"("+ SQLiteHelper.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+SQLiteHelper.Table_Column_1_Subject_Name+" VARCHAR, "+SQLiteHelper.Table_Column_2_SubjectFullForm+" VARCHAR, "+SQLiteHelper.Table_Column_3_subteamcode+" VARCHAR, "+SQLiteHelper.Table_Column_5_contract_number+" VARCHAR, "+SQLiteHelper.Table_Column_6_contract_number2+" VARCHAR, "+SQLiteHelper.Table_Column_7_name_topic+" VARCHAR, "+SQLiteHelper.Table_Column_8_customer+" VARCHAR, "+SQLiteHelper.Table_Column_9_description+" VARCHAR, "+SQLiteHelper.Table_Column_16_status+" VARCHAR, "+SQLiteHelper.Table_Column_15_date_time+" VARCHAR, "+SQLiteHelper.Table_Column_23_date_time_update+" VARCHAR, "+SQLiteHelper.Table_Column_10_approveStatus+" VARCHAR, "+SQLiteHelper.Table_Column_11_approveBy+" VARCHAR, "+SQLiteHelper.Table_Column_12_approveDate+" VARCHAR, "+SQLiteHelper.Table_Column_17_isremark+" VARCHAR, "+SQLiteHelper.Table_Column_14_isremark1+" VARCHAR, "+SQLiteHelper.Table_Column_20_check_foller+" VARCHAR, "+SQLiteHelper.Table_Column_21_countfoller+" VARCHAR, "+SQLiteHelper.Table_Column_22_countcomment+" VARCHAR, "+SQLiteHelper.Table_Column_4_picture+" VARCHAR);");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_problem_id_image.TABLE_NAME+"("+ SQLiteHelper_problem_id_image.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_problem_id_image.Table_part_id+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_part_image+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_Category+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_Main_problems+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_Sub_problems+" VARCHAR,"+SQLiteHelper_problem_id_image.Table_topic+" VARCHAR,"+SQLiteHelper_problem_id_image.Table_ProblemDetail+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_datetime+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_Url+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_Image_Name+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_Image_Size+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_Image_Type+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_order_image+" VARCHAR);");


    }

    public void SQLiteDataBaseBuild3(){

        sqLiteDatabase = getActivity().openOrCreateDatabase(SQLiteHelper_image_buffer2.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    public void SQLiteTableBuild3(){

        //sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper.TABLE_NAME+"("+ SQLiteHelper.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+SQLiteHelper.Table_Column_1_Subject_Name+" VARCHAR, "+SQLiteHelper.Table_Column_2_SubjectFullForm+" VARCHAR, "+SQLiteHelper.Table_Column_3_subteamcode+" VARCHAR, "+SQLiteHelper.Table_Column_5_contract_number+" VARCHAR, "+SQLiteHelper.Table_Column_6_contract_number2+" VARCHAR, "+SQLiteHelper.Table_Column_7_name_topic+" VARCHAR, "+SQLiteHelper.Table_Column_8_customer+" VARCHAR, "+SQLiteHelper.Table_Column_9_description+" VARCHAR, "+SQLiteHelper.Table_Column_16_status+" VARCHAR, "+SQLiteHelper.Table_Column_15_date_time+" VARCHAR, "+SQLiteHelper.Table_Column_23_date_time_update+" VARCHAR, "+SQLiteHelper.Table_Column_10_approveStatus+" VARCHAR, "+SQLiteHelper.Table_Column_11_approveBy+" VARCHAR, "+SQLiteHelper.Table_Column_12_approveDate+" VARCHAR, "+SQLiteHelper.Table_Column_17_isremark+" VARCHAR, "+SQLiteHelper.Table_Column_14_isremark1+" VARCHAR, "+SQLiteHelper.Table_Column_20_check_foller+" VARCHAR, "+SQLiteHelper.Table_Column_21_countfoller+" VARCHAR, "+SQLiteHelper.Table_Column_22_countcomment+" VARCHAR, "+SQLiteHelper.Table_Column_4_picture+" VARCHAR);");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_image_buffer2.TABLE_NAME+"("+ SQLiteHelper_image_buffer2.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_image_buffer2.Table_part_id+" VARCHAR, "+SQLiteHelper_image_buffer2.Table_name_image+" VARCHAR, "+SQLiteHelper_image_buffer2.Table_url_image+" VARCHAR, "+SQLiteHelper_image_buffer2.Table_Url+" VARCHAR, "+SQLiteHelper_image_buffer2.Table_Image_Name+" VARCHAR, "+SQLiteHelper_image_buffer2.Table_Image_Size+" VARCHAR, "+SQLiteHelper_image_buffer2.Table_Image_Type+" VARCHAR, "+SQLiteHelper_image_buffer2.Table_order_image+" VARCHAR);");


    }
    public void revealMenu() {
        menuOpen = true;
        MyApplication.getInstance().getPrefManager().setPreferrence("status_hide_ro_reveal", "1");
        linear_sale1.setVisibility(View.VISIBLE);
        linear_status.setVisibility(View.VISIBLE);
        int cx = linear_sale1.getRight() - 200;
        int cy = linear_sale1.getTop();
        int finalRadius = Math.max(linear_sale1.getWidth(), linear_sale1.getHeight());
        Animator anim =
                null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            anim = ViewAnimationUtils.createCircularReveal(linear_sale1, cx, cy, 0, finalRadius);
        }
        anim.setDuration(600);
        linear_sale1.setVisibility(View.VISIBLE);
        linear_status.setVisibility(View.VISIBLE);
        //overlay.setVisibility(View.GONE);
        anim.start();



        // Animate The Icons One after the other, I really would like to know if there is any
        // simpler way to do it
        @SuppressLint("ResourceType") Animation popeup1 = AnimationUtils.loadAnimation(getActivity(), R.animator.popeup);
        @SuppressLint("ResourceType") Animation popeup2 = AnimationUtils.loadAnimation(getActivity(), R.animator.popeup);
        @SuppressLint("ResourceType") Animation popeup3 = AnimationUtils.loadAnimation(getActivity(), R.animator.popeup);
        @SuppressLint("ResourceType") Animation popeup4 = AnimationUtils.loadAnimation(getActivity(), R.animator.popeup);
        @SuppressLint("ResourceType") Animation popeup5 = AnimationUtils.loadAnimation(getActivity(), R.animator.popeup);
        @SuppressLint("ResourceType") Animation popeup6 = AnimationUtils.loadAnimation(getActivity(), R.animator.popeup);
        popeup1.setStartOffset(50);
        popeup2.setStartOffset(100);
        popeup3.setStartOffset(150);
        popeup4.setStartOffset(200);
        popeup5.setStartOffset(250);
        popeup6.setStartOffset(300);


    }



    public void hideMenu() {
        menuOpen = false;

        MyApplication.getInstance().getPrefManager().setPreferrence("status_hide_ro_reveal", "0");

        int cx = linear_sale1.getRight() - 200;
        int cy = linear_sale1.getTop();
        int initialRadius = linear_sale1.getWidth();
        Animator anim = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            try {
                anim = ViewAnimationUtils.createCircularReveal(linear_sale1, cx, cy, initialRadius, 0);
            }
            catch (Exception ex){

            }

        }

        try {
            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    linear_sale1.setVisibility(View.INVISIBLE);
                    linear_sale1.setVisibility(View.GONE);
                    linear_status.setVisibility(View.GONE);
                    // overlay.setVisibility(View.INVISIBLE);
                    // overlay.setVisibility(View.GONE);
                }
            });

            anim.start();
        }
        catch (Exception ex){

        }







    }







    public void revealMenu2() {
        menuOpen = true;

        linear_sale2.setVisibility(View.VISIBLE);
        linear_sale3.setVisibility(View.VISIBLE);
        lenear_custommer_other.setVisibility(View.VISIBLE);
        int cx = linear_sale2.getRight() - 200;
        int cy = linear_sale2.getTop();
        int finalRadius = Math.max(linear_sale2.getWidth(), linear_sale2.getHeight());

        int cx3 = linear_sale3.getRight() - 200;
        int cy3 = linear_sale3.getTop();
        int finalRadius3 = Math.max(linear_sale3.getWidth(), linear_sale3.getHeight());



        Animator anim = null;
        Animator anim2 = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            anim = ViewAnimationUtils.createCircularReveal(linear_sale2, cx, cy, 0, finalRadius);
            anim2 = ViewAnimationUtils.createCircularReveal(linear_sale3, cx3, cy3, 0, finalRadius3);
        }
        anim.setDuration(600);
        anim2.setDuration(600);
        linear_sale2.setVisibility(View.VISIBLE);
        linear_sale3.setVisibility(View.VISIBLE);
        //overlay.setVisibility(View.GONE);
        anim.start();
        anim2.start();


        // Animate The Icons One after the other, I really would like to know if there is any
        // simpler way to do it
        @SuppressLint("ResourceType") Animation popeup1 = AnimationUtils.loadAnimation(getActivity(), R.animator.popeup);
        @SuppressLint("ResourceType") Animation popeup2 = AnimationUtils.loadAnimation(getActivity(), R.animator.popeup);
        @SuppressLint("ResourceType") Animation popeup3 = AnimationUtils.loadAnimation(getActivity(), R.animator.popeup);
        @SuppressLint("ResourceType") Animation popeup4 = AnimationUtils.loadAnimation(getActivity(), R.animator.popeup);
        @SuppressLint("ResourceType") Animation popeup5 = AnimationUtils.loadAnimation(getActivity(), R.animator.popeup);
        @SuppressLint("ResourceType") Animation popeup6 = AnimationUtils.loadAnimation(getActivity(), R.animator.popeup);
        popeup1.setStartOffset(50);
        popeup2.setStartOffset(100);
        popeup3.setStartOffset(150);
        popeup4.setStartOffset(200);
        popeup5.setStartOffset(250);
        popeup6.setStartOffset(300);


    }



    public void hideMenu2() {
        menuOpen = false;
        int cx = linear_sale2.getRight() - 200;
        int cy = linear_sale2.getTop();
        int initialRadius = linear_sale2.getWidth();

        int cx3 = linear_sale3.getRight() - 200;
        int cy3 = linear_sale3.getTop();
        int initialRadius3= linear_sale3.getWidth();


        Animator anim = null;
        Animator anim2 = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            try {
                anim = ViewAnimationUtils.createCircularReveal(linear_sale2, cx, cy, initialRadius, 0);

                anim2 = ViewAnimationUtils.createCircularReveal(linear_sale3, cx3, cy3, initialRadius3, 0);
            }
            catch (Exception ex){

            }

        }


        try {
            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    linear_sale2.setVisibility(View.INVISIBLE);
                    linear_sale2.setVisibility(View.GONE);
                    // overlay.setVisibility(View.INVISIBLE);
                    // overlay.setVisibility(View.GONE);
                }
            });
            anim.start();
        }
        catch (Exception e){

        }







        try {
            anim2.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    linear_sale3.setVisibility(View.INVISIBLE);
                    linear_sale3.setVisibility(View.GONE);
                    // overlay.setVisibility(View.INVISIBLE);
                    // overlay.setVisibility(View.GONE);
                }
            });
            anim2.start();
        }
        catch (Exception e){

        }




    }


    @Override
    public void onResume() {
        super.onResume();
        Log.e("onResume", "onResume");


    }

    public void onPause() {
        super.onPause();

     //   dialog_show_runing();
        Log.e("onPause", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();

        Log.e("onStop", "onStop");

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("onDestroyView", "onDestroyView");


        check=0;
        SQLiteDataBaseBuild2();
        SQLiteTableBuild2();
        sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_problem_id_image.TABLE_NAME+"");


        File dire= new File(Environment.getExternalStorageDirectory(), "/Android/data/com.tsr.tsrproblemreport/files/Pictures");
        Log.e("dire", String.valueOf(dire));
        new DirectoryCleaner(dire).clean();
        dire.delete();

        Log.e("dialog","ปิด dialog");
        // sDialog.dismissWithAnimation();









        MyApplication.getInstance().getPrefManager().setPreferrence("getCONTNO","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getProductName","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getProductPrice","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getCustomerName","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getAddressall","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getEmpID","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getEmployeeName","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getPositionCode","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getPositionName","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getTeamHeadCode","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getTeamHeadName","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getTeamName","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getSupervisorHeadCode","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getSupervisorHeadName","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getSupervisorName","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getSubDepartmentHeadCode","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getSubDepartmentHeadName","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getSubDepartmentName","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getDepartmentHeadCode","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getDepartmentHeadName","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getDepartmentName","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getSubTeamCode","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getTeamCode","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getPicture","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getInformID","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getContno_nontification_problem","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getInformEmpID","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getInformDepartID","null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getOutstanding", "null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getCustomerStatus", "null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getAccountStatus", "null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getPayLastPeriod", "null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getCashTeamCCode", "null");
        MyApplication.getInstance().getPrefManager().setPreferrence("getCashTeamACode", "null");
        MyApplication.getInstance().getPrefManager().setPreferrence("contno_save", "");
        MyApplication.getInstance().getPrefManager().setPreferrence("check", "null");
        check_buttom_remove_image=0;
        check_sucess_insert_master=0;
        check_sucess_insert_details=0;
        check_sucess_insert_image=0;
        size_image=0;
        InformID_M="null";
        InformID_D="null";
        hideMenu();
        hideMenu2();
        switcher2.setVisibility(View.GONE);
        lenear_custommer_other.setVisibility(View.GONE);
        linear_status.setVisibility(View.GONE);
        inputText.setText("");
        inputText.clearAnimation();
        count_problem.setText("0" + " รายการ");
       // is = String.valueOf(0);

        SQLiteDataBaseBuild();
        SQLiteTableBuild();
        sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_image_buffer.TABLE_NAME+"");

        SQLiteDataBaseBuild2();
        SQLiteTableBuild2();
        sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_problem_id_image.TABLE_NAME+"");

        SQLiteDataBaseBuild3();
        SQLiteTableBuild3();
        sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_image_buffer2.TABLE_NAME+"");

    }

    private void dialog_show_runing(){
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog_on_running);
        dialog.setCancelable(true);

       final TextView cancal= (TextView)dialog. findViewById(R.id.cancal);
        final TextView save= (TextView)dialog. findViewById(R.id.save);

        cancal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "0");
                singleItem.clear();

                SQLiteDataBaseBuild();
                SQLiteTableBuild();
                sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_image_buffer.TABLE_NAME+"");

                status_run_work=false;
                //update_status_offline();
                Log.e("offline","user");
                Intent mIntent = new Intent( getActivity(), LOGIN_MAIN.class);
                startActivity(mIntent);
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // MyApplication.getInstance().getPrefManager().setPreferrence("save", "1");
                MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "0");
                status_run_work=false;
                //update_status_offline();
                Log.e("offline","user");
                Intent mIntent = new Intent( getActivity(), LOGIN_MAIN.class);
                startActivity(mIntent);
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        dialog.show();
    }



    @Override
    public void click_deleteAll(View v, int position) {
        final GetData_check_problem getDataAdapter1 =  getData_check_problems.get(position);
        Log.e("idididid",getDataAdapter1.getPart_id());
        getDataAdapter1.getPart_id();
        new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE)
                .setTitleText("คุณแน่ใจไหม?")
                .setContentText("ที่ต้องการลบปัญหานี้!")
                .setCancelText("ไม่!")
                .setConfirmText("ใช่!")
                .showCancelButton(true)
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {

                        sDialog.cancel();
                    }
                })
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(final SweetAlertDialog sDialog) {

                        SQLiteDataBaseBuild2();
                        SQLiteTableBuild2();
                       // cursor = sqLiteDatabase.rawQuery("SELECT count(*) as ddd,part_image,Category,Main_problems,Sub_problems,topic,datetime  FROM " + SQLiteHelper_problem_id_image.TABLE_NAME + "" + " WHERE part_id =" + "'" + idid2 + "'" + " ORDER BY datetime DESC LIMIT 1", null);
                        sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_problem_id_image.TABLE_NAME+""+ " WHERE part_id =" + "'" + getDataAdapter1.getPart_id() + "'");
                        SELECT_DATA_PROBLEM_SQLITE_intro();
                        sDialog.cancel();
                    }


                })
                .show();
        check_buttom_remove_image=0;
        size_image=0;
        }

    @Override
    public void click_image_problem_incorrect(View v, int position) {
        getData_cedit_dialog_image_problem_from_ids.clear();

        final GetData_check_problem getDataAdapter1 =  getData_check_problems.get(position);
        Log.e("image_view",getDataAdapter1.getPart_id());


        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.mp3_online_list_single_recycleview_dialog_custom_image_problem);
        dialog.setCancelable(true);
       // final TextView tvTitle = (TextView) dialog.findViewById(R.id.tvTitle);
        //final ImageView itemImage = (ImageView) dialog.findViewById(R.id.itemImage);
        final RecyclerView recycler_view = (RecyclerView) dialog.findViewById(R.id.recycler_view);

        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));



        //tvTitle.setText(singleItem.getName());






        cursor = sqLiteDatabase.rawQuery("SELECT part_image  FROM " + SQLiteHelper_problem_id_image.TABLE_NAME + "" + " WHERE part_id =" + "'" + getDataAdapter1.getPart_id() + "'" , null);

        if (cursor.moveToFirst()) {
            do {
                GetData_cedit_dialog_image_problem_from_id dataCeditDialogImageProblemFromId =new  GetData_cedit_dialog_image_problem_from_id();

                String part_image=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_image));
                Log.e("part_image",part_image);
                dataCeditDialogImageProblemFromId.setImage_id_all(part_image);
                getData_cedit_dialog_image_problem_from_ids.add(dataCeditDialogImageProblemFromId);
            } while (cursor.moveToNext());
        }
        cursor.close();

            recyclerViewDataAdapter_dialog_image_problem_from_id = new RecyclerViewDataAdapter_dialog_image_problem_from_id(getActivity(), getData_cedit_dialog_image_problem_from_ids/*(ArrayList<GetData_cedit_dialog_image_problem_from_id>) getData_cedit_dialog_image_problem_from_ids*/);
            recycler_view.setAdapter(recyclerViewDataAdapter_dialog_image_problem_from_id);

        dialog.show();

        //itemImage.setOnTouchListener(new ImageMatrixTouchHandler(getActivity()));


    }













    public class ObjNonti{
        public String InformID,WorkCode,MessageHeader,MessageDetails,ipaddress,type,project;
    }
    private WebSocketClient webSocketClient;
    public void connectSocket(){
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
                ob.project = "TICKET";
                ob.ipaddress=MyApplication.getInstance().getPrefManager().getPreferrence("IPaddress");
                ob.MessageHeader =InformID_REAL+ "แจ้งปัญหาจาก : "+MyApplication.getInstance().getPrefManager().getPreferrence("EMPID")+" : "+MyApplication.getInstance().getPrefManager().getPreferrence("EmployeeName");
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











    public   void insert_data_to_cs(){

Log.e("InformID_REAL4444",InformID_REAL);

        StringRequest postRequest = new StringRequest(Request.Method.POST, "https://toss.thiensurat.co.th/Ticket/api/ServiceF1/CreateProblemServiceF1",
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.e("Response_cs", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.e("error_cs", error.getLocalizedMessage()+"");
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("InformID", InformID_REAL);


                return params;
            }
        };
        // requestQueue.add(postRequest);

        try {
            try {
                requestQueue = Volley.newRequestQueue(getActivity());
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









    Dialog dialog_image;

    @Override
    public void click_deleteAll3(View v, int position) {

        if(size>0) {
            getData_image_more_for_delates.clear();


            dialog_image = new Dialog(getActivity());
            dialog_image.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog_image.setContentView(R.layout.mp3_online_list_single_recycleview_dialog_custom_image_problem);
            dialog_image.setCancelable(true);
            final TextView counter = (TextView) dialog_image.findViewById(R.id.counter);
            final RelativeLayout close = (RelativeLayout) dialog_image.findViewById(R.id.close);


            final RecyclerView recycler_view = (RecyclerView) dialog_image.findViewById(R.id.recycler_view);

            recycler_view.setHasFixedSize(true);
            recycler_view.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));


            if (check_buttom_remove_image == 1) {

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

            } else {
                cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "", null);
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
            }


            counter.setText(getData_image_more_for_delates.size() + "");

            recyclerViewDataAdapter_dialog_image_problem_from_id2 = new RecyclerViewDataAdapter_dialog_image_problem_from_id2(getActivity(), getData_image_more_for_delates);
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
        else {
            new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("! ไม่มีรูป")
                    .setContentText("กรุณาตรวจสอบข้อมูลก่อน!")
                    .setConfirmText("ออก!")
                    .show();
        }




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
        SQLiteDataBaseBuild3();
        SQLiteTableBuild3();

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

                    Log.e("CHECK_IMAGEwwww_222", FA);
                    //  String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_BUF2 + "','" + number_BUF2 + "','" + FA + "','" + Url_BUF2 + "','" + NAME_IMAGE_BUF2 + "','" + length_BUF2 + "','" + image_type_BUF2 + "','" + order_image_BUF2 + "');";
                    //  sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);

                    singleItem3.add(new SingleItemModel3("รูป " + f, FA));
                    size3 = singleItem3.size();
                    //getData_image_news=getDataImageNew.getImage_Name();


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

            SQLiteDataBaseBuild2();
            SQLiteTableBuild2();
            sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_problem_id_image.TABLE_NAME+"");

            SQLiteDataBaseBuild3();
            SQLiteTableBuild3();
            sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_image_buffer2.TABLE_NAME+"");
            my_recycler_view.setVisibility(View.GONE);

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




        allSampleData.clear();
        singleItem.clear();


        for (int i = 1; i <=1; i++) {

            SectionDataModel dm = new SectionDataModel();

            dm.setHeaderTitle("ล่าสุด ");

            singleItem = new ArrayList<SingleItemModel>();


if(size_image==1){
    cursor = sqLiteDatabase.rawQuery("SELECT count(*)as dd,url_image,order_image,name_image FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" + " WHERE name_image =" + "'" + "2" + "'", null);
    //cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + SQLiteHelper_image_buffer.TABLE_NAME + "" , null);
    if (cursor.moveToFirst()) {
        do {

            String FA = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
            String f = cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
            //String rr=cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
            Log.e("FAภ",FA+","+order_image);


            singleItem.add(new SingleItemModel("รูป " + f, FA));

            size = singleItem.size();
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



                singleItem.add(new SingleItemModel("รูป " + f, FA));

                size = singleItem.size();
                //MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
          //  }

        } while (cursor222.moveToNext());
    }


}






            //}


            dm.setAllItemsInSection(singleItem);
            allSampleData.add(dm);
        }

        RecyclerViewDataAdapter5 adapter = new RecyclerViewDataAdapter5(getActivity(), allSampleData);
        my_recycler_view.setAdapter(adapter);
        adapter.setitemclick_deleteAll3(this);
         adapter.notifyDataSetChanged();
        if(singleItem.size()==0){
            my_recycler_view.setVisibility(View.GONE);
        }
        else {
            my_recycler_view.setVisibility(View.VISIBLE);
        }
        //select_image();
        check_buttom_remove_image=1;

    }

    public void SQLiteDataBaseBuild_data_checker_problem_for_report(){
        sqLiteDatabase =getActivity().openOrCreateDatabase(SQLiteHelper_data_checker_problem_for_report.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
    public void SQLiteTableBuild_data_checker_problem_for_report(){
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_data_checker_problem_for_report.TABLE_NAME+"("+ SQLiteHelper_data_checker_problem_for_report.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_data_checker_problem_for_report.Table_CONTNO+" VARCHAR, "+SQLiteHelper_data_checker_problem_for_report.Table_GORY+" VARCHAR, "+SQLiteHelper_data_checker_problem_for_report.Table_MAIN+" VARCHAR, "+SQLiteHelper_data_checker_problem_for_report.Table_SUB+" VARCHAR, "+SQLiteHelper_data_checker_problem_for_report.Table_DETAILS+" VARCHAR,"+SQLiteHelper_data_checker_problem_for_report.Table_ProcessTypeID+" VARCHAR);");
    }




    String GET_JSON_UPDATE_Problem_Inform_Master=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Master_Copy_real2_3.php";
    private void update_data_cannal_master_new(String Contno){
String InformEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");


            jsonArrayRequest = new JsonArrayRequest(GET_JSON_UPDATE_Problem_Inform_Master+"?InformID="+InformID_REAL+"&Contno="+Contno+"&InformEmpID="+InformEmpID,


                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                           // check_sucess_insert_image=1;

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            //check_sucess_insert_image=0;
                        }
                    });


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


















   // String details_problem_nonti_to_web2="";
    public class ObjNonti2{
        public String InformID,WorkCode,MessageHeader,MessageDetails,ipaddress,type,project;
    }
    private WebSocketClient webSocketClient2;
    public void connectSocket2(String InformID_REAL2,String details_problem_nonti_to_web2){
        Log.e("","");
        URI uri;
        try {
            uri = new URI("ws://toss.thiensurat.co.th:3002");
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }
        webSocketClient2 = new WebSocketClient(uri) {
            @Override
            public void onOpen() {
                System.out.println("onOpen");
                ObjNonti2 ob = new ObjNonti2();
                ob.InformID = InformID_REAL2;
                ob.WorkCode = "00";
                ob.type = "checker";
                ob.project = "TICKET";
                ob.ipaddress=MyApplication.getInstance().getPrefManager().getPreferrence("IPaddress");
                ob.MessageHeader =InformID_REAL+ "แจ้งปัญหาจาก : "+MyApplication.getInstance().getPrefManager().getPreferrence("EMPID")+" : "+MyApplication.getInstance().getPrefManager().getPreferrence("EmployeeName");
                ob.MessageDetails = details_problem_nonti_to_web2;
                Gson gson = new Gson();
                String json = gson.toJson(ob);
                Log.e("strJson" , json);
                webSocketClient2.send(json);
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



                try {
                    webSocketClient.setConnectTimeout(10000);
                    webSocketClient.setReadTimeout(60000);

                    //webSocketClient.addHeader("Origin", "http://developer.example.com");
                    //webSocketClient.enableAutomaticReconnection(5000);
                    webSocketClient.connect();
                }
                catch (Exception ex){

                }


        check_nonti_web=1;
        //details_problem_nonti_to_web="";
    }
















    private void insert_log_problem(){
        String InformEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");



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

        String ipaddress = ipaddress3;
        String computername = computername3;


        try {
            Log.e("url_log_problem",API_URL_ALL.GET_JSON_insert_log_problem+"?Contno="+contno+"&NoID="+NoID+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&InformID="+InformID+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            jsonArrayRequest = new JsonArrayRequest(API_URL_ALL.GET_JSON_insert_log_problem+"?Contno="+contno+"&NoID="+NoID+"&FnYear="+FnYear+"&FnMonth="+FnMonth+"&InformID="+InformID+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&user_code="+InformEmpID,


                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            // check_sucess_insert_image=1;

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            //check_sucess_insert_image=0;
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
}
