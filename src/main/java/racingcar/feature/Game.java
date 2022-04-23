package racingcar.feature;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private static String INPUT_CAR_MESSAGE = "경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분";
    private static String INPUT_COUNT_MESSAGE = "시도할 횟수";

    public void startGame() {
        progress(makeCars(), makeCount());
    }

    private void progress(Cars cars, int count) {
        System.out.println("실행 결과");
        cars.progressAll(count);
        cars.printWinner();
    }

    private String input(String message) {
        System.out.println(message);
        return readLine();
    }

    private Cars makeCars() {
        try {
            String input = input(INPUT_CAR_MESSAGE);
            return new Cars(Player.makePlayer(input));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return makeCars();
        }
    }

    private int makeCount() {
        try {
            String count = input(INPUT_COUNT_MESSAGE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            makeCount();
        }
        return 1;
    }
}
