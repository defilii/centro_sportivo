package it.euris.academy.centrosportivo.service;

import it.euris.academy.centrosportivo.entity.Course;
import it.euris.academy.centrosportivo.entity.Customer;

import java.math.BigInteger;
import java.util.List;

public interface CourseService {
    List<Course> findAll();

    Course save(Course course);

    void deleteById(BigInteger idCourse);

    Course findById(BigInteger idCourse);
}
