package it.euris.academy.centrosportivo.service;

import it.euris.academy.centrosportivo.entity.Course;
import it.euris.academy.centrosportivo.entity.Customer;
import it.euris.academy.centrosportivo.entity.CustomerCourse;

import java.math.BigInteger;
import java.util.List;

public interface CustomerCourseService {
    List<CustomerCourse> findAll();

    CustomerCourse save(CustomerCourse customerCourse);

    void deleteById(Long idCustomerCourse);

    CustomerCourse findById(Long idCustomerCourse);
}