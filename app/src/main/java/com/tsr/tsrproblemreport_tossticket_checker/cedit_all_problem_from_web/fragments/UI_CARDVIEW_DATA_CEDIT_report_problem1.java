package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
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
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.zagum.speechrecognitionview.RecognitionProgressView;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.IMAGE_report_problem_all_id;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.RecyclerViewAdapterCheckBox;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.databases.SQLiteHelper;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetDataAdapterCheckBox;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_remove_image_select_id;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_sale_information;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_uploade_Image;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.activity.MainActivity_qr_report_problem;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.uploads_image.Service;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.utils.ImageConfiguration;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.CircleTransform;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
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

import static android.app.Activity.RESULT_OK;

public class UI_CARDVIEW_DATA_CEDIT_report_problem1 extends Fragment  implements View.OnClickListener,RecyclerViewAdapterCheckBox.itemclick2, RecyclerViewAdapterCheckBox.itemclick_image_sucess, RecyclerViewAdapterCheckBox.itemclick_image_ic_dete1, RecyclerViewAdapterCheckBox.itemclick_image_ic_dete2, RecyclerViewAdapterCheckBox.itemclick_photograph_image_error, RecyclerViewAdapterCheckBox.itemclick_photograph_image_success,RecyclerViewAdapterCheckBox.MessageAdapterListener{



    List<GetDataAdapterCheckBox> GetDataAdapter1;

    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/groud_problem_genaral.php";
    String GET_insent_report_problem="http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/insert_report_problem.php";
String GET_JSON_DATA_HTTP_URL_INSENT_DATA_SALE="http://app.thiensurat.co.th/assanee/api_report_problem_from_contno/report_promlem_contno.php";

    RecyclerViewAdapterCheckBox recyclerViewadapter1;
    String JSON_ID = "id_ge";
    String JSON_PROBLEM = "topic_problem_ge";

    RecyclerView recyclerView;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    JsonArrayRequest jsonArrayRequest ;
    RequestQueue requestQueue ;
    RelativeLayout relativeLayout;
    SwipeRefreshLayout swipeRefreshLayout;
    FloatingActionButton floatingActionButton;

    StringBuilder stringBuilder,stringBuilder2,stringBuilder3,stringBuilder4;
    String DADA,DADA2,DADA3;
    StringBuilder kaka;

    String Description="";

    private SpeechRecognizer speechRecognizer;
    RecognitionProgressView recognitionProgressView;
    Intent intent;
    private boolean mIslistening;
    ImageView on_mic,handle;
    private static final int REQUEST_RECORD_AUDIO_PERMISSION_CODE = 1;

    public  static boolean open_mic = false;

    TextView txt_namesale,txt_position,txt_teamcode,txt_boss,txt_bossposition;

    String getRefNo="",getCONTNO="",getEmpID="",getEmployeeName="",getPositionCode="",getPositionName="",getTeamHeadCode="",
            getTeamHeadName="",getTeamName="",getSupervisorHeadCode="",getSupervisorHeadName="",
            getSupervisorName="",getSubDepartmentHeadCode="",getSubDepartmentHeadName="",
            getSubDepartmentName="",getDepartmentHeadCode="",getDepartmentHeadName="",
            getDepartmentName="",getSubTeamCode="",getTeamCode="",getPicture="",contno_save="",check_sale_contno="";

    private EditText inputText,new_message;
    private  ImageButton switcher;




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

    String contno="";
    String url_part="";
    /********** get data sale of problem ******/


    /******    cick image error,sucess*****/
    Intent CamIntent,GalIntent,CropIntent,CropIntent2;
    File file;
    Uri uri;
    int position_image_error,position_image_sucess,position_image_delete1,position_image_delete2;
    Bitmap bitmap;
    String filePath = null;
    Bitmap bmplogo=null;
    View image_error;
    View image_sucess;
    String logo="";
    GetDataAdapterCheckBox getDataAdapterCheckBox;

    LinearLayout linear_sale1,linear_sale2;
    int check=0;
    int position_recycle_view=0;
    int o;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    File storageDir =  null ;

    /****     upload image***/
    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int REQUEST_GALLERY_CODE = 200;
    private static final int READ_REQUEST_CODE = 300;
    private static final String SERVER_PATH = "http://app.thiensurat.co.th/assanee/";

    private Service uploadService;
    ProgressDialog progressDialog;
    SweetAlertDialog pDialogg;
    List<GetData_uploade_Image> getData_uploade_images;
    int count_menu,count_menu2;

    /****     upload image***/

//private ActionModeCallback actionModeCallback;
    //private ActionMode actionMode;

    /****    ลบรูปใน FOLDER ID ทั้งหมดที่เลือก***/
    List<GetData_cedit_remove_image_select_id> remove_image_select_id;
    /****    ลบรูปใน FOLDER ID ทั้งหมดที่เลือก***/

    /***  insent problem master **/
    /***  insent problem image **/
    /***  insent problem details **/
    String part_id="";
    String part_image="";
    String type_image="";

    String Problem_Type_ID="";
    String Problem_TypeDeteils_ID="";
    String Url="";
    String Image_Name="";
    String Image_Size="";
    String Image_Type="";
    String id_problem="";
    String PATH;
    /***  insent problem master **/
    /***  insent problem image **/
    /***  insent problem details **/
    String node_message="";
    /******    cick image error,sucess*****/




    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

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

        contno_save = MyApplication.getInstance().getPrefManager().getPreferrence("contno_save");
        check_sale_contno = MyApplication.getInstance().getPrefManager().getPreferrence("check");
        inputText.setText(contno_save);


        try {
            if(check_sale_contno.equals("0")){
                linear_sale1.setVisibility(View.GONE);
                linear_sale2.setVisibility(View.GONE);
            }
            else {
                linear_sale1.setVisibility(View.VISIBLE);
                linear_sale2.setVisibility(View.VISIBLE);
            }
        }
        catch (Exception e){

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



        PackageManager m = getActivity().getPackageManager();
        PATH =  getActivity().getPackageName();
        try {
            PackageInfo p = m.getPackageInfo(PATH, 0);
            PATH = p.applicationInfo.dataDir;
            Log.e("app path", PATH);
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("yourtag", "Error Package name not found ", e);
        }



        recyclerView.setHasFixedSize(true);

        recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(recyclerViewlayoutManager);





        // recognitionProgressView ******************************
        int[] colors = {
                ContextCompat.getColor(getActivity(), R.color.color1),
                ContextCompat.getColor(getActivity(), R.color.color2),
                ContextCompat.getColor(getActivity(), R.color.color3),
                ContextCompat.getColor(getActivity(), R.color.color4),
                ContextCompat.getColor(getActivity(), R.color.color5)
        };

//    int[] heights = { 20, 24, 18, 23, 16 };
        int[] heights = {60, 76, 58, 80, 55};
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(getActivity());


        recognitionProgressView.setSpeechRecognizer(speechRecognizer);
        // recognitionProgressView ******************************
        startRecognition();
        recognitionProgressView.setColors(colors);
        recognitionProgressView.setBarMaxHeightsInDp(heights);
        recognitionProgressView.setCircleRadiusInDp(2);
        recognitionProgressView.setSpacingInDp(2);
        recognitionProgressView.setIdleStateAmplitudeInDp(2);
        recognitionProgressView.setRotationRadiusInDp(10);
        recognitionProgressView.play();



       // del_image_report_problem_to_device();




        SQLiteDataBaseBuild();
        SQLiteTableBuild();



        DADA="1,2";
        String arr2[] = DADA.split(",");
        int count_id=arr2.length;

        Log.e("count_id", String.valueOf(count_id));

        int i;
        for( i=0;i<count_id;i++){
            Log.e("count_id",arr2[i]);





            File storageDir =  null ;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
                storageDir =getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("contno_save") + "/"+"report_problem"+ "/"+"ID"+arr2[i]+"/"+"image_error"+ "/");

            }

            File image[]= storageDir.listFiles();
            int da= image.length;
            for(int e=0;e<da;e++) {
                String DF = String.valueOf(image[e]);
                Log.e("DF",DF);
            }




            File storageDir2 =  null ;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
                storageDir2 =getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("contno_save") + "/"+"report_problem"+ "/"+"ID"+arr2[i]+"/"+"image_success"+ "/");

            }

            File image2[]= storageDir2.listFiles();
            int da2= image2.length;
            for(int e2=0;e2<da2;e2++) {
                String DF2 = String.valueOf(image2[e2]);
                Log.e("DF2",DF2);
            }


        }




        //ShowSQLiteDBdata();



        /*
         storageDir =  null ;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
            storageDir =getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("contno_save") + "/"+"report_problem"+ "/");

            File image[]= storageDir.listFiles();
            int da= image.length;
            GetDataAdapterCheckBox_image_id getDataAdapterCheckBox_image_id;
            List<GetDataAdapterCheckBox_image_id> list_image=new ArrayList<>();

            for(o=0;o<da;o++){
                Log.e("url", String.valueOf(image[o]));
                // storageDir=storageDir+image[o];
                storageDir =new File(image[o]+"/");

                File image2[]= storageDir.listFiles();
                int da2= image2.length;

                getDataAdapterCheckBox_image_id=new GetDataAdapterCheckBox_image_id();
                getDataAdapterCheckBox_image_id.setImage_error_id(String.valueOf(o));
                getDataAdapterCheckBox_image_id.setImage_error_size(String.valueOf(da2));
                //GetDataAdapterCheckBox box =new GetDataAdapterCheckBox();
                //GetDataAdapter1.setImage_error(String.valueOf(image[o]));

                int t;
                String DD="";

                for(t=0;t<da2;t++){
                    Log.e("dd"+t, String.valueOf(image2[t]));



                    getDataAdapterCheckBox_image_id.setImage_error(String.valueOf(image2[t]));
                    list_image.add(getDataAdapterCheckBox_image_id);

                    DD=String.valueOf(image2[t]);
                }

            }
        }

        */





       //sqLiteDatabase.execSQL("DELETE FROM "+SQLiteHelper.TABLE_NAME+"");










        JSON_DATA_WEB_CALL();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                position_recycle_view=0;
                recyclerView.setHasFixedSize(true);

                recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

                recyclerView.setLayoutManager(recyclerViewlayoutManager);
                GetDataAdapter1.clear();
                JSON_DATA_WEB_CALL();
                swipeRefreshLayout.setRefreshing(false);
            }
        });


        initListener();
        initListener_node_message();




    }



    public void SQLiteDataBaseBuild(){

        sqLiteDatabase = getActivity().openOrCreateDatabase(SQLiteHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    public void SQLiteTableBuild(){

        //sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper.TABLE_NAME+"("+ SQLiteHelper.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+SQLiteHelper.Table_Column_1_Subject_Name+" VARCHAR, "+SQLiteHelper.Table_Column_2_SubjectFullForm+" VARCHAR, "+SQLiteHelper.Table_Column_3_subteamcode+" VARCHAR, "+SQLiteHelper.Table_Column_5_contract_number+" VARCHAR, "+SQLiteHelper.Table_Column_6_contract_number2+" VARCHAR, "+SQLiteHelper.Table_Column_7_name_topic+" VARCHAR, "+SQLiteHelper.Table_Column_8_customer+" VARCHAR, "+SQLiteHelper.Table_Column_9_description+" VARCHAR, "+SQLiteHelper.Table_Column_16_status+" VARCHAR, "+SQLiteHelper.Table_Column_15_date_time+" VARCHAR, "+SQLiteHelper.Table_Column_23_date_time_update+" VARCHAR, "+SQLiteHelper.Table_Column_10_approveStatus+" VARCHAR, "+SQLiteHelper.Table_Column_11_approveBy+" VARCHAR, "+SQLiteHelper.Table_Column_12_approveDate+" VARCHAR, "+SQLiteHelper.Table_Column_17_isremark+" VARCHAR, "+SQLiteHelper.Table_Column_14_isremark1+" VARCHAR, "+SQLiteHelper.Table_Column_20_check_foller+" VARCHAR, "+SQLiteHelper.Table_Column_21_countfoller+" VARCHAR, "+SQLiteHelper.Table_Column_22_countcomment+" VARCHAR, "+SQLiteHelper.Table_Column_4_picture+" VARCHAR);");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper.TABLE_NAME+"("+ SQLiteHelper.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper.Table_contno+" VARCHAR, "+SQLiteHelper.Table_part_id+" VARCHAR, "+SQLiteHelper.Table_part_image+" VARCHAR, "+SQLiteHelper.Table_type_image+" VARCHAR, "+SQLiteHelper.Table_Problem_Type_ID+" VARCHAR, "+SQLiteHelper.Table_Problem_TypeDeteils_ID+" VARCHAR, "+SQLiteHelper.Table_Url+" VARCHAR, "+SQLiteHelper.Table_Image_Name+" VARCHAR, "+SQLiteHelper.Table_Image_Size+" VARCHAR, "+SQLiteHelper.Table_Image_Type+" VARCHAR);");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View layoutView = inflater.inflate(R.layout.cardview_row_cedit_cedit, container, false);


        setHasOptionsMenu(true);



        GetDataAdapter1 = new ArrayList<>();
        getData_uploade_images = new ArrayList<>();
        remove_image_select_id= new ArrayList<>();

        recyclerView = (RecyclerView) layoutView.findViewById(R.id.recyclerview1);
        relativeLayout= (RelativeLayout) layoutView.findViewById(R.id.relativeLayout);
        swipeRefreshLayout = (SwipeRefreshLayout) layoutView.findViewById(R.id.swipe_refresh_layout);
        floatingActionButton= (FloatingActionButton) layoutView.findViewById(R.id.fab);
        recognitionProgressView = (RecognitionProgressView) layoutView.findViewById(R.id.recognition_view);
        on_mic= (ImageView) layoutView.findViewById(R.id.on_mic);

        handle= (ImageView) layoutView.findViewById(R.id.handle);
        txt_namesale= (TextView) layoutView.findViewById(R.id.txt_namesale);
        txt_position= (TextView) layoutView.findViewById(R.id.txt_position);
        txt_teamcode= (TextView) layoutView.findViewById(R.id.txt_teamcode);
        txt_boss= (TextView) layoutView.findViewById(R.id.txt_boss);
        txt_bossposition= (TextView) layoutView.findViewById(R.id.txt_bossposition);
        inputText = (EditText) layoutView.findViewById(R.id.inputText);
        new_message= (EditText) layoutView.findViewById(R.id.new_message);
        switcher  = (ImageButton) layoutView.findViewById(R.id.switcher);

        linear_sale1= (LinearLayout) layoutView.findViewById(R.id.linear_sale1);
        linear_sale2= (LinearLayout) layoutView.findViewById(R.id.linear_sale2);
        relativeLayout.setVisibility(View.GONE);
        floatingActionButton.setOnClickListener(this);
        switcher.setOnClickListener(this);

        node_message= new_message.getText().toString();

        on_mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  startRecognition();
                if(!open_mic){
                    open_mic=true;
                    on_mic.setBackgroundResource(R.drawable.ic_mic_white_24dp);
                    //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    //    on_mic.setBackgroundTintList(ColorStateList.valueOf(0xff3164d7));
                   // }
                }
                else {
                    open_mic=false;
                    on_mic.setBackgroundResource(R.drawable.ic_mic_off_white_24dp);
                    //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                   //     on_mic.setBackgroundTintList(ColorStateList.valueOf(0xffffffff));
                   // }
                }


                if (ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.RECORD_AUDIO)
                        != PackageManager.PERMISSION_GRANTED) {

                    requestPermission();
                } else {

                    startRecognition();


                    recognitionProgressView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startRecognition();

                        }
                    }, 50);

                }



            }
        });





        return layoutView;

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

    private void initListener_node_message() {
        new_message.addTextChangedListener(new TextWatcher() {

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

                    MyApplication.getInstance().getPrefManager().setPreferrence("node_message", String.valueOf(s));


                } else {

                }
            }
        });
    }

    private void startRecognition() {
        intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getActivity().getPackageName());
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "th");

        SpeechRecognitionListener speechRecognitionListener = new SpeechRecognitionListener();
        recognitionProgressView.setRecognitionListener(speechRecognitionListener);

        if (!mIslistening)
        {
            speechRecognizer.startListening(intent);
        }


    }
    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                Manifest.permission.RECORD_AUDIO)) {
          //  Toast.makeText(this, "Requires RECORD_AUDIO permission", Toast.LENGTH_SHORT).show();

        } else {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[] { Manifest.permission.RECORD_AUDIO },
                    REQUEST_RECORD_AUDIO_PERMISSION_CODE);


        }
    }









    protected class SpeechRecognitionListener implements RecognitionListener {

        @Override
        public void onBeginningOfSpeech()
        {
            //Log.d(TAG, "onBeginingOfSpeech");
        }

        @Override
        public void onBufferReceived(byte[] buffer)
        {

        }

        @Override
        public void onEndOfSpeech()
        {
            //Log.d(TAG, "onEndOfSpeech");
        }

        @Override
        public void onError(int error)
        {
            speechRecognizer.startListening(intent);

            //Log.d(TAG, "error = " + error);
        }

        @Override
        public void onEvent(int eventType, Bundle params)
        {

        }

        @Override
        public void onPartialResults(Bundle partialResults)
        {

        }

        @Override
        public void onReadyForSpeech(Bundle params)
        {
           // Log.d(TAG, "onReadyForSpeech"); //$NON-NLS-1$
        }

        @Override
        public void onResults(Bundle results)
        {

            Log.e("results", String.valueOf(results));
            ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);


            for (String s : matches) {
            Log.e("soued", s);
        }
            startRecognition();



        }

        @Override
        public void onRmsChanged(float rmsdB)
        {
        }
    }

    public void JSON_DATA_WEB_CALL() {

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL ,


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
        swipeRefreshLayout.setRefreshing(false);
    }



int idid=0;
    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array) {






        for (int i = 0; i < array.length(); i++) {

            final GetDataAdapterCheckBox GetDataAdapter2 = new GetDataAdapterCheckBox();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);

                GetDataAdapter2.setid(json.getString(JSON_ID));
                GetDataAdapter2.setproblem(json.getString(JSON_PROBLEM));


                idid=i+1;


                cursor = sqLiteDatabase.rawQuery("SELECT count(*) as ddd  FROM "+SQLiteHelper.TABLE_NAME+"" +" WHERE part_id ="+"'"+idid+"'" +" and contno ="+"'"+MyApplication.getInstance().getPrefManager().getPreferrence("getCONTNO")+"'"+" and type_image ="+"'"+"image_error"+"'"+" ORDER BY part_image DESC LIMIT 1"  , null);

                if (cursor.moveToFirst()) {
                    do {
                        int count= cursor.getInt(0);
                        //String FA=cursor.getString(count(*));
                        Log.e("count", String.valueOf(count));
                        GetDataAdapter2.setImage_error_size(String.valueOf(count));
                    } while (cursor.moveToNext());
                }
                cursor.close();





                cursor = sqLiteDatabase.rawQuery("SELECT *  FROM "+SQLiteHelper.TABLE_NAME+"" +" WHERE part_id ="+"'"+idid+"'" +" and contno ="+"'"+MyApplication.getInstance().getPrefManager().getPreferrence("getCONTNO")+"'"+" and type_image ="+"'"+"image_error"+"'"+" ORDER BY part_image DESC LIMIT 1"  , null);

                if (cursor.moveToFirst()) {
            do {

                String FA=cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_part_image));
                Log.e("A", FA);
                GetDataAdapter2.setImage_error(FA);
            } while (cursor.moveToNext());
        }
        cursor.close();







                cursor = sqLiteDatabase.rawQuery("SELECT count(*) as ddd  FROM "+SQLiteHelper.TABLE_NAME+"" +" WHERE part_id ="+"'"+idid+"'" +" and contno ="+"'"+MyApplication.getInstance().getPrefManager().getPreferrence("getCONTNO")+"'"+" and type_image ="+"'"+"image_success"+"'"+" ORDER BY part_image DESC LIMIT 1"  , null);

                if (cursor.moveToFirst()) {
                    do {
                        int count= cursor.getInt(0);
                        //String FA=cursor.getString(count(*));
                        Log.e("count", String.valueOf(count));
                        GetDataAdapter2.setImage_sucess_size(String.valueOf(count));
                    } while (cursor.moveToNext());
                }
                cursor.close();





                cursor = sqLiteDatabase.rawQuery("SELECT *  FROM "+SQLiteHelper.TABLE_NAME+"" +" WHERE part_id ="+"'"+idid+"'" +" and contno ="+"'"+MyApplication.getInstance().getPrefManager().getPreferrence("getCONTNO")+"'"+" and type_image ="+"'"+"image_success"+"'"+" ORDER BY part_image DESC LIMIT 1"  , null);

                if (cursor.moveToFirst()) {
                    do {

                        String FA=cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_part_image));
                        Log.e("A", FA);
                        GetDataAdapter2.setImage_sucess(FA);
                    } while (cursor.moveToNext());
                }
                cursor.close();










            } catch (JSONException e) {

                e.printStackTrace();
            }






            GetDataAdapter1.add(GetDataAdapter2);








        }


        recyclerViewadapter1 = new RecyclerViewAdapterCheckBox(GetDataAdapter1, getActivity(),this,this);
        recyclerView.setAdapter(recyclerViewadapter1);
        recyclerView.scrollToPosition(position_recycle_view);

        recyclerViewadapter1.setitemclick_image_sucess(this);
        recyclerViewadapter1.setitemclick2(this);
        recyclerViewadapter1.setitemclick_image_ic_dete1(this);
        recyclerViewadapter1.setitemclick_image_ic_dete2(this);
        recyclerViewadapter1.setitemclick_photograph_image_error(this);
        recyclerViewadapter1.setitemclick_photograph_image_success(this);

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

        requestQueue = Volley.newRequestQueue(getActivity());

        requestQueue.add(jsonArrayRequest);

    }


    public void JSON_PARSE_DATA_AFTER_WEBCALL_INSENT_DATA_SALE(JSONArray array) {

              Log.e("array", String.valueOf(array.length()));
                check=array.length();
        MyApplication.getInstance().getPrefManager().setPreferrence("check", String.valueOf(check));
                if(check==0){
                    linear_sale1.setVisibility(View.GONE);
                    linear_sale2.setVisibility(View.GONE);
                }
                else {
                    linear_sale1.setVisibility(View.VISIBLE);
                    linear_sale2.setVisibility(View.VISIBLE);
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













                try {
                    Glide.with(getActivity()).load(GetDataAdapter2.getPicture())



                            .crossFade()
                            .thumbnail(0.5f)
                            .bitmapTransform(new CircleTransform(getActivity()))
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .placeholder(getActivity().getResources().getDrawable(R.drawable.dasaa))
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

                MyApplication.getInstance().getPrefManager().setPreferrence("contno_save", contno);








            } catch (JSONException e) {

                e.printStackTrace();
            }
          //  GetDataAdapter1.add(GetDataAdapter2);

        }



        GetDataAdapter1.clear();
        JSON_DATA_WEB_CALL();


    }

    @Override
    public void onClick(View view) {
        if(view==floatingActionButton){
            dialog();
        }

        else if(view==switcher){
            Intent Intent = new Intent(getActivity(), MainActivity_qr_report_problem.class);
            startActivityForResult(Intent, 100);
        }
    }


    private void dialog(){


        new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE)
                .setTitleText("คุณแน่ใจไหม?")
                .setContentText("ที่ต้องการแจ้งการแก้ไขปัญหานี้แล้ว!")
                .setCancelText("ไม่!")
                .setConfirmText("ใช่!")
                .showCancelButton(true)
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        Log.e("3333","3333");
                        sDialog.cancel();
                    }
                })
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(final SweetAlertDialog sDialog) {
                        Log.e("rrrr", "rrrr");
                        sDialog.cancel();






                        stringBuilder = new StringBuilder();
                        stringBuilder2 = new StringBuilder();
                        stringBuilder3 = new StringBuilder();
                        stringBuilder4 = new StringBuilder();

                        for (GetDataAdapterCheckBox number : GetDataAdapter1) {
                            if (number.isSelected()) {

                                if (stringBuilder.length() > 0)
                                    stringBuilder.append(",");


                                stringBuilder.append(number.getproblem());


                                if (stringBuilder2.length() > 0)
                                    stringBuilder2.append(",");
                                stringBuilder2.append(number.getid());
                                kaka = stringBuilder;

                            }


                            if (number.isSelected()) {

                                if (stringBuilder3.length() > 0)
                                    stringBuilder3.append(",");


                                stringBuilder3.append(number.getproblem());


                                if (stringBuilder4.length() > 0)
                                    stringBuilder4.append(",");
                                stringBuilder4.append(number.getid());

                            }

                        }
                        DADA = stringBuilder2.toString();
                        DADA2 = stringBuilder.toString();
                        DADA3 = stringBuilder3.toString();

                        Log.e("a1", DADA);
                        Log.e("a2", kaka + "");
                        Log.e("a3", DADA2 + "");
                        Log.e("a4", Description + "");


                        try {



                            if (stringBuilder2.toString() == "") {
                                if(check_sale_contno.equals("0")){
                                    new SweetAlertDialog(getActivity(), SweetAlertDialog.ERROR_TYPE)
                                            .setTitleText("!เลขที่สัญญาไม่ถูกต้อง")
                                            .setContentText("ลองใหม่อีกครั้ง!")
                                            .show();
                                }
                                else {
                                    new SweetAlertDialog(getActivity(), SweetAlertDialog.ERROR_TYPE)
                                            .setTitleText("!กรุณาเลือกปัญหา")
                                            .setContentText("ลองใหม่อีกครั้ง!")
                                            .show();
                                }




                            } else {

                                /*
                                String arr3[];
                                SweetAlertDialog pDialogg2 = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
                                pDialogg2.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                                pDialogg2.setTitleText("กำลังอัปโหลด...");
                                pDialogg2.setCancelable(false);
                                pDialogg2.show();

                                   Log.e("55555555555555555","555555");

                                if(check_sale_contno.equals("0")){
                                    new SweetAlertDialog(getActivity(), SweetAlertDialog.ERROR_TYPE)
                                            .setTitleText("!เลขที่สัญญาไม่ถูกต้อง")
                                            .setContentText("ลองใหม่อีกครั้ง!")
                                            .show();
                                    pDialogg2.cancel();
                                }
                                else {
                                    pDialogg2.cancel();
                                     arr3= DADA.split(",");
                                    int count=arr3.length;
                                    Log.e("count", String.valueOf(count));
                                    for(int c=0;c<arr3.length;c++) {
                                        id_problem = arr3[c];
                                        Log.e("arr2", arr3[c]);
                                        INSENT_Problem_Master();
                                         INSENT_Problem_details();

                                    }
                                }
                                */



                                if(check_sale_contno.equals("0")){
                                    new SweetAlertDialog(getActivity(), SweetAlertDialog.ERROR_TYPE)
                                            .setTitleText("!เลขที่สัญญาไม่ถูกต้อง")
                                            .setContentText("ลองใหม่อีกครั้ง!")
                                            .show();
                                }
                                else {

                                    SweetAlertDialog pDialogg2 = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
                                    pDialogg2.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                                    pDialogg2.setTitleText("กำลังอัปโหลด...");
                                    pDialogg2.setCancelable(false);

                                    String PART_ID="";
                                    String arr2[] = DADA.split(",");
                                        int count=arr2.length;
                                    Log.e("count", String.valueOf(count));



                                        for(int c=0;c<count;c++){
                                             id_problem=arr2[c];
                                            INSENT_Problem_Master();
                                            INSENT_Problem_details();
                                            Log.e("id_problem",id_problem);


                                        }







                                             if(count==1){
                                                 PART_ID  =arr2[0];

                                             }
                                        else if(count==2){ PART_ID  =arr2[0]+"'"+" or "+"part_id ="+"'"+arr2[1];}

                                        else if(count==3){PART_ID  =arr2[0]+"'"+" or "+"part_id ="+"'"+arr2[1]+"'"+" or "+"part_id ="+"'"+arr2[2];}
                                        else if(count==4){PART_ID  =arr2[0]+"'"+" or "+"part_id ="+"'"+arr2[1]+"'"+" or "+"part_id ="+"'"+arr2[2]+"'"+" or "+"part_id ="+"'"+arr2[3];}
                                        else if(count==5){PART_ID  =arr2[0]+"'"+" or "+"part_id ="+"'"+arr2[1]+"'"+" or "+"part_id ="+"'"+arr2[2]+"'"+" or "+"part_id ="+"'"+arr2[3]+"'"+" or "+"part_id ="+"'"+arr2[4]; }
                                        else if(count==6){PART_ID  =arr2[0]+"'"+" or "+"part_id ="+"'"+arr2[1]+"'"+" or "+"part_id ="+"'"+arr2[2]+"'"+" or "+"part_id ="+"'"+arr2[3]+"'"+" or "+"part_id ="+"'"+arr2[4]+"'"+" or "+"part_id ="+"'"+arr2[5]; }
                                        else if(count==7){PART_ID  =arr2[0]+"'"+" or "+"part_id ="+"'"+arr2[1]+"'"+" or "+"part_id ="+"'"+arr2[2]+"'"+" or "+"part_id ="+"'"+arr2[3]+"'"+" or "+"part_id ="+"'"+arr2[4]+"'"+" or "+"part_id ="+"'"+arr2[5]+"'"+" or "+"part_id ="+"'"+arr2[6]; }
                                        else if(count==8){PART_ID  =arr2[0]+"'"+" or "+"part_id ="+"'"+arr2[1]+"'"+" or "+"part_id ="+"'"+arr2[2]+"'"+" or "+"part_id ="+"'"+arr2[3]+"'"+" or "+"part_id ="+"'"+arr2[4]+"'"+" or "+"part_id ="+"'"+arr2[5]+"'"+" or "+"part_id ="+"'"+arr2[6]+"'"+" or "+"part_id ="+"'"+arr2[7]; }
                                        else if(count==9){PART_ID  =arr2[0]+"'"+" or "+"part_id ="+"'"+arr2[1]+"'"+" or "+"part_id ="+"'"+arr2[2]+"'"+" or "+"part_id ="+"'"+arr2[3]+"'"+" or "+"part_id ="+"'"+arr2[4]+"'"+" or "+"part_id ="+"'"+arr2[5]+"'"+" or "+"part_id ="+"'"+arr2[6]+"'"+" or "+"part_id ="+"'"+arr2[7]+"'"+" or "+"part_id ="+"'"+arr2[8]; }
                                        else if(count==10){PART_ID  =arr2[0]+"'"+" or "+"part_id ="+"'"+arr2[1]+"'"+" or "+"part_id ="+"'"+arr2[2]+"'"+" or "+"part_id ="+"'"+arr2[3]+"'"+" or "+"part_id ="+"'"+arr2[4]+"'"+" or "+"part_id ="+"'"+arr2[5]+"'"+" or "+"part_id ="+"'"+arr2[6]+"'"+" or "+"part_id ="+"'"+arr2[7]+"'"+" or "+"part_id ="+"'"+arr2[8]+"'"+" or "+"part_id ="+"'"+arr2[9]; }
                                        else if(count==11){PART_ID  =arr2[0]+"'"+" or "+"part_id ="+"'"+arr2[1]+"'"+" or "+"part_id ="+"'"+arr2[2]+"'"+" or "+"part_id ="+"'"+arr2[3]+"'"+" or "+"part_id ="+"'"+arr2[4]+"'"+" or "+"part_id ="+"'"+arr2[5]+"'"+" or "+"part_id ="+"'"+arr2[6]+"'"+" or "+"part_id ="+"'"+arr2[7]+"'"+" or "+"part_id ="+"'"+arr2[8]+"'"+" or "+"part_id ="+"'"+arr2[9]+"'"+" or "+"part_id ="+"'"+arr2[10];  }
                                        else if(count==12){PART_ID  =arr2[0]+"'"+" or "+"part_id ="+"'"+arr2[1]+"'"+" or "+"part_id ="+"'"+arr2[2]+"'"+" or "+"part_id ="+"'"+arr2[3]+"'"+" or "+"part_id ="+"'"+arr2[4]+"'"+" or "+"part_id ="+"'"+arr2[5]+"'"+" or "+"part_id ="+"'"+arr2[6]+"'"+" or "+"part_id ="+"'"+arr2[7]+"'"+" or "+"part_id ="+"'"+arr2[8]+"'"+" or "+"part_id ="+"'"+arr2[9]+"'"+" or "+"part_id ="+"'"+arr2[10]+"'"+" or "+"part_id ="+"'"+arr2[11];  }
                                        else if(count==13){PART_ID  =arr2[0]+"'"+" or "+"part_id ="+"'"+arr2[1]+"'"+" or "+"part_id ="+"'"+arr2[2]+"'"+" or "+"part_id ="+"'"+arr2[3]+"'"+" or "+"part_id ="+"'"+arr2[4]+"'"+" or "+"part_id ="+"'"+arr2[5]+"'"+" or "+"part_id ="+"'"+arr2[6]+"'"+" or "+"part_id ="+"'"+arr2[7]+"'"+" or "+"part_id ="+"'"+arr2[8]+"'"+" or "+"part_id ="+"'"+arr2[9]+"'"+" or "+"part_id ="+"'"+arr2[10]+"'"+" or "+"part_id ="+"'"+arr2[11]+"'"+" or "+"part_id ="+"'"+arr2[12];  }
                                        else if(count==14){PART_ID  =arr2[0]+"'"+" or "+"part_id ="+"'"+arr2[1]+"'"+" or "+"part_id ="+"'"+arr2[2]+"'"+" or "+"part_id ="+"'"+arr2[3]+"'"+" or "+"part_id ="+"'"+arr2[4]+"'"+" or "+"part_id ="+"'"+arr2[5]+"'"+" or "+"part_id ="+"'"+arr2[6]+"'"+" or "+"part_id ="+"'"+arr2[7]+"'"+" or "+"part_id ="+"'"+arr2[8]+"'"+" or "+"part_id ="+"'"+arr2[9]+"'"+" or "+"part_id ="+"'"+arr2[10]+"'"+" or "+"part_id ="+"'"+arr2[11]+"'"+" or "+"part_id ="+"'"+arr2[12]+"'"+" or "+"part_id ="+"'"+arr2[13];  }
                                        else if(count==15){PART_ID  =arr2[0]+"'"+" or "+"part_id ="+"'"+arr2[1]+"'"+" or "+"part_id ="+"'"+arr2[2]+"'"+" or "+"part_id ="+"'"+arr2[3]+"'"+" or "+"part_id ="+"'"+arr2[4]+"'"+" or "+"part_id ="+"'"+arr2[5]+"'"+" or "+"part_id ="+"'"+arr2[6]+"'"+" or "+"part_id ="+"'"+arr2[7]+"'"+" or "+"part_id ="+"'"+arr2[8]+"'"+" or "+"part_id ="+"'"+arr2[9]+"'"+" or "+"part_id ="+"'"+arr2[10]+"'"+" or "+"part_id ="+"'"+arr2[11]+"'"+" or "+"part_id ="+"'"+arr2[12]+"'"+" or "+"part_id ="+"'"+arr2[13]+"'"+" or "+"part_id ="+"'"+arr2[14];  }


                                        Log.e("PART_ID",PART_ID);
                                    SQLiteDataBaseBuild();
                                    SQLiteTableBuild();
                                   // cursor = sqLiteDatabase.rawQuery("SELECT *  FROM "+SQLiteHelper.TABLE_NAME+"" +" WHERE part_id ="+"'"+idid+"'" +"ORDER BY part_image DESC LIMIT 1"  , null);
                                  String SQL=  "SELECT *  FROM favorite where part_id ="+"'"+PART_ID+"'" +" and contno ="+"'"+MyApplication.getInstance().getPrefManager().getPreferrence("getCONTNO")+"'" ;  //+" and part_image !="+"'"+"null"+"'"
                                        Log.e("SQL",SQL);
                                    cursor = sqLiteDatabase.rawQuery( SQL , null);

                                    if (cursor.moveToFirst()) {
                                        do {
                                            GetData_uploade_Image getData_uploade_image = new GetData_uploade_Image();
                                            String FA=cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_part_image));



                                            getData_uploade_image.setImage(FA);
                                            Log.e("A", FA);
                                            getData_uploade_images.add(getData_uploade_image);

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

                                     pDialogg = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
                                    pDialogg.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                                    pDialogg.setTitleText("กำลังอัปโหลด...");
                                    pDialogg.setCancelable(false);
                                    uploadMultiFile();



                                }







                            }





                        }
                        catch (Exception ex){


                        }


                    }


                })
                .show();



    }


    public void insent_report_problem() {
        String contno= MyApplication.getInstance().getPrefManager().getPreferrence("conno_qr");//More
        String CreateBy=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

        jsonArrayRequest = new JsonArrayRequest(GET_insent_report_problem+"?contno="+contno+"&problem="+DADA+"&type="+"General"+"&CreateBy="+CreateBy ,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        //nontification_cedit_to_sale();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue = Volley.newRequestQueue(getActivity());

        requestQueue.add(jsonArrayRequest);

    }



    String GET_nontification_to_sale="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit/firebase_nontification_sale_from_cedit/index.php";
    public void nontification_cedit_to_sale() {
        String contno= MyApplication.getInstance().getPrefManager().getPreferrence("conno_qr");//More
        String image_cedit=MyApplication.getInstance().getPrefManager().getPreferrence("picture");//More
        String name_cedit=MyApplication.getInstance().getPrefManager().getPreferrence("EmployeeName");//More
        jsonArrayRequest = new JsonArrayRequest(GET_nontification_to_sale+"?contno="+contno+"&problem="+DADA+"&name_cedit="+name_cedit+"&image_cedit="+image_cedit,


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

        requestQueue = Volley.newRequestQueue(getActivity());

        requestQueue.add(jsonArrayRequest);

    }


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

        /*
        for (int i = 0; i < filePaths.size(); i++) {
            File file = new File(filePaths.get(i));
            builder.addFormDataPart("file[]", file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file));
        }
*/
        for (int i = 0; i < getData_uploade_images.size(); i++) {
           // getData_uploade_images.get(i);
            GetData_uploade_Image contact = getData_uploade_images.get(i);
            String data_image_to_qry=contact.getImage();



            cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper.TABLE_NAME+"" +" WHERE part_image ="+"'"+data_image_to_qry+"'" +" and contno ="+"'"+MyApplication.getInstance().getPrefManager().getPreferrence("getCONTNO")+"'" , null);

            if (cursor.moveToFirst()) {
                do {

                     part_id=cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_part_id));
                     part_image=cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_part_image));
                     type_image=cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_type_image));

                    Problem_Type_ID=cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Problem_Type_ID));
                    Problem_TypeDeteils_ID=cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Problem_TypeDeteils_ID));
                    Url=cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Url));
                    Image_Name=cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Image_Name));
                    Image_Size=cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Image_Size));
                    Image_Type=cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Image_Type));

                    Log.e("part_id", part_id);
                    Log.e("part_image", part_image);
                    Log.e("type_image", type_image);
                    Log.e("Problem_Type_ID", Problem_Type_ID);
                    Log.e("Problem_TypeDeteils_ID", Problem_TypeDeteils_ID);
                    Log.e("Url", Url);
                    Log.e("Image_Name", Image_Name);
                    Log.e("Image_Size", Image_Size);
                    Log.e("Image_Type", Image_Type);



                    INSENT_Problem_image();

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

                new SweetAlertDialog(getActivity(), SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("เส็จสิ้น!")
                        .setContentText("*เเจ้งปัญหา*")
                       // .setContentText("เรียบร้อย\n")
                        .show();

                File file = new File("/storage/sdcard0/Android/data/com.tsr.tsrproblemreport/files/Pictures/70102489/report_problem/ID1/image_error/image_error_20180406070126-1473976226.jpg");
                double length = file.length();
                length = length/1024;

                Log.e("imageName", file.getPath() + ", File size : " + length +" KB");
                getData_uploade_images.clear();
                pDialogg.dismiss();
                pDialogg.cancel();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                pDialogg.dismiss();
                pDialogg.cancel();
                Log.d(TAG, "Error " + t.getMessage());

                new SweetAlertDialog(getActivity(), SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("ผิดพลาด!")
                        .setContentText(t.getMessage()+"\n*")

                        .show();

            }
        });


    }


    //String GET_JSON_INSENT_Problem_Master="http://app.thiensurat.co.th/assanee/api_report_problem_from_contno/insent_problem_master.php";
    //String GET_JSON_INSENT_Problem_image="http://app.thiensurat.co.th/assanee/api_report_problem_from_contno/insent_problem_image.php";
    //String GET_JSON_INSENT_Problem_details="http://app.thiensurat.co.th/assanee/api_report_problem_from_contno/insent_problem_details.php";

    String GET_JSON_INSENT_Problem_Master="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_problem_master.php";
    String GET_JSON_INSENT_Problem_image="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_problem_image.php";
    String GET_JSON_INSENT_Problem_details="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_problem_details.php";
    //


    String Problem_Status="";
    public   void INSENT_Problem_Master(){
        String Refno=MyApplication.getInstance().getPrefManager().getPreferrence("getRefNo");
        String Contno=MyApplication.getInstance().getPrefManager().getPreferrence("getCONTNO");
        String Emp_Report=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        String user_code=MyApplication.getInstance().getPrefManager().getPreferrence("getEmpID");

             Problem_Status="00";



        Log.e("URLLLLLL",GET_JSON_INSENT_Problem_Master+"?Refno="+Refno+"&Contno="+Contno+"&Emp_Report="+Emp_Report+"&user_code="+user_code+"&Problem_Status="+Problem_Status);

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_INSENT_Problem_Master+"?Refno="+Refno+"&Contno="+Contno+"&Emp_Report="+Emp_Report+"&user_code="+user_code+"&Problem_Status="+Problem_Status,


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

        requestQueue = Volley.newRequestQueue(getActivity());

        requestQueue.add(jsonArrayRequest);
        }

    String Problem_Note="";
    public  void INSENT_Problem_details(){


        String Problem_ID="1";
        String Problem_Type_ID="01";
        String Problem_TypeDeteils_ID=id_problem;

        String Problem_Note2=MyApplication.getInstance().getPrefManager().getPreferrence("node_message")+"";
        if(Problem_Note2.equals("null")){
            Problem_Note="NULL";
        }
        else {
            Problem_Note=Problem_Note2;
        }


        String Emp_Approve="NULL";
        String Emp_Repair="NULL";
        String Emp_Verify="NULL";

        Problem_Status_IMAGE="00";

        String user_code_IMAGE=MyApplication.getInstance().getPrefManager().getPreferrence("getEmpID");
        try {
            Log.e("details",GET_JSON_INSENT_Problem_details+"?Problem_Type_ID="+Problem_Type_ID+"&Problem_TypeDeteils_ID="+Problem_TypeDeteils_ID+"&Problem_Note="+URLEncoder.encode(Problem_Note, "UTF-8")+"&Emp_Approve="+Emp_Approve+"&Emp_Repair="+Emp_Repair+"&Emp_Verify="+Emp_Verify+"&Problem_Status="+Problem_Status_IMAGE+"&user_code="+user_code_IMAGE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }





        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_INSENT_Problem_details+"?Problem_Type_ID="+Problem_Type_ID+"&Problem_TypeDeteils_ID="+Problem_TypeDeteils_ID+"&Problem_Note="+URLEncoder.encode(Problem_Note, "UTF-8")+"&Emp_Approve="+ Emp_Approve+"&Emp_Repair="+Emp_Repair+"&Emp_Verify="+Emp_Verify+"&Problem_Status="+Problem_Status_IMAGE+"&user_code="+user_code_IMAGE,


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





        requestQueue = Volley.newRequestQueue(getActivity());

        requestQueue.add(jsonArrayRequest);

    }



    String Problem_Status_IMAGE="";
    private  void INSENT_Problem_image(){


        String Problem_ID="1";
        String Problem_Type_ID="01";
        String Problem_TypeDeteils_ID=part_id;

        String Url_u=Url;
        String Image_Name_u=Image_Name;
        String Image_Size_u=Image_Size;

        String Image_Type_u=Image_Type;
        if(type_image.equals("image_error")){
            Problem_Status_IMAGE="00";
        }
        else {
            Problem_Status_IMAGE="01";
        }


        String user_code_IMAGE=MyApplication.getInstance().getPrefManager().getPreferrence("getEmpID");
        Log.e("uuuu",GET_JSON_INSENT_Problem_image+"?Problem_Type_ID="+Problem_Type_ID+"&Problem_TypeDeteils_ID="+Problem_TypeDeteils_ID+"&Url="+Url_u+"&Image_Name="+Image_Name_u+"&Image_Size="+Image_Size_u+"&Image_Type="+Image_Type_u+"&Problem_Status="+Problem_Status_IMAGE+"&user_code="+user_code_IMAGE);
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_INSENT_Problem_image+"?Problem_Type_ID="+Problem_Type_ID+"&Problem_TypeDeteils_ID="+Problem_TypeDeteils_ID+"&Url="+Url_u+"&Image_Name="+Image_Name_u+"&Image_Size="+Image_Size_u+"&Image_Type="+Image_Type_u+"&Problem_Status="+Problem_Status_IMAGE+"&user_code="+user_code_IMAGE,


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

        requestQueue = Volley.newRequestQueue(getActivity());

        requestQueue.add(jsonArrayRequest);

    }






    Uri fileUri;
    ImageConfiguration ic;

    @Override
    public void click2(View v, int position) {
        if(check_sale_contno.equals("0")){
            inputText.setHint("เลขที่สัญญาไม่ถูกต้อง");
            inputText.setHintTextColor(0xffff0000);
        }
        else {
            position_image_error = position;


            getDataAdapterCheckBox = GetDataAdapter1.get(position_image_error);


            Intent Intent = new Intent(getActivity(), IMAGE_report_problem_all_id.class);
            Bundle bun = new Bundle();
            bun.putString("ID", getDataAdapterCheckBox.getid());
            bun.putString("image","image_error");
            Intent.putExtras(bun);
            startActivityForResult(Intent, 55);
        }

/*
        image_error=v;
        position_image_error= position;
        getDataAdapterCheckBox=GetDataAdapter1.get(position_image_error);

        CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        ic=new ImageConfiguration(getActivity());
        file=ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                "report_problem",getDataAdapterCheckBox.getid());
        fileUri=Uri.fromFile(file);
        CamIntent.putExtra(MediaStore.EXTRA_OUTPUT,fileUri);
        startActivityForResult(CamIntent,1);
*/


    }

    @Override
    public void click_image_sucess(View v, int position) {
        if(check_sale_contno.equals("0")){
            inputText.setHint("เลขที่สัญญาไม่ถูกต้อง");
            inputText.setHintTextColor(0xffff0000);
        }
        else {
            position_image_sucess = position;
            getDataAdapterCheckBox = GetDataAdapter1.get(position_image_sucess);
            Intent Intent = new Intent(getActivity(), IMAGE_report_problem_all_id.class);
            Bundle bun = new Bundle();
            bun.putString("ID", getDataAdapterCheckBox.getid());
            bun.putString("image","image_success");
            Intent.putExtras(bun);
            startActivityForResult(Intent, 66);
        }

    }


    @Override
    public void click_image_ic_dete1(View v, int position) {
        if(check_sale_contno.equals("0")){
            inputText.setHint("เลขที่สัญญาไม่ถูกต้อง");
            inputText.setHintTextColor(0xffff0000);
        }
        else {
            position_image_delete1=position;

            getDataAdapterCheckBox=GetDataAdapter1.get(position_image_delete1);
            ic.removeImage(getDataAdapterCheckBox.getImage_error());
            //getDataAdapterCheckBox=GetDataAdapter1.get(position_image_sucess);
        }

    }

    @Override
    public void click_image_ic_dete2(View v, int position) {
        if(check_sale_contno.equals("0")){
            inputText.setHint("เลขที่สัญญาไม่ถูกต้อง");
            inputText.setHintTextColor(0xffff0000);
        }
        else {
            position_image_delete2=position;
            getDataAdapterCheckBox=GetDataAdapter1.get(position_image_delete2);
            ic.removeImage(getDataAdapterCheckBox.getImage_sucess());

            //getDataAdapterCheckBox=GetDataAdapter1.get(position_image_sucess);
        }

    }



    int id_image_error=0;
    @Override
    public void click_photograph_image_error(View v, int position) {
        if(check_sale_contno.equals("0")){
            inputText.setHint("เลขที่สัญญาไม่ถูกต้อง");
            inputText.setHintTextColor(0xffff0000);
        }
        else {
            image_error=v;
            position_image_error= position;
            id_image_error=position+1;
            Log.e("id_image_error", String.valueOf(id_image_error));
            getDataAdapterCheckBox=GetDataAdapter1.get(position_image_error);

            CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        /*file = new File(Environment.getExternalStorageDirectory(),
                "file"+String.valueOf(System.currentTimeMillis())+".jpg");
        uri = Uri.fromFile(file);*/
            ic=new ImageConfiguration(getActivity(),PATH);
            file=ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                    "report_problem",getDataAdapterCheckBox.getid());
            fileUri=Uri.fromFile(file);
            CamIntent.putExtra(MediaStore.EXTRA_OUTPUT,fileUri);
            startActivityForResult(CamIntent,1);
        }

    }

    int id_image_success=0;
    @Override
    public void click_photograph_image_success(View v, int position) {
        if(check_sale_contno.equals("0")){
            inputText.setHint("เลขที่สัญญาไม่ถูกต้อง");
            inputText.setHintTextColor(0xffff0000);
        }
        else {
            image_sucess=v;
            position_image_sucess= position;
            id_image_success=position+1;

            getDataAdapterCheckBox=GetDataAdapter1.get(position_image_sucess);

            CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        /*file = new File(Environment.getExternalStorageDirectory(),
                "file"+String.valueOf(System.currentTimeMillis())+".jpg");
        uri = Uri.fromFile(file);*/
            ic=new ImageConfiguration(getActivity(),PATH);
            file=ic.createImageByType_sucess(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                    "report_problem",getDataAdapterCheckBox.getid());
            fileUri=Uri.fromFile(file);
            CamIntent.putExtra(MediaStore.EXTRA_OUTPUT,fileUri);
            startActivityForResult(CamIntent,3);
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
    private void CropImage2() {

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
            startActivityForResult(CropIntent, 4);
        } catch (ActivityNotFoundException ex) {

        }
    }


    private Runnable myThread4 = new Runnable(){
        public void run() {
            try{


                if(filePath!=null)
                {

                    byte[] bfile2= Utils.BitmapToByteArray_image_device(bitmap);
                    //logo=Utils.getFileDate_image_device();



                    for(int i=0;i<2;i++){
                      //  Utils.doFileUpload_image_report_promlem(bfile2,getDataAdapterCheckBox.getImage_error());
                    }


                    //DELETE_IMAGE_DEVICE();
                   // JSON_DATA_WEB_CALL_IMAGE_CAMERA();
                   // INSENT_DATA_CHECK_DEVICE_PEEBANG();
                   // INSENT_history_image_product();

                }

            }
            catch(Exception e)
            {
                e.printStackTrace();

            }
          //  myHandle.sendMessage(myHandle.obtainMessage());
        }
    };

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

        else if(requestCode == 1) {
            if(resultCode==RESULT_OK) {

                CropImage();
                }

        } else if (requestCode == 2) {

            File storageDir =  null ;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
             storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("contno_save") + "/"+"report_problem"+ "/"+"ID"+getDataAdapterCheckBox.getid()+ "/"+"image_error"+"/");

            }

            File image[]= storageDir.listFiles();
           int fgf= image.length;
            for(int i=0;i<fgf;i++) {
                String DF = String.valueOf(image[i]);
            }

            Log.e("fgf", String.valueOf(fgf));
            try {
                if(fgf>1){
                    recyclerViewadapter1.count_image(fgf,position_image_error);
                    recyclerViewadapter1.notifyDataSetChanged();
                }
                else {

                }

            }
            catch (Exception ex){

            }
            String image_name=MyApplication.getInstance().getPrefManager().getPreferrence("imageName");
            String Problem_Type_ID="01";
            String Problem_TypeDeteils_ID= String.valueOf(id_image_error);
            String Url="http://app.thiensurat.co.th/assanee/uploads_image_report_problem/"+image_name+".jpg";

            String FILE=file.getAbsolutePath();
            File file2 = new File(FILE);
            long length = file2.length();
            length = length/1024;


            GetDataAdapter1.set(position_image_error,getDataAdapterCheckBox.setImage_error(file.getAbsolutePath()));
            recyclerViewadapter1.notifyDataSetChanged();
            int cout_image_error= getDataAdapterCheckBox.getImage_error().length();

            Log.e("cout_image_error", String.valueOf(cout_image_error));


           // INSENT_DATA_REPORT_PROBLEM_BUFFER();
            SQLiteDataBaseBuild();
            SQLiteTableBuild();

            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (contno,part_id,part_image,type_image,Problem_Type_ID,Problem_TypeDeteils_ID,Url,Image_Name,Image_Size,Image_Type) VALUES('" + MyApplication.getInstance().getPrefManager().getPreferrence("getCONTNO") + "','" + id_image_error + "', '" + file.getAbsolutePath() + "', '" + "image_error" + "', '" + Problem_Type_ID + "', '" + Problem_TypeDeteils_ID + "', '" + Url + "', '" + image_name + "', '" + length + "', '" + "jpg" + "');";
            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);




            cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper.TABLE_NAME+"" +" WHERE part_id ="+"'"+id_image_error+"'" +" and type_image ="+"'"+"image_success"+"'" , null);

            if (cursor.moveToFirst()) {
                do {

                   String FA=cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_part_image));
                    Log.e("A", FA);
                } while (cursor.moveToNext());
            }
            cursor.close();

            //recyclerViewadapter1.notifyDataSetChanged();
            position_recycle_view=id_image_error-1;
            GetDataAdapter1.clear();
           JSON_DATA_WEB_CALL();



        }
        else if(requestCode == 3) {
            if(resultCode==RESULT_OK) {

                CropImage2();
            }

        } else if (requestCode == 4) {

            File storageDir =  null ;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
                storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("contno_save") + "/"+"report_problem"+ "/"+"ID"+getDataAdapterCheckBox.getid()+ "/");

            }

            File image[]= storageDir.listFiles();
            int fgf= image.length;
            Log.e("fgf", String.valueOf(fgf));
            try {
                if(fgf>1){
                    recyclerViewadapter1.count_image(fgf,position_image_sucess);
                    recyclerViewadapter1.notifyDataSetChanged();
                }
                else {

                }

            }
            catch (Exception ex){

            }

            String Problem_Type_ID="01";
            String Problem_TypeDeteils_ID= String.valueOf(id_image_success);
            String Url="http://app.thiensurat.co.th/assanee/uploads_image_report_problem/";
            String image_name=MyApplication.getInstance().getPrefManager().getPreferrence("imageName");
            String FILE=file.getAbsolutePath();
            File file2 = new File(FILE);
            long length = file2.length();
            length = length/1024;


            GetDataAdapter1.set(position_image_sucess,getDataAdapterCheckBox.setImage_sucess(file.getAbsolutePath()));
            recyclerViewadapter1.notifyDataSetChanged();
            int cout_image_success= getDataAdapterCheckBox.getImage_sucess().length();

            Log.e("cout_image_error", String.valueOf(cout_image_success));


            // INSENT_DATA_REPORT_PROBLEM_BUFFER();
            SQLiteDataBaseBuild();
            SQLiteTableBuild();

            String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (contno,part_id,part_image,type_image,Problem_Type_ID,Problem_TypeDeteils_ID,Url,Image_Name,Image_Size,Image_Type) VALUES('" + MyApplication.getInstance().getPrefManager().getPreferrence("getCONTNO") + "','" + id_image_success + "', '" + file.getAbsolutePath() + "', '" + "image_success" + "', '" + Problem_Type_ID + "', '" + Problem_TypeDeteils_ID + "', '" + Url + "', '" + image_name + "', '" + length + "', '" + "jpg" + "');";
           // String SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (part_id,part_image,type_image) VALUES('" + id_image_success + "', '" + file.getAbsolutePath() + "', '" + "image_success" + "');";
            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);




            cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper.TABLE_NAME+"" +" WHERE part_id ="+"'"+id_image_success+"'" +" and type_image ="+"'"+"image_success"+"'"  , null);

            if (cursor.moveToFirst()) {
                do {

                    String FA=cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_part_image));
                    Log.e("A", FA);
                } while (cursor.moveToNext());
            }
            cursor.close();

            //recyclerViewadapter1.notifyDataSetChanged();
            position_recycle_view=id_image_success-1;
            GetDataAdapter1.clear();
            JSON_DATA_WEB_CALL();



        }


        else if (requestCode == 55) {

            position_recycle_view=position_image_error-1;
            GetDataAdapter1.clear();
            JSON_DATA_WEB_CALL();

        }
        else if (requestCode == 66) {

            position_recycle_view=position_image_sucess-1;
            GetDataAdapter1.clear();
            JSON_DATA_WEB_CALL();

        }

    }


    public void del_image_report_problem_to_device(){
        for(int i=0;i<GetDataAdapter1.size();i++){
            getDataAdapterCheckBox=GetDataAdapter1.get(i);
            try {
                ic.removeImage(fileUri+getDataAdapterCheckBox.getImage_error());
                ic.removeImage(fileUri+getDataAdapterCheckBox.getImage_sucess());

                Log.e("aaa",getDataAdapterCheckBox.getImage_error());
            }
            catch (Exception ex){
               Log.e("ex",ex.getMessage());
            }

        }

    }





    @Override
    public void onRowLongClicked(int position) {

        enableActionMode(position);
    }


    @Override
    public void onRowLongClicked2(int position) {

        enableActionMode2(position);
    }

    private void enableActionMode(int position) {

        toggleSelection(position);
    }
    private void enableActionMode2(int position) {

        toggleSelection2(position);
    }


    private void toggleSelection(int position) {
        Log.e("position", String.valueOf(position));
        recyclerViewadapter1.toggleSelection(position);
        int count = recyclerViewadapter1.getSelectedItemCount();
            count =count+ recyclerViewadapter1.getSelectedItemCount2();
       //int count2=recyclerViewadapter1.getSelectedItemCount2();
        count_menu=count;
        count_menu2=count_menu+1;


        if (count == 0) {
            getActivity().invalidateOptionsMenu();
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("แจ้งปัญหา");


            recyclerViewadapter1.clearSelections();
            recyclerViewadapter1.clearSelections2();


        } else {
            getActivity().invalidateOptionsMenu();
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(String.valueOf(count));

            GetData_cedit_remove_image_select_id remove_image_select_id = new GetData_cedit_remove_image_select_id();
            remove_image_select_id.setPart_id(String.valueOf(count_menu2));


        }
    }


    private void toggleSelection2(int position) {
        Log.e("position", String.valueOf(position));
        recyclerViewadapter1.toggleSelection2(position);
        int count = recyclerViewadapter1.getSelectedItemCount2();
      //  int count2 = recyclerViewadapter1.getSelectedItemCount2();
        count=count+recyclerViewadapter1.getSelectedItemCount();
        count_menu=count;
        count_menu2=count_menu+1;


        if (count == 0) {
            getActivity().invalidateOptionsMenu();
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("แจ้งปัญหา");

            recyclerViewadapter1.clearSelections();
            recyclerViewadapter1.clearSelections2();



        } else {
            getActivity().invalidateOptionsMenu();
          //  ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(String.valueOf(count));
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(String.valueOf(count));
            GetData_cedit_remove_image_select_id remove_image_select_id = new GetData_cedit_remove_image_select_id();
            remove_image_select_id.setPart_id(String.valueOf(count_menu2));


        }
    }


    // deleting the messages from recycler view
    private void deleteMessages() {
        recyclerViewadapter1.resetAnimationIndex();
        List<Integer> selectedItemPositions = recyclerViewadapter1.getSelectedItems();

        for (int i = selectedItemPositions.size() - 1; i >= 0; i--) {
            recyclerViewadapter1.removeData(selectedItemPositions.get(i));

        }





        recyclerViewadapter1.notifyDataSetChanged();
    }

    private void deleteMessages2() {
        recyclerViewadapter1.resetAnimationIndex2();
        List<Integer> selectedItemPositions2 = recyclerViewadapter1.getSelectedItems2();

        Log.e("selected_size", String.valueOf(selectedItemPositions2.size()));
        for (int i = selectedItemPositions2.size() - 1; i >= 0; i--) {
            recyclerViewadapter1.removeData2(selectedItemPositions2.get(i));

        }
        recyclerViewadapter1.notifyDataSetChanged();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        // TODO add your menu :
        inflater.inflate(R.menu.menu_action_mode, menu);
    if(count_menu==0){
        menu.findItem(R.id.action_delete).setVisible(false);
        menu.findItem(R.id.ss).setVisible(true);

    }
    else {
        menu.findItem(R.id.action_delete).setVisible(true);
        menu.findItem(R.id.ss).setVisible(false);
    }

      //  getActivity().invalidateOptionsMenu();

        //TODO call super
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_delete:
                deleteMessages();
                deleteMessages2();

                Log.e("DDDDD","SSSS");

                getActivity().invalidateOptionsMenu();
                ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("แจ้งปัญหา");


                recyclerViewadapter1.clearSelections2();
                recyclerViewadapter1.clearSelections();
                count_menu=0;

                GetDataAdapter1.clear();
                JSON_DATA_WEB_CALL();
                // Not implemented here
                return false;


            default:
                break;
        }

        return false;
    }
/*
    @Override
    public void onDestroy() {
        super.onDestroy();
        del_image_report_problem_to_device();
    }

    @Override
    public void onPause() {
        super.onPause();
        del_image_report_problem_to_device();
    }*/
}