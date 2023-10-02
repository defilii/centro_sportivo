package it.euris.academy.centrosportivo.repository;

import it.euris.academy.centrosportivo.entity.Address;
import it.euris.academy.centrosportivo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface AddressRepository extends JpaRepository<Address, BigInteger> {
}
