package com.example.kononova.paybook.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.kononova.paybook.Utils;
import com.example.kononova.paybook.payment.IPay;
import com.example.kononova.paybook.payment.Pay;
import com.example.kononova.paybook.R;
import com.example.kononova.paybook.settings.Tariffs;

import java.lang.reflect.Field;
import java.util.Calendar;

public class AddRecordFragment extends DialogFragment implements View.OnClickListener {
    private Button dateDialogButton;
    private Button addPayButton;
    private Pay pay = new Pay();
    private final static String DATE_PICKER_DIALOG_TAG = "login_dialog";
    private IPay pays;
    private EditText light;
    private EditText coldWater;
    private EditText hotWater;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.add_record, container, false);

        dateDialogButton = (Button)rootView.findViewById(R.id.buttonDataDialog);
        addPayButton = (Button)rootView.findViewById(R.id.buttonAddPay);
        dateDialogButton.setOnClickListener(this);
        addPayButton.setOnClickListener(this);

        light = (EditText)rootView.findViewById(R.id.editTextLight);
        coldWater = (EditText)rootView.findViewById(R.id.editTextColdWater);
        hotWater = (EditText)rootView.findViewById(R.id.editTextHotWater);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonDataDialog:
                final Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog.OnDateSetListener mCallback = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int backYear, int backMonth, int backDay) {
                        String payDate = backDay + " " + backMonth + " " + backYear;
                        dateDialogButton.setText(payDate);
                        calendar.set(Calendar.YEAR, backYear);
                        calendar.set(Calendar.MONTH, backMonth);
                        calendar.set(Calendar.DAY_OF_MONTH, backDay);
                        pay.date = calendar.getTime().getTime();
                    }
                };
                DatePickerDialog dialog = new DatePickerDialog(getActivity(), mCallback, year, month, day);
                try {
                    Field f[] = dialog.getClass().getDeclaredFields();
                    for (Field field : f) {
                        if (field.getName().equals("mDatePicker")) {
                            field.setAccessible(true);
                            Object yearPicker = new Object();
                            yearPicker = field.get(dialog);
                            Field[] declaredFields = yearPicker.getClass().getDeclaredFields();
                            for (Field f1 : declaredFields){
                                Log.e("", f1.getName()+" " + f1.getType());
                                if (field.getName().equals("mDaySpinner")) {
                                    field.setAccessible(true);
                                    Object dayPicker = new Object();
                                    dayPicker = f1.get(yearPicker);
                                    ((View) dayPicker).setVisibility(View.GONE);
                                }
                            }
                        }
                    }
                }
                catch (SecurityException e) {
                    Log.d("ERROR", e.getMessage());
                }
                catch (IllegalArgumentException e) {
                    Log.d("ERROR", e.getMessage());
                }
                catch (IllegalAccessException e) {
                    Log.d("ERROR", e.getMessage());
                }
                dialog.setCancelable(true);
                //((ViewGroup) Dialog.getDatePicker()).findViewById(Resources.getSystem().getIdentifier("day", "id", "android")).setVisibility(View.GONE);
                dialog.setTitle(R.string.choose_period);
                dialog.show();
                break;
            case R.id.buttonAddPay:
                pay.lightEnd = Integer.parseInt(light.getText().toString());
                pay.coldWaterEnd = Integer.parseInt(coldWater.getText().toString());
                pay.hotWaterEnd = Integer.parseInt(hotWater.getText().toString());
                pay.calculate();
                pays.addPay(pay);
                Tariffs.getInstance().setLightPosition(pay.lightEnd);
                Tariffs.getInstance().setColdWaterPosition(pay.coldWaterEnd);
                Tariffs.getInstance().setHotWaterPosition(pay.hotWaterEnd);
                light.setText("");
                coldWater.setText("");
                hotWater.setText("");
                Utils.hideKeyboard(getContext(), view);
                getActivity().getSupportFragmentManager().popBackStack();
                break;
        }
    }

    public void setPays(IPay pays) {
        this.pays = pays;
    }
}
