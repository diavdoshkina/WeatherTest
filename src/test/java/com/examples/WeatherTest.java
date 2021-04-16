package com.examples;

import com.examples.client.WeatherClient;
import com.examples.models.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class WeatherTest {
    static WeatherClient weatherClient;
    final double lat = 59.938879;
    final double lon = 30.315212;

    @BeforeAll
    public static void before() {
        weatherClient = new WeatherClient();
    }

    @Test
    public void test() throws IOException {
        int expectedMin = -100;
        int expectedMax = -10;

        WeatherResponse byCoordinates = weatherClient.getByCoordinates(lat, lon);
        double actualTemperature = byCoordinates.getMain().getTemp();
        Assertions.assertTrue(actualTemperature > expectedMin, "Actual temperature: " + actualTemperature + " expected to be more than " + expectedMin);
        Assertions.assertTrue(actualTemperature < expectedMax, "Actual temperature: " + actualTemperature + " expected to be less than " + expectedMax);
    }
}
