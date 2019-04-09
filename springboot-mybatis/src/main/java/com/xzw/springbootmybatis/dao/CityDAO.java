package com.xzw.springbootmybatis.dao;

import com.xzw.springbootmybatis.domain.City;
import org.apache.ibatis.annotations.Param;

public interface CityDAO {

    City findByName(@Param("cityName") String cityName);
}
