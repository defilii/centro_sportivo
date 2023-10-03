package it.euris.academy.centrosportivo.entity;

import it.euris.academy.centrosportivo.dto.CustomerCourseDTO;
import it.euris.academy.centrosportivo.dto.archetype.Dto;
import it.euris.academy.centrosportivo.dto.archetype.Model;
import it.euris.academy.centrosportivo.entity.key.CustomerCourseKey;
import jakarta.persistence.*;
import lombok.*;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_course")
public class CustomerCourse implements Model {


    @EmbeddedId
    private CustomerCourseKey id;

    @ManyToOne
    @MapsId("customer_id")
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @MapsId("course_id")
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