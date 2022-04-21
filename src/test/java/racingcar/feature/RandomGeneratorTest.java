package racingcar.feature;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorTest {

    @DisplayName("NumberGenerator - 한 자리 수 생성 테스트")
    @Test
    void generateSingleTest() {
        //given:
        RandomGenerator generator = new RandomGenerator(new Number(0), new Number(9));
        //when:
        List<Integer> numberList = Arrays.asList(
                generator.generate(),
                generator.generate(),
                generator.generate());
        //then:
        assertThat(numberList)
                .containsAnyOf(0,1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @DisplayName("NumberGenerator - 네 자리 수 생성 테스트")
    @Test
    void generateTrebleFigureTest() {
        //given:
        RandomGenerator generator = new RandomGenerator(new Number(1000), new Number(1005));
        //when:
        List<Integer> numberList = Arrays.asList(
                generator.generate(),
                generator.generate(),
                generator.generate());
        //then:
        assertThat(numberList)
                .containsAnyOf(1000, 1001, 1002, 1003, 1004, 1005);
    }
}
