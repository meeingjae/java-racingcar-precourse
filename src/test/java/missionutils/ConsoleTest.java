package missionutils;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsoleTest {
    final String INPUT = "input";

    @Test
    public void readLine() {
        try (MockedStatic<Console> staticConsole = Mockito.mockStatic(Console.class)) {
            staticConsole.when(Console::readLine)
                    .thenReturn(INPUT);
            String input = Console.readLine();
            assertThat(input).isEqualTo(INPUT);
        }
    }
}
