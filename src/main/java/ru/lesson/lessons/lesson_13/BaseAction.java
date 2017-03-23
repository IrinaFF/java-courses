package ru.lesson.lessons.lesson_13;

/**
 * Описывает базовую реализацию поведения пользователя
 */
public class BaseAction implements UserAction {
    private final GeneratorBoard generator;
    private final Board board;
    private final SaperLogic logic;


    public BaseAction(final SaperLogic logic, final Board board, final GeneratorBoard generator) {
        this.generator = generator;
        this.board = board;
        this.logic = logic;
    }
    /**
     * инициализация игры
     */
    public void initGame(){
        final Cell[][] cells = generator.generate();
        this.board.drawBoard(cells);
        this.logic.loadBoard(cells);
    }
    /**
     * действие пользователя
     */
    public void select(int x, int y, boolean bomb) {
        System.out.println("1. BaseAction.select");
        this.logic.suggest(x,y,bomb);
        board.drawCell(x,y);
        if (this.logic.shouldBang(x,y)) {
            this.board.drawBang();
        }
        if (this.logic.finish()) {
            board.drawCongratulate();
        }
    }
}
