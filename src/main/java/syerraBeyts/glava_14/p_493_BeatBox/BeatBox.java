package syerraBeyts.glava_14.p_493_BeatBox;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @autor irinaff
 * @since 01.02.2017
 **/

public class BeatBox {

    JPanel mainPanel;
    //массив для хранения флажков
    ArrayList<JCheckBox> checkboxList;
    Sequencer sequencer;
    Sequence sequence;
    Track track;
    JFrame theFrame;

    //это названия инструментов для меток интерфейса
    String [] instrumentNames = {"Bass Drum", "Closed Hi-Hat",
                    "Open Hi-Hat","Acoustic Snare", "Crash Cymbal", "Hand Clap",
                    "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga",
                    "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo",
                    "Open Hi Conga"};
    //фактические барабанные клавиши соответствующие инструментам канала барабана
    int [] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};

    public static void main(String [] args) {
        BeatBox gui = new BeatBox();
        gui.buildGUI();
    }

    public void buildGUI() {
        theFrame = new JFrame("Cyber BeatBox");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        //пустая граница позволяет создать поля между краями панели и местом размещения компонентов
        background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        checkboxList = new ArrayList<JCheckBox>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(new MyStopListener());
        buttonBox.add(stop);

        JButton upTempo = new JButton("UpTempo");
        upTempo.addActionListener(new MyUpTempoListener());
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("DownTempo");
        downTempo.addActionListener(new MyDownTempoListener());
        buttonBox.add(downTempo);

        JButton serializeit = new JButton("Serializeit");
        serializeit.addActionListener(new MySendListener());
        buttonBox.add(serializeit);

        JButton restore = new JButton("Restore");
        restore.addActionListener(new MyReadInListener());
        buttonBox.add(restore);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < 16; i++) {
            nameBox.add(new Label(instrumentNames[i]));
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        theFrame.getContentPane().add(background);

        GridLayout grid = new GridLayout(16,16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER, mainPanel);

        //создаем флажки, присваиваем им false, добавляем в массив и на панель
        for (int i = 0; i < 256; i++){
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkboxList.add(c);
            mainPanel.add(c);
        }

        setUpMidi();
        theFrame.setBounds(50,50,300,300);
        theFrame.pack();
        theFrame.setVisible(true);
    }

    //обычный midi-код для получения синтезатора, секвенсора и дорожки
    public void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ,4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        }
        catch (Exception e) {e.printStackTrace();}
    }

    //Вот здесь все и происходит! преобразуем состояния флажков в миди-события
    //и добавляем на дорожку
    public void buildTrackAndStart() {
        //создаем массив из 16 элементов, чтобы хранить значения
        //для каждого инструмента на все 16 тактов
        int [] trackList = null;

        //избавляемся от старой дорожки и создаем новую
        sequence.deleteTrack(track);
        track = sequence.createTrack();

        //делаем для каждого из 16 рядов
        for (int i = 0; i <16; i++) {
            trackList = new int[16];
            //задаем клавишу, которая представляет ударный инструмент
            //массив содержит миди-числа для каждого инструмента
            int key = instruments[i];

            //делаем это для каждого такта текущего ряда
            for (int j =0; j< 16; j++) {
                JCheckBox jc = (JCheckBox) checkboxList.get(j + (16*i));
                //установлен ли флажок на этом такте?
                if (jc.isSelected()) {
                    //ели да, то помещаем значение клавиши в текущую ячейку массива
                    trackList[j] = key;
                } else {
                    trackList[j] = 0;
                }
            }

            //для этого инструмента и для всех 16 тактов создаем события и добавляем их на дорожку
            makeTracks(trackList);
            track.add(makeEvent(176,1,127,0,16));
        }

        //мы всегда дб уверены что событие на такте 16 существует
        // (они идут от 0 до 15)
        //Иначе BeatBox может не пройти все 16 тактов
        //перед тем как заново начнет последвателность
        track.add(makeEvent(192,9,1,0,15));
        try {
            sequencer.setSequence(sequence);
            //позволяет задать количество повторений цикл, здесь бесконечный цикл
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        }
        catch (Exception e) {e.printStackTrace();}
    }

    //слушатель кнопки старт
    public class MyStartListener implements ActionListener {
        public void actionPerformed (ActionEvent a) {
            buildTrackAndStart();
        }
    }

    //слушатель кнопки стоп
    public class MyStopListener implements ActionListener {
        public void actionPerformed (ActionEvent a) {
            sequencer.stop();
        }
    }

    //слушатель кнопки UpTempo
    public class MyUpTempoListener implements ActionListener {
        public void actionPerformed (ActionEvent a) {
            float tempoFactor = sequencer.getTempoFactor();
            //коэффициент темпа определяет темп синтезатора =1
            //кнопкой изменяем его на +-3%
            sequencer.setTempoFactor((float)(tempoFactor * 1.03));
        }
    }

    //слушатель кнопки DownTempo
    public class MyDownTempoListener implements ActionListener {
        public void actionPerformed (ActionEvent a) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float)(tempoFactor * .97));
        }
    }

    //слушатель кнопки serializeit Сериализация схемы
    public class MySendListener implements ActionListener {
        public void actionPerformed (ActionEvent a) {
            System.out.println("слушатель кнопки serializeit");

            //массив хранения флажков барабанов
           boolean[] checkboxState = new boolean[256];
            for (int i = 0; i<256; i++) {
                JCheckBox check = (JCheckBox) checkboxList.get(i);
                if (check.isSelected()) {
                    checkboxState[i] = true;
                }
            }

            //Вызываем диалоговое окно
            //позволяющее пользователю называть и сохранять набор
            //программа останавливается на этой строке пока пользователь не выберет меню Save
            //навигацию, выбор файла и тд выполнит за вавс класс JFilehHoser
            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(theFrame);
            System.out.println("JFileChooser");
            File file = fileSave.getSelectedFile();
            System.out.println("file=" + file.getName());
            System.out.println("file=" + file.getPath());
            try {
                FileOutputStream fileStream = new FileOutputStream(fileSave.getSelectedFile());
                ObjectOutputStream os = new ObjectOutputStream(fileStream);
                os.writeObject(checkboxState);
                os.close();
                System.out.println("os.close");
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    //слушатель кнопки restore восстановление схемы
    //считываем булев массив и используем его для восстановления состояний флажков
    public class MyReadInListener implements ActionListener {
        public void actionPerformed (ActionEvent a) {
            System.out.println("слушатель кнопки restore");

            //Вызываем диалоговое окно
            //позволяющее пользователю называть и сохранять набор
            //программа останавливается на этой строке пока пользователь не выберет меню Save
            //навигацию, выбор файла и тд выполнит за вавс класс JFilehHoser
            JFileChooser fileRead = new JFileChooser();
            fileRead.showOpenDialog(theFrame);
            File file = fileRead.getSelectedFile();
            System.out.println("file=" + file.getName());
            System.out.println("file=" + file.getPath());

            //массив хранения флажков барабанов
            boolean[] checkboxState = null;

            try {
                FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream is = new ObjectInputStream(fileIn);
                checkboxState = (boolean[]) is.readObject();
                is.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            //восстанавливаем состояние кждого флажка в ArrayList
            //содержащий объекты JCheckBox (checkboxList)
            for (int i = 0; i<256; i++) {
                System.out.println("восстановление флажка " + i);
                JCheckBox check = (JCheckBox) checkboxList.get(i);
                if (checkboxState[i]) {
                    check.setSelected(true);
                } else {
                    check.setSelected(false);
                }
            }
            //останавливаем проигрывание
            //восстанавливаем последовательность, используя новые состояния флажков
            sequencer.stop();
            buildTrackAndStart();
        }
    }

    /*
    метод создания события для одного инструмента
    за каждый проход цикла для всех 16 тактов
    каждый элемет вх массива будет сожержать либо клавишу инструмента, либо нуль
    если не нуль, нужно создать событие для инструмента
    */
    public void makeTracks (int[] list) {
        for (int i = 0; i < 16; i++) {
            int key = list[i];
            if (key != 0) {
                //добавляем в дорожку события включения и выключения
                track.add(makeEvent(144,9,key,100,i));
                track.add(makeEvent(128,9,key,100,i+1));
            }
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
