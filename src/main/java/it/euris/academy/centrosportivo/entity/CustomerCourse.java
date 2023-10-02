package it.euris.academy.centrosportivo.entity;

import it.euris.academy.centrosportivo.dto.CustomerCourseDTO;
import it.euris.academy.centrosportivo.dto.archetype.Dto;
import it.euris.academy.centrosportivo.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_course")
public class CustomerCourse implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "deleted", nullable = false)
    @Builder.Default
    private Boolean deleted = false;

    @Override
    public Dto toDto() {
        return CustomerCourseDTO
                .builder()
                .id(id)
                .deleted(deleted)
                .customer(customer)
                .course(course)
                .build();
    }

}