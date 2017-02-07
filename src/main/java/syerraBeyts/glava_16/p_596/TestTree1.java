package syerraBeyts.glava_16.p_596;

import java.util.*;

/**
 * упражнение
 * @autor irinaff
 * @since 04.02.2017
 **/

public class TestTree1 {
    public static void main(String[] args) {
        new TestTree1().go();
    }

    public void go(){
        Book b1 = new Book("Как устроены кошки");
        Book b2 = new Book("Постройте заново свое тело");
        Book b3 = new Book("Впоисках Эмо");

        BookCompare bookCompare = new BookCompare();

        //на вход консструктра передали компаратор
        TreeSet<Book> tree = new TreeSet<Book>(bookCompare);
        tree.add(b1);
        tree.add(b2);
        tree.add(b3);
        System.out.println(tree);
    }

    class Book implements Comparable <Book>{
        String title;

        public Book(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public int compareTo(Book b) {
            return getTitle().compareTo(b.getTitle());
        }

        @Override
        public String toString() {
            return title;
        }
    }

    public class BookCompare implements Comparator<Book> {
        public int compare(Book one, Book two) {
            return (one.title.compareTo(two.title));
        }
    }
}
