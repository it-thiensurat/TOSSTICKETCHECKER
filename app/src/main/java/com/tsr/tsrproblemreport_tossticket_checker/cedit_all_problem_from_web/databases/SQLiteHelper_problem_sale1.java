package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.databases;



/**
 * Created by Juned on 1/23/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper_problem_sale1 extends SQLiteOpenHelper {

    public static String DATABASE_NAME="androiddata";

    public static final String TABLE_NAME="problemsale";

    public static final String Table_Column_ID="id";

    public static final String Table_InformID="InformID";
    public static final String Table_ResponStatus="ResponStatus";
    public static final String Table_Contno="Contno";
    public static final String Table_ID="ID";
    public static final String Table_EmployeeName="EmployeeName";
    public static final String Table_PositionName="PositionName";
    public static final String Table_picture="picture";
    public static final String Table_topic_problem="topic_problem";
    public static final String Table_main="main";
    public static final String Table_gory="gory";
    public static final String Table_ProblemDetail="ProblemDetail";
    public static final String Table_ProblemDetail2="ProblemDetail2";
    public static final String Table_ProblemDetail3="ProblemDetail3";
    public static final String Table_ProblemDetail4="ProblemDetail4";
    public static final String Table_WorkCode="WorkCode";
    public static final String Table_WorkName="WorkName";
    public static final String Table_date_modify="date_modify";
    public static final String Table_Image_Name="Image_Name";
    public static final String Table_countImage="countImage";
    public static final String Table_Image_Name_R="Image_Name_R";
    public static final String Table_countImage_R="countImage_R";
    public static final String Table_ImageUrl="ImageUrl";
    public static final String Table_ImageUrl_R="ImageUrl_R";
    public static final String Table_Items_R="Items_R";
    public static final String Table_user_code="user_code";
    public static final String Table_ProblemDetail_sub="ProblemDetail_sub";
    public static final String Table_Informitem="Informitem";
    public static final String Table_customer="customer";
    public static final String Table_address="address";
    public static final String Table_tel="tel";
    public static final String Table_tel2="tel2";
    public static final String Table_EffDate="EffDate";

    public SQLiteHelper_problem_sale1(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        //String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+Table_Column_ID+" INTEGER PRIMARY KEY, "+Table_channel_name+" VARCHAR, "+Table_category_name+" VARCHAR, "+Table_channel_image+" VARCHAR, "+Table_channel_url+" VARCHAR, "+Table_channel_description+" VARCHAR, "+Table_Column_7_name_topic+" VARCHAR, "+Table_Column_8_customer+" VARCHAR, "+Table_Column_9_description+" VARCHAR, "+Table_Column_16_status+" VARCHAR, "+Table_Column_15_date_time+" VARCHAR, "+Table_Column_23_date_time_update+" VARCHAR, "+Table_Column_10_approveStatus+" VARCHAR, "+Table_Column_11_approveBy+" VARCHAR, "+Table_Column_12_approveDate+" VARCHAR, "+Table_Column_17_isremark+" VARCHAR, "+Table_Column_14_isremark1+" VARCHAR, "+Table_Column_20_check_foller+" VARCHAR, "+Table_Column_21_countfoller+" VARCHAR, "+Table_Column_22_countcomment+" VARCHAR, "+Table_Column_4_picture+" VARCHAR)";
       String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+Table_Column_ID+" INTEGER PRIMARY KEY,  " +
               ""+Table_InformID+" VARCHAR" +
               ","+Table_ResponStatus+" VARCHAR,"+Table_Contno+" VARCHAR,"+Table_ID+" VARCHAR" +
               ","+Table_EmployeeName+" VARCHAR,"+Table_PositionName+" VARCHAR" +
               ","+Table_picture+" VARCHAR,"+Table_topic_problem+" VARCHAR" +
               ","+Table_main+" VARCHAR,"+Table_gory+" VARCHAR,"+Table_ProblemDetail+" VARCHAR" +
               ","+Table_ProblemDetail2+" VARCHAR,"+Table_ProblemDetail3+" VARCHAR,"+Table_ProblemDetail4+" VARCHAR" +
               ","+Table_WorkCode+" VARCHAR,"+Table_WorkName+" VARCHAR,"+Table_date_modify+" VARCHAR,"+Table_Image_Name+" VARCHAR" +
               ","+Table_countImage+" VARCHAR,"+Table_Image_Name_R+" VARCHAR,"+Table_countImage_R+" VARCHAR" +
               ","+Table_ImageUrl+" VARCHAR,"+Table_ImageUrl_R+" VARCHAR,"+Table_Items_R+" VARCHAR,"+Table_user_code+" VARCHAR" +
               ","+Table_ProblemDetail_sub+" VARCHAR,"+Table_Informitem+" VARCHAR,"+Table_customer+" VARCHAR" +
               ","+Table_address+" VARCHAR,"+Table_tel+" VARCHAR,"+Table_tel2+" VARCHAR,"+Table_EffDate+" VARCHAR)";
        //   String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+Table_Column_ID+" INTEGER PRIMARY KEY, "+Table_Column_1_namethai+" VARCHAR, "+Table_Column_2_position+" VARCHAR) "+Table_Column_3_subteamcode+" VARCHAR, "+Table_Column_4_picture+" VARCHAR) "+Table_Column_5_contract_number+" VARCHAR," + " "+Table_Column_6_contract_number2+" VARCHAR)"+ " "+Table_Column_7_name_topic+" VARCHAR," + " "+Table_Column_8_customer+" VARCHAR)"+ " "+Table_Column_9_description+" VARCHAR," + " "+Table_Column_10_approveStatus+" VARCHAR)"+ " "+Table_Column_11_approveBy+" VARCHAR," + " "+Table_Column_12_approveDate+" VARCHAR)"+ " "+Table_Column_13_updateBy+" VARCHAR," + " "+Table_Column_14_isremark1+" VARCHAR)"+ " "+Table_Column_15_date_time+" VARCHAR," + " "+Table_Column_16_status+" VARCHAR)"+ " "+Table_Column_17_isremark+" VARCHAR," + " "+Table_Column_18_userName+" VARCHAR)"+ " "+Table_Column_19_empID+" VARCHAR," + " "+Table_Column_20_check_foller+" VARCHAR)"+ " "+Table_Column_21_countfoller+" VARCHAR," + " "+Table_Column_22_countcomment+" VARCHAR)"+ " "+Table_Column_23_date_time_update+" VARCHAR," ;
        database.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

}