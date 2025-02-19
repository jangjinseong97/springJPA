package org.example.springjpa.student;

import org.example.springjpa.entity.Student;
import org.example.springjpa.student.model.StudentDto;
import org.example.springjpa.student.model.StudentRes;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT new org.example.springjpa.student.model.StudentDto(s.studentId, s.name, s.createdAt) " +
            "FROM Student s")
    List<StudentDto> findList(Pageable pageable);
}
