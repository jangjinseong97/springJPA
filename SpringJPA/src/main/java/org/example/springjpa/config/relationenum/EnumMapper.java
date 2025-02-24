package org.example.springjpa.config.relationenum;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EnumMapper {
    private Map<String, List<EnumMapperValue>> factory = new LinkedHashMap<>();

    public void put(String key, Class<? extends EnumMapperType> e){
        factory.put(key, toEnumValues(e));
    }

    // e.getEnumConstants() : schoolTypeCodeArray= [ SchoolTypeCode.ELEMENTARY, SchoolTypeCode.MIDDLE, SchoolTypeCode.HIGH ]
    private List<EnumMapperValue> toEnumValues(Class<? extends EnumMapperType> e){
        return Arrays.stream(e.getEnumConstants()) //arrays 를 stream 으로
                .map(EnumMapperValue::new) // 메소드 참조
//                .map(item -> new EnumMapperValue(item)) //이거랑 동일한 효과
        // 위의 주석대로라면
        // 첫번쨰는 EnumMapperValue는 code="00101", value= "초등학교"
        // 두번쨰는 EnumMapperValue는 code="00102", value= "중학교"
        // 세번쨰는 EnumMapperValue는 code="00103", value= "고등학교"
                .toList(); // stream 을 arrayList로

    }
    public List<EnumMapperValue> get(String key){
        return factory.get(key);
    }
}
