package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters;

import android.content.Context;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.github.vipulasri.timelineview.TimelineView;
import com.tsr.tsrproblemreport_tossticket_checker.R;

import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.ExpandableLayout;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.utils.VectorDrawableUtils;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import static com.tsr.tsrproblemreport_tossticket_checker.R.id;

/**
 * Created by JUNED on 6/16/2016.
 */
public class RecyclerViewAdapter_history_problem extends RecyclerView.Adapter<RecyclerViewAdapter_history_problem.ViewHolder> implements Filterable {


    public static Context context;
    List<GetData_cedit> getDataAdapter;
    ImageLoader imageLoader1;
    private HashSet<Integer> expandedPositionSet;
    int i = 0;







    String date_new_format_thai,date_new_format_thai2;
    String dateThai_year,dateThai_month,dateThai_day,dateThai_month1,isremark1="",isremark="",Description;
    int converted_dateThai11;
    private Date oneWayTripDate;
    String s1,s2,s3;

    TextView myTextViews ;

LinearLayout linearLayout;


    int zine;
    private UserFilter userFilter;


    public RecyclerViewAdapter_history_problem(List<GetData_cedit> getDataAdapter, Context context){

        super();
        this.getDataAdapter = getDataAdapter;

        expandedPositionSet = new HashSet<>();
        this.context = context;
        userFilter = new UserFilter(RecyclerViewAdapter_history_problem.this,getDataAdapter);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


       // View v = layoutInflater.inflate(viewType == 0 ? R.layout.item_odd : R.layout.item_even, parent, false);


        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_timeline2, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {
        Viewholder.updateItem(position);

        GetData_cedit timeLineModel = getDataAdapter.get(position);
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






        Viewholder.text_timeline_date.setText(getDataAdapter1.getconno2());
        Viewholder.text_timeline_title.setText("กลุ่มปัญหา : "+getDataAdapter1.getGroupID());



        Description=getDataAdapter1.getIssueGroupName();





        if(Description.indexOf(Description) != -1) {
            String arr2[] = Description.split(",");
            zine=arr2.length;
            StringBuilder DF = new StringBuilder();
            String arr_isremark[] = isremark.split(",");
            //String arr_isremark1[] = null;
            for(int i=0;i < arr2.length; i++){
                DF.append(arr2[i]);
                DF.append("\n");




                if(isremark1.equals("null")){
                    myTextViews = new TextView(context);
                    myTextViews.setText(arr2[i]);
                    myTextViews.setTextColor(0XFF000000);
                }
                else {

                    if(isremark.equals(isremark1)){
                        myTextViews = new TextView(context);
                        myTextViews.setText(arr2[i]);
                        myTextViews.setTextColor(0XFF5990c6);
                    }
                    else {
                        if (isremark1.indexOf(",") < 0) {
                            myTextViews = new TextView(context);
                            if (isremark1.equals(arr_isremark[i])) {
                                myTextViews.setText(arr2[i]);
                                myTextViews.setTextColor(0XFF000000);
                            } else {
                                myTextViews.setText(arr2[i]);
                                myTextViews.setTextColor(0XFF5990c6);
                            }
                        } else {
                            String arr_isremark1[] = isremark1.split(",");
                            myTextViews = new TextView(context);
                            int indexResult = Arrays.binarySearch(arr_isremark, arr_isremark1[i]);
                            if (indexResult == i) {
                                myTextViews.setText(arr2[i]);
                                myTextViews.setTextColor(0XFF000000);
                            } else {
                                myTextViews.setText(arr2[i]);
                                myTextViews.setTextColor(0XFF5990c6);
                            }
                        }
                    }


                }

                Viewholder.ezreal_story.setText("รายการ :");

                Viewholder.linearLayout.addView(myTextViews);
            }

        }
















        //Viewholder.text_timeline_title2.setText("12:00:00");
        Viewholder.time_marker.setMarker(VectorDrawableUtils.getDrawable(context, R.drawable.ic_marker_active, R.color.black));

     //   Viewholder.text_timeline_title.setText("กลุ่มปัญหา : "+getDataAdapter1.getGroupID());












        try {

            String date=getDataAdapter1.getCreatedate()+"";
            Log.e("datedate",date);
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

                Log.e("s123",dateThai_day+dateThai_month+dateThai_year+","+s1+s2+s3);
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
    public int getItemViewType(int position) {
        return position % 2;
    }

    @Override
    public int getItemCount() {

        return getDataAdapter.size();
    }


    @Override
    public Filter getFilter() {
        if(userFilter!=null){
            userFilter=new RecyclerViewAdapter_history_problem.UserFilter(this,getDataAdapter);
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

        public android.support.v7.widget.AppCompatTextView text_timeline_date,text_timeline_title,text_timeline_title2;

        public TimelineView time_marker;
        public ImageView VollyNetworkImageView1,titel,icon_time;
        //public TextView check_location;
        //public TextView report_problem;
        //public TextView picture_device;
        //public TextView picture_location;
      //  public TextView Date;


        private ExpandableLayout expandableLayout;
        private TextView showInfo,ezreal_story;
        private LinearLayout linearLayout;
        private  ImageView image;

        public GetData_cedit feed;
        public ViewHolder(View itemView) {

            super(itemView);






            text_timeline_date = (android.support.v7.widget.AppCompatTextView) itemView.findViewById(id.text_timeline_date) ;

            text_timeline_title= (android.support.v7.widget.AppCompatTextView) itemView.findViewById(id.text_timeline_title) ;
            text_timeline_title2= (android.support.v7.widget.AppCompatTextView) itemView.findViewById(id.text_timeline_title2) ;
            time_marker = (TimelineView) itemView.findViewById(id.time_marker) ;
           VollyNetworkImageView1= (ImageView) itemView.findViewById(id.VollyNetworkImageView1) ;
          //  titel= (ImageView) itemView.findViewById(id.titel) ;
           icon_time= (ImageView) itemView.findViewById(id.icon_time) ;
            //  subteam = (TextView) itemView.findViewById(id.subteam) ;
            //  lbl_name = (TextView) itemView.findViewById(id.lbl_name) ;
            //  title = (TextView) itemView.findViewById(id.title) ;

            image= (ImageView) itemView.findViewById(id.image) ;
            expandableLayout = (ExpandableLayout) itemView.findViewById(id.expandable_layout);
            showInfo = (TextView) itemView.findViewById(id.show_info);
            ezreal_story= (TextView) itemView.findViewById(id.ezreal_story);


            linearLayout=(LinearLayout)itemView.findViewById(id.linearLayout);
            itemView.setOnLongClickListener(this);
            itemView.setOnClickListener(this);




        }


        private void updateItem(final int position) {
            expandableLayout.setOnExpandListener(new ExpandableLayout.OnExpandListener() {
                @Override
                public void onExpand(boolean expanded) {
                    registerExpand(position, showInfo);
                }
            });
            expandableLayout.setExpand(expandedPositionSet.contains(position));

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

    private void registerExpand(int position, TextView textView) {
        if (expandedPositionSet.contains(position)) {
            removeExpand(position);
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_keyboard_arrow_down_black_24dp, 0);
            textView.setText("");
           // Toast.makeText(context, "Position: " + position + " collapsed!", Toast.LENGTH_SHORT).show();
        } else {
            addExpand(position);
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_keyboard_arrow_up_black_24dp, 0);
            textView.setText("");

           // Toast.makeText(context, "Position: " + position + " expanded!", Toast.LENGTH_SHORT).show();
        }
    }

    private void removeExpand(int position) {
        expandedPositionSet.remove(position);
    }

    private void addExpand(int position) {
        expandedPositionSet.add(position);
    }
    private static class UserFilter extends Filter {

        private final RecyclerViewAdapter_history_problem adapter;

        private final List<GetData_cedit> originalList;

        private final List<GetData_cedit> filteredList;

        private UserFilter(RecyclerViewAdapter_history_problem adapter, List<GetData_cedit> originalList) {
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
