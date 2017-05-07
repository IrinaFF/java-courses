package javarush;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IFatkullina on 14.03.2017.
 */
class Test {
    List<Integer> list;
    Test(){
        list = new ArrayList<Integer>();
        someVoid(list);
    }
    void someVoid(List<Integer> l){
        l.add(0);
        l=null;
    }
    public static void main(String[] args) {
        Test test=new Test();
        System.out.println("Size is: "+test.list.size());

        Integer a = 128;
        Integer b = 128;
        Integer c = -128;
        Integer d = -128;
        System.out.println("Integer:");
        System.out.println(a==b);
        System.out.println(c == d);

        Integer i1 = 10;
        Integer i2 = 10;

        Double d1 = 10d;
        Double d2 = 10d;

        System.out.println("Integer + Double:");
        System.out.println(i1 == i2);
        System.out.println(d1 == d2);
        System.out.println("d1:" + d1);
        System.out.println("d2:" + d2);

        long x = 5;
        long y = 2;
        byte b1 = (byte) (x / y);

        int count = 1, i = 0;
        do {
            count *= ++i;
            System.out.println("i: " + i + ", count: " + count);
            if (count > 5) break;
        } while (i <= 4);
    }
}
