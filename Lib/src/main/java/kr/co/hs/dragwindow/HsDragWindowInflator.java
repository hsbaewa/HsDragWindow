package kr.co.hs.dragwindow;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import static android.content.Context.WINDOW_SERVICE;

/**
 * Created by privacydev on 2017. 4. 17..
 */

public class HsDragWindowInflator {

    private Context mContext;
    private HsDragWindowInflator(Context context){
        this.mContext = context;
    }


    public static final HsDragWindowInflator from(Context context){
        HsDragWindowInflator hsDragLinearLayout = new HsDragWindowInflator(context);
        return hsDragLinearLayout;
    }


    public static int getDP(Context context, int dp){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dp * scale + 0.5f);
    }


    public Context getContext() {
        return mContext;
    }

    public View inflate(int layout, ViewGroup viewGroup, int widthDP, int heightDP){
        final WindowManager windowManager = (WindowManager) getContext().getSystemService(WINDOW_SERVICE);
        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);


        final View view = LayoutInflater.from(mContext).inflate(layout, viewGroup);

        params.width = getDP(getContext(), widthDP);
        params.height = getDP(getContext(), heightDP);

        windowManager.addView(view, params);

        view.setOnTouchListener(new View.OnTouchListener() {
            private int initialX;
            private int initialY;
            private float initialTouchX;
            private float initialTouchY;

            @Override public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        initialX = params.x;
                        initialY = params.y;
                        initialTouchX = event.getRawX();
                        initialTouchY = event.getRawY();
                        return true;
                    case MotionEvent.ACTION_UP:
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        params.x = initialX + (int) (event.getRawX() - initialTouchX);
                        params.y = initialY + (int) (event.getRawY() - initialTouchY);
                        windowManager.updateViewLayout(view, params);
                        return true;
                }
                return false;
            }
        });

        return view;
    }



}
