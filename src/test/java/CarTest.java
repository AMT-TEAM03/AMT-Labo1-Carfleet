import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

class CarTest {
    static Car _car;

    @BeforeAll
    static void beforeAll() throws IOException {
        _car = Car.fromJson(new String(Files.readAllBytes(Paths.get("./src/main/resources/dataCar.json")), Charset.forName("UTF-8")));
    }

    @Test
    void testPlate(){
        String expectedPlate = "GE 123201";
        assertEquals(expectedPlate, _car.getPlate());
    }

    @Test
    void testId(){
        int expectedInteger = 939948275;
        assertEquals(expectedInteger, _car.getId());
    }

    @Test
    void testColumns() {
        assert(_car.getColumns() != null);
        assertEquals(_car.getColumns().size(), 33);
    }
}

