package colas;

/**
 * Clase que representa un Nodo de una Cola
 *
 * @param <TipoDeDato> Tipo de Dato a almacenar dentro del nodo.
 * @author Prof. Derlis Zarate (profderliszarate@gmail.com)
 * @author Prof. Saúl Zalimben (szalimben93@gmail.com)
 */
public class NodoCola<TipoDeDato> {
    
    Cliente dato;
    NodoCola<TipoDeDato> siguiente;

    /**
     * @return the dato
     */
    public Cliente getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(Cliente dato) {
        this.dato = dato;
    }

    /**
     * @return the siguiente
     */
    public NodoCola<TipoDeDato> getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoCola<TipoDeDato> siguiente) {
        this.siguiente = siguiente;
    }
    
}
