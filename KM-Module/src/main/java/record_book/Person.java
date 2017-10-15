package record_book;

import record_book.Sex;

import java.util.Date;

public abstract class Person {
    private String fullName;
    private Date birthday;
    private String address;
    private Sex sex;

    public Person(String fullName, Date birthday, String address, Sex sex) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.address = address;
        this.sex = sex;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public Sex getSex() {
        return sex;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
