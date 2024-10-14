def counting_sort(array):
    # Encuentra el valor máximo en el array de entrada
    max_value = max(array)

    # Inicializa el array de conteo con el tamaño adecuado
    count = [0] * (max_value + 1)
    output = [0] * len(array)

    # Contar la frecuencia de cada número en el array de entrada
    for num in array:
        count[num] += 1

    # Actualizar el array de conteo sumando los valores anteriores (cálculo de posiciones acumuladas)
    for i in range(1, len(count)):
        count[i] += count[i - 1]

    # Construir el array de salida usando el conteo acumulado
    for num in reversed(array):
        output[count[num] - 1] = num
        count[num] -= 1

    return output  # Retorna el array ordenado


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
        respuestas = counting_sort(array)
        print(" ".join(map(str, respuestas)))


if __name__ == "__main__":
    main()
