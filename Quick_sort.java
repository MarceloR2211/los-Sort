import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Quick_sort {

    // Función para implementar QuickSort
    public static void quicksort(List<Integer> array, int inicio, int fin) {
        if (inicio >= fin) return; // Condición de parada
        
        // Elección del pivote
        int pivote = array.get(inicio + (fin - inicio) / 2); // Valor del pivote (elemento en la mitad)
        int i = inicio;
        int j = fin;
        
        while (i <= j) {
            // Encontrar un elemento a la izquierda que sea mayor o igual al pivote
            while (array.get(i) < pivote) {
                i++;
            }
            // Encontrar un elemento a la derecha que sea menor o igual al pivote
            while (array.get(j) > pivote) {
                j--;
            }
            // Intercambiar elementos si i <= j
            if (i <= j) {
                int temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
                i++;
                j--;
            }
        }

        // Recursivamente ordenar las dos sub-particiones
        if (inicio < j) {
            quicksort(array, inicio, j); // Partición izquierda
        }
        if (i < fin) {
            quicksort(array, i, fin); // Partición derecha
        }
    }

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

    // Función principal
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        lectura(array);

        // Verificar si se leyeron números
        if (!array.isEmpty()) {
            // Llamar a quicksort
            quicksort(array, 0, array.size() - 1);

            // Imprimir el array ordenado
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            System.out.println("El archivo está vacío o no se leyeron números.");
        }
    }


}
