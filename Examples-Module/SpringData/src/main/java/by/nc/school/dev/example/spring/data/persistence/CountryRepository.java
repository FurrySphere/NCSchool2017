package by.nc.school.dev.example.spring.data.persistence;

import by.nc.school.dev.example.spring.data.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

    Country getByName(String name);

}
