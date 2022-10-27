package com.springboot.likelionspringboot.Controller;

import com.springboot.likelionspringboot.domain.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "Hello Post API";
    }

    @PostMapping("/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();
    /* Builder Pattern
         StringBuilder란?
         자바에서 String은 변경 불가능한 문자열이지만, StringBuilder를 통해
         .append :  연결과 같이 문자열을 편집할 수 있다.
          */

        postData.entrySet().forEach(map -> sb.append(map.getKey() + ":" + map.getValue() + "\n"));
        return sb.toString();
    }
//@RequestParam("가져올데이터의 이름")[데이터타입][가져온데이터를 담을 변수]
    @PostMapping("/member2")
    public ResponseEntity<MemberDto> postMember(MemberDto memberDto) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(memberDto);
    }
}
