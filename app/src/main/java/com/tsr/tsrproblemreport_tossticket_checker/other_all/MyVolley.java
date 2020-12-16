package com.tsr.tsrproblemreport_tossticket_checker.other_all;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Belal on 13/10/16.
 */

public class MyVolley {

    private static MyVolley mInstance;
    private static MyVolley mInstance2;
    private RequestQueue mRequestQueue;
    private RequestQueue mRequestQueue2;
    public static Context mCtx;

    private MyVolley(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();
        mRequestQueue2 = getRequestQueue2();
    }

    public static synchronized MyVolley getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new MyVolley(context);
        }
        return mInstance;
    }

    public static synchronized MyVolley getInstance2(Context context) {
        if (mInstance2 == null) {
            mInstance2 = new MyVolley(context);
        }
        return mInstance2;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }


    public RequestQueue getRequestQueue2() {
        if (mRequestQueue2 == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue2 = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue2;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue2(Request<T> req) {
        getRequestQueue2().add(req);
    }
}