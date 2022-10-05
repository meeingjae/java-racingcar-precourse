package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    private static final CAR_NAME = "name";

    @Test
    void 자동차_생성_성공() {
        Car car = new Car(new CarName(CAR_NAME), new CarStatus());
        String name = car.getCarName();
        String progress = car.getCarProgress();
        assertThat(name).isEqualTo(CAR_NAME);
        assertThat(progress).isEqualTo("");
    }

    @Test
    void 자동차_생성_성공() {
        assertThatThrownBy(() ->  {
            Car car = new Car(new CarName(""), new CarStatus());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_전진() {
        Car car = new Car(new CarName(CAR_NAME), new CarStatus());
        car.plusProgress();
        String progress = car.getCarProgress();
        assertThat(progress).isEqualTo("-");
    }

    @Test
    void 자동차_상태() {
        Car car = new Car(new CarName(CAR_NAME), new CarStatus());
        car.plusProgress();
        String carStatus = car.getStatus();
        assertThat(progress).isEqualTo("name : -");
    }
}
