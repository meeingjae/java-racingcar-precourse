package racingcar.feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Player {

    private static final int MAX_LENGTH = 5;
    private static final String EMPTY_STRING = "";

    private final String name;

    public Player(final String name) {
        this.name = name;
    }

    public static List<Player> makePlayer(String inputNames) {
        List<String> names = makeNames(inputNames);
        validate(names);
        List<Player> players = new ArrayList<>(); //컬렉션의 선언이 반드시 필요한 것인가?
        names.forEach(name -> players.add(new Player(name)));
        return players;
    }

    private static List<String> makeNames(String inputNames) {
        return Arrays.asList(inputNames.split(","));
    }

    // 객체의 상태와 행위에 대한 책임을 한 곳에서 관리하기 위해 PlayerValidator.class로 분리하지 않는다.
    //TODO : Validate 로직 보강 필요.
    // validation 상태를 enum으로 ?
    private static void validate(List<String> names) {
        containsSpaceOrEmptyName(names);
        isOverFiveCharacter(names);
        isOnlyOnePlayer(names);
        isDuplicatedPlayer(names);
    }

    private static void containsSpaceOrEmptyName(List<String> names) {
        names.forEach(name -> {
            if (name.trim().equals(EMPTY_STRING)) {
                throw new IllegalArgumentException("[ERROR] 공백이 포함되지 않은 플레이어 이름을 입력");
            }
        });
    }

    private static void isOverFiveCharacter(List<String> names) {
        names.forEach(name -> {
            if (name.length() >= MAX_LENGTH) {
                throw new IllegalArgumentException("[ERROR] 플레이어 이름은 5글자보다 작아야한다");
            }
        });
    }

    private static void isOnlyOnePlayer(List<String> names) {
        if (names.size() == 1) {
            throw new IllegalArgumentException("[ERROR] 최소 2명 이상의 플레이어");
        }
    }

    private static void isDuplicatedPlayer(List<String> names) {
        if(names.size() != new HashSet<>(names).size()) {
            throw new IllegalArgumentException("[ERROR] 중복");
        }
    }
}
