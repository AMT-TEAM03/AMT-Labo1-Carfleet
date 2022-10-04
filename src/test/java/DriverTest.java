import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

// import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DriverTest {
    static Driver _driver;

    @BeforeAll
    static void beforeAll() {
        // TODO Create _car from JSON for now dummy car hardcoded...
        _driver = new Driver(1, "Coucou", null, null);
    }

    @Test
    void testPlate() {
        // JSONObject expectedData = new
        // JSONObject("../../main/resources/dataCar.json");
        String expectedPlate = "GE 123201";

        assertEquals(expectedPlate, _driver.getPlate());
    }

    @Test
    void testId() {
        // Read from JSON using official library
        int expectedInteger = 939948275;

        assertEquals(expectedInteger, _driver.getId());
    }

    @Test
    void testColumns() {
        // Read from randomized columns JSON using official library
        List<Item.Column> expected_columns = new ArrayList<Item.Column>();
        // Overload _car recreated from randomized JSON
        assert (_driver.getColumns() != null);
        assertEquals(expected_columns.size(), _driver.getColumns().size());
        assertArrayEquals(_driver.getColumns().toArray(), expected_columns.toArray());
    }

    @Test
    void testCar() {
        // Get car from JSON id from Fleet
        Car expected_car = new Car(1, "coucou", null); 
        assertEquals(_driver.getCar(), expected_car);
    }
}
