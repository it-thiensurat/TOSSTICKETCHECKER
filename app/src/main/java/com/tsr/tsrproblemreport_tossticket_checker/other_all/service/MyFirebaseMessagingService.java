package com.tsr.tsrproblemreport_tossticket_checker.other_all.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
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
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;


import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.MusicActivity_Credit;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.nontification.NotificationUtils_sale_from_cedit;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;


/**
 * Created by teerayut.k on 1/12/2018.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";
    private NotificationUtils_sale_from_cedit notificationUtils_sale_from_cedit;
    private Context mContext;
    String nontification;
     int icon = R.drawable.browser;
    public MyFirebaseMessagingService(Context mContext) {
        this.mContext = mContext;
    }
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.d(TAG, "From: " + remoteMessage.getFrom());

        RemoteMessage.Notification notification = remoteMessage.getNotification();
        Map<String, String> data = remoteMessage.getData();

        handleNow(notification, data);




        if (remoteMessage.getData().size() > 0) {


            try {
                JSONObject json = new JSONObject(remoteMessage.getData().toString());
                handleDataMessage_sale_from_cedit(json);

            } catch (Exception e) {

            }
        }



    }

    private void handleNow(RemoteMessage.Notification notification, Map<String, String> data) {
        Log.d(TAG, "Short lived task is done.");
        try {
            sendNotification(notification, data);
        } catch (IOException e) {
            Log.e(TAG, String.valueOf(e));
        }
    }

    /**
     * Create and show a simple notification containing the received FCM message.
     *
     * @param data FCM message body received.
     */
    private void sendNotification(RemoteMessage.Notification notification, Map<String, String> data) throws IOException {
        String title;
        String body;
        if (notification != null) {
            title = notification.getTitle();
            body = notification.getBody();
        } else {
            title = data.get("title");
            body = data.get("body");
        }

        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        Intent intent = new Intent(this, MusicActivity_Credit.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(false)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setContentIntent(pendingIntent)
                .setLargeIcon(icon)
                .setColor(Color.RED)
                .setBadgeIconType(R.drawable.ic_add_circle_black_24dp)
                //.setShowWhen( false )
                .setSmallIcon(R.mipmap.ic_launcher);

        String image_url = data.get("image_url");
        if (image_url != null && image_url.length() != 0) {
            URL url = new URL(image_url);
            Bitmap bigPicture = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            notificationBuilder.setStyle(
                    new NotificationCompat.BigPictureStyle().bigPicture(bigPicture).setSummaryText(body)
            );
        }

        notificationBuilder.setDefaults(Notification.DEFAULT_VIBRATE);
        notificationBuilder.setLights(Color.BLUE, 1000, 300);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());
    }


    private void handleDataMessage_sale_from_cedit(JSONObject json) {
        try {
            JSONObject data2 = json.getJSONObject("data2");

            String title = data2.getString("title_sale_from_cedit");
            String message = data2.getString("message_sale_from_cedit");
            String timestamp = data2.getString("timestamp_sale_from_cedit");
            String image_cedit = data2.getString("image_cedit_sale_from_cedit");
        }
        catch (Exception ex){

        }
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://devahoy.com/posts/android-notification/"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Notification notification =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("DevAhoy News")
                        .setContentText("สวัสดีครับ ยินดีต้อนรับเข้าสู่บทความ Android Notification :)")
                        .setAutoCancel(true)
                        .setContentIntent(pendingIntent)
                        .build();

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1000, notification);
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

    private void showNotificationMessage_sale_from_cedit(Context context, String title, String message,String image_cedit,String timeStamp, Intent intent) {
        notificationUtils_sale_from_cedit = new NotificationUtils_sale_from_cedit(context);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        notificationUtils_sale_from_cedit.showNotificationMessage_sale_from_cedit(title, message,image_cedit, timeStamp, intent);
    }
}
