package com.conversor;

import javax.swing.*;
import java.net.*;
import java.io.*;

public class ConversorMoneda {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/6d456fc52c87865bb20e9df1/latest/CRC";

    public static double obtenerTasaCambio(String monedaDestino) {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String jsonResponse = response.toString();
            int startIndex = jsonResponse.indexOf("\"" + monedaDestino + "\":") + monedaDestino.length() + 3;
            int endIndex = jsonResponse.indexOf(",", startIndex);
            if (endIndex == -1) {
                endIndex = jsonResponse.indexOf("}", startIndex);
            }
            String tasaStr = jsonResponse.substring(startIndex, endIndex);
            return Double.parseDouble(tasaStr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la tasa de cambio: " + e.getMessage());
            return -1;
        }
    }

    public static double convertir(double monto, String monedaDestino) {
        double tasa = obtenerTasaCambio(monedaDestino);
        if (tasa == -1) {
            return -1;
        }
        return monto * tasa;
    }
}

