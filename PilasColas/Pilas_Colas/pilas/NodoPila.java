package pilas;

/**
 * Clase que representa un Nodo de una Pila
 *
 * @param <TipoDeDato> Tipo de Dato a almacenar dentro del nodo.
 * @author Prof. Derlis Zarate (profderliszarate@gmail.com)
 * @author Prof. Saúl Zalimben (szalimben93@gmail.com)
 */
public class NodoPila<TipoDeDato> {
    
    TipoDeDato dato;
    NodoPila<TipoDeDato> siguiente;

    /**
     * @return the dato
     */
    public TipoDeDato getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(TipoDeDato dato) {
        this.dato = dato;
    }

    /**
     * @return the siguiente
     */
    public NodoPila<TipoDeDato> getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoPila<TipoDeDato> siguiente) {
        this.siguiente = siguiente;
    }
    
}
