package com.example.kononova.paybook;

import android.content.SharedPreferences;

public class StorageTariff implements ITariff{
    private SharedPreferences sharedPreferences;
    public static final String APP_PREFERENCES_LIGHT = "lightTariff";
    public static final String APP_PREFERENCES_COLD_WATER = "coldWaterTariff";
    public static final String APP_PREFERENCES_HOT_WATER = "hotWaterTariff";
    public static final String APP_PREFERENCES_LIGHT_START = "lightStartPosition";
    public static final String APP_PREFERENCES_COLD_WATER_START = "coldWaterStartPosition";
    public static final String APP_PREFERENCES_HOT_WATER_START = "hotWaterStartPosition";


    public StorageTariff(SharedPreferences sharedPreferences){
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public float getLightTariff() {
        return sharedPreferences.getFloat(APP_PREFERENCES_LIGHT, 0);
    }

    @Override
    public void setLightTariff(float lightTariff) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(APP_PREFERENCES_LIGHT, lightTariff);
        editor.apply();
    }

    @Override
    public float getColdWaterTariff() {
        return sharedPreferences.getFloat(APP_PREFERENCES_COLD_WATER, 0);
    }

    @Override
    public void setColdWaterTariff(float coldWaterTariff) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(APP_PREFERENCES_COLD_WATER, coldWaterTariff);
        editor.apply();
    }

    @Override
    public float getHotWaterTariff() {
        return sharedPreferences.getFloat(APP_PREFERENCES_HOT_WATER, 0);
    }

    @Override
    public void setHotWaterTariff(float hotWaterTariff) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(APP_PREFERENCES_HOT_WATER, hotWaterTariff);
        editor.apply();
    }

    @Override
    public int getLightStartPosition() {
        return sharedPreferences.getInt(APP_PREFERENCES_LIGHT_START, 0);
    }

    @Override
    public void setLightStartPosition(int lightStartPosition) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(APP_PREFERENCES_LIGHT_START, lightStartPosition);
        editor.apply();
    }

    @Override
    public int getColdWaterStartPosition() {
        return sharedPreferences.getInt(APP_PREFERENCES_COLD_WATER_START, 0);
    }

    @Override
    public void setColdWaterStartPosition(int coldWaterStartPosition) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(APP_PREFERENCES_COLD_WATER_START, coldWaterStartPosition);
        editor.apply();
    }

    @Override
    public int getHotWaterStartPosition() {
        return sharedPreferences.getInt(APP_PREFERENCES_HOT_WATER_START, 0);
    }

    @Override
    public void setHotWaterStartPosition(int hotWaterStartPosition) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(APP_PREFERENCES_HOT_WATER_START, hotWaterStartPosition);
        editor.apply();
    }
}
