package com.example.kononova.paybook.settings;

import android.content.SharedPreferences;

import com.example.kononova.paybook.settings.ITariff;

public class StorageTariff implements ITariff {
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
    public int getLightPosition() {
        return sharedPreferences.getInt(APP_PREFERENCES_LIGHT_START, 0);
    }

    @Override
    public void setLightPosition(int lightStartPosition) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(APP_PREFERENCES_LIGHT_START, lightStartPosition);
        editor.apply();
    }

    @Override
    public int getColdWaterPosition() {
        return sharedPreferences.getInt(APP_PREFERENCES_COLD_WATER_START, 0);
    }

    @Override
    public void setColdWaterPosition(int coldWaterStartPosition) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(APP_PREFERENCES_COLD_WATER_START, coldWaterStartPosition);
        editor.apply();
    }

    @Override
    public int getHotWaterPosition() {
        return sharedPreferences.getInt(APP_PREFERENCES_HOT_WATER_START, 0);
    }

    @Override
    public void setHotWaterPosition(int hotWaterStartPosition) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(APP_PREFERENCES_HOT_WATER_START, hotWaterStartPosition);
        editor.apply();
    }
}
