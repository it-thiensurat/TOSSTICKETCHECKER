package com.tsr.tsrproblemreport_tossticket_checker.other_all.nontification;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
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
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Patterns;

import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import me.leolin.shortcutbadger.ShortcutBadger;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by teera-s on 5/19/2016 AD.
 */
public class NotificationUtils_credit_from_sale {
    // private static String TAG = NotificationUtils.class.getSimpleName();
    public static final String PREFS = "examplePrefs";
    private Context mContext;
    private static int hh=0;
    private static String  str,str2;
    String gg;
    int i;
    int k;
     int h=0;
    public static int dd=0;
    private static int h3=1;
    int h2;
    int ll;
    int counter;
    int counter2;
    String stringCounter;
    String Sound,nontification,onoff_sound,vibrate;
    public NotificationUtils_credit_from_sale() {

    }

    public NotificationUtils_credit_from_sale(Context mContext) {
        this.mContext = mContext;
    }
    public void showNotificationMessage_sale_from_cedit(String title, String message,String image_cedit, String timeStamp,Intent intent) {
        // public void showNotificationMessage2(String title, String message, String timeStamp, Intent intent) {
        NotificationUtils_web_to_cedit(title, message,image_cedit, timeStamp, intent, null);

    }
    public void NotificationUtils_web_to_cedit(final String title, final String message, final String image_cedit, final String timeStamp, Intent intent, String imageUrl) {
        // public void showNotificationMessage2(final String title, final String message, final String content, Intent intent, String imageUrl, String post_url) {
        // Check for empty push message
        if (TextUtils.isEmpty(message))
            return;

        // notification icon
        final int icon = R.drawable.browser;


        final PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        mContext,
                        new Random().nextInt(),
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );







        final NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mContext);
        final Uri alarmSound = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE
                //   + "://" + mContext.getPackageName() + "/raw/notification");
                + "://" + mContext.getPackageName() + "/raw/"+nontification);
        if (!TextUtils.isEmpty(imageUrl)) {

            if (imageUrl != null && imageUrl.length() > 4 && Patterns.WEB_URL.matcher(imageUrl).matches()) {

                Bitmap bitmap = getBitmapFromURL(imageUrl);

                if (bitmap != null) {
                    //   showBigNotification(bitmap, mBuilder, icon, title, message, content, resultPendingIntent, alarmSound);
                } else {
                    showSmallNotification(mBuilder, icon, title, message,image_cedit, timeStamp, resultPendingIntent, alarmSound, intent);
                    // showSmallNotification(mBuilder, icon, title, message, content, resultPendingIntent, alarmSound);
                }
            }
        } else {
            showSmallNotification(mBuilder, icon, title, message,image_cedit, timeStamp, resultPendingIntent, alarmSound, intent);
            //    playNotificationSound();
            hh++;

        }
    }





    //  private void showSmallNotification(android.support.v4.app.NotificationCompat.Builder mBuilder, int icon, String title, String message, String timeStamp, PendingIntent resultPendingIntent, Uri alarmSound) {
    private  void showSmallNotification(NotificationCompat.Builder mBuilder, int icon, String title, String message,String image_cedit, String timeStamp, PendingIntent resultPendingIntent, Uri alarmSound, Intent intent) {

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();

        Bitmap bitmap = getBitmapFromURL(image_cedit);
         bitmap = getCircleBitmap(bitmap);



         /*
        if (Config.appendNotificationMessages) {
            MyApplication.getInstance().getPrefManager().addNotification(message);
            String oldNotification = MyApplication.getInstance().getPrefManager().getNotifications();
            List<String> messages = Arrays.asList(oldNotification.split("\\|"));

            for (int i = messages.size() - 1; i >= 0; i--) {
                inboxStyle.addLine(title+" >"+messages.get(i));
                //    Log.e("iiiiii",i+"");
                //  Log.e("sssss",messages.get(i));
            }
            //h=messages.size();
            h=h+1;
            h3=messages.size()-1;

            // hh=h;
        } else {
            inboxStyle.addLine(title+" >"+message);
        }
        int x = 1;
        str = Integer.toString(h);
        str2 = Integer.toString(h3);


        stringCounter = Integer.toString(h);



        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
        // bigText.bigText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        bigText.bigText(message);
        bigText.setBigContentTitle("ปัญหาเลขที่สัญญา : "+title);
        bigText.setSummaryText("By Website"+":"+"Admin");






        Notification notification;


        notification = mBuilder.setSmallIcon(icon).setTicker(title).setWhen(0)
                .setAutoCancel(false)
                .setContentTitle("ปัญหาเลขที่สัญญา : "+title)

                .setContentIntent(resultPendingIntent)

                .setSound(alarmSound)

                .setWhen(getTimeMilliSec(timeStamp))
                .setSmallIcon(R.drawable.ic_tab_contacts)
                .setLargeIcon(bitmap)

                .setNumber(h)
                .setColor(Color.parseColor("#32CD32"))
               // .addAction(android.R.drawable.ic_menu_view,"ปัญหาของ : "+title,resultPendingIntent)
                //.setSubText(NAME+" : "+POSITION)
                .setSubText(message)
                .setStyle(bigText)
                .setVibrate(new long[] { 500, 500, 500 })
                //.setPriority(NotificationCompat.PRIORITY_MAX)
                // .setDefaults(Notification.DEFAULT_VIBRATE)
                 .setLights(Color.BLUE, 1000, 300)
               // .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
                .build();

        Random random = new Random();
        int m = random.nextInt(9999 - 1000) + 1000;

        NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(NOTIFICATION_SERVICE);
        //  notificationManager.notify(Config.NOTIFICATION_ID, notification);
        notificationManager.notify(m, notification);
        //   Log.e("gggggg",m+"");
        acquireWakeLock(mContext);
        releaseWakeLock();
*/







       // Intent intent2 = new Intent(MusicActivity_Credit.this,
             //   MusicActivity_Credit.class);

       // PendingIntent pendingIntent = PendingIntent.getActivity(
           //     MusicActivity_Credit.this, 0, intent2,
             //   PendingIntent.FLAG_CANCEL_CURRENT);
        String oldNotification=message;
        List<String> messages = Arrays.asList(oldNotification.split(","));

        //for (int i = messages.size() - 1; i >= 0; i--) {
            for (int i =0;i< messages.size(); i++) {
            inboxStyle.addLine(i+1+" :"+messages.get(i));

        }

              /* .setStyle(new NotificationCompat.InboxStyle()
                        .addLine(messages)
                        .addLine("M.Twain (Google+) Haiku is more than a cert...")
                        .addLine("M.Twain Reminder")
                        .addLine("M.Twain Lunch?")
                        .addLine("M.Twain Revised Specs")
                        .addLine("M.Twain ")
                        .addLine("Google Play Celebrate 25 billion apps with Goo..")
                        .addLine("Stack Exchange StackOverflow weekly Newsl...")
                        .addLine("M.Twain (Google+) Haiku is more than a cert...")
                        .addLine("M.Twain Reminder")
                        .addLine("M.Twain Lunch?")
                        .addLine("M.Twain Revised Specs")
                        .addLine("M.Twain ")
                        .addLine("Google Play Celebrate 25 billion apps with Goo..")
                        .addLine("Stack Exchange StackOverflow weekly Newsl...")
                        .setBigContentTitle("6 ปัญหาเข้ามาไหม่")

                        .setSummaryText("dddddd")*/


        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
        // bigText.bigText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");

        //for (int i = messages.size() - 1; i >= 0; i--) {
            for (int i =0;i< messages.size(); i++) {
          //  inboxStyle.addLine(i+" :"+messages.get(i));
            bigText.bigText(messages.get(i));
        }
        bigText.setBigContentTitle("แก้ไขปัญหา:"+"เลขที่:"+title);
        bigText.setSummaryText("By Mobile"+":"+"ใจสั่งมา"+" : พนักงานขาย");

        Notification notification;


        notification = mBuilder.setSmallIcon(icon).setTicker(title).setWhen(0)
                .setSmallIcon(R.drawable.ic_tab_contacts)
                .setLargeIcon(bitmap)
                .setNumber(messages.size())
                .setWhen(getTimeMilliSec(timeStamp))
                .setColor(Color.parseColor("#32CD32"))
                .setContentIntent(resultPendingIntent)
                .setStyle(inboxStyle)
                .setContentTitle("แก้ไขปัญหา:"+"เลขที่:"+title)
                .setSubText("By Mobile"+":"+"ใจสั่งมา"+" : พนักงานขาย")

                .build();
        Random random = new Random();
        int m = random.nextInt(9999 - 1000) + 1000;

        notification.defaults |= Notification.DEFAULT_LIGHTS;
        notification.defaults |= Notification.DEFAULT_VIBRATE; //Vibration
        NotificationManager mNotificationManager2 = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager2.notify(new Random().nextInt(), notification);
        acquireWakeLock(mContext);
        releaseWakeLock();


        dd=dd+1;
        ShortcutBadger.applyCount(mContext, dd); //for 1.1.4+

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

    // Playing notification sound
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


    public static long getTimeMilliSec(String timeStamp) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = format.parse(timeStamp);
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }


    // Clears notification tray messages
    public static void clearNotifications() {
        NotificationManager notificationManager = (NotificationManager) MyApplication.getInstance().getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancelAll();
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
}
