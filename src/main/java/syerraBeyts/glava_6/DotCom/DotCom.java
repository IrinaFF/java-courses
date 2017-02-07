package syerraBeyts.glava_6.DotCom;
import java.util.*;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 24.01.2017
 **/

public class DotCom {
    //ArrayList с ячейками, описывающими местоположение сайта
    private ArrayList<String> locationCells;
    //Имя сайта
    private String name;

    /**
     * сеттер, который обновляет местоположение сайта (случайный адрес,
     * предоставляемый placeDotCom() из класса Game Helper
     **/
    public void setLocatoinCells(ArrayList<String> loc) {
        locationCells = loc;
    }
    /**
     * сеттер, который обновляет имя сайта
     **/
    public void setName(String n) {
        name = n;
    }
    /**
     * принимает ход пользователя в качестве параметра, проверяет его и
     * возвращает результат "Попал", "Мимо" или "Потопил"
     **/

    public String checkYourself(String userInput) {
        String result = "Мимо";
        //если од пользователя совпал с одним из элементов ArrayList
        //то метод indexOf вернет его местоположение
        // если нет - вернет -1
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            //удаление элемента
            locationCells.remove(index);
            //все ли авдреса были разгаданы
            if (locationCells.isEmpty()) {
                result = "Потопил";
                System.out.println("Ой! Вы потопили "+ name + " :( ");
            } else {
                result = "Попал";
            }
        }
        System.out.println(result);
        return result;

    }
}
