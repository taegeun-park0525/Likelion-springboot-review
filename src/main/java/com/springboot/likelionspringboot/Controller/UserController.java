package com.springboot.likelionspringboot.Controller;

import com.springboot.likelionspringboot.dao.UserDao;
import com.springboot.likelionspringboot.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping("/user-add")
    public ResponseEntity<String> addUser(User user) {
        log.info("user-add로 요청이 들어왔습니다.");
        userDao.addUser(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(user.toString() + "생성 되었습니다.");
    }

    @DeleteMapping("/user-delete")
    public ResponseEntity<String> deleteUser(String id) {
        log.info("user-delete로 요청이 들어왔습니다.");
        userDao.deleteUser(id);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("id : " + id + "의 user가 삭제되었습니다.");
    }

    @DeleteMapping("/user-deleteAll")
    public ResponseEntity<String> deleteAll() {
        log.info("user-deleteAll로 요청이 들어왔습니다.");
        userDao.deleteAll();
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("모든 데이터가 삭제되었습니다.");
    }

}
