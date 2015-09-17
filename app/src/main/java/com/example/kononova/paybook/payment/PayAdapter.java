package com.example.kononova.paybook.payment;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kononova.paybook.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PayAdapter extends BaseAdapter {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM yyyy");
    private Context context;
    private IPay pays;
    private LayoutInflater layoutInflater;

    public PayAdapter(Context context, IPay pays){
        this.context = context;
        this.pays = pays;
        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return pays.getAll().length;
    }

    @Override
    public Object getItem(int position) {
        return pays.getAll()[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null){
            view = layoutInflater.inflate(R.layout.list_element, parent, false);
        }
        Pay pay = (Pay)getItem(position);

        TextView period = (TextView)view.findViewById(R.id.textViewPeriod);
        period.setText(simpleDateFormat.format(new Date(pay.date)));

        TextView monthPay = (TextView)view.findViewById(R.id.textViewMonthPay);
        monthPay.setText("" + (pay.lightPay + pay.coldWaterPay + pay.hotWaterPay));

        TextView lightPay = (TextView)view.findViewById(R.id.textViewLightPay);
        lightPay.setText("" + pay.lightPay);

        TextView coldWaterPay = (TextView)view.findViewById(R.id.textViewColdWaterPay);
        coldWaterPay.setText("" + pay.coldWaterPay);

        TextView hotWaterPay = (TextView)view.findViewById(R.id.textViewHotWaterPay);
        hotWaterPay.setText("" + pay.hotWaterPay);

        return view;
    }
}
