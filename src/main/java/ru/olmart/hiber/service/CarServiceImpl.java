package ru.olmart.hiber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.olmart.hiber.dao.CarDao;
import ru.olmart.hiber.model.Car;

public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    @Transactional
    @Override
    public void addCars(Car car) {
        carDao.addCars(car);
    }
}
