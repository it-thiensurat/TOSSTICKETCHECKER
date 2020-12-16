package com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.pen_sing;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.tsr.tsrproblemreport_tossticket_checker.R;

public class ViewSignatureActivity extends AppCompatActivity {

    private ImageView imgvwSignature;
    private  String signaturePath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_signature);

        imgvwSignature = (ImageView) findViewById(R.id.imgvwSignature);
        Bundle extras = getIntent().getExtras();

        if(extras!=null)
        {
            signaturePath = extras.getString("SignaturePath");
            if(signaturePath!=null)
                imgvwSignature.setImageURI(Uri.parse("file://"+signaturePath));
        }
    }
}
