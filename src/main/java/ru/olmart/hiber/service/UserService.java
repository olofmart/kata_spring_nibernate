package ru.olmart.hiber.service;

import ru.olmart.hiber.model.User;

import java.util.List;

public interface UserService {
    void addUsers(User user);
    List<User> listUsers();
    List<User> getUsers(String carModel, int carSeries);
}