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
                System.out.println("Enter the type of operation : add, diff, mult, div, inv");
                String op_type = reader.next();
                System.out.println("Enter first arg : ");
                String first = reader.next();
                System.out.println("Enter second arg : ");
                String second = reader.next();
                switch (String.valueOf(op_type)) {
                    case "add":
                        calc.add(Integer.valueOf(first), Integer.valueOf(second));
                        break;
                    case "diff":
                        calc.diff(Integer.valueOf(first), Integer.valueOf(second));
                        break;
                    case "mult":
                        calc.mult(Integer.valueOf(first), Integer.valueOf(second));
                        break;
                    case "div":
                        calc.div(Integer.valueOf(first), Integer.valueOf(second));
                        break;
                    case "inv":
                        calc.inv(Integer.valueOf(first), Integer.valueOf(second));
                        break;
                    default:
                        System.out.println("Operation not in: add, diff, mult, div,inv");
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
