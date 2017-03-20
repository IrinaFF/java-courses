package ru.lesson.lessons.lesson_10v1;

/**
 * Класс описывает клинику, используется своя реализация коллекции LinkedList
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

public class ClinicLinked {
    //Массив клиентов
    private myLinkedList<Client> clients;
    //private myLinkedList<Pet> pets;

    public ClinicLinked() {
        this.clients = new myLinkedList<Client>();
    }

    //1 + клиента
    public void addClient(final Client client) {
        clients.add(client);
    }

    //2 + или заменить питомца клиенту
    public boolean addClientPet(final String nameClient, final Pet pet) {
        myLinkedList<Client> result = findClientByName(nameClient);
        myLinkedList.LinkedListIterator p;
        boolean res = false;
        for (p = result.first(); p.isValid(); p.advance()) {
            result.retrieve(p).addPet(pet);
            res = true;
        }
        //System.out.println("add pet for client: " + result.getClientId() + " pet: " + result.getPetName());
        return res;
    }

    //3 Поиск клиента по имени клиента
    public myLinkedList<Client> findClientByName(final String name) {
        myLinkedList<Client> result = new myLinkedList<Client>();
        myLinkedList.LinkedListIterator p;
        for(p = clients.first(); p.isValid(); p.advance()) {
            if (clients.retrieve(p) != null && name.equals(clients.retrieve(p).getClientId()))  {
                result.add(clients.retrieve(p));
                //System.out.println(i + ": Client: "+ clients.get(i).getClientId());
            }
        }
        return result;
    }

    // 3 Поиск клиента по кличке питомца
    public myLinkedList<Client> findClientByPetName(final String name) {
        myLinkedList<Client> result = new myLinkedList<Client>();
        myLinkedList.LinkedListIterator p;
        for(p = clients.first(); p.isValid(); p.advance()) {
            if (clients.retrieve(p) != null && name.equals(clients.retrieve(p).getPetName()))  {
                result.add(clients.retrieve(p));
            }
        }
        return result;
    }

    //5 Поиск питомца по имени клиента
    public myLinkedList<Pet> findPetByClientName(final String name) {
        myLinkedList<Pet> result = new myLinkedList<Pet>();
        myLinkedList.LinkedListIterator p;
        for (p = clients.first(); p.isValid(); p.advance()) {
            if (clients.retrieve(p) != null && name.equals(clients.retrieve(p).getClientId())) {
                result.add(clients.retrieve(p).pet);
                //System.out.println(i + ": Client: "+ clients.get(i).getClientId());
            }
        }
        return result;
    }

    //6 Поиск питомца по имени питомца
    public myLinkedList<Pet> findPetByPetName(final String name) {
        myLinkedList<Pet> result = new myLinkedList<Pet>();
        myLinkedList.LinkedListIterator p;
        for (p = clients.first(); p.isValid(); p.advance()) {
            if (clients.retrieve(p) != null && name.equals(clients.retrieve(p).getPetName())) {
                result.add(clients.retrieve(p).pet);
                //System.out.println(i + ": Client: "+ clients.get(i).getClientId());
            }
        }
        return result;
    }

    //6 изменить имя клиента: Имя клиента, Новое имя клиента
    public void changeClientName(final String name, String newName) {
        myLinkedList<Client> result = findClientByName(name);
        myLinkedList.LinkedListIterator p;
        for(p = result.first(); p.isValid(); p.advance()) {
            result.retrieve(p).changeName(newName);
            //System.out.println("Client: " + result.getClientId() + " new pet name: " + result.getPetName());
        }
    }

    //7 изменить имя питомца
    public void changeClientPetName(final String nameClient, String namePet) {
        myLinkedList<Client> result = findClientByName(nameClient);
        myLinkedList.LinkedListIterator p;
        for(p = result.first(); p.isValid(); p.advance()) {
            result.retrieve(p).changeNamePet(namePet);
            //System.out.println("Client: " + result.getClientId() + " new pet: " + result.getPetName());
        }
    }

    //8 Удалить клиента
    public boolean deleteClient (final String nameClient) {
        myLinkedList<Client> result = findClientByName(nameClient);
        myLinkedList.LinkedListIterator p;
        boolean res = false;
        for (p = result.first(); p.isValid(); p.advance()) {
            //System.out.println("delete client with name= " + nameClient + " and index =" + index);
            clients.remove(result.retrieve(p));
            res = true;
        }
        return res;
    }

    //9 Удалить питомца у клиента
    public boolean deleteClientPet (final String nameClient) {
        myLinkedList<Client> result = findClientByName(nameClient);
        myLinkedList.LinkedListIterator p;
        boolean res = false;
        for (p = result.first(); p.isValid(); p.advance()) {
            result.retrieve(p).deletePet();
            //System.out.println("Client: " + result.getClientId() + " delete pet");
            res = true;
        }
        return res;
    }

    //11 вывести клиентов и питомцев клиники
    public void showClient() {
        myLinkedList.LinkedListIterator p;
        int i = 0;
        for (p = clients.first(); p.isValid(); p.advance(), i++) {
            System.out.println(i + ": Client- " + clients.retrieve(p).getClientId() +
                    " Pet- " + clients.retrieve(p).getPetName() +
                    " Vid: " + clients.retrieve(p).getPetType());
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
        if (clients.retrieve(i) != null){
            rezult = clients.retrieve(i).getClientId();
        }
        return rezult;
    }

    /* получение имени питомца по индексу */
    public String getNamePetClient (int i) {
        String rezult = "<...>";
        if (clients.retrieve(i) != null){
            rezult = clients.retrieve(i).getPetName();
        }
        return rezult;
    }

    /* получение типа питомца по индексу */
    public String getTypePetClient (int i) {
        String rezult = "<...>";
        if (clients.retrieve(i) != null){
            rezult = clients.retrieve(i).getPetType();
        }
        return rezult;
    }
}

