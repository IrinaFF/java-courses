package syerraBeyts.glava_11.ex_372;

import javax.sound.midi.*;
/**
 * первое приложение для проигрывания звуков
 * @autor irinaff
 * @since 30.01.2017
 **/

public class MiniMiniMusicApp {

    public static void main (String [] args) {
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();
    }

    public void play() {
        try {
            //получаем синтезатор
            Sequencer player = MidiSystem.getSequencer();
            //и открываем его, изначально он не открыт
            player.open();

            //аргументы для конструктора синтезатора
            Sequence seg = new Sequence(Sequence.PPQ, 4);

            //запрашиваем трек у последовательности
            //трек содержится в полседовательности
            //а MIDI-данные в треке
            Track track = seg.createTrack();

            //помещаем в трек MIDI-события a и b
            //создаем сообщение
            ShortMessage a = new ShortMessage();
            //помещаем в сообщение инструкцию
            //начать проигрывать ноту 44
            a.setMessage(144,1,44,100);
            //используя сообщение создаем новое событие
            //сообщение сработает на первом такте
            MidiEvent noteOn = new MidiEvent(a, 1);
            //добавляем событие в трек
            //трек хранит все объекты MidiEvent
            track.add(noteOn);

            //2
            ShortMessage b = new ShortMessage();
            b.setMessage(128,1,44,100);
            MidiEvent noteOff = new MidiEvent(b, 5);
            track.add(noteOff);

            //меняем инструмент
            //a.setMessage(192,1,102,0);

            //передаем последовательность синтезатору
            //как-будто вставляем в проигрыватель SD
            player.setSequence(seg);
            //запускаем синтезатор
            //как-будто нажимаем play
            player.start();

        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        //finally {}
    }
}
