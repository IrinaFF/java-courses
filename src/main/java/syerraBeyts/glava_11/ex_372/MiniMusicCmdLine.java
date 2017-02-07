package syerraBeyts.glava_11.ex_372;
import javax.sound.midi.*;
/**
 * @autor irinaff
 * @since 30.01.2017
 **/

public class MiniMusicCmdLine {

    public static void main (String [] args) {
        MiniMusicCmdLine mini = new MiniMusicCmdLine();
        GameHelper helper = new GameHelper();
        //if (args.length < 2) {
            //System.out.println("Не забудьте аргументы для инструмента и ноты");
        //} else {
            //int instrument = Integer.parseInt(args[0]);
            //int note = Integer.parseInt(args[1]);
            int instrument = Integer.parseInt(helper.getUserInput("Введите число - инструмент"));
            int note = Integer.parseInt(helper.getUserInput("Введите число - ноту"));
            mini.play(instrument, note);
            /*
            102 30
            80 20
            40 70
            */
        //}
    }

    public void play(int instrument, int note) {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence seg = new Sequence(Sequence.PPQ, 4);
            Track track = seg.createTrack();

            MidiEvent event = null;

            ShortMessage first = new ShortMessage();
            first.setMessage(192,1,instrument,0);
            MidiEvent changeInstrument = new MidiEvent(first,1);
            track.add(changeInstrument);

            ShortMessage a = new ShortMessage();
            a.setMessage(144,1,note,100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128,1,note,100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);
            player.setSequence(seg);
            player.start();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        //finally {}
    }
}
