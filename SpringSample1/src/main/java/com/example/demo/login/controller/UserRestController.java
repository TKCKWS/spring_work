package com.example.demo.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    /**
     * ユーザ1件登録用処理
     */
    @PostMapping("/rest/insert")
    public String postUserOne(@RequestBody User user) {

        // ユーザーを1件登録
        boolean result = service.insert(user);

        String str = "";

        if (result == true) {
            str = "{\"result\":\"ok\"}";
        } else {
            str = "{\"result\":\"error\"}";
        }

        // 結果用の文字列をリターン
        return str;
    }

    /**
     * ユーザ1件更新用処理
     */
    @PutMapping("/rest/update")
    public String putUserOne(@RequestBody User user) {

        // ユーザーを1件登録
        boolean result = service.update(user);

        String str = "";

        if (result == true) {
            str = "{\"result\":\"ok\"}";
        } else {
            str = "{\"result\":\"error\"}";
        }

        // 結果用の文字列をリターン
        return str;
    }

    /**
     * ユーザ1件削除用処理
     */
    @DeleteMapping("/rest/delete/{id:.+}")
    public String DeleteUserOne(@PathVariable("id") String userId) {

        // ユーザーを1件登録
        boolean result = service.delete(userId);

        String str = "";

        if (result == true) {
            str = "{\"result\":\"ok\"}";
        } else {
            str = "{\"result\":\"error\"}";
        }

        // 結果用の文字列をリターン
        return str;
    }
}
