package syerraBeyts.glava_12.ex_418.v_3;

import syerraBeyts.glava_12.ex_418.MiniMusicPlayer2;

import javax.sound.midi.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

/**
 * третья версия музыкальной художественной прогрыммы
 * добавляем графику во второе действие
 * рисуем графику в такт музыке
 * @autor irinaff
 * @since 31.01.2017
 **/

//
public class MiniMusicPlayer3 {

    static JFrame f = new JFrame("Мой первый музыкальный клип");
    static MyDrawPanel ml;

    public static void main (String [] args) {
        MiniMusicPlayer3 mini = new MiniMusicPlayer3();
        mini.go();
    }

    public void setUpGui() {
        ml = new MyDrawPanel();
        f.setContentPane(ml);
        f.setBounds(30,30,300,300);
        f.setVisible(true);
    }

    public void go() {
        setUpGui();

        try {
            //создаем и открываем синтезатор
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            //добавляем слушателя события 127 - панель
            sequencer.addControllerEventListener(ml, new int[] {127});
            //создаем последовательность и дорожку
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            //создаем группу событий чтобы ноты выбирались случайным образом
            //от ноты фортепиано 5 до 61
            int r = 0;
            for (int i = 5; i < 60; i+= 4) {
                r = (int) ((Math.random() + 50) + 1);
                track.add(makeEvent(144,1,r,100,i)); //начало проигрывания звука i
                /*
                вот так мы ловим ритм: добавляем наше собственное событие
                ControllerEvent (176 означает что тип события - ControllerEvent)
                с аргументом события 127
                оно ничего не будет делать
                мы вставляем его лишь для того, чтобы иметь возможность
                реагировать на воспроизведенеие каждой ноты
                его цель 0- запуск чего-нибудь, что можно отслеживать
                мы не можем следить за событиями включения/выключения воспроизведения
                мы запускаем это событие в тот момент когда включается воспроизведение ноты
                 */
                track.add(makeEvent(176,1,127,0,i));
                track.add(makeEvent(128,1,r,100,i + 2)); //конец проигрывания звука i
            }

            //запускаем его
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(120);
            sequencer.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //метод обработки события из интерфейса слушателя события ControllerEvent
    //Прик аждом получении события мы пишем в командной строке ля
    public void controlChange(ShortMessage event) {
        System.out.println("ля");
    }

    public static MidiEvent makeEvent(
            int com, //тип сообщения
            int chan, //канал
            int one, //нота проигрывания
            int two, //скорость и сила нажатия клавиши
            int tick //такт, продолжительность звучания ноты
    ) {
        MidiEvent event = null;
        try {
            //создаем сообщение и событие используя параметры метода
            ShortMessage a = new ShortMessage();
            a.setMessage(com, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {  }
        return event;
    }


    //внутренний класс, панель рисования, нам нужно отслеживать события ControllerEvent
    class MyDrawPanel extends JPanel implements ControllerEventListener {
        //будем присваивать флагу true когда получим событие
        boolean msg = false;

        public void controlChange(ShortMessage event) {
            msg = true;
            repaint();
        }

        public void paintComponent(Graphics g) {
            //рисуем только когда получаем событие ControllerEvent
            if (msg) {
                Graphics2D g2 = (Graphics2D) g;
                //генерация случайного цвета
                int r = (int) (Math.random() * 250);
                int gr = (int) (Math.random() * 250);
                int b = (int) (Math.random() * 250);

                g.setColor(new Color(r,gr,b));

                //рисование полупроизвольного прямоугольника
                //высота и ширина
                int ht = (int) ((Math.random() * 120) + 10);
                int width = (int) ((Math.random() * 120) + 10);
                //координаты
                int x= (int) ((Math.random() * 40) + 10);
                int y = (int) ((Math.random() * 40) + 10);

                g.fillRect(x,y,ht,width);
                msg = false;
            }
        }
    }

}