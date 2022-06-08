package ru.olmart.hiber.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.olmart.hiber.model.Car;

public class CarDaoImpl implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCars(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }
}
