# Proyecto de Listas Enlazadas

Este proyecto implementa una estructura de datos de listas enlazadas en Java. La clase `Lista`  proporciona métodos para manipular y gestionar una lista enlazada simple, mientras que la clase `Principal` muestra ejemplos de cómo utilizar estos métodos.

## Estructura del Proyecto

- **Lista.java**: Clase que define la estructura de la lista enlazada y proporciona métodos para manipularla.
- **Nodo.java**: Clase que representa un nodo en la lista enlazada.
- **Principal.java**: Clase principal que contiene el método `main` para ejecutar ejemplos de uso de la clase `Lista`.

## Clase `Lista`

La clase `Lista` proporciona varias funcionalidades para manejar listas enlazadas.

### Métodos

1. **insertarCabezaLista(int entrada)**:
   - Inserta un nuevo nodo al inicio de la lista con el valor proporcionado.

2. **insertarLista(Nodo anterior, int entrada)**:
   - Inserta un nuevo nodo después del nodo especificado (`anterior`).

3. **eliminar(int entrada)**:
   - Elimina el primer nodo que contiene el valor especificado.

4. **buscarLista(int destino)**:
   - Busca un nodo que contenga el valor especificado y devuelve el nodo encontrado.

5. **visualizar()**:
   - Imprime todos los elementos de la lista en la consola.

6. **invertirLista()**:
   - Invierte el orden de los nodos en la lista.

7. **obtenerDesdeElFinal(int n)**:
   - Devuelve el nodo que se encuentra en la posición `n` desde el final de la lista.

8. **eliminarDuplicados()**:
   - Elimina nodos duplicados en la lista.

9. **obtenerTamaño()**:
   - Devuelve el número de nodos en la lista.

10. **ordenarLista()**:
    - Ordena los nodos de la lista en orden ascendente.

11. **unirListas(Lista otraLista)**:
    - Une la lista actual con otra lista enlazada.

12. **separarParesImpares()**:
    - Separa los números en la lista en dos listas diferentes: una para números pares y otra para números impares.

## Clase `Principal`

La clase `Principal` es el punto de entrada del programa y contiene el método `main`, donde se demuestran las funcionalidades de la clase `Lista`. A continuación se presentan las principales acciones realizadas en esta clase:

### Ejemplos de Uso

1. **Creación de una lista**:
   - Se crea una instancia de `Lista` y se insertan varios elementos.

2. **Visualización de la lista**:
   - Se llama al método `visualizar()` para imprimir la lista original.

3. **Ordenación de la lista**:
   - Se utiliza el método `ordenarLista()` para ordenar los elementos de la lista.

4. **Unión de dos listas**:
   - Se crea otra lista y se unen ambas listas usando el método `unirListas()`.

5. **Separación de números pares e impares**:
   - Se separan los números en dos listas diferentes y se visualizan ambas listas.

### Ejemplo de Código

```java
public class Principal {
    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.insertarCabezaLista(5);
        lista.insertarCabezaLista(3);
        lista.insertarCabezaLista(1);
        lista.insertarCabezaLista(4);
        lista.insertarCabezaLista(2);
        
        System.out.println("Lista original:");
        lista.visualizar();

        // Ordenar la lista
        lista.ordenarLista();
        System.out.println("Lista ordenada:");
        lista.visualizar();

        // Unir con otra lista
        Lista otraLista = new Lista();
        otraLista.insertarCabezaLista(10);
        otraLista.insertarCabezaLista(8);
        otraLista.insertarCabezaLista(9);
        
        System.out.println("Otra lista:");
        otraLista.visualizar();

        lista.unirListas(otraLista);
        System.out.println("Lista unida:");
        lista.visualizar();

        // Separar números pares e impares
        Lista[] listasSeparadas = lista.separarParesImpares();
        System.out.println("Lista de números pares:");
        listasSeparadas[0].visualizar();
        System.out.println("Lista de números impares:");
        listasSeparadas[1].visualizar();
    }
}
