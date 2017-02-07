package syerraBeyts.glava_8.ex_241;
//import syerraBeyts.glava_8.ex_236;
import java.util.*;
/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 27.01.2017
 **/

public class TestObject {
    public static void main (String [] args) {
        //создаем ArrayList и объявляем его для хранения объектов Dog
        ArrayList<Dog> myDogArrayList1 = new ArrayList<Dog>();
        //создаем объект класса Dog
        Dog aDog1 = new Dog();
        //добавляем Dog в список
        myDogArrayList1.add(aDog1);
        //присваиваем объект Dog из списка новой переменной,
        //ссылка на которую имеет тип Dog
        //как бы для метода get() объявлен тип возвращающего значения Dog
        Dog d1 = myDogArrayList1.get(0);

        //создаем ArrayList и объявляем его для хранения объектов типа Object
        ArrayList<Object> myDogArrayList2 = new ArrayList<Object>();
        //создаем объект класса Dog
        Dog aDog2 = new Dog();
        //добавляем Dog в список
        myDogArrayList2.add(aDog2);
        //это не скомпилируется
        //когда используем ArrayList<Object> метод get()
        //возвращает тип Object
        //Dog d2 = myDogArrayList2.get(0);

        Object o = myDogArrayList1.get(0);
        //это допустимо, вы сможете вызвать его для любого объекта
        int i = o.hashCode();
        //не скомпилируется, класс Object ничего не знает о методе bark
        //даже если мы знаем, что по данному иньексу расположен объект Dog
        //o.bark();

        //приводим Object к Dog
        Dog d = (Dog) o;
        d.roam();

        //проверка что это Dog
        if (o instanceof Dog) {
            d = (Dog) o;
        }
    }

    public void go() {
        Dog aDog = new Dog();
        //эта строка не сработает, возвращаемый тип Object  означает что компилятор не позволит
        //присвоить возвращенную ссылку чему-нибудь кроме Object
        //Dog sameDog = getObject(aDog);
        //это сработает, хотя и бесполезно
        Object sameDog = getObject(aDog);
    }

    public Object getObject(Object o) {
        //это похоже на обработку метода get() для ArrayList<Object>
        return o;
    }


}
