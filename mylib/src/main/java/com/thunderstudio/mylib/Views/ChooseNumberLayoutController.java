package com.thunderstudio.mylib.Views;

import com.thunderstudio.mylib.OnValueChanged;

public class ChooseNumberLayoutController{

    public float min;
    public float max;
    public float step;

    private float number;
    public float getNumber(){return  number;}

    private OnValueChanged<Float> onValueChangedListener;

    public void setOnPropertyChanged(OnValueChanged<Float> onValueChanged) {
        this.onValueChangedListener = onValueChanged;
    }

    public void setNumber(float val)
    {
        if(val > max){val = max;}
        if(val < min){val = min;}
        if(number != val)
        {
            number = val;
            onValueChangedListener.onValueChanged(number);
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

        onValueChangedListener = newValue -> {
            //ToDO
        };
    }
}
