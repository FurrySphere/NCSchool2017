package main.java.by.nc.school.dev.entities.users;

import main.java.by.nc.school.dev.exceptions.MyException;

import java.awt.*;
import java.io.Serializable;

/**
 * Created by User on 15.10.2017.
 */
public class AppUser implements Serializable{
    private Long id;
    private String username;
    private String password;
    private String role;

    public AppUser(Long id, String username, String password, String role) throws MyException {
        if(id < 0) throw new MyException("id < 0");
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppUser appUser = (AppUser) o;

        if (!id.equals(appUser.id)) return false;
        if (!username.equals(appUser.username)) return false;
        if (!password.equals(appUser.password)) return false;
        return role.equals(appUser.role);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
