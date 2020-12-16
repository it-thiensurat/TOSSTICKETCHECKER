package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters;
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
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_sale;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static com.tsr.tsrproblemreport_tossticket_checker.R.id;

/**
 * Created by JUNED on 6/16/2016.
 */
public class RecyclerViewAdapter_report_problem_edit extends RecyclerView.Adapter<RecyclerViewAdapter_report_problem_edit.ViewHolder> implements Filterable {


    public static Context context;
    List<GetData_sale> getDataAdapter;
    ImageLoader imageLoader1;

    int i = 0;







    String date_new_format_thai,date_new_format_thai2;
    String dateThai_year,dateThai_month,dateThai_day,dateThai_month1;
    int converted_dateThai11;
    private Date oneWayTripDate;
    String s1,s2,s3;






    int zine;
    private UserFilter userFilter;


    public RecyclerViewAdapter_report_problem_edit(List<GetData_sale> getDataAdapter, Context context){

        super();
        this.getDataAdapter = getDataAdapter;
        this.context = context;
        userFilter = new UserFilter(RecyclerViewAdapter_report_problem_edit.this,getDataAdapter);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {




        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.show_cardview_cedit2, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {

        GetData_sale getDataAdapter1 =  getDataAdapter.get(position);


        Viewholder.txt_conno.setText(getDataAdapter1.getCONTNO());
        Viewholder.txt_customer.setText(getDataAdapter1.getCustomerName());
        Viewholder.txt_address.setText(getDataAdapter1.getAddressDetail());














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



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener,View.OnClickListener  {


        public TextView txt_conno;
        public TextView txt_customer;
        public TextView txt_address;
        public TextView tv_distance;
        public TextView tv_date;
        public ImageView handleView;
        public ImageView handle2;
        public ImageView handle3;

        public GetData_sale feed;
        public ViewHolder(View itemView) {

            super(itemView);

            txt_conno = (TextView) itemView.findViewById(id.txt_conno) ;
            txt_customer = (TextView) itemView.findViewById(id.txt_customer) ;
            txt_address = (TextView) itemView.findViewById(id.txt_address) ;
            tv_distance= (TextView) itemView.findViewById(id.tv_distance) ;
            handleView = (ImageView) itemView.findViewById(id.handle);
            tv_date= (TextView) itemView.findViewById(id.tv_date) ;
            handle2= (ImageView) itemView.findViewById(id.handle2);
            handle3= (ImageView) itemView.findViewById(id.handle3);





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

        private final RecyclerViewAdapter_report_problem_edit adapter;

        private final List<GetData_sale> originalList;

        private final List<GetData_sale> filteredList;

        private UserFilter(RecyclerViewAdapter_report_problem_edit adapter, List<GetData_sale> originalList) {
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
                for (final GetData_sale user : originalList) {

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
                adapter.getDataAdapter.addAll((ArrayList<GetData_sale>) results.values);
                adapter.notifyDataSetChanged();
            }
        }
    }



}
