package ru.lesson.lessons.lesson_10;

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
    /**
     * переопределенный equals вызывается
     * переопределенный hashCode не вызывается
     * не работает без переопределения equals и без переопределения hashCode
     * работает c переопределением equals без переопределения hashCode
     * не работает без переопределения equals и с переопределением hashCode
     UserModify equals
     UserModify equals
     */
     /*
    @Test

    public void arrayContains() {
        System.out.println("UserModify arrayContains");
        List<UserModify> users = new ArrayList<UserModify>();
        users.add(new UserModify("1", "first", new User("1", "1")));
        users.add(new UserModify("2", "second", new User("1", "1")));
        //выявим, если метод equls неверно перекрыт
        assertTrue(users.contains(new UserModify("1", "first", new User("1", "1"))));
    }
    */
    /**
     * переопределенный equals не вызывается
     * переопределенный hashCode вызывается
     * Зависимость (@link java.util.Set#add) от методов hashCode equals
     * работает без переопределения equals и без переопределения hashCode
     * работает c переопределением equals без переопределения hashCode
     * работает без переопределения equals и с переопределением hashCode
     User hashCode() : 1568
     UserModify hashCode() : -1274265247
     User hashCode() : 1568
     UserModify hashCode() : 1970146270
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
     * переопределенный equals вызывается
     * переопределенный hashCode вызывается при сравнении
     *  не работает без переопределения equals и без переопределения hashCode
     *  не работает c переопределением equals без переопределения hashCode
     *  не работает без переопределения equals и с переопределением hashCode
     User hashCode() : 1568
     UserModify hashCode() : -1274265247
     User hashCode() : 1568
     UserModify hashCode() : 1970146270
     User hashCode() : 1568
     UserModify hashCode() : -1274265247
     UserModify equals
     */
    /*
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
    */
}
