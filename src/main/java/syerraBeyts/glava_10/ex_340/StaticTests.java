package syerraBeyts.glava_10.ex_340;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 29.01.2017
 **/

public class StaticTests extends StaticSuper {
    static int rand;

    static {
        rand = (int) (Math.random() * 6);
        System.out.println("Статический блок " + rand);
    }

    StaticTests () {
        System.out.println("Конструктор");
    }

    public static void main (String [] args) {
        System.out.println("Внутри main");
        StaticTests st = new StaticTests();
    }
}

//Родительский статический блок
//Статический блок " + rand
//Внутри main
//Родительский конструктор
//Конструктор
