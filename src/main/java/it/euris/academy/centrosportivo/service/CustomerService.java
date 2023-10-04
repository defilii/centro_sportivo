package it.euris.academy.centrosportivo.service;

import it.euris.academy.centrosportivo.entity.Customer;
import it.euris.academy.centrosportivo.exceptions.IdMustBeNullException;
import it.euris.academy.centrosportivo.exceptions.IdMustNotBeNullException;

import java.util.List;

public interface CustomerService {
  List<Customer> findAll();

  Customer insert(Customer customer) throws IdMustBeNullException;
  Customer update(Customer customer) throws IdMustNotBeNullException;

  Boolean deleteById(Long idCustomer);

  Customer findById(Long idCustomer);
}
