package syerraBeyts.glava_14.p_474;

import java.io.*;
/**
 * сохранение и восстановление персонажей
 * @autor irinaff
 * @since 01.02.2017
 **/

public class GameSaverTest {
    public static void main(String [] args) {
        //создаем несколько персонажей
        GameCharacter one = new GameCharacter(50, "Эльф",
                new String[] {"лук", "меч", "кастет"});
        GameCharacter two = new GameCharacter(200, "Тролль",
                new String[] {"голые руки", "большой топор"});
        GameCharacter three = new GameCharacter(120, "Маг",
                new String[] {"заклинания", "невидимость"});

        //код который изменяет состояния персонажей
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        //присвоим им значения null, чтобы мы нес могли обратиться к вобъектам в куче
        one = null;
        two = null;
        three = null;
        //теперь прочитаем из файла
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));

            GameCharacter oneRestore = (GameCharacter) is.readObject();
            GameCharacter twoRestore = (GameCharacter) is.readObject();
            GameCharacter threeRestore = (GameCharacter) is.readObject();

            System.out.println("Тип первого: " + oneRestore.getType());
            System.out.println("Тип второго: " + twoRestore.getType());
            System.out.println("Тип третьего: " + threeRestore.getType());
            //is.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
