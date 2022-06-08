package ru.olmart.hiber.dao;
import ru.olmart.hiber.model.User;

import java.util.List;

public interface UserDao {
    void addUsers(User user);
    List<User> listUsers();
    List<User> getUsers(String carModel, int carSeries);
}