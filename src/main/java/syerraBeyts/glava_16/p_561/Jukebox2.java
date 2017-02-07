package syerraBeyts.glava_16.p_561;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * с сортировкой/ метод Collections.sort сортирует список строк в алфавитном порядке
 * @autor irinaff
 * @since 03.02.2017
 **/

public class Jukebox2 {
    //коллекция песен
    ArrayList<String> songList = new ArrayList<String>();

    public static void main(String[] args) {
        new Jukebox2().go();
    }

    //метод загружает файл и выводит содержимое songList
    public void go() {
        getSongs();
        System.out.println(songList);
        //вызываем статический метод
        Collections.sort(songList);
        //отсотированный список
        System.out.println(songList);
    }

    //считываем файл и вызываем для каждой строки addSong
    void getSongs () {
        try {
            File file = new File ("D:\\Test\\SongList.txt") ;
            BufferedReader reader = new BufferedReader(new FileReader(file) ) ;
            String line = null;
            while ((line = reader.readLine()) != null) {
                addSong(line);
            }
        } catch(Exception ex) {
            ex.printStackTrace ();
        }
    }

    void addSong(String lineToParse) {
        String[] tokens = lineToParse.split ("/");
        //нам нужны лишь названия песен
        songList.add(tokens[0]);
    }

}
