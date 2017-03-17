package ru.lesson.lessons.lesson_10v1;

import java.util.Scanner;

//* 1 + клиента
// "2 - add/replace animal of client, \n" +
//"3 - find client (client name), \n" +
//"4 - find client (animal name), \n" +
//"5 - find animal (client name), \n" +
//"6 - find animal (animal name), \n" +
//"7 - change name client, \n" +
//"8 - change name animal, \n" +
//"9 - delete client, \n" +
//"10 - delete animal, \n" +
//"11 - show Clinica, \n" +
//"12 - exit  \n" +

public class InteractClinicRunner {

    public static void main(String args[]) {
        System.out.println("Starts");
        ScanHelper scan = new ScanHelper();
        Scanner reader = new Scanner(System.in);
        int clinicsize = 10;
        Clinic clinic = new Clinic();
        String idClient;
        String idClientNew;
        Integer typePet = 0;
        String petName = "";
        String newPetName = "";
        myArrayList<Client> clients;
        myArrayList<Pet> pets;

        try {
            String exit = "0";
            while (!exit.equals("1")) {
                boolean isInput = true;
                //выбор операции
                int op_type = scan.enterOpType();
                switch (op_type ) {
                    //1 - add client
                    case 1:
                        System.out.println("Selected operation '1. add client'");

                        idClient = scan.enterName("Client");
                        typePet = scan.enterPetType();
                        petName = scan.enterPetName();
                        clinic.addClient(new Client(idClient));
                        System.out.println("Client "+ idClient+ " is added");
                        break;
                    //2 - add animal of client
                    case 2:
                        System.out.println("Selected operation '2. add/replace animal of client'");
                        idClient = scan.enterName("Client");
                        typePet = scan.enterPetType();
                        petName = scan.enterPetName();
                        isInput = clinic.addClientPet(idClient, createPet(petName, typePet));
                        if (isInput) {
                            System.out.println("Pet for client add/replace");
                        }
                        break;
                    case 3:
                        System.out.println("Selected operation '3. find client (client name)' : ");
                        idClient = scan.enterName("Client");
                        clients = clinic.findClientByName(idClient);
                        showClients(clients);
                        break;
                    case 4:
                        System.out.println("Selected operation '4. find client (animal name)' : ");
                        petName = scan.enterPetName();
                        clients = clinic.findClientByPetName(petName);
                        showClients(clients);
                        break;
                    case 5:
                        System.out.println("Selected operation '5. find animal (client name)' : ");
                        idClient = scan.enterName("Client");
                        pets = clinic.findPetByClientName(idClient);
                        showPets(pets);
                        break;
                    case 6:
                        System.out.println("Selected operation '6. find animal (animal name)' : ");
                        idClient = scan.enterName("Client");
                        pets = clinic.findPetByPetName(idClient);
                        showPets(pets);
                        break;
                    case 7:
                        System.out.println("Selected operation '7. change name client' : ");
                        idClient = scan.enterName("Client");
                        idClientNew = scan.enterName("idClientNew");
                        clinic.changeClientName(idClient, idClientNew);
                        break;
                    case 8:
                        System.out.println("Selected operation '8. change name animal' : ");
                        idClient = scan.enterName("Client");
                        newPetName = scan.enterName("newPet");
                        clinic.changeClientPetName(idClient, newPetName);
                        break;
                    case 9:
                        System.out.println("Selected operation '9. delete client' : ");
                        idClient = scan.enterName("Client");
                        clinic.deleteClient(idClient);
                        break;
                    case 10:
                        System.out.println("Selected operation '10. delete animal' : ");
                        idClient = scan.enterName("Client");
                        clinic.deleteClientPet(idClient);
                        break;
                    case 11:
                        System.out.println("Selected operation '11. show Clinica' : ");
                        for (int i = 0; i < clinicsize; i++) {
                            System.out.println( i + ": " + clinic.getNameClient(i)+ " " +
                                    clinic.getTypePetClient(i)+ " " +
                                    clinic.getNamePetClient(i));
                        }
                        break;
                    case 12:
                        exit = "1";
                        break;
                    default:
                        System.out.println("Operation not in:1..10");
                        break;
                }
                //exit = scan.enterYes();
            }
        }
        finally {
            reader.close();
        }
    }
    //добавить питомца
    public static Pet createPet(String namePet, int typePet) {
        Pet pet = null;
        if (typePet == 1) {
            pet = new Cat(namePet);
        }
        if (typePet == 2) {
            pet = new Dog(namePet);
        }
            //System.out.println("add pet for client: " + result.getClientId() + " pet: " + result.getPetName());
        return pet;
    }

    // вывести список найденных клиентов
    public static void showClients(myArrayList<Client> c) {
        for (int i = 0; i < c.size(); i++) {
            //System.out.println(client);
            System.out.println("N" + i + " client name: " + c.get(i).getClientId() +
                    " Client pet name: "+c.get(i).getPetName() +
                    " Pet type: " + c.get(i).getPetType());
        }
    }

    // вывести список найденных животных
    public static void showPets(myArrayList<Pet> p) {
        for (int i = 0; i < p.size(); i++) {
            //System.out.println(client);
            System.out.println("Pet name: " + p.get(i).getName());
        }
    }

}
