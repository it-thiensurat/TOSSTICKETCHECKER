package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.MusicActivity_Credit;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Detali_data_cedit;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.UI_CARDVIEW_DATA_CEDIT;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.helper.ItemTouchHelperAdapter;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.helper.OnCustomerListChangedListener;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.helper.OnLoadMoreListener;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.helper.OnStartDragListener;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit;

import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import at.grabner.circleprogress.CircleProgressView;

public class ContactAdapter3 extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable, ItemTouchHelperAdapter {
    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;
    private OnLoadMoreListener onLoadMoreListener;
    private boolean isLoading;
    private Activity activity;
    private List<GetData_cedit> contacts =new ArrayList<GetData_cedit>();
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;
    CircleProgressView mCircleView3;
    MusicActivity_Credit musicActivity_credit;
    UI_CARDVIEW_DATA_CEDIT ui_cardview_data_cedit;
    private long c1 = 0;

    Detali_data_cedit detali_data_cedit;
    Double dist = 0.0;
    Double durat=0.0;
    public  Context context;
public  static int position_adap=0;
    ImageLoader imageLoader1;
    String s1,s2,s3,s4,s5,s6;
    int converted1,converted2,converted3,converted4,converted5,converted6;
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
    String address_now;
    String url,url2;
    public static int color;
    int zine;
    private UserFilter userFilter;
    SimpleDateFormat input2;
    SimpleDateFormat output2;

    private Date oneWayTripDate;
    private Date oneWayTripDate1;
    private Date oneWayTripDate2;
    private Date oneWayTripDate3;
    private OnCustomerListChangedListener onCustomerListChangedListener;

    ImageView foller;
    //   public GetDataAdapter feed;
    String themes_app;
    View v;

    JSONObject jsonObject;
    JSONObject distance;
    JsonArrayRequest jsonArrayRequest;

Dialog dialog3;
    RequestQueue requestQueue;
   // String GET_JSON_DATA_HTTP_URL_insent_map = "http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/insertdismap.php";
    String CONNO;

    public ContactAdapter3(RecyclerView recyclerView, List<GetData_cedit> contacts, FragmentActivity context ){
        super();
        this.contacts = contacts;
       // this.activity = activity;



        this.contacts = contacts;
        this.context = context;

        this.onCustomerListChangedListener=onCustomerListChangedListener;

        userFilter = new UserFilter(ContactAdapter3.this,contacts);

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                    if (onLoadMoreListener != null) {
                        onLoadMoreListener.onLoadMore();
                    }
                    isLoading = true;
                }
            }
        });
    }

    private Object lock1 = new Object();
    Thread thread;
   public static int b;

String origins,des;
public void Setloc(String a,String b){
    this.origins=a;
    this.des=b;
}

    String origins2,des2;
    public void Setloc2(String a2,String b2){
        this.origins=a2;
        this.des=b2;
    }


    public void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.onLoadMoreListener = mOnLoadMoreListener;
    }

    @Override
    public int getItemViewType(int position) {
        return contacts.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_cardview_cedit6, parent, false);
            return new UserViewHolder(view);
        } else if (viewType == VIEW_TYPE_LOADING) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading, parent, false);
            return new LoadingViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {







    if (holder instanceof UserViewHolder) {








/*
            final GetData_cedit contact = contacts.get(position);
            final UserViewHolder userViewHolder = (UserViewHolder) holder;


          //  position_adap = position;

            userViewHolder.txt_conno.setText(contact.getCONTNO());
            userViewHolder.txt_customer.setText(contact.getCustomerName());
            userViewHolder.txt_address.setText(contact.getAddressDetail());
            userViewHolder.tv_distance.setText("~"+contact.getdis()+" km");

            //userViewHolder.txt_status.setText(contact.getCheckerStatusName());



            try {
                String date11=contact.getEFFDATE()+"";


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




                    userViewHolder.tv_date.setText(dateThai_day+" "+dateThai_month1+converted_dateThai11);
                    //Log.e("dateThai",dateThai_day+""+dateThai_month1+""+converted_dateThai11+"");
                }

            }
            catch (Exception ex){

            }*/





















        final GetData_cedit contact = contacts.get(position);
        final UserViewHolder userViewHolder = (UserViewHolder) holder;


        //  position_adap = position;

        userViewHolder.txt_conno.setText(contact.getCONTNO());
        userViewHolder.txt_customer.setText(contact.getCustomerName());
        userViewHolder.txt_address.setText(contact.getAddressDetail());
      //  userViewHolder.tv_distance.setText("~"+contact.getdis()+" km");

        userViewHolder.txt_status.setText(contact.getCheckerStatusName());

        if(contact.getCheckerStatus().equals("10")){
            userViewHolder.linear_coler.setBackgroundColor(0xffff69b4);
            userViewHolder.txt_status_closing.setText("รอดำเนินการ");
            userViewHolder.txt_status_closing.setTextColor(0xffA9A9A9);
            userViewHolder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
        }
        else  if(contact.getCheckerStatus().equals("11")){
            userViewHolder.linear_coler.setBackgroundColor(0xff00695c);
            userViewHolder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange17);
            userViewHolder.txt_status_closing.setText("ตรวจสอบแล้ว");

        }
        else if(contact.getCheckerStatus().equals("01")){
            userViewHolder.linear_coler.setBackgroundColor(0xffFFA500);
            userViewHolder.txt_status_closing.setText("รอดำเนินการ");
            userViewHolder.txt_status_closing.setTextColor(0xffA9A9A9);
            userViewHolder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
        }
        else  if(contact.getCheckerStatus().equals("90")){
            userViewHolder.linear_coler.setBackgroundColor(0xffFFA500);
            userViewHolder.txt_status_closing.setText("รอดำเนินการ");
            userViewHolder.txt_status_closing.setTextColor(0xffA9A9A9);
            userViewHolder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange4);
        }

        else  if(contact.getCheckerStatus().equals("99")){

            userViewHolder.linear_coler.setBackgroundColor(0xffff0000);
            userViewHolder.txt_status_closing.setText("มีปัญหา");
            userViewHolder.txt_status_closing.setTextColor(0xffA9A9A9);
            userViewHolder.linear_status_closing.setBackgroundResource(R.drawable.roun_rect_orange14);
        }


        try {
            String date11=contact.getEFFDATE()+"";


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




                userViewHolder.tv_date.setText(dateThai_day+" "+dateThai_month1+converted_dateThai11);
                //Log.e("dateThai",dateThai_day+""+dateThai_month1+""+converted_dateThai11+"");
            }

        }
        catch (Exception ex){

        }







        if(color==0xff000000){
            // Start a drag whenever the handle view it touched
            userViewHolder.handleView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                        //mDragStartListener.onStartDrag(userViewHolder);
                    }
                    return false;
                }
            });


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                userViewHolder.handleView.setBackgroundTintList(ColorStateList.valueOf(color));
            }
        }
        else {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                userViewHolder.handleView.setBackgroundTintList(ColorStateList.valueOf(0xff999999));
            }
        }



        }
















    }


    private Runnable Success = new Runnable() {

        @Override
        public void run() {

        }
    };


    @Override
    public int getItemCount() {
        return contacts == null ? 0 : contacts.size();
    }

    public void setLoaded() {
        isLoading = false;
    }

    private class LoadingViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;

        public LoadingViewHolder(View view) {
            super(view);
            progressBar = (ProgressBar) view.findViewById(R.id.progressBar1);
        }
    }


    @Override
    public Filter getFilter() {
        if(userFilter!=null){
            userFilter=new ContactAdapter3.UserFilter(this,contacts);
        }

        return userFilter;

    }





    private ContactAdapter3.itemclick ic;
    public void setitemclick(ContactAdapter3.itemclick ic){
        this.ic=ic;
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {

        Collections.swap(contacts, fromPosition, toPosition);
        onCustomerListChangedListener.onNoteListChanged(contacts);
        notifyItemMoved(fromPosition, toPosition);
        notifyDataSetChanged();
        return true;
    }

    @Override
    public void onItemDismiss(int position) {

    }
    public interface itemclick{
        void click(View v, int position);
    }


    private ContactAdapter3.itemclick2 ic2;
    public void setitemclick2(ContactAdapter3.itemclick2 ic2){
        this.ic2=ic2;
    }
    public interface itemclick2{


        void click2(View v, int position);
    }












/*
    private ContactAdapter3.itemclick_linear_se linear_se;
    public void setitemclick2(ContactAdapter3.itemclick_linear_se iclinear_se){
        this.linear_se=iclinear_se;
    }
    public interface itemclick_linear_se{


        void click_linear_se(View v, int position);
    }
*/






    private itemclick_linear_se ic_linear_se;
    public void setitemclick_linear_se(itemclick_linear_se ic_linear_se){
        this.ic_linear_se=ic_linear_se;
    }
    public interface itemclick_linear_se{


        void click_linear_se(View v, int position);
    }


    private class UserViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener,View.OnClickListener  {

        public TextView txt_conno;
        public TextView txt_customer;
        public TextView txt_address;
        public TextView tv_distance;
        public TextView tv_date;
        public ImageView handleView;
        public ImageView handle2;
        public ImageView handle3;

        //     public TextView lbl_name;
        //  public TextView title;



        public TextView txt_status;
        //     public TextView lbl_name;
        //  public TextView title;
        public LinearLayout linear_coler,linear_status_closing,linear_se;
        public TextView  txt_status_closing;

        public GetData_cedit feed;
        public UserViewHolder(View itemView) {

            super(itemView);






            txt_conno = (TextView) itemView.findViewById(R.id.txt_conno) ;
            txt_customer = (TextView) itemView.findViewById(R.id.txt_customer) ;
            txt_address = (TextView) itemView.findViewById(R.id.txt_address) ;
            tv_distance= (TextView) itemView.findViewById(R.id.tv_distance) ;
            handleView = (ImageView) itemView.findViewById(R.id.handle);
            tv_date= (TextView) itemView.findViewById(R.id.tv_date) ;
            handle2= (ImageView) itemView.findViewById(R.id.handle2);
            handle3= (ImageView) itemView.findViewById(R.id.handle3);
         //   Log.e("fffff","ffff");

            txt_status= (TextView) itemView.findViewById(R.id.txt_status);
            linear_coler= (LinearLayout) itemView.findViewById(R.id.linear_coler);
            linear_status_closing= (LinearLayout) itemView.findViewById(R.id.linear_status_closing);
            linear_se= (LinearLayout) itemView.findViewById(R.id.linear_se);
            txt_status_closing= (TextView) itemView.findViewById(R.id.txt_status_closing);
            linear_coler.setVisibility(View.VISIBLE);
            
            itemView.setOnLongClickListener(this);
            itemView.setOnClickListener(this);
            linear_se.setOnClickListener(this);





        }





        @Override
        public void onClick(View view) {

            if(view==linear_se){
                try {


                    if(ic_linear_se!=null){
                        ic_linear_se.click_linear_se(linear_se,getPosition());
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

        private final ContactAdapter3 adapter;

        private final List<GetData_cedit> originalList;

        private final List<GetData_cedit> filteredList;

        private UserFilter(ContactAdapter3 adapter, List<GetData_cedit> originalList) {
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
                    //   if ((user.getContract_number().toUpperCase()).contains(constraint.toString().toUpperCase()) ||
                    //          (user.getnamethai().toUpperCase()).contains(constraint.toString().toUpperCase()) ){
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
                adapter.contacts.clear();
                adapter.notifyDataSetChanged();
            } else {
                adapter.contacts.clear();
                adapter.contacts.addAll((ArrayList<GetData_cedit>) results.values);
                adapter.notifyDataSetChanged();
            }
        }
    }












}