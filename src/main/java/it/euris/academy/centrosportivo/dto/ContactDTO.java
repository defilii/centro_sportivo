package it.euris.academy.centrosportivo.dto;

import it.euris.academy.centrosportivo.dto.archetype.Dto;
import it.euris.academy.centrosportivo.dto.archetype.Model;
import it.euris.academy.centrosportivo.entity.Contact;
import it.euris.academy.centrosportivo.entity.Course;
import it.euris.academy.centrosportivo.entity.Customer;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactDTO implements Dto{

    private BigInteger id;

    private Boolean deleted = false;

    private String contact_type;

    private String value;

    private Customer customer;
    @Override
    public Model toModel() {
        return Contact.builder()
                .deleted(deleted)
                .id(id)
                .contact_type(contact_type)
                .value(value)
                .customer(customer)
                .build();
    }
}
