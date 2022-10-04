import java.util.List;

public class Item {

    private String name;
    private int id;
    private List<Column> columns;

    public Item(int id, String name, List<Column> column_values){
    }

    public class Column {
        String name;
        String value;

        public Column(String title, String text){
        }
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
}
