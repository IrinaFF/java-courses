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

    /**
     * Получить имя питомца
     **/
    public  String getPetName(){
        if (this.pet.getName() != null)  {
            return this.pet.getName();
        }
        else {
            return "null";
        }

    };
    /**
     * Получить имя Клиента
     **/
    public  String getClientId(){
        return this.id;
    };
}
