package it.euris.academy.centrosportivo.repository;


import it.euris.academy.centrosportivo.entity.CustomerCourse;
import it.euris.academy.centrosportivo.entity.key.CustomerCourseKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CustomerCourseRepository extends JpaRepository<CustomerCourse, CustomerCourseKey> {
}
