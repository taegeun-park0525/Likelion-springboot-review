package com.springboot.likelionspringboot.dao;

import com.springboot.likelionspringboot.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //이렇게 해놓으면 springBoot가 Factory를 구성해서 DI를 해줌 final 필수!

    public void addUser(User user) {
        this.jdbcTemplate.update("insert into users(id,name,password) values (?,?,?)",
                user.getId(),user.getName(),user.getPassword());
    }

    public void deleteUser(String id) {
        this.jdbcTemplate.update("delete from users where id=?", id);
    }

    public void deleteAll(){
        this.jdbcTemplate.update("delete from users;");
    }

}
