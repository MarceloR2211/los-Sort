package creador_de_txt_ramdom;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Creador_de_txt_ramdom {

    public static void main(String[] args) {
        Random random = new Random();

        int[] las_cantidades = {100, 500, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000};

        for (int i = 0; i < las_cantidades.length; i++) {
            String ruta = "C:\\Users\\Usuar\\Desktop\\practica ADA\\random\\los"+las_cantidades[i]+".txt";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta, true))) {
                for (int j = 0; j < las_cantidades[i]; j++) {
                    writer.write(String.valueOf(random.nextInt(100000)));
                    writer.newLine();
                }
            } catch (IOException e) {
                System.out.println("error en " + ruta + ": " + e.getMessage());
            }

        }

    }
}