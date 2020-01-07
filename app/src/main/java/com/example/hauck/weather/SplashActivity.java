package com.example.luara.desafiotruckpad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.luara.desafiotruckpad.ui.splash.SplashFragment;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, SplashFragment.newInstance())
                    .commitNow();
        }
    }
}
