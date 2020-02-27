package com.mahindra.task;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdPage extends AppCompatActivity {

    private View background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.do_not_move, R.anim.do_not_move);
        setContentView(R.layout.activity_third);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        background = findViewById(R.id.background);
        new CountDownTimer(1000, 100) {
            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                startActivity(new Intent(ThirdPage.this, FourthPage.class));
                finish();
            }
        }.start();
    }

    protected void onResume() {
        super.onResume();
        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
        /*startActivity(new Intent(ThirdPage.this, FourthPage.class));
        finish();*/
    }
}

