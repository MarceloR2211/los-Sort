#include <iostream>
#include <fstream>
#include <vector>
#include <string>
using namespace std;


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
	int axi;
	//////////
	for(int i=0;i<array.size();i++){
		int a=i;
		axi=array[i];
		
		while((a>0) and (array[a-1]>axi)){
			array[a]=array[a-1];
			a--;
		}
		
		array[a] = axi;
	}
	//////////
	for (int k = 0; k < array.size(); k++)
	{
		cout << array[k]<<" ";
	}
	return 0;
}
