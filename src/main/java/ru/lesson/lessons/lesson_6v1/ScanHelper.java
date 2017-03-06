package ru.lesson.lessons.lesson_6v1;

import java.util.Scanner;

/**
 * @autor irinaff
 * @since 24.02.2017
 **/

public class ScanHelper {
    Scanner reader = new Scanner(System.in);

    //метод для организации ввода типа операции
    public int enterOpType() {
        System.out.print("1 - add client, \n" +
                "2 - add animal of client, \n" +
                "3 - find client (animal name), \n" +
                "4 - find client (client name), \n" +
                "5 - change name client, \n" +
                "6 - change name animal, \n" +
                "7 - delete client, \n" +
                "8 - delete animal, \n" +
                "9 - show Clinica, \n" +
                "10 - exit  \n" +
                "Enter the type of operation : ");
        int opType = -1;
        boolean isInput = true;
        while (isInput) {
            try {
                opType = Integer.valueOf(reader.next());
                if (opType > 0 && opType < 11) {
                    isInput = false;
                } else {
                    System.out.println("Ввведите целое число от 1 до 10 для выбора операции");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ввведите целое число от 1 до 10 для выбора операции");
            }
        }
        return opType;
    }

    // метод для организации ввода типа животного
    public int enterPetType() {
        System.out.print("Enter pet type (1 - Cat, 2 - Dog, 3 - CatDog):");
        int typePet = -1;
        boolean isInput = true;
        typePet = Integer.valueOf(reader.next());
        /**
        if (!(typePet > 0 && typePet < 4)) {
            throw new UserException("Pet type must in 1,2,3");
        }
        **/
        while (isInput) {
            try {
                typePet = Integer.valueOf(reader.next());
                if (typePet > 0 && typePet < 4) {
                    isInput = false;
                } else {
                    System.out.println("Ввведите целое число от 1 до 3 для выбора типа животного");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ввведите целое число от 1 до 3 для выбора типа животного");
            }
        }
        return typePet;
    }

    // метод для организации ввода имени животного
    public String enterPetName() {
        String message = "Enter pet name (more tnen 3 simbols): ";
        System.out.print(message);
        String petName = "";
        boolean isInput = true;
        while (isInput) {
            petName = reader.nextLine();
            if (petName.length() > 2) {
                isInput = false;
            }
            else {
                System.out.println(message);
            }
        }
        return petName;
    }

    // метод для организации ввода имени клиента
    public String enterName(String inputType) {
        String message = "";
        int lenght = 0;
        if (inputType.equals("Client")) {
            message = "Enter client name (more then 5 simbols): ";
            lenght = 5;
        } else if (inputType.equals("newClient")) {
            message = "Enter client NEW name (more then 5 simbols): ";
            lenght = 5;
        } else if (inputType.equals("Pet")) {
            message = "Enter pet name (more then 5 simbols): ";
            lenght = 3;
        } else if (inputType.equals("newPet")) {
            message = "Enter pet NEW name (more then 5 simbols): ";
            lenght = 3;
        }
        System.out.print(message);
        String name = "";
        boolean isInput = true;
        while (isInput) {
            name = reader.next();
            if (name.length() >= lenght) {
                isInput = false;
            }
            else {
                System.out.print(message);
            }
        }
        return name;
    }

    // метод для организации ввода выйти/продолжить
    public String enterYes() {
        String exit = "";
        System.out.println("Exit : (1) = yes / (other)= no");
        exit = reader.next();
        return exit;
    }
}
