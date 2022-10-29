package com.springboot.likelionspringboot.Controller;

import com.springboot.likelionspringboot.domain.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/put-api")
@Slf4j
public class PutController {

    @PutMapping(value = "/member1")
    public String putMemberDto1( MemberDto memberDto) {
        log.info("PutController : member1으로 요청이 들어왔습니다.");
        return memberDto.toString();
    }

    @PutMapping(value = "/member2")
    public MemberDto putMemberDto2( MemberDto memberDto) {
        return memberDto;
    }

    @PutMapping("/member3")
    public ResponseEntity<MemberDto> putMemberDto3(MemberDto memberDto) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(memberDto);
    }
}
