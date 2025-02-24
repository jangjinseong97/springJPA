package org.example.springjpa.entity;

import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.springjpa.config.relationenum.AbstractEnumCodeConverter;
import org.example.springjpa.config.relationenum.EnumMapperType;

@Getter
@RequiredArgsConstructor
public enum SchoolTypeCode implements EnumMapperType {
    ELEMENTARY("00101","초등학교"),
    MIDDLE("00102","중학교"),
    HIGH("00103","고등학교")
    ;
    // 생성자로 인해 code부분에 code value부분에 value
    private final String code;
    private final String value;

    @Converter(autoApply = true) // school type enum을 사용하는 entity는 자동으로 컨버터가 작동
    public static class CodeConverter extends AbstractEnumCodeConverter<SchoolTypeCode>{
        public CodeConverter() {
            super(SchoolTypeCode.class,false);
        }
    }
}
