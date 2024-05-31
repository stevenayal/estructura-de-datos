package listas;

/**
 * Interfaz que define las operaciones de un Iterador Generico
 *
 * @param <TipoDeDato> Tipo de Dato almacenado en la coleccion sobre la que se va a iterar.
 * @author Prof. Derlis Zarate (profderliszarate@gmail.com)
 * @author Prof. Saúl Zalimben (szalimben93@gmail.com)
 */
public interface InterfazIterador<TipoDeDato> {

    /**
     * Metodo que se posiciona al inicio de la coleccion de datos
     */
    void first();

    /**
     * Metodo que indica con TRUE o FALSE si es que aun existen datos en la coleccion
     * que no fueron visitados por el iterador. Cuando llega al final de la coleccion, retorna FALSE
     *
     * @return TRUE o FALSE
     */
    boolean hasNext();

    /**
     * Metodo que retorna el siguiente dato almacenado en la coleccion, siempre y cuando
     * aun existan datos pendientes de ser visitados.
     *
     * @return Dato almacenado en la coleccion
     */
    TipoDeDato next();
}
