package ru.olmart.hiber.service;

import ru.olmart.hiber.model.Car;
import ru.olmart.hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    List<User> getUsers(String carModel, int carSeries);
}