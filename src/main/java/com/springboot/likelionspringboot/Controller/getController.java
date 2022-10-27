package com.springboot.likelionspringboot.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class getController {
    @RequestMapping("/request")
    public String getVariable(@RequestParam Map<String, String> param) {
        param.entrySet().forEach((map) -> {
            System.out.printf("key:%s value:%s",map.getKey(),map.getValue());
        });
        return "request가 호출 완료되었습니다.";
    }
}
