package it.euris.academy.centrosportivo.service;

import it.euris.academy.centrosportivo.entity.Customer;

import java.math.BigInteger;
import java.util.List;

public interface CustomerService {
  List<Customer> findAll();

  Customer save(Customer customer);

  void deleteById(Long idCustomer);

  Customer findById(Long idCustomer);
}
