package org.example.springjpa.dummy;

import net.datafaker.Faker;
import org.example.springjpa.entity.Student;
import org.example.springjpa.student.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Locale;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentDummyGenerator {
    @Autowired private StudentRepository studentRepository;

    Faker faker = new Faker(new Locale("ko"));

    @Test
    @Rollback(false)
    void generate(){
        for(int i=0;i<10000;i++){
            StringBuilder sb = new StringBuilder(faker.name().lastName());
            sb.append(faker.name().firstName());
            Student student = Student.builder().
                    name(sb.toString()).
//                    name(faker.name().fullName()).
                    // 다 좋은데 성씨 이후 띄어쓰기가 들어감 장 진성 이런식으로
                    build();
            studentRepository.save(student);
        }
        studentRepository.flush();
    }
}
