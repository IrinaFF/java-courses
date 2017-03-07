package ru.lesson.lessons.lesson_10;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Зависимость equal=true то hashCode = true
 * Обратная зависимость несправделива
 **/

public class UserTest {
    /**
     * x.equals(x)
     **/
    @Test
    public void reflexive()  {
        User pit = new User("1", "1");
        assertEquals(pit, pit);
    }
    /**
     * x.equals(y) y.equals(x)
     **/

    @Test
    public void symmetric()  {
        User pit = new User("1", "1");
        User dim = new User("1", "1");
        assertEquals(pit, dim);
        assertEquals(dim, pit);
    }
    /**
     * x.equals(y) y.equals(z) x.equals(z)
     **/

    @Test
    public void transitive() {
        User pit = new User("1", "1");
        User dim = new User("1", "1");
        User max = new User("1", "1");
        assertEquals(pit, dim);
        assertEquals(dim, max);
        assertEquals(pit, max);
    }

    /**
     * y.equals(x) consistently
     **/
    @Test
    public void consistent() {
        User pit = new User("1", "1");
        User dim = new User("1", "1");
        for (int i=0;i<=10;++i ) {
            assertEquals(pit, dim);
        }
    }
    }