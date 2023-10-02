package it.euris.academy.centrosportivo.service;

import it.euris.academy.centrosportivo.entity.Contact;
import it.euris.academy.centrosportivo.entity.Course;

import java.math.BigInteger;
import java.util.List;

public interface ContactService {
    List<Contact> findAll();

    Contact save(Contact contact);

    void deleteById(BigInteger idContact);

    Contact findById(BigInteger idContact);
}