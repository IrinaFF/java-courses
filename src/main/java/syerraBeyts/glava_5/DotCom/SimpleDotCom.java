package syerraBeyts.glava_5.DotCom;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 24.01.2017
 **/

public class SimpleDotCom {
    int[] locationCells;
    int numOfHits = 0;

    public void setLocatoinCells(int[] locs) {
        locationCells = locs;
    }

    public String checkYourself(String stringGuess) {
        int guess = Integer.parseInt(stringGuess);
        String result = "Мимо";

        for(int cell : locationCells) {
            if (guess == cell) {
                numOfHits++;
                result = "Попал";
                break;
            }
        }
        if (numOfHits == locationCells.length){
            result = "Потопил";
        }
        System.out.println(result);
        return result;

    }
}
