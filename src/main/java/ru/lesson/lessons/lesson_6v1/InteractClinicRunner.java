package ru.lesson.lessons.lesson_6v1;

import java.util.Scanner;

/**
 * что-нибудь поделать с клиникой, клиентами и питомцами
 **/

public class InteractClinicRunner  {

    public static void main(String args[]) {
        System.out.println("Starts");
        ScanHelper scan = new ScanHelper();
        Scanner reader = new Scanner(System.in);
        int clinicsize = 10;
        Clinic clinic = new Clinic(clinicsize);
        int idClientTotal = 0; //счетчик массива
        int freeIndex; //первый освободившийся индекс массива клиентов
        String idClient;
        String idClientNew;
        Integer typePet = 0;
        String petName = "";
        String newPetName = "";
        Client client;

        try {
            String exit = "0";
            while (!exit.equals("1")) {
                boolean isInput = true;
                //выбор операции
                int op_type = scan.enterOpType();
                switch (op_type ) {
                    //1 - add client
                    case 1:
                        System.out.println("Selected operation 'add client'");
                        if (idClientTotal < 10) {
                            freeIndex = idClientTotal;
                        } else {
                            freeIndex = clinic.findFreeIndex();
                            if (freeIndex > 0 ) {
                                System.out.println("Client not add : 10 clients all");
                                break;
                            }
                        }
                        idClient = scan.enterName("Client");
                        typePet = scan.enterPetType();
                        petName = scan.enterPetName();
                        addClient(freeIndex, clinic, idClient, typePet, petName);
                        idClientTotal++;
                        break;
                    //2 - add animal of client
                    case 2:
                        System.out.println("Selected operation 'add animal of client'");
                        idClient = scan.enterName("Client");
                        typePet = scan.enterPetType();
                        petName = scan.enterPetName();

                        isInput = addPetForClient(clinic, idClient, typePet, petName);
                        if (!isInput) {
                            System.out.println("Pet for client not add : client not found");
                        }
                        break;
                    case 3:
                        System.out.println("Selected operation 'find client (animal name)' : ");
                        petName = scan.enterPetName();
                        client = clinic.findClientByPetName(petName);
                        break;
                    case 4:
                        System.out.println("Selected operation 'find client (client name)' : ");
                        idClient = scan.enterName("Client");
                        client = clinic.findClientByName(idClient);
                        break;
                    case 5:
                        System.out.println("Selected operation 'change name client' : ");
                        idClient = scan.enterName("Client");
                        idClientNew = scan.enterName("newClient");
                        clinic.changeClientName(idClient,idClientNew);
                        break;
                    case 6:
                        System.out.println("Selected operation 'change name animal' : ");
                        idClient = scan.enterName("Client");
                        newPetName = scan.enterName("newPet");
                        clinic.changeClientPetName(idClient, newPetName);
                        break;
                    case 7:
                        System.out.println("Selected operation 'delete client' : ");
                        idClient = scan.enterName("Client");
                        clinic.deleteClient(idClient);
                        break;
                    case 8:
                        System.out.println("Selected operation 'delete animal' : ");
                        idClient = scan.enterName("Client");
                        clinic.deleteClientPet(idClient);
                        break;
                    case 9:
                        System.out.println("Selected operation 'show Clinica' : ");
                        for (int i = 0; i < clinicsize; i++) {
                            System.out.println( i + ": " + clinic.getNameClient(i)+ " " +
                                    clinic.getTypePetClient(i)+ " " +
                                    clinic.getNamePetClient(i));
                        }
                        break;
                    case 10:
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

    //Добавление клиента
    public static void addClient(int i, Clinic clinic, String clientName,
                                 int petType, String namePet) {
        Pet pet;
        if (petType == 1) {
            pet = new Dog (namePet);
        } else if (petType == 2) {
            pet = new Cat (namePet);
        } else {
            pet = new CatDog(new Cat (namePet), new Dog (namePet));
        }
        Client client = new Client(clientName, pet);
        clinic.addClient(i, client);
    }

    //Добавление животного клиенту
    public static boolean addPetForClient(Clinic clinic, String clientName,
                                          int petType, String namePet) {
        boolean result = false;
        Pet pet = null;
        Client client = clinic.findClientByName(clientName);
        if (client != null) {
            result = true;
            if (petType == 1) {
                pet = new Dog (namePet);
            } else if (petType == 2) {
                pet = new Cat (namePet);
            } else if (petType == 3) {
                pet = new CatDog(new Cat (namePet), new Dog (namePet));
            } else {
                System.out.println("Pet not add");
            }
            client.addPet(pet);
        }
        return result;
    }
}
