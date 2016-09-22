package Clinica;

/**
 * Работа клиники
 * ДЗ. Клиника
 Создать программу для обслуживания клиники домашних питомцев.
 Должна быть возможно добавлять клиентов.
 Указывать какой питомец есть у клиента.
 Возможность искать по кличке питомца, по имени клиента.
 Редактировать имя клиента, имя питомца.
 Удалять клиента, питомца.
 Возможность валидации.
 * @autor irinaff
 * @since 17.09.2016
 */
public class ClinicRunner {

    public static void main(String[] arg) {
        final Clinic clinic = new Clinic(10);



        Client[] client = new Client[]{
            clinic.addClient(0, new Client("Brown", new Cat("Digy"))),

            clinic.addClient(1, new Client("Nick", new Dog(new Dog("Sparky")))),

            clinic.addClient(2, new Client("Ann", new CatDog(new Cat("Digy"),new Dog(new Animal("Sparky")))))
        };

        //for(int i = 0; i < client.length; i++) {
            //client[i].getPetName();
        //}
    }
}
