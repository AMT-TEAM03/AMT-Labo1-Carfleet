import java.lang.reflect.Executable;
import java.util.List;

public class Item {

    private String name;
    private int id;
    private List<Column> columns;

    static void jsonParsing() {

    }

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

    public static class JsonException extends Exception{
        public JsonException(String errorMessage) {
            super(errorMessage);
        }
    }
    public static class EmptyJsonException extends JsonException {
        public EmptyJsonException(String errorMessage) {
            super(errorMessage);
        }
    }
    public static class BadStructureException extends JsonException {
        public BadStructureException(String errorMessage) {
            super(errorMessage);
        }
    }
    public static class MissingFieldsException extends JsonException {
        public MissingFieldsException(String errorMessage) {
            super(errorMessage);
        }
    }
    public static class UnknownFieldsTypeException extends JsonException {
        public UnknownFieldsTypeException(String errorMessage) {
            super(errorMessage);
        }
    }
}
