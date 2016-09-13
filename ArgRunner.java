/**
 * Класс для запуска калькулятора. Поддерживает ввод пользователя.
 */
public class ArgRunner {
    public static void main(String[] arg) {
        Calculator calc = new Calculator();
        String op_type = String.valueOf(arg[0]);
        int first = Integer.valueOf(arg[1]);
        int second = Integer.valueOf(arg[2]);
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
    }
}
