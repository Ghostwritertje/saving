package be.ghostwritertje.services;

import be.ghostwritertje.domain.Car;
import be.ghostwritertje.domain.Refueling;

import java.util.List;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
public interface RefuelingService {

    List<Refueling> findByCar(Car car);
}
