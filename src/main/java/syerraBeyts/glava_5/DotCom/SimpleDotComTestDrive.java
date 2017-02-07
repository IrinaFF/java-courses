package syerraBeyts.glava_5.DotCom;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 24.01.2017
 **/

public class SimpleDotComTestDrive {

    public static void main(String[] args){
        SimpleDotCom dot = new SimpleDotCom();
        int[] locations = {2,3,4};
        dot.setLocatoinCells(locations);
        String userGuess = "2";
        String result = dot.checkYourself(userGuess);
        userGuess = "1";
        result = dot.checkYourself(userGuess);
    }
}
