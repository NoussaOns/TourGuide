package com.example.android.tourguideapp.items;

public class PlacesItems {

    private int mImageResource;
    private String mTitle, mGeoCoor, mUrl, mPrice;

    /**
     * For the beaches and nature items
     */

    public PlacesItems(int imageResource, String title, String geoCoor) {
        mImageResource = imageResource;
        mTitle = title;
        mGeoCoor = geoCoor;
    }

    /**
     * For the hotels item
     */
    public PlacesItems(int imageResource, String title, String geoCoor, String url, String price) {
        mImageResource = imageResource;
        mTitle = title;
        mGeoCoor = geoCoor;
        mUrl = url;
        mPrice = price;
    }

    /**
     * For the shopping and restaurant items
     */
    public PlacesItems(int imageResource, String title, String geoCoor, String url) {
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

    public String getPrice() {
        return mPrice;
    }
}
