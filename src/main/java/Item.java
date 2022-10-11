import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Item {
    @SerializedName(value="name")
    private String plate;
    private int id;
    @SerializedName(value="column_values")
    private List<Column> columns;

    // TODO Not needed for deserialization
    public Item(int id, String plate, List<Column> columns){
        this.plate = plate;
        this.id = id;
        this.columns = columns;
    }

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

    public String getPlate() {
        // throw new UnsupportedOperationException("Not implemented");
        return this.plate;
    }

    public int getId() {
        return this.id;
    }

    public List<Column> getColumns() {
        return this.columns;
    }
}
