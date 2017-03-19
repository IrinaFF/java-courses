package CollectionTest.myLinkedList;

// Basic node stored in a linked list
// Note that this class is not accessible outside
// of package weiss.nonstandard

class ListNode<T> {
    // Constructors
    public ListNode(T theElement) {
        this(theElement, null);
    }

    public ListNode(T theElement, ListNode n) {
        element = theElement;
        next = n;
    }

    public T element;
    public ListNode next;
}