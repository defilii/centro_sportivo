package it.euris.academy.centrosportivo.dto;

import it.euris.academy.centrosportivo.dto.archetype.Dto;
import it.euris.academy.centrosportivo.dto.archetype.Model;
import it.euris.academy.centrosportivo.entity.Course;
import it.euris.academy.centrosportivo.entity.Customer;
import it.euris.academy.centrosportivo.entity.CustomerCourse;
import it.euris.academy.centrosportivo.entity.key.CustomerCourseKey;
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
public class CustomerCourseDTO implements Dto{

    private Customer customer;
    private Course course;
    private Boolean deleted;
    private CustomerCourseKey id;

    @Override
    public Model toModel() {
        return CustomerCourse.builder()
                .id(id)
                .deleted(deleted)
                .customer(customer)
                .course(course)
                .build();
    }



}
