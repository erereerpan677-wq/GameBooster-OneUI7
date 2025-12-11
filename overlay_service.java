package com.gamebooster.oneui7;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.IBinder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * overlay_service.java
 * Service untuk menampilkan floating popup HyperOS-style.
 * Tidak mengubah setting sistem. Menggunakan TYPE_APPLICATION_OVERLAY (user harus beri izin Draw over apps).
 */
public class overlay_service extends Service {

    private WindowManager windowManager;
    private View floatView;
    private WindowManager.LayoutParams params;

    @Override
    public void onCreate() {
        super.onCreate();
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        floatView = LayoutInflater.from(this).inflate(R.layout.popup_layout, null);

        int layoutFlag;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            layoutFlag = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else {
            layoutFlag = WindowManager.LayoutParams.TYPE_PHONE;
        }

        params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                layoutFlag,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.TOP | Gravity.END;
        params.x = 50;
        params.y = 200;

        // allow drag
        floatView.setOnTouchListener(new View.OnTouchListener() {
            private int initialX, initialY;
            private float initialTouchX, initialTouchY;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        initialX = params.x;
                        initialY = params.y;
                        initialTouchX = event.getRawX();
                        initialTouchY = event.getRawY();
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        params.x = initialX - (int)(event.getRawX() - initialTouchX);
                        params.y = initialY + (int)(event.getRawY() - initialTouchY);
                        try { windowManager.updateViewLayout(floatView, params); } catch (Exception e) {}
                        return true;
                }
                return false;
            }
        });

        // contoh isi: tampilan FPS dummy + tombol boost (UI saja)
        TextView tv = floatView.findViewById(R.id.tv_popup_label);
        tv.setText("HYPER • BOOST");

        try { windowManager.addView(floatView, params); } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try { if (floatView != null) windowManager.removeView(floatView); } catch (Exception e) {}
    }

    @Override
    public IBinder onBind(Intent intent) { return null; }
}
