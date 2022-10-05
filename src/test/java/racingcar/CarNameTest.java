package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    static final String NAME = "name";

    @Test
    void 자동차이름_생성_성공() {

        CarName carName = new CarName(NAME);
        String name = carName.getName();
        assertThat(name).isEqualTo(NAME);
    }

    @Test
    void 자동차이름_생성_실패_공백() {

        assertThatThrownBy(() -> {
            CarName carName = new CarName("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_생성_실패_다섯자이상() {
        assertThatThrownBy(() -> {
            CarName carName = new CarName("123456");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
