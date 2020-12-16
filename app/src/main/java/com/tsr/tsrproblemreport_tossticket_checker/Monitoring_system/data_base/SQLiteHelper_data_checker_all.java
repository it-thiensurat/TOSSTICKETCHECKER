package com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.data_base;

/**
 * Created by Juned on 1/23/2017.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper_data_checker_all extends SQLiteOpenHelper {

    public static String DATABASE_NAME="data_checker_new_new_new";

    public static final String TABLE_NAME="data";

    public static final String Table_Column_ID="id";


    public static final String Table_CONTNO="CONTNO";
    public static final String Table_RefNo="RefNo";
    public static final String Table_SaleEmployeeName="SaleEmployeeName";
    public static final String Table_SaleTeamCode="SaleTeamCode";
    public static final String Table_SaleHeaderName="SaleHeaderName";
    public static final String Table_IDCARD="IDCARD";
    public static final String Table_CustomerName="CustomerName";
    public static final String Table_ADDRESSS="ADDRESSS";
    public static final String Table_Tel="Tel";
    public static final String Table_Tel2="Tel2";
    public static final String Table_ProductName="ProductName";
    public static final String Table_EFFDATE="EFFDATE";
    public static final String Table_Dis="Dis";

    public static final String Table_Latitude="Latitude";
    public static final String Table_Longitude="Longitude";
    public static final String Table_Outstanding="Outstanding";
    public static final String Table_PayLastPeriod="PayLastPeriod";
    public static final String Table_FnYear="FnYear";
    public static final String Table_FnMonth="FnMonth";
    public static final String Table_ProductSerial="ProductSerial";
    public static final String Table_NoID="NoID";

    public static final String Table_CheckerStatus="CheckerStatus";
    public static final String Table_CheckerStatusName="CheckerStatusName";

    public static final String Table_Fortnight_no="Fortnight_no";
    public static final String Table_opendate="opendate";
    public static final String Table_closedate="closedate";

    public static final String Table_AssignDateTime="AssignDateTime";

    public SQLiteHelper_data_checker_all(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        // String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+Table_Column_ID+" INTEGER PRIMARY KEY, "+Table_channel_name+" VARCHAR, "+Table_category_name+" VARCHAR, "+Table_channel_image+" VARCHAR, "+Table_channel_url+" VARCHAR, "+Table_channel_description+" VARCHAR, "+Table_Column_7_name_topic+" VARCHAR, "+Table_Column_8_customer+" VARCHAR, "+Table_Column_9_description+" VARCHAR, "+Table_Column_16_status+" VARCHAR, "+Table_Column_15_date_time+" VARCHAR, "+Table_Column_23_date_time_update+" VARCHAR, "+Table_Column_10_approveStatus+" VARCHAR, "+Table_Column_11_approveBy+" VARCHAR, "+Table_Column_12_approveDate+" VARCHAR, "+Table_Column_17_isremark+" VARCHAR, "+Table_Column_14_isremark1+" VARCHAR, "+Table_Column_20_check_foller+" VARCHAR, "+Table_Column_21_countfoller+" VARCHAR, "+Table_Column_22_countcomment+" VARCHAR, "+Table_Column_4_picture+" VARCHAR)";
        String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+Table_Column_ID+" INTEGER PRIMARY KEY,  "+Table_CONTNO+" VARCHAR,"+Table_RefNo+" VARCHAR,"+Table_SaleEmployeeName+" VARCHAR,"+Table_SaleTeamCode+" VARCHAR,"+Table_SaleHeaderName+" VARCHAR,"+Table_IDCARD+" VARCHAR,"+Table_CustomerName+" VARCHAR,"+Table_ADDRESSS+" VARCHAR,"+Table_Tel+" VARCHAR,"+Table_Tel2+" VARCHAR,"+Table_ProductName+" VARCHAR,"+Table_EFFDATE+" VARCHAR,"+Table_Dis+" VARCHAR,"+Table_Latitude+" VARCHAR,"+Table_Longitude+" VARCHAR,"+Table_Outstanding+" VARCHAR,"+Table_PayLastPeriod+" VARCHAR,"+Table_FnYear+" VARCHAR,"+Table_FnMonth+" VARCHAR,"+Table_ProductSerial+" VARCHAR,"+Table_NoID+" VARCHAR,"+Table_CheckerStatus+" VARCHAR,"+Table_CheckerStatusName+" VARCHAR,"+Table_Fortnight_no+" VARCHAR,"+Table_opendate+" VARCHAR,"+Table_closedate+" VARCHAR,"+Table_AssignDateTime+" VARCHAR)";
        //   String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+Table_Column_ID+" INTEGER PRIMARY KEY, "+Table_Column_1_namethai+" VARCHAR, "+Table_Column_2_position+" VARCHAR) "+Table_Column_3_subteamcode+" VARCHAR, "+Table_Column_4_picture+" VARCHAR) "+Table_Column_5_contract_number+" VARCHAR," + " "+Table_Column_6_contract_number2+" VARCHAR)"+ " "+Table_Column_7_name_topic+" VARCHAR," + " "+Table_Column_8_customer+" VARCHAR)"+ " "+Table_Column_9_description+" VARCHAR," + " "+Table_Column_10_approveStatus+" VARCHAR)"+ " "+Table_Column_11_approveBy+" VARCHAR," + " "+Table_Column_12_approveDate+" VARCHAR)"+ " "+Table_Column_13_updateBy+" VARCHAR," + " "+Table_Column_14_isremark1+" VARCHAR)"+ " "+Table_Column_15_date_time+" VARCHAR," + " "+Table_Column_16_status+" VARCHAR)"+ " "+Table_Column_17_isremark+" VARCHAR," + " "+Table_Column_18_userName+" VARCHAR)"+ " "+Table_Column_19_empID+" VARCHAR," + " "+Table_Column_20_check_foller+" VARCHAR)"+ " "+Table_Column_21_countfoller+" VARCHAR," + " "+Table_Column_22_countcomment+" VARCHAR)"+ " "+Table_Column_23_date_time_update+" VARCHAR," ;
        database.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

}