import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException, Item.JsonException {
        String json = new String(Files.readAllBytes(Paths.get("./src/main/resources/dataCar.json")), Charset.forName("UTF-8"));
        JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
        if(obj.size() < 1){
            throw new Item.EmptyJsonException("");
        }
        JsonObject data = obj.get("data").getAsJsonObject();
        JsonArray boards = data.get("boards").getAsJsonArray();
        JsonObject board = boards.get(0).getAsJsonObject();
        JsonArray items = board.get("items").getAsJsonArray();
        JsonObject item = items.get(0).getAsJsonObject();

        boolean tmp1 = !item.has("id");
        boolean tmp2 = !item.has("name");
        boolean tmp3 = !item.has("column_values");

        if(!item.has("id") || !item.has("name") || !item.has("column_values")){
            throw new Item.MissingFieldsException("");
        }

        Gson g = new Gson();
        Car car = g.fromJson(item, Car.class);

        JsonArray expected_columns = item.get("column_values").getAsJsonArray();
        for(JsonElement column : expected_columns){
            System.out.println(column.getAsJsonObject().get("title").getAsString());
        }
    }
    
}
