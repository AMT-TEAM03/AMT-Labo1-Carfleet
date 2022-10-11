import java.util.List;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;

public class Driver{

    private Car car;
    @SerializedName(value="name")
    private String plate;
    private int id;
    @SerializedName(value="column_values")
    private List<Column> columns;
    // TODO Check this
    private static Fleet fleet;

    public class Column {
        @SerializedName(value="title")
        String name;
        @SerializedName(value="text")
        String value;

        public Column(String title, String text){
            this.name = title;
            this.value = text;
        }
    }

    public Driver(int id, String plate, List<Column> columns, Car car){
        this.id = id;
        this.plate = plate;
        this.columns = columns;
    }
    
    public Car getCar() {
        return this.car;
    }

    public String getPlate() {
        return this.plate;
    }

    public int getId() {
        return this.id;
    }

    public List<Column> getColumns() {
        return this.columns;
    }

    public Column getColumn(String name){
        for(Column col : columns)
            if(col.name == name)
                return col;
        return null;
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
        if(fleet == null)
            fleet = Fleet.getInstance();
        driver.car = fleet.getCar(id_car);
        return driver;
    }
}
