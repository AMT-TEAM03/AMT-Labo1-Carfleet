import java.util.HashSet;
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

    static public Car fromJson(JsonArray jsonData, List<Car> carList) throws Item.JsonException {
        boolean error = false;
        HashSet<String> errorMsg = new HashSet<>();

        if(jsonData.size() < 1){
            throw new Item.BadStructureException("");
        }

        for(int i = 0; i < jsonData.size(); i++){
            try {
                JsonObject item = jsonData.get(i).getAsJsonObject();

                if(!item.has("id")){
                    throw new Item.MissingFieldsException("id");
                }

                if(!item.has("name")){
                    throw new Item.MissingFieldsException("name");
                }

                if(!item.has("column_values")){
                    throw new Item.MissingFieldsException("column_values");
                }

                Gson g = new Gson();
                Car car = g.fromJson(item, Car.class);
                carList.add(car);
            }catch (Item.MissingFieldsException e){
                error = true;
                errorMsg.add(e.getMessage());
            }
        }

        if(error){
            String messageError = "";
            for(String e : errorMsg)
                messageError = messageError + e + ", ";

            throw new Item.MissingFieldsException(messageError.substring(0, messageError.length()-2));
        }
        return null;
    }
}
