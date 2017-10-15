package by.nc.school.dev.beans;

import by.nc.school.dev.beans.Enums.Role;

/**
 * @author Admin
 * @version 1.0
 * @created 15-10-2017 18:25:40
 */
public class User {
	private long id;
	private String password;
	private Role role;
	private String username;

	public User(){
	}

	public User(long id, String username, String password, Role role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public User addUser(){
		return null;
	}

	public boolean doesUserExist(){
		return false;
	}

	public boolean doLogin(){
		return false;
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

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (id != user.id) return false;
		if (!password.equals(user.password)) return false;
		if (role != user.role) return false;
		return username.equals(user.username);
	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + password.hashCode();
		result = 31 * result + (role != null ? role.hashCode() : 0);
		result = 31 * result + username.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", password='" + password + '\'' +
				", role=" + role +
				", username='" + username + '\'' +
				'}';
	}
}