package ru.lesson.lessons.lesson_6v1;

/**
 * Класс описывает клинику (обычный массив)
 * @autor irinaff
 * @since 17.09.2016
 */
public class Clinic {
    //Массив клиентов
    private Client[] clients;
    //private List<Client> clients1;// = new ArrayList<Client>();

    public Clinic(final int size) {
        this.clients = new Client[size];
    }

    //Поиск освободившегося окна в массиве клиентов
    public int findFreeIndex () {
        int freeIndex = -1;
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] == null) {
                freeIndex = i;
                break;
            }
        }
        return freeIndex;
    }

    public String getNameClient (int i) {
        String rezult = "<...>";
        if (clients[i] != null){
            rezult = clients[i].getClientId();
        }
        return rezult;
    }

    public String getNamePetClient (int i) {
        String rezult = "<...>";
        if (clients[i] != null){
            rezult = clients[i].getPetName();
        }
        return rezult;
    }

    public String getTypePetClient (int i) {
        String rezult = "<...>";
        if (clients[i] != null){
            rezult = clients[i].getPetType();
        }
        return rezult;
    }

    //public Clinic() {
    //    this.clients1 =  new ArrayList<Client>();
    //}

    //Добавить клиента: Позиция, Клиент
    public void addClient(final int position, final Client client) {
        this.clients[position] = client;
    }
/*
    //List<User> users = new ArrayList<User>();
    //users.add(new User("1","first"));
    public void addClient1(int position, final Client client)
            throws UserException {
        if (position >= 0) {
            this.clients1.add(position, client);
        }
        else {
            throw new UserException("Cliens position can not be null or negativ!");
        }
    }

    public void chowClient1() {
        //this.clients1.add(position, client);
        for (Client client : clients1) {
            //System.out.println(client);
            System.out.println("Client name: " + client.getClientId() +
                    " Client pet name: "+client.getPetName() +
                    " Pet type: " + client.getPetType());
        }
    }
*/
    //Найти клиента по имени животного
    public Client findClientByPetName(final String name) {
        Client result = null;
        for(int i = 0; i < this.clients.length; i++) {
            //if (this.clients[i] != null) {System.out.println(i + ": " + this.clients[i].getPetName());}
            if (this.clients[i] != null && (name).equals(this.clients[i].getPetName()))  {
                result = this.clients[i];
                System.out.println(i + ": Client: "+ this.clients[i].getClientId() +
                        " pet: "+ this.clients[i].getPetName());
            }
        }
        if (result == null) {
            System.out.println("Client not found");
        }
        return result;
    }

    //Найти клиента по имени клиента
    public Client findClientByName(final String name) {
        Client result = null;
        for(int i = 0; i < this.clients.length; i++) {
            if (this.clients[i] != null && name.equals(this.clients[i].getClientId()))  {
                result = this.clients[i];
                System.out.println(i + ": Client: "+ this.clients[i].getClientId());
            }
        }
        if (result == null) {
            System.out.println("Client not found");
        }
        return result;
    }

    //Найти индекс клиента в клинике по имени клиента
    public int findIndexClientByName(final String name) {
        int result = -1;
        for (int i = 0; i < this.clients.length; i++) {
            if (this.clients[i] != null && name.equals(this.clients[i].getClientId()))  {
                result = i;
                System.out.println(i+ ": Client: "+ this.clients[i].getClientId());
            };
        }
        return result;
    }

    //Изменить имя клиента: Имя клиента, Новое имя клиента
    public void changeClientName(final String name, String newName) {
        Client result = findClientByName(name);
        if (result != null) {
            result.changeName(newName);
            System.out.println("Client: " + result.getClientId() + " new pet name: " + result.getPetName());
        }
    }

    //Сменить питомца клиенту: Имя клиента, Имя питомца
    public void changeClientPetName(final String nameClient, String namePet) {
        Client result = findClientByName(nameClient);
        if (result != null) {
            result.changeNamePet(namePet);
            System.out.println("Client: " + result.getClientId() + " new pet: " + result.getPetName());
        }
    }

    //добавить питомца клиенту
    public void addClientPet(final String nameClient, Pet pet) {
        Client result = findClientByName(nameClient);
        if (result != null) {
            result.addPet(pet);
            System.out.println("add pet for client: " + result.getClientId() + " pet: " + result.getPetName());
        }
    }
    //Удалить клиента из клиники
    public void deleteClient (final String nameClient) {
        int index = -1;
        index = findIndexClientByName(nameClient);
        if (index > 0) {
            this.clients[index] = null;
            System.out.println("delete client with name= " + nameClient + " and index =" + index);
        }
    }

    //Удалять питомца
    public void deleteClientPet (final String nameClient) {
        Client result = findClientByName(nameClient);
        if (result != null) {
            result.deletePet();
            System.out.println("Client: " + result.getClientId() + " delete pet");
        }
    }
}
