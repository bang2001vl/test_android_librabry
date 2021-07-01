package com.thunderstudio.mylib.Views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.AttrRes;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.Observer;

import com.thunderstudio.mylib.INotifyPropertiesChanged;
import com.thunderstudio.mylib.OnValueChanged;
import com.thunderstudio.mylib.R;


public class ChooseAmountLayout extends LinearLayout {
    public ChooseNumberLayoutController controller;

    private final Context context;
    public EditText editText;
    public ImageButton btnIncrease;
    public ImageButton btnDecrease;
    public LinearLayout layout;

    @SuppressLint("UseCompatLoadingForDrawables")
    public ChooseAmountLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        layout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.layout_choose_amount, this, false);
        editText = layout.findViewById(R.id.input_amount);
        btnIncrease = layout.findViewById(R.id.btn_increase);
        btnDecrease = layout.findViewById(R.id.btn_decrease);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ChooseAmountLayout);

        int buttonSize = a.getDimensionPixelOffset(R.styleable.ChooseAmountLayout_button_size, getResources().getDimensionPixelSize(R.dimen.normal_button_size));
        int drawable_increase = a.getResourceId(R.styleable.ChooseAmountLayout_src_increase, R.mipmap.ic_plus);
        int drawable_decrease = a.getResourceId(R.styleable.ChooseAmountLayout_src_decrease, R.mipmap.ic_minus);

        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) btnDecrease.getLayoutParams();
        params.width = params.height = buttonSize;
        btnDecrease.setLayoutParams(params);

        params = (LinearLayout.LayoutParams) btnIncrease.getLayoutParams();
        params.width = params.height = buttonSize;
        btnIncrease.setLayoutParams(params);

        btnDecrease.setImageResource(drawable_decrease);
        btnIncrease.setImageResource(drawable_increase);

        float min = a.getFloat(R.styleable.ChooseAmountLayout_minValue, 1f);
        float max = a.getFloat(R.styleable.ChooseAmountLayout_maxValue, 10f);
        float step = a.getFloat(R.styleable.ChooseAmountLayout_stepValue, 1f);

        controller = new ChooseNumberLayoutController(min, max, step);

        btnIncrease.setOnClickListener(v -> controller.Increase());

        btnDecrease.setOnClickListener(v -> controller.Decrease());

        controller.setOnPropertyChanged(propertyName ->
                editText.setText(String.valueOf((int) controller.getNumber())));

        a.recycle();
        this.addView(layout, layout.getLayoutParams());
    }
}



