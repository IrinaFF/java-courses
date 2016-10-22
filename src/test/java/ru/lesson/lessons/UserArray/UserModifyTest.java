package ru.lesson.lessons.UserArray;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 22.10.2016
 **/

public class UserModifyTest {
    /**
     * x.equals(x)
     не вызываются переопределенные методы
     * работает без переопределения equals и без переопределения hashCode
     * работает c переопределением equals без переопределения hashCode
     * работает без переопределения equals и с переопределением hashCode
     * работает c переопределением equals и с переопределением hashCode
     **/
    @Test
    public void reflexive()  {
        UserModify pit = new UserModify("1", "1", new User("1", "1"));
        assertEquals(pit, pit);
    }
    /**
     * x.equals(y) y.equals(x)
     * зависит от переопределенного equals
     * вызываются переопределенный equals и переопределенный hashCode
     * не работает без переопределения equals и без переопределения hashCode
     * работает c переопределением equals без переопределения hashCode
     * не работает без переопределения equals и с переопределением hashCode
     UserModify equals
     User hashCode() : 1568
     UserModify hashCode() : 50176
     User hashCode() : 1568
     UserModify hashCode() : 50176
     **/

    @Test
    public void symmetric()  {
        UserModify pit = new UserModify("1", "1", new User("1", "1"));
        UserModify dim = new UserModify("1", "1", new User("1", "1"));
        assertEquals(pit, dim);
        assertEquals(dim, pit);
    }
    /**
     * x.equals(y) y.equals(z) x.equals(z)
     * equals + hashCode
     * вызываются переопределенный equals и переопределенный hashCode
     * не работает без переопределения equals и без переопределения hashCode
     * работает c переопределением equals без переопределения hashCode
     * не работает без переопределения equals и с переопределением hashCode
     UserModify equals
     User hashCode() : 1568
     UserModify hashCode() : 50176
     User hashCode() : 1568
     UserModify hashCode() : 50176
     **/
    @Test
    public void transitive() {
        UserModify pit = new UserModify("1", "1", new User("1", "1"));
        UserModify dim = new UserModify("1", "1", new User("1", "1"));
        UserModify max = new UserModify("1", "1", new User("1", "1"));
        assertEquals(pit, dim);
        assertEquals(dim, max);
        assertEquals(pit, max);
    }

    /**
     * y.equals(x) consistently
     * вызываются переопределенный equals и переопределенный hashCode
     * не работает без переопределения equals и без переопределения hashCode
     * работает c переопределением equals без переопределения hashCode
     * не работает без переопределения equals и с переопределением hashCode
     UserModify equals
     User hashCode() : 1568
     UserModify hashCode() : 50176
     User hashCode() : 1568
     UserModify hashCode() : 50176
     **/
    @Test
    public void consistent() {
        UserModify pit = new UserModify("1", "1", new User("1", "1"));
        UserModify dim = new UserModify("1", "1", new User("1", "1"));
        for (int i=0;i<=10;++i ) {
            assertEquals(pit, dim);
        }
    }
}