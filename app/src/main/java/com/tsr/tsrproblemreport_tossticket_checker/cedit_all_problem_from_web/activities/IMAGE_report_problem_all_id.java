package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities;

import android.app.Dialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.IMAGE_report_problem_all_id_Adapter;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.databases.SQLiteHelper;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetDataAdapter_image_report_problem_error;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class IMAGE_report_problem_all_id extends AppCompatActivity implements IMAGE_report_problem_all_id_Adapter.MessageAdapterListener {
    List<GetDataAdapter_image_report_problem_error> GetDataAdapter1;
    GetDataAdapter_image_report_problem_error getDataAdapter_image_report_problem_error;
    IMAGE_report_problem_all_id_Adapter image_report_problem_all_id_adapter;
    RecyclerView recyclerview;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    GridLayoutManager layoutManager;
    Uri fileUri;
    File file;
    String ID="",image="";
    int i=0;
    private ActionModeCallback actionModeCallback;
    private ActionMode actionMode;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_report_problem_all_id);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        GetDataAdapter1 = new ArrayList<>();
        recyclerview= (RecyclerView) findViewById(R.id.recyclerview1);

        recyclerview.setHasFixedSize(true);

        recyclerViewlayoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(recyclerViewlayoutManager);
        layoutManager = new GridLayoutManager(this, 3);
        recyclerview.setLayoutManager(layoutManager);
        Bundle data=getIntent().getExtras();
        if(data!=null) {
            // from=data.getString("from");
            ID = data.getString("ID");
            image = data.getString("image");
        }

        File storageDir =  null ;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
            storageDir =this.getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/" + MyApplication.getInstance().getPrefManager().getPreferrence("contno_save") + "/"+"report_problem"+ "/"+"ID"+ID+"/"+image+ "/");

        }

        File image[]= storageDir.listFiles();
        int da= image.length;
        for(int i=0;i<da;i++){
            String DF= String.valueOf(image[i]);

            GetDataAdapter_image_report_problem_error getDataAdapterImageReportProblemError =new GetDataAdapter_image_report_problem_error();
            getDataAdapterImageReportProblemError.setImage_error(DF);

            GetDataAdapter1.add(getDataAdapterImageReportProblemError);

            Log.e("da2", DF);
        }

        image_report_problem_all_id_adapter= new IMAGE_report_problem_all_id_Adapter(GetDataAdapter1, this,this);
        // image_report_problem_all_id_adapter.notifyDataSetChanged();
        recyclerview.setAdapter(image_report_problem_all_id_adapter);
        actionModeCallback = new ActionModeCallback();
        Log.e("da", String.valueOf(da));


        //fileUri= Uri.fromFile(file);
       // contactAdapter = new ContactAdapter(recyclerView, GetDataAdapter1, getActivity(), UI_CARDVIEW_DATA_CEDIT.this, UI_CARDVIEW_DATA_CEDIT.this);
        //recyclerview.setAdapter(contactAdapter);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            // finish the activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    int position_image_custom_dialog;
    @Override
    public void onRowClicked(int position) {
        position_image_custom_dialog=position;
        getDataAdapter_image_report_problem_error=GetDataAdapter1.get(position);
        String image_error=getDataAdapter_image_report_problem_error.getImage_error();

        enableActionMode(position_image_custom_dialog);


        final Dialog dialog = new Dialog(IMAGE_report_problem_all_id.this);
        dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog_image_report_problemt);
        dialog.setCancelable(false);
        final ImageView image_map=(ImageView)dialog.findViewById(R.id.image_map);
        final ImageView rotage2=(ImageView)dialog.findViewById(R.id.rotage2);
        final ImageView ic_dete2=(ImageView)dialog.findViewById(R.id.ic_dete2);
        final ImageView ic_dete=(ImageView)dialog.findViewById(R.id.ic_dete);

        try {
            Glide.with(this).load(image_error)



                    .crossFade()
                    .thumbnail(0.5f)
                    // .bitmapTransform(new CircleTransform(context))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(this.getResources().getDrawable(R.drawable.no_image_map))
                    .into(image_map);
        }
        catch (Exception e) {

        }



        rotage2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                i=i+90;
                image_map.setRotation((float) i);

            }
        });

        ic_dete2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                deleteMessages();
                actionMode.finish();
                /*
                List<Integer> selectedItemPositions = image_report_problem_all_id_adapter.getSelectedItems();
                image_report_problem_all_id_adapter.removeData(selectedItemPositions.get(position_image_custom_dialog));
                image_report_problem_all_id_adapter.notifyDataSetChanged();
*/
                //GetDataAdapter_image_report_problem_error v= GetDataAdapter1.get(position_image_custom_dialog);
               // String DA=   v.getImage_error();
              //  Log.e("DA",DA);


             //   SQLiteDataBaseBuild();
              //  SQLiteTableBuild();
              //  sqLiteDatabase.execSQL("DELETE FROM " + SQLiteHelper.TABLE_NAME + "" + " WHERE part_image =" + "'" + DA + "'");
              //  Log.e("ข้อมุล", "ลบ");

               // File file = new File(DA);
              //  boolean deleted = file.delete();



                dialog.dismiss();
            }
        });


        ic_dete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                actionMode.finish();
                dialog.dismiss();
            }
        });
        dialog.show();




    }

    public void SQLiteDataBaseBuild(){

        sqLiteDatabase = this.openOrCreateDatabase(SQLiteHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    public void SQLiteTableBuild(){

        //sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper.TABLE_NAME+"("+ SQLiteHelper.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+SQLiteHelper.Table_Column_1_Subject_Name+" VARCHAR, "+SQLiteHelper.Table_Column_2_SubjectFullForm+" VARCHAR, "+SQLiteHelper.Table_Column_3_subteamcode+" VARCHAR, "+SQLiteHelper.Table_Column_5_contract_number+" VARCHAR, "+SQLiteHelper.Table_Column_6_contract_number2+" VARCHAR, "+SQLiteHelper.Table_Column_7_name_topic+" VARCHAR, "+SQLiteHelper.Table_Column_8_customer+" VARCHAR, "+SQLiteHelper.Table_Column_9_description+" VARCHAR, "+SQLiteHelper.Table_Column_16_status+" VARCHAR, "+SQLiteHelper.Table_Column_15_date_time+" VARCHAR, "+SQLiteHelper.Table_Column_23_date_time_update+" VARCHAR, "+SQLiteHelper.Table_Column_10_approveStatus+" VARCHAR, "+SQLiteHelper.Table_Column_11_approveBy+" VARCHAR, "+SQLiteHelper.Table_Column_12_approveDate+" VARCHAR, "+SQLiteHelper.Table_Column_17_isremark+" VARCHAR, "+SQLiteHelper.Table_Column_14_isremark1+" VARCHAR, "+SQLiteHelper.Table_Column_20_check_foller+" VARCHAR, "+SQLiteHelper.Table_Column_21_countfoller+" VARCHAR, "+SQLiteHelper.Table_Column_22_countcomment+" VARCHAR, "+SQLiteHelper.Table_Column_4_picture+" VARCHAR);");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper.TABLE_NAME+"("+ SQLiteHelper.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+SQLiteHelper.Table_part_id+" VARCHAR, "+SQLiteHelper.Table_part_image+" VARCHAR);");


    }
    @Override
    public void onRowLongClicked(int position) {
        enableActionMode(position);
    }

    private void enableActionMode(int position) {
        if (actionMode == null) {
            actionMode = startSupportActionMode(actionModeCallback);
        }
        toggleSelection(position);
    }



    private void toggleSelection(int position) {
        image_report_problem_all_id_adapter.toggleSelection(position);
        int count = image_report_problem_all_id_adapter.getSelectedItemCount();

        if (count == 0) {
            actionMode.finish();
        } else {
            actionMode.setTitle(String.valueOf(count));
            actionMode.invalidate();
        }
    }

    private class ActionModeCallback implements ActionMode.Callback {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.menu_action_mode, menu);

            // disable swipe refresh if action mode is enabled
            //swipeRefreshLayout.setEnabled(false);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_delete:
                    // delete all the selected messages
                    deleteMessages();
                    mode.finish();
                    return true;

                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            image_report_problem_all_id_adapter.clearSelections();
        //  swipeRefreshLayout.setEnabled(true);
            actionMode = null;
            recyclerview.post(new Runnable() {
                @Override
                public void run() {
                    image_report_problem_all_id_adapter.resetAnimationIndex();
                    // mAdapter.notifyDataSetChanged();
                }
            });
        }
    }

    // deleting the messages from recycler view
    private void deleteMessages() {
        image_report_problem_all_id_adapter.resetAnimationIndex();
        List<Integer> selectedItemPositions = image_report_problem_all_id_adapter.getSelectedItems();


        for (int i = selectedItemPositions.size() - 1; i >= 0; i--) {
            image_report_problem_all_id_adapter.removeData(selectedItemPositions.get(i));

        }
        image_report_problem_all_id_adapter.notifyDataSetChanged();
    }
}
