package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarStatusTest {

    @Test
    void 자동차상태_생성_성공() {

        CarStatus status = new CarStatus();
        int progress = status.getProgress();
        assertThat(progress).isEqualTo(0);
    }

    @Test
    void 자동차상태_전진() {
        //given:
        CarStatus status = new CarStatus();
        //when:
        status.plusProgress();
        int progress = status.getProgress();
        //then:
        assertThat(progress).isEqualTo(1);
    }

    @Test
    void 자동차상태_상태바() {
        //given:
        CarStatus status = new CarStatus();
        final int progressCount = 5;
        //when:
        for (int i = 0; i < progressCount; i++) {
            status.plusProgress();
        }
        String progressBar = status.getProgressBar();
        //then:
        assertThat(progressBar).isEqualTo("-----");
    }
}
