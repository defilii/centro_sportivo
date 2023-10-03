package it.euris.academy.centrosportivo.controller;

import it.euris.academy.centrosportivo.dto.AddressDTO;
import it.euris.academy.centrosportivo.dto.CustomerCourseDTO;
import it.euris.academy.centrosportivo.entity.Address;
import it.euris.academy.centrosportivo.entity.Contact;
import it.euris.academy.centrosportivo.entity.Customer;
import it.euris.academy.centrosportivo.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/addresses")
public class AddressController {


    AddressService addressService;

    @GetMapping
    public List<Address> getAllAddress() {
        return addressService.findAll();
    }

    @PostMapping
    public Address saveAddress(@RequestBody AddressDTO addressDTO) {
        Address address = (Address) addressDTO.toModel();
        return addressService.save(address);
    }

    @PutMapping
    public Address updateAddress(@RequestBody CustomerCourseDTO customerCourseDTO) {
        Address customerCourse = (Address) customerCourseDTO.toModel();
        return addressService.save(customerCourse);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable("id") Long idAddress) {
        addressService.deleteById(idAddress);
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable("id") Long idAddress) {
        return addressService.findById(idAddress);
    }

    @DeleteMapping("/customer/{id}")
    public void deleteAddressByCustomerId(@PathVariable("id") Long customerId)  {
        List<Address> matchedAddresses = addressService.findAll().stream()
                .filter(address -> address.getCustomer().getId().equals(customerId))
                .toList();
        for (Address matchedAddress : matchedAddresses) {
            Long idToDelete = matchedAddress.getId();
            addressService.deleteById(idToDelete);
        }
    }

    @GetMapping("/customer/{id}")
    public List<Address> getAddressByCustomerId(@PathVariable("id") Long customerId) {
        return addressService.findAll().stream().filter(address -> address.getCustomer().getId().equals(customerId)).collect(Collectors.toList());
    }
}