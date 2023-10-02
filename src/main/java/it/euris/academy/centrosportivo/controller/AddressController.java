package it.euris.academy.centrosportivo.controller;

import it.euris.academy.centrosportivo.dto.AddressDTO;
import it.euris.academy.centrosportivo.dto.CustomerCourseDTO;
import it.euris.academy.centrosportivo.entity.Address;
import it.euris.academy.centrosportivo.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/address")
@SpringBootApplication
public class AddressController {


    AddressService addressService;

    @GetMapping
    public List<Address> getAllCustomerCourse() {
        return addressService.findAll();
    }

    @PostMapping
    public Address saveCustomer(@RequestBody AddressDTO addressDTO) {
        Address address = (Address) addressDTO.toModel();
        return addressService.save(address);
    }

    @PutMapping
    public Address updateCustomer(@RequestBody CustomerCourseDTO customerCourseDTO) {
        Address customerCourse = (Address) customerCourseDTO.toModel();
        return addressService.save(customerCourse);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") BigInteger idAddress) {
        addressService.deleteById(idAddress);
    }

    @GetMapping("/{id}")
    public Address getCustomerById(@PathVariable("id") BigInteger idAddress) {
        return addressService.findById(idAddress);
    }

    @DeleteMapping("/{customer}")
    public void deleteAddressByCustomer(@PathVariable("customer") BigInteger idAddress) {
        addressService.deleteById(idAddress);
    }

    @GetMapping("/{customer}")
    public Address getAddressByCustomer(@PathVariable("customer") BigInteger idAddress) {
        return addressService.findById(idAddress);
    }
}