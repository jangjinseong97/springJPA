package org.example.springjpa.student;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.example.springjpa.student.model.StudentDto;
import org.example.springjpa.student.model.StudentRes;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;
    List<StudentRes> getList(Pageable pageable) {
        List<StudentDto> res = studentRepository.findList(pageable);
        List<StudentRes> res2 = new ArrayList<>(res.size());
        for(StudentDto r : res) {
            String a = String.valueOf(r.getStudentId());
            Long b = Long.valueOf(a.substring(7, a.length()));
            Long c = Long.valueOf(a.substring(0,7));
            StudentRes sr = new StudentRes(b,c,r.getName(),r.getCreatedAt());
            res2.add(sr);
        }
        return res2;
    }
    List<StudentDto> getListIdToString(Pageable pageable) {
        return studentRepository.findList(pageable);
    }
}
