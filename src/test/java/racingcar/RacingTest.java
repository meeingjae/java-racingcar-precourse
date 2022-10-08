package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

//TODO : 클래스명 변경
public class RacingTest {

    @Test
    void 자동차목록_생성() {
        Racing racing = new Racing("1,2,3");
        List<Car> cars = racing.getCars();
        assertThat(cars).hasSize(3);
    }

    @Test
    void 자동차목록_예외_하나이상() {
        assertThatThrownBy(() -> {
            Racing racing = new Racing("1");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차목록_예외_중복된_이름() {
        assertThatThrownBy(() -> {
            Racing racing = new Racing("1,1");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 레이싱_시작() {
        try (MockedStatic<Randoms> randomsMockedStatic = Mockito.mockStatic(Randoms.class)) {
            randomsMockedStatic.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(6);
            Racing racing = new Racing("1,2,3");
            String result = racing.race(5);
            assertThat(result).isEqualTo("최종 우승자 : 1, 2, 3");
        }
    }
}
