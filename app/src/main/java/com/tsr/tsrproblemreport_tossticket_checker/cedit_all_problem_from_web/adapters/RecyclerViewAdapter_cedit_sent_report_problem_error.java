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
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_sale_recive_problem;

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
public class RecyclerViewAdapter_cedit_sent_report_problem_error extends RecyclerView.Adapter<RecyclerViewAdapter_cedit_sent_report_problem_error.ViewHolder> implements Filterable {


    public static Context context;
    List<GetData_cedit_sale_recive_problem> getDataAdapter;
    ImageLoader imageLoader1;

    int i = 0;







    String date_new_format_thai,date_new_format_thai2;
    String dateThai_year,dateThai_month,dateThai_day,dateThai_month1;
    int converted_dateThai11;
    private Date oneWayTripDate;
    String s1,s2,s3;
    private Date oneWayTripDate3;





    int zine;
    private UserFilter userFilter;


    public RecyclerViewAdapter_cedit_sent_report_problem_error(List<GetData_cedit_sale_recive_problem> getDataAdapter, Context context){

        super();
        this.getDataAdapter = getDataAdapter;
        this.context = context;
        userFilter = new UserFilter(RecyclerViewAdapter_cedit_sent_report_problem_error.this,getDataAdapter);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {




        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.show_cardview_sale_recive, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {

        GetData_cedit_sale_recive_problem getDataAdapter1 =  getDataAdapter.get(position);


       // Viewholder.txt_InformID.setText(getDataAdapter1.getInformID());
        Viewholder.txt_conno.setText(getDataAdapter1.getContno());
        Viewholder.txt_customer.setText(getDataAdapter1.getCustomerName());
        Viewholder.txt_address.setText(getDataAdapter1.getAddressDetail());
        Viewholder.count.setText(getDataAdapter1.getCount_problem());
        Viewholder.tv_distance.setText("~ "+getDataAdapter1.getDistant()+" Km");
        Viewholder.txt_phone.setText(getDataAdapter1.getTelHome()+","+getDataAdapter1.getTelMobile());
        Viewholder.txt_productname.setText(getDataAdapter1.getProductName());
        Viewholder.total.setText(getDataAdapter1.getTotalPrice()+" บาท");

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
            String date11=getDataAdapter1.getDate_createString()+"";


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




                Viewholder.tv_date.setText(dateThai_day+" "+dateThai_month1+converted_dateThai11);
                Log.e("dateThai",dateThai_day+""+dateThai_month1+""+converted_dateThai11+"");
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
            userFilter=new UserFilter(this,getDataAdapter);
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


    private RecyclerViewAdapter_cedit_sent_report_problem_error.itemclick_navigate ic_navigate;
    public void setitemclick_navigate(RecyclerViewAdapter_cedit_sent_report_problem_error.itemclick_navigate navigate){
        this.ic_navigate=navigate;
    }
    public interface itemclick_navigate{


        void click_navigate(View v, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener,View.OnClickListener  {

        public TextView txt_InformID;
        public TextView txt_conno;
        public TextView txt_customer;
        public TextView txt_address;
        public TextView tv_distance;
        public TextView tv_date;
        public ImageView handleView;
        public ImageView handle2;
        public ImageView handle3;
        public TextView count;
        public TextView txt_phone;
        public TextView txt_productname;
        public TextView total;
        public ImageView navigate;
        public LinearLayout linear_Informitem;
        public  TextView txt_Informitem;
        public GetData_cedit_sale_recive_problem feed;
        public ViewHolder(View itemView) {

            super(itemView);
            txt_InformID = (TextView) itemView.findViewById(id.txt_InformID) ;
            txt_conno = (TextView) itemView.findViewById(id.txt_conno) ;
            txt_customer = (TextView) itemView.findViewById(id.txt_customer) ;
            txt_address = (TextView) itemView.findViewById(id.txt_address) ;
            tv_distance= (TextView) itemView.findViewById(id.tv_distance) ;
            handleView = (ImageView) itemView.findViewById(id.handle);
            tv_date= (TextView) itemView.findViewById(id.tv_date) ;
            handle2= (ImageView) itemView.findViewById(id.handle2);
            handle3= (ImageView) itemView.findViewById(id.handle3);
            count= (TextView) itemView.findViewById(id.count) ;
            txt_phone= (TextView) itemView.findViewById(id.txt_phone) ;
            txt_productname= (TextView) itemView.findViewById(id.txt_productname) ;
            total= (TextView) itemView.findViewById(id.total) ;
            navigate= (ImageView) itemView.findViewById(id.navigate);
            linear_Informitem= (LinearLayout) itemView.findViewById(id.linear_Informitem) ;
            txt_Informitem= (TextView) itemView.findViewById(id.txt_Informitem) ;

            itemView.setOnLongClickListener(this);
            itemView.setOnClickListener(this);
            navigate.setOnClickListener(this);



        }



        @Override
        public void onClick(View view) {
            if(view==navigate){
                try {
                    if(ic_navigate!=null){
                        ic_navigate.click_navigate(navigate,getPosition());
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

        private final RecyclerViewAdapter_cedit_sent_report_problem_error adapter;

        private final List<GetData_cedit_sale_recive_problem> originalList;

        private final List<GetData_cedit_sale_recive_problem> filteredList;

        private UserFilter(RecyclerViewAdapter_cedit_sent_report_problem_error adapter, List<GetData_cedit_sale_recive_problem> originalList) {
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
                for (final GetData_cedit_sale_recive_problem user : originalList) {

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
                adapter.getDataAdapter.addAll((ArrayList<GetData_cedit_sale_recive_problem>) results.values);
                adapter.notifyDataSetChanged();
            }
        }
    }



}
