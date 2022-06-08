package ru.olmart.hiber.dao;

import ru.olmart.hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUsers(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("ALL")
    public List<User> getUsers(String carModel, int carSeries) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where car in (from Car where model = :model and series = :series)");
        query.setParameter("model", carModel);
        query.setParameter("series", carSeries);;
        return query.getResultList();
    }

}