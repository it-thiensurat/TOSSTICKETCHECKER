package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.tsr.tsrproblemreport_tossticket_checker.R;

import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.utils.VectorDrawableUtils;
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
public class RecyclerViewAdapter_history extends RecyclerView.Adapter<RecyclerViewAdapter_history.ViewHolder> implements Filterable {


    public static Context context;
    List<GetData_cedit> getDataAdapter;
    ImageLoader imageLoader1;

    int i = 0;







    String date_new_format_thai,date_new_format_thai2;
    String dateThai_year,dateThai_month,dateThai_day,dateThai_month1;
    int converted_dateThai11;
    private Date oneWayTripDate;
    String s1,s2,s3;






    int zine;
    private UserFilter userFilter;


    public RecyclerViewAdapter_history(List<GetData_cedit> getDataAdapter, Context context){

        super();
        this.getDataAdapter = getDataAdapter;
        this.context = context;
        userFilter = new UserFilter(RecyclerViewAdapter_history.this,getDataAdapter);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {




        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_timeline, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {

        GetData_cedit getDataAdapter1 =  getDataAdapter.get(position);


/*
        try {
            Glide.with(context).load(getDataAdapter1.getpicture())



                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(context))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                    .into(Viewholder.networkImageView);
        }
        catch (Exception e) {

        }
        */






        Viewholder.txt_conno.setText(getDataAdapter1.getconno_view());



        Viewholder.text_timeline_title2.setText("12:00:00");
        Viewholder.time_marker.setMarker(VectorDrawableUtils.getDrawable(context, R.drawable.ic_marker_active, R.color.colorPrimary2));


        String check1;
        check1=getDataAdapter1.gettitleTypeCode();

if(check1.equals("SCAN")){
    Viewholder.text_timeline_title.setText("Scan QR/BAR CODE");
    Viewholder.text_timeline_title.setTextColor(0xffBA55D3);
    Viewholder.VollyNetworkImageView1.setBackgroundResource(R.drawable.ic_qr_scan);
    Viewholder.VollyNetworkImageView1.setBackgroundTintList(ColorStateList.valueOf(0xFF000000));

    Viewholder.titel.setBackgroundResource(0);

}
else if(check1.equals("PRODUCT")){
    Viewholder.text_timeline_title.setText("ถ่ายรูปเครื่อง");
    Viewholder.text_timeline_title.setTextColor(0xff5f9ea0);
    Viewholder.VollyNetworkImageView1.setBackgroundResource(R.drawable.ic_camera);
    Viewholder.VollyNetworkImageView1.setBackgroundTintList(ColorStateList.valueOf(0xFFA9A9A9));
    Viewholder.titel.setBackgroundResource(R.drawable.filter_water);
}
else if(check1.equals("IDCARD")){
    Viewholder.text_timeline_title.setText("ถ่ายรูปบัตรประชาชน");
    Viewholder.text_timeline_title.setTextColor(0xffB22222);
    Viewholder.VollyNetworkImageView1.setBackgroundResource(R.drawable.ic_camera);
    Viewholder.VollyNetworkImageView1.setBackgroundTintList(ColorStateList.valueOf(0xFFA9A9A9));
    Viewholder.titel.setBackgroundResource(R.drawable.id_card);

}
else if(check1.equals("MAP")){
    Viewholder.text_timeline_title.setText("ตรวจสอบตำแหน่ง");
    Viewholder.text_timeline_title.setTextColor(0xff988a62);
    Viewholder.VollyNetworkImageView1.setBackgroundResource(R.drawable.ic_maps_place);
    Viewholder.VollyNetworkImageView1.setBackgroundTintList(ColorStateList.valueOf(0xFFFFA500));

    Viewholder.titel.setBackgroundResource(0);
}












        try {
            String date=getDataAdapter1.getDate();
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
    Viewholder.text_timeline_title2.setText(date_new_format_thai2);
    Viewholder.icon_time.setBackgroundResource(R.drawable.ic_access_time_black_24dp);
    Log.e("TIME",date_new_format_thai2);
}
else {
    Viewholder.text_timeline_title2.setText(dateThai_day+" "+dateThai_month1+converted_dateThai11);
    Viewholder.icon_time.setBackgroundResource(0);
    Log.e("dateThai",dateThai_day+""+dateThai_month1+""+converted_dateThai11+"");
}


            }
        }
        catch (Exception ex){

        }
















        Viewholder.feed = getDataAdapter1;

    }

    @Override
    public int getItemCount() {

        return getDataAdapter.size();
    }


    @Override
    public Filter getFilter() {
        if(userFilter!=null){
            userFilter=new RecyclerViewAdapter_history.UserFilter(this,getDataAdapter);
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



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener,View.OnClickListener  {

        public android.support.v7.widget.AppCompatTextView txt_conno,text_timeline_title,text_timeline_title2;
        public com.github.vipulasri.timelineview.TimelineView time_marker;
        public ImageView VollyNetworkImageView1,titel,icon_time;
        public TextView check_location;
        public TextView report_problem;
        public TextView picture_device;
        public TextView picture_location;
        public TextView Date;



        public GetData_cedit feed;
        public ViewHolder(View itemView) {

            super(itemView);






            txt_conno = (android.support.v7.widget.AppCompatTextView) itemView.findViewById(id.text_timeline_date) ;
            text_timeline_title= (android.support.v7.widget.AppCompatTextView) itemView.findViewById(id.text_timeline_title) ;
            text_timeline_title2= (android.support.v7.widget.AppCompatTextView) itemView.findViewById(id.text_timeline_title2) ;
            time_marker = (com.github.vipulasri.timelineview.TimelineView) itemView.findViewById(id.time_marker) ;
            VollyNetworkImageView1= (ImageView) itemView.findViewById(id.VollyNetworkImageView1) ;
            titel= (ImageView) itemView.findViewById(id.titel) ;
            icon_time= (ImageView) itemView.findViewById(id.icon_time) ;
          //  subteam = (TextView) itemView.findViewById(id.subteam) ;
          //  lbl_name = (TextView) itemView.findViewById(id.lbl_name) ;
          //  title = (TextView) itemView.findViewById(id.title) ;







            itemView.setOnLongClickListener(this);
            itemView.setOnClickListener(this);




        }



        @Override
        public void onClick(View view) {
            try {
                if(ic2!=null){
                    ic2.click2(itemView,getPosition());
                }
            }


            catch (Exception e) {

                e.printStackTrace();
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

        private final RecyclerViewAdapter_history adapter;

        private final List<GetData_cedit> originalList;

        private final List<GetData_cedit> filteredList;

        private UserFilter(RecyclerViewAdapter_history adapter, List<GetData_cedit> originalList) {
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
                for (final GetData_cedit user : originalList) {

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
                adapter.getDataAdapter.addAll((ArrayList<GetData_cedit>) results.values);
                adapter.notifyDataSetChanged();
            }
        }
    }



}
