package com.example.demo.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.service.RestService;

@RestController
public class UserRestController {

    @Autowired
    RestService service;

    /**
     * ユーザ全件取得用処理
     */
    @GetMapping("/rest/get")
    public List<User> getUserMany() {
        // ユーザ全件取得
        return service.selectMany();
    }

    /**
     * ユーザ1件取得用処理
     */
    @GetMapping("/rest/get/{id:.+}")
    public User getUserOne(@PathVariable("id") String userId) {
        // ユーザ1件取得
        return service.selectOne(userId);
    }


}
