package CollectionTest;


/**
 * Клиент
 * @autor irinaff
 * @since 17.09.2016
 */
public class Person {
    private String name;

    /**
     * Конструктор
     * @param name Имя
     */
    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
