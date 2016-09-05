/**
 * Класс реализует калькулятор
 * ДЗ 2. Создать класс Calculator.
     Добавить два класс клиента ArgRunner, InteractRunner.
     ArgRunner - данные получает из параметров запуска программы.
     InteractRunner - данные вводит пользователь.
     Добавить возможность выборка операции. Валидацию. Повторное использование результат вычисления.
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
        for (Integer param : params) {
            this.result += param;
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
