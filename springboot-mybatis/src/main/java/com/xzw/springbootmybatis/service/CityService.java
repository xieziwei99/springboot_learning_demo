package com.xzw.springbootmybatis.service;

import com.xzw.springbootmybatis.domain.City;

import java.util.List;

public interface CityService {

    City findCityByName(String cityName);

    List<City> findAllCity();

    City findCityById(Long id);

    Long saveCity(City city);

    Long updateCity(City city);

    Long deleteCity(Long id);
}
