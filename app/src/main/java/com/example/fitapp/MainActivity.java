package com.example.fitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    // HaKi 07.02.2021 16:45 attribute area
    protected Vector<Exercise> exercises = new Vector<Exercise>();
    protected static final String EXERCISES = "com.example.fitapp.EXERCISES";
    protected EditText dateToday, dateToday2, dateToday3, dateToday4, dateToday5;
    protected EditText dofw, dofw2, dofw3, dofw4, dofw5;
    protected String dateText;
    protected String dayText;
    protected int td_Year, td_Month, td_Day;
    protected String td_Year_str, td_Month_str, td_Day_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // HaKi 08.02.2021 Grids + Date
        // Get EditTexts and set Line under Text to transparent
        dateToday = (EditText) findViewById(R.id.INP_DateToday);
        dateToday.setBackgroundResource(android.R.color.transparent);
        dateToday2 = (EditText) findViewById(R.id.INP_DateToday2);
        dateToday2.setBackgroundResource(android.R.color.transparent);
        dateToday3 = (EditText) findViewById(R.id.INP_DateToday3);
        dateToday3.setBackgroundResource(android.R.color.transparent);
        dateToday4 = (EditText) findViewById(R.id.INP_DateToday4);
        dateToday4.setBackgroundResource(android.R.color.transparent);
        dateToday5 = (EditText) findViewById(R.id.INP_DateToday5);
        dateToday5.setBackgroundResource(android.R.color.transparent);

        dofw = (EditText) findViewById(R.id.INP_DayOW);
        dofw.setBackgroundResource(android.R.color.transparent);
        dofw2 = (EditText) findViewById(R.id.INP_DayOW2);
        dofw2.setBackgroundResource(android.R.color.transparent);
        dofw3 = (EditText) findViewById(R.id.INP_DayOW3);
        dofw3.setBackgroundResource(android.R.color.transparent);
        dofw4 = (EditText) findViewById(R.id.INP_DayOW4);
        dofw4.setBackgroundResource(android.R.color.transparent);
        dofw5 = (EditText) findViewById(R.id.INP_DayOW5);
        dofw5.setBackgroundResource(android.R.color.transparent);

        // Get calendar for date
        Calendar calendar = Calendar.getInstance();

        // for 5 Grids
        for (int i = 0; i<= 4; i++){

            // Add number of grid to calender for days
            calendar.add(Calendar.DAY_OF_YEAR, i);

            // Calendar get year, month, day as int
            td_Year = calendar.get(Calendar.YEAR);
            td_Month = calendar.get(Calendar.MONTH);
            td_Day = calendar.get(Calendar.DAY_OF_MONTH);

            // Set year, month and day to strings
            td_Year_str = Integer.toString(td_Year);
            td_Month_str = Integer.toString((td_Month + 1));
            td_Day_str = Integer.toString(td_Day);

            // If length = 1 add a 0 -> 08 instead of 8
            if (td_Month_str.length() == 1){
                td_Month_str = "0" + td_Month_str;
            }

            if (td_Day_str.length() == 1){
                td_Day_str = "0" + td_Day_str;
            }

            // Create text of EditTexts
            dateText = " " +td_Day_str + "." + td_Month_str + "." + td_Year_str;

            td_Day = calendar.get(Calendar.DAY_OF_WEEK);

            switch (td_Day){
                case 1:
                    dayText = "Sunday";
                    break;
                case 2:
                    dayText = "Monday";
                    break;
                case 3:
                    dayText = "Tuesday";
                    break;
                case 4:
                    dayText = "Wednesday";
                    break;
                case 5:
                    dayText = "Thursday";
                    break;
                case 6:
                    dayText = "Friday";
                    break;
                case 7:
                    dayText = "Saturday";
                    break;
            }

            // Switch on which Grid
            switch (i){
                case 0:
                    dateToday.setText(dateText, TextView.BufferType.EDITABLE);
                    dofw.setText(dayText, TextView.BufferType.EDITABLE);
                    break;
                case 1:
                    dateToday2.setText(dateText, TextView.BufferType.EDITABLE);
                    dofw2.setText(dayText, TextView.BufferType.EDITABLE);
                    break;
                case 2:
                    dateToday3.setText(dateText, TextView.BufferType.EDITABLE);
                    dofw3.setText(dayText, TextView.BufferType.EDITABLE);
                    break;
                case 3:
                    dateToday4.setText(dateText, TextView.BufferType.EDITABLE);
                    dofw4.setText(dayText, TextView.BufferType.EDITABLE);
                    break;
                case 4:
                    dateToday5.setText(dateText, TextView.BufferType.EDITABLE);
                    dofw5.setText(dayText, TextView.BufferType.EDITABLE);
                    break;
            }


            // Calendar remove grid number
            calendar.add(Calendar.DAY_OF_YEAR, (i * -1));

        }

    }

    public void newExercise (View View){
        // HaKi 07.02.2021 16:15 - New Screen
        Intent intent = new Intent(this, NewExercise.class);
        intent.putExtra(EXERCISES, exercises);
        startActivity(intent);
    }

    public void splitPlans (View View){
        // HaKi 09.02.2021 21:20 - Split plans
        Intent intentSplit = new Intent(this, SplitPlans.class);
        startActivity(intentSplit);
    }
}