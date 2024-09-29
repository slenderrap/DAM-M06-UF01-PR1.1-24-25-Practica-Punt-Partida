package com.project;

import java.io.*;
import java.nio.file.FileSystemException;

public class PR114linies {

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/numeros.txt";

        // Crida al mètode que genera i escriu els números aleatoris
        generarNumerosAleatoris(camiFitxer);
    }

    // Mètode per generar 10 números aleatoris i escriure'ls al fitxer
    public static void generarNumerosAleatoris(String camiFitxer) {
        File arxiu = new File(camiFitxer);
        try {
            if(!arxiu.exists()){
                arxiu.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(camiFitxer)));
            StringBuilder cadenaNumsAleatoris= new StringBuilder();
            for (int i=0;i<10;i++){
                int numAleatori = (int) (Math.random() * (100));
                if (i!=9){
                    cadenaNumsAleatoris.append(numAleatori).append("\n");
                }else {
                    cadenaNumsAleatoris.append(numAleatori);
                }

            }
            bw.write(String.valueOf(cadenaNumsAleatoris));
            bw.close();
            System.out.println("Les linees s'han afegit correctament");


        } catch (IOException e) {
            System.out.println("Error: No s'ha pogut crear l'arxiu");
        }


    }
}
