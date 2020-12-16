package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_sale_edit_problem;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.ImageAfter;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.ImageBefore;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.SectionDataModel;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.SectionDataModel2;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.SingleItemModel;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.SingleItemModel2;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.CircleTransform;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static com.tsr.tsrproblemreport_tossticket_checker.R.id;

/**
 * Created by JUNED on 6/16/2016.
 */
public class RecyclerViewAdapter_credit_recive_problem_before_edit2 extends RecyclerView.Adapter<RecyclerViewAdapter_credit_recive_problem_before_edit2.ViewHolder> implements Filterable {

    RecyclerViewDataAdapter3 adapter3;
    RecyclerViewDataAdapter4 adapter4;
    public static Context context;
    List<GetData_cedit_sale_edit_problem> getDataAdapter;
    private List<ImageBefore> imageBeforeList = new ArrayList<>();
    private List<ImageAfter> imageAfterList = new ArrayList<>();
    // List<Details_contno> details_contnos ;
   // Details_contno Details_contno;
    ImageLoader imageLoader1;

    int i = 0;
    private boolean open_up_down=false;
    public  static LinearLayout linear_down;
      public  static ImageView image_status;

    ArrayList<SectionDataModel> allSampleData;
    ArrayList<SingleItemModel> singleItem;

    ArrayList<SectionDataModel2> allSampleData2;
    ArrayList<SingleItemModel2> singleItem2;


    String date_new_format_thai,date_new_format_thai2;
    String dateThai_year,dateThai_month,dateThai_day,dateThai_month1;
    int converted_dateThai11;
    private Date oneWayTripDate;
    String s1,s2,s3;
    private int layout1 = 100;
    private int layout2 = 101;
    View v;

    public RecyclerView my_recycler_view2,my_recycler_view;

    int zine;
    private UserFilter userFilter;


    public RecyclerViewAdapter_credit_recive_problem_before_edit2(List<GetData_cedit_sale_edit_problem> getDataAdapter, Context context){

        super();
        this.getDataAdapter = getDataAdapter;
       // this.details_contnos=details_contnos;
        this.context = context;
        userFilter = new UserFilter(RecyclerViewAdapter_credit_recive_problem_before_edit2.this,getDataAdapter);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       // list_item_home2
        //show_checkbox_cardview_cedit2_edit_before_fragment_waiting_to_check
        //show_checkbox_cardview_cedit2_edit_before2_fragment_waiting_to_check


        if (viewType == layout1) {
            // self message
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_home4, parent, false);
        }
        else if (viewType == layout2) {
            // self message
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_home2, parent, false);
        }


       // View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_home, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;


    }




    @Override
    public int getItemViewType(int position) {
        GetData_cedit_sale_edit_problem message = getDataAdapter.get(position);
        try {
            if ((!message.getImage_Name().equals("null"))&(!message.getImage_Name_R().equals("null"))) {
                return layout1;
            }
            else if ((!message.getImage_Name().equals("null"))&(message.getImage_Name_R().equals("null"))) {
                return layout1;
            }
            else if ((message.getImage_Name().equals("null"))&(!message.getImage_Name_R().equals("null"))) {
                return layout1;
            }

            else  {
                return layout2;
            }

        }
        catch (Exception e) {

        }



        return position;
    }



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {

        GetData_cedit_sale_edit_problem getDataAdapter1 =  getDataAdapter.get(position);

        Viewholder.InformID.setText(getDataAdapter1.getInformID());
        Viewholder.contno.setText(getDataAdapter1.getContno());

        Viewholder.txt_customer.setText(getDataAdapter1.getCustomer()+"");
        Viewholder.txt_tel.setText(getDataAdapter1.getTel()+"");
        Viewholder.txt_address.setText(getDataAdapter1.getAddress()+"");

        try {
            if(getDataAdapter1.getGory().equals("ปัญหาการ์ดตรวจสอบ")){
                Viewholder.txt_category.setTextColor(0XFFff0000);
            }
            else if(getDataAdapter1.getGory().equals("ปัญหาการ์ดค่างวด")){
                Viewholder.txt_category.setTextColor(0XFFFFA500);
            }
            else {
                Viewholder.txt_category.setTextColor(0XFFC71585);
            }
        }
        catch (Exception ex){

        }



        try {
            String CancelNote =getDataAdapter1.getCancelNote();
            if((CancelNote.equals("null"))|(CancelNote.isEmpty())){
                Viewholder.linear_sale3_main.setVisibility(View.GONE);
            }
            else {
                Viewholder.linear_sale3_main.setVisibility(View.VISIBLE);
                Viewholder.new_message_main3.setText(getDataAdapter1.getCancelNote());
            }


            Viewholder.txt_effdate.setText(getDataAdapter1.getEffDate()+"");
            if(getDataAdapter1.getTel().equals("null")|(getDataAdapter1.getTel().isEmpty())){
                Viewholder.txt_tel.setText("-");
            }
            else {
                Viewholder.txt_tel.setText(getDataAdapter1.getTel()+"");
            }
            if(getDataAdapter1.getTel2().equals("null")|(getDataAdapter1.getTel2().isEmpty())){
                Viewholder.txt_tel2.setText("-");
            }
            else {
                Viewholder.txt_tel2.setText(getDataAdapter1.getTel2()+"");
            }




        }
        catch (Exception x){

        }





        try {
            String IN_ITEM=getDataAdapter1.getInformitem()+"";
            if(IN_ITEM.equals("null")){
                Viewholder.linear_Informitem.setVisibility(View.GONE);

            }
            else {
                Viewholder.linear_Informitem.setVisibility(View.VISIBLE);
                Viewholder.txt_Informitem.setText(getDataAdapter1.getInformitem());
            }
        }
        catch (Exception ex){

        }




        try {
            if(getDataAdapter1.getGory().equals("null")){
                Viewholder.txt_category.setText("อื่นๆ");
            }
            else {
                Viewholder.txt_category.setText(getDataAdapter1.getGory());
            }
        }
        catch (Exception ex){

        }



        if(getDataAdapter1.getMain().equals("null")){
            Viewholder.txt_main_problem.setText("-");
        }
        else {
            Viewholder.txt_main_problem.setText(getDataAdapter1.getMain());
        }


        if(getDataAdapter1.getTopic_problem().equals("null")){
            Viewholder.txt_sub_problem.setText("-");
        }
        else {
            Viewholder.txt_sub_problem.setText(getDataAdapter1.getTopic_problem());
        }


  /*      if(!getDataAdapter1.getProblemTopic().isEmpty()){
            Viewholder.txt_topic.setText(getDataAdapter1.getProblemTopic()+"");
        }
       else*/ if(getDataAdapter1.getTopic_problem().equals("null")){
            Viewholder.txt_topic.setText("ปัญหาอื่นๆ");
        }
        else {
            Viewholder.txt_topic.setText("-");

        }





        try {
            if(getDataAdapter1.getProblemDetail_sub().isEmpty()){
                Viewholder.new_message_main.setText("-");
            }
            else {
                Viewholder.new_message_main.setText(getDataAdapter1.getProblemDetail_sub());
            }
        }
        catch (Exception ex){

        }






        Viewholder.new_message.setText(getDataAdapter1.getProblemDetail());
        Viewholder.new_message2.setText(getDataAdapter1.getProblemDetail2());

        try {
            Glide.with(context).load(getDataAdapter1.getPicture())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(context))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                    .into(Viewholder.list_item_home_foxy_img);
        }
        catch (Exception e) {

        }
        Viewholder.list_item_home_posted_name.setText(getDataAdapter1.getEmployeeName());
        Viewholder.list_item_home_posted_txt.setText(getDataAdapter1.getPositionName());



        String WorkCode_I=getDataAdapter1.getWorkCode_I();
        String WorkCode=getDataAdapter1.getWorkCode();
        String WorkName=getDataAdapter1.getWorkName();
        imageBeforeList = getDataAdapter1.getImageBefore();
        imageAfterList = getDataAdapter1.getImageAfter();
        if(WorkName.equals("null")){
            Viewholder.txt_status.setText("อยู่ระหว่างการตรวจสอบ");
            Viewholder.deleteAll.setVisibility(View.VISIBLE);

            Viewholder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
            Viewholder.txt_status_closing.setText("รอดำเนินการ");
            Viewholder.txt_status_closing.setTextColor(0xffA9A9A9);
            Viewholder.relat_remove.setVisibility(View.VISIBLE);
        }
        else {
            Viewholder.txt_status.setText(WorkName);
            Viewholder.deleteAll.setVisibility(View.GONE);

            Viewholder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
            Viewholder.txt_status_closing.setText("รอดำเนินการ");
            //Viewholder.txt_status_closing.setTextColor(0xffA9A9A9);

        }


        if(WorkCode.equals("00")){
            Viewholder.relat_remove.setVisibility(View.VISIBLE);

            Viewholder.linear_coler.setBackgroundResource(R.color.graysafe);
            Viewholder.deleteAll.setVisibility(View.VISIBLE);

            Viewholder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
            Viewholder.txt_status_closing.setText("รอดำเนินการ");
            Viewholder.txt_status_closing.setTextColor(0xffA9A9A9);

            Viewholder.txt_status_image.setText(" รูปยังไม่แก้ไข ");
            Viewholder.txt_status_image.setTextColor(0xffB22222);

            try {
                Glide.with(context).load(getDataAdapter1.getImageUrl())



                        .crossFade()
                        .thumbnail(0.5f)
                        // .bitmapTransform(new CircleTransform(context))
                        .diskCacheStrategy(DiskCacheStrategy.ALL)

                        .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                        .into(Viewholder.image_problem_incorrect);
            }
            catch (Exception e) {

            }
        }


        else if(WorkCode.equals("10")){
            Viewholder.relat_remove.setVisibility(View.GONE);

            Viewholder.linear_coler.setBackgroundResource(R.color.colorPrimary);

            Viewholder.deleteAll.setVisibility(View.VISIBLE);

            Viewholder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange17);
            Viewholder.txt_status_closing.setText("ปิดงานแล้ว");

            if(getDataAdapter1.getImage_Name_R().equals("null")){
                Viewholder.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                Viewholder.txt_status_image.setTextColor(0xfffaebd7);

                String COUNT_IMAGE=getDataAdapter1.getCountImage();
                try {
                    int int_count_image= Integer.parseInt(COUNT_IMAGE);
                    if(int_count_image>1){
                        Viewholder.txt_count_image_error.setVisibility(View.VISIBLE);
                        Viewholder.txt_count_image_error.setText("+ "+getDataAdapter1.getCountImage());
                    }
                    else {
                        Viewholder.txt_count_image_error.setVisibility(View.GONE);
                    }
                }
                catch (Exception e){

                }


                try {
                    Glide.with(context).load(getDataAdapter1.getImageUrl())


                            .crossFade()
                            .thumbnail(0.5f)
                            // .bitmapTransform(new CircleTransform(context))
                            .diskCacheStrategy(DiskCacheStrategy.ALL)

                            .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                            .into(Viewholder.image_problem_incorrect);
                }
                catch (Exception e) {

                }
            }
            else {
                Viewholder.txt_status_image.setText(" รูปแก้ไขแล้ว ");
                Viewholder.txt_status_image.setTextColor(0xff75b275);

                String COUNT_IMAGE=getDataAdapter1.getCountImage_R();
                try {
                    int int_count_image= Integer.parseInt(COUNT_IMAGE);
                    if(int_count_image>1){
                        Viewholder.txt_count_image_error.setVisibility(View.VISIBLE);
                        Viewholder.txt_count_image_error.setText("+ "+getDataAdapter1.getCountImage_R());
                    }
                    else {
                        Viewholder.txt_count_image_error.setVisibility(View.GONE);
                    }
                }
                catch (Exception e){

                }
                try {
                    Glide.with(context).load(getDataAdapter1.getImageUrl_R())


                            .crossFade()
                            .thumbnail(0.5f)
                            // .bitmapTransform(new CircleTransform(context))
                            .diskCacheStrategy(DiskCacheStrategy.ALL)

                            .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                            .into(Viewholder.image_problem_incorrect);
                }
                catch (Exception e) {

                }
            }


        }
        else if(WorkCode.equals("21")){
            Viewholder.relat_remove.setVisibility(View.GONE);

            Viewholder.linear_coler.setBackgroundResource(R.color.MediumTurquoise);
            Viewholder.deleteAll.setVisibility(View.VISIBLE);

            Viewholder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
            Viewholder.txt_status_closing.setText("รอดำเนินการ");
            Viewholder.txt_status_closing.setTextColor(0xffA9A9A9);


            if(getDataAdapter1.getImage_Name_R().equals("null")){
                Viewholder.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                Viewholder.txt_status_image.setTextColor(0xfffaebd7);


                String COUNT_IMAGE=getDataAdapter1.getCountImage();
                try {
                    int int_count_image= Integer.parseInt(COUNT_IMAGE);
                    if(int_count_image>1){
                        Viewholder.txt_count_image_error.setVisibility(View.VISIBLE);
                        Viewholder.txt_count_image_error.setText("+ "+getDataAdapter1.getCountImage());
                    }
                    else {
                        Viewholder.txt_count_image_error.setVisibility(View.GONE);
                    }
                }
                catch (Exception e){

                }

                try {
                    Glide.with(context).load(getDataAdapter1.getImageUrl())


                            .crossFade()
                            .thumbnail(0.5f)
                            // .bitmapTransform(new CircleTransform(context))
                            .diskCacheStrategy(DiskCacheStrategy.ALL)

                            .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                            .into(Viewholder.image_problem_incorrect);
                }
                catch (Exception e) {

                }
            }
            else {
                Viewholder.txt_status_image.setText(" รูปแก้ไขแล้ว ");
                Viewholder.txt_status_image.setTextColor(0xff75b275);

                String COUNT_IMAGE=getDataAdapter1.getCountImage_R();
                try {
                    int int_count_image= Integer.parseInt(COUNT_IMAGE);
                    if(int_count_image>1){
                        Viewholder.txt_count_image_error.setVisibility(View.VISIBLE);
                        Viewholder.txt_count_image_error.setText("+ "+getDataAdapter1.getCountImage_R());
                    }
                    else {
                        Viewholder.txt_count_image_error.setVisibility(View.GONE);
                    }
                }
                catch (Exception e){

                }
                try {
                    Glide.with(context).load(getDataAdapter1.getImageUrl_R())


                            .crossFade()
                            .thumbnail(0.5f)
                            // .bitmapTransform(new CircleTransform(context))
                            .diskCacheStrategy(DiskCacheStrategy.ALL)

                            .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                            .into(Viewholder.image_problem_incorrect);
                }
                catch (Exception e) {

                }
            }
        }
        else if(WorkCode.equals("22")){
            Viewholder.relat_remove.setVisibility(View.GONE);

            Viewholder.linear_coler.setBackgroundResource(R.color.Red);
            Viewholder.deleteAll.setVisibility(View.VISIBLE);


            Viewholder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
            Viewholder.txt_status_closing.setText("รอดำเนินการ");
            Viewholder.txt_status_closing.setTextColor(0xffA9A9A9);


            if(getDataAdapter1.getImage_Name_R().equals("null")){
                Viewholder.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                Viewholder.txt_status_image.setTextColor(0xfffaebd7);


                String COUNT_IMAGE=getDataAdapter1.getCountImage();
                try {
                    int int_count_image= Integer.parseInt(COUNT_IMAGE);
                    if(int_count_image>1){
                        Viewholder.txt_count_image_error.setVisibility(View.VISIBLE);
                        Viewholder.txt_count_image_error.setText("+ "+getDataAdapter1.getCountImage());
                    }
                    else {
                        Viewholder.txt_count_image_error.setVisibility(View.GONE);
                    }
                }
                catch (Exception e){

                }

                try {
                    Glide.with(context).load(getDataAdapter1.getImageUrl())


                            .crossFade()
                            .thumbnail(0.5f)
                            // .bitmapTransform(new CircleTransform(context))
                            .diskCacheStrategy(DiskCacheStrategy.ALL)

                            .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                            .into(Viewholder.image_problem_incorrect);
                }
                catch (Exception e) {

                }
            }
            else {
                Viewholder.txt_status_image.setText(" รูปแก้ไขแล้ว ");
                Viewholder.txt_status_image.setTextColor(0xff75b275);

                String COUNT_IMAGE=getDataAdapter1.getCountImage_R();
                try {
                    int int_count_image= Integer.parseInt(COUNT_IMAGE);
                    if(int_count_image>1){
                        Viewholder.txt_count_image_error.setVisibility(View.VISIBLE);
                        Viewholder.txt_count_image_error.setText("+ "+getDataAdapter1.getCountImage_R());
                    }
                    else {
                        Viewholder.txt_count_image_error.setVisibility(View.GONE);
                    }
                }
                catch (Exception e){

                }
                try {
                    Glide.with(context).load(getDataAdapter1.getImageUrl_R())


                            .crossFade()
                            .thumbnail(0.5f)
                            // .bitmapTransform(new CircleTransform(context))
                            .diskCacheStrategy(DiskCacheStrategy.ALL)

                            .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                            .into(Viewholder.image_problem_incorrect);
                }
                catch (Exception e) {

                }
            }
        }
        else if(WorkCode.equals("23")){
            Viewholder.relat_remove.setVisibility(View.GONE);

            Viewholder.linear_coler.setBackgroundResource(R.color.RoyalBlue);

            Viewholder.deleteAll.setVisibility(View.VISIBLE);

            Viewholder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
            Viewholder.txt_status_closing.setText("รอดำเนินการ");
            Viewholder.txt_status_closing.setTextColor(0xffA9A9A9);

            Viewholder.txt_status_image.setText(" รูปแก้ไขแล้ว ");
            Viewholder.txt_status_image.setTextColor(0xff75b275);

            if(getDataAdapter1.getImage_Name_R().equals("null")){
                Viewholder.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                Viewholder.txt_status_image.setTextColor(0xfffaebd7);

                String COUNT_IMAGE=getDataAdapter1.getCountImage();
                try {
                    int int_count_image= Integer.parseInt(COUNT_IMAGE);
                    if(int_count_image>1){
                        Viewholder.txt_count_image_error.setVisibility(View.VISIBLE);
                        Viewholder.txt_count_image_error.setText("+ "+getDataAdapter1.getCountImage());
                    }
                    else {
                        Viewholder.txt_count_image_error.setVisibility(View.GONE);
                    }
                }
                catch (Exception e){

                }



                try {
                    Glide.with(context).load(getDataAdapter1.getImageUrl())


                            .crossFade()
                            .thumbnail(0.5f)
                            // .bitmapTransform(new CircleTransform(context))
                            .diskCacheStrategy(DiskCacheStrategy.ALL)

                            .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                            .into(Viewholder.image_problem_incorrect);
                }
                catch (Exception e) {

                }
            }
            else {
                Viewholder.txt_status_image.setText(" รูปแก้ไขแล้ว ");
                Viewholder.txt_status_image.setTextColor(0xff75b275);

                String COUNT_IMAGE=getDataAdapter1.getCountImage_R();
                try {
                    int int_count_image= Integer.parseInt(COUNT_IMAGE);
                    if(int_count_image>1){
                        Viewholder.txt_count_image_error.setVisibility(View.VISIBLE);
                        Viewholder.txt_count_image_error.setText("+ "+getDataAdapter1.getCountImage_R());
                    }
                    else {
                        Viewholder.txt_count_image_error.setVisibility(View.GONE);
                    }
                }
                catch (Exception e){

                }


                try {
                    Glide.with(context).load(getDataAdapter1.getImageUrl_R())


                            .crossFade()
                            .thumbnail(0.5f)
                            // .bitmapTransform(new CircleTransform(context))
                            .diskCacheStrategy(DiskCacheStrategy.ALL)

                            .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                            .into(Viewholder.image_problem_incorrect);
                }
                catch (Exception e) {

                }
            }
        }
        else if(WorkCode.equals("24")){
            Viewholder.relat_remove.setVisibility(View.GONE);

            Viewholder.linear_coler.setBackgroundResource(R.color.Blue);

            Viewholder.deleteAll.setVisibility(View.VISIBLE);

            Viewholder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
            Viewholder.txt_status_closing.setText("รอดำเนินการ");
            Viewholder.txt_status_closing.setTextColor(0xffA9A9A9);

            Viewholder.txt_status_image.setText(" รูปแก้ไขแล้ว ");
            Viewholder.txt_status_image.setTextColor(0xff75b275);

            if(getDataAdapter1.getImage_Name_R().equals("null")){
                Viewholder.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                Viewholder.txt_status_image.setTextColor(0xfffaebd7);

                String COUNT_IMAGE=getDataAdapter1.getCountImage();
                try {
                    int int_count_image= Integer.parseInt(COUNT_IMAGE);
                    if(int_count_image>1){
                        Viewholder.txt_count_image_error.setVisibility(View.VISIBLE);
                        Viewholder.txt_count_image_error.setText("+ "+getDataAdapter1.getCountImage());
                    }
                    else {
                        Viewholder.txt_count_image_error.setVisibility(View.GONE);
                    }
                }
                catch (Exception e){

                }
                try {
                    Glide.with(context).load(getDataAdapter1.getImageUrl())


                            .crossFade()
                            .thumbnail(0.5f)
                            // .bitmapTransform(new CircleTransform(context))
                            .diskCacheStrategy(DiskCacheStrategy.ALL)

                            .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                            .into(Viewholder.image_problem_incorrect);
                }
                catch (Exception e) {

                }
            }
            else {
                Viewholder.txt_status_image.setText(" รูปแก้ไขแล้ว ");
                Viewholder.txt_status_image.setTextColor(0xff75b275);

                String COUNT_IMAGE=getDataAdapter1.getCountImage_R();
                try {
                    int int_count_image= Integer.parseInt(COUNT_IMAGE);
                    if(int_count_image>1){
                        Viewholder.txt_count_image_error.setVisibility(View.VISIBLE);
                        Viewholder.txt_count_image_error.setText("+ "+getDataAdapter1.getCountImage_R());
                    }
                    else {
                        Viewholder.txt_count_image_error.setVisibility(View.GONE);
                    }
                }
                catch (Exception e){

                }
                try {
                    Glide.with(context).load(getDataAdapter1.getImageUrl_R())


                            .crossFade()
                            .thumbnail(0.5f)
                            // .bitmapTransform(new CircleTransform(context))
                            .diskCacheStrategy(DiskCacheStrategy.ALL)

                            .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                            .into(Viewholder.image_problem_incorrect);
                }
                catch (Exception e) {

                }
            }
        }
        else if(WorkCode.equals("25")){
            Viewholder.relat_remove.setVisibility(View.GONE);
            Viewholder.linear_coler.setBackgroundResource(R.color.DarkBlue);

            Viewholder.deleteAll.setVisibility(View.VISIBLE);

            Viewholder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
            Viewholder.txt_status_closing.setText("รอดำเนินการ");
            Viewholder.txt_status_closing.setTextColor(0xffA9A9A9);

            Viewholder.txt_status_image.setText(" รูปแก้ไขแล้ว ");
            Viewholder.txt_status_image.setTextColor(0xff75b275);

            if(getDataAdapter1.getImage_Name_R().equals("null")){
                Viewholder.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                Viewholder.txt_status_image.setTextColor(0xfffaebd7);

                String COUNT_IMAGE=getDataAdapter1.getCountImage();
                try {
                    int int_count_image= Integer.parseInt(COUNT_IMAGE);
                    if(int_count_image>1){
                        Viewholder.txt_count_image_error.setVisibility(View.VISIBLE);
                        Viewholder.txt_count_image_error.setText("+ "+getDataAdapter1.getCountImage());
                    }
                    else {
                        Viewholder.txt_count_image_error.setVisibility(View.GONE);
                    }
                }
                catch (Exception e){

                }
                try {
                    Glide.with(context).load(getDataAdapter1.getImageUrl())


                            .crossFade()
                            .thumbnail(0.5f)
                            // .bitmapTransform(new CircleTransform(context))
                            .diskCacheStrategy(DiskCacheStrategy.ALL)

                            .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                            .into(Viewholder.image_problem_incorrect);
                }
                catch (Exception e) {

                }
            }
            else {
                Viewholder.txt_status_image.setText(" รูปแก้ไขแล้ว ");
                Viewholder.txt_status_image.setTextColor(0xff75b275);

                String COUNT_IMAGE=getDataAdapter1.getCountImage_R();
                try {
                    int int_count_image= Integer.parseInt(COUNT_IMAGE);
                    if(int_count_image>1){
                        Viewholder.txt_count_image_error.setVisibility(View.VISIBLE);
                        Viewholder.txt_count_image_error.setText("+ "+getDataAdapter1.getCountImage_R());
                    }
                    else {
                        Viewholder.txt_count_image_error.setVisibility(View.GONE);
                    }
                }
                catch (Exception e){

                }
                try {
                    Glide.with(context).load(getDataAdapter1.getImageUrl_R())


                            .crossFade()
                            .thumbnail(0.5f)
                            // .bitmapTransform(new CircleTransform(context))
                            .diskCacheStrategy(DiskCacheStrategy.ALL)

                            .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                            .into(Viewholder.image_problem_incorrect);
                }
                catch (Exception e) {

                }
            }
        }


        else if(WorkCode.equals("26")){
            Viewholder.relat_remove.setVisibility(View.GONE);
            Viewholder.linear_coler.setBackgroundResource(R.color.Purple);

            Viewholder.deleteAll.setVisibility(View.VISIBLE);

            Viewholder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
            Viewholder.txt_status_closing.setText("รอดำเนินการ");
            Viewholder.txt_status_closing.setTextColor(0xffA9A9A9);

            Viewholder.txt_status_image.setText(" รูปแก้ไขแล้ว ");
            Viewholder.txt_status_image.setTextColor(0xff75b275);

            if(getDataAdapter1.getImage_Name_R().equals("null")){
                Viewholder.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                Viewholder.txt_status_image.setTextColor(0xfffaebd7);

                String COUNT_IMAGE=getDataAdapter1.getCountImage();
                try {
                    int int_count_image= Integer.parseInt(COUNT_IMAGE);
                    if(int_count_image>1){
                        Viewholder.txt_count_image_error.setVisibility(View.VISIBLE);
                        Viewholder.txt_count_image_error.setText("+ "+getDataAdapter1.getCountImage());
                    }
                    else {
                        Viewholder.txt_count_image_error.setVisibility(View.GONE);
                    }
                }
                catch (Exception e){

                }
                try {
                    Glide.with(context).load(getDataAdapter1.getImageUrl())


                            .crossFade()
                            .thumbnail(0.5f)
                            // .bitmapTransform(new CircleTransform(context))
                            .diskCacheStrategy(DiskCacheStrategy.ALL)

                            .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                            .into(Viewholder.image_problem_incorrect);
                }
                catch (Exception e) {

                }
            }
            else {
                Viewholder.txt_status_image.setText(" รูปแก้ไขแล้ว ");
                Viewholder.txt_status_image.setTextColor(0xff75b275);

                String COUNT_IMAGE=getDataAdapter1.getCountImage_R();
                try {
                    int int_count_image= Integer.parseInt(COUNT_IMAGE);
                    if(int_count_image>1){
                        Viewholder.txt_count_image_error.setVisibility(View.VISIBLE);
                        Viewholder.txt_count_image_error.setText("+ "+getDataAdapter1.getCountImage_R());
                    }
                    else {
                        Viewholder.txt_count_image_error.setVisibility(View.GONE);
                    }
                }
                catch (Exception e){

                }
                try {
                    Glide.with(context).load(getDataAdapter1.getImageUrl_R())


                            .crossFade()
                            .thumbnail(0.5f)
                            // .bitmapTransform(new CircleTransform(context))
                            .diskCacheStrategy(DiskCacheStrategy.ALL)

                            .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                            .into(Viewholder.image_problem_incorrect);
                }
                catch (Exception e) {

                }
            }
        }


        else if(WorkCode.equals("90")){
            Viewholder.relat_remove.setVisibility(View.GONE);
            Viewholder.linear_coler.setBackgroundResource(R.color.Red);

            Viewholder.deleteAll.setVisibility(View.VISIBLE);

            Viewholder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
            Viewholder.txt_status_closing.setText("รอดำเนินการ");
            Viewholder.txt_status_closing.setTextColor(0xffA9A9A9);

            Viewholder.txt_status_image.setText(" รูปแก้ไขแล้ว ");
            Viewholder.txt_status_image.setTextColor(0xff75b275);

            if(getDataAdapter1.getImage_Name_R().equals("null")){
                Viewholder.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                Viewholder.txt_status_image.setTextColor(0xfffaebd7);

                String COUNT_IMAGE=getDataAdapter1.getCountImage();
                try {
                    int int_count_image= Integer.parseInt(COUNT_IMAGE);
                    if(int_count_image>1){
                        Viewholder.txt_count_image_error.setVisibility(View.VISIBLE);
                        Viewholder.txt_count_image_error.setText("+ "+getDataAdapter1.getCountImage());
                    }
                    else {
                        Viewholder.txt_count_image_error.setVisibility(View.GONE);
                    }
                }
                catch (Exception e){

                }
                try {
                    Glide.with(context).load(getDataAdapter1.getImageUrl())


                            .crossFade()
                            .thumbnail(0.5f)
                            // .bitmapTransform(new CircleTransform(context))
                            .diskCacheStrategy(DiskCacheStrategy.ALL)

                            .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                            .into(Viewholder.image_problem_incorrect);
                }
                catch (Exception e) {

                }
            }
            else {
                Viewholder.txt_status_image.setText(" รูปแก้ไขแล้ว ");
                Viewholder.txt_status_image.setTextColor(0xff75b275);

                String COUNT_IMAGE=getDataAdapter1.getCountImage_R();
                try {
                    int int_count_image= Integer.parseInt(COUNT_IMAGE);
                    if(int_count_image>1){
                        Viewholder.txt_count_image_error.setVisibility(View.VISIBLE);
                        Viewholder.txt_count_image_error.setText("+ "+getDataAdapter1.getCountImage_R());
                    }
                    else {
                        Viewholder.txt_count_image_error.setVisibility(View.GONE);
                    }
                }
                catch (Exception e){

                }
                try {
                    Glide.with(context).load(getDataAdapter1.getImageUrl_R())


                            .crossFade()
                            .thumbnail(0.5f)
                            // .bitmapTransform(new CircleTransform(context))
                            .diskCacheStrategy(DiskCacheStrategy.ALL)

                            .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                            .into(Viewholder.image_problem_incorrect);
                }
                catch (Exception e) {

                }
            }
        }


        else if(WorkCode.equals("91")){
            image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
            Viewholder.relat_remove.setVisibility(View.GONE);
            Viewholder.linear_coler.setBackgroundResource(R.color.SeaGreen);
            Viewholder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange17);
            Viewholder.txt_status_closing.setText("ปิดงานแล้ว");

            if(getDataAdapter1.getImage_Name_R().equals("null")){
                Viewholder.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                Viewholder.txt_status_image.setTextColor(0xfffaebd7);


                String COUNT_IMAGE=getDataAdapter1.getCountImage();
                try {
                    int int_count_image= Integer.parseInt(COUNT_IMAGE);
                    if(int_count_image>1){
                        Viewholder.txt_count_image_error.setVisibility(View.VISIBLE);
                        Viewholder.txt_count_image_error.setText("+ "+getDataAdapter1.getCountImage());
                    }
                    else {
                        Viewholder.txt_count_image_error.setVisibility(View.GONE);
                    }
                }
                catch (Exception e){

                }

                try {
                    Glide.with(context).load(getDataAdapter1.getImageUrl())


                            .crossFade()
                            .thumbnail(0.5f)
                            // .bitmapTransform(new CircleTransform(context))
                            .diskCacheStrategy(DiskCacheStrategy.ALL)

                            .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                            .into(Viewholder.image_problem_incorrect);
                }
                catch (Exception e) {

                }
            }
            else {
                Viewholder.txt_status_image.setText(" รูปแก้ไขแล้ว ");
                Viewholder.txt_status_image.setTextColor(0xff75b275);

                String COUNT_IMAGE=getDataAdapter1.getCountImage_R();
                try {
                    int int_count_image= Integer.parseInt(COUNT_IMAGE);
                    if(int_count_image>1){
                        Viewholder.txt_count_image_error.setVisibility(View.VISIBLE);
                        Viewholder.txt_count_image_error.setText("+ "+getDataAdapter1.getCountImage_R());
                    }
                    else {
                        Viewholder.txt_count_image_error.setVisibility(View.GONE);
                    }
                }
                catch (Exception e){

                }
                try {
                    Glide.with(context).load(getDataAdapter1.getImageUrl_R())


                            .crossFade()
                            .thumbnail(0.5f)
                            // .bitmapTransform(new CircleTransform(context))
                            .diskCacheStrategy(DiskCacheStrategy.ALL)

                            .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                            .into(Viewholder.image_problem_incorrect);
                }
                catch (Exception e) {

                }
            }
        }


       else if(WorkCode_I.equals("90")){
            Viewholder.txt_status.setText("ยกเลิกรายการ");

            Viewholder.relat_remove.setVisibility(View.GONE);
            Viewholder.linear_coler.setBackgroundResource(R.color.Red);

            Viewholder.deleteAll.setVisibility(View.VISIBLE);

            Viewholder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange25);
            Viewholder.txt_status_closing.setText("เรียบร้อย");
            Viewholder.txt_status_closing.setTextColor(0xffffffff);

            Viewholder.txt_status_image.setText(" รูปแก้ไขแล้ว ");
            Viewholder.txt_status_image.setTextColor(0xff75b275);

            if(getDataAdapter1.getImage_Name_R().equals("null")){
                Viewholder.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                Viewholder.txt_status_image.setTextColor(0xfffaebd7);

                String COUNT_IMAGE=getDataAdapter1.getCountImage();
                try {
                    int int_count_image= Integer.parseInt(COUNT_IMAGE);
                    if(int_count_image>1){
                        Viewholder.txt_count_image_error.setVisibility(View.VISIBLE);
                        Viewholder.txt_count_image_error.setText("+ "+getDataAdapter1.getCountImage());
                    }
                    else {
                        Viewholder.txt_count_image_error.setVisibility(View.GONE);
                    }
                }
                catch (Exception e){

                }
                try {
                    Glide.with(context).load(getDataAdapter1.getImageUrl())


                            .crossFade()
                            .thumbnail(0.5f)
                            // .bitmapTransform(new CircleTransform(context))
                            .diskCacheStrategy(DiskCacheStrategy.ALL)

                            .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                            .into(Viewholder.image_problem_incorrect);
                }
                catch (Exception e) {

                }
            }
            else {
                Viewholder.txt_status_image.setText(" รูปแก้ไขแล้ว ");
                Viewholder.txt_status_image.setTextColor(0xff75b275);

                String COUNT_IMAGE=getDataAdapter1.getCountImage_R();
                try {
                    int int_count_image= Integer.parseInt(COUNT_IMAGE);
                    if(int_count_image>1){
                        Viewholder.txt_count_image_error.setVisibility(View.VISIBLE);
                        Viewholder.txt_count_image_error.setText("+ "+getDataAdapter1.getCountImage_R());
                    }
                    else {
                        Viewholder.txt_count_image_error.setVisibility(View.GONE);
                    }
                }
                catch (Exception e){

                }
                try {
                    Glide.with(context).load(getDataAdapter1.getImageUrl_R())


                            .crossFade()
                            .thumbnail(0.5f)
                            // .bitmapTransform(new CircleTransform(context))
                            .diskCacheStrategy(DiskCacheStrategy.ALL)

                            .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                            .into(Viewholder.image_problem_incorrect);
                }
                catch (Exception e) {

                }
            }
        }
        else {

            Viewholder.relat_remove.setVisibility(View.VISIBLE);
            Viewholder.linear_coler.setBackgroundResource(R.color.Yellow);

            Viewholder.deleteAll.setVisibility(View.VISIBLE);

            Viewholder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
            Viewholder.txt_status_closing.setText("รอดำเนินการ");
            Viewholder.txt_status_closing.setTextColor(0xffA9A9A9);

            Viewholder.txt_status_image.setText(" รูปยังไม่แก้ไข ");
            Viewholder.txt_status_image.setTextColor(0xffB22222);

            if(getDataAdapter1.getImage_Name_R().equals("null")){
                Viewholder.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                Viewholder.txt_status_image.setTextColor(0xfffaebd7);

                String COUNT_IMAGE=getDataAdapter1.getCountImage();
                try {
                    int int_count_image= Integer.parseInt(COUNT_IMAGE);
                    if(int_count_image>1){
                        Viewholder.txt_count_image_error.setVisibility(View.VISIBLE);
                        Viewholder.txt_count_image_error.setText("+ "+getDataAdapter1.getCountImage());
                    }
                    else {
                        Viewholder.txt_count_image_error.setVisibility(View.GONE);
                    }
                }
                catch (Exception e){

                }
                try {
                    Glide.with(context).load(getDataAdapter1.getImageUrl())


                            .crossFade()
                            .thumbnail(0.5f)
                            // .bitmapTransform(new CircleTransform(context))
                            .diskCacheStrategy(DiskCacheStrategy.ALL)

                            .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                            .into(Viewholder.image_problem_incorrect);
                }
                catch (Exception e) {

                }
            }
            else {
                Viewholder.txt_status_image.setText(" รูปแก้ไขแล้ว ");
                Viewholder.txt_status_image.setTextColor(0xff75b275);

                String COUNT_IMAGE=getDataAdapter1.getCountImage_R();
                try {
                    int int_count_image= Integer.parseInt(COUNT_IMAGE);
                    if(int_count_image>1){
                        Viewholder.txt_count_image_error.setVisibility(View.VISIBLE);
                        Viewholder.txt_count_image_error.setText("+ "+getDataAdapter1.getCountImage_R());
                    }
                    else {
                        Viewholder.txt_count_image_error.setVisibility(View.GONE);
                    }
                }
                catch (Exception e){

                }
                try {
                    Glide.with(context).load(getDataAdapter1.getImageUrl_R())


                            .crossFade()
                            .thumbnail(0.5f)
                            // .bitmapTransform(new CircleTransform(context))
                            .diskCacheStrategy(DiskCacheStrategy.ALL)

                            .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                            .into(Viewholder.image_problem_incorrect);
                }
                catch (Exception e) {

                }
            }
        }












        try {
            String date=getDataAdapter1.getDate_create();
            SimpleDateFormat input22 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat output22 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat output33 = new SimpleDateFormat("HH:mm:ss");
            try {
                oneWayTripDate = input22.parse(date);  // parse input

            } catch (ParseException e) {
                e.printStackTrace();
            }


            date_new_format_thai=output22.format(oneWayTripDate);
            date_new_format_thai2=output33.format(oneWayTripDate);

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


                String fff= Utils.getSystemDateTextMonth();


                if(fff.indexOf(fff) != -1) {
                    String arr[] = fff.split("-");
                    s1=arr[0];
                    s2=arr[1];
                    s3=arr[2];
                }

                Log.e("s123",s1+s2+s3);
                if((dateThai_day.equals(s1))&(dateThai_month.equals(s2))&(dateThai_year.equals(s3))){
                    Viewholder.txt_datetime.setText(date_new_format_thai2);
                    //Viewholder.icon_time.setBackgroundResource(R.drawable.ic_access_time_black_24dp);
                    //Log.e("TIME",date_new_format_thai2);
                }
                else {
                    Viewholder.txt_datetime.setText(dateThai_day+" "+dateThai_month1+converted_dateThai11);
                    //  Viewholder.icon_time.setBackgroundResource(0);
                    // Log.e("dateThai",dateThai_day+""+dateThai_month1+""+converted_dateThai11+"");
                }


            }
        }
        catch (Exception ex){

        }




        adapter3 = new RecyclerViewDataAdapter3(context, allSampleData, imageBeforeList);
        my_recycler_view2.setAdapter(adapter3);
        adapter3.notifyDataSetChanged();


        adapter4 = new RecyclerViewDataAdapter4(context, allSampleData2, imageAfterList);
        my_recycler_view.setAdapter(adapter4);
        adapter4.notifyDataSetChanged();
















        // initUI();


        Viewholder.feed = getDataAdapter1;

    }

    @Override
    public int getItemCount() {

        return getDataAdapter.size();
    }


    @Override
    public Filter getFilter() {
        if(userFilter!=null){
            userFilter=new RecyclerViewAdapter_credit_recive_problem_before_edit2.UserFilter(this,getDataAdapter);
        }

        return userFilter;

    }





    private itemclick ic;
    public void setitemclick(itemclick ic){
        this.ic=ic;
    }
    public interface itemclick{
        void click(View v, int position);
    }


    private itemclick2 ic2;
    public void setitemclick2(itemclick2 ic2){
        this.ic2=ic2;
    }
    public interface itemclick2{


        void click2(View v, int position);
    }


    private itemclick_list_item_status_sale ic_list_item_status_sale;
    public void setitemclick_list_item_status_sale(itemclick_list_item_status_sale ic_list_item_status_sale){
        this.ic_list_item_status_sale=ic_list_item_status_sale;
    }
    public interface itemclick_list_item_status_sale{


        void click_list_item_status_sale(View v, int position);
    }



    private itemclick_comment ic_comment;
    public void setitemclick_comment(itemclick_comment ic_comment){
        this.ic_comment=ic_comment;
    }
    public interface itemclick_comment{


        void click_comment(View v, int position);
    }


    private itemclick_relat_remove ic_relat_remove;
    public void setitemclick_relat_remove(itemclick_relat_remove ic_relat_remove){
        this.ic_relat_remove=ic_relat_remove;
    }
    public interface itemclick_relat_remove{


        void click_relat_remove(View v, int position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener,View.OnClickListener  {

        public TextView InformID;
        public TextView contno;
        public TextView txt_category;
        public TextView txt_main_problem;
        public TextView txt_sub_problem;
        public TextView txt_topic;

        public TextView new_message,new_message2;
        public ImageView image_problem_incorrect;
        public TextView  txt_count_image_error;
        public  TextView txt_status;
        public LinearLayout linear_coler;
        public RelativeLayout deleteAll;
        public  TextView txt_datetime;

        public   ImageView image_status_sent_from_cedit;
        public   LinearLayout linear_down_sent_from_cedit;

        public LinearLayout linear_status_closing;
        public  TextView txt_status_closing;
        public  TextView txt_status_image;

        public LinearLayout linear_Informitem,linear_sale3_main;
        public  TextView txt_Informitem;
        public RelativeLayout relat_remove;

        public ImageView list_item_home_dislike;
        public ImageView list_item_home_menu;
        public ImageView list_item_home_foxy_img;
        public  TextView list_item_home_posted_name;
        public  TextView list_item_home_posted_txt;
        public  TextView txt_comment;
        public ImageView list_item_status_sale;

        public  TextView new_message_main;
        public  TextView new_message_main3;

        protected  TextView txt_customer;
        protected  TextView txt_tel,txt_tel2;
        protected  TextView txt_address,txt_effdate;

        public GetData_cedit_sale_edit_problem feed;
        public ViewHolder(View itemView) {

            super(itemView);
            InformID = (TextView) itemView.findViewById(id.InformID) ;
            contno = (TextView) itemView.findViewById(id.contno) ;

            txt_category = (TextView) itemView.findViewById(id.txt_category) ;
            txt_main_problem = (TextView) itemView.findViewById(id.txt_main_problem) ;
            txt_sub_problem = (TextView) itemView.findViewById(id.txt_sub_problem) ;
            txt_topic = (TextView) itemView.findViewById(id.txt_topic) ;
            new_message= (TextView) itemView.findViewById(id.new_message) ;
            new_message2= (TextView) itemView.findViewById(id.new_message2) ;
            image_problem_incorrect= (ImageView) itemView.findViewById(id.image_problem_incorrect) ;
            txt_count_image_error= (TextView) itemView.findViewById(id.txt_count_image_error) ;
            txt_status= (TextView) itemView.findViewById(id.txt_status) ;
            linear_coler= (LinearLayout) itemView.findViewById(id.linear_coler) ;
            deleteAll= (RelativeLayout) itemView.findViewById(id.deleteAll) ;
            image_status_sent_from_cedit= (ImageView) itemView.findViewById(id.image_status) ;
            linear_down_sent_from_cedit= (LinearLayout) itemView.findViewById(id.linear_down) ;
            my_recycler_view2 = (RecyclerView) itemView.findViewById(R.id.my_recycler_view2);
            my_recycler_view = (RecyclerView) itemView.findViewById(R.id.my_recycler_view);

            txt_datetime= (TextView) itemView.findViewById(id.txt_datetime) ;

            linear_status_closing= (LinearLayout) itemView.findViewById(id.linear_status_closing) ;
            txt_status_closing= (TextView) itemView.findViewById(id.txt_status_closing) ;
            txt_status_image= (TextView) itemView.findViewById(id.txt_status_image) ;

            linear_Informitem= (LinearLayout) itemView.findViewById(id.linear_Informitem) ;
            txt_Informitem= (TextView) itemView.findViewById(id.txt_Informitem) ;
            relat_remove= (RelativeLayout) itemView.findViewById(id.relat_remove) ;

            list_item_home_foxy_img= (ImageView) itemView.findViewById(id.list_item_home_foxy_img);
            list_item_home_dislike= (ImageView) itemView.findViewById(id.list_item_home_dislike);
            list_item_home_menu= (ImageView) itemView.findViewById(id.list_item_home_menu);
            list_item_home_posted_name= (TextView) itemView.findViewById(id.list_item_home_posted_name) ;
            list_item_home_posted_txt= (TextView) itemView.findViewById(id.list_item_home_posted_txt) ;
            txt_comment= (TextView) itemView.findViewById(id.txt_comment) ;
            list_item_status_sale= (ImageView) itemView.findViewById(id.list_item_status_sale);
            new_message_main= (TextView) itemView.findViewById(id.new_message_main) ;

            linear_sale3_main= (LinearLayout) itemView.findViewById(id.linear_sale3_main) ;
            new_message_main3= (TextView) itemView.findViewById(id.new_message_main3) ;
            image_status_sent_from_cedit.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);


            txt_customer = (TextView) itemView.findViewById(R.id.txt_customer) ;
            txt_tel = (TextView) itemView.findViewById(R.id.txt_tel) ;
            txt_tel2= (TextView) itemView.findViewById(R.id.txt_tel2) ;
            txt_address = (TextView) itemView.findViewById(R.id.txt_address) ;
            txt_effdate = (TextView) itemView.findViewById(R.id.txt_effdate) ;

            itemView.setOnLongClickListener(this);
            relat_remove.setOnLongClickListener(this);
            relat_remove.setOnClickListener(this);
            itemView.setOnClickListener(this);
            list_item_status_sale.setOnClickListener(this);
            txt_comment.setOnClickListener(this);
           // relat_remove.setVisibility(View.GONE);
            /**/

            allSampleData = new ArrayList<SectionDataModel>();
            singleItem = new ArrayList<SingleItemModel>();

            allSampleData2 = new ArrayList<SectionDataModel2>();
            singleItem2 = new ArrayList<SingleItemModel2>();


            my_recycler_view2.setHasFixedSize(true);
            my_recycler_view2.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));



            my_recycler_view.setHasFixedSize(true);
            my_recycler_view.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));


        }



        @Override
        public void onClick(View view) {


            if(view==list_item_status_sale){
                try {
                    if(ic_list_item_status_sale!=null){
                        ic_list_item_status_sale.click_list_item_status_sale(list_item_status_sale,getPosition());
                    }
                }


                catch (Exception e) {

                    e.printStackTrace();
                }
            }
           else if(view==txt_comment){
                try {
                    if(ic_comment!=null){
                        ic_comment.click_comment(txt_comment,getPosition());
                    }
                }


                catch (Exception e) {

                    e.printStackTrace();
                }
            }

            else if(view==relat_remove){
                try {
                    if(ic_relat_remove!=null){
                        ic_relat_remove.click_relat_remove(relat_remove,getPosition());
                    }
                }


                catch (Exception e) {

                    e.printStackTrace();
                }
            }

            else {
                try {
                    if(ic2!=null){
                        ic2.click2(itemView,getPosition());
                    }
                }


                catch (Exception e) {

                    e.printStackTrace();
                }
            }

        }

        @Override
        public boolean onLongClick(View view) {
            try {
                if (ic != null) {
                    ic.click(itemView, getPosition());
                }
            }
            catch (Exception e) {

                e.printStackTrace();
            }



            return true;
        }
    }



    private static class UserFilter extends Filter {

        private final RecyclerViewAdapter_credit_recive_problem_before_edit2 adapter;

        private final List<GetData_cedit_sale_edit_problem> originalList;

        private final List<GetData_cedit_sale_edit_problem> filteredList;

        private UserFilter(RecyclerViewAdapter_credit_recive_problem_before_edit2 adapter, List<GetData_cedit_sale_edit_problem> originalList) {
            super();
            this.adapter = adapter;
            this.originalList = new LinkedList<>(originalList);
            this.filteredList = new ArrayList<>();
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            filteredList.clear();
            final FilterResults results = new FilterResults();

            if (constraint.length() == 0) {
                filteredList.addAll(originalList);
            } else {
                for (final GetData_cedit_sale_edit_problem user : originalList) {

                    //if ((user.getContract_number().toUpperCase()).contains(constraint.toString().toUpperCase()) ||
                    //         (user.getnamethai().toUpperCase()).contains(constraint.toString().toUpperCase()) ){
                    //    filteredList.add(user);
                    // }



                }
            }

            results.values = filteredList;
            results.count = filteredList.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            if (results.count == 0){
                adapter.getDataAdapter.clear();
                adapter.notifyDataSetChanged();
            } else {
                adapter.getDataAdapter.clear();
                adapter.getDataAdapter.addAll((ArrayList<GetData_cedit_sale_edit_problem>) results.values);
                adapter.notifyDataSetChanged();
            }
        }
    }


}
