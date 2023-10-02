package it.euris.academy.centrosportivo.dto;

import it.euris.academy.centrosportivo.dto.archetype.Dto;
import it.euris.academy.centrosportivo.dto.archetype.Model;
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
public class CourseDTO implements Dto {

    private BigInteger id;

    private Boolean deleted = false;

    private String denomination;

    private String difficulty;

    private Double price;

    private String sport;

    @Override
    public Model toModel() {
        return Course.builder()
                .deleted(deleted)
                .id(id)
                .sport(sport)
                .difficulty(difficulty)
                .price(price)
                .denomination(denomination)
                .build();
    }
}
