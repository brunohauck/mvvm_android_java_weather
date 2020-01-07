package com.example.luara.desafiotruckpad.interfaces;

import com.example.luara.desafiotruckpad.model.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {

    @GET("data/2.5/weather?lat=-19.9150762&lon=-43.9693133&appid=790b3216e024360388cff970412859d4")
    Call<WeatherData> getWeather();

    @GET("data/2.5/weather")
    Call<WeatherData> getWeatherByParameter(
            @Query("lat") String lat,
            @Query("lon") String lon,
            @Query("appid") String apiKey
    );


}



