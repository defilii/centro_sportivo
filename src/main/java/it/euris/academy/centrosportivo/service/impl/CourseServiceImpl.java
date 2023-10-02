package it.euris.academy.centrosportivo.service.impl;

import it.euris.academy.centrosportivo.entity.Course;
import it.euris.academy.centrosportivo.entity.Customer;
import it.euris.academy.centrosportivo.repository.CourseRepository;
import it.euris.academy.centrosportivo.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteById(BigInteger idCourse) {
        courseRepository.deleteById(idCourse);
    }

    @Override
    public Course findById(BigInteger idCourse) {
        return courseRepository.findById(idCourse).orElse(Course.builder().build());
    }
}
