package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    private static final String CAR_NAME = "name";

    @Test
    void 자동차_생성_성공() {
        Car car = new Car(new CarName(CAR_NAME), new CarProgress());
        String name = car.getCarName();
        String progress = car.getCarProgressBar();
        assertThat(name).isEqualTo(CAR_NAME);
        assertThat(progress).isEqualTo("");
    }

    @Test
    void 자동차_생성_실패_자동차이름_빈값() {
        assertThatThrownBy(() -> {
            Car car = new Car(new CarName(""), new CarProgress());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_전진() {
        Car car = new Car(new CarName(CAR_NAME), new CarProgress());
        car.plusProgress();
        String progress = car.getCarProgressBar();
        assertThat(progress).isEqualTo("-");
    }

    @Test
    void 자동차_상태() {
        Car car = new Car(new CarName(CAR_NAME), new CarProgress());
        car.plusProgress();
        String carStatus = car.getStatus();
        assertThat(carStatus).isEqualTo("name : -");
    }
}
