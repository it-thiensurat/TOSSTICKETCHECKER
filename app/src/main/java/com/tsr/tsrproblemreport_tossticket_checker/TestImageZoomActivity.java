package com.tsr.tsrproblemreport_tossticket_checker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler;
import com.bumptech.glide.Glide;

public class TestImageZoomActivity extends AppCompatActivity {
    ImageView imageView2;
    int Y=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_image_zoom);
         imageView2 = (ImageView)findViewById(R.id.imageView);
        //imageView.setImage(ImageSource.bitmap(bitmap));


        Glide.with(this)
                .load("http://app.thiensurat.co.th/assanee/upload/iconprofile/picture1.png")
                .into(imageView2);

        imageView2.setOnTouchListener(new ImageMatrixTouchHandler(this));
    }
}
