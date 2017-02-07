package syerraBeyts.glava_11.ex_351;
import javax.sound.midi.*;
/**
 *
 * @autor irinaff
 * @since 30.01.2017
 **/

public class MusicTest1 {

    public void play(){
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            System.out.println("Мы получили синтезатор");
        } catch (MidiUnavailableException ex){
            System.out.println("Неудача");
            ex.printStackTrace();
        } finally {
            System.out.println("Выполнится в любом случае");
        }
    }
    public static void main (String [] args) {
        MusicTest1 mt = new MusicTest1();
        mt.play();;
    }
}
