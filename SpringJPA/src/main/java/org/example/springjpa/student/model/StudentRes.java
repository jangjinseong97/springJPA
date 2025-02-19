package org.example.springjpa.student.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class StudentRes {
    private Long studentId;
    private Long studentId1;
    private String name;
    private LocalDateTime createdAt;

}
