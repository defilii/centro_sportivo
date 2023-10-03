package it.euris.academy.centrosportivo.controller;

import it.euris.academy.centrosportivo.dto.CourseDTO;
import it.euris.academy.centrosportivo.entity.Course;
import it.euris.academy.centrosportivo.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/courses")
public class CourseController {

    CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.findAll();
    }

    @PostMapping
    public Course saveCourse(@RequestBody CourseDTO courseDTO) {
        Course course = (Course) courseDTO.toModel();
        return courseService.save(course);
    }

    @PutMapping
    public Course updateCourse(@RequestBody CourseDTO courseDTO) {
        Course course = (Course) courseDTO.toModel();
        return courseService.save(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable("id") Long idCourse) {
        courseService.deleteById(idCourse);
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable("id") Long idCourse) {
        return courseService.findById(idCourse);
    }

}
