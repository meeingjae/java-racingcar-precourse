package racingcar;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.Application.ERROR_HEADER;

public class RacingGame {

    private Racing racing;

    public void init() {
        try {
            racing = new Racing(inputCarName());
        } catch (IllegalArgumentException e) {
            init();
        }
    }

    public void race() {
        try {
            String result = racing.race(inputGameCount());
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            race();
        }
    }

    private int inputGameCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String gameCount = Console.readLine();
        validSpace(gameCount);
        validNumeric(gameCount);
        validNatural(gameCount);
        return Integer.parseInt(gameCount);
    }

    private void validNatural(String input) {
        if (Integer.parseInt(input) < 1) {
            System.out.println(ERROR_HEADER + " 1 이상의 값을 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_HEADER + " 입력은 숫자여야합니다.");
            throw new IllegalArgumentException();
        }
    }

    private String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        validSpace(carNames);
        return carNames;
    }

    private void validSpace(String input) {
        if (input.equals("")) {
            System.out.println(ERROR_HEADER + " 빈값이 아니어야 합니다.");
            throw new IllegalArgumentException();
        }
    }

}
