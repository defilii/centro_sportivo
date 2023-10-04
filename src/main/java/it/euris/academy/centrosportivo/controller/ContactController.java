package it.euris.academy.centrosportivo.controller;

import it.euris.academy.centrosportivo.dto.ContactDTO;
import it.euris.academy.centrosportivo.entity.Contact;
import it.euris.academy.centrosportivo.entity.Course;
import it.euris.academy.centrosportivo.exceptions.IdMustBeNullException;
import it.euris.academy.centrosportivo.exceptions.IdMustNotBeNullException;
import it.euris.academy.centrosportivo.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/contacts")
public class ContactController {


    ContactService contactService;

    @GetMapping
    public List<ContactDTO> getAllContacts() {
        return contactService.findAll().stream().map(Contact::toDto).toList();
    }

    @PostMapping
    public ContactDTO saveContact(@RequestBody ContactDTO contactDTO) {
        try{
            Contact contact = contactDTO.toModel();
            return contactService.insert(contact).toDto();
        }
        catch(IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping
    public ContactDTO updateContact(@RequestBody ContactDTO contactDTO) {
        try{
            Contact contact = contactDTO.toModel();
            return contactService.update(contact).toDto();
        }
        catch(IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public Boolean deleteContact(@PathVariable("id") Long idContact) {
        return contactService.deleteById(idContact);
    }

    @GetMapping("/{id}")
    public ContactDTO getContactById(@PathVariable("id") Long idContact) {
        return contactService.findById(idContact).toDto();
    }

    @DeleteMapping("/customer/{id}")
    public Boolean deleteContactByCustomerId(@PathVariable("customerId") Long customerId) {
        List<Contact> matchedContacts = contactService.findAll().stream()
                .filter(contact -> contact.getCustomer().getId().equals(customerId))
                .toList();
        Integer contactsThatWerentDeleted = matchedContacts.size();
        for (Contact matchedContact : matchedContacts) {
            Long idToDelete = matchedContact.getId();
            contactService.deleteById(idToDelete);
            contactsThatWerentDeleted--;
        }
        return contactsThatWerentDeleted == 0;

    }

    @GetMapping("/customer/{id}")
    public List<ContactDTO> getContactByCustomerId(@PathVariable("id") Long customerId) {
        return contactService.findAll().stream().map(Contact::toDto).filter(contact -> contact.getCustomer().getId().equals(customerId)).collect(Collectors.toList());
    }
}