package com.gamebooster.hyperos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class logic extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        Button startOverlay = findViewById(R.id.btn_start_overlay);
        Button stopOverlay = findViewById(R.id.btn_stop_overlay);

        // START POPUP
        startOverlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent svc = new Intent(logic.this, popup_service.class);
                startService(svc);
            }
        });

        // STOP POPUP
        stopOverlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent svc = new Intent(logic.this, popup_service.class);
                stopService(svc);
            }
        });
    }
}