package syerraBeyts.glava_16.p_561;

import java.util.*;
import java.io.*;
/**
 * без сортировки
 * @autor irinaff
 * @since 03.02.2017
 **/

public class Jukebox1 {
    //коллекция песен
    ArrayList<String> songList = new ArrayList<String>();

    public static void main(String[] args) {
        new Jukebox1().go();
    }

    //метод загружает файл и выводит содержимое songList
    public void go() {
        getSongs();
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
