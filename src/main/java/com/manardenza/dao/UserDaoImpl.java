package com.manardenza.dao;

import com.manardenza.entity.User;

import java.io.File;
import java.util.List;

public class UserDaoImpl extends AbstractDao<User> {

    private static UserDaoImpl instance;

    private UserDaoImpl() {
        databaseFile = new File("src/main/resources/databaseFiles/databaseUsersFile.bin");
    }

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }

    public User getUserByName(String firstName, String lastName) {
        return database.stream().filter(user -> user.getFirstName().equals(firstName)).filter(user -> user.getLastName()
            .equals(lastName)).findFirst().orElse(null);
    }
}
