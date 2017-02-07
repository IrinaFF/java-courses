package syerraBeyts.glava_6.DotCom;
import java.util.*;

/**
 * @autor irinaff
 * @since 25.01.2017
 * Игра Потопи сайт на поле 7Х7
 * цель потопить все сайты за минимальное количество попыток
 * всего 3 класса: DotCom информациея о "сайте" - 3 объъекта
 * DotComBust - игра, GameHelper - вспомогательные функции
 * класс DotComBust выполняет три главные задачи:
 * 1.подготавливает игру
 * 2.играет с пользователем, пока не будут потоплены все "сайты"
 * 3.завершает игру
 **/

public class DotComBust {
    //объявляем и инициализируем переменные которыые нам понадобятся
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> DotComList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    /**
     * метод создает объекты DotCom, присваивает им имена и адреса
     * выводит пользователю краткие инструкции
     **/
    private void setUpGame() {
        //создадим несколько сайтов и присвоим им адреса
        //создает три объекта DotCom, даем им имена и помещаем в ArrayList
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        DotComList.add(one);
        DotComList.add(two);
        DotComList.add(three);
        //Выводим краткие инструкции для пользователя
        System.out.println("Ваша цель - потопить три 'сайта'.");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Попытайтесь потопить их за минималбное количество ходов");

        //повторяем с каждым объектом DotCom в списке
        for (DotCom dotComToSet : DotComList) {
            //запрашиваем у вспомогательного объекта адрес сайта
            ArrayList<String> newLocation = helper.placeDotCom(3);
            //вызываем сеттер из объекта DotCom
            //чтобы передать местоположение которое
            //только что получили от вспомогательного объекта
            dotComToSet.setLocatoinCells(newLocation);
        }
    }
    /**
     * метод запрашивает у пользователя ход
     * вызывает метод checkUserGuess, пока все объекты не выведены из игры
     **/
    private void startPlaying() {
        //До тех пор пока список объектов DotCom не станет пустым
        while (!DotComList.isEmpty()) {
            //получаем пользовательский ввод
            String userGuess = helper.getUserInput("Сделайте ход");
            //вызываем наш метод checkUserGuess
            checkUserGuess(userGuess);
        }
        //вызываем наш метод finishGame()
        finishGame();
    }
    /**
     * метод просматривает все оставшиеся объеъекты DotCom
     * у каждого объекты вызывает метод checkYourself()
     **/
    private void checkUserGuess(String userGuess) {
        //инкрементируем количество попыток которые сделал поьзователь
        numOfGuesses++;
        //подразумеваем промах, пока не выяснили обратного
        String result = "Мимо";
        //повторяем это для всех объектов в списке
        for (DotCom dotComToTest : DotComList) {
            //просим DotCom проверить ход пользователя, ищем попадание или потопление
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("Попал")) {
                //выбираемся из цикла раньше времени, нет смысла проверять другик "сайты"
                break;
            }
            if (result.equals("Потопил")) {
                //ему пришел конец, ак что удаляем его из списка и выходи из цикла
                DotComList.remove(dotComToTest);
                break;
            }
        }
        //выводим для пользователя результат
        System.out.println(result);
    }
    /**
     * выводит на экран сообщение об успехе пользователя
     * основываясь на количестве ходов
     **/
    private void finishGame() {
        //выводим сообщение о том как пользователь прошел игру
        System.out.println("Все 'сайты' ушли ко дну! Ваши акции ничего не стоят.");

        if (numOfGuesses <= 18) {
            System.out.println("Это заняло у вас всего " + numOfGuesses + " попыток");
            System.out.println("Вы успели выбраться до того как все ваши вложения утонули.");
        } else {
            System.out.println("Это заняло у вас довольно много времени. " + numOfGuesses + " попыток");
            System.out.println("Рыбы водят хороводы вокруг ваших вложений.");
        }
    }

    public static void main(String[] args) {
        //созжаем игровой объект
        DotComBust game = new DotComBust();
        //говорим игровому объекту подготовить игру
        game.setUpGame();
        //говорим игровому объекту начать главный игровой цикл
        //продолжаем запрашивать пользовательский ввод и проверять полученные данные
        game.startPlaying();
    }
}
