package com.tsr.tsrproblemreport_tossticket_checker.test.adapters;

/**
 * Created by pratap.kesaboyina on 24-12-2014.
 */

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.test.models.SingleItemModel2;

import java.util.ArrayList;

public class SectionListDataAdapter2 extends RecyclerView.Adapter<SectionListDataAdapter2.SingleItemRowHolder> {

    private ArrayList<SingleItemModel2> itemsList;
    private Context mContext;

    public SectionListDataAdapter2(Context context, ArrayList<SingleItemModel2> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mp3_online_list_single_card, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {

        SingleItemModel2 singleItem = itemsList.get(i);

        //holder.tvTitle.setText(singleItem.getName());
        holder.tvTitle.setText("รูปที่ "+(i+1));

        try {
            Glide.with(mContext).load(singleItem.getUrl())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.itemImage);
        }
        catch (Exception e) {

        }
        holder.itemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // SingleItemModel singleItem = itemsList.get(i);
                //  Toast.makeText(v.getContext(), tvTitle.getText(), Toast.LENGTH_SHORT).show();

                final Dialog dialog = new Dialog(mContext);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.mp3_online_list_single_card_dialog_custom);
                dialog.setCancelable(true);
                final TextView tvTitle = (TextView) dialog.findViewById(R.id.tvTitle);
                final ImageView itemImage = (ImageView) dialog.findViewById(R.id.itemImage);
                final RelativeLayout close = (RelativeLayout) dialog.findViewById(R.id.close);
                final RelativeLayout remove = (RelativeLayout) dialog.findViewById(R.id.remove);
                remove.setVisibility(View.GONE);
                //tvTitle.setText(singleItem.getName());

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        dialog.cancel();
                    }
                });


                tvTitle.setText("รูปที่ "+(i+1));

                try {
                    Glide.with(mContext).load(singleItem.getUrl())
                            .into(itemImage);
                    itemImage.setOnTouchListener(new ImageMatrixTouchHandler(mContext));
                }
                catch (Exception e) {

                }
                dialog.show();
            }
        });



    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle;

        protected ImageView itemImage;



        public SingleItemRowHolder(View view) {
            super(view);

            this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            this.itemImage = (ImageView) view.findViewById(R.id.itemImage);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Toast.makeText(v.getContext(), tvTitle.getText(), Toast.LENGTH_SHORT).show();

                }
            });


        }

    }

}