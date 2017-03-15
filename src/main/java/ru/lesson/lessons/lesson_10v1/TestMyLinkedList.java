package ru.lesson.lessons.lesson_10v1;

/**
 * http://javist.ru/svyazannyj-spisok-realizacii-v-java/
 * @autor irinaff
 * @since 15.03.2017
 **/

public class TestMyLinkedList {
    public static void main(String[] args) {
        myLinkedList theList = new myLinkedList();
        LinkedListIterator theItr;
        int i;
        theItr = theList.zeroth();
        theList.printList();

        for (i = 0; i < 10; i++) {
            theList.insert(new Integer(i), theItr);
            theList.printList();
            theItr.advance();
        }

        System.out.println("Size was: " + theList.listSize(theList));

        for (i = 0; i < 10; i += 2)
            theList.remove(new Integer(i));

        for (i = 0; i < 10; i++) {
            //System.out.println("i=" + i);
            if ((i % 2 == 0) == (theList.find(new Integer(i)).isValid()))
                System.out.println("Find fails!");
            //if (i % 2 == 0) System.out.println("i % 2 == 0");
            //if (theList.find(new Integer(i)).isValid()) System.out.println("theList.find(new Integer(i)).isValid())");
        }

        System.out.println("Finished deletions");
        theList.printList();

        myLinkedList PersonList = new myLinkedList();
        theItr = PersonList.zeroth();
        PersonList.printList();
        for (i = 0; i < 10; i++) {
            theList.insert(new Person("Petr_"+i), theItr);
            PersonList.printList();
            theItr.advance();
        }
        PersonList.printList();
    }
}
