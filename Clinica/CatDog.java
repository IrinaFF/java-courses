package Clinica;

/**
 * Реализация котопса
 * @autor irinaff
 * @since 17.09.2016
 **/

public class CatDog implements Pet {
    private Pet cat; //переменная для ссылки на объект реализующий интерфейс
    private Pet dog; //переменная для ссылки на объект реализующий интерфейс

    public CatDog( Pet cat, Pet dog) {
        this.cat = cat;
        this.dog = dog;
    };

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public void makeSound(){
        this.cat.makeSound();
        this.dog.makeSound();
    };
    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public  String getName(){
        return String.format("%s + %s", this.cat.getName(), this.dog.getName());
    };
}
