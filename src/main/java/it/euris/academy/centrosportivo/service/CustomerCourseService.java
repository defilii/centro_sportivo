package it.euris.academy.centrosportivo.service;

import it.euris.academy.centrosportivo.entity.Course;
import it.euris.academy.centrosportivo.entity.Customer;
import it.euris.academy.centrosportivo.entity.CustomerCourse;
import it.euris.academy.centrosportivo.entity.key.CustomerCourseKey;

import java.math.BigInteger;
import java.util.List;

public interface CustomerCourseService {
    List<CustomerCourse> findAll();

    CustomerCourse save(CustomerCourse customerCourse);

    void deleteById(CustomerCourseKey idCustomerCourse);

    CustomerCourse findById(CustomerCourseKey idCustomerCourse);
}