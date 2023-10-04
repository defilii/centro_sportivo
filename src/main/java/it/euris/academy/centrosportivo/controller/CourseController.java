package it.euris.academy.centrosportivo.controller;

import it.euris.academy.centrosportivo.dto.CourseDTO;
import it.euris.academy.centrosportivo.entity.Course;
import it.euris.academy.centrosportivo.entity.CustomerCourse;
import it.euris.academy.centrosportivo.exceptions.IdMustBeNullException;
import it.euris.academy.centrosportivo.exceptions.IdMustNotBeNullException;
import it.euris.academy.centrosportivo.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/courses")
public class CourseController {

    CourseService courseService;

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        return courseService.findAll().stream().map(Course::toDto).toList();
    }

    @PostMapping
    public CourseDTO saveCourse(@RequestBody CourseDTO courseDTO) throws IdMustBeNullException {
        try{
            Course course = courseDTO.toModel();
            return courseService.insert(course).toDto();
        }
        catch(IdMustBeNullException | IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping
    public CourseDTO updateCourse(@RequestBody CourseDTO courseDTO)  {
        try{
            Course course = courseDTO.toModel();
            return courseService.update(course).toDto();
        }
        catch(IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public boolean deleteCourse(@PathVariable("id") Long idCourse) {
        return courseService.deleteById(idCourse);
    }

    @GetMapping("/{id}")
    public CourseDTO getCourseById(@PathVariable("id") Long idCourse) {
        return (CourseDTO) courseService.findById(idCourse).toDto();
    }

}
