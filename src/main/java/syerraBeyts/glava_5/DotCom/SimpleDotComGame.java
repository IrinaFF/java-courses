package syerraBeyts.glava_5.DotCom;

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
        SimpleDotCom theDotCom = new SimpleDotCom();
        int randomNum = (int) (Math.random() * 5); //число от 0 до 4
        int[] localions = {randomNum, randomNum + 1, randomNum + 2};
        theDotCom.setLocatoinCells(localions);

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
