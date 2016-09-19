package Clinica;

/**
 * Реализация собаки
 * @autor irinaff
 * @since 17.09.2016
 **/

public class Dog extends Pet{
    /**
     * Базовая реализация питомца
     */
    private Pet pet;

    Dog(String name) {
        this.name = name;
    };

    public Dog(final Pet pet) {
        this.pet = pet;
    };

    public void makeSound(){
        this.pet.makeSound();
        System.out.println("Gav, Gav");
    };
    @Override
    public  String getName(){
        return this.pet.getName();
    };
}
