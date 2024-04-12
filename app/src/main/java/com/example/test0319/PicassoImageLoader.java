package com.example.test0319;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoImageLoader implements ImageLoader {

    @Override
    public void loadImage(String url, ImageView into) {

        // If the url is not working, display the default image
        Picasso.get()
                .load(url)
                .error(R.drawable.ig_logo) // Set error placeholder
                .into(into);
    }
}

