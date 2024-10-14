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


def selection_sort(array):
    for i in range(len(array) - 1):
        axi = i
        for j in range(i + 1, len(array)):
            if array[j] < array[axi]:
                axi = j
        # Intercambiar elementos si es necesario
        if axi != i:
            array[i], array[axi] = array[axi], array[i]  # Intercambio usando tupla


def main():
    filename = "C:\\Users\\Usuar\\Desktop\\practica ADA\\random\\los100000.txt"
    array = lectura(filename)

    # Ordenar el array
    selection_sort(array)

    # Imprimir el array ordenado
    print(" ".join(map(str, array)))


if __name__ == "__main__":
    main()
