package it.euris.academy.centrosportivo.dto;

import it.euris.academy.centrosportivo.dto.archetype.Dto;
import it.euris.academy.centrosportivo.dto.archetype.Model;
import it.euris.academy.centrosportivo.entity.Address;
import it.euris.academy.centrosportivo.entity.Course;
import it.euris.academy.centrosportivo.entity.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class AddressDTO implements Dto{

    private Long id;

    private Boolean deleted = false;

    private String address;

    private String city;

    private String nation;

    private String province;

    private Integer postal_code;

    private Customer customer;
    @Override
    public Model toModel() {
        return Address.builder()

//                .deleted(deleted)
//                .id(id)
                .address(address)
                .city(city)
                .nation(nation)
                .province(province)
                .postal_code(postal_code)
                .customer(customer)
                .build();
    }
}
