package com.conversor;

public class ConversorTemperatura {
    public static double convertirCelsiusAFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public static double convertirFahrenheitACelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
}

