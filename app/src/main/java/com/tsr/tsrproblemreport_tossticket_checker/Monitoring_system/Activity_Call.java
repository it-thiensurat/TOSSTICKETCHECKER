package com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tsr.tsrproblemreport_tossticket_checker.R;


public class Activity_Call extends AppCompatActivity {

    private final int CALL_REQUEST = 100;

    EditText mobileNoEt;
    Button callBt;
    String number="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initializeViews();
        Bundle data=getIntent().getExtras();
        if(data!=null) {

            number = data.getString("number");

            mobileNoEt.setText(number);
        }

    }

    /**
     * This method is responsible to initialization of view
     * */
    private void initializeViews() {

        try
        {
            mobileNoEt = (EditText) findViewById(R.id.activityMain_mobileNoEt);
            callBt = (Button) findViewById(R.id.activityMain_callBt);

            callBt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (validationCheck())
                        callPhoneNumber();
                }
            });
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * This method is responsible validate phone no.
     * */
    private boolean validationCheck()
    {
        try
        {
            String phoneNo = mobileNoEt.getText().toString().trim();
            if (phoneNo.equalsIgnoreCase(""))
            {
                mobileNoEt.setError(getResources().getString(R.string.phone_empty_message));
                mobileNoEt.requestFocus();
                return false;
            }
            if (phoneNo.length() < 6 || phoneNo.length() > 13)
            {
                mobileNoEt.setError(getResources().getString(R.string.invalid_no_message));
                mobileNoEt.requestFocus();
                return false;
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return true;
    }

    /**
     * This method is responsible make a call and also
     * checking run time permissions for CALL_PHONE
     * */
    public void callPhoneNumber()
    {
        try
        {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling

                    ActivityCompat.requestPermissions(Activity_Call.this, new String[]{Manifest.permission.CALL_PHONE}, CALL_REQUEST);

                    return;
                }
            }

            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + mobileNoEt.getText().toString().trim()));
            startActivity(callIntent);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults)
    {
        if(requestCode == CALL_REQUEST)
        {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                callPhoneNumber();
            }
            else
            {
                Toast.makeText(Activity_Call.this, getResources().getString(R.string.call_permission_denied_message), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            // finish the activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
