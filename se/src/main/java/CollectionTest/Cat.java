package CollectionTest;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 08.03.2017
 **/

public class Cat implements Pet {
    private String mName;
    private int mAge;

    public Cat(String name) {
        mName = name;
    }

    public Cat(String name, int age) {
        mName = name;
        mAge = age;
    }

    public String getName() {
        return mName;
    };

    @Override
    public String toString() {
        return this.mName;
    }
}
