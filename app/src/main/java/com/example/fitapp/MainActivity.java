package com.example.fitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    // HaKi 07.02.2021 16:45 attribute area
    protected Vector<Exercise> exercises = new Vector<Exercise>();
    protected static final String EXERCISES = "com.example.fitapp.EXERCISES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void newExercise (View View){
        // HaKi 07.02.2021 16:15 - New Screen
        Intent intent = new Intent(this, NewExercise.class);
        intent.putExtra(EXERCISES, exercises);
        startActivity(intent);
    }
}