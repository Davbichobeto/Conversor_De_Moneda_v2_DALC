package com.aluracursos.convertidormoneda.principal;

import com.aluracursos.convertidormoneda.modelos.*;
import com.aluracursos.convertidormoneda.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConvertidorMoneda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiService apiService = new ApiService();
        MenuService menuService = new MenuService();
        ConversionService conversionService = new ConversionService(apiService);
        ApiResponse apiResponse = apiService.obtenerDatosAPI();
        if (apiResponse == null) {
            System.out.println("Error de datos de la API.");
            return;
        }
        List<String> historialConversiones = new ArrayList<>();
        while (true) {
            menuService.mostrarMenu();
            String opcion = "";
            try {
                opcion = scanner.nextLine();
                if (opcion.isEmpty()) {
                    throw new IllegalArgumentException("Área requerida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                continue;
            }
            if (opcion.equals("15")) {
                System.out.println("¡Funcion correcta gracias por el uso!.");
                com.aluracursos.convertidormoneda.util.FileUtil.guardarDatosEnArchivo("historial_conversiones.txt", historialConversiones);
                break;
            }
            if (!MenuService.OPCIONES_CONVERSION.containsKey(opcion)) {
                System.out.println("Opción no válida, reintente.");
                continue;
            }
            double cantidad = 0;
            try {
                System.out.println("Ingrese el monto a convertir: ");
                String cantidadStr = scanner.nextLine();
                if (cantidadStr.isEmpty()) {
                    throw new IllegalArgumentException("Área requerida de llenado.");
                }
                cantidad = Double.parseDouble(cantidadStr);
                if (cantidad <= 0) {
                    throw new IllegalArgumentException("La cantidad debe ser mayor que cero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                continue;
            }
            String resultadoConversion = conversionService.realizarConversion(opcion, cantidad, apiResponse);
            historialConversiones.add(resultadoConversion);
            System.out.println("Presione enter para seguir...");
            scanner.nextLine();
        }
        scanner.close();
        System.out.println("Cargando el historial de conversiones...");
        FileReaderUtil.leerDatosDeArchivo("historial_conversiones.txt");
    }
}
