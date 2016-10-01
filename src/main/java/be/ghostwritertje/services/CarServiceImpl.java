package be.ghostwritertje.services;

import be.ghostwritertje.dao.repository.CarDao;
import be.ghostwritertje.domain.Car;
import be.ghostwritertje.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao dao;

    @Autowired
    private PersonService personService;

    @PostConstruct
    private void postConstruct() {
        Car car = new Car();
        car.setBrand("Fiat");
        car.setModel("Punto");
        car.setPurchaseDate(LocalDate.now());
        car.setOwner(personService.findByUsername("Ghostwritertje"));
        this.dao.save(car);
    }

    @Override
    public List<Car> findAll(Person owner) {
        return this.dao.findByOwner(owner);
    }

    @Override
    public Car save(Car car) {
        return this.dao.save(car);
    }
}
