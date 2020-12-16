package com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.data_base;

/**
 * Created by Juned on 1/23/2017.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper_data_type extends SQLiteOpenHelper {

    public static String DATABASE_NAME="data_type";

    public static final String TABLE_NAME="data_type";

    public static final String Table_Column_ID="id";


    public static final String Table_part_id="part_id";
    public static final String Table_ProcessTypeName="ProcessTypeName";
    public static final String Table_Processclick="Processclick";

    public SQLiteHelper_data_type(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        // String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+Table_Column_ID+" INTEGER PRIMARY KEY, "+Table_channel_name+" VARCHAR, "+Table_category_name+" VARCHAR, "+Table_channel_image+" VARCHAR, "+Table_channel_url+" VARCHAR, "+Table_channel_description+" VARCHAR, "+Table_Column_7_name_topic+" VARCHAR, "+Table_Column_8_customer+" VARCHAR, "+Table_Column_9_description+" VARCHAR, "+Table_Column_16_status+" VARCHAR, "+Table_Column_15_date_time+" VARCHAR, "+Table_Column_23_date_time_update+" VARCHAR, "+Table_Column_10_approveStatus+" VARCHAR, "+Table_Column_11_approveBy+" VARCHAR, "+Table_Column_12_approveDate+" VARCHAR, "+Table_Column_17_isremark+" VARCHAR, "+Table_Column_14_isremark1+" VARCHAR, "+Table_Column_20_check_foller+" VARCHAR, "+Table_Column_21_countfoller+" VARCHAR, "+Table_Column_22_countcomment+" VARCHAR, "+Table_Column_4_picture+" VARCHAR)";
        String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+Table_Column_ID+" INTEGER PRIMARY KEY,  "+Table_part_id+" VARCHAR,"+Table_ProcessTypeName+" VARCHAR,"+Table_Processclick+" VARCHAR)";
        //   String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+Table_Column_ID+" INTEGER PRIMARY KEY, "+Table_Column_1_namethai+" VARCHAR, "+Table_Column_2_position+" VARCHAR) "+Table_Column_3_subteamcode+" VARCHAR, "+Table_Column_4_picture+" VARCHAR) "+Table_Column_5_contract_number+" VARCHAR," + " "+Table_Column_6_contract_number2+" VARCHAR)"+ " "+Table_Column_7_name_topic+" VARCHAR," + " "+Table_Column_8_customer+" VARCHAR)"+ " "+Table_Column_9_description+" VARCHAR," + " "+Table_Column_10_approveStatus+" VARCHAR)"+ " "+Table_Column_11_approveBy+" VARCHAR," + " "+Table_Column_12_approveDate+" VARCHAR)"+ " "+Table_Column_13_updateBy+" VARCHAR," + " "+Table_Column_14_isremark1+" VARCHAR)"+ " "+Table_Column_15_date_time+" VARCHAR," + " "+Table_Column_16_status+" VARCHAR)"+ " "+Table_Column_17_isremark+" VARCHAR," + " "+Table_Column_18_userName+" VARCHAR)"+ " "+Table_Column_19_empID+" VARCHAR," + " "+Table_Column_20_check_foller+" VARCHAR)"+ " "+Table_Column_21_countfoller+" VARCHAR," + " "+Table_Column_22_countcomment+" VARCHAR)"+ " "+Table_Column_23_date_time_update+" VARCHAR," ;
        database.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

}