package com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.StrictMode;
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
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.Get_data_type_check;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static com.tsr.tsrproblemreport_tossticket_checker.R.id;

/**
 * Created by JUNED on 6/16/2016.
 */
public class RecyclerViewAdapter_type_check_susscess extends RecyclerView.Adapter<RecyclerViewAdapter_type_check_susscess.ViewHolder> implements Filterable {


    public static Context context;
    List<Get_data_type_check> getDataAdapter;
    ImageLoader imageLoader1;

    int i = 0;







    String date_new_format_thai,date_new_format_thai2;
    String dateThai_year,dateThai_month,dateThai_day,dateThai_month1;
    int converted_dateThai11;
    private Date oneWayTripDate;
    String s1,s2,s3;






    int zine;
    private UserFilter userFilter;


    public RecyclerViewAdapter_type_check_susscess(List<Get_data_type_check> getDataAdapter, Context context){

        super();
        this.getDataAdapter = getDataAdapter;
        this.context = context;
        userFilter = new UserFilter(RecyclerViewAdapter_type_check_susscess.this,getDataAdapter);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {




        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.show_cardview_cedit3, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {

        Get_data_type_check getDataAdapter1 =  getDataAdapter.get(position);


            Viewholder.txt_conno.setText(getDataAdapter1.getProcessTypeID());
            Viewholder.txt_customer.setText(getDataAdapter1.getData());

            Viewholder.txt_connohh.setText(getDataAdapter1.getProblemDetail());
        Viewholder.txt_ProcessTypeName.setText(getDataAdapter1.getProcessTypeName());


        String TOPIC=getDataAdapter1.getProcessTypeID();

        Log.e("TOPIC",TOPIC);
        try {
          String  PositionCode= MyApplication.getInstance().getPrefManager().getPreferrence("SourceSystem");
            if(TOPIC.equals("นัดเก็บเงินงวด 2 (ภายใน 60 วัน)")){

                if(PositionCode.equals("Credit")){

                    String  getENTERDATE= getDataAdapter1.getENTERDATE()+"";

                            if(getENTERDATE.equals("null")){
                                Viewholder.edit.setVisibility(View.VISIBLE);
                            }
                            else {
                                Viewholder.edit.setVisibility(View.GONE);
                            }

                }
                else {
                    Viewholder.edit.setVisibility(View.GONE);
                }

            }
            else {
                Viewholder.edit.setVisibility(View.GONE);


            }

        }
        catch (Exception ex){

        }

        try {

            String DATA= getDataAdapter1.getAnswerID();

            if(DATA.equals("99")){
                Viewholder.txt_customer.setTextColor(0xfff40707);
            }
            else if(DATA.equals("10")){
                Viewholder.txt_customer.setTextColor(0xfff40707);
            }
            else if(DATA.equals("16")){
                Viewholder.txt_customer.setTextColor(0xfff40707);
            }
            else if(DATA.equals("20")){
                Viewholder.txt_customer.setTextColor(0xfff40707);
            }
            else if(DATA.equals("23")){
                Viewholder.txt_customer.setTextColor(0xfff40707);
            }
            else if(DATA.equals("36")){
                Viewholder.txt_customer.setTextColor(0xfff40707);
            }
            else {
                Viewholder.txt_customer.setTextColor(0xff2E8B57);

            }
        }
        catch (Exception ex){

        }




        String COUNT_IMAGE=getDataAdapter1.getItems();
        try {
            int int_count_image= Integer.parseInt(COUNT_IMAGE);
            if(int_count_image==1){
                Viewholder.image_problem_incorrect.setVisibility(View.VISIBLE);
                Viewholder.txt_count_image_error.setVisibility(View.GONE);
                Viewholder.li_image.setVisibility(View.VISIBLE);




                try {


                  //String url_image_ral="",url_image_ral2="";

                    Glide.with(context).load(getDataAdapter1.getURL())
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
            else if(int_count_image>1){
                Viewholder.txt_count_image_error.setVisibility(View.VISIBLE);
                Viewholder.txt_count_image_error.setText("+ "+getDataAdapter1.getItems());
                Viewholder.image_problem_incorrect.setVisibility(View.VISIBLE);
                Viewholder.li_image.setVisibility(View.VISIBLE);

                try {


                    Glide.with(context).load(getDataAdapter1.getURL())
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
                Viewholder.txt_count_image_error.setVisibility(View.GONE);
                Viewholder.image_problem_incorrect.setVisibility(View.GONE);
                Viewholder.li_image.setVisibility(View.GONE);
            }
        }
        catch (Exception e){

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
            userFilter=new RecyclerViewAdapter_type_check_susscess.UserFilter(this,getDataAdapter);
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

    private RecyclerViewAdapter_type_check_susscess.itemclick_image_problem_incorrect ic_image_problem_incorrect;
    public void setitemclick_image_problem_incorrect(RecyclerViewAdapter_type_check_susscess.itemclick_image_problem_incorrect image_problem_incorrect){
        this.ic_image_problem_incorrect=image_problem_incorrect;
    }
    public interface itemclick_image_problem_incorrect{
        void click_image_problem_incorrect(View v, int position);
    }




    private RecyclerViewAdapter_type_check_susscess.itemclick_edit ic_edit;
    public void setitemclick_edit(RecyclerViewAdapter_type_check_susscess.itemclick_edit edit){
        this.ic_edit=edit;
    }
    public interface itemclick_edit{
        void click_edit(View v, int position);
    }




    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener,View.OnClickListener  {


        public TextView txt_conno,txt_connohh;
        public TextView txt_customer;
        public TextView txt_count_image_error,txt_ProcessTypeName;
        public ImageView image_problem_incorrect;
        public LinearLayout li_image;


        public ImageView edit;




        public Get_data_type_check feed;
        public ViewHolder(View itemView) {

            super(itemView);

            txt_conno = (TextView) itemView.findViewById(id.txt_conno) ;
            txt_customer = (TextView) itemView.findViewById(id.txt_customer) ;
            txt_count_image_error = (TextView) itemView.findViewById(id.txt_count_image_error) ;
            image_problem_incorrect= (ImageView) itemView.findViewById(id.image_problem_incorrect) ;
            txt_connohh = (TextView) itemView.findViewById(id.txt_connohh) ;
            txt_ProcessTypeName= (TextView) itemView.findViewById(id.txt_ProcessTypeName) ;
            li_image= (LinearLayout) itemView.findViewById(id.li_image) ;


            edit = (ImageView) itemView.findViewById(id.edit) ;




            image_problem_incorrect.setOnClickListener(this);
            edit.setOnClickListener(this);

            itemView.setOnLongClickListener(this);
            itemView.setOnClickListener(this);




        }



        @Override
        public void onClick(View view) {

            if (view == image_problem_incorrect) {
                try {
                    if (ic_image_problem_incorrect != null) {
                        ic_image_problem_incorrect.click_image_problem_incorrect(image_problem_incorrect, getPosition());
                    }
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }

           else if (view == edit) {
                try {
                    if (ic_edit != null) {
                        ic_edit.click_edit(edit, getPosition());
                    }
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }

            else {
                try {
                    if (ic2 != null) {
                        ic2.click2(itemView, getPosition());
                    }
                } catch (Exception e) {

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

        private final RecyclerViewAdapter_type_check_susscess adapter;

        private final List<Get_data_type_check> originalList;

        private final List<Get_data_type_check> filteredList;

        private UserFilter(RecyclerViewAdapter_type_check_susscess adapter, List<Get_data_type_check> originalList) {
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
                for (final Get_data_type_check user : originalList) {

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
                adapter.getDataAdapter.addAll((ArrayList<Get_data_type_check>) results.values);
                adapter.notifyDataSetChanged();
            }
        }
    }



}
