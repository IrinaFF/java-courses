package ru.lesson.lessons.UserArray;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 22.10.2016
 **/

public class UserModify {
    private String idMod;
    private String nameMod;
    private User user;

    public UserModify (String id, String name, User user) {
        this.idMod = id;
        this.nameMod = name;
        this.user = user;
    }

    public String getIdMod() {
        return idMod;
    }

    public String getNameMod() {
        return nameMod;
    }

    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("UserModify equals");
        //return super.equals(o);
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserModify that = (UserModify) o;

        if (idMod != null ? !idMod.equals(that.idMod) : that.idMod != null) return false;
        if (nameMod != null ? !nameMod.equals(that.nameMod) : that.nameMod != null) return false;
        return user != null ? user.equals(that.user) : that.user == null;
    }

    @Override
    public int hashCode() {
        int result = idMod != null ? idMod.hashCode() : 0;
        result = 31 * result + (nameMod != null ? nameMod.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        System.out.println("UserModify hashCode() : " + result);
        return result;
        //дефолтная реализация
        //System.out.println("UserModify super.hashCode() : " + super.hashCode() +
        //        "; hashCode() : " + result);
        //return super.hashCode();
    }
}
