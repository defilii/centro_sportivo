package it.euris.academy.centrosportivo.repository;

import it.euris.academy.centrosportivo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
