package ru.lesson.lessons.Calculator;

import java.util.Scanner;
/**
 * Класс для запуска калькулятора. Поддерживает ввод пользователя.
 */
public class InteractRunner {

    public static void main(String[] arg) {
        Scanner reader = new Scanner(System.in);
        try {
            Calculator calc = new Calculator();
            String exit = "no";
            while (!exit.equals("yes")) {
                System.out.println("Enter the type of operation : 1-add, 2-diff, 3-mult, 4-div, 5-inv");
                int op_type = Integer.valueOf(reader.next());
                System.out.println("Enter first arg : ");
                String first = reader.next();
                System.out.println("Enter second arg : ");
                String second = reader.next();
                switch (op_type) {
                    case 1://"add":
                        calc.add(Integer.valueOf(first), Integer.valueOf(second));
                        break;
                    case 2://"diff":
                        try {
                            calc.diff(Integer.valueOf(first), Integer.valueOf(second));
                        } catch (UserException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Please enter two args");
                        }
                        break;
                    case 3://"mult":
                        try {
                            calc.mult(Integer.valueOf(first), Integer.valueOf(second));
                        } catch (UserException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Please enter two args");
                        }
                        break;
                    case 4://"div":
                        try {
                            calc.div(Integer.valueOf(first), Integer.valueOf(second));
                        } catch (UserException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Please enter two args");
                        }
                        break;
                    case 5://"inv":
                        try {
                            calc.inv(Integer.valueOf(first), Integer.valueOf(second));
                        } catch (UserException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Please enter two args");
                        }
                        break;
                    default:
                        System.out.println("Operation not in: 1-add, 2-diff, 3-mult, 4-div,5-inv");
                        break;
                }
                System.out.println("Result : " + calc.getResult());
                calc.cleanResult();
                System.out.println("Exit : yes/no");
                exit = reader.next();
            }
        } finally {
            reader.close();
        }
    }

}
