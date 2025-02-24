package org.example.springjpa.School.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.springjpa.entity.SchoolTypeCode;

@Getter
@ToString
@Setter
public class SchoolPostReq {

    private String schoolName;
    private SchoolTypeCode SchoolTypeCode;
}
