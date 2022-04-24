package com.example.demo.services;

import com.example.demo.entities.Course;
import com.example.demo.pojos.CourseRequest;
import com.example.demo.repositories.ContentRepository;
import com.example.demo.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ContentRepository contentRepository;

    public CourseService(){}

    public Course addCourseWithoutContents(CourseRequest courseRequest){
        Course course = new Course();
        course.setCourse_id(courseRequest.getCourse_id());
        course.setCourse_name(courseRequest.getCourse_name());
        course.setContents(courseRequest.getContents()
        .stream()
        .map(content -> {
            if (content.getContent_id() > 0){
                content = contentRepository.findById(content.getContent_id());
            }
            content.getCourses().add(course);
            return content;
        }).collect(Collectors.toSet())
        );
        return courseRepository.save(course);
    }
}
