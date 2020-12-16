package com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;

import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.Get_data_confirm;
import com.tsr.tsrproblemreport_tossticket_checker.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static com.tsr.tsrproblemreport_tossticket_checker.R.id;

/**
 * Created by JUNED on 6/16/2016.
 */
public class RecyclerViewAdapter_confirm extends RecyclerView.Adapter<RecyclerViewAdapter_confirm.ViewHolder> implements Filterable {


    public static Context context;
    List<Get_data_confirm> getDataAdapter;
    ImageLoader imageLoader1;

    int i = 0;







    String date_new_format_thai,date_new_format_thai2;
    String dateThai_year,dateThai_month,dateThai_day,dateThai_month1;
    int converted_dateThai11;
    private Date oneWayTripDate;
    String s1,s2,s3;






    int zine;
    private UserFilter userFilter;


    public RecyclerViewAdapter_confirm(List<Get_data_confirm> getDataAdapter, Context context){

        super();
        this.getDataAdapter = getDataAdapter;
        this.context = context;
        userFilter = new UserFilter(RecyclerViewAdapter_confirm.this,getDataAdapter);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {




        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_table, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {

        Get_data_confirm getDataAdapter1 =  getDataAdapter.get(position);

if(position==0){
    Viewholder.txt_PaymentPeriodNumber.setText("งวดที่");
    Viewholder.txt_PaymentAmount.setText("ยอดค่างวด");
    Viewholder.txt_Discount.setText("ส่วนลด");
    Viewholder.txt_NetAmount.setText("ค่างวด");
    Viewholder.txt_PaymentComplete.setText("สถานะ");

    Viewholder.tata.setBackgroundColor(0xff9370DB);
}
else {
    Viewholder.txt_PaymentPeriodNumber.setText(getDataAdapter1.getPaymentPeriodNumber());
    Viewholder.txt_PaymentAmount.setText(getDataAdapter1.getPaymentAmount());
    Viewholder.txt_Discount.setText(getDataAdapter1.getDiscount());
    Viewholder.txt_NetAmount.setText(getDataAdapter1.getNetAmount());



    if(getDataAdapter1.getPaymentComplete().equals("1")){
        Viewholder.txt_PaymentComplete.setText("ชำระแล้ว");
        Viewholder.txt_PaymentComplete.setTextColor(0xff26ae90);
    }
    else {
        Viewholder.txt_PaymentComplete.setText("ยังไม่ชำระ");
        Viewholder.txt_PaymentComplete.setTextColor(0xffFE6767);
    }



    for(position=1;position<=getDataAdapter.size();position++){
        if(i%2==0){
            Viewholder.tata.setBackgroundColor(0xff87ceeb);
        }
        else {
            Viewholder.tata.setBackgroundColor(0xff4682B4);
        }
    }
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
            userFilter=new RecyclerViewAdapter_confirm.UserFilter(this,getDataAdapter);
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


        public TextView txt_PaymentPeriodNumber;
        public TextView txt_PaymentAmount;
        public TextView txt_Discount;
        public TextView txt_NetAmount;
        public TextView txt_PaymentComplete;
        public TableRow tata;




        public Get_data_confirm feed;
        public ViewHolder(View itemView) {

            super(itemView);

            txt_PaymentPeriodNumber = (TextView) itemView.findViewById(id.txt_PaymentPeriodNumber) ;
            txt_PaymentAmount = (TextView) itemView.findViewById(id.txt_PaymentAmount) ;
            txt_Discount = (TextView) itemView.findViewById(id.txt_Discount) ;
            txt_NetAmount = (TextView) itemView.findViewById(id.txt_NetAmount) ;
            txt_PaymentComplete = (TextView) itemView.findViewById(id.txt_PaymentComplete) ;
            tata= (TableRow) itemView.findViewById(id.tata) ;







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

        private final RecyclerViewAdapter_confirm adapter;

        private final List<Get_data_confirm> originalList;

        private final List<Get_data_confirm> filteredList;

        private UserFilter(RecyclerViewAdapter_confirm adapter, List<Get_data_confirm> originalList) {
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
                for (final Get_data_confirm user : originalList) {

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
                adapter.getDataAdapter.addAll((ArrayList<Get_data_confirm>) results.values);
                adapter.notifyDataSetChanged();
            }
        }
    }



}
