package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarProgressTest {

    @Test
    void 자동차상태_생성_성공() {

        CarProgress progress = new CarProgress();
        int count = progress.getCount();
        assertThat(progress).isEqualTo(0);
    }

    @Test
    void 자동차상태_전진() {
        //given:
        CarProgress progress = new CarProgress();
        //when:
        progress.plusProgress();
        int progress = progress.getCount();
        //then:
        assertThat(progress).isEqualTo(1);
    }

    @Test
    void 자동차상태_상태바() {
        //given:
        CarProgress progress = new CarProgress();
        final int progressCount = 5;
        //when:
        for (int i = 0; i < progressCount; i++) {
            progress.plusProgress();
        }
        String progressBar = progress.getProgressBar();
        //then:
        assertThat(progressBar).isEqualTo("-----");
    }

    @Test
    void 자동차상태_상태바_초기상태() {
        //given:
        CarProgress progress = new CarProgress();
        //when:
        String progressBar = progress.getProgressBar();
        //then:
        assertThat(progressBar).isEqualTo("");
    }
}
