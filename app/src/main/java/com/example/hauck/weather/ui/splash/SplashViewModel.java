package com.example.luara.desafiotruckpad.ui.splash;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.luara.desafiotruckpad.model.WeatherData;
import com.example.luara.desafiotruckpad.service.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashViewModel extends ViewModel {

    private MutableLiveData<WeatherData> weatherResponse;
    public LiveData<WeatherData> getWeather(double lat, double lon) {
        if (weatherResponse == null) {
            weatherResponse = new MutableLiveData<WeatherData>();
            loadWeather(lat, lon);
        }

        return  weatherResponse;
    }

    private void loadWeather(double lat, double lon) {
        Call<WeatherData> call = RetrofitService.getMovieAPI().getWeatherByParameter(String.valueOf(lat), String.valueOf(lon), "790b3216e024360388cff970412859d4");

        call.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                if (response.body() != null) {

                    weatherResponse.setValue(response.body());
                }

            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                Log.d("---->", "ERRO");
            }

        });
    }
}
