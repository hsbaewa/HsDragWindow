package kr.co.hs.dragwindow.sample;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * Created by privacydev on 2017. 4. 17..
 */

public class SampleActivity extends AppCompatActivity implements View.OnClickListener{


    private static final int RC_OVERLAY = 100;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);





        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)){
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:"+getPackageName()));
            startActivityForResult(intent, RC_OVERLAY);
        }else{
            Intent intent = new Intent(this, SampleService.class);
            intent.setAction("FLOAT");
            startService(intent);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case RC_OVERLAY:{


                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)){
                    finish();
                }else{
                    Intent intent = new Intent(this, SampleService.class);
                    intent.setAction("FLOAT");
                    startService(intent);
                }

                break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ButtonLeft:{
                Log.d("a","a");
                break;
            }
            case R.id.ButtonRight:{

                Log.d("a","a");

                break;
            }
        }
    }
}
