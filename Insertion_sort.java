import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Insertion_sort {

    // Función para leer el archivo y llenar la lista
    public static void lectura(List<Integer> numeros) {
        BufferedReader reader;
        String linea;

        try {
            // Abre el archivo en modo lectura
            reader = new BufferedReader(new FileReader("C:\\Users\\Usuar\\Desktop\\practica ADA\\random\\los100000.txt"));

            // Verifica si el archivo se abrió correctamente y lee línea por línea
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

        // Algoritmo de Insertion Sort
        for (int i = 0; i < array.size(); i++) {
            int a = i;
            axi = array.get(i);

            // Desplaza los elementos mayores hacia la derecha
            while (a > 0 && array.get(a - 1) > axi) {
                array.set(a, array.get(a - 1));
                a--;
            }

            array.set(a, axi);
        }

        // Imprime el array ordenado
        for (int num : array) {
            System.out.print(num + " ");
        }
    }


}
