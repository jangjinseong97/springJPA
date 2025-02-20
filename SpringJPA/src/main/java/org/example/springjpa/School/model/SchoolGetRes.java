package org.example.springjpa.School.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.springjpa.entity.SchoolTypeCode;

@Getter
@AllArgsConstructor
public class SchoolGetRes {
    private Long schoolId;
    private String name;
    private SchoolTypeCode schoolTypeCode;
}
