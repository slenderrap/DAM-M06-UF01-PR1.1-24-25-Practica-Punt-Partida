package com.project;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class PR113sobreescriu {

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/frasesMatrix.txt";

        // Crida al mètode que escriu les frases sobreescrivint el fitxer
        escriureFrases(camiFitxer);
    }

    // Mètode que escriu les frases sobreescrivint el fitxer amb UTF-8 i línia en blanc final
    public static void escriureFrases(String camiFitxer) {
        File arxiu = new File(camiFitxer);

        if (!arxiu.exists()){
            try {
                arxiu.createNewFile();
            } catch (IOException e) {
                System.out.println("No s'ha pogut crear");
            }
        }
            try {
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(camiFitxer),
                        StandardCharsets.UTF_8));
                bw.write("I can only show you the door\n");
                bw.append("You're the one that has to walk through it\n");
                bw.close();
                System.out.println("S'han introduit les files correctament");
            } catch (IOException e2) {
                e2.printStackTrace();
            }


    }
}
