package org.example.springjpa.dummy;

import net.datafaker.Faker;
import org.example.springjpa.School.SchoolRepository;
import org.example.springjpa.entity.School;
import org.example.springjpa.entity.SchoolTypeCode;
import org.example.springjpa.student.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Locale;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SchoolDummyGenerator {
    @Autowired private SchoolRepository schoolRepository;
    Faker faker = new Faker(new Locale("ko"));
    @Autowired
    private StudentRepository studentRepository;
    RandomEnumGenerator<SchoolTypeCode> schoolTypeCodeGenerator = new RandomEnumGenerator<>(SchoolTypeCode.class);

    @Test
    @Rollback(false)
    void generate(){
        studentRepository.deleteAll();
        schoolRepository.deleteAll();
        for(int i=0; i<100;i++){
//            int typeCodeIdx = faker.random().nextInt(3); // 랜덤으로해야지
//            SchoolTypeCode schoolTypeCode = switch (typeCodeIdx) {
//                case 0 -> SchoolTypeCode.ELEMENTARY;
//                case 1 -> SchoolTypeCode.MIDDLE;
//                default -> SchoolTypeCode.HIGH;
//            };
            School school = School.builder().
                    name(faker.educator().secondarySchool()).
                    schoolTypeCode(schoolTypeCodeGenerator.getRandomEnum()).
                    build();
            schoolRepository.save(school);
        }
        schoolRepository.flush();
    }
}
