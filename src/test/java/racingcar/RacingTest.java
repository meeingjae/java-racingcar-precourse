package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;

//TODO : 클래스명 변경
public class RacingTest {

    @Test
    void 자동차목록_생성() {
        Racing racing = new Racing(Arrays.asList(
                new Car(new CarName("1"), new CarStatus()),
                new Car(new CarName("2"), new CarStatus()),
                new Car(new CarName("3"), new CarStatus()))
        );
        List<Cars> cars = carLine.getCars();
        assertThat(cars).size(3);
    }

    @Test
    void 자동차목록_예외_하나이상() {
        assertThatThrownBy(() -> {
            Racing racing = new Racing(Arrays.asList(
                    new Car(new CarName("1"), new CarStatus())
            );
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차목록_예외_중복된_이름() {
        assertThatThrownBy(() -> {
            Racing racing = new Racing(Arrays.asList(
                    new Car(new CarName("1"), new CarStatus()),
                    new Car(new CarName("1"), new CarStatus())
            );
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 레이싱_시작() {
        MockedStatic<Randoms> randomsMockedStatic = Mockito.mockStatic(Randoms.class);
        randomsMockedStatic.when(() -> Randoms.pickNumberInRange(any(), any()))
                .thenReturn(6);
        Racing racing = new Racing(Arrays.asList(
                new Car(new CarName("1"), new CarStatus()),
                new Car(new CarName("2"), new CarStatus()),
                new Car(new CarName("3"), new CarStatus()))
        );
        racing.race();
        String result = racing.getResult();
        assertThat(result).isEqualTo("최종 우승자 : 1, 2, 3");
    }
}
