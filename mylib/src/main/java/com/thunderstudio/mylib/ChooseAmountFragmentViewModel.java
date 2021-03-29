package com.thunderstudio.mylib;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.util.Observable;

public class ChooseAmountFragmentViewModel extends BaseObservable {
    Integer amount;
    public int button_size;
    int maxAmount;
    int minAmount;

    @Bindable
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer val) {
        if(val < minAmount){val = minAmount;}
        if(val > maxAmount){val = maxAmount;}
        if(val != amount){
            amount = val;
        }
        notifyPropertyChanged(com.thunderstudio.mylib.BR.amount);
    }

    @Bindable
    public String getAmountString()
    {
        return getAmount().toString();
    }

    public void setAmountString(String val)
    {
        Integer integer;
        try
        {
            integer = Integer.parseInt(val);
        }
        catch (NumberFormatException exception)
        {
            Log.d("MY_TAG_ERROR", exception.getMessage());
            integer = minAmount;
        }

        setAmount(integer);
        notifyPropertyChanged(com.thunderstudio.mylib.BR.amountString);
    }

    public ChooseAmountFragmentViewModel()
    {
        amount = 1;
        minAmount = 1;
        maxAmount = 1000000;
        button_size = 79;
    }
}
