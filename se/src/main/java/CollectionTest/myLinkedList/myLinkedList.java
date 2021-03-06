package CollectionTest.myLinkedList;

// LinkedList class
// http://javist.ru/svyazannyj-spisok-realizacii-v-java/
// CONSTRUCTION: with no initializer
// Access is via LinkedListIterator class
//
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
 * <p>
 * using a header node.
 * <p>
 * Access to the list is via LinkedListIterator.
 *
 * @author Mark Allen Weiss
 * @see LinkedListIterator
 */

public class myLinkedList {
    private ListNode header;

    /** Construct the list  */
    public myLinkedList() {
        header = new ListNode(null);
    }

    /**
     * Test if the list is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return header.next == null;
    }

    /**
     * Make the list logically empty.
     */
    public void makeEmpty() {
        header.next = null;
    }

    /**
     * Return an iterator representing the header node.
     */
    public LinkedListIterator zeroth() {
        return new LinkedListIterator(header);
    }

    /**
     * Return an iterator representing the first node in the list.
     * <p>
     * This operation is valid for empty lists.
     */
    public LinkedListIterator first() {
        return new LinkedListIterator(header.next);
    }

    /**
     * Insert after p.
     * @param x the item to insert.
     * @param p the position prior to the newly inserted item.
     */

    public void insert(Object x, LinkedListIterator p) {
        if (p != null && p.current != null)
            p.current.next = new ListNode(x, p.current.next);
    }

    /**
     * Return iterator corresponding to the first node containing an item.
     * @param x the item to search for.
     * @return an iterator; iterator is not valid if item is not found.
     */

    public LinkedListIterator find(Object x) {
        ListNode itr = header.next;
        while (itr != null && !itr.element.equals(x))
            itr = itr.next;
        return new LinkedListIterator(itr);
    }

    /**
     * Return iterator prior to the first node containing an item.
     * @param x the item to search for.
     * @return appropriate iterator if the item is found. Otherwise, the
     * <p>
     * iterator corresponding to the last element in the list is returned.
     */

    public LinkedListIterator findPrevious(Object x) {
        ListNode itr = header;
        while (itr.next != null && !itr.next.element.equals(x))
            itr = itr.next;
        return new LinkedListIterator(itr);
    }

    /**
     * Remove the first occurrence of an item.
     * @param x the item to remove.
     */

    public void remove(Object x) {
        LinkedListIterator p = findPrevious(x);
        if (p.current.next != null)
            p.current.next = p.current.next.next;  // Bypass deleted node
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

    public static int listSize(myLinkedList theList) {

        LinkedListIterator itr;

        int size = 0;


        for (itr = theList.first(); itr.isValid(); itr.advance())

            size++;


        return size;

    }
}