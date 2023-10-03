package it.euris.academy.centrosportivo.service.impl;

import it.euris.academy.centrosportivo.entity.Contact;
import it.euris.academy.centrosportivo.repository.ContactRepository;
import it.euris.academy.centrosportivo.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void deleteById(Long idContact) {
        contactRepository.deleteById(idContact);
    }

    @Override
    public Contact findById(Long idContact) {
        return contactRepository.findById(idContact).orElse(Contact.builder().build());
    }
}
