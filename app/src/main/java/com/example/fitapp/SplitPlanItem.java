package com.example.fitapp;

public class SplitPlanItem {
    private int mImageResource;
    private String mText1;
    private String mText2;

    public SplitPlanItem(int mImageResource, String mText1, String mText2){
        this.mImageResource = mImageResource;
        this.mText1 = mText1;
        this.mText2 = mText2;
    }


    public int getmImageResource(){
        return mImageResource;
    }

    public String getText1(){
        return mText1;
    }

    public  String getText2(){
        return mText2;
    }

    public void changeText1(String text){
        this.mText1 = text;
    }
}
