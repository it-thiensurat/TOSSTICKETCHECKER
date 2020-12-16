package com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.pagination;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.pagination.models.Result;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.CircleTransform;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.Utils;


import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Suleiman on 19/10/16.
 */

public class PaginationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM = 0;
    private static final int LOADING = 1;
    private static final String BASE_URL_IMG = "https://image.tmdb.org/t/p/w150";

    private List<Result> movieResults;
    private Context context;

    private boolean isLoadingAdded = false;


    public  static ImageView image_status;



    String date_new_format_thai,date_new_format_thai2;
    String dateThai_year,dateThai_month,dateThai_day,dateThai_month1;
    int converted_dateThai11;
    private Date oneWayTripDate;
    String s1,s2,s3;



    public PaginationAdapter(Context context) {
        this.context = context;
        movieResults = new ArrayList<>();
    }

    public List<Result> getMovies() {
        return movieResults;
    }

    public void setMovies(List<Result> movieResults) {
        this.movieResults = movieResults;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case ITEM:
                viewHolder = getViewHolder(parent, inflater);
                break;
            case LOADING:
                View v2 = inflater.inflate(R.layout.item_progress, parent, false);
                viewHolder = new LoadingVH(v2);
                break;
        }
        return viewHolder;
    }

    @NonNull
    private RecyclerView.ViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        RecyclerView.ViewHolder viewHolder;
       // View v1 = inflater.inflate(R.layout.item_list_test, parent, false);
        View v1 = inflater.inflate(R.layout.list_item2, parent, false);
        viewHolder = new MovieVH(v1);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

      //  Result result = movieResults.get(position); // Movie
        Result  getDataAdapter1 =  movieResults.get(position);
        switch (getItemViewType(position)) {
            case ITEM:



                final MovieVH Viewholder = (MovieVH) holder;
















                try {
                    try {
                        Viewholder.InformID.setText(getDataAdapter1.getTitle()+"");
                        Viewholder.contno.setText(getDataAdapter1.getContno()+"");
                        Viewholder.txt_category.setText(getDataAdapter1.getGory()+"");
                        Viewholder.txt_main_problem.setText(getDataAdapter1.getMain()+"");
                        Viewholder.txt_sub_problem.setText(getDataAdapter1.getTopic_problem()+"");
                        //Viewholder.txt_topic.setText(getDataAdapter1.getTopic_problem());
                        Viewholder.new_message.setText(getDataAdapter1.getProblemDetail()+"");
                        Viewholder.new_message2.setText(getDataAdapter1.getProblemDetail2()+"");
                        Viewholder.new_message3.setText(getDataAdapter1.getProblemDetail3()+"");
                        Viewholder.new_message4.setText(getDataAdapter1.getProblemDetail4()+"");

                        Viewholder.txt_customer.setText(getDataAdapter1.getcustomer()+"");
                        Viewholder.txt_address.setText(getDataAdapter1.getAddress()+"");


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
                    Viewholder.list_item_home_posted_name.setText(getDataAdapter1.getEmployeeName()+"");
                    Viewholder.list_item_home_posted_txt.setText(getDataAdapter1.getPositionName()+"");



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

                    String WorkCode=getDataAdapter1.getWorkCode()+"";
                    String WorkName=getDataAdapter1.getWorkName()+"";







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




                        if(WorkCode.equals("00")){
                            image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
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
                            image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
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
                            image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
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
                            image_status.setBackgroundResource(R.drawable.icon_modify);
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
                            image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
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
                            image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
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
                            image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
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
                            image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
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
                            image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
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
                            image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);

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
                            image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);

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







              /*  final MovieVH movieVH = (MovieVH) holder;

                movieVH.InformID.setText(result.getTitle());
                movieVH.contno.setText(result.getContno());
                movieVH.txt_customer.setText(result.getcustomer());

                movieVH.txt_address.setText(result.getAddress()+"");


                movieVH.txt_effdate.setText(result.getEffDate()+"");
                if(result.getTel().equals("null")|(result.getTel().isEmpty())){
                    movieVH.txt_tel.setText("-");
                }
                else {
                    movieVH.txt_tel.setText(result.getTel()+"");
                }
                if(result.getTel2().equals("null")|(result.getTel2().isEmpty())){
                    movieVH.txt_tel2.setText("-");
                }
                else {
                    movieVH.txt_tel2.setText(result.getTel2()+"");
                }

                movieVH.txt_category.setText(result.getGory()+"");
                movieVH.txt_main_problem.setText(result.getMain()+"");
                movieVH.txt_sub_problem.setText(result.getTopic_problem()+"");

                try {
                    if(result.getGory().equals("ปัญหาการ์ดตรวจสอบ")){
                        movieVH.txt_category.setTextColor(0XFFff0000);
                    }
                    else if(result.getGory().equals("ปัญหาการ์ดค่างวด")){
                        movieVH.txt_category.setTextColor(0XFFFFA500);
                    }
                    else {
                        movieVH.txt_category.setTextColor(0XFFC71585);
                    }
                }
                catch (Exception ex){

                }

                try {
                    if(result.getTopic_problem().equals("null")){
                        movieVH.txt_topic.setText("ปัญหาอื่นๆ");
                    }
                    else {
                        movieVH.txt_topic.setText("-");

                    }
                }
                catch (Exception EX){

                }






                try {
                    String COUNT_IMAGE=result.getImageUrl()+"";
                    String COUNT_IMAGE2=result.getImageUrl_R()+"";



                    if(COUNT_IMAGE.equals("null")){
                        movieVH.linear_head_image1.setVisibility(View.GONE);
                    }
                    else {
                        movieVH.linear_head_image1.setVisibility(View.VISIBLE);
                    }


                    if(COUNT_IMAGE2.equals("null")){
                        movieVH.linear_head_image2.setVisibility(View.GONE);
                    }
                    else {
                        movieVH.linear_head_image2.setVisibility(View.VISIBLE);
                    }

                }
                catch (Exception ex){

                }






                try {
                    String ProblemDetail3 =result.getProblemDetail3()+"";
                    String ProblemDetail4 =result.getProblemDetail4()+"";

                    if ((ProblemDetail3.equals("null"))|(ProblemDetail3.isEmpty())){
                        movieVH.linear_sale3.setVisibility(View.GONE);
                    }
                    else {
                        movieVH.linear_sale3.setVisibility(View.VISIBLE);
                    }

                    if ((ProblemDetail4.equals("null"))|(ProblemDetail4.isEmpty())){
                        movieVH.linear_sale4.setVisibility(View.GONE);
                    }
                    else {
                        movieVH.linear_sale4.setVisibility(View.VISIBLE);
                    }
                }
                catch (Exception EX){

                }




                try {
                    if ((!result.getImage_Name().equals("null")) &(!result.getImage_Name_R().equals("null")))  {
                        movieVH.linear_image.setVisibility(View.VISIBLE);
                    } else if ((!result.getImage_Name().equals("null")) &(result.getImage_Name_R().equals("null"))) {
                        movieVH.linear_image.setVisibility(View.VISIBLE);
                    } else if ((result.getImage_Name().equals("null")) &(!result.getImage_Name_R().equals("null")))  {
                        movieVH.linear_image.setVisibility(View.VISIBLE);
                    } else if ((result.getImage_Name().equals("null")) &(result.getImage_Name_R().equals("null")))  {
                        movieVH.linear_image.setVisibility(View.GONE);
                    }else  {
                        movieVH.linear_image.setVisibility(View.GONE);
                    }
                }
                catch (Exception e) {
                    //    Viewholder.linear_image.setVisibility(View.GONE);
                }





                try {
                    Log.e("getInformitem",result.getInformitem());
                    if (!result.getInformitem().equals("")) {
                        movieVH.linear_Informitem.setVisibility(View.VISIBLE);
                        movieVH.txt_Informitem.setText(result.getInformitem());
                    } else  {
                        movieVH.linear_Informitem.setVisibility(View.GONE);
                    }
                }
                catch (Exception e) {
                    //    Viewholder.linear_image.setVisibility(View.GONE);
                }


                try {
                    String CancelNote =result.getCancelNote()+"";
                    if((CancelNote.equals("null"))|(CancelNote.isEmpty())){
                        movieVH.linear_sale3_main.setVisibility(View.GONE);
                    }
                    else {
                        movieVH.linear_sale3_main.setVisibility(View.VISIBLE);
                        movieVH.new_message_main3.setText(result.getCancelNote());
                    }
                }
                catch (Exception x){

                }




















                try {
                    Glide.with(context).load(result.getPicture())
                            .crossFade()
                            .thumbnail(0.5f)
                            .bitmapTransform(new CircleTransform(context))
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                            .into(movieVH.list_item_home_foxy_img);
                }
                catch (Exception e) {

                }
                movieVH.list_item_home_posted_name.setText(result.getEmployeeName()+"");
                movieVH.list_item_home_posted_txt.setText(result.getPositionName()+"");



                try {
                    if(result.getProblemDetail_sub().isEmpty()){
                        movieVH.new_message_main.setText("-");
                    }
                    else {
                        movieVH.new_message_main.setText(result.getProblemDetail_sub());
                    }
                }
                catch (Exception ex){

                }




                String WorkCode=result.getWorkCode()+"";
                String WorkName=result.getWorkName()+"";


                try {
                    if(WorkName.equals("null")){
                        movieVH.txt_status.setText("อยู่ระหว่างการตรวจสอบ");
                        movieVH.deleteAll.setVisibility(View.VISIBLE);

                        movieVH.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
                        movieVH.txt_status_closing.setText("รอดำเนินการ");
                        movieVH.txt_status_closing.setTextColor(0xffA9A9A9);

                    }
                    else {
                        movieVH.txt_status.setText(WorkName);
                        movieVH.deleteAll.setVisibility(View.VISIBLE);

                        movieVH.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
                        movieVH.txt_status_closing.setText("รอดำเนินการ");
                    }
                }
                catch (Exception ex){

                }


































                try {
                    if(WorkCode.equals("00")){
                        image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                        movieVH.linear_coler.setBackgroundResource(R.color.graysafe);
                        movieVH.deleteAll.setVisibility(View.VISIBLE);

                        movieVH.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
                        movieVH.txt_status_closing.setText("รอดำเนินการ");
                        movieVH.txt_status_closing.setTextColor(0xffA9A9A9);

                        movieVH.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                        movieVH.txt_status_image.setTextColor(0xffB22222);

                        try {
                            Glide.with(context).load(result.getImageUrl())
                                    .crossFade()
                                    .thumbnail(0.5f)
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                                    .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                                    .into(movieVH.image_problem_incorrect);
                        }
                        catch (Exception e) {

                        }
                    }
                    else if(WorkCode.equals("10")){
                        image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                        movieVH.linear_coler.setBackgroundResource(R.color.colorPrimary);
                        movieVH.deleteAll.setVisibility(View.VISIBLE);

                        movieVH.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange17);
                        movieVH.txt_status_closing.setText("ปิดงานแล้ว");
                        movieVH.txt_status_closing.setTextColor(0xffffffff);
                        if(result.getImage_Name_R().equals("null")){
                            movieVH.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                            movieVH.txt_status_image.setTextColor(0xfffaebd7);

                            String COUNT_IMAGE=result.getCountImage()+"";
                            try {
                                int int_count_image= Integer.parseInt(COUNT_IMAGE);
                                if(int_count_image>1){
                                    movieVH.txt_count_image_error.setVisibility(View.VISIBLE);
                                    movieVH.txt_count_image_error.setText("+ "+result.getCountImage());
                                }
                                else {
                                    movieVH.txt_count_image_error.setVisibility(View.GONE);
                                }
                            }
                            catch (Exception e){

                            }

                            try {
                                Glide.with(context).load(result.getImageUrl())
                                        .crossFade()
                                        .thumbnail(0.5f)
                                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                                        .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                                        .into(movieVH.image_problem_incorrect);
                            }
                            catch (Exception e) {

                            }
                        }
                        else {
                            movieVH.txt_status_image.setText(" รูปแก้ไขแล้ว ");
                            movieVH.txt_status_image.setTextColor(0xff75b275);

                            String COUNT_IMAGE=result.getCountImage_R()+"";
                            try {
                                int int_count_image= Integer.parseInt(COUNT_IMAGE);
                                if(int_count_image>1){
                                    movieVH.txt_count_image_error.setVisibility(View.VISIBLE);
                                    movieVH.txt_count_image_error.setText("+ "+result.getCountImage_R());
                                }
                                else {
                                    movieVH.txt_count_image_error.setVisibility(View.GONE);
                                }
                            }
                            catch (Exception e){

                            }
                            try {
                                Glide.with(context).load(result.getImageUrl_R())
                                        .crossFade()
                                        .thumbnail(0.5f)
                                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                                        .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                                        .into(movieVH.image_problem_incorrect);
                            }
                            catch (Exception e) {

                            }
                        }
                    }
                    else if(WorkCode.equals("21")){
                        image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                        movieVH.linear_coler.setBackgroundResource(R.color.MediumTurquoise);
                        movieVH.deleteAll.setVisibility(View.VISIBLE);

                        movieVH.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
                        movieVH.txt_status_closing.setText("รอดำเนินการ");
                        movieVH.txt_status_closing.setTextColor(0xffA9A9A9);

                        movieVH.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                        movieVH.txt_status_image.setTextColor(0xfffaebd7);


                        try {
                            Glide.with(context).load(result.getImageUrl())
                                    .crossFade()
                                    .thumbnail(0.5f)
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                                    .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                                    .into(movieVH.image_problem_incorrect);
                        }
                        catch (Exception e) {

                        }
                    }
                    else if(WorkCode.equals("22")){
                        image_status.setBackgroundResource(R.drawable.icon_modify);
                        movieVH.linear_coler.setBackgroundResource(R.color.Red);
                        movieVH.deleteAll.setVisibility(View.VISIBLE);

                        movieVH.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
                        movieVH.txt_status_closing.setText("รอดำเนินการ");
                        movieVH.txt_status_closing.setTextColor(0xffA9A9A9);


                        if(result.getImage_Name_R().equals("null")){
                            movieVH.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                            movieVH.txt_status_image.setTextColor(0xfffaebd7);


                            String COUNT_IMAGE=result.getCountImage()+"";
                            try {
                                int int_count_image= Integer.parseInt(COUNT_IMAGE);
                                if(int_count_image>1){
                                    movieVH.txt_count_image_error.setVisibility(View.VISIBLE);
                                    movieVH.txt_count_image_error.setText("+ "+result.getCountImage());
                                }
                                else {
                                    movieVH.txt_count_image_error.setVisibility(View.GONE);
                                }
                            }
                            catch (Exception e){

                            }

                            try {
                                Glide.with(context).load(result.getImageUrl())

                                        .crossFade()
                                        .thumbnail(0.5f)
                                        // .bitmapTransform(new CircleTransform(context))
                                        .diskCacheStrategy(DiskCacheStrategy.ALL)

                                        .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                                        .into(movieVH.image_problem_incorrect);
                            }
                            catch (Exception e) {

                            }
                        }
                        else {
                            movieVH.txt_status_image.setText(" รูปแก้ไขแล้ว ");
                            movieVH.txt_status_image.setTextColor(0xff75b275);

                            String COUNT_IMAGE=result.getCountImage_R()+"";
                            try {
                                int int_count_image= Integer.parseInt(COUNT_IMAGE);
                                if(int_count_image>1){
                                    movieVH.txt_count_image_error.setVisibility(View.VISIBLE);
                                    movieVH.txt_count_image_error.setText("+ "+result.getCountImage_R());
                                }
                                else {
                                    movieVH.txt_count_image_error.setVisibility(View.GONE);
                                }
                            }
                            catch (Exception e){

                            }
                            try {
                                Glide.with(context).load(result.getImageUrl_R())


                                        .crossFade()
                                        .thumbnail(0.5f)
                                        // .bitmapTransform(new CircleTransform(context))
                                        .diskCacheStrategy(DiskCacheStrategy.ALL)

                                        .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                                        .into(movieVH.image_problem_incorrect);
                            }
                            catch (Exception e) {

                            }
                        }
                    }
                    else if(WorkCode.equals("23")){
                        image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                        movieVH.linear_coler.setBackgroundResource(R.color.RoyalBlue);
                        movieVH.deleteAll.setVisibility(View.VISIBLE);

                        movieVH.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
                        movieVH.txt_status_closing.setText("รอดำเนินการ");
                        movieVH.txt_status_closing.setTextColor(0xffA9A9A9);

                        if(result.getImage_Name_R().equals("null")){
                            movieVH.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                            movieVH.txt_status_image.setTextColor(0xfffaebd7);


                            String COUNT_IMAGE=result.getCountImage()+"";
                            try {
                                int int_count_image= Integer.parseInt(COUNT_IMAGE);
                                if(int_count_image>1){
                                    movieVH.txt_count_image_error.setVisibility(View.VISIBLE);
                                    movieVH.txt_count_image_error.setText("+ "+result.getCountImage());
                                }
                                else {
                                    movieVH.txt_count_image_error.setVisibility(View.GONE);
                                }
                            }
                            catch (Exception e){

                            }

                            try {
                                Glide.with(context).load(result.getImageUrl())


                                        .crossFade()
                                        .thumbnail(0.5f)
                                        // .bitmapTransform(new CircleTransform(context))
                                        .diskCacheStrategy(DiskCacheStrategy.ALL)

                                        .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                                        .into(movieVH.image_problem_incorrect);
                            }
                            catch (Exception e) {

                            }
                        }
                        else {
                            movieVH.txt_status_image.setText(" รูปแก้ไขแล้ว ");
                            movieVH.txt_status_image.setTextColor(0xff75b275);

                            String COUNT_IMAGE=result.getCountImage_R()+"";
                            try {
                                int int_count_image= Integer.parseInt(COUNT_IMAGE);
                                if(int_count_image>1){
                                    movieVH.txt_count_image_error.setVisibility(View.VISIBLE);
                                    movieVH.txt_count_image_error.setText("+ "+result.getCountImage_R());
                                }
                                else {
                                    movieVH.txt_count_image_error.setVisibility(View.GONE);
                                }
                            }
                            catch (Exception e){

                            }
                            try {
                                Glide.with(context).load(result.getImageUrl_R())


                                        .crossFade()
                                        .thumbnail(0.5f)
                                        // .bitmapTransform(new CircleTransform(context))
                                        .diskCacheStrategy(DiskCacheStrategy.ALL)

                                        .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                                        .into(movieVH.image_problem_incorrect);
                            }
                            catch (Exception e) {

                            }
                        }
                    }
                    else if(WorkCode.equals("24")){
                        image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                        movieVH.linear_coler.setBackgroundResource(R.color.Blue);
                        movieVH.deleteAll.setVisibility(View.VISIBLE);

                        movieVH.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
                        movieVH.txt_status_closing.setText("รอดำเนินการ");
                        movieVH.txt_status_closing.setTextColor(0xffA9A9A9);

                        if(result.getImage_Name_R().equals("null")){
                            movieVH.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                            movieVH.txt_status_image.setTextColor(0xfffaebd7);


                            String COUNT_IMAGE=result.getCountImage()+"";
                            try {
                                int int_count_image= Integer.parseInt(COUNT_IMAGE);
                                if(int_count_image>1){
                                    movieVH.txt_count_image_error.setVisibility(View.VISIBLE);
                                    movieVH.txt_count_image_error.setText("+ "+result.getCountImage());
                                }
                                else {
                                    movieVH.txt_count_image_error.setVisibility(View.GONE);
                                }
                            }
                            catch (Exception e){

                            }

                            try {
                                Glide.with(context).load(result.getImageUrl())


                                        .crossFade()
                                        .thumbnail(0.5f)
                                        // .bitmapTransform(new CircleTransform(context))
                                        .diskCacheStrategy(DiskCacheStrategy.ALL)

                                        .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                                        .into(movieVH.image_problem_incorrect);
                            }
                            catch (Exception e) {

                            }
                        }
                        else {
                            movieVH.txt_status_image.setText(" รูปแก้ไขแล้ว ");
                            movieVH.txt_status_image.setTextColor(0xff75b275);

                            String COUNT_IMAGE=result.getCountImage_R()+"";
                            try {
                                int int_count_image= Integer.parseInt(COUNT_IMAGE);
                                if(int_count_image>1){
                                    movieVH.txt_count_image_error.setVisibility(View.VISIBLE);
                                    movieVH.txt_count_image_error.setText("+ "+result.getCountImage_R());
                                }
                                else {
                                    movieVH.txt_count_image_error.setVisibility(View.GONE);
                                }
                            }
                            catch (Exception e){

                            }
                            try {
                                Glide.with(context).load(result.getImageUrl_R())


                                        .crossFade()
                                        .thumbnail(0.5f)
                                        // .bitmapTransform(new CircleTransform(context))
                                        .diskCacheStrategy(DiskCacheStrategy.ALL)

                                        .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                                        .into(movieVH.image_problem_incorrect);
                            }
                            catch (Exception e) {

                            }
                        }
                    }
                    else if(WorkCode.equals("25")){
                        image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                        movieVH.linear_coler.setBackgroundResource(R.color.DarkBlue);
                        movieVH.deleteAll.setVisibility(View.VISIBLE);

                        movieVH.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
                        movieVH.txt_status_closing.setText("รอดำเนินการ");
                        movieVH.txt_status_closing.setTextColor(0xffA9A9A9);

                        if(result.getImage_Name_R().equals("null")){
                            movieVH.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                            movieVH.txt_status_image.setTextColor(0xfffaebd7);


                            String COUNT_IMAGE=result.getCountImage();
                            try {
                                int int_count_image= Integer.parseInt(COUNT_IMAGE);
                                if(int_count_image>1){
                                    movieVH.txt_count_image_error.setVisibility(View.VISIBLE);
                                    movieVH.txt_count_image_error.setText("+ "+result.getCountImage());
                                }
                                else {
                                    movieVH.txt_count_image_error.setVisibility(View.GONE);
                                }
                            }
                            catch (Exception e){

                            }

                            try {
                                Glide.with(context).load(result.getImageUrl())


                                        .crossFade()
                                        .thumbnail(0.5f)
                                        // .bitmapTransform(new CircleTransform(context))
                                        .diskCacheStrategy(DiskCacheStrategy.ALL)

                                        .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                                        .into(movieVH.image_problem_incorrect);
                            }
                            catch (Exception e) {

                            }
                        }
                        else {
                            movieVH.txt_status_image.setText(" รูปแก้ไขแล้ว ");
                            movieVH.txt_status_image.setTextColor(0xff75b275);

                            String COUNT_IMAGE=result.getCountImage_R()+"";
                            try {
                                int int_count_image= Integer.parseInt(COUNT_IMAGE);
                                if(int_count_image>1){
                                    movieVH.txt_count_image_error.setVisibility(View.VISIBLE);
                                    movieVH.txt_count_image_error.setText("+ "+result.getCountImage_R());
                                }
                                else {
                                    movieVH.txt_count_image_error.setVisibility(View.GONE);
                                }
                            }
                            catch (Exception e){

                            }
                            try {
                                Glide.with(context).load(result.getImageUrl_R())


                                        .crossFade()
                                        .thumbnail(0.5f)
                                        // .bitmapTransform(new CircleTransform(context))
                                        .diskCacheStrategy(DiskCacheStrategy.ALL)

                                        .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                                        .into(movieVH.image_problem_incorrect);
                            }
                            catch (Exception e) {

                            }
                        }
                    }

                    else if(WorkCode.equals("26")){
                        image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                        movieVH.linear_coler.setBackgroundResource(R.color.Purple);
                        movieVH.deleteAll.setVisibility(View.VISIBLE);

                        movieVH.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
                        movieVH.txt_status_closing.setText("รอดำเนินการ");
                        movieVH.txt_status_closing.setTextColor(0xffA9A9A9);

                        if(result.getImage_Name_R().equals("null")){
                            movieVH.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                            movieVH.txt_status_image.setTextColor(0xfffaebd7);


                            String COUNT_IMAGE=result.getCountImage()+"";
                            try {
                                int int_count_image= Integer.parseInt(COUNT_IMAGE);
                                if(int_count_image>1){
                                    movieVH.txt_count_image_error.setVisibility(View.VISIBLE);
                                    movieVH.txt_count_image_error.setText("+ "+result.getCountImage());
                                }
                                else {
                                    movieVH.txt_count_image_error.setVisibility(View.GONE);
                                }
                            }
                            catch (Exception e){

                            }

                            try {
                                Glide.with(context).load(result.getImageUrl())


                                        .crossFade()
                                        .thumbnail(0.5f)
                                        // .bitmapTransform(new CircleTransform(context))
                                        .diskCacheStrategy(DiskCacheStrategy.ALL)

                                        .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                                        .into(movieVH.image_problem_incorrect);
                            }
                            catch (Exception e) {

                            }
                        }
                        else {
                            movieVH.txt_status_image.setText(" รูปแก้ไขแล้ว ");
                            movieVH.txt_status_image.setTextColor(0xff75b275);

                            String COUNT_IMAGE=result.getCountImage_R();
                            try {
                                int int_count_image= Integer.parseInt(COUNT_IMAGE);
                                if(int_count_image>1){
                                    movieVH.txt_count_image_error.setVisibility(View.VISIBLE);
                                    movieVH.txt_count_image_error.setText("+ "+result.getCountImage_R());
                                }
                                else {
                                    movieVH.txt_count_image_error.setVisibility(View.GONE);
                                }
                            }
                            catch (Exception e){

                            }
                            try {
                                Glide.with(context).load(result.getImageUrl_R())


                                        .crossFade()
                                        .thumbnail(0.5f)
                                        // .bitmapTransform(new CircleTransform(context))
                                        .diskCacheStrategy(DiskCacheStrategy.ALL)

                                        .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                                        .into(movieVH.image_problem_incorrect);
                            }
                            catch (Exception e) {

                            }
                        }
                    }
                    else if(WorkCode.equals("90")){
                        image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                        movieVH.linear_coler.setBackgroundResource(R.color.SeaGreen);
                        movieVH.deleteAll.setVisibility(View.VISIBLE);

                        movieVH.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange17);
                        movieVH.txt_status_closing.setText("เรียบร้อย");
                        movieVH.txt_status_closing.setTextColor(0xffffffff);
                        if(result.getImage_Name_R().equals("null")){
                            movieVH.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                            movieVH.txt_status_image.setTextColor(0xfffaebd7);

                            String COUNT_IMAGE=result.getCountImage()+"";
                            try {
                                int int_count_image= Integer.parseInt(COUNT_IMAGE);
                                if(int_count_image>1){
                                    movieVH.txt_count_image_error.setVisibility(View.VISIBLE);
                                    movieVH.txt_count_image_error.setText("+ "+result.getCountImage());
                                }
                                else {
                                    movieVH.txt_count_image_error.setVisibility(View.GONE);
                                }
                            }
                            catch (Exception e){

                            }

                            try {
                                Glide.with(context).load(result.getImageUrl())
                                        .crossFade()
                                        .thumbnail(0.5f)
                                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                                        .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                                        .into(movieVH.image_problem_incorrect);
                            }
                            catch (Exception e) {

                            }
                        }
                        else {
                            movieVH.txt_status_image.setText(" รูปแก้ไขแล้ว ");
                            movieVH.txt_status_image.setTextColor(0xff75b275);

                            String COUNT_IMAGE=result.getCountImage_R()+"";
                            try {
                                int int_count_image= Integer.parseInt(COUNT_IMAGE);
                                if(int_count_image>1){
                                    movieVH.txt_count_image_error.setVisibility(View.VISIBLE);
                                    movieVH.txt_count_image_error.setText("+ "+result.getCountImage_R());
                                }
                                else {
                                    movieVH.txt_count_image_error.setVisibility(View.GONE);
                                }
                            }
                            catch (Exception e){

                            }
                            try {
                                Glide.with(context).load(result.getImageUrl_R())
                                        .crossFade()
                                        .thumbnail(0.5f)
                                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                                        .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                                        .into(movieVH.image_problem_incorrect);
                            }
                            catch (Exception e) {

                            }
                        }
                    }


                    else if(WorkCode.equals("91")){
                        image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);

                        movieVH.linear_coler.setBackgroundResource(R.color.SeaGreen);

                        movieVH.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange17);
                        movieVH.txt_status_closing.setText("ปิดงานแล้ว");


                        if(result.getImage_Name_R().equals("null")){
                            movieVH.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                            movieVH.txt_status_image.setTextColor(0xfffaebd7);


                            String COUNT_IMAGE=result.getCountImage();
                            try {
                                int int_count_image= Integer.parseInt(COUNT_IMAGE);
                                if(int_count_image>1){
                                    movieVH.txt_count_image_error.setVisibility(View.VISIBLE);
                                    movieVH.txt_count_image_error.setText("+ "+result.getCountImage());
                                }
                                else {
                                    movieVH.txt_count_image_error.setVisibility(View.GONE);
                                }
                            }
                            catch (Exception e){

                            }

                            try {
                                Glide.with(context).load(result.getImageUrl())


                                        .crossFade()
                                        .thumbnail(0.5f)
                                        // .bitmapTransform(new CircleTransform(context))
                                        .diskCacheStrategy(DiskCacheStrategy.ALL)

                                        .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                                        .into(movieVH.image_problem_incorrect);
                            }
                            catch (Exception e) {

                            }
                        }
                        else {
                            movieVH.txt_status_image.setText(" รูปแก้ไขแล้ว ");
                            movieVH.txt_status_image.setTextColor(0xff75b275);

                            String COUNT_IMAGE=result.getCountImage_R();
                            try {
                                int int_count_image= Integer.parseInt(COUNT_IMAGE);
                                if(int_count_image>1){
                                    movieVH.txt_count_image_error.setVisibility(View.VISIBLE);
                                    movieVH.txt_count_image_error.setText("+ "+result.getCountImage_R());
                                }
                                else {
                                    movieVH.txt_count_image_error.setVisibility(View.GONE);
                                }
                            }
                            catch (Exception e){

                            }
                            try {
                                Glide.with(context).load(result.getImageUrl_R())


                                        .crossFade()
                                        .thumbnail(0.5f)
                                        // .bitmapTransform(new CircleTransform(context))
                                        .diskCacheStrategy(DiskCacheStrategy.ALL)

                                        .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                                        .into(movieVH.image_problem_incorrect);
                            }
                            catch (Exception e) {

                            }
                        }
                    }

                    else {
                        image_status.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);

                        movieVH.linear_coler.setBackgroundResource(R.color.Yellow);
                        movieVH.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
                        movieVH.txt_status_closing.setText("รอดำเนินการ");
                        movieVH.txt_status_closing.setTextColor(0xffA9A9A9);

                        if(result.getImage_Name_R().equals("null")){
                            movieVH.txt_status_image.setText(" รูปยังไม่แก้ไข ");
                            movieVH.txt_status_image.setTextColor(0xfffaebd7);


                            String COUNT_IMAGE=result.getCountImage();
                            try {
                                int int_count_image= Integer.parseInt(COUNT_IMAGE);
                                if(int_count_image>1){
                                    movieVH.txt_count_image_error.setVisibility(View.VISIBLE);
                                    movieVH.txt_count_image_error.setText("+ "+result.getCountImage());
                                }
                                else {
                                    movieVH.txt_count_image_error.setVisibility(View.GONE);
                                }
                            }
                            catch (Exception e){

                            }

                            try {
                                Glide.with(context).load(result.getImageUrl()+"")


                                        .crossFade()
                                        .thumbnail(0.5f)
                                        // .bitmapTransform(new CircleTransform(context))
                                        .diskCacheStrategy(DiskCacheStrategy.ALL)

                                        .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                                        .into(movieVH.image_problem_incorrect);
                            }
                            catch (Exception e) {

                            }
                        }
                        else {
                            movieVH.txt_status_image.setText(" รูปแก้ไขแล้ว ");
                            movieVH.txt_status_image.setTextColor(0xff75b275);

                            String COUNT_IMAGE=result.getCountImage_R()+"";
                            try {
                                int int_count_image= Integer.parseInt(COUNT_IMAGE);
                                if(int_count_image>1){
                                    movieVH.txt_count_image_error.setVisibility(View.VISIBLE);
                                    movieVH.txt_count_image_error.setText("+ "+result.getCountImage_R());
                                }
                                else {
                                    movieVH.txt_count_image_error.setVisibility(View.GONE);
                                }
                            }
                            catch (Exception e){

                            }
                            try {
                                Glide.with(context).load(result.getImageUrl_R())


                                        .crossFade()
                                        .thumbnail(0.5f)
                                        // .bitmapTransform(new CircleTransform(context))
                                        .diskCacheStrategy(DiskCacheStrategy.ALL)

                                        .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                                        .into(movieVH.image_problem_incorrect);
                            }
                            catch (Exception e) {

                            }
                        }
                    }

                }
                catch (Exception ex){

                }

                try {


                    String date=result.getDate_create();
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
                            movieVH.txt_datetime.setText(date_new_format_thai2);
                            //Viewholder.icon_time.setBackgroundResource(R.drawable.ic_access_time_black_24dp);
                            //Log.e("TIME",date_new_format_thai2);
                        }
                        else {
                            movieVH.txt_datetime.setText(dateThai_day+" "+dateThai_month1+converted_dateThai11);
                            //  Viewholder.icon_time.setBackgroundResource(0);
                            // Log.e("dateThai",dateThai_day+""+dateThai_month1+""+converted_dateThai11+"");
                        }


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
                            .into(movieVH.list_item_home_foxy_img);
                }
                catch (Exception e) {

                }

*/


             /*   movieVH.mYear.setText(
                        result.getReleaseDate().substring(0, 4)  // we want the year only
                                + " | "
                                + result.getOriginalLanguage().toUpperCase()
                );*/
               // movieVH.mMovieDesc.setText(result.getOverview());

                /**
                 * Using Glide to handle image loading.
                 * Learn more about Glide here:
                 * <a href="http://blog.grafixartist.com/image-gallery-app-android-studio-1-4-glide/" />
                 */
/*                Glide
                        .with(context)
                        .load(BASE_URL_IMG + result.getPosterPath())
                        .listener(new RequestListener<String, GlideDrawable>() {
                            @Override
                            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                                // TODO: 08/11/16 handle failure
                                movieVH.mProgress.setVisibility(View.GONE);
                                return false;
                            }

                            @Override
                            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                                // image ready, hide progress now
                                movieVH.mProgress.setVisibility(View.GONE);
                                return false;   // return false if you want Glide to handle everything else.
                            }
                        })
                        .diskCacheStrategy(DiskCacheStrategy.ALL)   // cache both original & resized image
                        .centerCrop()
                        .crossFade()
                        .into(movieVH.mPosterImg);*/

                break;

            case LOADING:
//                Do nothing
                break;
        }

    }

    @Override
    public int getItemCount() {
        return movieResults == null ? 0 : movieResults.size();

    }

    @Override
    public int getItemViewType(int position) {
        return (position == movieResults.size() - 1 && isLoadingAdded) ? LOADING : ITEM;
    }


    /*
   Helpers
   _________________________________________________________________________________________________
    */

    public void add(Result r) {
        movieResults.add(r);
        notifyItemInserted(movieResults.size() - 1);
    }

    public void addAll(List<Result> moveResults) {
        for (Result result : moveResults) {
            add(result);
        }
    }

    public void remove(Result r) {
        int position = movieResults.indexOf(r);
        if (position > -1) {
            movieResults.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        isLoadingAdded = false;
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }


    public void addLoadingFooter() {
        isLoadingAdded = true;
        add(new Result());
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = movieResults.size() - 1;
        Result result = getItem(position);

        if (result != null) {
            movieResults.remove(position);
            notifyItemRemoved(position);
        }
    }

    public Result getItem(int position) {
        return movieResults.get(position);
    }


   /*
   View Holders
   _________________________________________________________________________________________________
    */

    /**
     * Main list's content ViewHolder
     */
    protected class MovieVH extends RecyclerView.ViewHolder {
/*        private TextView mMovieTitle;
        private TextView mMovieDesc;
        private TextView mYear; // displays "year | language"
        private ImageView mPosterImg;
        private ProgressBar mProgress;*/
        protected TextView InformID;
        protected TextView contno;
        protected  TextView txt_customer;
        protected  TextView txt_tel,txt_tel2;
        protected  TextView txt_address,txt_effdate;

        protected TextView txt_category;
        protected TextView txt_main_problem;
        protected TextView txt_sub_problem;
        protected TextView txt_topic;
        protected LinearLayout linear_head_image1,linear_head_image2;
        protected LinearLayout linear_status_closing,linear_sale3_main,linear_Informitem,linear_image,linear_sale3,linear_sale4;
        protected  TextView txt_Informitem;
        protected  TextView new_message_main3;
        protected ImageView list_item_home_foxy_img;
        protected  TextView list_item_home_posted_name;
        protected  TextView list_item_home_posted_txt;
        protected  TextView new_message_main;

        protected  TextView txt_status;
        protected  TextView txt_status_image;
        protected  TextView txt_status_closing;

        protected RelativeLayout deleteAll,relat_remove;

        protected LinearLayout linear_coler;
        protected ImageView image_problem_incorrect;
        protected TextView  txt_count_image_error;
        protected  TextView txt_datetime;

        protected TextView new_message,new_message2,new_message3,new_message4;

        public MovieVH(View itemView) {
            super(itemView);
            InformID = (TextView) itemView.findViewById(R.id.InformID) ;
            contno = (TextView) itemView.findViewById(R.id.contno) ;
            txt_customer = (TextView) itemView.findViewById(R.id.txt_customer) ;
            txt_tel = (TextView) itemView.findViewById(R.id.txt_tel) ;
            txt_tel2= (TextView) itemView.findViewById(R.id.txt_tel2) ;
            txt_address = (TextView) itemView.findViewById(R.id.txt_address) ;
            txt_effdate = (TextView) itemView.findViewById(R.id.txt_effdate) ;

            txt_category = (TextView) itemView.findViewById(R.id.txt_category) ;
            txt_main_problem = (TextView) itemView.findViewById(R.id.txt_main_problem) ;
            txt_sub_problem = (TextView) itemView.findViewById(R.id.txt_sub_problem) ;
            txt_topic = (TextView) itemView.findViewById(R.id.txt_topic) ;

            linear_head_image1= (LinearLayout) itemView.findViewById(R.id.linear_head_image1) ;
            linear_head_image2= (LinearLayout) itemView.findViewById(R.id.linear_head_image2) ;

            linear_sale3= (LinearLayout) itemView.findViewById(R.id.linear_sale3) ;
            linear_sale4= (LinearLayout) itemView.findViewById(R.id.linear_sale4) ;
            linear_image= (LinearLayout) itemView.findViewById(R.id.linear_image) ;

            linear_Informitem= (LinearLayout) itemView.findViewById(R.id.linear_Informitem) ;
            txt_Informitem= (TextView) itemView.findViewById(R.id.txt_Informitem) ;
            linear_sale3_main= (LinearLayout) itemView.findViewById(R.id.linear_sale3_main) ;
            new_message_main3= (TextView) itemView.findViewById(R.id.new_message_main3) ;
            list_item_home_foxy_img= (ImageView) itemView.findViewById(R.id.list_item_home_foxy_img);
            list_item_home_posted_name= (TextView) itemView.findViewById(R.id.list_item_home_posted_name) ;
            list_item_home_posted_txt= (TextView) itemView.findViewById(R.id.list_item_home_posted_txt) ;

            new_message_main= (TextView) itemView.findViewById(R.id.new_message_main) ;

            txt_status= (TextView) itemView.findViewById(R.id.txt_status) ;
            txt_status_closing= (TextView) itemView.findViewById(R.id.txt_status_closing) ;
            txt_status_image= (TextView) itemView.findViewById(R.id.txt_status_image) ;

            deleteAll= (RelativeLayout) itemView.findViewById(R.id.deleteAll) ;
            relat_remove= (RelativeLayout) itemView.findViewById(R.id.relat_remove) ;

            image_status= (ImageView) itemView.findViewById(R.id.image_status) ;

            linear_coler= (LinearLayout) itemView.findViewById(R.id.linear_coler) ;
            image_problem_incorrect= (ImageView) itemView.findViewById(R.id.image_problem_incorrect) ;
            txt_count_image_error= (TextView) itemView.findViewById(R.id.txt_count_image_error) ;
            txt_datetime= (TextView) itemView.findViewById(R.id.txt_datetime) ;

            new_message= (TextView) itemView.findViewById(R.id.new_message) ;
            new_message2= (TextView) itemView.findViewById(R.id.new_message2) ;
            new_message3= (TextView) itemView.findViewById(R.id.new_message3) ;
            new_message4= (TextView) itemView.findViewById(R.id.new_message4) ;

    /*        mMovieTitle = (TextView) itemView.findViewById(R.id.movie_title);
            mMovieDesc = (TextView) itemView.findViewById(R.id.movie_desc);
            mYear = (TextView) itemView.findViewById(R.id.movie_year);
            mPosterImg = (ImageView) itemView.findViewById(R.id.movie_poster);
            mProgress = (ProgressBar) itemView.findViewById(R.id.movie_progress);*/
        }
    }


    protected class LoadingVH extends RecyclerView.ViewHolder {

        public LoadingVH(View itemView) {
            super(itemView);
        }
    }


}
