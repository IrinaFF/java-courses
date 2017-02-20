package ru.lesson.lessons.lesson_11;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс описывает клинику
 * @autor irinaff
 * @since 17.09.2016
 */
public class Clinic {
    /**
    * Список клиентов
     **/
    private Client[] clients;
    private List<Client> clients1;// = new ArrayList<Client>();

    public Clinic(final int size) {
        this.clients = new Client[size];
    }

    public Clinic() {
        this.clients1 =  new ArrayList<Client>();
    }

    /**
     * Добавить клиента
     * @param position Позиция
     * @param client Клиент
     */
    public void addClient(final int position, final Client client) {
        this.clients[position] = client;
    }
    //List<User> users = new ArrayList<User>();
    //users.add(new User("1","first"));
    public void addClient1(int position, final Client client) throws UserException {
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
            System.out.println("Client name: "+client.getClientId() + " Client pet name: "+client.getPetName() + " Pet type: " + client.getPetType());
        }
    }
    /**
     * Найти клиента
     * @param name Имя животного
     */
    public Client[] findClientByPetName(final String name) {
        Client[] result;
        result = new Client[1];
        for(int i = 0; i < this.clients.length; i++) {
            if (this.clients[i] != null && (name).equals(this.clients[i].getPetName()))  {
                result[0] = this.clients[i];
                System.out.println("findClientByPetName Client: "+ this.clients[i].getClientId()+ " pet: "+ this.clients[i].getPetName());
            };
        }
        return result;
    }

    /**
     * Найти клиента
     * @param name Имя клиента
     */
    public Client[] findClientByName(final String name) {
        Client[] result;
        result = new Client[1];
        for(int i = 0; i < this.clients.length; i++) {
            if (this.clients[i] != null && (name).equals(this.clients[i].getClientId()))  {
                result[0] = this.clients[i];
                System.out.println("findClientByName Client: "+ this.clients[i].getClientId()+ " pet: "+ this.clients[i].getPetName());
            };
        }
        return result;
    }

    /**
     * Изменить имя клиента
     * @param name Имя клиента
     * @param name Новое имя клиента
     */
    public void changeClientName(final String name, String newName) {
        for (int i = 0; i < this.clients.length; i++) {
            if (this.clients[i] != null && (name).equals(this.clients[i].getClientId())) {
                this.clients[i].changeName(newName);
                System.out.println("changeClientName Client: " + this.clients[i].getClientId() + " pet: " + this.clients[i].getPetName());
            }
        }
    }

    /**
     * Сменить питомца
     * @param nameClient Имя клиента
     * @param namePet Имя питомца
     */
    public void changeClientPetName(final String nameClient, String namePet) {
        for (int i = 0; i < this.clients.length; i++) {
            if (this.clients[i] != null && (nameClient).equals(this.clients[i].getClientId())) {
                this.clients[i].changeNamePet(namePet);
                System.out.println("changeClientPetName Client: " + this.clients[i].getClientId() + " pet: " + this.clients[i].getPetName());
            }
        }
    }

//    @Override
//    public String toString() {
//        return "Clinic{" +
//                "clients=" + Arrays.toString(clients) +
//                ", clients1=" + clients1 +
//                '}';
//    }
}
