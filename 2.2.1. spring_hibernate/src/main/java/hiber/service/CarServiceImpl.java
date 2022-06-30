package hiber.service;

import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarServiceImpl implements CarService{

    @Autowired
public CarService carService;
    @Override
    public void add(Car car) {
        carService.add(car);
    }

    @Override
    public List<Car> listCars() {
        return carService.listCars();
    }

    @Override
    public Car getCar(String model) {
        return carService.getCar(model);
    }
}
