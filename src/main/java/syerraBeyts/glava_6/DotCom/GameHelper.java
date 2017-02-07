package syerraBeyts.glava_6.DotCom;

import java.io.*;
import java.util.*;

/**
 * это вспомогательый класс для игры
 * главная задача - создание ячеек с объектами DotCom
 * @autor irinaff
 * @since 24.01.2017
 **/

public class GameHelper {

    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    int [] grid = new int[gridSize];
    private int comCount = 0;   //номер сайта для размещения

    /**
     * вывод сообщения и полученик хода пользователя
     **/
    public String getUserInput(String prompt){
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase();
    }
    /**
     * вывод сообщения и полученик хода пользователя
     **/
    public ArrayList<String> placeDotCom(int comSize){
        ArrayList<String> alphaCells = new ArrayList<String>();
        //хранит координаты типа f6
        String [] alphacoords = new String [comSize];
        //временная строка для конкатенации
        String temp = null;
        //координаты текущего сайта
        int[] coords = new int[comSize];
        //счетчик текущих попыток
        int attempts = 0;
        //нашли подходящее местоположение?
        boolean success = false;
        //текущее начальное местоположение
        int location = 0;

        //энный сайт для размещения
        comCount++;
        //устанавливаем горизонтальный инремент
        int incr = 1;

        //если нечетный (размещаем вертикально)
        //устанавливаем вертикальный инкремент
        if ((comCount % 2) == 1) {
            incr = gridLength;
        }

        //главный поисковый цикл (32)
        while (!success & attempts++ < 200) {
            //получаем случайную стартовую точку
            location = (int) (Math.random() * gridSize);
            System.out.println("пробуем "+ location);
            //энная позиция на сайте, который нужно разместить
            int x = 0;
            //предполагаем успешный исход
            success = true;
            //ищем соседнюю неиспользованную ячейку
            while (success && x < comSize) {
                //если еще не используется
                if (grid[location] == 0) {
                    //сохраняем местоположение
                    coords[x++] = location;
                    //пробуем следующую соседнюю ячейку
                    location += incr;
                    //вышли за рамки - низ
                    if (x > 0 && (location % gridLength == 0)) {
                        //неудача
                        success = false;
                    }
                }
            }//конец while

            //переводим местоположение в симвоьные координаты
            x = 0;
            int row = 0;
            int column = 0;
            System.out.println("\n");

            while (x < comSize) {
                //помечаем ячейки на главной сетке как использованные
                grid[coords[x]] = 1;
                //получаем значение строки
                row = (int) (coords[x] / gridLength);
                //получаем числовое знаяение столбца
                column = coords[x] % gridLength;
                //преобразуем его в строковый символ
                temp = String.valueOf(alphabet.charAt(column));

                alphaCells.add(temp.concat(Integer.toString(row)));
                x++;
                //это выражение говорит вам о том где именно находится сайт
                System.out.println(" coord " + x + " = " + alphaCells.get(x-1));
            }
        }
        System.out.println("\n");
        return alphaCells;
    }


}
