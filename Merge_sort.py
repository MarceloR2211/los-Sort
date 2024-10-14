def fusion(arr, left, mid, right):
    n1 = mid - left + 1
    n2 = right - mid

    # Crear listas temporales
    L = arr[left:left + n1]
    R = arr[mid + 1:mid + 1 + n2]

    i = 0
    j = 0
    k = left

    # Mezclar las listas temporales de nuevo en el original
    while i < n1 and j < n2:
        if L[i] <= R[j]:
            arr[k] = L[i]
            i += 1
        else:
            arr[k] = R[j]
            j += 1
        k += 1

    # Copiar los elementos restantes de L[]
    while i < n1:
        arr[k] = L[i]
        i += 1
        k += 1

    # Copiar los elementos restantes de R[]
    while j < n2:
        arr[k] = R[j]
        j += 1
        k += 1


def merge_sort(arr, left, right):
    if left < right:
        mid = left + (right - left) // 2

        # Ordenar las dos mitades
        merge_sort(arr, left, mid)
        merge_sort(arr, mid + 1, right)

        # Fusionar las mitades ordenadas
        fusion(arr, left, mid, right)


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
    arr = lectura(filename)

    # Verificar si se leyeron números
    if arr:
        # Ordenar el array
        merge_sort(arr, 0, len(arr) - 1)

        # Imprimir el array ordenado
        print(" ".join(map(str, arr)))
    else:
        print("El archivo está vacío o no se leyeron números.")


if __name__ == "__main__":
    main()
