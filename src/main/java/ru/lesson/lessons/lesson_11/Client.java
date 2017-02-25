package ru.lesson.lessons.lesson_11;

/**
 * Клиент
 * @autor irinaff
 * @since 17.09.2016
 */
public class Client {
    private String id;
    private Pet pet;

    /**
     * @param id номер
     * @param pet Питомец
     */
    public Client(String id, Pet pet) {
        this.id = id;
        this.pet = pet;
    }

    public Client(String id) {
        this.id = id;
    }

    //Получить кличку питомца
    public  String getPetName(){
        if (this.pet != null) {
            return this.pet.getName();
        }
        else { return "null"; }
    }

    //Получить вид  питомца
    public  String getPetType(){
        if (this.pet != null) {
            return String.valueOf(this.pet.getClass().getSimpleName());//.getEnclosingClass()
        }
        else { return "null"; }
    }

    //Получить id-Имя Клиента
    public  String getClientId(){
        return this.id;
    };

    //Редактировать имя Клиента
    public  void changeName(String name){
        this.id = name;
    };

    //Редактировать имя питомца
    public  void changeNamePet(String name){
        this.pet.changeName(name);
        System.out.println("Client changeNamePet: " + name);
    };

    //Указать питомца
    public  void addPet(Pet pet){
        this.pet = pet;
        System.out.println("Client addPet: " + pet.getName());
    };

    //Удалить питомца
    public  void deletePet(){
        this.pet = null;
        System.out.println("Client deletePet" );
    };
}
