import java.util.List;

public class Fleet {
    private List<Car> cars;

    public Fleet(List<Car> cars){
        this.cars = cars;
    }

    public Car getCar(int id){
        for(Car car : this.cars)
            if(car.getId() == id)
                return car;
        return null;
    }
}
