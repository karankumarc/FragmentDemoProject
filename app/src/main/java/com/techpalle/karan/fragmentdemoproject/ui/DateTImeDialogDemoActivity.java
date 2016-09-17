package com.techpalle.karan.fragmentdemoproject.ui;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.techpalle.karan.fragmentdemoproject.R;

import java.util.Calendar;

public class DateTimeDialogDemoActivity extends AppCompatActivity {

    private TextView textViewDate, textViewTime;
    private Button buttonDate, buttonTime;

    int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_dialog_demo);

        textViewDate = (TextView) findViewById(R.id.text_view_date);
        textViewTime = (TextView) findViewById(R.id.text_view_time);

        buttonDate = (Button) findViewById(R.id.button_select_date);
        buttonTime = (Button) findViewById(R.id.button_select_time);


        buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(DateTimeDialogDemoActivity.this,

                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                String strMonth = String.valueOf(month), strDay = String.valueOf(day), strYear = String.valueOf(year);

                                if(month<10){
                                    strMonth = "0"+strMonth;
                                }

                                if(day<10){
                                    strDay = "0"+strDay;
                                }

                                // Handle the data here
                                textViewDate.setText(strDay+ " - "+ strMonth+ " - "+ strYear);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });


        buttonTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mHour, mMinute;

                //Get the current time
                Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(DateTimeDialogDemoActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                String strHour = String.valueOf(hourOfDay);
                                if(hourOfDay<10){
                                    strHour = "0"+hourOfDay;
                                }

                                String strMinute = String.valueOf(minute);
                                if(minute<10){
                                    strMinute = "0"+minute;
                                }

                                // Handle data here
                                textViewTime.setText(strHour+" : "+strMinute);
                            }
                        }, mHour, mMinute, true);
                timePickerDialog.show();
            }
        });
    }
}
