package com.thunderstudio.mylib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import java.util.jar.Attributes;

public class ChooseAmountView extends LinearLayout {

    Context context;

    public ChooseAmountView(Context context) {
        super(context);
        this.init(context, null);
    }

    public ChooseAmountView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.init(context, attrs);
    }

    public ChooseAmountView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init(context, attrs);
    }

    public ChooseAmountView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.init(context, attrs);
    }

    private void init(Context context, AttributeSet attributeSet)
    {
        this.context = context;
        if(attributeSet != null)
        {
            // get attrs
        }

    }


}
