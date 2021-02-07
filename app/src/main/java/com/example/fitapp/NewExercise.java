package com.example.fitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.Vector;

// HaKi 07.02.2021 16:30 created
// Add new Exercises

public class NewExercise extends AppCompatActivity {

    protected Vector<Exercise> exercises = new Vector<Exercise>(1000);
    protected String PopUpMessage = "The Exercise has been created";
    protected EditText name;
    protected EditText description;
    protected EditText howToLink;
    protected String nameText;
    protected String descriptionText;
    protected String howToLinkText;
    protected boolean fieldEmpty;
    protected String emptyMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_exercise2);

        // Get all existing exercises
        Intent intent = getIntent();
        if (intent.getParcelableExtra(MainActivity.EXERCISES) != null) {
            exercises = (Vector<Exercise>) intent.getParcelableExtra(MainActivity.EXERCISES);
        }
    }

    public void addExercise(View view){
        // HaKi 07.02.2021 19:08 Add new Exercise

        // clear fieldEmpty
        fieldEmpty = false;

        // get EditText's inputs
        name = (EditText) findViewById(R.id.INP_name);
        description = (EditText) findViewById(R.id.INP_description);
        howToLink = (EditText) findViewById(R.id.INP_explanatory_video);

        // get text from EditTexts
        nameText = name.getText().toString();
        descriptionText = description.getText().toString();
        howToLinkText = howToLink.getText().toString();

        // if field is empty
        if (nameText.equals("") || nameText == null){
            emptyMessage = "Please fill the name of the exercise";
            fieldEmpty = true;
        }

        if (descriptionText == null){
            descriptionText = "";
        }

        if (howToLinkText == null){
            howToLinkText = "";
        }

        if (fieldEmpty){
            View contextView_fe = findViewById(android.R.id.content);
            Snackbar snackbar_fe = Snackbar.make(contextView_fe, emptyMessage, Snackbar.LENGTH_SHORT);
            snackbar_fe.setActionTextColor(ContextCompat.getColor(getBaseContext(), R.color.design_default_color_error));
            View snackbarView_fe = snackbar_fe.getView();
            TextView textView_fe = snackbarView_fe.findViewById(R.id.snackbar_text);

            textView_fe.setTextColor(-65536);

            // Text alignment of snackbar
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                textView_fe.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            } else {
                // If android older version -> old syntax
                textView_fe.setGravity(Gravity.CENTER_HORIZONTAL);
            }
            // show snackbar
            snackbar_fe.show();
            return;
        }


        Exercise ex = new Exercise(nameText, descriptionText, howToLinkText);

        exercises.add(ex);

        // Popup Window "Exercise has been added"
        View contextView = findViewById(android.R.id.content);

        Snackbar snackbar = Snackbar.make(contextView, "Exercise has been added", Snackbar.LENGTH_SHORT);
        snackbar.setActionTextColor(ContextCompat.getColor(getBaseContext(), R.color.white));
        View snackbarView = snackbar.getView();

        // Create TextView to configure output text
        TextView textView = snackbarView.findViewById(R.id.snackbar_text);

        // Set text size
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

        // Text alignment of snackbar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        } else {
            // If android older version -> old syntax
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
        }
        // show snackbar
        snackbar.show();

        //Wait 3 seconds before go back to main
        (new Handler()).postDelayed(this::backToMain, 3000);

    }

    public void backToMain(){
        // HaKi 07.02.2021 22:22 go back to main view

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}