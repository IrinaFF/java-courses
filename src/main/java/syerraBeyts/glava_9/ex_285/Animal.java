package syerraBeyts.glava_9.ex_285;

/**
 * @autor irinaff
 * @since 26.01.2017
 **/

abstract class Animal {
    private String name;

    Animal(String n) {
        System.out.println("создание Animal");
        name = n;
    }

    String getName() {
        return name;
    };
}
