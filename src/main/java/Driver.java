import java.util.List;

import com.google.gson.*;

public class Driver{

    private Car car;
    private String name;
    private int id;
    private List<Column> columns;
    private static Fleet fleet;

    public class Column {
        String name;
        String value;

        public Column(String title, String text){
        }
    }

    public Driver(int id, String name, List<Column> column_values, Car car){
        this.id = id;
        this.name = name;
        this.columns = column_values;
    }
    
    public Car getCar() {
        throw new UnsupportedOperationException("Not implemented...");
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

    static public Driver fromJson(String jsonString){
        String json = new String(jsonString);
        JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
        JsonObject data = obj.get("data").getAsJsonObject();
        JsonArray boards = data.get("boards").getAsJsonArray();
        JsonObject board = boards.get(0).getAsJsonObject();
        JsonArray items = board.get("items").getAsJsonArray();
        JsonObject item = items.get(0).getAsJsonObject();
        int id_car = item.get("id").getAsInt();
        // String plaque_car = item.get("name").getAsString();
        JsonArray subitems = item.get("subitems").getAsJsonArray();
        JsonObject driver_item = subitems.get(0).getAsJsonObject();
        Gson g = new Gson();
        Driver driver = g.fromJson(driver_item, Driver.class);
        driver.car = fleet.getCar(id_car);
        return driver;
    }
}
