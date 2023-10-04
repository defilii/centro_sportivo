package it.euris.academy.centrosportivo.service;

import it.euris.academy.centrosportivo.entity.Contact;
import it.euris.academy.centrosportivo.exceptions.IdMustBeNullException;
import it.euris.academy.centrosportivo.exceptions.IdMustNotBeNullException;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();

    Contact insert(Contact contact) throws IdMustBeNullException;
    Contact update(Contact contact) throws IdMustNotBeNullException;

    Boolean deleteById(Long idContact);

    Contact findById(Long idContact);
}