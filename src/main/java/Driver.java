import java.util.List;

public class Driver extends Item{

    private Car car;

    public Driver(int id, String name, List<Column> column_values, Car car){
        super(id, name, column_values);
    }
    
    public Car getCar() {
        throw new UnsupportedOperationException("Not implemented...");
    }

}
