import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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

    public static JsonArray getJsonData(String jsonString) throws JsonException {
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

        return board.get("items").getAsJsonArray();
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
