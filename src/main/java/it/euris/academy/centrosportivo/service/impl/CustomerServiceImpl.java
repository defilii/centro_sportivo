package it.euris.academy.centrosportivo.service.impl;

import it.euris.academy.centrosportivo.entity.Customer;
import it.euris.academy.centrosportivo.exceptions.IdMustBeNullException;
import it.euris.academy.centrosportivo.exceptions.IdMustNotBeNullException;
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
  public Customer insert(Customer customer) throws IdMustBeNullException {
    if(customer.getId() != null){
      throw new IdMustBeNullException();
    }
    return customerRepository.save(customer);
  }

  @Override
  public Customer update(Customer customer) throws IdMustNotBeNullException {
    if(customer.getId() == null){
      throw new IdMustNotBeNullException();
    }
    return customerRepository.save(customer);
  }

  @Override
  public Boolean deleteById(Long idCustomer) {
    customerRepository.deleteById(idCustomer);
    return customerRepository.findById(idCustomer).isEmpty();
  }

  @Override
  public Customer findById(Long idCustomer) {
    return customerRepository.findById(idCustomer).orElse(Customer.builder().build());
  }

}
