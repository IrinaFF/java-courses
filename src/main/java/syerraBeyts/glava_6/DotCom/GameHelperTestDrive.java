package syerraBeyts.glava_6.DotCom;

import java.util.ArrayList;

/**
 * мой лично класс для тестирования GameHelper
 * @autor irinaff
 * @since 25.01.2017
 **/

public class GameHelperTestDrive {
    public static void main(String[] args){
        GameHelper helper = new GameHelper();
        ArrayList<String> newLocation1 = helper.placeDotCom(3);
        ArrayList<String> newLocation2 = helper.placeDotCom(3);
        ArrayList<String> newLocation3 = helper.placeDotCom(3);

        //for (int i = 0; i < newLocation.size(); i++) {
            //System.out.println(newLocation.get(i));
        //}

        //for (int i = 0; i <helper.grid.length; i++) {//(int i : helper.grid) {
            //System.out.println("grid: " + i);
        //}
    }
}
