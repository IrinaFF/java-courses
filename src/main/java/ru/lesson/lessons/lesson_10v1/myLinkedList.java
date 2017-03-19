package ru.lesson.lessons.lesson_10v1;

// LinkedList class
// http://javist.ru/svyazannyj-spisok-realizacii-v-java/
// CONSTRUCTION: with no initializer
// Access is via LinkedListIterator class
// ******************PUBLIC OPERATIONS*********************
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// LinkedListIterator zeroth( )
//                        --> Return position to prior to first
// LinkedListIterator first( )
//                        --> Return first position
// void insert( x, p )    --> Insert x after current iterator position p
// void remove( x )       --> Remove x
// LinkedListIterator find( x )
//                        --> Return position that views x
// LinkedListIterator findPrevious( x )
//                        --> Return position prior to x
// ******************ERRORS********************************
// No special errors

/**
 * Linked list implementation of the list
 * using a header node.
 * Access to the list is via LinkedListIterator.
 * @author Mark Allen Weiss
 * @see LinkedListIterator
 */

public class myLinkedList<T> {
    //private ListNode header;
    ListNode<T> first;
    ListNode<T> last;
    int size = 0;

    /** Construct the list  */
    public myLinkedList() {
        //header = new ListNode(null);
    }

    /**
     * Links e as last element.
     */
    void linkLast(T t) {
        final ListNode<T> l = last;
        final ListNode<T> newNode = new ListNode<>(l, t, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    //public void addFirst (T x) {
    //insert(x, new LinkedListIterator(header));
    //size++;
    //}

    /**
     * Return iterator corresponding to the first node containing an item.
     * @param x the item to search for.
     * @return an iterator; iterator is not valid if item is not found.
     */

    public LinkedListIterator find(T x) {
        //ListNode itr = header.next;
        ListNode itr = first;
        while (itr != null && !itr.element.equals(x))
            itr = itr.next;
        return new LinkedListIterator(itr);
    }
    /**
     * Remove the first occurrence of an item.
     * @param x the item to remove.
     */
    public void remove (T x) {
        LinkedListIterator p = find(x);
        final T element = (T) p.current.element;
        final ListNode<T> next = p.current.next;
        final ListNode<T> prev = p.current.prev;
        if (prev == null) {
            first = next;
        }
        else {
            prev.next = next;
            p.current.prev = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            p.current.next = null;
        }
            p.current.element = null;
            size--;
    }


    public void printList() {
        if (this.isEmpty())
            System.out.print("Empty list");
        else {
            LinkedListIterator itr = this.first();
            for (; itr.isValid(); itr.advance())
                System.out.print(itr.retrieve() + " ");
        }
        System.out.println();
    }

    public void printFirst() {
        LinkedListIterator itr = this.first();
        System.out.println("first: " + itr.retrieve());

    }
    public void printLast() {
        LinkedListIterator itr = this.last();
        System.out.println("last: " + itr.retrieve());
    }

    /**
     * Test if the list is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        //return header.next == null;
        return ((first == null) && (last == null) && (size == 0));
    }

    /**
     * Make the list logically empty.
     */
    public void makeEmpty() {
        //header.next = null;
        //size = 0;
        for (ListNode<T> x = first; x != null; ) {
            ListNode<T> next = x.next;
            x.element = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    /**
     * Return an iterator representing the first node in the list.
     * <p>
     * This operation is valid for empty lists.
     */
    public LinkedListIterator first() {
        //return new LinkedListIterator(header.next);
        return new LinkedListIterator(first);
    }

    public LinkedListIterator last() {
        //return new LinkedListIterator(header.next);
        return new LinkedListIterator(last);
    }

    // Simple print method
    public static void printList(myLinkedList theList) {
        if (theList.isEmpty())
            System.out.print("Empty list");
        else {
            LinkedListIterator itr = theList.first();
            for (; itr.isValid(); itr.advance())
                System.out.print(itr.retrieve() + " ");
        }
        System.out.println();
    }

    // In this routine, LinkedList and LinkedListIterator are the
    // classes written in Section 17.2.
    public int size() {
        return size;
    }

    private static class ListNode<T> {
        public T element;
        public ListNode<T> next;
        public ListNode<T> prev;

        // Constructors
        public ListNode(T theElement) {
            this(null, theElement, null);
        }

        public ListNode(ListNode<T> p, T theElement, ListNode<T> n) {
            element = theElement;
            prev = p;
            next = n;
        }
    }

    public static class LinkedListIterator<T> {

        ListNode<T> current;    // Current position

        /**
         * Construct the list iterator
         * @param theNode any node in the linked list.
         */
        LinkedListIterator(ListNode<T> theNode) {
            current = theNode;
        }

        /**
         * Test if the current position is a valid position in the list.
         * @return true if the current position is valid.
         */
        public boolean isValid() {
            return current != null;
        }

        /**
         * Return the item stored in the current position.
         * @return the stored item or null if the current position
         * <p>
         * is not in the list.
         */
        public T retrieve() {
            return isValid() ? (T) current.element : null;
        }

        /**
         * Advance the current position to the next node in the list.
         * <p>
         * If the current position is null, then do nothing.
         */
        public void advance() {
            if (isValid())
                current = current.next;
        }

        public void retreat() {
            if (isValid())
                current = current.prev;
        }
    }
}
/**
 * Insert after p.
 * @param x the item to insert.
 * @param p the position prior to the newly inserted item.
 */

//    public void insert_old(T x, LinkedListIterator p) {
//        if (p != null && p.current != null)
//            p.current.next = new ListNode(p.current, x, p.current.next);
//        size++;
//    }

//    public void remove_old(T x) {
//        LinkedListIterator p = findPrevious(x);
//        if (p.current.next != null) {
//            p.current.next = p.current.next.next;  // Bypass deleted node
//            size--; }
//    }
/**
 * Return iterator prior to the first node containing an item.
 * @param x the item to search for.
 * @return appropriate iterator if the item is found. Otherwise, the
 * <p>
 * iterator corresponding to the last element in the list is returned.
 */

//    public LinkedListIterator findPrevious(T x) {
//        //ListNode itr = header;
//        ListNode itr = first;
//        //while (itr.next != null && !itr.next.element.equals(x))
//        while (itr != null && !itr.element.equals(x))
//            itr = itr.next;
//        return new LinkedListIterator(itr);
//    }
/**
 * Return an iterator representing the header node.
 */
//public LinkedListIterator zeroth() {
//    return new LinkedListIterator(header);
//}
//    public static int listSize(myLinkedList theList) {
//        LinkedListIterator itr;
//        int size = 0;
//        for (itr = theList.first(); itr.isValid(); itr.advance())
//            size++;
//        return size;
//    }