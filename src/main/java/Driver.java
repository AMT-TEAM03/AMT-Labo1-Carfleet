import java.util.List;

public class Driver extends Item{

    private Car car;

    public Driver(int id, String name, List<Column> column_values, Car car){
        super(id, name, column_values);
        this.car = car;
    }
    
    public Car getCar() {
        return this.car;
    }

}
