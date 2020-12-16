package com.tsr.tsrproblemreport_tossticket_checker;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.tsr.tsrproblemreport_tossticket_checker.jsonlogin.INTRO_APP;

import static com.tsr.tsrproblemreport_tossticket_checker.jsonlogin.INTRO_APP.SELECT_PRODUCT_OR_UAT;

public class API_URL_ALL  {

 //   public static String BASE_URL0="https://tssm.thiensurat.co.th/";
    //String BASE_URL="http://app.thiensurat.co.th/";

    //String PRODUCT_OR_UAT=SELECT_PRODUCT_OR_UAT;


 public static  String BASE_URL2="";





 private static String getTsrUrl(){
String BASE_URL="";
  switch (TOSSGeneral.SERVICE_MODE){

        case PRODUCTION:
            //url = "http://203.150.54.248/mca";
         BASE_URL = "https://tssm.thiensurat.co.th/";






         break;
        case UAT:
         BASE_URL = "https://tssm.thiensurat.co.th/assanee_UAT/";

         Log.e("SERVICE_MODE","UAT");


         break;

    }
  return BASE_URL;
 }


 public static final String BASE_URL = getTsrUrl();

 //public static  String BASE_URL = getTsrUrl();



























 /* แจ้งปัญหา เคดิต*/
 public static   String GET_JSON_DATA_HTTP_URL_gory = "";
 public   static String GET_JSON_DATA_HTTP_URL_gory_2= BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_gory_problem_2.php";
 public  static  String GET_JSON_DATA_HTTP_URL_main="";
 public  static  String GET_JSON_DATA_HTTP_URL_sub="";
 public static  String GET_JSON_DATA_HTTP_URL_sub_all=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_Problem_Master.php";
 public static  String GET_JSON_DATA_HTTP_URL_SELECT_PROBLEM_FROM_NUMBER=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_Problem_Master_ID_CODE.php";
 public  static  String GET_JSON_DATA_HTTP_URL_details=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_details_problem.php";


 public   static String GET_JSON_DATA_HTTP_URL_INSENT_DATA_SALE555=BASE_URL+"assanee/api_report_problem_from_contno/report_promlem_contno5.php";
 public  static String GET_JSON_DATA_HTTP_URL_INSENT_DATA_CHECK_CONTNO=BASE_URL+"assanee/api_report_problem_from_contno/report_promlem_contno_note.php";

 public static String GET_JSON_DATA_HTTP_URL_INSENT_DATA_SALE="";
 public static String GET_JSON_DATA_HTTP_URL_select_status_non =BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_status_non.php";
 public static String GET_JSON_DATA_HTTP_URL_sent_nontification_to_web=" http://app.thiensurat.co.th/api/RealTimeDatabase/";
 public static String GET_JSON_select_id_from_Problem_Inform_Master_new=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_id_from_Problem_Inform_Master_Copy_real_new.php";


 public static String GET_JSON_insent_Problem_Inform_Master="";
 public static String GET_JSON_insent_Problem_Inform_Master_new="";
 public static  String GET_JSON_insent_Problem_Inform_Master_for_checker=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Master_for_checker.php";

 public static   String GET_JSON_insent_Problem_Inform_Details=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Details_Copy_real.php";
 public static  String GET_JSON_insent_Problem_Inform_Details2=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Details_Copy_real2.php";
 public static  String GET_JSON_insent_Problem_Inform_Details_Images=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Details_Images_Copy_real.php";
 public static   String GET_JSON_insent_Problem_Inform_Details_Images2=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Inform_Details_Images_Copy_real2.php";

 public static  String GET_JSON_select_id_from_Problem_Inform_Master=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_id_from_Problem_Inform_Master_Copy_real_uat.php";
 public static   String GET_JSON_Delete_data_credit=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/cedit_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_delate.php";


 public static  String GET_JSON_insert_log_problem=BASE_URL+"assanee/checker_system/problem/insert_log_problem.php";

 /* แจ้งปัญหา เคดิต*/











 /* แก้ไขปัญหา การ์ดสัญญา sale*/
 public static   String GET_JSON_DATA_HTTP_URL = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_no_PAGE_4.php";
 public static  String GET_JSON_DATA_HTTP_URL_date1_to_date2 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_no_PAGE_date1_to_date2_4.php";
 public static  String GET_JSON_DATA_HTTP_URL_number_page = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_number_page_no_4.php";
 public static  String GET_JSON_DATA_HTTP_URL_number_page_date1_to_date2 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_number_page_date1_to_date2_no_4.php";

 public static String GET_JSON_DATA_HTTP_URL43=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/avc4.php";

 /* แก้ไขปัญหา การ์ดสัญญา sale*/







 /*  sale menu 0*/
 public static String GET_JSON_DATA_HTTP_URL0 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_problem1_json2_real_from_cedit_edit_problem2_copy_real_PAGE.php";
 public static  String GET_JSON_DATA_HTTP_URL_date1_to_date2_0 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_problem1_json2_real_from_cedit_edit_problem2_copy_real_PAGE_date1_to_date2.php";
 public static  String GET_JSON_DATA_HTTP_URL_number_page_0 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_number_page.php";
 public static String GET_JSON_DATA_HTTP_URL_number_page_date1_to_date2_0 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_number_page_date1_to_date2.php";
 public static String GET_JSON_DATA_HTTP_URL43_0=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/avc4.php";

 /*  sale menu 0*/









 /*  sale menu 00*/
 public static String GET_JSON_DATA_HTTP_URL_00 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_no_PAGE.php";
 public static  String GET_JSON_DATA_HTTP_URL_date1_to_date2_00 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_no_PAGE_date1_to_date2.php";
 public static String GET_JSON_DATA_HTTP_URL_number_page_00 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_number_page_no.php";
 public static String GET_JSON_DATA_HTTP_URL_number_page_date1_to_date2_00 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_number_page_date1_to_date2_no.php";
 public static String GET_JSON_DATA_HTTP_URL43_00=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/avc4.php";
 /*  sale menu 00*/





 /*  sale menu 1*/

 public static String GET_JSON_DATA_HTTP_URL_1 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_no_PAGE_1.php";
 public static String GET_JSON_DATA_HTTP_URL_date1_to_date2_1 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_no_PAGE_date1_to_date2_1.php";
 public static String GET_JSON_DATA_HTTP_URL_number_page_1 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_number_page_no_1.php";
 public static String GET_JSON_DATA_HTTP_URL_number_page_date1_to_date2_1 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_number_page_date1_to_date2_no_1.php";
 public static String GET_JSON_DATA_HTTP_URL43_1=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/avc4.php";
 /*  sale menu 1*/





 /*  sale menu 2*/

 public static  String GET_JSON_DATA_HTTP_URL_2 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_no_PAGE_2.php";
 public static  String GET_JSON_DATA_HTTP_URL_date1_to_date2_2 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_no_PAGE_date1_to_date2_2.php";
 public static  String GET_JSON_DATA_HTTP_URL_number_page_2 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_number_page_no_2.php";
 public static String GET_JSON_DATA_HTTP_URL_number_page_date1_to_date2_2 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_number_page_date1_to_date2_no_2.php";
 public static  String GET_JSON_DATA_HTTP_URL43_2=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/avc4.php";
 /*  sale menu 2*/































 public static  String GET_JSON_select_id_from_Problem_Respon_Details2 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno_UAT/select_id_from_Problem_Respon_Details_copy_real_edit_new2_22.php";
 public static  String Activity_edit_problem_from_sale_uat_GET_JSON_DATA_HTTP_URL = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all_UAT/select_image_problem_from_id_copy_real.php";
 public static  String GET_JSON_DATA_HTTP_URL4 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all_UAT/select_image_problem_from_id_copy_of_details_real.php";
 public static   String GET_JSON_insent_Problem_Respon_Details_Images = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno_UAT/insent_Problem_Respon_Details_Images_copy_real.php";
 public static  String GET_JSON_delete_Problem_Respon_Details_Images = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno_UAT/delete_Problem_Respon_Details_Images_copy_real.php";
 public static  String GET_JSON_select_id_from_Problem_Respon_Master = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno_UAT/select_id_from_Problem_Respon_Master_copy_real.php";
 public static  String GET_JSON_select_id_from_Problem_Respon_Details = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno_UAT/select_id_from_Problem_Respon_Details_copy_real.php";
 public static   String GET_JSON_UPDATE_from_Problem_Respon_Master = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno_UAT/update_Problem_Respon_Master_copy_real.php";
 public static  String GET_JSON_UPDATE_from_Problem_Respon_Details = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno_UAT/update_Problem_Respon_Details_copy_real.php";
 public static   String GET_JSON_select_empid_sent_problem_in_come = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/select_emp_sent_problem_in_come.php";
 public static  String GET_JSON_sent_nontification_to_credit = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/firebase_nontification_sale_to_credit_by_edit_problem/index.php";
 public static  String Activity_edit_problem_from_sale_uat_GET_JSON_DATA_HTTP_URL_sent_nontification_to_web=" http://app.thiensurat.co.th/api/RealTimeDatabase/";
 public static  String GET_JSON_sent_nontification_to_sale_all=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/firebase_nontification_sale_from_cedit_to_sale_all/index.php";
 public static  String URL_non_to_web="ws://toss.thiensurat.co.th:3002";


 public static  String GET_JSON_DATA_HTTP_URL2=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/detalis_all_from_contno.php";












 public static  String GET_JSON_DATA_HTTP_URL_new = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all_UAT/select_image_problem_from_id_copy_real.php";
 public static  String GET_JSON_DATA_HTTP_URL4_new = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all_UAT/select_image_problem_from_id_copy_of_details_real.php";
 public static  String GET_JSON_insent_Problem_Respon_Details_Images_new= BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno_UAT/insent_Problem_Respon_Details_Images_copy_real.php";
 public static  String GET_JSON_select_id_from_Problem_Respon_Master_new= BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno_UAT/select_id_from_Problem_Respon_Master_copy_real.php";
 public static   String GET_JSON_select_id_from_Problem_Respon_Details_new = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno_UAT/select_id_from_Problem_Respon_Details_copy_real_edit_new.php";

 public static  String GET_JSON_select_id_from_Problem_Respon_Details2_new = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno_UAT/select_id_from_Problem_Respon_Details_copy_real_edit_new2_22.php";

 public static   String GET_JSON_UPDATE_from_Problem_Respon_Master_new = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno_UAT/update_Problem_Respon_Master_copy_real.php";
 public static   String GET_JSON_select_empid_sent_problem_in_come_new = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/select_emp_sent_problem_in_come.php";
 public static   String GET_JSON_sent_nontification_to_credit_new = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/firebase_nontification_sale_to_credit_by_edit_problem/index.php";
 public static   String GET_JSON_DATA_HTTP_URL_insent_deails_respon_new=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno_UAT/insent_Problem_Respon_Details_Copy_real.php";
 public static   String GET_JSON_DATA_HTTP_URL_sent_nontification_to_web_new="http://app.thiensurat.co.th/api/RealTimeDatabase/";
 public static   String GET_JSON_sent_nontification_to_sale_all_new=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/firebase_nontification_sale_from_cedit_to_sale_all/index.php";
 public static   String URL_non_to_web_new="ws://uat.thiensurat.co.th:3002";



 public static   String GET_JSON_select_check_sucess_all=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/GET_JSON_select_check_sucess_all2.php";


 public static   String GET_JSON_select_check_delate_all=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/GET_JSON_select_check_delate_all.php";










 public static  String GET_JSON_DATA_HTTP_URL_YES2 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_PAGE2.php";
 public static  String GET_JSON_DATA_HTTP_URL_date1_to_date2_YES2 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_PAGE_date1_to_date2_2.php";
 public static  String GET_JSON_DATA_HTTP_URL_number_page_YES2 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_number_page_yes2.php";
 public static String GET_JSON_DATA_HTTP_URL_number_page_date1_to_date2_YES2 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_number_page_date1_to_date2_yes2.php";





 public static   String GET_JSON_DATA_HTTP_URL_YES1 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/YES1/manager_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_PAGE.php";
 public static  String GET_JSON_DATA_HTTP_URL_date1_to_date2_YES1 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/YES1/manager_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_PAGE_date1_to_date2.php";
 public static   String GET_JSON_DATA_HTTP_URL_number_page_YES1 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/YES1/manager_number_page_yes.php";
 public static  String GET_JSON_DATA_HTTP_URL_number_page_date1_to_date2_YES1 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/YES1/manager_number_page_date1_to_date2_yes.php";






 public static   String GET_JSON_DATA_HTTP_URL_YES0 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/YES0/manager_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_PAGE.php";
 public static  String GET_JSON_DATA_HTTP_URL_date1_to_date2_YES0 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/YES0/manager_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_PAGE_date1_to_date2.php";
 public static   String GET_JSON_DATA_HTTP_URL_number_page_YES0 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/YES0/manager_number_page_yes.php";
 public static  String GET_JSON_DATA_HTTP_URL_number_page_date1_to_date2_YES0 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/YES0/manager_number_page_date1_to_date2_yes.php";






 public static  String GET_JSON_DATA_HTTP_URL_SE_NO3 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_no_PAGE_4_SE.php";
 public static  String GET_JSON_DATA_HTTP_URL_SE_NO2 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_no_PAGE_2_SE.php";
 public static  String GET_JSON_DATA_HTTP_URL_SE_NO1 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_no_PAGE_1_SE.php";

 public static  String GET_JSON_DATA_HTTP_URL_SE_PAGE = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_problem1_json2_real_from_cedit_edit_problem2_copy_real_PAGE_SE.php";




 public static  String GET_JSON_DATA_HTTP_URL_SE_YES3 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/manager_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_PAGE2_SE.php";
 public static  String GET_JSON_DATA_HTTP_URL_SE_YES2 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/YES1/manager_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_PAGE_SE.php";
 public static  String GET_JSON_DATA_HTTP_URL_SE_YES1 = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/YES0/manager_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_PAGE_SE.php";




 public static  String GET_JSON_DATA_HTTP_URL_number_page_date1_to_date2_PAGE4_ALL=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/PAGE4_ALL/manager_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_PAGE_4_ALL_number_page_date_to_date.php";
 public static  String GET_JSON_DATA_HTTP_URL_number_page_PAGE4_ALL=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/PAGE4_ALL/manager_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_PAGE_4_ALL_number_page.php";
 public static  String GET_JSON_DATA_HTTP_URL_date1_to_date2_PAGE4_ALL=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/PAGE4_ALL/manager_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_PAGE_4_ALL_date_to_date.php";
 public static  String GET_JSON_DATA_HTTP_URL_PAGE4_ALL=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/PAGE4_ALL/manager_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_PAGE_4_ALL.php";
 public static  String GET_JSON_DATA_HTTP_URL_SE_PAGE4_ALL=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/PAGE4_ALL/manager_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_PAGE_4_ALL_SE.php";




 /*   CREDIT*/

 public static  String GET_JSON_DATA_HTTP_URL_CREDIT1=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/credit/problem_all/cedit_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real.php";
 public static  String  GET_JSON_DATA_HTTP_URL_SE_PAGE_CREDIT1=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/credit/problem_all/cedit_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_SE.php";
 public static  String GET_JSON_DATA_HTTP_URL_date1_to_date2_CREDIT1=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/credit/problem_all/cedit_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_date1_to_date2.php";
 public static  String GET_JSON_DATA_HTTP_URL_number_page_CREDIT1=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/credit/problem_all/cedit_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_number_page.php";
 public static  String GET_JSON_DATA_HTTP_URL_number_page_date1_to_date2_CREDIT1=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/credit/problem_all/cedit_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_date1_to_date2_number_page.php";

 /*   CREDIT*/


/***  checker card ระบบ ตรวจสอบ */
public static String GET_JSON_insert_CheckerCard_Master=BASE_URL+"assanee/checker_system/Master/insert_CheckerCard_Master_home_in.php";
 public static String GET_JSON_insert_CheckerCard_Dedails=BASE_URL+"assanee/checker_system/Details/insert_CheckerCard_Details.php";
 public static String GET_JSON_insert_CheckerCard_Dedails_GPS=BASE_URL+"assanee/checker_system/Details/insert_CheckerCard_Details_GPS.php";
 public static String GET_JSON_insert_CheckerCard_Images=BASE_URL+"assanee/checker_system/Images/insert_CheckerCard_Image.php";

 public static String GET_JSON_check_and_update_CheckerCard_Master=BASE_URL+"assanee/checker_system/check_and_update_CheckerCard_Master.php";






 public static String GET_JSON_DATA_HTTP_URL_gory_1= BASE_URL+"assanee/checker_system/insert_CheckerCard_Details_home_in.php";
 public static String GET_JSON_DATA_HTTP_URL_gory_1_save_back= BASE_URL+"assanee/checker_system/insert_CheckerCard_Details_home_in_save_back.php";
 public static String GET_JSON_DATA_HTTP_URL_gory_2_checker= BASE_URL+"assanee/checker_system/insert_CheckerCard_Details_gps_maker.php";
 public static String GET_JSON_DATA_HTTP_URL_gory_2_save_back= BASE_URL+"assanee/checker_system/insert_CheckerCard_Details_gps_maker_save_back.php";
 public static String GET_JSON_DATA_HTTP_URL_gory_3= BASE_URL+"assanee/checker_system/insert_CheckerCard_Details_install.php";
 public static String GET_JSON_DATA_HTTP_URL_gory_3_save_back= BASE_URL+"assanee/checker_system/insert_CheckerCard_Details_install_save_back.php";
 public static String GET_JSON_DATA_HTTP_URL_gory_4= BASE_URL+"assanee/checker_system/insert_CheckerCard_Details_checker_who.php";
 public static String GET_JSON_DATA_HTTP_URL_gory_4_save_back= BASE_URL+"assanee/checker_system/insert_CheckerCard_Details_checker_who_save_back.php";
 public static String GET_JSON_DATA_HTTP_URL_tai= BASE_URL+"assanee/checker_system/insert_CheckerCard_Details_tain.php";
 public static String GET_JSON_DATA_HTTP_URL_product_name= BASE_URL+"assanee/checker_system/insert_CheckerCard_Details_product_name.php";
 public static String GET_JSON_DATA_HTTP_URL_product_name_save_back= BASE_URL+"assanee/checker_system/insert_CheckerCard_Details_product_name_save_back.php";
 public static String GET_JSON_DATA_HTTP_URL__date_to_date= BASE_URL+"assanee/checker_system/insert_CheckerCard_Details_date_to_date.php";
 public static String GET_JSON_DATA_HTTP_URL__date_to_date_save_back= BASE_URL+"assanee/checker_system/insert_CheckerCard_Details_date_to_date_save_back.php";
 public static String GET_JSON_DATA_HTTP_URL_checker = BASE_URL+"assanee/checker_system/type_check2.php";
 public static String GET_JSON_DATA_HTTP_URL_data_check_over_day= "";
 public static String GET_JSON_DATA_HTTP_URL_gory_5= BASE_URL+"assanee/checker_system/data_confirm.php";
 public static String GET_JSON_DATA_HTTP_URL_gory_5_save_back= BASE_URL+"assanee/checker_system/data_confirm_save_back.php";
 public static String GET_JSON_DATA_HTTP_URL_gory_6= BASE_URL+"assanee/checker_system/data_confirm2.php";
 public static String GET_JSON_DATA_HTTP_URL_gory_6_save_back= BASE_URL+"assanee/checker_system/data_confirm2_save_back.php";




 public static String GET_JSON_select_check_sucess_all_checker=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_check_sucess_all2.php";
 public static String GET_JSON_insert_CheckerCard_AgainPending= BASE_URL+"assanee/checker_system/Details/insert_CheckerCard_AgainPending.php";
 public static String GET_JSON_select_CheckerCard_AgainPending= BASE_URL+"assanee/checker_system/Details/select_CheckerCard_AgainPending.php";

 public static String GET_JSON_Delete_data_credit_UI_CARDVIEW_DATA_MANAGER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_CREDIT1=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/cedit_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_delate.php";
 public static String GET_JSON_DATA_HTTP_URL2_UI_CARDVIEW_DATA_MANAGER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_CREDIT1=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/detalis_all_from_contno.php";
 public static String GET_JSON_DATA_HTTP_URL_gory_6_UI_CARDVIEW_DATA_MANAGER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_CREDIT1= BASE_URL+"assanee/checker_system/data_confirm3.php";




/***Check_Fragment1**/
 public static String GET_JSON_DATA_HTTP_URL_Check_Fragment1 = BASE_URL+"assanee/checker_system/type_check.php";
 public static String GET_JSON_INSENT_checker_edit_custommer_all =BASE_URL+"assanee/checker_system/EditData/insert_CheckerCard_EditData.php";
 public static String GET_JSON_INSENT_checker_edit_custommer_all_tel =BASE_URL+"assanee/checker_system/EditData/insert_CheckerCard_EditData_tel.php";

 public static   String GET_JSON_DATA_HTTP_URL_IMAGE ="http://bof.thiensurat.co.th/mca/images/NewcontractImage/";
 public static String GET_JSON_DATA_HTTP_URL2_Check_Fragment1 = BASE_URL+"assanee/api_cedit_all_problem_from_web/cedit_data_image_pagerview.php";
 public static String GET_JSON_DATA_HTTP_URL_select_new_data=BASE_URL+"assanee/checker_system/edit_data_new.php";
/***Check_Fragment1**/

/***Check_Fragment1_2**/
public static String GET_JSON_DATA_HTTP_URL_select_color=BASE_URL+"assanee/checker_system/data_select_color.php";
 public static String GET_JSON_UPDATE_MASTER_AND_DETAILS_CHECKER=BASE_URL+"assanee/checker_system/Update_mas_and_details/update_mas_and_details.php";
 public static String JSON_DATA_WEB_CALL22__Check_Fragment1_2= BASE_URL+"assanee/checker_system/data_check_image.php";
/***Check_Fragment1_2**/












/***  checker card ระบบ ตรวจสอบ */








/*** ระบบแก้ไขปัญหา Sale >> Activity_edit_problem_from_sale***/
public static String GET_JSON_DATA_HTTP_URL_Activity_edit_problem_from_sale = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/select_image_problem_from_id_copy_real.php";
 public static String GET_JSON_DATA_HTTP_URL4_Activity_edit_problem_from_sale = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/select_image_problem_from_id_copy_of_details_real.php";
 public static String GET_JSON_insent_Problem_Respon_Details_Images_Activity_edit_problem_from_sale = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Respon_Details_Images_copy_real.php";
 public static String GET_JSON_delete_Problem_Respon_Details_Images_Activity_edit_problem_from_sale = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/delete_Problem_Respon_Details_Images_copy_real.php";
 public static String GET_JSON_select_id_from_Problem_Respon_Master_Activity_edit_problem_from_sale = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_id_from_Problem_Respon_Master_copy_real.php";
 public static  String GET_JSON_select_id_from_Problem_Respon_Details_Activity_edit_problem_from_sale = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_id_from_Problem_Respon_Details_copy_real.php";
 public static String GET_JSON_UPDATE_from_Problem_Respon_Master_Activity_edit_problem_from_sale = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/update_Problem_Respon_Master_copy_real.php";
 public static String GET_JSON_UPDATE_from_Problem_Respon_Details_Activity_edit_problem_from_sale = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/update_Problem_Respon_Details_copy_real.php";
 public static String GET_JSON_select_empid_sent_problem_in_come_Activity_edit_problem_from_sale = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/select_emp_sent_problem_in_come.php";
 public static String GET_JSON_sent_nontification_to_credit_Activity_edit_problem_from_sale = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/firebase_nontification_sale_to_credit_by_edit_problem/index.php";
 public static String GET_JSON_DATA_HTTP_URL_sent_nontification_to_web_Activity_edit_problem_from_sale=" http://app.thiensurat.co.th/api/RealTimeDatabase/";
 public static String GET_JSON_sent_nontification_to_sale_all_Activity_edit_problem_from_sale=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/firebase_nontification_sale_from_cedit_to_sale_all/index.php";
 public static String URL_non_to_web_Activity_edit_problem_from_sale="ws://toss.thiensurat.co.th:3002";
 public static String GET_JSON_DATA_HTTP_URL2_Activity_edit_problem_from_sale=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/detalis_all_from_contno.php";
 public static String GET_JSON_DATA_HTTP_URL_gory_6_Activity_edit_problem_from_sale= BASE_URL+"assanee/checker_system/data_confirm3.php";





 /*** ระบบแก้ไขปัญหา Sale >> Activity_edit_problem_from_sale_edit_new***/
 public static String GET_JSON_DATA_HTTP_URL_Activity_edit_problem_from_sale_edit_new = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/select_image_problem_from_id_copy_real.php";
 public static String GET_JSON_DATA_HTTP_URL4_Activity_edit_problem_from_sale_edit_new = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/select_image_problem_from_id_copy_of_details_real.php";
 public static String GET_JSON_insent_Problem_Respon_Details_Images_Activity_edit_problem_from_sale_edit_new = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Respon_Details_Images_copy_real.php";
 public static String GET_JSON_select_id_from_Problem_Respon_Master_Activity_edit_problem_from_sale_edit_new = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_id_from_Problem_Respon_Master_copy_real.php";
 public static String GET_JSON_select_id_from_Problem_Respon_Details_Activity_edit_problem_from_sale_edit_new = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/select_id_from_Problem_Respon_Details_copy_real_edit_new.php";
 public static String GET_JSON_UPDATE_from_Problem_Respon_Master_Activity_edit_problem_from_sale_edit_new = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/update_Problem_Respon_Master_copy_real.php";
 public static String GET_JSON_select_empid_sent_problem_in_come_Activity_edit_problem_from_sale_edit_new = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale/problem_all/select_emp_sent_problem_in_come.php";
 public static String GET_JSON_sent_nontification_to_credit_Activity_edit_problem_from_sale_edit_new = BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/firebase_nontification_sale_to_credit_by_edit_problem/index.php";
 public static String GET_JSON_DATA_HTTP_URL_insent_deails_respon_Activity_edit_problem_from_sale_edit_new=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/api_report_problem_from_contno/insent_Problem_Respon_Details_Copy_real.php";
 public static String GET_JSON_DATA_HTTP_URL_sent_nontification_to_web_Activity_edit_problem_from_sale_edit_new=" http://app.thiensurat.co.th/api/RealTimeDatabase/";
 public static String GET_JSON_sent_nontification_to_sale_all_Activity_edit_problem_from_sale_edit_new=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/firebase_nontification_sale_from_cedit_to_sale_all/index.php";
 public static String URL_non_to_web_Activity_edit_problem_from_sale_edit_new="ws://uat.thiensurat.co.th:3002";
 public static String GET_JSON_DATA_HTTP_URL2_Activity_edit_problem_from_sale_edit_new=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/detalis_all_from_contno.php";
 public static String GET_JSON_DATA_HTTP_URL_gory_6_Activity_edit_problem_from_sale_edit_new= BASE_URL+"assanee/checker_system/data_confirm3.php";



 public static String GET_JSON_DATA_HTTP_URL2_Activity_edit_problem_from_sale_edit_new_uat=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/detalis_all_from_contno_page4.php";
 public static String GET_JSON_DATA_HTTP_URL_gory_6_Activity_edit_problem_from_sale_edit_new_uat= BASE_URL+"assanee/checker_system/data_confirm3.php";

 public static String GET_JSON_DATA_HTTP_URL2_Activity_edit_problem_from_sale_uat=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/manager/problem_all/detalis_all_from_contno_page4.php";
 public static String GET_JSON_DATA_HTTP_URL_gory_6_Activity_edit_problem_from_sale_uat= BASE_URL+"assanee/checker_system/data_confirm3.php";



 public static String GET_JSON_DATA_HTTP_URL_delate_data_checker= BASE_URL+"assanee/checker_system/delate_data_checker.php";







    /*   SALE_REPORT_PROBLEM*/

    public static  String GET_JSON_DATA_HTTP_URL_SALE_REPORT_PROBLEM=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale_report_problem/problem_all/cedit_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real.php";
    public static  String  GET_JSON_DATA_HTTP_URL_SE_PAGE_SALE_REPORT_PROBLEM=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale_report_problem/problem_all/cedit_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_SE.php";
    public static  String GET_JSON_DATA_HTTP_URL_date1_to_date2_SALE_REPORT_PROBLEM=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale_report_problem/problem_all/cedit_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_date1_to_date2.php";
    public static  String GET_JSON_DATA_HTTP_URL_number_page_SALE_REPORT_PROBLEM=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale_report_problem/problem_all/cedit_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_number_page.php";
    public static  String GET_JSON_DATA_HTTP_URL_number_page_date1_to_date2_SALE_REPORT_PROBLEM=BASE_URL+"assanee/api_sale_all_problem_from_cedit_by_db_kiw/sale_report_problem/problem_all/cedit_problem1_json2_real_from_cedit_edit_problem2_copy_waiting_to_check_real_date1_to_date2_number_page.php";

    /*   CREDIT*/

}
