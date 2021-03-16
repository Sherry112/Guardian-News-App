package com.example.android.news;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static com.example.android.news.MainActivity.LOG_TAG;

public class NewsAdapter extends ArrayAdapter<News> {


    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_item_list, parent, false);
        }

        // Find the news articles at the given position in the list of articles
        News currentNews = getItem(position);


        TextView sectionHeading = (TextView) listItemView.findViewById(R.id.sectionHeading_textView);
        sectionHeading.setText(currentNews.getSectionHeading());
        TextView title = (TextView) listItemView.findViewById(R.id.title_textView);
        title.setText(currentNews.getTitle());
        TextView publishTime = (TextView) listItemView.findViewById(R.id.publishTime_textView);
        String dateAndTimeObject = currentNews.getPublishTime();

        publishTime.setText(formatTime(dateAndTimeObject));


        ImageView thumbnail = (ImageView) listItemView.findViewById(R.id.thumbnail_imageView);
        thumbnail.setImageBitmap(formatImageFromURL(currentNews.getThumbnailImage()));

        return listItemView;
    }



    private String formatTime(final String timeObject) {
        String dateAndTimeStr = "";
        try {
            SimpleDateFormat currentFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy  HH:mm");
            dateAndTimeStr = newFormat.format(currentFormat.parse(timeObject));
        } catch (ParseException parseEx) {
            dateAndTimeStr = "N.A.";
            Log.e(LOG_TAG, "Error while parsing the published date", parseEx);
        }
        return dateAndTimeStr;
    }

    private Bitmap formatImageFromURL(Bitmap articleThumbnail) {
        Bitmap returnBitmap;
        if (articleThumbnail == null) {
            returnBitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.news);
        } else {
            returnBitmap = articleThumbnail;
        }
        return returnBitmap;
    }
}
