package by.nc.school.dev.example.spring.data.service;

import by.nc.school.dev.example.spring.data.model.Country;

public interface CountryService {

    Country getOrCreateCountryByName(String countryName);

}
