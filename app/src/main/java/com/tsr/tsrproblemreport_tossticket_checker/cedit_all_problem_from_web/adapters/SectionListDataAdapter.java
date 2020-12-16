package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters;

/**
 * Created by pratap.kesaboyina on 24-12-2014.
 */

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.ImageBefore;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.SingleItemModel;


import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder> {

    private ArrayList<SingleItemModel> itemsList;
    private List<ImageBefore> imageBeforeList = new ArrayList<ImageBefore>();
    private Context mContext;

    public SectionListDataAdapter(Context context, ArrayList<SingleItemModel> itemsList,List<ImageBefore> imageBeforeList) {
        //this.itemsList = itemsList;
        this.mContext = context;
        this.imageBeforeList = imageBeforeList;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mp3_online_list_single_card, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, final int i) {
    //    final SingleItemModel singleItem = itemsList.get(i);
        final ImageBefore imageBefore =imageBeforeList.get(i);
        //final SingleItemModel singleItem = itemsList.get(i);
        holder.tvTitle.setText("รูปที่ "+(i+1));
        //holder.tvTitle.setText(singleItem.getName());
        //Log.e("imageBefore_size", String.valueOf(imageBeforeList.size()));
        try {
            Glide.with(mContext).load(imageBefore.getImageUrl())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.itemImage);
        }
        catch (Exception e) {

        }
        Log.e("image url", imageBefore.getImageUrl());

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


                tvTitle.setText(imageBefore.getName_image());

                try {
                    Glide.with(mContext).load(imageBefore.getImageUrl())
                            .into(itemImage);
                    itemImage.setOnTouchListener(new ImageMatrixTouchHandler(mContext));
                }
                catch (Exception e) {

                }
                dialog.show();
            }
        });

        /*
       Glide.with(mContext)
                .load(feedItem.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.bg)
                .into(feedListRowHolder.thumbView);*/
    }

    @Override
    public int getItemCount() {
        return (null != imageBeforeList ? imageBeforeList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle;

        public CircleImageView itemImage;


        public SingleItemRowHolder(View view) {
            super(view);

            this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            this.itemImage = (CircleImageView) view.findViewById(R.id.itemImage);
        }
    }
}