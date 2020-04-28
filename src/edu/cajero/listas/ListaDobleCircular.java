package edu.cajero.listas;

public class ListaDobleCircular<T> {
    private class Node<T>
    {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node( )
        {
            data = null;
            next = null;
            prev = null;
        }
        public Node (T newData)
        {
            data = newData;
        }
    }
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public ListaDobleCircular()
    {
        head = null;
        tail = null;
    }

    /**
     * Agrega un nodo al comienzo de la lista con el dato especificado
     * @param item El item a insertar
     */
    public void addFirst(T item)
    {
        // Crea  nuevo nudo
        Node<T> new_node = new Node<>(item);

        // Hace el next del nuevo nudo como la cabeza y el previo como null
        new_node.next = head;
        new_node.prev = tail;

        // Se cambia el prev de la nodo cabeza al nuevo nudo
        if (head != null)
            head.prev = new_node;
        if (tail != null)
            tail.next = new_node;

        head = new_node;

        if (size == 0){
            tail = new_node;
            head.next = head;
            tail.prev = tail;
        }

        size++;


    }

    /**
     * Agrega un nodo despues de un nodo dado
     * @param node El nodo precedente al nuevo item
     * @param item El item a insertar
     */
    private void addAfter(Node<T> node, T item){
        if (node == null) {
            System.out.println("The given previous node cannot be NULL ");
            return;
        }

        // Se crea el nodo nuevo
        Node<T> new_node = new Node<>(item);

        /* 4. Hace el next del nuevo node como next del prev_node */
        new_node.next = node.next;

        /* 5. Hace el next del prev_node como new_node */
        node.next = new_node;

        /* 6. Hace prev_node como el prev del new_node */
        new_node.prev = node;

        /* 7. Cambia el prev del next del nodo new_node */
        if (new_node.next != null)
            new_node.next.prev = new_node;
        if (node == tail)
            tail = new_node;

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



    private T remove(Node<T> node) {
        if (node != null) {
            if(node == tail){
                tail = node.prev;
                tail.next = head;
                head.prev = tail;
            }
            else if(node == head){
                head = head.next;
                head.prev = tail;
                tail.next = head;
            }
            else{
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size--;
            return node.data;
        } else {
            return null;
        }
    }


    /**
     * Remueve el nodo con indice index
     * @param index
     * @return La entrada eliminada
     */
    T remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<T> nodeR = getNode(index);
        return remove(nodeR);
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
        do{
            itemAtPosition = position.data;
            if (itemAtPosition.equals(target))
                return position;
            position = position.next;
        } while (position != head);

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
        do {
            itemAtPosition = position.data;
            if (itemAtPosition.equals(target))
                return pos;
            position = position.next;
            pos++;
        } while (position != head);
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

        do{
            System.out.printf("%s\n",position.data);
            position = position.next;
        } while (position != head);
    }

    public void outputListReverse()
    {
        Node<T> position = tail;

        do{
            System.out.printf("%s\n",position.data);
            position = position.prev;
        } while (position != tail);
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
    public void clear()
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
