package com.example.jookatest.network;


import retrofit2.Retrofit;

public class ApiClient {

    private static Retrofit retrofit;
    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            // Here build retrofit
        }
        return retrofit;
    }

}
