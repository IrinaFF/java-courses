package ru.lesson.lessons.lesson_10v1;

// LinkedListIterator class; maintains "current position"
// CONSTRUCTION: Package visible only, with a ListNode
// ******************PUBLIC OPERATIONS*********************
// void advance( )        --> Advance
// boolean isValid( )     --> True if at valid position in list
// Object retrieve        --> Return item in current position

/**
 * Linked list implementation of the list iterator
 * <p>
 * using a header node.
 * @author Mark Allen Weiss
 * @see myLinkedList
 */

public class LinkedListIterator<T> {

    ListNode current;    // Current position

    /**
     * Construct the list iterator
     * @param theNode any node in the linked list.
     */
    LinkedListIterator(ListNode theNode) {
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
}
