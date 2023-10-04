package it.euris.academy.centrosportivo.controller;

import it.euris.academy.centrosportivo.dto.AddressDTO;
import it.euris.academy.centrosportivo.entity.Address;
import it.euris.academy.centrosportivo.exceptions.IdMustBeNullException;
import it.euris.academy.centrosportivo.exceptions.IdMustNotBeNullException;
import it.euris.academy.centrosportivo.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/addresses")
public class AddressController {


    AddressService addressService;

    @GetMapping
    public List<AddressDTO> getAllAddress() {
        return addressService.findAll().stream().map(Address::toDto).toList();
    }

    @PostMapping
    public AddressDTO saveAddress(@RequestBody AddressDTO addressDTO) {
        try{
            Address address = addressDTO.toModel();
            return addressService.insert(address).toDto();
        }
        catch(IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping
    public AddressDTO updateAddress(@RequestBody AddressDTO addressDTO) {
        try{
            Address address = addressDTO.toModel();
            return addressService.update(address).toDto();
        }
        catch(IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public Boolean deleteAddress(@PathVariable("id") Long idAddress) {
        return addressService.deleteById(idAddress);
    }

    @GetMapping("/{id}")
    public AddressDTO getAddressById(@PathVariable("id") Long idAddress) {
        return addressService.findById(idAddress).toDto();
    }

    @DeleteMapping("/customer/{id}")
    public Boolean deleteAddressByCustomerId(@PathVariable("id") Long customerId)  {
        List<Address> matchedAddresses = addressService.findAll().stream()
                .filter(address -> address.getCustomer().getId().equals(customerId))
                .toList();
        Integer addressThatWerentDeleted = matchedAddresses.size();
        for (Address matchedAddress : matchedAddresses) {
            Long idToDelete = matchedAddress.getId();
            addressService.deleteById(idToDelete);
            addressThatWerentDeleted--;
        }
        return addressThatWerentDeleted == 0;
    }

    @GetMapping("/customer/{id}")
    public List<AddressDTO> getAddressByCustomerId(@PathVariable("id") Long customerId) {
        return addressService.findAll().stream().map(Address::toDto).filter(address -> address.getCustomer().getId().equals(customerId)).collect(Collectors.toList());
    }
}