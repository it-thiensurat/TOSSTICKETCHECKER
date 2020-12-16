package com.tsr.tsrproblemreport_tossticket_checker.test.adapters;

/**
 * Created by pratap.kesaboyina on 24-12-2014.
 */

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.CircleTransform;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.Utils;
import com.tsr.tsrproblemreport_tossticket_checker.test.models.GetData_cedit_sale_edit_problem;
import com.tsr.tsrproblemreport_tossticket_checker.test.models.SectionDataModel;
import com.tsr.tsrproblemreport_tossticket_checker.test.models.SectionDataModel2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class RecyclerViewDataAdapter2 extends RecyclerView.Adapter<RecyclerViewDataAdapter2.ItemRowHolder> implements Filterable {

    private ArrayList<SectionDataModel> dataList;
    private ArrayList<SectionDataModel2> dataList2;
    List<GetData_cedit_sale_edit_problem> getDataAdapter;
    GetData_cedit_sale_edit_problem getDataAdapter1;
    private Context context;


  //  public  static LinearLayout linear_down;
   // public  static ImageView image_status;
    public RecyclerView my_recycler_view2,my_recycler_view;
    String date_new_format_thai,date_new_format_thai2;
    String dateThai_year,dateThai_month,dateThai_day,dateThai_month1;
    int converted_dateThai11;
    private Date oneWayTripDate;
    String s1,s2,s3;
    private int layout1 = 100;
    private int layout2 = 101;

    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;


    private UserFilter userFilter;

    public RecyclerViewDataAdapter2(List<GetData_cedit_sale_edit_problem> getDataAdapter, Context context, ArrayList<SectionDataModel> dataList, ArrayList<SectionDataModel2> dataList2) {
        super();
        this.dataList = dataList;
        this.dataList2 = dataList2;
        this.context = context;
        this.getDataAdapter = getDataAdapter;
        userFilter = new UserFilter(RecyclerViewDataAdapter2.this,getDataAdapter);
    }


    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item3, null);
        ItemRowHolder mh = new ItemRowHolder(v);
        return mh;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ItemRowHolder Viewholder, int i) {






                try {
                    getDataAdapter1 =  getDataAdapter.get(i);
                }
                catch (Exception ex){

                }


        final String sectionName = dataList.get(i).getHeaderTitle();

        ArrayList singleSectionItems = dataList.get(i).getAllItemsInSection();


        final String sectionName2 = dataList2.get(i).getHeaderTitle();

        ArrayList singleSectionItems2 = dataList2.get(i).getAllItemsInSection();

        Viewholder.itemTitle.setText(sectionName);
        Viewholder.itemTitle2.setText(sectionName);

        SectionListDataAdapter itemListDataAdapter = new SectionListDataAdapter(context, singleSectionItems);
        SectionListDataAdapter2 itemListDataAdapter2 = new SectionListDataAdapter2(context, singleSectionItems2);

        Viewholder.recycler_view_list.setHasFixedSize(true);
        Viewholder.recycler_view_list.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        Viewholder.recycler_view_list.setAdapter(itemListDataAdapter);
        Viewholder.recycler_view_list.setNestedScrollingEnabled(false);




        Viewholder.recycler_view_list2.setHasFixedSize(true);
        Viewholder.recycler_view_list2.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        Viewholder.recycler_view_list2.setAdapter(itemListDataAdapter2);
        Viewholder.recycler_view_list2.setNestedScrollingEnabled(false);

/*        Viewholder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(v.getContext(), "click event on more, "+sectionName , Toast.LENGTH_SHORT).show();



            }
        });*/



































        try {
            try {
                Viewholder.InformID.setText(getDataAdapter1.getInformID()+"");
                Viewholder.contno.setText(getDataAdapter1.getContno()+"");
                Viewholder.txt_category.setText(getDataAdapter1.getGory()+"");
                Viewholder.txt_main_problem.setText(getDataAdapter1.getMain()+"");
                Viewholder.txt_sub_problem.setText(getDataAdapter1.getTopic_problem()+"");
                //Viewholder.txt_topic.setText(getDataAdapter1.getTopic_problem());

                String DD=getDataAdapter1.getProblemDetail()+"";
                if(DD.equals("null")){
                    Viewholder.new_message.setVisibility(View.GONE);
                }
                else {
                    Viewholder.new_message.setVisibility(View.VISIBLE);
                    Viewholder.new_message.setText(getDataAdapter1.getProblemDetail()+"");
                }



                Viewholder.new_message2.setText(getDataAdapter1.getProblemDetail2()+"");
                Viewholder.new_message3.setText(getDataAdapter1.getProblemDetail3()+"");
                Viewholder.new_message4.setText(getDataAdapter1.getProblemDetail4()+"");

                Viewholder.txt_customer.setText(getDataAdapter1.getCustomer()+"");
                Viewholder.txt_address.setText(getDataAdapter1.getAddress()+"");


                Viewholder.txt_effdate.setText(getDataAdapter1.getEffDate()+"");



            }
            catch (Exception EX){

            }


            try {
                String COUNT_IMAGE=getDataAdapter1.getImageUrl()+"";
                String COUNT_IMAGE2=getDataAdapter1.getImageUrl_R()+"";



                if(COUNT_IMAGE.equals("null")){
                    Viewholder.linear_head_image1.setVisibility(View.GONE);
                }
                else {
                    Viewholder.linear_head_image1.setVisibility(View.VISIBLE);
                }


                if(COUNT_IMAGE2.equals("null")){
                    Viewholder.linear_head_image2.setVisibility(View.GONE);
                }
                else {
                    Viewholder.linear_head_image2.setVisibility(View.VISIBLE);
                }

            }
            catch (Exception ex){

            }

            try {
                String ProblemDetail3 =getDataAdapter1.getProblemDetail3()+"";
                String ProblemDetail4 =getDataAdapter1.getProblemDetail4()+"";

                if ((ProblemDetail3.equals("null"))|(ProblemDetail3.isEmpty())){
                    Viewholder.linear_sale3.setVisibility(View.GONE);
                }
                else {
                    Viewholder.linear_sale3.setVisibility(View.VISIBLE);
                }

                if ((ProblemDetail4.equals("null"))|(ProblemDetail4.isEmpty())){
                    Viewholder.linear_sale4.setVisibility(View.GONE);
                }
                else {
                    Viewholder.linear_sale4.setVisibility(View.VISIBLE);
                }
            }
            catch (Exception EX){

            }





            try {
                if ((!getDataAdapter1.getImage_Name().equals("null")) &(!getDataAdapter1.getImage_Name_R().equals("null")))  {
                    Viewholder.linear_image.setVisibility(View.VISIBLE);
                } else if ((!getDataAdapter1.getImage_Name().equals("null")) &(getDataAdapter1.getImage_Name_R().equals("null"))) {
                    Viewholder.linear_image.setVisibility(View.VISIBLE);
                } else if ((getDataAdapter1.getImage_Name().equals("null")) &(!getDataAdapter1.getImage_Name_R().equals("null")))  {
                    Viewholder.linear_image.setVisibility(View.VISIBLE);
                } else if ((getDataAdapter1.getImage_Name().equals("null")) &(getDataAdapter1.getImage_Name_R().equals("null")))  {
                    Viewholder.linear_image.setVisibility(View.GONE);
                }else  {
                    Viewholder.linear_image.setVisibility(View.GONE);
                }
            }
            catch (Exception e) {
                //    Viewholder.linear_image.setVisibility(View.GONE);
            }



            try {
                Log.e("getInformitem",getDataAdapter1.getInformitem());
                if (!getDataAdapter1.getInformitem().equals("")) {
                    Viewholder.linear_Informitem.setVisibility(View.VISIBLE);
                    Viewholder.txt_Informitem.setText(getDataAdapter1.getInformitem());
                } else  {
                    Viewholder.linear_Informitem.setVisibility(View.GONE);
                }
            }
            catch (Exception e) {
                //    Viewholder.linear_image.setVisibility(View.GONE);
            }


            try {
                String CancelNote =getDataAdapter1.getCancelNote()+"";
                if((CancelNote.equals("null"))|(CancelNote.isEmpty())){
                    Viewholder.linear_sale3_main.setVisibility(View.GONE);
                }
                else {
                    Viewholder.linear_sale3_main.setVisibility(View.VISIBLE);
                    Viewholder.new_message_main3.setText(getDataAdapter1.getCancelNote());
                }
            }
            catch (Exception x){

            }



            try {
                if(getDataAdapter1.getTopic_problem().equals("null")){
                    Viewholder.txt_topic.setText("ปัญหาอื่นๆ");
                }
                else {
                    Viewholder.txt_topic.setText("-");

                }
            }
            catch (Exception EX){

            }





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

            try {
                Viewholder.list_item_home_posted_name.setText(getDataAdapter1.getEmployeeName()+"");
                Viewholder.list_item_home_posted_txt.setText(getDataAdapter1.getPositionName()+"");

            }
            catch ( Exception ex){

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
                String WorkCode=getDataAdapter1.getWorkCode()+"";
                String WorkName=getDataAdapter1.getWorkName()+"";
                if(WorkName.equals("null")){
                    Viewholder.txt_status.setText("อยู่ระหว่างการตรวจสอบ");
                    Viewholder.deleteAll.setVisibility(View.VISIBLE);

                    Viewholder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
                    Viewholder.txt_status_closing.setText("รอดำเนินการ");
                    Viewholder.txt_status_closing.setTextColor(0xffA9A9A9);

                }
                else {
                    Viewholder.txt_status.setText(WorkName);
                    Viewholder.deleteAll.setVisibility(View.VISIBLE);

                    Viewholder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
                    Viewholder.txt_status_closing.setText("รอดำเนินการ");
                }
            }
            catch (Exception ex){

            }












            try {
                String WorkCode=getDataAdapter1.getWorkCode()+"";
                String WorkName=getDataAdapter1.getWorkName()+"";
                if(WorkCode.equals("00")){
                    Viewholder. image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
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
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                                .into(Viewholder.image_problem_incorrect);
                    }
                    catch (Exception e) {

                    }
                }
                else if(WorkCode.equals("10")){
                    Viewholder. image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    Viewholder.linear_coler.setBackgroundResource(R.color.colorPrimary);
                    Viewholder.deleteAll.setVisibility(View.VISIBLE);

                    Viewholder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange17);
                    Viewholder.txt_status_closing.setText("ปิดงานแล้ว");
                    Viewholder.txt_status_closing.setTextColor(0xffffffff);
                    if(getDataAdapter1.getImage_Name_R().equals("null")){
                        Viewholder.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                        Viewholder.txt_status_image.setTextColor(0xfffaebd7);

                        String COUNT_IMAGE=getDataAdapter1.getCountImage()+"";
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

                        String COUNT_IMAGE=getDataAdapter1.getCountImage_R()+"";
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
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                                    .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                                    .into(Viewholder.image_problem_incorrect);
                        }
                        catch (Exception e) {

                        }
                    }
                }
                else if(WorkCode.equals("21")){
                    Viewholder.image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    Viewholder.linear_coler.setBackgroundResource(R.color.MediumTurquoise);
                    Viewholder.deleteAll.setVisibility(View.VISIBLE);

                    Viewholder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
                    Viewholder.txt_status_closing.setText("รอดำเนินการ");
                    Viewholder.txt_status_closing.setTextColor(0xffA9A9A9);

                    Viewholder.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                    Viewholder.txt_status_image.setTextColor(0xfffaebd7);


                    try {
                        Glide.with(context).load(getDataAdapter1.getImageUrl())
                                .crossFade()
                                .thumbnail(0.5f)
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                                .into(Viewholder.image_problem_incorrect);
                    }
                    catch (Exception e) {

                    }
                }
                else if(WorkCode.equals("22")){
                    Viewholder.image_status.setBackgroundResource(R.drawable.icon_modify);
                    Viewholder.linear_coler.setBackgroundResource(R.color.Red);
                    Viewholder.deleteAll.setVisibility(View.VISIBLE);

                    Viewholder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
                    Viewholder.txt_status_closing.setText("รอดำเนินการ");
                    Viewholder.txt_status_closing.setTextColor(0xffA9A9A9);


                    if(getDataAdapter1.getImage_Name_R().equals("null")){
                        Viewholder.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                        Viewholder.txt_status_image.setTextColor(0xfffaebd7);


                        String COUNT_IMAGE=getDataAdapter1.getCountImage()+"";
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

                        String COUNT_IMAGE=getDataAdapter1.getCountImage_R()+"";
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
                    Viewholder.image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    Viewholder.linear_coler.setBackgroundResource(R.color.RoyalBlue);
                    Viewholder.deleteAll.setVisibility(View.VISIBLE);

                    Viewholder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
                    Viewholder.txt_status_closing.setText("รอดำเนินการ");
                    Viewholder.txt_status_closing.setTextColor(0xffA9A9A9);

                    if(getDataAdapter1.getImage_Name_R().equals("null")){
                        Viewholder.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                        Viewholder.txt_status_image.setTextColor(0xfffaebd7);


                        String COUNT_IMAGE=getDataAdapter1.getCountImage()+"";
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

                        String COUNT_IMAGE=getDataAdapter1.getCountImage_R()+"";
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
                    Viewholder.image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    Viewholder.linear_coler.setBackgroundResource(R.color.Blue);
                    Viewholder.deleteAll.setVisibility(View.VISIBLE);

                    Viewholder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
                    Viewholder.txt_status_closing.setText("รอดำเนินการ");
                    Viewholder.txt_status_closing.setTextColor(0xffA9A9A9);

                    if(getDataAdapter1.getImage_Name_R().equals("null")){
                        Viewholder.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                        Viewholder.txt_status_image.setTextColor(0xfffaebd7);


                        String COUNT_IMAGE=getDataAdapter1.getCountImage()+"";
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

                        String COUNT_IMAGE=getDataAdapter1.getCountImage_R()+"";
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

                            Log.e("trtrtr",getDataAdapter1.getImageUrl_R());
                            Glide.with(context).load(getDataAdapter1.getImageUrl_R())


                                    .crossFade()
                                    .thumbnail(0.5f)
                                    // .bitmapTransform(new CircleTransform(context))
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                                  //  .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                                    .into(Viewholder.image_problem_incorrect);
                        }
                        catch (Exception e) {

                        }
                    }
                }
                else if(WorkCode.equals("25")){
                    Viewholder.image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    Viewholder.linear_coler.setBackgroundResource(R.color.DarkBlue);
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

                        String COUNT_IMAGE=getDataAdapter1.getCountImage_R()+"";
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
                    Viewholder.image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    Viewholder.linear_coler.setBackgroundResource(R.color.Purple);
                    Viewholder.deleteAll.setVisibility(View.VISIBLE);

                    Viewholder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
                    Viewholder.txt_status_closing.setText("รอดำเนินการ");
                    Viewholder.txt_status_closing.setTextColor(0xffA9A9A9);

                    if(getDataAdapter1.getImage_Name_R().equals("null")){
                        Viewholder.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                        Viewholder.txt_status_image.setTextColor(0xfffaebd7);


                        String COUNT_IMAGE=getDataAdapter1.getCountImage()+"";
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
                    Viewholder.image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    Viewholder.linear_coler.setBackgroundResource(R.color.SeaGreen);
                    Viewholder.deleteAll.setVisibility(View.VISIBLE);

                    Viewholder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange17);
                    Viewholder.txt_status_closing.setText("เรียบร้อย");
                    Viewholder.txt_status_closing.setTextColor(0xffffffff);
                    if(getDataAdapter1.getImage_Name_R().equals("null")){
                        Viewholder.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                        Viewholder.txt_status_image.setTextColor(0xfffaebd7);

                        String COUNT_IMAGE=getDataAdapter1.getCountImage()+"";
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

                        String COUNT_IMAGE=getDataAdapter1.getCountImage_R()+"";
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
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                                    .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                                    .into(Viewholder.image_problem_incorrect);
                        }
                        catch (Exception e) {

                        }
                    }
                }


                else if(WorkCode.equals("91")){
                    Viewholder.image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);

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

                else {
                    Viewholder.image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);

                    Viewholder.linear_coler.setBackgroundResource(R.color.Yellow);
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
                            Glide.with(context).load(getDataAdapter1.getImageUrl()+"")


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

                        String COUNT_IMAGE=getDataAdapter1.getCountImage_R()+"";
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

            }
            catch (Exception ex){

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
                    Viewholder.txt_date_create.setText(getDataAdapter1.getDate_Assing());


                }
            }
            catch (Exception ex){

            }

            try {
                Glide.with(context).load("http://app.thiensurat.co.th/assanee/upload/iconprofile/picture1.png")
                        .crossFade()
                        .thumbnail(0.5f)
                        .bitmapTransform(new CircleTransform(context))
                        .diskCacheStrategy(DiskCacheStrategy.NONE)

                        .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                        .into(Viewholder.list_item_home_foxy_img);
            }
            catch (Exception e) {

            }
        }
        catch (AndroidRuntimeException f){

        }






        try {
            DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
            String date_now = df2.format(Calendar.getInstance().getTime());

            String arr2[] = getDataAdapter1.getEffDate().split("/");
            String date_day=arr2[0];
            String date_month=arr2[1];
            String date_year=arr2[2];

            String date_install=date_year+"-"+date_month+"-"+date_day;

            getCountOfDays(date_now,date_install);

            if((int) dayCount>30){
                //Viewholder.li_tel.setVisibility(View.GONE);
                Viewholder.txt_tel.setText("เกิน 30 วัน");
                Viewholder.txt_tel2.setText("เกิน 30 วัน");

            }
            else {
               // Viewholder.li_tel.setVisibility(View.VISIBLE);

                try {
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
                catch (Exception ex){

                }


            }

        }
        catch (Exception ex){

        }






    }

    float dayCount;
    public String getCountOfDays(String createdDateString, String expireDateString) {



        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

        Date createdConvertedDate = null, expireCovertedDate = null, todayWithZeroTime = null;
        try {
            createdConvertedDate = dateFormat.parse(createdDateString);
            expireCovertedDate = dateFormat.parse(expireDateString);

            Date today = new Date();

            todayWithZeroTime = dateFormat.parse(dateFormat.format(today));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int cYear = 0, cMonth = 0, cDay = 0;

        if (createdConvertedDate.after(todayWithZeroTime)) {
            Calendar cCal = Calendar.getInstance();
            cCal.setTime(createdConvertedDate);
            cYear = cCal.get(Calendar.YEAR);
            cMonth = cCal.get(Calendar.MONTH);
            cDay = cCal.get(Calendar.DAY_OF_MONTH);

        } else {
            Calendar cCal = Calendar.getInstance();
            cCal.setTime(todayWithZeroTime);
            cYear = cCal.get(Calendar.YEAR);
            cMonth = cCal.get(Calendar.MONTH);
            cDay = cCal.get(Calendar.DAY_OF_MONTH);
        }



        Calendar eCal = Calendar.getInstance();
        eCal.setTime(expireCovertedDate);

        int eYear = eCal.get(Calendar.YEAR);
        int eMonth = eCal.get(Calendar.MONTH);
        int eDay = eCal.get(Calendar.DAY_OF_MONTH);

        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();

        date1.clear();
        date1.set(cYear, cMonth, cDay);
        date2.clear();
        date2.set(eYear, eMonth, eDay);

        long diff = date2.getTimeInMillis() - date1.getTimeInMillis();

        dayCount = 0-((float) diff / (24 * 60 * 60 * 1000));
        Log.e("dayCount", String.valueOf((int) dayCount));




        return ("" + (int) dayCount + " Days");
    }


    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() : 0);
    }


    @Override
    public int getItemViewType(int position) {
        return dataList.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }

    @Override
    public Filter getFilter() {
        if(userFilter!=null){
            userFilter=new RecyclerViewDataAdapter2.UserFilter(this,getDataAdapter);
        }
        return userFilter;
    }

    private class LoadingViewHolder extends RecyclerView.ViewHolder {

        ProgressBar progressBar;

        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progressBar);
        }
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


    private itemclick_txt_comment ic_txt_comment;
    public void setitemclick_txt_comment(itemclick_txt_comment ic_txt_comment){
        this.ic_txt_comment=ic_txt_comment;
    }
    public interface itemclick_txt_comment{


        void click_txt_comment(View v, int position);
    }


    private itemclick_list_item_history ic_list_item_history;
    public void setitemclick_list_item_history(itemclick_list_item_history ic_list_item_history){
        this.ic_list_item_history=ic_list_item_history;
    }
    public interface itemclick_list_item_history{


        void click_list_item_history(View v, int position);
    }


    public class ItemRowHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener,View.OnClickListener  {

        protected TextView itemTitle;

        protected RecyclerView recycler_view_list;

        protected Button btnMore;



        protected TextView itemTitle2;

        protected RecyclerView recycler_view_list2;

        protected Button btnMore2;






        protected TextView InformID;
        protected TextView contno;
        protected TextView txt_category;
        protected TextView txt_main_problem;
        protected TextView txt_sub_problem;
        protected TextView txt_topic;
        protected TextView new_message,new_message2,new_message3,new_message4;
        protected ImageView image_problem_incorrect;
        protected TextView  txt_count_image_error;
        protected  TextView txt_status;
        protected LinearLayout linear_coler;
        protected RelativeLayout deleteAll,relat_remove;
        protected LinearLayout linear_status_closing,linear_sale3_main,linear_Informitem,linear_image,linear_sale3,linear_sale4;
        protected  TextView txt_status_closing;
        protected  TextView txt_datetime,txt_date_create;
        protected  TextView txt_status_image;
        protected ImageView list_item_home_dislike;
        protected ImageView list_item_home_menu;
        protected ImageView list_item_home_foxy_img;
        protected ImageView list_item_history;
        protected  TextView list_item_home_posted_name;
        protected  TextView list_item_home_posted_txt;
        protected  TextView txt_comment;
        protected ImageView list_item_status_sale;
        protected  TextView new_message_main;
        protected  TextView new_message_main3;
        protected  TextView txt_Informitem;

        protected LinearLayout linear_head_image1,linear_head_image2,linear_down,li_tel;

        protected  TextView txt_customer;
        protected  TextView txt_tel,txt_tel2;
        protected  TextView txt_address,txt_effdate;

        protected ImageView image_status;

        public ItemRowHolder(View view) {
            super(view);

            this.itemTitle = (TextView) view.findViewById(R.id.itemTitle);
            this.recycler_view_list = (RecyclerView) view.findViewById(R.id.recycler_view_list);
            this.btnMore= (Button) view.findViewById(R.id.btnMore);



            this.itemTitle2 = (TextView) view.findViewById(R.id.itemTitle2);
            this.recycler_view_list2 = (RecyclerView) view.findViewById(R.id.recycler_view_list2);
            this.btnMore2= (Button) view.findViewById(R.id.btnMore2);



            InformID = (TextView) itemView.findViewById(R.id.InformID) ;
            contno = (TextView) itemView.findViewById(R.id.contno) ;

            txt_category = (TextView) itemView.findViewById(R.id.txt_category) ;
            txt_main_problem = (TextView) itemView.findViewById(R.id.txt_main_problem) ;
            txt_sub_problem = (TextView) itemView.findViewById(R.id.txt_sub_problem) ;
            txt_topic = (TextView) itemView.findViewById(R.id.txt_topic) ;
            new_message= (TextView) itemView.findViewById(R.id.new_message) ;
            new_message2= (TextView) itemView.findViewById(R.id.new_message2) ;
            new_message3= (TextView) itemView.findViewById(R.id.new_message3) ;
            new_message4= (TextView) itemView.findViewById(R.id.new_message4) ;
            image_problem_incorrect= (ImageView) itemView.findViewById(R.id.image_problem_incorrect) ;
            txt_count_image_error= (TextView) itemView.findViewById(R.id.txt_count_image_error) ;
            txt_status= (TextView) itemView.findViewById(R.id.txt_status) ;
            linear_coler= (LinearLayout) itemView.findViewById(R.id.linear_coler) ;
            linear_sale3= (LinearLayout) itemView.findViewById(R.id.linear_sale3) ;
            linear_sale4= (LinearLayout) itemView.findViewById(R.id.linear_sale4) ;
            deleteAll= (RelativeLayout) itemView.findViewById(R.id.deleteAll) ;
            relat_remove= (RelativeLayout) itemView.findViewById(R.id.relat_remove) ;

            my_recycler_view2 = (RecyclerView) itemView.findViewById(R.id.my_recycler_view2);
            my_recycler_view = (RecyclerView) itemView.findViewById(R.id.my_recycler_view);
            image_status= (ImageView) itemView.findViewById(R.id.image_status) ;
            linear_down= (LinearLayout) itemView.findViewById(R.id.linear_down) ;

            linear_status_closing= (LinearLayout) itemView.findViewById(R.id.linear_status_closing) ;
            txt_status_closing= (TextView) itemView.findViewById(R.id.txt_status_closing) ;
            txt_date_create= (TextView) itemView.findViewById(R.id.txt_date_create) ;

            txt_datetime= (TextView) itemView.findViewById(R.id.txt_datetime) ;
            txt_status_image= (TextView) itemView.findViewById(R.id.txt_status_image) ;

            list_item_home_foxy_img= (ImageView) itemView.findViewById(R.id.list_item_home_foxy_img);
            list_item_home_dislike= (ImageView) itemView.findViewById(R.id.list_item_home_dislike);
            list_item_home_menu= (ImageView) itemView.findViewById(R.id.list_item_home_menu);
            list_item_history= (ImageView) itemView.findViewById(R.id.list_item_history);
            list_item_home_posted_name= (TextView) itemView.findViewById(R.id.list_item_home_posted_name) ;
            list_item_home_posted_txt= (TextView) itemView.findViewById(R.id.list_item_home_posted_txt) ;
            txt_comment= (TextView) itemView.findViewById(R.id.txt_comment) ;
            list_item_status_sale= (ImageView) itemView.findViewById(R.id.list_item_status_sale);
            new_message_main= (TextView) itemView.findViewById(R.id.new_message_main) ;
            new_message_main3= (TextView) itemView.findViewById(R.id.new_message_main3) ;
            linear_sale3_main= (LinearLayout) itemView.findViewById(R.id.linear_sale3_main) ;
            txt_Informitem= (TextView) itemView.findViewById(R.id.txt_Informitem) ;
            linear_Informitem= (LinearLayout) itemView.findViewById(R.id.linear_Informitem) ;
            linear_image= (LinearLayout) itemView.findViewById(R.id.linear_image) ;
            linear_head_image1= (LinearLayout) itemView.findViewById(R.id.linear_head_image1) ;
            linear_head_image2= (LinearLayout) itemView.findViewById(R.id.linear_head_image2) ;
            li_tel=itemView.findViewById(R.id.li_tel) ;

            txt_customer = (TextView) itemView.findViewById(R.id.txt_customer) ;
            txt_tel = (TextView) itemView.findViewById(R.id.txt_tel) ;
            txt_tel2= (TextView) itemView.findViewById(R.id.txt_tel2) ;
            txt_address = (TextView) itemView.findViewById(R.id.txt_address) ;
            txt_effdate = (TextView) itemView.findViewById(R.id.txt_effdate) ;




            itemView.setOnLongClickListener(this);
            itemView.setOnClickListener(this);
            list_item_status_sale.setOnClickListener(this);
            list_item_history.setOnClickListener(this);
            txt_comment.setOnClickListener(this);
            relat_remove.setVisibility(View.GONE);
            deleteAll.setVisibility(View.GONE);

           /* itemView.setOnLongClickListener(this);
            itemView.setOnClickListener(this);
            list_item_status_sale.setOnClickListener(this);
            list_item_history.setOnClickListener(this);
            txt_comment.setOnClickListener(this);*/







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
            else if(view==list_item_history){
                try {
                    if(ic_list_item_history!=null){
                        ic_list_item_history.click_list_item_history(list_item_history,getPosition());
                    }
                }


                catch (Exception e) {

                    e.printStackTrace();
                }
            }
            else if(view==txt_comment){
                try {
                    if(ic_txt_comment!=null){
                        ic_txt_comment.click_txt_comment(txt_comment,getPosition());
                    }
                }


                catch (Exception e) {

                    e.printStackTrace();
                }
            }
            else{
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

        private final RecyclerViewDataAdapter2 adapter;

        private final List<GetData_cedit_sale_edit_problem> originalList;

        private final List<GetData_cedit_sale_edit_problem> filteredList;

        private UserFilter(RecyclerViewDataAdapter2 adapter, List<GetData_cedit_sale_edit_problem> originalList) {
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

                    if ((user.getContno().toUpperCase()).contains(constraint.toString().toUpperCase()) ||
                            (user.getInformID().toUpperCase()).contains(constraint.toString().toUpperCase()) ){
                        filteredList.add(user);
                    }



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