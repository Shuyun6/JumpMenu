package com.example.shuyun.jumpmenu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
/**
 * Created by Shuyun on 4/23/2016/023.
 */
public class TopBar extends RelativeLayout {

    public Button leftButton, rightButton;
    public ImageView leftImageView, rightImageView;
    public int leftButtonWidth, leftButtonHeight, rightButtonWidth, rightButtonHeight,
            leftImageViewWidth, leftImageViewHeight, rightImageViewWidth, rightImageViewHeight;
    public int rightButtonMarginLeft, rightButtonMarginTop, rightButtonMarginRight, rightButtonMarginBottom;
    public int rightImageViewMarginLeft, rightImageViewMarginTop, rightImageViewMarginRight, rightImageViewMarginBottom;
    private int leftButtonColor, leftButtonClickColor, rightButtonColor, rightButtonClickColor;
    private int leftButtonMarginLeft, leftButtonMarginTop, leftButtonMarginRight, leftButtonMarginBottom;
    private int leftImageViewMarginLeft, leftImageViewMarginTop, leftImageViewMarginRight, leftImageViewMarginBottom;
    private Drawable leftImageViewBackground, rightImageViewBackground;
    private TextView titleTextView;
    private String title;
    private float titleTextSize;
    private int titleTextColor;
    private int topBarbackgroundColor;

    private LayoutParams leftButtonParams, leftImageViewParams,
            rightButtonParams, rightImageViewParams, titleTextViewParams;

    private topBarClickListener listener;

    public TopBar(final Context context, AttributeSet attrs) {
        super(context, attrs);
        /**
         * Using TypedArray to get params from name space
         * */
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        leftImageViewBackground = typedArray.getDrawable(R.styleable.TopBar_leftImageViewBackground);
        leftButtonColor = typedArray.getColor(R.styleable.TopBar_leftButtonColor, 0);
        leftButtonClickColor = typedArray.getColor(R.styleable.TopBar_leftButtonClickColor, 0);

        rightImageViewBackground = typedArray.getDrawable(R.styleable.TopBar_rightImageViewBackground);
        rightButtonColor = typedArray.getColor(R.styleable.TopBar_rightButtonColor, 0);
        rightButtonClickColor = typedArray.getColor(R.styleable.TopBar_rightButtonClickColor, 0);

        leftButtonWidth = (int) typedArray.getDimension(R.styleable.TopBar_leftButtonWidth, 0);
        leftButtonHeight = (int) typedArray.getDimension(R.styleable.TopBar_leftButtonHeight, 0);
        rightButtonWidth = (int) typedArray.getDimension(R.styleable.TopBar_rightButtonWidth, 0);
        rightButtonHeight = (int) typedArray.getDimension(R.styleable.TopBar_rightButtonHeight, 0);

        leftButtonMarginLeft = (int) typedArray.getDimension(R.styleable.TopBar_leftButtonMarginLeft, 0);
        leftButtonMarginTop = (int) typedArray.getDimension(R.styleable.TopBar_leftButtonMarginTop, 0);
        leftButtonMarginRight = (int) typedArray.getDimension(R.styleable.TopBar_leftButtonMarginRight, 0);
        leftButtonMarginBottom = (int) typedArray.getDimension(R.styleable.TopBar_leftButtonMarginBottom, 0);
        leftImageViewWidth = (int) typedArray.getDimension(R.styleable.TopBar_leftImageViewWidth, 0);
        leftImageViewHeight = (int) typedArray.getDimension(R.styleable.TopBar_leftImageViewHeight, 0);
        leftImageViewMarginLeft = (int) typedArray.getDimension(R.styleable.TopBar_leftImageViewMarginLeft, 0);
        leftImageViewMarginTop = (int) typedArray.getDimension(R.styleable.TopBar_leftImageViewMarginTop, 0);
        leftImageViewMarginRight = (int) typedArray.getDimension(R.styleable.TopBar_leftImageViewMarginRight, 0);
        leftImageViewMarginBottom = (int) typedArray.getDimension(R.styleable.TopBar_leftImageViewMarginBottom, 0);

        rightButtonMarginLeft = (int) typedArray.getDimension(R.styleable.TopBar_rightButtonMarginLeft, 0);
        rightButtonMarginTop = (int) typedArray.getDimension(R.styleable.TopBar_rightButtonMarginTop, 0);
        rightButtonMarginRight = (int) typedArray.getDimension(R.styleable.TopBar_rightButtonMarginRight, 0);
        rightButtonMarginBottom = (int) typedArray.getDimension(R.styleable.TopBar_rightButtonMarginBottom, 0);
        rightImageViewWidth = (int) typedArray.getDimension(R.styleable.TopBar_rightImageViewWidth, 0);
        rightImageViewHeight = (int) typedArray.getDimension(R.styleable.TopBar_rightImageViewHeight, 0);
        rightImageViewMarginLeft = (int) typedArray.getDimension(R.styleable.TopBar_rightImageViewMarginLeft, 0);
        rightImageViewMarginTop = (int) typedArray.getDimension(R.styleable.TopBar_rightImageViewMarginTop, 0);
        rightImageViewMarginRight = (int) typedArray.getDimension(R.styleable.TopBar_rightImageViewMarginRight, 0);
        rightImageViewMarginBottom = (int) typedArray.getDimension(R.styleable.TopBar_rightImageViewMarginBottom, 0);

        title = typedArray.getString(R.styleable.TopBar_mtitle);
        titleTextColor = typedArray.getColor(R.styleable.TopBar_mtitleTextColor, 0);
        titleTextSize = typedArray.getDimension(R.styleable.TopBar_mtitleTextSize, 0);

        topBarbackgroundColor = typedArray.getColor(R.styleable.TopBar_topBarBackgroundColor, 0);

        typedArray.recycle();

        leftButton = new Button(context);
        rightButton = new Button(context);
        leftImageView = new ImageView(context);
        rightImageView = new ImageView(context);
        titleTextView = new TextView(context);

        leftButton.setBackgroundColor(leftButtonColor);
        rightButton.setBackgroundColor(rightButtonColor);
        leftImageView.setBackground(leftImageViewBackground);
        rightImageView.setBackground(rightImageViewBackground);
        titleTextView.setText(title);
        titleTextView.setTextSize(titleTextSize);
        titleTextView.setTextColor(titleTextColor);
        titleTextView.setGravity(Gravity.CENTER);

        setBackgroundColor(topBarbackgroundColor);

        leftButtonParams = new LayoutParams(leftButtonWidth, leftButtonHeight);
        leftButtonParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        leftButtonParams.setMargins(leftButtonMarginLeft, leftButtonMarginTop, leftButtonMarginRight, leftButtonMarginBottom);
        addView(leftButton, leftButtonParams);

        leftImageViewParams = new LayoutParams(leftImageViewWidth, leftImageViewHeight);
        leftImageViewParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        leftImageViewParams.setMargins(leftImageViewMarginLeft, leftImageViewMarginTop, leftImageViewMarginRight, leftImageViewMarginBottom);
        addView(leftImageView, leftImageViewParams);

        rightButtonParams = new LayoutParams(rightButtonWidth, rightButtonHeight);
        rightButtonParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        rightButtonParams.setMargins(rightButtonMarginLeft, rightButtonMarginTop, rightButtonMarginRight, rightButtonMarginBottom);
        addView(rightButton, rightButtonParams);

        rightImageViewParams = new LayoutParams(rightImageViewWidth, rightButtonHeight);
        rightImageViewParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        rightImageViewParams.setMargins(rightImageViewMarginLeft, rightImageViewMarginTop, rightImageViewMarginRight, rightImageViewMarginBottom);
        addView(rightImageView, rightImageViewParams);

        titleTextViewParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        titleTextViewParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(titleTextView, titleTextViewParams);

        leftButton.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                    v.setBackgroundColor(leftButtonClickColor);
                else if (event.getAction() == MotionEvent.ACTION_UP) {
                    v.setBackgroundColor(leftButtonColor);
                    listener.leftClick();
                }
                return false;
            }
        });

        rightButton.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                    v.setBackgroundColor(rightButtonClickColor);
                else if (event.getAction() == MotionEvent.ACTION_UP) {
                    v.setBackgroundColor(rightButtonColor);
                    listener.rightClick();
                }
                return false;
            }
        });

    }

    public void setOnTopBarClickListener(topBarClickListener listener) {
        this.listener = listener;
    }

    /**
     * Open an interface for setting click listener
     * */
    public interface topBarClickListener {
        void leftClick();
        void rightClick();
    }
}
