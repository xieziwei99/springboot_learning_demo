package com.xzw.springbootmybatis.controller;

import com.xzw.springbootmybatis.domain.City;
import com.xzw.springbootmybatis.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city{cityName}", method = RequestMethod.GET)
    public City findOneCity(@PathVariable("cityName") String cityName) {
        return cityService.findCityByName(cityName);
    }

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
    public City findCityById(@PathVariable("id") Long id) {
        return cityService.findCityById(id);
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public List<City> findAllCity() {
        return cityService.findAllCity();
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public void insertCity(@RequestBody City city) {
        cityService.saveCity(city);
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.PUT)
    public void updateCity(@RequestBody City city) {
        cityService.updateCity(city);
    }

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.DELETE)
    public void deleteCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }
}
