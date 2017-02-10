package org.mdsd2016.android.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SystemBroadCastReceiver extends BroadcastReceiver {
    private static final String TAG = SystemBroadCastReceiver.class.getSimpleName();

    public SystemBroadCastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        switch (intent.getAction()){
            case Intent.ACTION_BATTERY_LOW:
                Log.v(SystemBroadCastReceiver.TAG, "Battery Low!!");

                break;
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                Log.v(SystemBroadCastReceiver.TAG, "Airplane Mode");

                break;
            default:

        }



    }
}
