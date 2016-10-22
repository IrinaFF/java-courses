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
     **/
    @Test
    public void reflexive()  {
        UserModify pit = new UserModify("1", "1", new User("1", "1"));
        assertEquals(pit, pit);
    }
    /**
     * x.equals(y) y.equals(x)
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