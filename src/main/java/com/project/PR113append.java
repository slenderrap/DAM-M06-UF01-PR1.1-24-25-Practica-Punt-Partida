package com.project;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class PR113append {

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/frasesMatrix.txt";

        // Crida al mètode que afegeix les frases al fitxer
        afegirFrases(camiFitxer);
    }

    // Mètode que afegeix les frases al fitxer amb UTF-8 i línia en blanc final
    public static void afegirFrases(String camiFitxer) {
        File arxiu = new File(camiFitxer);

        if (!arxiu.exists()){
            try {
                arxiu.createNewFile();
            } catch (IOException e) {
                System.out.println("No s'ha pogut crear l'arxiu");
            }
        }
            try {

                FileWriter fw = new FileWriter(camiFitxer, StandardCharsets.UTF_8, true);
                fw.write("I can only show you the door\n");
                fw.write("You're the one that has to walk through it\n");
                fw.close();
                System.out.println("S'han introduit les files correctament");
            } catch (IOException e2) {
                e2.printStackTrace();


        }

    }
}
