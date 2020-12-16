package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.recycleviewcomment;

import android.content.Context;
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
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tsr.tsrproblemreport_tossticket_checker.R;

import com.tsr.tsrproblemreport_tossticket_checker.other_all.CircleTransform;

import org.apache.commons.lang.StringEscapeUtils;

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
public class RecyclerViewAdapter_Comment4 extends RecyclerView.Adapter<RecyclerViewAdapter_Comment4.ViewHolder> implements Filterable {

    Context context;

    List<GetDataAdapter_comment4> getDataAdapter;

    ImageLoader imageLoader1;
    String s1,s2,s3,s4,s5,s6;
    int converted1,converted2,converted3,converted4,converted5,converted6;



    private UserFilter userFilter;





    String ggg;
    String CP;
    String date2;
    String STATUS;
    String date_new_format_thai,date_new_format_thai2;

    String dateThai_year,dateThai_month,dateThai_day,
            dateThai_year1,dateThai_month1,dateThai_day1,
            dateThai_year_null,dateThai_month_null,dateThai_day_null,
            dateThai_year_null1,dateThai_month_null1,dateThai_day_null1;



    int converted_dateThai1,converted_dateThai11;

    int i = 0;


    int zine;

    SimpleDateFormat input2;
    SimpleDateFormat output2;

    private Date oneWayTripDate;
    private Date oneWayTripDate1;
    private Date oneWayTripDate2;
    private Date oneWayTripDate3;



    public RecyclerViewAdapter_Comment4(List<GetDataAdapter_comment4> getDataAdapter, Context context){

        super();
        this.getDataAdapter = getDataAdapter;
        this.context = context;
        userFilter = new UserFilter(RecyclerViewAdapter_Comment4.this,getDataAdapter);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_cardview_comment, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {

        GetDataAdapter_comment4 getDataAdapter1 =  getDataAdapter.get(position);





        try {
            Glide.with(context).load(getDataAdapter1.getpicture())
                    .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(context))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(Viewholder.networkImageView);
        }


        catch (Exception e) {

        }






        Viewholder.lbl_sale.setText(getDataAdapter1.getnamethai());
        Viewholder.position.setText(getDataAdapter1.getposition());

       // Viewholder.refno.setText(getDataAdapter1.getrefno());
        Viewholder.comment.setText(StringEscapeUtils.unescapeJava(getDataAdapter1.getcomment()));
      //  Viewholder.lbl_time.setText(getDataAdapter1.getdatetime());








        /********************************************************************************/
        /* format วันที่*/






        String date11=getDataAdapter1.getdatetime()+"";


        SimpleDateFormat input22 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat output22 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            oneWayTripDate3 = input22.parse(date11);  // parse input

        } catch (ParseException e) {
            e.printStackTrace();
        }


        date_new_format_thai2=output22.format(oneWayTripDate3);


        if(date_new_format_thai2.indexOf(date_new_format_thai2) != -1) {
            String arr2[] = date_new_format_thai2.split("-");
            dateThai_year = arr2[0];
            dateThai_month = arr2[1];
            dateThai_day = arr2[2];


            converted_dateThai11 = Integer.parseInt(dateThai_year);
            converted_dateThai11 = converted_dateThai11 + 543;

            if (dateThai_month.equals("01")) {
                dateThai_month1 = "ม.ค.";
            } else if (dateThai_month.equals("02")) {
                dateThai_month1 = "ก.พ.";
            } else if (dateThai_month.equals("03")) {
                dateThai_month1 = "มี.ค.";
            } else if (dateThai_month.equals("04")) {
                dateThai_month1 = "เม.ย.";
            } else if (dateThai_month.equals("05")) {
                dateThai_month1 = "พ.ค.";
            } else if (dateThai_month.equals("06")) {
                dateThai_month1 = "มิ.ย.";
            } else if (dateThai_month.equals("07")) {
                dateThai_month1 = "ก.ค.";
            } else if (dateThai_month.equals("08")) {
                dateThai_month1 = "ส.ค.";
            } else if (dateThai_month.equals("09")) {
                dateThai_month1 = "ก.ย.";
            } else if (dateThai_month.equals("10")) {
                dateThai_month1 = "ต.ค.";
            } else if (dateThai_month.equals("11")) {
                dateThai_month1 = "พ.ย.";
            } else if (dateThai_month.equals("12")) {
                dateThai_month1 = "ธ.ค.";
            }


            Viewholder.lbl_time.setText(dateThai_day + " " + dateThai_month1 + converted_dateThai11);
            Log.e("dateThai", dateThai_day + "" + dateThai_month1 + "" + converted_dateThai11 + "");


        }

        /********************************************************************************/





















        Viewholder.feed = getDataAdapter1;

    }

    @Override
    public int getItemCount() {

        return getDataAdapter.size();
    }



    @Override
    public Filter getFilter() {
        if(userFilter!=null){
            userFilter=new UserFilter(this,getDataAdapter);
        }

        return userFilter;

    }








    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView lbl_sale;
        public TextView position;
       // public TextView refno;
        public TextView comment;
        public TextView lbl_time;
        public ImageView networkImageView ;



        public GetDataAdapter_comment4 feed;
        public ViewHolder(View itemView) {

            super(itemView);






            lbl_sale = (TextView) itemView.findViewById(id.lbl_sale) ;
            position= (TextView) itemView.findViewById(id.position) ;
           // refno = (TextView) itemView.findViewById(id.refno) ;
            comment = (TextView) itemView.findViewById(id.comment) ;
            lbl_time = (TextView) itemView.findViewById(id.lbl_time) ;

            networkImageView = (ImageView) itemView.findViewById(id.VollyNetworkImageView1) ;





            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
















                }
            });





        }
    }



    private static class UserFilter extends Filter {

        private final RecyclerViewAdapter_Comment4 adapter;

        private final List<GetDataAdapter_comment4> originalList;

        private final List<GetDataAdapter_comment4> filteredList;

        private UserFilter(RecyclerViewAdapter_Comment4 adapter, List<GetDataAdapter_comment4> originalList) {
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
                for (final GetDataAdapter_comment4 user : originalList) {
                    if ((user.getnamethai().toUpperCase()).contains(constraint.toString().toUpperCase()) ||
                            (user.getnamethai().toUpperCase()).contains(constraint.toString().toUpperCase()) ){
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
                adapter.getDataAdapter.addAll((ArrayList<GetDataAdapter_comment4>) results.values);
                adapter.notifyDataSetChanged();
            }
        }
    }
}

