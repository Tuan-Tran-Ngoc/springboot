package com.example.demo.controllers;

import com.example.demo.entities.City;
import com.example.demo.entities.Country;
import com.example.demo.entities.Course;
import com.example.demo.pojos.CityRequest;
import com.example.demo.pojos.CourseRequest;
import com.example.demo.services.CityService;
import com.example.demo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private  CityService cityService;

    @Autowired
    private CourseService courseService;

    @GetMapping("sayHello")
    public  String sayHello(){
        return "Hello User";
    }

    @GetMapping("getcities")
    public List<City> getCities(){
        return cityService.getCities();
    }

    @PostMapping("addcity")
    public City saveCity(@RequestBody City city){
        return cityService.saveCity(city);
    }

    @GetMapping("getcity")
    public City getCity(String cityNm){
        return cityService.getCity(cityNm);
    }

    @PostMapping("savecity")
    public City addCity(@RequestBody CityRequest cityRequest){
        return cityService.addCity(cityRequest);
    }

    @PostMapping("addcourse")
    public Course addCourse(@RequestBody CourseRequest courseRequest){
        return courseService.addCourseWithoutContents(courseRequest);
    }
}
