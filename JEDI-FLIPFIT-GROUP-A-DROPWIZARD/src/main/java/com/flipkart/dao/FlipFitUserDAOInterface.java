package com.flipkart.dao;

import com.flipkart.bean.Users;
import com.flipkart.exceptions.WrongCredentialsException;

public interface FlipFitUserDAOInterface {
    public int authenticateUser(String email, String password, int roleId);
    public int createUser(String name, String password, int roleId);
}
