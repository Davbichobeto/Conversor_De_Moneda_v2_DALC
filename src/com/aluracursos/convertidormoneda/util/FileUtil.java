package com.aluracursos.convertidormoneda.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileUtil {
    public static void guardarDatosEnArchivo(String nombreArchivo, List<String> datos) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            for(String linea : datos) {
                writer.write(linea + System.lineSeparator());
            }

            System.out.println("Datos guardados en " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo: " + e.getMessage());
        }

    }
}
