package com.example.kononova.paybook;

public class MemoryTariff implements ITariff {
    private float lightTariff;
    private float coldWaterTariff;
    private float hotWaterTariff;
    private int lightStartPosition;
    private int coldWaterStartPosition;
    private int hotWaterStartPosition;

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
    public int getLightStartPosition() {
        return lightStartPosition;
    }

    @Override
    public void setLightStartPosition(int lightStartPosition) {
        this.lightStartPosition = lightStartPosition;
    }

    @Override
    public int getColdWaterStartPosition() {
        return coldWaterStartPosition;
    }

    @Override
    public void setColdWaterStartPosition(int coldWaterStartPosition) {
        this.coldWaterStartPosition = coldWaterStartPosition;
    }

    @Override
    public int getHotWaterStartPosition() {
        return hotWaterStartPosition;
    }

    @Override
    public void setHotWaterStartPosition(int hotWaterStartPosition) {
        this.hotWaterStartPosition = hotWaterStartPosition;
    }
}
