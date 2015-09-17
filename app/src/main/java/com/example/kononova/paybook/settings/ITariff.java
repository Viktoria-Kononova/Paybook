package com.example.kononova.paybook.settings;

public interface ITariff {
    public float getLightTariff();

    public void setLightTariff(float lightTariff);

    public float getColdWaterTariff();

    public void setColdWaterTariff(float coldWaterTariff);

    public float getHotWaterTariff();

    public void setHotWaterTariff(float hotWaterTariff);

    public int getLightPosition();

    public void setLightPosition(int lightPosition);

    public int getColdWaterPosition();

    public void setColdWaterPosition(int coldWaterPosition);

    public int getHotWaterPosition();

    public void setHotWaterPosition(int hotWaterPosition);
}
