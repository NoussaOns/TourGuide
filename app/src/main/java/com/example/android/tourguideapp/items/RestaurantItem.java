package com.example.android.tourguideapp.items;

public class RestaurantItem {
    private int mImageResource;
    private String mTitle, mGeoCoor, mUrl, mPrice;

    public RestaurantItem(int imageResource, String title, String geoCoor, String url, String price) {
        mImageResource = imageResource;
        mTitle = title;
        mGeoCoor = geoCoor;
        mUrl = url;
        mPrice = price;
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

    public String getPrice() {
        return mPrice;
    }
}
