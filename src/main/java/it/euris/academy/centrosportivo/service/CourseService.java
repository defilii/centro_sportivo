package it.euris.academy.centrosportivo.service;

import it.euris.academy.centrosportivo.entity.Course;
import it.euris.academy.centrosportivo.exceptions.IdMustBeNullException;
import it.euris.academy.centrosportivo.exceptions.IdMustNotBeNullException;

import java.util.List;

public interface CourseService {
    List<Course> findAll();

    Course insert(Course course) throws IdMustNotBeNullException, IdMustBeNullException;
    Course update(Course course) throws IdMustNotBeNullException;

    Boolean deleteById(Long idCourse);

    Course findById(Long idCourse);
}
