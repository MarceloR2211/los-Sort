def lectura(numeros):
    try:
        # Abre el archivo en modo lectura
        with open("C:\\Users\\Usuar\\Desktop\\practica ADA\\random\\los100000.txt", "r") as archivo:
            # Lee el archivo línea por línea y convierte cada línea en entero
            for linea in archivo:
                numeros.append(int(linea.strip()))  # Convierte y agrega al final de la lista
    except FileNotFoundError:
        print("No se pudo abrir el archivo.")

def bubble_sort(array):
    # Algoritmo de ordenamiento burbuja
    n = len(array)
    for i in range(n - 1):
        for j in range(n - i - 1):
            if array[j] > array[j + 1]:
                # Intercambio de elementos
                array[j], array[j + 1] = array[j + 1], array[j]

def main():
    array = []
    lectura(array)
    
    bubble_sort(array)
    
    # Imprime el array ordenado
    for num in array:
        print(num, end=" ")

if __name__ == "__main__":
    main()
