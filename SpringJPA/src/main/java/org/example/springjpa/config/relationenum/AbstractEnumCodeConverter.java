package org.example.springjpa.config.relationenum;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.RequiredArgsConstructor;

@Converter(autoApply = true)
@RequiredArgsConstructor
public abstract class AbstractEnumCodeConverter <E extends Enum<E> & EnumMapperType>
        implements AttributeConverter<E,String> {

    private final Class<E> targetEnumClass;
    private final boolean nullable;
//    private final String enumName; // 문제가 생겼을 때 enum때문인지 출력해보기 위하여

    @Override
    public String convertToDatabaseColumn(E enumItem) {
        // db에 값을 넣을때(insert update)
        if(!nullable && enumItem == null){
            // null 허용 안했는데 attribute가 null이면
            throw new IllegalArgumentException(String.format("%s는 null로 지정 불가능",targetEnumClass.getSimpleName()));

        }
        return EnumConvertUtils.toCode(enumItem);
    }
    @Override
    // db에서 값을 가져올 때(select)
    public E convertToEntityAttribute(String dbData) {
        if(!nullable && StringUtils.isBlank(dbData) || dbData==null){
            throw new IllegalArgumentException(String.format("%s 는 bd에 null이나 empty로 저장되어이씅ㅁ", targetEnumClass.getSimpleName()));
//            throw new IllegalArgumentException(String.format("%s 는 bd에 null이나 empty로 저장되어이씅ㅁ", enumName));

        }

        return EnumConvertUtils.ofCode(targetEnumClass,dbData);

    }
}
