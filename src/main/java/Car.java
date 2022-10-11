import java.util.ArrayList;
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

    static public Car fromJson(String jsonString){
        String json = new String(jsonString);
        JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
        JsonObject data = obj.get("data").getAsJsonObject();
        JsonArray boards = data.get("boards").getAsJsonArray();
        JsonObject board = boards.get(0).getAsJsonObject();
        JsonArray items = board.get("items").getAsJsonArray();
        JsonObject item = items.get(0).getAsJsonObject();
        Gson g = new Gson();
        Car car = g.fromJson(item, Car.class);
        if(fleet == null)
            fleet = new Fleet(new ArrayList<Car>());
        fleet.addCar(car);
        return car;
    }
}
