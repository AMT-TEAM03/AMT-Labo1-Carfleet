import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

class CarTest {
    static Item _car;

    @BeforeAll
    static void beforeAll() throws IOException {
        String json = new String(Files.readAllBytes(Paths.get("./src/main/resources/dataCar.json")));
        JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
        JsonObject data = obj.get("data").getAsJsonObject();
        JsonArray boards = data.get("boards").getAsJsonArray();
        JsonObject board = boards.get(0).getAsJsonObject();
        JsonArray items = board.get("items").getAsJsonArray();
        JsonObject item = items.get(0).getAsJsonObject();
        // String items = JsonParser.parseString(json).getAsJsonObject().get("data").getAsJsonObject().get("boards").getAsJsonArray().get(0).getAsJsonObject().get("items").getAsString();
        Gson g = new Gson();
        // String json = "{\"id\": \"939948275\", \"name\": \"GE 123201\",\"column_values\": [{\"title\": \"Modèle\",\"text\": \"Volkswagen California\"}]}";
        _car = g.fromJson(item, Item.class);
        // System.out.println(person.getPlate()); // John
        // System.out.println(g.toJson(person)); // {"name":"John"}
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

