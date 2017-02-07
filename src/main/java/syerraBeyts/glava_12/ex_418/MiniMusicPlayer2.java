package syerraBeyts.glava_12.ex_418;

import javax.sound.midi.*;

/**
 * вторая версия музыкальной художественной прогрыммы
 * регистрируем и слушаем события, но без графики
 * выводим сообщение в командную строку с каждым тактом
 * @autor irinaff
 * @since 31.01.2017
 **/

//нам нужно отслеживать события ControllerEvent, поэтому мы реализуем интерфейс слушателя
public class MiniMusicPlayer2 implements ControllerEventListener {

    public static void main (String [] args) {
        MiniMusicPlayer2 mini = new MiniMusicPlayer2();
        mini.go();
    }

    public void go() {
        try {
            //создаем и открываем синтезатор
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            /*
            регистрируем события синтезатором
            метод, отвечающий за регистрацию
            принимает объект слушателя и целочсленный массив
            - список событий
            нас интересует только событие 127
             */
            int[] eventsIWant = {127};
            sequencer.addControllerEventListener(this,eventsIWant);

            //создаем последовательность и дорожку
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            //создаем группу событий чтобы ноты продолжали подниматься
            //от ноты фортепиано 5 до 61
            for (int i = 5; i < 60; i+= 4) {
                track.add(makeEvent(144,1,i,100,i)); //начало проигрывания звука i
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
                track.add(makeEvent(128,1,i,100,i + 2)); //конец проигрывания звука i
            }

            //запускаем его
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
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
}

