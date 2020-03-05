package com.mahindra.task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView btn, circle;
    private View background;
    Animation animUpDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        animUpDown = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.up_down);

        background = findViewById(R.id.background);
        circle = findViewById(R.id.circle);

        btn = findViewById(R.id.imageView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    int cx = background.getWidth() / 2;
                    int cy = background.getBottom() / 2;

                    float finalRadius = Math.max(background.getWidth() + 500, background.getHeight() + 500);
                    Animator circularReveal = ViewAnimationUtils.createCircularReveal(background, cx, cy, finalRadius, 160);

                    circularReveal.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animator) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {
                            background.setBackgroundColor(Color.WHITE);
                            circle.setVisibility(View.VISIBLE);
                            Intent i = new Intent(MainActivity.this, SecondPage.class);
                            startActivity(i);
                            finish();
                            //circle.startAnimation(animUpDown);
                            //finish();
                        }

                        @Override
                        public void onAnimationCancel(Animator animator) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animator) {

                        }
                    });
                    circularReveal.setDuration(2000);
                    circularReveal.start();
                }
                //startActivity(new Intent(MainActivity.this, SecondPage.class));
            }
        });

    }

    private int getDips(int dps) {
        Resources resources = getResources();
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dps,
                resources.getDisplayMetrics());
    }
}
