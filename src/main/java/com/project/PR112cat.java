package com.project;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class PR112cat {

    public static void main(String[] args) {
        // Comprovar que s'ha proporcionat una ruta com a paràmetre
        if (args.length == 0) {
            System.out.println("No s'ha proporcionat cap ruta d'arxiu.");
            return;
        }

        // Obtenir la ruta del fitxer des dels paràmetres
        String rutaArxiu = args[0];
        mostrarContingutArxiu(rutaArxiu);
    }

    // Funció per mostrar el contingut de l'arxiu o el missatge d'error corresponent
    public static void mostrarContingutArxiu(String rutaArxiu) {

        try {
            File arxiu = new File(rutaArxiu);
            if (!arxiu.exists()){
                System.out.println("El fitxer no existeix o no és accessible.");
            }


            if (arxiu.isFile()){
                String linea;
                BufferedReader br= new BufferedReader(new InputStreamReader(new FileInputStream(arxiu.getPath()),
                        StandardCharsets.UTF_8));
                while ((linea = br.readLine())!=null){
                    System.out.println(linea);
                }
            }else if (arxiu.isDirectory()){
                System.out.println("El path no correspon a un arxiu, sinó a una carpeta.");
            }else {
                System.err.println("El fitxer no existeix o no es accessible");
            }
        } catch (FileNotFoundException e) {
            System.err.println("El fitxer no sh'ha trobat");
        } catch (IOException e) {
            System.err.println("Error s'ha interromput");
        }

    }
}
