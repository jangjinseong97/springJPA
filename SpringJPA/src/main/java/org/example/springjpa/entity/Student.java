package org.example.springjpa.entity;

import io.hypersistence.utils.hibernate.id.Tsid;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student extends UpdatedAt{
    @Id @Tsid//auto_increment 대신
    private Long studentId;
    @Column(nullable = false)
    private String name;
    @ManyToOne @JoinColumn(name= "school_id")
    private School school;

    @Column(nullable = false)
    private StudentGradeType gradeTypeCode;
}
