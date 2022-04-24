package com.example.demo.services;

import com.example.demo.entities.City;
import com.example.demo.entities.Country;
import com.example.demo.pojos.CityRequest;
import com.example.demo.repositories.CityRepository;
import com.example.demo.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CountryRepository countryRepository;

    public List<City> getCities(){
        return cityRepository.findAll();
    }

    public City saveCity(City city){
        return cityRepository.save(city);
    }

    public City getCity(String name){
        return cityRepository.findByCityname(name);
    }

    public City addCity(CityRequest cityRequest){
        Country country = countryRepository.findById(cityRequest.getCountry_id());
        if (country != null){
            City city = new City();
            city.setCityname(cityRequest.getCity_name());
            city.setCityCode(cityRequest.getCity_code());
            city.setCountryId(country.getCountry_id());
//            city.setCountryId(country.getCountry_id());

            return cityRepository.save(city);
        }
        return null;
    }
}
