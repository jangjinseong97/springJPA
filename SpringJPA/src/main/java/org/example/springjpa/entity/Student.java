package org.example.springjpa.entity;

import io.hypersistence.utils.hibernate.id.Tsid;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
}
