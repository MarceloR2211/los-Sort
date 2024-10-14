import java.io.*;
import java.util.*;

public class Selection_sort {

    // Función para leer el archivo y almacenar los números en una lista
    public static void lectura(List<Integer> numeros) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Usuar\\Desktop\\practica ADA\\random\\los100000.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                // Convierte la línea leída a entero y la almacena en la lista
                numeros.add(Integer.parseInt(linea));
            }
            br.close();  // Cierra el archivo
        } catch (IOException e) {
            System.out.println("No se pudo abrir el archivo.");
        }
    }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        lectura(array);

        int axi;
        int rem;

        // Algoritmo de selección
        for (int i = 0; i < array.size() - 1; i++) {
            axi = i;
            for (int j = i + 1; j < array.size(); j++) {
                if (array.get(j) < array.get(axi)) {
                    axi = j;
                }
            }
            if (axi != i) {
                // Intercambiar elementos
                rem = array.get(i);
                array.set(i, array.get(axi));
                array.set(axi, rem);
            }
        }

        // Imprimir el array ordenado
        for (int num : array) {
            System.out.print(num + " ");
        }
    }


}
