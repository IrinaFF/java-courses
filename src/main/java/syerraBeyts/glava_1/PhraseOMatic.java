package syerraBeyts.glava_1;

/**
 * Created by IFatkullina on 29.12.2016.
 */
public class PhraseOMatic {
    public static void main(String[] args) {
        String[] worldListOne = {"круглосуточный","трехзвенный","30000-футовый","взаимный",
                "обоюдный выигрыш","фронтенд","на основе веб-технологий","проникающий",
                "умный","шесть сигм","метод критического пути","динамичный"};
        String[] worldListTwo = {"уполномоченный","трудный","чистый продукт","ориентированный",
                "центральный","распределенный","кластеризованный","фирменный","нестандартнй ум",
                "позиционированный","сетевой","сфокусированный","использованный с выгодой",
                "выровненный","нацеленный на","общий","совместный","ускоренный"};
        String[] worldListThree = {"процесс","пункт разгрузки","выход из положения",
                "тип структуры","талант","подход","уровень завоеванного внимания",
                "портал","период времени","обзор","образец","пункт следования"};

        int oneLength = worldListOne.length;
        int twoLength = worldListTwo.length;
        int threeLength = worldListThree.length;

        int rand1 = (int) (Math.random() * oneLength);
        int rand2 = (int) (Math.random() * twoLength);
        int rand3 = (int) (Math.random() * threeLength);

        String phrase = worldListOne[rand1] + " " + worldListTwo[rand2] + " " + worldListThree[rand3];
        System.out.println( "Все что вам нужно, это - " + phrase);
    }
}
