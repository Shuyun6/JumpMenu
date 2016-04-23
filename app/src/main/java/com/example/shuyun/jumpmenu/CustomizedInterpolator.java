package com.example.shuyun.jumpmenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.BounceInterpolator;

/**
 * Created by Shuyun on 4/23/2016/023.
 */
public class CustomizedInterpolator extends BounceInterpolator {
    public CustomizedInterpolator() {
    }

    @SuppressWarnings({"UnusedDeclaration"})
    public CustomizedInterpolator(Context context, AttributeSet attrs) {
    }

    private static float bounce(float t) {
        return t * t * 1.0f;
    }

    public float getInterpolation(float t) {
//        t *= 1.1226f;
//        if (t < 0.3535f) return bounce(t);
//        else if (t < 0.7408f) return bounce(t - 0.54719f) + 0.9f;
//        else if (t < 0.9644f) return bounce(t - 0.8526f) + 0.95f;
//        else return bounce(t - 1.0435f) + 0.98f;

        if (t < 0.5) return 4.0f * t * t;
        else if (t < 0.75) return 6.4f * bounce(t - 0.625f) + 0.9f;
        else if (t < 0.875) return 12.8f * bounce(t - 0.8125f) + 0.95f;
        else return 5.12f * bounce(t - 0.9375f) + 0.98f;

    }

}
