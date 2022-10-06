import java.util.List;

public class Item {

    private String name;
    private int id;
    private List<Column> columns;

    public Item(int id, String name, List<Column> column_values){
        this.name = name;
        this.id = id;
        this.columns = column_values;
    }

    public class Column {
        String name;
        String value;

        public Column(String title, String text){
            this.name = title;
            this.value = text;        
        }
    }

    public String getPlate() {
        // throw new UnsupportedOperationException("Not implemented");
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public List<Column> getColumns() {
        return this.columns;
    }
}
