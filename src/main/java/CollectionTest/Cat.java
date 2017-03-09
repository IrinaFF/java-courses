package CollectionTest;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 08.03.2017
 **/

public class Cat {
    private String mName;
    private int mAge;

    public Cat(String name, int age) {
        mName = name;
        mAge = age;
    }

    @Override
    public String toString() {
        return this.mName;
    }
}
