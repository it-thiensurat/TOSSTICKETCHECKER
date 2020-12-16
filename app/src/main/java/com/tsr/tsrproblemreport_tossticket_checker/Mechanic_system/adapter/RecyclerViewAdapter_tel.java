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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.tsr.tsrproblemreport_tossticket_checker.Mechanic_system.model.Get_data_tel;
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
public class RecyclerViewAdapter_tel extends RecyclerView.Adapter<RecyclerViewAdapter_tel.ViewHolder> implements Filterable {


    public static Context context;
    List<Get_data_tel> getDataAdapter;
    ImageLoader imageLoader1;

    int i = 0;







    String date_new_format_thai,date_new_format_thai2;
    String dateThai_year,dateThai_month,dateThai_day,dateThai_month1;
    int converted_dateThai11;
    private Date oneWayTripDate;
    String s1,s2,s3;






    int zine;
    private UserFilter userFilter;


    public RecyclerViewAdapter_tel(List<Get_data_tel> getDataAdapter, Context context){

        super();
        this.getDataAdapter = getDataAdapter;
        this.context = context;
        userFilter = new UserFilter(RecyclerViewAdapter_tel.this,getDataAdapter);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {




        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_machamic2, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {


        try {
            Get_data_tel getDataAdapter1 =  getDataAdapter.get(position);


            if(position==0){
                  Viewholder.li1.setVisibility(View.VISIBLE);
                Viewholder.li2.setVisibility(View.VISIBLE);

                Viewholder.li3.setVisibility(View.GONE);
            }
            else {
                Viewholder.li1.setVisibility(View.GONE);
                Viewholder.li2.setVisibility(View.GONE);
                Viewholder.li3.setVisibility(View.VISIBLE);

                Viewholder.tee.setText("เบอร์ที่ : "+position);
            }



            Viewholder.textViewTitle.setText(getDataAdapter1.getTel());

            Viewholder.custom.setText(getDataAdapter1.getNAME());
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
            userFilter=new RecyclerViewAdapter_tel.UserFilter(this,getDataAdapter);
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







    private itemclick3 ic3;
    public void setitemclick3(itemclick3 ic3){
        this.ic3=ic3;
    }
    public interface itemclick3{


        void click3(View v, int position);
    }




    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener,View.OnClickListener  {


        public TextView textViewTitle,textViewDescription,tee;

        public  ImageView imageView4;
        public TextView  custom,date,product;
        LinearLayout li1,li2,li3;

        public Get_data_tel feed;
        public ViewHolder(View itemView) {

            super(itemView);

            textViewTitle = (TextView) itemView.findViewById(id.textViewTitle) ;
            tee= (TextView) itemView.findViewById(id.tee) ;

            li1 = (LinearLayout) itemView.findViewById(id.li1) ;
          li2 = (LinearLayout) itemView.findViewById(id.li2) ;
            li3 = (LinearLayout) itemView.findViewById(id.li3) ;


            custom= (TextView) itemView.findViewById(id.custom) ;
            date= (TextView) itemView.findViewById(id.date) ;
            product= (TextView) itemView.findViewById(id.product) ;


            itemView.setOnLongClickListener(this);
            itemView.setOnClickListener(this);
          //  li2.setOnClickListener(this);


//chang_image();

        }



        @Override
        public void onClick(View view) {


      /*      if(view==li2){
                try {
                    if(ic3!=null){
                        ic3.click3(li2,getPosition());
                    }
                }


                catch (Exception e) {

                    e.printStackTrace();
                }
            }
            else {*/
                try {
                    if(ic2!=null){
                        ic2.click2(itemView,getPosition());
                    }
                }


                catch (Exception e) {

                    e.printStackTrace();
                }
            //}

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

        private final RecyclerViewAdapter_tel adapter;

        private final List<Get_data_tel> originalList;

        private final List<Get_data_tel> filteredList;

        private UserFilter(RecyclerViewAdapter_tel adapter, List<Get_data_tel> originalList) {
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
                for (final Get_data_tel user : originalList) {

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
                adapter.getDataAdapter.addAll((ArrayList<Get_data_tel>) results.values);
                adapter.notifyDataSetChanged();
            }
        }
    }
    public  void chang_image(String position){

    }



}
