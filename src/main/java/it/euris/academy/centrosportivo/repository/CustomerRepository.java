package it.euris.academy.centrosportivo.repository;

import it.euris.academy.centrosportivo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CustomerRepository extends JpaRepository<Customer, BigInteger> {
}
