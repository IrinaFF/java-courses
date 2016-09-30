package ru.lesson.lessons.Calculator;
/**
 * Класс для запуска калькулятора. Поддерживает ввод пользователя.
 */
public class ArgRunner {
    public static void main(String[] arg) {
        Calculator calc = new Calculator();
        int op_type = Integer.valueOf(arg[0]);
        int first = Integer.valueOf(arg[1]);
        int second = Integer.valueOf(arg[2]);
        switch (op_type) {
            case 1://"add":
                calc.add(Integer.valueOf(first), Integer.valueOf(second));
                break;
            case 2://"diff":
                calc.diff(Integer.valueOf(first), Integer.valueOf(second));
                break;
            case 3://"mult":
                calc.mult(Integer.valueOf(first), Integer.valueOf(second));
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
                calc.inv(Integer.valueOf(first), Integer.valueOf(second));
                break;
            default:
                System.out.println("Operation not in: 1-add, 2-diff, 3-mult, 4-div,5-inv");
                break;
        }
        System.out.println("Result : " + calc.getResult());
        calc.cleanResult();
    }
}
