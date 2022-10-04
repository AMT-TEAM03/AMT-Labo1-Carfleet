import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
/*
class CalculatorTests {

    @Test
    @DisplayName("1 + 1 = 2")
    void addsTwoNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    void add(int first, int second, int expectedResult) {
        Calculator calculator = new Calculator();
        assertEquals(expectedResult, calculator.add(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }
}
*/

class dataCarTest {
    dataCar _dataCar;

    @org.junit.jupiter.api.BeforeEach
    void beforeEach() throws IOException {

        _dataCar = new dataCar("src/main/resources/dataCar.json");
    }

    @org.junit.jupiter.api.Test
    void testPlate(){
        //JSONObject expectedData = new JSONObject("../../main/resources/dataCar.json");

        String expectedPlate = "GE 123201";

        assertEquals(expectedPlate, _dataCar.getPlate());
    }

    @org.junit.jupiter.api.Test
    void testId(){
        int expectedInteger = 939948275;

        assertEquals(expectedInteger, _dataCar.getId());
    }

}

