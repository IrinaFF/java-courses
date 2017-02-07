package syerraBeyts.glava_16.p_596;

import java.util.*;
/**
 * упражнение
 * @autor irinaff
 * @since 04.02.2017
 **/

public class TestTree {
    public static void main(String[] args) {
        new TestTree().go();
    }

    public void go(){
        Book b1 = new Book("Как устроены кошки");
        Book b2 = new Book("Постройте заново свое тело");
        Book b3 = new Book("Впоисках Эмо");

        TreeSet<Book> tree = new TreeSet<Book>();
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
}
