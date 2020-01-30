package com.xzw.springbootelasticsearch.web;

import com.xzw.springbootelasticsearch.model.City;
import com.xzw.springbootelasticsearch.model.UserESRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xieziwei99
 * 2020-01-30
 */
@RestController
public class UserESController {

    private final UserESRepository userESRepository;

    public UserESController(UserESRepository userESRepository) {
        this.userESRepository = userESRepository;
    }

    @PostMapping("/city")
    public String createCity(@RequestBody City city) {
        userESRepository.save(city);
        return "success";
    }

    @GetMapping("/city/{id}")
    public City getCityById(@PathVariable Long id) {
        return userESRepository.findById(id).orElse(null);
    }

    @GetMapping("/city")
    public List<City> getCityListByDesc(@RequestParam String desc) {
        return userESRepository.findCityByDescription(desc);
    }
}
