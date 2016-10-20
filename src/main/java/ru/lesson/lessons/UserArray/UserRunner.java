package ru.lesson.lessons.UserArray;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO: comment
 * @autor irinaff
 * @since 16.10.2016
 **/

public class UserRunner {
    public static void main(String[] args){
        /**
         List<User> users = new ArrayList<User>();
         users.add(new User("1","first"));
         users.add(new User("2","second"));
         users.add(new User("1","first"));

         for (User user : users) {
         System.out.println(user);
         }

         List<User> users_l = new LinkedList<User>();
         users_l.add(new User("1","first"));
         users_l.add(new User("2","second"));
         users_l.add(new User("1","first"));

         for (User user : users_l) {
         System.out.println(user);
         }

         Set<User> users_s = new HashSet<User>();
         users_s.add(new User("1","first"));
         users_s.add(new User("2","second"));
         users_s.add(new User("1","first"));

         for (User user : users_s) {
         System.out.println(user);
         }
         **/
        Map<String, User> users_m = new HashMap<String, User>();
        users_m.put("1", new User("1","first"));
        users_m.put("2", new User("2","second"));
        users_m.put("1", new User("1","first"));

        for (Map.Entry<String, User> user : users_m.entrySet()) {
            System.out.println(user);
        }
    }


}
