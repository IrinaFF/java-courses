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
    /**
     * Имя
     */
    private String name;

    /**
     * Конструктор
     * @param name Имя животного
     */
    public Dog(final String name){
        this.name = name;
    }
    /**
     * Конструктор
     * @param pet ссылка на объект
     */
    public Dog(final Pet pet) {
        this.pet = pet;
        this.name = pet.getName();
    };

    /**
     * Подать голос
     */
    @Override
    public void makeSound(){
        this.pet.makeSound();
        System.out.println(
                String.format("%s say: %s", this.name, "Gav, Gav")
        );
    };
    @Override
    public  String getName(){
        return this.name;
    };

    /**
     * Сменить имя питомца
     * */
    @Override
    public void changeName(String name) {
        this.name = name;
        System.out.println("Dog changeName: " + name);
    };
}
