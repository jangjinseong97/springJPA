package org.example.springjpa.School;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springjpa.School.model.SchoolGetRes;
import org.example.springjpa.School.model.SchoolPostReq;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public String save(@RequestBody SchoolPostReq req){
        log.info("req: {}",req);
        schoolservice.save(req);
        return "등록 완료";
    }
}
