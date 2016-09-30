package ru.lesson.lessons.Calculator;

/**
 * Класс реализует калькулятор
 * ДЗ 2. Создать класс Calculator.
     Добавить два класс клиента ArgRunner, InteractRunner.
     ArgRunner - данные получает из параметров запуска программы.
     InteractRunner - данные вводит пользователь.
     Добавить возможность выбора операции.
     Валидацию.
     Повторное использование результата вычисления.
 */
public class Calculator {
    /*
    Результат вычисления
    */
    private int result;
    /**
     * Суммируем аргументы
     * @param params Аргументы суммирования.
     */
    public void add(int ... params) {
        for (Integer m : params) {
            this.result += m;
        }
    }
    /**
     * Вычитаем аргументы
     * @param params Аргументы вычитания.
     */
    public void diff(int ... params) {
        this.result = params[0];
        for (Integer m = 1;  m <= params.length - 1; m++) {
            this.result -= params[m];
        }
    }
    /**
     * Умножаем аргументы
     * @param params Аргументы умножения.
     */
    public void mult(int ... params) {
        this.result = params[0];
        for (Integer m = 1;  m <= params.length - 1; m++) {
            this.result *= params[m];
        }
    }
    /**
     * Делим аргументы
     * @param args входящие аргументы
     * @throws UserException если аргументов нет, вызываем исключение
     */
    public void div(int ... args) throws UserException {
        if (args.length > 0) {
            this.result = args[0];
            for (int m = 1;  m <= args.length - 1; m++) {
                if (args[m] == 0) {
                    throw new IllegalArgumentException("You try to div by 0. Please change arg!");
                }
                this.result /= args[m];
            }
        } else {
            throw new UserException("You should enter two args!");
        }
    }
    /**
     * Возводим в степень аргументы
     * @param params Аргументы возведения в степень.
     */
    public void inv(int ... params) {
        this.result = params[0];
        for (Integer m = 1;  m <= params.length - 1; m++) {
            this.result = (int) (Math.pow(this.result, params[m]));
        }
    }
    /**
     * Получить результат.
     * @return результат вычисления.
     */
    public int getResult() {
        return this.result;
    }
    /**
    * Очистить результат вычисления.
    */
    public void cleanResult() {
        this.result = 0;
    }
}
