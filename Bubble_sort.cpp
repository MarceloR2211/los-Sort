#include <iostream>
#include <fstream>
#include <vector>
#include <string>
using namespace std;

void lectura(vector<int>& numeros){
    ifstream archi;
    string linea;

    // Abre el archivo en modo lectura
    archi.open("C:\\Users\\Usuar\\Desktop\\practica ADA\\random\\los6000.txt", ios::in);

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

int main(){
    vector<int> array;
    lectura(array);
    int axi;
    //////////
    for (int i = 0; i < array.size()-1; i++)
    {
        for (int j = 0; j < array.size()-i-1; j++)
        {
            if (array[j]>array[j+1])
            {
                axi=array[j];
                array[j] = array[j+1];
                array[j+1] = axi;
            }
            
        }
        
    }
    //////////
    for (int k = 0; k < array.size(); k++)
    {
        cout << array[k]<<" ";
    }
    
    return 0;

}


