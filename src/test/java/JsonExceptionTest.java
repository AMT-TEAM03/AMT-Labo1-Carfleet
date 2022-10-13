//import com.google.gson.Gson;
import com.google.gson.Gson;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

        import static org.junit.jupiter.api.Assertions.*;

public class JsonExceptionTest {
    private Car _car;


    @BeforeAll
    static void beforeAll(){

    }

    @Test
    void testEmptyJson() throws IOException {

        String json = new String(Files.readAllBytes(Paths.get("src/test/java/resources/emptyJson.json")));
        assertThrows(Item.EmptyJsonException.class,
                ()->{
                    Car.fromJson(json);
                });
    }

    @Test
    void testBadStructure() throws IOException {
        String json = new String(Files.readAllBytes(Paths.get("src/test/java/resources/emptyJson.json")));
        assertThrows(Item.BadStructureException.class,
                ()->{
                    Car.fromJson(json);
                });
    }

    @Test
    void testMissingField() throws IOException {
        String json = new String(Files.readAllBytes(Paths.get("src/test/java/resources/emptyJson.json")));
        assertThrows(Item.BadStructureException.class,
                ()->{
                    Car.fromJson(json);
                });
    }

    @Test
    void testUnknownType(){

    }
}
