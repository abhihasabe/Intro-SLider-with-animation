package com.mahindra.task;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Fifth extends AppCompatActivity {

    private View background;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.do_not_move, R.anim.do_not_move);
        setContentView(R.layout.activity_fifth);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        background = findViewById(R.id.backgroundss);
        imageView = findViewById(R.id.imageView);

        if (savedInstanceState == null) {

            final ViewTreeObserver viewTreeObserver = background.getViewTreeObserver();

            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

                    @Override
                    public void onGlobalLayout() {
                        circularRevealActivity();
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            background.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                    }

                });
            }
        }
        new CountDownTimer(3000, 100) {
            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                startActivity(new Intent(Fifth.this, Dashboard.class));
                finish();
            }
        }.start();
    }

    private void circularRevealActivity() {
        int cx = background.getRight() - getDips(44);
        int cy = background.getBottom() - getDips(44);

        float finalRadius = Math.max(background.getWidth(), background.getHeight());

        Animator circularReveal = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            circularReveal = ViewAnimationUtils.createCircularReveal(
                    background,
                    cx,
                    cy,
                    0,
                    finalRadius);
        }

        circularReveal.setDuration(3000);
        background.setVisibility(View.VISIBLE);
        circularReveal.start();

    }

    private int getDips(int dps) {
        Resources resources = getResources();
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dps,
                resources.getDisplayMetrics());
    }
}
