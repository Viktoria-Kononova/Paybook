package com.example.kononova.paybook;

public class Tariffs implements ITariff {
    private static Tariffs instance = null;

   /* private float lightTariff;
    private float coldWaterTariff;
    private float hotWaterTariff;
    private int lightStartPosition;
    private int coldWaterStartPosition;
    private int hotWaterStartPosition;*/

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
    public int getLightStartPosition() {
        return iTariff.getLightStartPosition();
    }

    @Override
    public void setLightStartPosition(int lightStartPosition) {
        this.iTariff.setLightStartPosition(lightStartPosition);
    }

    @Override
    public int getColdWaterStartPosition() {
        return iTariff.getColdWaterStartPosition();
    }

    @Override
    public void setColdWaterStartPosition(int coldWaterStartPosition) {
        this.iTariff.setColdWaterStartPosition(coldWaterStartPosition);
    }

    @Override
    public int getHotWaterStartPosition() {
        return iTariff.getHotWaterStartPosition();
    }

    @Override
    public void setHotWaterStartPosition(int hotWaterStartPosition) {
        this.iTariff.setHotWaterStartPosition(hotWaterStartPosition);
    }
}
