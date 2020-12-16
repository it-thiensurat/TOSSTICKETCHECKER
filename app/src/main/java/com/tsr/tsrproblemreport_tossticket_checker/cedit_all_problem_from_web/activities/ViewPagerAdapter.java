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
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.check_for_credit.Check_Fragment1;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Sanket on 27-Feb-17.
 */

public class ViewPagerAdapter extends PagerAdapter {

    public static Context context;
    private LayoutInflater layoutInflater;
    JsonArrayRequest jsonArrayRequest;
    Check_Fragment1 detali_data_cedit;
    RequestQueue requestQueue;
 // public static   String GET_JSON_DATA_HTTP_URL_IMAGE ="http://bof.thiensurat.co.th/mca/images/contractImage/";
    public static   String GET_JSON_DATA_HTTP_URL_IMAGE ="http://bof.thiensurat.co.th/mca/images/NewcontractImage/";


    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/cedit_data_image_pagerview.php";

    String JSON_contno_image= "contno_image";
    String JSON_Image_PRODUCT = "Image_PRODUCT";
    String JSON_Image_IDCARD = "Image_IDCARD";
    String JSON_Image_MAP = "Image_MAP";


    GetData_cedit getData_cedit;

public static String image1,image2,image3,image4,image5,image6,image11,image22,image33,status_confirm1_old,
        status_confirm2_old,status_confirm3_old,status_confirm1,status_confirm2,status_confirm3,server_image_PRODUCT,server_image_IDCARD,server_image_MAP;
    List<GetData_cedit> GetDataAdapter1;
    ImageView imageView;
    int position2;
    private Integer [] images = {R.drawable.slide1,R.drawable.slide2, R.drawable.slide3,R.drawable.slide1,R.drawable.slide2, R.drawable.slide3};
String Conno;
    public static int check_image_device1=0;
    public static int check_image_device2=0;
    public static int check_image_device3=0;

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }
public int position_real;
    public static  int i=0;
    public static  int j=0;
    public static  int k=0;

    public static  int x=0;
    public static  int y=0;
    public static  int z=0;

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
        position_real=position;
        JSON_DATA_WEB_CALL();









        //position2=position;
Log.e("position33", String.valueOf(position));

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
                //    image_map.setOnTouchListener(new ImageMatrixTouchHandler(context));

                    try {
                        Glide.with(context).load(GET_JSON_DATA_HTTP_URL_IMAGE+image6)



                             /*   .crossFade()
                                .thumbnail(0.5f)
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                */
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






                }   else if(position == 2){


                    final Dialog dialog = new Dialog(ViewPagerAdapter.context);
                    dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.custom_dialog_image_cedit);
                    dialog.setCancelable(true);
                    final ImageView image_map=(ImageView)dialog.findViewById(R.id.image_map);
                    final ImageView rotage2=(ImageView)dialog.findViewById(R.id.rotage2);
                    try {
                        Glide.with(context).load(GET_JSON_DATA_HTTP_URL_IMAGE+image5)



                                /*   .crossFade()
                                  .thumbnail(0.5f)
                                  .diskCacheStrategy(DiskCacheStrategy.ALL)
                                  */
                                .placeholder(context.getResources().getDrawable(R.drawable.no_image_idcard))
                                .into(image_map);
                      //  image_map.setOnTouchListener(new ImageMatrixTouchHandler(context));
                    }
                    catch (Exception e) {

                    }

                    rotage2.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            j=j+90;
                            image_map.setRotation ((float) j);

                        }
                    });

                    dialog.show();

                }

                else if(position == 3){


                    final Dialog dialog = new Dialog(ViewPagerAdapter.context);
                    dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.custom_dialog_image_cedit);
                    dialog.setCancelable(true);
                    final ImageView image_map=(ImageView)dialog.findViewById(R.id.image_map);
                    final ImageView rotage2=(ImageView)dialog.findViewById(R.id.rotage2);
                    try {
                        Glide.with(context).load(GET_JSON_DATA_HTTP_URL_IMAGE+image4)



                                /*   .crossFade()
                                  .thumbnail(0.5f)
                                  .diskCacheStrategy(DiskCacheStrategy.ALL)
                                  */
                                .placeholder(context.getResources().getDrawable(R.drawable.no_image_idcard))
                                .into(image_map);
                        //  image_map.setOnTouchListener(new ImageMatrixTouchHandler(context));
                    }
                    catch (Exception e) {

                    }

                    rotage2.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            z=z+90;
                            image_map.setRotation ((float) z);

                        }
                    });

                    dialog.show();

                }

                else if(position == 4){


                    final Dialog dialog = new Dialog(ViewPagerAdapter.context);
                    dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.custom_dialog_image_cedit);
                    dialog.setCancelable(true);
                    final ImageView image_map=(ImageView)dialog.findViewById(R.id.image_map);
                    final ImageView rotage2=(ImageView)dialog.findViewById(R.id.rotage2);
                    try {
                        Glide.with(context).load(GET_JSON_DATA_HTTP_URL_IMAGE+image3)



                                /*   .crossFade()
                                  .thumbnail(0.5f)
                                  .diskCacheStrategy(DiskCacheStrategy.ALL)
                                  */
                                .placeholder(context.getResources().getDrawable(R.drawable.no_image_idcard))
                                .into(image_map);
                        //  image_map.setOnTouchListener(new ImageMatrixTouchHandler(context));
                    }
                    catch (Exception e) {

                    }

                    rotage2.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            y=y+90;
                            image_map.setRotation ((float) y);

                        }
                    });

                    dialog.show();

                }

                else if(position == 5){


                    final Dialog dialog = new Dialog(ViewPagerAdapter.context);
                    dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.custom_dialog_image_cedit);
                    dialog.setCancelable(true);
                    final ImageView image_map=(ImageView)dialog.findViewById(R.id.image_map);
                    final ImageView rotage2=(ImageView)dialog.findViewById(R.id.rotage2);
                    try {
                        Glide.with(context).load(GET_JSON_DATA_HTTP_URL_IMAGE+image2)



                                /*   .crossFade()
                                  .thumbnail(0.5f)
                                  .diskCacheStrategy(DiskCacheStrategy.ALL)
                                  */
                                .placeholder(context.getResources().getDrawable(R.drawable.no_image_idcard))
                                .into(image_map);
                        //  image_map.setOnTouchListener(new ImageMatrixTouchHandler(context));
                    }
                    catch (Exception e) {

                    }

                    rotage2.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            x=x+90;
                            image_map.setRotation ((float) x);

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
                        Glide.with(context).load(GET_JSON_DATA_HTTP_URL_IMAGE+image1)



                                /*   .crossFade()
                                  .thumbnail(0.5f)
                                  .diskCacheStrategy(DiskCacheStrategy.ALL)
                                  */
                                .placeholder(context.getResources().getDrawable(R.drawable.no_image_product))
                                .into(image_map);
                       // image_map.setOnTouchListener(new ImageMatrixTouchHandler(context));
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







    public void JSON_DATA_WEB_CALL() {


        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL+"?CONTNO="+Conno,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //getDistanceInfo("13.9012707,100.4514525","13.988191,100.6137946");
                        //distance(13.9012707,100.4514525,13.9012707,100.4514525);
                        Log.e("1111","11111");
                        JSON_PARSE_DATA_AFTER_WEBCALL(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("2222",error.toString());
                        //ShowSQLiteDBdata();
                    }
                });

        requestQueue = Volley.newRequestQueue(context);

        requestQueue.add(jsonArrayRequest);

    }



    public void JSON_PARSE_DATA_AFTER_WEBCALL( JSONArray array) {





        for (int i = 0; i <= array.length()-1; i++) {

            final GetData_cedit GetDataAdapter2 = new GetData_cedit();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);




                getData_cedit =new GetData_cedit();


                getData_cedit.setcontno_image(json.getString(JSON_contno_image));
                getData_cedit.setImage_PRODUCT(json.getString(JSON_Image_PRODUCT));
                getData_cedit.setImage_IDCARD(json.getString(JSON_Image_IDCARD));
                getData_cedit.setImage_MAP(json.getString(JSON_Image_MAP));

                getData_cedit.setImage_ADDRESS(json.getString("Image_ADDRESS"));
                getData_cedit.setImage_PAYMENTCARD(json.getString("Image_PAYMENTCARD"));
                getData_cedit.setImage_MAPPAYMENT(json.getString("Image_MAPPAYMENT"));


                            image1 = getData_cedit.getImage_PRODUCT() + "";
                            image2 = getData_cedit.getImage_IDCARD() + "";
                            image3 = getData_cedit.getImage_MAP() + "";


                image4 = getData_cedit.getImage_ADDRESS() + "";
                image5 = getData_cedit.getImage_PAYMENTCARD() + "";
                image6 = getData_cedit.getImage_MAPPAYMENT() + "";






                Log.e("image1", image1);
                Log.e("image2", image2);
                Log.e("image3", image3);
                Log.e("image4", image4);
                Log.e("image5", image5);
                Log.e("image6", image6);










                if(position_real == 0){
                    Log.e("position_real", String.valueOf(position_real));
                    try {
                        Glide.with(context).load(GET_JSON_DATA_HTTP_URL_IMAGE+image6)



                                .crossFade()
                                .thumbnail(0.5f)
                                // .bitmapTransform(new CircleTransform(context))
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .placeholder(context.getResources().getDrawable(R.drawable.no_image_map))
                                .into(imageView);
                    }
                    catch (Exception e) {

                    }
                }  else if(position_real == 2){
                    try {
                        Glide.with(context).load(GET_JSON_DATA_HTTP_URL_IMAGE+image5)



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

                else if(position_real == 3){
                    try {
                        Glide.with(context).load(GET_JSON_DATA_HTTP_URL_IMAGE+image4)



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


                else if(position_real == 4){
                    try {
                        Glide.with(context).load(GET_JSON_DATA_HTTP_URL_IMAGE+image3)



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


                else if(position_real == 5){
                    try {
                        Glide.with(context).load(GET_JSON_DATA_HTTP_URL_IMAGE+image2)



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
                        Glide.with(context).load(GET_JSON_DATA_HTTP_URL_IMAGE+image1)



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



            } catch (JSONException e) {

                e.printStackTrace();
            }
//            GetDataAdapter1.add(GetDataAdapter2);
            //  pDialog.dismiss();
        }



    }





    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}
