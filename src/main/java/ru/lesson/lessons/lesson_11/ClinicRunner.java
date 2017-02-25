package ru.lesson.lessons.lesson_11;

/**
 * Работа клиники
 * @autor irinaff
 * @since 17.09.2016
 */
public class ClinicRunner {

    public static void main(String[] arg) {
        int clinicsize = 10;
        final Clinic clinic = new Clinic(clinicsize);
        Client client;
        //Возможность добавлять клиента
        clinic.addClient(0, new Client("Brown-0", new Cat("Digy")));
        clinic.addClient(1, new Client("Nick-1", new Dog(new Dog("Sparky"))));
        clinic.addClient(2, new Client("Ann-2", new CatDog(new Cat("Digy"), new Dog(new Animal("Sparky")))));

        Cat cat = new Cat("Digy");
        client =  new Client("Brown-3", cat);
        clinic.addClient(3, client);

        Dog dog = new Dog("Sparky");
        client =  new Client("Brown-4", cat);
        clinic.addClient(4, client);

        dog = new Dog((new Animal("Sparkys")));
        client =  new Client("Brown2", dog);
        clinic.addClient(5, client);

        CatDog catdog = new CatDog(cat,dog);
        client =  new Client("Brown3", catdog);
        clinic.addClient(6, client);

        clinic.addClient(7, new Client("Brown-7"));
        clinic.addClient(8, new Client("Brown-8"));
        clinic.addClient(9, new Client("Brown-9"));

        //Указывать какой питомец есть у клиента
        clinic.addClientPet("Brown-7", new Cat("Fru"));
        clinic.addClientPet("Brown-8", new Cat("Fru-fru"));
        clinic.addClientPet("Brown-9", new Dog("Gart"));

        //Возможность искать клиента по кличке питомца
        client = clinic.findClientByPetName("Sparky");

        //Возможность искать по имени клиента
        client = clinic.findClientByName("Brown");

        //Редактировать имя клиента
        clinic.changeClientName("Brown","Green");

        //Редактировать имя питомца
        clinic.changeClientPetName("Green","Big Digy");

        //Удалять клиента
        clinic.deleteClient("Brown-8");

        //Удалять питомца
        clinic.deleteClientPet("Brown-9");

        for (int i = 0; i < clinicsize; i++) {
            System.out.println(clinic.getNameClient(i)+ " " +
                    clinic.getTypePetClient(i)+ " " +
                    clinic.getNamePetClient(i));
        }
    }
}