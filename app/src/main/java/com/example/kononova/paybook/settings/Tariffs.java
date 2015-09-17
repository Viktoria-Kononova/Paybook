package com.example.kononova.paybook.settings;

public class Tariffs implements ITariff {
    private static Tariffs instance = null;

    private ITariff iTariff;

    public void setTariff(ITariff iTariff) {
        this.iTariff = iTariff;
    }

    private Tariffs(){
    }

    public static Tariffs getInstance() {
        if (instance == null){
            instance = new Tariffs();
        }
        return instance;
    }

    @Override
    public float getLightTariff() {
        return iTariff.getLightTariff();
    }

    @Override
    public void setLightTariff(float lightTariff) {
        this.iTariff.setLightTariff(lightTariff);
    }

    @Override
    public float getColdWaterTariff() {
        return iTariff.getColdWaterTariff();
    }

    @Override
    public void setColdWaterTariff(float coldWaterTariff) {
        this.iTariff.setColdWaterTariff(coldWaterTariff);
    }

    @Override
    public float getHotWaterTariff() {
        return iTariff.getHotWaterTariff();
    }

    @Override
    public void setHotWaterTariff(float hotWaterTariff) {
        this.iTariff.setHotWaterTariff(hotWaterTariff);
    }

    @Override
    public int getLightPosition() {
        return iTariff.getLightPosition();
    }

    @Override
    public void setLightPosition(int lightStartPosition) {
        this.iTariff.setLightPosition(lightStartPosition);
    }

    @Override
    public int getColdWaterPosition() {
        return iTariff.getColdWaterPosition();
    }

    @Override
    public void setColdWaterPosition(int coldWaterStartPosition) {
        this.iTariff.setColdWaterPosition(coldWaterStartPosition);
    }

    @Override
    public int getHotWaterPosition() {
        return iTariff.getHotWaterPosition();
    }

    @Override
    public void setHotWaterPosition(int hotWaterStartPosition) {
        this.iTariff.setHotWaterPosition(hotWaterStartPosition);
    }
}
