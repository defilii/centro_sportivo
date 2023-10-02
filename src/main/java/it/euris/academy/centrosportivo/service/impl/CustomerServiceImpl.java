package it.euris.academy.centrosportivo.service.impl;

import it.euris.academy.centrosportivo.entity.Customer;
import it.euris.academy.centrosportivo.repository.CustomerRepository;
import it.euris.academy.centrosportivo.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  CustomerRepository customerRepository;

  @Override
  public List<Customer> findAll() {
    return customerRepository.findAll();
  }

  @Override
  public Customer save(Customer customer) {
    return customerRepository.save(customer);
  }

  @Override
  public void deleteById(BigInteger idCustomer) {
    customerRepository.deleteById(idCustomer);
  }

  @Override
  public Customer findById(BigInteger idCustomer) {
    return customerRepository.findById(idCustomer).orElse(Customer.builder().build());
  }

}
