package com.springboot.likelionspringboot.Controller;

import com.springboot.likelionspringboot.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
    @RequestMapping("/request")
    public String getVariable(@RequestParam Map<String, String> param) {
        param.entrySet().forEach((map) -> {
            System.out.printf("key:%s value:%s",map.getKey(),map.getValue());
        });
        return "request가 호출 완료되었습니다.";

    }
    @GetMapping("/request1")
    public String getRequestParam(MemberDto memberDto){
        return memberDto.toString();
    }
}
