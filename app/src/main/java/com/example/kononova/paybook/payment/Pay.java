package com.example.kononova.paybook.payment;

import com.example.kononova.paybook.settings.Tariffs;

public class Pay {
    public int id;
    public long date;
    public int lightBegining;
    public int lightEnd;
    public float lightPay;
    public int coldWaterBegining;
    public int coldWaterEnd;
    public float coldWaterPay;
    public int hotWaterBegining;
    public int hotWaterEnd;
    public float hotWaterPay;

    public void calculate(){
        lightPay = (lightEnd - Tariffs.getInstance().getLightPosition())*Tariffs.getInstance().getLightTariff();
        coldWaterPay = (coldWaterEnd - Tariffs.getInstance().getColdWaterPosition())*Tariffs.getInstance().getColdWaterTariff();
        hotWaterPay = (hotWaterEnd - Tariffs.getInstance().getHotWaterPosition())*Tariffs.getInstance().getHotWaterTariff();
    }

    @Override
    public String toString() {
        return "Pay{" +
                "id=" + id +
                ", date=" + date +
                ", lightBegining=" + lightBegining +
                ", lightEnd=" + lightEnd +
                ", lightPay=" + lightPay +
                ", coldWaterBegining=" + coldWaterBegining +
                ", coldWaterEnd=" + coldWaterEnd +
                ", coldWaterPay=" + coldWaterPay +
                ", hotWaterBegining=" + hotWaterBegining +
                ", hotWaterEnd=" + hotWaterEnd +
                ", hotWaterPay=" + hotWaterPay +
                '}';
    }
}
