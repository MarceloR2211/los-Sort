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


def insertion_sort(array):
    # Implementación del algoritmo de ordenamiento por inserción
    for i in range(len(array)):
        axi = array[i]
        a = i

        # Desplaza los elementos mayores a la derecha
        while a > 0 and array[a - 1] > axi:
            array[a] = array[a - 1]
            a -= 1
        
        array[a] = axi


def main():
    filename = "C:\\Users\\Usuar\\Desktop\\practica ADA\\random\\los100000.txt"
    array = lectura(filename)
    
    if array:
        insertion_sort(array)
        
        # Imprimir el array ordenado
        print(" ".join(map(str, array)))


if __name__ == "__main__":
    main()
