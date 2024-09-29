package com.project;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PR115cp {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Error: Has d'indicar dues rutes d'arxiu.");
            System.out.println("Ús: PR115cp <origen> <destinació>");
            return;
        }

        // Ruta de l'arxiu origen
        String rutaOrigen = args[0];
        // Ruta de l'arxiu destinació
        String rutaDesti = args[1];

        // Crida al mètode per copiar l'arxiu
        copiarArxiu(rutaOrigen, rutaDesti);
    }

    // Mètode per copiar un arxiu de text de l'origen al destí
    public static void copiarArxiu(String rutaOrigen, String rutaDesti) {
        File arxiuOrigen = new File(rutaOrigen);
        File arxiuDesti = new File(rutaDesti);
        boolean reescriure=true;
        if (!arxiuOrigen.exists()) {
            System.out.println("L'arxiu origen no existeix");
        } else {
            if (!arxiuOrigen.isFile()) {
                System.out.println("L'arxiu origen no es un arxiu de text");
            } else {
                if (!arxiuOrigen.getName().endsWith(".txt")) {
                    System.out.println("L'arxiu no es un .txt");
                } else {
                    if (arxiuDesti.exists()){
                        System.out.println("Vols que l'arxiu es reescriveixi?(s/n)");
                        Scanner sc = new Scanner(System.in);
                        while (!sc.hasNext()){
                            String text = sc.nextLine().toLowerCase();
                            if (text.equals("s")){
                                break;
                            } else if (text.equals("n")) {
                                reescriure=false;
                            }else {
                                System.out.println("Has d'escriure s o n");
                            }

                        }
                        sc.close();
                    }

                    try {
                        if (reescriure) {
                            int c = 0;
                            String linea;
                            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(rutaOrigen),
                                    StandardCharsets.UTF_8));


                            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(rutaDesti),
                                    StandardCharsets.UTF_8));
                            while ((linea = br.readLine()) != null) {

                                bw.write(linea);
                                bw.newLine();


                            }
                            bw.close();
                            br.close();
                            System.out.println("S'ha copiat correctament");
                        }else {
                            System.out.println("Has dit que no el vols reescriure");
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Arxiu no trobat");
                    } catch (IOException e) {
                        System.out.println("Error a la copia");
                    }
                }
            }
        }

    }
}
