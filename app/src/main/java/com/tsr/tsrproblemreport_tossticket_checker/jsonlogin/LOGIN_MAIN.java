package com.tsr.tsrproblemreport_tossticket_checker.jsonlogin;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.arturogutierrez.Badges;
import com.github.arturogutierrez.BadgesNotSupportedException;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;
import com.tsr.tsrproblemreport_tossticket_checker.Mechanic_system.MusicActivity_Mechanic;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.MusicActivity_Credit;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.MusicActivity_Progammer;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.Config;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;
import com.tsr.tsrproblemreport_tossticket_checker.retrofit.api.Service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.tsr.tsrproblemreport_tossticket_checker.API_URL_ALL.BASE_URL;



public class LOGIN_MAIN extends AppCompatActivity implements View.OnClickListener {
    EditText edt_user;
    EditText edt_pwd;
    Button button_login;
    private String user,pass,user2;
    public static StringBuilder recDataString = new StringBuilder();




    List<GetData> GetDataAdapter1;
    GetData getData,getData2,getData3,getData4,getData5;
    RecyclerView recyclerView;

    RecyclerView.LayoutManager recyclerViewlayoutManager;

    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/login5_3.php";

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
    //String JSON_UserName = "UserName";

    String JSON_themes_app = "themesapp";
    String JSON_themes_color1 = "themes_color1";
    String JSON_design_app_on_off_all = "design_app_on_off_all";
    String JSON_SourceSystem = "SourceSystem";
    String JSON_SALECODE ="SALECODE";
     String JSON_DepartId ="DepartId";
    String JSON_mcode ="mcode";
    String JSON_CashTeamCode="CashTeamCode";
    JsonArrayRequest jsonArrayRequest ;

    RequestQueue requestQueue ;
    private SwipeRefreshLayout swipeRefreshLayout;
    TextView counter;
    String COUTER;
    SweetAlertDialog pDialog2;
    private ProgressDialog pDialog;
    private BroadcastReceiver mRegistrationBroadcastReceiver;
    String deviceId,regId,tokenA,tokenb,EmployeeName,
            UserName,PositionCode, PositionCode2,PositionName,
            picture,backgound,TeamHeadCode,TeamHeadName,
            TeamName,SupervisorHeadCode,SupervisorHeadName,
            SupervisorName,SubDepartmentHeadCode,SubDepartmentHeadName,
            SubDepartmentName,DepartmentHeadCode,DepartmentHeadName,
            DepartmentName,SubTeamCode,TeamCode,themes_app,themes_color1,
            design_app_on_off_all,SourceSystem,SALECODE,DepartId,Mcode,CashTeamCode,
            count_problemall,count_problemyes,count_problemno,count_problemfollow;

    String android_name="";
    String IPaddress="";
    String AndroidDeviceID="";
    SweetAlertDialog pDialogg2;
    private TextView txtRegId, txtMessage,textView3;
    String themes_color2;
    String statuslogin,statuslogin_sale,statuslogin_SubTeamLeader,statuslogin_Supervisor,statuslogin_line,TOKEN;
    String myVersion="";
    String version="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authen3);
        //edt_user=(android.support.v7.widget.AppCompatEditText) findViewById(R.id.edt_user);
        edt_user=(EditText) findViewById(R.id.edt_user);

        edt_pwd=(EditText) findViewById(R.id.edt_pwd);
        button_login=(Button) findViewById(R.id.button_login);
      //  check_system_stop();
        TOKEN= FirebaseInstanceId.getInstance().getToken();

//        Log.e("TOKENTOKEN",TOKEN);


        try {
            Badges.setBadge(LOGIN_MAIN.this, 5);
        } catch (BadgesNotSupportedException badgesNotSupportedException) {
            //      Log.d(TAG, badgesNotSupportedException.getMessage());
        }

        NetwordDetect();
        android_name = Build.MANUFACTURER
                + " " + Build.MODEL + " " + Build.VERSION.RELEASE
                + " " + Build.VERSION_CODES.class.getFields()[android.os.Build.VERSION.SDK_INT].getName();

         myVersion = android.os.Build.VERSION.RELEASE; // e.g. myVersion := "1.6"

        AndroidDeviceID = Settings.Secure.getString(this.getContentResolver(),
                Settings.Secure.ANDROID_ID);

        MyApplication.getInstance().getPrefManager().setPreferrence("AndroidDeviceID", AndroidDeviceID);

        try {
            PackageInfo pInfo = this.getPackageManager().getPackageInfo(getPackageName(), 0);
             version = pInfo.versionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

      //  Toast.makeText(LOGIN_MAIN.this, "myVersion " +myVersion, Toast.LENGTH_LONG).show();

        //MyApplication.getInstance().getPrefManager().clear();
       // displayFirebaseRegId();
        try {
             statuslogin = MyApplication.getInstance().getPrefManager().getPreferrence("statuslogin");
             statuslogin_sale = MyApplication.getInstance().getPrefManager().getPreferrence("statuslogin_sale");
             statuslogin_SubTeamLeader = MyApplication.getInstance().getPrefManager().getPreferrence("statuslogin_SubTeamLeader");
             statuslogin_Supervisor = MyApplication.getInstance().getPrefManager().getPreferrence("statuslogin_Supervisor");
             statuslogin_line = MyApplication.getInstance().getPrefManager().getPreferrence("statuslogin_line");
             PositionCode2=MyApplication.getInstance().getPrefManager().getPreferrence("PositionCode");
             SourceSystem = MyApplication.getInstance().getPrefManager().getPreferrence("SourceSystem");


           // Log.e("statuslogin",statuslogin+","+statuslogin_sale+","+statuslogin_SubTeamLeader+","+statuslogin_Supervisor+","+statuslogin_line);
           if (statuslogin.equals("1")) {
               MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_M", "null");
               MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_L", "null");
               MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_S", "null");
               MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_T", "null");




                   try {
                       Log.e("PositionCode2",PositionCode2);

                       if(PositionCode2.equals("Programmer")) {
                           Intent intent2 = new Intent(LOGIN_MAIN.this, MusicActivity_Progammer.class);
                           startActivity(intent2);
                           finish();
                       }
                       else {
                           Intent intent = new Intent(LOGIN_MAIN.this, MusicActivity_Credit.class);
                           startActivity(intent);
                           finish();
                       }

                   }
                   catch (Exception ex){
                       Intent intent = new Intent(LOGIN_MAIN.this, MusicActivity_Credit.class);
                       startActivity(intent);
                       finish();
                   }








          }



        }
        catch (Exception ex){
          //  Log.e("statuslogin",ex.getMessage());
        }

        button_login.setOnClickListener(this);








    }

    @Override
    public void onClick(View view) {
        if(view == button_login){
            try {
                MyApplication.getInstance().getPrefManager().setPreferrence("statuslogin", "0");

                user = edt_user.getText().toString();
                pass = edt_pwd.getText().toString();
                recDataString.delete(0, recDataString.length());
                recDataString.append(user);
                user2 = recDataString.substring(1, 6);



                if(pass.equals(user2)){
                    deviceId  = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
                    if (checkConnection() == true) {

                        pDialog2 = new SweetAlertDialog(LOGIN_MAIN.this, SweetAlertDialog.PROGRESS_TYPE);
                        pDialog2.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                        pDialog2.setTitleText("Loading");
                        pDialog2.setCancelable(true);
                        pDialog2.show();

                        update_TOKEN();
                        INSENT_LOGIN_LOOKHIN();

                        login_r();
                    } else {

                        pDialog2 = new SweetAlertDialog(LOGIN_MAIN.this, SweetAlertDialog.PROGRESS_TYPE);
                        pDialog2.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                        pDialog2.setTitleText("Loading");
                        pDialog2.setCancelable(true);
                        pDialog2.show();

                        login_r();




                    }
                }
                else {
                    new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("ผิดพลาด")
                            .setContentText("user/password ไม่ถูกต้อง!")
                            .show();
                }

            }
            catch (Exception ex){
                if(!pass.equals(user)){
                    new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("ผิดพลาด")
                            .setContentText("user/password ไม่ถูกต้อง!")
                            .show();
                }
                else {
                    new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("ผิดพลาด")
                            .setContentText("กรุณากรอก user/password !")
                            .show();
                }

            }

        }
    }




    private void displayFirebaseRegId() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences(Config.SHARED_PREF, 0);
        regId = pref.getString("regId", null);
        tokenA = regId;

        if (!TextUtils.isEmpty(regId))
            tokenA = regId;
        else
            tokenb = regId;




        Log.e("tokenA3",tokenA);
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

    public void JSON_DATA_WEB_CALL(){

        // jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL+"?picture="+"http://app.thiensurat.co.th/assanee/upload/image8.png",
       Log.e("eeeeeeeeeeeee",GET_JSON_DATA_HTTP_URL+"?EmpID="+user);
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL+"?EmpID="+user,
                //        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //JSON_PARSE_DATA_AFTER_WEBCALL(response);
                        Log.e("response", response.toString());
                        if (response.length() == 0) {

                            try {
                                pDialog2.cancel();
                                pDialog2.dismiss();
                            }
                            catch (Exception ex){

                            }

                            new SweetAlertDialog(LOGIN_MAIN.this, SweetAlertDialog.ERROR_TYPE)
                                    .setTitleText("ผิดพลาด")
                                    .setContentText("พนักงานลาออกแล้ว!")

                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sDialog) {

                                            sDialog.dismiss();
                                            //   edt_pwd.setText("");
                                            try {
                                             //   pDialog2.cancel();
                                            //    pDialog2.dismiss();
                                            }
                                            catch (Exception ex){

                                            }
                                        }
                                    })
                                    .show();

                        } else {

/*
                            pDialog2 = new SweetAlertDialog(LOGIN_MAIN.this, SweetAlertDialog.PROGRESS_TYPE);
                            pDialog2.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                            pDialog2.setTitleText("Loading");
                            pDialog2.setCancelable(true);
                            pDialog2.show();*/

                            JSON_PARSE_DATA_AFTER_WEBCALL(response);

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        JSON_DATA_WEB_CALL();
                    }
                });


        /*
        jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
*/

        try {
            try {
                requestQueue = Volley.newRequestQueue(this);
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




    private void login_r() {

        try {

            Log.e("BASE_URLBASE_URL",BASE_URL);


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            Service request = retrofit.create(Service.class);
            Call call = request.getSale(user);
            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, retrofit2.Response response) {
                   // Log.e("error","ok");
                    Gson gson=new Gson();
                    try {
                        JSONObject jsonObject=new JSONObject(gson.toJson(response.body()));

                        JSON_PARSE_DATA_AFTER_WEBCALL(jsonObject.getJSONArray("data"));

                        Log.e("okok","ok");

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.e("error","error");
                    }


                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    Log.e("error","error2");
                    pDialog2.dismiss();
                    try {
                        String CHCEK=t.getLocalizedMessage()+"";
                        if(CHCEK.equals("timeout")){
                            new SweetAlertDialog(LOGIN_MAIN.this, SweetAlertDialog.ERROR_TYPE)
                                    .setTitleText("ผิดพลาด")
                                    .setContentText("ไม่สามารถเชื่อมต่อกับเซิร์ฟเวอร์ได้!")
                                    .show();


                        }
                    }
                    catch (Exception ex){

                    }

                }
            });

        } catch (Exception e) {

        }
    }





    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array){
        Log.e("array.length()", String.valueOf(array.length()));

        if(array.length()==0){

            try {
                pDialog2.cancel();
                pDialog2.dismiss();

            }
            catch (Exception ex){

            }
                new SweetAlertDialog(LOGIN_MAIN.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("ผิดพลาด ไม่สามารถเข้าระบบได้!")
                    .setContentText("เนื่องจาก รหัสนี้ : "+"ไม่มีในระบบ")

                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {

                            sDialog.dismiss();
                            //   edt_pwd.setText("");
                            sDialog.dismissWithAnimation();
                            sDialog.cancel();
                        }
                    })
                    .show();
        }
        else {
            for(int i = 0; i<array.length(); i++) {

                GetData GetDataAdapter2 = new GetData();

                JSONObject json = null;
                try {
                    json = array.getJSONObject(i);
                    Log.e("JSON length",json.getString(JSON_PositionCode));
                    getData =new GetData();
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
                    //  getData.setUserName(json.getString(JSON_UserName));
                    getData.setthemes_app(json.getString(JSON_themes_app));
                    getData.setthemes_color1(json.getString(JSON_themes_color1));
                    getData.setdesign_app_on_off_all(json.getString(JSON_design_app_on_off_all));
                    getData.setSourceSystem(json.getString(JSON_SourceSystem));
                    getData.setSALECODE(json.getString(JSON_SALECODE));
                    getData.setDepartId(json.getString(JSON_DepartId));
                    getData.setMcode(json.getString(JSON_mcode));
                    getData.setCashTeamCode(json.getString(JSON_CashTeamCode));

                    EmployeeName=getData.getEmployeeName();
                    PositionCode= getData.getPositionCode();
                    PositionName= getData.getPositionName();
                    picture= getData.getpicture();
                    backgound= getData.getbackgound();

                    TeamHeadCode= getData.getTeamHeadCode();
                    TeamHeadName= getData.getTeamHeadName();
                    TeamName= getData.getTeamName();

                    SupervisorHeadCode= getData.getSupervisorHeadCode();
                    SupervisorHeadName= getData.getSupervisorHeadName();
                    SupervisorName= getData.getSupervisorName();

                    SubDepartmentHeadCode= getData.getSubDepartmentHeadCode();
                    SubDepartmentHeadName= getData.getSubDepartmentHeadName();
                    SubDepartmentName= getData.getSubDepartmentName();

                    DepartmentHeadCode= getData.getDepartmentHeadCode();
                    DepartmentHeadName= getData.getDepartmentHeadName();
                    DepartmentName= getData.getDepartmentName();

                    SubTeamCode= getData.getSubTeamCode();
                    TeamCode= getData.getTeamCode();
                    UserName= getData.getUserName();
                    themes_app= getData.getthemes_app();
                    themes_color1= getData.getthemes_color1();
                    design_app_on_off_all= getData.getdesign_app_on_off_all();
                    SourceSystem= getData.getSourceSystem();

                    Log.e("PositionCode",PositionCode);

                    SALECODE= getData.getSALECODE();
                    DepartId= getData.getDepartId();
                    Mcode= getData.getMcode();
                    CashTeamCode= getData.getCashTeamCode();
                    if(themes_color1.equals(null)){
                        themes_color2="-1";
                    }
                    else {
                        themes_color2=getData.getthemes_color1();
                    }

                    Log.e("PositionCode",PositionCode);

                    MyApplication.getInstance().getPrefManager().setPreferrence("EmployeeName", EmployeeName);
                    //MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode", PositionCode);
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
                    MyApplication.getInstance().getPrefManager().setPreferrence("design", design_app_on_off_all);
                    MyApplication.getInstance().getPrefManager().setPreferrence("EMPID", user);
                    MyApplication.getInstance().getPrefManager().setPreferrence("SourceSystem", SourceSystem);
                    MyApplication.getInstance().getPrefManager().setPreferrence("SALECODE", SALECODE);
                    MyApplication.getInstance().getPrefManager().setPreferrence("DepartId", DepartId);
                    MyApplication.getInstance().getPrefManager().setPreferrence("android_name", android_name);
                    MyApplication.getInstance().getPrefManager().setPreferrence("IPaddress", IPaddress);
                    MyApplication.getInstance().getPrefManager().setPreferrence("VersionOS", myVersion);
                    MyApplication.getInstance().getPrefManager().setPreferrence("Mcode", Mcode);
                    MyApplication.getInstance().getPrefManager().setPreferrence("CashTeamCode", CashTeamCode);
                    MyApplication.getInstance().getPrefManager().setPreferrence("TOKEN", TOKEN);

                    MyApplication.getInstance().getPrefManager().setPreferrence("debug_run_error_checker1", json.getString("debug_run_error_checker1"));


                    if (array.length() > 1) {
                        MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode", "null");
                        if (array.getJSONObject(i).getString(JSON_PositionCode).equals("Manager")) {
                            MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_M", PositionCode);
                        }
                        else if(array.getJSONObject(i).getString(JSON_PositionCode).equals("LineManager")) {
                            MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_L", PositionCode);
                        }
                        else if(array.getJSONObject(i).getString(JSON_PositionCode).equals("Supervisor")) {
                            MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_S", PositionCode);
                        }
                        else if(array.getJSONObject(i).getString(JSON_PositionCode).equals("SubTeamLeader")) {
                            MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_T", PositionCode);
                        }
                    }
                    else {
                        MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode", PositionCode);
                        MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_M", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_L", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_S", "null");
                        MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_T", "null");
                    }

                    if(SourceSystem.equals("Credit")){
                        MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode", PositionCode);
                        MyApplication.getInstance().getPrefManager().setPreferrence("statuslogin", "1");

                    }

                    else if(SourceSystem.equals("Sale")){
                        String  PositionCode_M=MyApplication.getInstance().getPrefManager().getPreferrence("PositionCode_M")+"";
                        String  PositionCode_L=MyApplication.getInstance().getPrefManager().getPreferrence("PositionCode_L")+"";
                        String  PositionCode_S=MyApplication.getInstance().getPrefManager().getPreferrence("PositionCode_S")+"";
                        String  PositionCode_T=MyApplication.getInstance().getPrefManager().getPreferrence("PositionCode_T")+"";
                        String  PositionCode=MyApplication.getInstance().getPrefManager().getPreferrence("PositionCode")+"";

                        Log.e("PositionCode_ALL",PositionCode_M+","+PositionCode_L+","+PositionCode_S+","+PositionCode_T+","+PositionCode);
                        if((PositionCode_M.equals("Manager"))&(PositionCode_L.equals("LineManager"))&(PositionCode_S.equals("Supervisor"))&(PositionCode_T.equals("SubTeamLeader"))&(PositionCode.equals("Sale"))){
                            PositionCode2="Manager";
                        }
                        else if((PositionCode_M.equals("Manager"))&(PositionCode_L.equals("LineManager"))&(PositionCode_S.equals("Supervisor"))&(PositionCode_T.equals("SubTeamLeader"))&(PositionCode.equals("null"))){
                            PositionCode2="Manager";
                        }
                        else if((PositionCode_M.equals("Manager"))&(PositionCode_L.equals("LineManager"))&(PositionCode_S.equals("Supervisor"))&(PositionCode_T.equals("null"))&(PositionCode.equals("null"))){
                            PositionCode2="Manager";
                        }
                        else if((PositionCode_M.equals("Manager"))&(PositionCode_L.equals("LineManager"))&(PositionCode_S.equals("null"))&(PositionCode_T.equals("null"))&(PositionCode.equals("null"))){
                            PositionCode2="Manager";
                        }
                        else if((PositionCode_M.equals("Manager"))&(PositionCode_L.equals("null"))&(PositionCode_S.equals("null"))&(PositionCode_T.equals("null"))&(PositionCode.equals("null"))){
                            PositionCode2="Manager";
                        }

                        else if((PositionCode_M.equals("null"))&(PositionCode_L.equals("LineManager"))&(PositionCode_S.equals("Supervisor"))&(PositionCode_T.equals("SubTeamLeader"))&(PositionCode.equals("Sale"))){
                            PositionCode2="LineManager";
                        }
                        else if((PositionCode_M.equals("null"))&(PositionCode_L.equals("LineManager"))&(PositionCode_S.equals("Supervisor"))&(PositionCode_T.equals("SubTeamLeader"))&(PositionCode.equals("null"))){
                            PositionCode2="LineManager";
                        }
                        else if((PositionCode_M.equals("null"))&(PositionCode_L.equals("LineManager"))&(PositionCode_S.equals("Supervisor"))&(PositionCode_T.equals("null"))&(PositionCode.equals("null"))){
                            PositionCode2="LineManager";
                        }
                        else if((PositionCode_M.equals("null"))&(PositionCode_L.equals("LineManager"))&(PositionCode_S.equals("null"))&(PositionCode_T.equals("null"))&(PositionCode.equals("null"))){
                            PositionCode2="LineManager";
                        }

                        else if((PositionCode_M.equals("null"))&(PositionCode_L.equals("null"))&(PositionCode_S.equals("Supervisor"))&(PositionCode_T.equals("SubTeamLeader"))&(PositionCode.equals("Sale"))){
                            PositionCode2="Supervisor";
                        }
                        else if((PositionCode_M.equals("null"))&(PositionCode_L.equals("null"))&(PositionCode_S.equals("Supervisor"))&(PositionCode_T.equals("SubTeamLeader"))&(PositionCode.equals("null"))){
                            PositionCode2="Supervisor";
                        }
                        else if((PositionCode_M.equals("null"))&(PositionCode_L.equals("null"))&(PositionCode_S.equals("Supervisor"))&(PositionCode_T.equals("null"))&(PositionCode.equals("null"))){
                            PositionCode2="Supervisor";
                        }

                        else if((PositionCode_M.equals("null"))&(PositionCode_L.equals("null"))&(PositionCode_S.equals("null"))&(PositionCode_T.equals("SubTeamLeader"))&(PositionCode.equals("Sale"))){
                            PositionCode2="SubTeamLeader";
                        }
                        else if((PositionCode_M.equals("null"))&(PositionCode_L.equals("null"))&(PositionCode_S.equals("null"))&(PositionCode_T.equals("SubTeamLeader"))&(PositionCode.equals("null"))){
                            PositionCode2="SubTeamLeader";
                        }

                        else  if((PositionCode_M.equals("null"))&(PositionCode_L.equals("null"))&(PositionCode_S.equals("null"))&(PositionCode_T.equals("null"))&(PositionCode.equals("Manager"))){
                            PositionCode2="Manager";
                        }
                        else  if((PositionCode_M.equals("null"))&(PositionCode_L.equals("null"))&(PositionCode_S.equals("null"))&(PositionCode_T.equals("null"))&(PositionCode.equals("LineManager"))){
                            PositionCode2="LineManager";
                        }
                        else  if((PositionCode_M.equals("null"))&(PositionCode_L.equals("null"))&(PositionCode_S.equals("null"))&(PositionCode_T.equals("null"))&(PositionCode.equals("Supervisor"))){
                            PositionCode2="Supervisor";
                        }
                        else  if((PositionCode_M.equals("null"))&(PositionCode_L.equals("null"))&(PositionCode_S.equals("null"))&(PositionCode_T.equals("null"))&(PositionCode.equals("SubTeamLeader"))){
                            PositionCode2="SubTeamLeader";
                        }
                        else  if((PositionCode_M.equals("null"))&(PositionCode_L.equals("null"))&(PositionCode_S.equals("null"))&(PositionCode_T.equals("null"))&(PositionCode.equals("Sale"))){
                            PositionCode2="Sale";
                        }

                        else {
                            PositionCode2="Sale";
                        }

                        Log.e("vvvv",PositionCode2+"");

                        MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode", PositionCode2);
                    }
                    else if(PositionCode.equals("Sale")){

                        try {
                            pDialog2.cancel();
                            pDialog2.dismiss();
                            Intent intent = new Intent(LOGIN_MAIN.this, MusicActivity_Credit.class);
                            startActivity(intent);
                        }
                        catch (Exception ex){

                        }
                        finish();
                    }


                    else if(SourceSystem.equals("null")){
                        try {
                            pDialog2.cancel();
                            pDialog2.dismiss();
                        }
                        catch (Exception EX){

                        }
                        new SweetAlertDialog(LOGIN_MAIN.this, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("ผิดพลาด")
                                .setContentText("พนักงานลาออกแล้ว!")

                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sDialog) {

                                        sDialog.dismiss();
                                        //   edt_pwd.setText("");
                                        sDialog.dismissWithAnimation();
                                        sDialog.cancel();
                                    }
                                })
                                .show();
                    }
                } catch (JSONException e) {
                    Log.e("Exception", e.getLocalizedMessage());
                    e.printStackTrace();

                }
            }


            try {
                if(PositionCode.equals("Programmer")) {
                    MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode", "Programmer");
                    MyApplication.getInstance().getPrefManager().setPreferrence("statuslogin", "1");
                    try {
                        pDialog2.cancel();
                        pDialog2.dismiss();

                        if(array.length()!=0){
                            Intent intent = new Intent(LOGIN_MAIN.this, MusicActivity_Progammer.class);
                            startActivity(intent);

                            finish();
                        }
                        else {
                            CHECK_ACODE();
                        }



                    } catch (Exception ex) {

                    }

                }
              else  if(PositionCode.equals("Mechanic")) {
                   // MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode", "Programmer");
                    MyApplication.getInstance().getPrefManager().setPreferrence("statuslogin", "1");
                    try {
                        pDialog2.cancel();
                        pDialog2.dismiss();

                        if(array.length()!=0){
                            Intent intent = new Intent(LOGIN_MAIN.this, MusicActivity_Mechanic.class);
                            startActivity(intent);

                            finish();
                        }
                        else {
                            CHECK_ACODE();
                        }



                    } catch (Exception ex) {

                    }

                }
                else {
                    MyApplication.getInstance().getPrefManager().setPreferrence("statuslogin", "1");
                    try {
                        pDialog2.cancel();
                        pDialog2.dismiss();

                        if(array.length()!=0){
                            Intent intent = new Intent(LOGIN_MAIN.this, MusicActivity_Credit.class);
                            startActivity(intent);
                            finish();
                        }

                        else {
                            CHECK_ACODE();
                        }



                    } catch (Exception ex) {

                    }

                }
            }
            catch (Exception E){
                MyApplication.getInstance().getPrefManager().setPreferrence("statuslogin", "1");
                try {
                    pDialog2.cancel();
                    pDialog2.dismiss();

                    if(array.length()!=0){
                        Intent intent = new Intent(LOGIN_MAIN.this, MusicActivity_Credit.class);
                        startActivity(intent);

                        finish();
                    }

                    else {
                        CHECK_ACODE();
                    }






                } catch (Exception ex) {

                }

            }
        }



    }




    private void CHECK_ACODE() {

        try {


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            Service request = retrofit.create(Service.class);
            Call call = request.getSale4(user);
            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, retrofit2.Response response) {
                    Log.e("error","ok");
                    Gson gson=new Gson();
                    try {
                        JSONObject jsonObject=new JSONObject(gson.toJson(response.body()));

                        JSON_PARSE_DATA_AFTER_WEBCALL_CHECK_ACODE(jsonObject.getJSONArray("data"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    pDialog2.dismiss();
                    Log.e("error",t.getLocalizedMessage());

                }
            });

        } catch (Exception e) {

        }
    }
    String SALE_STATUS="",SALE_STATUS_NAME="";
    public void JSON_PARSE_DATA_AFTER_WEBCALL_CHECK_ACODE(JSONArray array) {
int xx=array.length();
if(xx==0){
    new SweetAlertDialog(LOGIN_MAIN.this, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("ผิดพลาด ไม่สามารถเข้าระบบได้!")
            .setContentText("เนื่องจาก รหัสนี้ : "+"ไม่มีในระบบ")

            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sDialog) {

                    sDialog.dismiss();
                    //   edt_pwd.setText("");
                    sDialog.dismissWithAnimation();
                    sDialog.cancel();
                }
            })
            .show();
                }
                else {
                    for (int i = 0; i < array.length(); i++) {

                        GetData GetDataAdapter2 = new GetData();

                        JSONObject json = null;
                        try {
                            json = array.getJSONObject(i);

                            SALE_STATUS=json.getString("SaleStatus");



                        } catch (JSONException e) {

                            e.printStackTrace();

                        }
                    }

                    if (SALE_STATUS.equals("D")) {
                        SALE_STATUS_NAME="รักษาการ";


                    }
                    else if (SALE_STATUS.equals("G")) {
                        SALE_STATUS_NAME="ย้ายออก";


                    }

                    else if (SALE_STATUS.equals("P")) {
                        SALE_STATUS_NAME="ย้าย";



                    } else {
                        SALE_STATUS_NAME="ออก";


                    }





                    MyApplication.getInstance().getPrefManager().setPreferrence("statuslogin", "0");


                    new SweetAlertDialog(LOGIN_MAIN.this, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("ผิดพลาด ไม่สามารถเข้าระบบได้!")
                            .setContentText("เนื่องจาก รหัสนี้ : "+SALE_STATUS_NAME)

                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {

                                    sDialog.dismiss();
                                    //   edt_pwd.setText("");
                                    sDialog.dismissWithAnimation();
                                    sDialog.cancel();
                                }
                            })
                            .show();
                }




    }








    String GET_JSON_DATA_HTTP_URL_UPDATE_TOKEN="http://app.thiensurat.co.th/assanee/updatetoken.php";
    public void update_TOKEN() {

        try {
            Log.e("url_update",GET_JSON_DATA_HTTP_URL_UPDATE_TOKEN + "?tokenA=" + TOKEN+ "&username=" + user+ "&android_device=" + AndroidDeviceID+ "&android_name=" + URLEncoder.encode(android_name, "UTF-8")+ "&android_version=" + URLEncoder.encode(myVersion, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_UPDATE_TOKEN + "?tokenA=" + TOKEN+ "&username=" + user+ "&android_device=" + AndroidDeviceID+ "&android_name=" + URLEncoder.encode(android_name, "UTF-8") + "&android_version=" + URLEncoder.encode(myVersion, "UTF-8"),


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

                int MY_SOCKET_TIMEOUT_MS=30000;

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






    private void NetwordDetect() {

        boolean WIFI = false;

        boolean MOBILE = false;

        ConnectivityManager CM = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo[] networkInfo = CM.getAllNetworkInfo();

        for (NetworkInfo netInfo : networkInfo) {

            if (netInfo.getTypeName().equalsIgnoreCase("WIFI"))

                if (netInfo.isConnected())

                    WIFI = true;

            if (netInfo.getTypeName().equalsIgnoreCase("MOBILE"))

                if (netInfo.isConnected())

                    MOBILE = true;
        }

        if(WIFI == true)

        {
            IPaddress = GetDeviceipWiFiData();
            //textview.setText(IPaddress);


        }

        if(MOBILE == true)
        {

            IPaddress = GetDeviceipMobileData();
            // textview.setText(IPaddress);

        }



        Log.e("IPaddress",IPaddress);

    }


    public String GetDeviceipMobileData(){
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
                 en.hasMoreElements();) {
                NetworkInterface networkinterface = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = networkinterface.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (Exception ex) {
            Log.e("Current IP", ex.toString());
        }
        return null;
    }

    public String GetDeviceipWiFiData()
    {

        @SuppressLint("WifiManagerLeak") WifiManager wm = (WifiManager) this.getSystemService(WIFI_SERVICE);

        @SuppressWarnings("deprecation")

        String ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());

        return ip;

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent=new Intent();
            setResult(RESULT_OK, intent);
            finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==100){

            if (checkConnection() == true) {

                JSON_DATA_WEB_CALL();

            } else {

                final Dialog dialog = new Dialog(LOGIN_MAIN.this);
                dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.customdialog_checkinternet);
                dialog.setCancelable(true);

                Button button1 = (Button) dialog.findViewById(R.id.button1);
                Button button6 = (Button) dialog.findViewById(R.id.button6);
                button1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext()
                                , "Close dialog", Toast.LENGTH_SHORT);

                        Intent intent = new Intent(Settings.ACTION_SETTINGS);

                        startActivityForResult(intent, 100);
                    }
                });

                button6.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext()
                                , "Close dialog", Toast.LENGTH_SHORT);
                        dialog.cancel();
                        dialog.dismiss();
                        finish();
                    }
                });

                dialog.show();

            }


        }

        else if(requestCode==10){
            JSON_DATA_WEB_CALL();
        }
    }




    String check_system_stop_or_run="";
    String node="";
    String node2="";
    String node3="";
    public void JSON_PARSE_DATA_AFTER_check_system_stop(JSONArray array) {


        for (int i = 0; i < array.length(); i++) {

            //final GetData_select_topic_problem_sub GetDataAdapter2 = new GetData_select_topic_problem_sub();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                // GetDataAdapter2.setProblemID(json.getString("InformID"));
                check_system_stop_or_run=json.getString("check_system_stop_or_run");
                node=json.getString("node");
                node2=json.getString("node2");
                node3=json.getString("node3");

                Log.e("check_system",check_system_stop_or_run);


                if(check_system_stop_or_run.equals("1")){
                    SweetAlertDialog sweetAlertDialog=  new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE);
                    sweetAlertDialog.setTitleText(node);
                    sweetAlertDialog.setContentText(node2);
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

            } catch (JSONException e) {

                e.printStackTrace();
            }

        }




    }




String GET_JSON_INSENT_LOGIN_LOOKHIN="https://tssm.thiensurat.co.th/addLogloginApp.php";
    public   void INSENT_LOGIN_LOOKHIN(){

        String EmpID=user;
        String TypeLogin="LOGIN";
        String GCMID=TOKEN;
        String AppVersion=version;
        String AndroidVersion=myVersion;



        StringRequest postRequest = new StringRequest(Request.Method.POST, GET_JSON_INSENT_LOGIN_LOOKHIN,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                       // Log.e("Response_sucess", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                       // Log.e("Response_error", error.getLocalizedMessage()+"");
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("EmpID", EmpID);
                params.put("TypeLogin",TypeLogin);
              //  params.put("GCMID",GCMID);
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
}
