package com.project;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;

public class PR111Files {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/pr111/";
        gestionarArxius(camiFitxer);
    }

    public static void gestionarArxius(String camiFitxer) {
        File directori = new File(camiFitxer+"/myFiles");
        if (!directori.exists()){
            if(directori.mkdirs()){
                System.out.println("Directori creat");
            } else{
                System.err.println("Error al crear el direcotri");
            }
        }
        try{

            File arxiu1 = new File(directori+"/file1.txt");
            if (!arxiu1.exists()){
                if (arxiu1.createNewFile()){
                    System.out.println("arxiu1 creat");
                }else {
                    System.err.println("L'arxiu1 no s'ha pogut crear");
                }
            }else {
                System.out.println("L'arxiu ja existeix");
            }
            File arxiu2 = new File(directori+"/file2.txt");
            if (!arxiu2.exists()){
            if (arxiu2.createNewFile()){
                System.out.println("arxiu2 creat");
            }else {
                System.err.println("L'arxiu2 no s'ha pogut crear");
            }}else {
                System.err.println("L'arxiu ja existeix");
            }

            File arxiuRenombable = new File(directori+"/renamedFile.txt");
            if(arxiu2.renameTo(arxiuRenombable))
            {
                System.out.println("renombrat");

            }else {
                System.err.println("No s'ha pogut reanomenar");
            }


            System.out.println("Els arxius de la carpeta son:");
            for (int i=0;i<directori.listFiles().length;i++){
                System.out.println(directori.listFiles()[i].getName());
            }

            if (arxiu1.delete()){
                System.out.println("L'arxiu1 s'ha eliminat");
            }else {
                System.err.println("No s'ha pogut eliminar");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
