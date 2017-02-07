package syerraBeyts.glava_16.p_584;

import java.io.*;
import java.util.*;

/**
 * упражнение с коллекциями
 * @autor irinaff
 * @since 04.02.2017
 **/

public class SortMountains {
    LinkedList<Mountain> mnt = new LinkedList<Mountain>();

    class NameCompare implements Comparator<Mountain> {
        public int compare(Mountain one, Mountain two) {
            return (one.getName().compareTo(two.getName()));
        }
    }

    class HeightCompare implements Comparator<Mountain> {
        public int compare(Mountain one, Mountain two) {
            if (one.getHeight() < two.getHeight()) {
                return 1;
            }
                if (one.getHeight() == two.getHeight()) {
                    return 0;
                }
            return -1;
            }
    }

    public static void main(String[] args) {
        new SortMountains().go();
    }

    public void go(){
        mnt.add(new Mountain("Лонг-Рейндж", 14255));
        mnt.add(new Mountain("Эльберт", 14433));
        mnt.add(new Mountain("Марун", 14156));
        mnt.add(new Mountain("Касл", 14265));

        System.out.println("В порядке добавления: \n" + mnt);

        NameCompare nc = new NameCompare();
        Collections.sort(mnt, nc);
        System.out.println("По названию: \n" + mnt);

        HeightCompare hc = new HeightCompare();
        Collections.sort(mnt, hc);
        System.out.println("По высоте: \n" + mnt);
    }

    class Mountain {
        private String name;
        private int height;

        public Mountain(String name, int height) {
            this.name = name;
            this.height = height;
        }

        public String getName() {
            return name;
        }

        public int getHeight() {
            return height;
        }

        @Override
        public String toString() {
            return name + ": " + height ;
        }
    }


}
