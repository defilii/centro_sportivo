package it.euris.academy.centrosportivo.repository;


import it.euris.academy.centrosportivo.entity.CustomerCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CustomerCourseRepository extends JpaRepository<CustomerCourse, BigInteger> {
}
