package com.gamebooster.oneui7;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

public class popup_service extends Service {

    private WindowManager windowManager;
    private View popupView;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        popupView = LayoutInflater.from(this).inflate(R.layout.popup_layout, null);

        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.TOP | Gravity.RIGHT;
        params.x = 20;
        params.y = 150;

        windowManager.addView(popupView, params);

        popupView.setOnClickListener(v -> stopSelf());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (popupView != null) windowManager.removeView(popupView);
    }
                                     }
