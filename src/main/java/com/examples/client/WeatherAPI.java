package com.examples.client;

import com.examples.models.WeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {
    @GET("weather")
    Call<WeatherResponse> getWeather(@Query("lat") double lat,
                                     @Query("lon") double lon,
                                     @Query("appid") String appid,
                                     @Query("units") String units);
}
