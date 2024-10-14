import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bubble_sort {

    public static void lectura(List<Integer> numeros) {
        BufferedReader reader;
        String linea;

        try {
            // Abre el archivo en modo lectura
            reader = new BufferedReader(new FileReader("C:\\Users\\Usuar\\Desktop\\practica ADA\\random\\los100000.txt"));

            // Lee el archivo línea por línea
            while ((linea = reader.readLine()) != null) {
                // Convierte la línea leída a entero y la almacena en la lista
                numeros.add(Integer.parseInt(linea));
            }
            reader.close();  // Cierra el archivo

        } catch (IOException e) {
            System.out.println("No se pudo abrir el archivo.");
        }
    }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        lectura(array);
        int axi;

        // Bubble Sort
        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = 0; j < array.size() - i - 1; j++) {
                if (array.get(j) > array.get(j + 1)) {
                    axi = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, axi);
                }
            }
        }

        // Imprime el array ordenado
        for (int k = 0; k < array.size(); k++) {
            System.out.print(array.get(k) + " ");
        }
    }
}