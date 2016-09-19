package Clinica;

/** Реализация домашнего животного
 * @autor irinaff
 * @since 17.09.2016
 **/

public class Pet {

    public String name;

    public Pet(String name){
        this.name = name;
    }
    /**
     * Издавать звук
     */
    public void makeSound() {
        System.out.println("Fr, Fr");
    }
        /**
         * Имя питомца
         */

    public String getName() {
        return this.name;
    }
}

