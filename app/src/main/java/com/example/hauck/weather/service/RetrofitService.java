package com.example.luara.desafiotruckpad.service;


import com.example.luara.desafiotruckpad.interfaces.WeatherAPI;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    public static final String BASE_URL = "https://api.openweathermap.org/";

    private static Retrofit retrofit;



    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.connectTimeout(30, TimeUnit.SECONDS);
            httpClient.readTimeout(30, TimeUnit.SECONDS);
            httpClient.writeTimeout(30, TimeUnit.SECONDS);




            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();

        }

        return retrofit;
    }

    public static WeatherAPI getMovieAPI(){
        return getRetrofit().create(WeatherAPI.class);

    }
}




