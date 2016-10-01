package be.ghostwritertje.services.car;

import be.ghostwritertje.domain.Car;
import be.ghostwritertje.domain.Person;
import be.ghostwritertje.services.DomainObjectReadService;

import java.util.List;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
public interface CarService extends DomainObjectReadService<Car> {
    List<Car> findAll(Person person);

    Car save(Car car);
}
