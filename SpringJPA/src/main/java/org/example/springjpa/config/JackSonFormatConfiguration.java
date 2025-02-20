package org.example.springjpa.config;


import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class JackSonFormatConfiguration {
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizer(@Value("${constants.jackson.date-format}") final String dateFormat,
                                                            @Value("${constants.jackson.datetime-format}") final String dateTimeFormat) {
        return builder -> {
            builder.simpleDateFormat(dateFormat)
                    .serializerByType(Long.class, ToStringSerializer.instance)
                    // 실행할떄long은 String으로 변환
                    .serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(dateFormat)))
                    .serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimeFormat)));
        };
    }
}
