package it.euris.academy.centrosportivo.service.impl;

import it.euris.academy.centrosportivo.entity.Address;
import it.euris.academy.centrosportivo.repository.AddressRepository;
import it.euris.academy.centrosportivo.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import it.euris.academy.centrosportivo.exceptions.IdMustBeNullException;
import it.euris.academy.centrosportivo.exceptions.IdMustNotBeNullException;

import java.math.BigInteger;
import java.util.List;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    AddressRepository addressRepository;

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address insert(Address address) throws IdMustBeNullException {
        if (address.getId() != null) {
            throw new IdMustBeNullException();
        }
        return addressRepository.save(address);
    }

    @Override
    public Address update(Address address) throws IdMustNotBeNullException {
        if(address.getId() == null){
            throw new IdMustNotBeNullException();
        }
        return null;
    }

    @Override
    public Boolean deleteById(Long idAddress) {
        addressRepository.deleteById(idAddress);
        return addressRepository.findById(idAddress).isEmpty();
    }

    @Override
    public Address findById(Long idAddress) {
        return addressRepository.findById(idAddress).orElse(Address.builder().build());
    }
}
