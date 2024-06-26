package com.flipkart.business;
import com.flipkart.bean.FlipFitGym;

public class FlipFitGymService {
    FlipFitGym gym = new FlipFitGym();
    public void createGym(int id, int gymOwnerId, String name, String location) {

        gym.setGymId(id);
        gym.setGymOwnerId(gymOwnerId);
        gym.setGymName(name);
        gym.setGymLocation(location);

        System.out.println("gym owner details added");
    }

}
