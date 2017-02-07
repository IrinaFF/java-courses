package syerraBeyts.glava_14.p_485;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

/**
 * простой инструмент для создания
 * и сохранения электронных флеш-карт.
 * Содержит меню File (Файл) с командой Save (Сохранить)
 * для сохранения текущего набора карточек в текстовый файл.
 * @autor irinaff
 * @since 01.02.2017
 **/

public class QuizCardBuilder {
    private JTextArea question;
    private JTextArea answer;
    private ArrayList<QuizCard> cardList;
    private JFrame frame;

    public static void main(String [] args) {
        QuizCardBuilder builder = new QuizCardBuilder();
        builder.go();
    }

    public void go() {
        //Формируем GUI
        //и выводим на экран
        frame = new JFrame("Quiz Card Builder");
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);

        question = new JTextArea(6,20);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setFont(bigFont);

        JScrollPane qScroller = new JScrollPane(question);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        answer = new JTextArea(6,20);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);
        answer.setFont(bigFont);

        JScrollPane aScroller = new JScrollPane(answer);
        aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JButton nextButton = new JButton("Next Card");
        cardList = new ArrayList<QuizCard>();
        JLabel qLabel = new JLabel("Question:");
        JLabel aLabel = new JLabel("Answer:");

        mainPanel.add(qLabel);
        mainPanel.add(qScroller);
        mainPanel.add(aLabel);
        mainPanel.add(aScroller);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        newMenuItem.addActionListener(new NewMenuListener());
        saveMenuItem.addActionListener(new SaveMenuListener());

        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500,600);
        frame.setVisible(true);
    }

    //срабатывает по кнопке NextCard
    private class NextCardListener implements ActionListener {
        public void actionPerformed (ActionEvent ev) {
            // Добавляем текущдую карточку в список и очищаем текстовые области
            QuizCard card = new QuizCard(question.getText(), answer.getText());
            cardList.add(card);
            System.out.println("количество записей при переходе=" + cardList.size());
            clearCard();
        }
    }

    //команда Save из меню File
    private class SaveMenuListener implements ActionListener {
        public void actionPerformed (ActionEvent ev) {
            QuizCard card = new QuizCard(question.getText(), answer.getText());
            cardList.add(card);
            System.out.println("количество записей при сохранении=" + cardList.size());

            //Вызываем диалоговое окно
            //позволяющее пользователю называть и сохранять набор
            //программа останавливается на этой строке пока пользователь не выберет меню Save
            //навигацию, выбор файла и тд выполнит за вавс класс JFilehHoser
            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(frame);
            saveFile(fileSave.getSelectedFile());
        }
    }

    //команда New из меню File
    private class NewMenuListener implements ActionListener {
        public void actionPerformed (ActionEvent ev) {
            // Очищаем список карточек и текстовые области
            cardList.clear();
            clearCard();
        }
    }

    private void clearCard() {
        question.setText("");
        answer.setText("");
        question.requestFocus();
    }

    //вызывается из класса SaveMenuListener
    private void saveFile (File file) {
        System.out.println("file=" + file.getName());
        System.out.println("file=" + file.getPath());
        //Проходим по списку карточек и записываем
        //каждый элемент в текстовый файл, который потом
        //можно оудет прочитать
        //(то есть с чистыми разделителями между частями)
        try {
            //соединяем BufferedWriter с новым FileWriter
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            //FileWriter writer = new FileWriter(file);

            //FileOutputStream fileStream = new FileOutputStream(file);
            //ObjectOutputStream os = new ObjectOutputStream(fileStream);

            //пробегаем по с карточками и записываем их по одной на строку, разделяя вопрос и ответ
            for (QuizCard card: cardList) {
                writer.write(card.getQuestion() + "/");
                writer.write(card.getAnswer() + "\n");
                //writer.write("Привет, Фу!");
                //os.writeUTF(card.getQuestion() + "/");
                //os.writeUTF(card.getAnswer() + "\n");
                System.out.println("cardList getQuestion=" + card.getQuestion() + " getAnswer="+ card.getAnswer() );
            }
            writer.close();
        } catch (IOException ex) {
                System.out.println("couldn't write the cardList out");
            ex.printStackTrace();
        }
    }
}
