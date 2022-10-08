package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static racingcar.Application.ERROR_HEADER;

public class Racing {

    private static final String COMMA = ",";

    private static final int RANDOM_START_INDEX = 0;
    private static final int RANDOM_END_INDEX = 9;
    private static final int FORWARD_STANDARD = 4;

    private final List<Car> cars;

    public Racing(String input) {
        validCarSize(input);
        validDuplicatedName(input);
        cars = new ArrayList<>();
        for (String name : input.split(",")) {
            cars.add(new Car(new CarName(name.trim()), new CarProgress()));
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public String race(int raceCount) {
        System.out.println("실행 결과");
        for (int i = 0; i < raceCount; i++) {
            race();
            System.out.println();
        }
        return getResult();
    }

    private void race() {
        for (Car car : cars) {
            int randomNum = Randoms.pickNumberInRange(RANDOM_START_INDEX, RANDOM_END_INDEX);
            progressOrNot(car, randomNum);
        }
    }

    private void progressOrNot(Car car, int randomNum) {
        if (randomNum >= FORWARD_STANDARD) {
            car.plusProgress();
        }
        System.out.println(car.getCarName() + " : " + car.getCarProgressBar());
    }

    private String getResult() {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getProgressCount());
        }
        return "최종 우승자 : " + findAllWiner(max);
    }

    private String findAllWiner(int max) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : cars) {
            addWinner(car, max, winnerNames);
        }
        return String.join(", ", winnerNames);
    }

    private void addWinner(Car car, int max, List<String> winnerNames) {
        if (car.getProgressCount() == max) {
            winnerNames.add(car.getCarName());
        }
    }

    private void validCarSize(String input) {
        if (input.split(COMMA).length == 1) {
            System.out.println(ERROR_HEADER + " 한 개 이상의 자동차 이름을 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validDuplicatedName(String input) {
        String[] names = input.split(COMMA);
        Set<String> nameSet = new HashSet<>(Arrays.asList(names));
        if (names.length != nameSet.size()) {
            System.out.println(ERROR_HEADER + " 중복되지 않는 자동차 이름을 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
