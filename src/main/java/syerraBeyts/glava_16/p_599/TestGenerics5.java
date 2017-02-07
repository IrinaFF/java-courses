package syerraBeyts.glava_16.p_599;

import java.util.*;

/**
 * обобщения
 * ArrayList<Animal> и takeAnimals1 (ArrayList<Animal> animals)
 * работает
 * @autor irinaff
 * @since 05.02.2017
 **/

public class TestGenerics5 {
    public static void main(String[] args) {
        new TestGenerics5().go();
    }

    public void go() {
        //ArrayList<Dog> dogs1 = new ArrayList<Animal>(); //no
        //ArrayList<Animal> animals1 = new ArrayList<Dog>();//no
        List<Animal> list = new ArrayList<Animal>(); //да
        ArrayList<Dog> dogs = new ArrayList<Dog>();//да
        //ArrayList<Animal> animals = dogs;//no
        List<Dog> dogList = dogs;//yes
        ArrayList<Object> objects = new ArrayList<Object>();//yes
        List<Object> objList = objects;//yes
        //ArrayList<Object> objs = new ArrayList<Dog>();//no
    }

}
