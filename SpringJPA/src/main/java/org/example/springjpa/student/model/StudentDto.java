package org.example.springjpa.student.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class StudentDto {
    private Long studentId;
    private String name;
    private LocalDateTime createdAt;
}
