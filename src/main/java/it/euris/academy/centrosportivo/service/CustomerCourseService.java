package it.euris.academy.centrosportivo.service;

import it.euris.academy.centrosportivo.entity.CustomerCourse;
import it.euris.academy.centrosportivo.entity.key.CustomerCourseKey;
import it.euris.academy.centrosportivo.exceptions.IdMustBeNullException;
import it.euris.academy.centrosportivo.exceptions.IdMustNotBeNullException;

import java.util.List;

public interface CustomerCourseService {
    List<CustomerCourse> findAll();

    CustomerCourse insert(CustomerCourse customerCourse) throws IdMustBeNullException;
    CustomerCourse update(CustomerCourse customerCourse) throws IdMustBeNullException, IdMustNotBeNullException;

    Boolean deleteById(CustomerCourseKey idCustomerCourse);

    CustomerCourse findById(CustomerCourseKey idCustomerCourse);
}