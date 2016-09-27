package Clinica;

/**
 * Класс описывает клинику
 * @autor irinaff
 * @since 17.09.2016
 */
public class Clinic {
    /**
    * Список клиентов
     **/
    private final Client[] clients;

    public Clinic(final int size) {
        this.clients = new Client[size];
    }

    /**
     * Добавить клиента
     * @param position Позиция
     * @param client Клиент
     */
    public void addClient(final int position, final Client client) {
        this.clients[position] = client;
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
}
