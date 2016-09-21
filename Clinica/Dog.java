package Clinica;

/**
 * Реализация собаки
 * @autor irinaff
 * @since 17.09.2016
 **/

public class Dog implements Pet{
    /**
     * Базовая реализация питомца
     */
    private Pet pet; //переменная для ссылки на объект реализующий интерфейс
    public String name;

    //Dog(String name) {
        //this.name = name;
    //};
    public Dog(final String name){
        this.name = name;
    }

    public Dog(final Pet pet) {
        this.pet = pet;
    };
    @Override
    public void makeSound(){
        this.pet.makeSound();
        System.out.println("Gav, Gav");
    };
    @Override
    public  String getName(){
        return this.getName();
    };
}
