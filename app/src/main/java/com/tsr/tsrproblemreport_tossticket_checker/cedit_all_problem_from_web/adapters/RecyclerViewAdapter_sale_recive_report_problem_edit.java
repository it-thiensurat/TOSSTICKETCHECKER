package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.HapticFeedbackConstants;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.databases.SQLiteHelper;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.helper.FlipAnimator;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetDataAdapterCheckBox_image_id;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_sale_edit_problem;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.utils.ImageConfiguration;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.tsr.tsrproblemreport_tossticket_checker.R.id;

/**
 * Created by JUNED on 6/16/2016.
 */
public class RecyclerViewAdapter_sale_recive_report_problem_edit extends RecyclerView.Adapter<RecyclerViewAdapter_sale_recive_report_problem_edit.ViewHolder>  {

    Context context;

    List<GetData_cedit_sale_edit_problem> getDataAdapter;
    List<GetDataAdapterCheckBox_image_id> image_id =new ArrayList<>();
    ImageLoader imageLoader1;
    String s1,s2,s3,s4,s5,s6;
    int converted1,converted2,converted3,converted4,converted5,converted6;
    String ggg;
    String CP;
    private Date oneWayTripDate;
    public static boolean status_cick1 = false,
            status_cick2 = false;
    //public static boolean status_cick2 = false;




    private MessageAdapterListener listener;
    private SparseBooleanArray animationItemsIndex;
    private SparseBooleanArray selectedItems;
    private boolean reverseAllAnimations = false;
    SQLiteDatabase sqLiteDatabase;
    private static int currentSelectedIndex = -1;


    private MessageAdapterListener listener2;
    private SparseBooleanArray animationItemsIndex2;
    private SparseBooleanArray selectedItems2;
    private boolean reverseAllAnimations2 = false;
    private static int currentSelectedIndex2 = -1;


    public RecyclerViewAdapter_sale_recive_report_problem_edit(List<GetData_cedit_sale_edit_problem> getDataAdapter, Context context, MessageAdapterListener listener, MessageAdapterListener listener2){

        super();
        this.getDataAdapter = getDataAdapter;
        this.context = context;

        this.listener = listener;
        selectedItems = new SparseBooleanArray();
        animationItemsIndex = new SparseBooleanArray();

        this.listener2 = listener2;
        selectedItems2 = new SparseBooleanArray();
        animationItemsIndex2 = new SparseBooleanArray();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_checkbox_cardview_cedit2_edit, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder Viewholder, final int position) {

        final GetData_cedit_sale_edit_problem getDataAdapter1 =  getDataAdapter.get(position);
        final GetData_cedit_sale_edit_problem getDataAdapter2 =  getDataAdapter.get(position2);









        Viewholder.checkBox.setOnCheckedChangeListener(null);


        //if true, your checkbox will be selected, else unselected
        Viewholder.checkBox.setChecked(getDataAdapter.get(position).isSelected());

        Viewholder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                getDataAdapter.get(Viewholder.getAdapterPosition()).setSelected(isChecked);
                if(isChecked){



                }


            }
        });

        Viewholder.lbl_problem.setText(getDataAdapter1.getTopic_problem());

        try {
            Glide.with(context).load("http://app.thiensurat.co.th/assanee/uploads_image_report_problem/"+getDataAdapter1.getImage_Name()+".jpg")



                    .crossFade()
                    .thumbnail(0.5f)
                    //  .bitmapTransform(new CircleTransform(context))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                    .into(Viewholder.image_problem_incorrect);
        }
        catch (Exception e) {

        }


        try {
            Glide.with(context).load(getDataAdapter1.getImage_Name())



                    .crossFade()
                    .thumbnail(0.5f)
                    // .bitmapTransform(new CircleTransform(context))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                    .placeholder(context.getResources().getDrawable(R.drawable.dasaa))
                    .into(Viewholder.image_problem_sucess);
        }
        catch (Exception e) {

        }





        try {
            if (getDataAdapter1.getImage_Name().isEmpty()) {
                Viewholder.ic_dete1.setVisibility(View.GONE);

            }
            else {
                Viewholder.ic_dete1.setVisibility(View.GONE);
            }
        }

        catch (Exception ex){
            Viewholder.ic_dete1.setVisibility(View.GONE);
        }






        try {
            if (getDataAdapter1.getImage_Name().isEmpty()) {
                Viewholder.ic_dete2.setVisibility(View.GONE);

            }
            else {
                Viewholder.ic_dete2.setVisibility(View.GONE);
            }
        }

        catch (Exception ex){
            Viewholder.ic_dete2.setVisibility(View.GONE);
        }



        try {

            // if(getDataAdapter1.getImage_error().equals(getDataAdapter2.getImage_error())){


            String size =getDataAdapter1.getCountImage();
            int sizei= Integer.parseInt(size);
            if(sizei>1){
                Viewholder.txt_count_image_error.setText("+"+getDataAdapter1.getCountImage()+" ");
                Viewholder.txt_count_image_error.setVisibility(View.VISIBLE);
            }
            else {
                Viewholder.txt_count_image_error.setVisibility(View.GONE);
            }

            // }
        }
        catch (Exception e){

        }





        try {

            String size =getDataAdapter1.getCountImage();
            int sizei= Integer.parseInt(size);
            if(sizei>1){
                Viewholder.txt_count_image_success.setText("+"+getDataAdapter1.getCountImage()+" ");
                Viewholder.txt_count_image_success.setVisibility(View.GONE);
            }
            else {
                Viewholder.txt_count_image_success.setVisibility(View.GONE);
            }

            // }
        }
        catch (Exception e){

        }








        applyIconAnimation(Viewholder, position);
        applyIconAnimation2(Viewholder, position);
        applyClickEvents(Viewholder, position);


        Viewholder.feed = getDataAdapter1;

    }
    private void applyClickEvents(ViewHolder holder, final int position) {





        holder.image_problem_incorrect.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listener.onRowLongClicked(position);
                view.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
                return true;
            }
        });


        holder.image_problem_sucess.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listener2.onRowLongClicked2(position);
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
    private void applyIconAnimation2(ViewHolder holder, int position) {
        if (selectedItems2.get(position, false)) {
            holder.iconFront2.setVisibility(View.GONE);
            resetIconYAxis2(holder.icon_back2);
            holder.icon_back2.setVisibility(View.VISIBLE);
            holder.icon_back2.setAlpha(1);
            if (currentSelectedIndex2 == position) {
                FlipAnimator.flipView(context, holder.icon_back2, holder.iconFront2, true);
                resetCurrentIndex2();
            }
        } else {
            holder.icon_back2.setVisibility(View.GONE);
            resetIconYAxis2(holder.iconFront2);
            holder.iconFront2.setVisibility(View.VISIBLE);
            holder.iconFront2.setAlpha(1);
            if ((reverseAllAnimations2 && animationItemsIndex2.get(position, false)) || currentSelectedIndex2 == position) {
                FlipAnimator.flipView(context, holder.icon_back2, holder.iconFront2, false);
                resetCurrentIndex2();
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

    private void resetIconYAxis2(View view) {
        if (view.getRotationY() != 0) {
            view.setRotationY(0);
        }
    }

    public void resetAnimationIndex2() {
        reverseAllAnimations2 = false;
        animationItemsIndex2.clear();
    }




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


    public void toggleSelection2(int pos) {
        currentSelectedIndex2 = pos;
        if (selectedItems2.get(pos, false)) {
            selectedItems2.delete(pos);
            animationItemsIndex2.delete(pos);
        } else {
            selectedItems2.put(pos, true);
            animationItemsIndex2.put(pos, true);
        }
        notifyItemChanged(pos);
    }

    public void clearSelections2() {
        reverseAllAnimations2 = true;
        selectedItems2.clear();
        notifyDataSetChanged();
    }






    private RecyclerViewAdapterCheckBox.itemclick2 ic2;
    public void setitemclick2(RecyclerViewAdapterCheckBox.itemclick2 ic2){
        this.ic2=ic2;
    }
    public interface itemclick2{


        void click2(View v, int position);
    }



    private RecyclerViewAdapterCheckBox.itemclick_image_sucess ic_image_sucess;
    public void setitemclick_image_sucess(RecyclerViewAdapterCheckBox.itemclick_image_sucess ic_image_sucess){
        this.ic_image_sucess=ic_image_sucess;
    }
    public interface itemclick_image_sucess{


        void click_image_sucess(View v, int position);
    }








    private RecyclerViewAdapterCheckBox.itemclick_image_ic_dete1 ic_image_ic_dete1;
    public void setitemclick_image_ic_dete1(RecyclerViewAdapterCheckBox.itemclick_image_ic_dete1 ic_image_ic_dete1){
        this.ic_image_ic_dete1=ic_image_ic_dete1;
    }
    public interface itemclick_image_ic_dete1{


        void click_image_ic_dete1(View v, int position);
    }


    private RecyclerViewAdapterCheckBox.itemclick_image_ic_dete2 ic_image_ic_dete2;
    public void setitemclick_image_ic_dete2(RecyclerViewAdapterCheckBox.itemclick_image_ic_dete2 ic_image_ic_dete2){
        this.ic_image_ic_dete2=ic_image_ic_dete2;
    }
    public interface itemclick_image_ic_dete2{


        void click_image_ic_dete2(View v, int position);
    }






    private RecyclerViewAdapterCheckBox.itemclick_photograph_image_error ic_photograph_image_error;
    public void setitemclick_photograph_image_error(RecyclerViewAdapterCheckBox.itemclick_photograph_image_error photograph_image_error){
        this.ic_photograph_image_error=photograph_image_error;
    }
    public interface itemclick_photograph_image_error{


        void click_photograph_image_error(View v, int position);
    }



    private RecyclerViewAdapterCheckBox.itemclick_photograph_image_success ic_photograph_image_success;
    public void setitemclick_photograph_image_success(RecyclerViewAdapterCheckBox.itemclick_photograph_image_success photograph_image_success){
        this.ic_photograph_image_success=photograph_image_success;
    }
    public interface itemclick_photograph_image_success{


        void click_photograph_image_success(View v, int position);
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView lbl_problem,txt_image_sucess,txt_image_error,txt_count_image_error,txt_count_image_success;
        public CheckBox checkBox;
        public  ImageView image_problem_incorrect,image_problem_sucess,ic_dete1,ic_dete2,photograph_image_error,photograph_image_success;
        public LinearLayout linear_checkbox;
        //  public ImageView networkImageView ;

        public RelativeLayout icon_back,iconFront;
        public RelativeLayout icon_back2,iconFront2;

        public GetData_cedit_sale_edit_problem feed;
        public ViewHolder(View itemView) {

            super(itemView);






            lbl_problem = (TextView) itemView.findViewById(id.lbl_problem) ;
            txt_image_sucess = (TextView) itemView.findViewById(id.txt_image_sucess) ;
            txt_image_error = (TextView) itemView.findViewById(id.txt_image_error) ;
            txt_count_image_error= (TextView) itemView.findViewById(id.txt_count_image_error) ;
            txt_count_image_success= (TextView) itemView.findViewById(id.txt_count_image_success) ;
            checkBox= (CheckBox) itemView.findViewById(id.checkBox) ;

            image_problem_incorrect= (ImageView) itemView.findViewById(id.image_problem_incorrect) ;
            image_problem_sucess= (ImageView) itemView.findViewById(id.image_problem_sucess) ;

            ic_dete1= (ImageView) itemView.findViewById(id.ic_dete1) ;
            ic_dete2= (ImageView) itemView.findViewById(id.ic_dete2) ;

            photograph_image_error= (ImageView) itemView.findViewById(id.photograph_image_error) ;
            photograph_image_success= (ImageView) itemView.findViewById(id.photograph_image_success) ;

            linear_checkbox= (LinearLayout) itemView.findViewById(id.linear_checkbox) ;


            icon_back= (RelativeLayout) itemView.findViewById(id.icon_back) ;
            iconFront = (RelativeLayout) itemView.findViewById(R.id.icon_front);
            icon_back2= (RelativeLayout) itemView.findViewById(id.icon_back2) ;
            iconFront2 = (RelativeLayout) itemView.findViewById(R.id.icon_front2);
            //  networkImageView = (ImageView) itemView.findViewById(id.VollyNetworkImageView1) ;


            image_problem_incorrect.setOnClickListener(this);
            image_problem_sucess.setOnClickListener(this);
            ic_dete1.setOnClickListener(this);
            ic_dete2.setOnClickListener(this);
            photograph_image_error.setOnClickListener(this);
            photograph_image_success.setOnClickListener(this);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    //String ckeckposition= getDataAdapter1.getposition();

                    //      Intent mIntent = new Intent(v.getContext(), UI_SHOW_PROBLEM.class);
                    //       Bundle bun=new Bundle();
                    //  bun.putString("namethai", feed.getnamethai());

                    //title.setText()

                    //   mIntent.putExtras(bun);
///
                    //  v.getContext().startActivity(mIntent);












                }
            });





        }

        @Override
        public void onClick(View view) {

            if(view==image_problem_incorrect){
                try {
                    if(ic2!=null){
                        ic2.click2(image_problem_incorrect,getPosition());
                    }
                }


                catch (Exception e) {

                    e.printStackTrace();
                }
            }
            else if(view==image_problem_sucess){
                try {
                    if(ic_image_sucess!=null){
                        ic_image_sucess.click_image_sucess(image_problem_sucess,getPosition());
                    }
                }


                catch (Exception e) {

                    e.printStackTrace();
                }
            }

            else if(view==ic_dete1){
                try {
                    if(ic_image_ic_dete1!=null){
                        ic_image_ic_dete1.click_image_ic_dete1(ic_dete1,getPosition());
                    }
                }


                catch (Exception e) {

                    e.printStackTrace();
                }
            }


            else if(view==ic_dete2){
                try {
                    if(ic_image_ic_dete2!=null){
                        ic_image_ic_dete2.click_image_ic_dete2(ic_dete2,getPosition());
                    }
                }


                catch (Exception e) {

                    e.printStackTrace();
                }
            }


            else if(view==photograph_image_error){
                try {
                    if(ic_photograph_image_error!=null){
                        ic_photograph_image_error.click_photograph_image_error(photograph_image_error,getPosition());
                    }
                }


                catch (Exception e) {

                    e.printStackTrace();
                }
            }


            else if(view==photograph_image_success){
                try {
                    if(ic_photograph_image_success!=null){
                        ic_photograph_image_success.click_photograph_image_success(photograph_image_success,getPosition());
                    }
                }


                catch (Exception e) {

                    e.printStackTrace();
                }
            }






        }




    }

    int i,position2;

    public void count_image(int i,int position){

        this.i=i;
        this.position2=position;

    }





    public int getSelectedItemCount() {
        return selectedItems.size();
    }
    public int getSelectedItemCount2() {
        return selectedItems2.size();
    }
    public List<Integer> getSelectedItems() {
        List<Integer> items =
                new ArrayList<>(selectedItems.size());
        for (int i = 0; i < selectedItems.size(); i++) {
            items.add(selectedItems.keyAt(i));
        }
        return items;
    }
    public List<Integer> getSelectedItems2() {
        List<Integer> items2 =
                new ArrayList<>(selectedItems2.size());
        for (int i = 0; i < selectedItems2.size(); i++) {
            items2.add(selectedItems2.keyAt(i));
        }
        return items2;
    }
    ImageConfiguration ic;
    int position_remove_sqlite;
    public void removeData(int position) {
        position_remove_sqlite=position+1;
        //  GetDataAdapterCheckBox v= getDataAdapter.get(position);
        // String DA=   v.getid();
        Log.e("DA1", String.valueOf(position_remove_sqlite));
        Log.e("position_remove_sqlite1", String.valueOf(position_remove_sqlite));


        SQLiteDataBaseBuild();
        SQLiteTableBuild();
        sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper.TABLE_NAME + "" + " WHERE part_id =" + "'" + String.valueOf(position_remove_sqlite) + "'");
        Log.e("ข้อมุล", "ลบ");



        if(position_remove_sqlite!=0){

            File storageDir =  null ;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
                storageDir =context.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("contno_save") + "/"+"report_problem"+ "/"+"ID"+position_remove_sqlite+"/"+"image_error"+ "/");

            }



            File image[]= storageDir.listFiles();
            int da= image.length;
            for(int i=0;i<da;i++) {
                String DF = String.valueOf(image[i]);

                Log.e("image_error",DF);
                File fdelete = new File(DF);
                boolean deleted = fdelete.delete();

            }
        }
        else {

        }



        //  File fdelete = new File(storageDir.getAbsolutePath());
        //  boolean deleted = fdelete.delete();


        getDataAdapter.remove(position);



        resetCurrentIndex();
    }

    int position_remove_sqlite2;
    public void removeData2(int position) {
        position_remove_sqlite2=position+1;
        //  GetDataAdapterCheckBox v= getDataAdapter.get(position);
        // String DA=   v.getid();
        Log.e("DA2", String.valueOf(position_remove_sqlite2));
        Log.e("position_remove_sqlite2", String.valueOf(position_remove_sqlite2));


        SQLiteDataBaseBuild();
        SQLiteTableBuild();
        sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper.TABLE_NAME + "" + " WHERE part_id =" + "'" + String.valueOf(position_remove_sqlite2) + "'");
        Log.e("ข้อมุล", "ลบ");


        if(position_remove_sqlite2!=0){
            File storageDir2 =  null ;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
                storageDir2 =context.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("contno_save") + "/"+"report_problem"+ "/"+"ID"+position_remove_sqlite2+"/"+"image_success"+ "/");

            }

            File image[]= storageDir2.listFiles();
            int da= image.length;
            for(int i=0;i<da;i++) {
                String DF = String.valueOf(image[i]);

                Log.e("image_success",DF);
                File fdelete = new File(DF);
                boolean deleted = fdelete.delete();

            }
        }
        else {

        }


        getDataAdapter.remove(position);



        resetCurrentIndex2();
    }
    private void resetCurrentIndex() {
        currentSelectedIndex = -1;
    }
    private void resetCurrentIndex2() {
        currentSelectedIndex2 = -1;
    }
    public interface MessageAdapterListener {

        void onRowLongClicked(int position);
        void onRowLongClicked2(int position);
    }

    public void SQLiteDataBaseBuild(){

        sqLiteDatabase = context.openOrCreateDatabase(SQLiteHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    public void SQLiteTableBuild(){

        //sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper.TABLE_NAME+"("+ SQLiteHelper.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+SQLiteHelper.Table_Column_1_Subject_Name+" VARCHAR, "+SQLiteHelper.Table_Column_2_SubjectFullForm+" VARCHAR, "+SQLiteHelper.Table_Column_3_subteamcode+" VARCHAR, "+SQLiteHelper.Table_Column_5_contract_number+" VARCHAR, "+SQLiteHelper.Table_Column_6_contract_number2+" VARCHAR, "+SQLiteHelper.Table_Column_7_name_topic+" VARCHAR, "+SQLiteHelper.Table_Column_8_customer+" VARCHAR, "+SQLiteHelper.Table_Column_9_description+" VARCHAR, "+SQLiteHelper.Table_Column_16_status+" VARCHAR, "+SQLiteHelper.Table_Column_15_date_time+" VARCHAR, "+SQLiteHelper.Table_Column_23_date_time_update+" VARCHAR, "+SQLiteHelper.Table_Column_10_approveStatus+" VARCHAR, "+SQLiteHelper.Table_Column_11_approveBy+" VARCHAR, "+SQLiteHelper.Table_Column_12_approveDate+" VARCHAR, "+SQLiteHelper.Table_Column_17_isremark+" VARCHAR, "+SQLiteHelper.Table_Column_14_isremark1+" VARCHAR, "+SQLiteHelper.Table_Column_20_check_foller+" VARCHAR, "+SQLiteHelper.Table_Column_21_countfoller+" VARCHAR, "+SQLiteHelper.Table_Column_22_countcomment+" VARCHAR, "+SQLiteHelper.Table_Column_4_picture+" VARCHAR);");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper.TABLE_NAME+"("+ SQLiteHelper.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+SQLiteHelper.Table_part_id+" VARCHAR, "+ SQLiteHelper.Table_part_image+" VARCHAR);");


    }
}
