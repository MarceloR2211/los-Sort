#include <iostream>
#include <fstream>
#include <vector>
#include <string>
using namespace std;

void quicksort(vector<int>& array, int inicio, int fin) {
	if (inicio >= fin) return; // Condici�n de parada
	
	// Elecci�n del pivote
	int pivote = array[inicio + (fin - inicio) / 2]; // Valor del pivote (elemento en la mitad)
	int i = inicio;
	int j = fin;
	
	while (i <= j) {
		// Encontrar un elemento a la izquierda que sea mayor o igual al pivote
		while (array[i] < pivote) {
			i++;
		}
		// Encontrar un elemento a la derecha que sea menor o igual al pivote
		while (array[j] > pivote) {
			j--;
		}
		// Intercambiar elementos si i <= j
		if (i <= j) {
			swap(array[i], array[j]); // Intercambio usando swap
			i++;
			j--;
		}
		
	// Recursivamente ordenar las dos sub-particiones
	if (inicio < j) {
		quicksort(array, inicio, j); // Partici�n izquierda
	}
	if (i < fin) {
		quicksort(array, i, fin); //p derecha
	}
	}
	}

void lectura(vector<int>& numeros) {
    ifstream archi;
    string linea;

    // Abre el archivo en modo lectura
    archi.open("C:\\Users\\Usuar\\Desktop\\practica ADA\\random\\los70000.txt", ios::in);

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
	
int main(int argc, char *argv[]){
	vector<int> array;
    lectura(array);
	
	quicksort(array,0,array.size());
	
	for (int k = 0; k < array.size(); k++){
			{
				cout << array[k]<<" ";
			}
	}
			return 0;
}

//#include <iostream>
//using namespace std;
//
//int main(int argc, char *argv[]) {
//	int array[] = {10,3,2,5,4,8,9,7,6,1};
//	//////////
//	int tamano = sizeof(array)/sizeof(array[0]);//forma de hallar el tama�o de un array si se desconoce
//	int  inicio=0,fin=tamano-1,pivote=array[tamano/2];
//	int axiinicio=inicio, axifin=fin;
//	do{
//		while(array[inicio]<pivote and inicio<axifin){
//			inicio++;
//		}
//		while(array[fin]<pivote and fin<axiinicio){
//			fin++;
//		}
//		if(inicio<=fin){
//			int axi = array[inicio];
//			array[inicio] = array[fin];
//			array[fin] = axi;
//			inicio++;
//			fin--;
//		}
//	}while(inicio<=fin);
//	
//	
//	/////////
//	for (int k = 0; k < 10; k++)
//	{
//		cout << array[k]<<" ";
//	}
//	return 0;
//}
