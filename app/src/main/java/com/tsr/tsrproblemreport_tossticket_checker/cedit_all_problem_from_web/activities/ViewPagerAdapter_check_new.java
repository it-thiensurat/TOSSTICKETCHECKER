package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit;

import java.util.List;

import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.ViewPagerAdapter.image4;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.ViewPagerAdapter.image5;
import static com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.ViewPagerAdapter.image6;

/**
 * Created by Sanket on 27-Feb-17.
 */

public class ViewPagerAdapter_check_new extends PagerAdapter {

    public static Context context;
    private LayoutInflater layoutInflater;
    JsonArrayRequest jsonArrayRequest;
    Detali_data_cedit detali_data_cedit;
    RequestQueue requestQueue;

    GetData_cedit getData_cedit;


    List<GetData_cedit> GetDataAdapter1;
    ImageView imageView;
    int position2;
    private Integer [] images = {R.drawable.slide1,R.drawable.slide2, R.drawable.slide3};
    String Conno;
    public static int check_image_device=0;
    public static int check_image_device2=0;
    public static int check_image_device3=0;
    public static int check_image_device4=0;

    public static  int i=0;
    public static  int j=0;
    public static  int k=0;

    public ViewPagerAdapter_check_new(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout, null);
        imageView = (ImageView) view.findViewById(R.id.imageView);


        Conno=   detali_data_cedit.conno;

        //JSON_DATA_WEB_CALL();


        if(position == 0){
            try {
                Glide.with(context).load("http://app.thiensurat.co.th/assanee/upload_image_check_customer/"+image6)



                        .crossFade()
                        .thumbnail(0.5f)
                        // .bitmapTransform(new CircleTransform(context))
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(context.getResources().getDrawable(R.drawable.no_image_map))
                        .into(imageView);
            }
            catch (Exception e) {

            }
        } else if(position == 2){
            try {
                Glide.with(context).load("http://app.thiensurat.co.th/assanee/upload_image_check_customer/"+image5)



                        .crossFade()
                        .thumbnail(0.5f)
                        // .bitmapTransform(new CircleTransform(context))
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(context.getResources().getDrawable(R.drawable.no_image_idcard))
                        .into(imageView);
            }
            catch (Exception e) {

            }
        }

        else {
            // getBitmapFromURL("http://bof.thiensurat.co.th/mca/images/contractImage/4A67748AAB704BFDAE4268FE8AE501DD.jpg");
            try {
                Glide.with(context).load("http://app.thiensurat.co.th/assanee/upload_image_check_customer/"+image4)



                        .crossFade()
                        .thumbnail(0.5f)
                        // .bitmapTransform(new CircleTransform(context))
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(context.getResources().getDrawable(R.drawable.no_image_product))
                        .into(imageView);
            }
            catch (Exception e) {

            }
        }






        //position2=position;
        Log.e("fds", String.valueOf(position));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position == 0){




                    final Dialog dialog = new Dialog(ViewPagerAdapter.context);
                    dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.custom_dialog_image_cedit);
                    dialog.setCancelable(true);
                    final ImageView image_map=(ImageView)dialog.findViewById(R.id.image_map);
                    final ImageView rotage2=(ImageView)dialog.findViewById(R.id.rotage2);


                    //  image_map.setImageURI(Uri.fromFile(imageFile));
                    // image_map.setImageBitmap(bitmap);


                    try {
                        Glide.with(context).load("http://app.thiensurat.co.th/assanee/upload_image_check_customer/"+image6)



                                .crossFade()
                                .thumbnail(0.5f)
                                // .bitmapTransform(new CircleTransform(context))
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .placeholder(context.getResources().getDrawable(R.drawable.no_image_map))
                                .into(image_map);
                    }
                    catch (Exception e) {

                    }



                    rotage2.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            i=i+90;
                            image_map.setRotation((float) i);

                        }
                    });
                    dialog.show();






                } else if(position == 2){


                    final Dialog dialog = new Dialog(ViewPagerAdapter.context);
                    dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.custom_dialog_image_cedit);
                    dialog.setCancelable(true);
                    final ImageView image_map=(ImageView)dialog.findViewById(R.id.image_map);
                    final ImageView rotage2=(ImageView)dialog.findViewById(R.id.rotage2);
                    try {
                        Glide.with(context).load("http://app.thiensurat.co.th/assanee/upload_image_check_customer/"+image5)



                                .crossFade()
                                .thumbnail(0.5f)
                                // .bitmapTransform(new CircleTransform(context))
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .placeholder(context.getResources().getDrawable(R.drawable.no_image_idcard))
                                .into(image_map);
                    }
                    catch (Exception e) {

                    }

                    rotage2.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            j=j+90;
                            image_map.setRotation((float) j);

                        }
                    });
                    dialog.show();

                }
                else {


                    final Dialog dialog = new Dialog(ViewPagerAdapter.context);
                    dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.custom_dialog_image_cedit);
                    dialog.setCancelable(true);
                    final ImageView image_map=(ImageView)dialog.findViewById(R.id.image_map);
                    final ImageView rotage2=(ImageView)dialog.findViewById(R.id.rotage2);
                    try {
                        Glide.with(context).load("http://app.thiensurat.co.th/assanee/upload_image_check_customer/"+image4)



                                .crossFade()
                                .thumbnail(0.5f)
                                // .bitmapTransform(new CircleTransform(context))
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .placeholder(context.getResources().getDrawable(R.drawable.no_image_product))
                                .into(image_map);
                    }
                    catch (Exception e) {

                    }

                    rotage2.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            k=k+90;
                            image_map.setRotation((float) k);

                        }
                    });
                    dialog.show();

                }

            }
        });

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }






    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}
