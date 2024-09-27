package com.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PR110ReadFile {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/GestioTasques.java";
        llegirIMostrarFitxer(camiFitxer);  // Només cridem a la funció amb la ruta del fitxer
    }

    // Funció que llegeix el fitxer i mostra les línies amb numeració
    public static void llegirIMostrarFitxer(String camiFitxer) {
        try {
            File f = new File(camiFitxer);
            Scanner sc = new Scanner(f);
            Integer c = 0;
            while (sc.hasNext()) {
                c++;
                System.out.println(c + ": " + sc.nextLine());
            }
        }catch (FileNotFoundException e1){
            System.err.println(e1.getMessage());
        }catch (Exception e2){
            System.err.println("Error: "+e2);
        }
    }
}
