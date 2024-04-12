package com.example.test0319;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("photos.json")
    Call<Post> getPosts(

            @Query("method") String method,
            @Query("api_key") String apiKey,
            @Query("page") int page,
            @Query("format") String format,
            @Query("nojsoncallback") boolean noJsonCallback,
            @Query("safe_search") boolean safeSearch
    );
}
