package org.example.springjpa.entity;

import jakarta.transaction.Transactional;
import org.example.springjpa.student.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.beans.Transient;

import static org.junit.jupiter.api.Assertions.*;

//JPA 테스트
    @DataJpaTest
    @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// db는 바꾸지 않음
class StudentTest {
    @Autowired //TDD 에선 이 에노테이션으로만 받아야됨
    private StudentRepository studentRepository;

    @Test
    @Transactional
    public void createStudent(){
        for(int i=0; i<100; i++){
            Student student = Student.builder().
                    name(String.format("홍길동%03d",i)).
                    build();
            studentRepository.save(student);
        }
        studentRepository.flush();
    }

    @Test
    @Rollback(false)
    public void insertStudent(){
        School school = School.builder()
                .schoolId(680592768985023227L)
                .build();

        Student student = Student.builder()
                .gradeTypeCode(StudentGradeType.GRADE_2)
                .name("testIS2")
                .school(school)
                .build();
        studentRepository.save(student);
    }
}