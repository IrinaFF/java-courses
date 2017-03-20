package ru.lesson.lessons.lesson_10v1;


/**
 * http://javist.ru/svyazannyj-spisok-realizacii-v-java/
 * @autor irinaff
 * @since 15.03.2017
 **/

public class TestMyLinkedList {
    public static void main(String[] args) {
        myLinkedList theList = new myLinkedList();
        myLinkedList.LinkedListIterator theItr;
        int i;
        //theItr = theList.zeroth();
        theList.printList();

        for (i = 0; i < 10; i++) {
            //theList.insert(new Integer(i), theItr);
            theList.add(new Integer(i));
            theList.printList();
            //theItr.advance();
        }

        //System.out.println("Size was: " + theList.listSize(theList));
        System.out.println("Size was (2): " + theList.size());

        for (i = 0; i < 10; i += 2)
            theList.remove(new Integer(i));

        //System.out.println("Size was: " + theList.listSize(theList));
        System.out.println("Size was (2): " + theList.size());

        for (i = 0; i < 10; i++) {
            //System.out.println("i=" + i);
            if ((i % 2 == 0) == (theList.find(new Integer(i)).isValid()))
                System.out.println("Find fails!");
            //if (i % 2 == 0) System.out.println("i % 2 == 0");
            //if (theList.find(new Integer(i)).isValid()) System.out.println("theList.find(new Integer(i)).isValid())");
        }

        System.out.println("Finished deletions");
        theList.printList();

        myLinkedList personList = new myLinkedList();
        //theItr = personList.zeroth();
        personList.printList();
        for (i = 0; i < 10; i++) {
            //personList.insert(new Person("Petr_"+i), theItr);
            personList.add(new Person("Petr_"+i));
            personList.printList();
            //theItr.advance();
        }
        personList.printList();
        //System.out.println("Size was: " + personList.listSize(personList));
        System.out.println("Size was (2): " + personList.size());


        theItr = theList.first();
        for (; theItr.isValid(); theItr.advance())
            System.out.print(theItr.retrieve() + " ");

    }
}
