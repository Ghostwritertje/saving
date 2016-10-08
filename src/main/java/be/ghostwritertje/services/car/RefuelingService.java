package be.ghostwritertje.services.car;

import be.ghostwritertje.domain.Car;
import be.ghostwritertje.domain.Refueling;
import be.ghostwritertje.services.DomainObjectReadService;

import java.util.List;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
public interface RefuelingService extends DomainObjectReadService<Refueling> {

    List<Refueling> findByCar(Car car);

    Refueling save(Refueling refueling);

    void delete(Refueling refueling);
}
