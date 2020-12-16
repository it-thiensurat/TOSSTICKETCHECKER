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
        import android.widget.RelativeLayout;
        import android.widget.TextView;

        import com.android.volley.toolbox.ImageLoader;
        import com.bumptech.glide.Glide;
        import com.bumptech.glide.load.engine.DiskCacheStrategy;
        import com.tsr.tsrproblemreport_tossticket_checker.R;
        import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_check_problem;
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
public class RecyclerViewAdapter_check_problem_new extends RecyclerView.Adapter<RecyclerViewAdapter_check_problem_new.ViewHolder> implements Filterable {


    public static Context context;
    List<GetData_check_problem> getDataAdapter;
    ImageLoader imageLoader1;

    int i = 0;
    private int layout1 = 100;
    private int layout2 = 101;






    String date_new_format_thai,date_new_format_thai2;
    String dateThai_year,dateThai_month,dateThai_day,dateThai_month1;
    int converted_dateThai11;
    private Date oneWayTripDate;
    String s1,s2,s3;






    int zine;
    private UserFilter userFilter;
    View v;

    public RecyclerViewAdapter_check_problem_new(List<GetData_check_problem> getDataAdapter, Context context){

        super();
        this.getDataAdapter = getDataAdapter;
        this.context = context;
        userFilter = new UserFilter(RecyclerViewAdapter_check_problem_new.this,getDataAdapter);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == layout1) {
            // self message
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.show_checkbox_cardview_cedit_new_real, parent, false);
        }
        else if (viewType == layout2) {
            // self message
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.show_checkbox_cardview_cedit_new_real2, parent, false);
        }


        //View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.show_checkbox_cardview_cedit_new_real, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;


    }




    @Override
    public int getItemViewType(int position) {
        GetData_check_problem message = getDataAdapter.get(position);
        try {
            if (!message.getImage().equals("null")) {
                return layout1;
            }
            else  {
                return layout2;
            }

        }
        catch (Exception e) {

        }



        return position;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {

        GetData_check_problem getDataAdapter1 =  getDataAdapter.get(position);


        Viewholder.txt_category.setText(getDataAdapter1.getCategory());



        if(getDataAdapter1.getMain_problems().equals("NULL")){
            Viewholder.txt_main_problem.setText("-");
        }
        else {
            Viewholder.txt_main_problem.setText(getDataAdapter1.getMain_problems());
        }


        if(getDataAdapter1.getSub_problems().equals("NULL")){
            Viewholder.txt_sub_problem.setText("-");
        }
        else {
            Viewholder.txt_sub_problem.setText(getDataAdapter1.getSub_problems());
        }

        if(getDataAdapter1.getSubject().equals("NULL")){
            Viewholder.txt_topic.setText("-");
        }
        else {
            Viewholder.txt_topic.setText("ปัญหา"+getDataAdapter1.getSubject());
        }



        Viewholder.new_message.setText(getDataAdapter1.getProblemDetail());

        String COUNT_IMAGE=getDataAdapter1.getCount_image();
        try {
            int int_count_image= Integer.parseInt(COUNT_IMAGE);
            if(int_count_image>1){
                Viewholder.txt_count_image_error.setVisibility(View.VISIBLE);
                Viewholder.txt_count_image_error.setText("+ "+getDataAdapter1.getCount_image());
            }
            else {
                Viewholder.txt_count_image_error.setVisibility(View.GONE);
            }
        }
        catch (Exception e){

        }




        try {
            Glide.with(context).load(getDataAdapter1.getImage())



                    .crossFade()
                    .thumbnail(0.5f)
                    // .bitmapTransform(new CircleTransform(context))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                    .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                    .into(Viewholder.image_problem_incorrect);
        }
        catch (Exception e) {

        }



        try {
            String date=getDataAdapter1.getDatetime();
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
                    Viewholder.txt_datetime.setText(date_new_format_thai2);
                    //Viewholder.icon_time.setBackgroundResource(R.drawable.ic_access_time_black_24dp);
                    //Log.e("TIME",date_new_format_thai2);
                }
                else {
                    Viewholder.txt_datetime.setText(dateThai_day+" "+dateThai_month1+converted_dateThai11);
                    //  Viewholder.icon_time.setBackgroundResource(0);
                    // Log.e("dateThai",dateThai_day+""+dateThai_month1+""+converted_dateThai11+"");
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
            userFilter=new RecyclerViewAdapter_check_problem_new.UserFilter(this,getDataAdapter);
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





    private RecyclerViewAdapter_check_problem_new.itemclick_deleteAll ic_deleteAll;
    public void setitemclick_deleteAll(RecyclerViewAdapter_check_problem_new.itemclick_deleteAll deleteAll){
        this.ic_deleteAll=deleteAll;
    }
    public interface itemclick_deleteAll{
        void click_deleteAll(View v, int position);
    }


    private RecyclerViewAdapter_check_problem_new.itemclick_image_problem_incorrect ic_image_problem_incorrect;
    public void setitemclick_image_problem_incorrect(RecyclerViewAdapter_check_problem_new.itemclick_image_problem_incorrect image_problem_incorrect){
        this.ic_image_problem_incorrect=image_problem_incorrect;
    }
    public interface itemclick_image_problem_incorrect{
        void click_image_problem_incorrect(View v, int position);
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener,View.OnClickListener  {


        public TextView txt_category;
        public TextView txt_main_problem;
        public TextView txt_sub_problem;
        public TextView txt_topic;
        public TextView txt_datetime;
        public TextView new_message;
        public ImageView image_problem_incorrect;
        public TextView  txt_count_image_error;
        public RelativeLayout deleteAll;

        public GetData_check_problem feed;
        public ViewHolder(View itemView) {

            super(itemView);

            txt_category = (TextView) itemView.findViewById(id.txt_category) ;
            txt_main_problem = (TextView) itemView.findViewById(id.txt_main_problem) ;
            txt_sub_problem = (TextView) itemView.findViewById(id.txt_sub_problem) ;
            txt_topic = (TextView) itemView.findViewById(id.txt_topic) ;
            txt_datetime = (TextView) itemView.findViewById(id.txt_datetime) ;
            new_message= (TextView) itemView.findViewById(id.new_message) ;
            image_problem_incorrect= (ImageView) itemView.findViewById(id.image_problem_incorrect) ;
            txt_count_image_error= (TextView) itemView.findViewById(id.txt_count_image_error) ;
            deleteAll= (RelativeLayout) itemView.findViewById(id.deleteAll) ;

            //itemView.setOnLongClickListener(this);
          //  itemView.setOnClickListener(this);
            deleteAll.setOnClickListener(this);
            image_problem_incorrect.setOnClickListener(this);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                }
            });


        }



        @Override
        public void onClick(View view) {
            if(view==deleteAll){
                try {
                    if(ic_deleteAll!=null){
                        ic_deleteAll.click_deleteAll(deleteAll,getPosition());
                    }
                }


                catch (Exception e) {

                    e.printStackTrace();
                }
            }
            else if(view==image_problem_incorrect){
                try {
                    if(ic_image_problem_incorrect!=null){
                        ic_image_problem_incorrect.click_image_problem_incorrect(image_problem_incorrect,getPosition());
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

        private final RecyclerViewAdapter_check_problem_new adapter;

        private final List<GetData_check_problem> originalList;

        private final List<GetData_check_problem> filteredList;

        private UserFilter(RecyclerViewAdapter_check_problem_new adapter, List<GetData_check_problem> originalList) {
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
                for (final GetData_check_problem user : originalList) {

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
                adapter.getDataAdapter.addAll((ArrayList<GetData_check_problem>) results.values);
                adapter.notifyDataSetChanged();
            }
        }
    }



}
