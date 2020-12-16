package com.tsr.tsrproblemreport_tossticket_checker.other_all.service;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.hwangjr.rxbus.RxBus;


/**
 * Created by teerayut.k on 1/12/2018.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";



    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    // [START refresh_token]
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
     //   sendRegistrationToServer(refreshedToken);
    }



    @Override
    public void onCreate() {
        super.onCreate();
        RxBus.get().register( this );
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister( this );
    }
}
