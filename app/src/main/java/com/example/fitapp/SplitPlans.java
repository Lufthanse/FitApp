package com.example.fitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class SplitPlans extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutmanager;
    private ArrayList<SplitPlanItem> splitPlanItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split_plans);

        createSplitPlan();
        buildRecyclerView();

    }

    public void changeItem(int position, String text){
        splitPlanItems.get(position).changeText1(text);
        mAdapter.notifyItemChanged(position);
    }

    public void createSplitPlan(){
        splitPlanItems.add(new SplitPlanItem(R.drawable.ic_receipt, "Split 1", "Line2"));
        splitPlanItems.add(new SplitPlanItem(R.drawable.ic_receipt, "Split 2", "Line3"));
        splitPlanItems.add(new SplitPlanItem(R.drawable.ic_receipt, "Split 3", "Line4"));
        splitPlanItems.add(new SplitPlanItem(R.drawable.ic_receipt, "Split 4", "Line5"));
        splitPlanItems.add(new SplitPlanItem(R.drawable.ic_receipt, "Split 5", "Line6"));
        splitPlanItems.add(new SplitPlanItem(R.drawable.ic_receipt, "Split 6", "Line7"));
        splitPlanItems.add(new SplitPlanItem(R.drawable.ic_receipt, "Split 7", "Line8"));
        splitPlanItems.add(new SplitPlanItem(R.drawable.ic_receipt, "Split 8", "Line9"));
        splitPlanItems.add(new SplitPlanItem(R.drawable.ic_receipt, "Split 9", "Line0"));
        splitPlanItems.add(new SplitPlanItem(R.drawable.ic_receipt, "Split 0", "Line90"));


    }

    public void buildRecyclerView(){
        mRecyclerView = findViewById(R.id.RV_split_plan);
        mRecyclerView.setHasFixedSize(true);
        mLayoutmanager = new LinearLayoutManager(this);
        mAdapter = new RecyclerAdapter(splitPlanItems);

        mRecyclerView.setLayoutManager(mLayoutmanager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position, "clicked");
            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });
    }

    public void insertItem(int position) {
        splitPlanItems.add(position, new SplitPlanItem( R.drawable.ic_receipt, "New Item Line1", "This is line 2"));
        mAdapter.notifyItemInserted(position);
    }

    public void removeItem(int position) {
        splitPlanItems.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

}