package it.euris.academy.centrosportivo.controller;

import it.euris.academy.centrosportivo.dto.CustomerCourseDTO;
import it.euris.academy.centrosportivo.dto.CustomerDTO;
import it.euris.academy.centrosportivo.entity.Customer;
import it.euris.academy.centrosportivo.entity.CustomerCourse;
import it.euris.academy.centrosportivo.entity.key.CustomerCourseKey;
import it.euris.academy.centrosportivo.service.CustomerCourseService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/customerscourses")
public class CustomerCourseController {

    CustomerCourseService customerCourseService;

    @GetMapping
    public List<CustomerCourse> getAllCustomerCourse() {
        return customerCourseService.findAll();
    }

    @PostMapping
    public CustomerCourse saveCustomerCourse(@RequestBody CustomerCourseDTO customerCourseDTO) {
        CustomerCourse customerCourse = (CustomerCourse) customerCourseDTO.toModel();
        return customerCourseService.save(customerCourse);
    }

    @PutMapping
    public CustomerCourse updateCustomerCourse(@RequestBody CustomerCourseDTO customerCourseDTO) {
        CustomerCourse customerCourse = (CustomerCourse) customerCourseDTO.toModel();
        return customerCourseService.save(customerCourse);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerCourse(@PathVariable("id") CustomerCourseKey idCustomerCourse) {
        customerCourseService.deleteById(idCustomerCourse);
    }

    @GetMapping("/{id}")
    public CustomerCourse getCustomerCourseById(@PathVariable("id") CustomerCourseKey idCustomerCourse) {
        return customerCourseService.findById(idCustomerCourse);
    }

}
