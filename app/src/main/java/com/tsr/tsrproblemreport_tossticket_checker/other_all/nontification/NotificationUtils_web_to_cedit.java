package com.tsr.tsrproblemreport_tossticket_checker.other_all.nontification;



        import android.app.Notification;
        import android.app.NotificationManager;
        import android.app.PendingIntent;
        import android.content.ContentResolver;
        import android.content.Context;
        import android.content.Intent;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.graphics.Color;
        import android.media.Ringtone;
        import android.media.RingtoneManager;
        import android.net.Uri;
        import android.os.PowerManager;
        import android.support.v4.app.NotificationCompat;
        import android.text.TextUtils;
        import android.util.Patterns;

        import com.tsr.tsrproblemreport_tossticket_checker.R;

        import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;
        import com.tsr.tsrproblemreport_tossticket_checker.other_all.service.Config2;

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

/**
 * Created by teera-s on 5/19/2016 AD.
 */
public class NotificationUtils_web_to_cedit  {
    // private static String TAG = NotificationUtils.class.getSimpleName();
    public static final String PREFS = "examplePrefs";
    private Context mContext;
    private static int hh=0;
    private static String  str,str2;
    String gg;
    int i;
    int k;
    private static int h=1;
    private static int h3=1;
    int h2;
    int ll;
    int counter;
    int counter2;
    String stringCounter;
    String Sound,nontification,onoff_sound,vibrate;
    public NotificationUtils_web_to_cedit() {

    }

    public NotificationUtils_web_to_cedit(Context mContext) {
        this.mContext = mContext;
    }
    public void showNotificationMessage_web_to_cedit(String title, String message, String timeStamp,Intent intent) {
        // public void showNotificationMessage2(String title, String message, String timeStamp, Intent intent) {
        NotificationUtils_web_to_cedit(title, message, timeStamp, intent, null);

    }
    public void NotificationUtils_web_to_cedit(final String title, final String message, final String timeStamp, Intent intent, String imageUrl) {
        // public void showNotificationMessage2(final String title, final String message, final String content, Intent intent, String imageUrl, String post_url) {
        // Check for empty push message
        if (TextUtils.isEmpty(message))
            return;

        // notification icon
        final int icon = R.drawable.browser;


        final PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        mContext,
                        0,
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
                    showSmallNotification(mBuilder, icon, title, message, timeStamp, resultPendingIntent, alarmSound, intent);
                    // showSmallNotification(mBuilder, icon, title, message, content, resultPendingIntent, alarmSound);
                }
            }
        } else {
            showSmallNotification(mBuilder, icon, title, message, timeStamp, resultPendingIntent, alarmSound, intent);
            //    playNotificationSound();
            hh++;

        }
    }





    //  private void showSmallNotification(android.support.v4.app.NotificationCompat.Builder mBuilder, int icon, String title, String message, String timeStamp, PendingIntent resultPendingIntent, Uri alarmSound) {
    private  void showSmallNotification(NotificationCompat.Builder mBuilder, int icon, String title, String message, String timeStamp, PendingIntent resultPendingIntent, Uri alarmSound, Intent intent) {

        // private void showSmallNotification(NotificationCompat.Builder mBuilder, int icon, String title, String message, String content, PendingIntent resultPendingIntent, Uri alarmSound) {

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();



        if (Config2.appendNotificationMessages) {
            MyApplication.getInstance().getPrefManager().addNotification(message);

            //  String oldNotification = MyApplication.getInstance().getPrefManager().getNotifications();
            String oldNotification = MyApplication.getInstance().getPrefManager().getNotifications();

            List<String> messages = Arrays.asList(oldNotification.split("\\|"));

            for (int i = messages.size() - 1; i >= 0; i--) {
                inboxStyle.addLine("เลขที่สัญญา : "+title+" >"+"ลูกค้า : "+messages.get(i));
                //    Log.e("iiiiii",i+"");
                //  Log.e("sssss",messages.get(i));
            }
            h=messages.size();
            h3=messages.size()-1;

            // hh=h;
        } else {
            inboxStyle.addLine(title+" >"+message);
        }
        int x = 1;
        str = Integer.toString(h);






        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
        // bigText.bigText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        bigText.bigText(message+"  สัญญา *ที่ต้องตรวจสอบ*");
        bigText.setBigContentTitle(str);
        bigText.setSummaryText("By Web");


        Notification notification;


            notification = mBuilder.setSmallIcon(icon).setTicker(title).setWhen(0)
                    .setAutoCancel(false)
                    .setContentTitle(message+"  สัญญา *ที่ต้องตรวจสอบ*")
                    .setContentIntent(resultPendingIntent)
                    //.setContentIntent(resultPendingIntent2)
                    .setSound(alarmSound)
                    .setStyle(inboxStyle)
                    .setWhen(getTimeMilliSec(timeStamp))
                    .setSmallIcon(R.drawable.ic_tab_contacts)
                    .setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(), icon))
                    //  .setContentText(message)
                    .setNumber(h)
                    .setColor(Color.parseColor("#32CD32"))
                    .setSubText("By Web")
                    //  .setStyle(bigText)

                    .setVibrate(new long[] { 500, 500, 500 })
                    .setPriority(NotificationCompat.PRIORITY_MAX)


                    .build();









        // notification.flags |= Notification.FLAG_SHOW_LIGHTS;
        Random random = new Random();
        int m = random.nextInt(9999 - 1000) + 1000;

        NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        //  notificationManager.notify(Config.NOTIFICATION_ID, notification);
        notificationManager.notify(Config2.NOTIFICATION_ID, notification);
        //   Log.e("gggggg",m+"");
        acquireWakeLock(mContext);
        releaseWakeLock();
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
        NotificationManager notificationManager = (NotificationManager) MyApplication.getInstance().getSystemService(Context.NOTIFICATION_SERVICE);
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
