package main.java.com.flipkart.bean;

/**
 * Represents a gym in the FlipFit system.
 */
public class FlipFitGym {

    private int gymId;          // Unique identifier for the gym
    private int gymOwnerId;     // Identifier for the owner of the gym
    private String gymName;     // Name of the gym
    private String gymLocation; // Location of the gym

    /**
     * Constructs a FlipFitGym object with the given details.
     *
     * @param gymId       The unique identifier for the gym.
     * @param gymOwnerId  The identifier for the owner of the gym.
     * @param gymName     The name of the gym.
     * @param gymLocation The location of the gym.
     */
    public FlipFitGym(int gymId, int gymOwnerId, String gymName, String gymLocation) {
        this.gymId = gymId;
        this.gymOwnerId = gymOwnerId;
        this.gymName = gymName;
        this.gymLocation = gymLocation;
    }

    /**
     * Retrieves the gymId of the gym.
     *
     * @return The gymId of the gym.
     */
    public int getGymId() {
        return gymId;
    }

    /**
     * Sets the gymId for the gym.
     *
     * @param gymId The gymId to set.
     */
    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    /**
     * Retrieves the gymOwnerId of the gym.
     *
     * @return The gymOwnerId of the gym.
     */
    public int getGymOwnerId() {
        return gymOwnerId;
    }

    /**
     * Sets the gymOwnerId for the gym.
     *
     * @param gymOwnerId The gymOwnerId to set.
     */
    public void setGymOwnerId(int gymOwnerId) {
        this.gymOwnerId = gymOwnerId;
    }

    /**
     * Retrieves the gymName of the gym.
     *
     * @return The gymName of the gym.
     */
    public String getGymName() {
        return gymName;
    }

    /**
     * Sets the gymName for the gym.
     *
     * @param gymName The gymName to set.
     */
    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    /**
     * Retrieves the gymLocation of the gym.
     *
     * @return The gymLocation of the gym.
     */
    public String getGymLocation() {
        return gymLocation;
    }

    /**
     * Sets the gymLocation for the gym.
     *
     * @param gymLocation The gymLocation to set.
     */
    public void setGymLocation(String gymLocation) {
        this.gymLocation = gymLocation;
    }
}
