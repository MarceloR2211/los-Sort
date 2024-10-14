import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Merge_sort {

    // Función para fusionar dos subarrays
    public static void fusion(List<Integer> arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Crear arrays temporales
        List<Integer> L = new ArrayList<>(n1);
        List<Integer> R = new ArrayList<>(n2);

        // Copiar datos a los arrays temporales
        for (int i = 0; i < n1; i++)
            L.add(arr.get(left + i));
        for (int i = 0; i < n2; i++)
            R.add(arr.get(mid + 1 + i));

        int i = 0, j = 0, k = left;

        // Mezclar los arrays temporales de nuevo en el original
        while (i < n1 && j < n2) {
            if (L.get(i) <= R.get(j)) {
                arr.set(k, L.get(i));
                i++;
            } else {
                arr.set(k, R.get(j));
                j++;
            }
            k++;
        }

        // Copiar los elementos restantes de L[]
        while (i < n1) {
            arr.set(k, L.get(i));
            i++;
            k++;
        }

        // Copiar los elementos restantes de R[]
        while (j < n2) {
            arr.set(k, R.get(j));
            j++;
            k++;
        }
    }

    // Función para implementar Merge Sort
    public static void mergeSort(List<Integer> arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Ordenar las dos mitades
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Fusionar las mitades ordenadas
            fusion(arr, left, mid, right);
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
        List<Integer> arr = new ArrayList<>();
        lectura(arr);

        // Verificar si se leyeron números
        if (!arr.isEmpty()) {
            // Ordenar el array
            mergeSort(arr, 0, arr.size() - 1);

            // Imprimir el array ordenado
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            System.out.println("El archivo está vacío o no se leyeron números.");
        }
    }


}
