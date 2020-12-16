package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.helper.GetCurrentLocation;

public class test_my_location extends AppCompatActivity {

    private TextView latitudeView, longitudeView;
    private Button getLocationBtn;
    GetCurrentLocation currentLoc;
    private String latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_my_location);

        initControls();
        currentLoc = new GetCurrentLocation(this);
    }

    private void initControls() {

        latitudeView = (TextView) findViewById(R.id.lat);
        longitudeView = (TextView) findViewById(R.id.lng);
        getLocationBtn = (Button) findViewById(R.id.getLocation);

        getLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                latitude = currentLoc.latitude;
                longitude = currentLoc.longitude;

                if (TextUtils.isEmpty(latitude) || TextUtils.isEmpty(longitude)) {
                    // latitude = "0.00";
                    // longitude = "0.00";
                }

                latitudeView.setText("Latitude: " + latitude);
                longitudeView.setText("Longitude: " + longitude);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        currentLoc.connectGoogleApi();
    }

    @Override
    protected void onStop() {
        super.onStop();
        currentLoc.disConnectGoogleApi();
    }

}
