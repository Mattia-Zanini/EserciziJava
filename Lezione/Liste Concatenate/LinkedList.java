public class LinkedList<E> implements Container {
    private ListNode<E> head, tail;

    // costruttore
    public LinkedList() {
        makeEmpty();
    }

    // metodi di Container
    public void makeEmpty() {
        head = tail = new ListNode<E>();
    }

    public boolean isEmpty() {
        return (head == tail);
    }

    // metodi di accesso
    public E getFirst() { // operazione O(1)
        if (isEmpty()) {
            throw new EmptyLinkedListException();
        }
        return head.getNext().getElement();
    }

    public E getLast() { // operazione O(1)
        if (isEmpty()) {
            throw new EmptyLinkedListException();
        }
        return tail.getElement();
    }

    // metodi modificatori di inserimento
    public void addFirst(E e) {
        head.setElement(e);
        ListNode<E> oldHead = head;
        head = new ListNode<E>(null, head, null);
        oldHead.setPrevious(head);
    }

    public void addLast(E e) {
        tail.setNext(new ListNode<E>(e, null, tail));
        tail = tail.getNext();
    }

    // metodi modificatori di rimozione
    public E removeFirst() {
        E e = getFirst();
        head = head.getNext();
        head.setElement(null);
        return e;
    }

    public E removeLast() {
        E e = getLast();
        ListNode<E> temp = head;
        while (temp.getNext() != tail) {
            temp = temp.getNext();
        }
        tail = temp;
        tail.setNext(null);
        return e;
    }

    public String toString() {
        String s = "[";
        ListNode<E> tmp = head;
        while (true) {
            if (isEmpty())
                break;
            tmp = tmp.getNext();
            s += " " + tmp.getElement() + " ";

            if (tmp.getNext() == null)
                break;
        }
        return s + "]";
    }

    public void printDebug() {
        ListNode<E> tmp = head;
        boolean stop = false;
        for (int i = 0; !stop; i++) {
            if (isEmpty())
                break;
            if (tmp.getNext() == null)
                stop = true;

            System.out.printf("Node[%d]\n%s\n\n", i, tmp.getNodeInfo());
            tmp = tmp.getNext();
        }
    }

    public void printReverseDebug() {
        ListNode<E> tmp = tail;
        boolean stop = false;
        for (int i = 0; !stop; i++) {
            if (isEmpty())
                break;
            if (tmp.getPrevious() == null)
                stop = true;

            System.out.printf("Node[%d]\n%s\n\n", i, tmp.getNodeInfo());
            tmp = tmp.getPrevious();
        }
    }

    // classe interna privata che descrive il nodo della lista
    private class ListNode<E> {
        private E element; // riferimento al dato
        private ListNode<E> next; // riferimento al nodo successivo
        private ListNode<E> previous; // riferimento al nodo successivo

        public ListNode(E e, ListNode<E> n, ListNode<E> p) {
            element = e;
            next = n;
            previous = p;
        }

        public ListNode() {
            element = null;
            next = null;
            previous = null;
        }

        public E getElement() {
            return element;
        }

        public ListNode<E> getNext() {
            return next;
        }

        public ListNode<E> getPrevious() {
            return previous;
        }

        public void setElement(E e) {
            element = e;
        }

        public void setNext(ListNode<E> n) {
            next = n;
        }

        public void setPrevious(ListNode<E> p) {
            previous = p;
        }

        public String getNodeInfo() {
            String s = new String();
            s = "e => " + element +
                    "\nthis => " + this +
                    "\nnext => " + next +
                    "\nprevious => " + previous;
            return s;
        }
    }
}

class EmptyLinkedListException extends RuntimeException {
}