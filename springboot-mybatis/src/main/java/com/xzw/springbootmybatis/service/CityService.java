package com.xzw.springbootmybatis.service;

import com.xzw.springbootmybatis.domain.City;

public interface CityService {

    City findCityByName(String cityName);
}
