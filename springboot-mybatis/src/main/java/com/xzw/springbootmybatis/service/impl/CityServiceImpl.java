package com.xzw.springbootmybatis.service.impl;

import com.xzw.springbootmybatis.dao.CityDAO;
import com.xzw.springbootmybatis.domain.City;
import com.xzw.springbootmybatis.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDAO cityDAO;

    @Override
    public City findCityByName(String cityName) {
        return cityDAO.findByName(cityName);
    }

    @Override
    public List<City> findAllCity() {
        return cityDAO.findAllCity();
    }

    @Override
    public City findCityById(Long id) {
        return cityDAO.findById(id);
    }

    @Override
    public Long saveCity(City city) {
        return cityDAO.saveCity(city);
    }

    @Override
    public Long updateCity(City city) {
        return cityDAO.updateCity(city);
    }

    @Override
    public Long deleteCity(Long id) {
        return cityDAO.deleteCity(id);
    }
}
