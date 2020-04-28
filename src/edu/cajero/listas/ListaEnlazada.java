package edu.cajero.listas;

public class ListaEnlazada<T> {
    private class Node<T>
    {
        private T data;
        private Node<T> next;

        public Node( )
        {
            data = null;
            next = null;
        }
        public Node (T newData, Node<T> linkValue)
        {
            data = newData;
            next = linkValue;
        }
    }
    private Node<T> head;
    private int size = 0;

    public ListaEnlazada()
    {
        head = null;
    }

    /**
     * Agrega un nodo al comienzo de la lista con el dato especificado
     * @param item El item a insertar
     */
    public void addFirst(T item)
    {
        head = new Node<T> (item, head);
        size++;
    }

    /**
     * Agrega un nodo despues de un nodo dado
     * @param node El nodo precedente al nuevo item
     * @param item El item a insertar
     */
    private void addAfter(Node<T> node, T item){
        node.next = new Node<T>(item,node.next);
        size++;
    }

    /**
     * Inserta un item especificado en el indice
     * @param index La posición donde el item sera insertado
     * @param item El item a ser insertado
     * @throws IndexOutOfBoundsException si el item esta fuera de rango
     */
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            addFirst(item);
        } else {
            Node<T> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    /**
     * Agrega un item al final de la lista
     * @param item El item que sera agregado
     * @return true
     */
    public boolean add(T item) {
        add(size, item);
        return true;
    }

    /**
     * Remueve el primer elemento de la lista
     * @return The dato del nodo eliminado o null si la lista esta vacía
     */
    private T removeFirst() {
        Node<T> temp = head;
        if (head != null) {
            head = head.next;
        }
        if (temp != null) {
            size--;
            return temp.data;
        } else {
            return null;
        }
    }

    /**
     * Elimina un nodo despues de un nodo dado
     * @param node El nodo anterior al nodo que se removera
     * @return El dato del nodo eliminado, o null sí no hay nodo a eliminar
     */
    private T removeAfter(Node<T> node) {
        Node<T> temp = node.next;
        if (temp != null) {
            node.next = temp.next;
            size--;
            return temp.data;
        } else {
            return null;
        }
    }

    /**
     * Remueve el nodo con indice index
     * @param index
     * @return La entrada eliminada
     */
    public T remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if(index == 0)
            return removeFirst();
        else {
            return removeAfter(getNode(index - 1));
        }
    }

    public boolean remove(T item){
        if (!contains(item))
            return  false;
        else
            remove(indexOf(item));
        return  true;
    }

    /**
     * Devuelve el número de nodos en la lista
     */
    public int size()
    {
        return size;
    }

    public boolean contains(T item)
    {
        return (find(item) != null);
    }

    /**
     * Encuentra el primer nodo conteniendo el item target, y retorna una referencia al nodo. Sí el target
     * no esta en la lista, null es devuelto
     */
    private Node find(T target)
    {
        Node<T> position = head;
        T itemAtPosition;
        while (position != null)
        {
            itemAtPosition = position.data;
            if (itemAtPosition.equals(target))
                return position;
            position = position.next;
        }
        return null;
    }

    /**
     * Busca el objetivo y retorna la posición de la primera coincidencia, o -1 si no esta en la lista
     * @param target entrada a buscar
     * @return la posición desde el header de la lista, -1 si no esta en la lista
     */
    public int indexOf(T target){
        Node<T> position = head;
        T itemAtPosition;
        Integer pos = 0;
        while (position != null)
        {
            itemAtPosition = position.data;
            if (itemAtPosition.equals(target))
                return pos;
            position = position.next;
            pos++;
        }
        return -1;
    }

    /**
     * Encuentra el primer nodo conteniendo el item target, y retorna una referencia al dato en ese nodo. Sí el target
     * no esta en la lista, null es devuelto
     */
    public T findData(T target)
    {
        Node<T> result = find(target);
        if (result == null)
            return null;
        else
            return result.data;
    }

    public void outputList()
    {
        Node<T> position = head;
        while (position != null)
        {
            System.out.printf("%s\n\n",position.data);
            position = position.next;
        }
    }

    /**
     * Retorna true sí la lista esta vacía
     */
    public boolean isEmpty( )
    {
        return (head == null);
    }

    /**
     * Elimina todos los elementos de la lista
     */
    public void clear( )
    {
        head = null;
    }



    /**
     * Encuentra el nodo en la posición especificada
     * @param index La posición del nodo buscado
     * @return El indice del nodo o null sí este nodo no existe
     */
    private Node<T> getNode(int index) {
        Node<T> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * Captura el dato del indice
     * @param index La posición del dato a retornar
     * @return El dato en el indice
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<T> node = getNode(index);

        return node.data;
    }

    /**
     * Almacena una referencia a una entrada en el elemento en la posición index
     * @param index La posición del item a cambiar
     * @param newValue El dato nuevo
     * @return El dato previo del indice
     * @throws IndexOutOfBoundsException si el indice esta por fuera del rango
     */
    public T set(int index, T newValue) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<T> node = getNode(index);
        T result = node.data;
        node.data = newValue;
        return result;
    }

}
