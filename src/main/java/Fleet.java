import java.util.List;

public class Fleet {
    private List<Car> cars;

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
