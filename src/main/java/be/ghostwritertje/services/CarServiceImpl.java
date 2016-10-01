package be.ghostwritertje.services;

import be.ghostwritertje.dao.repository.CarDao;
import be.ghostwritertje.domain.Car;
import be.ghostwritertje.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    @Override
    public List<Car> findAll(Person owner) {
        Car car = new Car();
        car.setBrand("Fiat");
        car.setModel("Punto");
        car.setPurchaseDate(LocalDate.now());
        car.setOwner(owner);
        this.carDao.save(car);
        return this.carDao.findByOwner(owner);
    }
}
