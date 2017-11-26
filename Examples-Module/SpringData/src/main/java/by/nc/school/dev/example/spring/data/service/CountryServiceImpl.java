package by.nc.school.dev.example.spring.data.service;

import by.nc.school.dev.example.spring.data.model.Country;
import by.nc.school.dev.example.spring.data.persistence.CountryRepository;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

public class CountryServiceImpl implements CountryService {

    protected CountryRepository countryRepository;

    @Transactional
    @Override
    public Country getOrCreateCountryByName(String countryName) {
        Country country = countryRepository.getByName(countryName);
        if (country == null) {
            country = new Country(countryName);
            countryRepository.save(country);
        }
        return country;
    }

    @Required
    public void setCountryRepository(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

}
