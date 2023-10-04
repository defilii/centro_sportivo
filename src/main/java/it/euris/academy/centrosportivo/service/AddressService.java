package it.euris.academy.centrosportivo.service;

import it.euris.academy.centrosportivo.entity.Address;
import it.euris.academy.centrosportivo.exceptions.IdMustBeNullException;
import it.euris.academy.centrosportivo.exceptions.IdMustNotBeNullException;

import java.util.List;

public interface AddressService {
    List<Address> findAll();

    Address insert(Address address) throws IdMustBeNullException;
    Address update(Address address) throws IdMustNotBeNullException;

    Boolean deleteById(Long idAddress);

    Address findById(Long idAddress);
}
