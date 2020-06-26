package com.pro.movie.ui.app.splash;

import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.pro.movie.ui.app.dashboard.DashBoardActivity;
import com.pro.movie.utils.helper.Constants;


public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                DashBoardActivity.runActivity(SplashActivity.this);
                finish();
            }
        }, Constants.Default.SPLASH_DELAY_TIME);
    }
}
