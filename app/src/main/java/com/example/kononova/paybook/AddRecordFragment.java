package com.example.kononova.paybook;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import java.lang.reflect.Field;
import java.util.Calendar;

public class AddRecordFragment extends DialogFragment implements View.OnClickListener {
    private Button dateDialogButton;
    private final static String DATE_PICKER_DIALOG_TAG = "login_dialog";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.add_record, container, false);

        dateDialogButton = (Button)rootView.findViewById(R.id.buttonDataDialog);
        dateDialogButton.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        final Calendar calendar = Calendar.getInstance();
        //calendar.setTimeInMillis(mStartDate);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog.OnDateSetListener mCallback = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int backYear, int backMonth, int backDay) {
                dateDialogButton.setText(backDay + " " + backMonth + " " + backYear);
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
    }
}
