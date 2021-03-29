package com.thunderstudio.mylib;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.thunderstudio.mylib.databinding.FragmentChooseAmountBinding;

public class ChooseAmountFragment extends Fragment {

    ImageButton btnIncrease;
    ImageButton btnDecrease;

    int btn_size;

    public ChooseAmountFragment()
    {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choose_amount, container, false);
        this.btnIncrease = view.findViewById(R.id.btn_increase);
        this.btnDecrease = view.findViewById(R.id.btn_decrease);

        this.btnIncrease.getLayoutParams().height = this.btnIncrease.getLayoutParams().width = btn_size;
        this.btnDecrease.getLayoutParams().height = this.btnDecrease.getLayoutParams().width = btn_size;
        return view;
    }

    @Override
    public void onInflate(@NonNull Context context, @NonNull AttributeSet attrs, @Nullable Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ChooseAmountFragment);
        btn_size = a.getDimensionPixelSize(R.styleable.ChooseAmountFragment_button_size, 20);
        Log.d("MY_TAG", String.valueOf(btn_size));

        a.recycle();
    }
}
