package org.mdsd2016.android.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = CustomBroadcastReceiver.class.getSimpleName();
    private BroadcastReceiver myLocalReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnStartService = (Button) findViewById(R.id.btnTrigBroadcast);
        btnStartService.setOnClickListener(this);

        final Button btnStartService2 = (Button) findViewById(R.id.btnTrigLocalBroadcast);
        btnStartService2.setOnClickListener(this);
    }

    @Override
    public void onResume(){

        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(this.myLocalReceiver,
            new IntentFilter("org.mdsd2016.android.dummybroadcastmessage.CUSTOM_ACTION"));

    }

    @Override
    public void onPause(){
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.myLocalReceiver);
    }

    @Override
    public void onClick(View whichView) {

        if(whichView.getId() == R.id.btnTrigBroadcast) {
            Log.i(MainActivity.TAG, "upper button clicked");

            Intent customBroadcastIntent = new Intent();
            customBroadcastIntent.setAction("org.mdsd2016.android.dummybroadcastmessage.CUSTOM_ACTION");
            sendBroadcast(customBroadcastIntent);
        }else if (whichView.getId() == R.id.btnTrigLocalBroadcast){
            Log.i(MainActivity.TAG, "this btn has been clicked");

 //           Intent BroadcastIntentTwo = new Intent();
 //           startService(BroadcastIntentTwo);

            LocalBroadcastManager.getInstance(this).sendBroadcast(
                new Intent().setAction("org.mdsd2016.android.dummybroadcastmessage.CUSTOM_ACTION"));
            };

        }

 //       case R.id.btnTrigBroadcast:
 //       Log.i(MainActivity.TAG, "Custom Broadcast Service has been clicked");

 //       Intent which = new Intent(this, CustomBroadcastReceiver.class);
  //      startService();

  //      break;

};




