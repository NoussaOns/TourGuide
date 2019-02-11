package com.example.android.tourguideapp.items;

public class ShoppingItem {
    private int mImageResource;
    private String mTitle, mGeoCoor, mUrl;

    public ShoppingItem(int imageResource, String title, String geoCoor, String url) {
        mImageResource = imageResource;
        mTitle = title;
        mGeoCoor = geoCoor;
        mUrl = url;
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

    public String getUrl() {
        return mUrl;
    }

}
