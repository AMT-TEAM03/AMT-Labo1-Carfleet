import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String json = new String(Files.readAllBytes(Paths.get("./src/main/resources/dataCar.json")), Charset.forName("UTF-8"));
        JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
        JsonObject data = obj.get("data").getAsJsonObject();
        JsonArray boards = data.get("boards").getAsJsonArray();
        JsonObject board = boards.get(0).getAsJsonObject();
        JsonArray items = board.get("items").getAsJsonArray();
        JsonObject item = items.get(0).getAsJsonObject();
        Gson g = new Gson();
        Car car = g.fromJson(item, Car.class);

        JsonArray expected_columns = item.get("column_values").getAsJsonArray();
        for(JsonElement column : expected_columns){
            System.out.println(column.getAsJsonObject().get("title").getAsString());
        }
    }
    
}
