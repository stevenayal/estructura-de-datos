package listas;

public class ListaUtils {
    public static <T extends Number> int sumaElementosLista(ListaEnlazadaSimple<T> lista) {
        int suma = 0;
        IteradorLista<T> iterador = lista.getIterador();
        while (iterador.hasNext()) {
            suma += iterador.next().intValue();
        }
        return suma;
    }
}