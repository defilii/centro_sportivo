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
@RequestMapping("/address")
@SpringBootApplication
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

    @DeleteMapping("/{customer}")
    public void deleteAddressByCustomer(@PathVariable("customer") Customer customer) {
        List<Address> matchedContacts = addressService.findAll().stream()
                .filter(contact -> contact.getCustomer().equals(customer))
                .toList();
        for (Address matchedContact : matchedContacts) {
            Long idToDelete = matchedContact.getId();
            addressService.deleteById(idToDelete);
        }
    }

    @GetMapping("/{customer}")
    public List<Address> getAddressByCustomer(@PathVariable("customer") Customer customer) {
        return addressService.findAll().stream().filter(contact -> contact.getCustomer().equals(customer)).collect(Collectors.toList());
    }
}