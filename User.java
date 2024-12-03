/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.administration;

/**
 *
 * @author Usuario
 */
public class User {
    private int userId;
    private String userName;
    private String password;
    private String permissions;

    // Constructor, getters y setters
    public User(int userId, String userName, String password, String permissions) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.permissions = permissions;
    }

    // Getters y setters
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPermissions() { return permissions; }
    public void setPermissions(String permissions) { this.permissions = permissions; }
}
