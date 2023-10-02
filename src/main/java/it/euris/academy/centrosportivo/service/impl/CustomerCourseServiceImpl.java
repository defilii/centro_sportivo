package it.euris.academy.centrosportivo.service.impl;

import it.euris.academy.centrosportivo.entity.CustomerCourse;
import it.euris.academy.centrosportivo.repository.CustomerCourseRepository;
import it.euris.academy.centrosportivo.service.CustomerCourseService;

import java.math.BigInteger;
import java.util.List;

public class CustomerCourseServiceImpl implements CustomerCourseService {

    CustomerCourseRepository customerCourseRepository;

    @Override
    public List<CustomerCourse> findAll() {
        return customerCourseRepository.findAll();
    }

    @Override
    public CustomerCourse save(CustomerCourse customerCourse) {
        return customerCourseRepository.save(customerCourse);
    }

    @Override
    public void deleteById(BigInteger idCustomerCourse) {
        customerCourseRepository.deleteById(idCustomerCourse);
    }

    @Override
    public CustomerCourse findById(BigInteger idCustomerCourse) {
        return customerCourseRepository.findById(idCustomerCourse).orElse(CustomerCourse.builder().build());
    }
}
