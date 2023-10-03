package it.euris.academy.centrosportivo.entity.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class CustomerCourseKey implements Serializable {

    @Column(name="customer_id")
    private Long customerId;

    @Column(name="course_id")
    private Long courseId;

}
