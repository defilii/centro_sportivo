package it.euris.academy.centrosportivo.repository;

import it.euris.academy.centrosportivo.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface ContactRepository extends JpaRepository<Contact, BigInteger> {
}
