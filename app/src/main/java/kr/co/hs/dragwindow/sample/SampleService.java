package kr.co.hs.dragwindow.sample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import kr.co.hs.dragwindow.HsDragWindowInflator;

/**
 * Created by privacydev on 2017. 4. 17..
 */

public class SampleService extends Service {




    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String action = intent.getAction();

        switch (action){
            case "FLOAT":{

                View view = HsDragWindowInflator.from(getApplicationContext()).inflate(R.layout.overlay_menu, null, 200, 100);

                Button btnL = (Button) view.findViewById(R.id.ButtonLeft);
                Button btnR = (Button) view.findViewById(R.id.ButtonRight);

                btnL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("a","a");
                    }
                });
                btnR.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("a","a");
                    }
                });


                break;
            }
        }


        return START_STICKY;
    }
}
