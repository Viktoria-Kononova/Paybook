package com.example.kononova.paybook;

import java.util.Calendar;
import java.util.Date;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class DatePickerDialogFragment extends DialogFragment {

    private static final String DATEPICKER_DATE = "datepicker_date";

    private DatePickerDialog.OnDateSetListener mCallback;
    private long mStartDate;

    public DatePickerDialogFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        if (savedInstanceState != null) {
            mStartDate = savedInstanceState.getLong(DATEPICKER_DATE);
        }
    }

    @Override
    public void onDestroyView() {
        Dialog dialog = getDialog();
        if ((dialog != null) && getRetainInstance()) {
            dialog.setDismissMessage(null);
        }
        super.onDestroyView();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(DATEPICKER_DATE, mStartDate);
    }

    public DatePickerDialogFragment(long startDate, DatePickerDialog.OnDateSetListener callback) {
        this.mCallback = callback;
        if (startDate <= 0) {
            this.mStartDate = new Date().getTime();
        } else {
            this.mStartDate = startDate;
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(mStartDate);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(getActivity(), mCallback, year, month, day);
        dialog.setCancelable(true);
        dialog.show();
        return dialog;
    }
}