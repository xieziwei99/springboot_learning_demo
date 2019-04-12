package com.xzw.springbootmybatis.dao;

import com.xzw.springbootmybatis.domain.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityDAO {

    City findByName(@Param("cityName") String cityName);

    List<City> findAllCity();

    City findById(@Param("id") Long id);

    Long saveCity(City city);

    Long updateCity(City city);

    Long deleteCity(Long id);
}
