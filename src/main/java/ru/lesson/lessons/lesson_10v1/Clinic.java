package ru.lesson.lessons.lesson_10v1;

/**
 * Класс описывает клинику, используется своя реализация коллекции ArrayList
 * @autor irinaff
 * @since 15.03.2017
 * 1 + клиента
 * 2 + или заменить питомца клиенту
 * 3
 * 4 Поиск клиента по имени клиента
 * 5 Поиск клиента по кличке питомца
 * 6 Поиск питомца по имени клиента
 * 7 изменить имя клиента
 * 8 изменить имя питомца
 * 9 Удалить клиента
 * 10 Удалить питомца у клиента
 */

public class Clinic {
    //Массив клиентов
    private myArrayList<Client> clients;

    public Clinic() {
        this.clients = new myArrayList<Client>();
    }

    //1 + клиента
    public void addClient(final Client client) {
        clients.add(client);
    }

    //2 + или заменить питомца клиенту
    public void addClientPet(final String nameClient, Pet pet) {
        Client result = findClientByName(nameClient);
        if (result != null) {
            result.addPet(pet);
            //System.out.println("add pet for client: " + result.getClientId() + " pet: " + result.getPetName());
        }
    }

    //4 Поиск клиента по имени клиента
    public Client findClientByName(final String name) {
        Client result = null;
        for(int i = 0; i < clients.size(); i++) {
            if (clients.get(i) != null && name.equals(clients.get(i).getClientId()))  {
                result = clients.get(i);
                //System.out.println(i + ": Client: "+ clients.get(i).getClientId());
            }
        }
        if (result == null) {
            System.out.println("Client not found");
        }
        return result;
    }

    // 5 Поиск клиента по кличке питомца
    public Client findClientByPetName(final String name) {
        Client result = null;
        for(int i = 0; i < clients.size(); i++) {
            //if (this.clients[i] != null) {System.out.println(i + ": " + this.clients[i].getPetName());}
            if (clients.get(i) != null && (name).equals(clients.get(i).getPetName()))  {
                result = clients.get(i);
                //System.out.println(i + ": Client: "+ clients.get(i).getClientId() +
                        //" pet: "+ clients.get(i).getPetName());
            }
        }
        if (result == null) {
            System.out.println("Client not found");
        }
        return result;
    }

    //6 Поиск питомца по имени клиента
    public Client findPetByNameClient(final String name) {
        Client result = null;
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i) != null && name.equals(clients.get(i).getClientId())) {
                result = clients.get(i);
                //System.out.println(i + ": Client: "+ clients.get(i).getClientId());
            }
        }
        if (result == null) {
            System.out.println("Client not found");
        }
        return result;
    }

    //7 изменить имя клиента: Имя клиента, Новое имя клиента
    public void changeClientName(final String name, String newName) {
        Client result = findClientByName(name);
        if (result != null) {
            result.changeName(newName);
            //System.out.println("Client: " + result.getClientId() + " new pet name: " + result.getPetName());
        }
    }

    //8 изменить имя питомца
    public void changeClientPetName(final String nameClient, String namePet) {
        Client result = findClientByName(nameClient);
        if (result != null) {
            result.changeNamePet(namePet);
            //System.out.println("Client: " + result.getClientId() + " new pet: " + result.getPetName());
        }
    }

    //9 Удалить клиента
    public boolean deleteClient (final String nameClient) {
        Client result = findClientByName(nameClient);
        if (result != null) {
            //System.out.println("delete client with name= " + nameClient + " and index =" + index);
            clients.remove(result);
            return true;
        }
        else return false;
    }

    //10 Удалить питомца у клиента
    public void deleteClientPet (final String nameClient) {
        Client result = findClientByName(nameClient);
        if (result != null) {
            result.deletePet();
            //System.out.println("Client: " + result.getClientId() + " delete pet");
        }
    }

    //11 вывести клиентов и питомцев клиники
    public void chowClient() {
        //this.clients1.add(position, client);
        for (int i = 0; i < clients.size(); i++) {
            //System.out.println(client);
            System.out.println("Client name: " + clients.get(i).getClientId() +
                    " Client pet name: "+clients.get(i).getPetName() +
                    " Pet type: " + clients.get(i).getPetType());
        }
    }

    //Количество клиентов клиники
    public int getSize() {
        return clients.size();
    }

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
