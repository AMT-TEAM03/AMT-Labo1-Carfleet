import java.util.List;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;

public class Driver{

    private Car car;
    private String name;
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

    public Driver(int id, String name, List<Column> columns, Car car){
        this.id = id;
        this.name = name;
        this.columns = columns;
        this.car = car;
    }
    
    public Car getCar() {
        return this.car;
    }

    public String getName() {
        return this.name;
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

    static public Driver fromJson(String jsonString) throws Item.JsonException {
        String json = jsonString;
        JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
        if(obj.size() < 1){
            throw new Item.EmptyJsonException("");
        }

        if(!obj.has("data")){
            throw new Item.MissingFieldsException("data");
        }
        JsonObject data = obj.get("data").getAsJsonObject();
        if(data.size() < 1){
            throw new Item.BadStructureException("");
        }

        if(!data.has("boards")){
            throw new Item.MissingFieldsException("boards");
        }
        JsonArray boards = data.get("boards").getAsJsonArray();
        if(boards.size() < 1){
            throw new Item.BadStructureException("");
        }

        JsonObject board = boards.get(0).getAsJsonObject();

        if(!board.has("items")){
            throw new Item.MissingFieldsException("items");
        }
        JsonArray items = board.get("items").getAsJsonArray();
        if(items.size() < 1){
            throw new Item.BadStructureException("");
        }

        JsonObject item = items.get(0).getAsJsonObject();

        if(!item.has("id")){
            throw new Item.MissingFieldsException("id");
        }

        if(!item.has("name")){
            throw new Item.MissingFieldsException("name");
        }

        if(!item.has("subitems")){
            throw new Item.MissingFieldsException("item.subitems");
        }

        int id_car = item.get("id").getAsInt();
        JsonArray subitems = item.get("subitems").getAsJsonArray();
        JsonObject driver_item = subitems.get(0).getAsJsonObject();

        if(!driver_item.has("id")){
            throw new Item.MissingFieldsException("item.subitems..id");
        }

        if(!driver_item.has("name")){
            throw new Item.MissingFieldsException("item.subitems..name");
        }

        if(!driver_item.has("column_values")){
            throw new Item.MissingFieldsException("item.subitems.column_values");
        }

        Gson g = new Gson();
        Driver driver = g.fromJson(driver_item, Driver.class);
        if(fleet == null)
            fleet = Fleet.getInstance();
        driver.car = fleet.getCar(id_car);
        return driver;
    }
}
