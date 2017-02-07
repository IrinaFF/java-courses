package syerraBeyts.glava_6.DotCom;

import syerraBeyts.glava_5.DotCom.GameHelper;

import java.util.ArrayList;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 24.01.2017
 **/

public class SimpleDotComGame {
    public static void main(String [] args) {
        int numOfGuesses = 0; //количество ходов пользователя
        GameHelper helper = new GameHelper();
        DotCom theDotCom = new DotCom();
        int randomNum = (int) (Math.random() * 5); //число от 0 до 4
        int[] localions = {randomNum, randomNum + 1, randomNum + 2};
        ArrayList<String> locationCells = new ArrayList<String>();
        locationCells.add(0,Integer.toString(randomNum));
        locationCells.add(1,Integer.toString(randomNum + 1));
        locationCells.add(2,Integer.toString(randomNum + 2));
        theDotCom.setLocatoinCells(locationCells);

        boolean isAlive = true; //закончилась ли игра

        while (isAlive) {
            String guess = helper.getUserInput("Введите число");
            String result = theDotCom.checkYourself(guess);
            numOfGuesses++;

            if (result.equals("Потопил")) {
                isAlive = false;
                System.out.println("Вам потребовалось попыток " + numOfGuesses);
            }
        }
    }
}
