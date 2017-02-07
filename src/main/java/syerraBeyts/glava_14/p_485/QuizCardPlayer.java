package syerraBeyts.glava_14.p_485;

import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * игровой движок, который будет загружать набор флеш-карт
 * и разыгрывать их для пользователя
 * Включает меню File (Файл) с командой Load(Загрузить)
 * для загрузки набора карточек изтекстового файла.
 * @autor irinaff
 * @since 01.02.2017
 **/

public class QuizCardPlayer {
    private JTextArea display;
    private JTextArea answer;
    private ArrayList<QuizCard> cardList;
    private QuizCard currentCard;
    private int currentCardIndex;
    private JFrame frame;
    private JButton nextButton;
    private boolean isShowAnswer;

    public static void main(String [] args) {
        QuizCardPlayer player = new QuizCardPlayer();
        player.go();
    }

    public void go(){
        // Сформируем и выведем на экран GUI
        frame = new JFrame("Quiz Card Player");
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);

        display = new JTextArea(6,20);
        display.setFont(bigFont);
        display.setLineWrap(true);
        display.setEditable(true);

        JScrollPane qScroller = new JScrollPane(display);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        nextButton = new JButton("Show Qwestion");
        nextButton.addActionListener(new NextCardListener());

        mainPanel.add(qScroller);
        mainPanel.add(nextButton);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem loadMenuItem = new JMenuItem("Load Card Set");
        loadMenuItem.addActionListener(new OpenMenuListener());

        fileMenu.add(loadMenuItem);
        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(640,500);
        frame.setVisible(true);
    }

    class NextCardListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
        // Если это вопрос, показываем ответ, иначе показываем следующий вопрос
        // Установим флаг для того, что мы видим, — вопрос это или ответ
            if (isShowAnswer) {
                // Показываем ответ, так как вопрос уже был увиден
                display.setText(currentCard.getAnswer());
                nextButton.setText("Next Card");
                isShowAnswer = false;
            } else {
                // Показываем следующий вопрос
                if (currentCardIndex < cardList.size()) {
                    showNextCard();
                } else {
                    // Больше карточек нет!
                    display.setText("That was last card");
                    nextButton.setEnabled(false);
                }
            }
        }
    }
    class OpenMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
        // Вызываем диалоговое окно, позволяющее пользователю выбирать,
        // какой набор карточек открыть
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(frame);
            loadFile(fileOpen.getSelectedFile());
        }
    }
    private void loadFile(File file) {
        // Нужно создать ArrayList с карточками, считывая их из текстового файла,
        // вызванного из обработчика событий класса OpenMenuListener,
        // прочитать файл по одной строке за один раз
        // и вызвать метод makeCard() для создания новой карточки из строки
        // (одна строка в файле содержит вопрос и ответ, разделенные символом /)
        cardList = new ArrayList<QuizCard>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            //создаем строковую переменную для временного хранения каждой строки в процессе чтения
            String line = null;
            //прочитай строку текста и присвой ее переменной line
            //пока перемнная не пуста
            while ((line = reader.readLine()) != null) {
                makeCard(line);
            }
            reader.close();
        }
        catch (Exception ex) {
            System.out.println("couldn't read the card file");
            ex.printStackTrace();
        }
        // Пришло время показать первую карточку
        showNextCard();
    }

    private void makeCard( String lineToParse) {
        // Вызывается методом load File, берет строку из текстового файла,
        // делит ее на две части — вопрос и ответ — и создает новый обьект QiiizCard,
        // а затем добавляет его в ArrayList с помощью CardList
        String [] result = lineToParse.split("/");
        QuizCard card = new QuizCard (result[0],result[1]);
        cardList.add(card);
        System.out.println("made a card " + cardList.size() );
    }

    private void showNextCard() {
        //
        currentCard = cardList.get(currentCardIndex);
        currentCardIndex++;
        //display.setText("Show Answer");
        display.setText(currentCard.getQuestion());
        nextButton.setText("Show Answer");
        isShowAnswer = true;
    }
}
