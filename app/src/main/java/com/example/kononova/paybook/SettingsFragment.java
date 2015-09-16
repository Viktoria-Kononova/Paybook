package com.example.kononova.paybook;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SettingsFragment extends Fragment implements View.OnClickListener{
    private EditText lightTariffPre;
    private EditText coldWaterTariffPre;
    private EditText hotWaterTariffPre;
    private EditText lightStartPositionPre;
    private EditText coldWaterStartPositionPre;
    private EditText hotWaterStartPositionPre;
    private Button confirm;
    private MainFragment mainFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.settings, container, false);

        lightTariffPre = (EditText)rootView.findViewById(R.id.editTextLight);
        coldWaterTariffPre = (EditText)rootView.findViewById(R.id.editTextColdWater);
        hotWaterTariffPre = (EditText)rootView.findViewById(R.id.editTextHotWater);
        lightStartPositionPre = (EditText)rootView.findViewById(R.id.editTextLightPosition);
        coldWaterStartPositionPre = (EditText)rootView.findViewById(R.id.editTextColdWaterPosition);
        hotWaterStartPositionPre = (EditText)rootView.findViewById(R.id.editTextHotWaterPosition);

        lightTariffPre.setText(String.valueOf(Tariffs.getInstance().getLightTariff()));
        coldWaterTariffPre.setText(String.valueOf(Tariffs.getInstance().getColdWaterTariff()));
        hotWaterTariffPre.setText(String.valueOf(Tariffs.getInstance().getHotWaterTariff()));
        lightStartPositionPre.setText(String.valueOf(Tariffs.getInstance().getLightStartPosition()));
        coldWaterStartPositionPre.setText(String.valueOf(Tariffs.getInstance().getColdWaterStartPosition()));
        hotWaterStartPositionPre.setText(String.valueOf(Tariffs.getInstance().getHotWaterStartPosition()));

        confirm = (Button)rootView.findViewById(R.id.buttonConfirm);
        confirm.setOnClickListener(this);

        mainFragment = new MainFragment();

        return rootView;
    }

    @Override
    public void onClick(View v) {
        float lightTariff = Float.parseFloat(lightTariffPre.getText().toString());
        Tariffs.getInstance().setLightTariff(lightTariff);
        float coldWaterTariff = Float.parseFloat(coldWaterTariffPre.getText().toString());
        Tariffs.getInstance().setColdWaterTariff(coldWaterTariff);
        float hotWaterTariff = Float.parseFloat(hotWaterTariffPre.getText().toString());
        Tariffs.getInstance().setHotWaterTariff(hotWaterTariff);
        int lightStartPosition = Integer.parseInt(lightStartPositionPre.getText().toString());
        Tariffs.getInstance().setLightStartPosition(lightStartPosition);
        int coldWaterStartPosition = Integer.parseInt(coldWaterStartPositionPre.getText().toString());
        Tariffs.getInstance().setColdWaterStartPosition(coldWaterStartPosition);
        int hotWaterStartPosition = Integer.parseInt(hotWaterStartPositionPre.getText().toString());
        Tariffs.getInstance().setHotWaterStartPosition(hotWaterStartPosition);
        FragmentTransaction fragmentTransaction;
        fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, mainFragment);
        fragmentTransaction.commit();
    }
}
