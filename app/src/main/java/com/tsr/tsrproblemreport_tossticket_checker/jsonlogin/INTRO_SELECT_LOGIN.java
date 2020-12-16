package com.tsr.tsrproblemreport_tossticket_checker.jsonlogin;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.MusicActivity_Credit;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;
import com.tsr.tsrproblemreport_tossticket_checker.retrofit.api.Service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.tsr.tsrproblemreport_tossticket_checker.API_URL_ALL.BASE_URL;


public class INTRO_SELECT_LOGIN extends AppCompatActivity {

    CircleImageView bighead_image,tsr_image;
    String AndroidDeviceID="";
    GetData getData;

    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/login_device3.php";

    String JSON_EMPID= "EmpID";
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

    String regId,tokenA,tokenb,EmployeeName,
            UserName,PositionCode, PositionCode2,PositionName,
            picture,backgound,TeamHeadCode,TeamHeadName,
            TeamName,SupervisorHeadCode,SupervisorHeadName,
            SupervisorName,SubDepartmentHeadCode,SubDepartmentHeadName,
            SubDepartmentName,DepartmentHeadCode,DepartmentHeadName,
            DepartmentName,SubTeamCode,TeamCode,themes_app,themes_color1,
            design_app_on_off_all,SourceSystem,SALECODE,DepartId,Mcode,CashTeamCode,
            count_problemall,count_problemyes,count_problemno,count_problemfollow,EMPID;
    String android_name="";
    String IPaddress="";
    String themes_color2;
    String statuslogin,statuslogin_sale,statuslogin_SubTeamLeader,statuslogin_Supervisor,statuslogin_line,TOKEN;
    String myVersion="",version="";
    SweetAlertDialog pDialog2;
    int check_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro__app);
        bighead_image=(CircleImageView) findViewById(R.id.bighead_image);
        tsr_image=(CircleImageView) findViewById(R.id.tsr_image);

        TOKEN= FirebaseInstanceId.getInstance().getToken();

        android_name = Build.MANUFACTURER
                + " " + Build.MODEL + " " + Build.VERSION.RELEASE
                + " " + Build.VERSION_CODES.class.getFields()[android.os.Build.VERSION.SDK_INT].getName();

        myVersion = android.os.Build.VERSION.RELEASE; // e.g. myVersion := "1.6"

        AndroidDeviceID = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        MyApplication.getInstance().getPrefManager().setPreferrence("AndroidDeviceID", AndroidDeviceID);

        Log.e("AndroidDeviceswdsds",AndroidDeviceID);
        try {
            PackageInfo pInfo = this.getPackageManager().getPackageInfo(getPackageName(), 0);
            version = pInfo.versionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
      //  JSON_DATA_WEB_CALL();
        try {
            Log.e("tttt","tttt");
           pDialog2 = new SweetAlertDialog(INTRO_SELECT_LOGIN.this, SweetAlertDialog.PROGRESS_TYPE);
            pDialog2.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
            pDialog2.setTitleText("Loading");
            pDialog2.setCancelable(true);
            pDialog2.show();
        //    ProgressDialog dialog

            //JSON_DATA_WEB_CALL_check();


                    login_r();


        }
        catch (OutOfMemoryError EX){
             Log.e("RuntimeException555",EX.getLocalizedMessage());

        }

        if(check_login>0){
            /*
            pDialog2 = new SweetAlertDialog(INTRO_SELECT_LOGIN.this, SweetAlertDialog.PROGRESS_TYPE);
            pDialog2.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
            pDialog2.setTitleText("Loading");
            pDialog2.setCancelable(true);
            pDialog2.show();

            MyApplication.getInstance().getPrefManager().setPreferrence("statuslogin", "1");

            update_TOKEN();
            Intent intent = new Intent(INTRO_SELECT_LOGIN.this, MusicActivity_Credit.class);
            startActivity(intent);        try {
                pDialog2.cancel();
                pDialog2.dismiss();
            }
            catch (Exception ex){

            }



            finish();*/

        }
        else {

        }


        bighead_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String DD = String.valueOf(getPackageManager().getLaunchIntentForPackage("th.co.thiensurat"));
                final String appPackageName = "th.co.thiensurat&hl=th";
                if (DD.equals("null")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=th.co.thiensurat"));
                    // startActivity(intent);
                    startActivityForResult(intent, 10);
                }
                else {

                    try {
                        Intent intent = getPackageManager().getLaunchIntentForPackage("th.co.thiensurat");
                        startActivityForResult(intent, 10);
                    }
                    catch (OutOfMemoryError EX){
                        Log.e("RuntimeException555",EX.getLocalizedMessage());

                    }


                }








            }
        });

        tsr_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(INTRO_SELECT_LOGIN.this, LOGIN_MAIN.class);
                startActivity(intent);
                finish();
            }
        });



    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
           if(requestCode==10){

               try {
                   Log.e("tttt","tttt");
                   pDialog2 = new SweetAlertDialog(INTRO_SELECT_LOGIN.this, SweetAlertDialog.PROGRESS_TYPE);
                   pDialog2.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                   pDialog2.setTitleText("Loading");
                   pDialog2.setCancelable(true);
                   pDialog2.show();


                   login_r();
                 //  JSON_DATA_WEB_CALL();
               }
               catch (OutOfMemoryError EX){
                 //  Log.e("RuntimeException555",EX.getLocalizedMessage());

               }

        }

    }



    public void JSON_DATA_WEB_CALL(){

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL+"?AndroidDeviceID="+AndroidDeviceID,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSON_PARSE_DATA_AFTER_WEBCALL(response);



                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        try {
                            pDialog2.cancel();
                            pDialog2.dismiss();
                        }
                        catch (Exception ex){

                        }

                        JSON_DATA_WEB_CALL();
                    }
                });


                try {
                    requestQueue = Volley.newRequestQueue(this);
                    requestQueue.add(jsonArrayRequest);
                }
                catch (OutOfMemoryError EX){
                  //  requestQueue.stop();

                   Log.e("RuntimeException555",EX.getLocalizedMessage());
                    JSON_DATA_WEB_CALL();
                }


    }


    public void JSON_DATA_WEB_CALL_check(){

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL+"?AndroidDeviceID="+AndroidDeviceID,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSON_PARSE_DATA_AFTER_WEBCALL(response);



                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        try {
                            pDialog2.cancel();
                            pDialog2.dismiss();
                        }
                        catch (Exception ex){

                        }

                        //JSON_DATA_WEB_CALL();
                    }
                });


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



    private void login_r() {

        try {
            //    String SALECODE= MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");
            /*client Client = new client();
            Service request = Client.retrofit.create(Service.class);*/

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            Service request = retrofit.create(Service.class);
            Call call = request.getSale2(AndroidDeviceID);
            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, retrofit2.Response response) {
                    //Log.e("onResponse",response.body() + "");
                    Gson gson=new Gson();
                    try {
                        JSONObject jsonObject=new JSONObject(gson.toJson(response.body()));
                        //Log.e("JSON length",jsonObject.getJSONArray("data").length() + "");
                        JSON_PARSE_DATA_AFTER_WEBCALL(jsonObject.getJSONArray("data"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    pDialog2.dismiss();
//                   Log.e("onFailure",t.getLocalizedMessage());
                }
            });

        } catch (Exception e) {

        }
    }


    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array){

         check_login=array.length();

         if(check_login==0){
             try {
                 pDialog2.dismiss();
                 pDialog2.dismissWithAnimation();

             }
             catch (Exception ex){

             }

         }
         else {
             for(int i = 0; i<array.length(); i++) {

                 //    GetData GetDataAdapter2 = new GetData();

                 JSONObject json = null;
                 try {

                     json = array.getJSONObject(i);


                     getData =new GetData();
                     getData.setEMPID(json.getString(JSON_EMPID));
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

                     EMPID=getData.getEMPID();
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

                     Log.e("SourceSystem",SourceSystem);
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

                     if(PositionCode.equals("")){

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
                     MyApplication.getInstance().getPrefManager().setPreferrence("EMPID", EMPID);
                     MyApplication.getInstance().getPrefManager().setPreferrence("SourceSystem", SourceSystem);
                     MyApplication.getInstance().getPrefManager().setPreferrence("SALECODE", SALECODE);
                     MyApplication.getInstance().getPrefManager().setPreferrence("DepartId", DepartId);
                     MyApplication.getInstance().getPrefManager().setPreferrence("android_name", android_name);
                     MyApplication.getInstance().getPrefManager().setPreferrence("IPaddress", IPaddress);
                     MyApplication.getInstance().getPrefManager().setPreferrence("VersionOS", myVersion);
                     MyApplication.getInstance().getPrefManager().setPreferrence("Mcode", Mcode);
                     MyApplication.getInstance().getPrefManager().setPreferrence("CashTeamCode", CashTeamCode);

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

                         // MyApplication.getInstance().getPrefManager().setPreferrence("statuslogin", "1");
                         // Intent intent = new Intent(INTRO_SELECT_LOGIN.this, MusicActivity_Credit.class);
                         //startActivity(intent);
                         // finish();
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

                         Log.e("vvvv",PositionCode2);
                         MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode", PositionCode2);






                     }




                 } catch (JSONException e) {

                     e.printStackTrace();

                 }


             }

             MyApplication.getInstance().getPrefManager().setPreferrence("statuslogin", "1");

             update_TOKEN();
             INSENT_LOGIN_LOOKHIN();

             Intent intent = new Intent(INTRO_SELECT_LOGIN.this, MusicActivity_Credit.class);
             startActivity(intent);
             try {
                 pDialog2.cancel();
                 pDialog2.dismiss();
             }
             catch (Exception ex){

             }
             finish();
         }








    }


    String GET_JSON_DATA_HTTP_URL_UPDATE_TOKEN="http://app.thiensurat.co.th/assanee/updatetoken.php";
    public void update_TOKEN() {


        try {
            jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_UPDATE_TOKEN + "?tokenA=" + TOKEN+ "&username=" + EMPID+ "&android_device=" + AndroidDeviceID+ "&android_name=" + URLEncoder.encode(android_name, "UTF-8") + "&android_version=" + URLEncoder.encode(myVersion, "UTF-8"),


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


    String GET_JSON_INSENT_LOGIN_LOOKHIN="https://tssm.thiensurat.co.th/addLogloginApp.php";
    public   void INSENT_LOGIN_LOOKHIN(){

        String EmpID=EMPID;
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
                        Log.e("Response", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        //Log.d("Error.Response", response);
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
    protected void onResume() {
        super.onResume();
        login_r();
    }
}
