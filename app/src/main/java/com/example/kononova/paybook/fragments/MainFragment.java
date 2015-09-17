package com.example.kononova.paybook.fragments;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.kononova.paybook.payment.IPay;
import com.example.kononova.paybook.payment.MemoryPay;
import com.example.kononova.paybook.payment.PayAdapter;
import com.example.kononova.paybook.R;

public class MainFragment extends Fragment implements View.OnClickListener {
    private ImageView settingsButton;
    private ImageView addButton;
    private IPay iPay;
    private ListView listElement;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_fragment, container, false);
        settingsButton = (ImageView)rootView.findViewById(R.id.imageViewSettings);
        addButton = (ImageView)rootView.findViewById(R.id.imageViewAdd);

        settingsButton.setOnClickListener(this);
        addButton.setOnClickListener(this);

        iPay = new MemoryPay();

        listElement = (ListView)rootView.findViewById(R.id.listView);
        PayAdapter payAdapter = new PayAdapter(getContext(), iPay);
        listElement.setAdapter(payAdapter);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction;
        fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.imageViewSettings:
                fragmentTransaction.add(R.id.container, new SettingsFragment());
                break;
            case R.id.imageViewAdd:
                AddRecordFragment addRecordFragment = new AddRecordFragment();
                addRecordFragment.setPays(iPay);
                fragmentTransaction.add(R.id.container, addRecordFragment);
                break;
            default:
                break;
        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
