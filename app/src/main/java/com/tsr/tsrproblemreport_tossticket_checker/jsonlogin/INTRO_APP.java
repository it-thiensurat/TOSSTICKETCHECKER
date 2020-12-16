package com.tsr.tsrproblemreport_tossticket_checker.jsonlogin;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.github.arturogutierrez.Badges;
import com.github.arturogutierrez.BadgesNotSupportedException;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;
import com.tsr.tsrproblemreport_tossticket_checker.Mechanic_system.MusicActivity_Mechanic;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.MusicActivity_Credit;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.MusicActivity_Progammer;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;
import com.tsr.tsrproblemreport_tossticket_checker.retrofit.api.Service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.tsr.tsrproblemreport_tossticket_checker.API_URL_ALL.BASE_URL;


public class INTRO_APP extends AppCompatActivity {
  public static   String SELECT_PRODUCT_OR_UAT="PRODUCT";// PRODUCT  OR UAT


    String statuslogin="";
    GetData getData;
   // String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/login5_3.php";

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
    String deviceId,regId,tokenA,tokenb,EmployeeName,
            UserName,PositionCode, PositionCode2,PositionName,
            picture,backgound,TeamHeadCode,TeamHeadName,
            TeamName,SupervisorHeadCode,SupervisorHeadName,
            SupervisorName,SubDepartmentHeadCode,SubDepartmentHeadName,
            SubDepartmentName,DepartmentHeadCode,DepartmentHeadName,
            DepartmentName,SubTeamCode,TeamCode,themes_app,themes_color1,
            design_app_on_off_all,SourceSystem,SALECODE,DepartId,Mcode,CashTeamCode,
            count_problemall,count_problemyes,count_problemno,count_problemfollow;
    String themes_color2;

    SweetAlertDialog pDialog2;
    String user="";
    JsonArrayRequest jsonArrayRequest ;
    RequestQueue requestQueue ;
    String myVersion="";
    String version="";
    String android_name="";
    String IPaddress="";
    String AndroidDeviceID="",TOKEN="";


    String newVersion;
    String currentVersion="";

    private int newversion;
    private int currentversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_andriod_device);


        deleteCache(this);


        android_name = Build.MANUFACTURER
                + " " + Build.MODEL + " " + Build.VERSION.RELEASE
                + " " + Build.VERSION_CODES.class.getFields()[android.os.Build.VERSION.SDK_INT].getName();



        MyApplication.getInstance().getPrefManager().setPreferrence("android_name", android_name);




        myVersion = android.os.Build.VERSION.RELEASE; // e.g. myVersion := "1.6"


        MyApplication.getInstance().getPrefManager().setPreferrence("myVersion", myVersion);

        AndroidDeviceID = Settings.Secure.getString(this.getContentResolver(),
                Settings.Secure.ANDROID_ID);


        MyApplication.getInstance().getPrefManager().setPreferrence("AndroidDeviceID", AndroidDeviceID);

        try {
            PackageInfo pInfo = this.getPackageManager().getPackageInfo(getPackageName(), 0);
            version = pInfo.versionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }





    }


    private JSONObject object = null;
    private void login_r() {

        try {


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            Service request = retrofit.create(Service.class);
            Call call = request.getSale(user);
            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, retrofit2.Response response) {

                    Gson gson=new Gson();
                    try {
                        JSONObject jsonObject=new JSONObject(gson.toJson(response.body()));
                        JSON_PARSE_DATA_AFTER_WEBCALL(jsonObject.getJSONArray("data"));
                    } catch (JSONException e) {
                        e.printStackTrace();


                    }


                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    pDialog2.dismiss();

                    try {
                        String CHCEK=t.getLocalizedMessage()+"";

                        //Log.e("CHCEKCHCEK",CHCEK);

                        if(CHCEK.equals("timeout")){
                            new SweetAlertDialog(INTRO_APP.this, SweetAlertDialog.ERROR_TYPE)
                                    .setTitleText("ผิดพลาด")
                                    .setContentText("ไม่สามารถเชื่อมต่อเซิร์ฟเวอร์!")

                                     .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                         @Override
                                         public void onClick(SweetAlertDialog sweetAlertDialog) {

                                             sweetAlertDialog.dismissWithAnimation();

                                             try {
                                                 currentVersion = getApplicationContext().getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
                                                 currentversion = Integer.parseInt(currentVersion.substring(Math.max(currentVersion.length() - 2, 0)));
                                                 Log.e("Current Version","::"+ currentVersion.substring(Math.max(currentVersion.length() - 2, 0)));
                                             } catch (PackageManager.NameNotFoundException e) {
                                                 e.printStackTrace();
                                             }

                                             new FetchAppVersionFromGooglePlayStore().execute();
                                         }
                                     })
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
            new SweetAlertDialog(INTRO_APP.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("ผิดพลาด ไม่สามารถเข้าระบบได้!")
                    .setContentText("กรุณาลองใหม่อีกครั้ง")

                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {

                            sDialog.dismiss();
                            //   edt_pwd.setText("");
                            sDialog.dismissWithAnimation();
                            sDialog.cancel();






                            try {
                                if((user.equals("null"))|user.isEmpty()){
                                    MyApplication.getInstance().getPrefManager().setPreferrence("statuslogin", "0");

                                     Intent intent = new Intent(INTRO_APP.this, LOGIN_MAIN.class);
                                     startActivity(intent);
                                     finish();
                                }
                                else {
                                    login_r();
                                }

                            }
                            catch (Exception ex){
                                MyApplication.getInstance().getPrefManager().setPreferrence("statuslogin", "0");
                            }



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
                      Log.e("JSON length", json.getString(JSON_PositionCode));
                      getData = new GetData();
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

                      EmployeeName = getData.getEmployeeName();
                      PositionCode = getData.getPositionCode();
                      PositionName = getData.getPositionName();
                      picture = getData.getpicture();
                      backgound = getData.getbackgound();

                      TeamHeadCode = getData.getTeamHeadCode();
                      TeamHeadName = getData.getTeamHeadName();
                      TeamName = getData.getTeamName();

                      SupervisorHeadCode = getData.getSupervisorHeadCode();
                      SupervisorHeadName = getData.getSupervisorHeadName();
                      SupervisorName = getData.getSupervisorName();

                      SubDepartmentHeadCode = getData.getSubDepartmentHeadCode();
                      SubDepartmentHeadName = getData.getSubDepartmentHeadName();
                      SubDepartmentName = getData.getSubDepartmentName();

                      DepartmentHeadCode = getData.getDepartmentHeadCode();
                      DepartmentHeadName = getData.getDepartmentHeadName();
                      DepartmentName = getData.getDepartmentName();

                      SubTeamCode = getData.getSubTeamCode();
                      TeamCode = getData.getTeamCode();
                      UserName = getData.getUserName();
                      themes_app = getData.getthemes_app();
                      themes_color1 = getData.getthemes_color1();
                      design_app_on_off_all = getData.getdesign_app_on_off_all();
                      SourceSystem = getData.getSourceSystem();

                      Log.e("PositionCode", PositionCode);

                      SALECODE = getData.getSALECODE();
                      DepartId = getData.getDepartId();
                      Mcode = getData.getMcode();
                      CashTeamCode = getData.getCashTeamCode();
                      if (themes_color1.equals(null)) {
                          themes_color2 = "-1";
                      } else {
                          themes_color2 = getData.getthemes_color1();
                      }

                      Log.e("PositionCode", PositionCode);

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
                      MyApplication.getInstance().getPrefManager().setPreferrence("Mcode", Mcode);
                      MyApplication.getInstance().getPrefManager().setPreferrence("CashTeamCode", CashTeamCode);

                      MyApplication.getInstance().getPrefManager().setPreferrence("debug_run_error_checker1", json.getString("debug_run_error_checker1"));


                      if (array.length() > 1) {
                          MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode", "null");
                          if (array.getJSONObject(i).getString(JSON_PositionCode).equals("Manager")) {
                              MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_M", PositionCode);
                          } else if (array.getJSONObject(i).getString(JSON_PositionCode).equals("LineManager")) {
                              MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_L", PositionCode);
                          } else if (array.getJSONObject(i).getString(JSON_PositionCode).equals("Supervisor")) {
                              MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_S", PositionCode);
                          } else if (array.getJSONObject(i).getString(JSON_PositionCode).equals("SubTeamLeader")) {
                              MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_T", PositionCode);
                          }
                      } else {
                          MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode", PositionCode);
                          MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_M", "null");
                          MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_L", "null");
                          MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_S", "null");
                          MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode_T", "null");
                      }

                      if (SourceSystem.equals("Credit")) {
                          MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode", PositionCode);
                          MyApplication.getInstance().getPrefManager().setPreferrence("statuslogin", "1");

                      } else if (SourceSystem.equals("Sale")) {
                          String PositionCode_M = MyApplication.getInstance().getPrefManager().getPreferrence("PositionCode_M") + "";
                          String PositionCode_L = MyApplication.getInstance().getPrefManager().getPreferrence("PositionCode_L") + "";
                          String PositionCode_S = MyApplication.getInstance().getPrefManager().getPreferrence("PositionCode_S") + "";
                          String PositionCode_T = MyApplication.getInstance().getPrefManager().getPreferrence("PositionCode_T") + "";
                          String PositionCode = MyApplication.getInstance().getPrefManager().getPreferrence("PositionCode") + "";

                          Log.e("PositionCode_ALL", PositionCode_M + "," + PositionCode_L + "," + PositionCode_S + "," + PositionCode_T + "," + PositionCode);
                          if ((PositionCode_M.equals("Manager")) & (PositionCode_L.equals("LineManager")) & (PositionCode_S.equals("Supervisor")) & (PositionCode_T.equals("SubTeamLeader")) & (PositionCode.equals("Sale"))) {
                              PositionCode2 = "Manager";
                          } else if ((PositionCode_M.equals("Manager")) & (PositionCode_L.equals("LineManager")) & (PositionCode_S.equals("Supervisor")) & (PositionCode_T.equals("SubTeamLeader")) & (PositionCode.equals("null"))) {
                              PositionCode2 = "Manager";
                          } else if ((PositionCode_M.equals("Manager")) & (PositionCode_L.equals("LineManager")) & (PositionCode_S.equals("Supervisor")) & (PositionCode_T.equals("null")) & (PositionCode.equals("null"))) {
                              PositionCode2 = "Manager";
                          } else if ((PositionCode_M.equals("Manager")) & (PositionCode_L.equals("LineManager")) & (PositionCode_S.equals("null")) & (PositionCode_T.equals("null")) & (PositionCode.equals("null"))) {
                              PositionCode2 = "Manager";
                          } else if ((PositionCode_M.equals("Manager")) & (PositionCode_L.equals("null")) & (PositionCode_S.equals("null")) & (PositionCode_T.equals("null")) & (PositionCode.equals("null"))) {
                              PositionCode2 = "Manager";
                          } else if ((PositionCode_M.equals("null")) & (PositionCode_L.equals("LineManager")) & (PositionCode_S.equals("Supervisor")) & (PositionCode_T.equals("SubTeamLeader")) & (PositionCode.equals("Sale"))) {
                              PositionCode2 = "LineManager";
                          } else if ((PositionCode_M.equals("null")) & (PositionCode_L.equals("LineManager")) & (PositionCode_S.equals("Supervisor")) & (PositionCode_T.equals("SubTeamLeader")) & (PositionCode.equals("null"))) {
                              PositionCode2 = "LineManager";
                          } else if ((PositionCode_M.equals("null")) & (PositionCode_L.equals("LineManager")) & (PositionCode_S.equals("Supervisor")) & (PositionCode_T.equals("null")) & (PositionCode.equals("null"))) {
                              PositionCode2 = "LineManager";
                          } else if ((PositionCode_M.equals("null")) & (PositionCode_L.equals("LineManager")) & (PositionCode_S.equals("null")) & (PositionCode_T.equals("null")) & (PositionCode.equals("null"))) {
                              PositionCode2 = "LineManager";
                          } else if ((PositionCode_M.equals("null")) & (PositionCode_L.equals("null")) & (PositionCode_S.equals("Supervisor")) & (PositionCode_T.equals("SubTeamLeader")) & (PositionCode.equals("Sale"))) {
                              PositionCode2 = "Supervisor";
                          } else if ((PositionCode_M.equals("null")) & (PositionCode_L.equals("null")) & (PositionCode_S.equals("Supervisor")) & (PositionCode_T.equals("SubTeamLeader")) & (PositionCode.equals("null"))) {
                              PositionCode2 = "Supervisor";
                          } else if ((PositionCode_M.equals("null")) & (PositionCode_L.equals("null")) & (PositionCode_S.equals("Supervisor")) & (PositionCode_T.equals("null")) & (PositionCode.equals("null"))) {
                              PositionCode2 = "Supervisor";
                          } else if ((PositionCode_M.equals("null")) & (PositionCode_L.equals("null")) & (PositionCode_S.equals("null")) & (PositionCode_T.equals("SubTeamLeader")) & (PositionCode.equals("Sale"))) {
                              PositionCode2 = "SubTeamLeader";
                          } else if ((PositionCode_M.equals("null")) & (PositionCode_L.equals("null")) & (PositionCode_S.equals("null")) & (PositionCode_T.equals("SubTeamLeader")) & (PositionCode.equals("null"))) {
                              PositionCode2 = "SubTeamLeader";
                          } else if ((PositionCode_M.equals("null")) & (PositionCode_L.equals("null")) & (PositionCode_S.equals("null")) & (PositionCode_T.equals("null")) & (PositionCode.equals("Manager"))) {
                              PositionCode2 = "Manager";
                          } else if ((PositionCode_M.equals("null")) & (PositionCode_L.equals("null")) & (PositionCode_S.equals("null")) & (PositionCode_T.equals("null")) & (PositionCode.equals("LineManager"))) {
                              PositionCode2 = "LineManager";
                          } else if ((PositionCode_M.equals("null")) & (PositionCode_L.equals("null")) & (PositionCode_S.equals("null")) & (PositionCode_T.equals("null")) & (PositionCode.equals("Supervisor"))) {
                              PositionCode2 = "Supervisor";
                          } else if ((PositionCode_M.equals("null")) & (PositionCode_L.equals("null")) & (PositionCode_S.equals("null")) & (PositionCode_T.equals("null")) & (PositionCode.equals("SubTeamLeader"))) {
                              PositionCode2 = "SubTeamLeader";
                          } else if ((PositionCode_M.equals("null")) & (PositionCode_L.equals("null")) & (PositionCode_S.equals("null")) & (PositionCode_T.equals("null")) & (PositionCode.equals("Sale"))) {
                              PositionCode2 = "Sale";
                          } else {
                              PositionCode2 = "Sale";
                          }

                          Log.e("vvvv", PositionCode2 + "");

                          MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode", PositionCode2);
                      } else if (PositionCode.equals("Sale")) {

                          try {
                              pDialog2.cancel();
                              pDialog2.dismiss();
                              Intent intent = new Intent(INTRO_APP.this, MusicActivity_Credit.class);
                              startActivity(intent);
                          } catch (Exception ex) {

                          }
                          finish();
                      } else if (SourceSystem.equals("null")) {
                          try {
                              pDialog2.cancel();
                              pDialog2.dismiss();
                          } catch (Exception EX) {

                          }
                          new SweetAlertDialog(INTRO_APP.this, SweetAlertDialog.ERROR_TYPE)
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
                  if (PositionCode.equals("Programmer")) {
                      MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode", "Programmer");
                      MyApplication.getInstance().getPrefManager().setPreferrence("statuslogin", "1");
                      try {
                          pDialog2.cancel();
                          pDialog2.dismiss();
                          Intent intent = new Intent(INTRO_APP.this, MusicActivity_Progammer.class);
                          startActivity(intent);
                      } catch (Exception ex) {

                      }
                      finish();
                  } else if (PositionCode.equals("Mechanic")) {
                      // MyApplication.getInstance().getPrefManager().setPreferrence("PositionCode", "Programmer");

                      MyApplication.getInstance().getPrefManager().setPreferrence("statuslogin", "1");
                      try {
                          pDialog2.cancel();
                          pDialog2.dismiss();
                          Intent intent = new Intent(INTRO_APP.this, MusicActivity_Mechanic.class);
                          startActivity(intent);
                      } catch (Exception ex) {

                      }
                      finish();

                  } else {
                      MyApplication.getInstance().getPrefManager().setPreferrence("statuslogin", "1");
                      try {
                          pDialog2.cancel();
                          pDialog2.dismiss();
                          Intent intent = new Intent(INTRO_APP.this, MusicActivity_Credit.class);
                          startActivity(intent);
                      } catch (Exception ex) {

                      }
                      finish();
                  }
              } catch (Exception E) {
                  MyApplication.getInstance().getPrefManager().setPreferrence("statuslogin", "1");
                  try {
                      pDialog2.cancel();
                      pDialog2.dismiss();
                      Intent intent = new Intent(INTRO_APP.this, MusicActivity_Credit.class);
                      startActivity(intent);
                  } catch (Exception ex) {

                  }
                  finish();

              }


          }



    }



    String GET_JSON_DATA_HTTP_URL_UPDATE_TOKEN="http://app.thiensurat.co.th/assanee/updatetoken.php";
    public void update_TOKEN() {

        // Log.e("url_update",GET_JSON_DATA_HTTP_URL_UPDATE_TOKEN + "?tokenA=" + TOKEN+ "&username=" + user+ "&android_device=" + AndroidDeviceID+ "&android_name=" + android_name+ "&android_version=" + myVersion);

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











    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();







        SweetAlertDialog sweetAlertDialog = null;

        if(checkConnection() == true){

            try {
                sweetAlertDialog.dismissWithAnimation();
                sweetAlertDialog.dismiss();

            }
            catch (Exception ex){

            }

            try {


                currentVersion = getApplicationContext().getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
                currentversion = Integer.parseInt(currentVersion.substring(Math.max(currentVersion.length() - 2, 0)));
                Log.e("Current Version","::"+ currentVersion.substring(Math.max(currentVersion.length() - 2, 0)));
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }

            new FetchAppVersionFromGooglePlayStore().execute();
        }
        else {
             sweetAlertDialog = new SweetAlertDialog(INTRO_APP.this, SweetAlertDialog.WARNING_TYPE);
            sweetAlertDialog.setTitleText("กรุณาตรวจสอบเครือข่าย!");


            sweetAlertDialog.setConfirmText("OK!");
            sweetAlertDialog.setCancelable(false);
            sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sDialog) {

                    Intent intent=new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                    startActivity(intent);

                }
            });

            sweetAlertDialog.show();

        }






    }


    class FetchAppVersionFromGooglePlayStore extends AsyncTask<String, Void, String> {

        protected String doInBackground(String... urls) {
            String version = "";
            try {
                //return //https://play.google.com/store/apps/details?id=th.co.thiensurat
                Document document = Jsoup.connect("https://play.google.com/store/apps/details?id=com.tsr.tsrproblemreport_tossticket_checker&hl=en")
                        .timeout(10000)
                        .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                        .referrer("http://www.google.com")
                        .get();
                if (document != null) {
                    Elements element = document.getElementsContainingOwnText("Current Version");
                    for (Element ele : element) {
                        if (ele.siblingElements() != null) {
                            Elements sibElemets = ele.siblingElements();
                            for (Element sibElemet : sibElemets) {
                                version = sibElemet.text();
                            }
                        }
                    }
                }

            } catch (Exception e) {
                return "";
            }
            return version;
        }

        protected void onPostExecute(String string) {
            newVersion = string;

            try {
                newversion = Integer.parseInt(newVersion.substring(Math.max(newVersion.length() - 2, 0)));

            }
            catch (Exception ex){

            }
            Log.e("new Version", newVersion.substring(Math.max(newVersion.length() - 2, 0)));
//			Toast.makeText(SplashActivity.this, "new Version: " + newVersion, Toast.LENGTH_LONG).show();
            if (newVersion != null && !newVersion.isEmpty()) {
                if (newversion > currentversion) {



                    Log.e("5555", "5555");




                    SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(INTRO_APP.this, SweetAlertDialog.WARNING_TYPE);
                    sweetAlertDialog.setTitleText("มีการอัพเดทใหม่!");

                    sweetAlertDialog.setCancelText("ไม่! ออก");
                    sweetAlertDialog.setConfirmText("OK! อัพเดท");
                    sweetAlertDialog.setCancelable(false);
                    sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {




                            try {
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
                            } catch (android.content.ActivityNotFoundException anfe) {
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
                            }

                        }
                    });
                    sweetAlertDialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            Log.e("dialog", "ปิด dialog");
                            sweetAlertDialog.dismissWithAnimation();
                            finish();
                        }
                    });
                    sweetAlertDialog.show();






                } else {








                    final Handler handler = new Handler();
                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }

                            handler.post(new Runnable() {

                                @Override
                                public void run() {
                                    // TODO Auto-generated method stub




                                    try {
                                        statuslogin = MyApplication.getInstance().getPrefManager().getPreferrence("statuslogin");
                                        if (statuslogin.equals("1")) {
                                            user=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

                                            try {
                                                TOKEN= FirebaseInstanceId.getInstance().getToken();
                                            }
                                            catch (Exception ex){

                                            }



                                            try {
                                                Badges.setBadge(INTRO_APP.this, 5);
                                            } catch (BadgesNotSupportedException badgesNotSupportedException) {
                                                //      Log.d(TAG, badgesNotSupportedException.getMessage());
                                            }



                                            pDialog2 = new SweetAlertDialog(INTRO_APP.this, SweetAlertDialog.PROGRESS_TYPE);
                                            pDialog2.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                                            pDialog2.setTitleText("Loading");
                                            pDialog2.setCancelable(true);
                                            pDialog2.show();






                                            update_TOKEN();
                                            login_r();



                                            try {
                                                Intent i = getApplicationContext().getPackageManager().getLaunchIntentForPackage("com.gps_tracking");
                                                if (i != null) {
//                                                    MyApplication.getInstance().getPrefManager().setPreferrence("gis", "1");
                                                    Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("gis://empid/" + MyApplication.getInstance().getPrefManager().getPreferrence("EMPID") + "/TICKET"));
                                                    startActivity(in);
                                                }
                                            }
                                            catch (Exception ex){

                                            }



                                        }

                                        else {

                                            Log.e("8888", "8888");

                                            Intent intent = new Intent(INTRO_APP.this, LOGIN_MAIN.class);
                                            startActivity(intent);
                                            finish();




                                        }
                                    }
                                    catch (Exception e){

                                        Log.e("9999", "9999");

                                        Intent intent = new Intent(INTRO_APP.this, LOGIN_MAIN.class);
                                        startActivity(intent);
                                        finish();


                                    }






                                }
                            });

                        }
                    }).start();















                }

            }
        }
    }

    protected boolean checkConnection(){
        boolean re=false;
        try{
            ConnectivityManager conMan = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

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







    public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) { e.printStackTrace();}
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if(dir!= null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }






}
