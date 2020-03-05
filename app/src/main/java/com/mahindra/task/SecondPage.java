package com.mahindra.task;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class SecondPage extends AppCompatActivity {

    private View background;
    ImageView btn,circle;
    Animation animUpDown;
    LinearLayout layout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.do_not_move, R.anim.do_not_move);
        setContentView(R.layout.activity_second);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        animUpDown = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.up_down);
        background = findViewById(R.id.background);
        circle = findViewById(R.id.circle);
        circle.setVisibility(View.VISIBLE);
        circle.startAnimation(animUpDown);
        background.setVisibility(View.INVISIBLE);
        btn = findViewById(R.id.imageView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondPage.this, ThirdPage.class));
                finish();
            }
        });

    }

    protected void onResume() {
        super.onResume();
        background.setVisibility(View.VISIBLE);
        btn.setVisibility(View.VISIBLE);
        overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
    }

}
