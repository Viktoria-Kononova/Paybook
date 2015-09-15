package com.example.kononova.paybook;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainFragment extends Fragment implements View.OnClickListener {
    ImageView settingsButton;
    ImageView addButton;
    SettingsFragment settingsFragment;
    AddRecordFragment addRecordFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_fragment, container, false);
        settingsButton = (ImageView)rootView.findViewById(R.id.imageViewSettings);
        addButton = (ImageView)rootView.findViewById(R.id.imageViewAdd);

        settingsFragment = new SettingsFragment();
        addRecordFragment = new AddRecordFragment();

        settingsButton.setOnClickListener(this);
        addButton.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction;
        fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.imageViewSettings:
                fragmentTransaction.add(R.id.container, settingsFragment);
                break;
            case R.id.imageViewAdd:
                fragmentTransaction.add(R.id.container, addRecordFragment);
                break;
            default:
                break;
        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
