package com.gamebooster.oneui7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * logic.java
 * Entry activity yang memulai overlay popup (HyperOS style)
 * Aman, ringan — hanya contoh UI / trigger overlay.
 */
public class logic extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); // pastikan layout.xml bernama main

        // Tombol contoh untuk mulai/stop overlay
        Button btnStart = findViewById(R.id.btn_start_overlay);
        Button btnStop  = findViewById(R.id.btn_stop_overlay);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(logic.this, overlay_service.class);
                startService(i);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(logic.this, overlay_service.class);
                stopService(i);
            }
        });
    }
}
