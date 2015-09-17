package com.example.kononova.paybook.settings;

public class MemoryTariff implements ITariff {
    private float lightTariff;
    private float coldWaterTariff;
    private float hotWaterTariff;
    private int lightPosition;
    private int coldWaterPosition;
    private int hotWaterPosition;

    @Override
    public float getLightTariff() {
        return lightTariff;
    }

    @Override
    public void setLightTariff(float lightTariff) {
        this.lightTariff = lightTariff;
    }

    @Override
    public float getColdWaterTariff() {
        return coldWaterTariff;
    }

    @Override
    public void setColdWaterTariff(float coldWaterTariff) {
        this.coldWaterTariff = coldWaterTariff;
    }

    @Override
    public float getHotWaterTariff() {
        return hotWaterTariff;
    }

    @Override
    public void setHotWaterTariff(float hotWaterTariff) {
        this.hotWaterTariff = hotWaterTariff;
    }

    @Override
    public int getLightPosition() {
        return lightPosition;
    }

    @Override
    public void setLightPosition(int lightPosition) {
        this.lightPosition = lightPosition;
    }

    @Override
    public int getColdWaterPosition() {
        return coldWaterPosition;
    }

    @Override
    public void setColdWaterPosition(int coldWaterPosition) {
        this.coldWaterPosition = coldWaterPosition;
    }

    @Override
    public int getHotWaterPosition() {
        return hotWaterPosition;
    }

    @Override
    public void setHotWaterPosition(int hotWaterPosition) {
        this.hotWaterPosition = hotWaterPosition;
    }
}
