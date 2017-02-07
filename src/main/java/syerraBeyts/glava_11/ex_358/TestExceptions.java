package syerraBeyts.glava_11.ex_358;

/**
 * @autor irinaff
 * @since 30.01.2017
 **/

public class TestExceptions {

    public static void main (String [] args) {
        String test = "Да";
        try {
            System.out.println("Начало try");
            doRisky(test);
            System.out.println("Конец try");
        } catch (ScaryException se){
            System.out.println("Жуткое исключение");
        } finally {
            System.out.println("finally");
        }
        System.out.println("Конец main");
    }

    static void doRisky (String test) throws ScaryException {
        System.out.println("Начало опасного метода");
        if ("Да".equals(test)){
            throw new ScaryException("Жуткое исключение");
        }
        System.out.println("Конец опасного метода");
        return;
    }
}

/*
нет
Начало try
Начало опасного метода
Конец опасного метода
Конец try
finally
Конец main

да
Начало try
Начало опасного метода
Жуткое исключение
finally
Конец main
 */