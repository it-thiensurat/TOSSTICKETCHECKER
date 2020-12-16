package com.tsr.tsrproblemreport_tossticket_checker;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
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
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class INSERT_GPS_GIS implements LocationListener {


    JsonArrayRequest jsonArrayRequest;
    JsonObjectRequest jsonObjectRequest;
    RequestQueue requestQueue;
    Context context;
    public static String la="",lo="";
    public INSERT_GPS_GIS(Context context) {
        this.context = context;

    }




    LocationManager locationManager;
    String mprovider;


    public void gg(){
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();

        mprovider = locationManager.getBestProvider(criteria, false);

        if (mprovider != null && !mprovider.equals("")) {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            Location location = locationManager.getLastKnownLocation(mprovider);
            locationManager.requestLocationUpdates(mprovider, 15000, 1, this);

            if (location != null){
                onLocationChanged(location);
            }
            else{

            }
             //   Toast.makeText(getBaseContext(), "No Location Provider Found Check Your Code", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onLocationChanged(Location location) {
        //TextView longitude = (TextView) findViewById(R.id.textView);
        // TextView latitude = (TextView) findViewById(R.id.textView1);

        // longitude.setText("Current Longitude:" + location.getLongitude());
        //latitude.setText("Current Latitude:" + location.getLatitude());
        lo= String.valueOf(location.getLongitude());
        la= String.valueOf(location.getLatitude());
        sendPost(location.getLatitude(),location.getLongitude());

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    public void sendPost(double la,double lo) {

        double latitude1=la;
        double longitude1=lo;
        String deviceId=MyApplication.getInstance().getPrefManager().getPreferrence("AndroidDeviceID");
        String empId=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");
        String source="TICKET";
        String speed="0";

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://toss.thiensurat.co.th/ServicesPHP/Production/GIS/TrackingLocation");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                    conn.setRequestProperty("Accept","application/json");
                    conn.setDoOutput(true);
                    conn.setDoInput(true);

                    JSONArray jsonArray = new JSONArray();
                    JSONObject jsonParam = new JSONObject();
                    jsonParam.put("latitude", latitude1);
                    jsonParam.put("longitude", longitude1);
                    jsonParam.put("deviceId", deviceId);
                    jsonParam.put("empId", empId);
                    jsonParam.put("source", source);
                    jsonParam.put("speed", speed);


                    jsonArray.put(jsonParam);
                    Log.e("JSON", String.valueOf(jsonArray));
                    DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                    //os.writeBytes(URLEncoder.encode(jsonParam.toString(), "UTF-8"));
                    os.writeBytes(String.valueOf(jsonArray));

                    os.flush();
                    os.close();

                    Log.e("STATUS", String.valueOf(conn.getResponseCode()));
                    //   Log.i("MSG" , conn.getResponseMessage());

                    conn.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }


}
