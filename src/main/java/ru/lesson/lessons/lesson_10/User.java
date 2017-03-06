package ru.lesson.lessons.lesson_10;

/**
 * @autor irinaff
 * @since 16.10.2016
 **/

public class User {
    private String id;
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("User equals");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        return name != null ? name.equals(user.name) : user.name == null;

    }
    //реализация по нашей бизнес-логике уникальности индекса
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        System.out.println("User hashCode() : " + result);
        return result;
        //дефолтная реализация
        //System.out.println("User super.hashCode() : " + super.hashCode() +
        //        "; hashCode() : " + result);
        //return super.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


}
