package by.nc.school.dev.beans;

import by.nc.school.dev.Model.Classes.Address;
/**
 * @author Admin
 * @version 1.0
 * @created 15-10-2017 18:25:40
 */
public abstract class Human {
	private Address address;
	private String email;
	private String name;
	private String surname;
	private String telephoneNumber;

	public Human(){
	}

	public Human(String surname, String name, String email, Address address, String telephoneNumber) {
		this.surname = surname;
		this.name = name;
		this.email = email;
		this.address = address;
		this.telephoneNumber = telephoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

		Human human = (Human) o;

		if (!getAddress().equals(human.getAddress())) return false;
		if (!getEmail().equals(human.getEmail())) return false;
		if (!getName().equals(human.getName())) return false;
		if (!getSurname().equals(human.getSurname())) return false;
		return getTelephoneNumber().equals(human.getTelephoneNumber());
	}

	@Override
	public int hashCode() {
		int result = getAddress().hashCode();
		result = 31 * result + getEmail().hashCode();
		result = 31 * result + getName().hashCode();
		result = 31 * result + getSurname().hashCode();
		result = 31 * result + getTelephoneNumber().hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Human{" +
				"address=" + address +
				", email='" + email + '\'' +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", telephoneNumber='" + telephoneNumber + '\'' +
				'}';
	}
}