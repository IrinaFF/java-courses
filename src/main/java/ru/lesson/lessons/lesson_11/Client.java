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

    //Получить имя питомца
    public  String getPetName(){
        if (this.pet.getName() != null)  {
            return this.pet.getName();
        }
        else {
            return "null";
        }
    };
    //Получить id-имя Клиента
    public  String getClientId(){
        return this.id;
    };

    //Изменить имя Клиента
    public  void changeName(String name){
        this.id = name;
    };

    //Сменить имя питомца
    public  void changeNamePet(String name){
        this.pet.changeName(name);
        System.out.println("Client changeNamePet: " + name);
    };

    //Получить вид  питомца
    public  String getPetType(){
        return String.valueOf(this.pet.getClass());
    }

    //Указать питомца
    public  void addPet(Pet pet){
        this.pet = pet;
        System.out.println("Client addPet: " + pet.getName());
    };

//    @Override
//    public String toString() {
//        return "Client{" +
//                "id='" + id + '\'' +
//                ", pet=" + pet +
//                '}';
//    }
}
