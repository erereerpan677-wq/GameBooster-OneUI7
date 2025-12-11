package com.gamebooster.oneui7;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class logic extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); // layout utama

        // Tombol mulai overlay
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