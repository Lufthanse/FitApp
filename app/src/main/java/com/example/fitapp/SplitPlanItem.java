package com.example.fitapp;

public class SplitPlanItem {
    private int mImageResource;
    private String mText1;
    private String mText2;

    public SplitPlanItem(int mImageResource, String mText1, String mTExt2){
        this.mImageResource = mImageResource;
        this.mText1 = mText2;
        this.mText2 = mTExt2;
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
}
