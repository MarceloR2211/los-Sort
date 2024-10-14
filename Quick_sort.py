def quicksort(array, inicio, fin):
    if inicio >= fin:
        return  # Condición de parada

    # Elección del pivote
    pivote = array[inicio + (fin - inicio) // 2]  # Valor del pivote
    i = inicio
    j = fin

    while i <= j:
        # Encontrar un elemento a la izquierda que sea mayor o igual al pivote
        while array[i] < pivote:
            i += 1
        # Encontrar un elemento a la derecha que sea menor o igual al pivote
        while array[j] > pivote:
            j -= 1
        # Intercambiar elementos si i <= j
        if i <= j:
            array[i], array[j] = array[j], array[i]  # Intercambio usando una tupla
            i += 1
            j -= 1

    # Recursivamente ordenar las dos sub-particiones
    if inicio < j:
        quicksort(array, inicio, j)  # Partición izquierda
    if i < fin:
        quicksort(array, i, fin)  # Partición derecha


def lectura(filename):
    numeros = []
    try:
        # Abre el archivo en modo lectura
        with open(filename, "r") as archivo:
            # Lee el archivo línea por línea y convierte cada línea a entero
            for linea in archivo:
                numeros.append(int(linea.strip()))  # Convierte y agrega a la lista
    except FileNotFoundError:
        print("No se pudo abrir el archivo.")
    return numeros


def main():
    filename = "C:\\Users\\Usuar\\Desktop\\practica ADA\\random\\los100000.txt"
    array = lectura(filename)

    # Ordenar el array
    if array:
        quicksort(array, 0, len(array) - 1)

        # Imprimir el array ordenado
        print(" ".join(map(str, array)))
    else:
        print("El archivo está vacío o no se leyeron números.")


if __name__ == "__main__":
    main()
