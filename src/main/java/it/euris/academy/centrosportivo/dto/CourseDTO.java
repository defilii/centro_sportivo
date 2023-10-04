package it.euris.academy.centrosportivo.dto;

import it.euris.academy.centrosportivo.dto.archetype.Dto;
import it.euris.academy.centrosportivo.dto.archetype.Model;
import it.euris.academy.centrosportivo.entity.Course;
import it.euris.academy.centrosportivo.entity.Customer;
import it.euris.academy.centrosportivo.enums.Sport;
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

    private Long id;

    private Boolean deleted = false;

    private String denomination;

    private String difficulty;

    private Double price;

    private Sport sport;

    @Override
    public Course toModel() {
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
