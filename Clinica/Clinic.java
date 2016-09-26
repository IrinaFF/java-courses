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
            //if (this.clients[i].getPetName() != null &&  (name).equals(this.clients[i].getPetName()))  {
            if (1==1 )  {
                //result[0] = this.clients[i];
                System.out.println(
                        String.format("%s Client: %s", this.clients[i].getClientId(), "%s pet: %s", this.clients[i].getPetName())
                );
            };
        }
        return result;
    }
}
