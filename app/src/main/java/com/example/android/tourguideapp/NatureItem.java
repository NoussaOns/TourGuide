package com.example.android.tourguideapp;

public class NatureItem {
    private int mImageResource;
    private String mTitle, mGeoCoor;

    public NatureItem(int imageResource, String title, String geoCoor) {
        mImageResource = imageResource;
        mTitle = title;
        mGeoCoor = geoCoor;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public String getTitle() {
        return mTitle;
    }


    public String getGeoCoor() {
        return mGeoCoor;
    }
}
