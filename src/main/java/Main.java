import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {
        Gson g = new Gson();
        String json = "{\"id\": \"939948275\", \"name\": \"GE 123201\",\"column_values\": [{\"title\": \"Modèle\",\"text\": \"Volkswagen California\"}]}";
        Item person = g.fromJson(json, Item.class);
        System.out.println(person.getPlate()); // John
        System.out.println(g.toJson(person)); // {"name":"John"}
    }
    
}
