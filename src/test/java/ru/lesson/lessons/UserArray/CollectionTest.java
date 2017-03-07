package ru.lesson.lessons.lesson_10;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Зависимость equal=true то hashCode = true
 * Обратная зависимость несправделива
 **/

public class CollectionTest {
    @Test
    public void arrayContains() {
        List<User> users = new ArrayList<User>();
        users.add(new User("1", "first"));
        users.add(new User("2", "second"));
        //выявим, если метод equls неверно перекрыт
        assertTrue(users.contains(new User("1", "first")));
    }

    /**
     * Зависимость (@link java.util.Set#add) от методов hashCode equals
     */
    @Test
    public void setAdd() {
        Set<User> users = new HashSet<User>();
        //метод задействует наш hashcode
        users.add(new User("1", "first"));
        users.add(new User("2", "second"));
        assertEquals(2, users.size());
    }
    /**
     * Зависимость (@link java.util.Map#put) от методов hashCode equals
     */
    @Test
    public void mapPut() {
        Map<User, User> users = new HashMap<User, User>();
        users.put(new User("1", "first"), new User("1", "first"));
        users.put(new User("2", "second"), new User("2", "second"));
        users.put(new User("1", "first"), new User("3", "first"));
        //метод задействует наш hashcode
        assertEquals(2, users.size());
    }
}
