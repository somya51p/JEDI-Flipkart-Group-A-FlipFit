package com.flipkart.business;

import com.flipkart.dao.FlipFitUserDAOImpl;
import com.flipkart.bean.Users;
import com.flipkart.dao.FlipFitUserDAOInterface;

public class FlipFitUserService implements FlipFitUserInterface{

    FlipFitUserDAOInterface userDAO = new FlipFitUserDAOImpl();

    public int authenticateUser(String email, String password, int roleId) {

        return userDAO.authenticateUser(email, password, roleId);
    }

    public int createUser(String email, String password, int roleId) {
        int userId = userDAO.createUser(email, password, roleId);
        if (userId > 0) {
            System.out.println("User created");
            return userId;
        }
        else {
            System.out.println("User creation failed");
        }
        return 0;

    }
}
