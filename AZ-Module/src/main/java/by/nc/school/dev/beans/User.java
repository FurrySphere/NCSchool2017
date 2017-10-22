package by.nc.school.dev.beans;

import by.nc.school.dev.beans.enums.Role;

import java.io.Serializable;

/**
 * @author Admin
 * @version 1.0
 */
public class User implements Serializable {
    private long id;
    private String password;
    private Role role;
    private String username;
    private String surname;
    private String name;
    private String email;
    private String telephoneNumber;

    public User() {
    }

    public User(long id, String username, String password, String roleName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = Role.valueOf(roleName);
    }

    public User(long id, String username, String password, String roleName,  String surname, String name, String email,
                String telephoneNumber) {
        this.id = id;
        this.password = password;
        this.role = Role.valueOf(roleName);
        this.username = username;
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
    }

    public User(String surname, String name, String email, String telephoneNumber) {
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(String roleName) {
        this.role = Role.valueOf(roleName);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (getId() != user.getId()) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        if (getRole() != user.getRole()) return false;
        if (!getUsername().equals(user.getUsername())) return false;
        if (!getSurname().equals(user.getSurname())) return false;
        if (!getName().equals(user.getName())) return false;
        if (!getEmail().equals(user.getEmail())) return false;
        return getTelephoneNumber().equals(user.getTelephoneNumber());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + (getRole() != null ? getRole().hashCode() : 0);
        result = 31 * result + getUsername().hashCode();
        result = 31 * result + getSurname().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getTelephoneNumber().hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(id).append(" ").append(username).append(" ").append(password).append(" ").append(role).append(" ");
        builder.append(surname).append(" ").append(name).append(" ").append(email).append(" ").append(telephoneNumber);
        return builder.toString();
    }
}