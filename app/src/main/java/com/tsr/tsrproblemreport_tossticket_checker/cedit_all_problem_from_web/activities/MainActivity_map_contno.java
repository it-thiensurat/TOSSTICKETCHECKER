package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_map;

import java.util.ArrayList;
import java.util.List;


public class MainActivity_map_contno extends AppCompatActivity implements OnMapReadyCallback {
    List<GetData_cedit> GetDataAdapter1=new ArrayList<>();
    GetData_cedit_map getData_cedit_map;
    GetData_cedit getData_cedit;
    SupportMapFragment mapFragment;
    Marker melbourne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_contno);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        getData_cedit_map=getIntent().getParcelableExtra("latlong");
        GetDataAdapter1=getData_cedit_map.getGetDataAdapter1();
        Log.e("sssd",GetDataAdapter1.size()+"");

        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapFragment.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap googleMap) {

                        /*
                        googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

                        googleMap.addMarker(new MarkerOptions()
                                .position(new LatLng(37.4233438, -122.0728817))
                                .title("LinkedIn")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));


                        googleMap.addMarker(new MarkerOptions()
                                .position(new LatLng(37.4629101,-122.2449094))
                                .title("Facebook")
                                .snippet("Facebook HQ: Menlo Park"));


                        melbourne =   googleMap.addMarker(new MarkerOptions()
                                .position(new LatLng(37.3092293, -122.1136845))
                                .title("Apple"));
                        melbourne.showInfoWindow();


                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.4233438, -122.0728817), 10));
                   */
                        Double LA=0.0,LO=0.0;
                        int i;
                        for(i=0;i<GetDataAdapter1.size();i++){
                            GetData_cedit item = GetDataAdapter1.get(i);
                            //   getData_cedit = GetDataAdapter1.get(i);
                            String LA_A = item.getLatitude()+"";
                            String LO_O = item.getLongitude()+"";
                            //Log.e("coutno", item.getCONTNO());
                            //  String LA_A = MyApplication.getInstance().getPrefManager().getPreferrence("la"+String.valueOf(i))+"";
                            // String LO_O = MyApplication.getInstance().getPrefManager().getPreferrence("lo"+String.valueOf(i))+"";

//


                            if(LA_A.equals("null")){
                                // Log.e("null",LA_A+","+LO_O);
                            }
                            else {

                                LA= Double.valueOf(LA_A);
                                LO= Double.valueOf(LO_O);
                                Log.e("masa",LA_A+","+LO_O);
                                melbourne=  googleMap.addMarker(new MarkerOptions()
                                        .position(new LatLng(LA, LO))
                                        .title("เลบขที่สัญญา A123456")
                                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_pin_atm)));
                                melbourne.showInfoWindow();
                            }

                        }


                        melbourne= googleMap.addMarker(new MarkerOptions()
                                .position(new LatLng(13.9012801, 100.5039834))
                                .title("พนักงานตรวจสอบ")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_custom_search)));
                        // .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                        melbourne.showInfoWindow();



                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(13.9012801, 100.5039834), 12));




                    }
                });
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {



        Double LA=0.0,LO=0.0;
        int i;
        for(i=0;i<GetDataAdapter1.size();i++){
        GetData_cedit item = GetDataAdapter1.get(i);
         //   getData_cedit = GetDataAdapter1.get(i);
            String LA_A = item.getLatitude()+"";
            String LO_O = item.getLongitude()+"";
            String CONTNO = item.getCONTNO()+"";
            String ADRR = item.getAddressDetail()+"";
            //Log.e("coutno", item.getCONTNO());
          //  String LA_A = MyApplication.getInstance().getPrefManager().getPreferrence("la"+String.valueOf(i))+"";
           // String LO_O = MyApplication.getInstance().getPrefManager().getPreferrence("lo"+String.valueOf(i))+"";

//


            if(LA_A.equals("null")){
               // Log.e("null",LA_A+","+LO_O);
            }
            else {

                LA= Double.valueOf(LA_A);
                LO= Double.valueOf(LO_O);
                Log.e("masa",LA_A+","+LO_O);
                melbourne=  googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(LA, LO))
                        .title("เลขที่สัญญา : "+CONTNO)
                        .snippet("ที่อยู่ : "+ADRR)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_pin_atm)));
                melbourne.showInfoWindow();
            }

        }


        melbourne= googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(13.9012801, 100.5039834))
                .title("พนักงานตรวจสอบ")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_custom_search)));
               // .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        melbourne.showInfoWindow();



        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(13.9012801, 100.5039834), 12));

    }
}
