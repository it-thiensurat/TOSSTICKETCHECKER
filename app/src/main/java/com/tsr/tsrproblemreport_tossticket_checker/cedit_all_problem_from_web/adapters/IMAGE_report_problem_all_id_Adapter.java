package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters;


        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.util.SparseBooleanArray;
        import android.view.HapticFeedbackConstants;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.RelativeLayout;

        import com.android.volley.toolbox.ImageLoader;

        import com.bumptech.glide.Glide;
        import com.bumptech.glide.load.engine.DiskCacheStrategy;
        import com.tsr.tsrproblemreport_tossticket_checker.R;
        import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.databases.SQLiteHelper;
        import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.helper.FlipAnimator;
        import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetDataAdapter_image_report_problem_error;
        import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.utils.ImageConfiguration;

        import java.io.File;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;

        import static com.tsr.tsrproblemreport_tossticket_checker.R.id;

/**
 * Created by JUNED on 6/16/2016.
 */
public class IMAGE_report_problem_all_id_Adapter extends RecyclerView.Adapter<IMAGE_report_problem_all_id_Adapter.ViewHolder> {

    Context context;
    private MessageAdapterListener listener;
    List<GetDataAdapter_image_report_problem_error> getDataAdapter;
    private SparseBooleanArray animationItemsIndex;
    private SparseBooleanArray selectedItems;
    ImageLoader imageLoader1;
    String s1,s2,s3,s4,s5,s6;
    int converted1,converted2,converted3,converted4,converted5,converted6;
    String ggg;
    String CP;
    private Date oneWayTripDate;
    private boolean reverseAllAnimations = false;
    SQLiteDatabase sqLiteDatabase;
    private static int currentSelectedIndex = -1;
    public IMAGE_report_problem_all_id_Adapter(List<GetDataAdapter_image_report_problem_error> getDataAdapter, Context context, MessageAdapterListener listener){

        super();
        this.getDataAdapter = getDataAdapter;
        this.context = context;
        this.listener = listener;
        selectedItems = new SparseBooleanArray();
        animationItemsIndex = new SparseBooleanArray();
    }






    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_cardview_image_report_problem, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder Viewholder, int position) {

        GetDataAdapter_image_report_problem_error getDataAdapter1 =  getDataAdapter.get(position);





        try {
            Glide.with(context).load(getDataAdapter1.getImage_error())



                    .crossFade()
                    .thumbnail(0.5f)
                    //.bitmapTransform(new CircleTransform(context))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                    .into(Viewholder.image_problem_error);
        }
        catch (Exception e) {

        }


        applyIconAnimation(Viewholder, position);
        applyClickEvents(Viewholder, position);






        Viewholder.feed = getDataAdapter1;

    }


    private void applyClickEvents(ViewHolder holder, final int position) {



        holder.image_problem_error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onRowClicked(position);
            }
        });


        holder.image_problem_error.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listener.onRowLongClicked(position);
                view.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
                return true;
            }
        });
    }






    private void applyIconAnimation(ViewHolder holder, int position) {
        if (selectedItems.get(position, false)) {
            holder.iconFront.setVisibility(View.GONE);
            resetIconYAxis(holder.icon_back);
            holder.icon_back.setVisibility(View.VISIBLE);
            holder.icon_back.setAlpha(1);
            if (currentSelectedIndex == position) {
                FlipAnimator.flipView(context, holder.icon_back, holder.iconFront, true);
                resetCurrentIndex();
            }
        } else {
            holder.icon_back.setVisibility(View.GONE);
            resetIconYAxis(holder.iconFront);
            holder.iconFront.setVisibility(View.VISIBLE);
            holder.iconFront.setAlpha(1);
            if ((reverseAllAnimations && animationItemsIndex.get(position, false)) || currentSelectedIndex == position) {
                FlipAnimator.flipView(context, holder.icon_back, holder.iconFront, false);
                resetCurrentIndex();
            }
        }
    }


    private void resetIconYAxis(View view) {
        if (view.getRotationY() != 0) {
            view.setRotationY(0);
        }
    }

    public void resetAnimationIndex() {
        reverseAllAnimations = false;
        animationItemsIndex.clear();
    }

    //@Override
    //public long getItemId(String position) {
  //      return getDataAdapter.get(position).getImage_error();
 //   }





    @Override
    public int getItemCount() {

        return getDataAdapter.size();
    }



    public void toggleSelection(int pos) {
        currentSelectedIndex = pos;
        if (selectedItems.get(pos, false)) {
            selectedItems.delete(pos);
            animationItemsIndex.delete(pos);
        } else {
            selectedItems.put(pos, true);
            animationItemsIndex.put(pos, true);
        }
        notifyItemChanged(pos);
    }

    public void clearSelections() {
        reverseAllAnimations = true;
        selectedItems.clear();
        notifyDataSetChanged();
    }








    class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView image_problem_error;
public RelativeLayout icon_back,iconFront;

        public GetDataAdapter_image_report_problem_error feed;
        public ViewHolder(View itemView) {

            super(itemView);






            image_problem_error = (ImageView) itemView.findViewById(id.image_problem_error) ;
            icon_back= (RelativeLayout) itemView.findViewById(id.icon_back) ;
            iconFront = (RelativeLayout) itemView.findViewById(R.id.icon_front);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {





                }
            });





        }
    }




    public int getSelectedItemCount() {
        return selectedItems.size();
    }

    public List<Integer> getSelectedItems() {
        List<Integer> items =
                new ArrayList<>(selectedItems.size());
        for (int i = 0; i < selectedItems.size(); i++) {
            items.add(selectedItems.keyAt(i));
        }
        return items;
    }

    ImageConfiguration ic;
    public void removeData(int position) {
        GetDataAdapter_image_report_problem_error v= getDataAdapter.get(position);
        String DA=   v.getImage_error();
        Log.e("DsA",DA);

        SQLiteDataBaseBuild();
        SQLiteTableBuild();
        sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper.TABLE_NAME + "" + " WHERE part_image =" + "'" + DA + "'");
        Log.e("ข้อมุล", "ลบ");

        File file = new File(DA);
        boolean deleted = file.delete();
        getDataAdapter.remove(position);



        resetCurrentIndex();
    }

    private void resetCurrentIndex() {
        currentSelectedIndex = -1;
    }

    public interface MessageAdapterListener {
        void onRowClicked(int position);
        void onRowLongClicked(int position);
    }



    public void SQLiteDataBaseBuild(){

        sqLiteDatabase = context.openOrCreateDatabase(SQLiteHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    public void SQLiteTableBuild(){

        //sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper.TABLE_NAME+"("+ SQLiteHelper.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+SQLiteHelper.Table_Column_1_Subject_Name+" VARCHAR, "+SQLiteHelper.Table_Column_2_SubjectFullForm+" VARCHAR, "+SQLiteHelper.Table_Column_3_subteamcode+" VARCHAR, "+SQLiteHelper.Table_Column_5_contract_number+" VARCHAR, "+SQLiteHelper.Table_Column_6_contract_number2+" VARCHAR, "+SQLiteHelper.Table_Column_7_name_topic+" VARCHAR, "+SQLiteHelper.Table_Column_8_customer+" VARCHAR, "+SQLiteHelper.Table_Column_9_description+" VARCHAR, "+SQLiteHelper.Table_Column_16_status+" VARCHAR, "+SQLiteHelper.Table_Column_15_date_time+" VARCHAR, "+SQLiteHelper.Table_Column_23_date_time_update+" VARCHAR, "+SQLiteHelper.Table_Column_10_approveStatus+" VARCHAR, "+SQLiteHelper.Table_Column_11_approveBy+" VARCHAR, "+SQLiteHelper.Table_Column_12_approveDate+" VARCHAR, "+SQLiteHelper.Table_Column_17_isremark+" VARCHAR, "+SQLiteHelper.Table_Column_14_isremark1+" VARCHAR, "+SQLiteHelper.Table_Column_20_check_foller+" VARCHAR, "+SQLiteHelper.Table_Column_21_countfoller+" VARCHAR, "+SQLiteHelper.Table_Column_22_countcomment+" VARCHAR, "+SQLiteHelper.Table_Column_4_picture+" VARCHAR);");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper.TABLE_NAME+"("+ SQLiteHelper.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+SQLiteHelper.Table_part_id+" VARCHAR, "+SQLiteHelper.Table_part_image+" VARCHAR);");


    }
}
