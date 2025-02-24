package org.example.springjpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springjpa.config.relationenum.EnumMapper;
import org.example.springjpa.config.relationenum.EnumMapperValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("common")
public class CommonController {
    private final EnumMapper enumMapper;
    @GetMapping("code")
    public List<EnumMapperValue> GetCodeList(@RequestParam("code_type") String codeType){
        return enumMapper.get(codeType);
    }
}
