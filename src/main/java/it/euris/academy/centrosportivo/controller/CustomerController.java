package it.euris.academy.centrosportivo.controller;

import io.swagger.v3.oas.annotations.Operation;
import it.euris.academy.centrosportivo.dto.CustomerDTO;
import it.euris.academy.centrosportivo.entity.Customer;
import it.euris.academy.centrosportivo.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
@SpringBootApplication
public class CustomerController {


  CustomerService customerService;

  @GetMapping
  public List<Customer> getAllCustomers() {
    return customerService.findAll();
  }

  @PostMapping
  public Customer saveCustomer(@RequestBody CustomerDTO customerDTO) {
    Customer customer = (Customer) customerDTO.toModel();
    return customerService.save(customer);
  }

  @PutMapping
  public Customer updateCustomer(@RequestBody CustomerDTO customerDTO){
    Customer customer = (Customer) customerDTO.toModel();
    return customerService.save(customer);
  }

  @DeleteMapping("/{id}")
  public void deleteCustomer(@PathVariable("id") BigInteger idCustomer) {
    customerService.deleteById(idCustomer);
  }

  @GetMapping("/{id}")
  public Customer getCustomerById(@PathVariable("id") BigInteger idCustomer) {
    return customerService.findById(idCustomer);
  }

}
