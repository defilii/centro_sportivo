package it.euris.academy.centrosportivo.service.impl;

import it.euris.academy.centrosportivo.entity.CustomerCourse;
import it.euris.academy.centrosportivo.entity.key.CustomerCourseKey;
import it.euris.academy.centrosportivo.repository.CustomerCourseRepository;
import it.euris.academy.centrosportivo.service.CustomerCourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import it.euris.academy.centrosportivo.exceptions.IdMustBeNullException;
import it.euris.academy.centrosportivo.exceptions.IdMustNotBeNullException;

import java.math.BigInteger;
import java.util.List;
@Service
@AllArgsConstructor
public class CustomerCourseServiceImpl implements CustomerCourseService {

    CustomerCourseRepository customerCourseRepository;

    @Override
    public List<CustomerCourse> findAll() {
        return customerCourseRepository.findAll();
    }

    @Override
    public CustomerCourse insert(CustomerCourse customerCourse) throws IdMustBeNullException {
        if(customerCourse.getId() != null){
            throw new IdMustBeNullException();
        }
        return customerCourseRepository.save(customerCourse);
    }

    @Override
    public CustomerCourse update(CustomerCourse customerCourse) throws IdMustNotBeNullException {
        if(customerCourse.getId() == null){
            throw new IdMustNotBeNullException();
    }
        return customerCourseRepository.save(customerCourse);
    }

    @Override
    public Boolean deleteById(CustomerCourseKey idCustomerCourse) {
        customerCourseRepository.deleteById(idCustomerCourse);
        return customerCourseRepository.findById(idCustomerCourse).isEmpty();
    }

    @Override
    public CustomerCourse findById(CustomerCourseKey idCustomerCourse) {
        return customerCourseRepository.findById(idCustomerCourse).orElse(CustomerCourse.builder().build());
    }
}
