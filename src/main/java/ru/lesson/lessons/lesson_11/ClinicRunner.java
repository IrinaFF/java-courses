package ru.lesson.lessons.lesson_11;

/**
 * Работа клиники
 * @autor irinaff
 * @since 17.09.2016
 */
public class ClinicRunner {

    public static void main(String[] arg) {
        final Clinic clinic = new Clinic(10);
        Client client[] = new Client[1];

        clinic.addClient(0, new Client("Brown", new Cat("Digy")));

        clinic.addClient(1, new Client("Nick", new Dog(new Dog("Sparky"))));

        clinic.addClient(2, new Client("Ann", new CatDog(new Cat("Digy"), new Dog(new Animal("Sparky")))));

        client = clinic.findClientByPetName("Sparky");
        client = clinic.findClientByName("Brown");
        clinic.changeClientName("Brown","Green");
        clinic.changeClientPetName("Green","Big Digy");

        Cat cat1 = new Cat("Digy");
        Dog dog1 = new Dog("Sparky");
        Dog dog2 = new Dog((new Animal("Sparky")));
        CatDog catdog1 = new CatDog(cat1,dog1);
        Client client1 =  new Client("Brown1", cat1);
        Client client2 =  new Client("Brown2", dog2);
        Client client3 =  new Client("Brown3", catdog1);
        //if (cat1.getName() != null )  {
            //System.out.println("Cat name: "+cat1.getName());
        //}
        System.out.println("Catdog name: "+catdog1.getName());
        System.out.println("Dog name: "+dog2.getName());
        System.out.println("Client name:"+client1.getClientId());
        System.out.println("Client1 pet name: "+client1.getPetName());
        System.out.println("Client2 pet name: "+client2.getPetName());
        System.out.println("Client3 pet name: "+client3.getPetName());

    }
}