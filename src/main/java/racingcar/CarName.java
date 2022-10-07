package racingcar;

import static racingcar.Application.ERROR_HEADER;

public class CarName {
    private final String name;

    public CarName(String name) {
        validSpace(name);
        validLength(name);
        this.name = name;
    }

    private void validLength(String name) {
        if (name.length() >5) {
            System.out.println(ERROR_HEADER + " 자동차 이름은 5글자를 넘지 않아야 한다.");
            throw new IllegalArgumentException();
        }
    }

    private void validSpace(String name) {
        if (name.equals("")){
            System.out.println(ERROR_HEADER + " 자동자 이름은 공백이 아니어야 한다.");
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }
}
