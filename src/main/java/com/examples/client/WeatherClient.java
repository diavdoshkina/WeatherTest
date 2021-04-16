package com.examples.client;

import com.examples.models.WeatherResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class WeatherClient {

    static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    static final String APP_ID = "4a2d380959f93349c3ab8d65fa033930";
    static final String UNITS = "metric";
    WeatherAPI weatherAPI;

    public WeatherClient() {
        Gson gson = new GsonBuilder()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        weatherAPI = retrofit.create(WeatherAPI.class);
    }

    public WeatherResponse getByCoordinates(double lat, double lon) throws IOException {
        Call<WeatherResponse> weather = weatherAPI.getWeather(lat, lon, APP_ID, UNITS);
        Response<WeatherResponse> response = weather.execute();
        return response.body();
    }
}
