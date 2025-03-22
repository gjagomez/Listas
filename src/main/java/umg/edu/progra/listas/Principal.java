package umg.edu.progra.listas;

/**
 *
 * @author Walter Cordova
 */

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

        // Ejercicio 1: Ordenar la lista de forma ascendente
        lista.ordenarLista();
        System.out.println("Lista ordenada:");
        lista.visualizar();

        // Ejercicio 2: Unir dos listas enlazadas
        Lista otraLista = new Lista();
        otraLista.insertarCabezaLista(10);
        otraLista.insertarCabezaLista(8);
        otraLista.insertarCabezaLista(9);
        
        System.out.println("Otra lista:");
        otraLista.visualizar();

        lista.unirListas(otraLista);
        System.out.println("Lista unida:");
        lista.visualizar();

        // Ejercicio 3: Separar números pares e impares
        Lista[] listasSeparadas = lista.separarParesImpares();
        System.out.println("Lista de numeros pares:");
        listasSeparadas[0].visualizar();
        System.out.println("Lista de numeros impares:");
        listasSeparadas[1].visualizar();
    }
}
