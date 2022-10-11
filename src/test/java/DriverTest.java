import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DriverTest {
    static Driver _driver;

    @BeforeAll
    static void beforeAll() throws IOException {
        _driver = Driver.fromJson(new String(Files.readAllBytes(Paths.get("./src/main/resources/dataDriver.json")), Charset.forName("UTF-8")));
    }

    @Test
    void testPlate() {
        String expectedPlate = "GE 4567889";

        assertEquals(expectedPlate, _driver.getPlate());
    }

    @Test
    void testId() {
        int expectedInteger = 939948325;

        assertEquals(expectedInteger, _driver.getId());
    }

    @Test
    void testColumns() {
        // Overload _car recreated from randomized JSON
        assert (_driver.getColumns() != null);
        assertEquals(_driver.getColumns().size(), 9);
    }

    @Test
    void testCar() {
        // Get car from JSON id from Fleet
        Car expected_car = new Car(1, "coucou", null); 
        assertEquals(_driver.getCar(), expected_car);
    }
}
