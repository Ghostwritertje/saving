package be.ghostwritertje.services;

import be.ghostwritertje.dao.repository.RefuelingDao;
import be.ghostwritertje.domain.Car;
import be.ghostwritertje.domain.Refueling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
@Service
public class RefuelingServiceImpl implements RefuelingService {

    @Autowired
    private RefuelingDao dao;

    @Override
    public List<Refueling> findByCar(Car car) {
        return this.dao.findByCar(car);
    }

    @Override
    public Refueling save(Refueling refueling) {
        return this.dao.save(refueling);
    }
}
