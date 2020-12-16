package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by Arvind on 3/27/2018.
 */

public class MontserratTextView extends android.support.v7.widget.AppCompatTextView {
    public MontserratTextView(Context context) {
        super(context);
        setTypeface(Typeface.createFromAsset(context.getAssets(), "montserrat_regular.ttf"));
    }

    public MontserratTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setTypeface(Typeface.createFromAsset(context.getAssets(), "montserrat_regular.ttf"));
    }

    public MontserratTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(Typeface.createFromAsset(context.getAssets(), "montserrat_regular.ttf"));
    }

}
