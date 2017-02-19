package syerraBeyts.glava_18.p_669;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Irina on 10.02.2017.
 * (универсальный сервис, реализует Service)
 */
public class MiniMusicService implements Service {
    MyDrawPanel myPanel;

    public JPanel getGuiPanel() {
        JPanel mainPanel = new JPanel();
        myPanel = new MyDrawPanel();
        JButton playButton = new JButton("Play it");
        playButton.addActionListener(new PlayltListener());
        mainPanel.add(myPanel);
        mainPanel.add(playButton);
        return mainPanel;
    }

    public class PlayltListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            System.out.println("MiniMusicService.PlayltListener.actionPerformed");
            try {
                Sequencer sequencer = MidiSystem.getSequencer();
                sequencer.open();

                sequencer.addControllerEventListener(myPanel, new int[]{127});
                Sequence seq = new Sequence(Sequence.PPQ, 4);
                Track track = seq.createTrack();

                for (int i = 0; i < 10; i++) {}
                for (int i = 0; i < 100; i+=4) {
                    int rNum = (int) ((Math.random() * 50) + 1);
                    if (rNum < 38) {
                        //Теперь делаем это, «только если num < 38 (75 % времени)
                        track.add(makeEvent(144,1,rNum, 100, i));
                        track.add(makeEvent(176,1,127, 0, i));
                        track.add(makeEvent(128,1,rNum, 100, i+2));
                    }
                }

                sequencer.setSequence(seq);
                sequencer.start();
                sequencer.setTempoInBPM(220);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd,chan,one,two);
            event = new MidiEvent(a, tick);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
        return event;
    }

    class MyDrawPanel extends JPanel implements ControllerEventListener {
        //Рисуем только тогда, когда наступит определенное событие
        boolean msg = false;

        public void controlChange (ShortMessage event) {
            msg = true;
            repaint();
        }

        public Dimension getPreferredSize () {
            return new Dimension(300,300);
        }

        public void painComponent (Graphics g) {
            if (msg) {
                Graphics2D g2 = (Graphics2D) g;

                int r = (int) (Math.random() * 250);
                int gr = (int) (Math.random() * 250);
                int b = (int) (Math.random() * 250);

                g.setColor(new Color(r,gr,b));

                int ht = (int) ((Math.random() * 120) + 10);
                int width = (int) ((Math.random() * 120) + 10);

                int x = (int) ((Math.random() * 40) + 10);
                int y = (int) ((Math.random() * 40) + 10);

                g.fillRect(x,y,ht,width);
                msg = false;
            }
            System.out.println("MiniMusicService.MyDrawPanel.painComponent");
        }
    }
}
