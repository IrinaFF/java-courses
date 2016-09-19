package Clinica;

/**
 * Работа клиники
 * ДЗ. Клиника
 Задания
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
        //Pet pet1 = new Pet("Sparky");
        //Cat cat1 = new Cat("Digy");
        //Dog dog1 = new Dog(pet1);

        clinic.addClient(0, new Client("Brown", new Cat("Digy")));

        clinic.addClient(1, new Client("Nick", new Dog(new Pet("Sparky"))));

        //clinic.addClient(2, new Client("Ann", new CatDog(new Cat("Digy"),
                                                       // new Dog(new Animal("Sparky")))));
    }
}
