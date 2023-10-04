package it.euris.academy.centrosportivo.entity;

import it.euris.academy.centrosportivo.dto.ContactDTO;
import it.euris.academy.centrosportivo.dto.CustomerDTO;
import it.euris.academy.centrosportivo.dto.archetype.Dto;
import it.euris.academy.centrosportivo.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contact")
public class Contact implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "deleted", nullable = false)
    @Builder.Default
    private Boolean deleted = false;

    @Column(name = "contact_type", nullable = false)
    private String contact_type;

    @Column(name = "value", nullable = false)
    private String value;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Override
    public ContactDTO toDto() {
        return ContactDTO.builder()
                .id(id)
                .deleted(deleted)
                .contact_type(contact_type)
                .value(value)
                .customer(customer)
                .build();
    }

}

