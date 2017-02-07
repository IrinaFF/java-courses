package syerraBeyts.glava_16.p_583;

import java.io.*;
import java.util.*;

/**
 * с сортировкой/ метод Collections.sort сортирует список строк в алфавитном порядке
 * @autor irinaff
 * @since 03.02.2017
 **/

public class Jukebox5 {
    ArrayList<Song> songList = new ArrayList<Song>();

    public static void main(String[] args) {
        new Jukebox5().go();
    }

    //создаем вложенный класс реализующий Comparator
    //тип параметра совадает с тем который мы будем сравнивать
    class ArtistCompare implements Comparator<Song> {
        public int compare(Song one, Song two) {
            return one.getArtist().compareTo(two.getArtist());
        }
    }

    //метод загружает файл и выводит содержимое songList
    public void go() {
        getSongs();
        System.out.println(songList);
        //вызываем статический метод
        Collections.sort(songList);
        //отсотированный список
        System.out.println(songList);

        //создаем экземпляр вложенного класса Comparator
        ArtistCompare artistCompare = new ArtistCompare();
        Collections.sort(songList, artistCompare);
        //отсотированный список
        System.out.println(songList);
    }

    //считываем файл и вызываем для каждой строки addSong
    void getSongs () {
        try {
            //File file = new File ("D:\\Test\\SongListMore.txt");
            File file = new File ("D:\\Test\\SongListMoreDubl.txt") ;
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
        Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
        songList.add(nextSong);
    }

}
