package it.euris.academy.centrosportivo.service.impl;

import it.euris.academy.centrosportivo.entity.Address;
import it.euris.academy.centrosportivo.repository.AddressRepository;
import it.euris.academy.centrosportivo.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void deleteById(BigInteger idAddress) {
        addressRepository.deleteById(idAddress);
    }

    @Override
    public Address findById(BigInteger idAddress) {
        return addressRepository.findById(idAddress).orElse(Address.builder().build());
    }
}
