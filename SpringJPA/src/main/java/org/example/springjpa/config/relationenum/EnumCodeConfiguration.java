package org.example.springjpa.config.relationenum;

import org.example.springjpa.entity.SchoolTypeCode;
import org.example.springjpa.entity.StudentGradeType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    @Configuration: 빈등록, 메소드중 @Bean 에노테이션을 가진 메소드가 있을 수 있다.
    @Bean: 빈등록, 스프링 컨테이너가 이 메소드를 호출 > 리턴된 주소값을 빈등록

    @Configuration 아래에 있는 @Bean은 싱글톤뿐(component 아래는 싱글톤이 아님)
 */
@Configuration
public class EnumCodeConfiguration {
    @Bean
    public EnumMapper enumMapper() {
        EnumMapper enumMapper = new EnumMapper();
        enumMapper.put(SchoolTypeCode.class.getSimpleName(), SchoolTypeCode.class);
        enumMapper.put(StudentGradeType.class.getSimpleName(), StudentGradeType.class);
        return enumMapper;
    }
}
