package ru.lesson.lessons.lesson_11;

import java.util.Scanner;

/**
 * @autor irinaff
 * @since 15.10.2016
 **/

public class InteractClinicRunner  {
    public static void main(String args[]) {
        System.out.println("Starts");
        Scanner reader = new Scanner(System.in);
        Clinic clinic = new Clinic();
        int idClientTotal = 0;
        try {
            String exit = "0";
            while (!exit.equals("1")) {
                System.out.println("Enter the type of operation : \n" +
                        "1-add client, \n" +
                        "2-add animal of client, \n" +
                        "3-find client (animal name), \n" +
                        "4-find client (client name), \n" +
                        "5-change name client, \n" +
                        "6 - change name animal, \n" +
                        "7 - delete client, \n" +
                        "8 - delete animal");
                int op_type = Integer.valueOf(reader.next());
                switch (op_type ) {
                    case 1:
                        //Integer m = args.length
                        System.out.println("Enter client name : ");
                        String idClient = reader.next();
                        System.out.println("Enter pet type : 1-Cat, 2-Dog, 3-CatDog");
                        Integer typePet = Integer.valueOf(reader.next());
                        System.out.println("Enter pet name : ");
                        String petName = reader.next();
                        switch (typePet) {
                            case 1:
                                try {
                                    clinic.addClient1(idClientTotal, new Client(idClient, new Cat(petName)));
                                } catch (UserException e) {
                                    //e.printStackTrace();
                                    System.out.println(e.getMessage());
                                    //System.out.println("Please enter two args");
                                }
                                idClientTotal++;
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Client not added. Pet type in 1,2,3!");
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("Enter client 2-name : ");
                        break;
                    case 3:
                        System.out.println("Enter client 3-name : ");
                        break;
                    case 4:
                        System.out.println("Enter client 4-name : ");
                        break;
                    case 5:
                        System.out.println("Enter client 5-name : ");
                        break;
                    case 6:
                        System.out.println("Enter client 6-name : ");
                        break;
                    case 7:
                        System.out.println("Enter client 7-name : ");
                        break;
                    case 8:
                        break;
                    default:
                        System.out.println("Operation not in:1..8");
                        break;
                }
                System.out.println("Exit : yes=1/no");
                exit = reader.next();
                clinic.chowClient1();
            }
        }
        finally {
            reader.close();
        }

    }
}
