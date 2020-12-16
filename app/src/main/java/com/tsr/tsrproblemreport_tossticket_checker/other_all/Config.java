package com.tsr.tsrproblemreport_tossticket_checker.other_all;

/**
 * Created by Lincoln on 05/01/16.
 */
public class Config {

    // flag to identify whether to show single line
    // or multi line test push notification tray
    public static boolean appendNotificationMessages = true;
    public static boolean appendNotificationMessages2 = true;
    public static boolean appendNotificationMessages3 = true;
    public static boolean appendNotificationMessages4 = true;
    public static boolean appendNotificationMessages5 = true;
    public static boolean appendNotificationMessages6 = true;
    public static boolean appendNotificationMessages7 = true;
    public static boolean appendNotificationMessages8 = true;

    public static boolean appendNotificationMessages9 = true;
    public static boolean appendNotificationMessages10 = true;
    // global topic to receive app wide push notifications
   // public static final String TOPIC_GLOBAL = "global";

    // broadcast receiver intent filters
    public static final String SENT_TOKEN_TO_SERVER = "sentTokenToServer";
   // public static final String REGISTRATION_COMPLETE = "registrationComplete";
  //  public static final String PUSH_NOTIFICATION = "pushNotification";

    // type of push messages
    public static final int PUSH_TYPE_CHATROOM = 1;
    public static final int PUSH_TYPE_USER = 2;

    // id to handle the notification in the notification try
   // public static final int NOTIFICATION_ID = 100;
   // public static final int NOTIFICATION_ID_BIG_IMAGE = 101;




    // global topic to receive app wide push notifications
    public static final String TOPIC_GLOBAL = "global";

    // broadcast receiver intent filters
    public static final String REGISTRATION_COMPLETE = "registrationComplete";
    public static final String PUSH_NOTIFICATION = "pushNotification";

    // id to handle the notification in the notification tray
    public static final int NOTIFICATION_ID = 100;
    public static final int NOTIFICATION_ID2 = 102;
    public static final int NOTIFICATION_ID3 = 103;
    public static final int NOTIFICATION_ID4 = 104;

    public static final int NOTIFICATION_ID5 = 105;
    public static final int NOTIFICATION_ID6 = 106;

    public static final int NOTIFICATION_ID_BIG_IMAGE = 101;

    public static final String SHARED_PREF = "ah_firebase";


}
