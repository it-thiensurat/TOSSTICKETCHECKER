package com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.adapter;

/**
 * Created by pratap.kesaboyina on 24-12-2014.
 */

import android.app.Dialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler;
import com.bumptech.glide.Glide;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.model.SingleItemModel_checker3;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.databases.SQLiteHelper_image_buffer;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class SectionListDataAdapter_image3 extends RecyclerView.Adapter<SectionListDataAdapter_image3.SingleItemRowHolder> {

    private ArrayList<SingleItemModel_checker3> itemsList;

    private Context mContext;
    SQLiteDatabase sqLiteDatabase;
    public SectionListDataAdapter_image3(Context context, ArrayList<SingleItemModel_checker3> itemsList) {
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
    public void onBindViewHolder(SingleItemRowHolder holder, final int i) {

        final SingleItemModel_checker3 singleItem = itemsList.get(i);
        holder.tvTitle.setText("รูปที่ "+(i+1));
      //  holder.tvTitle.setText(singleItem.getName());
        //Log.e("imageBefore_size", String.valueOf(imageBeforeList.size()));
        try {
            Glide.with(mContext).load(singleItem.getUrl())
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
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        dialog.cancel();
                    }
                });


                tvTitle.setText(singleItem.getName());
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

        public CircleImageView itemImage;


        public SingleItemRowHolder(View view) {
            super(view);

            this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            this.itemImage = (CircleImageView) view.findViewById(R.id.itemImage);
        }
    }



    public void SQLiteDataBaseBuild(){

        sqLiteDatabase = mContext.openOrCreateDatabase(SQLiteHelper_image_buffer.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    public void SQLiteTableBuild(){

        //sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper.TABLE_NAME+"("+ SQLiteHelper.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+SQLiteHelper.Table_Column_1_Subject_Name+" VARCHAR, "+SQLiteHelper.Table_Column_2_SubjectFullForm+" VARCHAR, "+SQLiteHelper.Table_Column_3_subteamcode+" VARCHAR, "+SQLiteHelper.Table_Column_5_contract_number+" VARCHAR, "+SQLiteHelper.Table_Column_6_contract_number2+" VARCHAR, "+SQLiteHelper.Table_Column_7_name_topic+" VARCHAR, "+SQLiteHelper.Table_Column_8_customer+" VARCHAR, "+SQLiteHelper.Table_Column_9_description+" VARCHAR, "+SQLiteHelper.Table_Column_16_status+" VARCHAR, "+SQLiteHelper.Table_Column_15_date_time+" VARCHAR, "+SQLiteHelper.Table_Column_23_date_time_update+" VARCHAR, "+SQLiteHelper.Table_Column_10_approveStatus+" VARCHAR, "+SQLiteHelper.Table_Column_11_approveBy+" VARCHAR, "+SQLiteHelper.Table_Column_12_approveDate+" VARCHAR, "+SQLiteHelper.Table_Column_17_isremark+" VARCHAR, "+SQLiteHelper.Table_Column_14_isremark1+" VARCHAR, "+SQLiteHelper.Table_Column_20_check_foller+" VARCHAR, "+SQLiteHelper.Table_Column_21_countfoller+" VARCHAR, "+SQLiteHelper.Table_Column_22_countcomment+" VARCHAR, "+SQLiteHelper.Table_Column_4_picture+" VARCHAR);");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper_image_buffer.TABLE_NAME+"("+ SQLiteHelper_image_buffer.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+SQLiteHelper_image_buffer.Table_part_id+" VARCHAR, "+SQLiteHelper_image_buffer.Table_name_image+" VARCHAR, "+SQLiteHelper_image_buffer.Table_url_image+" VARCHAR, "+SQLiteHelper_image_buffer.Table_Url+" VARCHAR, "+SQLiteHelper_image_buffer.Table_Image_Name+" VARCHAR, "+SQLiteHelper_image_buffer.Table_Image_Size+" VARCHAR, "+SQLiteHelper_image_buffer.Table_Image_Type+" VARCHAR, "+SQLiteHelper_image_buffer.Table_order_image+" VARCHAR);");


    }
}