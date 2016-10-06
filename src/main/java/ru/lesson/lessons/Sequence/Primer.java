package ru.lesson.lessons.Sequence;

/**
 * @autor irinaff
 * @since 07.10.2016
 * http://atamanenko.blogspot.ru/2011/07/java.html
 * некоторые особенности переопределения методов в Java
 **/

public class Primer {
    public static void main(String[] arg) {

        /*
         public class A {
         int i = 3;
         int getI() {return i;}
        }

        public class B extends A{
             int i = 5;
             int getI() {return i;}
        }

        Вопрос: что выведет данный код?
        Ответ:
        1. Так как поля класса не наследуются, то у класса A своё поле i и у класса B тоже своё поле i.
        Так как для полей полиморфизм не действует, то при обращении a.i мы обращаемся к классу A, поэтому на экран будет выведено 3.
        2. При вызове метода a.getI() у нас в дело вступает полиморфизм, поэтому будет вызван метод от класса, инстанс которого был создан.
        Соответственно, мы получим на выходе 5.
         */
        A a = new B();
        System.out.println(a.i);
        System.out.println(a.getI());

        /*
          public class A {
         static int i = 3;
         static int getI() {return i;}
        }

        public class B extends A{
             static int i = 5;
             static int getI() {return i;}
        }
        Статические поля и методы виртуальными не являются, поэтому оба вызова выведут нам 3.
         */
        //A1 a1 = new B1();
        //System.out.println(a1.i);
        //System.out.println(a1.getI());
    }
}


