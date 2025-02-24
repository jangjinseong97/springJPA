package org.example.springjpa.entity;

import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.springjpa.config.relationenum.AbstractEnumCodeConverter;
import org.example.springjpa.config.relationenum.EnumMapperType;

@Getter
@RequiredArgsConstructor
public enum StudentGradeType implements EnumMapperType {
    GRADE_1("00201", "1학년"),
    GRADE_2("00202", "2학년"),
    GRADE_3("00203", "3학년");

    private final String code;
    private final String value;

    @Converter(autoApply = true) // school type enum을 사용하는 entity는 자동으로 컨버터가 작동
    public static class CodeConverter extends AbstractEnumCodeConverter<StudentGradeType> {
        public CodeConverter() {
            super(StudentGradeType.class,false);
        }
    }

}
