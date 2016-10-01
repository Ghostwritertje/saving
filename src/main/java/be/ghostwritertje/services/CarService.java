package be.ghostwritertje.services;

import be.ghostwritertje.domain.Car;
import be.ghostwritertje.domain.Person;

import java.util.List;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
public interface CarService {
    List<Car> findAll(Person person);
}
