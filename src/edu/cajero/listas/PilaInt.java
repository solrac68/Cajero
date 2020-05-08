package edu.cajero.listas;

public interface PilaInt<T> {
    /**Empuja un elemento en la pSarte superior de la pila y regresa
     el artículo empujado.
     @param obj El objeto a insertar
     @return El objeto insertado
     */
    T push(T obj);
    /** REtorna el objeto de la parte superior de la pila sin remover este.
     @post La pila permanece sin modificar.
     @return El objeto de la parte superior d ela pila
     @throws NoSuchElementException Sí la pila esta vacía
     */
    T peek();
    /** Retorna el objeto de la parte superior de la pila y remueve este.
     @post La pila es un item mas pequeño.
     @return El objeto de la parte superior de la pila
     @throws NoSuchElementException Sí la pila esta vacía
     */
    T pop();
    /** Retorna True,
     returns false.
     @return true (false) if the stack is empty (not empty)
     */
    boolean isEmpty();

    /**
     * Retorna el numero de elementos en la pila
     * @return el número de elemntos en la pila
     */
    int size();
}
