package it.euris.academy.centrosportivo.service.impl;

import it.euris.academy.centrosportivo.entity.Contact;
import it.euris.academy.centrosportivo.repository.ContactRepository;
import it.euris.academy.centrosportivo.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import it.euris.academy.centrosportivo.exceptions.IdMustBeNullException;
import it.euris.academy.centrosportivo.exceptions.IdMustNotBeNullException;

import java.math.BigInteger;
import java.util.List;
@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

    ContactRepository contactRepository;

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact insert(Contact contact) throws IdMustBeNullException {
        if(contact.getId() != null){
            throw new IdMustBeNullException();
        }
        return contactRepository.save(contact);
    }

    @Override
    public Contact update(Contact contact) throws IdMustNotBeNullException {
        if(contact.getId() == null){
            throw new IdMustNotBeNullException();
        }
        return contactRepository.save(contact);
    }

    @Override
    public Boolean deleteById(Long idContact) {
        contactRepository.deleteById(idContact);
        return contactRepository.findById(idContact).isEmpty();
    }

    @Override
    public Contact findById(Long idContact) {
        return contactRepository.findById(idContact).orElse(Contact.builder().build());
    }
}
