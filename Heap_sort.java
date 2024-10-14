import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Heap_sort {

    // Función para hacer el heapify de un subárbol con la raíz en el índice i
    public static void heapify(List<Integer> array, int n, int i) {
        int largest = i;         // Inicializa el nodo más grande como la raíz
        int left = 2 * i + 1;    // Hijo izquierdo
        int right = 2 * i + 2;   // Hijo derecho
        
        // Si el hijo izquierdo es más grande que la raíz
        if (left < n && array.get(left) > array.get(largest)) {
            largest = left;
        }
        // Si el hijo derecho es más grande que el mayor hasta ahora
        if (right < n && array.get(right) > array.get(largest)) {
            largest = right;
        }
        // Si el mayor no es la raíz
        if (largest != i) {
            // Intercambiar
            int temp = array.get(i);
            array.set(i, array.get(largest));
            array.set(largest, temp);

            // Recursivamente hace heapify en el subárbol afectado
            heapify(array, n, largest);
        }
    }

    // Función para implementar Heap Sort
    public static void heapSort(List<Integer> array, int n) {
        // Construir el heap (reorganizar el array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Extraer elementos del heap uno por uno
        for (int i = n - 1; i >= 0; i--) {
            // Mueve la raíz actual al final
            int temp = array.get(0);
            array.set(0, array.get(i));
            array.set(i, temp);

            // Llama a heapify en el heap reducido
            heapify(array, i, 0);
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
        int n = array.size();
        heapSort(array, n);

        for (int num : array) {
            System.out.print(num + " ");
        }
    }


}
