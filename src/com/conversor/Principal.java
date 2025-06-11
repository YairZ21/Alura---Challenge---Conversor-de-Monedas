package com.conversor;

import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        while (true) {
            String[] opciones = {"Conversor de Moneda", "Conversor de Temperatura", "Salir"};
            int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menú Principal",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            if (seleccion == 0) {
                String[] monedas = {"USD", "EUR", "GBP", "JPY", "KRW"};
                String monedaDestino = (String) JOptionPane.showInputDialog(null, "Seleccione la moneda de destino:",
                        "Monedas Disponibles", JOptionPane.QUESTION_MESSAGE, null, monedas, monedas[0]);

                if (monedaDestino != null) {
                    String montoStr = JOptionPane.showInputDialog("Ingrese el monto en colones costarricenses:");
                    try {
                        double monto = Double.parseDouble(montoStr);
                        double resultado = com.conversor.ConversorMoneda.convertir(monto, monedaDestino);
                        if (resultado != -1) {
                            JOptionPane.showMessageDialog(null, "Resultado: " + resultado + " " + monedaDestino);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
                    }
                }
            } else if (seleccion == 1) {
                String[] opcionesTemp = {"Celsius a Fahrenheit", "Fahrenheit a Celsius"};
                String opcionTemp = (String) JOptionPane.showInputDialog(null, "Seleccione la conversión:",
                        "Conversor de Temperatura", JOptionPane.QUESTION_MESSAGE, null, opcionesTemp, opcionesTemp[0]);

                if (opcionTemp != null) {
                    String tempStr = JOptionPane.showInputDialog("Ingrese la temperatura:");
                    try {
                        double temp = Double.parseDouble(tempStr);
                        double resultado = 0;
                        if (opcionTemp.equals("Celsius a Fahrenheit")) {
                            resultado = com.conversor.ConversorTemperatura.convertirCelsiusAFahrenheit(temp);
                        } else {
                            resultado = com.conversor.ConversorTemperatura.convertirFahrenheitACelsius(temp);
                        }
                        JOptionPane.showMessageDialog(null, "Resultado: " + resultado + "°");
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
                    }
                }
            } else {
                int salir = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea salir?", "Confirmar Salida",
                        JOptionPane.YES_NO_OPTION);
                if (salir == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Programa Terminado");
                    break;
                }
            }
        }
    }
}

