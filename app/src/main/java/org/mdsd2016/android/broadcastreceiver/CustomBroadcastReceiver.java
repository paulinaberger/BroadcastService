package org.mdsd2016.android.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class CustomBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = CustomBroadcastReceiver.class.getSimpleName();
    public CustomBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i(CustomBroadcastReceiver.TAG, "Custom ACTION event caught");
        Toast.makeText(context, "Custom Action triggered", Toast.LENGTH_SHORT).show();


    }
}
