package racingcar.feature;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CarsTest {

    @Test
    public void stringTest() {
        List<String> names = new ArrayList<>();
        names.add("ming");
        names.add("jae");
        System.out.println(String.join(" ", names));
    }
}
