import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {

    public static void main(String[] args) throws IOException {
        String json = new String(Files.readAllBytes(Paths.get("./src/main/resources/dataCar.json")), Charset.forName("UTF-8"));
        JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
        JsonObject data = obj.get("data").getAsJsonObject();
        JsonArray boards = data.get("boards").getAsJsonArray();
        JsonObject board = boards.get(0).getAsJsonObject();
        JsonArray items = board.get("items").getAsJsonArray();
        JsonObject item = items.get(0).getAsJsonObject();
        // String items = JsonParser.parseString(json).getAsJsonObject().get("data").getAsJsonObject().get("boards").getAsJsonArray().get(0).getAsJsonObject().get("items").getAsString();
        Gson g = new Gson();
        // String json = "{\"id\": \"939948275\", \"name\": \"GE 123201\",\"column_values\": [{\"title\": \"Modèle\",\"text\": \"Volkswagen California\"}]}";
        Item person = g.fromJson(item, Item.class);
        System.out.println(person.getPlate()); // John/
        for(Item.Column c : person.getColumns()){
            System.out.println(c.name + " " + c.value);
        }
        // System.out.println(person.getColumns());
        System.out.println(person.getId());
        // System.out.println(g.toJson(person)); // {"name":"John"}
    }
}
