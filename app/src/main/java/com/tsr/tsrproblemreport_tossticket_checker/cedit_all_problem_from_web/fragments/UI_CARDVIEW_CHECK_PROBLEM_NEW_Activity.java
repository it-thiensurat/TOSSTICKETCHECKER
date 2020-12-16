package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.MusicActivity_Credit;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.RecyclerViewAdapter_check_problem_new;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.RecyclerViewDataAdapter;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.RecyclerViewDataAdapter_dialog_image_problem_from_id;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.databases.SQLiteHelper_image_buffer;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.databases.SQLiteHelper_problem_id_image;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.DATA_mp3;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_dialog_image_problem_from_id;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_check_problem;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_sale_information;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_select_topic_problem_gory;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_select_topic_problem_main;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_select_topic_problem_sub;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_uploade_Image;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.ImageAfter;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.ImageBefore;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.SectionDataModel;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.SingleItemModel;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.uploads_image.Service;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.utils.ImageConfiguration;
import com.tsr.tsrproblemreport_tossticket_checker.jsonlogin.LOGIN_MAIN;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.CircleTransform;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

public class UI_CARDVIEW_CHECK_PROBLEM_NEW_Activity extends AppCompatActivity implements View.OnClickListener,RecyclerViewAdapter_check_problem_new.itemclick_deleteAll,RecyclerViewAdapter_check_problem_new.itemclick_image_problem_incorrect{

    Spinner spDemo,spDemo2,spDemo3,spDemo4;
    String[] value= {
            "ทดสอบ 1", "เมา 1", "Eclair", "Froyo", "Gingerbread",
            "Honeycomb", "ICS", "Jelly Bean", "KitKat", "Lollipop",
            "Marshmallow"};

    String GET_JSON_DATA_HTTP_URL = "http://www.assaneecity.com/mp3_online/api.php?artist_list";
    JsonArrayRequest jsonArrayRequest;
    JsonObjectRequest jsonObjectRequest;
    RequestQueue requestQueue;
    ArrayList<SectionDataModel> allSampleData;
    ArrayList<SingleItemModel> singleItem;

    private List<ImageBefore> imageBeforeList = new ArrayList<>();
    private List<ImageAfter> imageAfterList = new ArrayList<>();

    RecyclerView my_recycler_view,recyclerview1;
    RecyclerViewAdapter_check_problem_new recyclerViewAdapter_check_problem_new;
    RecyclerViewAdapter_check_problem_new adapter2;
    RelativeLayout r_save,open_camera;
    List<GetData_check_problem> getData_check_problems;
    GetData_check_problem getDataCheckProblem2;
    List<GetData_select_topic_problem_gory> getData_select_topic_problem_gories;
    List<GetData_select_topic_problem_main> getData_select_topic_problem_mains;
    List<GetData_select_topic_problem_sub> getData_select_topic_problem_subs;

    EditText new_message,inputText,edittext_se;
    ScrollView sv;
    TextView count_problem;
    ImageButton switcher,switcher2,ib_se;
    Button btn_report;
    CheckBox checkBox;
   LinearLayout linear_sale1,linear_sale2,linearlayout_show_problem_sub,linearlayout_show_problem_main,linear_status,linear_coler;
    TextView txt_namesale,txt_position,txt_teamcode,txt_boss,txt_bossposition,txt_status;
    ImageView handle,image_status;
    String getRefNo="",getCONTNO="",getEmpID="",getEmployeeName="",getPositionCode="",getPositionName="",getTeamHeadCode="",
            getTeamHeadName="",getTeamName="",getSupervisorHeadCode="",getSupervisorHeadName="",
            getSupervisorName="",getSubDepartmentHeadCode="",getSubDepartmentHeadName="",
            getSubDepartmentName="",getDepartmentHeadCode="",getDepartmentHeadName="",
            getDepartmentName="",getSubTeamCode="",getTeamCode="",getPicture="",contno_save="",check_sale_contno="";

    //
    String GET_JSON_DATA_HTTP_URL_INSENT_DATA_SALE="http://app.thiensurat.co.th/assanee/api_report_problem_from_contno/report_promlem_contno.php";
    String contno="";
    /********** get data sale of problem ******/
    List<GetData_sale_information> GetDataAdapter2;
    String JSON_RefNo="RefNo";
    String JSON_CONTNO="CONTNO";
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
    String JSON_InformID="InformID";
    String JSON_Contno_nontification_problem="Contno_nontification_problem";
    String JSON_InformEmpID="InformEmpID";
    String JSON_InformDepartID="InformDepartID";
    //
    public  static boolean menuOpen = false;
    //public  static boolean menuOpen_C = false;
    int check=0;
    int error=0;
    public static int size=0;
    public static boolean status_run_work= false;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    //  select topic problem
    String GET_JSON_DATA_HTTP_URL_gory = "http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_gory_problem.php";
    String GET_JSON_DATA_HTTP_URL_main="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_main_problem.php";
    String GET_JSON_DATA_HTTP_URL_sub="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_sub_problem.php";
    //

    //
    RecyclerViewDataAdapter_dialog_image_problem_from_id recyclerViewDataAdapter_dialog_image_problem_from_id;
    List<GetData_cedit_dialog_image_problem_from_id> getData_cedit_dialog_image_problem_from_ids;

    List<GetData_uploade_Image> getData_uploade_images;
    private Service uploadService;
    ProgressDialog progressDialog;
    SweetAlertDialog pDialogg,pDialogg2;
    private static final String SERVER_PATH = "http://app.thiensurat.co.th/assanee/";
    String PATH;
    //

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardview_row_cedit_cedit2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sv = (ScrollView)findViewById(R.id.scrl);
        spDemo= (Spinner)findViewById(R.id.spDemo);
        spDemo2= (Spinner) findViewById(R.id.spDemo2);
        spDemo3= (Spinner) findViewById(R.id.spDemo3);
        spDemo4= (Spinner) findViewById(R.id.spDemo4);
        count_problem= (TextView) findViewById(R.id.count_problem);
        new_message= (EditText) findViewById(R.id.new_message);
        my_recycler_view = (RecyclerView)findViewById(R.id.my_recycler_view);
        recyclerview1= (RecyclerView)findViewById(R.id.recyclerview1);
        r_save= (RelativeLayout)findViewById(R.id.r_save);
        open_camera= (RelativeLayout)findViewById(R.id.open_camera);
        linear_sale1= (LinearLayout)findViewById(R.id.linear_sale1);
        linear_sale2= (LinearLayout)findViewById(R.id.linear_sale2);
        inputText = (EditText)findViewById(R.id.inputText);
        switcher= (ImageButton)findViewById(R.id.switcher);
        switcher2= (ImageButton)findViewById(R.id.switcher2);


        handle= (ImageView)findViewById(R.id.handle);
        txt_namesale= (TextView)findViewById(R.id.txt_namesale);
        txt_position= (TextView)findViewById(R.id.txt_position);
        txt_teamcode= (TextView)findViewById(R.id.txt_teamcode);
        txt_boss= (TextView)findViewById(R.id.txt_boss);
        txt_bossposition= (TextView)findViewById(R.id.txt_bossposition);
        btn_report= (Button)findViewById(R.id.btn_report);

        linearlayout_show_problem_main= (LinearLayout)findViewById(R.id.linearlayout_show_problem_main);
        linearlayout_show_problem_sub= (LinearLayout)findViewById(R.id.linearlayout_show_problem_sub);
        linear_status= (LinearLayout)findViewById(R.id.linear_status);
        image_status= (ImageView)findViewById(R.id.image_status);
        txt_status= (TextView)findViewById(R.id.txt_status);
        linear_coler= (LinearLayout)findViewById(R.id.linear_coler);
        checkBox= (CheckBox)findViewById(R.id.checkBox);
        edittext_se = (EditText)findViewById(R.id.edittext_se);
        ib_se= (ImageButton)findViewById(R.id.ib_se);
        r_save.setOnClickListener(this);
        open_camera.setOnClickListener(this);
        switcher.setOnClickListener(this);
        switcher2.setOnClickListener(this);
        btn_report.setOnClickListener(this);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){

                    // if(!menuOpen_C) {
                    //menuOpen_C=true;
                    edittext_se.setVisibility(View.GONE);
                    ib_se.setVisibility(View.GONE);
                    spDemo4.setVisibility(View.VISIBLE);

                    //}


                }
                else {
                    //menuOpen_C=false;
                    edittext_se.setVisibility(View.VISIBLE);
                    ib_se.setVisibility(View.VISIBLE);
                    spDemo4.setVisibility(View.GONE);
                }
            }
        });


        allSampleData = new ArrayList<SectionDataModel>();
        singleItem = new ArrayList<SingleItemModel>();

        getData_check_problems=new ArrayList<>();
        getData_select_topic_problem_gories=new ArrayList<>();
        getData_select_topic_problem_mains=new ArrayList<>();
        getData_select_topic_problem_subs=new ArrayList<>();

        getData_cedit_dialog_image_problem_from_ids=new ArrayList<>();
        getData_uploade_images = new ArrayList<>();








        PackageManager m = getPackageManager();
        PATH = getPackageName();
        try {
            PackageInfo p = m.getPackageInfo(PATH, 0);
            PATH = p.applicationInfo.dataDir;
            Log.e("app path", PATH);
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("yourtag", "Error Package name not found ", e);
        }







        SELECT_DATA_PROBLEM_GORY();
        select_image();
        SELECT_DATA_PROBLEM_SQLITE_intro();


        //    sendData();
        my_recycler_view.setHasFixedSize(true);
        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(this, allSampleData,imageBeforeList);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        my_recycler_view.setAdapter(adapter);

        recyclerview1.setHasFixedSize(true);
        recyclerview1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));





        inputText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(inputText.getWindowToken(), 0);
                    //initListener();
                    contno=inputText.getText().toString();

                    pDialogg2 = new SweetAlertDialog(UI_CARDVIEW_CHECK_PROBLEM_NEW_Activity.this, SweetAlertDialog.PROGRESS_TYPE);
                    pDialogg2.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                    pDialogg2.setTitleText("กำลังค้นหาเลขที่สัญญา...");
                    pDialogg2.setCancelable(true);
                    pDialogg2.show();

                    INSENT_DATA_SALE();
                    return true;
                }
                return false;
            }
        });






        sv.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                int scrollY = sv.getScrollY(); // For ScrollView
                int scrollX = sv.getScrollX(); // For HorizontalScrollView

                Log.e("scrollY", String.valueOf(scrollY));
                Log.e("scrollX", String.valueOf(scrollX));

                if(scrollY>0){
                    hideMenu();
                    hideMenu2();
                    // linear_sale1.setVisibility(View.GONE);
                }
            }
        });

        inputText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideMenu();
                hideMenu2();
            }

        });



        String save="",cancal="";
        save = MyApplication.getInstance().getPrefManager().getPreferrence("save")+"";
        cancal = MyApplication.getInstance().getPrefManager().getPreferrence("cancal")+"";
        if(size>0){
            if(cancal.equals("0")) {

            }
            else {
                dialog_show_runing();
            }
        }
        else {

        }







        // **********************************************DATA USER*********************************************

        getRefNo = MyApplication.getInstance().getPrefManager().getPreferrence("getRefNo");
        getCONTNO = MyApplication.getInstance().getPrefManager().getPreferrence("getCONTNO");
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




        try {
            if(check_sale_contno.equals("0")){
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
            Glide.with(this).load(getPicture)



                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(this))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(this.getResources().getDrawable(R.drawable.dasaa))
                    .into(handle);
        }
        catch (Exception e) {

        }

        txt_namesale.setText(getEmployeeName);
        txt_position.setText(getPositionCode);
        txt_teamcode.setText(getTeamCode);

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
        // *******************************************DATA USER************************************************





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

                } else {

                }
            }
        });
    }





    public void INSENT_DATA_SALE() {

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_INSENT_DATA_SALE+"?contno="+contno ,


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

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

    }

    //check_sale_contno = MyApplication.getInstance().getPrefManager().getPreferrence("check");

    public void JSON_PARSE_DATA_AFTER_WEBCALL_INSENT_DATA_SALE(JSONArray array) {
        check=array.length();
        MyApplication.getInstance().getPrefManager().setPreferrence("check", String.valueOf(check));
        if(check==0){
           // switcher2.setVisibility(View.GONE);
            switcher2.setVisibility(View.VISIBLE);
            switcher2.setImageResource(R.drawable.errorerror);
            error=1;



            revealMenu2();

        }
        else {
            switcher2.setVisibility(View.VISIBLE);
            switcher2.setImageResource(R.drawable.check_box_report_problem);
            error=0;
            revealMenu();
        }
        for (int i = 0; i < array.length(); i++) {

            final GetData_sale_information GetDataAdapter2 = new GetData_sale_information();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);
                GetDataAdapter2.setRefNo(json.getString(JSON_RefNo));
                GetDataAdapter2.setCONTNO(json.getString(JSON_CONTNO));
                GetDataAdapter2.setEmpID(json.getString(JSON_EmpID));
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
                GetDataAdapter2.setInformID(json.getString(JSON_InformID));
                GetDataAdapter2.setContno_nontification_problem(json.getString(JSON_Contno_nontification_problem));
                GetDataAdapter2.setInformEmpID(json.getString(JSON_InformEmpID));
                GetDataAdapter2.setInformDepartID(json.getString(JSON_InformDepartID));









                try {
                    Glide.with(this).load(GetDataAdapter2.getPicture())



                            .crossFade()
                            .thumbnail(0.5f)
                            .bitmapTransform(new CircleTransform(this))
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .placeholder(this.getResources().getDrawable(R.drawable.dasaa))
                            .into(handle);
                }
                catch (Exception e) {

                }

                txt_namesale.setText(GetDataAdapter2.getEmployeeName());
                txt_position.setText(GetDataAdapter2.getPositionCode());
                txt_teamcode.setText(GetDataAdapter2.getTeamCode());

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
                    image_status.setBackgroundResource(R.drawable.ic_error_outline_white_24dp);
                    txt_status.setText("ยังไม่เคยเเจ้งป้ญหา");
                    linear_coler.setBackgroundResource(R.color.Plum);

                }
                else {
                    linear_status.setVisibility(View.VISIBLE);
                    image_status.setBackgroundResource(R.drawable.ic_check_circle_white_24dp);
                    txt_status.setText("เคยแจ้งปัญหาแล้ว");
                    linear_coler.setBackgroundResource(R.color.base_gray_green);
                }









                MyApplication.getInstance().getPrefManager().setPreferrence("getRefNo", GetDataAdapter2.getRefNo());
                MyApplication.getInstance().getPrefManager().setPreferrence("getCONTNO", GetDataAdapter2.getCONTNO());
                MyApplication.getInstance().getPrefManager().setPreferrence("getEmpID", GetDataAdapter2.getEmpID());
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

                MyApplication.getInstance().getPrefManager().setPreferrence("getInformID", GetDataAdapter2.getInformID());
                MyApplication.getInstance().getPrefManager().setPreferrence("getContno_nontification_problem", GetDataAdapter2.getContno_nontification_problem());
                MyApplication.getInstance().getPrefManager().setPreferrence("getInformEmpID", GetDataAdapter2.getInformEmpID());
                MyApplication.getInstance().getPrefManager().setPreferrence("getInformDepartID", GetDataAdapter2.getInformDepartID());

                MyApplication.getInstance().getPrefManager().setPreferrence("contno_save", contno);








            } catch (JSONException e) {

                e.printStackTrace();
            }
            //  GetDataAdapter1.add(GetDataAdapter2);

        }

        pDialogg2.cancel();

       // GetDataAdapter1.clear();
       // JSON_DATA_WEB_CALL();


    }

    String item="";
    public void SELECT_DATA_PROBLEM_GORY() {

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_gory ,


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

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

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
           adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, array2);
           //adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, android.R.id.text1, array2);
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
                }
                else {
                    spDemo2.setVisibility(View.VISIBLE);
                    spDemo3.setVisibility(View.VISIBLE);
                    linearlayout_show_problem_main.setVisibility(View.VISIBLE);
                    linearlayout_show_problem_sub.setVisibility(View.VISIBLE);
                }


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



    public void SELECT_DATA_PROBLEM_MAIN() {

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_main+"?ProblemID="+ID_GORY ,


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

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

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
            adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, array2);

        }

        spDemo2.setAdapter(adapter);

        spDemo2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                final GetData_select_topic_problem_main contact = getData_select_topic_problem_mains.get(position);
                 ID_MAIN= contact.getProblemID();
                getData_select_topic_problem_subs.clear();
                SELECT_DATA_PROBLEM_SUB();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });









    }


    public void SELECT_DATA_PROBLEM_SUB() {

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_sub+"?ProblemID="+ID_MAIN ,


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

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

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
                adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, array2);
            }
            catch (Exception ex){

            }


        }

        spDemo3.setAdapter(adapter);

        spDemo3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             //   String item = parent.getItemAtPosition(position).toString();
               final GetData_select_topic_problem_sub contact = getData_select_topic_problem_subs.get(position);

                if(item.equals("อื่นๆ")){
                    ID_SUB= "0";
                }
                else {
                    ID_SUB= contact.getProblemID();
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });









    }



public  void select_image(){
    allSampleData.clear();
    SQLiteDataBaseBuild();
    SQLiteTableBuild();
    for (int i = 1; i <=1; i++) {

        SectionDataModel dm = new SectionDataModel();

        dm.setHeaderTitle("ล่าสุด ");

     //   ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();







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

         size = singleItem.size();
        Log.e("size", String.valueOf(size));
        dm.setAllItemsInSection(singleItem);

        allSampleData.add(dm);


    }


    RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(this, allSampleData,imageBeforeList);
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


        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(this, allSampleData,imageBeforeList);
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
    String ProblemDetai="";
    String edittext_size="";
    @Override
    public void onClick(View view) {
        if(view==r_save){
            contno_save= MyApplication.getInstance().getPrefManager().getPreferrence("contno_save")+"";

            String strinputText = inputText.getText().toString();

            if(TextUtils.isEmpty(strinputText)) {
                inputText.setError("!กรุณาพิมพ์เลขที่สัญญา");



           // if((contno_save.equals("null"))|(contno_save.isEmpty())){
                long[] pattern = { 0, 200, 500 };
                Vibrator v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
                // Vibrate for 500 milliseconds
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    v.vibrate(VibrationEffect.createOneShot(200,VibrationEffect.DEFAULT_AMPLITUDE));
                }else{
                    //deprecated in API 26
                     v.vibrate(200);
                    //v.vibrate(pattern , 1);
                    //v.vibrate(new long[] { 500, 500, 500 });

                }


                SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE);
                sweetAlertDialog.setTitleText("เลขที่สัญญาไม่ถูกต้อง!");
                sweetAlertDialog.setContentText("*กรุณาลองใหม่อีกครั้ง*");
                sweetAlertDialog.setCancelable(true);
                sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {


                        Log.e("dialog","ปิด dialog");
                        sDialog.dismissWithAnimation();
                    }
                });
                sweetAlertDialog .show();




            }
            else {



                edittext_size= String.valueOf(new_message.getTextSize());


                if(item.equals("อื่นๆ")){

                    String strUserName = new_message.getText().toString();

                    if(TextUtils.isEmpty(strUserName)) {
                        new_message.setError("!กรุณาพิมพ์รายละเอียดปัญหาด้วย");
                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.showSoftInput(new_message, InputMethodManager.SHOW_IMPLICIT);


                        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            v.vibrate(VibrationEffect.createOneShot(200,VibrationEffect.DEFAULT_AMPLITUDE));
                        }else{ v.vibrate(200);
                        }


                      //  new_message.setHint("!กรุณาพิมพ์รายละเอียดปัญหาด้วย");
                       // new_message.setHintTextColor(0xffff0000);

                        return;
                    }

                    else {

                        Cursor cursor_id = sqLiteDatabase.rawQuery("SELECT COUNT (*)  FROM " + SQLiteHelper_problem_id_image.TABLE_NAME + "" + " WHERE part_id =" + "'" + ID_SUB + "'", null);

                        if (cursor_id.moveToFirst()) {
                            do {
                                count_id = cursor_id.getInt(0);
                                Log.e("count_id", String.valueOf(count_id));

                            } while (cursor_id.moveToNext());
                        }
                        cursor_id.close();

                        if (count_id > 0) {

                            // SQLiteDataBaseBuild2();
                            // SQLiteTableBuild2();
                            // sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_problem_id_image.TABLE_NAME+"");

                            //String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_problem_id_image.TABLE_NAME + " (part_id,part_image,Category,Main_problems,Sub_problems,topic,datetime) VALUES('" + ID_SUB + "','" + FA + "','" + Category + "','" + Main_problems + "','" + Sub_problems + "','" + topic + "','" + datetime + "');";
                            //sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
                            Log.e("ERROR", "มีข้อมูลอยุ่แล้ว");
                            Toast toast = Toast.makeText(this, "ปัญหานี้มีข้อมูลรอการเเจ้งแล้ว", Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            v.setTextColor(Color.RED);
                            toast.show();

                            //  Toast.makeText(getActivity(), "ปัญหานี้มีข้อมูลรอการเเจ้งแล้ว", Toast.LENGTH_SHORT).show();
                            return;
                        } else {


                            String Category = spDemo.getSelectedItem().toString()+"";
                            String Main_problems = "NULL";
                            String Sub_problems = "NULL";
                            String topic  = "อื่นๆ";




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
                                    Image_id_item = cursor_id2.getString(cursor_id2.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image))+"";
                                } while (cursor_id2.moveToNext());
                            }
                            cursor_id2.close();


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

                                FA_FA = "null";
                                String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_problem_id_image.TABLE_NAME + " (part_id,part_image,Category,Main_problems,Sub_problems,topic,datetime,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + FA_FA + "','" + Category + "','" + Main_problems + "','" + Sub_problems + "','" + topic + "','" + datetime + "','" + Url + "','" + Image_Name + "','" + Image_Size + "','" + Image_Type + "','" + Image_id_item + "');";
                                sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);

                            } else {
                                Log.e("CHECK_IMAGE", "have_image");

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

                                        String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_problem_id_image.TABLE_NAME + " (part_id,part_image,Category,Main_problems,Sub_problems,topic,datetime,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + FA_FA + "','" + Category + "','" + Main_problems + "','" + Sub_problems + "','" + topic + "','" + datetime + "','" + Url + "','" + Image_Name + "','" + Image_Size + "','" + Image_Type + "','" + Image_id_item + "');";
                                        sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);


                                        Log.e("rrrr", FA_FA);


                                    } while (cursor.moveToNext());
                                }
                                cursor.close();


                            }


                            SELECT_DATA_PROBLEM_SQLITE_intro();

                        }

                    }


                }
                else {
                    Cursor cursor_id = sqLiteDatabase.rawQuery("SELECT COUNT (*)  FROM " + SQLiteHelper_problem_id_image.TABLE_NAME + "" + " WHERE part_id =" + "'" + ID_SUB + "'", null);

                    if (cursor_id.moveToFirst()) {
                        do {
                            count_id = cursor_id.getInt(0);
                            Log.e("count_id", String.valueOf(count_id));

                        } while (cursor_id.moveToNext());
                    }
                    cursor_id.close();

                    if (count_id > 0) {

                        // SQLiteDataBaseBuild2();
                        // SQLiteTableBuild2();
                        // sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_problem_id_image.TABLE_NAME+"");

                        //String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_problem_id_image.TABLE_NAME + " (part_id,part_image,Category,Main_problems,Sub_problems,topic,datetime) VALUES('" + ID_SUB + "','" + FA + "','" + Category + "','" + Main_problems + "','" + Sub_problems + "','" + topic + "','" + datetime + "');";
                        //sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
                        Log.e("ERROR", "มีข้อมูลอยุ่แล้ว");
                        Toast toast = Toast.makeText(this, "ปัญหานี้มีข้อมูลรอการเเจ้งแล้ว", Toast.LENGTH_SHORT);
                        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                        v.setTextColor(Color.RED);
                        toast.show();

                        //  Toast.makeText(getActivity(), "ปัญหานี้มีข้อมูลรอการเเจ้งแล้ว", Toast.LENGTH_SHORT).show();
                        return;
                    } else {


                        String Category = spDemo.getSelectedItem().toString();
                        String Main_problems = spDemo2.getSelectedItem().toString();
                        String Sub_problems = spDemo3.getSelectedItem().toString();
                        String topic = new_message.getText().toString();




                        if (topic.isEmpty()) {
                            topic = "NULL";

                        } else {
                            topic = new_message.getText().toString();
                        }
                        String datetime = "";
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        datetime = sdf.format(new Date());


                        SQLiteDataBaseBuild();
                        SQLiteTableBuild();

                        SQLiteDataBaseBuild2();
                        SQLiteTableBuild2();


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
                                Image_id_item = cursor_id2.getString(cursor_id2.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image))+"";
                            } while (cursor_id2.moveToNext());
                        }
                        cursor_id2.close();


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

                            FA_FA = "null";
                            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_problem_id_image.TABLE_NAME + " (part_id,part_image,Category,Main_problems,Sub_problems,topic,datetime,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + FA_FA + "','" + Category + "','" + Main_problems + "','" + Sub_problems + "','" + topic + "','" + datetime + "','" + Url + "','" + Image_Name + "','" + Image_Size + "','" + Image_Type + "','" + Image_id_item + "');";
                            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);

                        } else {
                            Log.e("CHECK_IMAGE", "have_image");

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

                                    String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_problem_id_image.TABLE_NAME + " (part_id,part_image,Category,Main_problems,Sub_problems,topic,datetime,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + FA_FA + "','" + Category + "','" + Main_problems + "','" + Sub_problems + "','" + topic + "','" + datetime + "','" + Url + "','" + Image_Name + "','" + Image_Size + "','" + Image_Type + "','" + Image_id_item + "');";
                                    sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);


                                    Log.e("rrrr", FA_FA);


                                } while (cursor.moveToNext());
                            }
                            cursor.close();


                        }


                        SELECT_DATA_PROBLEM_SQLITE_intro();

                    }

                }

                }















        }
        else if(view==open_camera){
            contno_save= MyApplication.getInstance().getPrefManager().getPreferrence("contno_save")+"";

            String strinputText = inputText.getText().toString();

            if(TextUtils.isEmpty(strinputText)) {
                inputText.setError("!กรุณาพิมพ์เลขที่สัญญา");
            //if((contno_save.equals("null"))|(contno_save.isEmpty())){
                long[] pattern = { 0, 200, 500 };
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    v.vibrate(VibrationEffect.createOneShot(200,VibrationEffect.DEFAULT_AMPLITUDE));
                }else{

                    v.vibrate(200);
                    }


                SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE);
                sweetAlertDialog.setTitleText("เลขที่สัญญาไม่ถูกต้อง!");
                sweetAlertDialog.setContentText("*กรุณาลองใหม่อีกครั้ง*");
                sweetAlertDialog.setCancelable(true);
                sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {


                        Log.e("dialog","ปิด dialog");
                        sDialog.dismissWithAnimation();
                    }
                });
                sweetAlertDialog .show();

            }
            else {
                CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                ic = new ImageConfiguration(this,PATH);
                file = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                        "report_problem", "ALL");
                fileUri = Uri.fromFile(file);
                CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                startActivityForResult(CamIntent, 1);
            }
        }
        else if(view==switcher){

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
          // Log.e("size", String.valueOf(getData_check_problems.size()));
            contno_save= MyApplication.getInstance().getPrefManager().getPreferrence("contno_save")+"";
           if(getData_check_problems.size()==0){
               SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE);
               sweetAlertDialog.setTitleText("ไม่มีรายการปัญหา!");
               sweetAlertDialog.setContentText("*กรุณาบันทึกรายการ*");
               sweetAlertDialog.setCancelable(true);
               sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                   @Override
                   public void onClick(SweetAlertDialog sDialog) {


                       Log.e("dialog","ปิด dialog");
                       sDialog.dismissWithAnimation();
                   }
               });
               sweetAlertDialog .show();
           }
           else {
               String strinputText = inputText.getText().toString();

               if(TextUtils.isEmpty(strinputText)) {
                   inputText.setError("!กรุณาพิมพ์เลขที่สัญญา");
              // if((contno_save.equals("null"))|(contno_save.isEmpty())){
                   long[] pattern = { 0, 200, 500 };
                   Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                   if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                       v.vibrate(VibrationEffect.createOneShot(200,VibrationEffect.DEFAULT_AMPLITUDE));
                   }else{

                       v.vibrate(200);
                   }


                   SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE);
                   sweetAlertDialog.setTitleText("เลขที่สัญญาไม่ถูกต้อง!");
                   sweetAlertDialog.setContentText("*กรุณาลองใหม่อีกครั้ง*");
                   sweetAlertDialog.setCancelable(true);
                   sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                       @Override
                       public void onClick(SweetAlertDialog sDialog) {


                           Log.e("dialog","ปิด dialog");
                           sDialog.dismissWithAnimation();
                       }
                   });
                   sweetAlertDialog .show();

               }
               else {


                   INSENT_Problem_Master();
                   select_id_from_Problem_Inform_Master();

               }







           }

        }
    }



    String part_id="";
    String part_image="";
    String Category="";
    String Main_problems="";
    String Sub_problems="";
    String topic="";
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
                    datetime=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_datetime));

                    Url=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Url));
                    Image_Name=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Image_Name));
                    Image_Size=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Image_Size));
                    Image_Type=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Image_Type));
                    Image_id_item=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_order_image));




                    INSENT_Problem_Inform_Details_Images();


                } while (cursor.moveToNext());
            }
            cursor.close();




            File file = new File(String.valueOf(contact.getImage()));
            builder.addFormDataPart("file[]", file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file));
        }

        File file = new File("");
        MultipartBody requestBody = builder.build();
        Call<ResponseBody> call = uploadService.uploadMultiFile(requestBody);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {

                //  Toast.makeText(getActivity(), "Success " + response.message(), Toast.LENGTH_LONG).show();
                //  Toast.makeText(getActivity(), "Success " + response.body().toString(), Toast.LENGTH_LONG).show();


                SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(UI_CARDVIEW_CHECK_PROBLEM_NEW_Activity.this, SweetAlertDialog.SUCCESS_TYPE);
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


                        /*
                        File storageDir2 =  null ;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
                            storageDir2 =getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("contno_save") + "/"+"report_problem"+ "/"+"ID"+"ALL"+"/"+"image_error"+ "/");

                        }

                        File image[]= storageDir2.listFiles();
                        int da= image.length;
                        for(int i=0;i<da;i++) {
                            String DF = String.valueOf(image[i]);

                            Log.e("image_success",DF);
                            File fdelete = new File(DF);
                            boolean deleted = fdelete.delete();

                        }
                        */



                        Log.e("dialog","ปิด dialog");
                        sDialog.dismissWithAnimation();
                    }
                });
                sweetAlertDialog .show();





                File file = new File("/storage/sdcard0/Android/data/com.tsr.tsrproblemreport/files/Pictures/70102489/report_problem/ID1/image_error/image_error_20180406070126-1473976226.jpg");
                double length = file.length();
                length = length/1024;

                Log.e("imageName", file.getPath() + ", File size : " + length +" KB");
                getData_uploade_images.clear();
                pDialogg.dismiss();
                pDialogg.cancel();

                getData_check_problems.clear();  //เคลียร์ recycle problem real
                adapter2.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                pDialogg.dismiss();
                pDialogg.cancel();
              //  Log.d(TAG, "Error " + t.getMessage());

                new SweetAlertDialog(UI_CARDVIEW_CHECK_PROBLEM_NEW_Activity.this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("ผิดพลาด!")
                        .setContentText(t.getMessage()+"\n*")

                        .show();

            }
        });


    }



    //String GET_JSON_insent_Problem_Inform_Master="http://app.thiensurat.co.th/assanee/api_report_problem_from_contno/insent_Problem_Inform_Master.php";
    //String GET_JSON_insent_Problem_Inform_Details="http://app.thiensurat.co.th/assanee/api_report_problem_from_contno/insent_Problem_Inform_Details.php";
    //String GET_JSON_insent_Problem_Inform_Details_Images="http://app.thiensurat.co.th/assanee/api_report_problem_from_contno/insent_Problem_Inform_Details_Images.php";

    //String GET_JSON_insent_Problem_Inform_Master="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Master.php";
    //String GET_JSON_insent_Problem_Inform_Details="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Details.php";
    //String GET_JSON_insent_Problem_Inform_Details_Images="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Details_Images.php";
    //String GET_JSON_select_id_from_Problem_Inform_Master="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_id_from_Problem_Inform_Master.php";

    String GET_JSON_insent_Problem_Inform_Master="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Master_Copy.php";
    String GET_JSON_insent_Problem_Inform_Details="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Details_Copy.php";
    String GET_JSON_insent_Problem_Inform_Details_Images="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Details_Images_Copy.php";
    String GET_JSON_select_id_from_Problem_Inform_Master="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_id_from_Problem_Inform_Master_Copy.php";
    //
    //


    String Problem_Status="";
    public   void INSENT_Problem_Master(){



        String Contno=MyApplication.getInstance().getPrefManager().getPreferrence("contno_save");
        String InformEmpID=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        String InformDepartID=MyApplication.getInstance().getPrefManager().getPreferrence("DepartId");
        String AdminEmpID="NULL";
        String AdminDepartID="NULL";
        String WorkCode="00";
        String user_code=MyApplication.getInstance().getPrefManager().getPreferrence("getEmpID");
        String ipaddress=MyApplication.getInstance().getPrefManager().getPreferrence("IPaddress");
        String computername=MyApplication.getInstance().getPrefManager().getPreferrence("android_name");
        String NoteData="NULL";
        String InformStatus="1";

        try {
            Log.e("URL_Master",GET_JSON_insent_Problem_Inform_Master+"?Contno="+Contno+"&InformEmpID="+InformEmpID+"&InformDepartID="+InformDepartID+"&AdminEmpID="+AdminEmpID+"&AdminDepartID="+AdminDepartID+"&WorkCode="+WorkCode+"&user_code="+user_code+"&ipaddress="+ipaddress+"&computername="+URLEncoder.encode(computername, "UTF-8")+"&NoteData="+NoteData+"&InformStatus="+InformStatus);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_insent_Problem_Inform_Master+"?Contno="+Contno+"&InformEmpID="+InformEmpID+"&InformDepartID="+InformDepartID+"&AdminEmpID="+AdminEmpID+"&AdminDepartID="+AdminDepartID+"&WorkCode="+WorkCode+"&user_code="+user_code+"&ipaddress="+ipaddress+"&computername="+ URLEncoder.encode(computername, "UTF-8")+"&NoteData="+NoteData+"&InformStatus="+InformStatus,


                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            //INSENT_Problem_details();

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


    public void select_id_from_Problem_Inform_Master(){


            jsonArrayRequest = new JsonArrayRequest(GET_JSON_select_id_from_Problem_Inform_Master,


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


        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);
    }


    String InformID="";
    String InformID_REAL="";
    public void JSON_PARSE_DATA_AFTER_select_id_from_Problem_Inform_Master(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            //final GetData_select_topic_problem_sub GetDataAdapter2 = new GetData_select_topic_problem_sub();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
               // GetDataAdapter2.setProblemID(json.getString("InformID"));
                 InformID=json.getString("InformID");
                // MyApplication.getInstance().getPrefManager().setPreferrence("InformID", InformID);

                Log.e("InformID_intro",InformID);



            } catch (JSONException e) {

                e.printStackTrace();
            }
            //getData_select_topic_problem_subs.add(GetDataAdapter2);
            // value=GetDataAdapter2.getProblemName();
        }



        InformID_REAL=InformID;


        Cursor cursor_id = sqLiteDatabase.rawQuery("SELECT DISTINCT part_id,topic  FROM " + SQLiteHelper_problem_id_image.TABLE_NAME, null);

        if (cursor_id.moveToFirst()) {
            do {
                part_id_details = cursor_id.getString(cursor_id.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_id));
                ProblemDetai= cursor_id.getString(cursor_id.getColumnIndex(SQLiteHelper_problem_id_image.Table_topic));
                Log.e("part_idfdddd", part_id_details);

                INSENT_Problem_Details();



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


        pDialogg = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialogg.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialogg.setTitleText("กำลังอัปโหลด...");
        pDialogg.setCancelable(false);
        uploadMultiFile();



    }



    public   void INSENT_Problem_Details(){



        //String ProblemID=InformID;
        Log.e("InformID1",InformID);
        String ProblemTopic="NULL";
        String ProblemDetail=ProblemDetai;
        String CheckNote="NULL";
        String ProblemStatus="1";
      //  Log.e("InformID2",MyApplication.getInstance().getPrefManager().getPreferrence("InformID"));




        try {
            Log.e("URL_Details",GET_JSON_insent_Problem_Inform_Details+"?InformID="+MyApplication.getInstance().getPrefManager().getPreferrence("InformID")+"&ProblemID="+part_id_details+"&ProblemTopic="+ProblemTopic+"&ProblemDetail="+URLEncoder.encode(ProblemDetail, "UTF-8")+"&CheckNote="+CheckNote+"&ProblemStatus="+ProblemStatus);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_insent_Problem_Inform_Details+"?InformID="+InformID_REAL+"&ProblemID="+part_id_details+"&ProblemTopic="+ProblemTopic+"&ProblemDetail="+URLEncoder.encode(ProblemDetail, "UTF-8")+"&CheckNote="+CheckNote+"&ProblemStatus="+ProblemStatus,


                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            //INSENT_Problem_details();

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




    private  void INSENT_Problem_Inform_Details_Images(){


        String ProblemID=part_id;
        String ImageItem=Image_id_item ;




        String ImageUrl=Url;
        String ImageName=Image_Name;
        String ImageSize=Image_Size;
        String ImageType =Image_Type;
        Log.e("InformID1",InformID);
     //   Log.e("InformID2",MyApplication.getInstance().getPrefManager().getPreferrence("InformID"));
        //Log.e("URL_Details_Images",GET_JSON_insent_Problem_Inform_Details_Images+"?InformID="+MyApplication.getInstance().getPrefManager().getPreferrence("InformID")+"&ProblemID="+ProblemID+"&ImageItem="+ImageItem+"&ImageUrl="+ImageUrl+"&ImageName="+ImageName+"&ImageSize="+ImageSize+"&ImageType="+ImageType);

//MyApplication.getInstance().getPrefManager().getPreferrence("InformID")

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_insent_Problem_Inform_Details_Images+"?InformID="+InformID_REAL+"&ProblemID="+ProblemID+"&ImageItem="+ImageItem+"&ImageUrl="+ImageUrl+"&ImageName="+ImageName+"&ImageSize="+ImageSize+"&ImageType="+ImageType,


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


    int idid2;
    public  void  SELECT_DATA_PROBLEM_SQLITE_intro(){
        order_image=0;

        allSampleData.clear();
        SQLiteDataBaseBuild();
        SQLiteTableBuild();
        sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper_image_buffer.TABLE_NAME+"");


       // allSampleData.clear();
        getData_check_problems.clear();
        SQLiteDataBaseBuild2();
        SQLiteTableBuild2();



        for(idid2 =0;idid2<100;idid2++) {
            GetData_check_problem getDataCheckProblem =new GetData_check_problem();

            cursor = sqLiteDatabase.rawQuery("SELECT count(*) as ddd,part_id,part_image,Category,Main_problems,Sub_problems,topic,datetime  FROM " + SQLiteHelper_problem_id_image.TABLE_NAME + "" + " WHERE part_id =" + "'" + idid2 + "'" + " ORDER BY datetime DESC LIMIT 1", null);

            if (cursor.moveToFirst()) {
                do {
                    int count = cursor.getInt(0);
                    //String FA=cursor.getString(count(*));
                    Log.e("count999", String.valueOf(count));
                    String part_id=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_id));
                    String part_image=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_image));
                    String Category=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Category));
                    String Main_problems=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Main_problems));
                    String Sub_problems=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_Sub_problems));
                    String topic=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_topic));
                    String datetime=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_datetime));



                    if(count!=0){
                        Log.e("dada",part_image+Category+Main_problems+Sub_problems+topic+datetime);
                        getDataCheckProblem.setPart_id(String.valueOf(part_id));
                        getDataCheckProblem.setCount_image(String.valueOf(count));

                        getDataCheckProblem.setCategory(Category);
                        getDataCheckProblem.setMain_problems(Main_problems);
                        getDataCheckProblem.setSub_problems(Sub_problems);
                        getDataCheckProblem.setSubject(topic);
                        getDataCheckProblem.setDatetime(datetime);
                        getDataCheckProblem.setImage(part_image);

                        getData_check_problems.add(getDataCheckProblem);
                    }

                } while (cursor.moveToNext());
            }
            cursor.close();




/*
            cursor = sqLiteDatabase.rawQuery("SELECT count(*) as ddd,part_image,Category,Main_problems,Sub_problems,topic,datetime FROM " + SQLiteHelper_problem_id_image.TABLE_NAME + "" + " WHERE part_id =" + "'" + idid2 + "'" + " ORDER BY part_image DESC LIMIT 1", null);

            if (cursor.moveToFirst()) {
                do {
                    int count = cursor.getInt(0);

                   Log.e("count555", String.valueOf(count));
                    if(count!=0){
                        Log.e("part_image",part_image);




                    }

                } while (cursor.moveToNext());
            }
            cursor.close();
*/




        }

         adapter2 = new RecyclerViewAdapter_check_problem_new(getData_check_problems,this);
        recyclerview1.setAdapter(adapter2);
        adapter2.setitemclick_deleteAll(this);
        adapter2.setitemclick_image_problem_incorrect(this);

        int ds=getData_check_problems.size();
        String is = String.valueOf(ds);
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

    int order_image=0;
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
                CropImage();
            }

        }

        else if (requestCode == 2){
            order_image=order_image+1;
            String FILE=file.getAbsolutePath();

            String image_name=MyApplication.getInstance().getPrefManager().getPreferrence("imageName");

            Log.e("image_name",image_name);

            String Url="http://app.thiensurat.co.th/assanee/uploads_image_report_problem/"+image_name+".jpg";
            Log.e("Url_image_name",Url);

            File file2 = new File(FILE);
            long length = file2.length();
            length = length/1024;

            Log.e("FILE",FILE);
        String number= String.valueOf(1);

            SQLiteDataBaseBuild();
            SQLiteTableBuild();

            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper_image_buffer.TABLE_NAME + " (part_id,name_image,url_image,Url,Image_Name,Image_Size,Image_Type,order_image) VALUES('" + ID_SUB + "','" + number + "','" + FILE + "','" + Url + "','" + image_name + "','" + length + "','" + "jpg" + "','" + order_image + "');";
            // String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (part_id,part_image,type_image) VALUES('" + id_image_success + "', '" + file.getAbsolutePath() + "', '" + "image_success" + "');";
            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
















            for (int i = 1; i <=1; i++) {

                SectionDataModel dm = new SectionDataModel();

                dm.setHeaderTitle("ล่าสุด ");

                ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();







                cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper_image_buffer.TABLE_NAME+""   , null);

                if (cursor.moveToFirst()) {
                    do {

                        String FA=cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_url_image));
                        String f=cursor.getString(cursor.getColumnIndex(SQLiteHelper_image_buffer.Table_order_image));
                        Log.e("A", FA);

                       // GetDataAdapter2.setMp3_thumbnail_s2(json.getString("artist_image_thumb"));

                       // String f= String.valueOf(order_image);
                        singleItem.add(new SingleItemModel("รูป "+f,FA));

                        size=singleItem.size();
                        MyApplication.getInstance().getPrefManager().setPreferrence("cancal", "1");
                    } while (cursor.moveToNext());
                }
                cursor.close();


                dm.setAllItemsInSection(singleItem);

                allSampleData.add(dm);


            }


            RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(this, allSampleData,imageBeforeList);
            my_recycler_view.setAdapter(adapter);



        }





    }

    public void SQLiteDataBaseBuild(){

        sqLiteDatabase =openOrCreateDatabase(SQLiteHelper_image_buffer.DATABASE_NAME, Context.MODE_PRIVATE, null);

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

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_problem_id_image.TABLE_NAME+"("+ SQLiteHelper_problem_id_image.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_problem_id_image.Table_part_id+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_part_image+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_Category+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_Main_problems+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_Sub_problems+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_topic+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_datetime+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_Url+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_Image_Name+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_Image_Size+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_Image_Type+" VARCHAR, "+SQLiteHelper_problem_id_image.Table_order_image+" VARCHAR);");


    }

    public void revealMenu() {
        menuOpen = true;

        linear_sale1.setVisibility(View.VISIBLE);
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
        //overlay.setVisibility(View.GONE);
        anim.start();


        // Animate The Icons One after the other, I really would like to know if there is any
        // simpler way to do it
        @SuppressLint("ResourceType") Animation popeup1 = AnimationUtils.loadAnimation(this, R.animator.popeup);
        @SuppressLint("ResourceType") Animation popeup2 = AnimationUtils.loadAnimation(this, R.animator.popeup);
        @SuppressLint("ResourceType") Animation popeup3 = AnimationUtils.loadAnimation(this, R.animator.popeup);
        @SuppressLint("ResourceType") Animation popeup4 = AnimationUtils.loadAnimation(this, R.animator.popeup);
        @SuppressLint("ResourceType") Animation popeup5 = AnimationUtils.loadAnimation(this, R.animator.popeup);
        @SuppressLint("ResourceType") Animation popeup6 = AnimationUtils.loadAnimation(this, R.animator.popeup);
        popeup1.setStartOffset(50);
        popeup2.setStartOffset(100);
        popeup3.setStartOffset(150);
        popeup4.setStartOffset(200);
        popeup5.setStartOffset(250);
        popeup6.setStartOffset(300);


    }



    public void hideMenu() {
        menuOpen = false;
        int cx = linear_sale1.getRight() - 200;
        int cy = linear_sale1.getTop();
        int initialRadius = linear_sale1.getWidth();
        Animator anim = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            anim = ViewAnimationUtils.createCircularReveal(linear_sale1, cx, cy, initialRadius, 0);
        }
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                linear_sale1.setVisibility(View.INVISIBLE);
                linear_sale1.setVisibility(View.GONE);
                // overlay.setVisibility(View.INVISIBLE);
                // overlay.setVisibility(View.GONE);
            }
        });
        anim.start();
    }







    public void revealMenu2() {
        menuOpen = true;

        linear_sale2.setVisibility(View.VISIBLE);
        int cx = linear_sale2.getRight() - 200;
        int cy = linear_sale2.getTop();
        int finalRadius = Math.max(linear_sale2.getWidth(), linear_sale2.getHeight());
        Animator anim =
                null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            anim = ViewAnimationUtils.createCircularReveal(linear_sale2, cx, cy, 0, finalRadius);
        }
        anim.setDuration(600);
        linear_sale2.setVisibility(View.VISIBLE);
        //overlay.setVisibility(View.GONE);
        anim.start();


        // Animate The Icons One after the other, I really would like to know if there is any
        // simpler way to do it
        @SuppressLint("ResourceType") Animation popeup1 = AnimationUtils.loadAnimation(this, R.animator.popeup);
        @SuppressLint("ResourceType") Animation popeup2 = AnimationUtils.loadAnimation(this, R.animator.popeup);
        @SuppressLint("ResourceType") Animation popeup3 = AnimationUtils.loadAnimation(this, R.animator.popeup);
        @SuppressLint("ResourceType") Animation popeup4 = AnimationUtils.loadAnimation(this, R.animator.popeup);
        @SuppressLint("ResourceType") Animation popeup5 = AnimationUtils.loadAnimation(this, R.animator.popeup);
        @SuppressLint("ResourceType") Animation popeup6 = AnimationUtils.loadAnimation(this, R.animator.popeup);
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
        Animator anim = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            anim = ViewAnimationUtils.createCircularReveal(linear_sale2, cx, cy, initialRadius, 0);
        }
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











    public void onPause() {
        super.onPause();

     //   dialog_show_runing();
        Log.e("Check", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();

       // dialog_show_runing();
        Log.e("Check", "onStop");
    }


    private void dialog_show_runing(){
        final Dialog dialog = new Dialog(this);
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
                Intent mIntent = new Intent( UI_CARDVIEW_CHECK_PROBLEM_NEW_Activity.this, LOGIN_MAIN.class);
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
                Intent mIntent = new Intent( UI_CARDVIEW_CHECK_PROBLEM_NEW_Activity.this, LOGIN_MAIN.class);
                startActivity(mIntent);
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        dialog.show();
    }
    private void sendData()
    {
        //INTENT OBJ
        Intent i = new Intent(this.getBaseContext(),
                MusicActivity_Credit.class);

        //PACK DATA
        i.putExtra("SENDER_KEY", "MyFragment");
        i.putExtra("NAME_KEY", "KKK");
        i.putExtra("YEAR_KEY", "dddd");

        //RESET WIDGETS
        //  nameFragTxt.setText("");
        // launchYearSpinner.setSelection(0);

        //START ACTIVITY
       startActivity(i);
    }

    @Override
    public void click_deleteAll(View v, int position) {
        final GetData_check_problem getDataAdapter1 =  getData_check_problems.get(position);
        Log.e("idididid",getDataAdapter1.getPart_id());
        getDataAdapter1.getPart_id();
        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
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
        }

    @Override
    public void click_image_problem_incorrect(View v, int position) {
        getData_cedit_dialog_image_problem_from_ids.clear();

        final GetData_check_problem getDataAdapter1 =  getData_check_problems.get(position);
        Log.e("image_view",getDataAdapter1.getPart_id());


        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.mp3_online_list_single_recycleview_dialog_custom_image_problem);
        dialog.setCancelable(true);
       // final TextView tvTitle = (TextView) dialog.findViewById(R.id.tvTitle);
        //final ImageView itemImage = (ImageView) dialog.findViewById(R.id.itemImage);
        final RecyclerView recycler_view = (RecyclerView) dialog.findViewById(R.id.recycler_view);

        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        GetData_cedit_dialog_image_problem_from_id dataCeditDialogImageProblemFromId =new  GetData_cedit_dialog_image_problem_from_id();
        //tvTitle.setText(singleItem.getName());






        cursor = sqLiteDatabase.rawQuery("SELECT part_image  FROM " + SQLiteHelper_problem_id_image.TABLE_NAME + "" + " WHERE part_id =" + "'" + getDataAdapter1.getPart_id() + "'" , null);

        if (cursor.moveToFirst()) {
            do {

                String part_image=cursor.getString(cursor.getColumnIndex(SQLiteHelper_problem_id_image.Table_part_image));
                dataCeditDialogImageProblemFromId.setImage_id_all(part_image);
                getData_cedit_dialog_image_problem_from_ids.add(dataCeditDialogImageProblemFromId);
            } while (cursor.moveToNext());
        }
        cursor.close();

            recyclerViewDataAdapter_dialog_image_problem_from_id = new RecyclerViewDataAdapter_dialog_image_problem_from_id(this, (ArrayList<GetData_cedit_dialog_image_problem_from_id>) getData_cedit_dialog_image_problem_from_ids);
            recycler_view.setAdapter(recyclerViewDataAdapter_dialog_image_problem_from_id);

        dialog.show();
    }



















}
