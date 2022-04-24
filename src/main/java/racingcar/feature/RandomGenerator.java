package racingcar.feature;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * 난수 생성기
 */
public class RandomGenerator {

    /**
     * @return 난수 생성
     */
    public static int generate(Number min, Number max) {
        return Randoms.pickNumberInRange(min.getNum(), max.getNum());
    }
}
