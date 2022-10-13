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
        assertThrows(Item.EmptyJsonException.class,
                ()->{
                    Driver.fromJson(json);
                });
    }

    @Test
    void testBadStructure() throws IOException {
        String json1 = new String(Files.readAllBytes(Paths.get("src/test/java/resources/BadStructure1.json")));
        String json2 = new String(Files.readAllBytes(Paths.get("src/test/java/resources/BadStructure2.json")));
        String json3 = new String(Files.readAllBytes(Paths.get("src/test/java/resources/BadStructure3.json")));
        assertThrows(Item.BadStructureException.class,
                ()->{
                    Car.fromJson(json1);
                });
        assertThrows(Item.BadStructureException.class,
                ()->{
                    Car.fromJson(json2);
                });

        assertThrows(Item.BadStructureException.class,
                ()->{
                    Car.fromJson(json3);
                });


        assertThrows(Item.BadStructureException.class,
                ()->{
                    Driver.fromJson(json1);
                });
        assertThrows(Item.BadStructureException.class,
                ()->{
                    Driver.fromJson(json2);
                });

        assertThrows(Item.BadStructureException.class,
                ()->{
                    Driver.fromJson(json3);
                });
    }

    @Test
    void testMissingField() throws IOException {
        String jsonCar1 = new String(Files.readAllBytes(Paths.get("src/test/java/resources/missingField1Car.json")));
        String jsonCar2 = new String(Files.readAllBytes(Paths.get("src/test/java/resources/missingField2Car.json")));
        String jsonCar3 = new String(Files.readAllBytes(Paths.get("src/test/java/resources/missingField3Car.json")));

        String jsonDriver1 = new String(Files.readAllBytes(Paths.get("src/test/java/resources/missingField1Driver.json")));
        String jsonDriver2 = new String(Files.readAllBytes(Paths.get("src/test/java/resources/missingField2Driver.json")));
        String jsonDriver3 = new String(Files.readAllBytes(Paths.get("src/test/java/resources/missingField3Driver.json")));
        String jsonDriver4 = new String(Files.readAllBytes(Paths.get("src/test/java/resources/missingField4Driver.json")));
        String jsonDriver5 = new String(Files.readAllBytes(Paths.get("src/test/java/resources/missingField5Driver.json")));
        String jsonDriver6 = new String(Files.readAllBytes(Paths.get("src/test/java/resources/missingField6Driver.json")));


        assertThrows(Item.MissingFieldsException.class,
                ()->{
                    Car.fromJson(jsonCar1);
                });
        assertThrows(Item.MissingFieldsException.class,
                ()->{
                    Car.fromJson(jsonCar2);
                });

        assertThrows(Item.MissingFieldsException.class,
                ()->{
                    Car.fromJson(jsonCar3);
                });



        assertThrows(Item.MissingFieldsException.class,
                ()->{
                    Car.fromJson(jsonDriver1);
                });

        assertThrows(Item.MissingFieldsException.class,
                ()->{
                    Car.fromJson(jsonDriver2);
                });

        assertThrows(Item.MissingFieldsException.class,
                ()->{
                    Car.fromJson(jsonDriver3);
                });

        assertThrows(Item.MissingFieldsException.class,
                ()->{
                    Car.fromJson(jsonDriver4);
                });

        assertThrows(Item.MissingFieldsException.class,
                ()->{
                    Car.fromJson(jsonDriver5);
                });

        assertThrows(Item.MissingFieldsException.class,
                ()->{
                    Car.fromJson(jsonDriver6);
                });
    }

    @Test
    void testUnknownType(){

    }
}
