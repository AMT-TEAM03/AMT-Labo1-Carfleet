import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

// import java.io.File;
import java.util.ArrayList;
import java.util.List;


class CarTest {
    static Car _car;

    @BeforeAll
    static void beforeAll() {
        // TODO Create _car from JSON for now dummy car hardcoded...
        _car = new Car(1, "Coucou", null);
    }

    @Test
    void testPlate(){
        //JSONObject expectedData = new JSONObject("../../main/resources/dataCar.json");
        String expectedPlate = "GE 123201";

        assertEquals(expectedPlate, _car.getPlate());
    }

    @Test
    void testId(){
        // Read from JSON using official library
        int expectedInteger = 939948275;

        assertEquals(expectedInteger, _car.getId());
    }

    @Test
    void testColumns() {
        // Read from randomized columns JSON using official library
        List<Item.Column> expected_columns = new ArrayList<Item.Column>();
        // Overload _car recreated from randomized JSON
        assert(_car.getColumns() != null);
        assertEquals(expected_columns.size(), _car.getColumns().size());
        assertArrayEquals(_car.getColumns().toArray(), expected_columns.toArray());
    }
}

