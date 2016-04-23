package com.example.shuyun.jumpmenu;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

public class MainActivity extends Activity {

    private TopBar topBar;
    private TopMenu topMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topBar= (TopBar) findViewById(R.id.id_topbar);
        topMenu= (TopMenu) findViewById(R.id.topmenu);
        topMenu.setVisibility(View.GONE);

        topBar.setOnTopBarClickListener(new TopBar.topBarClickListener() {
            @Override
            public void leftClick() {
                menuOpen(topMenu);
            }

            @Override
            public void rightClick() {

            }
        });
        topMenu.setOnTopMenuClickListener(new TopMenu.topMenuClickListener() {
            @Override
            public void menuClick() {
                menuClose(topMenu);
            }
        });

    }

    public void menuOpen(View view) {
        topMenu.setVisibility(View.VISIBLE);
        topMenu.setClickable(true);
        /**
         * Setting rotate animation params
         * */
        RotateAnimation rotateAnimation = new RotateAnimation(-90, 0, (float) (DensityUtil.dip2px(getApplication(), 16) +
                0.5 * DensityUtil.dip2px(getApplication(), 24)), (float) (DensityUtil.dip2px(getApplication(), 16) + 0.5 * DensityUtil.dip2px(getApplication(), 24)));
        rotateAnimation.setDuration(625);
        rotateAnimation.setFillAfter(false);
        rotateAnimation.setInterpolator(new CustomizedInterpolator());
        view.startAnimation(rotateAnimation);
    }

    public void menuClose(View view) {
        /**
         * Setting rotate animation params
         * */
        RotateAnimation rotateAnimation = new RotateAnimation(0, -90, (float) (DensityUtil.dip2px(getApplication(), 16) +
                0.5 * DensityUtil.dip2px(getApplication(), 24)), (float) (DensityUtil.dip2px(getApplication(), 16) + 0.5 * DensityUtil.dip2px(getApplication(), 24)));
        rotateAnimation.setDuration(625);
        rotateAnimation.setFillAfter(false);
        rotateAnimation.setInterpolator(new CustomizedInterpolator());
        topMenu.startAnimation(rotateAnimation);
        topMenu.setVisibility(View.GONE);
    }

    public void finish(View view){
        finish();
    }

}
