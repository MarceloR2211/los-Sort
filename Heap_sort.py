def heapify(array, n, i):
    # Inicializa el nodo más grande como la raíz
    largest = i
    left = 2 * i + 1  # Hijo izquierdo
    right = 2 * i + 2  # Hijo derecho

    # Si el hijo izquierdo es más grande que la raíz
    if left < n and array[left] > array[largest]:
        largest = left

    # Si el hijo derecho es más grande que el mayor hasta ahora
    if right < n and array[right] > array[largest]:
        largest = right

    # Si el mayor no es la raíz
    if largest != i:
        array[i], array[largest] = array[largest], array[i]  # Intercambiar
        # Recursivamente hace heapify en el subárbol afectado
        heapify(array, n, largest)


def heap_sort(array):
    n = len(array)

    # Construir el heap (reorganizar el array)
    for i in range(n // 2 - 1, -1, -1):
        heapify(array, n, i)

    # Extraer elementos del heap uno por uno
    for i in range(n - 1, 0, -1):
        array[0], array[i] = array[i], array[0]  # Mueve la raíz actual al final
        heapify(array, i, 0)


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
    if array:
        heap_sort(array)
        print(" ".join(map(str, array)))


if __name__ == "__main__":
    main()
