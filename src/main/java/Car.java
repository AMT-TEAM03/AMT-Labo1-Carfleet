import java.util.List;

import com.google.gson.*;

public class Car{

    private String name;
    private int id;
    private List<Column> columns;

    public class Column {
        String name;
        String value;

        public Column(String title, String text){
        }
    }

    public Car(int id, String name, List<Column> column_values){
        this.id = id;
        this.name = name;
        this.columns = column_values;
    }

    public String getPlate() {
        throw new UnsupportedOperationException("Not implemented...");
    }

    public int getId() {
        throw new UnsupportedOperationException("Not implemented...");
    }

    public List<Column> getColumns() {
        throw new UnsupportedOperationException("Not implemented...");
    }

    public Column getColumn(String name){
        throw new UnsupportedOperationException("Not implemented...");
    }

    static public Car fromJson(String jsonString){
        String json = new String(jsonString);
        JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
        JsonObject data = obj.get("data").getAsJsonObject();
        JsonArray boards = data.get("boards").getAsJsonArray();
        JsonObject board = boards.get(0).getAsJsonObject();
        JsonArray items = board.get("items").getAsJsonArray();
        JsonObject item = items.get(0).getAsJsonObject();
        Gson g = new Gson();
        return g.fromJson(item, Car.class);
    }
}
