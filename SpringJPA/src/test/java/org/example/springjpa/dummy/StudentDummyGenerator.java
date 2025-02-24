package org.example.springjpa.dummy;

import net.datafaker.Faker;
import org.example.springjpa.School.SchoolRepository;
import org.example.springjpa.entity.School;
import org.example.springjpa.entity.SchoolTypeCode;
import org.example.springjpa.entity.Student;
import org.example.springjpa.entity.StudentGradeType;
import org.example.springjpa.student.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Locale;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentDummyGenerator {
    @Autowired private StudentRepository studentRepository;
    @Autowired private SchoolRepository schoolRepository;

    Faker faker = new Faker(new Locale("ko"));

    RandomEnumGenerator<StudentGradeType> studentGradeTypeCodeGenerator = new RandomEnumGenerator<>(StudentGradeType.class);

    @Test
    @Rollback(false)
    void generate(){
        int needForCount = 1000;
        studentRepository.deleteAll(); // 기존 데이터들 삭제
        List<School> schoolList = schoolRepository.findAll();
        if(schoolList.size()==0){return;}

        for(int i=0;i<needForCount;i++){

            StringBuilder sb = new StringBuilder(faker.name().lastName());
            sb.append(faker.name().firstName());
            Student student = Student.builder().
                    name(sb.toString()).
                    school(schoolList.get((int)(Math.random()*schoolList.size()))).
                    gradeTypeCode(studentGradeTypeCodeGenerator.getRandomEnum()).
        // faker.random().nextInt(schoolList.size()); schoolList.size() -1개 만큼의 랜덤 숫자 생성 이거써도 됨
//                    name(faker.name().fullName()).
                    // 다 좋은데 성씨 이후 띄어쓰기가 들어감 장 진성 이런식으로
                    build();
            studentRepository.save(student);
        }
        studentRepository.flush();
    }
}
