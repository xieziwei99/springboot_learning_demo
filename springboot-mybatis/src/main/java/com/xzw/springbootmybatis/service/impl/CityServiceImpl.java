package com.xzw.springbootmybatis.service.impl;

import com.xzw.springbootmybatis.dao.CityDAO;
import com.xzw.springbootmybatis.domain.City;
import com.xzw.springbootmybatis.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDAO cityDAO;

    @Override
    public City findCityByName(String cityName) {
        return cityDAO.findByName(cityName);
    }
}
