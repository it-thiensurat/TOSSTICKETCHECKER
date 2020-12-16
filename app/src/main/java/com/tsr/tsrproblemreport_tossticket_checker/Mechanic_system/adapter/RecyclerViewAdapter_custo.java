package com.tsr.tsrproblemreport_tossticket_checker.Mechanic_system.adapter;

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
import com.tsr.tsrproblemreport_tossticket_checker.Mechanic_system.model.Get_data_customer;

import com.tsr.tsrproblemreport_tossticket_checker.R;

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
public class RecyclerViewAdapter_custo extends RecyclerView.Adapter<RecyclerViewAdapter_custo.ViewHolder> implements Filterable {


    public static Context context;
    List<Get_data_customer> getDataAdapter;
    ImageLoader imageLoader1;

    int i = 0;







    String date_new_format_thai,date_new_format_thai2;
    String dateThai_year,dateThai_month,dateThai_day,dateThai_month1;
    int converted_dateThai11;
    private Date oneWayTripDate;
    String s1,s2,s3;






    int zine;
    private UserFilter userFilter;


    public RecyclerViewAdapter_custo(List<Get_data_customer> getDataAdapter, Context context){

        super();
        this.getDataAdapter = getDataAdapter;
        this.context = context;
        userFilter = new UserFilter(RecyclerViewAdapter_custo.this,getDataAdapter);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {




        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_machamic1, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {


        try {
            Get_data_customer getDataAdapter1 =  getDataAdapter.get(position);


            Viewholder.textViewTitle.setText(getDataAdapter1.getContno());
            Viewholder.textViewDescription.setText(getDataAdapter1.getCustomername());

            Viewholder.tel.setText(getDataAdapter1.getTelno());
            Viewholder.product.setText(getDataAdapter1.getProductname());

            try {
                String date=getDataAdapter1.getInstalldate();
                SimpleDateFormat input22 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat output22 = new SimpleDateFormat("yyyy-MM-dd");
                // SimpleDateFormat output33 = new SimpleDateFormat("HH:mm:ss");
                try {
                    oneWayTripDate = input22.parse(date);  // parse input

                    date_new_format_thai=output22.format(oneWayTripDate);

                    Viewholder.date.setText(date_new_format_thai);

                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
            catch (Exception ex){

            }








            Viewholder.feed = getDataAdapter1;
        }
        catch (Exception ex){

        }


    }

    @Override
    public int getItemCount() {

        return getDataAdapter.size();
        //return 4;
    }


    @Override
    public Filter getFilter() {
        if(userFilter!=null){
            userFilter=new RecyclerViewAdapter_custo.UserFilter(this,getDataAdapter);
        }

        return userFilter;

    }

    private  int poss;
    public void setPos(int pos) {
        this.poss = pos;
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


        public TextView textViewTitle,textViewDescription,tel,date,product;

        public  ImageView imageView4;

        public Get_data_customer feed;
        public ViewHolder(View itemView) {

            super(itemView);

            textViewTitle = (TextView) itemView.findViewById(id.textViewTitle) ;
            textViewDescription= (TextView) itemView.findViewById(id.textViewDescription) ;

            tel= (TextView) itemView.findViewById(id.tel) ;
            date= (TextView) itemView.findViewById(id.date) ;
            product= (TextView) itemView.findViewById(id.product) ;

          //  imageView4= (ImageView) itemView.findViewById(id.imageView4) ;





            itemView.setOnLongClickListener(this);
            itemView.setOnClickListener(this);


//chang_image();

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

        private final RecyclerViewAdapter_custo adapter;

        private final List<Get_data_customer> originalList;

        private final List<Get_data_customer> filteredList;

        private UserFilter(RecyclerViewAdapter_custo adapter, List<Get_data_customer> originalList) {
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
                for (final Get_data_customer user : originalList) {

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
                adapter.getDataAdapter.addAll((ArrayList<Get_data_customer>) results.values);
                adapter.notifyDataSetChanged();
            }
        }
    }
    public  void chang_image(String position){

    }



}
