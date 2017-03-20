package ru.lesson.lessons.lesson_10v1;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 19.03.2017
 **/

public class myLinkedListTest {
    myLinkedList<Person> theList = new myLinkedList();
    myLinkedList.LinkedListIterator p;
    Person p1 = new Person("One");
    Person p2 = new Person("Two");
    Person p3 = new Person("Three");
    Person p4 = new Person("Four");
    Person p5 = new Person("Five");

    @Test
    public void add() throws Exception {
        theList.add(p1);
        theList.add(p2);
        theList.add(p3);
        theList.printList();
        assertEquals(theList.size(),3);
    }


    @Test
    public void isEmpty() throws Exception {
        theList.add(p1);
        theList.add(p2);
        theList.add(p3);
        theList.add(p4);
        theList.add(p5);
        theList.makeEmpty();
        //assertTrue(theList.isEmpty());
        theList.add(p1);
        assertFalse(theList.isEmpty());
    }

    @Test
    public void makeEmpty() throws Exception {
        theList.add(p1);
        theList.add(p2);
        theList.add(p3);
        theList.add(p4);
        theList.add(p5);
        theList.makeEmpty();
        assertEquals(theList.size(),0);
    }

    @Test
    public void first() throws Exception {
        theList.add(p1);
        theList.add(p2);
        theList.add(p3);
        theList.add(p4);
        theList.add(p5);
        p = theList.first();
        assertTrue(String.valueOf(p.retrieve()).equals("One"));
    }

    @Test
    public void last() throws Exception {
        theList.add(p1);
        theList.add(p2);
        theList.add(p3);
        theList.add(p4);
        theList.add(p5);
        p = theList.last();
        assertTrue(String.valueOf(p.retrieve()).equals("Five"));
    }
    @Test
    public void find() throws Exception {
        theList.add(p1);
        theList.add(p2);
        theList.add(p3);
        theList.add(p4);
        theList.add(p5);
        p = theList.find(p2);
        assertTrue(String.valueOf(p.retrieve()).equals("Two"));
    }

    @Test
    public void remove() throws Exception {
        theList.add(p1);
        theList.add(p2);
        theList.add(p3);
        theList.add(p4);
        theList.add(p5);
        theList.remove(p5);
        theList.printList();
        assertEquals(theList.size(),4);
        theList.printFirst();
        theList.printLast();
    }

    @Test
    public void size() throws Exception {
        theList.add(p1);
        theList.add(p2);
        theList.add(p3);
        theList.add(p4);
        theList.add(p5);
        assertEquals(theList.size(),5);
    }

    @Test
    public void iterator() throws Exception {
        String[] s = new String[5];
        theList.add(p1);
        theList.add(p2);
        theList.add(p3);
        theList.add(p4);
        theList.add(p5);
        p = theList.first();
        for (int i = 0; p.isValid(); p.advance(), i++)
            s[i] = (String.valueOf(p.retrieve()));
        System.out.println(Arrays.toString(s));
        assertEquals(Arrays.toString(s),"[One, Two, Three, Four, Five]");
    }

    @Test
    public void iteratorR() throws Exception {
        String[] s = new String[5];
        theList.add(p1);
        theList.add(p2);
        theList.add(p3);
        theList.add(p4);
        theList.add(p5);
        p = theList.last();
        for (int i = 0; p.isValid(); p.retreat(), i++)
            s[i] = (String.valueOf(p.retrieve()));
        System.out.println(Arrays.toString(s));
        assertEquals(Arrays.toString(s),"[Five, Four, Three, Two, One]");
    }
}