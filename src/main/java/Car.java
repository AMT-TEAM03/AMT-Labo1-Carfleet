import java.util.List;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;

public class Car{
    @SerializedName(value="name")
    private String plate;
    private int id;
    @SerializedName(value="column_values")
    private List<Column> columns;

    private static Fleet fleet = null;

    public class Column {
        @SerializedName(value="title")
        String name;
        @SerializedName(value = "text")
        String value;

        public Column(String title, String text){
            this.name = title;
            this.value = text;
        }
    }
    public Car(int id, String plate, List<Column> columns){
        this.id = id;
        this.plate = plate;
        this.columns = columns;
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

    static public Car fromJson(String jsonString) throws Item.JsonException {
        String json = jsonString;
        JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
        if(obj.size() < 1){
            throw new Item.EmptyJsonException("");
        }
        JsonObject data = obj.get("data").getAsJsonObject();
        if(data.size() < 1){
            throw new Item.BadStructureException("");
        }
        JsonArray boards = data.get("boards").getAsJsonArray();
        if(boards.size() < 1){
            throw new Item.BadStructureException("");
        }
        JsonObject board = boards.get(0).getAsJsonObject();
        JsonArray items = board.get("items").getAsJsonArray();
        if(items.size() < 1){
            throw new Item.BadStructureException("");
        }

        JsonObject item = items.get(0).getAsJsonObject();

        if(!item.has("id") || !item.has("name") || !item.has("column_values")){
            throw new Item.MissingFieldsException("blabla");
        }

        Gson g = new Gson();
        Car car = g.fromJson(item, Car.class);
        if(fleet == null)
            fleet = Fleet.getInstance();
        fleet.addCar(car);
        return car;

    }
}
