package CollectionTest;

import java.util.*;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 11.03.2017
 **/

public class CollectionsTasks {
    public static void main(String[] args) {
        //Надо выяснить, начинается ли список с определённых элементов? И тут subList в руки!
        List<String> myList = new ArrayList<String>();
        myList.add("a1");
        myList.add("a2");
        myList.add("a3");
        myList.add("a4");
        myList.add("a5");
        myList.add("a6");
        myList.add("a7");
        myList.add("a8");
        List<String> prefix = Arrays.asList("a1", "a2", "a3");
        System.out.println("myList.size()" + myList.size());
        System.out.println("prefix.size()" + prefix.size());
        System.out.println(myList.subList(0, prefix.size()));

        if(myList.size() >= prefix.size() &&
                myList.subList(0, prefix.size()).equals(prefix)) {
            System.out.println("ok");
        }

        //Нужно удалить много элементов из середины списка? Ничего нет проще:
        myList.subList(2, 4).clear();
        System.out.println(myList);

        //Надо добавить в один список все элементы другого списка за исключением первого? И тут subList придёт на помощь:
        myList.addAll(prefix.subList(1, prefix.size()));
        System.out.println(myList);

        String[] ar = {"0","1","2","3","4","5","6","7"};
        System.out.println("myList.size()" + myList.size());
        //System.out.println(Arrays.asList(myList).getClass().getName());
        System.out.println(Arrays.asList(ar).subList(1,5));



        }
    //Многие сталкиваются c задачей отыскать, скажем, 10 минимальных значений большого несортированного списка.
    // Чаще всего список сортируют и потом берут первые 10 значений.
    // Если исходный список менять нельзя, придётся его ещё скопировать для сортировки.
    // А ведь очередь с приоритетом легко справится с этой задачей:
    public static <T extends Comparable<T>> List<T> leastN(Collection<T> input, int n) {
        assert n > 0;
        PriorityQueue<T> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (T t : input) {
            if (pq.size() < n) {
                pq.add(t);
            } else if (pq.peek().compareTo(t) > 0) {
                pq.poll();
                pq.add(t);
            }
        }
        List<T> list = new ArrayList<>(pq);
        Collections.sort(list);
        return list;
    }

}
