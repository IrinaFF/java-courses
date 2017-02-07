package syerraBeyts.glava_14.p_485;

/**
 * простой класс, разделяющий данные по карточкам
 * @autor irinaff
 * @since 01.02.2017
 **/

public class QuizCard {
    private String question;
    private String answer;
    QuizCard (String q, String a) {
        question = q;
        answer = a;
    }

    public String getQuestion() {
        return question;
    }
    public String getAnswer() {
        return answer;
    }
}
