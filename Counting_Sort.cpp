#include <vector>
#include <iostream>
#include <algorithm> // Para usar la funci�n max_element
#include <fstream>
#include <string>
using namespace std;

static vector<int> CountingSort(vector<int>& array) {
	// Encuentra el valor m�ximo en el array de entrada
	int max_value = *max_element(array.begin(), array.end());
	
	// Inicializa el vector de conteo con tama�o adecuado
	vector<int> count(max_value + 1, 0);
	vector<int> output(array.size(), 0);
	
	// Contar la frecuencia de cada n�mero en el array de entrada
	for (int i = 0; i < array.size(); i++) {
		count[array[i]]++;
	}
	
	// Actualizar el vector de conteo sumando los valores anteriores (c�lculo de posiciones acumuladas)
	for (int i = 1; i <= max_value; i++) {
		count[i] += count[i - 1];
	}
	
	// Construir el array de salida usando el conteo acumulado
	for (int i = array.size() - 1; i >= 0; i--) {
		output[count[array[i]] - 1] = array[i];
		count[array[i]]--;
	}
	
	return output; // Retornar el array ordenado
}

void lectura(vector<int>& numeros){
    ifstream archi;
    string linea;

    // Abre el archivo en modo lectura
    archi.open("C:\\Users\\Usuar\\Desktop\\practica ADA\\random\\los100000.txt", ios::in);
    // Verifica si el archivo se abrió correctamente
    if (archi.is_open()) {
        // Lee el archivo línea por línea
        while (getline(archi, linea)) {
            // Convierte la línea leída a entero y la almacena en el vector
            numeros.push_back(stoi(linea)); 
        }
        archi.close();  // Cierra el archivo
    } else {
        cout << "No se pudo abrir el archivo." << endl;
    }
}

int main(int argc, char *argv[]) {
	vector<int> array;
    lectura(array);
	vector<int> respuestas = CountingSort(array);
	
	for (int i = 0; i < respuestas.size(); i++) {
		cout << respuestas[i] << " ";
	}
	
	return 0;
}
