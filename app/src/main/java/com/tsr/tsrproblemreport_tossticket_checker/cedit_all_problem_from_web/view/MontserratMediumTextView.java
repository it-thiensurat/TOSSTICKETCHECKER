package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class MontserratMediumTextView extends android.support.v7.widget.AppCompatTextView {
    public MontserratMediumTextView(Context context) {
        super(context);
        setTypeface(Typeface.createFromAsset(context.getAssets(), "Montserrat_Medium.ttf"));
    }

    public MontserratMediumTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setTypeface(Typeface.createFromAsset(context.getAssets(), "Montserrat_Medium.ttf"));
    }

    public MontserratMediumTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(Typeface.createFromAsset(context.getAssets(), "Montserrat_Medium.ttf"));
    }

}
