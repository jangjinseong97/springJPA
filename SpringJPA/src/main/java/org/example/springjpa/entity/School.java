package org.example.springjpa.entity;

import io.hypersistence.utils.hibernate.id.Tsid;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class School extends CreatedAt{
    @Id @Tsid
    private Long schoolId;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false)
    private SchoolTypeCode schoolTypeCode;

}
