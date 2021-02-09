package com.example.fitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class SplitPlans extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split_plans);

        ArrayList<SplitPlanItem> splitPlanItems = new ArrayList<>();
        splitPlanItems.add(new SplitPlanItem(R.drawable.ic_receipt, "Split 1", "Line2"));
        splitPlanItems.add(new SplitPlanItem(R.drawable.ic_receipt, "Split 2", "Line3"));
    }
}