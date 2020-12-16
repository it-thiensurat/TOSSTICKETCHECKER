package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tsr.tsrproblemreport_tossticket_checker.R;

/**
 * Created by user on 25/1/2561.
 */

public class Show_image_history extends AppCompatActivity{
    String partimage="";
    ImageView image;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.show_image_history_check_customer);
        image=(ImageView)findViewById(R.id.image);

        Bundle data=getIntent().getExtras();
        if(data!=null)
        {
            partimage=data.getString("partimage");


            Log.e("partimage",partimage);



            try {
                Glide.with(this).load("http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/upload_image_check_customer/"+partimage)



                        .crossFade()
                        .thumbnail(0.5f)
                       // .bitmapTransform(new CircleTransform(this))
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(this.getResources().getDrawable(R.drawable.dasaa))
                        .into(image);
            }
            catch (Exception e) {

            }





        }



    }
}
