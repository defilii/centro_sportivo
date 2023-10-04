package it.euris.academy.centrosportivo.dto;

import it.euris.academy.centrosportivo.dto.archetype.Dto;
import it.euris.academy.centrosportivo.dto.archetype.Model;
import it.euris.academy.centrosportivo.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO implements Dto {


  private Long id;

  private LocalDateTime birth_date;

  private Boolean deleted;

  private String name;

  private String surname;

  private String tax_code;

  @Override
  public Customer toModel() {

    return Customer
        .builder()
            .id(id)
            .name(name)
            .surname(surname)
            .tax_code(tax_code)
            .birth_date(birth_date)
        .build();
  }


}
