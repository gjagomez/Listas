package umg.edu.progra.listas;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Walter Cordova
 */
public class Lista {

    private Nodo primero;

    @Override
    public String toString() {
        return "=>" + primero;
    }

    /**
     * Constructor para inicializar una lista
     */
    public Lista() {
        primero = null;
    }

    /**
     * Devuelve el nodo inicial
     *
     * @return
     */
    public Nodo leerPrimero() {
        return primero;
    }

    /**
     * Inserta valores a la lista
     *
     * @param entrada
     */
    public void insertarCabezaLista(int entrada) {
        Nodo nuevo = new Nodo(entrada);
        nuevo.enlace = primero;
        primero = nuevo;
    }

    /**
     * Inserta un elemento a partir de anterior
     *
     * @param anterior
     * @param entrada
     */
    public void insertarLista(Nodo anterior, int entrada) {
        Nodo nuevo = new Nodo(entrada);
        nuevo.enlace = anterior.enlace;
        anterior.enlace = nuevo;
    }

    /**
     * Elimina el elemento entrada
     *
     * @param entrada
     */
    public void eliminar(int entrada) {
        Nodo actual = primero;
        Nodo anterior = null;

        while (actual != null && actual.dato != entrada) {
            anterior = actual;
            actual = actual.enlace;
        }
        if (actual != null) {
            if (actual == primero) {
                primero = actual.enlace;
            } else {
                anterior.enlace = actual.enlace;
            }
            actual = null;
        }
    }

    /**
     * Busca el elemento destino
     *
     * @param destino
     * @return
     */
    public Nodo buscarLista(int destino) {
        Nodo indice;
        for (indice = primero; indice != null; indice = indice.enlace) {
            if (indice.dato == destino) {
                return indice;
            }
        }
        return null;
    }

    /**
     * Recorre la lista y muestra cada dato
     */
    public void visualizar() {
        Nodo n = primero;
        while (n != null) {
            System.out.print(n.dato + " ");
            n = n.enlace;
        }
        System.out.println(); // Para nueva línea después de visualizar
    }

    /**
     * 1 - Método para invertir la lista enlazada
     */
    public void invertirLista() {
        Nodo anterior = null;
        Nodo actual = primero;
        Nodo siguiente;

        while (actual != null) {
            siguiente = actual.enlace; // Guarda el siguiente nodo
            actual.enlace = anterior;   // Invertir el enlace
            anterior = actual;          // Mover anterior hacia adelante
            actual = siguiente;         // Mover actual hacia adelante
        }
        primero = anterior; // Actualizar el primero
    }

    /**
     * 2 - Método para obtener el elemento en la posición n desde el final
     *
     * @param n La posición desde el final 
     * @return El nodo en la posición n desde el final, o null si no existe
     */
    public Nodo obtenerDesdeElFinal(int n) {
        Nodo actual = primero;
        Nodo referencia = primero;

        // Mover 'referencia' n pasos adelante
        for (int i = 0; i < n; i++) {
            if (referencia == null) {
                return null; // Si n es mayor que el tamaño de la lista
            }
            referencia = referencia.enlace;
        }

        // Mover ambos nodos hasta que 'referencia' llegue al final
        while (referencia != null) {
            actual = actual.enlace;
            referencia = referencia.enlace;
        }
        return actual; // 'actual' ahora está en la posición n desde el final
    }

    /**
     * 3 - Método para eliminar duplicados en una lista enlazada
     */
    public void eliminarDuplicados() {
        Set<Integer> seen = new HashSet<>();
        Nodo actual = primero;
        Nodo anterior = null;

        while (actual != null) {
            if (seen.contains(actual.dato)) {
                anterior.enlace = actual.enlace; // Eliminar el nodo duplicado
            } else {
                seen.add(actual.dato);
                anterior = actual; // Solo avanzar si no es duplicado
            }
            actual = actual.enlace; // Avanzar al siguiente nodo
        }
    }

    /**
     * 4 - Método para obtener el tamaño de la lista enlazada
     *
     * @return El tamaño de la lista
     */
    public int obtenerTamaño() {
        int tamaño = 0;
        Nodo actual = primero;

        while (actual != null) {
            tamaño++;
            actual = actual.enlace;
        }
        return tamaño;
    }

    
      /**
     * EJERCICIO DENTRO DE LA CLASE PRINCIPAL
     */
    
    
    /**
     * Ejercicio 1: Ordenar la lista de forma ascendente
     */
    public void ordenarLista() {
        if (primero == null || primero.enlace == null) {
            return; // La lista está vacía o tiene un solo elemento
        }

        Nodo actual, siguiente;
        boolean intercambiado;

        do {
            actual = primero;
            intercambiado = false;

            while (actual.enlace != null) {
                siguiente = actual.enlace;
                if (actual.dato > siguiente.dato) {
                    // Intercambiar datos
                    int temp = actual.dato;
                    actual.dato = siguiente.dato;
                    siguiente.dato = temp;
                    intercambiado = true;
                }
                actual = siguiente;
            }
        } while (intercambiado);
    }

    /**
     * Ejercicio 2: Unir dos listas enlazadas
     *
     * @param otraLista La otra lista a unir
     */
    public void unirListas(Lista otraLista) {
        if (otraLista != null && otraLista.leerPrimero() != null) {
            Nodo actual = otraLista.leerPrimero();
            while (actual != null) {
                insertarCabezaLista(actual.dato); // Inserta al inicio
                actual = actual.enlace;
            }
        }
    }

    /**
     * Ejercicio 3: Separar números pares e impares en dos listas enlazadas diferentes
     *
     * @return Un arreglo con dos listas: [listaPares, listaImpares]
     */
    public Lista[] separarParesImpares() {
        Lista listaPares = new Lista();
        Lista listaImpares = new Lista();
        Nodo actual = primero;

        while (actual != null) {
            if (actual.dato % 2 == 0) {
                listaPares.insertarCabezaLista(actual.dato);
            } else {
                listaImpares.insertarCabezaLista(actual.dato);
            }
            actual = actual.enlace;
        }
        return new Lista[]{listaPares, listaImpares};
    }
}
