import java.util.ArrayList;
import java.util.List;

public class Fleet {
    private List<Car> cars = new ArrayList<Car>();

    private static Fleet instance = null;
                                              
    private Fleet() {
        // constructor of the SingletonExample class
    }

    public static Fleet getInstance() {
        // write code that allows us to create only one object
        // access the object as per our need
        if(instance == null)
            instance = new Fleet();
        return instance;
    }

    public Fleet(List<Car> cars){
        this.cars = cars;
    }

    public void addCar(Car car){
        this.cars.add(car);
    }

    public Car getCar(int id){
        for(Car car : cars)
            if(car.getId() == id)
                return car;

        return null;
    }
}
