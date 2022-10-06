package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    @Test
    void 레이싱게임_생성() {
        MockedStatic<Console> consoleMockedStatic = Mockito.mockStatic(Console.class);
        consoleMockedStatic.when(Console::readLine)
                .thenReturn("1,2,3");
        RacingGame racingGame = new RacingGame();
        racingGame.init();
    }

    @Test
    void 레이싱게임_생성_예외_사용자입력_없음() {
        MockedStatic<Console> consoleMockedStatic = Mockito.mockStatic(Console.class);
        consoleMockedStatic.when(Console::readLine)
                .thenReturn("");

        assertThatThrownBy(() -> {
            RacingGame racingGame = new RacingGame();
            racingGame.init();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
