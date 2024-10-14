import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Counting_sort {

    public static List<Integer> countingSort(List<Integer> array) {
        // Encuentra el valor máximo en el array de entrada
        int max_value = array.stream().max(Integer::compare).get();
        
        // Inicializa el array de conteo con tamaño adecuado
        int[] count = new int[max_value + 1];
        List<Integer> output = new ArrayList<>(array.size());
        
        // Inicializa la lista de salida con ceros
        for (int i = 0; i < array.size(); i++) {
            output.add(0);
        }
        
        // Contar la frecuencia de cada número en el array de entrada
        for (int num : array) {
            count[num]++;
        }
        
        // Actualizar el array de conteo sumando los valores anteriores (cálculo de posiciones acumuladas)
        for (int i = 1; i <= max_value; i++) {
            count[i] += count[i - 1];
        }
        
        // Construir el array de salida usando el conteo acumulado
        for (int i = array.size() - 1; i >= 0; i--) {
            output.set(count[array.get(i)] - 1, array.get(i));
            count[array.get(i)]--;
        }
        
        return output; // Retornar el array ordenado
    }

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
        List<Integer> respuestas = countingSort(array);

        for (int num : respuestas) {
            System.out.print(num + " ");
        }
    }
}
