package com.example.shuyun.jumpmenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by Shuyun on 4/23/2016/023.
 */
public class TopMenu extends RelativeLayout {

    public Button menuButton;
    private ImageView menuImageView;
    private LayoutParams menuButtonParams, menuImageViewParams;

    private LayoutInflater inflater;
    private View view;

    private topMenuClickListener listener;

    public TopMenu(Context context, AttributeSet attrs) {
        super(context, attrs);

        menuButton = new Button(context);
        menuImageView = new ImageView(context);

        setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        menuButton.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                    v.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                else if (event.getAction() == MotionEvent.ACTION_UP) {
                    v.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    listener.menuClick();
                }
                return false;
            }
        });

        menuButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        menuButtonParams = new LayoutParams(DensityUtil.dip2px(context, 48), DensityUtil.dip2px(context, 48));
        menuButtonParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        menuButtonParams.setMargins(DensityUtil.dip2px(context, 4), DensityUtil.dip2px(context, 4),
                DensityUtil.dip2px(context, 4), DensityUtil.dip2px(context, 4));
        addView(menuButton, menuButtonParams);

        menuImageView.setBackground(getResources().getDrawable(R.drawable.ic_menu));
        menuImageViewParams = new LayoutParams(DensityUtil.dip2px(context, 24), DensityUtil.dip2px(context, 24));
        menuImageViewParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        menuImageViewParams.setMargins(DensityUtil.dip2px(context, 16), DensityUtil.dip2px(context, 16), DensityUtil.dip2px(context, 16), DensityUtil.dip2px(context, 16));
        addView(menuImageView, menuImageViewParams);

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.topmenu_layout, null);
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        layoutParams.setMargins(0, DensityUtil.dip2px(context, 48), 0, 0);
        addView(view, layoutParams);

    }

    public void setOnTopMenuClickListener(topMenuClickListener listener) {
        this.listener = listener;
    }

    /**
     * Open an interface for setting click listener
     * */
    public interface topMenuClickListener {
        void menuClick();
    }

}
