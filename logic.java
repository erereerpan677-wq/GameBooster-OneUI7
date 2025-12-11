package com.gamebooster.oneui7;

import android.app.Activity;
import android.os.Bundle;

public class logic extends Activity {

    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.main);

        // Basic booster example (dummy, aman, tidak modifikasi sistem)
        Runtime.getRuntime().gc();
    }
}
