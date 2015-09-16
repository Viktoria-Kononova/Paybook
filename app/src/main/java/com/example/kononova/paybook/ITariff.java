package com.example.kononova.paybook;

public interface ITariff {
    public float getLightTariff();

    public void setLightTariff(float lightTariff);

    public float getColdWaterTariff();

    public void setColdWaterTariff(float coldWaterTariff);

    public float getHotWaterTariff();

    public void setHotWaterTariff(float hotWaterTariff);

    public int getLightStartPosition();

    public void setLightStartPosition(int lightStartPosition);

    public int getColdWaterStartPosition();

    public void setColdWaterStartPosition(int coldWaterStartPosition);

    public int getHotWaterStartPosition();

    public void setHotWaterStartPosition(int hotWaterStartPosition);
}
