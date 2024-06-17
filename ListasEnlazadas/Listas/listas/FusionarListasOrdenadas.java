package listas;

public class FusionarListasOrdenadas {
    public static ListaEnlazadaSimple<Integer> fusionarListasOrdenadas(ListaEnlazadaSimple<Integer> list1, ListaEnlazadaSimple<Integer> list2) {
        ListaEnlazadaSimple<Integer> listaFusionada = new ListaEnlazadaSimple<>();
        NodoLista<Integer> nodo1 = list1.getPrimero();
        NodoLista<Integer> nodo2 = list2.getPrimero();

        while (nodo1 != null && nodo2 != null) {
            if (nodo1.getDato() < nodo2.getDato()) {
                listaFusionada.insertar(nodo1.getDato());
                nodo1 = nodo1.getSiguiente();
            } else if (nodo1.getDato() > nodo2.getDato()) {
                listaFusionada.insertar(nodo2.getDato());
                nodo2 = nodo2.getSiguiente();
            } else {
                listaFusionada.insertar(nodo1.getDato());
                nodo1 = nodo1.getSiguiente();
                listaFusionada.insertar(nodo2.getDato());
                nodo2 = nodo2.getSiguiente();
            }
        }

        // Agregar elementos restantes de list1
        while (nodo1 != null) {
            listaFusionada.insertar(nodo1.getDato());
            nodo1 = nodo1.getSiguiente();
        }

        // Agregar elementos restantes de list2
        while (nodo2 != null) {
            listaFusionada.insertar(nodo2.getDato());
            nodo2 = nodo2.getSiguiente();
        }

        return listaFusionada;
    }

    public static void main(String[] args) {
        ListaEnlazadaSimple<Integer> list1 = new ListaEnlazadaSimple<>();
        list1.insertar(1);
        list1.insertar(2);
        list1.insertar(4);

        ListaEnlazadaSimple<Integer> list2 = new ListaEnlazadaSimple<>();
        list2.insertar(1);
        list2.insertar(3);
        list2.insertar(4);

        ListaEnlazadaSimple<Integer> listaFusionada = fusionarListasOrdenadas(list1, list2);
        System.out.println("Tamaño de la lista fusionada: " + listaFusionada.getTamanoLista());

        NodoLista<Integer> nodoActual = listaFusionada.getPrimero();
        int posicion = 1;
        while (nodoActual != null) {
            System.out.println("Elemento en la posición " + posicion + ": " + nodoActual.getDato());
            nodoActual = nodoActual.getSiguiente();
            posicion++;
        }
    }
}