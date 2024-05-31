package pilas;

/**
 * Interfaz que define las operaciones de una Pila
 *
 * @param <TipoDeDato> Tipo de Dato a almacenar dentro de la pila
 * @author Prof. Derlis Zarate (profderliszarate@gmail.com)
 * @author Prof. Saúl Zalimben (szalimben93@gmail.com)
 */
public interface InterfazPila<TipoDeDato> {
        
    void apilar(TipoDeDato dato);
    
    TipoDeDato desapilar();
    
    TipoDeDato obtenerTope();
    
    void anular();
    
    int tamanoPila();
        
    boolean esVacia();
    
}
