package com.example.test0319;

import android.util.Log;

import com.example.test0319.adapter.ListAdapter;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConnectApi  {

    Gson gson = new Gson();
    public void connect_Api() {

        ApiClient apiClient = new ApiClient();
        //Connect API, Use Callback to get response data

        apiClient.getApiService().getPosts("flickr.photos.getRecent", "fee10de350d1f31d5fec0eaf330d2dba", 1, "json", true, true).enqueue(new Callback<Post>() {

            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                //Response Data

                if (response.isSuccessful() && response.body() != null) {
                    // Success and valid data
                    List<Post.Photo> data = response.body().photos.photo;
                    ListAdapter adapter = new ListAdapter(MainActivity.context, data);
                    // Update the listView
                    MainActivity.listView.setAdapter(adapter);

                } else {
                    //Has response but invalid data
                    try {
                        ErrorResponse errorResponse = gson.fromJson(response.errorBody().string(), ErrorResponse.class);
                        Log.e("Error", errorResponse.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

                Log.d("note", "response: " + t.toString());
            }
        });
    }
}
