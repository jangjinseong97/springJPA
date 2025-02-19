package org.example.springjpa.student;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springjpa.student.model.StudentRes;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;
    @GetMapping
    List<StudentRes> getList(@RequestParam int page, @RequestParam int size) {
        return studentService.getList(PageRequest.of(page, size));
    }
}
