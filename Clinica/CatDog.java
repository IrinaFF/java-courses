package Clinica;

/**
 * Реализация котопса
 * @autor irinaff
 * @since 17.09.2016
 **/

public class CatDog implements Pet {
    private Pet cat; //переменная для ссылки на объект реализующий интерфейс
    private Pet dog; //переменная для ссылки на объект реализующий интерфейс
    /**
     * Базовая реализация питомца
     */
    public CatDog( Pet cat, Pet dog) {
        this.cat = cat;
        this.dog = dog;
    };
    @Override
    public void makeSound(){
        this.cat.makeSound();
        this.dog.makeSound();
    };
    @Override
    public  String getName(){
        return String.format("%s say: %s", this.cat.getName(), this.dog.getName());
    };
}
