package it.euris.academy.centrosportivo.entity;

import it.euris.academy.centrosportivo.dto.CustomerDTO;
import it.euris.academy.centrosportivo.dto.archetype.Dto;
import it.euris.academy.centrosportivo.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private BigInteger id;

  @Column(name = "deleted", nullable = false)
  @Builder.Default
  private Boolean deleted = false;

  @Column(name = "birth_date" , nullable = false)
  private LocalDateTime birth_date;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "surname", nullable = false)
  private String surname;

  @Column(name = "tax_code", nullable = false)
  private String tax_code;

  @Override
  public Dto toDto() {
    return CustomerDTO
        .builder()
            .id(id)
            .deleted(deleted)
            .name(name)
            .surname(surname)
            .tax_code(tax_code)
            .birth_date(birth_date)
        .build();
  }

  @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
  List<Address> customerAddresses;

  @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
  List<Contact> customerContacts;

  @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
  List<CustomerCourse> customerCourses;

}

