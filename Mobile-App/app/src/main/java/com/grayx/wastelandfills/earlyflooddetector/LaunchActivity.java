package com.grayx.wastelandfills.earlyflooddetector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class LaunchActivity extends AppCompatActivity {
    Animation LogoAnim;
    ImageView Logo;

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        LogoAnim = AnimationUtils.loadAnimation(getBaseContext(),R.anim.logo);
        Logo =(ImageView) findViewById(R.id.imageLogo);
        Logo.startAnimation(LogoAnim);
        LogoAnim.setAnimationListener(new Animation.AnimationListener(){

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                /* New Handler to start the Menu-Activity
                 * and close this Splash-Screen after some seconds.*/
                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        /* Create an Intent that will start the Menu-Activity. */
                        Intent mainIntent = new Intent(LaunchActivity.this,OnboardActivity.class);
                        LaunchActivity.this.startActivity(mainIntent);
                        LaunchActivity.this.finish();
                    }
                }, SPLASH_DISPLAY_LENGTH);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
