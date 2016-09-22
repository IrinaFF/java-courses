package Clinica;

/**
 * Клиент
 * @autor irinaff
 * @since 17.09.2016
 */
public class Client {
    private final String id;
    private final Pet pet;

    /**
     * Конструктор
     * @param id номер
     * @param pet Питомец
     */
    public Client(String id, Pet pet) {
        this.id = id;
        this.pet = pet;
    }

    public  String getPetName(){
        return this.pet.getName();
    };
}
