package racingcar;

public class Application {

    public static final String ERROR_HEADER = "[ERROR]";

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.init();
        racingGame.race();
    }
}
