package org.geektimes.projects.user.service.impl;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public boolean register(User user){
        DatabaseUserRepository.INSERT_USER_DML_SQL
         return true;
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
