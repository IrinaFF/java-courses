package syerraBeyts.glava_7.ex_222;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 26.01.2017
 **/

public class Mixed2 {
    public static void main (String [] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        A a2 = new C();

        //1
        //b.m1();
        //c.m2();
        //a.m3();
        //B`s m1, A`s m2, A`s m3,
        //2
        //c.m1();
        //c.m2();
        //c.m3();
        //B`s m1, A`s m2, C`s m3, 13
        //3
        //a.m1();
        //b.m2();
        //c.m3();
        //A`s m1, A`s m2, C`s m3, 13
        //4
        a2.m1();
        a2.m2();
        a2.m3();
        //B`s m1, A`s m2, C`s m3, 13
    }
}
