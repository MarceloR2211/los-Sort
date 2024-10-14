#include <iostream>
#include <fstream>
#include <vector>
#include <string>
using namespace std;

// Funci�n para hacer el heapify de un sub�rbol con la ra�z en el �ndice i
void heapify(vector<int> array, int n, int i) {
	int largest = i;         // Inicializa el nodo m�s grande como la ra�z
	int left = 2 * i + 1;    // Hijo izquierdo
	int right = 2 * i + 2;   // Hijo derecho
	
	// Si el hijo izquierdo es m�s grande que la ra�z
	if (left < n && array[left] > array[largest])
		largest = left;
	// Si el hijo derecho es m�s grande que el mayor hasta ahora
	if (right < n && array[right] > array[largest])
		largest = right;
	// Si el mayor no es la ra�z
	if (largest != i) {
		swap(array[i], array[largest]);  // Intercambiar
		// Recursivamente hace heapify en el sub�rbol afectado
		heapify(array, n, largest);
	}
}

// Funci�n para implementar Heap Sort
void heapSort(vector<int> array, int n) {
	// Construir el heap (reorganizar el array)
	for (int i = n / 2 - 1; i >= 0; i--)
		heapify(array, n, i);
	// Extraer elementos del heap uno por uno
	for (int i = n - 1; i >= 0; i--) {
		// Mueve la ra�z actual al final
		swap(array[0], array[i]);
		// Llama a heapify en el heap reducido
		heapify(array, i, 0);
	}
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

// Funci�n principal
int main() {
	vector<int> array;
    lectura(array);
	int n = array.size();	
	heapSort(array, n);
	for (int i = 0; i < n; ++i){
		cout << array[i] << " ";
	}
	return 0;
}
