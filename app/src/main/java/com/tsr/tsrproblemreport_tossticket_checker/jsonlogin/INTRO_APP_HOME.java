package com.tsr.tsrproblemreport_tossticket_checker.jsonlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.MusicActivity_Checker;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.MusicActivity_Credit;


public class INTRO_APP_HOME extends AppCompatActivity {

    String statuslogin="";
    CardView ckeck,report,setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_intro);
        ckeck=(CardView) findViewById(R.id.ckeck);
        report=(CardView) findViewById(R.id.report);
        setting=(CardView) findViewById(R.id.setting);

        ckeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(INTRO_APP_HOME.this, MusicActivity_Checker.class));

            }
        });

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(INTRO_APP_HOME.this, MusicActivity_Credit.class));
                 finish();
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
     /*   try {
            statuslogin = MyApplication.getInstance().getPrefManager().getPreferrence("statuslogin");
            if (statuslogin.equals("1")) {

                Intent intent = new Intent(INTRO_APP_HOME.this, MusicActivity_Credit.class);
                startActivity(intent);
                finish();
            }

            else {
                Intent intent = new Intent(INTRO_APP_HOME.this, INTRO_SELECT_LOGIN.class);
                startActivity(intent);
               finish();




            }
        }
        catch (Exception e){
            Intent intent = new Intent(INTRO_APP_HOME.this, INTRO_SELECT_LOGIN.class);
            startActivity(intent);
            finish();


        }*/


    }
}
