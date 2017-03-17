package ru.lesson.lessons.lesson_10v1;

/**
 * Класс описывает клинику, используется своя реализация коллекции ArrayList
 * @autor irinaff
 * @since 15.03.2017
 * 1 + клиента
 * 2 + или заменить питомца клиенту
 * 3 Поиск клиента по имени клиента
 * 4 Поиск клиента по кличке питомца
 * 5 Поиск питомца по имени клиента
 * 6 Поиск питомца по имени питомца
 * 7 изменить имя клиента
 * 8 изменить имя питомца
 * 9 Удалить клиента
 * 10 Удалить питомца у клиента
 */

public class Clinic {
    //Массив клиентов
    private myArrayList<Client> clients;
    //private myArrayList<Pet> pets;

    public Clinic() {
        this.clients = new myArrayList<Client>();
    }

    //1 + клиента
    public void addClient(final Client client) {
        clients.add(client);
    }

    //2 + или заменить питомца клиенту
    public boolean addClientPet(final String nameClient, final Pet pet) {
        myArrayList<Client> result = findClientByName(nameClient);
        boolean res = false;
        for(int i = 0; i < result.size(); i++) {
            result.get(i).addPet(pet);
            res = true;
            }
            //System.out.println("add pet for client: " + result.getClientId() + " pet: " + result.getPetName());
        return res;
    }

    //3 Поиск клиента по имени клиента
    public myArrayList<Client> findClientByName(final String name) {
        myArrayList<Client> result = new myArrayList<Client>();
        for(int i = 0; i < clients.size(); i++) {
            if (clients.get(i) != null && name.equals(clients.get(i).getClientId()))  {
                result.add(clients.get(i));
                //System.out.println(i + ": Client: "+ clients.get(i).getClientId());
            }
        }
        if (result == null) {
            System.out.println("Client not found");
        }
        return result;
    }

    // 3 Поиск клиента по кличке питомца
    public myArrayList<Client> findClientByPetName(final String name) {
        myArrayList<Client> result = new myArrayList<Client>();
        for(int i = 0; i < clients.size(); i++) {
                  if (clients.get(i) != null && name.equals(clients.get(i).getPetName()))  {
                result.add(clients.get(i));
            }
        }
        return result;
    }

    //5 Поиск питомца по имени клиента
    public myArrayList<Pet> findPetByClientName(final String name) {
        myArrayList<Pet> result = new myArrayList<Pet>();
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i) != null && name.equals(clients.get(i).getClientId())) {
                result.add(clients.get(i).pet);
                //System.out.println(i + ": Client: "+ clients.get(i).getClientId());
            }
        }
        return result;
    }

    //6 Поиск питомца по имени питомца
    public myArrayList<Pet> findPetByPetName(final String name) {
        myArrayList<Pet> result = new myArrayList<Pet>();
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i) != null && name.equals(clients.get(i).getPetName())) {
                result.add(clients.get(i).pet);
                //System.out.println(i + ": Client: "+ clients.get(i).getClientId());
            }
        }
        return result;
    }

    //6 изменить имя клиента: Имя клиента, Новое имя клиента
    public void changeClientName(final String name, String newName) {
        myArrayList<Client> result = findClientByName(name);
        for(int i = 0; i < result.size(); i++) {
            result.get(i).changeName(newName);
            //System.out.println("Client: " + result.getClientId() + " new pet name: " + result.getPetName());
        }
    }

    //7 изменить имя питомца
    public void changeClientPetName(final String nameClient, String namePet) {
        myArrayList<Client> result = findClientByName(nameClient);
        for(int i = 0; i < result.size(); i++) {
            result.get(i).changeNamePet(namePet);
            //System.out.println("Client: " + result.getClientId() + " new pet: " + result.getPetName());
        }
    }

    //8 Удалить клиента
    public boolean deleteClient (final String nameClient) {
        myArrayList<Client> result = findClientByName(nameClient);
        boolean res = false;
        for (int i = 0; i < result.size(); i++) {
            //System.out.println("delete client with name= " + nameClient + " and index =" + index);
            clients.remove(result.get(i));
            res = true;
        }
        return res;
    }

    //9 Удалить питомца у клиента
    public boolean deleteClientPet (final String nameClient) {
        myArrayList<Client> result = findClientByName(nameClient);
        boolean res = false;
        for (int i = 0; i < result.size(); i++) {
            result.get(i).deletePet();
            //System.out.println("Client: " + result.getClientId() + " delete pet");
            res = true;
        }
        return res;
    }

    //11 вывести клиентов и питомцев клиники
    public void showClient() {
        for (int i = 0; i < clients.size(); i++) {
            System.out.println(i + ": Client- " + clients.get(i).getClientId() +
                    " Pet- " + clients.get(i).getPetName() +
                    " Vid: " + clients.get(i).getPetType());
        }
    }

    //Количество клиентов клиники
    public int getSize() {
        return clients.size();
    }

    //Для команд с клавиатуры InteractClinicRunner
    /* получение имени клиента по индексу */
    public String getNameClient (int i) {
        String rezult = "not found";
        if (clients.get(i) != null){
            rezult = clients.get(i).getClientId();
        }
        return rezult;
    }

    /* получение имени питомца по индексу */
    public String getNamePetClient (int i) {
        String rezult = "<...>";
        if (clients.get(i) != null){
            rezult = clients.get(i).getPetName();
        }
        return rezult;
    }

    /* получение типа питомца по индексу */
    public String getTypePetClient (int i) {
        String rezult = "<...>";
        if (clients.get(i) != null){
            rezult = clients.get(i).getPetType();
        }
        return rezult;
    }
}
