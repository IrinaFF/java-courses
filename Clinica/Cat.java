package Clinica;

/**
 * Реализация кота. Он умеет мяукать и ловить мышей
 * @autor irinaff
 * @since 17.09.2016
 **/

public class Cat implements Pet {
    public final String name;

    /**
     * Конструктор
     * @param name Имя животного
     **/
    public Cat(String name) {
        this.name = name;
    };

    /**
     * Поймать мышь
     **/
    public void catchMouth() {
    }

    /**
     * Подать голос
     */
    @Override
    public void makeSound(){
        System.out.println(
                String.format("%s say: %s", this.name, "Mau, Mau")
        );
    };
    @Override
    public  String getName(){
        return this.name;
    };

}
