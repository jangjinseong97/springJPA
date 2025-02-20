package org.example.springjpa.School;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springjpa.School.model.SchoolGetRes;
import org.example.springjpa.entity.School;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SchoolService {
    private final SchoolRepository schoolRepository;
    public List<SchoolGetRes> getSchool(){
        List<School> schools = schoolRepository.findAll();
        return schools.stream() // schools로 스트림 생성
                .map(item -> new SchoolGetRes(item.getSchoolId(), item.getName(), item.getSchoolTypeCode())) // 같은 크기의 다른 스트림을 생성
                // 여기서 schools 를 사용하여 SchoolGetRes 객체를 생성
                .toList(); // 만들어진걸 리스트로 변환
    }
}
