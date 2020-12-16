package com.tsr.tsrproblemreport_tossticket_checker.mvp.Adapter.manager;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.Model.manager.ManagerRes;


import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;


/**
 * Created by Ashish on 28-09-2017.
 */

public class ContactAdapter_manager extends RecyclerView.Adapter<ContactAdapter_manager.MyViewHolder> {
    private Context context;
    private List<ManagerRes> list = new ArrayList<ManagerRes>();
    public ContactAdapter_manager(Context context, List<ManagerRes> list){
        this.context = context;
        this.list = list;
    }

    /*public void setCustomerList(List<CustomerRes> list){
        this.list = list;
    }*/

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_cardview_cedit2,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ManagerRes res = list.get(position);
        Log.e("contno", res.getCONTNO());
//        Log.e("CustomerName", res.getCustomerName());
        holder.txt_conno.setText(res.getCONTNO());
        holder.txt_customer.setText(res.getCustomerName());

    }

    @Override
    public int getItemCount() {
        return list.size();
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



    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener,View.OnClickListener  {

        /*
        @BindView(R.id.txt_conno) TextView textViewContno;
        @BindView(R.id.txt_customer) TextView textViewcustomer;
        @BindView(R.id.txt_address) TextView txt_address;
        @BindView(R.id.tv_distance) TextView tv_distance;
        @BindView(R.id.handle) TextView handleView;
        @BindView(R.id.tv_date) TextView tv_date;
        @BindView(R.id.handle2) TextView handle2;
        @BindView(R.id.handle3) TextView handle3;
*/
        public TextView txt_conno;
        public TextView txt_customer;
        public TextView txt_address;
        public TextView tv_distance;
        public TextView tv_date;
        public ImageView handleView;
        public ImageView handle2;
        public ImageView handle3;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);



            txt_conno = (TextView) itemView.findViewById(R.id.txt_conno) ;
            txt_customer = (TextView) itemView.findViewById(R.id.txt_customer) ;
            txt_address = (TextView) itemView.findViewById(R.id.txt_address) ;
            tv_distance= (TextView) itemView.findViewById(R.id.tv_distance) ;
            handleView = (ImageView) itemView.findViewById(R.id.handle);
            tv_date= (TextView) itemView.findViewById(R.id.tv_date) ;
            handle2= (ImageView) itemView.findViewById(R.id.handle2);
            handle3= (ImageView) itemView.findViewById(R.id.handle3);

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



            //return true;
            return false;
        }
    }
}
