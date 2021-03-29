package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.thunderstudio.mylib.ChooseAmountFragmentViewModel;
import com.thunderstudio.mylib.databinding.FragmentChooseAmountBinding;

public class ChooseAmountLayout extends LinearLayout {

    public ChooseAmountLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        // Inflate and attach Layout-Resource it to this
        LayoutInflater.from(context).inflate(R.layout.fragment_choose_amount, this, true);

        @SuppressLint("CustomViewStyleable") TypedArray a = context.obtainStyledAttributes(R.styleable.ChooseAmountFragment);

        ImageButton btnIncrease = findViewById(R.id.btn_increase);
        ImageButton btnDecrease = findViewById(R.id.btn_decrease);

        a.recycle();
    }
}
