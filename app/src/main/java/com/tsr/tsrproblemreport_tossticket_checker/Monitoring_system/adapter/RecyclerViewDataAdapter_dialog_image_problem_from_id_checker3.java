package com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.adapter;



/**
 * Created by pratap.kesaboyina on 24-12-2014.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler;
import com.bumptech.glide.Glide;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.GetData_cedit_dialog_image_problem_from_id_checker3;
import com.tsr.tsrproblemreport_tossticket_checker.R;

import java.util.List;

public class RecyclerViewDataAdapter_dialog_image_problem_from_id_checker3 extends RecyclerView.Adapter<RecyclerViewDataAdapter_dialog_image_problem_from_id_checker3.ItemRowHolder> {

    private List<GetData_cedit_dialog_image_problem_from_id_checker3> dataList;
    private Context mContext;

    public RecyclerViewDataAdapter_dialog_image_problem_from_id_checker3(Context context, List<GetData_cedit_dialog_image_problem_from_id_checker3> dataList) {
        this.dataList = dataList;
        this.mContext = context;
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mp3_online_list_single_card_dialog_custom_image_problem2, null);
        ItemRowHolder mh = new ItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder itemRowHolder, int i) {

        final GetData_cedit_dialog_image_problem_from_id_checker3 getData_cedit_dialog_image_problem_from_id = dataList.get(i);
        itemRowHolder.tvTitle.setText("รูปที่ "+(i+1));
        try {
            Glide.with(mContext).load(getData_cedit_dialog_image_problem_from_id.getImage_id_all())




                    .into(itemRowHolder.itemImage);

            itemRowHolder.itemImage.setOnTouchListener(new ImageMatrixTouchHandler(mContext));
        }
        catch (Exception e) {

        }
//
      //

    }

    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() : 0);
    }




    private RecyclerViewDataAdapter_dialog_image_problem_from_id_checker3.itemclick_deleteAll_id_checker3 ic_deleteAll;
    public void setitemclick_deleteAll2(RecyclerViewDataAdapter_dialog_image_problem_from_id_checker3.itemclick_deleteAll_id_checker3 deleteAll){
        this.ic_deleteAll=deleteAll;
    }
    public interface itemclick_deleteAll_id_checker3{


        void click_deleteAll_id_checker3(View v, int position);
    }






    public class ItemRowHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        protected ImageView itemImage,image_remove,image_cancal;
        protected TextView tvTitle;


        public ItemRowHolder(View view) {
            super(view);
            this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            this.itemImage = (ImageView) view.findViewById(R.id.itemImage);
            this.image_remove = (ImageView) view.findViewById(R.id.image_remove);
            this.image_cancal = (ImageView) view.findViewById(R.id.image_cancal);
            image_remove.setVisibility(View.VISIBLE);
            image_cancal.setVisibility(View.GONE);
            image_remove.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if(v==image_remove){
                try {
                    if(ic_deleteAll!=null){
                        ic_deleteAll.click_deleteAll_id_checker3(image_remove,getPosition());
                    }
                }


                catch (Exception e) {

                    e.printStackTrace();
                }
            }
        }
    }

}
