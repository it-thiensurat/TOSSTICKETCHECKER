package com.tsr.tsrproblemreport_tossticket_checker.sale_all_problem_from_cedit.line.map;

import android.Manifest;
import android.app.Dialog;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.Utils;


import org.json.JSONArray;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private GoogleMap mMap;
    private GoogleApiClient googleApiClient;
    SupportMapFragment mapFragment;
    private LocationRequest locationRequest;
    private Location currentLocation;
    private double longitude;
    private double latitude;

    String filePath = null;
    Bitmap bmplogo=null;
    Bitmap bitmap;
    Timer myTimer;
    String logo="",logo2="";
    public static String logo_url="";
    JsonArrayRequest jsonArrayRequest;

    RequestQueue requestQueue;
    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/insert_check_customer_location.php";
    String GET_JSON_DATA_HTTP_URL2 = "http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/insert_check_customer_location_image_by_peebang.php";
    String GET_JSON_DATA_HTTP_URL3 = "http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/insert_check_customer_history.php";
    String GET_JSON_DATA_HTTP_URL_DELETE_LOCATION="http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/delete_image_location_from_sever.php";
    private String conno_qr,refno;
    String Latitude,Longitude,RefNo,ImageTypeCode,pathurl,CreateBy;
    Double DIS,lat1,lon1,lat2,lon2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
         mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


if(checkGPSEnable()){
    buildGoogleApiClient();
    googleApiClient.connect();
}
else {
    displayLocationSettingsRequest();
}
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapFragment.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap googleMap) {
                        mMap=googleMap;


                        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

                       /// mMap.addMarker(new MarkerOptions()
                         //       .position(new LatLng(latitude, longitude))
                         //       .title("พนักงานตรวจสอบ")
                          //      .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

                       // mMap.addMarker(new MarkerOptions()
                         //       .position(new LatLng(latitude,longitude))
                          //      .title("ลูกค้า")
                             //   .snippet("assanee weanlor"));

                        //   googleMap.addMarker(new MarkerOptions()
                        //    .position(new LatLng(37.3092293, -122.1136845))
                        //   .title("Apple"));

                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 15));
                    }
                });
            }
        });



        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                captureScreen();


            }
        });




    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
/*
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        */

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(latitude, longitude))
                .title("พนักงานตรวจสอบ")
                //.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                // .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.fromResource(R.drawable.icon_pin_atm))));
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_pin_atm)));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 15));
    }



    private boolean checkGPSEnable() {
        LocationManager lm = (LocationManager)getSystemService(LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;
        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch(Exception ex) {}

        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch(Exception ex) {}

        if(!gps_enabled && !network_enabled) {
            return false;
        } else {
            return true;
        }
    }




    private void displayLocationSettingsRequest() {

        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        locationRequest.setInterval(1000);
        locationRequest.setFastestInterval(1000);

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(locationRequest);
        builder.setAlwaysShow(true);

       PendingResult<LocationSettingsResult> result = LocationServices.SettingsApi.checkLocationSettings(googleApiClient, builder.build());
        result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
            @Override
            public void onResult(LocationSettingsResult result) {
                final Status status = result.getStatus();
                switch (status.getStatusCode()) {
                    case LocationSettingsStatusCodes.SUCCESS:

                       // updateGPSStatus("GPS is Enabled in your device");
                        //getCurrentLocation();
                        break;
                    case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                        try {
                            status.startResolutionForResult(MapsActivity.this, 1234);
                        } catch (IntentSender.SendIntentException e) {

                        }
                        break;
                    case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                        break;
                }
            }
        });
    }


    protected synchronized void buildGoogleApiClient() {
        googleApiClient = new GoogleApiClient.Builder(MapsActivity.this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        locationRequest = new LocationRequest();
        locationRequest.setInterval(3000);
        locationRequest.setFastestInterval(3000);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        currentLocation = location;
        if (mMap != null)
            mMap.clear();
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        if (googleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, this);
        }

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(latitude, longitude))
                //.position(new LatLng(13.9869737625122, 100.510757446289))
                .title("พนักงานตรวจสอบ")
                //.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                // .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.fromResource(R.drawable.icon_pin_atm))));
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_pin_atm)));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 15));
       // mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(13.9869737625122, 100.510757446289), 15));




        /*
        myTimer = new Timer();

        myTimer.schedule(new TimerTask() {
            public void run() {
                //captureScreen();
            }
        }, 0, 15000);
        */

    }










    public void captureScreen() {
        GoogleMap.SnapshotReadyCallback callback = new GoogleMap.SnapshotReadyCallback() {
            String pictureUri;
            @Override
            public void onSnapshotReady(Bitmap snapshot) {
                bitmap= snapshot;


                final Dialog dialog = new Dialog(MapsActivity.this);
                dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.custom_dialog_capsceen);
                dialog.setCancelable(true);
                final ImageView image_map=(ImageView)dialog.findViewById(R.id.image_map);
                final Button cancal=(Button)dialog.findViewById(R.id.cancal);
                final Button save=(Button)dialog.findViewById(R.id.save);

                //  image_map.setImageURI(Uri.fromFile(imageFile));
                image_map.setImageBitmap(bitmap);

                cancal.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });

                save.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {


                        creatJPG(bitmap);




                        dialog.cancel();
                    }
                });

                dialog.show();



               // myTimer.cancel();
                //
                //getPresenter().saveImageUrl(MapCheckinActivity.this, jobItem.getOrderid(), Constance.IMAGE_TYPE_CHECKIN, pictureUri.getPath().toString());
            }
        };
        mMap.snapshot(callback);
    }








    private void creatJPG(Bitmap bitmap ) {
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
        String imageName = df.format(now);
        Bitmap cc=bitmap;
        try {
            String imagePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();

            File imageFile = new File(imagePath + "/" + imageName + ".jpg");
            FileOutputStream outputStream = new FileOutputStream(imageFile);
            int quality = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
            outputStream.flush();
            outputStream.close();

            String uu = Uri.fromFile(imageFile).toString();
            String rr =Uri.fromFile(imageFile).toString();

            if (uu != null) {
                filePath = uu;
            } else if (rr != null) {
                filePath = rr;
            } else {

                Toast.makeText(getApplicationContext(), "Unknown path",
                        Toast.LENGTH_LONG).show();
                Log.e("Bitmap", "Unknown path");
            }


            System.out.println("filePath="+filePath);
            bmplogo= Utils.decodeFile_location(new File(filePath),240);




            if(filePath!=null)logo=filePath;
            Thread b=new Thread(myThread3);
            b.start();




            new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("OK!")
                    .setContentText("ตรวจสอบเส็จสิ้น")


                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.cancel();
                            finish();
                        }
                    })
                    .show();




        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    String txt;
    private Runnable myThread3 = new Runnable(){
        public void run() {
            try{
                if(filePath!=null)
                {

                    byte[] bfile=Utils.BitmapToByteArray(bitmap);

                    logo=Utils.getFileDate_location();
                    logo_url=logo;
                  //  MyApplication.getInstance().getPrefManager().setPreferrence("logo_url", logo);
                    Log.e("logoSS",logo_url);
                    Utils.doFileUpload_image_device(bfile, logo);

                    DELETE_IMAGE_LOCATION();
                    INSENT_DATA_CHECK_LOCATION();
                    INSENT_DATA_CHECK_LOCATION_PEEBANG();
                    INSENT_history_location();

                }

            }
            catch(Exception e)
            {
                e.printStackTrace();

            }
            myHandle.sendMessage(myHandle.obtainMessage());
        }
    };
    Handler myHandle = new Handler(){
        @Override
        public void handleMessage(android.os.Message msg) {
//            pdialog.dismiss();
//            Utils.showDialog(GAGA.this, txt);
        }
    };



    private  void DELETE_IMAGE_LOCATION(){


        RefNo = MyApplication.getInstance().getPrefManager().getPreferrence("RefNo_all");
        ImageTypeCode="MAP";

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL_DELETE_LOCATION+"?refno="+RefNo+"&ImageTypeCode="+ImageTypeCode,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //getDistanceInfo("13.9012707,100.4514525","13.988191,100.6137946");
                        //distance(13.9012707,100.4514525,13.9012707,100.4514525);
                        Log.e("1111","11111");
                        //  JSON_PARSE_DATA_AFTER_WEBCALL(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("2222",error.toString());
                        //ShowSQLiteDBdata();
                    }
                });

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

    }


    private  void INSENT_DATA_CHECK_LOCATION(){


        Latitude = MyApplication.getInstance().getPrefManager().getPreferrence("Latitude");
        Longitude = MyApplication.getInstance().getPrefManager().getPreferrence("Longitude");




         lat2= Double.valueOf(Latitude);
        lon2= Double.valueOf(Longitude);
        haversine(13.9869737625122,100.510757446289,lat2,lon2);
Log.e("DIS", String.valueOf(lat2+lon2));
String DISA= String.valueOf(DIS);

        String salecode = MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");
        conno_qr = MyApplication.getInstance().getPrefManager().getPreferrence("conno_qr");
        refno= MyApplication.getInstance().getPrefManager().getPreferrence("refno");
        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL+"?salecode="+salecode+"&conno="+conno_qr+"&status_location="+"1"+"&distance="+DISA,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //getDistanceInfo("13.9012707,100.4514525","13.988191,100.6137946");
                        //distance(13.9012707,100.4514525,13.9012707,100.4514525);
                        Log.e("1111","11111");
                        //  JSON_PARSE_DATA_AFTER_WEBCALL(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("2222",error.toString());
                        //ShowSQLiteDBdata();
                    }
                });

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

    }


    private  void INSENT_DATA_CHECK_LOCATION_PEEBANG(){


        RefNo = MyApplication.getInstance().getPrefManager().getPreferrence("RefNo_all");
        ImageTypeCode="MAP";
        //logo2=Utils.getFileDate_location();
       // pathurl=logo2;
        CreateBy= MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");




        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL2+"?refno="+RefNo+"&ImageTypeCode="+ImageTypeCode+"&pathurl="+logo_url+"&CreateBy="+CreateBy,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //getDistanceInfo("13.9012707,100.4514525","13.988191,100.6137946");
                        //distance(13.9012707,100.4514525,13.9012707,100.4514525);
                        Log.e("1111","11111");
                        //  JSON_PARSE_DATA_AFTER_WEBCALL(response);


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("2222",error.toString());
                        //ShowSQLiteDBdata();
                    }
                });

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

    }





    private  void INSENT_history_location(){

        String salecode = MyApplication.getInstance().getPrefManager().getPreferrence("SALECODE");

        RefNo = MyApplication.getInstance().getPrefManager().getPreferrence("RefNo_all");
      String  conno = MyApplication.getInstance().getPrefManager().getPreferrence("conno_qr");
        CreateBy= MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
       //logo_url= MyApplication.getInstance().getPrefManager().getPreferrence("logo_url");

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL3+"?empid="+CreateBy+"&salecode="+salecode+"&refno="+RefNo+"&conno="+conno+"&titleTypeCode="+"MAP"+"&server="+"assanee_mobile"+"&partimage="+logo_url+"&status_confirm_image_old="+"null"+"&status_confirm="+"1",


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //getDistanceInfo("13.9012707,100.4514525","13.988191,100.6137946");
                        //distance(13.9012707,100.4514525,13.9012707,100.4514525);
                        Log.e("1111","11111");
                        //  JSON_PARSE_DATA_AFTER_WEBCALL(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("2222",error.toString());
                        //ShowSQLiteDBdata();
                    }
                });

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);

    }

    public void haversine(double lat1, double lon1, double lat2, double lon2) {
        double Rad = 6372.8; //Earth's Radius In kilometers
        // TODO Auto-generated method stub
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        DIS = Rad * c;

    }



}
