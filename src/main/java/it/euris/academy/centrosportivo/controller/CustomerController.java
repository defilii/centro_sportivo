package it.euris.academy.centrosportivo.controller;

import it.euris.academy.centrosportivo.dto.CustomerDTO;
import it.euris.academy.centrosportivo.entity.Customer;
import it.euris.academy.centrosportivo.exceptions.IdMustBeNullException;
import it.euris.academy.centrosportivo.exceptions.IdMustNotBeNullException;
import it.euris.academy.centrosportivo.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.function.Function;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {


  CustomerService customerService;

  @GetMapping
  public List<CustomerDTO> getAllCustomers() {
    return customerService.findAll().stream().map(Customer::toDto).toList();
  }

  @PostMapping
  public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {
    try{
      Customer customer = customerDTO.toModel();
      return customerService.insert(customer).toDto();
    }
    catch(IdMustBeNullException e) {
      throw new ResponseStatusException(
              HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @PutMapping
  public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO) {
    try{
      Customer customer = customerDTO.toModel();
      return customerService.update(customer).toDto();
    }
    catch(IdMustNotBeNullException e) {
      throw new ResponseStatusException(
              HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  public Boolean deleteCustomer(@PathVariable("id") Long idCustomer) {
    return customerService.deleteById(idCustomer);
  }

  @GetMapping("/{id}")
  public CustomerDTO getCustomerById(@PathVariable("id") Long idCustomer) {
    return customerService.findById(idCustomer).toDto();
  }

}
