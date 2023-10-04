package it.euris.academy.centrosportivo.service.impl;

import it.euris.academy.centrosportivo.entity.Course;
import it.euris.academy.centrosportivo.entity.Customer;
import it.euris.academy.centrosportivo.repository.CourseRepository;
import it.euris.academy.centrosportivo.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import it.euris.academy.centrosportivo.exceptions.IdMustBeNullException;
import it.euris.academy.centrosportivo.exceptions.IdMustNotBeNullException;

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
    public Course insert(Course course) throws IdMustBeNullException {
        if(course.getId() != null){
            throw new IdMustBeNullException();
        }
        return courseRepository.save(course);
    }

    @Override
    public Course update(Course course) throws IdMustNotBeNullException {
        if(course.getId() == null){
            throw new IdMustNotBeNullException();
        }
        return courseRepository.save(course);
    }

    @Override
    public Boolean deleteById(Long idCourse) {
        courseRepository.deleteById(idCourse);
        return courseRepository.findById(idCourse).isEmpty();
    }

    @Override
    public Course findById(Long idCourse) {
        return courseRepository.findById(idCourse).orElse(Course.builder().build());
    }
}
