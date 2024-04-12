package com.example.test0319;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ListDetailActivityTest {

    @Mock
    private ImageLoader mockImageLoader;

    @Mock
    private ImageView mockImageView;

    private ListDetailActivity listDetailActivity = new ListDetailActivity();



    @Test
    public void testInit_Data() {
        String testUrl = "http://example.com/image.jpg";
        listDetailActivity.init_Data(testUrl, mockImageView);

        // Verify loadImage was called with the correct arguments
        verify(mockImageLoader).loadImage(testUrl, mockImageView);
    }

}