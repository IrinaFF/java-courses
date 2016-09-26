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
                //System.out.println("i="+i);
                //System.out.println("name="+ this.clients[i].getPetName());
                System.out.println("Client: "+ this.clients[i].getClientId()+ " pet: "+ this.clients[i].getPetName());
            };
        }
        return result;
    }
}
