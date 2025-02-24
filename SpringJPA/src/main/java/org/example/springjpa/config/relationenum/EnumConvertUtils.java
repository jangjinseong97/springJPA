package org.example.springjpa.config.relationenum;

import io.micrometer.common.util.StringUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.EnumSet;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
//private 기본 생성자 >> 외부에서 객체생성이 불가능하도록 >> static을 쓰도록
public class EnumConvertUtils {
    public static <E extends Enum<E> & EnumMapperType> E ofCode(Class<E> enumClass, String code) {
        // <E> 였다면 어떤 타입이던 가능 하지만 <E extends Enum<E>> 이므로 enum타입만
        // >> <E extends Enum<E> & EnumMapperType> 가 되서 enum이면서 enumMapperType만 가능
        // 예시로 ELEMENTARY의 정보(code와 value까지) 보내고 String value의 적힌것에 따라 ELEMENTARY 를 반환(즉 안의 value랑
        // 비교 후 같으면 반환
        // enumClass : schoolTypeCode.class, code: "00101" >> SchoolTypeCode.ELEMENTRY 타입이 리턴
        // enumClass : schoolTypeCode.class, code: "00102" >> SchoolTypeCode.MIDDLE 타입이 리턴
        if(StringUtils.isBlank(code))
            // isBlank null이거나 ""이면 ture 리턴
        {return null;}
        return EnumSet.allOf(enumClass) // enum이 가진 모든 아이템을 콜렉션으로 리턴 1)
                .stream() // 1) 을 스트림으로 생성
                .filter(item -> item.getCode().equals(code)) // 스트림의 아이템중 원하는 아이템만 다시 스트림으로 2)
                .findFirst() // 2)스트림 아이템중 첫번째 아이템을 리턴(Optional) 3)
                .orElse(null); // 3)이 null이면 null리턴(원래는 보통 에러를 터트림)
    }
    public static <E extends Enum<E> & EnumMapperType> String toCode(E enumItem) {
        // enumItem으로 SchoolTpeCode.ELEMENTRY 가 들어오면 00101 리턴
        // enumItem으로 SchoolTpeCode.MIDDLE 가 들어오면 00102 리턴
        if(enumItem == null){return null;}
        return enumItem.getCode();
    }
}
