package com.example.android.news;

import android.graphics.Bitmap;

public class News {
    private String mSectionHeading;
    private String mPublishTime;
    private String mTitle;
    private String mUrl;
    private Bitmap mThumbnail;


    public News(String sectionHeading, String publishTime,String title, String url, Bitmap thumbnail) {
        mSectionHeading = sectionHeading;
        mPublishTime = publishTime;
        mTitle = title;
        mUrl = url;
        mThumbnail=thumbnail;
    }



    public Bitmap getThumbnailImage() {
        return mThumbnail;
    }

    public String getSectionHeading() {
        return mSectionHeading;
    }

    public String getPublishTime() {
        return mPublishTime;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getUrl() {
        return mUrl;
    }
}

