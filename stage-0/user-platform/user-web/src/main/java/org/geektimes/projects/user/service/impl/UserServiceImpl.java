package org.geektimes.projects.user.service.impl;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.sql.DBConnectionManager;

import java.sql.Connection;
import java.sql.DriverManager;

public class UserServiceImpl implements UserService {
    @Override
    public boolean register(User user){
        DBConnectionManager manager = new DBConnectionManager();
        String databaseURL = "jdbc:mysql://127.0.0.1:3306/db?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
        try {
            Connection connection = DriverManager.getConnection(databaseURL,"root","123456");
            manager.setConnection(connection);
            DatabaseUserRepository repo = new DatabaseUserRepository(manager);
            return repo.insert(user);
        }
        catch(Exception exception){
            exception.printStackTrace();
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public boolean deregister(User user){
        return true;
    }

    @Override
    public boolean update(User user){
        return true;
    }

    @Override
    public User queryUserById(Long id){
         User user = null;
         user.setId(id);
         return user;
    }

    @Override
    public User queryUserByNameAndPassword(String name, String password){
        User user = null;
        user.setName(name);
        return user;
    }

}
