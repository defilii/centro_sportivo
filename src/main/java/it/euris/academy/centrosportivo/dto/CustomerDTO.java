package it.euris.academy.centrosportivo.dto;

import it.euris.academy.centrosportivo.dto.archetype.Dto;
import it.euris.academy.centrosportivo.dto.archetype.Model;
import it.euris.academy.centrosportivo.entity.Customer;
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
public class CustomerDTO implements Dto {


  private BigInteger id;

  private LocalDateTime birth_date;

  private Boolean deleted;

  private String name;

  private String surname;

  private String tax_code;

  @Override
  public Model toModel() {

    return Customer
        .builder()
            .id(id)
            .deleted(deleted)
            .name(name)
            .surname(surname)
            .tax_code(tax_code)
            .birth_date(birth_date)
        .build();
  }

}
