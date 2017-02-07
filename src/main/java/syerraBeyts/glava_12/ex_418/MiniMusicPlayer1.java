package syerraBeyts.glava_12.ex_418;

import javax.sound.midi.*;
/**
 * первая версия музыкальной художественной прогрыммы
 * код упрощающй создание MIDI-событий
 * @autor irinaff
 * @since 31.01.2017
 **/

public class MiniMusicPlayer1 {

    public static void main (String [] args) {
        try {
            //создаем и открываем синтезатор
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            //создаем последовательность и дорожку
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            //создаем группу событий чтобы ноты продолжали подниматься
            //от ноты фортепиано 5 до 61
            for (int i = 5; i < 61; i+= 4) {
                track.add(makeEvent(144,1,i,100,i)); //начало проигрывания
                track.add(makeEvent(128,1,i,100,i + 2)); //конец проигрывания
            }

            //запускаем его
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
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
