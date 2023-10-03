package it.euris.academy.centrosportivo.controller;

import io.swagger.v3.oas.annotations.Operation;
import it.euris.academy.centrosportivo.dto.AddressDTO;
import it.euris.academy.centrosportivo.dto.ContactDTO;
import it.euris.academy.centrosportivo.dto.CustomerCourseDTO;
import it.euris.academy.centrosportivo.entity.Address;
import it.euris.academy.centrosportivo.entity.Contact;
import it.euris.academy.centrosportivo.entity.Customer;
import it.euris.academy.centrosportivo.service.AddressService;
import it.euris.academy.centrosportivo.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/contacts")
@SpringBootApplication
public class ContactController {


    ContactService contactService;

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.findAll();
    }

    @PostMapping
    public Contact saveContact(@RequestBody ContactDTO contactDTO) {
        Contact contact = (Contact) contactDTO.toModel();
        return contactService.save(contact);
    }

    @PutMapping
    public Contact updateContact(@RequestBody ContactDTO contactDTO) {
        Contact contact = (Contact) contactDTO.toModel();
        return contactService.save(contact);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable("id") Long idContact) {
        contactService.deleteById(idContact);
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable("id") Long idContact) {
        return contactService.findById(idContact);
    }

    @DeleteMapping("/{customer}")
    public void deleteContactByCustomer(@PathVariable("customer") Customer customer) {
        List<Contact> matchedContacts = contactService.findAll().stream()
                .filter(contact -> contact.getCustomer().equals(customer))
                .toList();
        for (Contact matchedContact : matchedContacts) {
            Long idToDelete = matchedContact.getId();
            contactService.deleteById(idToDelete);
        }
    }

    @GetMapping("/{customer}")
    public List<Contact> getContactByCustomer(@PathVariable("customer") Customer customer) {
        return contactService.findAll().stream().filter(contact -> contact.getCustomer().equals(customer)).collect(Collectors.toList());
    }
}