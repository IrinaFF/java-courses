package syerraBeyts.glava_8.ex_255;

import syerraBeyts.glava_8.ex_236.Animal;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 26.01.2017
 **/

abstract class Dog extends Canine implements Pet {
    //реализация методов интерфейса
    public void beFriendly() {};
    public void play() {};
    //переопределенные методы
    public void eat() {};
    public void roam() {};
    public void makeNoise() {};
}

