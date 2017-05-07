package CollectionTest;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.logging.Logger;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 08.03.2017
 **/

public class StackTest {
    private static Logger log = Logger.getLogger(ArrayMultiTest.class.getName());
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(1);
        stack.push(2);

        System.out.println("Текущий стек: " + stack);
        System.out.println("Удаляем: " + stack.pop());
        System.out.println("Удаляем: " + stack.pop());
        System.out.println("Удаляем: " + stack.pop());
        System.out.println("Текущий стек: " + stack);

        Cat barsik = new Cat("Барсик", 4);
        Cat murzik = new Cat("Мурзик", 6);
        Cat vaska = new Cat("Васька", 9);

        Stack<Cat> catStack = new Stack<>();
        catStack.push(barsik);
        catStack.push(murzik);
        catStack.push(vaska);

        log.info("Текущий стек: " + catStack);
        log.info("Брысь " + catStack.pop());
        log.info("Кто последний? " + catStack.peek().toString());
        log.info("Брысь " + catStack.pop());
        log.info("Кто последний? " + catStack.peek().toString());
        log.info("Брысь " + catStack.pop());
        log.info("Никого? " + catStack.empty());
        try {
            log.info("Кто последний? " + catStack.peek().toString());
        }catch (EmptyStackException e)
        {
            log.info(e.getClass().getName());
            log.info("Пустой стек. Некого прогонять");
        }
        log.info("Текущий стек: " + catStack);
    }
}
