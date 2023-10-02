package it.euris.academy.centrosportivo.service;

import it.euris.academy.centrosportivo.entity.Address;
import it.euris.academy.centrosportivo.entity.Contact;

import java.math.BigInteger;
import java.util.List;

public interface AddressService {
    List<Address> findAll();

    Address save(Address address);

    void deleteById(BigInteger idAddress);

    Address findById(BigInteger idAddress);
}
