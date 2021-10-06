package baseball.view;

import static nextstep.utils.Console.*;

public class BaseballGameView {

    private static final String NUMBER_INPUT_COMMENT = "숫자를 입력해주세요 : ";
    private static final String GAME_RESTART_INPUT_COMMENT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String WRONG_INPUT_COMMENT = "[ERROR] 잘못된 입력값입니다.";

    private static final String GAME_OVER_COMMENT = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";

    public static void requestNumberInput() {
        print(NUMBER_INPUT_COMMENT);
    }

    public static void requestGameRestartInput() {
        println(GAME_RESTART_INPUT_COMMENT);
    }

    public static void wrongInput() {
        println(WRONG_INPUT_COMMENT);
    }

    public static void gameOver() {
        println(GAME_OVER_COMMENT);
    }

    public static void print(String data) {
        System.out.print(data);
    }

    public static void println(String data) {
        System.out.println(data);
    }

    public static String read() {
        return readLine();
    }
}
