package com.flipkart.bean;

/**
 * Represents a Role entity with details such as ID, name, and description.
 */
public class Roles {

    private int roleId;
    private String roleName;
    private String roleDescription;

    /**
     * Constructor to initialize a Role object.
     *
     * @param roleId         The unique identifier for the role.
     * @param roleName       The name of the role (e.g., admin, customer, owner).
     * @param roleDescription A brief description of the role.
     */
    public Roles(int roleId, String roleName, String roleDescription) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

    /**
     * Retrieves the role ID.
     *
     * @return The role ID.
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Sets the role ID.
     *
     * @param roleId The role ID to set.
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * Retrieves the role name.
     *
     * @return The role name.
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets the role name.
     *
     * @param roleName The role name to set.
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Retrieves the role description.
     *
     * @return The role description.
     */
    public String getRoleDescription() {
        return roleDescription;
    }

    /**
     * Sets the role description.
     *
     * @param roleDescription The role description to set.
     */
    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
