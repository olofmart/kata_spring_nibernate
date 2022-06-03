package ru.olmart.hiber;

import ru.olmart.hiber.config.AppConfig;
import ru.olmart.hiber.model.Car;
import ru.olmart.hiber.model.User;
import ru.olmart.hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
        userService.add(new User("User5", "Lastname5", "user5@mail.ru", new Car("volga", 1)));
        userService.add(new User("User6", "Lastname6", "user6@mail.ru", new Car("moscvich", 2)));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = "+user.getId());
            System.out.println("First Name = "+ user.getFirstName());
            System.out.println("Last Name = "+ user.getLastName());
            System.out.println("Email = "+ user.getEmail());
            if(user.getCar() != null) {
                System.out.println("Model car = " + user.getCar().getModel());
                System.out.println("Series car = " + user.getCar().getSeries());
            }
            System.out.println();
        }

        List<User> users2 = userService.getUsers("volga", 1);
        System.out.println();
        System.out.println(users2);

        context.close();
    }
}