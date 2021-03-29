package com.thunderstudio.mylib.Views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.AttrRes;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.thunderstudio.mylib.INotifyPropertiesChanged;
import com.thunderstudio.mylib.R;


public class ChooseAmountLayout extends LinearLayout {
    private Observer<Float> observerNumber;
    private ChooseNumberLayoutController controller;

    private Context context;
    @SuppressLint("UseCompatLoadingForDrawables")
    public ChooseAmountLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        LinearLayout layout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.layout_choose_amount, this, true);
        EditText editText = findViewById(R.id.input_amount);
        ImageButton btnIncrease = findViewById(R.id.btn_increase);
        ImageButton btnDecrease = findViewById(R.id.btn_decrease);

        observerNumber = new Observer<Float>() {
            @Override
            public void onChanged(Float aFloat) {
                editText.setText(String.valueOf(aFloat));
            }
        };

        controller = new ChooseNumberLayoutController(1, 80, 1);
        btnIncrease.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.Increase();
            }
        });

        btnDecrease.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.Decrease();
            }
        });

        controller.setOnPropertyChanged(new INotifyPropertiesChanged() {
            @Override
            public void OnPropertyChanged(String propertyName) {
                editText.setText(String.valueOf((int)controller.getNumber()));
            }
        });

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ChooseAmountLayout);
        int drawable_increase =  a.getResourceId(R.styleable.ChooseAmountLayout_src_increase, R.color.design_default_color_error);
        int drawable_decrease =  a.getResourceId(R.styleable.ChooseAmountLayout_src_decrease, R.color.design_default_color_error);
        btnDecrease.setImageResource(drawable_decrease);
        btnIncrease.setImageResource(drawable_increase);
        a.recycle();
    }

    public class ChooseNumberLayoutController{
        public final float min;
        public final float max;
        public final float step;

        private float number;
        public float getNumber(){return  number;}

        private INotifyPropertiesChanged onPropertyChanged;

        public void setOnPropertyChanged(INotifyPropertiesChanged onPropertyChanged) {
            this.onPropertyChanged = onPropertyChanged;
        }

        public void setNumber(float val)
        {
            if(val > max){val = max;}
            if(val < min){val = min;}
            if(number != val)
            {
                number = val;
                onPropertyChanged.OnPropertyChanged("number");
            }
        }

        public void Increase()
        {
            setNumber(number+step);
        }

        public void Decrease()
        {
            setNumber(number-step);
        }

        public ChooseNumberLayoutController(float min, float max, float step)
        {
            this.min = min;
            this.max = max;
            this.step = step;

            number = min;

            onPropertyChanged = new INotifyPropertiesChanged() {
                @Override
                public void OnPropertyChanged(String propertyName) {
                    // TODO
                }
            };
        }
    }
}


