package by.nc.school.dev.example.spring.data.model;

import javax.persistence.*;

@Entity
@Table(name="countries")
public class Country {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    private Country() {}

    public Country(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
