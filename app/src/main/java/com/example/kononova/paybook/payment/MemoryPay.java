package com.example.kononova.paybook.payment;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MemoryPay implements IPay {
    public MemoryPay(){
        Pay p = new Pay();
        p.lightPay = 1;
        p.coldWaterPay = 2;
        p.hotWaterPay = 3;
        p.date = System.currentTimeMillis();
        addPay(p);
    }

    List<Pay> payList = new ArrayList<Pay>();
    @Override
    public Pay[] getAll() {
        return payList.toArray(new Pay[payList.size()]);
    }

    @Override
    public void addPay(Pay pay) {
        Log.e("", pay.toString());
        payList.add(pay);
    }
}
