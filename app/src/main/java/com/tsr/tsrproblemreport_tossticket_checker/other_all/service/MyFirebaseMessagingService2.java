package com.tsr.tsrproblemreport_tossticket_checker.other_all.service;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.MusicActivity_Checker;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.MusicActivity_Credit;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities.Activity_check_problem_by_cedit_nonti;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.UI_CARDVIEW_DATA_CREDIT_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT2_Acti;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.manager.UI_CARDVIEW_DATA_MANAGER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_NO_3_activity;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.nontification.NotificationUtils_credit_from_sale;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.nontification.NotificationUtils_sale_from_cedit;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.nontification.NotificationUtils_web_to_cedit;
import com.tsr.tsrproblemreport_tossticket_checker.payment_system.MusicActivity_Payment;

import static com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.MusicActivity_Checker.dad;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.tsr.tsrproblemreport_tossticket_checker.other_all.service.NotificationUtils.getTimeMilliSec;

/**
 * Created by Ravi Tamada on 08/08/16.
 * www.androidhive.info
 */
public class MyFirebaseMessagingService2 extends FirebaseMessagingService {

    private static final String TAG = MyFirebaseMessagingService2.class.getSimpleName();
    private Context mContext;
    Intent resultIntent;

    private NotificationUtils_web_to_cedit notificationUtils_web_to_cedit;
    private NotificationUtils_sale_from_cedit notificationUtils_sale_from_cedit;
    private NotificationUtils_credit_from_sale notificationUtils_credit_from_sale;
    private NotificationUtils notificationUtils;
    int count=0;

    private static final Random random = new Random();
    public static final String INTENT_KEY = "THE_QUOTE";
    public static final String INTENT_KEY_2 = "INTENT_KEY_2";
    String Sound,nontification;

   String myVersion = MyApplication.getInstance().getPrefManager().getPreferrence("myVersion");

//   float ver= Float.parseFloat(myVersion);
    //public MyFirebaseMessagingService2(Context mContext) {
     //   this.mContext = mContext;
  //  }
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
       //Log.e(TAG, "From: " + remoteMessage.getFrom());

        if (remoteMessage == null)
            return;

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
      //      Log.e(TAG, "Notification Body: " + remoteMessage.getNotification().getBody());


        }

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
        //    Log.e(TAG, "Data Payload: " + remoteMessage.getData().toString());

            try {
                JSONObject json = new JSONObject(remoteMessage.getData().toString());


                /*
                String id = "my_channel_01";
                Notification notification = new NotificationCompat.Builder(mContext, id)
                        .setContentTitle("New Messages")
                        .setContentText("You've received 3 new messages.")
                        .setSmallIcon(R.drawable.icon)
                        .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
                        .build();

                NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
                //  notificationManager.notify(Config.NOTIFICATION_ID, notification);
                notificationManager.notify(Config2.NOTIFICATION_ID, notification);
*/
//Log.e("sss","sss");
                //setBadge(getApplicationContext(),1);
                //Log.d(TAG, "Message data payload: " + remoteMessage.getData());
                // In this case the XMPP Server sends a payload data
             //   String title = remoteMessage.getData().get("title2");
               // String message = remoteMessage.getData().get("message2");
               // String image = remoteMessage.getData().get("image2");
            //    Log.d(TAG, "Message received: " + message);



                //handleDataMessage(json);
              //  handleDataMessage2(json);


                handleDataMessage_sale_from_cedit(json);
                handleDataMessage_credit_from_sale(json);
                handleDataMessage_credit_to_sale(json);
                handleDataMessage_sale_to_sale_all(json);

                handleDataMessage_credit_from_web(json);

                handleDataMessage_sale_to_sale_all2(json);

                handleDataMessage_sale_and_credit_from_web_closing(json);
                handleDataMessage_sale_and_credit_from_web_closing_extra(json);
                handleDataMessage_sale_and_credit_from_web_closing_extra_success(json);

                handleDataMessage_sale_and_credit_from_web_closing_credit(json);
                handleDataMessage_sale_and_credit_from_web_closing_credit_extra(json);
                handleDataMessage_sale_and_credit_from_web_closing_credit_extra_success(json);

                handleDataMessage_credit_from_web_cancel(json);
                handleDataMessage_credit_from_web_receive(json);

                handleDataMessage_logout_all(json);

                handleDataMessage_checker(json);
                handleDataMessage_checker2(json);
                handleDataMessage_sale_all_for_checker(json);
                handleDataMessage_sale_all_for_checker_by_web(json);
            } catch (Exception e) {

               // Log.e(TAG, "Exception: " + e.getMessage());
            }
        }
    }











    private void handleDataMessage_credit_from_web(JSONObject json) {
        Log.e(TAG, "push json: " + json.toString());

        try {
            JSONObject data2 = json.getJSONObject("web_to_cedit_checker");

            String title = data2.getString("title_web_to_cedit_checker");
            String message = data2.getString("message_web_to_cedit_checker");
            String timestamp = data2.getString("timestamp_web_to_cedit_checker");
            String image_cedit = data2.getString("image_web_to_cedit_checker");



            //sale_all_from_web


            //ShortcutBadger.applyCount(mContext, 15);

            if (android.os.Build.VERSION.SDK_INT>=8.1) {
                sendNotification(image_cedit,message,title,timestamp,"รายการชำระเงินจากลูกค้า","By Website"+":"+"Admin","#32CD32",R.drawable.ic_tab_contacts,2222,2);

            }

             else {
              String randomQuote = String.valueOf(new Random().nextInt());
              try {
                  Intent pushNotification = new Intent(Config2.PUSH_NOTIFICATION);
                  pushNotification.putExtra("title_web_to_cedit_checker", title);
                  pushNotification.putExtra("message_web_to_cedit_checker", message);
                  pushNotification.putExtra("timestamp_web_to_cedit_checker", timestamp);
                  pushNotification.putExtra("image_web_to_cedit_checker", image_cedit);
                  LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);



                  NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                  Bitmap bitmap = getBitmapFromURL(image_cedit);
                  bitmap = getCircleBitmap(bitmap);
                  String oldNotification=message;
                  List<String> messages = Arrays.asList(oldNotification.split(","));
                  for (int i =0;i< messages.size(); i++) {
                      inboxStyle.addLine("-"+" :"+messages.get(i));
                  }
                  NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

                  for (int i =0;i< messages.size(); i++) {
                      bigText.bigText(messages.get(i));
                  }
                  bigText.setBigContentTitle("ชำระเงินจากลูกค้า:"+"เลขที่:"+title);
                  bigText.setSummaryText("By Website"+":"+"Admin");

                  playNotificationSound();

                  Log.i(TAG, "QUOTE: " + randomQuote);
                  Intent showFullQuoteIntent = new Intent(this, MusicActivity_Payment.class);
                  showFullQuoteIntent.putExtra(INTENT_KEY, randomQuote);
                  showFullQuoteIntent.putExtra("title_web_to_cedit_checker", title);
                  showFullQuoteIntent.putExtra("message_web_to_cedit_checker", message);
                  showFullQuoteIntent.putExtra("image_web_to_cedit_checker", image_cedit);
                  showFullQuoteIntent.putExtra("timestamp_web_to_cedit_checker", timestamp);





                  int uniqueInt = (int) (System.currentTimeMillis() & 0xfffffff);
                  PendingIntent pendingIntent = PendingIntent.getActivity(this, uniqueInt, showFullQuoteIntent, PendingIntent.FLAG_UPDATE_CURRENT);


                  Notification notification = new NotificationCompat.Builder(this)

                          .setTicker(randomQuote)
                          .setAutoCancel(true)
                          .setContentTitle("ชำระเงินจากลูกค้า:"+"เลขที่:"+title)
                          .setContentIntent(pendingIntent)
                          //.setSound(alarmSound)
                          .setStyle(inboxStyle)
                          .setWhen(getTimeMilliSec(timestamp))
                          .setSmallIcon(R.drawable.ic_tab_contacts)
                          .setLargeIcon(bitmap)
                          .setNumber(messages.size())
                          .setColor(Color.parseColor("#32CD32"))
                          .setSubText("By Website"+":"+"Admin")
                          .setVibrate(new long[] { 500, 500, 500 })
                          .setPriority(NotificationCompat.PRIORITY_MAX)
                          .build();











                  NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                  notificationManager.notify(Integer.parseInt(randomQuote), notification);
                  acquireWakeLock(getApplicationContext());
                  releaseWakeLock();

              }
              catch (Exception ex){
                  sendNotification(image_cedit,message,title,timestamp,"รายการชำระเงินจากลูกค้า","By Website"+":"+"Admin","#32CD32",R.drawable.ic_tab_contacts,Integer.parseInt(randomQuote),1);

              }
             }






  /*
*/











        }
        catch (Exception ex){

        }
    }

    private void handleDataMessage_sale_to_sale_all2(JSONObject json) {
        Log.e(TAG, "push json: " + json.toString());

        try {
            JSONObject data2 = json.getJSONObject("sale_all_from_web");

            String title = data2.getString("title_sale_from_cedit_to_sale_all_from_web");
            String message = data2.getString("message_sale_from_cedit_to_sale_all_from_web");
            String contno = data2.getString("contno_sale_from_cedit_to_sale_all_from_web");
            String timestamp = data2.getString("timestamp_sale_from_cedit_to_sale_all_from_web");
            String image_cedit = data2.getString("image_cedit_sale_from_cedit_to_sale_all_from_web");


            if (android.os.Build.VERSION.SDK_INT>=8.1) {
                sendNotification(image_cedit,message,contno,timestamp,"รับปัญหา การ์ดสัญญา เข้าระบบ","By Website"+":"+"Admin","#ee2c7a",R.drawable.ic_tab_contacts,1,1);

            }
            else {
                try {
                    Intent pushNotification = new Intent(Config2.PUSH_NOTIFICATION);
                    pushNotification.putExtra("title_web_to_cedit_checker", title);
                    pushNotification.putExtra("message_web_to_cedit_checker", message);
                    pushNotification.putExtra("timestamp_web_to_cedit_checker", timestamp);
                    pushNotification.putExtra("image_web_to_cedit_checker", image_cedit);
                    LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);



                    NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                    Bitmap bitmap = getBitmapFromURL(image_cedit);
                    bitmap = getCircleBitmap(bitmap);
                    String oldNotification=message;
                    List<String> messages = Arrays.asList(oldNotification.split(","));
                    for (int i =0;i< messages.size(); i++) {
                        inboxStyle.addLine("-"+" :"+messages.get(i));
                    }
                    NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

                    for (int i =0;i< messages.size(); i++) {
                        bigText.bigText(messages.get(i));
                    }
                    bigText.setBigContentTitle("รับปัญหา การ์ดสัญญา เข้าระบบ");
                    bigText.setSummaryText("By Website"+":"+"Admin");

                    playNotificationSound();


                    Intent showFullQuoteIntent = new Intent(this, MusicActivity_Payment.class);




                    int uniqueInt = (int) (System.currentTimeMillis() & 0xfffffff);
                    PendingIntent pendingIntent = PendingIntent.getActivity(this, uniqueInt, showFullQuoteIntent, PendingIntent.FLAG_UPDATE_CURRENT);


                    Notification notification = new NotificationCompat.Builder(this)

                            .setTicker("1")
                            .setAutoCancel(true)
                            .setContentTitle("รับปัญหา การ์ดสัญญา เข้าระบบ")
                            .setContentIntent(pendingIntent)
                            //.setSound(alarmSound)
                            .setStyle(inboxStyle)
                            .setWhen(getTimeMilliSec(timestamp))
                            .setSmallIcon(R.drawable.ic_tab_contacts)
                            .setLargeIcon(bitmap)
                            .setNumber(messages.size())
                            .setColor(Color.parseColor("#ee2c7a"))
                            .setSubText("By Website"+":"+"Admin")
                            .setVibrate(new long[] { 500, 500, 500 })
                            .setPriority(NotificationCompat.PRIORITY_MAX)
                            .build();











                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    notificationManager.notify(Integer.parseInt("1"), notification);
                    acquireWakeLock(getApplicationContext());
                    releaseWakeLock();

                }
                catch (Exception ex){

                }



            }



        }
        catch (Exception ex){

        }
    }








    private void sendNotification(String image_cedit,String message,String contno,String timestamp,String ContentTitle,String SubText,String parseColor,int SmallIcon,int id,int id_intent) {
        NotificationManager mNotificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);


        Intent intent = null;

        if(id_intent==1){
            intent = new Intent(this, UI_CARDVIEW_DATA_MANAGER_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT_NO_3_activity.class);




            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            Bitmap bitmap = getBitmapFromURL(image_cedit);
            bitmap = getCircleBitmap(bitmap);
            String oldNotification=message;
            List<String> messages = Arrays.asList(oldNotification.split(","));
            for (int i =0;i< messages.size(); i++) {
                inboxStyle.addLine(i+1+" :"+messages.get(i));
            }
            NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

            // for (int i =0;i< messages.size(); i++) {
            bigText.bigText("เลขที่:"+contno+"\n"+""+"\n"+">"+message);

            // }
            bigText.setBigContentTitle(ContentTitle);
            bigText.setSummaryText(SubText);

            //  String randomQuote = String.valueOf(new Random().nextInt());
            playNotificationSound();


            NotificationChannel mChannel;
            String NOTIFICATION_CHANNEL_ID = "onlinesong_push";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = "Onlinesong Channel";// The user-visible name of the channel.
                int importance = NotificationManager.IMPORTANCE_HIGH;
                mChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance);
                mNotificationManager.createNotificationChannel(mChannel);
            }

            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)



                    .setAutoCancel(true)
                    // .setSound(uri)
                    .setAutoCancel(true)
                    .setLargeIcon(bitmap)
                    .setStyle(bigText)
                    .setChannelId(NOTIFICATION_CHANNEL_ID)
                    .setLights(Color.RED, 800, 800)
                    // .setContentText("ssss")
                    .setContentTitle(ContentTitle)

                    .setStyle(bigText)
                    .setWhen(getTimeMilliSec(timestamp))
                    .setSmallIcon(SmallIcon)

                    .setNumber(messages.size())
                    .setColor(Color.parseColor(parseColor))
                    .setSubText(SubText)
                    .setVibrate(new long[] { 500, 500, 500 })
                    .setPriority(NotificationCompat.PRIORITY_MAX)

                    ;


            //  NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            // notificationManager.notify(Integer.parseInt(randomQuote), notification);
            acquireWakeLock(getApplicationContext());
            releaseWakeLock();


            mBuilder.setTicker("ffff");



            mBuilder.setContentIntent(contentIntent);
            mNotificationManager.notify(id, mBuilder.build());
        }
        else if(id_intent==2){
            intent = new Intent(this, MusicActivity_Payment.class);




            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            Bitmap bitmap = getBitmapFromURL(image_cedit);
            bitmap = getCircleBitmap(bitmap);
            String oldNotification=message;
            List<String> messages = Arrays.asList(oldNotification.split(","));
            for (int i =0;i< messages.size(); i++) {
                inboxStyle.addLine(i+1+" :"+messages.get(i));
            }
            NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

            // for (int i =0;i< messages.size(); i++) {
            bigText.bigText("เลขที่:"+contno+"\n"+""+"\n"+">"+message);

            // }
            bigText.setBigContentTitle(ContentTitle);
            bigText.setSummaryText(SubText);

            //  String randomQuote = String.valueOf(new Random().nextInt());
            playNotificationSound();


            NotificationChannel mChannel;
            String NOTIFICATION_CHANNEL_ID = "onlinesong_push";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = "Onlinesong Channel";// The user-visible name of the channel.
                int importance = NotificationManager.IMPORTANCE_HIGH;
                mChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance);
                mNotificationManager.createNotificationChannel(mChannel);
            }

            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)



                    .setAutoCancel(true)
                    // .setSound(uri)
                    .setAutoCancel(true)
                    .setLargeIcon(bitmap)
                    .setStyle(bigText)
                    .setChannelId(NOTIFICATION_CHANNEL_ID)
                    .setLights(Color.RED, 800, 800)
                    // .setContentText("ssss")
                    .setContentTitle(ContentTitle)

                    .setStyle(bigText)
                    .setWhen(getTimeMilliSec(timestamp))
                    .setSmallIcon(SmallIcon)

                    .setNumber(messages.size())
                    .setColor(Color.parseColor(parseColor))
                    .setSubText(SubText)
                    .setVibrate(new long[] { 500, 500, 500 })
                    .setPriority(NotificationCompat.PRIORITY_MAX)

                    ;


            //  NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            // notificationManager.notify(Integer.parseInt(randomQuote), notification);
            acquireWakeLock(getApplicationContext());
            releaseWakeLock();


            mBuilder.setTicker("ffff");



            mBuilder.setContentIntent(contentIntent);
            mNotificationManager.notify(id, mBuilder.build());

        }
        else if(id_intent==3){
            intent = new Intent(this, MusicActivity_Checker.class);





            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            Bitmap bitmap = getBitmapFromURL(image_cedit);
            bitmap = getCircleBitmap(bitmap);
            String oldNotification=message;
            List<String> messages = Arrays.asList(oldNotification.split(","));
            for (int i =0;i< messages.size(); i++) {
                inboxStyle.addLine(i+1+" :"+messages.get(i));
            }
            NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

            // for (int i =0;i< messages.size(); i++) {
           // bigText.bigText("เลขที่:"+contno+"\n"+""+"\n"+">"+message);

            // }
            bigText.setBigContentTitle(ContentTitle);
            bigText.setSummaryText(SubText);

            //  String randomQuote = String.valueOf(new Random().nextInt());
            playNotificationSound();


            NotificationChannel mChannel;
            String NOTIFICATION_CHANNEL_ID = "onlinesong_push";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = "Onlinesong Channel";// The user-visible name of the channel.
                int importance = NotificationManager.IMPORTANCE_HIGH;
                mChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance);
                mNotificationManager.createNotificationChannel(mChannel);
            }

            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)



                    .setAutoCancel(true)
                    // .setSound(uri)
                    .setAutoCancel(true)
                    .setLargeIcon(bitmap)
                    .setStyle(bigText)
                    .setChannelId(NOTIFICATION_CHANNEL_ID)
                    .setLights(Color.RED, 800, 800)
                    // .setContentText("ssss")
                    .setContentTitle(ContentTitle)

                    .setStyle(bigText)
                    .setWhen(getTimeMilliSec(timestamp))
                    .setSmallIcon(SmallIcon)

                    .setNumber(messages.size())
                    .setColor(Color.parseColor(parseColor))
                    .setSubText(SubText)
                    .setVibrate(new long[] { 500, 500, 500 })
                    .setPriority(NotificationCompat.PRIORITY_MAX)

                    ;


            //  NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            // notificationManager.notify(Integer.parseInt(randomQuote), notification);
            acquireWakeLock(getApplicationContext());
            releaseWakeLock();


            mBuilder.setTicker("ffff");



            mBuilder.setContentIntent(contentIntent);
            mNotificationManager.notify(id, mBuilder.build());

        }

        else if(id_intent==4){
            intent = new Intent(this, MusicActivity_Checker.class);





            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            Bitmap bitmap = getBitmapFromURL(image_cedit);
            bitmap = getCircleBitmap(bitmap);
            String oldNotification=message;
            List<String> messages = Arrays.asList(oldNotification.split(","));
            for (int i =0;i< messages.size(); i++) {
                inboxStyle.addLine(i+1+" :"+messages.get(i));
            }
            NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

            // for (int i =0;i< messages.size(); i++) {
            // bigText.bigText("เลขที่:"+contno+"\n"+""+"\n"+">"+message);

            // }
            bigText.setBigContentTitle(ContentTitle);
            bigText.setSummaryText(SubText);

            //  String randomQuote = String.valueOf(new Random().nextInt());
            playNotificationSound();


            NotificationChannel mChannel;
            String NOTIFICATION_CHANNEL_ID = "onlinesong_push";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = "Onlinesong Channel";// The user-visible name of the channel.
                int importance = NotificationManager.IMPORTANCE_HIGH;
                mChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance);
                mNotificationManager.createNotificationChannel(mChannel);
            }

            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)



                    .setAutoCancel(true)
                    // .setSound(uri)
                    .setAutoCancel(true)
                    .setLargeIcon(bitmap)
                    .setStyle(bigText)
                    .setChannelId(NOTIFICATION_CHANNEL_ID)
                    .setLights(Color.RED, 800, 800)
                    // .setContentText("ssss")
                    .setContentTitle(ContentTitle)

                    .setStyle(bigText)
                    .setWhen(getTimeMilliSec(timestamp))
                    .setSmallIcon(SmallIcon)

                    .setNumber(messages.size())
                    .setColor(Color.parseColor(parseColor))
                    .setSubText(SubText)
                    .setVibrate(new long[] { 500, 500, 500 })
                    .setPriority(NotificationCompat.PRIORITY_MAX)

                    ;


            //  NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            // notificationManager.notify(Integer.parseInt(randomQuote), notification);
            acquireWakeLock(getApplicationContext());
            releaseWakeLock();


            mBuilder.setTicker("4");



            mBuilder.setContentIntent(contentIntent);
            mNotificationManager.notify(id, mBuilder.build());

        }

        else if(id_intent==5){
            intent = new Intent(this, MusicActivity_Credit.class);




            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            Bitmap bitmap = getBitmapFromURL(image_cedit);
            bitmap = getCircleBitmap(bitmap);
            String oldNotification=message;
            List<String> messages = Arrays.asList(oldNotification.split(","));
            for (int i =0;i< messages.size(); i++) {
                inboxStyle.addLine(i+1+" :"+messages.get(i));
            }
            NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

            // for (int i =0;i< messages.size(); i++) {

            // }

            bigText.bigText("เลขที่:" + contno + "\n" + "" + "\n" + ">" + message);

            bigText.setBigContentTitle(ContentTitle);
            bigText.setSummaryText(SubText);

            //  String randomQuote = String.valueOf(new Random().nextInt());
            playNotificationSound();


            NotificationChannel mChannel;
            String NOTIFICATION_CHANNEL_ID = "onlinesong_push";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = "Onlinesong Channel";// The user-visible name of the channel.
                int importance = NotificationManager.IMPORTANCE_HIGH;
                mChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance);
                mNotificationManager.createNotificationChannel(mChannel);
            }

            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)



                    .setAutoCancel(true)
                    // .setSound(uri)
                    .setAutoCancel(true)
                    .setLargeIcon(bitmap)
                    .setStyle(bigText)
                    .setChannelId(NOTIFICATION_CHANNEL_ID)
                    .setLights(Color.RED, 800, 800)
                    // .setContentText("ssss")
                    .setContentTitle(ContentTitle)

                    .setStyle(bigText)
                    .setWhen(getTimeMilliSec(timestamp))
                    .setSmallIcon(SmallIcon)

                    .setNumber(messages.size())
                    .setColor(Color.parseColor(parseColor))
                    .setSubText(SubText)
                    .setVibrate(new long[] { 500, 500, 500 })
                    .setPriority(NotificationCompat.PRIORITY_MAX)

                    ;


            //  NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            // notificationManager.notify(Integer.parseInt(randomQuote), notification);
            acquireWakeLock(getApplicationContext());
            releaseWakeLock();


            mBuilder.setTicker(id+"");



            mBuilder.setContentIntent(contentIntent);
            mNotificationManager.notify(id, mBuilder.build());

        }

        else if(id_intent==6){
            intent = new Intent(this, MusicActivity_Credit.class);




            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            Bitmap bitmap = getBitmapFromURL(image_cedit);
            bitmap = getCircleBitmap(bitmap);
            String oldNotification=message;
            List<String> messages = Arrays.asList(oldNotification.split(","));
            for (int i =0;i< messages.size(); i++) {
                inboxStyle.addLine(i+1+" :"+messages.get(i));
            }
            NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

            // for (int i =0;i< messages.size(); i++) {

            // }

            bigText.bigText("เลขที่:" + contno + "\n" + "" + "\n" + ">" + message);



            bigText.setBigContentTitle(ContentTitle);
            bigText.setSummaryText(SubText);

            //  String randomQuote = String.valueOf(new Random().nextInt());
            playNotificationSound();


            NotificationChannel mChannel;
            String NOTIFICATION_CHANNEL_ID = "onlinesong_push";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = "Onlinesong Channel";// The user-visible name of the channel.
                int importance = NotificationManager.IMPORTANCE_HIGH;
                mChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance);
                mNotificationManager.createNotificationChannel(mChannel);
            }

            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)



                    .setAutoCancel(true)
                    // .setSound(uri)
                    .setAutoCancel(true)
                    .setLargeIcon(bitmap)
                    .setStyle(bigText)
                    .setChannelId(NOTIFICATION_CHANNEL_ID)
                    .setLights(Color.RED, 800, 800)
                    // .setContentText("ssss")
                    .setContentTitle(ContentTitle)

                    .setStyle(bigText)
                    .setWhen(getTimeMilliSec(timestamp))
                    .setSmallIcon(SmallIcon)

                    .setNumber(messages.size())
                    .setColor(Color.parseColor(parseColor))
                    .setSubText(SubText)
                    .setVibrate(new long[] { 500, 500, 500 })
                    .setPriority(NotificationCompat.PRIORITY_MAX)

                    ;


            //  NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            // notificationManager.notify(Integer.parseInt(randomQuote), notification);
            acquireWakeLock(getApplicationContext());
            releaseWakeLock();


            mBuilder.setTicker(id+"");



            mBuilder.setContentIntent(contentIntent);
            mNotificationManager.notify(id, mBuilder.build());

        }

        else if(id_intent==7){
            intent = new Intent(this, MusicActivity_Credit.class);




            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            Bitmap bitmap = getBitmapFromURL(image_cedit);
            bitmap = getCircleBitmap(bitmap);
            String oldNotification=message;
            List<String> messages = Arrays.asList(oldNotification.split(","));
            for (int i =0;i< messages.size(); i++) {
                inboxStyle.addLine(i+1+" :"+messages.get(i));
            }
            NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

            // for (int i =0;i< messages.size(); i++) {

            // }

            bigText.bigText("เลขที่:" + contno + "\n" + "" + "\n" + ">" + message);



            bigText.setBigContentTitle(ContentTitle);
            bigText.setSummaryText(SubText);

            //  String randomQuote = String.valueOf(new Random().nextInt());
            playNotificationSound();


            NotificationChannel mChannel;
            String NOTIFICATION_CHANNEL_ID = "onlinesong_push";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = "Onlinesong Channel";// The user-visible name of the channel.
                int importance = NotificationManager.IMPORTANCE_HIGH;
                mChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance);
                mNotificationManager.createNotificationChannel(mChannel);
            }

            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)



                    .setAutoCancel(true)
                    // .setSound(uri)
                    .setAutoCancel(true)
                    .setLargeIcon(bitmap)
                    .setStyle(bigText)
                    .setChannelId(NOTIFICATION_CHANNEL_ID)
                    .setLights(Color.RED, 800, 800)
                    // .setContentText("ssss")
                    .setContentTitle(ContentTitle)

                    .setStyle(bigText)
                    .setWhen(getTimeMilliSec(timestamp))
                    .setSmallIcon(SmallIcon)

                    .setNumber(messages.size())
                    .setColor(Color.parseColor(parseColor))
                    .setSubText(SubText)
                    .setVibrate(new long[] { 500, 500, 500 })
                    .setPriority(NotificationCompat.PRIORITY_MAX)

                    ;


            //  NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            // notificationManager.notify(Integer.parseInt(randomQuote), notification);
            acquireWakeLock(getApplicationContext());
            releaseWakeLock();


            mBuilder.setTicker(id+"");



            mBuilder.setContentIntent(contentIntent);
            mNotificationManager.notify(id, mBuilder.build());

        }



        else if(id_intent==8){
            intent = new Intent(this, UI_CARDVIEW_DATA_CREDIT_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT2_Acti.class);




            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            Bitmap bitmap = getBitmapFromURL(image_cedit);
            bitmap = getCircleBitmap(bitmap);
            String oldNotification=message;
            List<String> messages = Arrays.asList(oldNotification.split(","));
            for (int i =0;i< messages.size(); i++) {
                inboxStyle.addLine(i+1+" :"+messages.get(i));
            }
            NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

            // for (int i =0;i< messages.size(); i++) {

            // }

            bigText.bigText("เลขที่:" + contno + "\n" + "" + "\n" + ">" + message);



            bigText.setBigContentTitle(ContentTitle);
            bigText.setSummaryText(SubText);

            //  String randomQuote = String.valueOf(new Random().nextInt());
            playNotificationSound();


            NotificationChannel mChannel;
            String NOTIFICATION_CHANNEL_ID = "onlinesong_push";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = "Onlinesong Channel";// The user-visible name of the channel.
                int importance = NotificationManager.IMPORTANCE_HIGH;
                mChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance);
                mNotificationManager.createNotificationChannel(mChannel);
            }

            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)



                    .setAutoCancel(true)
                    // .setSound(uri)
                    .setAutoCancel(true)
                    .setLargeIcon(bitmap)
                    .setStyle(bigText)
                    .setChannelId(NOTIFICATION_CHANNEL_ID)
                    .setLights(Color.RED, 800, 800)
                    // .setContentText("ssss")
                    .setContentTitle(ContentTitle)

                    .setStyle(bigText)
                    .setWhen(getTimeMilliSec(timestamp))
                    .setSmallIcon(SmallIcon)

                    .setNumber(messages.size())
                    .setColor(Color.parseColor(parseColor))
                    .setSubText(SubText)
                    .setVibrate(new long[] { 500, 500, 500 })
                    .setPriority(NotificationCompat.PRIORITY_MAX)

                    ;


            //  NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            // notificationManager.notify(Integer.parseInt(randomQuote), notification);
            acquireWakeLock(getApplicationContext());
            releaseWakeLock();


            mBuilder.setTicker(id+"");



            mBuilder.setContentIntent(contentIntent);
            mNotificationManager.notify(id, mBuilder.build());

        }

        else if(id_intent==9){
            intent = new Intent(this, UI_CARDVIEW_DATA_CREDIT_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT2_Acti.class);




            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            Bitmap bitmap = getBitmapFromURL(image_cedit);
            bitmap = getCircleBitmap(bitmap);
            String oldNotification=message;
            List<String> messages = Arrays.asList(oldNotification.split(","));
            for (int i =0;i< messages.size(); i++) {
                inboxStyle.addLine(i+1+" :"+messages.get(i));
            }
            NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

            // for (int i =0;i< messages.size(); i++) {

            // }

            bigText.bigText("เลขที่:" + contno + "\n" + "" + "\n" + ">" + message);



            bigText.setBigContentTitle(ContentTitle);
            bigText.setSummaryText(SubText);

            //  String randomQuote = String.valueOf(new Random().nextInt());
            playNotificationSound();


            NotificationChannel mChannel;
            String NOTIFICATION_CHANNEL_ID = "onlinesong_push";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = "Onlinesong Channel";// The user-visible name of the channel.
                int importance = NotificationManager.IMPORTANCE_HIGH;
                mChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance);
                mNotificationManager.createNotificationChannel(mChannel);
            }

            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)



                    .setAutoCancel(true)
                    // .setSound(uri)
                    .setAutoCancel(true)
                    .setLargeIcon(bitmap)
                    .setStyle(bigText)
                    .setChannelId(NOTIFICATION_CHANNEL_ID)
                    .setLights(Color.RED, 800, 800)
                    // .setContentText("ssss")
                    .setContentTitle(ContentTitle)

                    .setStyle(bigText)
                    .setWhen(getTimeMilliSec(timestamp))
                    .setSmallIcon(SmallIcon)

                    .setNumber(messages.size())
                    .setColor(Color.parseColor(parseColor))
                    .setSubText(SubText)
                    .setVibrate(new long[] { 500, 500, 500 })
                    .setPriority(NotificationCompat.PRIORITY_MAX)

                    ;


            //  NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            // notificationManager.notify(Integer.parseInt(randomQuote), notification);
            acquireWakeLock(getApplicationContext());
            releaseWakeLock();


            mBuilder.setTicker(id+"");



            mBuilder.setContentIntent(contentIntent);
            mNotificationManager.notify(id, mBuilder.build());

        }


        else if(id_intent==10){
            intent = new Intent(this, UI_CARDVIEW_DATA_CREDIT_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT2_Acti.class);




            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            Bitmap bitmap = getBitmapFromURL(image_cedit);
            bitmap = getCircleBitmap(bitmap);
            String oldNotification=message;
            List<String> messages = Arrays.asList(oldNotification.split(","));
            for (int i =0;i< messages.size(); i++) {
                inboxStyle.addLine(i+1+" :"+messages.get(i));
            }
            NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

            // for (int i =0;i< messages.size(); i++) {

            // }

            bigText.bigText("เลขที่:" + contno + "\n" + "" + "\n" + ">" + message);



            bigText.setBigContentTitle(ContentTitle);
            bigText.setSummaryText(SubText);

            //  String randomQuote = String.valueOf(new Random().nextInt());
            playNotificationSound();


            NotificationChannel mChannel;
            String NOTIFICATION_CHANNEL_ID = "onlinesong_push";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = "Onlinesong Channel";// The user-visible name of the channel.
                int importance = NotificationManager.IMPORTANCE_HIGH;
                mChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance);
                mNotificationManager.createNotificationChannel(mChannel);
            }

            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)



                    .setAutoCancel(true)
                    // .setSound(uri)
                    .setAutoCancel(true)
                    .setLargeIcon(bitmap)
                    .setStyle(bigText)
                    .setChannelId(NOTIFICATION_CHANNEL_ID)
                    .setLights(Color.RED, 800, 800)
                    // .setContentText("ssss")
                    .setContentTitle(ContentTitle)

                    .setStyle(bigText)
                    .setWhen(getTimeMilliSec(timestamp))
                    .setSmallIcon(SmallIcon)

                    .setNumber(messages.size())
                    .setColor(Color.parseColor(parseColor))
                    .setSubText(SubText)
                    .setVibrate(new long[] { 500, 500, 500 })
                    .setPriority(NotificationCompat.PRIORITY_MAX)

                    ;


            //  NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            // notificationManager.notify(Integer.parseInt(randomQuote), notification);
            acquireWakeLock(getApplicationContext());
            releaseWakeLock();


            mBuilder.setTicker(id+"");



            mBuilder.setContentIntent(contentIntent);
            mNotificationManager.notify(id, mBuilder.build());

        }
        else if(id_intent==11){
            intent = new Intent(this, UI_CARDVIEW_DATA_CREDIT_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT2_Acti.class);




            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            Bitmap bitmap = getBitmapFromURL(image_cedit);
            bitmap = getCircleBitmap(bitmap);
            String oldNotification=message;
            List<String> messages = Arrays.asList(oldNotification.split(","));
            for (int i =0;i< messages.size(); i++) {
                inboxStyle.addLine(i+1+" :"+messages.get(i));
            }
            NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

            // for (int i =0;i< messages.size(); i++) {

            // }

            bigText.bigText("เลขที่:" + contno + "\n" + "" + "\n" + ">" + message);



            bigText.setBigContentTitle(ContentTitle);
            bigText.setSummaryText(SubText);

            //  String randomQuote = String.valueOf(new Random().nextInt());
            playNotificationSound();


            NotificationChannel mChannel;
            String NOTIFICATION_CHANNEL_ID = "onlinesong_push";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = "Onlinesong Channel";// The user-visible name of the channel.
                int importance = NotificationManager.IMPORTANCE_HIGH;
                mChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance);
                mNotificationManager.createNotificationChannel(mChannel);
            }

            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)



                    .setAutoCancel(true)
                    // .setSound(uri)
                    .setAutoCancel(true)
                    .setLargeIcon(bitmap)
                    .setStyle(bigText)
                    .setChannelId(NOTIFICATION_CHANNEL_ID)
                    .setLights(Color.RED, 800, 800)
                    // .setContentText("ssss")
                    .setContentTitle(ContentTitle)

                    .setStyle(bigText)
                    .setWhen(getTimeMilliSec(timestamp))
                    .setSmallIcon(SmallIcon)

                    .setNumber(messages.size())
                    .setColor(Color.parseColor(parseColor))
                    .setSubText(SubText)
                    .setVibrate(new long[] { 500, 500, 500 })
                    .setPriority(NotificationCompat.PRIORITY_MAX)

                    ;


            //  NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            // notificationManager.notify(Integer.parseInt(randomQuote), notification);
            acquireWakeLock(getApplicationContext());
            releaseWakeLock();


            mBuilder.setTicker(id+"");



            mBuilder.setContentIntent(contentIntent);
            mNotificationManager.notify(id, mBuilder.build());

        }


        else if(id_intent==12){
            intent = new Intent(this, UI_CARDVIEW_DATA_CREDIT_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT2_Acti.class);




            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            Bitmap bitmap = getBitmapFromURL(image_cedit);
            bitmap = getCircleBitmap(bitmap);
            String oldNotification=message;
            List<String> messages = Arrays.asList(oldNotification.split(","));
            for (int i =0;i< messages.size(); i++) {
                inboxStyle.addLine(i+1+" :"+messages.get(i));
            }
            NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

            // for (int i =0;i< messages.size(); i++) {

            // }

            bigText.bigText("เลขที่:" + contno + "\n" + "" + "\n" + ">" + message);



            bigText.setBigContentTitle(ContentTitle);
            bigText.setSummaryText(SubText);

            //  String randomQuote = String.valueOf(new Random().nextInt());
            playNotificationSound();


            NotificationChannel mChannel;
            String NOTIFICATION_CHANNEL_ID = "onlinesong_push";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = "Onlinesong Channel";// The user-visible name of the channel.
                int importance = NotificationManager.IMPORTANCE_HIGH;
                mChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance);
                mNotificationManager.createNotificationChannel(mChannel);
            }

            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)



                    .setAutoCancel(true)
                    // .setSound(uri)
                    .setAutoCancel(true)
                    .setLargeIcon(bitmap)
                    .setStyle(bigText)
                    .setChannelId(NOTIFICATION_CHANNEL_ID)
                    .setLights(Color.RED, 800, 800)
                    // .setContentText("ssss")
                    .setContentTitle(ContentTitle)

                    .setStyle(bigText)
                    .setWhen(getTimeMilliSec(timestamp))
                    .setSmallIcon(SmallIcon)

                    .setNumber(messages.size())
                    .setColor(Color.parseColor(parseColor))
                    .setSubText(SubText)
                    .setVibrate(new long[] { 500, 500, 500 })
                    .setPriority(NotificationCompat.PRIORITY_MAX)

                    ;


            //  NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            // notificationManager.notify(Integer.parseInt(randomQuote), notification);
            acquireWakeLock(getApplicationContext());
            releaseWakeLock();


            mBuilder.setTicker(id+"");



            mBuilder.setContentIntent(contentIntent);
            mNotificationManager.notify(id, mBuilder.build());

        }


        else if(id_intent==13){
            intent = new Intent(this, MusicActivity_Credit.class);




            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            Bitmap bitmap = getBitmapFromURL(image_cedit);
            bitmap = getCircleBitmap(bitmap);
            String oldNotification=message;
            List<String> messages = Arrays.asList(oldNotification.split(","));
            for (int i =0;i< messages.size(); i++) {
                inboxStyle.addLine(i+1+" :"+messages.get(i));
            }
            NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

            // for (int i =0;i< messages.size(); i++) {

            // }

            //bigText.bigText("เลขที่:" + contno + "\n" + "" + "\n" + ">" + message);
           // NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

            for (int i = 0; i < messages.size(); i++) {
                bigText.bigText(messages.get(i));
            }


            bigText.setBigContentTitle(ContentTitle);
            bigText.setSummaryText(SubText);

            //  String randomQuote = String.valueOf(new Random().nextInt());
            playNotificationSound();


            NotificationChannel mChannel;
            String NOTIFICATION_CHANNEL_ID = "onlinesong_push";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = "Onlinesong Channel";// The user-visible name of the channel.
                int importance = NotificationManager.IMPORTANCE_HIGH;
                mChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance);
                mNotificationManager.createNotificationChannel(mChannel);
            }

            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)



                    .setAutoCancel(true)
                    // .setSound(uri)
                    .setAutoCancel(true)
                    .setLargeIcon(bitmap)
                    .setStyle(bigText)
                    .setChannelId(NOTIFICATION_CHANNEL_ID)
                    .setLights(Color.RED, 800, 800)
                    // .setContentText("ssss")
                    .setContentTitle(ContentTitle)

                    .setStyle(bigText)
                    .setWhen(getTimeMilliSec(timestamp))
                    .setSmallIcon(SmallIcon)

                    .setNumber(messages.size())
                    .setColor(Color.parseColor(parseColor))
                    .setSubText(SubText)
                    .setVibrate(new long[] { 500, 500, 500 })
                    .setPriority(NotificationCompat.PRIORITY_MAX)

                    ;


            //  NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            // notificationManager.notify(Integer.parseInt(randomQuote), notification);
            acquireWakeLock(getApplicationContext());
            releaseWakeLock();


            mBuilder.setTicker(id+"");



            mBuilder.setContentIntent(contentIntent);
            mNotificationManager.notify(id, mBuilder.build());

        }

        else if(id_intent==14){
            intent = new Intent(this, MusicActivity_Credit.class);




            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            Bitmap bitmap = getBitmapFromURL(image_cedit);
            bitmap = getCircleBitmap(bitmap);
            String oldNotification=message;
            List<String> messages = Arrays.asList(oldNotification.split(","));
            for (int i =0;i< messages.size(); i++) {
                inboxStyle.addLine(i+1+" :"+messages.get(i));
            }
            NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

            // for (int i =0;i< messages.size(); i++) {

            // }

            //bigText.bigText("เลขที่:" + contno + "\n" + "" + "\n" + ">" + message);
            // NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();


            for (int i = 0; i < messages.size(); i++) {
                bigText.bigText(messages.get(i));
            }


            bigText.setBigContentTitle(ContentTitle);
            bigText.setSummaryText(SubText);

            //  String randomQuote = String.valueOf(new Random().nextInt());
            playNotificationSound();


            NotificationChannel mChannel;
            String NOTIFICATION_CHANNEL_ID = "onlinesong_push";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = "Onlinesong Channel";// The user-visible name of the channel.
                int importance = NotificationManager.IMPORTANCE_HIGH;
                mChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance);
                mNotificationManager.createNotificationChannel(mChannel);
            }

            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)



                    .setAutoCancel(true)
                    // .setSound(uri)
                    .setAutoCancel(true)
                    .setLargeIcon(bitmap)
                    .setStyle(bigText)
                    .setChannelId(NOTIFICATION_CHANNEL_ID)
                    .setLights(Color.RED, 800, 800)
                    // .setContentText("ssss")
                    .setContentTitle(ContentTitle)

                    .setStyle(bigText)
                    .setWhen(getTimeMilliSec(timestamp))
                    .setSmallIcon(SmallIcon)

                    .setNumber(messages.size())
                    .setColor(Color.parseColor(parseColor))
                    .setSubText(SubText)
                    .setVibrate(new long[] { 500, 500, 500 })
                    .setPriority(NotificationCompat.PRIORITY_MAX)

                    ;


            //  NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            // notificationManager.notify(Integer.parseInt(randomQuote), notification);
            acquireWakeLock(getApplicationContext());
            releaseWakeLock();


            mBuilder.setTicker(id+"");



            mBuilder.setContentIntent(contentIntent);
            mNotificationManager.notify(id, mBuilder.build());

        }

        else if(id_intent==15){
            intent = new Intent(this, MusicActivity_Credit.class);




            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            Bitmap bitmap = getBitmapFromURL(image_cedit);
            bitmap = getCircleBitmap(bitmap);
            String oldNotification=message;
            List<String> messages = Arrays.asList(oldNotification.split(","));
            for (int i =0;i< messages.size(); i++) {
                inboxStyle.addLine(i+1+" :"+messages.get(i));
            }
            NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

            // for (int i =0;i< messages.size(); i++) {

            // }

            //bigText.bigText("เลขที่:" + contno + "\n" + "" + "\n" + ">" + message);
            // NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();


            for (int i = 0; i < messages.size(); i++) {
                bigText.bigText(messages.get(i));
            }


            bigText.setBigContentTitle(ContentTitle);
            bigText.setSummaryText(SubText);

            //  String randomQuote = String.valueOf(new Random().nextInt());
            playNotificationSound();


            NotificationChannel mChannel;
            String NOTIFICATION_CHANNEL_ID = "onlinesong_push";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = "Onlinesong Channel";// The user-visible name of the channel.
                int importance = NotificationManager.IMPORTANCE_HIGH;
                mChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance);
                mNotificationManager.createNotificationChannel(mChannel);
            }

            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)



                    .setAutoCancel(true)
                    // .setSound(uri)
                    .setAutoCancel(true)
                    .setLargeIcon(bitmap)
                    .setStyle(bigText)
                    .setChannelId(NOTIFICATION_CHANNEL_ID)
                    .setLights(Color.RED, 800, 800)
                    // .setContentText("ssss")
                    .setContentTitle(ContentTitle)

                    .setStyle(bigText)
                    .setWhen(getTimeMilliSec(timestamp))
                    .setSmallIcon(SmallIcon)

                    .setNumber(messages.size())
                    .setColor(Color.parseColor(parseColor))
                    .setSubText(SubText)
                    .setVibrate(new long[] { 500, 500, 500 })
                    .setPriority(NotificationCompat.PRIORITY_MAX)

                    ;


            //  NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            // notificationManager.notify(Integer.parseInt(randomQuote), notification);
            acquireWakeLock(getApplicationContext());
            releaseWakeLock();


            mBuilder.setTicker(id+"");



            mBuilder.setContentIntent(contentIntent);
            mNotificationManager.notify(id, mBuilder.build());

        }


        else if(id_intent==16){
            intent = new Intent(this, MusicActivity_Credit.class);




            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            Bitmap bitmap = getBitmapFromURL(image_cedit);
            bitmap = getCircleBitmap(bitmap);
            String oldNotification=message;
            List<String> messages = Arrays.asList(oldNotification.split(","));
            for (int i =0;i< messages.size(); i++) {
                inboxStyle.addLine(i+1+" :"+messages.get(i));
            }
            NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

            // for (int i =0;i< messages.size(); i++) {

            // }

            //bigText.bigText("เลขที่:" + contno + "\n" + "" + "\n" + ">" + message);
            // NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

            bigText.bigText("เลขที่:" + contno + "\n" + "" + "\n" + ">" + message);



            bigText.setBigContentTitle(ContentTitle);
            bigText.setSummaryText(SubText);

            //  String randomQuote = String.valueOf(new Random().nextInt());
            playNotificationSound();


            NotificationChannel mChannel;
            String NOTIFICATION_CHANNEL_ID = "onlinesong_push";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = "Onlinesong Channel";// The user-visible name of the channel.
                int importance = NotificationManager.IMPORTANCE_HIGH;
                mChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance);
                mNotificationManager.createNotificationChannel(mChannel);
            }

            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)



                    .setAutoCancel(true)
                    // .setSound(uri)
                    .setAutoCancel(true)
                    .setLargeIcon(bitmap)
                    .setStyle(bigText)
                    .setChannelId(NOTIFICATION_CHANNEL_ID)
                    .setLights(Color.RED, 800, 800)
                    // .setContentText("ssss")
                    .setContentTitle(ContentTitle)

                    .setStyle(bigText)
                    .setWhen(getTimeMilliSec(timestamp))
                    .setSmallIcon(SmallIcon)

                    .setNumber(messages.size())
                    .setColor(Color.parseColor(parseColor))
                    .setSubText(SubText)
                    .setVibrate(new long[] { 500, 500, 500 })
                    .setPriority(NotificationCompat.PRIORITY_MAX)

                    ;


            //  NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            // notificationManager.notify(Integer.parseInt(randomQuote), notification);
            acquireWakeLock(getApplicationContext());
            releaseWakeLock();


            mBuilder.setTicker(id+"");



            mBuilder.setContentIntent(contentIntent);
            mNotificationManager.notify(id, mBuilder.build());

        }
    }
















    private void handleDataMessage2(JSONObject json) {
       // Log.e(TAG, "push json: " + json.toString());

        try {
            JSONObject data2 = json.getJSONObject("data2");

            String title = data2.getString("title2");
            String message = data2.getString("message2");
            String timestamp = data2.getString("timestamp2");


/*
            Intent pushNotification = new Intent(Config2.PUSH_NOTIFICATION);
            pushNotification.putExtra("contno", title);
            pushNotification.putExtra("count", message);
            pushNotification.putExtra("timestamp", timestamp);

            LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);
*/



            resultIntent = new Intent(getApplicationContext(), MusicActivity_Credit.class);
            //  resultIntent = new Intent(getApplicationContext(), IconTextTabsActivity11.class);
            Bundle bun = new Bundle();

            bun.putString("contno", title);
            bun.putString("count", message);
            resultIntent.putExtras(bun);

            //startService(new Intent(MyFirebaseMessagingService2.this, FloatWidgetService.class));
            //showNotificationMessage_web_to_cedit(getApplicationContext(), title, message, timestamp, resultIntent);

        }
        catch (Exception ex){

        }
    }




    private void handleDataMessage_sale_from_cedit(JSONObject json) {
        //Log.e(TAG, "push json: " + json.toString());

        try {
            JSONObject data2 = json.getJSONObject("data2");

            String title = data2.getString("title_sale_from_cedit");
            String message = data2.getString("message_sale_from_cedit");
            String timestamp = data2.getString("timestamp_sale_from_cedit");
            String image_cedit = data2.getString("image_cedit_sale_from_cedit");


            Log.e("message",message);

            // ShortcutBadger.applyCount(mContext, 0);

            Intent pushNotification = new Intent(Config2.PUSH_NOTIFICATION);
            pushNotification.putExtra("contno", title);
            pushNotification.putExtra("problem", message);
            pushNotification.putExtra("timestamp", timestamp);
            pushNotification.putExtra("image_cedit", image_cedit);
            LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);




            resultIntent = new Intent(getApplicationContext(), MusicActivity_Credit.class);
            Bundle bun = new Bundle();
            bun.putString("contno", title);
            bun.putString("problem", message);
            bun.putString("timestamp", timestamp);
            bun.putString("image_cedit", image_cedit);
            resultIntent.putExtras(bun);

            //startService(new Intent(MyFirebaseMessagingService2.this, FloatWidgetService.class));
           showNotificationMessage_sale_from_cedit(getApplicationContext(), title, message,image_cedit, timestamp, resultIntent);
            //showNotificationMessage(getApplicationContext(), title, message, timestamp, resultIntent);



        }
        catch (Exception ex){

        }



    }




    private void handleDataMessage_logout_all(JSONObject json) {

            //Log.e(TAG, "push json: " + json.toString());

            try {
                JSONObject data2 = json.getJSONObject("data_logout_all");

                String title = data2.getString("title_logout_all");
                String message = data2.getString("message_logout_all");
                String timestamp = data2.getString("timestamp_logout_all");
                String image_cedit = data2.getString("image_logout_all");




                // ShortcutBadger.applyCount(mContext, 0);

                Intent pushNotification = new Intent(Config2.PUSH_NOTIFICATION);
                pushNotification.putExtra("non_logout", "logout");
                pushNotification.putExtra("problem", message);
                pushNotification.putExtra("timestamp", timestamp);
                pushNotification.putExtra("image_cedit", image_cedit);
                LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);





                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                Bitmap bitmap = getBitmapFromURL(image_cedit);
                bitmap = getCircleBitmap(bitmap);
                String oldNotification=message;
                List<String> messages = Arrays.asList(oldNotification.split(","));
                for (int i =0;i< messages.size(); i++) {
                    inboxStyle.addLine(i+1+" :"+messages.get(i));
                }
                NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

                // for (int i =0;i< messages.size(); i++) {
                bigText.bigText("ทุก USER ออกจากระบบอัตโนมัติ");

                // }
                bigText.setBigContentTitle("LOGOUT ทุก USER");
                bigText.setSummaryText("By Website"+":"+"Admin");

                playNotificationSound();
                String randomQuote = String.valueOf(new Random().nextInt());
                Log.i(TAG, "QUOTE: " + randomQuote);







                Notification notification = new NotificationCompat.Builder(this)

                        .setTicker(randomQuote)
                        .setAutoCancel(true)
                        .setContentTitle("LOGOUT ทุก USER")
                       // .setContentIntent(pendingIntent)
                        //.setSound(alarmSound)
                        .setStyle(bigText)
                        .setWhen(getTimeMilliSec(timestamp))
                        .setSmallIcon(R.drawable.ic_tab_contacts)
                        .setLargeIcon(bitmap)
                        .setNumber(messages.size())
                        .setColor(Color.parseColor("#32CD32"))
                        .setSubText("By Website"+":"+"Admin")
                        .setVibrate(new long[] { 500, 500, 500 })
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .build();



                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(Integer.parseInt(randomQuote), notification);
                acquireWakeLock(getApplicationContext());
                releaseWakeLock();

            }
            catch (Exception ex){

            }
        }




    private void handleDataMessage_checker(JSONObject json) {

        //Log.e(TAG, "push json: " + json.toString());

        try {
            JSONObject data2 = json.getJSONObject("cedit_to_cedit_checker");

            String title = data2.getString("title_cedit_to_cedit_checker");
            String message = data2.getString("message_cedit_to_cedit_checker");
            String timestamp = data2.getString("timestamp_cedit_to_cedit_checker");
            String image_cedit = data2.getString("image_cedit_to_cedit_checker");




            if (android.os.Build.VERSION.SDK_INT>=8.1) {
                sendNotification(image_cedit,message,title,timestamp,"รายการตรวจสอบ "+ message+" รายการ","By Website"+":"+"Admin","#32CD32",R.drawable.ic_tab_contacts,22,3);

            }
            else {
                Intent pushNotification = new Intent(Config2.PUSH_NOTIFICATION);
                pushNotification.putExtra("title_cedit_to_cedit_checker", title);
                pushNotification.putExtra("message_cedit_to_cedit_checker", message);
                pushNotification.putExtra("timestamp_cedit_to_cedit_checker", timestamp);
                pushNotification.putExtra("image_cedit_to_cedit_checker", image_cedit);
                LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);





                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                Bitmap bitmap = getBitmapFromURL(image_cedit);
                bitmap = getCircleBitmap(bitmap);
                String oldNotification=message;
                List<String> messages = Arrays.asList(oldNotification.split(","));
                for (int i =0;i< messages.size(); i++) {
                    inboxStyle.addLine(i+1+" :"+messages.get(i));
                }
                NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

                // for (int i =0;i< messages.size(); i++) {
                bigText.bigText("รายการตรวจสอบ "+ message+" รายการ");

                // }
                bigText.setBigContentTitle("รายการตรวจสอบ "+ message+" รายการ");
                bigText.setSummaryText("By Website"+":"+"Admin");

                playNotificationSound();
                String randomQuote = String.valueOf(new Random().nextInt());
                Log.i(TAG, "QUOTE: " + randomQuote);



                Intent showFullQuoteIntent = new Intent(this, MusicActivity_Checker.class);
                showFullQuoteIntent.putExtra(INTENT_KEY, randomQuote);
                showFullQuoteIntent.putExtra("title_web_to_cedit_checker", title);
                showFullQuoteIntent.putExtra("message_web_to_cedit_checker", message);
                showFullQuoteIntent.putExtra("image_web_to_cedit_checker", image_cedit);
                showFullQuoteIntent.putExtra("timestamp_web_to_cedit_checker", timestamp);





                int uniqueInt = (int) (System.currentTimeMillis() & 0xfffffff);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, uniqueInt, showFullQuoteIntent, PendingIntent.FLAG_UPDATE_CURRENT);



                Notification notification = new NotificationCompat.Builder(this)

                        .setTicker(randomQuote)
                        .setAutoCancel(true)
                        .setContentTitle("รายการตรวจสอบ "+ message+" รายการ")
                        .setContentIntent(pendingIntent)
                        //.setSound(alarmSound)
                        .setStyle(bigText)
                        .setWhen(getTimeMilliSec(timestamp))
                        .setSmallIcon(R.drawable.ic_tab_contacts)
                        .setLargeIcon(bitmap)
                        .setNumber(messages.size())
                        .setColor(Color.parseColor("#32CD32"))
                        .setSubText("By Website"+":"+"Admin")
                        .setVibrate(new long[] { 500, 500, 500 })
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .build();



                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(Integer.parseInt("22"), notification);
                acquireWakeLock(getApplicationContext());
                releaseWakeLock();

            }










        }
        catch (Exception ex){

        }
    }



    private void handleDataMessage_checker2(JSONObject json) {

        //Log.e(TAG, "push json: " + json.toString());

        try {
            JSONObject data2 = json.getJSONObject("cedit_to_cedit_checker_change");

            String title = data2.getString("title_cedit_to_cedit_checker_change");
            String message = data2.getString("message_cedit_to_cedit_checker_change");
            String timestamp = data2.getString("timestamp_cedit_to_cedit_checker_change");
            String image_cedit = data2.getString("image_cedit_to_cedit_checker_change");
            String CheckerType = data2.getString("CheckerType_to_cedit_checker_change");


            if (android.os.Build.VERSION.SDK_INT>=8.1) {
                sendNotification(image_cedit,message,title,timestamp,"รายการตรวจสอบ " + message + " รายการ","By Website"+":"+"Admin","#32CD32",R.drawable.ic_tab_contacts,33,4);

            }
            else {


                dad = 0;
                MyApplication.getInstance().getPrefManager().setPreferrence("dat2", "1");
                MyApplication.getInstance().getPrefManager().setPreferrence("key_sort", null);
                MyApplication.getInstance().getPrefManager().setPreferrence("intro_save", "0");


                Intent pushNotification = new Intent(this, MusicActivity_Checker.class);
                pushNotification.putExtra("sddf", "dsds");
                pushNotification.putExtra("probsdsdslem", message);
                pushNotification.putExtra("sds", timestamp);
                pushNotification.putExtra("sds", image_cedit);
                LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);


                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                Bitmap bitmap = getBitmapFromURL(image_cedit);
                bitmap = getCircleBitmap(bitmap);
                String oldNotification = message;
                List<String> messages = Arrays.asList(oldNotification.split(","));
                for (int i = 0; i < messages.size(); i++) {
                    inboxStyle.addLine(i + 1 + " :" + messages.get(i));
                }
                NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

                // for (int i =0;i< messages.size(); i++) {
                bigText.bigText("รายการตรวจสอบ " + message + " รายการ");

                // }
                bigText.setBigContentTitle("รายการตรวจสอบ " + message + " รายการ");
                bigText.setSummaryText("By Website" + ":" + "Admin");

                playNotificationSound();
                String randomQuote = String.valueOf(new Random().nextInt());
                Log.i(TAG, "QUOTE: " + randomQuote);


                int uniqueInt = (int) (System.currentTimeMillis() & 0xfffffff);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, uniqueInt, pushNotification, PendingIntent.FLAG_UPDATE_CURRENT);


                Notification notification = new NotificationCompat.Builder(this)

                        .setTicker(randomQuote)
                        .setAutoCancel(true)
                        .setContentTitle("รายการตรวจสอบ " + message + " รายการ")
                        .setContentIntent(pendingIntent)
                        //.setSound(alarmSound)
                        .setStyle(bigText)
                        .setWhen(getTimeMilliSec(timestamp))
                        .setSmallIcon(R.drawable.ic_tab_contacts)
                        .setLargeIcon(bitmap)
                        .setNumber(messages.size())
                        .setColor(Color.parseColor("#32CD32"))
                        .setSubText("By Website" + ":" + "Admin")
                        .setVibrate(new long[]{500, 500, 500})
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .build();


                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(Integer.parseInt("33"), notification);
                acquireWakeLock(getApplicationContext());
                releaseWakeLock();

            }

        }
        catch (Exception ex){

        }
    }

    private void handleDataMessage_sale_and_credit_from_web_closing(JSONObject json) {
        //Log.e(TAG, "push json: " + json.toString());

        try {
            JSONObject data2 = json.getJSONObject("data2");

            String title = data2.getString("title_sale_and_credit_from_web_closing");
            String message = data2.getString("message_sale_and_credit_from_web_closing");
            String timestamp = data2.getString("timestamp_sale_and_credit_from_web_closing");
            String image_cedit = data2.getString("image_sale_and_credit_from_web_closing");


            String randomQuote = String.valueOf(new Random().nextInt());



            if (android.os.Build.VERSION.SDK_INT>=8.1) {
                sendNotification(image_cedit,message,title,timestamp,"ปิดงานแล้ว "+ message+" รายการ","By Website"+":"+"Admin","#32CD32",R.drawable.ic_tab_contacts, Integer.parseInt(randomQuote),5);

            }
            else {
                // ShortcutBadger.applyCount(mContext, 0);

                Intent pushNotification = new Intent(Config2.PUSH_NOTIFICATION);
                pushNotification.putExtra("contno", title);
                pushNotification.putExtra("problem", message);
                pushNotification.putExtra("timestamp", timestamp);
                pushNotification.putExtra("image_cedit", image_cedit);
                LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);


                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                Bitmap bitmap = getBitmapFromURL(image_cedit);
                bitmap = getCircleBitmap(bitmap);
                String oldNotification = message;
                List<String> messages = Arrays.asList(oldNotification.split(","));
                for (int i = 0; i < messages.size(); i++) {
                    inboxStyle.addLine(i + 1 + " :" + messages.get(i));
                }
                NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

                // for (int i =0;i< messages.size(); i++) {
                bigText.bigText("เลขที่:" + title + "\n" + "" + "\n" + ">" + message);

                // }
                bigText.setBigContentTitle("ปิดงานแล้ว");
                bigText.setSummaryText("By Website" + ":" + "Admin");

                playNotificationSound();
               // String randomQuote = String.valueOf(new Random().nextInt());
                Log.i(TAG, "QUOTE: " + randomQuote);
                Intent showFullQuoteIntent = new Intent(this, MusicActivity_Credit.class);
                showFullQuoteIntent.putExtra(INTENT_KEY, randomQuote);
                showFullQuoteIntent.putExtra("title", title);
                showFullQuoteIntent.putExtra("message", message);
                showFullQuoteIntent.putExtra("image_cedit", image_cedit);
                showFullQuoteIntent.putExtra("timestamp", timestamp);


                int uniqueInt = (int) (System.currentTimeMillis() & 0xfffffff);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, uniqueInt, showFullQuoteIntent, PendingIntent.FLAG_UPDATE_CURRENT);


                Notification notification = new NotificationCompat.Builder(this)

                        .setTicker(randomQuote)
                        .setAutoCancel(true)
                        .setContentTitle("ปิดงานแล้ว")
                        .setContentIntent(pendingIntent)
                        //.setSound(alarmSound)
                        .setStyle(bigText)
                        .setWhen(getTimeMilliSec(timestamp))
                        .setSmallIcon(R.drawable.ic_tab_contacts)
                        .setLargeIcon(bitmap)
                        .setNumber(messages.size())
                        .setColor(Color.parseColor("#32CD32"))
                        .setSubText("By Website" + ":" + "Admin")
                        .setVibrate(new long[]{500, 500, 500})
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .build();


                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(Integer.parseInt(randomQuote), notification);
                acquireWakeLock(getApplicationContext());
                releaseWakeLock();
            }

        }
        catch (Exception ex){

        }
    }









    private void handleDataMessage_sale_and_credit_from_web_closing_extra(JSONObject json) {
        //Log.e(TAG, "push json: " + json.toString());

        try {
            JSONObject data2 = json.getJSONObject("closing_extra");

            String title = data2.getString("title_sale_and_credit_from_web_closing_extra");
            String message = data2.getString("message_sale_and_credit_from_web_closing_extra");
            String timestamp = data2.getString("timestamp_sale_and_credit_from_web_closing_extra");
            String image_cedit = data2.getString("image_sale_and_credit_from_web_closing_extra");

            String randomQuote = String.valueOf(new Random().nextInt());
            if (android.os.Build.VERSION.SDK_INT>=8.1) {
                sendNotification(image_cedit,message,title,timestamp,"อยู่ระหว่างการปิดงาน(แบบพิเศษ)","By Website"+":"+"Admin","#800080",R.drawable.ic_tab_contacts, Integer.parseInt(randomQuote),6);

            }
            else {

                // ShortcutBadger.applyCount(mContext, 0);

                Intent pushNotification = new Intent(Config2.PUSH_NOTIFICATION);
                pushNotification.putExtra("contno", title);
                pushNotification.putExtra("problem", message);
                pushNotification.putExtra("timestamp", timestamp);
                pushNotification.putExtra("image_cedit", image_cedit);
                LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);


                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                Bitmap bitmap = getBitmapFromURL(image_cedit);
                bitmap = getCircleBitmap(bitmap);
                String oldNotification = message;
                List<String> messages = Arrays.asList(oldNotification.split(","));
                for (int i = 0; i < messages.size(); i++) {
                    inboxStyle.addLine(i + 1 + " :" + messages.get(i));
                }
                NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

                // for (int i =0;i< messages.size(); i++) {
                bigText.bigText("เลขที่:" + title + "\n" + "" + "\n" + ">" + message);

                // }
                bigText.setBigContentTitle("อยู่ระหว่างการปิดงาน(แบบพิเศษ)");
                bigText.setSummaryText("By Website" + ":" + "Admin");

                playNotificationSound();

                Log.i(TAG, "QUOTE: " + randomQuote);
                Intent showFullQuoteIntent = new Intent(this, MusicActivity_Credit.class);
                showFullQuoteIntent.putExtra(INTENT_KEY, randomQuote);
                showFullQuoteIntent.putExtra("title", title);
                showFullQuoteIntent.putExtra("message", message);
                showFullQuoteIntent.putExtra("image_cedit", image_cedit);
                showFullQuoteIntent.putExtra("timestamp", timestamp);


                int uniqueInt = (int) (System.currentTimeMillis() & 0xfffffff);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, uniqueInt, showFullQuoteIntent, PendingIntent.FLAG_UPDATE_CURRENT);


                Notification notification = new NotificationCompat.Builder(this)

                        .setTicker(randomQuote)
                        .setAutoCancel(true)
                        .setContentTitle("อยู่ระหว่างการปิดงาน(แบบพิเศษ)")
                        .setContentIntent(pendingIntent)
                        //.setSound(alarmSound)
                        .setStyle(bigText)
                        .setWhen(getTimeMilliSec(timestamp))
                        .setSmallIcon(R.drawable.ic_tab_contacts)
                        .setLargeIcon(bitmap)
                        .setNumber(messages.size())
                        .setColor(Color.parseColor("#800080"))
                        .setSubText("By Website" + ":" + "Admin")
                        .setVibrate(new long[]{500, 500, 500})
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .build();


                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(Integer.parseInt(randomQuote), notification);
                acquireWakeLock(getApplicationContext());
                releaseWakeLock();
            }
        }
        catch (Exception ex){

        }
    }



    private void handleDataMessage_sale_and_credit_from_web_closing_extra_success(JSONObject json) {
        //Log.e(TAG, "push json: " + json.toString());

        try {
            JSONObject data2 = json.getJSONObject("closing_extra_success");

            String title = data2.getString("title_sale_and_credit_from_web_closing_extra_success");
            String message = data2.getString("message_sale_and_credit_from_web_closing_extra_success");
            String timestamp = data2.getString("timestamp_sale_and_credit_from_web_closing_extra_success");
            String image_cedit = data2.getString("image_sale_and_credit_from_web_closing_extra_success");


            String randomQuote = String.valueOf(new Random().nextInt());


            if (android.os.Build.VERSION.SDK_INT>=8.1) {
                sendNotification(image_cedit,message,title,timestamp,"ปิดงาน(แบบพิเศษ)","By Website"+":"+"Admin","#2E8B57",R.drawable.ic_tab_contacts, Integer.parseInt(randomQuote),7);

            }
            else {
                // ShortcutBadger.applyCount(mContext, 0);

                Intent pushNotification = new Intent(Config2.PUSH_NOTIFICATION);
                pushNotification.putExtra("contno", title);
                pushNotification.putExtra("problem", message);
                pushNotification.putExtra("timestamp", timestamp);
                pushNotification.putExtra("image_cedit", image_cedit);
                LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);


                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                Bitmap bitmap = getBitmapFromURL(image_cedit);
                bitmap = getCircleBitmap(bitmap);
                String oldNotification = message;
                List<String> messages = Arrays.asList(oldNotification.split(","));
                for (int i = 0; i < messages.size(); i++) {
                    inboxStyle.addLine(i + 1 + " :" + messages.get(i));
                }
                NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

                // for (int i =0;i< messages.size(); i++) {
                bigText.bigText("เลขที่:" + title + "\n" + "" + "\n" + ">" + message);

                // }
                bigText.setBigContentTitle("ปิดงาน(แบบพิเศษ)");
                bigText.setSummaryText("By Website" + ":" + "Admin");

                playNotificationSound();

                Log.i(TAG, "QUOTE: " + randomQuote);
                Intent showFullQuoteIntent = new Intent(this, MusicActivity_Credit.class);
                showFullQuoteIntent.putExtra(INTENT_KEY, randomQuote);
                showFullQuoteIntent.putExtra("title", title);
                showFullQuoteIntent.putExtra("message", message);
                showFullQuoteIntent.putExtra("image_cedit", image_cedit);
                showFullQuoteIntent.putExtra("timestamp", timestamp);


                int uniqueInt = (int) (System.currentTimeMillis() & 0xfffffff);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, uniqueInt, showFullQuoteIntent, PendingIntent.FLAG_UPDATE_CURRENT);


                Notification notification = new NotificationCompat.Builder(this)

                        .setTicker(randomQuote)
                        .setAutoCancel(true)
                        .setContentTitle("ปิดงาน(แบบพิเศษ)")
                        .setContentIntent(pendingIntent)
                        //.setSound(alarmSound)
                        .setStyle(bigText)
                        .setWhen(getTimeMilliSec(timestamp))
                        .setSmallIcon(R.drawable.ic_tab_contacts)
                        .setLargeIcon(bitmap)
                        .setNumber(messages.size())
                        .setColor(Color.parseColor("#2E8B57"))
                        .setSubText("By Website" + ":" + "Admin")
                        .setVibrate(new long[]{500, 500, 500})
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .build();


                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(Integer.parseInt(randomQuote), notification);
                acquireWakeLock(getApplicationContext());
                releaseWakeLock();
            }
        }
        catch (Exception ex){

        }
    }




    private void handleDataMessage_sale_and_credit_from_web_closing_credit(JSONObject json) {
        //Log.e(TAG, "push json: " + json.toString());

        try {
            JSONObject data2 = json.getJSONObject("closing_credit");

            String title = data2.getString("title_sale_and_credit_from_web_closing_credit");
            String message = data2.getString("message_sale_and_credit_from_web_closing_credit");
            String timestamp = data2.getString("timestamp_sale_and_credit_from_web_closing_credit");
            String image_cedit = data2.getString("image_sale_and_credit_from_web_closing_credit");

            String randomQuote = String.valueOf(new Random().nextInt());
            if (android.os.Build.VERSION.SDK_INT>=8.1) {
                sendNotification(image_cedit,message,title,timestamp,"ปิดงานแล้ว","By Website"+":"+"Admin","#32CD32",R.drawable.ic_tab_contacts, Integer.parseInt(randomQuote),8);

            }
            else {

                // ShortcutBadger.applyCount(mContext, 0);

                Intent pushNotification = new Intent(Config2.PUSH_NOTIFICATION);
                pushNotification.putExtra("contno", title);
                pushNotification.putExtra("problem", message);
                pushNotification.putExtra("timestamp", timestamp);
                pushNotification.putExtra("image_cedit", image_cedit);
                LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);


                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                Bitmap bitmap = getBitmapFromURL(image_cedit);
                bitmap = getCircleBitmap(bitmap);
                String oldNotification = message;
                List<String> messages = Arrays.asList(oldNotification.split(","));
                for (int i = 0; i < messages.size(); i++) {
                    inboxStyle.addLine(i + 1 + " :" + messages.get(i));
                }
                NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

                // for (int i =0;i< messages.size(); i++) {
                bigText.bigText("เลขที่:" + title + "\n" + "" + "\n" + ">" + message);

                // }
                bigText.setBigContentTitle("ปิดงานแล้ว");
                bigText.setSummaryText("By Website" + ":" + "Admin");

                playNotificationSound();

                Log.i(TAG, "QUOTE: " + randomQuote);
                Intent showFullQuoteIntent = new Intent(this, UI_CARDVIEW_DATA_CREDIT_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT2_Acti.class);
                showFullQuoteIntent.putExtra(INTENT_KEY, randomQuote);
                showFullQuoteIntent.putExtra("title", title);
                showFullQuoteIntent.putExtra("message", message);
                showFullQuoteIntent.putExtra("image_cedit", image_cedit);
                showFullQuoteIntent.putExtra("timestamp", timestamp);


                int uniqueInt = (int) (System.currentTimeMillis() & 0xfffffff);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, uniqueInt, showFullQuoteIntent, PendingIntent.FLAG_UPDATE_CURRENT);


                Notification notification = new NotificationCompat.Builder(this)

                        .setTicker(randomQuote)
                        .setAutoCancel(true)
                        .setContentTitle("ปิดงานแล้ว")
                        .setContentIntent(pendingIntent)
                        //.setSound(alarmSound)
                        .setStyle(bigText)
                        .setWhen(getTimeMilliSec(timestamp))
                        .setSmallIcon(R.drawable.ic_tab_contacts)
                        .setLargeIcon(bitmap)
                        .setNumber(messages.size())
                        .setColor(Color.parseColor("#32CD32"))
                        .setSubText("By Website" + ":" + "Admin")
                        .setVibrate(new long[]{500, 500, 500})
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .build();


                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(Integer.parseInt(randomQuote), notification);
                acquireWakeLock(getApplicationContext());
                releaseWakeLock();
            }
        }
        catch (Exception ex){

        }
    }




    private void handleDataMessage_sale_and_credit_from_web_closing_credit_extra(JSONObject json) {
        //Log.e(TAG, "push json: " + json.toString());

        try {
            JSONObject data2 = json.getJSONObject("closing_credit_extra");

            String title = data2.getString("title_sale_and_credit_from_web_closing_credit_extra");
            String message = data2.getString("message_sale_and_credit_from_web_closing_credit_extra");
            String timestamp = data2.getString("timestamp_sale_and_credit_from_web_closing_credit_extra");
            String image_cedit = data2.getString("image_sale_and_credit_from_web_closing_credit_extra");


            String randomQuote = String.valueOf(new Random().nextInt());
            if (android.os.Build.VERSION.SDK_INT>=8.1) {
                sendNotification(image_cedit,message,title,timestamp,"อยู่ระหว่างการปิดงาน(แบบพิเศษ)","By Website"+":"+"Admin","#800080",R.drawable.ic_tab_contacts, Integer.parseInt(randomQuote),9);

            }
            else {
                // ShortcutBadger.applyCount(mContext, 0);

                Intent pushNotification = new Intent(Config2.PUSH_NOTIFICATION);
                pushNotification.putExtra("contno", title);
                pushNotification.putExtra("problem", message);
                pushNotification.putExtra("timestamp", timestamp);
                pushNotification.putExtra("image_cedit", image_cedit);
                LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);


                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                Bitmap bitmap = getBitmapFromURL(image_cedit);
                bitmap = getCircleBitmap(bitmap);
                String oldNotification = message;
                List<String> messages = Arrays.asList(oldNotification.split(","));
                for (int i = 0; i < messages.size(); i++) {
                    inboxStyle.addLine(i + 1 + " :" + messages.get(i));
                }
                NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

                // for (int i =0;i< messages.size(); i++) {
                bigText.bigText("เลขที่:" + title + "\n" + "" + "\n" + ">" + message);

                // }
                bigText.setBigContentTitle("อยู่ระหว่างการปิดงาน(แบบพิเศษ)");
                bigText.setSummaryText("By Website" + ":" + "Admin");

                playNotificationSound();

                Log.i(TAG, "QUOTE: " + randomQuote);
                Intent showFullQuoteIntent = new Intent(this, UI_CARDVIEW_DATA_CREDIT_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT2_Acti.class);
                showFullQuoteIntent.putExtra(INTENT_KEY, randomQuote);
                showFullQuoteIntent.putExtra("title", title);
                showFullQuoteIntent.putExtra("message", message);
                showFullQuoteIntent.putExtra("image_cedit", image_cedit);
                showFullQuoteIntent.putExtra("timestamp", timestamp);


                int uniqueInt = (int) (System.currentTimeMillis() & 0xfffffff);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, uniqueInt, showFullQuoteIntent, PendingIntent.FLAG_UPDATE_CURRENT);


                Notification notification = new NotificationCompat.Builder(this)

                        .setTicker(randomQuote)
                        .setAutoCancel(true)
                        .setContentTitle("อยู่ระหว่างการปิดงาน(แบบพิเศษ)")
                        .setContentIntent(pendingIntent)
                        //.setSound(alarmSound)
                        .setStyle(bigText)
                        .setWhen(getTimeMilliSec(timestamp))
                        .setSmallIcon(R.drawable.ic_tab_contacts)
                        .setLargeIcon(bitmap)
                        .setNumber(messages.size())
                        .setColor(Color.parseColor("#800080"))
                        .setSubText("By Website" + ":" + "Admin")
                        .setVibrate(new long[]{500, 500, 500})
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .build();


                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(Integer.parseInt(randomQuote), notification);
                acquireWakeLock(getApplicationContext());
                releaseWakeLock();
            }
        }
        catch (Exception ex){

        }
    }








    private void handleDataMessage_sale_and_credit_from_web_closing_credit_extra_success(JSONObject json) {
        //Log.e(TAG, "push json: " + json.toString());

        try {
            JSONObject data2 = json.getJSONObject("closing_credit_extra_success");

            String title = data2.getString("title_sale_and_credit_from_web_closing_credit_extra_success");
            String message = data2.getString("message_sale_and_credit_from_web_closing_credit_extra_success");
            String timestamp = data2.getString("timestamp_sale_and_credit_from_web_closing_credit_extra_success");
            String image_cedit = data2.getString("image_sale_and_credit_from_web_closing_credit_extra_success");




            // ShortcutBadger.applyCount(mContext, 0);

            Intent pushNotification = new Intent(Config2.PUSH_NOTIFICATION);
            pushNotification.putExtra("contno", title);
            pushNotification.putExtra("problem", message);
            pushNotification.putExtra("timestamp", timestamp);
            pushNotification.putExtra("image_cedit", image_cedit);
            LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);

            String randomQuote = String.valueOf(new Random().nextInt());

            if (android.os.Build.VERSION.SDK_INT>=8.1) {
                sendNotification(image_cedit,message,title,timestamp,"ปิดงาน(แบบพิเศษ)","By Website"+":"+"Admin","#2E8B57",R.drawable.ic_tab_contacts, Integer.parseInt(randomQuote),10);

            }
            else {

                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                Bitmap bitmap = getBitmapFromURL(image_cedit);
                bitmap = getCircleBitmap(bitmap);
                String oldNotification = message;
                List<String> messages = Arrays.asList(oldNotification.split(","));
                for (int i = 0; i < messages.size(); i++) {
                    inboxStyle.addLine(i + 1 + " :" + messages.get(i));
                }
                NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

                // for (int i =0;i< messages.size(); i++) {
                bigText.bigText("เลขที่:" + title + "\n" + "" + "\n" + ">" + message);

                // }
                bigText.setBigContentTitle("ปิดงาน(แบบพิเศษ)");
                bigText.setSummaryText("By Website" + ":" + "Admin");

                playNotificationSound();

                Log.i(TAG, "QUOTE: " + randomQuote);
                Intent showFullQuoteIntent = new Intent(this, UI_CARDVIEW_DATA_CREDIT_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT2_Acti.class);
                showFullQuoteIntent.putExtra(INTENT_KEY, randomQuote);
                showFullQuoteIntent.putExtra("title", title);
                showFullQuoteIntent.putExtra("message", message);
                showFullQuoteIntent.putExtra("image_cedit", image_cedit);
                showFullQuoteIntent.putExtra("timestamp", timestamp);


                int uniqueInt = (int) (System.currentTimeMillis() & 0xfffffff);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, uniqueInt, showFullQuoteIntent, PendingIntent.FLAG_UPDATE_CURRENT);


                Notification notification = new NotificationCompat.Builder(this)

                        .setTicker(randomQuote)
                        .setAutoCancel(true)
                        .setContentTitle("ปิดงาน(แบบพิเศษ)")
                        .setContentIntent(pendingIntent)
                        //.setSound(alarmSound)
                        .setStyle(bigText)
                        .setWhen(getTimeMilliSec(timestamp))
                        .setSmallIcon(R.drawable.ic_tab_contacts)
                        .setLargeIcon(bitmap)
                        .setNumber(messages.size())
                        .setColor(Color.parseColor("#2E8B57"))
                        .setSubText("By Website" + ":" + "Admin")
                        .setVibrate(new long[]{500, 500, 500})
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .build();


                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(Integer.parseInt(randomQuote), notification);
                acquireWakeLock(getApplicationContext());
                releaseWakeLock();
            }
        }
        catch (Exception ex){

        }
    }







    private void handleDataMessage_credit_from_web_cancel(JSONObject json) {
        //Log.e(TAG, "push json: " + json.toString());

        try {
            JSONObject data2 = json.getJSONObject("cancel_credit");

            String title = data2.getString("title_sale_and_credit_from_web_cancel_credit");
            String message = data2.getString("message_sale_and_credit_from_web_cancel_credit");
            String timestamp = data2.getString("timestamp_sale_and_credit_from_web_cancel_credit");
            String image_cedit = data2.getString("image_sale_and_credit_from_web_cancel_credit");


            String randomQuote = String.valueOf(new Random().nextInt());
            if (android.os.Build.VERSION.SDK_INT>=8.1) {
                sendNotification(image_cedit,message,title,timestamp,"ยกเลิกปัญหา","By Website"+":"+"Admin","#FF4500",R.drawable.ic_tab_contacts, Integer.parseInt(randomQuote),11);

            }
            else {
                // ShortcutBadger.applyCount(mContext, 0);

                Intent pushNotification = new Intent(Config2.PUSH_NOTIFICATION);
                pushNotification.putExtra("contno", title);
                pushNotification.putExtra("problem", message);
                pushNotification.putExtra("timestamp", timestamp);
                pushNotification.putExtra("image_cedit", image_cedit);
                LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);


                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                Bitmap bitmap = getBitmapFromURL(image_cedit);
                bitmap = getCircleBitmap(bitmap);
                String oldNotification = message;
                List<String> messages = Arrays.asList(oldNotification.split(","));
                for (int i = 0; i < messages.size(); i++) {
                    inboxStyle.addLine(i + 1 + " :" + messages.get(i));
                }
                NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

                // for (int i =0;i< messages.size(); i++) {
                bigText.bigText("เลขที่:" + title + "\n" + "" + "\n" + ">" + message);

                // }
                bigText.setBigContentTitle("ยกเลิกปัญหา");
                bigText.setSummaryText("By Website" + ":" + "Admin");

                playNotificationSound();

                Log.i(TAG, "QUOTE: " + randomQuote);
                Intent showFullQuoteIntent = new Intent(this, UI_CARDVIEW_DATA_CREDIT_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT2_Acti.class);
                showFullQuoteIntent.putExtra(INTENT_KEY, randomQuote);
                showFullQuoteIntent.putExtra("title", title);
                showFullQuoteIntent.putExtra("message", message);
                showFullQuoteIntent.putExtra("image_cedit", image_cedit);
                showFullQuoteIntent.putExtra("timestamp", timestamp);


                int uniqueInt = (int) (System.currentTimeMillis() & 0xfffffff);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, uniqueInt, showFullQuoteIntent, PendingIntent.FLAG_UPDATE_CURRENT);


                Notification notification = new NotificationCompat.Builder(this)

                        .setTicker(randomQuote)
                        .setAutoCancel(true)
                        .setContentTitle("ยกเลิกปัญหา")
                        .setContentIntent(pendingIntent)
                        //.setSound(alarmSound)
                        .setStyle(bigText)
                        .setWhen(getTimeMilliSec(timestamp))
                        .setSmallIcon(R.drawable.ic_tab_contacts)
                        .setLargeIcon(bitmap)
                        .setNumber(messages.size())
                        .setColor(Color.parseColor("#FF4500"))
                        .setSubText("By Website" + ":" + "Admin")
                        .setVibrate(new long[]{500, 500, 500})
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .build();


                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(Integer.parseInt(randomQuote), notification);
                acquireWakeLock(getApplicationContext());
                releaseWakeLock();
            }
        }
        catch (Exception ex){

        }
    }



    private void handleDataMessage_credit_from_web_receive(JSONObject json) {
        //Log.e(TAG, "push json: " + json.toString());

        try {
            JSONObject data2 = json.getJSONObject("receive_credit");

            String title = data2.getString("title_credit_from_web_receive_credit");
            String message = data2.getString("message_credit_from_web_receive_credit");
            String timestamp = data2.getString("timestamp_credit_from_web_receive_credit");
            String image_cedit = data2.getString("image_credit_from_web_receive_credit");


            String randomQuote = String.valueOf(new Random().nextInt());
            if (android.os.Build.VERSION.SDK_INT>=8.1) {
                sendNotification(image_cedit,message,title,timestamp,"รับปัญหาเข้าระบบ","By Website"+":"+"Admin","#FF4500",R.drawable.ic_tab_contacts, Integer.parseInt(randomQuote),12);

            }
            else {
                // ShortcutBadger.applyCount(mContext, 0);

                Intent pushNotification = new Intent(Config2.PUSH_NOTIFICATION);
                pushNotification.putExtra("contno", title);
                pushNotification.putExtra("problem", message);
                pushNotification.putExtra("timestamp", timestamp);
                pushNotification.putExtra("image_cedit", image_cedit);
                LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);


                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                Bitmap bitmap = getBitmapFromURL(image_cedit);
                bitmap = getCircleBitmap(bitmap);
                String oldNotification = message;
                List<String> messages = Arrays.asList(oldNotification.split(","));
                for (int i = 0; i < messages.size(); i++) {
                    inboxStyle.addLine(i + 1 + " :" + messages.get(i));
                }
                NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

                // for (int i =0;i< messages.size(); i++) {
                bigText.bigText("เลขที่:" + title + "\n" + "" + "\n" + ">" + message);

                // }
                bigText.setBigContentTitle("รับปัญหาเข้าระบบ");
                bigText.setSummaryText("By Website" + ":" + "Admin");

                playNotificationSound();

                Log.i(TAG, "QUOTE: " + randomQuote);
                Intent showFullQuoteIntent = new Intent(this, UI_CARDVIEW_DATA_CREDIT_BEFORE_EDIT_PROBLEM_INTRO_FRAGMENT2_Acti.class);
                showFullQuoteIntent.putExtra(INTENT_KEY, randomQuote);
                showFullQuoteIntent.putExtra("title", title);
                showFullQuoteIntent.putExtra("message", message);
                showFullQuoteIntent.putExtra("image_cedit", image_cedit);
                showFullQuoteIntent.putExtra("timestamp", timestamp);
                // showFullQuoteIntent.putExtra("nonti","nonti");


                int uniqueInt = (int) (System.currentTimeMillis() & 0xfffffff);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, uniqueInt, showFullQuoteIntent, PendingIntent.FLAG_UPDATE_CURRENT);


                Notification notification = new NotificationCompat.Builder(this)

                        .setTicker(randomQuote)
                        .setAutoCancel(true)
                        .setContentTitle("รับปัญหาเข้าระบบ")
                        .setContentIntent(pendingIntent)
                        //.setSound(alarmSound)
                        .setStyle(bigText)
                        .setWhen(getTimeMilliSec(timestamp))
                        .setSmallIcon(R.drawable.ic_tab_contacts)
                        .setLargeIcon(bitmap)
                        .setNumber(messages.size())
                        .setColor(Color.parseColor("#48D1CC"))
                        .setSubText("By Website" + ":" + "Admin")
                        .setVibrate(new long[]{500, 500, 500})
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .build();


                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(Integer.parseInt(randomQuote), notification);
                acquireWakeLock(getApplicationContext());
                releaseWakeLock();
            }
        }
        catch (Exception ex){

        }
    }


    private void handleDataMessage_credit_from_sale(JSONObject json) {
        //Log.e(TAG, "push json: " + json.toString());

        try {
            JSONObject data2 = json.getJSONObject("credit_recive_edit");

            String title = data2.getString("title_credit_from_sale");
            String message = data2.getString("message_credit_from_sale");
            String timestamp = data2.getString("timestamp_credit_from_sale");
            String image_cedit = data2.getString("image_credit_from_sale");




            String InformID_credit_from_sale = data2.getString("InformID_credit_from_sale");
            String Contno_credit_from_sale = data2.getString("Contno_credit_from_sale");
            String ID_credit_from_sale = data2.getString("ID_credit_from_sale");
            String topic_problem_credit_from_sale = data2.getString("topic_problem_credit_from_sale");
            String main_credit_from_sale = data2.getString("main_credit_from_sale");
            String gory_credit_from_sale = data2.getString("gory_credit_from_sale");
            String ProblemDetail_credit_from_sale = data2.getString("ProblemDetail_credit_from_sale");
            String ProblemDetail2_credit_from_sale = data2.getString("ProblemDetail2_credit_from_sale");
            String Image_Name_credit_from_sale = data2.getString("Image_Name_credit_from_sale");
            String WorkCode_credit_from_sale = data2.getString("WorkCode_credit_from_sale");
            String WorkName_credit_from_sale = data2.getString("WorkName_credit_from_sale");
            String date_create_credit_from_sale = data2.getString("date_create_credit_from_sale");
            String countImage_credit_from_sale = data2.getString("countImage_credit_from_sale");
            String Image_Name_R_credit_from_sale = data2.getString("Image_Name_R_credit_from_sale");
            String countImage_R_credit_from_sale = data2.getString("countImage_R_credit_from_sale");
            String Items_R_credit_from_sale = data2.getString("Items_R_credit_from_sale");

            String EmployeeName_credit_from_sale = data2.getString("EmployeeName_credit_from_sale");
            String PositionName_credit_from_sale = data2.getString("PositionName_credit_from_sale");
            String picture_credit_from_sale = data2.getString("picture_credit_from_sale");
            String user_code_credit_from_sale = data2.getString("user_code_credit_from_sale");


            Log.e("messagerr",message);
            // ShortcutBadger.applyCount(mContext, 0);

            Intent pushNotification = new Intent(Config2.PUSH_NOTIFICATION);
            pushNotification.putExtra("contno", title);
            pushNotification.putExtra("problem", message);
            pushNotification.putExtra("timestamp", timestamp);
            pushNotification.putExtra("image_cedit", image_cedit);
            LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);

            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            Bitmap bitmap = getBitmapFromURL(image_cedit);
            bitmap = getCircleBitmap(bitmap);
            String oldNotification=message;
            List<String> messages = Arrays.asList(oldNotification.split(","));
            for (int i =0;i< messages.size(); i++) {
                inboxStyle.addLine(i+1+" :"+messages.get(i));
            }
            NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

            for (int i =0;i< messages.size(); i++) {
                bigText.bigText(messages.get(i));
            }
            bigText.setBigContentTitle("แก้ไขปัญหา:"+"เลขที่:"+title);
            bigText.setSummaryText("By Mobile"+":"+""+" : พนักงานขาย");

            playNotificationSound();
            String randomQuote = String.valueOf(new Random().nextInt());
            Log.i(TAG, "QUOTE: " + randomQuote);
            Intent showFullQuoteIntent = new Intent(this, Activity_check_problem_by_cedit_nonti.class);
            showFullQuoteIntent.putExtra(INTENT_KEY, randomQuote);
            showFullQuoteIntent.putExtra("title", title);
            showFullQuoteIntent.putExtra("message", message);
            showFullQuoteIntent.putExtra("image_cedit", image_cedit);
            showFullQuoteIntent.putExtra("timestamp", timestamp);

            showFullQuoteIntent.putExtra("ID", ID_credit_from_sale);
            showFullQuoteIntent.putExtra("Gory", gory_credit_from_sale);
            showFullQuoteIntent.putExtra("Main", main_credit_from_sale);
            showFullQuoteIntent.putExtra("Sub", topic_problem_credit_from_sale);
            showFullQuoteIntent.putExtra("Detail", ProblemDetail_credit_from_sale);
            showFullQuoteIntent.putExtra("Detail2", ProblemDetail2_credit_from_sale);
            showFullQuoteIntent.putExtra("conno", Contno_credit_from_sale);
            showFullQuoteIntent.putExtra("InformID", InformID_credit_from_sale);
            showFullQuoteIntent.putExtra("Contno", Contno_credit_from_sale);
            showFullQuoteIntent.putExtra("WorkCode", WorkCode_credit_from_sale);
            showFullQuoteIntent.putExtra("WorkName", WorkName_credit_from_sale);
            showFullQuoteIntent.putExtra("Items_R", Items_R_credit_from_sale);

            showFullQuoteIntent.putExtra("getEmployeeName", EmployeeName_credit_from_sale);
            showFullQuoteIntent.putExtra("getPositionName", PositionName_credit_from_sale);
            showFullQuoteIntent.putExtra("getPicture", picture_credit_from_sale);
            showFullQuoteIntent.putExtra("user_code", user_code_credit_from_sale);




            int uniqueInt = (int) (System.currentTimeMillis() & 0xfffffff);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, uniqueInt, showFullQuoteIntent, PendingIntent.FLAG_UPDATE_CURRENT);


            Notification notification = new NotificationCompat.Builder(this)

                    .setTicker(randomQuote)
                    .setAutoCancel(true)
                    .setContentTitle("แก้ไขปัญหา:"+"เลขที่:"+title)
                    .setContentIntent(pendingIntent)
                    //.setSound(alarmSound)
                    .setStyle(inboxStyle)
                    .setWhen(getTimeMilliSec(timestamp))
                    .setSmallIcon(R.drawable.ic_tab_contacts)
                    .setLargeIcon(bitmap)
                    .setNumber(messages.size())
                    .setColor(Color.parseColor("#32CD32"))
                    .setSubText("By Mobile"+":"+""+" : พนักงานขาย")
                    .setVibrate(new long[] { 500, 500, 500 })
                    .setPriority(NotificationCompat.PRIORITY_MAX)
                    .build();



            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(Integer.parseInt(randomQuote), notification);
            acquireWakeLock(getApplicationContext());
            releaseWakeLock();




        }
        catch (Exception ex){

        }
    }











    private void handleDataMessage_sale_to_sale_all(JSONObject json) {
        //Log.e(TAG, "push json: " + json.toString());

        try {
            JSONObject data2 = json.getJSONObject("sale_all");

            String title = data2.getString("title_sale_from_cedit_to_sale_all");
            String message = data2.getString("message_sale_from_cedit_to_sale_all");
            String timestamp = data2.getString("timestamp_sale_from_cedit_to_sale_all");
            String image_cedit = data2.getString("image_cedit_sale_from_cedit_to_sale_all");



            String randomQuote = String.valueOf(new Random().nextInt());
            if (android.os.Build.VERSION.SDK_INT>=8.1) {
                sendNotification(image_cedit,message,title,timestamp,"แก้ไขปัญหา:" + "เลขที่:" + title,"By Mobile" + ":" + "" + " : พนักงานขาย","#32CD32",R.drawable.ic_tab_contacts, Integer.parseInt(randomQuote),13);

            }
            else {
                // ShortcutBadger.applyCount(mContext, 0);

                Intent pushNotification = new Intent(Config2.PUSH_NOTIFICATION);
                pushNotification.putExtra("contno", title);
                pushNotification.putExtra("problem", message);
                pushNotification.putExtra("timestamp", timestamp);
                pushNotification.putExtra("image_cedit", image_cedit);
                LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);


                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                Bitmap bitmap = getBitmapFromURL(image_cedit);
                bitmap = getCircleBitmap(bitmap);
                String oldNotification = message;
                List<String> messages = Arrays.asList(oldNotification.split(","));
                for (int i = 0; i < messages.size(); i++) {
                    inboxStyle.addLine(i + 1 + " :" + messages.get(i));
                }
                NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

                for (int i = 0; i < messages.size(); i++) {
                    bigText.bigText(messages.get(i));
                }
                bigText.setBigContentTitle("แก้ไขปัญหา:" + "เลขที่:" + title);
                bigText.setSummaryText("By Mobile" + ":" + "" + " : พนักงานขาย");

                playNotificationSound();

                Log.i(TAG, "QUOTE: " + randomQuote);
                Intent showFullQuoteIntent = new Intent(this, MusicActivity_Credit.class);
                showFullQuoteIntent.putExtra(INTENT_KEY, randomQuote);
                showFullQuoteIntent.putExtra("title", title);
                showFullQuoteIntent.putExtra("message", message);
                showFullQuoteIntent.putExtra("image_cedit", image_cedit);
                showFullQuoteIntent.putExtra("timestamp", timestamp);


                int uniqueInt = (int) (System.currentTimeMillis() & 0xfffffff);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, uniqueInt, showFullQuoteIntent, PendingIntent.FLAG_UPDATE_CURRENT);


                Notification notification = new NotificationCompat.Builder(this)

                        .setTicker(randomQuote)
                        .setAutoCancel(true)
                        .setContentTitle("แก้ไขปัญหา:" + "เลขที่:" + title)
                        .setContentIntent(pendingIntent)
                        //.setSound(alarmSound)
                        .setStyle(inboxStyle)
                        .setWhen(getTimeMilliSec(timestamp))
                        .setSmallIcon(R.drawable.ic_tab_contacts)
                        .setLargeIcon(bitmap)
                        .setNumber(messages.size())
                        .setColor(Color.parseColor("#32CD32"))
                        .setSubText("By Mobile" + ":" + "" + " : พนักงานขาย")
                        .setVibrate(new long[]{500, 500, 500})
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .build();


                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(Integer.parseInt(randomQuote), notification);
                acquireWakeLock(getApplicationContext());
                releaseWakeLock();

            }


        }
        catch (Exception ex){

        }
    }



    private void handleDataMessage_sale_all_for_checker(JSONObject json) {
        //Log.e(TAG, "push json: " + json.toString());

        try {
            JSONObject data2 = json.getJSONObject("sale_all_for_checker");

            String title = data2.getString("title_sale_from_cedit_to_sale_all_for_checker");
            String message = data2.getString("message_sale_from_cedit_to_sale_all_for_checker");
            String timestamp = data2.getString("timestamp_sale_from_cedit_to_sale_all_for_checker");
            String image_cedit = data2.getString("image_cedit_sale_from_cedit_to_sale_all_for_checker");



            String randomQuote = String.valueOf(new Random().nextInt());
            if (android.os.Build.VERSION.SDK_INT>=8.1) {
                sendNotification(image_cedit,message,title,timestamp,"การตรวจสอบ:" + "เลขที่:" + title,"By Mobile" + ":" + "" + " : พนักงานเคดิต","#32CD32",R.drawable.ic_tab_contacts, Integer.parseInt(randomQuote),14);

            }
            else {
                // ShortcutBadger.applyCount(mContext, 0);

                Intent pushNotification = new Intent(Config2.PUSH_NOTIFICATION);
                pushNotification.putExtra("contno", title);
                pushNotification.putExtra("problem", message);
                pushNotification.putExtra("timestamp", timestamp);
                pushNotification.putExtra("image_cedit", image_cedit);
                LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);


                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                Bitmap bitmap = getBitmapFromURL(image_cedit);
                bitmap = getCircleBitmap(bitmap);
                String oldNotification = message;
                List<String> messages = Arrays.asList(oldNotification.split(","));
                for (int i = 0; i < messages.size(); i++) {
                    inboxStyle.addLine(i + 1 + " :" + messages.get(i));
                }
                NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

                for (int i = 0; i < messages.size(); i++) {
                    bigText.bigText(messages.get(i));
                }
                bigText.setBigContentTitle("การตรวจสอบ:" + "เลขที่:" + title);
                bigText.setSummaryText("By Mobile" + ":" + "" + " : พนักงานเคดิต");

                playNotificationSound();

                Log.i(TAG, "QUOTE: " + randomQuote);
                Intent showFullQuoteIntent = new Intent(this, MusicActivity_Credit.class);
                showFullQuoteIntent.putExtra(INTENT_KEY, randomQuote);
                showFullQuoteIntent.putExtra("title", title);
                showFullQuoteIntent.putExtra("message", message);
                showFullQuoteIntent.putExtra("image_cedit", image_cedit);
                showFullQuoteIntent.putExtra("timestamp", timestamp);


                int uniqueInt = (int) (System.currentTimeMillis() & 0xfffffff);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, uniqueInt, showFullQuoteIntent, PendingIntent.FLAG_UPDATE_CURRENT);


                Notification notification = new NotificationCompat.Builder(this)

                        .setTicker(randomQuote)
                        .setAutoCancel(true)
                        .setContentTitle("การตรวจสอบ:" + "เลขที่:" + title)
                        .setContentIntent(pendingIntent)
                        //.setSound(alarmSound)
                        .setStyle(inboxStyle)
                        .setWhen(getTimeMilliSec(timestamp))
                        .setSmallIcon(R.drawable.ic_tab_contacts)
                        .setLargeIcon(bitmap)
                        .setNumber(messages.size())
                        .setColor(Color.parseColor("#32CD32"))
                        .setSubText("By Mobile" + ":" + "" + " : พนักงานเคดิต")
                        .setVibrate(new long[]{500, 500, 500})
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .build();


                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(Integer.parseInt(randomQuote), notification);
                acquireWakeLock(getApplicationContext());
                releaseWakeLock();


            }

        }
        catch (Exception ex){

        }
    }








    private void handleDataMessage_sale_all_for_checker_by_web(JSONObject json) {
        //Log.e(TAG, "push json: " + json.toString());

        try {
            JSONObject data2 = json.getJSONObject("sale_all_for_checker_by_web");

            String title = data2.getString("title_sale_from_cedit_to_sale_all_for_checker_by_web");
            String message = data2.getString("message_sale_from_cedit_to_sale_all_for_checker_by_web");
            String timestamp = data2.getString("timestamp_sale_from_cedit_to_sale_all_for_checker_by_web");
            String image_cedit = data2.getString("image_cedit_sale_from_cedit_to_sale_all_for_checker_by_web");


            String randomQuote = String.valueOf(new Random().nextInt());
            if (android.os.Build.VERSION.SDK_INT>=8.1) {
                sendNotification(image_cedit,message,title,timestamp,"การตรวจสอบ:" + "เลขที่:" + title,"By Website" + ":" + "" + " : Admin","#32CD32",R.drawable.ic_tab_contacts, Integer.parseInt(randomQuote),15);

            }
            else {

                // ShortcutBadger.applyCount(mContext, 0);

                Intent pushNotification = new Intent(Config2.PUSH_NOTIFICATION);
                pushNotification.putExtra("contno", title);
                pushNotification.putExtra("problem", message);
                pushNotification.putExtra("timestamp", timestamp);
                pushNotification.putExtra("image_cedit", image_cedit);
                LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);


                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                Bitmap bitmap = getBitmapFromURL(image_cedit);
                bitmap = getCircleBitmap(bitmap);
                String oldNotification = message;
                List<String> messages = Arrays.asList(oldNotification.split(","));
                for (int i = 0; i < messages.size(); i++) {
                    inboxStyle.addLine(i + 1 + " :" + messages.get(i));
                }
                NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

                for (int i = 0; i < messages.size(); i++) {
                    bigText.bigText(messages.get(i));
                }
                bigText.setBigContentTitle("การตรวจสอบ:" + "เลขที่:" + title);
                bigText.setSummaryText("By Website" + ":" + "" + " : Admin");

                playNotificationSound();

                Log.i(TAG, "QUOTE: " + randomQuote);
                Intent showFullQuoteIntent = new Intent(this, MusicActivity_Credit.class);
                showFullQuoteIntent.putExtra(INTENT_KEY, randomQuote);
                showFullQuoteIntent.putExtra("title", title);
                showFullQuoteIntent.putExtra("message", message);
                showFullQuoteIntent.putExtra("image_cedit", image_cedit);
                showFullQuoteIntent.putExtra("timestamp", timestamp);


                int uniqueInt = (int) (System.currentTimeMillis() & 0xfffffff);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, uniqueInt, showFullQuoteIntent, PendingIntent.FLAG_UPDATE_CURRENT);


                Notification notification = new NotificationCompat.Builder(this)

                        .setTicker(randomQuote)
                        .setAutoCancel(true)
                        .setContentTitle("การตรวจสอบ:" + "เลขที่:" + title)
                        .setContentIntent(pendingIntent)
                        //.setSound(alarmSound)
                        .setStyle(inboxStyle)
                        .setWhen(getTimeMilliSec(timestamp))
                        .setSmallIcon(R.drawable.ic_tab_contacts)
                        .setLargeIcon(bitmap)
                        .setNumber(messages.size())
                        .setColor(Color.parseColor("#32CD32"))
                        .setSubText("By Website" + ":" + "" + " : Admin")
                        .setVibrate(new long[]{500, 500, 500})
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .build();


                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(Integer.parseInt(randomQuote), notification);
                acquireWakeLock(getApplicationContext());
                releaseWakeLock();

            }


        }
        catch (Exception ex){

        }
    }






    private void handleDataMessage_credit_to_sale(JSONObject json) {
        //Log.e(TAG, "push json: " + json.toString());



        try {
            JSONObject data2 = json.getJSONObject("data2");

            String title = data2.getString("title_credit_to_sale");
            String message = data2.getString("message_credit_to_sale");
            String timestamp = data2.getString("timestamp_credit_to_sale");
            String image_cedit = data2.getString("image_credit_to_sale");
            String status_check = data2.getString("status_check_credit_to_sale");



            String randomQuote = String.valueOf(new Random().nextInt());

            if (android.os.Build.VERSION.SDK_INT>=8.1) {
                sendNotification(image_cedit,message,title,timestamp,"ตรวจสอบแล้วผ่าน","By Mobile" + ":" + "" + " : พนักงานเครดิต","#32CD32",R.drawable.ic_tab_contacts, Integer.parseInt(randomQuote),16);

            }

            else {
                Intent pushNotification = new Intent(Config2.PUSH_NOTIFICATION);
                pushNotification.putExtra("contno", title);
                pushNotification.putExtra("problem", message);
                pushNotification.putExtra("timestamp", timestamp);
                pushNotification.putExtra("image_cedit", image_cedit);
                pushNotification.putExtra("check", "check");
                LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);


                Log.e("status_check", status_check);
                if (status_check.equals("25")) {
                    NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                    Bitmap bitmap = getBitmapFromURL(image_cedit);
                    bitmap = getCircleBitmap(bitmap);
                    String oldNotification = message;
                    List<String> messages = Arrays.asList(oldNotification.split(","));
                    for (int i = 0; i < messages.size(); i++) {
                        inboxStyle.addLine(i + 1 + " :" + messages.get(i));
                    }
                    NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

                    // for (int i =0;i< messages.size(); i++) {
                    bigText.bigText("เลขที่:" + title + "\n" + "" + "\n" + ">" + message);

                    // }
                    bigText.setBigContentTitle("ตรวจสอบแล้วผ่าน");
                    bigText.setSummaryText("By Mobile" + ":" + "" + " : พนักงานเครดิต");

                    playNotificationSound();
                    Log.i(TAG, "QUOTE: " + randomQuote);
                    Intent showFullQuoteIntent = new Intent(this, MusicActivity_Credit.class);
                    showFullQuoteIntent.putExtra(INTENT_KEY, randomQuote);
                    showFullQuoteIntent.putExtra("title", title);
                    showFullQuoteIntent.putExtra("message", message);
                    showFullQuoteIntent.putExtra("image_cedit", image_cedit);
                    showFullQuoteIntent.putExtra("timestamp", timestamp);
                    showFullQuoteIntent.putExtra("check", "check");


                    int uniqueInt = (int) (System.currentTimeMillis() & 0xfffffff);
                    PendingIntent pendingIntent = PendingIntent.getActivity(this, uniqueInt, showFullQuoteIntent, PendingIntent.FLAG_UPDATE_CURRENT);


                    Notification notification = new NotificationCompat.Builder(this)

                            .setTicker(randomQuote)
                            .setAutoCancel(true)
                            .setContentTitle("ตรวจสอบแล้วผ่าน")
                            .setContentIntent(pendingIntent)
                            //.setSound(alarmSound)
                            .setStyle(bigText)
                            .setWhen(getTimeMilliSec(timestamp))
                            .setSmallIcon(R.drawable.ic_tab_contacts)
                            .setLargeIcon(bitmap)
                            .setNumber(messages.size())
                            .setColor(Color.parseColor("#32CD32"))
                            .setSubText("By Mobile" + ":" + "" + " : พนักงานเครดิต")
                            .setVibrate(new long[]{500, 500, 500})
                            .setPriority(NotificationCompat.PRIORITY_MAX)
                            .build();


                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    notificationManager.notify(Integer.parseInt(randomQuote), notification);
                    acquireWakeLock(getApplicationContext());
                    releaseWakeLock();
                } else {
                    NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                    Bitmap bitmap = getBitmapFromURL(image_cedit);
                    bitmap = getCircleBitmap(bitmap);
                    String oldNotification = message;
                    List<String> messages = Arrays.asList(oldNotification.split(","));
                    for (int i = 0; i < messages.size(); i++) {
                        inboxStyle.addLine(i + 1 + " :" + messages.get(i));
                    }
                    NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

                    //for (int i =0;i< messages.size(); i++) {
                    bigText.bigText("เลขที่:" + title + "\n" + "" + "\n" + ">" + message);
                    // }
                    bigText.setBigContentTitle("ตรวจสอบแล้วไม่ผ่าน:กรุณาแก้ไข");
                    bigText.setSummaryText("By Mobile" + ":" + "" + " : พนักงานเครดิต");

                    playNotificationSound();

                    Log.i(TAG, "QUOTE: " + randomQuote);
                    Intent showFullQuoteIntent = new Intent(this, MusicActivity_Credit.class);
                    showFullQuoteIntent.putExtra(INTENT_KEY, randomQuote);
                    showFullQuoteIntent.putExtra("title", title);
                    showFullQuoteIntent.putExtra("message", message);
                    showFullQuoteIntent.putExtra("image_cedit", image_cedit);
                    showFullQuoteIntent.putExtra("timestamp", timestamp);
                    showFullQuoteIntent.putExtra("check", "check");


                    int uniqueInt = (int) (System.currentTimeMillis() & 0xfffffff);
                    PendingIntent pendingIntent = PendingIntent.getActivity(this, uniqueInt, showFullQuoteIntent, PendingIntent.FLAG_UPDATE_CURRENT);


                    Notification notification = new NotificationCompat.Builder(this)

                            .setTicker(randomQuote)
                            .setAutoCancel(true)
                            .setContentTitle("ตรวจสอบแล้วไม่ผ่าน:กรุณาแก้ไข")
                            .setContentIntent(pendingIntent)
                            //.setSound(alarmSound)
                            .setStyle(bigText)
                            .setWhen(getTimeMilliSec(timestamp))
                            .setSmallIcon(R.drawable.ic_tab_contacts)
                            .setLargeIcon(bitmap)
                            .setNumber(messages.size())
                            .setColor(Color.parseColor("#ff0000"))
                            .setSubText("By Mobile" + ":" + "" + " : พนักงานเครดิต")
                            .setVibrate(new long[]{500, 500, 500})
                            .setPriority(NotificationCompat.PRIORITY_MAX)
                            .build();


                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    notificationManager.notify(Integer.parseInt(randomQuote), notification);
                    acquireWakeLock(getApplicationContext());
                    releaseWakeLock();
                }


            }

        }
        catch (Exception ex){

        }
    }






    public void playNotificationSound() {
        try {

            nontification="notification";


            Uri alarmSound = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE
                    //     + "://" + MyApplication.getInstance().getApplicationContext().getPackageName() + "/raw/notification");
                    + "://" + MyApplication.getInstance().getApplicationContext().getPackageName() + "/raw/"+nontification);
            Ringtone r = RingtoneManager.getRingtone(MyApplication.getInstance().getApplicationContext(), alarmSound);
            r.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void showNotificationMessage(Context context, String title, String message, String timeStamp, Intent intent) {
        notificationUtils = new NotificationUtils(context);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        notificationUtils.showNotificationMessage(title, message, timeStamp, intent);
    }


    public static void setBadge(Context context, int count) {
        String launcherClassName = getLauncherClassName(context);
        if (launcherClassName == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count", count);
        intent.putExtra("badge_count_package_name", context.getPackageName());
        intent.putExtra("badge_count_class_name", launcherClassName);
        context.sendBroadcast(intent);
    }

    public static String getLauncherClassName(Context context) {

        PackageManager pm = context.getPackageManager();

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> resolveInfos = pm.queryIntentActivities(intent, 0);
        for (ResolveInfo resolveInfo : resolveInfos) {
            String pkgName = resolveInfo.activityInfo.applicationInfo.packageName;
            if (pkgName.equalsIgnoreCase(context.getPackageName())) {
                String className = resolveInfo.activityInfo.name;
                return className;
            }
        }
        return null;
    }


    public Bitmap getBitmapFromURL(String strURL) {
        try {
            URL url = new URL(strURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    private Bitmap getCircleBitmap(Bitmap bitmap) {
        final Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(output);

        final int color = Color.RED;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawOval(rectF, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        bitmap.recycle();

        return output;
    }
    private PowerManager.WakeLock wakeLock;
    public  void acquireWakeLock(Context context) {
        if (wakeLock != null)
            wakeLock.release();

        PowerManager pm = (PowerManager)context.getSystemService(Context.POWER_SERVICE);
        wakeLock = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK |PowerManager.ACQUIRE_CAUSES_WAKEUP |PowerManager.ON_AFTER_RELEASE, "WakeLock");
        wakeLock.acquire();
    }

    public  void releaseWakeLock() {
        if (wakeLock != null)
            wakeLock.release();

        wakeLock = null;
    }
    private void showNotificationMessage_web_to_cedit(Context context, String title, String message,String timeStamp, Intent intent) {
        notificationUtils_web_to_cedit = new NotificationUtils_web_to_cedit(context);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        notificationUtils_web_to_cedit.showNotificationMessage_web_to_cedit(title, message, timeStamp, intent);
    }

    private void showNotificationMessage_sale_from_cedit(Context context, String title, String message,String image_cedit,String timeStamp, Intent intent) {
        notificationUtils_sale_from_cedit = new NotificationUtils_sale_from_cedit(context);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        notificationUtils_sale_from_cedit.showNotificationMessage_sale_from_cedit(title, message,image_cedit, timeStamp, intent);
    }
    private void showNotificationMessage_credit_from_sale(Context context, String title, String message,String image_cedit,String timeStamp, Intent intent) {
        notificationUtils_credit_from_sale = new NotificationUtils_credit_from_sale(context);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        notificationUtils_credit_from_sale.showNotificationMessage_sale_from_cedit(title, message,image_cedit, timeStamp, intent);
    }







}
