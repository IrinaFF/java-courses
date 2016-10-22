package ru.lesson.lessons.UserArray;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 22.10.2016
 **/

public class CollectionModifyTest {

    @Test
    public void arrayContains() {
        System.out.println("UserModify arrayContains");
        List<UserModify> users = new ArrayList<UserModify>();
        users.add(new UserModify("1", "first", new User("1", "1")));
        users.add(new UserModify("2", "second", new User("1", "1")));
        //выявим, если метод equls неверно перекрыт
        assertTrue(users.contains(new UserModify("1", "first", new User("1", "1"))));
    }
    /**
     * Зависимость (@link java.util.Set#add) от методов hashCode equals
     */
    @Test
    public void setAdd() {
        System.out.println("UserModify setAdd");
        Set<UserModify> users = new HashSet<UserModify>();
        //метод задействует наш hashcode
        users.add(new UserModify("1", "first", new User("1", "1")));
        users.add(new UserModify("2", "second", new User("1", "1")));
        assertEquals(2, users.size());
    }
    /**
     * Зависимость (@link java.util.Map#put) от методов hashCode equals
     */
    @Test
    public void mapPut() {
        System.out.println("UserModify mapPut");
        Map<UserModify, UserModify> users = new HashMap<UserModify, UserModify>();
        users.put(new UserModify("1", "first", new User("1", "1")), new UserModify("1", "first", new User("1", "1")));
        users.put(new UserModify("2", "second", new User("1", "1")), new UserModify("2", "second", new User("1", "1")));
        users.put(new UserModify("1", "first", new User("1", "1")), new UserModify("3", "first", new User("1", "1")));
        //метод задействует наш hashcode
        assertEquals(2, users.size());
    }
}
