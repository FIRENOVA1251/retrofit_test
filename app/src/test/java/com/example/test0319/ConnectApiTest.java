package com.example.test0319;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@RunWith(JUnit4.class)
public class ConnectApiTest {

    private MockWebServer mockWebServer;
    ApiInterface apiInterface;

    ApiClient apiClient = new ApiClient();

    @Before
    public void setUp() throws Exception {
        mockWebServer = new MockWebServer();
        mockWebServer.start();

        apiInterface = new Retrofit.Builder()
                .baseUrl(mockWebServer.url("/"))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface.class);
    }

    @Test
    public void getRecent_returnsData() throws Exception {
        // Set response of MockWebServer
        String mockJsonResponse = "{"
                + "\"photos\": {"
                + "\"page\": \"1\","
                + "\"pages\": \"10\","
                + "\"perpage\": \"1\","
                + "\"total\": \"1000\","
                + "\"photo\": [{"
                + "\"id\": \"48837804368\","
                + "\"owner\": \"183727554@N08\","
                + "\"secret\": \"709b44acf8\","
                + "\"server\": \"65535\","
                + "\"farm\": 66,"
                + "\"title\": \"Reflections Off a Backcountry Pond (Daylight Blues)\","
                + "\"ispublic\": 1,"
                + "\"isfriend\": 0,"
                + "\"isfamily\": 0,"
                + "  }"
                + "]},"
                + "\"stat\": \"ok\""
                + "}";

        // Use server.url
        HttpUrl baseUrl = mockWebServer.url("/reg1");

        // Send Request
        //HttpRequest.get(baseUrl.url()).body();


        mockWebServer.enqueue(new MockResponse().setBody(mockJsonResponse));

        //assertEquals("/photos", mockWebServer.takeRequest().getPath());


    }


    @After
    public void tearDown() throws Exception {
        mockWebServer.shutdown();
    }



    @Test
    public void connect_Api(){
        // Create Post Object
        Post post = new Post();

        // Create call object
        Call<Post> call = mock(Call.class);

        // Use callback to get response data
        doAnswer(invocation -> {
            Callback<Post> callback = invocation.getArgument(0);
            callback.onResponse(call, Response.success(post));
            return null;
        }).when(call).enqueue(any(Callback.class));

    }

    @Test
    public void connect_Api_success(){

        //Connect API, Use Callback to get response data
        // Use actual method to test
        apiClient.getApiService().getPosts("flickr.photos.getRecent", "fee10de350d1f31d5fec0eaf330d2dba", 1, "json", true, true).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                // check if response is success and NonNull

                assertTrue(response.isSuccessful());
                assertNotEquals(response.body(), null);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                // Fail assertion
            }
        });


    }

    @Test
    public void connect_Api_empty(){

        // If the variable are wrong
        apiClient.getApiService().getPosts("", "", 1, "", true, true).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                // check if response is success and Null

                assertTrue(response.isSuccessful());
                assertNotEquals(response.body(), null);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
            }
        });

    }




}