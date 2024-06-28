package com.flipkart.business;

import com.flipkart.bean.Users;

public interface FlipFitUserInterface {
    public int authenticateUser(String email, String password, int roleId);
    public int createUser(String name, String password, int roleId);
}
