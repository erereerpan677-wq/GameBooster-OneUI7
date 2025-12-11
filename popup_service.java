package com.gamebooster.hyperos;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

public class popup_service extends Service {

    private WindowManager wm;
    private View popupView;

    @Override
    public void onCreate() {
        super.onCreate();

        wm = (WindowManager) getSystemService(WINDOW_SERVICE);

        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.TOP | Gravity.LEFT;
        params.x = 50;
        params.y = 200;

        popupView = LayoutInflater.from(this).inflate(R.layout.popup_layout, null);

        wm.addView(popupView, params);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (popupView != null) wm.removeView(popupView);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
