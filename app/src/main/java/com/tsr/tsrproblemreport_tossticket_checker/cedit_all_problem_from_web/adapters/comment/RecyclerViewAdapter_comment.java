package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.comment;
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

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.Comment;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.CircleTransform;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.tsr.tsrproblemreport_tossticket_checker.R.id;

/**
 * Created by JUNED on 6/16/2016.
 */
public class RecyclerViewAdapter_comment extends RecyclerView.Adapter<RecyclerViewAdapter_comment.ViewHolder> implements Filterable {


    public static Context context;
    List<Comment> getDataAdapter;







    int zine;
    private UserFilter userFilter;


    public RecyclerViewAdapter_comment(List<Comment> getDataAdapter, Context context){

        super();
        this.getDataAdapter = getDataAdapter;
        this.context = context;
        userFilter = new UserFilter(RecyclerViewAdapter_comment.this,getDataAdapter);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {




        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.show_cardview_comment, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {

        Comment getDataAdapter1 =  getDataAdapter.get(position);


           Viewholder.position.setText(getDataAdapter1.getName_topic());
          // Viewholder.lbl_sale.setText(getDataAdapter1.getWorkCode());

           Viewholder.lbl_time.setText(getDataAdapter1.getDate_create());

           if((getDataAdapter1.getProblemDetail().equals("null"))|(getDataAdapter1.getProblemDetail().equals("-"))|(getDataAdapter1.getProblemDetail().equals(""))){
               if(getDataAdapter1.getWorkCode().equals("00")){
                   Viewholder.comment.setText("แจ้งปัญหา");
               }
               else if(getDataAdapter1.getWorkCode().equals("21")){
                   Viewholder.comment.setText("รับทราบปัญหา");
               }
               else if(getDataAdapter1.getWorkCode().equals("01")){
                   Viewholder.comment.setText("ส่งมอบหมายงานให้คนที่เกี่ยวข้อง");
               }
               else if(getDataAdapter1.getWorkCode().equals("02")){
                   Viewholder.comment.setText("ทำการแก้ไขปัญหา");
               }
               else if(getDataAdapter1.getWorkCode().equals("04")){
                   Viewholder.comment.setText("ทำการตรวจสอบปัญหา");
               }



           }
           else {
               Viewholder.comment.setText(getDataAdapter1.getProblemDetail());
           }


        if(getDataAdapter1.getWorkCode().equals("00")){
            Viewholder.lbl_sale.setText("พนักงานฝ่ายเครดิต");
        }
        else if(getDataAdapter1.getWorkCode().equals("21")){
            Viewholder.lbl_sale.setText("แอดมินกลาง");
            Viewholder.lenear_image.setVisibility(View.GONE);
        }
        else if(getDataAdapter1.getWorkCode().equals("01")){
               Viewholder.lbl_sale.setText("แอดมินกลาง");
            Viewholder.lenear_image.setVisibility(View.GONE);
        }
        else if(getDataAdapter1.getWorkCode().equals("02")){
            Viewholder.lbl_sale.setText("พนักงานฝ่ายขาย");
        }
        else if(getDataAdapter1.getWorkCode().equals("04")){
            Viewholder.lbl_sale.setText("พนักงานฝ่ายเครดิต");
            Viewholder.lenear_image.setVisibility(View.GONE);
        }





        try {
            Glide.with(context).load(getDataAdapter1.getPicture_topic())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(context))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                    .into(Viewholder.VollyNetworkImageView1);
        }
        catch (Exception e) {

        }


        try {
            Glide.with(context).load(getDataAdapter1.getImageUrl())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleTransform(context))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(0)
                    .into(Viewholder.image_url);
        }
        catch (Exception e) {

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
            userFilter=new RecyclerViewAdapter_comment.UserFilter(this,getDataAdapter);
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


        public TextView position;
        public TextView lbl_sale;
        public TextView comment;
        public TextView lbl_time;
        public ImageView VollyNetworkImageView1;
        public ImageView image_url;
        public LinearLayout lenear_image;
        public Comment feed;
        public ViewHolder(View itemView) {

            super(itemView);

            position = (TextView) itemView.findViewById(id.position) ;
            lbl_sale = (TextView) itemView.findViewById(id.lbl_sale) ;
            comment = (TextView) itemView.findViewById(id.comment) ;
            lbl_time= (TextView) itemView.findViewById(id.lbl_time) ;
            VollyNetworkImageView1= (ImageView) itemView.findViewById(id.VollyNetworkImageView1);
            image_url= (ImageView) itemView.findViewById(id.image_url);
            lenear_image= (LinearLayout) itemView.findViewById(id.lenear_image);




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

        private final RecyclerViewAdapter_comment adapter;

        private final List<Comment> originalList;

        private final List<Comment> filteredList;

        private UserFilter(RecyclerViewAdapter_comment adapter, List<Comment> originalList) {
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
                for (final Comment user : originalList) {

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
                adapter.getDataAdapter.addAll((ArrayList<Comment>) results.values);
                adapter.notifyDataSetChanged();
            }
        }
    }



}
