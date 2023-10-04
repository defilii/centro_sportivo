package it.euris.academy.centrosportivo.entity;

import it.euris.academy.centrosportivo.dto.CourseDTO;
import it.euris.academy.centrosportivo.dto.archetype.Dto;
import it.euris.academy.centrosportivo.dto.archetype.Model;
import it.euris.academy.centrosportivo.enums.Sport;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class Course implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "deleted", nullable = false)
    @Builder.Default
    private Boolean deleted = false;

    @Column(name = "denomination" , nullable = false)
    private String denomination;

    @Column(name = "difficulty", nullable = false)
    private String difficulty;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "sport", nullable = false)
    @Enumerated(EnumType.STRING)
    private Sport sport;

    @Override
    public CourseDTO toDto() {
        return CourseDTO
                .builder()
                .id(id)
                .deleted(deleted)
                .sport(sport)
                .price(price)
                .difficulty(difficulty)
                .denomination(denomination)
                .build();
    }

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    List<CustomerCourse> customerCourses;

}

