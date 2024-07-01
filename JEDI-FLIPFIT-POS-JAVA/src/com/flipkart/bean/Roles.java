package com.flipkart.bean;

/**
 * Represents a role in the system.
 */
public class Roles {

    private int roleId;             // Unique identifier for the role
    private String roleName;        // Name of the role (e.g., Admin, Customer)
    private String roleDescription; // Description of the role

    /**
     * Constructs a Roles object with the given details.
     *
     * @param roleId           The unique identifier for the role.
     * @param roleName         The name of the role.
     * @param roleDescription  The description of the role.
     */
    public Roles(int roleId, String roleName, String roleDescription) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

    /**
     * Gets the unique identifier for the role.
     * @return The role ID.
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Sets the unique identifier for the role.
     * @param roleId The role ID to set.
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * Gets the name of the role.
     * @return The role name.
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets the name of the role.
     * @param roleName The role name to set.
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Gets the description of the role.
     * @return The role description.
     */
    public String getRoleDescription() {
        return roleDescription;
    }

    /**
     * Sets the description of the role.
     * @param roleDescription The role description to set.
     */
    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
