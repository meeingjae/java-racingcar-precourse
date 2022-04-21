package racingcar.feature;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * 난수 생성기
 */
public class RandomGenerator {

    private final Number min;
    private final Number max;

    /**
     * @param min 최소 값
     * @param max 최대 값
     */
    public RandomGenerator(Number min, Number max) {
        this.min = min;
        this.max = max;
    }

    /**
     * @return 난수 생성
     */
    public int generate() {
        return Randoms.pickNumberInRange(min.getNum(), max.getNum());
    }
}
