package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BroadcastReceiverOnBootComplete extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equalsIgnoreCase(Intent.ACTION_VOICE_COMMAND)) {
                Intent serviceIntent = new Intent(context, UI_CARDVIEW_DATA_CEDIT_report_problem1.class);
            context.startActivity(serviceIntent);
        }

    }


}

