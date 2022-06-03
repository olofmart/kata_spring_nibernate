package ru.olmart.hiber.service;

import ru.olmart.hiber.dao.UserDao;
import ru.olmart.hiber.model.Car;
import ru.olmart.hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional(readOnly = true)
    public List<User> getUsers(String carModel, int carSeries) {
        return userDao.getUsers(carModel, carSeries);
    }
}