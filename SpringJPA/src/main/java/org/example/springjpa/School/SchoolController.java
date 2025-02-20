package org.example.springjpa.School;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springjpa.School.model.SchoolGetRes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("school")
@Slf4j
public class SchoolController {

    private final SchoolService schoolservice;
    @GetMapping
    public List<SchoolGetRes> getSchool() {
        return schoolservice.getSchool();
    }
}
