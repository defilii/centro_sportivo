package it.euris.academy.centrosportivo.controller;

import it.euris.academy.centrosportivo.dto.CustomerCourseDTO;
import it.euris.academy.centrosportivo.entity.Customer;
import it.euris.academy.centrosportivo.entity.CustomerCourse;
import it.euris.academy.centrosportivo.entity.key.CustomerCourseKey;
import it.euris.academy.centrosportivo.exceptions.IdMustBeNullException;
import it.euris.academy.centrosportivo.exceptions.IdMustNotBeNullException;
import it.euris.academy.centrosportivo.service.CustomerCourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/customerscourses")
public class CustomerCourseController {

    CustomerCourseService customerCourseService;

    @GetMapping
    public List<CustomerCourseDTO> getAllCustomerCourse() {
        return customerCourseService.findAll().stream().map(CustomerCourse::toDto).toList();
    }

    @PostMapping
    public CustomerCourseDTO saveCustomerCourse(@RequestBody CustomerCourseDTO customerCourseDTO) throws IdMustBeNullException {
        try{
            CustomerCourse customerCourse = customerCourseDTO.toModel();
            return customerCourseService.insert(customerCourse).toDto();
        }
        catch(IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping
    public CustomerCourseDTO updateCustomerCourse(@RequestBody CustomerCourseDTO customerCourseDTO) throws IdMustBeNullException, IdMustNotBeNullException {
        try{
            CustomerCourse customerCourse = customerCourseDTO.toModel();
            return customerCourseService.update(customerCourse).toDto();
        }
        catch(IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public Boolean deleteCustomerCourse(@PathVariable("id") CustomerCourseKey idCustomerCourse) {
        return customerCourseService.deleteById(idCustomerCourse);
    }

    @GetMapping("/{id}")
    public CustomerCourseDTO getCustomerCourseById(@PathVariable("id") CustomerCourseKey idCustomerCourse) {
        return customerCourseService.findById(idCustomerCourse).toDto();
    }

}
