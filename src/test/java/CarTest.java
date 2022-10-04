import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

class CarTest {
    static Car _car;

    @BeforeAll
    static void beforeAll() throws IOException {
        Gson g = new Gson();
        String fileName = "./src/main/resources/dataCar.json";
        String fileContent = new String(Files.readAllBytes(Paths.get(fileName)));
        // JsonObject jsonObject = JsonParser.parseString(fileContent).getAsJsonObject();
        // String items = jsonObject.get("items").toString();
        // System.out.println(items);
        // System.out.println(jsonObject.get("name").getAsString()); // John
        String json = "{\"id\": \"939948275\", \"name\": \"GE 123201\",\"column_values\": [{\"title\": \"Modèle\",\"text\": \"Volkswagen California\"}]}";
        _car = g.fromJson(json, Car.class);
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

