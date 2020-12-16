package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments;

/**
 * Created by user on 30/11/2560.
 */

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.tsr.tsrproblemreport_tossticket_checker.R;

import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.ViewPagerAdapter;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static android.app.Activity.RESULT_OK;


public class Detali_data_cedit_fragmant extends android.support.v4.app.Fragment implements OnClickListener {

    ImageView scan,location,camera;
    GetData_cedit getData_cedit;
    JsonArrayRequest jsonArrayRequest;
    Intent CamIntent,GalIntent,CropIntent,CropIntent2;
    RequestQueue requestQueue;
    File file;
    Uri uri;
    Bitmap bitmap;
    String filePath = null;
    Bitmap bmplogo=null;



    TextView txt_conno,txt_productname,txt_status,txt_customer,txt_idcard,txt_address,txt_phone,txt_date;
    public static String conno,productname,status,customer,idcard,address,phone_home,phone_mobile,date,Latitude,Longitude;


    private Date oneWayTripDate;


    String date_new_format_thai;

    String dateThai_year,dateThai_month,dateThai_day, dateThai_month1;

    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;

    int converted_dateThai1,converted_dateThai11;

    Button button5;
    ViewPagerAdapter viewPagerAdapter;























    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);






        viewPagerAdapter = new ViewPagerAdapter(getActivity());

//            scan.setOnClickListener(this);
        //       location.setOnClickListener(this);
        //      camera.setOnClickListener(this);
        button5.setOnClickListener(this);







        Bundle data=getActivity().getIntent().getExtras();
        if(data!=null)
        {

            conno=data.getString("conno");
            productname=data.getString("productname");
            status=data.getString("status");
            customer=data.getString("customer");
            idcard=data.getString("idcard");
            address=data.getString("address");
            phone_home=data.getString("phone_home");
            phone_mobile=data.getString("phone_mobile");
            date=data.getString("date");

            Latitude=data.getString("Latitude");
            Longitude=data.getString("Longitude");

            txt_conno.setText(conno);
            txt_productname.setText(productname);
            txt_status.setText(status);
            txt_customer.setText(customer);
            txt_idcard.setText(idcard);
            txt_address.setText(address);
            txt_phone.setText(phone_mobile+" , "+phone_home);







//Log.e("date",date);




            SimpleDateFormat input22 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat output22 = new SimpleDateFormat("yyyy-MM-dd");
            try {
                oneWayTripDate = input22.parse(date);  // parse input

            } catch (ParseException e) {
                e.printStackTrace();
            }


            date_new_format_thai=output22.format(oneWayTripDate);

            Log.e("date_new_format_thai",date_new_format_thai);


            if(date_new_format_thai.indexOf(date_new_format_thai) != -1) {
                String arr2[] = date_new_format_thai.split("-");
                dateThai_year=arr2[0];
                dateThai_month=arr2[1];
                dateThai_day=arr2[2];


                converted_dateThai11=Integer.parseInt(dateThai_year);
                converted_dateThai11=converted_dateThai11+543;

                if(dateThai_month.equals("01")){dateThai_month1="ม.ค.";}
                else if(dateThai_month.equals("02")){dateThai_month1="ก.พ.";}
                else if(dateThai_month.equals("03")){dateThai_month1="มี.ค.";}
                else if(dateThai_month.equals("04")){dateThai_month1="เม.ย.";}
                else if(dateThai_month.equals("05")){dateThai_month1="พ.ค.";}
                else if(dateThai_month.equals("06")){dateThai_month1="มิ.ย.";}
                else if(dateThai_month.equals("07")){dateThai_month1="ก.ค.";}
                else if(dateThai_month.equals("08")){dateThai_month1="ส.ค.";}
                else if(dateThai_month.equals("09")){dateThai_month1="ก.ย.";}
                else if(dateThai_month.equals("10")){dateThai_month1="ต.ค.";}
                else if(dateThai_month.equals("11")){dateThai_month1="พ.ย.";}
                else if(dateThai_month.equals("12")){dateThai_month1="ธ.ค.";}



                txt_date.setText(dateThai_day+" "+dateThai_month1+converted_dateThai11);
                Log.e("dateThai",dateThai_day+""+dateThai_month1+""+converted_dateThai11+"");
            }




        }










        viewPager.setAdapter(viewPagerAdapter);

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(getActivity());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.nonactive_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);












    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View layoutView = inflater.inflate(R.layout.check_customer_new, container, false);
        // toolbar = (Toolbar) layoutView.findViewById(R.id.toolbar);
        if (Build.VERSION.SDK_INT >= 21) {
            getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }




        //getActivity().getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //   scan=(ImageView)findViewById(R.id.scan);
        //  location=(ImageView)findViewById(R.id.location);
        //  camera=(ImageView)findViewById(R.id.camera);


        txt_conno=(TextView)layoutView.findViewById(R.id.txt_conno);
        txt_productname=(TextView)layoutView.findViewById(R.id.txt_productname);
        txt_status=(TextView)layoutView.findViewById(R.id.txt_status);
        txt_customer=(TextView)layoutView.findViewById(R.id.txt_customer);
        txt_idcard=(TextView)layoutView.findViewById(R.id.txt_idcard);
        txt_address=(TextView)layoutView.findViewById(R.id.txt_address);
        txt_phone=(TextView)layoutView.findViewById(R.id.txt_phone);
        txt_date=(TextView)layoutView.findViewById(R.id.txt_date);
        button5=(Button)layoutView.findViewById(R.id.button5);


        viewPager = (ViewPager) layoutView.findViewById(R.id.viewPager);

        sliderDotspanel = (LinearLayout)layoutView. findViewById(R.id.SliderDots);






        return layoutView;

    }




    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            Detali_data_cedit_fragmant.this.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(viewPager.getCurrentItem() == 0){
                        viewPager.setCurrentItem(1);
                    } else if(viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);
                    }
                    else if(viewPager.getCurrentItem() == 2){
                        viewPager.setCurrentItem(3);
                    }
                    else {
                        viewPager.setCurrentItem(0);
                    }

                }
            });

        }
    }


    @Override
    public void onClick(View view) {


        /*
                          if(view==scan){
                        Intent Intent = new Intent( this, MainActivity_qr.class);


                              Bundle bun=new Bundle();
                              bun.putString("conno", conno);


                              Intent.putExtras(bun);

                        startActivity(Intent);
                }
                else  if(view==location){
                        Intent Intent = new Intent( this, MapsActivity.class);
                        startActivity(Intent);

                }
                else  if(view==camera){
                        CameraOpen();

                }
                else

                 */if(view==button5)
        {
            // Intent Intent = new Intent( Detali_data_cedit.this, UI_CARDVIEW_CHECKBOX_cedit.class);
            // startActivity(Intent);

        }
    }


    private void CameraOpen() {
        CamIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


        file = new File(Environment.getExternalStorageDirectory(),
                "file"+String.valueOf(System.currentTimeMillis())+".jpg");
        uri = Uri.fromFile(file);
        CamIntent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
        CamIntent.putExtra("return-data",true);
        startActivityForResult(CamIntent,0);
    }



    private void CropImage() {

        try{
            CropIntent = new Intent("com.android.camera.action.CROP");
            CropIntent.setDataAndType(uri,"image/*");
            CropIntent.putExtra("crop","true");
            CropIntent.putExtra("outputX",256);
            CropIntent.putExtra("outputY",256);
            CropIntent.putExtra("aspectX",1);
            CropIntent.putExtra("aspectY",1);
            CropIntent.putExtra("scaleUpIfNeeded",true);
            CropIntent.putExtra("return-data",true);

            startActivityForResult(CropIntent,1);
        }
        catch (ActivityNotFoundException ex)
        {

        }



    }


    private void creatJPG(Bitmap bitmap ) {
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
        String imageName = df.format(now);
        try {
            String imagePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();

            File imageFile = new File(imagePath + "/" + imageName + ".jpg");
            FileOutputStream outputStream = new FileOutputStream(imageFile);
            int quality = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
            outputStream.flush();
            outputStream.close();

            String uu = Uri.fromFile(imageFile).toString();
            String rr =Uri.fromFile(imageFile).toString();

            if (uu != null) {
                filePath = uu;
            } else if (rr != null) {
                filePath = rr;
            } else {

                Toast.makeText(getActivity(), "Unknown path",
                        Toast.LENGTH_LONG).show();
                Log.e("Bitmap", "Unknown path");
            }


            System.out.println("filePath="+filePath);
            bmplogo= Utils.decodeFile(new File(filePath),240);

            Log.e("ddd","fff");



        } catch (Throwable e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0) {
            if(resultCode==RESULT_OK)
                CropImage();
        }


        else if (requestCode == 1)
        {

            if(data != null)
            {

                try {

                    Bundle bundle = data.getExtras();

                    bitmap = bundle.getParcelable("data");

                    //  imageView2.setImageBitmap(bitmap);

                    creatJPG(bitmap);

                }
                catch (Exception e) {

                }

            }
        }

    }







    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if(id == R.id.map){



            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?daddr=" + "13.897776" + "," + "100.5123653"+"&daddr="+Latitude+","+Longitude));
            startActivity(intent);

        }



        return super.onOptionsItemSelected(item);
    }




}
