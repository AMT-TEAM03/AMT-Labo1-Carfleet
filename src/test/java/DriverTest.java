import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DriverTest {
    static Driver _driver;
    static Car _car;

    @BeforeAll
    static void beforeAll() throws IOException, Item.EmptyJsonException {
        _car = Car.fromJson(new String(Files.readAllBytes(Paths.get("./src/main/resources/dataDriver.json")), Charset.forName("UTF-8")));
        _driver = Driver.fromJson(new String(Files.readAllBytes(Paths.get("./src/main/resources/dataDriver.json")), Charset.forName("UTF-8")));
    }

    /*@Test
    void testPlate() {
        String expectedPlate = "Responsable véhicule : Maxime Fontaines";

        assertEquals(expectedPlate, _driver.getName());
    }*/

    @Test
    void testId() {
        int expectedInteger = 1879863460;

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
        Car expected_car = Fleet.getInstance().getCar(939948275);
        assertEquals(_driver.getCar(), expected_car);
    }
}
